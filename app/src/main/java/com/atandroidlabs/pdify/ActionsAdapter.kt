package com.atandroidlabs.pdify

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActionsAdapter(private val context: Context) : RecyclerView.Adapter<ActionsAdapter.ActionsViewHolder>() {

    override fun onBindViewHolder(holder: ActionsViewHolder, position: Int) {
        holder.actionNameTextView.setText(MainActivity.actionArray[position].stringId)
        holder.actionImageView.setImageResource(MainActivity.actionArray[position].imgId)
        handleClickEvent(holder.itemView, position)
    }

    private fun handleClickEvent(view: View, position: Int) {
        val intent: Intent = when(position) {
            0-> Intent(context,CreateActivity::class.java)
            1-> Intent(context, EditActivity::class.java)
            2-> Intent(context,PdfListActivity::class.java)
            else -> Intent(context, ShareActivity::class.java)
        }

        view.setOnClickListener(View.OnClickListener {
            context.startActivity(intent)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionsViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.action_layout,parent,false)

        return ActionsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return MainActivity.actionArray.size
    }

    class ActionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var actionNameTextView: TextView = itemView.findViewById(R.id.action_name)
        var actionImageView: ImageView = itemView.findViewById(R.id.action_image)
    }
}