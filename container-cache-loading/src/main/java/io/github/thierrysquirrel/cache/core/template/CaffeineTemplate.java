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
package io.github.thierrysquirrel.cache.core.template;

import com.github.benmanes.caffeine.cache.Cache;
import io.github.thierrysquirrel.cache.core.domain.CacheDomain;
import io.github.thierrysquirrel.cache.core.factory.CacheDomainFactory;

import java.util.Objects;

/**
 * ClassName: CaffeineTemplate
 * Description:
 * date: 2026/6/2
 *
 * @author ThierrySquirrel
 * @since JDK 25
 */
public class CaffeineTemplate {
    private Cache<String, CacheDomain> cache;

    public CaffeineTemplate(Cache<String, CacheDomain> cache) {
        this.cache = cache;
    }

    public void put(String key, Object value) {
        CacheDomain valueCacheDomain = CacheDomainFactory.createValueCacheDomain(value);
        cache.put(key, valueCacheDomain);
    }

    public Object get(String key) {
        CacheDomain ifPresent = cache.getIfPresent(key);
        if (Objects.isNull(ifPresent)) {
            return null;
        }
        return ifPresent.getValue();
    }

    public void invalidate(String key) {
        cache.invalidate(key);
    }

    public Cache<String, CacheDomain> getCache() {
        return cache;
    }

    public void setCache(Cache<String, CacheDomain> cache) {
        this.cache = cache;
    }

    @Override
    public String toString() {
        return "CaffeineTemplate{" +
                "cache=" + cache +
                '}';
    }
}
