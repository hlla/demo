package com.google.android.play.b;

import com.google.android.play.b.a.n;

public class q
{
  public static final String a = q.class.getSimpleName();
  private static q e = null;
  public final r b = new r(com.google.android.play.b.a.q.class, 60);
  public final r c = new r(n.class, 50);
  public final r d = new r(p.class, 60);
  private final r f = new r(com.google.android.play.b.a.p.class, 60);
  
  public static q a()
  {
    try
    {
      if (e == null) {
        e = new q();
      }
      q localq = e;
      return localq;
    }
    finally {}
  }
  
  public final void a(com.google.android.play.b.a.q paramq)
  {
    Object localObject1 = paramq.j;
    int i = 0;
    while (i < localObject1.length)
    {
      Object localObject2 = localObject1[i];
      ((n)localObject2).c();
      this.c.a(localObject2);
      i += 1;
    }
    paramq.c();
    localObject1 = paramq.f;
    if (localObject1 != null)
    {
      ((com.google.android.play.b.a.p)localObject1).b();
      this.f.a(localObject1);
    }
    this.b.a(paramq);
  }
  
  public final com.google.android.play.b.a.p b()
  {
    return (com.google.android.play.b.a.p)this.f.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */