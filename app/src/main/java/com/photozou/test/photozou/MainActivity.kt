package com.photozou.test.photozou

import android.app.FragmentManager
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    val mFragment = RecycleFragment.getInstance()
    val mTag = "RecycleFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        serch.setOnClickListener{mFragment.mfun?.PhotoZoGet(tag.text.toString(),5,mFragment) }

        if (savedInstanceState == null){
            val ft : FragmentManager = fragmentManager
            val f = ft.findFragmentByTag(mTag)
            if (f == null){
                //mFragment = RecycleFragment.getInstance()
                ft.beginTransaction().replace(R.id.container,mFragment,mTag).commit()
            }else {
                mFragment.apply { f as RecycleFragment }
            }
        }
    }

}
