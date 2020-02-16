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

class RecyclerViewAdapterTower(private val mImages: ArrayList<Int>,
                               private val mNames: ArrayList<String>,
                               private val mInfo: ArrayList<Int>,
                               private val mAddress: ArrayList<String>,
                               private val mNumbers:ArrayList<String>): RecyclerView.Adapter<RecyclerViewAdapterTower.ViewHolderTower>() {

    class ViewHolderTower(itemView: View) : RecyclerViewAdapter.ViewHolder(itemView)
    {
        val imageViewT=itemView.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.imageViewTower)
        val mNameT=itemView.findViewById<TextView>(R.id.text_view_name_tower)
        val mLayoutT=itemView.findViewById<RelativeLayout>(R.id.list_items_layout_tower)
        val mContextT= itemView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTower {
        return ViewHolderTower(
            LayoutInflater.from(parent.context).inflate(R.layout.list_items_tower,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return mNames.size
    }

    override fun onBindViewHolder(holder: ViewHolderTower, position: Int) {

        holder.imageViewT.setImageResource(mImages[position])
        holder.mNameT.text = mNames[position]

        holder.mLayoutT.setOnClickListener {
            val tIntent = Intent(holder.mContextT, MoreInfoActivity::class.java).apply {
                putExtra("INFO",mInfo[position])
                putExtra("NAME",mNames[position])
                putExtra("IMAGE",mImages[position])
                putExtra("ADDRESS",mAddress[position])
                putExtra("NUMBER",mNumbers[position])
            }
            holder.mContextT.startActivity(tIntent)
        }
    }


}