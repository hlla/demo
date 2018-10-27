package com.google.android.finsky.ag;

public abstract class p
{
  public final Object a;
  private f b;
  private final String c;
  
  protected p(f paramf, String paramString, Object paramObject)
  {
    this.b = paramf;
    this.c = paramString;
    this.a = paramObject;
  }
  
  protected abstract q a(String paramString);
  
  public final q b(String paramString)
  {
    String str = String.valueOf(this.c);
    paramString = String.valueOf(paramString);
    if (paramString.length() == 0) {}
    for (paramString = new String(str);; paramString = str.concat(paramString))
    {
      paramString = a(paramString);
      paramString.b = this.b;
      return paramString;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ag/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */