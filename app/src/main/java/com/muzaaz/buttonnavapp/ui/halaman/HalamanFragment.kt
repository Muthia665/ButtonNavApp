package com.muzaaz.buttonnavapp.ui.halaman


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.muzaaz.buttonnavapp.ListAdapter
import com.muzaaz.buttonnavapp.Model

import com.muzaaz.buttonnavapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HalamanFragment : Fragment() {

    private val list = ArrayList<Model>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_halaman, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv.setHasFixedSize(true)

        list.addAll(getListData())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rv.layoutManager = LinearLayoutManager(context)
        val listAdapter = ListAdapter(list)
        rv.adapter = listAdapter
    }

    private fun getListData(): ArrayList<Model> {
        val dataName = resources.getStringArray(R.array.judul_film)
        val dataDesc = resources.getStringArray(R.array.desc_film)
        val dataPhoto = resources.obtainTypedArray(R.array.foto_film)
        val listData = ArrayList<Model>()
        for (position in dataName.indices) {
            val model = Model(
                dataName[position],
                dataDesc[position],
                dataPhoto.getResourceId(position, -1)
            )
            listData.add(model)
        }

        return listData

    }

}
