cl-purchase
==================

采购管理系统


一、前置项目依赖

配置中心：https://github.com/pumadong/cl-privilege
商品中心：https://github.com/pumadong/cl-commodity

二、项目说明

采购中心，基于商品中心，管理采购合同、供应商、采购单、发货单、返厂单，其数据是财务与供应商进行结算的依据。

本系统中关于采购相关表单的建立，并没有考虑的非常完整，只演示比较基本的内容，需要根据实际情况，进行增减。

采购中心，如果把结算部分剥离出去，到一个财务系统中去，内容已经比较少了。

采购单号编码规则：P+年份后两位+月份+日期+两位数字，共9位

发货单号编码规则：3位仓库ID(不足3位0补足)+D+年份后两位+月份+日期+两位数字，共12位

返厂单号编码规则：3位仓库ID(不足3位0补足)+B+年份后两位+月份+日期+两位数字，共12位

三、mybatis-generator

ORM框架采用MyBatis，为了提高开发效率，先根据数据库表单结构自动生成Model和MyBatis相关类，生成命令如下：

java -jar mybatis-generator-core-1.3.1.jar -configfile config_purchase.xml -overwrite

生成时需要把mybatis-generator-core-1.3.1.jar、mysql-connector-java-5.1.24-bin.jar、config_privilege.xml放到一个目录下，生成的相关类和XML会放置到CreateResult文件夹下面。

jar下载地址：http://pan.baidu.com/s/1qW98L0C