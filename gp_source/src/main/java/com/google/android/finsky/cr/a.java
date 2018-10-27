package com.google.android.finsky.cr;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public enum a
  implements com.google.d.a.a.a.a.a.a
{
  public final Set b = new HashSet();
  
  private a() {}
  
  public final void a(long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(paramLong);
    }
  }
  
  public final void a(long paramLong, String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(paramLong, paramString);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cr/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */