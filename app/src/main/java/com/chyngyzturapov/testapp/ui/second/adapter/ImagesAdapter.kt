package com.chyngyzturapov.testapp.ui.second.adapter

import android.net.Uri
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
import com.chyngyzturapov.testapp.databinding.RvImagesBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class ImagesAdapter() : ListAdapter<Uri, ImagesAdapter.ViewHolderCars>(DIFF) {


    fun getItemAtPos(position: Int): Uri {
        return getItem(position)
    }

    private var _binding: RvImagesBinding? = null

    inner class ViewHolderCars(private val binding: RvImagesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val current = getItemAtPos(position)
            binding.ivImage.load(current)

        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCars {
        _binding = RvImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderCars(_binding!!)
    }

    override fun onBindViewHolder(holder: ViewHolderCars, position: Int) {
        holder.onBind(position)
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Uri>() {
            override fun areItemsTheSame(
                oldItem: Uri,
                newItem: Uri
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(
                oldItem: Uri,
                newItem: Uri
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }

}