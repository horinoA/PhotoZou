package com.photozou.test.photozou

import android.util.Log
import kotlin.concurrent.thread

/**
 * Created by horinoA on 2016/05/02.
 */
class RecycleFragmentUi(val delegate: RestApiable) : RestApiable by delegate{


    fun PhotoZoGet(keyword:String,limit:Int){
        Log.d("",keyword)
        delegate.retrofitCall(keyword, limit, {
                it?.let {
                    it?.info.Photo.forEach {
                        Log.d("photozo", it.photo_title)
                    }
                }
        })

    }
}