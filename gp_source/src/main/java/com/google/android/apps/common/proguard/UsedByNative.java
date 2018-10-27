package com.google.android.apps.common.proguard;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.CONSTRUCTOR})
public @interface UsedByNative {}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/apps/common/proguard/UsedByNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */