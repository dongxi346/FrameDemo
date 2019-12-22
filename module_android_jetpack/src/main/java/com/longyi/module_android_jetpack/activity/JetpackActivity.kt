package com.longyi.module_android_jetpack.activity

import android.util.Log
import androidx.navigation.Navigation
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import com.longyi.module_android_jetpack.R
@Route(path = RouterPath.AndroidJetPack.JETPACK_HOME_DEMO,name = "JetPack 使用首页")
class JetpackActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_jetpack
    }

    override fun initView() {

    }

    override fun initData() {

    }

    /**
     * 意味着Activity将它的 back键点击事件的委托出去，如果当前并非栈中顶部的Fragment, 那么点击back键，返回上一个Fragment。
     */
    override fun onSupportNavigateUp() = Navigation.findNavController(
        this,
        R.id.my_nav_host_fragment
    ).navigateUp()


    override fun onResume() {
        super.onResume()
        Log.e("222", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("222", "onPause")

    }
}
