package com.google.android.gms.ads.internal.js;

import com.google.android.gms.ads.internal.gmsg.u;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@a
public final class aw
  implements av, h
{
  private final au a;
  private final HashSet b;
  
  public aw(au paramau)
  {
    this.a = paramau;
    this.b = new HashSet();
  }
  
  public final void a()
  {
    Iterator localIterator = this.b.iterator();
    if (localIterator.hasNext())
    {
      AbstractMap.SimpleEntry localSimpleEntry = (AbstractMap.SimpleEntry)localIterator.next();
      String str = String.valueOf(((u)localSimpleEntry.getValue()).toString());
      if (str.length() == 0) {}
      for (str = new String("Unregistering eventhandler: ");; str = "Unregistering eventhandler: ".concat(str))
      {
        e.a(str);
        this.a.b((String)localSimpleEntry.getKey(), (u)localSimpleEntry.getValue());
        break;
      }
    }
    this.b.clear();
  }
  
  public final void a(String paramString, u paramu)
  {
    this.a.a(paramString, paramu);
    this.b.add(new AbstractMap.SimpleEntry(paramString, paramu));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    i.a(this, paramString1, paramString2);
  }
  
  public final void a(String paramString, Map paramMap)
  {
    i.a(this, paramString, paramMap);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    i.b(this, paramString, paramJSONObject);
  }
  
  public final void b(String paramString, u paramu)
  {
    this.a.b(paramString, paramu);
    this.b.remove(new AbstractMap.SimpleEntry(paramString, paramu));
  }
  
  public final void b(String paramString, JSONObject paramJSONObject)
  {
    i.a(this, paramString, paramJSONObject);
  }
  
  public final void d(String paramString)
  {
    this.a.d(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/js/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */