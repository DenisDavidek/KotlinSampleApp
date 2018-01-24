package com.example.denisdavidek.kotlintest

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.recycler_view_item.view.*

/**
 * Created by denisdavidek on 1/23/18.
 */

 class RecyclerAdapter1(var dataList: ArrayList<Data>): RecyclerView.Adapter<RecyclerAdapter1.DataViewHolder>() {


   /* private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            Log.e("Click ", dataList.get().finalText)
        }
    }*/

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
      //  holder.
        holder.itemView.textView2.setText(dataList.get(position).finalText)
        with(holder.itemView) {
            /*setOnClickListener(mOnClickListener)*/
        }
       /*
        holder.bindItems(dataList.get(position))*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
       val dataView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent, false)
        return DataViewHolder(dataView)
    }


    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        fun bindItems(data: Data) {

            itemView.textView2.setText(data.finalText);

        }

    }

}