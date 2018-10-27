package com.google.android.finsky.be;

import android.os.Bundle;
import android.view.View;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.e.aq;
import com.google.wireless.android.finsky.dfe.e.a.en;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class y
{
  public final Set a = new HashSet();
  private final boolean b;
  private final q c;
  private boolean d;
  private boolean e;
  private final Map f = new HashMap();
  private final Map g = new HashMap();
  private final Map h = new HashMap();
  private final Map i = new HashMap();
  
  public y(q paramq, Bundle paramBundle, f paramf)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("DialogVisibilityModel.tags")))
    {
      this.a.addAll(paramBundle.getStringArrayList("DialogVisibilityModel.tags"));
      this.e = true;
    }
    this.b = paramf.a(12652598L);
    this.c = paramq;
  }
  
  private final void a(Map paramMap)
  {
    if (!this.e)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      boolean bool1 = false;
      if (localIterator.hasNext())
      {
        Object localObject2 = (Entry)localIterator.next();
        Object localObject1 = (String)((Entry)localObject2).getKey();
        localObject2 = (Boolean)((Entry)localObject2).getValue();
        if (((Boolean)localObject2).booleanValue()) {}
        for (boolean bool2 = this.a.remove(localObject1);; bool2 = this.a.add(localObject1))
        {
          boolean bool3;
          if (bool2)
          {
            bool3 = ((Boolean)localObject2).booleanValue();
            localObject1 = (List)this.g.get(localObject1);
            if (localObject1 != null) {
              break label127;
            }
          }
          for (;;)
          {
            bool1 |= bool2;
            break;
            label127:
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((z)((Iterator)localObject1).next()).a(bool3);
            }
          }
        }
      }
      if ((this.d) && (bool1)) {
        a(paramMap.keySet(), false);
      }
    }
  }
  
  private final void a(Set paramSet, boolean paramBoolean)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Object localObject = (String)paramSet.next();
      localObject = (Set)this.f.get(localObject);
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        label57:
        View localView;
        int k;
        if (((Iterator)localObject).hasNext())
        {
          localView = (View)((Iterator)localObject).next();
          HashSet localHashSet = new HashSet((Collection)this.h.get(localView));
          localHashSet.retainAll(this.a);
          k = localView.getVisibility();
          if (localHashSet.isEmpty()) {
            break label181;
          }
        }
        label181:
        for (int j = 8;; j = 0)
        {
          localView.setVisibility(j);
          if ((paramBoolean) || (k == 0) || (localView.getVisibility() != 0)) {
            break label57;
          }
          this.c.a((aq)this.i.get(localView));
          break label57;
          break;
        }
      }
    }
  }
  
  public final void a()
  {
    this.e = false;
    this.d = true;
    Object localObject1 = new HashMap();
    Object localObject2 = this.a.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Map)localObject1).put((String)((Iterator)localObject2).next(), Boolean.valueOf(false));
    }
    if (!((Map)localObject1).isEmpty()) {
      a(((Map)localObject1).keySet(), true);
    }
    localObject1 = this.i.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (View)((Iterator)localObject1).next();
      if (((View)localObject2).getVisibility() == 0) {
        this.c.a((aq)this.i.get(localObject2));
      }
    }
  }
  
  public final void a(View paramView, en paramen, aq paramaq)
  {
    if (paramen != null)
    {
      String[] arrayOfString = paramen.D;
      int k = arrayOfString.length;
      if (k != 0)
      {
        int j = 0;
        while (j < k)
        {
          String str = arrayOfString[j];
          if (!this.f.containsKey(str)) {
            this.f.put(str, new HashSet());
          }
          ((Set)this.f.get(str)).add(paramView);
          if (!this.h.containsKey(paramView)) {
            this.h.put(paramView, new HashSet());
          }
          ((Set)this.h.get(paramView)).add(str);
          if (paramaq != null) {
            this.i.put(paramView, paramaq);
          }
          if ((paramen.f & 0x2000) == 0)
          {
            j += 1;
          }
          else
          {
            if (paramen.E == 1) {}
            for (boolean bool = true;; bool = false)
            {
              a(str, bool);
              break;
            }
          }
        }
      }
    }
  }
  
  public final void a(String paramString, z paramz)
  {
    if (!this.g.containsKey(paramString)) {
      this.g.put(paramString, new ArrayList());
    }
    ((List)this.g.get(paramString)).add(paramz);
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, Boolean.valueOf(paramBoolean));
    a(localHashMap);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.e = true;
    }
    for (;;)
    {
      this.f.clear();
      this.h.clear();
      this.g.clear();
      this.i.clear();
      this.d = false;
      return;
      if ((!this.e) && (this.b)) {
        this.a.clear();
      }
    }
  }
  
  public final void a(String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    int k = paramVarArgs.length;
    int j = 0;
    if (j < k)
    {
      String str = paramVarArgs[j];
      if (str == null) {}
      for (;;)
      {
        j += 1;
        break;
        if (this.a.contains(str)) {
          localHashMap.put(str, Boolean.valueOf(true));
        } else {
          localHashMap.put(str, Boolean.valueOf(false));
        }
      }
    }
    a(localHashMap);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */