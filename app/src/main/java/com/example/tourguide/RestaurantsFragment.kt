package com.example.tourguide


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourguide.adapters.RecyclerViewAdapterRest

/**
 * A simple [Fragment] subclass.
 */
class RestaurantsFragment : Fragment() {

    private val mImages:ArrayList<Int> = ArrayList()
    private val mNames:ArrayList<String> = ArrayList()
    private val mInfo:ArrayList<Int> = ArrayList()
    private val mAdress:ArrayList<String> = ArrayList()
    private val mNumber:ArrayList<String> = ArrayList()
    private var doList:Boolean= true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rView = inflater.inflate(R.layout.fragment_restaurants, container, false)

        val rRecyclerView = rView.findViewById<RecyclerView>(R.id.recylerViewRest)

        if(doList){
            initData()
            doList = false
        }

        rRecyclerView.layoutManager = LinearLayoutManager(rView.context)
        rRecyclerView.adapter = RecyclerViewAdapterRest(mImages,mNames,mInfo,mAdress,mNumber)
        return rView
    }

    private fun initData()
    {
        mImages.add(R.drawable.euroo)
        mNames.add("EuroAsia Restaurant")
        mInfo.add(R.string.euroasia)
        mAdress.add("351 W Oak St, Chicago, IL 60610, United States")
        mNumber.add("+13129880662")

        mImages.add(R.drawable.tortazo)
        mNames.add("Tortazo Chicago")
        mInfo.add(R.string.tortazo)
        mAdress.add("233 S. Wacker Drive, Unit L1-11 & L1-12, Chicago, IL 60606")
        mNumber.add("+13129627700")

        mImages.add(R.drawable.lula)
        mNames.add("Lula Cafe")
        mInfo.add(R.string.lula)
        mAdress.add("2537 N Kedzie Blvd, Chicago, IL 60647, United States")
        mNumber.add("+17734899554")

        mImages.add(R.drawable.bellemore)
        mNames.add("Bellemore")
        mInfo.add(R.string.bellemore)
        mAdress.add("564 W Randolph St, Chicago, IL 60661, United States")
        mNumber.add("+13126670104")

    }

}
