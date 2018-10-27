package com.google.android.finsky.bf;

import android.content.Context;
import com.google.android.finsky.dc.a;
import com.google.wireless.android.finsky.b.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class h
  extends f
{
  private final Context a;
  private final File k;
  private final int l;
  private final a m;
  private final boolean n;
  
  public h(Context paramContext, String paramString1, String paramString2, a parama, e parame, int paramInt, File paramFile, boolean paramBoolean)
  {
    super(paramString1, paramString2, parame.i, parame.f, "", parame.d, g.a(parame), parame.h, parame.g);
    this.m = parama;
    this.a = paramContext;
    this.k = paramFile;
    this.l = paramInt;
    this.n = paramBoolean;
  }
  
  public final String a(String paramString)
  {
    return this.a.getString(2131952761, new Object[] { paramString });
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream.flush();
    paramOutputStream.close();
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
    try
    {
      int i = this.l;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean d()
  {
    return true;
  }
  
  public final boolean e()
  {
    return this.n;
  }
  
  public final boolean f()
  {
    return true;
  }
  
  public final OutputStream g()
  {
    return new FileOutputStream(i());
  }
  
  public final void h()
  {
    i().delete();
  }
  
  public final File i()
  {
    return this.m.b();
  }
  
  public final a j()
  {
    return this.m;
  }
  
  public final boolean k()
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */