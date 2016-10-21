# DayNightDemo
日夜间模式在app上面的体验不必多说，特别是晚上，所以这玩意儿是个好东西，民间版本的夜间模式实现效果都很友好，但是都很复杂。官方在Android Support Library 23.2开始支持了夜间模式切换，所以大家伙儿不妨试试？

<!-- more -->

## 上代码 [DayNightDemo](https://github.com/paradoxie/DayNightDemo)

## 上效果

![我是图](还没有链接)

## 实践

### **1.关于gradle依赖就不多说了，新建项目就会依赖**

	compile 'com.android.support:appcompat-v7:24.2.1'

### **2.切换主题的activity必须继承自AppCompatActivity**

### **3.使用的主题，把Theme.AppCompat.DayNight作为parent：**

	<style name="AppTheme" parent="Theme.AppCompat.DayNight.DarkActionBar">

### **4.新建value-night文件夹，在此文件夹中准备另一套colors和styles。里面的名字跟对应的value下名字相同，只是值不同，这样系统就会自动获取对应的值了**

### **5.代码部分,想要切换的地方调用：**

	getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);//切换夜间模式
    recreate();//重新启动当前activity

    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);//切换日间模式
   	recreate();//重新启动当前activity


### **6.setLocalNightMode的值的说明：**

* MODE_NIGHT_NO： 使用亮色(light)主题，不使用夜间模式
* MODE_NIGHT_YES：使用暗色(dark)主题，使用夜间模式
* MODE_NIGHT_AUTO：根据当前时间自动切换 亮色(light)/暗色(dark)主题
* MODE_NIGHT_FOLLOW_SYSTEM(默认选项)：设置为跟随系统，通常为MODE_NIGHT_NO
*

### **7.补充一下，如何记录上一次设置的状态，可以用sp记录状态然后进来的时候就读取，具体代码没有，就是任性！**

### **8.补充两下，我看到很多人说这种模式切换会闪屏，怎么优化？先解释一下闪屏原因，因为必须调用recreate方法才能行，也就是说这里的activity重绘了，图中EditText里面的Hint信息也变化了，所以显得两个activity之间切换生硬，所以这里对切换主题的activity设置一个切换动画就行了，效果就是上面的图**

	<item name="android:windowAnimationStyle">@android:style/Animation.Toast</item>

**估计这个是大家最需要的。。。。**

### **9.还有人问到ToolBar中的相关东西怎么修改，这里只说右上角那三个点的menu打开后的背景修改，因为我在这里卡了一下，呃：**

	<!--设置Menu菜单的背景色-->
        <item name="android:itemBackground">@color/bg_content</item>

具体更多的关于ToolBar的移步：[android：ToolBar详解（手把手教程）](http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1118/2006.html)

## 总结

主题模式这个东西涉及的资源本身就很多，需要把每个需要修改的都记录，以便替换另一套修改方案，从另一方面要求了必须把那些资源文件放在value文件夹统一管理，也算是强行纠正一些习惯。


## 《UI篇》拓展阅读：

[《Android APP可能有的东西》之UI篇：加入购物车动画](http://www.jianshu.com/p/c92a89359f53)

[《Android APP可能有的东西》之UI篇：流式标签&搜索历史](http://www.jianshu.com/p/50675a10fce6)


---

> 本文作者：paradoxie

> 个人主页：[谢盒盒的小黑屋，不止说技术](http://www.paradoxie.cf/)

> 简书地址：[简书主页，专注技术类](http://www.jianshu.com/users/05f39939cbf3/latest_articles)

> github地址：[paradoxie](https://github.com/paradoxie)

> 转载请注明出处，蟹蟹!

> -------我的梦想真的是做一条咸鱼！

