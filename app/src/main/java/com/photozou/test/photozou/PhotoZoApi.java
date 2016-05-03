package com.photozou.test.photozou;


import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by horinoA on 2016/05/03.
 */
public interface PhotoZoApi {
    @GET("/rest/search_public.json?limit=5")
    Call<mainSerchPhotoZo> getPotoZo(@Query("keyword") String keyword,@Query("limit") Integer limit);

}
