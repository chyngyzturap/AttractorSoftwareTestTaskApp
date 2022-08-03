package com.chyngyzturapov.testapp.ui.first.adapter

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.chyngyzturapov.testapp.data.model.JsonModel
import com.chyngyzturapov.testapp.databinding.RvCompaniesBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class WorkExperienceAdapter() :
    ListAdapter<JsonModel.User.Company, WorkExperienceAdapter.ViewHolderCars>(DIFF) {

    fun getItemAtPos(position: Int): JsonModel.User.Company {
        return getItem(position)
    }

    private var _binding: RvCompaniesBinding? = null

    inner class ViewHolderCars(private val binding: RvCompaniesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val current = getItemAtPos(position)
            binding.tvName.text = current.name
            binding.tvPosition.text = current.position
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCars {
        _binding = RvCompaniesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderCars(_binding!!)
    }

    override fun onBindViewHolder(holder: ViewHolderCars, position: Int) {
        holder.onBind(position)
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<JsonModel.User.Company>() {
            override fun areItemsTheSame(
                oldItem: JsonModel.User.Company,
                newItem: JsonModel.User.Company
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: JsonModel.User.Company,
                newItem: JsonModel.User.Company
            ): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

}