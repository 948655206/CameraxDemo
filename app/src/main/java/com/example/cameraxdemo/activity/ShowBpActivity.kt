package com.example.cameraxdemo.activity

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.cameraxdemo.R
import com.example.cameraxdemo.databinding.ActivityShowBpBinding
import com.example.lib_base.base.BaseActivity
import com.example.lib_camerax.CameraxHelper

class ShowBpActivity : BaseActivity<ActivityShowBpBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityShowBpBinding
        get() = ActivityShowBpBinding::inflate


    override fun initView() {
        super.initView()


        intent.extras?.also {
            val imagePath = it.getString("imagePath")
            imagePath?.let { it1 ->
                mBinding.image.setImageBitmap(CameraxHelper.getCorrectlyOrientedBitmap(it1))
            }
        }
    }

    companion object {
        fun start(context: Context, bundle: Bundle) {
            context.startActivity(
                Intent(context, ShowBpActivity::class.java).apply {
                    putExtras(bundle)
                }
            )
        }
    }

}