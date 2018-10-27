package com.google.android.finsky.av;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import com.google.android.finsky.api.i;
import com.google.android.finsky.utils.bg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
{
  public final Map a;
  public final i b;
  public final com.google.android.finsky.dh.a c;
  public final ArrayList d;
  public final com.google.android.finsky.l.k e;
  private final AtomicInteger f;
  private final Handler g;
  
  @SuppressLint({"UseSparseArrays"})
  public a(i parami, com.google.android.finsky.dh.a parama, com.google.android.finsky.l.k paramk)
  {
    this.b = parami;
    this.c = parama;
    this.e = paramk;
    this.f = new AtomicInteger(1);
    this.g = new Handler(Looper.getMainLooper());
    this.d = new ArrayList();
    this.a = new HashMap();
  }
  
  public final int a(h paramh, f paramf)
  {
    bg.a();
    int i = this.f.getAndIncrement();
    paramh = new g(i, paramh, paramf);
    this.d.add(paramh);
    if ((this.d.size() == 1) && (this.a.isEmpty())) {
      a();
    }
    return i;
  }
  
  final void a()
  {
    this.g.post(new b(this));
  }
  
  final void a(g paramg, k paramk)
  {
    this.g.post(new e(this, paramg, paramk));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/av/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */