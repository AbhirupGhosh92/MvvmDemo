package com.happy.krutarthassignment.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.happy.krutarthassignment.R
import com.happy.krutarthassignment.models.ResponseModel
import com.happy.krutarthassignment.repository.Repository
import com.happy.krutarthassignment.viewholders.ListViewHolder

class CustomListAdapter(var context: Context,var list : List<ResponseModel>,var snippet : ((data : ResponseModel) -> Unit)? = null) : RecyclerView.Adapter<ListViewHolder>() {
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

        if(list[position].favourite)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.databinding.favImg.setImageDrawable(context.getDrawable(R.drawable.ic_fav_s))
            }
        }
        else
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.databinding.favImg.setImageDrawable(context.getDrawable(R.drawable.ic_fav_ns))
            }
        }

        holder.databinding.favImg.setOnClickListener {
            var data = list[position]
            data.favourite = !data.favourite
            Repository.insertSingleUser(context,data)
        }

        holder.databinding.txtName.setOnClickListener {
           if(snippet!=null)
            snippet?.invoke(list[position])
        }
    }
}