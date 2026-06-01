/**
 * Copyright 2026/6/2 ThierrySquirrel
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
 **/
package io.github.thierrysquirrel.cache.proxy;

import io.github.thierrysquirrel.cache.annotation.Cache;
import io.github.thierrysquirrel.cache.annotation.ClearCache;
import io.github.thierrysquirrel.cache.core.factory.AspectFactory;
import io.github.thierrysquirrel.cache.core.factory.execution.CacheAspectFactoryExecution;
import io.github.thierrysquirrel.cache.core.template.CaffeineTemplate;
import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * ClassName: CaffeineProxy
 * Description:
 * date: 2026/6/2
 *
 * @author ThierrySquirrel
 * @since JDK 25
 */
public class CaffeineProxy {

    private CaffeineTemplate caffeineTemplate;

    public CaffeineProxy(CaffeineTemplate caffeineTemplate) {
        this.caffeineTemplate = caffeineTemplate;
    }

    @RuntimeType
    public Object intercept(@This Object proxy, @Origin Method method, @AllArguments Object[] args, @SuperCall Callable<?> callable) throws Exception {
        Cache cache = method.getAnnotation(Cache.class);

        if (!Objects.isNull(cache)) {
            return CacheAspectFactoryExecution.loadCache(callable,
                    caffeineTemplate,
                    AspectFactory.paramsAnnotationToString(method, args));
        }

        ClearCache clearCache = method.getAnnotation(ClearCache.class);
        if (!Objects.isNull(clearCache)) {
            return CacheAspectFactoryExecution.clearCache(callable,
                    caffeineTemplate,
                    AspectFactory.paramsAnnotationToString(method, args));
        }

        return callable.call();
    }

    public CaffeineTemplate getCaffeineTemplate() {
        return caffeineTemplate;
    }

    public void setCaffeineTemplate(CaffeineTemplate caffeineTemplate) {
        this.caffeineTemplate = caffeineTemplate;
    }

    @Override
    public String toString() {
        return "CaffeineProxy{" +
                "caffeineTemplate=" + caffeineTemplate +
                '}';
    }
}
