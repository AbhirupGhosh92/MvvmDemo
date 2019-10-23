package com.happy.krutarthassignment.activity

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.happy.krutarthassignment.R
import com.happy.krutarthassignment.SplashScreen
import com.happy.krutarthassignment.fragment.TabFragment
import com.happy.krutarthassignment.databinding.ActivityMainBinding

class DashboardActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding?=null
    var fragmentManager: FragmentManager?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        init()
    }

    private fun init()
    {
        fragmentManager =supportFragmentManager
        fragmentManager?.beginTransaction()?.add(R.id.fragmentContainer,
            SplashScreen()
        )?.addToBackStack(null)
            ?.commit()
    }
}
