package com.chyngyzturapov.testapp.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import coil.load
import com.chyngyzturapov.testapp.databinding.FragmentFirstBinding
import com.chyngyzturapov.testapp.ui.first.adapter.WorkExperienceAdapter
import com.chyngyzturapov.testapp.ui.getEducation
import com.chyngyzturapov.testapp.ui.getFullName
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var workExpAdapter: WorkExperienceAdapter? = null
    private val viewModel: FirstViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner, Observer {
            binding.ivPhoto.load(it.photo)
            binding.tvName.text = getFullName(it.first_name, it.second_name)
            binding.tvEducation.text = getEducation(it.education)

            workExpAdapter = WorkExperienceAdapter()
            binding.rvExperience.adapter = workExpAdapter
            workExpAdapter!!.submitList(it.company)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}