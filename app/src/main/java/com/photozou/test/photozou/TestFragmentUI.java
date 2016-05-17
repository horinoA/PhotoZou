package com.photozou.test.photozou;

import android.util.Log;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/**
 * Created by horinoA on 2016/05/15.
 */
public class TestFragmentUI {
    protected void test(String keyword, Integer limit,RecycleFragment v){
        RestApi restApi = new RestApi();
        restApi.retrofitCall(keyword, limit, new Function1<mainSerchPhotoZo, Unit>() {
            @Override
            public Unit invoke(mainSerchPhotoZo mainSerchPhotoZo) {
                if (mainSerchPhotoZo != null){
                    for (Photo photo : mainSerchPhotoZo.getInfo().getPhoto()) {
                        Log.d("photoArray",photo.toString());
                    }
                }
                return null;
            }
        });

    }
}
