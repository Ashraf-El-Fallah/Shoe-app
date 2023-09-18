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
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.af.shoeapp.R
import com.af.shoeapp.data.Shoe
import com.af.shoeapp.adapters.ShoeAdapter
import com.af.shoeapp.databinding.FragmentShoeListBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ShoeListFragment : Fragment() {

    private lateinit var shoeAdapter: ShoeAdapter
    private lateinit var shoes: ArrayList<Shoe>
//    private lateinit var addButton:FloatingActionButton

    private var _binding:FragmentShoeListBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentShoeListBinding.inflate(inflater,container,false)
        val view =binding.root

//        addButton = binding.fabAdd
//        val toolBar =binding.toolbar
//        val recyclerView: RecyclerView = binding.rvShoes

        configurationToolBar( binding.toolbar)
        setOnClicks()

        //for menu
        setHasOptionsMenu(true)

        //recycler view
        addItemToRecycleView(binding.rvShoes)
        receiveArgumentsFromBundle()

        return view
    }

    private fun setOnClicks() {
        binding.fabAdd.setOnClickListener {
            navigateToDestinationFragment()
        }
    }


    private fun configurationToolBar(toolBar:MaterialToolbar) {
        //toolbar configuration
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolBar)

    }

    private fun addItemToRecycleView(recyclerView: RecyclerView) {
        //recyclerView

        shoes = arrayListOf<Shoe>(
            Shoe("Black shoes", "Adidas", R.drawable.shoes_black, "30"),
            Shoe("Nike shoes", "Nike", R.drawable.nike_shoes, "20")
        )
        shoeAdapter = ShoeAdapter(shoes)
        recyclerView.adapter = shoeAdapter
    }

    private fun receiveArgumentsFromBundle() {
        //receive arguments

        val args = this.arguments
        val companyName = args?.getString("companyName")
        val shoeName = args?.getString("shoeName")
        val shoeSize= args?.getString("shoeSize")

        val userShoe = Shoe(shoeName.toString(), companyName.toString(), R.drawable.shoe3, shoeSize)
        shoes.add(userShoe)
        shoeAdapter.notifyItemInserted(shoes.size - 1)
    }

    private fun navigateToDestinationFragment(){
        view?.findNavController()
            ?.safeNavigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        //.navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
    }

    private fun NavController.safeNavigate(direction: NavDirections) {
        currentDestination?.getAction(direction.actionId)?.run {
            navigate(direction)
        }
    }

    override  fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.miLogOut -> {
                requireActivity().finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}