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

import org.gradle.configuration.internal.UserCodeApplicationId;
import org.gradle.internal.operations.BuildOperationType;

public class ExecuteDomainObjectCollectionCallbackBuildOperationType implements BuildOperationType<ExecuteDomainObjectCollectionCallbackBuildOperationType.Details, ExecuteDomainObjectCollectionCallbackBuildOperationType.Result> {

    public interface Details {

        /**
         * The application ID of the script or plugin that registered the listener.
         *
         * @see org.gradle.api.internal.plugins.ApplyPluginBuildOperationType.Details#getApplicationId()
         * @see org.gradle.configuration.ApplyScriptPluginBuildOperationType.Details#getApplicationId()
         */
        long getApplicationId();

    }

    public interface Result {
    }

    static class DetailsImpl implements ExecuteDomainObjectCollectionCallbackBuildOperationType.Details {
        final UserCodeApplicationId applicationId;

        DetailsImpl(UserCodeApplicationId applicationId) {
            this.applicationId = applicationId;
        }

        @Override
        public long getApplicationId() {
            return applicationId.longValue();
        }

    }

    static final ExecuteDomainObjectCollectionCallbackBuildOperationType.Result RESULT = new ExecuteDomainObjectCollectionCallbackBuildOperationType.Result() {
    };

    private ExecuteDomainObjectCollectionCallbackBuildOperationType() {
    }
}

