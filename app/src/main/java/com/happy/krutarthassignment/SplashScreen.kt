package com.happy.krutarthassignment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.happy.krutarthassignment.activity.DashboardActivity
import com.happy.krutarthassignment.databinding.SplashScreenBinding
import com.happy.krutarthassignment.fragment.TabFragment
import kotlinx.android.synthetic.main.splash_screen.*

class SplashScreen : Fragment() {
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000 //3 seconds
    private var binding: SplashScreenBinding? = null


    private val mRunnable: Runnable = Runnable {


           fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer,TabFragment())?.commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.splash_screen,container,false)
        startAnimation()

        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

        return binding?.root
    }

    private fun startAnimation() {


        var visible = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)


        visible.reset()
        visible.setFillAfter(true)


        binding?.screen?.clearAnimation()
        binding?.screen?.startAnimation(visible)

    }

    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }

}