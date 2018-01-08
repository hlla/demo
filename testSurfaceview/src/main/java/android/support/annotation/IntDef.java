package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface IntDef
{
  boolean flag() default false;
  
  long[] value() default {};
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/android/support/annotation/IntDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */