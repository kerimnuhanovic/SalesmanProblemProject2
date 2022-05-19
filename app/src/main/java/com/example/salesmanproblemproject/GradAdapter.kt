package com.example.salesmanproblemproject


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GradAdapter: RecyclerView.Adapter<GradAdapter.GradViewHolder>() {
    var data=listOf<Grad>()//ovdje ce ici lista gradova


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradViewHolder {
        val layoutType=R.layout.grad_item
        val view: View=LayoutInflater.from(parent.context).inflate(layoutType,parent, false)
        return GradViewHolder(view)

    }

    override fun onBindViewHolder(holder: GradViewHolder, position: Int) {
        holder.grad.text="Sarajevo"
        holder.drzava.text="Sarajevo"

    }

    override fun getItemCount(): Int {
        return 20
    }
    //moze se reci da je ova klasa ispod nas jedan item od Recycler viewa
    class GradViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var grad:TextView=itemView.findViewById(R.id.Grad)
        var drzava:TextView=itemView.findViewById(R.id.Drzava)

    }
}