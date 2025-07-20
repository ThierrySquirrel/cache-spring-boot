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
package io.github.thierrysquirrel.cache.autoconfigure;

import io.github.thierrysquirrel.cache.aspect.CacheAspect;
import io.github.thierrysquirrel.cache.core.factory.CacheRedisTemplateFactory;
import io.github.thierrysquirrel.cache.core.factory.CaffeineTemplateFactory;
import io.github.thierrysquirrel.cache.core.factory.RedisMessageListenerContainerFactory;
import io.github.thierrysquirrel.cache.core.redis.template.CacheRedisTemplate;
import io.github.thierrysquirrel.cache.core.template.CaffeineTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;


/**
 * ClassName: CacheAutoConfiguration
 * Description:
 * date: 2020/5/24 1:32
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
public class CacheAutoConfiguration {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private CacheProperties cacheProperties;

    @Bean
    @ConditionalOnMissingBean(CacheRedisTemplate.class)
    public CacheRedisTemplate cacheRedisTemplate() {
        return CacheRedisTemplateFactory.createCacheRedisTemplate (redisConnectionFactory, cacheProperties);
    }

    @Bean
    @ConditionalOnMissingBean(CaffeineTemplate.class)
    public CaffeineTemplate caffeineTemplate() {
        return CaffeineTemplateFactory.createCaffeineTemplate (cacheProperties);
    }

    @Bean
    @ConditionalOnMissingBean(CacheAspect.class)
    public CacheAspect cacheAspect() {
        return new CacheAspect ();
    }
    @Bean
    @ConditionalOnMissingBean(RedisMessageListenerContainer.class)
    public RedisMessageListenerContainer redisMessageListenerContainer(@Autowired RedisConnectionFactory redisConnectionFactory,@Autowired CaffeineTemplate caffeineTemplate) {
        return RedisMessageListenerContainerFactory.createRedisMessageListenerContainer (redisConnectionFactory, caffeineTemplate);

    }

}
