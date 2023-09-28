package com.af.shoeapp.ui.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.af.shoeapp.R
import com.af.shoeapp.ViewModel.ShareViewModel
import com.af.shoeapp.data.Shoe
import com.af.shoeapp.databinding.FragmentShoeListBinding
import com.google.android.material.appbar.MaterialToolbar


class ShoeListFragment : Fragment() {

    private lateinit var shoeAdapter: ShoeAdapter
    private lateinit var shoes: ArrayList<Shoe>
    lateinit var viewModel:ShareViewModel

    private var _binding:FragmentShoeListBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentShoeListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurationToolBar( binding.toolbar)
        setOnClicks()

        //for menu
        setHasOptionsMenu(true)

        initViewModel()

        //recycler view
        addItemToRecycleView(binding.rvShoes)
    }

    private fun initViewModel(){
        viewModel= ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
    }

    private fun initShoeObservers(): Shoe {
        var shoeName: String? = null
        var companyName: String? = null
        var shoeSize: String? = null

        viewModel.shoeName.observe(viewLifecycleOwner, Observer {newValue->
            shoeName = newValue
        })

        viewModel.companyName.observe(viewLifecycleOwner, Observer {newValue->
            companyName = newValue
        })

        viewModel.shoeSize.observe(viewLifecycleOwner, Observer {newValue->
            shoeSize = newValue
        })

        return Shoe(shoeName, companyName, R.drawable.shoe1, shoeSize)
    }





    private fun addItemToRecycleView(recyclerView: RecyclerView) {
        //recyclerView

        shoes = arrayListOf<Shoe>(
            Shoe("Black shoes", "Adidas", R.drawable.shoes_black, "30"),
            Shoe("Nike shoes", "Nike", R.drawable.nike_shoes, "20")
        )

        shoeAdapter = ShoeAdapter(shoes)
        recyclerView.adapter = shoeAdapter

        shoes.add(initShoeObservers())
        shoeAdapter.notifyDataSetChanged()
        shoeAdapter.notifyItemInserted(shoes.size - 1)

    }

    private fun setOnClicks() {
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
    }




    private fun configurationToolBar(toolBar:MaterialToolbar) {
        //toolbar configuration
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolBar)

    }


    private fun receiveArgumentsFromBundle() {
        //receive arguments

//        val args = this.arguments
//        val companyName = args?.getString("companyName")
//        val shoeName = args?.getString("shoeName")
//        val shoeSize= args?.getString("shoeSize")

//        val userShoe = Shoe(shoeName.toString(), companyName.toString(), R.drawable.shoe3, shoeSize)

//        shoes.add(initShoeObservers())
//        shoeAdapter.notifyItemInserted(shoes.size - 1)
    }

//    private fun navigateToDestinationFragment(){
//        view?.findNavController()
//            ?.safeNavigate(com.af.shoeapp.ui.ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
//        //.navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
//    }

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