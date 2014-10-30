/*
 * Copyright 2014 the original author or authors.
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

package org.gradle.model.internal.manage.schema.store;

import net.jcip.annotations.NotThreadSafe;
import org.gradle.model.internal.core.ModelType;
import org.gradle.model.internal.manage.schema.ModelSchema;

@NotThreadSafe
public class CachingModelSchemaStore implements ModelSchemaStore {

    private final ModelSchemaCache cache = new ModelSchemaCache();
    private final ModelSchemaExtractor extractor;

    public CachingModelSchemaStore(ModelSchemaExtractor extractor) {
        this.extractor = extractor;
    }


    public <T> ModelSchema<T> getSchema(ModelType<T> type) {
        return extractor.extract(type, cache);
    }

}
