package com.example.tourguide


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_must_visit.*

/**
 * A simple [Fragment] subclass.
 */
class Restaurants : Fragment() {

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
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

}
