#container-cache

cache

[中文](./README_zh_CN.md)

Support function:

- [x] Cache
- [X] ClearCache

# Cache：

Provide Level 1 JVM Cache
Databases and Redis should store tokens instead of caches

# ClearCache:

Provide Clear Cache Annotation

## Quick Start

```xml
<!--Adding dependencies to pom. XML-->
<dependency>
    <groupId>io.github.thierrysquirrel</groupId>
    <artifactId>container-cache-loading</artifactId>
    <version>1.0.0.0-RELEASE</version>
</dependency>
``` 

### configuration file

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

# Cache

# ClearCache

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
 

 
