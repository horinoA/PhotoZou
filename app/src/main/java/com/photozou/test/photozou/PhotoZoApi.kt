package com.photozou.test.photozou

import retrofit.http.GET
import retrofit.Call
import retrofit.http.Query
/**
 * Created by horinoA on 2016/04/30.
 */
open interface PhotoZoApi {

    @GET("rest/search_public.json")
    open fun getPotoZo(@Query("keyword") keyword : String , @Query("limit") limit: Int) : Call<mainSerchPhotoZo>
}