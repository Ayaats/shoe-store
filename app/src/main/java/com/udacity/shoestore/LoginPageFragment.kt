package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginPageBinding
import com.udacity.shoestore.databinding.FragmentLoginPageBindingImpl


class LoginPageFragment : Fragment() {

    private lateinit var binding: FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_login_page, container, false)

        binding.SignInbutton.setOnClickListener {
            it.findNavController().navigate(LoginPageFragmentDirections.actionLoginPageFragmentToWelcomePageFragment())
        }
        binding.createAccountbutton.setOnClickListener {
            it.findNavController().navigate(LoginPageFragmentDirections.actionLoginPageFragmentToWelcomePageFragment())
        }
        return binding.root


    }

}