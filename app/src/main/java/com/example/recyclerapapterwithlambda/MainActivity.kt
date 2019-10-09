package com.example.recyclerapapterwithlambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = ArrayList<Person>()
        list.add(Person("A", "AAAAAAAA"))
        list.add(Person("B", "BBBBBBBB"))
        list.add(Person("C", "CCCCCCCC"))
        list.add(Person("D", "DDDDDDDD"))


        val adapter = RecyclerAdapterKotlin(list) { showToast(it) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager =LinearLayoutManager(this,RecyclerView.VERTICAL,false)
    }

    private fun showToast(it: String) {
        Toast.makeText(this, it, Toast.LENGTH_LONG).show()

    }
}
