package com.google.android.finsky.az;

import com.google.android.finsky.i.f;
import com.google.android.finsky.utils.ao;
import com.google.wireless.android.a.b.a.a.y;

public final class a
{
  private final f a;
  private final com.google.android.finsky.bm.a b;
  private final com.google.android.finsky.cw.a c;
  private final ao d;
  
  public a(com.google.android.finsky.cw.a parama, ao paramao, f paramf, com.google.android.finsky.bm.a parama1)
  {
    this.c = parama;
    this.d = paramao;
    this.a = paramf;
    this.b = parama1;
  }
  
  public final y a()
  {
    int m = 1;
    y localy = new y();
    int i;
    if (this.c.e()) {
      if (!this.c.c()) {
        i = 1;
      }
    }
    for (;;)
    {
      localy.c = i;
      localy.a |= 0x1;
      Boolean localBoolean = this.d.a();
      if (localBoolean != null) {
        if (localBoolean.booleanValue()) {
          i = 2;
        }
      }
      for (;;)
      {
        localy.d = i;
        localy.a |= 0x2;
        int j = this.a.a() ^ true;
        if ((j == 0) || (!this.b.a())) {
          if (j == 0) {
            if (this.d.c()) {
              j = m;
            }
          }
        }
        for (;;)
        {
          localy.b = j;
          localy.a |= 0x4;
          return localy;
          k = 2;
          continue;
          k = 3;
          continue;
          k = 4;
        }
        k = 1;
        continue;
        k = 1;
      }
      int k = 2;
      continue;
      k = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/az/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */