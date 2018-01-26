package com.example.denisdavidek.kotlintest

import android.graphics.Movie
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.denisdavidek.kotlintest.data.Data
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity(), clickInterface {


    override fun onItemInteraction(clickedPostion: Int) {
    Toast.makeText(applicationContext,data.get(clickedPostion).finalText, Toast.LENGTH_SHORT).show()

  }
//443,51   - 156,9

    private lateinit var linearLayoutManager: LinearLayoutManager
    val data = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager;

        if (intent.hasExtra("textMessage")) {

            Toast.makeText(this, intent.getStringExtra("textMessage"), Toast.LENGTH_SHORT).show()

        }



        data.add(Data("test1"))
        data.add(Data("test2"))
        data.add(Data("test3"))
        data.add(Data("test4"))
        data.add(Data("test5"))
        data.add(Data("test6"))
        data.add(Data("test7"))
        data.add(Data("test8"))

        val rec_adapter = RecyclerAdapter1(data,this)
        recycler_view.adapter = rec_adapter
        recycler_view.setOnClickListener { _ ->
            Toast.makeText(applicationContext,"blablalba",Toast.LENGTH_SHORT).show()
        }
    }
}
