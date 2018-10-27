package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;

@a
public final class f
  extends Handler
{
  public f(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    try
    {
      super.dispatchMessage(paramMessage);
      return;
    }
    finally
    {
      n localn = bt.A.e;
      n.m(bt.A.i.b);
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    try
    {
      super.handleMessage(paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      bt.A.i.a(paramMessage, "AdMobHandler.handleMessage");
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */