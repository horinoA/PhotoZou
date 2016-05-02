package com.photozou.test.photozou

import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            val mainFragment : RecycleFragment = RecycleFragment()
            val ft : FragmentManager = fragmentManager
            ft.beginTransaction().replace(R.id.container,mainFragment).commit()
        }
        textView1.setText("Test")
    }
}
