package com.atandroidlabs.pdify

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PdfAdapter(private var context: Context) : RecyclerView.Adapter<PdfAdapter.PdfListViewHolder>() {

    override fun onBindViewHolder(holder: PdfListViewHolder, position: Int) {
        holder.pdfNameTextView.text = PdfListActivity.pdfArray[position].name
        holder.pdfPathTextView.text = PdfListActivity.pdfArray[position].path
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfListViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.pdf_item_view,parent,false)
        return PdfListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return PdfListActivity.pdfArray.size
    }

    class PdfListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pdfNameTextView: TextView = itemView.findViewById(R.id.pdf_name_view)
        val pdfPathTextView: TextView = itemView.findViewById(R.id.pdf_path_view)
        val shareImageView: ImageView = itemView.findViewById(R.id.share_view)
        val editImageView: ImageView = itemView.findViewById(R.id.edit_view)
    }
}