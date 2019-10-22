package com.happy.krutarthassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.happy.krutarthassignment.R
import com.happy.krutarthassignment.models.ResponseModel
import com.happy.krutarthassignment.viewholders.ListViewHolder

class CustomListAdapter(var list : List<ResponseModel>) : RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        return ListViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.list_fragment,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.databinding.contactTxt.text = list[position].phone
        holder.databinding.txtMail.text = list[position].email
        holder.databinding.txtName.text = list[position].name
    }
}