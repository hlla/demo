package com.google.android.play.image;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.play.utils.b.a;
import com.google.android.play.utils.b.j;

public final class bz
{
  private int a;
  private boolean b;
  private Runnable c = new ca();
  private Handler d;
  private HandlerThread e;
  
  public bz()
  {
    boolean bool;
    if (Runtime.getRuntime().availableProcessors() > 1) {
      if (((Boolean)j.L.b()).booleanValue()) {
        bool = true;
      }
    }
    for (;;)
    {
      this.b = bool;
      if (this.b)
      {
        this.e = new HandlerThread("tentative-gc-runner", 10);
        this.e.start();
        this.d = new Handler(this.e.getLooper());
      }
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.b)
    {
      this.a += paramInt;
      if ((paramInt > 81920) && (this.a > 524288))
      {
        this.d.post(this.c);
        this.a = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/image/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */