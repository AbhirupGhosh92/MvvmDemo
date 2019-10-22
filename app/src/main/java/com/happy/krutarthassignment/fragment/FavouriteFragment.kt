package com.happy.krutarthassignment.fragment

import android.content.Context
import android.os.Bundle
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
import com.happy.krutarthassignment.models.ResponseModel
import com.happy.krutarthassignment.viewmodels.SharedViewModel

class FavouriteFragment: Fragment(), View.OnClickListener {

    private var favouriteFragmentBinding:FavouriteFragmentBinding?=null
    internal lateinit var view: View
    internal lateinit var mContext: Context
    private lateinit var sharedViewModel: SharedViewModel
    private var adapter : CustomListAdapter?= null
    private var userList = ArrayList<ResponseModel>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        favouriteFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.favourite_fragment, container, false)
        favouriteFragmentBinding?.executePendingBindings()
        sharedViewModel = ViewModelProviders.of(requireActivity())[SharedViewModel::class.java]
        return favouriteFragmentBinding?.root
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
                    userList.addAll(it.filter {
                        it.favourite
                    })
                    adapter = CustomListAdapter(requireContext(),userList)
                    {
                        fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer,
                            MapFragment().apply {
                                arguments = Bundle().apply {
                                    putSerializable("data",it)
                                }
                            }
                        )?.addToBackStack(null)
                            ?.commit()
                    }
                    favouriteFragmentBinding?.rlFav?.adapter = adapter
                    favouriteFragmentBinding?.rlFav?.layoutManager = LinearLayoutManager(requireContext())
                    favouriteFragmentBinding?.rlFav?.itemAnimator = DefaultItemAnimator()
                    adapter?.notifyDataSetChanged()
                }
                else
                {
                    userList.clear()
                    userList.addAll(it.filter {
                        it.favourite
                    })
                    adapter?.notifyDataSetChanged()
                }
            }
        })
    }
}