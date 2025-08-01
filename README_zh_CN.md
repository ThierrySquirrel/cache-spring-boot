# cache-spring-boot-starter

缓存 SpringBoot 版

[English](./README.md)

支持功能：
- [x] 缓存  
- [X] 清除缓存  

# 缓存： 
 提供一级JVM缓存,二级redis缓存  
 可集群使用  
 
# 清除缓存:  
 提供清除缓存注解  
 
## Quick Start

  修改redis.conf  
  修改内容为 notify-keyspace-events "Ex"  

```xml
<!--在pom.xml中添加依赖-->
        <dependency>
            <groupId>io.github.thierrysquirrel</groupId>
            <artifactId>cache-spring-boot-starter</artifactId>
            <version>1.3.0.0-RELEASE</version>
        </dependency>
``` 

 ### 配置文件
 
 ```properties
 ## application.properties
spring.redis.host="127.0.0.1"  redis地址
cache.expiration-time=60  Redis缓存过期时间
 ```

# 缓存 

 ```java
@RestController
public class CacheRestController {
    @GetMapping("/cache")
    @Cache
    public String hello(@CacheParameter @RequestParam String interfaceName,@RequestParam String versionNo,@CacheParameter @RequestParam long timeStamp) {
        System.out.println("SQL");
        return "hello";
    }
}
 ```

# 清除缓存

 ```java
@RestController
public class ClearCacheRestController {
    @GetMapping("/clear")
    @ClearCache
    public String hello(@CacheParameter @RequestParam String interfaceName,@RequestParam String versionNo,@CacheParameter @RequestParam long timeStamp) {
        return "world";
    }
}
 ```
 
