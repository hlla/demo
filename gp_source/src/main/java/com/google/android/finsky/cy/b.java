package com.google.android.finsky.cy;

import com.google.android.finsky.ag.d;
import com.google.android.play.image.bt;
import com.google.android.play.utils.PlayCommonLog;

final class b
  implements bt
{
  b(a parama) {}
  
  public final int a()
  {
    a locala = this.a;
    if (locala.e) {
      return locala.a();
    }
    if (com.google.android.play.utils.c.a.a == null) {
      PlayCommonLog.e("NetworkQualityCache instance is not set in NetworkQualityUtil", new Object[0]);
    }
    for (int i = -1;; i = com.google.android.play.utils.c.a.a.a())
    {
      if (i != -1)
      {
        float f1 = locala.b;
        if (i >= ((Integer)d.em.b()).intValue() + locala.c)
        {
          float f2 = i;
          if (f2 >= ((Integer)d.jh.b()).intValue() * f1)
          {
            if (f2 >= ((Integer)d.fb.b()).intValue() * f1) {
              return 3;
            }
            return 2;
          }
          return 1;
        }
        return 0;
      }
      return locala.a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cy/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */