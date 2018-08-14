# ZhihuRecycler
仿知乎的广告效果

先放一张知乎的广告截图：

![这里写图片描述](https://github.com/zhanglihow/hugo_blog/blob/master/blog/content/img/zhihu_gg_1.gif?raw=true)

说下我的实现吧，主要利用RecyclerView，在需要出现广告的时候，将这个item透明化，显示 ImageView 就达到这种效果了。最主要是这个RecyclerView的分隔条，用了个三方的才最终达到理想的效果。

![这里写图片描述](https://github.com/zhanglihow/hugo_blog/blob/master/blog/content/img/zhihu_gg_2.gif?raw=true)

可能还是会和原知乎有点不一样，图片广告完全没动，所以这只是好奇实现了一下，在网上看到hongyang的实现，自定义了个IamgeView,比较接近了一些。https://github.com/hongyangAndroid/demo_rvadimage
