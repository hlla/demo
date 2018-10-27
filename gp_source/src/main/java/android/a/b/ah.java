package android.a.b;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class ah
{
  public final HashMap a = new HashMap();
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((ae)localIterator.next()).a();
    }
    this.a.clear();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */