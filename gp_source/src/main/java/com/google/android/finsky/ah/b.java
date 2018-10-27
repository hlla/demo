package com.google.android.finsky.ah;

import java.util.Arrays;

public final class b
{
  public final int a;
  public final int[] b;
  public final int c;
  
  public b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.b = paramArrayOfInt;
    this.a = paramInt1;
    this.c = paramInt2;
  }
  
  public final String toString()
  {
    return String.format("ContentFilterSelection{authorityId=%s, level=%s, documentTypes=%s}", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.c), Arrays.toString(this.b) });
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ah/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */