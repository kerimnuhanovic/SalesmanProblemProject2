package com.example.salesmanproblemproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
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
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentListaGradovaBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista_gradova, container, false)

        //postavljanje recyclerView-a
        val grad_adapter=GradAdapter()
        val recyclerView: RecyclerView=binding.recycleGradovi
        recyclerView.adapter=grad_adapter//kraj postavljanja recycler Viewa
        //dodavanje menua
        setHasOptionsMenu(true)
        gradViewModel = ViewModelProvider(this).get(GradDBViewModel::class.java)

        gradViewModel.readAllData.observe(viewLifecycleOwner, Observer {grad->
            grad_adapter.setGradovi(grad)
        })

        binding.floatingActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_listaGradovaFragment_to_dodajGradFragment)
        )

        //potrebno za side menu
        var drawerLayout: DrawerLayout =binding.drawerLayout
        var navView=binding.navView
        toggle = ActionBarDrawerToggle(activity, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()///kraj za bocni meni
        //nisam nesto dodao jer ne moze u fragmentu



        return binding.root;
    }
    //ispod je funckija potrebna za selektiranje itema u bocnom meniju
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }



}