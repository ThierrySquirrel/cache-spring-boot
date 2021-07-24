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
package com.github.thierrysquirrel.cache.core.constant;

/**
 * ClassName: ThreadPoolSizeConstant
 * Description:
 * date: 2020/5/24 3:15
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public enum ThreadPoolSizeConstant {
    /**
     * RedisAsynchronousTaskCorePoolSize
     */
    REDIS_ASYNCHRONOUS_TASK_CORE_POOL_SIZE (Runtime.getRuntime ().availableProcessors () * 2),
    /**
     * RedisAsynchronousTaskMaximumPoolSize
     */
    REDIS_ASYNCHRONOUS_TASK_MAXIMUM_POOL_SIZE (Runtime.getRuntime ().availableProcessors () * 2),
    /**
     * RedisAsynchronousTaskKeepAliveTime
     */
    REDIS_ASYNCHRONOUS_TASK_KEEP_ALIVE_TIME (0),
    /**
     * RedisAsynchronousTaskCapacity
     */
    REDIS_ASYNCHRONOUS_TASK_CAPACITY (1024);
    private final int value;

    ThreadPoolSizeConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
