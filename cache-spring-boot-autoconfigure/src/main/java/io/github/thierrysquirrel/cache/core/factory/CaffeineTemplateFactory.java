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
package io.github.thierrysquirrel.cache.core.factory;

import com.github.benmanes.caffeine.cache.Cache;
import io.github.thierrysquirrel.cache.autoconfigure.CacheProperties;
import io.github.thierrysquirrel.cache.core.domain.CacheDomain;
import io.github.thierrysquirrel.cache.core.template.CaffeineTemplate;

/**
 * ClassName: CaffeineTemplateFactory
 * Description:
 * date: 2020/5/24 2:54
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class CaffeineTemplateFactory {
    private CaffeineTemplateFactory() {
    }

    public static CaffeineTemplate createCaffeineTemplate(CacheProperties cacheProperties) {
        Cache<String, CacheDomain> caffeine = CaffeineFactory.createCaffeine (cacheProperties);
        return new CaffeineTemplate (caffeine);
    }
}
