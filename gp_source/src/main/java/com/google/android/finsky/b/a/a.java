package com.google.android.finsky.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.y;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements h
{
  public final Context a;
  public final List b = new ArrayList();
  public final CharSequence c;
  public final aq d;
  private i e;
  private j f;
  private com.google.android.finsky.layout.structuredreviews.a g;
  
  public a(Context paramContext, byte[] paramArrayOfByte, CharSequence paramCharSequence, aq paramaq)
  {
    this.a = paramContext;
    this.c = paramCharSequence;
    this.d = new y(a(), paramArrayOfByte, paramaq);
  }
  
  protected abstract int a();
  
  public void a(Bundle paramBundle) {}
  
  public final void a(i parami)
  {
    this.e = parami;
  }
  
  public final void a(j paramj)
  {
    this.f = paramj;
  }
  
  public final void a(k paramk)
  {
    if (!this.b.contains(paramk)) {
      this.b.add(paramk);
    }
  }
  
  public final void a(com.google.android.finsky.layout.structuredreviews.a parama)
  {
    this.g = parama;
  }
  
  protected final void a(String paramString, int paramInt1, int paramInt2)
  {
    int i = this.b.size() - 1;
    while (i >= 0)
    {
      ((k)this.b.get(i)).a(this, paramString, paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public final void b()
  {
    this.d.getParentNode().a(this.d);
  }
  
  public final void b(k paramk)
  {
    this.b.remove(paramk);
  }
  
  public final aq c()
  {
    return this.d;
  }
  
  protected final void d()
  {
    i locali = this.e;
    if (locali != null) {
      locali.a();
    }
  }
  
  public CharSequence e()
  {
    return this.a.getResources().getString(2131953381);
  }
  
  public final void f()
  {
    com.google.android.finsky.layout.structuredreviews.a locala = this.g;
    if (locala != null) {
      locala.b();
    }
  }
  
  public final void g() {}
  
  public final void h()
  {
    j localj = this.f;
    if (localj != null) {
      localj.a(this);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */