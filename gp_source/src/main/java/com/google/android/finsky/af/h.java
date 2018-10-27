package com.google.android.finsky.af;

import com.google.android.finsky.utils.FinskyLog;
import java.util.concurrent.ExecutionException;

public final class h
{
  public static Object a(e parame)
  {
    try
    {
      parame = parame.get();
      return parame;
    }
    catch (InterruptedException parame)
    {
      FinskyLog.b(parame, "Unexpected exception: %s", new Object[] { parame.getMessage() });
      return null;
    }
    catch (ExecutionException parame)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */