package com.galal.seenapay.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.galal.seenapay.R
import com.galal.seenapay.databinding.ActivityMainBinding
import com.galal.seenapay.ui.compass.view.CompassFragment
import com.galal.seenapay.ui.home.view.HomeFragment
import com.galal.seenapay.ui.invoice.view.InvoiceFragment
import com.galal.seenapay.ui.profile.view.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentFragmentTag: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment(), getString(R.string.homefragment))
                    true
                }
                R.id.compass -> {
                    replaceFragment(CompassFragment(), getString(R.string.compassfragment))
                    true
                }
                R.id.invoice -> {
                    replaceFragment(InvoiceFragment(), getString(R.string.invoicefragment))
                    true
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment(), getString(R.string.profilefragment))
                    true
                }
                else -> false
            }
        }
        replaceFragment(HomeFragment(), getString(R.string.homefragment))
    }
    private fun replaceFragment(fragment:Fragment, tag: String){
        if(tag !=  currentFragmentTag){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
            currentFragmentTag = tag
        }
    }
}