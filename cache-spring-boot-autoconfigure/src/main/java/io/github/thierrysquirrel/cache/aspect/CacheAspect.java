/**
 * Copyright 2020 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.thierrysquirrel.cache.aspect;

import io.github.thierrysquirrel.cache.core.exception.CacheException;
import io.github.thierrysquirrel.cache.core.factory.AspectFactory;
import io.github.thierrysquirrel.cache.core.factory.execution.CacheAspectFactoryExecution;
import io.github.thierrysquirrel.cache.core.redis.template.CacheRedisTemplate;
import io.github.thierrysquirrel.cache.core.template.CaffeineTemplate;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName: CacheAspect
 * Description:
 * date: 2020/5/24 3:31
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Aspect
@Slf4j
@Data
public class CacheAspect {
    @Autowired
    private CacheRedisTemplate cacheRedisTemplate;
    @Autowired
    private CaffeineTemplate caffeineTemplate;

    @Pointcut("@annotation(io.github.thierrysquirrel.cache.annotation.Cache)")
    public void cachePointcut() {
        log.debug ("Start Cache");
    }

    @Pointcut("@annotation(io.github.thierrysquirrel.cache.annotation.ClearCache)")
    public void clearCachePointcut() {
        log.debug ("Start Clear Cache");
    }

    @Around("cachePointcut()")
    public Object cacheAround(ProceedingJoinPoint proceedingJoinPoint) throws CacheException {
        return CacheAspectFactoryExecution.loadCache (proceedingJoinPoint,
                cacheRedisTemplate,
                caffeineTemplate,
                AspectFactory.paramsAnnotationToString (proceedingJoinPoint));
    }

    @Around("clearCachePointcut()")
    public Object clearCacheAround(ProceedingJoinPoint proceedingJoinPoint) throws CacheException {
        return CacheAspectFactoryExecution.clearCache (proceedingJoinPoint,
                cacheRedisTemplate,
                caffeineTemplate,
                AspectFactory.paramsAnnotationToString (proceedingJoinPoint));
    }
}
