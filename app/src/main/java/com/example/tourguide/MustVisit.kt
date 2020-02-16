package com.example.tourguide


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_must_visit.*

/**
 * A simple [Fragment] subclass.
 */
class MustVisit : Fragment() {

    private val mImages:ArrayList<Int> = ArrayList()
    private val mNames:ArrayList<String> = ArrayList()
    private val mInfo:ArrayList<Int> = ArrayList()
    private val mAdress:ArrayList<String> = ArrayList()
    private val mNumber:ArrayList<String> = ArrayList()
    private var do_list:Boolean= true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_must_visit, container, false)
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init_data()
    }*/

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if(do_list){
            init_data()
            do_list=false
        }
        init_recyclerView()
    }

    private fun init_data()
    {
        mImages.add(R.drawable.artinst)
        mNames.add("Art Institute of Chicago")
        mInfo.add(R.string.info_art_institute)
        mAdress.add("111 South Michigan Avenue, Chicago Loop, Chicago, Illinois, 60603, USA")
        mNumber.add("+13124433600")

        mImages.add(R.drawable.mus_science)
        mNames.add("Museum of Science and Industry")
        mInfo.add(R.string.info_mus_science)
        mAdress.add("5700 South Lake Shore Drive, Jackson Park, Chicago, Illinois, 60637, USA")
        mNumber.add("+17736841414")

        mImages.add(R.drawable.shedd)
        mNames.add("Shedd Aquarium")
        mInfo.add(R.string.info_shedd)
        mAdress.add("1200 South Lake Shore Drive, Near South Side, Chicago, Illinois, 60605, USA")
        mNumber.add("+13129392438")

        mImages.add(R.drawable.zoo)
        mNames.add("Lincoln Park Zoo")
        mInfo.add(R.string.info_zoo)
        mAdress.add("2204 N. Cannon Drive, Chicago, Illinois, United States")
        mNumber.add("+13127422000")
    }

    private fun init_recyclerView()
    {
        recylerViewMustVisit.layoutManager=LinearLayoutManager(this.context)
        recylerViewMustVisit.adapter=
            RecyclerViewAdapter(
                mImages,
                mNames,
                mInfo,
                mAdress,
                mNumber
            )
    }
}
