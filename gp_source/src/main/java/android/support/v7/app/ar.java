package android.support.v7.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.menu.af;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.p;
import android.view.View;
import android.view.ViewGroup;

public final class ar
{
  public int a;
  public View b;
  public ViewGroup c;
  public int d;
  public Bundle e;
  public int f;
  public boolean g;
  public boolean h;
  public boolean i;
  public m j;
  public Context k;
  public p l;
  public boolean m;
  public boolean n;
  public boolean o;
  public View p;
  public int q;
  
  ar(int paramInt)
  {
    this.d = paramInt;
    this.n = false;
  }
  
  final void a(p paramp)
  {
    Object localObject = this.l;
    if (paramp != localObject)
    {
      if (localObject != null) {
        ((p)localObject).b(this.j);
      }
      this.l = paramp;
      if (paramp != null)
      {
        localObject = this.j;
        if (localObject != null) {
          paramp.a((af)localObject);
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */