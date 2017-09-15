package com.tencent.mm.bl;

import android.os.Environment;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
{
  public static boolean uLM;
  public static a uLN;
  
  static
  {
    GMTrace.i(13150787207168L, 97981);
    uLM = false;
    uLN = null;
    GMTrace.o(13150787207168L, 97981);
  }
  
  public static void Sy(String paramString)
  {
    GMTrace.i(16087873748992L, 119864);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.MemoryDumpOperation", "Hprof error uploadPath %s ", new Object[] { paramString });
      GMTrace.o(16087873748992L, 119864);
      return;
    }
    if (!rZ())
    {
      v.e("MicroMsg.MemoryDumpOperation", "Hprof sdcard invalid.");
      GMTrace.o(16087873748992L, 119864);
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      v.e("MicroMsg.MemoryDumpOperation", "Hprof upload file is not exist");
      GMTrace.o(16087873748992L, 119864);
      return;
    }
    paramString = p.a(paramString, true, null);
    if (paramString == null)
    {
      GMTrace.o(16087873748992L, 119864);
      return;
    }
    File localFile = new File(paramString);
    if ((!al.isWifi(aa.getContext())) && (localFile.length() > 5242880L))
    {
      v.i("MicroMsg.MemoryDumpOperation", "Hprof not wifi exceed max size, size " + localFile.length());
      GMTrace.o(16087873748992L, 119864);
      return;
    }
    if (uLN == null)
    {
      v.e("MicroMsg.MemoryDumpOperation", "Hprof upload : no file upload impl set!");
      GMTrace.o(16087873748992L, 119864);
      return;
    }
    boolean bool = uLN.Cu(paramString);
    v.i("MicroMsg.MemoryDumpOperation", "Hprof upload : %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      e.e(new File(b.uLL));
    }
    GMTrace.o(16087873748992L, 119864);
  }
  
  static boolean rZ()
  {
    GMTrace.i(13150250336256L, 97977);
    try
    {
      if ((Environment.getExternalStorageState().equals("mounted")) && (new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite()))
      {
        GMTrace.o(13150250336256L, 97977);
        return true;
      }
      GMTrace.o(13150250336256L, 97977);
      return false;
    }
    catch (Exception localException)
    {
      GMTrace.o(13150250336256L, 97977);
    }
    return false;
  }
  
  public static void yP(int paramInt)
  {
    GMTrace.i(13150116118528L, 97976);
    final boolean bool1;
    final boolean bool2;
    final boolean bool3;
    boolean bool4;
    switch (paramInt)
    {
    default: 
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
    for (;;)
    {
      v.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      Executors.newSingleThreadExecutor().execute(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13149847683072L, 97974);
          if (c.uLM)
          {
            v.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
            GMTrace.o(13149847683072L, 97974);
            return;
          }
          if (this.uLO) {}
          for (String str = b.G(true, false);; str = null)
          {
            Process.setThreadPriority(10);
            boolean bool = al.isWifi(aa.getContext());
            if ((bool3) && (!bool))
            {
              v.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
              GMTrace.o(13149847683072L, 97974);
              return;
            }
            if ((bool2) && (str != null)) {}
            for (;;)
            {
              c.uLM = true;
              c.Sy(str);
              c.uLM = false;
              GMTrace.o(13149847683072L, 97974);
              return;
              if (bool1) {
                str = b.uLL;
              } else {
                str = null;
              }
            }
          }
        }
      });
      GMTrace.o(13150116118528L, 97976);
      return;
      v.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
      System.gc();
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
      continue;
      bool1 = false;
      bool2 = true;
      bool3 = false;
      bool4 = true;
      continue;
      bool1 = false;
      bool2 = true;
      bool3 = true;
      bool4 = true;
      continue;
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = true;
      continue;
      bool1 = true;
      bool2 = false;
      bool3 = false;
      bool4 = false;
      continue;
      bool1 = true;
      bool2 = false;
      bool3 = true;
      bool4 = false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bl/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */