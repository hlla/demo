package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ap.i;
import com.tencent.mm.app.e.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;

public final class g
{
  public static void run()
  {
    GMTrace.i(500632125440L, 3730);
    Object localObject1 = aa.getContext();
    Object localObject4 = new e.a()
    {
      public final void cS(int paramAnonymousInt)
      {
        GMTrace.i(502108520448L, 3741);
        v.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.mm.plugin.report.service.g.oSF.a(25L, paramAnonymousInt, 1L, false);
        GMTrace.o(502108520448L, 3741);
      }
    };
    if (localObject1 != null) {}
    int j;
    label1070:
    label1164:
    label1169:
    label1193:
    label1198:
    for (;;)
    {
      boolean bool;
      try
      {
        localObject1 = ((Context)localObject1).getSharedPreferences("crash_status_file", 4);
        localObject5 = ((SharedPreferences)localObject1).getString("crashlist", "").split(";");
        if (localObject5 != null)
        {
          i = localObject5.length;
          if (i > 0) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject5;
        long l;
        Object localObject2;
        continue;
        try
        {
          Object localObject3 = localThrowable1.getSharedPreferences("crash_status_file", 4);
          if (((SharedPreferences)localObject3).getInt("googleplaysizelimit", 1024) == i) {
            continue;
          }
          localObject3 = ((SharedPreferences)localObject3).edit();
          ((SharedPreferences.Editor)localObject3).putInt("googleplaysizelimit", i);
          ((SharedPreferences.Editor)localObject3).commit();
        }
        catch (Throwable localThrowable2) {}
        continue;
        i = 3;
        continue;
        if (199 != i) {
          continue;
        }
        if (!m.xL().equals(localObject5)) {
          break label1218;
        }
      }
      localObject1 = aa.getContext();
      i = com.tencent.mm.i.g.sV().getInt("AndroidGooglePlayCrashUploadSizeLimit", 1024);
      if ((localObject1 == null) || (i <= 0))
      {
        ap.yY();
        if (u.aA(u.d((Long)c.vr().get(w.a.uxv, null))) > 21600000L)
        {
          com.tencent.mm.plugin.report.service.g.oSF.a(279L, com.tencent.mm.i.g.sV().getInt("AndroidDynamicConfigVer", 0) % 16, 1L, false);
          ap.yY();
          c.vr().a(w.a.uxv, Long.valueOf(u.NA()));
        }
        ap.yY();
        if (u.aA(u.d((Long)c.vr().get(w.a.uxw, null))) > 21600000L)
        {
          ap.yY();
          c.vr().a(w.a.uxw, Long.valueOf(u.NA()));
          localObject4 = o.KW();
          localObject1 = new int[6];
          tmp230_228 = localObject1;
          tmp230_228[0] = 0;
          tmp234_230 = tmp230_228;
          tmp234_230[1] = 0;
          tmp238_234 = tmp234_230;
          tmp238_234[2] = 0;
          tmp242_238 = tmp238_234;
          tmp242_238[3] = 0;
          tmp246_242 = tmp242_238;
          tmp246_242[4] = 0;
          tmp250_246 = tmp246_242;
          tmp250_246[5] = 0;
          tmp250_246;
          try
          {
            l = bf.Nz();
            localObject5 = "select status, videofuncflag, human from videoinfo2 where lastmodifytime > " + (l - 21600L);
            v.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", new Object[] { localObject5 });
            localObject4 = ((s)localObject4).hnp.a((String)localObject5, null, 2);
            if (!((Cursor)localObject4).moveToNext()) {
              break label1070;
            }
            i = ((Cursor)localObject4).getInt(0);
            j = ((Cursor)localObject4).getInt(1);
            localObject5 = ((Cursor)localObject4).getString(2);
            if (111 != i) {
              continue;
            }
            if (j != 3) {
              continue;
            }
            i = 0;
            localObject1[i] += 1;
            continue;
            l = bf.a((Long)h.vI().vr().get(81939, null), 0L);
          }
          catch (Exception localException) {}
        }
        if (bf.NA() - l <= 86400000L) {
          break label1164;
        }
        i = 1;
        if (i != 0) {
          new i();
        }
        l = System.currentTimeMillis();
        ap.yY();
        bool = ((Boolean)c.vr().get(233475, Boolean.valueOf(false))).booleanValue();
        ap.yY();
        if (c.wR().bLl() > 0) {
          break label1169;
        }
        if (!bool)
        {
          ap.yY();
          c.wW().Rk("officialaccounts");
          ap.yY();
          c.vr().set(233475, Boolean.valueOf(true));
        }
        v.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        GMTrace.o(500632125440L, 3730);
        return;
        localObject2 = localException.edit();
        ((SharedPreferences.Editor)localObject2).putString("crashlist", "");
        ((SharedPreferences.Editor)localObject2).commit();
        i = 0;
        if (i >= localObject5.length) {
          break label1198;
        }
        if (localObject5[i] == null)
        {
          localObject2 = null;
          if ((localObject2 == null) || (localObject2.length < 2)) {
            break label1193;
          }
          if (localObject2[1].equals("anr"))
          {
            ((e.a)localObject4).cS(10);
            break label1193;
          }
        }
        else
        {
          localObject2 = localObject5[i].split(",");
          continue;
        }
        ((e.a)localObject4).cS(11);
        if ("com.tencent.mm".equals(localObject2[0])) {
          ((e.a)localObject4).cS(14);
        }
        if ("com.tencent.mm:push".equals(localObject2[0])) {
          ((e.a)localObject4).cS(17);
        }
        if ("com.tencent.mm:tools".equals(localObject2[0])) {
          ((e.a)localObject4).cS(20);
        }
        if (localObject2[1].equals("java"))
        {
          ((e.a)localObject4).cS(12);
          if ("com.tencent.mm".equals(localObject2[0])) {
            ((e.a)localObject4).cS(15);
          }
          if ("com.tencent.mm:push".equals(localObject2[0])) {
            ((e.a)localObject4).cS(18);
          }
          if ("com.tencent.mm:tools".equals(localObject2[0])) {
            ((e.a)localObject4).cS(21);
          }
        }
        if (localObject2[1].equals("jni"))
        {
          ((e.a)localObject4).cS(13);
          if ("com.tencent.mm".equals(localObject2[0])) {
            ((e.a)localObject4).cS(16);
          }
          if ("com.tencent.mm:push".equals(localObject2[0])) {
            ((e.a)localObject4).cS(19);
          }
          if ("com.tencent.mm:tools".equals(localObject2[0])) {
            ((e.a)localObject4).cS(22);
          }
        }
        if (!localObject2[1].equals("first")) {
          break label1193;
        }
        if ("com.tencent.mm".equals(localObject2[0])) {
          ((e.a)localObject4).cS(23);
        }
        if ("com.tencent.mm:push".equals(localObject2[0])) {
          ((e.a)localObject4).cS(24);
        }
        if (!"com.tencent.mm:tools".equals(localObject2[0])) {
          break label1193;
        }
        ((e.a)localObject4).cS(25);
        break label1193;
      }
      if (j != 3) {
        break label1213;
      }
      i = 1;
      break;
      ((Cursor)localObject4).close();
      com.tencent.mm.plugin.report.service.g.oSF.i(12696, new Object[] { Integer.valueOf(10010), Integer.valueOf(localThrowable2[0]), Integer.valueOf(localThrowable2[1]), Integer.valueOf(localThrowable2[2]), Integer.valueOf(localThrowable2[3]), Integer.valueOf(localThrowable2[4]), Integer.valueOf(localThrowable2[5]) });
      continue;
      i = 0;
      continue;
      if (bool)
      {
        ap.yY();
        c.vr().set(233475, Boolean.valueOf(false));
        continue;
        i += 1;
      }
    }
    for (;;)
    {
      localThrowable2[i] += 1;
      break;
      label1213:
      i = 4;
    }
    label1218:
    if (j == 3) {}
    for (int i = 2;; i = 5)
    {
      localThrowable2[i] += 1;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */