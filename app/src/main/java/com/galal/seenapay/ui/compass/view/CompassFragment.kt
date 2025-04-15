package com.galal.seenapay.ui.compass.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.galal.seenapay.R
import com.galal.seenapay.databinding.FragmentCompassBinding
import com.galal.seenapay.ui.compass.viewModel.CompassViewModel

class CompassFragment : Fragment() {

    private var _binding: FragmentCompassBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[CompassViewModel::class.java]

        dashboardViewModel.setText(getString(R.string.this_is_compass_fragment))

        _binding = FragmentCompassBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}