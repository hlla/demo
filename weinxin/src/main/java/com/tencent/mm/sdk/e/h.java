package com.tencent.mm.sdk.e;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface h
{
  String bKe();
  
  int bKf() default 0;
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */