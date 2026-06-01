# container-cache

缓存

[English](./README.md)

支持功能：

- [x] 缓存
- [X] 清除缓存

# 缓存：

提供一级JVM缓存
数据库和Redis应该存储令牌而不是缓存

# 清除缓存:

提供清除缓存注解

## Quick Start

```xml
<!--在pom.xml中添加依赖-->
<dependency>
    <groupId>io.github.thierrysquirrel</groupId>
    <artifactId>container-cache-loading</artifactId>
    <version>1.0.0.0-RELEASE</version>
</dependency>
``` 

### 配置文件

 ```properties
 ## Java.ClassLoading
Class.forName=io.github.thierrysquirrel.cache.loading.CacheLoading
Method.setInitialCacheCapacity.int=4096
Method.setMaximumCacheCapacity.int=8192
Method.setExpirationTime.int=600
 ```

 ```java

@ScannerPackage(packageName = "com.hello.world.web.cache")
public class CaffeineRegistrationImpl implements InterfaceManualRegistration {

    @Override
    public void scannerAll(List<Class<?>> scannerClassList, Map<Class<?>, Object> registrationMap) {
        CaffeineRegistration.caffeineRegistrationScannerAll(scannerClassList, registrationMap);
    }
}
 ```

# 缓存

# 清除缓存

 ```java

@JvmCache
public class HelloCache {

    @Cache
    public String cache(@CacheParameter int a) {
        System.out.println("SQL");
        return "JVM cache";
    }

    @Cache
    public String cache(@CacheParameter int a, int b, @CacheParameter String c) {
        System.out.println("CacheParameter SQL");
        return "CacheParameter Cache";
    }

    @ClearCache
    public String clearCache(@CacheParameter int a) {
        System.out.println("clear");
        return "clearCache";
    }
}
 ```

# WEB

 ```java

@Http("/web")
public class HttpDemo {

    @Set
    private HelloCache helloCache;

    @Get("/cache")
    public String cache() {
        return helloCache.cache(1);
    }

    @Get("/clear")
    public String clear() {
        return helloCache.clearCache(1);
    }
}
 ```
 
