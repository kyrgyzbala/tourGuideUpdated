package com.example.tourguide

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoreInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        val imageView =findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.imageView2)
        val infoText:TextView = findViewById(R.id.more_info_text)
        val nameText:TextView = findViewById(R.id.more_info_name)
        val addressText:TextView = findViewById(R.id.more_info_address)
        val numberTextView:TextView = findViewById(R.id.more_info_phone)

        val mInfo = intent.getIntExtra("INFO",R.string.def_text)
        val mImage = intent.getIntExtra("IMAGE",R.drawable.shedd)
        val mName = intent.getStringExtra("NAME")
        val mAddress = intent.getStringExtra("ADDRESS")
        val mNumber = intent.getStringExtra("NUMBER")

        infoText.text = getString(mInfo)
        nameText.text = mName
        imageView.setImageResource(mImage)
        addressText.text = mAddress
        numberTextView.text = mNumber

        addressText.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        numberTextView.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        addressText.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW)
            mapIntent.data = Uri.parse("geo:0,0?q=$mAddress")

            val title = resources.getString(R.string.title_choose)
            val chooser = Intent.createChooser(mapIntent,title)

            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
        }

        numberTextView.setOnClickListener {
            val callIntent: Intent = Uri.parse("tel:$mNumber").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(callIntent)
        }
    }
}
