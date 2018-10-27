package com.google.android.finsky.bx;

import android.content.Context;
import android.content.IntentFilter;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.gms.car.i;
import com.google.android.gms.car.j;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public final class b
{
  public final CountDownLatch a = new CountDownLatch(1);
  public volatile boolean b = false;
  public final List c = new ArrayList();
  public final Handler d;
  private final Context e;
  private i f;
  private final j g = new g(this);
  private final com.google.android.finsky.ba.a h;
  private final com.google.android.finsky.bo.c i;
  private final com.google.android.finsky.af.c j;
  private com.google.android.finsky.af.e k;
  
  public b(Context paramContext, com.google.android.finsky.ba.a parama, com.google.android.finsky.bo.c paramc, Handler paramHandler, com.google.android.finsky.af.d paramd)
  {
    this.e = paramContext;
    this.h = parama;
    this.i = paramc;
    this.d = paramHandler;
    this.j = paramd.a(Executors.newSingleThreadExecutor(c.a));
  }
  
  private final boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.i.cY().a(12655451L))
    {
      bool1 = bool2;
      if (this.e.getSystemService("usb") != null)
      {
        bool1 = bool2;
        if (com.google.android.finsky.utils.a.d())
        {
          bool1 = bool2;
          if (!this.h.c) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final com.google.android.finsky.af.e a()
  {
    try
    {
      if (this.k == null) {
        this.k = this.j.a(new d(this));
      }
      com.google.android.finsky.af.e locale = this.k.a(e.a);
      return locale;
    }
    finally {}
  }
  
  final Void b()
  {
    int n = 0;
    int i1;
    int m;
    try
    {
      i locali;
      if ((d()) && (this.a.getCount() != 0L) && (this.f == null))
      {
        this.f = new i(this.e, this.g);
        locali = this.f;
        if (!i.a) {
          break label269;
        }
        Object localObject2 = new IntentFilter();
        ((IntentFilter)localObject2).addAction("com.google.android.gms.car.CONNECTED");
        ((IntentFilter)localObject2).addAction("com.google.android.gms.car.DISCONNECTED");
        locali.b.registerReceiver(locali.e, (IntentFilter)localObject2, "com.google.android.gms.permission.CAR", new Handler(locali.c));
        localObject2 = ((UsbManager)locali.b.getSystemService("usb")).getAccessoryList();
        if (localObject2 == null) {
          break label269;
        }
        int i2 = localObject2.length;
        i1 = 0;
        if (n < i2)
        {
          locals = localObject2[n];
          m = i1;
          if (!"Android".equals(locals.getManufacturer())) {
            break label285;
          }
          if ("Android Auto".equals(locals.getModel())) {
            break label294;
          }
          m = i1;
          if (!"Android Open Automotive Protocol".equals(locals.getModel())) {
            break label285;
          }
          m = 1;
          break label285;
        }
        if (i1 == 0) {
          break label269;
        }
        localObject2 = locali.f;
        s locals = locali.g;
        com.google.android.gms.car.d locald = locali.h;
        Looper localLooper = locali.c;
        locali.d = com.google.android.gms.car.a.a(locali.b, (r)localObject2, locals, locald, localLooper);
        locali.d.e();
      }
      for (;;)
      {
        return null;
        label269:
        locali.a(2);
      }
      n += 1;
    }
    finally {}
    for (;;)
    {
      label285:
      i1 = m;
      break;
      label294:
      m = 1;
    }
  }
  
  public final boolean c()
  {
    boolean bool = false;
    if (d()) {}
    try
    {
      this.a.await();
      bool = this.b;
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      FinskyLog.c("Interrupted while awaiting projection result!", new Object[0]);
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bx/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */