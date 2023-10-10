# <center>香山代码阅读笔记

### 1.文件组织

​	香山的源码位于src/main/xiangshan内，其中有backend、cache、frontend、mem五个文件夹，各个文件夹内所包含的功能模块见下图：

![image-20230831180530948](D:\Projects\nanhu-g-guide\images\structure\image-20230831180530948.png)

​	此外在xiangshan文件夹下还包含一些与香山架构相关的scala文件，里面主要是处理器的配置参数和一些香山特有基础类（如XSModule、XSBundle）的定义。

### 2.文件组织

