package com.example.tourguide


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourguide.adapters.RecyclerViewAdapterTower

/**
 * A simple [Fragment] subclass.
 */
class TowersFragment : Fragment() {

    private val mImages: ArrayList<Int> = ArrayList()
    private val mNames: ArrayList<String> = ArrayList()
    private val mInfo: ArrayList<Int> = ArrayList()
    private val mAddress: ArrayList<String> = ArrayList()
    private val mNumber: ArrayList<String> = ArrayList()
    private var doList: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val tView = inflater.inflate(R.layout.fragment_towers, container, false)

        val tRecyclerView = tView.findViewById<RecyclerView>(R.id.recylerViewTower)

        if (doList) {
            initData()
            doList = false
        }

        tRecyclerView.layoutManager = LinearLayoutManager(this.context)
        tRecyclerView.adapter =
            RecyclerViewAdapterTower(
                mImages,
                mNames,
                mInfo,
                mAddress,
                mNumber
            )

        return tView
    }

    private fun initData() {
        mImages.add(R.drawable.skydeck)
        mNames.add("Skydeck at Willis Tower")
        mInfo.add(R.string.info_skydeck)
        mAddress.add("233 South Wacker Drive, Chicago Loop, Chicago, Illinois, 60606, USA")
        mNumber.add("+13128759696")

        mImages.add(R.drawable.trump)
        mNames.add("Trump Tower Chicago")
        mInfo.add(R.string.info_trump)
        mAddress.add("401 N. Wabash Ave, Chicago, Illinois, United States")
        mNumber.add("+13125888000")

        mImages.add(R.drawable.john)
        mNames.add("John Hancock Tower Chicago")
        mInfo.add(R.string.info_john)
        mAddress.add("875 N Michigan Ave, Chicago, IL 60611, United States")
        mNumber.add("+18003951113 ")

        mImages.add(R.drawable.tribune)
        mNames.add("Tribune Tower Chicago")
        mInfo.add(R.string.info_tribune)
        mAddress.add("435 Michigan Ave, Chicago, IL 60611, United States")
        mNumber.add("+13122223994")
    }

}
