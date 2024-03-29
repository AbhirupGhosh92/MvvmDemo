package com.happy.krutarthassignment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.ListFragment
import com.happy.krutarthassignment.fragment.FavouriteFragment
import com.happy.krutarthassignment.fragment.MainListFragment

class CustomViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager,
    FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val nums = arrayListOf("Main","Favourites")


    override fun getItem(position: Int): Fragment {
        var fragment : Fragment? = null

        if(position == 0)
        {
            fragment = MainListFragment()
        }
        else
        {
            fragment = FavouriteFragment()

        }

        return fragment
    }

    override fun getCount(): Int {
        return nums.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return nums[position]
    }
}