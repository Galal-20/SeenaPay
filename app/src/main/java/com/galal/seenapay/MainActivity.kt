package com.galal.seenapay

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.galal.seenapay.databinding.ActivityMainBinding
import com.galal.seenapay.ui.compass.CompassFragment
import com.galal.seenapay.ui.home.HomeFragment
import com.galal.seenapay.ui.invoice.InvoiceFragment
import com.galal.seenapay.ui.profile.ProfileFragment

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
//                    findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id .navigation_home)
                    replaceFragment(HomeFragment(), getString(R.string.homefragment))
                    true
                }
                R.id.compass -> {
//                    findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id.compassFragment)
                    replaceFragment(CompassFragment(), getString(R.string.compassfragment))
                    true
                }
                R.id.invoice -> {
//                    findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id.invoiceFragment)
                    replaceFragment(InvoiceFragment(), getString(R.string.invoicefragment))
                    true
                }
                R.id.profile -> {
//                    findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id.profileFragment)
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