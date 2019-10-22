package com.happy.krutarthassignment.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.happy.krutarthassignment.R
import com.happy.krutarthassignment.adapters.CustomViewPagerAdapter
import com.happy.krutarthassignment.databinding.TabFragmentBinding
import com.happy.krutarthassignment.viewmodels.SharedViewModel

class TabFragment: Fragment() , View.OnClickListener  {
    override fun onClick(p0: View?) {

    }

    internal lateinit var view: View
    internal lateinit var mContext: Context
    private var tabFragmentBinding: TabFragmentBinding?=null
    private lateinit var viewmodel : SharedViewModel
    private var viewPagerAdapter : CustomViewPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tabFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.tab_fragment, container, false)
        tabFragmentBinding?.executePendingBindings()
        viewmodel = ViewModelProviders.of(requireActivity())[SharedViewModel::class.java]
        return tabFragmentBinding?.root
    }

    override fun onStart() {
        super.onStart()

        setUpViewPager()

    }

    override fun onResume() {
        super.onResume()

        setUpViewPager()
    }

   private fun setUpViewPager()
   {

       if(viewPagerAdapter == null)
       {
           viewPagerAdapter = CustomViewPagerAdapter(fragmentManager!!)
           tabFragmentBinding?.vpMain?.adapter = viewPagerAdapter
           tabFragmentBinding?.tlMain?.setupWithViewPager( tabFragmentBinding?.vpMain)
       }
       else
       {
           viewPagerAdapter?.notifyDataSetChanged()
       }

   }


}