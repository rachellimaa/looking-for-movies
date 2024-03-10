package com.rachellima.lookingmovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.apply {
            setupWithNavController(navController)
            setOnClickListener { item ->
                when(item.id) {
                    R.id.nav_list_movies -> findNavController().navigate(R.id.listMoviesToFavorites)
                    R.id.nav_favorite_list -> findNavController().navigate(R.id.favoritesToListMovies)
                    else -> findNavController().navigate(R.id.favoritesToListMovies)
                }
            }
        }
    }
}