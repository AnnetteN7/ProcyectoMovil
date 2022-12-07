package com.example.procyectomovil.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.procyectomovil.R
import com.example.procyectomovil.databinding.FragmentCategoryBinding

import com.example.procyectomovil.databinding.FragmentHomeBinding

import com.example.procyectomovil.model.Category
import com.example.procyectomovil.ui.home.HomeFragmentDirections
import com.example.procyectomovil.ui.home.HomeFragmentDirections.Companion.actionNavHomeToShowDetailActivty
import java.net.URL


class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    private var listaCategorias = emptyList<Category>()
    inner class CategoryViewHolder(private val itemBinding:FragmentCategoryBinding): RecyclerView.ViewHolder(itemBinding.root) {


        fun dibujar(category: Category) {
            itemBinding.catName.text = category.categoryName
            itemBinding.vistaMenu.setOnClickListener {
                val action = actionNavHomeToShowDetailActivty(category)
                itemView.findNavController().navigate(action)

            }
        }
    }
        fun setCategorias(categorias: List<Category>) {
            listaCategorias = categorias
            notifyDataSetChanged()
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
            val itemBinding =  FragmentCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return CategoryViewHolder(itemBinding)
        }




        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
            val category = listaCategorias[position]
            holder.dibujar(category)
        }

        override fun getItemCount(): Int {
            return listaCategorias.size
        }

        }




