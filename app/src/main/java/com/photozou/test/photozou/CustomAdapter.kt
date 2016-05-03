package com.photozou.test.photozou

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycle_card.view.*

/**
 * Created by horinoA on 2016/05/02.
 */
data class card_View(val url:String,
                     val thum_url:String,
                     val card_title:String,
                     val caption1:String,
                     val caption2:String)

class CustomAdapter(cardview : Array<card_View>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    protected val mCardView : Array<card_View>  = cardview

    class ViewHolder : RecyclerView.ViewHolder {
        constructor(v: View):super(v) {
            //SAM変換がもろにきいてます
            v.setOnClickListener { Log.d("","Element " + getAdapterPosition() + " clicked.") }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.recycle_card,parent,false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //setter,getterは書かなくてもインスタンスについてくる
        holder.itemView.card_title.text = mCardView[position].card_title
        holder.itemView.caption1.text = mCardView[position].caption1
        holder.itemView.caption2.text = mCardView[position].caption2
    }

    override fun getItemCount(): Int {
        return mCardView.count()
    }
}