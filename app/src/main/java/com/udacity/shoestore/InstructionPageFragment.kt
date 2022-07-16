package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionPageBinding
import com.udacity.shoestore.databinding.FragmentInstructionPageBindingImpl

class InstructionPageFragment : Fragment() {

private lateinit var binding: FragmentInstructionPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_instruction_page, container, false)
        binding.showList.setOnClickListener {
            it.findNavController().navigate(InstructionPageFragmentDirections.actionInstructionPageFragmentToShoeListPageFragment())
        }

        return binding.root
    }
}