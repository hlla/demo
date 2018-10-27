package com.google.android.finsky.dn.a.a;

import android.content.Context;
import com.google.android.finsky.dn.a.a;
import com.google.android.finsky.dn.a.i;
import com.google.android.finsky.dn.f;
import com.google.android.gms.phenotype.core.common.c;

public final class j
  extends a
{
  private final Context a;
  private final c b;
  
  public j(c paramc, i parami, Context paramContext, String paramString, f paramf)
  {
    super(parami, paramString, paramf);
    this.b = paramc;
    this.a = paramContext;
  }
  
  protected final boolean a()
  {
    return this.a.deleteDatabase(this.b.getDatabaseName());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */