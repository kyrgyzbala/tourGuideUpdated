package com.example.tourguide.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tourguide.MoreInfoActivity
import com.example.tourguide.R

class RecyclerViewAdapterRest(
    private val mImages: ArrayList<Int>,
    private val mNames: ArrayList<String>,
    private val mInfo: ArrayList<Int>,
    private val mAddress: ArrayList<String>,
    private val mNumbers: ArrayList<String>
) : RecyclerView.Adapter<RecyclerViewAdapterRest.ViewHolderRest>() {

    class ViewHolderRest(itemView: View) : RecyclerViewAdapter.ViewHolder(itemView) {
        val imageViewR =
            itemView.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.imageViewRest)
        val mNameR = itemView.findViewById<TextView>(R.id.text_view_name_rest)
        val mLayoutR = itemView.findViewById<RelativeLayout>(R.id.list_items_layout_rest)
        val mContextR = itemView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRest {
        return ViewHolderRest(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_items_rest,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mNames.size
    }

    override fun onBindViewHolder(holder: ViewHolderRest, position: Int) {
        holder.imageViewR.setImageResource(mImages[position])
        holder.mNameR.text = mNames[position]

        holder.mLayoutR.setOnClickListener {
            val tIntent = Intent(holder.mContextR, MoreInfoActivity::class.java).apply {
                putExtra("INFO", mInfo[position])
                putExtra("NAME", mNames[position])
                putExtra("IMAGE", mImages[position])
                putExtra("ADDRESS", mAddress[position])
                putExtra("NUMBER", mNumbers[position])
            }
            holder.mContextR.startActivity(tIntent)
        }
    }


}