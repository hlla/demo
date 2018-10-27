package com.b.a.a;

import android.util.Log;

public final class a
  extends f
{
  private String a;
  
  public a(String paramString)
  {
    this.a = paramString;
  }
  
  public final void a(String paramString)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(paramString).length());
    localStringBuilder.append(str);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    Log.d("isoparser", localStringBuilder.toString());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/b/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */