package com.example.framedemo

import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.lib_common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import androidx.fragment.app.FragmentPagerAdapter
import com.jaeger.library.StatusBarUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.constant.RouterPath
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.example.lib_common.constant.ParameterConstant.GankPhoto.position
import com.example.lib_common.service.home.IHomeService
import com.example.lib_common.service.user_center.ILoginService
import com.longyi.module_home.data.HomeDataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.logging.Handler
import kotlin.collections.ArrayList


/**
 * 首页
 */
class MainActivity : BaseActivity() {
    private val mFragmentList = ArrayList<Fragment>()
    private val numberBadgeItem = TextBadgeItem()
    private val shapeBadgeItem = ShapeBadgeItem()

    private val mPagerAdapter = object : FragmentPagerAdapter(supportFragmentManager) {
        override fun getItem(position: Int): Fragment { return mFragmentList[position] }
        override fun getCount(): Int { return mFragmentList.size }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

        numberBadgeItem.setBorderWidth(4)
            .setBackgroundColorResource(R.color.colorPrimary)
            .show()

        shapeBadgeItem.setShape(ShapeBadgeItem.SHAPE_STAR_5_VERTICES)
            .setShapeColorResource(R.color.menu_text_color)
            .setGravity(Gravity.TOP or Gravity.END)
            .show()


        bottom_navigation_bar
            .addItem(BottomNavigationItem(R.mipmap.home_select, "Home").setActiveColorResource(R.color.colorAccent).setBadgeItem(numberBadgeItem))
            .addItem(BottomNavigationItem(R.mipmap.course_select, "Course").setActiveColorResource(R.color.colorPrimary).setBadgeItem(shapeBadgeItem))
            .addItem(BottomNavigationItem(R.mipmap.mine_select, "Mine"))
            .setFirstSelectedPosition(0)
            .initialise()

        initListener()


    }

    override fun initData() {
        val mHomeFragment = ARouter.getInstance().build(RouterPath.Home.HOME).navigation() as Fragment
        val mMineFragment = ARouter.getInstance().build(RouterPath.UserCenter.MINE).navigation() as Fragment
        val mCourseFragment = ARouter.getInstance().build(RouterPath.Course.COURSE).navigation() as Fragment
        mFragmentList.add(mHomeFragment)
        mFragmentList.add(mCourseFragment)
        mFragmentList.add(mMineFragment)

        vp_home.adapter = mPagerAdapter

        Observable.intervalRange(0,2,5,0,TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                val homeService = ARouter.getInstance().build("/home_provider/IHomeService").navigation() as IHomeService
                val count = homeService.getFreshCount()
                if (count > 0){
                    numberBadgeItem.setText("$count")
                }
        }

    }

    private fun initListener(){
        bottom_navigation_bar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                vp_home.currentItem = position
                Log.e("222","切换$position")
                numberBadgeItem.hide()
            }
            override fun onTabUnselected(position: Int) {}
            override fun onTabReselected(position: Int) {}
        })

        vp_home.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) { bottom_navigation_bar.selectTab(position) }

        })
    }

    override fun setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, null)
    }

}
