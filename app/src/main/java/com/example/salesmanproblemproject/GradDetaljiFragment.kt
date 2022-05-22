package com.example.salesmanproblemproject

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.salesmanproblemproject.database.GradDBViewModel
import com.example.salesmanproblemproject.databinding.FragmentGradDetaljiBinding

class GradDetaljiFragment : Fragment() {

    lateinit var gradViewModel:GradDBViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentGradDetaljiBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_grad_detalji,container,false)

        var args = GradDetaljiFragmentArgs.fromBundle(arguments!!)

        binding.gradNaziv.text = args.grad.grad
        binding.drzavaNaziv.text = args.grad.drzava
        binding.opisText.text = args.grad.opis
        binding.latitudaVrijednost.text = args.grad.latituda.toString()
        binding.longitudaVrijednost.text = args.grad.longituda.toString()


        gradViewModel = ViewModelProvider(this).get(GradDBViewModel::class.java)

        binding.izbrisiGrad.setOnClickListener {
            val alert = AlertDialog.Builder(requireContext())
            alert.setPositiveButton("DA") {_,_ ->
                gradViewModel.deleteCity(args.grad)
                it.findNavController().navigate(GradDetaljiFragmentDirections.actionGradDetaljiFragmentToListaGradovaFragment())
            }
            alert.setNegativeButton("NE") {_,_ ->

            }
            alert.setTitle("Izbrisi ${args.grad.grad}?")
            alert.setMessage("Želite li izbrisati grad ${args.grad.grad}")
            alert.create().show()
        }

        return binding.root
    }
}