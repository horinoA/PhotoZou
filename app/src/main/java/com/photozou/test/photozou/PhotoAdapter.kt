package com.photozou.test.photozou

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycle_card.view.*
import java.util.*

/**
 * Created by horinoA on 2016/05/02.
 */

class PhotoAdapter(photo : ArrayList<Photo>, context : Context) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>(){

    protected val mPhoto : ArrayList<Photo>  = photo
    protected val mContext :Context = context

    override fun onBindViewHolder(holder: PhotoAdapter.ViewHolder?, position: Int) {
        //setter,getterは書かなくてもインスタンスについてくる
        holder?.let {
            holder.itemView.card_title.text = mPhoto[position].photo_title
            holder.itemView.caption1.text = mPhoto[position].date
            holder.itemView.caption2.text = mPhoto[position].copyright
            Picasso.with(mContext)
                .load(mPhoto[position].thumbnail_image_url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.itemView.card_thumnail)
        }

    }

    class ViewHolder : RecyclerView.ViewHolder {
        constructor(v: View):super(v) {
            v.setOnClickListener { Log.d("Tag","Element " + getAdapterPosition() + " clicked.") }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.recycle_card,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mPhoto.count()
    }

    data class atai(val title:String,val imageUrl:String,val cap1:String,val cap2:String)

}