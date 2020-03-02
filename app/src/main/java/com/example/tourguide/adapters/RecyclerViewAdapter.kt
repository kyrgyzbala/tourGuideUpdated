package com.example.tourguide.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tourguide.MoreInfoActivity
import com.example.tourguide.R
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerViewAdapter(
    private val mImages: ArrayList<Int>,
    private val mNames: ArrayList<String>,
    private val mInfo: ArrayList<Int>,
    private val mAddress: ArrayList<String>,
    private val mNumbers: ArrayList<String>
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView =
            itemView.findViewById<CircleImageView>(R.id.imageView)
        val mName = itemView.findViewById<TextView>(R.id.text_view_name)
        val mLayout = itemView.findViewById<RelativeLayout>(R.id.list_items_layout)
        val mContext = itemView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_items,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mNames.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.mContext).load(mImages[position]).into(holder.imageView)
        holder.mName.text = mNames[position]

        holder.mLayout.setOnClickListener {
            val intent = Intent(
                holder.mContext,
                MoreInfoActivity::class.java
            ).apply {
                putExtra("INFO", mInfo[position])
                putExtra("NAME", mNames[position])
                putExtra("IMAGE", mImages[position])
                putExtra("ADDRESS", mAddress[position])
                putExtra("NUMBER", mNumbers[position])
            }
            holder.mContext.startActivity(intent)
        }
    }

}