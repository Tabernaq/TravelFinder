package com.brkv.travelfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card.view.*

class CardAdapter(val items : Array<Article>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        ViewHolder {
            return ViewHolder(parent.inflate(R.layout.card))
        }

    override fun getItemCount(): Int = items.size

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this,
                attachToRoot)
    }

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindCard(article: Article) {
            with(article) {
                itemView.title.text = nom
                itemView.subTxt.text = desc

            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCard(items[position])
    }


}

