package com.dmstechsolution.learncoding.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dmstechsolution.learncoding.R
import com.github.barteksc.pdfviewer.PDFView

class SlideshowFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
       val pdf_viewer=root.findViewById<PDFView>(R.id.pdf_viewer)

        val name=arguments?.getString("name")
        when{
            name.equals("Html") ->{
                pdf_viewer.fromAsset("html.pdf").load()
            }
            name.equals("Css") ->{
                pdf_viewer.fromAsset("css.pdf").load()
            }
            name.equals("Android") ->{
                pdf_viewer.fromAsset("androidapp.pdf").load()
            }
            name.equals("C++") ->{
                pdf_viewer.fromAsset("ccc.pdf").load()
            }
            name.equals("Java") ->{
                pdf_viewer.fromAsset("java.pdf").load()
            }
            name.equals("JavaScript") ->{
                pdf_viewer.fromAsset("js.pdf").load()
            }
            name.equals("Kotlin") ->{
                pdf_viewer.fromAsset("ProgrammingKotlin.pdf").load()
            }
            name.equals("Php") ->{
                pdf_viewer.fromAsset("php.pdf").load()
            }
            name.equals("Python") ->{
                pdf_viewer.fromAsset("python.pdf").load()
            }
            name.equals("Swift") ->{
                pdf_viewer.fromAsset("swift.pdf").load()
            }
            name.equals("WordPress") ->{
                pdf_viewer.fromAsset("wordpress.pdf").load()
            }
            name.equals("Xml") ->{
                pdf_viewer.fromAsset("xml.pdf").load()
            }
        }


        return root
    }
}