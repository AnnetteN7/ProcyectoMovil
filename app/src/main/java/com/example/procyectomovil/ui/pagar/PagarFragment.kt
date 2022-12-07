package com.example.procyectomovil.ui.pagar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.procyectomovil.databinding.FragmentPagarBinding
import com.example.procyectomovil.viewmodel.PagarViewModel


class PagarFragment : Fragment() {

    private var _binding: FragmentPagarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val pagarViewModel =
            ViewModelProvider(this).get(PagarViewModel::class.java)

        _binding = FragmentPagarBinding.inflate(inflater, container, false)
        val root: View = binding.root

       /* val textView: TextView = binding.textPagar*/
        pagarViewModel.text.observe(viewLifecycleOwner) {
            /*textView.text = it*/
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}