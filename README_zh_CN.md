# 关于
OpenCodeCloud开源项目是一套开源集合。包括基础包、工具包、安全包、令牌包、支付包、excel包等。

开源项目组件做到开箱即用，方便更多开发者省去重复劳动，更专注于业务逻辑代码的编写。

我是 Jon，一个专注于学习和传播技术知识的开发者。希望这些工具包能帮到你，也欢迎任何朋友加入这个开源项目。

项目主页 : https://opencode.cloud

项目 Github : https://github.com/opencodecloud

乔恩的博客 : https://jon.wiki

电子邮件 : ijonso123@gmail.com

# 关于 opencode-base-utils
opencode-base-utils 是一个标准工具库，包含常用的实用工具类，并将继续集成更多可用工具。

# 快速入门
## 第 1 步：设置 pom.xml 添加依赖关系
```
<dependency>
    <groupId>cloud.opencode.base</groupId>
    <artifactId>opencode-base-utils</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 第 2 步 : 没有其他步骤了。尽情享受吧

# 工具列表

### 工厂
### YamlPropertySourceFactory
cloud.opencode.base.factory.YamlPropertySourceFactory

这是一个 yml 配置文件配置工厂。
### 生成器
### IdGenerator
云代码基础生成器 IdGenerator

基于雪花算法修改的分布式 ID 生成器。
## Toolkit
### OssHandler
完整地址： cloud.opencode.base.tool.oss.OssHandler

作用：
阿里云OSS基于STS方式生成stsToken给前端使用。只要配置相关参数即可。
### UploadHandler
完整地址： cloud.opencode.base.tool.upload.UploadHandler

作用：
基于阿里云OSS的文件和图片上传工具类。
图片支持文本水印和图片水印。水印支持9种排列方式。

### QrCodeHandler
完整地址： cloud.opencode.base.tool.qrcode

作用：
二维码生成，读取成文本。

## Util

### CodeCopyUtils
完整地址: cloud.opencode.base.util.CodeCopyUtils

作用：
二次封装BeanUtils.copyProperties，解决null拷贝。
### CodeDateTimeUtils
完整地址： cloud.opencode.base.util.CodeDateTimeUtils

作用：日期格式化工具。
### CodeFileUtils
完整地址： cloud.opencode.base.util.CodeFileUtils

作用：读取文件为字节码或者InputStream。
### CodeHttpUtils
完整地址： cloud.opencode.base.util.CodeHttpUtils

作用：获取http请求的基本信息。
### CodeListUtils
完整地址： cloud.opencode.base.util.CodeListUtils

作用：List的比较和排序。
### CodeMapUtils
完整地址： cloud.opencode.base.util.CodeMapUtils

作用：Map与类的转换（单层，多层）；Map的取值。
### CodeMoneyUtils
完整地址： cloud.opencode.base.util.CodeMoneyUtils

作用：人民币的转换，分转元，元转分，数字进行四舍五入转人民币。

### CodeStringUtils
完整地址： cloud.opencode.base.util.CodeStringUtils

作用：字符串处理。身份证，手机号隐私处理等。