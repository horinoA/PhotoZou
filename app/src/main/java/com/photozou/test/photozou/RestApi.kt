package com.photozou.test.photozou

/**
 * Created by horinoA on 2016/05/01.
 */
import android.util.Log
import retrofit.GsonConverterFactory
import retrofit.*
import retrofit.Callback

class RestApi : RestApiable{

    override fun retrofitCall(keyword:String,limit:Int,callback:(mainSerchPhotoZo?) -> Unit) {
        val retro = Retrofit.Builder()
                .baseUrl("https://api.photozou.jp")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retro.create(PhotoZoApi::class.java)
        val call = service.getPotoZo(keyword,limit)
        call.enqueue(object : Callback<mainSerchPhotoZo>{
            override fun onResponse(response: Response<mainSerchPhotoZo>?, retrofit: Retrofit?) {
                Log.d("test01",response?.body()?.stat.toString())
                if (response?.body()?.stat == "ok"){
                    callback(response?.body())
                }else{
                    callback(null)
                }
            }
            override fun onFailure(t: Throwable?) {
                callback(null)
            }
        })

    }
}

