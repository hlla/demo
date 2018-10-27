package com.google.android.finsky.be;

import android.content.Context;
import android.os.Bundle;
import com.google.android.finsky.cg.b;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dl.d;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.library.c;
import com.google.android.finsky.permissionui.h;

public final class e
{
  public final b.a a;
  public final String b;
  public final b.a c;
  public final b.a d;
  public final Context e;
  public int f;
  public String g;
  public final b.a h;
  public final c i;
  public final b.a j;
  public com.google.android.finsky.permissionui.a k;
  public final b.a l;
  public final b.a m;
  private final b.a n;
  
  public e(Context paramContext, String paramString, c paramc, b.a parama1, b.a parama2, b.a parama3, b.a parama4, b.a parama5, b.a parama6, b.a parama7, b.a parama8, Bundle paramBundle)
  {
    this.e = paramContext;
    this.b = paramString;
    this.d = parama1;
    this.l = parama2;
    this.h = parama3;
    this.a = parama4;
    this.i = paramc;
    this.j = parama5;
    this.m = parama6;
    this.c = parama7;
    this.n = parama8;
    if (paramBundle == null)
    {
      this.f = 0;
      this.g = null;
      return;
    }
    this.f = paramBundle.getInt("DialogAppsPermissionsModel.state");
    this.g = paramBundle.getString("DialogAppsPermissionsModel.errorMessage");
  }
  
  public final com.google.android.finsky.permissionui.a a(Document paramDocument, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.k == null)
    {
      String str = paramDocument.a.f;
      paramDocument = paramDocument.U().u;
      this.k = ((h)this.n.a()).a(this.e, str, paramDocument, paramBoolean1, paramBoolean2, 2);
    }
    return this.k;
  }
  
  public final void a(Document paramDocument)
  {
    this.l.a();
    d.a((b)this.h.a(), paramDocument.a.f);
  }
  
  public final void a(String paramString)
  {
    this.g = paramString;
    this.f = 2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */