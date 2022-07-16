package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListPageBinding
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
        val inflat= context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflat.inflate(R.layout.item, null)
        val name:TextView = view.findViewById(R.id.nameView)
        val size:TextView = view.findViewById(R.id.sizeView)
        val description:TextView = view.findViewById(R.id.decriptionView)
        val company:TextView = view.findViewById(R.id.companyView)

        name.text = shoe.name
        size.text = shoe.size
        description.text = shoe.description
        company.text = shoe.company

        LinearParent!!.addView(view)
}



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.log_out_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)    }
}