package com.google.android.gms.c;

import android.os.Binder;

public abstract class j<T>
{
  private static final Object agS = new Object();
  public static a azS = null;
  private static int azT = 0;
  private static String azU = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  private T akH = null;
  protected final String azV;
  protected final T azW;
  
  protected j(String paramString, T paramT)
  {
    this.azV = paramString;
    this.azW = paramT;
  }
  
  public static j<Float> a(String paramString, Float paramFloat)
  {
    new j(paramString, paramFloat) {};
  }
  
  public static j<Integer> a(String paramString, Integer paramInteger)
  {
    new j(paramString, paramInteger) {};
  }
  
  public static j<Long> a(String paramString, Long paramLong)
  {
    new j(paramString, paramLong) {};
  }
  
  public static j<Boolean> e(String paramString, boolean paramBoolean)
  {
    new j(paramString, Boolean.valueOf(paramBoolean)) {};
  }
  
  public static boolean isInitialized()
  {
    return azS != null;
  }
  
  public static j<String> j(String paramString1, String paramString2)
  {
    new j(paramString1, paramString2) {};
  }
  
  public static int kL()
  {
    return azT;
  }
  
  public final T get()
  {
    if (this.akH != null) {
      return (T)this.akH;
    }
    return (T)kM();
  }
  
  protected abstract T kM();
  
  public final T kN()
  {
    long l = Binder.clearCallingIdentity();
    try
    {
      Object localObject1 = get();
      return (T)localObject1;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  private static abstract interface a
  {
    public abstract Boolean kO();
    
    public abstract Long kP();
    
    public abstract Integer kQ();
    
    public abstract Float kR();
    
    public abstract String kS();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */