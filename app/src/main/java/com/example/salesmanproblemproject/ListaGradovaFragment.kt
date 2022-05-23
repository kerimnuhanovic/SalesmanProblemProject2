package com.example.salesmanproblemproject

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.salesmanproblemproject.database.GradDBViewModel
import com.example.salesmanproblemproject.databinding.FragmentListaGradovaBinding
import com.example.salesmanproblemproject.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ListaGradovaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaGradovaFragment : Fragment() {

    private lateinit var gradViewModel: GradDBViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentListaGradovaBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista_gradova, container, false)

        //postavljanje recyclerView-a
        val grad_adapter=GradAdapter()
        val recyclerView: RecyclerView=binding.recycleGradovi
        recyclerView.adapter=grad_adapter//kraj postavljanja recycler Viewa

        /*dodat liniju koda ako zatreba*/
        gradViewModel = ViewModelProvider(this).get(GradDBViewModel::class.java)

        gradViewModel.readAllData.observe(viewLifecycleOwner, Observer {grad->
            grad_adapter.setGradovi(grad)
        })

        binding.floatingActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_listaGradovaFragment_to_dodajGradFragment)
        )

        binding.izbrisiSve.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setPositiveButton("DA"){_, _ ->
                gradViewModel.deleteAll()
                Toast.makeText(requireContext(), "Gradovi izbrisani", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("NE") {_, _ ->

            }
            builder.setTitle("Izbrisi")
            builder.setMessage("Da li želite izbrisati sve gradove?")
            builder.show()
        }


        binding.dugme.setOnClickListener {
            var listaPomocna: ListaGradova = ListaGradova(gradViewModel.readAllData.value!!)
            if (gradViewModel.readAllData.value!!.size == 0 || gradViewModel.readAllData.value!!.size == 1 ||
                gradViewModel.readAllData.value!!.size == 2
            ) {
                Toast.makeText(requireContext(), "Potrebna su barem tri grada za računanje puta!", Toast.LENGTH_LONG).show()
            } else {
                it.findNavController().navigate(
                    ListaGradovaFragmentDirections.actionListaGradovaFragmentToNajkraciPutFragment(
                        listaPomocna
                    )
                )

            }
        }
        return binding.root;
    }


}