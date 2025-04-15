package com.galal.seenapay.ui.profile.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.galal.seenapay.R
import com.galal.seenapay.databinding.FragmentProfileBinding
import com.galal.seenapay.ui.profile.viewModel.ProfileViewModel


class ProfileFragment : Fragment() {


    private var _binding: FragmentProfileBinding? = null
    private val binding get() =    _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val profileViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]

        profileViewModel.setText(getString(R.string.this_is_profile_fragment))


        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textProfile
        profileViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


}