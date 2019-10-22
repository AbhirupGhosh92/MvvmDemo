package com.happy.krutarthassignment.activity.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.happy.krutarthassignment.R
import com.happy.krutarthassignment.databinding.TabFragmentBinding

class TabFragment: Fragment() , View.OnClickListener  {

    internal lateinit var view: View
    internal lateinit var mContext: Context
    private var tabFragmentBinding: TabFragmentBinding?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tabFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.tab_fragment, container, false)
        tabFragmentBinding!!.executePendingBindings()
        view = tabFragmentBinding!!.root

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