package com.chyngyzturapov.testapp.ui.second

import android.Manifest
import android.R.attr
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.chyngyzturapov.testapp.data.model.JsonModel
import com.chyngyzturapov.testapp.databinding.FragmentSecondBinding
import com.chyngyzturapov.testapp.ui.checkPermission
import com.chyngyzturapov.testapp.ui.first.adapter.WorkExperienceAdapter
import com.chyngyzturapov.testapp.ui.getPermission
import com.chyngyzturapov.testapp.ui.second.adapter.ImagesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private var colum = arrayOf<String>(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    private var imagesAdapter: ImagesAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPermission(requireActivity())
        binding.btnPick.setOnClickListener {
            val isGranted = checkPermission(requireActivity())
            if (isGranted)
                openGallery()
            else
                getPermission(requireActivity())
        }

        imagesAdapter = ImagesAdapter()
        binding.rvImages.adapter = imagesAdapter
    }


    private fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 123)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageList = mutableListOf<Uri>()

        if (requestCode == 123 && resultCode == RESULT_OK) {
            if (data?.clipData != null) {
                imageList.clear()
                val x: Int = data.clipData?.itemCount!!
                for (i in 0 until x) {
                    imageList.add(data.clipData?.getItemAt(i)?.uri!!)
                }
                imagesAdapter!!.submitList(imageList)
                Toast.makeText(requireContext(), "${imageList.size}", Toast.LENGTH_SHORT).show()
            } else if (data?.data != null) {
                imageList.clear()
                val imgUrl: String = data.data!!.path!!
                imageList.add(Uri.parse(imgUrl))
                imagesAdapter!!.submitList(imageList)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}