package com.example.salesmanproblemproject

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.salesmanproblemproject.databinding.FragmentListaGradovaBinding
import com.example.salesmanproblemproject.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ListaGradovaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaGradovaFragment : Fragment() {
    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentListaGradovaBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista_gradova, container, false)

        //postavljanje recyclerView-a
        var podaci= arrayListOf<Grad>()
        podaci=postaviListu(podaci)
        val grad_adapter=GradAdapter()
        grad_adapter.data=podaci
        val recyclerView: RecyclerView=binding.recycleGradovi
        recyclerView.adapter=grad_adapter

        //kraj postavljanja recycler Viewa
        ///////////////////pocetak za bocni meni
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


    private fun postaviListu(podaci: ArrayList<Grad>): ArrayList<Grad> {
        var povratna= arrayListOf<Grad>()
        povratna.add(Grad("Sarajevo","Bosna i Hercegovina",43.915886,17.679076))
        povratna.add(Grad("Tirana","Albanija",41.153332,20.168331 ))
        povratna.add(Grad("Berlin","Njemačka", 51.165691, 10.451526))
        return povratna
    }


}