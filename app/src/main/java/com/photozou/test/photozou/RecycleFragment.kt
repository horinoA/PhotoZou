package com.photozou.test.photozou

import android.app.Fragment
import android.os.Bundle

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_recycleview.*
import kotlin.concurrent.thread

/**
 * Created by horinoA on 2016/04/18.
 */
import kotlin.properties.Delegates

class RecycleFragment : Fragment() {

    val TAG = "RecyclerViewFragment"
    var fu : RecycleFragmentUi by Delegates.notNull()

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
        if (savedInstanceState == null) {
            my_recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                itemAnimator = DefaultItemAnimator()
                setHasFixedSize(true)
            }
            val card_view_Array = arrayOf<card_View>(
                    card_View("", "", "Test1", "test1Cap1", "test1cap2"),
                    card_View("", "", "Test2", "test2Cap1", "test2cap2")
            )
            val adapter = CustomAdapter(card_view_Array)
            my_recycler_view.adapter = adapter
            val r : RestApi = RestApi()
            fu = RecycleFragmentUi(r)
            fu.PhotoZoGet("花水木" ,5)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_recycleview,container,false)
        rootView?.apply { setTag(TAG) }
        return rootView
    }
}