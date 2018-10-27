package com.google.android.finsky.bf;

import com.google.wireless.android.finsky.b.a;
import com.google.wireless.android.finsky.b.e;
import com.google.wireless.android.finsky.b.f;

public final class g
{
  static f a(a parama)
  {
    f localf2 = parama.c;
    f localf1 = localf2;
    if (localf2 == null)
    {
      if ((parama.b & 0x20) != 0) {
        localf1 = new f().a(parama.h).a(parama.i).d();
      }
    }
    else {
      return localf1;
    }
    return null;
  }
  
  static f a(e parame)
  {
    if (parame.e()) {
      return new f().a(parame.c).a(parame.b).d();
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */