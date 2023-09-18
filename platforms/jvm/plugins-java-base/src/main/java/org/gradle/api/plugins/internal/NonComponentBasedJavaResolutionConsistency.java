/*
 * Copyright 2023 the original author or authors.
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

package org.gradle.api.plugins.internal;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.plugins.JavaResolutionConsistency;
import org.gradle.api.tasks.SourceSetContainer;

import javax.inject.Inject;

/**
 * Provides {@link JavaResolutionConsistency} for non-component based Java projects - by working
 * at the {@link org.gradle.api.tasks.SourceSet} level to align the given configurations for
 * consistent resolution directly.
 *
 * Must remain {@code non-final} to be instantiated by {@link ObjectFactory}.
 */
@NonNullApi
public abstract class NonComponentBasedJavaResolutionConsistency extends AbstractJavaResolutionConsistency {
    @Inject
    public NonComponentBasedJavaResolutionConsistency(Configuration mainCompileClasspath, Configuration mainRuntimeClasspath, Configuration testCompileClasspath, Configuration testRuntimeClasspath, SourceSetContainer sourceSets, ConfigurationContainer configurations) {
        super(mainCompileClasspath, mainRuntimeClasspath, testCompileClasspath, testRuntimeClasspath, sourceSets, configurations);
    }
}
