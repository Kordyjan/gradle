/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal;

import org.gradle.internal.service.ServiceRegistry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class IdentityClassGenerator implements ClassGenerator {
    @Override
    public <T> Class<? extends T> generate(Class<T> type) {
        return type;
    }

    @Override
    public <T> T newInstance(Constructor<T> constructor, ServiceRegistry services, Object[] params) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        return constructor.newInstance(params);
    }
}
