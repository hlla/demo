package com.google.ads.mediation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface p
{
  String a();
  
  boolean b() default true;
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/mediation/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */