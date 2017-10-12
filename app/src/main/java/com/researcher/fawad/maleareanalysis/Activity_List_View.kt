package com.researcher.fawad.maleareanalysis

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity__list__view.*
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList
import android.support.annotation.NonNull



class Activity_List_View : AppCompatActivity() {
    internal var list = ArrayList<ListRowHandle>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__list__view)
        list.add(ListRowHandle("Introduction", R.drawable.mlogo))

    }
}
