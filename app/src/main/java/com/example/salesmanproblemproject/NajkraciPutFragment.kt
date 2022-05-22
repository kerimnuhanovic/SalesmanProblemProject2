package com.example.salesmanproblemproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.salesmanproblemproject.algoritam.Algoritam
import com.example.salesmanproblemproject.database.GradDBViewModel
import com.example.salesmanproblemproject.databinding.FragmentNajkraciPutBinding


class NajkraciPutFragment : Fragment() {

    lateinit var gradViewModel: GradDBViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNajkraciPutBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_najkraci_put, container,false)


        gradViewModel = ViewModelProvider(this).get(GradDBViewModel::class.java)

        var algoritam: Algoritam

        return binding.root

    }

}