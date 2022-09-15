package dev.lizarraga.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dev.lizarraga.bottomnavigation.databinding.ActivityMainBinding
import dev.lizarraga.bottomnavigation.fragments.FavoriteFragment
import dev.lizarraga.bottomnavigation.fragments.HomeFragment
import dev.lizarraga.bottomnavigation.fragments.ListFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var homeFragment: HomeFragment
    lateinit var listFragment: ListFragment
    lateinit var favoriteFragment: FavoriteFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeFragment = HomeFragment()
        listFragment = ListFragment()
        favoriteFragment = FavoriteFragment()

        showFragment(homeFragment)

        binding.bnvMenu.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menuHome -> showFragment(homeFragment)
                R.id.menuList -> showFragment(listFragment)
                R.id.menuFavorite -> showFragment(favoriteFragment)
            }
            return@setOnItemSelectedListener true
        }
    }

    fun showFragment(frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameContent, frag).commit()
    }

}








