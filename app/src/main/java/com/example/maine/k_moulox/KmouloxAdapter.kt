package com.example.maine.k_moulox

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.maine.k_moulox.R.array.citationK
import kotlinx.android.synthetic.main.item_kmoulox.view.*
import android.R.raw
import android.media.AudioManager
import android.media.MediaPlayer
import android.view.ContextMenu
import java.security.AccessController.getContext

class KmouloxAdapter (val items : Array<AfficherKmoulox>):
    RecyclerView.Adapter<KmouloxAdapter.ViewHolder>()
{
    override fun getItemCount(): Int {
        return items.size
    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false) : View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KmouloxAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_kmoulox, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMonObjet(items[position])
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindMonObjet(afficherKamoulox : AfficherKmoulox){
            val textViewName = itemView.findViewById(R.id.textViewTxt) as TextView
            textViewName.text = afficherKamoulox.citationK

            val imgViewImg = itemView.findViewById(R.id.imgViewImg) as ImageView
            imgViewImg.setImageResource(afficherKamoulox.img)
        }
    }
}
