package com.example.recyclerapapterwithlambda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerAdapterKotlin(val list: ArrayList<Person>, val lambdaFun: (String) -> Unit) :
    RecyclerView.Adapter<RecyclerAdapterKotlin.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return RecyclerViewHolder(v, lambdaFun)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(list[position].name,list[position].family)
    }


    class RecyclerViewHolder(itemView: View, val lambdaFun: (String) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(name: String, family: String) {
            itemView.textView.text = name
            itemView.setOnClickListener { lambdaFun(family) }
        }
    }
}