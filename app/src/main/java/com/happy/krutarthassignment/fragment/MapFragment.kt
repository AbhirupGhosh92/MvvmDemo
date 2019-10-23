package com.happy.krutarthassignment.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.happy.krutarthassignment.R
import com.happy.krutarthassignment.databinding.FragmentMapBinding
import com.happy.krutarthassignment.models.ResponseModel

/**
 * A simple [Fragment] subclass.
 */
class MapFragment : Fragment() {

    private lateinit var dataBinding : FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_map,container,false)
        return dataBinding.root
    }

    override fun onResume() {
        super.onResume()

        var data = arguments?.getSerializable("data") as ResponseModel

        dataBinding.txtData.text = data.toString()
    }


}
