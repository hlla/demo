package com.google.android.finsky.dc;

import com.google.android.finsky.cg.c;
import com.google.android.finsky.em.g;
import com.google.wireless.android.finsky.b.e;

public final class b
{
  public final c a;
  public final a b;
  public final a c;
  private final com.google.wireless.android.finsky.b.a d;
  private final g e;
  
  public b(c paramc, g paramg)
  {
    this.a = paramc;
    this.d = paramc.i;
    this.e = paramg;
    this.b = a(0);
    this.c = a(1);
  }
  
  private final a a(int paramInt)
  {
    boolean bool = false;
    if (this.d != null)
    {
      int i = 0;
      for (;;)
      {
        localObject = this.d.a;
        if (i >= localObject.length) {
          break label91;
        }
        localObject = localObject[i];
        if (((e)localObject).e == paramInt) {
          break;
        }
        i += 1;
      }
      if (paramInt == 1) {
        bool = true;
      }
      Object localObject = new a(bool, this.a.F, ((e)localObject).j, ((e)localObject).i);
      ((a)localObject).a();
      return (a)localObject;
      label91:
      return null;
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dc/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */