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
package io.github.thierrysquirrel.cache.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * ClassName: ClearCache 
 * Description: 
 * date: 2020/5/24 3:31
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface ClearCache {
}
