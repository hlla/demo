package com.google.android.gms.ads.internal.js;

import android.net.Uri;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.gmsg.u;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.a.aa;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.common.util.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

@a
public class l
  implements k
{
  private final Map a = new HashMap();
  public Object c;
  
  private final void a(String paramString, Map paramMap)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        if (!e.a(2)) {
          break;
        }
        localObject = String.valueOf(paramString);
        if (((String)localObject).length() == 0)
        {
          localObject = new String("Received GMSG: ");
          e.a((String)localObject);
          localObject = paramMap.keySet().iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          String str1 = (String)((Iterator)localObject).next();
          String str2 = (String)paramMap.get(str1);
          StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 4 + String.valueOf(str2).length());
          localStringBuilder.append("  ");
          localStringBuilder.append(str1);
          localStringBuilder.append(": ");
          localStringBuilder.append(str2);
          e.a(localStringBuilder.toString());
          continue;
        }
        localObject = "Received GMSG: ".concat((String)localObject);
      }
      finally {}
    }
    paramString = (CopyOnWriteArrayList)this.a.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = (u)paramString.next();
        aa.b.execute(new m(this, (u)localObject, paramMap));
      }
    }
  }
  
  public final void a(String paramString, u paramu)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList2 = (CopyOnWriteArrayList)this.a.get(paramString);
      CopyOnWriteArrayList localCopyOnWriteArrayList1 = localCopyOnWriteArrayList2;
      if (localCopyOnWriteArrayList2 == null)
      {
        localCopyOnWriteArrayList1 = new CopyOnWriteArrayList();
        this.a.put(paramString, localCopyOnWriteArrayList1);
      }
      localCopyOnWriteArrayList1.add(paramu);
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, i parami)
  {
    try
    {
      paramString = (CopyOnWriteArrayList)this.a.get(paramString);
      if (paramString != null)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          u localu = (u)localIterator.next();
          if (parami.a(localu)) {
            localArrayList.add(localu);
          }
        }
        paramString.removeAll(localArrayList);
      }
    }
    finally {}
  }
  
  public final boolean a(Uri paramUri)
  {
    if (("gmsg".equalsIgnoreCase(paramUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramUri.getHost())))
    {
      b(paramUri);
      return true;
    }
    return false;
  }
  
  public final void b(Uri paramUri)
  {
    String str = paramUri.getPath();
    n localn = bt.A.e;
    a(str, n.a(paramUri));
  }
  
  public final void b(String paramString, u paramu)
  {
    try
    {
      paramString = (CopyOnWriteArrayList)this.a.get(paramString);
      if (paramString != null) {
        paramString.remove(paramu);
      }
      return;
    }
    finally {}
  }
  
  public final void c()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean e(String paramString)
  {
    return (paramString != null) && (a(Uri.parse(paramString)));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/js/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */