package com.galal.seenapay.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.galal.seenapay.R
import com.galal.seenapay.databinding.FragmentHomeBinding
import com.galal.seenapay.model.Recipe
import com.galal.seenapay.ui.home.adapter.RecipeAdapter
import com.galal.seenapay.ui.home.viewModel.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    val recipeList = listOf(
        Recipe(
            R.drawable.pizza,
            "Scrambled Egg",
           "4.9 | 5k Reviews",
            "Gordon Ramsay"
        ),
        Recipe(R.drawable.crip,
            "Grilled Cheese Sandwich",
            "4.9 | 4k Reviews",
            "Alain Ducasse"
        ),
        Recipe(R.drawable.pasta,
            "Pasta with Garlic",
            "4.8 | 3.5k Reviews",
            "Yannick Alléno"
        )
    )

    val egyptianFoodList = listOf(
        Recipe(R.drawable.nasi,
            "Nasi Goreng Rendang",
            "5 | 7k Review", "William Wongso"),
        Recipe(R.drawable.coto,
            "Coto Makassar",
            "4.9 | 1k Reviews", "Arnold Poernomo"),
        Recipe(R.drawable.ayam,
            "Ayam Betutu", "4.8 | 3.5k Reviews",
           "Juna Rorimpandey"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        homeViewModel.setText(getString(R.string.hello_seena_pay))


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.recipeRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = RecipeAdapter(recipeList)
        }
        binding.egyptianFoodRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = RecipeAdapter(egyptianFoodList)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}