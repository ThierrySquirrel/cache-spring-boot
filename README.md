# cache-spring-boot-starter

cache Spring Book Edition

[中文](./README_zh_CN.md)

Support function:
- [x] Cache  
- [X] ClearCache  

# Cache： 
 Provide Level 1 JVM Cache And Level 2 Redis Cache  
 Can be used in cluster  
 
# ClearCache:  
 Provide Clear Cache Annotation   
 
## Quick Start

  Modify redis.conf  
  Modified As notify-keyspace-events "Ex"  

```xml
<!--Adding dependencies to pom. XML-->
        <dependency>
            <groupId>io.github.thierrysquirrel</groupId>
            <artifactId>cache-spring-boot-starter</artifactId>
            <version>1.3.0.0-RELEASE</version>
        </dependency>
``` 

 ### configuration file
 
 ```properties
 ## application.properties
spring.redis.host="127.0.0.1"  Redis Address
 ```

# Cache 

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

# ClearCache

 ```java
@RestController
public class ClearCacheRestController {
    @GetMapping("/cache")
    @ClearCache
    public String hello(@CacheParameter @RequestParam String interfaceName,@RequestParam String versionNo,@CacheParameter @RequestParam long timeStamp) {
        return "world";
    }
}
 ```
 

 
