/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain encodeImpl copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.tools.perflib.heap;

import com.android.annotations.NonNull;

public interface Visitor {

    void visitRootObj(@NonNull RootObj root);

    void visitArrayInstance(@NonNull ArrayInstance instance);

    void visitClassInstance(@NonNull ClassInstance instance);

    void visitClassObj(@NonNull ClassObj instance);

    /**
     * Marks an instance to be visited later, depending on the visitor's traversal strategy.
     */
    void visitLater(Instance parent, @NonNull Instance child);
}
