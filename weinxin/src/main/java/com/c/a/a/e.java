package com.c.a.a;

import android.os.Handler;

abstract class e
{
  private a aJm;
  public long aJn;
  public final Handler handler;
  
  e(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (;;)
    {
      this.handler = paramHandler;
      return;
      paramHandler = new Handler();
    }
  }
  
  final void b(long paramLong1, long paramLong2)
  {
    stop();
    this.aJn = paramLong1;
    this.aJm = new a();
    a locala = this.aJm;
    if ((locala.started) || (locala.aJo)) {
      return;
    }
    locala.aJp.handler.postDelayed(locala, paramLong2);
    locala.started = true;
  }
  
  abstract void ni();
  
  final void stop()
  {
    if (this.aJm != null)
    {
      a locala = this.aJm;
      locala.aJo = true;
      locala.aJp.handler.removeCallbacks(locala);
    }
  }
  
  private final class a
    implements Runnable
  {
    boolean aJo;
    boolean started;
    
    public a() {}
    
    public final void run()
    {
      if (this.aJo) {
        return;
      }
      e.this.ni();
      e.this.handler.postDelayed(this, e.this.aJn);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */