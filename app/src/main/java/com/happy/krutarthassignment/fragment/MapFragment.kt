package com.happy.krutarthassignment.fragment


import android.os.Bundle
import android.text.SpannableString
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
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
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_map,container,false)
        return dataBinding.root
    }

    override fun onResume() {
        super.onResume()

        val data = arguments?.getSerializable("data") as ResponseModel

        val latLng = LatLng(data.address?.geo?.lat?.toDouble()!!, data.address.geo.lng?.toDouble()!!)

        val cameraPosition = CameraPosition.builder()
            .target(latLng)
            .zoom(5f)
            .bearing(0f)
            .tilt(45f)
            .build()



        val mapFragment  : SupportMapFragment = childFragmentManager.findFragmentById(com.happy.krutarthassignment.R.id.my_map_fragment) as SupportMapFragment
        mapFragment.getMapAsync{

            it.addMarker(MarkerOptions().apply {
                position(latLng)
                title(data.name)
            })

            it.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

        }

        dataBinding.txtData.text = SpannableString(

            " Name :- ${data.name}   Address:- ${data.address?.suite} ${data.address?.street} ${data.address?.city} ${data.address?.zipcode}\n" +
                    "email :- ${data.email}    company :-  ${data.company?.name}\n" +
                    "phone:- ${data.phone}    website:-  ${data.website}").toString()
    }


}
