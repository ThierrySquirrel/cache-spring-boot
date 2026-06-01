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
package io.github.thierrysquirrel.cache.registration;

import io.github.thierrysquirrel.cache.annotation.JvmCache;
import io.github.thierrysquirrel.cache.core.factory.CaffeineTemplateFactory;
import io.github.thierrysquirrel.cache.core.template.CaffeineTemplate;
import io.github.thierrysquirrel.cache.loading.CacheLoading;
import io.github.thierrysquirrel.cache.proxy.utils.CaffeineProxyUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName: CaffeineRegistration
 * Description:
 * date: 2026/6/2
 *
 * @author ThierrySquirrel
 * @since JDK 25
 */
public class CaffeineRegistration {

    private CaffeineRegistration() {
    }

    public static void caffeineRegistrationScannerAll(List<Class<?>> scannerClassList, Map<Class<?>, Object> registrationMap) {
        CacheLoading cacheLoading = (CacheLoading) registrationMap.get(CacheLoading.class);
        CaffeineTemplate caffeineTemplate = CaffeineTemplateFactory.createCaffeineTemplate(cacheLoading);
        registrationMap.put(CaffeineTemplate.class, caffeineTemplate);

        for (Class<?> thisClass : scannerClassList) {
            JvmCache jvmCache = thisClass.getAnnotation(JvmCache.class);
            if (Objects.isNull(jvmCache)) {
                continue;
            }
            Object caffeineProx = CaffeineProxyUtils.createCaffeineProxy(thisClass, caffeineTemplate);
            registrationMap.put(thisClass, caffeineProx);
        }

    }

}
