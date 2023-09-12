import android.os.Bundle
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.af.shoeapp.R
import com.af.shoeapp.SelectSize
import com.af.shoeapp.SelectSizeAdapter
import com.google.android.material.appbar.MaterialToolbar

class ShoeDetailFragment :Fragment()
{
    lateinit var selectSizeAdapter:SelectSizeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_shoe_detail,container,false)

        val toolBar = view?.findViewById<MaterialToolbar>(R.id.toolbar2)

        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolBar)

        //recycler view
        val sizes= arrayListOf<SelectSize>(SelectSize(0))
        selectSizeAdapter=SelectSizeAdapter(sizes)
        val recyclerView:RecyclerView=view.findViewById(R.id.rvSelectSize)
        recyclerView.adapter=selectSizeAdapter

        val companyNameView=view.findViewById<EditText>(R.id.etCompany)
        val shoeNameView=view.findViewById<EditText>(R.id.etName)


        val save=view.findViewById<Button>(R.id.btnSave)

        save.setOnClickListener {
            val companyName=companyNameView.text.toString()
            val shoeName=shoeNameView.text.toString()

            val action=ShoeDetailFragmentDirections
                .actionShoeDetailFragmentToShoeListFragment(companyName,shoeName)

            view.findNavController().navigate(action)
        }


        return view

    }
}