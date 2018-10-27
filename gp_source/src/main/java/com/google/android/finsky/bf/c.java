package com.google.android.finsky.bf;

import com.google.android.finsky.dg.d;
import com.google.wireless.android.finsky.b.a;
import java.io.File;
import java.io.OutputStream;

public final class c
  extends f
{
  private final int a;
  private final File k;
  private File l;
  private final d m;
  private final boolean n;
  
  public c(String paramString1, String paramString2, a parama, d paramd, File paramFile, int paramInt, boolean paramBoolean)
  {
    super(paramString1, paramString2, parama.e, parama.j, parama.k, parama.f, g.a(parama), parama.o, parama.n);
    this.m = paramd;
    this.k = paramFile;
    this.a = paramInt;
    this.n = paramBoolean;
  }
  
  public final String a(String paramString)
  {
    return paramString;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    this.m.a(paramOutputStream);
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    return true;
  }
  
  public final File b()
  {
    return this.k;
  }
  
  public final int c()
  {
    return this.a;
  }
  
  public final boolean d()
  {
    return false;
  }
  
  public final boolean e()
  {
    return this.n;
  }
  
  public final boolean f()
  {
    return this.m.b();
  }
  
  public final OutputStream g()
  {
    Object localObject = this.m;
    String str = this.h;
    localObject = ((d)localObject).a(str, str, this.j);
    this.l = ((com.google.android.finsky.dg.c)localObject).a;
    return ((com.google.android.finsky.dg.c)localObject).b;
  }
  
  public final void h()
  {
    this.m.b(this.h);
  }
  
  public final File i()
  {
    return this.l;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */