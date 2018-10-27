package com.google.android.finsky.o;

final class g
  implements a
{
  private final com.google.android.finsky.t.a a;
  private final com.google.wireless.android.finsky.dfe.d.a.c.a.a b;
  
  g(com.google.android.finsky.t.a parama)
  {
    this.a = parama;
    this.b = new com.google.wireless.android.finsky.dfe.d.a.c.a.a();
  }
  
  public final int a()
  {
    return 1;
  }
  
  public final void a(com.google.wireless.android.finsky.dfe.d.a.a.a parama)
  {
    parama.a = this.b;
  }
  
  public final boolean b()
  {
    com.google.wireless.android.finsky.dfe.d.a.c.a.a locala = this.b;
    boolean bool = this.a.a();
    locala.b |= 0x1;
    locala.a = bool;
    return com.google.android.finsky.t.a.a(this.a.c()) ^ true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/o/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */