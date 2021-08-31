package com.dmstechsolution.learncoding.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dmstechsolution.learncoding.R
import com.dmstechsolution.learncoding.model.RecAdapter
import com.dmstechsolution.learncoding.model.language

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val rec=root.findViewById<RecyclerView>(R.id.recycler)
        rec.layoutManager=GridLayoutManager(requireContext(),2)

        val pro_languages= listOf(
            language("Html",R.drawable.htmll),
            language("Css",R.drawable.css),
            language("C++",R.drawable.cc),
            language("Xml",R.drawable.xml),
            language("Python",R.drawable.python),
            language("Php",R.drawable.php),
            language("Android",R.drawable.android),
            language("Kotlin",R.drawable.kotlin),
            language("Java",R.drawable.java),
            language("JavaScript",R.drawable.javascript),
            language("WordPress",R.drawable.wordpress),
            language("Swift",R.drawable.swift),)

        val rec_adapter=RecAdapter(pro_languages)
        rec.adapter=rec_adapter

        return root
    }
}