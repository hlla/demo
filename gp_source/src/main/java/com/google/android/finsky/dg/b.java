package com.google.android.finsky.dg;

import android.content.Context;
import com.google.android.finsky.utils.FinskyLog;
import java.io.File;
import java.io.IOException;

public final class b
{
  public static File a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getCacheDir();
    if (!paramContext.setExecutable(true, false))
    {
      FinskyLog.c("Could not make executable %s", new Object[] { paramContext });
      throw new IOException("Could not make cache dir executable");
    }
    paramContext = new File(paramContext, "copies");
    paramContext.mkdirs();
    if ((paramContext.setExecutable(true, false)) && (paramContext.setReadable(true, false)))
    {
      paramContext = File.createTempFile(paramString, ".apk", paramContext);
      if (!paramContext.setReadable(true, false))
      {
        FinskyLog.c("Could not make readable %s", new Object[] { paramContext });
        paramContext.delete();
        throw new IOException("Could not make destination file writeable");
      }
    }
    else
    {
      FinskyLog.c("Could not make readable %s", new Object[] { paramContext });
      throw new IOException("Could not make destination dir readable");
    }
    return paramContext;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */