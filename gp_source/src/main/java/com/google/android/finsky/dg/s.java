package com.google.android.finsky.dg;

import com.google.android.finsky.utils.FinskyLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class s
  implements Runnable
{
  s(f paramf, List paramList) {}
  
  public final void run()
  {
    Object localObject = new HashSet(this.a.h.keySet());
    ((Set)localObject).removeAll(this.b);
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      FinskyLog.a("Pruning stale session for %s", new Object[] { str });
      this.a.a(str);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */