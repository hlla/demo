package com.google.android.finsky.l;

import android.annotation.SuppressLint;
import com.google.android.finsky.cg.c;

public final class b
{
  public final c a;
  public final String b;
  public final com.google.android.finsky.dh.b c;
  public final String d;
  
  public b(String paramString1, String paramString2, com.google.android.finsky.dh.b paramb, c paramc)
  {
    this.d = paramString1;
    this.b = paramString2;
    this.c = paramb;
    this.a = paramc;
  }
  
  @SuppressLint({"DefaultLocale"})
  public final String toString()
  {
    int j = -1;
    String str1 = this.d;
    String str2 = this.b;
    Object localObject = this.c;
    if (localObject != null) {}
    for (int i = ((com.google.android.finsky.dh.b)localObject).f;; i = -1)
    {
      localObject = this.a;
      if (localObject != null) {
        j = ((c)localObject).n;
      }
      return String.format("{package=%s nodeid=%s installed=%d desired=%d}", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(j) });
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/l/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */