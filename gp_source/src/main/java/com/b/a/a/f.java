package com.b.a.a;

public abstract class f
{
  public static f a(Class paramClass)
  {
    if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
      return new a(paramClass.getSimpleName());
    }
    return new c(paramClass.getSimpleName());
  }
  
  public abstract void a(String paramString);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/b/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */