package com.google.android.finsky.bf;

import android.content.Context;
import com.google.android.finsky.dg.c;
import com.google.android.finsky.dg.d;
import com.google.android.finsky.l.a;
import com.google.wireless.android.finsky.b.ah;
import java.io.File;
import java.io.OutputStream;

public final class j
  extends b
{
  private File k;
  private final d l;
  
  public j(Context paramContext, String paramString1, a parama, d paramd, String paramString2, ah paramah)
  {
    super(paramContext, paramString1, parama, paramString2, paramah);
    this.l = paramd;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    this.l.a(paramOutputStream);
  }
  
  public final boolean a(boolean paramBoolean)
  {
    return this.l.a(paramBoolean);
  }
  
  public final boolean d()
  {
    return false;
  }
  
  public final boolean f()
  {
    return this.l.b();
  }
  
  public final OutputStream g()
  {
    c localc = this.l.a(this.h, this.a, this.j);
    this.k = localc.a;
    return localc.b;
  }
  
  public final void h()
  {
    this.l.b(this.h);
  }
  
  public final File i()
  {
    return this.k;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */