package com.happy.krutarthassignment.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.happy.krutarthassignment.R
import com.happy.krutarthassignment.databinding.ListFragmentBinding
import com.happy.krutarthassignment.databinding.TabFragmentBinding

class ListFragment: Fragment() , View.OnClickListener  {

    internal lateinit var view: View
    internal lateinit var mContext: Context
    private var listFragmentBinding: ListFragmentBinding?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        listFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.favourite_fragment, container, false)
        listFragmentBinding!!.executePendingBindings()
        view = listFragmentBinding!!.root

        init()
        return view
    }

    private fun init() {
        initViews()
        initListner()
    }

    private fun initViews() {
    }

    private fun initListner(){
    }

    override fun onClick(p0: View?) {
    }

}