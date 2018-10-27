package com.google.android.finsky.cd;

import com.google.android.play.image.bz;
import com.google.android.play.image.m;
import com.google.android.play.image.p;
import com.google.android.play.image.s;

public final class b
  extends s
{
  private final c d;
  private final int e;
  private final d f;
  
  protected b(byte[] paramArrayOfByte, m paramm, p paramp, c paramc, bz parambz, d paramd)
  {
    super(paramArrayOfByte, paramm, paramp, parambz);
    this.d = paramc;
    this.f = paramd;
    int i = paramm.e;
    int k = paramm.c;
    int j = paramd.b();
    k = i * k;
    i = k;
    if (k == 0) {
      i = j;
    }
    this.e = Math.min(j, i);
  }
  
  protected final void a(OutOfMemoryError paramOutOfMemoryError)
  {
    this.d.a();
  }
  
  public final void run()
  {
    try
    {
      this.f.a(this.e);
      try
      {
        super.run();
        return;
      }
      finally
      {
        this.f.b(this.e);
      }
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cd/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */