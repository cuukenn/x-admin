#### 项目

###### 描述

微服务后台管理系统

###### 技术栈

- 核心
  - Spring cloud alibaba
  - LoadBalance
  - FeignClient
- 鉴权
  - Sa-token
  - OAuth
  - IdToken
- 第三方工具
  - HuTool

###### 架构

- 四层架构(与三层架构相比多了一层[manage通用层](https://blog.csdn.net/qq_40542534/article/details/112467861))
  - controller：api交互
  - service：业务逻辑层
  - manage：公共服务实现(传统三层中service中的业务逻辑抽到此层)
  - dao：数据库层

###### 系统模块

```
x-admin   
├── cloud-dependencies  //公共依赖全局版本控制
├── cloud-devtools      //开发工具
├── cloud-framework     //公共组件
│       └── cloud-framework-auth           //认证组件
│       └── cloud-framework-domain         //数据库支持组件
│       └── cloud-framework-domain-mybatis //mybatis支持组件
│       └── cloud-framework-dto            //传输对象组件
│       └── cloud-framework-exception      //异常定义组件
├── cloud-gateway       //网关[gateway.cloud.com]
├── cloud-auth-client   //OAuth客户端[client.auth.cloud.com:8080]
├── cloud-auth-server   //OAuth服务端[server.auth.cloud.com:8081]
├── cloud-services      //子服务集合
│       └── user-service  //用户服务子模块
│               └── user-client  //用户服务对外API
│               └── user-app     //用户服务实现[user.service.cloud.com:8090]
├──pom.xml  //项目依赖
```

###### 依赖服务([此处给出docker安装方法](https://github.com/cuukenn/docker-scripts))

- Alibaba Nacos Server：[如何安装?](https://github.com/cuukenn/docker-scripts/nacos)
- Redis：[如何安装?](https://github.com/cuukenn/docker-scripts/redis)
- MySql：[如何安装?](https://github.com/cuukenn/docker-scripts/mysql)

###### host文件修改(用于cookie多系统作用域传递)

```
# x-admin cloud host
127.0.0.1 gateway.cloud.com
127.0.0.1 client.auth.cloud.com
127.0.0.1 server.auth.cloud.com
127.0.0.1 user.service.cloud.com
```

###### Tips

- 微服务在idea中以services组启动
- 所有微服务本地设置jvm参数：-Xms64m -Xmx128m