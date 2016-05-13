package com.photozou.test.photozou

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.app.DialogFragment
import android.util.Log

/**
 * Created by horinoA on 2016/05/09.
 */
public class SpinningProgressDialog : DialogFragment(){

    fun SpinningProgressDialog(){}

    companion object {
        fun newInstance(title: String, messe: String): SpinningProgressDialog {
            val fragment = newInstance()
            val args = Bundle()
            args.putString("title", title)
            args.putString("messe", messe)
            fragment.apply { arguments = args }
            return fragment
        }

        fun newInstance():SpinningProgressDialog{
            return SpinningProgressDialog()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?) : Dialog{
        val title = arguments?.getString("title")
        val messe = arguments?.getString("messe")
        val progressDialog:ProgressDialog = ProgressDialog(activity)
        progressDialog.apply {
            setTitle(title)
            setMessage(messe)
            setProgressStyle(ProgressDialog.STYLE_SPINNER)
        }
        return progressDialog
    }

}
