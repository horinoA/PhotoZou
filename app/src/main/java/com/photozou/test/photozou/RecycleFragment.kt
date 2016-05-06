package com.photozou.test.photozou

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
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

    val TAG = "RecyclerViewFragment"
    lateinit var mfu : RecycleFragmentUi


    companion object {
        fun getInstance() : RecycleFragment {
            return RecycleFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRetainInstance(true)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        my_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
        }
        val r: RestApi = RestApi()
        mfu = RecycleFragmentUi(r)
        mfu.PhotoZoGet("花水木", 5, this)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_recycleview,container,false)
        rootView?.apply { setTag(TAG) }
        return rootView
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }
}