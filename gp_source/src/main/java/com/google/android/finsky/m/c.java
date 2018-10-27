package com.google.android.finsky.m;

import android.content.Context;
import com.google.android.finsky.e.af;
import com.google.android.finsky.utils.bg;
import com.google.android.finsky.utils.i;
import com.google.android.play.utils.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
{
  public final f a;
  public final Map b = new HashMap();
  public final List c = new ArrayList();
  private long d = 0L;
  
  public c(f paramf)
  {
    this.a = paramf;
  }
  
  public final b a(String paramString)
  {
    return (b)this.b.get(paramString);
  }
  
  public final void a(Context paramContext, af paramaf)
  {
    if (this.d < i.a() - ((Long)com.google.android.finsky.ag.d.S.b()).longValue())
    {
      this.d = i.a();
      bg.a(new e(this, paramContext, paramaf), new Void[0]);
    }
  }
  
  public final void a(d paramd)
  {
    this.c.add(paramd);
  }
  
  public final boolean a()
  {
    Map localMap = this.b;
    return (localMap != null) && (!localMap.isEmpty());
  }
  
  public final void b(d paramd)
  {
    this.c.remove(paramd);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/m/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */