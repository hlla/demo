package com.google.android.finsky.cq.d;

import android.support.v7.widget.ds;

 enum h
{
  h() {}
  
  public final boolean a(int paramInt1, int paramInt2, com.google.android.finsky.cq.c.f paramf, ds paramds)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (super.a(paramInt1, paramInt2, paramf, paramds))
    {
      String str = paramf.d(paramInt1, paramds);
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (str.equals(paramf.d(paramInt2, paramds))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cq/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */