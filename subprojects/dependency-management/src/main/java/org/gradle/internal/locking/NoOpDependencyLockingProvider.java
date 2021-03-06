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

package org.gradle.internal.locking;

import org.gradle.api.artifacts.component.ModuleComponentIdentifier;
import org.gradle.api.internal.artifacts.dsl.dependencies.DependencyLockingProvider;
import org.gradle.api.internal.artifacts.dsl.dependencies.DependencyLockingState;

import java.util.Collection;

public class NoOpDependencyLockingProvider implements DependencyLockingProvider {

    private static final NoOpDependencyLockingProvider INSTANCE = new NoOpDependencyLockingProvider();

    public static DependencyLockingProvider getInstance() {
        return INSTANCE;
    }

    private NoOpDependencyLockingProvider() {
        // Prevent construction
    }

    @Override
    public DependencyLockingState findLockConstraint(String configurationName) {
        return DefaultDependencyLockingState.EMPTY_LOCK_CONSTRAINT;
    }

    @Override
    public void persistResolvedDependencies(String configurationName, Collection<ModuleComponentIdentifier> resolutionResult) {
        // No-op
    }
}
