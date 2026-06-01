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
package io.github.thierrysquirrel.cache.loading.constant;

/**
 * ClassName: CacheLoadingConstant
 * Description:
 * date: 2026/6/2
 *
 * @author ThierrySquirrel
 * @since JDK 25
 */
public class CacheLoadingConstant {
    private CacheLoadingConstant() {
    }

    public static final int DEFAULT_INITIAL_CACHE_CAPACITY = 4096;

    public static final int DEFAULT_MAXIMUM_CACHE_CAPACITY = 8192;

    public static final int DEFAULT_EXPIRATION_TIME = 60 * 10;

}
