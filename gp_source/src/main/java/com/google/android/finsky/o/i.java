package com.google.android.finsky.o;

import com.google.wireless.android.finsky.dfe.d.b.a.a;

final class i
{
  public a a;
  public long b;
  
  i(long paramLong, String paramString)
  {
    this.b = paramLong;
    this.a = new a();
    a locala = this.a;
    if (paramString != null)
    {
      locala.a |= 0x1;
      locala.b = paramString;
      return;
    }
    throw new NullPointerException();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/o/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */