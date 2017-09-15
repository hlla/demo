package com.tencent.b.a.a;

import android.content.Context;

public abstract class q
{
  protected Context context = null;
  
  protected q(Context paramContext)
  {
    this.context = paramContext;
  }
  
  protected abstract void a(a parama);
  
  public final void b(a parama)
  {
    if (parama == null) {}
    while (!nK()) {
      return;
    }
    a(parama);
  }
  
  public final void b(g paramg)
  {
    if (paramg == null) {}
    do
    {
      return;
      paramg = paramg.toString();
    } while (!nK());
    write(s.encode(paramg));
  }
  
  protected abstract boolean nK();
  
  protected abstract String nL();
  
  protected abstract a nM();
  
  public final g nS()
  {
    g localg = null;
    if (nK()) {}
    for (String str = s.decode(nL());; str = null)
    {
      if (str != null) {
        localg = g.aI(str);
      }
      return localg;
    }
  }
  
  public final a nT()
  {
    if (nK()) {
      return nM();
    }
    return null;
  }
  
  protected abstract void write(String paramString);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/b/a/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */