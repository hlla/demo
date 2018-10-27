package com.google.android.finsky.e;

import android.text.TextUtils;
import com.google.wireless.android.a.b.a.a.bj;
import com.google.wireless.android.a.b.a.a.bk;

public final class g
{
  public final bj a = new bj();
  
  public g(int paramInt)
  {
    bj localbj = this.a;
    localbj.o = paramInt;
    localbj.a |= 0x2;
  }
  
  public final g a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      bk localbk = new bk();
      localbk.c = paramInt;
      localbk.a |= 0x1;
      localbk.a |= 0x2;
      localbk.b = paramBoolean;
      this.a.h = localbk;
    }
    return this;
  }
  
  public final g a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bj localbj = this.a;
      if (paramString != null)
      {
        localbj.a |= 0x1;
        localbj.g = paramString;
      }
    }
    else
    {
      return this;
    }
    throw new NullPointerException();
  }
  
  public final g a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      bj localbj = this.a;
      if (paramArrayOfByte != null)
      {
        localbj.a |= 0x40;
        localbj.p = paramArrayOfByte;
      }
    }
    else
    {
      return this;
    }
    throw new NullPointerException();
  }
  
  public final g b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bj localbj = this.a;
      if (paramString != null)
      {
        localbj.a |= 0x4;
        localbj.l = paramString;
      }
    }
    else
    {
      return this;
    }
    throw new NullPointerException();
  }
  
  public final g c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bj localbj = this.a;
      if (paramString != null)
      {
        localbj.a |= 0x80;
        localbj.f = paramString;
      }
    }
    else
    {
      return this;
    }
    throw new NullPointerException();
  }
  
  public final g d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bj localbj = this.a;
      if (paramString != null)
      {
        localbj.a |= 0x100;
        localbj.m = paramString;
      }
    }
    else
    {
      return this;
    }
    throw new NullPointerException();
  }
  
  public final g e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a(paramString);
    }
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */