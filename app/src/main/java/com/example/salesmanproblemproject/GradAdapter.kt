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
        holder.grad.text =    data[position].grad
        holder.drzava.text = data[position].drzava
        holder.lant.text = data[position].Lant.toString()
        holder.long.text = data[position].Long.toString()

    }

    override fun getItemCount(): Int {
        return data.size
    }
    //moze se reci da je ova klasa ispod nas jedan item od Recycler viewa
    class GradViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var grad:TextView=itemView.findViewById(R.id.Grad)
        var drzava:TextView=itemView.findViewById(R.id.Drzava)
        var lant:TextView=itemView.findViewById(R.id.lantituda)
        var long:TextView=itemView.findViewById(R.id.longituda)

    }
}