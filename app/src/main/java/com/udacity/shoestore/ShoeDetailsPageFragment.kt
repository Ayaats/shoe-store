package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsPageBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_details_page.*

class ShoeDetailsPageFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsPageBinding
    private lateinit var viewModel: ShoeStoreViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_details_page, container, false)

        viewModel= ViewModelProvider(requireActivity()).get(ShoeStoreViewModel::class.java)
        binding.cancel.setOnClickListener {
            it.findNavController().navigate(ShoeDetailsPageFragmentDirections.actionShoeDetailsPageFragmentToShoeListPageFragment())
        }

        binding.newShoe= Shoe("","","","")
        binding.shoeFrag=this
        binding.lifecycleOwner=this
        return binding.root
    }

    fun InsertShoe(shoe: Shoe){
        if(shoe.name.isNullOrEmpty()||shoe.company.isNullOrEmpty()||
            shoe.size.isNullOrEmpty()||shoe.description.isNullOrEmpty())
            Toast.makeText(context,"ENTER ALL DATA",Toast.LENGTH_SHORT).show()
        else{
            viewModel.add(Shoe(shoe.name,shoe.company,shoe.size,shoe.description))

           save.findNavController().navigate(ShoeDetailsPageFragmentDirections.actionShoeDetailsPageFragmentToShoeListPageFragment())


        }

    }

}