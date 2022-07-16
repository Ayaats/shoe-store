package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.databinding.FragmentWelcomePageBinding

class WelcomePageFragment : Fragment() {
    private lateinit var binding:FragmentWelcomePageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_welcome_page, container, false)

        binding.welcomBtn.setOnClickListener {
            it.findNavController().navigate(WelcomePageFragmentDirections.actionWelcomePageFragmentToInstructionPageFragment())
        }

        return binding.root
    }


}