/*
 * Copyright 2010-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.compiler.runner;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface KotlinModuleDescriptionBuilder {
    KotlinModuleDescriptionBuilder addModule(
            String moduleName,
            String outputDir,
            DependencyProvider dependencyProvider,
            List<File> sourceFiles,
            boolean tests,
            Set<File> directoriesToFilterOut
    );

    CharSequence asText();

    interface DependencyProvider {
        void processClassPath(DependencyProcessor processor);
    }

    interface DependencyProcessor {
        void processClassPathSection(String sectionDescription, Collection<File> files, boolean isOwnModule);
        void processAnnotationRoots(List<File> files);
    }
}
