# About
OpenCodeCloud open source project is a set of open source collection . Including the base package , toolkit , security package , token package , payment package , excel package and so on.

Open source project components to do out of the box, to facilitate more developers to save duplication of work, more focused on business logic code writing.

I am Jon, a developer who focuses on learning and spreading technical knowledge. I hope these toolkits can help you, and welcome any friends to join this open source project.

project homepage : https://opencode.cloud

project github : https://github.com/opencodecloud

Jon's blog : https://jon.wiki

e-mail: ijonso123@gmail.com

# About opencode-base-utils
opencode-base-utils is a standard tool library that contains commonly used utils classes, and it will continue to integrate more available tools.

# Quick Start
## Step 1: setting the pom.xml add dependency
```
<dependency>
    <groupId>cloud.opencode.base</groupId>
    <artifactId>opencode-base-utils</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Step 2 : No more step. Enjoy it.

# Utils list

## Factory
### YamlPropertySourceFactory
cloud.opencode.base.factory.YamlPropertySourceFactory

This is a yml configuration file configuration factory.
## Generator
### IdGenerator
cloud.opencode.base.generator.IdGenerator

Distributed ID generator, modified based on the snowflake algorithm.
## Toolkit
### OssHandler
cloud.opencode.base.tool.oss.OssHandler

AliCloud OSS generates stsToken for front-end use based on STS approach. Just configure the relevant parameters.
### UploadHandler
cloud.opencode.base.tool.upload.UploadHandler

File and image upload tool class based on Aliyun OSS.
Image supports text watermark and image watermark. The watermark supports 9 kinds of arrangement.

### QrCodeHandler
cloud.opencode.base.tool.qrcode

QR code generation, read into text.

## Util

### CodeCopyUtils
cloud.opencode.base.util.CodeCopyUtils

Secondary wrapper around BeanUtils.copyProperties to resolve null copies.
### CodeDateTimeUtils
cloud.opencode.base.util.CodeDateTimeUtils

Function: Date formatting tool.
### CodeFileUtils
cloud.opencode.base.util.

Read a file as bytecode or InputStream.
### CodeHttpUtils
cloud.opencode.base.util.CodeHttpUtils

Get the basic information of http requests.
### CodeListUtils
cloud.opencode.base.util.CodeListUtils

Comparison and sorting of lists.
### CodeMapUtils
cloud.opencode.base.util.

Function: Map and class conversion (single-level, multi-level); Map fetching.
### CodeMoneyUtils
cloud.opencode.base.util.CodeMoneyUtils

Convert RMB, cents to dollars, dollars to cents, numbers for rounding to RMB.

### CodeStringUtils
cloud.opencode.base.util.CodeStringUtils

String processing. ID, phone number privacy processing, etc.