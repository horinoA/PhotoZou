package com.photozou.test.photozou

/**
 * Created by horinoA on 2016/05/01.
 */
import android.util.Log
import retrofit.*

class RestApi : RestApiable{

    override fun retrofitCall(keyword:String,limit:Int,callback:(mainSerchPhotoZo?) -> Unit) {
        val retrofit = Retrofit.Builder()
                .baseUrl ("https://api.photozou.jp")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(PhotoZoApi::class.java)
        val call = service.getPotoZo(keyword,limit)
        call.enqueue(object :Callback<mainSerchPhotoZo>{
            override fun onResponse(response: Response<mainSerchPhotoZo>?, retrofit: Retrofit?) {
                response?.let{
                    if (response.body().stat == "ok"){
                        callback(response.body())
                    }else{
                        Log.d("error","stat=faill")
                        callback(null)
                    }
                }
            }
            override fun onFailure(t: Throwable?) {
                Log.d("error","onFaild")
                callback(null)
            }
        })
    }
}

