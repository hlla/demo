package com.google.android.finsky.t;

import com.google.android.finsky.ag.c;
import com.google.android.finsky.ag.q;
import com.google.wireless.android.finsky.dfe.i.a.e;
import com.google.wireless.android.finsky.dfe.i.a.h;

public final class a
{
  private final com.google.android.finsky.devicemanagement.a a;
  
  public a(com.google.android.finsky.devicemanagement.a parama)
  {
    this.a = parama;
  }
  
  public static void a(boolean paramBoolean)
  {
    c.r.a(Boolean.valueOf(paramBoolean));
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 3) || (paramInt == 2);
  }
  
  public static void b(boolean paramBoolean)
  {
    c.s.a(Boolean.valueOf(paramBoolean));
  }
  
  public final boolean a()
  {
    int i = c();
    if (!a(i)) {
      return ((Boolean)c.r.a()).booleanValue();
    }
    return i != 2;
  }
  
  public final boolean b()
  {
    int i = c();
    if (!a(i)) {
      return ((Boolean)c.s.a()).booleanValue();
    }
    return i == 3;
  }
  
  public final int c()
  {
    Object localObject2 = null;
    Object localObject3 = this.a;
    Object localObject1 = localObject2;
    if (((com.google.android.finsky.devicemanagement.a)localObject3).a())
    {
      localObject3 = ((com.google.android.finsky.devicemanagement.a)localObject3).g();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = ((e)localObject3).e;
        if (localObject1 != null) {
          break label49;
        }
        localObject1 = localObject2;
      }
    }
    label49:
    for (;;)
    {
      if (localObject1 != null) {
        return ((h)localObject1).a;
      }
      return 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/t/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */