package com.example.publicapi.ui.main.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.publicapi.R
import com.example.publicapi.data.model.Entry
import com.example.publicapi.data.model.public


class MainAdapter(private val publivItemList: public) :RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {

        return publivItemList.entries.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${publivItemList.entries.size} ")
        return holder.bind(publivItemList.entries[position])
    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        var tvTitle = itemView.findViewById<TextView>(R.id.txt1)
        var tvCases = itemView.findViewById<TextView>(R.id.txt2)
        fun bind(publicItem: Entry) {
          //  val0 entries: List<Entry>
            tvTitle.text = publicItem.API
            tvCases.text = publicItem.Category
        }
    }
}