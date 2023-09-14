package com.af.shoeapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.af.shoeapp.R
import com.af.shoeapp.data.Shoe
import com.af.shoeapp.adapters.ShoeAdapter
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ShoeListFragment : Fragment() {

    private lateinit var shoeAdapter: ShoeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shoe_list, container, false)

        //toolbar configuration

        val toolBar = view?.findViewById<MaterialToolbar>(R.id.toolbar)

        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolBar)

        //for menu
        setHasOptionsMenu(true)


        //recyclerView

        val shoes= arrayListOf<Shoe>(
            Shoe("Black shoes","Adidas", R.drawable.shoes_black,30),
            Shoe("Nike shoes","Nike", R.drawable.nike_shoes,20)
        )
        shoeAdapter= ShoeAdapter(shoes)
        val recyclerView:RecyclerView=view.findViewById(R.id.rvShoes)
        recyclerView.adapter=shoeAdapter



        //receive arguments
        
        val args=this.arguments
        val companyName=args?.getString("companyName")
        val shoeName=args?.getString("shoeName")

        val userShoe= Shoe(shoeName.toString(),companyName.toString(), R.drawable.shoe3,20)

        shoes.add(userShoe)
        shoeAdapter.notifyItemInserted(shoes.size-1)


        //navigate to the next fragment

        val addButton=view.findViewById<FloatingActionButton>(R.id.fabAdd)


        addButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }


        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{

        return when (item.itemId) {
            R.id.miLogOut ->{
                requireActivity().finish()
                true
            }
            else ->super.onOptionsItemSelected(item)
        }

    }




}