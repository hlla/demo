package com.google.android.finsky.o;

import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.android.volley.w;
import com.android.volley.x;
import com.google.android.finsky.ag.c;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.bg;
import com.google.wireless.android.finsky.dfe.d.b.a.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class h
  implements w, x
{
  public final List a = new ArrayList();
  private final com.google.android.finsky.api.d b;
  private int c = 0;
  private boolean d = false;
  
  h(com.google.android.finsky.api.d paramd)
  {
    this.b = paramd;
    paramd = ((Set)c.q.a()).iterator();
    while (paramd.hasNext())
    {
      i locali = a((String)paramd.next());
      if (locali == null) {
        FinskyLog.d("Could not parse stored dismissal token", new Object[0]);
      } else {
        this.a.add(locali);
      }
    }
  }
  
  private static i a(String paramString)
  {
    int i;
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.indexOf(':');
      if (i >= 0)
      {
        j = i + 1;
        if (j == paramString.length()) {}
      }
    }
    try
    {
      paramString = new i(Long.parseLong(paramString.substring(0, i)), paramString.substring(j));
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
    return null;
    return null;
    return null;
  }
  
  final void a()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (i)localIterator.next();
      String str = Long.toString(((i)localObject).b);
      localObject = ((i)localObject).a.b;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(localObject).length());
      localStringBuilder.append(str);
      localStringBuilder.append(':');
      localStringBuilder.append((String)localObject);
      localHashSet.add(localStringBuilder.toString());
    }
    c.q.a(localHashSet);
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    bg.a();
    long l = com.google.android.finsky.utils.i.a();
    paramVolleyError = this.a.subList(0, this.c).iterator();
    while (paramVolleyError.hasNext()) {
      if (l > ((i)paramVolleyError.next()).b + ((Long)com.google.android.finsky.ag.d.W.b()).longValue()) {
        paramVolleyError.remove();
      }
    }
    a();
    this.c = 0;
    if (this.d) {
      b();
    }
  }
  
  final void b()
  {
    
    if (this.c > 0)
    {
      FinskyLog.b("Not sending dismissed tokens because another request is already in flight.", new Object[0]);
      this.d = true;
      return;
    }
    if (this.a.isEmpty())
    {
      FinskyLog.b("Tried sending a dismiss request without any tokens to send.", new Object[0]);
      return;
    }
    this.d = false;
    this.c = this.a.size();
    com.google.wireless.android.finsky.dfe.d.b.a.a[] arrayOfa = new com.google.wireless.android.finsky.dfe.d.b.a.a[this.c];
    int i = 0;
    while (i < this.c)
    {
      arrayOfa[i] = ((i)this.a.get(i)).a;
      i += 1;
    }
    b localb = new b();
    localb.a = arrayOfa;
    this.b.a(localb, this, this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/o/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */