package com.galal.seenapay.ui.invoice.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.galal.seenapay.R
import com.galal.seenapay.databinding.FragmentInvoiceBinding
import com.galal.seenapay.ui.invoice.viewModel.InvoiceViewModel

class InvoiceFragment : Fragment() {

    private var _binding: FragmentInvoiceBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val invoiceViewModel =
            ViewModelProvider(this)[InvoiceViewModel::class.java]

        invoiceViewModel.setText(getString(R.string.this_is_invoice_fragment))

        _binding = FragmentInvoiceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        invoiceViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}