package com.example.salesmanproblemproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.salesmanproblemproject.databinding.FragmentListaGradovaBinding
import com.example.salesmanproblemproject.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ListaGradovaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaGradovaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentListaGradovaBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista_gradova, container, false)

        //postavljanje recyclerView-a
        val grad_adapter=GradAdapter()
        val recyclerView: RecyclerView=binding.recycleGradovi
        recyclerView.adapter=grad_adapter//kraj postavljanja recycler Viewa

        return binding.root;
    }



}