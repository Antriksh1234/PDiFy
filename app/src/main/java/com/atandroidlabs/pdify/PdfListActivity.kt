package com.atandroidlabs.pdify

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.annotation.RequiresPermission
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class PdfListActivity : AppCompatActivity() {

    companion object {
        val pdfArray: ArrayList<PdfFile> = ArrayList()
    }

    private val READ_STORAGE_REQUEST_CODE = 1000

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == READ_STORAGE_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Permission granted
                fillPdfArray(Environment.getExternalStorageDirectory())
            } else {
                //Permission denied
                Toast.makeText(this@PdfListActivity, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fillPdfArray(dir: File) {
        for(file in dir.listFiles()) {
            if (file.isDirectory) {
                fillPdfArray(file)
            } else {
                if (file.name.contains(".pdf")) {
                    pdfArray.add(PdfFile(file.name,file.absolutePath))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_list)

        //Check whether we have the permission to read the storage or not
        if (ContextCompat.checkSelfPermission(this@PdfListActivity,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            //We have the permission, so we can go to recursive search of pdf files in the device
            fillPdfArray(Environment.getExternalStorageDirectory())
        } else {
            ActivityCompat.requestPermissions(this@PdfListActivity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),READ_STORAGE_REQUEST_CODE)
        }


        val pdfListRecyclerView: RecyclerView = findViewById(R.id.pdf_list_recycler)
        pdfListRecyclerView.layoutManager = LinearLayoutManager(this@PdfListActivity)
        pdfListRecyclerView.adapter = PdfAdapter(this@PdfListActivity)

    }
}