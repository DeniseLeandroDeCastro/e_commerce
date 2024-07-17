package com.denise.castro.e_commerce.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denise.castro.e_commerce.R
import com.denise.castro.e_commerce.adapters.HomeViewPagerAdapter
import com.denise.castro.e_commerce.databinding.FragmentHomeBinding
import com.denise.castro.e_commerce.fragments.categories.AccessoryFragment
import com.denise.castro.e_commerce.fragments.categories.ChairFragment
import com.denise.castro.e_commerce.fragments.categories.CuppboardFragment
import com.denise.castro.e_commerce.fragments.categories.FurnitureFragment
import com.denise.castro.e_commerce.fragments.categories.MainCategoryFragment
import com.denise.castro.e_commerce.fragments.categories.TableFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            ChairFragment(),
            CuppboardFragment(),
            TableFragment(),
            AccessoryFragment(),
            FurnitureFragment()
        )

        val viewPager2Adapter = HomeViewPagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewPagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPagerHome) { tab, position ->
            when(position) {
                0 -> tab.text = "Início"
                1 -> tab.text = "Cadeiras"
                2 -> tab.text = "Guarda-roupas"
                3 -> tab.text = "Mesas"
                4 -> tab.text = "Acessórios"
                5 -> tab.text = "Móveis"
            }
        }.attach()
    }
}