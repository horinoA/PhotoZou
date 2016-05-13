package com.photozou.test.photozou

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_recycleview.*
import java.util.*

/**
 * Created by horinoA on 2016/04/18.
 */
import kotlin.properties.Delegates

class RecycleFragment : Fragment() {

    val TAG = "RecyclerFragmentView"
    val mPhotoTag = "mPhoto"
    var mfun : RecycleFragmentUi? = null
    var mPhoto = ArrayList<Photo>()

    fun RecycleFragment(){}

    companion object {
        fun getInstance() : RecycleFragment {
            return RecycleFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRetainInstance(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mfun = RecycleFragmentUi(RestApi())
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        my_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
        }
        if (savedInstanceState != null){
            val str = savedInstanceState.getString(mPhotoTag)
            val type = object : TypeToken<ArrayList<Photo>>() {}.type
            mPhoto.apply{Gson().fromJson(str,type)}
            Log.d("",mPhoto.toString())
        }
        if (mPhoto != null){
            val adapter = PhotoAdapter(mPhoto, activity.applicationContext)
            my_recycler_view.adapter = adapter
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_recycleview,container,false)
        rootView?.apply { setTag(TAG) }
        return rootView
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.apply {
            val str = Gson().toJson(mPhoto)
            putString(mPhotoTag,str.toString())
        }
    }
}