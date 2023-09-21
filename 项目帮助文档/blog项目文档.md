## 项目开发文档

### 个人博客功能

`<img src="F:\2023个人博客\需求文档\开发架构.jpg" alt="https://atlas.pingcode.com/files/public/6509578dd3f274831a1528f1" style="zoom:40%;" />`{=html}

### 技术组合

-   后端：Spring Boot+JPA+Thymeleaf模板

-   数据库：Mysql

-   前端UI：Semantic UI框架

### 工具与环境

-   IDEA

-   Maven3

-   JDK 8

-   Axure RP-8

### 内容模块

-   需求分析与功能规划

-   页面设计与开发

-   技术框架搭建

-   后端管理功能实现

-   前端管理功能实现

### 学到的东西

-   基于Spring Boot的完全全栈式的开发

-   Semantic UI框架的使用

-   一套博客系统的源代码与设计

-   Github源代码部署

## 需求分析与功能规划

### 1.1 用户故事 {#11-用户故事}

用户故事模板

-   作为一个(某个角色的使用者)，我们可以做(某个功能)事情，如此可以有(某个商业价值)的好处

角色-功能-商业价值

例子：

-作为一个招聘网站注册用户,我想查看最近3天发布的招聘信息,以便于了解罪行的招聘信息

-作为公司,可以粘贴新工作

### 1.2个人博客系统的用户故事1 {#12个人博客系统的用户故事1}

角色： 普通访客-管理员(我)

-   访客：可以分页查看所有的博客

-   访客：可以快速查看博客数最多的6个分类

-   访客：可以查看所有的分类

-   访客：可以查看某个分类下的博客列表

-   访客：可以快速查看标记博客最多的10个标签

-   访客：可以查看所有的bioaqian

-   访客：可以查康某个标签下的博客列表

-   访客：可以根据年度时间线查看博客列表

-   访客：可以快速查看最新的推荐博客

-   访客：可以用关键则全局搜索博客

-   访客：可以查看单个博客内容

-   访客：可以对博客内容进行评论

-   访客：可以赞赏博客内容

-   访客：可以微信扫码阅读博客内容

-   访客：可以再首页扫描公众号二维码关注

-   访客：可以用用户名和密码登录后台管理

-   admin：可以用户名和密码登录后台管理

-   admin：可以管理我的博客

-可以发布新博客

-可以对博客进行分类

-可以对博客打标签

-可以修改博客

-可以删除博客

-可以根据标题，分类，标签查询博客

-   admin：可以管理博客分类

-可以新增一个分类

-可以修改一个分类

-可以删除一个分裂

-可一个更具分类名称查询分类

-   admin：可以管理标签

-可以新增一个表亲啊

-可以修改一个标签

-可以删除一个标签

-可以根据名称查询标签

## 页面设计与开发

-   前端展示：首页，详情页，分类，标签，归档，关于我

-   后台展示：模板页(管理，分类，标签)

### 设计前端(原型页面)页面和手敲前端页面的简要比较：

-   设计前端页面（使用设计工具如Sketch、Adobe XD等）：

 1. 优点：

> 可视化设计，无需编写代码，可以快速创建原型或设计稿。 -
> 可以更好地呈现用户界面和交互体验，方便与设计团队和客户进行交流和反馈。 -
> 可以快速进行修改和迭代，省去编写和调试代码的时间。

2. 缺点：

> 需要学习和使用设计工具，对UI设计有一定的要求。 -
> 开发人员需要将设计稿转化为代码，可能存在一定的差异和调整。 -
> 可能无法完全适应复杂的交互需求和动态数据展示。\`

-   手敲前端页面（纯代码编写）：

    1.  优点：

> 可以更精细地控制界面的表现和交互，适应复杂的需求和动态内容展示。 -
> 开发人员更容易理解和修改代码，对于代码级别的调试和优化更加方便。 -
> 前端开发人员可以更加深入地了解前端技术和实践。

2. 缺点：

> 需要熟悉HTML、CSS和JavaScript等前端技术，以及相关的框架和工具。 -
> 编写和调试代码可能需要更多的时间和工作量。 -
> 在项目需求变更或UI设计调整时，需要手动修改代码并进行重新构建。

`在实践中，很多项目可能会综合使用这两种方法。设计前端页面可以帮助开发团队和设计团队共同理解和讨论，快速创作出原型或设计稿；手敲前端页面则是项目开发的主要环节，将设计转化为可交互、可动态展示的前端界面。选择使用哪种方法，可以根据项目的特点、团队的配合方式和开发流程来决定。`

### 页面开发

-   前端框架：Semantic UI

-   插件集成：

    1.  编辑器Markdown[ 链接 ](https://pandao.github.io/editor.md)

    2.  内容排版typo.css[ 链接 ](https://github.com/sofish/typo.css)

    3.  动画animate.css[ 链接 ](https://daneden.github.io/animate.css)

    4.  代码高亮prism[ 链接 ](https://github.com/PrismIS/prism)

    5.  目录生成Tocbor[ 链接 ](https://tscanlin.github.io/tocbot)

    6.  滚动监听waypoints[ 链接
        ](https://github.com/imakewebthings/waypoints)

    7.  平滑滚动jquery.scrollTo[ 链接
        ](https://github.com/flesler/jquery.scrollTo)

    8.  QR码生成qrcode.js[ 链接
        ](https://davidshimjs.github.io/qrcodejs/)

## 框架搭建

### 1.1：框架搭建 {#11框架搭建}

> 应用工具：IDEA [ 链接 ](https://www.jetbrains.com/zh-cn/idea/)
>
> mysql下载[ 链接
> ](https://github.com/webyog/sqlyog-community/wiki/Downloads)

### 1.2：构建与配置 {#12构建与配置}

1.  引入springboot模板

-   .web

-   Thymeleaf

-   JPA

-   MySQL

-   Aspects

-   DevTools

### 1.3：异常处理 {#13异常处理}

1.  定义错误页面

-   404

-   500

-   error

### 1.4：日志处理 {#14日志处理}

1.  记录日志内容

-   请求url

-   访问者ip

-   调用方法classMethod

-   参数args

-   返回内容

### 1.5：页面处理 {#15页面处理}

1.  静态页面导入project

2.  thymeleaf布局

-   定义fragment

-   使用fragment布局

1.  错误页面美化

## 设计规范

### 1.1：实体设计 {#11实体设计}

-   博客类Blog

-   博客分类Type

-   博客标签Tag

-   博客评论Comment

-   用户user

1.  实体关系

`<img src="F:\2023个人博客\需求文档\实体类\实体关系.png" style="zoom:55%;" />`{=html}

1.  评论类自关联关系

`<img src="F:\2023个人博客\需求文档\实体类\评论表自关联.png" style="zoom:80%;" />`{=html}

1.  blog

    `<img src="F:\2023个人博客\需求文档\实体类\blog.png" style="zoom:55%;" />`{=html}

2.  type

`<img src="F:\2023个人博客\需求文档\实体类\type.png" style="zoom:55%;" />`{=html}

1.  tag

![](F:\2023%E4%B8%AA%E4%BA%BA%E5%8D%9A%E5%AE%A2\%E9%9C%80%E6%B1%82%E6%96%87%E6%A1%A3\%E5%AE%9E%E4%BD%93%E7%B1%BB\tag.png "fig:")

``` 
	5. comment
```

`<img src="F:\2023个人博客\需求文档\实体类\comment.png" style="zoom:55%;" />`{=html}

1.  user

`<img src="F:\2023个人博客\需求文档\实体类\user.png" style="zoom:55%;" />`{=html}

### 1.2应用分层 {#12应用分层}

`<img src="F:\2023个人博客\需求文档\实体类\应用分层.png" style="zoom:55%;" />`{=html}

### 1.3：命名约定\-\--便于更新 {#13命名约定---便于更新}

## 后台管理

### 1.1：登录 {#11登录}

1.  构建登录页面和后台管理页面

2.  UserService和UserRepository

3.  LoginController实现登录

4.  MD5加密

5.  登录拦截器

### 1.2：分类管理 {#12分类管理}

1.  分类管理页面

2.  分类列表分页

    1.  Pageable表数据结构

`<img src="F:\2023个人博客\需求文档\实体类\pageable.png" style="zoom:55%;" />`{=html}

1.  分类新增-修改-删除

### 1.3标签管理和分类管理雷同 {#13标签管理和分类管理雷同}

### 1.4：博客管理 {#14博客管理}

1.  博客分页查询

2.  博客新增

3.  博客修改

4.  博客删除

## 前端展示

### 1.1：首页展示 {#11首页展示}

1.  博客列表

2.  top分类

3.  top标签

4.  最新博客推荐

5.  博客详情

所需插件：Markdown 转 HTML

-   commonmark-java [ https://github.com/atlassian/commonmark-java
    ](https://github.com/atlassian/commonmark-java)

-   pom.xml引用commonmark和插件

``` 
<dependency>
 <groupId>com.atlassian.commonmark</groupId>
 <artifactId>commonmark</artifactId>
 <version>0.10.0</version>
</dependency>
<dependency>
 <groupId>com.atlassian.commonmark</groupId>
 <artifactId>commonmark-ext-heading-anchor</artifactId>
 <version>0.10.0</version>
</dependency>
<dependency>
 <groupId>com.atlassian.commonmark</groupId>
 <artifactId>commonmark-ext-gfm-tables</artifactId>
 <version>0.10.0</version>
</dependency>
```

### 1.2:评论功能 {#12评论功能}

-   评论信息提交和回复功能

-   评论信息列表展示功能

-   管理员回复评论功能

### 1.3：分类页 {#13分类页}

### 1.4：标签页 {#14标签页}

### 1.5：归档页 {#15归档页}

### 1.6：关于我 {#16关于我}

## 项目部署

### 观看教程(资料)：

-   bilibili：【阿里云ECS服务器-在CentOS8中部署spring boot项目】
    <https://www.bilibili.com/video/BV1zB4y1P7HX/?share_source=copy_web&vd_source=e23d3f0ed7022385d6a641cbc20bedf7>

    \<视频虽然无声，但观看这个资料大可完成90%，另外10%就是得对阿里云ESC服务器的操作，配置，说明等方面略微的使用经验\>

> 实验需要的两款软件(自行下载)：
>
> 1.  FileZilla：<http://t.csdn.cn/dg5jh>
>
>     说明：
>
> `<img src="F:\2023个人博客\发布阶段\项目导入引导\项目部署\2023-09-21 10_56_39-云服务器管理控制台 和另外 3 个页面 - CRQYUE - Microsoft Edge Dev.png" style="zoom:40%;" />`{=html}
>
> `<img src="F:\2023个人博客\发布阶段\项目导入引导\项目部署\2023-09-21 10_27_20-sftp___root@47.115.223.137 - FileZilla.png" style="zoom:40%;" />`{=html}
>
> `<img src="F:\2023个人博客\发布阶段\项目导入引导\项目部署\2023-09-21 10_31_48-云服务器管理控制台 和另外 3 个页面 - CRQYUE - Microsoft Edge Dev.png" style="zoom:40%;" />`{=html}
>
> 1.  Termius：<https://www.termius.com/download>
