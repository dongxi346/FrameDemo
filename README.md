# FrameDemo 

> 项目为了快速实现使用了很多的 `GitHub` 仓库，在此非常感谢开源的各位大佬。
>
> 这是项目学习组件化开发的一个 `Demo`，虽然是` Demo `，但是组件化开发该有的内容基本都涵盖了。



推荐 [鸿洋的 WanAndroid 网站](https://www.wanandroid.com)，里面有很多干货。

相关的组件化文章介绍在网站里面也有，[点击直达。](https://www.wanandroid.com/article/query?k=%E7%BB%84%E4%BB%B6%E5%8C%96)

组件化开发，网上已经很多文章在写，我这里就不赘述。



## 什么样的项目才算组件化开发？

> 刚开始学习组件化开发，看到好多文章都写着组件化开发，但是大部分都是只有一个 `App` 组件，其他基本都是 `Lib` 组件，没有过多的参考价值。`Lib` 组件和 `App` 组件的差别在于，`Lib`组件不能独立运行，而 `App`组件能够独立运行。



## 如何实现组件化开发？

> 组件化开发的重点是，每个 独立的组件都是可运行，而组件间是需要相互通信的，那么如何实现呢？
>
> 这里使用了 [ARouter 框架](https://github.com/alibaba/ARouter) 进行组件间的通信。



组件化开发的好处就是，我们只要把框架搭建好，把` lib_common` 组件维护好，以后开发直接就是编写一个个的 `App` 组件，或者直接复用以前的 `App `组件。



**组件化的实施步骤**

- 新建空的项目，会创建 `app` 组件

- 新建 `config.gradle`。非必须，作用是为了更好的维护`gradle`中的仓库版本
- 新建 `lib_common` 库组件。组件开发中的所有基类，工具类都可以存放在这
- 串联 `app` 组件和其他组件、以及让其他组件能够独立运行。**（重难点）**。
- 新建 `module_xxx` 组件名字。具体的某个组件，比如：`module_usercenter`组件表示为用户中心



## WanAndroid 组件化开发实例

项目使用 `Kotlin + MVP` 模式开发，封装了`BaseActivity、BaseFragment、IBaseView、IPresenter`等基类，在`lib_common`组件的`utils`包中还包含了很多的工具类。



项目常用的一些功能：

- 网络请求框架：`RxJava2 + Retrofit2`，或者其他
- 日志打印：`Logger` 或者自己实现的日志工具
- 权限管理：`easyPermission`库，或者其他
- 组件路由：`ARouter`，或者其他
- 升级、崩溃统计：`Bugly`，或者其他
- 列表 `adapter`：非必须，`BRVAH`或者其他
- 图片加载：非必须，`Glide`或者其他
- 数据库：`Room`



### 用户中心

> 几乎每个应用必有的用户中心，用户中心涉及到的相关功能有：
>
> 注册功能、登录功能、退出功能、用户登录互斥功能、记住密码功能



**注册登录功能**

这里使用了 `鸿洋大佬的 WanAndroid 提供的 API` ，非常感谢

PS：大家在使用的使用也尽量少注册一些脏数据。







### 首页

> Banner + 文章列表



### 搜索

> 搜索热词+历史搜索+搜索列表



### 相关组件

> 下载文件组件、地图组件、分享组件




