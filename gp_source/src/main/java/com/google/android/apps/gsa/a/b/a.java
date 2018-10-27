package com.google.android.apps.gsa.a.b;

import java.util.concurrent.atomic.AtomicLong;

public final class a
{
  public final AtomicLong a = new AtomicLong(0L);
  public final AtomicLong b = new AtomicLong(0L);
  private final String c;
  
  public a(String paramString)
  {
    this.c = paramString;
  }
  
  public final String toString()
  {
    String str1 = Integer.toHexString(System.identityHashCode(this));
    String str2 = this.c;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 14 + String.valueOf(str2).length());
    localStringBuilder.append("TaskGraph@");
    localStringBuilder.append(str1);
    localStringBuilder.append("(\"");
    localStringBuilder.append(str2);
    localStringBuilder.append("\")");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/apps/gsa/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */