package com.google.android.finsky.bf;

import android.content.Context;
import com.google.android.finsky.dg.c;
import java.io.File;
import java.io.OutputStream;

public final class d
  extends a
{
  private File a;
  private final com.google.android.finsky.dg.d k;
  
  public d(Context paramContext, com.google.android.finsky.l.a parama, com.google.android.finsky.dg.d paramd, String paramString1, String paramString2, com.google.wireless.android.finsky.b.a parama1)
  {
    super(paramContext, parama, paramString1, paramString2, parama1);
    this.k = paramd;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    this.k.a(paramOutputStream);
  }
  
  public final boolean a(boolean paramBoolean)
  {
    return this.k.a(paramBoolean);
  }
  
  public final boolean f()
  {
    return this.k.b();
  }
  
  public final OutputStream g()
  {
    Object localObject = this.k;
    String str = this.h;
    localObject = ((com.google.android.finsky.dg.d)localObject).a(str, str, this.j);
    this.a = ((c)localObject).a;
    return ((c)localObject).b;
  }
  
  public final void h()
  {
    this.k.b(this.h);
  }
  
  public final File i()
  {
    return this.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */