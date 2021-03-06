package com.longyi.module_home.contract

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter
import com.example.lib_common.model.Article
import com.example.lib_common.model.Banner
import com.example.lib_common.model.Hotkey

/**
 * 首页 Contract
 */
interface HomeContract {
    interface View : IBaseView {
        /**
         * 显示错误信息
         */
        fun showError(errorMsg:String)

        /**
         * 显示 banner
         */
        fun showBanners(images: MutableList<String>,titles:MutableList<String>)

        /**
         * 显示 hotkey
         */
        fun showHotkeys(hotkeys: MutableList<Hotkey>)

        /**
         * 加载完成显示 article
         */
        fun showLoadCompleteArticles(listArticle: MutableList<Article>)

        /**
         * 全部显示 article
         */
        fun showLoadEndArticles(listArticle: MutableList<Article>)

        /**
         * 点击收藏、取消收藏成功
         */
        fun showBindLikeSuccess(msg:String)
        fun showBindLikeFail(msg:String)
    }

    interface Presenter: IPresenter<View> {

        /**
         * 获取 搜索热词
         */
        fun getHotkey()

        /**
         * 获取 banner
         */
        fun getBanners()
        fun getBannerUrl(position:Int):String

        /**
         * 获取首页文章列表
         */
        fun getArticles(page:Int)

        /**
         * 跳转网页详情
         * url 网址
         */
        fun toWebDetail(position:Int,url:String,id:Int,collect: Boolean)


        fun bindLike(position: Int,id:Int,collect:Boolean)
    }
}