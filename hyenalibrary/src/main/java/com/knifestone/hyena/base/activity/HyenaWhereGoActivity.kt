package com.knifestone.hyena.base.activity


import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.knifestone.hyena.R

import com.knifestone.hyena.view.viewgroup.ViewLoading

/**
 * 简介:
 * 显示loading 异常页面的Activity
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
abstract class HyenaWhereGoActivity : HyenaToolbarActivity() {

    //替换页面
    protected var mViewAbnormal: View? = null
    //加载页面
    protected var mViewLoading: ViewLoading? = null
    //初始化的加载
    protected var isInitLoading: Boolean = false

    val isLoading: Boolean
        get() = mViewLoading != null && mViewLoading!!.visibility == View.VISIBLE

    fun showLoading() {
        if (viewAbnormalContainer == null) {
            return
        }
        if (mViewLoading == null) {
            createLoadingView()
            if (mViewLoading != null) {
                viewAbnormalContainer.addView(mViewLoading)
            }
        }
        if (mViewLoading == null) {
            return
        }
        mViewLoading!!.visibility = View.VISIBLE
        mViewLoading!!.onStart()
    }

    fun showLoadingInit() {
        cancelAbnormal()
        cancelContent()
        showLoading()
        isInitLoading = true
    }

    fun cancelLoading() {
        if (viewAbnormalContainer == null) {
            return
        }
        if (mViewLoading != null) {
            mViewLoading!!.onStop()
            mViewLoading!!.visibility = View.GONE
        }
        if (isInitLoading) {
            cancelLoadingInit()
            isInitLoading = false
        } else {
            if (viewContent != null) {
                viewContent.visibility = View.VISIBLE
            }
        }
    }

    fun showContent() {
        cancelLoading()
        cancelAbnormal()
        if (viewContent != null) {
            viewContent.visibility = View.VISIBLE
        }
    }

    fun cancelContent() {
        if (viewContent != null) {
            viewContent.visibility = View.GONE
        }
    }

    fun showEmpty() {
        showAbnormal(null, R.string.hyenaShowEmpty, null, null)
    }

    fun showRetry() {
        showAbnormal(null, null, R.string.hyenaShowRetry, View.OnClickListener { getData() })
    }

    /**
     * 显示异常
     *
     * @param resImgId 提示图片
     * @param resStrId 提示文字
     * @param resbtnId 按钮文字
     * @param listener 按钮监听
     */
    fun showAbnormal(@DrawableRes resImgId: Int?, @StringRes resStrId: Int?, @StringRes resbtnId: Int?, listener: View.OnClickListener?) {
        showAbnormal(resImgId, if (resStrId != null) getString(resStrId) else {
            null
        }, if (resbtnId != null) getString(resbtnId) else {
            null
        }, listener)
    }

    fun showAbnormal(@DrawableRes resImgId: Int?, text: CharSequence?, textBtn: CharSequence?, listener: View.OnClickListener?) {
        cancelLoading()
        cancelContent()
        if (viewAbnormalContainer == null) {
            return
        }
        if (mViewAbnormal == null) {
            mViewAbnormal = LayoutInflater.from(mContext).inflate(com.knifestone.hyena.R.layout.view_abnormal, null)
            viewAbnormalContainer.addView(mViewAbnormal)
        }
        mViewAbnormal!!.visibility = View.VISIBLE
        val ivViewEmpty = mViewAbnormal!!.findViewById<View>(com.knifestone.hyena.R.id.abnormalIv) as ImageView
        if (resImgId == null) {
            ivViewEmpty.visibility = View.GONE
        } else {
            ivViewEmpty.visibility = View.VISIBLE
            ivViewEmpty.setImageResource(resImgId)
        }
        val tvViewEmpty = mViewAbnormal!!.findViewById<View>(com.knifestone.hyena.R.id.abnormalTv) as TextView
        if (text == null) {
            tvViewEmpty.visibility = View.GONE
        } else {
            tvViewEmpty.visibility = View.VISIBLE
            tvViewEmpty.text = text
        }
        val btnViewEmpty = mViewAbnormal!!.findViewById<View>(com.knifestone.hyena.R.id.abnormalBtn) as Button
        if (listener == null) {
            btnViewEmpty.visibility = View.GONE
            btnViewEmpty.setOnClickListener(null)
        } else {
            btnViewEmpty.visibility = View.VISIBLE
            if (textBtn != null) {
                btnViewEmpty.text = textBtn
            }
            btnViewEmpty.setOnClickListener(listener)
        }
    }

    fun cancelAbnormal() {
        if (mViewAbnormal != null) {
            mViewAbnormal!!.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        if (isLoading) {
            cancelLoading()
            onCancelCall()
            return
        }
        super.onBackPressed()
    }

    //创建loading
    protected abstract fun createLoadingView()

    //事件传递下去取消请求
    protected abstract fun onCancelCall()

    //取消初始化
    protected abstract fun cancelLoadingInit()


}
