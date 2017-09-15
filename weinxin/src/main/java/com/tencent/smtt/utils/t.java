package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class t
{
  static String igr;
  private static boolean wWF = true;
  static t wWH = null;
  static File wWI = null;
  static byte[] wWK;
  TextView Vr;
  private Context mContext = null;
  private SimpleDateFormat wWJ = null;
  private StringBuffer wWL = new StringBuffer();
  
  static
  {
    igr = null;
    wWK = null;
  }
  
  public t(Context paramContext)
  {
    try
    {
      this.mContext = paramContext.getApplicationContext();
      this.wWJ = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
      return;
    }
    catch (Exception paramContext)
    {
      this.wWJ = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
    }
  }
  
  public static void setWriteLogJIT(boolean paramBoolean)
  {
    wWF = paramBoolean;
  }
  
  public final void aC(String paramString)
  {
    try
    {
      String str = this.wWJ.format(Long.valueOf(System.currentTimeMillis()));
      this.wWL.append(str).append(" pid=").append(Process.myPid()).append(" tid=").append(Process.myTid()).append(paramString).append("\n");
      if ((Thread.currentThread() != Looper.getMainLooper().getThread()) || (wWF)) {
        writeLogToDisk();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void qM(String paramString)
  {
    if (this.Vr != null) {
      this.Vr.post(new a(paramString));
    }
  }
  
  public final void writeLogToDisk()
  {
    for (;;)
    {
      try
      {
        if (wWI == null)
        {
          if (!Environment.getExternalStorageState().equals("mounted")) {
            continue;
          }
          str = f.al(this.mContext, 6);
          if (str != null) {
            continue;
          }
          wWI = null;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        String str;
        continue;
      }
      catch (SecurityException localSecurityException)
      {
        continue;
      }
      if (wWI != null)
      {
        h.a(wWI, igr, wWK, this.wWL.toString());
        this.wWL.delete(0, this.wWL.length());
      }
      return;
      wWI = new File(str, "tbslog.txt");
      igr = h.cfc();
      wWK = h.fi(wWI.getName(), igr);
      continue;
      wWI = null;
    }
  }
  
  private final class a
    implements Runnable
  {
    String wWM = null;
    
    a(String paramString)
    {
      this.wWM = paramString;
    }
    
    public final void run()
    {
      if (t.this.Vr != null) {
        t.this.Vr.append(this.wWM + "\n");
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/utils/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */