package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.s;
import com.tencent.mm.u.ap;

public final class o
{
  static long gKl;
  
  static
  {
    GMTrace.i(498753077248L, 3716);
    gKl = 0L;
    GMTrace.o(498753077248L, 3716);
  }
  
  private static void cV(String paramString)
  {
    GMTrace.i(498216206336L, 3712);
    paramString = aa.getContext().getSharedPreferences(paramString, 0);
    Object localObject = paramString.getString("startup_info", "").split("=");
    if ((localObject == null) || (localObject.length == 0))
    {
      GMTrace.o(498216206336L, 3712);
      return;
    }
    a locala = new a();
    if (locala.cX(localObject[(localObject.length - 1)]))
    {
      locala.gKo = 2;
      localObject[(localObject.length - 1)] = locala.toString();
    }
    localObject = d((String[])localObject);
    v.d("MicroMsg.ProcessReport", "uerExit new info %s", new Object[] { localObject });
    paramString.edit().putString("startup_info", (String)localObject).commit();
    GMTrace.o(498216206336L, 3712);
  }
  
  public static void cW(String paramString)
  {
    GMTrace.i(16010027466752L, 119284);
    SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences(paramString, 0);
    String[] arrayOfString = localSharedPreferences.getString("startup_info", "").split("=");
    if ((arrayOfString == null) || (arrayOfString.length <= 1))
    {
      v.i("MicroMsg.ProcessReport", "nothing to reprot");
      GMTrace.o(16010027466752L, 119284);
      return;
    }
    int i = 0;
    while (i < arrayOfString.length - 1)
    {
      v.i("MicroMsg.ProcessReport", "reprot %s: %s", new Object[] { paramString, arrayOfString[i] });
      g.oSF.A(10667, arrayOfString[i]);
      i += 1;
    }
    localSharedPreferences.edit().putString("startup_info", arrayOfString[(arrayOfString.length - 1)]).commit();
    GMTrace.o(16010027466752L, 119284);
  }
  
  private static String d(String[] paramArrayOfString)
  {
    GMTrace.i(498484641792L, 3714);
    String str1 = "";
    int j = 1;
    int k = paramArrayOfString.length;
    int i = 0;
    if (i < k)
    {
      String str2 = paramArrayOfString[i];
      if (j != 0) {
        j = 0;
      }
      for (;;)
      {
        str1 = str1 + str2;
        i += 1;
        break;
        str1 = str1 + "=";
      }
    }
    GMTrace.o(498484641792L, 3714);
    return str1;
  }
  
  private static void k(String paramString, int paramInt)
  {
    GMTrace.i(497947770880L, 3710);
    SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences(paramString, 0);
    paramString = localSharedPreferences.getString("startup_info", "").split("=");
    if ((paramString != null) && (paramString.length > 0))
    {
      localObject = new a();
      if (((a)localObject).cX(paramString[(paramString.length - 1)]))
      {
        ((a)localObject).gKr = Process.myPid();
        paramString[(paramString.length - 1)] = ((a)localObject).toString();
      }
    }
    Object localObject = new a();
    ((a)localObject).gKn = paramInt;
    ((a)localObject).gKp = Process.myPid();
    ((a)localObject).gKq = ((int)bf.Nz());
    String str = d(paramString);
    localObject = ((a)localObject).toString();
    paramString = (String)localObject;
    if (str.length() > 0) {
      paramString = str + "=" + (String)localObject;
    }
    v.d("MicroMsg.ProcessReport", "startProc new info %s", new Object[] { paramString });
    localSharedPreferences.edit().putString("startup_info", paramString).commit();
    GMTrace.o(497947770880L, 3710);
  }
  
  public static void oA()
  {
    GMTrace.i(498081988608L, 3711);
    cV("mm_proc_startup");
    cV("push_proc_startup");
    GMTrace.o(498081988608L, 3711);
  }
  
  public static void onCreate(boolean paramBoolean)
  {
    GMTrace.i(497813553152L, 3709);
    if (paramBoolean)
    {
      k("mm_proc_startup", 2);
      GMTrace.o(497813553152L, 3709);
      return;
    }
    k("push_proc_startup", 1);
    GMTrace.o(497813553152L, 3709);
  }
  
  public static void qg()
  {
    GMTrace.i(498350424064L, 3713);
    if ((gKl != 0L) && (bf.aB(gKl) < 3600000L))
    {
      GMTrace.o(498350424064L, 3713);
      return;
    }
    int i = ((Integer)ap.yW().get(37, Integer.valueOf(0))).intValue();
    if (d.sXh != i)
    {
      ap.yW().set(37, Integer.valueOf(d.sXh));
      new ad(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(501303214080L, 3735);
          g.oSF.A(10675, this.gKm + "," + f.fuN);
          GMTrace.o(501303214080L, 3735);
        }
      });
    }
    gKl = bf.NB();
    new ad(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(501571649536L, 3737);
        o.cW("mm_proc_startup");
        o.cW("push_proc_startup");
        GMTrace.o(501571649536L, 3737);
      }
    });
    GMTrace.o(498350424064L, 3713);
  }
  
  static final class a
  {
    int gKn;
    int gKo;
    int gKp;
    int gKq;
    int gKr;
    
    a()
    {
      GMTrace.i(494592327680L, 3685);
      this.gKo = 1;
      GMTrace.o(494592327680L, 3685);
    }
    
    public final boolean cX(String paramString)
    {
      GMTrace.i(494726545408L, 3686);
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length != 5))
      {
        v.e("MicroMsg.ProcessReport", "error format");
        GMTrace.o(494726545408L, 3686);
        return false;
      }
      try
      {
        this.gKn = bf.getInt(paramString[0], 0);
        this.gKo = bf.getInt(paramString[1], 0);
        this.gKp = bf.getInt(paramString[2], 0);
        this.gKq = bf.getInt(paramString[3], 0);
        this.gKr = bf.getInt(paramString[4], 0);
        GMTrace.o(494726545408L, 3686);
        return true;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
        v.printErrStackTrace("MicroMsg.ProcessReport", paramString, "", new Object[0]);
        GMTrace.o(494726545408L, 3686);
      }
      return false;
    }
    
    public final String toString()
    {
      GMTrace.i(494860763136L, 3687);
      String str = String.format("%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.gKn), Integer.valueOf(this.gKo), Integer.valueOf(this.gKp), Integer.valueOf(this.gKq), Integer.valueOf(this.gKr) });
      GMTrace.o(494860763136L, 3687);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */