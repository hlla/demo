package com.google.android.finsky.av;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  public final int a;
  private final Map b;
  
  k(l paraml)
  {
    this.a = paraml.b;
    paraml = paraml.a.entrySet().iterator();
    this.b = new HashMap();
    while (paraml.hasNext())
    {
      Entry localEntry = (Entry)paraml.next();
      List localList = Collections.unmodifiableList((List)localEntry.getValue());
      this.b.put((String)localEntry.getKey(), localList);
    }
  }
  
  public final List a(String paramString)
  {
    if (!this.b.containsKey(paramString)) {
      return Collections.emptyList();
    }
    return (List)this.b.get(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/av/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */