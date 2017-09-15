package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;

public final class c<T extends IInterface>
  extends k<T>
{
  private final a.d<T> apO;
  
  public c(Context paramContext, Looper paramLooper, int paramInt, c.b paramb, c.c paramc, h paramh, a.d paramd)
  {
    super(paramContext, paramLooper, paramInt, paramh, paramb, paramc);
    this.apO = paramd;
  }
  
  protected final T f(IBinder paramIBinder)
  {
    return this.apO.jo();
  }
  
  protected final String jm()
  {
    return this.apO.jm();
  }
  
  protected final String jn()
  {
    return this.apO.jn();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */