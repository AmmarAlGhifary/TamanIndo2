package com.blogspot.yourfavoritekaisar.tamanindo2

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.blogspot.yourfavoritekaisar.tamanindo2.ui.home.HomeFragment
import com.blogspot.yourfavoritekaisar.tamanindo2.ui.layanan.LayananFragment
import com.blogspot.yourfavoritekaisar.tamanindo2.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val layananFragment = LayananFragment()
    private val profileFragment = ProfileFragment()

    private val fragmentManager = supportFragmentManager
    private var activeFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager.beginTransaction().apply {
            add(R.id.container, homeFragment, getString(R.string.title_home)).hide(homeFragment)
            add(R.id.container, layananFragment, getString(R.string.title_layanan)).hide(layananFragment)
            add(R.id.container, profileFragment, getString(R.string.title_profile))
        }.commit()
        initListeners()
        bottomNavigationView.itemIconTintList
    }

    private fun initListeners() {
        bottomNavigationView.setOnNavigationItemReselectedListener { menuItem ->
            when (menuItem.itemId){
                R.id.navigation_home -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
                    activeFragment = homeFragment
                    true
                }
                R.id.navigation_layanan -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(layananFragment).commit()
                    activeFragment = layananFragment
                    true
                }
                R.id.navigation_profile -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(profileFragment).commit()
                    activeFragment = profileFragment
                    true
                }

                else -> false
            }
        }
    }
}