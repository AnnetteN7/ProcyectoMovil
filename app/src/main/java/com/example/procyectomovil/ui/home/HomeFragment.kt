package com.example.procyectomovil.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.savedstate.R
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.procyectomovil.adapter.CategoryAdapter
import com.example.procyectomovil.databinding.FragmentHomeBinding
import com.example.procyectomovil.viewmodel.HomeViewModel
import io.grpc.InternalChannelz.id


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
/*
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

       binding.btaAddCategoryFab.setOnClickListener {
            findNavController().navigate(R.id.ac)
        }*/


        val categoryAdapter= CategoryAdapter()
        val recicladorMenu = binding.recicladorMenu
        recicladorMenu.adapter = categoryAdapter
        recicladorMenu.layoutManager = LinearLayoutManager(requireContext())
        homeViewModel.getCategorias.observe(viewLifecycleOwner){
                categorias -> categoryAdapter.setCategorias(categorias)
    }
        return binding.root
    }
        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
