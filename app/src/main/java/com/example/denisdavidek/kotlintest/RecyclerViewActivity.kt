package com.example.denisdavidek.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {


    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager;

        if (intent.hasExtra("textMessage")) {

            Toast.makeText(this, intent.getStringExtra("textMessage"), Toast.LENGTH_SHORT).show()

        }


        val data = ArrayList<Data>()
        data.add(Data("test1"))
        data.add(Data("test2"))
        data.add(Data("test3"))
        data.add(Data("test4"))
        data.add(Data("test5"))
        data.add(Data("test6"))
        data.add(Data("test7"))
        data.add(Data("test8"))

        val rec_adapter = RecyclerAdapter1(data)
        recycler_view.adapter = rec_adapter
        recycler_view.setOnClickListener { view ->
            Toast.makeText(applicationContext,"blablalba",Toast.LENGTH_SHORT).show()
        }
    }
}
