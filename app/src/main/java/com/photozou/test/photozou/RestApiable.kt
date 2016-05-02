package com.photozou.test.photozou

/**
 * Created by horinoA on 2016/05/02.
 */
interface  RestApiable {
    fun retrofitCall(keyword:String,limit:Int,callback:(mainSerchPhotoZo?) -> Unit)
}