package com.google.android.finsky.dg;

import android.graphics.Bitmap;
import com.google.android.finsky.ds.a.fa;
import com.google.android.finsky.utils.FinskyLog;
import java.io.IOException;
import java.util.HashMap;

final class p
  implements Runnable
{
  p(f paramf, String paramString1, long paramLong, String paramString2, Bitmap paramBitmap, int paramInt1, int paramInt2, fa paramfa, int paramInt3, boolean paramBoolean) {}
  
  public final void run()
  {
    try
    {
      if (!this.a.h.containsKey(this.h))
      {
        this.a.a(this.h, this.g, this.j, this.b, this.e, this.f, this.d, this.i, this.c);
        return;
      }
      FinskyLog.a("Session for %s already exists, skipping creation", new Object[] { this.h });
      return;
    }
    catch (IOException localIOException)
    {
      FinskyLog.a(localIOException, "Couldn't create session for %s: %s", new Object[] { this.h, localIOException.getMessage() });
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */