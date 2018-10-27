package android.support.v4.widget;

import android.support.v4.g.r;
import android.support.v4.g.s;
import android.support.v4.g.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class q
{
  public final v a = new v();
  public final r b = new s(10);
  public final ArrayList c = new ArrayList();
  public final HashSet d = new HashSet();
  
  public final void a(Object paramObject)
  {
    if (!this.a.containsKey(paramObject)) {
      this.a.put(paramObject, null);
    }
  }
  
  public final void a(Object paramObject, ArrayList paramArrayList, HashSet paramHashSet)
  {
    if (!paramArrayList.contains(paramObject))
    {
      if (paramHashSet.contains(paramObject)) {
        throw new RuntimeException("This graph contains cyclic dependencies");
      }
      paramHashSet.add(paramObject);
      ArrayList localArrayList = (ArrayList)this.a.get(paramObject);
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          a(localArrayList.get(i), paramArrayList, paramHashSet);
          i += 1;
        }
      }
      paramHashSet.remove(paramObject);
      paramArrayList.add(paramObject);
    }
  }
  
  public final List b(Object paramObject)
  {
    return (List)this.a.get(paramObject);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */