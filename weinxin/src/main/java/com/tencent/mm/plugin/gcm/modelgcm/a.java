package com.tencent.mm.plugin.gcm.modelgcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.s;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;
import java.io.IOException;

public class a
  implements com.tencent.mm.y.e
{
  private static a mGb;
  public Context context;
  public int mFZ;
  private int mGa;
  public com.google.android.gms.gcm.a mGc;
  
  private a(Context paramContext)
  {
    GMTrace.i(8013737885696L, 59707);
    this.mFZ = 3;
    this.mGa = 0;
    this.context = paramContext;
    GMTrace.o(8013737885696L, 59707);
  }
  
  public static a aCg()
  {
    GMTrace.i(8013872103424L, 59708);
    v.i("GcmRegister", "GCM getInstance");
    if (mGb != null)
    {
      localObject = mGb;
      GMTrace.o(8013872103424L, 59708);
      return (a)localObject;
    }
    Object localObject = aa.getContext();
    if (localObject == null)
    {
      v.e("GcmRegister", "GCM appcontext null");
      GMTrace.o(8013872103424L, 59708);
      return null;
    }
    localObject = new a((Context)localObject);
    mGb = (a)localObject;
    GMTrace.o(8013872103424L, 59708);
    return (a)localObject;
  }
  
  private SharedPreferences aCj()
  {
    GMTrace.i(8014274756608L, 59711);
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences(a.class.getSimpleName(), 0);
    GMTrace.o(8014274756608L, 59711);
    return localSharedPreferences;
  }
  
  private static int cn(Context paramContext)
  {
    int i = 0;
    GMTrace.i(8014408974336L, 59712);
    try
    {
      int j = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        v.e("GcmRegister", "Could not get package name.");
      }
    }
    GMTrace.o(8014408974336L, 59712);
    return i;
  }
  
  static boolean co(Context paramContext)
  {
    GMTrace.i(8015214280704L, 59718);
    try
    {
      int i = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
      if (i < 8)
      {
        GMTrace.o(8015214280704L, 59718);
        return false;
      }
      i = com.google.android.gms.common.e.w(paramContext);
      if (i != 0)
      {
        v.w("GcmRegister", "device not support GCM reason = " + i);
        GMTrace.o(8015214280704L, 59718);
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      v.e("GcmRegister", paramContext.toString());
      GMTrace.o(8015214280704L, 59718);
      return false;
    }
    GMTrace.o(8015214280704L, 59718);
    return true;
  }
  
  private void eH(boolean paramBoolean)
  {
    GMTrace.i(8014945845248L, 59716);
    Object localObject = aCj();
    v.i("GcmRegister", "Saving regSvrResult: " + paramBoolean);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("isRegToSvr", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if (paramBoolean)
    {
      this.mGa = z.MP().idW.uH();
      GMTrace.o(8014945845248L, 59716);
      return;
    }
    this.mGa = 0;
    GMTrace.o(8014945845248L, 59716);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(8015348498432L, 59719);
    v.i("GcmRegister", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    paramk.hss = true;
    if (paramk == null)
    {
      GMTrace.o(8015348498432L, 59719);
      return;
    }
    if ((paramk instanceof e))
    {
      boolean bool = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bool = true;
        v.i("GcmRegister", "NetScenePushReg success.");
        c.oRz.a(452L, 16L, 1L, false);
      }
      for (;;)
      {
        eH(bool);
        GMTrace.o(8015348498432L, 59719);
        return;
        v.i("GcmRegister", "NetScenePushReg faild.");
        c.oRz.a(452L, 17L, 1L, false);
      }
    }
    if ((paramk instanceof f))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label200;
      }
      v.i("GcmRegister", "NetScenePushUnReg success.");
      c.oRz.a(452L, 23L, 1L, false);
    }
    for (;;)
    {
      eH(false);
      GMTrace.o(8015348498432L, 59719);
      return;
      label200:
      v.e("GcmRegister", "NetScenePushUnReg faild.");
      c.oRz.a(452L, 24L, 1L, false);
    }
  }
  
  public final void aCh()
  {
    GMTrace.i(8014006321152L, 59709);
    v.i("GcmRegister", "checkregister");
    z.MN().postDelayed(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(8018167070720L, 59740);
        v.e("GcmRegister", "onCreate~~~threadID:" + Thread.currentThread());
        a locala = a.aCg();
        if (locala != null)
        {
          v.i("GcmRegister", "doRegist~~~");
          String str = locala.aCi();
          v.i("GcmRegister", "regid = " + str);
          if (a.co(locala.context))
          {
            locala.mGc = com.google.android.gms.gcm.a.D(locala.context);
            if ((str == null) || (str.length() == 0))
            {
              new a.a(locala).execute(new Void[] { null, null, null });
              GMTrace.o(8018167070720L, 59740);
              return;
            }
            locala.aCk();
            GMTrace.o(8018167070720L, 59740);
            return;
          }
          v.i("GcmRegister", "Google Play Services Unavailable.");
          g.oSF.A(11250, "2,0");
          c.oRz.a(452L, 0L, 1L, false);
          if (locala.aCm())
          {
            locala.aCi();
            locala.aCl();
          }
        }
        GMTrace.o(8018167070720L, 59740);
      }
    }, 5000L);
    GMTrace.o(8014006321152L, 59709);
  }
  
  @SuppressLint({"NewApi"})
  public final String aCi()
  {
    GMTrace.i(8014140538880L, 59710);
    SharedPreferences localSharedPreferences = aCj();
    String str = localSharedPreferences.getString("registration_id", "");
    if (str.length() == 0)
    {
      v.i("GcmRegister", "Registration not found.");
      c.oRz.a(452L, 1L, 1L, false);
      GMTrace.o(8014140538880L, 59710);
      return "";
    }
    if (localSharedPreferences.getInt("appVersion", Integer.MIN_VALUE) != cn(this.context))
    {
      v.i("GcmRegister", "App version changed.");
      c.oRz.a(452L, 2L, 1L, false);
      GMTrace.o(8014140538880L, 59710);
      return "";
    }
    if (bf.az(localSharedPreferences.getLong("regtime", 0L)) > 259200L)
    {
      v.i("GcmRegister", "gcm regid timeout");
      c.oRz.a(452L, 3L, 1L, false);
      GMTrace.o(8014140538880L, 59710);
      return "";
    }
    c.oRz.a(452L, 4L, 1L, false);
    GMTrace.o(8014140538880L, 59710);
    return str;
  }
  
  public final void aCk()
  {
    GMTrace.i(8014543192064L, 59713);
    c.oRz.a(452L, 11L, 1L, false);
    int i = z.MP().idW.uH();
    if ((this.mGa != 0) && (i == this.mGa))
    {
      v.i("GcmRegister", "uin already reg to weixin svr:" + this.mGa);
      c.oRz.a(452L, 12L, 1L, false);
      GMTrace.o(8014543192064L, 59713);
      return;
    }
    String str = aCi();
    if ((str == null) || (str.length() == 0))
    {
      v.i("GcmRegister", "sendRegistrationIdToBackend regid is empty.");
      c.oRz.a(452L, 13L, 1L, false);
      GMTrace.o(8014543192064L, 59713);
      return;
    }
    v.i("GcmRegister", "regToWeixinServer.");
    try
    {
      new e(str, i).a(z.MP(), this);
      c.oRz.a(452L, 14L, 1L, false);
      GMTrace.o(8014543192064L, 59713);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.oRz.a(452L, 15L, 1L, false);
      v.e("GcmRegister", "NetScenePushReg doScene error:" + localThrowable.toString());
      GMTrace.o(8014543192064L, 59713);
    }
  }
  
  public final void aCl()
  {
    GMTrace.i(8014677409792L, 59714);
    v.i("GcmRegister", "unregToWeixinServer");
    c.oRz.a(452L, 18L, 1L, false);
    String str = aCi();
    if ((str == null) || (str.length() == 0))
    {
      v.e("GcmRegister", "unregToWeixinServer regid is empty.");
      c.oRz.a(452L, 19L, 1L, false);
      GMTrace.o(8014677409792L, 59714);
      return;
    }
    if (!aCm())
    {
      v.e("GcmRegister", "is not reg to Svr. no need unreg.");
      c.oRz.a(452L, 20L, 1L, false);
      GMTrace.o(8014677409792L, 59714);
      return;
    }
    eH(false);
    try
    {
      new f(str, z.MP().idW.uH()).a(z.MP(), this);
      c.oRz.a(452L, 21L, 1L, false);
      GMTrace.o(8014677409792L, 59714);
      return;
    }
    catch (Throwable localThrowable)
    {
      v.e("GcmRegister", "NetScenePushUnReg doScene error:" + localThrowable.toString());
      c.oRz.a(452L, 22L, 1L, false);
      GMTrace.o(8014677409792L, 59714);
    }
  }
  
  public final boolean aCm()
  {
    GMTrace.i(8015080062976L, 59717);
    boolean bool = aCj().getBoolean("isRegToSvr", false);
    GMTrace.o(8015080062976L, 59717);
    return bool;
  }
  
  public final void ac(Context paramContext, String paramString)
  {
    GMTrace.i(8014811627520L, 59715);
    SharedPreferences localSharedPreferences = aCj();
    int i = cn(paramContext);
    v.i("GcmRegister", "Saving regId on app version " + i);
    paramContext = localSharedPreferences.edit();
    paramContext.putString("registration_id", paramString);
    paramContext.putInt("appVersion", i);
    paramContext.putLong("regtime", bf.Nz());
    paramContext.commit();
    GMTrace.o(8014811627520L, 59715);
  }
  
  final class a
    extends AsyncTask<Void, Void, String>
  {
    a()
    {
      GMTrace.i(8012395708416L, 59697);
      GMTrace.o(8012395708416L, 59697);
    }
    
    private String aCn()
    {
      GMTrace.i(8012529926144L, 59698);
      int n = 0;
      int i1 = 0;
      int m = 0;
      c.oRz.a(452L, 5L, 1L, false);
      i = m;
      j = n;
      k = i1;
      for (;;)
      {
        try
        {
          v.i("GcmRegister", "RegisterAsyncTask doInBackground.");
          i = m;
          j = n;
          k = i1;
          if (a.this.mGc == null)
          {
            i = m;
            j = n;
            k = i1;
            a.this.mGc = com.google.android.gms.gcm.a.D(a.this.context);
          }
          i = m;
          j = n;
          k = i1;
          String str2 = a.this.mGc.b(new String[] { "546136561403" });
          i = m;
          j = n;
          k = i1;
          str1 = "Device registered, registration ID=" + str2;
          if (str2 == null) {
            continue;
          }
          i = m;
          j = n;
          k = i1;
          if (str2.length() <= 0) {
            continue;
          }
          i = m;
          j = n;
          k = i1;
          a.this.ac(a.this.context, str2);
          i = m;
          j = n;
          k = i1;
          a.this.aCk();
          j = 1;
          k = 1;
          i = 1;
          c.oRz.a(452L, 6L, 1L, false);
          i = 1;
        }
        catch (IOException localIOException)
        {
          str1 = "Device register Error :" + localIOException.getMessage();
          v.printErrStackTrace("GcmRegister", localIOException, "", new Object[0]);
          g.oSF.A(11250, "2,1");
          c.oRz.a(452L, 8L, 1L, false);
          continue;
        }
        catch (SecurityException localSecurityException)
        {
          a.this.mFZ = 0;
          str1 = "Device register Error :" + localSecurityException.getMessage();
          v.printErrStackTrace("GcmRegister", localSecurityException, "", new Object[0]);
          g.oSF.A(11250, "2,1");
          c.oRz.a(452L, 9L, 1L, false);
          i = j;
          continue;
        }
        catch (Exception localException)
        {
          String str1 = "Device register Error :" + localException.getMessage();
          v.printErrStackTrace("GcmRegister", localException, "", new Object[0]);
          g.oSF.A(11250, "2,1");
          c.oRz.a(452L, 10L, 1L, false);
          i = k;
          continue;
        }
        v.i("GcmRegister", str1);
        if ((i == 0) && (a.this.mFZ > 0))
        {
          a.this.mFZ -= 1;
          a.this.aCh();
        }
        GMTrace.o(8012529926144L, 59698);
        return str1;
        i = m;
        j = n;
        k = i1;
        g.oSF.A(11250, "2,1");
        i = m;
        j = n;
        k = i1;
        c.oRz.a(452L, 7L, 1L, false);
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gcm/modelgcm/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */