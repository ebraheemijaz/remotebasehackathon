package com.hackathon.remotebase.challengeswvl.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hackathon.remotebase.challengeswvl.R
import com.hackathon.remotebase.challengeswvl.databinding.ActivitySwvlBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var activityMainBinding: ActivitySwvlBinding? = null

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivitySwvlBinding.inflate(layoutInflater)

        setContentView(activityMainBinding?.root)

        Log.d("MainActivity", "onViewCreated: ")

        navController = Navigation.findNavController(this, R.id.fragmentContainerView)
//
//        bottom_nav.setupWithNavController(navController)

//        NavigationUI.setupActionBarWithNavController(this, navController)

    }
}