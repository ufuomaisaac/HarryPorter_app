package com.example.menu_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.menu_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCurrentFragment(HomeFragment())

        binding.bottonNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.hcharacters -> setCurrentFragment(HomeFragment())
                R.id.books -> setCurrentFragment(ProfileFragment())
                R.id.hogwarts -> setCurrentFragment(MessageFragment())
            }
            true
        }

    }
    private fun setCurrentFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment , fragment)
            commit()
        }
    }
}