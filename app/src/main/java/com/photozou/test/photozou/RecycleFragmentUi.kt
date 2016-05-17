package com.photozou.test.photozou

import android.util.Log
import kotlinx.android.synthetic.main.fragment_recycleview.*
import kotlin.concurrent.thread

/**
 * Created by horinoA on 2016/05/02.
 */
class RecycleFragmentUi(val delegate: RestApiable) : RestApiable by delegate {

    fun PhotoZoGet(keyword: String, limit: Int, v: RecycleFragment) {
        val lody = SpinningProgressDialog.newInstance("test","テスト")
        lody.show(v.activity.fragmentManager,"lody")
        delegate.retrofitCall(keyword, limit, { callback ->
            lody.dismiss()
            callback?.info?.photo?.let { photo ->
                //Testtest
                val test = TestFragmentUI()
                test.test(keyword,limit,v)

                v.mPhoto = photo
                val adapter = PhotoAdapter(photo, v.activity.applicationContext)
                v.my_recycler_view.adapter = adapter
            }
        })

    }

}