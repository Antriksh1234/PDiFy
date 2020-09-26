package com.atandroidlabs.pdify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val actionArray: ArrayList<Action> = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionArray.clear()

        actionArray.add(Action(R.string.create,R.drawable.ic_baseline_add_24))
        actionArray.add(Action(R.string.edit,R.drawable.ic_baseline_edit_24))
        actionArray.add(Action(R.string.view,R.drawable.ic_baseline_find_in_page_24))
        actionArray.add(Action(R.string.share,R.drawable.ic_baseline_share_24))

        val actionRecyclerView: RecyclerView = findViewById(R.id.action_recycler)
        actionRecyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        actionRecyclerView.adapter = ActionsAdapter(this@MainActivity)

    }
}

//Emulator: emulator: ERROR: AdbHostServer.cpp:83: adb protocol fault (couldn't read status length)
