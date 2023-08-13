package com.example.cameraxdemo.activity

import android.view.LayoutInflater
import androidx.camera.core.ImageProxy
import androidx.core.os.bundleOf
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.cameraxdemo.databinding.ActivityMainBinding
import com.example.lib_base.base.BaseActivity
import com.example.lib_camerax.CameraxHelper

class MainActivity :
    BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate


    override fun initView() {
        super.initView()
        mBinding.apply {
            toggleBtn.setOnClickListener {
                CameraxHelper.toggleCamera()
            }
            takePhotoBtn.setOnClickListener {
                CameraxHelper.apply {
                    takePhoto(false)
                    setOnTakePhotoListener(object : CameraxHelper.OnTakePhotoListener {
                        override fun success(imagePath: String) {
                            ShowBpActivity.start(this@MainActivity, bundleOf().apply {
                                putString("imagePath",imagePath)
                            })
                        }

                        override fun failure() {
                        }

                    })
                }
            }
            flashBtn.setOnClickListener {
                CameraxHelper.toggleFlashLight()
            }
        }

    }
}