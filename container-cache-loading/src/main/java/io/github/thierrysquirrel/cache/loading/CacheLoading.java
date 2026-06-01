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
package io.github.thierrysquirrel.cache.loading;

import io.github.thierrysquirrel.cache.loading.constant.CacheLoadingConstant;
import io.github.thierrysquirrel.container.scanner.annotation.ScannerPackage;
import io.github.thierrysquirrel.container.scanner.registration.InterfaceManualRegistration;

import java.util.List;
import java.util.Map;

/**
 * ClassName: CacheLoading
 * Description:
 * date: 2026/6/2
 *
 * @author ThierrySquirrel
 * @since JDK 25
 */
@ScannerPackage(packageName = "io.github.thierrysquirrel.cache.loading")
public class CacheLoading implements InterfaceManualRegistration {


    /**
     * Initial Cache Capacity
     * 缓存初始容量
     */
    private int initialCacheCapacity = CacheLoadingConstant.DEFAULT_INITIAL_CACHE_CAPACITY;
    /**
     * Maximum Cache Capacity
     * 缓存最大容量
     */
    private int maximumCacheCapacity = CacheLoadingConstant.DEFAULT_MAXIMUM_CACHE_CAPACITY;
    /**
     * Expiration Time
     * 过期时间单位秒
     */
    private int expirationTime = CacheLoadingConstant.DEFAULT_EXPIRATION_TIME;

    @Override
    public void scannerAll(List<Class<?>> list, Map<Class<?>, Object> map) {

    }

    public int getInitialCacheCapacity() {
        return initialCacheCapacity;
    }

    public void setInitialCacheCapacity(int initialCacheCapacity) {
        this.initialCacheCapacity = initialCacheCapacity;
    }

    public int getMaximumCacheCapacity() {
        return maximumCacheCapacity;
    }

    public void setMaximumCacheCapacity(int maximumCacheCapacity) {
        this.maximumCacheCapacity = maximumCacheCapacity;
    }

    public int getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(int expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "CacheLoading{" +
                "initialCacheCapacity=" + initialCacheCapacity +
                ", maximumCacheCapacity=" + maximumCacheCapacity +
                ", expirationTime=" + expirationTime +
                '}';
    }
}
