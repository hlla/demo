package com.google.android.apps.gsa.a.d;

import com.google.android.apps.gsa.a.e.j;
import com.google.common.util.concurrent.bd;
import com.google.common.util.concurrent.t;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public final class d
{
  private final Object a = new Object();
  private final j b;
  private final Set c = Collections.newSetFromMap(new IdentityHashMap());
  
  public d(j paramj)
  {
    bd.e();
    new t();
    this.b = paramj;
  }
  
  public final boolean a(Object paramObject)
  {
    synchronized (this.a)
    {
      this.c.add(paramObject);
      return true;
    }
  }
  
  public final void b(Object paramObject)
  {
    synchronized (this.a)
    {
      if (this.c.remove(paramObject))
      {
        bool = this.c.isEmpty();
        if (bool) {
          this.b.a();
        }
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/apps/gsa/a/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */