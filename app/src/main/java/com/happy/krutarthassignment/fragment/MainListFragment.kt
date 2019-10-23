package com.happy.krutarthassignment.fragment

import android.content.Context
import android.os.Bundle
import android.os.SharedMemory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.happy.krutarthassignment.R
import com.happy.krutarthassignment.adapters.CustomListAdapter
import com.happy.krutarthassignment.databinding.FavouriteFragmentBinding
import com.happy.krutarthassignment.databinding.ListFragmentBinding
import com.happy.krutarthassignment.databinding.TabFragmentBinding
import com.happy.krutarthassignment.models.ResponseModel
import com.happy.krutarthassignment.repository.Repository
import com.happy.krutarthassignment.viewmodels.SharedViewModel

class MainListFragment: Fragment() , View.OnClickListener  {

    internal lateinit var view: View
    internal lateinit var mContext: Context
    private lateinit var listFragmentBinding: FavouriteFragmentBinding
    private lateinit var sharedViewModel: SharedViewModel
    private var adapter : CustomListAdapter?= null
    private var userList = ArrayList<ResponseModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        listFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.favourite_fragment, container, false)
        listFragmentBinding.executePendingBindings()

        sharedViewModel = ViewModelProviders.of(requireActivity())[SharedViewModel::class.java]
        return listFragmentBinding.root
    }

    override fun onClick(p0: View?) {


    }

    override fun onResume() {
        super.onResume()

        renderUi()
    }


    private fun renderUi()
    {
       sharedViewModel.getAllUsersFromCache(requireContext()).observe(viewLifecycleOwner, Observer {
           if(it.isNullOrEmpty())
           {
               sharedViewModel.initCacheFromServer(requireContext())
           }
           else
           {
               if(adapter == null)
               {
                   userList.addAll(it)
                   adapter = CustomListAdapter(requireContext(),userList){
                       sharedViewModel.snippet.invoke(it)
                   }
                   listFragmentBinding.rlFav.adapter = adapter
                   listFragmentBinding.rlFav.layoutManager = LinearLayoutManager(requireContext())
                   listFragmentBinding.rlFav.itemAnimator = DefaultItemAnimator()
                   adapter?.notifyDataSetChanged()
               }
               else
               {
                   userList.clear()
                   userList.addAll(it)
                   adapter?.notifyDataSetChanged()
               }
           }
       })
    }

}