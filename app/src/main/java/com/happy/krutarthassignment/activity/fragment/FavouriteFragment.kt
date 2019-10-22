package com.happy.krutarthassignment.activity.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.happy.krutarthassignment.R
import com.happy.krutarthassignment.databinding.FavouriteFragmentBinding

class FavouriteFragment: Fragment(), View.OnClickListener {

    private var favouriteFragmentBinding:FavouriteFragmentBinding?=null
    internal lateinit var view: View
    internal lateinit var mContext: Context



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        favouriteFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.favourite_fragment, container, false)
        favouriteFragmentBinding!!.executePendingBindings()
        view = favouriteFragmentBinding!!.root

        init()

        return view
    }
    fun init(){
        initViews()
        initListeners()
    }

    fun initViews(){
    }

    fun initListeners(){

    }

    override fun onClick(p0: View?) {
    }
}