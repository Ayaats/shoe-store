package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.View.inflate
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding.inflate
import com.udacity.shoestore.databinding.FragmentInstructionPageBinding.inflate
import com.udacity.shoestore.databinding.FragmentShoeListPageBinding
import com.udacity.shoestore.databinding.FragmentWelcomePageBinding.inflate
import com.udacity.shoestore.databinding.ItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeListPageFragment : Fragment() {

    private lateinit var binding: FragmentShoeListPageBinding
    private lateinit var viewModel: ShoeStoreViewModel
    private var  LinearParent: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list_page, container, false)
        setHasOptionsMenu(true)
        viewModel= ViewModelProvider(requireActivity()).get(ShoeStoreViewModel::class.java)

        LinearParent=binding.scroll



        binding.floatActionBtn.setOnClickListener {
            it.findNavController().navigate(ShoeListPageFragmentDirections.actionShoeListPageFragmentToShoeDetailsPageFragment())
        }



        viewModel.list.observe(viewLifecycleOwner,Observer { ShoeNew->
            for (i in ShoeNew.indices){
                val new=ShoeNew[i]
                AddNeWShoe(new)
            }
        })

        return binding.root
    }
    private fun AddNeWShoe(shoe: Shoe) {

        val inflater= context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val i = inflater.inflate(R.layout.item, null)
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(requireContext()))
        itemBinding.nameView.text = shoe.name
        itemBinding.sizeView.text = shoe.size
        itemBinding.companyView.text = shoe.company
        itemBinding.decriptionView.text = shoe.description

        LinearParent!!.addView(itemBinding.root)
}

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.log_out_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)    }
}