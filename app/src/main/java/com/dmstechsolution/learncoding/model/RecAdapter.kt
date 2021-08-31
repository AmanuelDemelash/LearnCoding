package com.dmstechsolution.learncoding.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dmstechsolution.learncoding.R
import io.armcha.elasticview.ElasticView

class RecAdapter(private val langu:List<language>): RecyclerView.Adapter<RecAdapter.ViewHolder>() {


    class ViewHolder(view:View):RecyclerView.ViewHolder(view){

        val image= view.findViewById<ImageView>(R.id.circleImageView)!!
        val title= view.findViewById<TextView>(R.id.langtitle)!!
        val elas= view.findViewById<ElasticView>(R.id.card)!!
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item=langu[position]
        holder.image.setImageResource(item.image)
        holder.title.text= item.name
        holder.elas.setOnClickListener {
            val bundle= bundleOf("name" to item.name)
            it.findNavController().navigate(R.id.action_nav_home_to_nav_slideshow,bundle)
        }
    }
    override fun getItemCount(): Int {
      return langu.size
    }

}