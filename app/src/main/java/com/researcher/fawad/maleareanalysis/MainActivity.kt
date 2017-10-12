package com.researcher.fawad.malwareanalysis

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.researcher.fawad.maleareanalysis.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.grid_element.view.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import com.researcher.fawad.maleareanalysis.Activity_List_View


class MainActivity : AppCompatActivity() {
    var adopter: GridAdopter? = null
    var listofTopics = ArrayList<GridItems>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add Items to grid list
        listofTopics.add(GridItems("Introduction",R.drawable.mlogo))
        listofTopics.add(GridItems("Basic Static",R.drawable.istatic))
        //Settingg Adopter
        adopter= GridAdopter(listofTopics,this)

        main_activity_grid.adapter=adopter
    }


    //
    //Adopter Class
    //
    class GridAdopter : BaseAdapter {
        var listofTopics = ArrayList<GridItems>()
        var context: Context? = null

        constructor(listofTopics: ArrayList<GridItems>, context: Context) : super() {
            this.context = context
            this.listofTopics = listofTopics
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var curTopic = listofTopics[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var gview = inflator.inflate(R.layout.grid_element,null)
            gview.grid_element_iv.setImageResource(curTopic.img!!)
            gview.grid_element_tv.text=curTopic.title!!

            gview.setOnClickListener {
                object : Thread(){
                    override fun run() {
                        var i:Intent = Intent(context,Activity_List_View::class.java)
                        context!!.startActivity(i)
                    }
                }.start()
                Log.i("tt",gview.grid_element_tv.text.toString())
            }

            return gview
        }

        override fun getItem(p0: Int): Any {
            return listofTopics[p0]
        }

        override fun getItemId(p0: Int): Long {
            return  p0.toLong()
        }

        override fun getCount(): Int {
            return listofTopics.size
        }

    }
}
