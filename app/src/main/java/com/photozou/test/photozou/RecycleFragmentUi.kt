package com.photozou.test.photozou

import android.util.Log
import kotlin.concurrent.thread

/**
 * Created by horinoA on 2016/05/02.
 */
class RecycleFragmentUi(val delegate: RestApiable) : RestApiable by delegate{

    fun PhotoZoGet(keyword:String,limit:Int){
        delegate.retrofitCall(keyword, limit, {callback ->
            callback?.info?.photo?.let {photo->
                photo.forEach { Log.d("title",it.photo_title) }
            }
        })

    }
}