package com.google.android.finsky.aj;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  private final Set a = new HashSet();
  
  public final void a(b paramb)
  {
    synchronized (this.a)
    {
      this.a.add(paramb);
      return;
    }
  }
  
  public final boolean a()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((b)localIterator.next()).a()) {
          return true;
        }
      }
      return false;
    }
  }
  
  public final boolean b()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb.b() == 2) && (localb.a())) {
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aj/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */