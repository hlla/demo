package com.tencent.mm.loader.stub;

import android.content.Context;
import android.os.Environment;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import java.io.File;

public class a
{
  public static final String hgf;
  public static final String hgg = hgf + "MicroMsg/";
  public static final String hgh;
  public static String hgi;
  public static String hgj;
  public static String hgk;
  public static String hgl;
  
  static
  {
    GMTrace.i(14008975360000L, 104375);
    Object localObject = aa.getContext();
    if (localObject == null) {
      throw new RuntimeException("MMApplicationContext not initialized.");
    }
    hgf = ((Context)localObject).getFilesDir().getParentFile().getAbsolutePath() + "/";
    try
    {
      localObject = new File(hgg);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      hgh = hgf + "files/public/";
      hgi = Environment.getExternalStorageDirectory().getAbsolutePath();
      hgj = "/tencent/MicroMsg/";
      hgk = hgi + hgj;
      hgl = hgk + "crash/";
      GMTrace.o(14008975360000L, 104375);
      return;
    }
    catch (Error localError)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/loader/stub/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */