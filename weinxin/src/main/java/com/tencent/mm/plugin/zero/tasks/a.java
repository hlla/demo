package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.v.a;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.Log.LogCallback;

public final class a
  extends c
{
  public a()
  {
    GMTrace.i(13628736536576L, 101542);
    GMTrace.o(13628736536576L, 101542);
  }
  
  public final void execute(e parame)
  {
    GMTrace.i(13628870754304L, 101543);
    if (!k.dx("wcdb")) {
      k.b("wcdb", getClass().getClassLoader());
    }
    Log.setLogger(new Log.LogCallback()
    {
      public final void println(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        GMTrace.i(13628199665664L, 101538);
        v.a locala = v.bIE();
        int i = Process.myPid();
        int j = Process.myTid();
        switch (paramAnonymousInt)
        {
        default: 
          GMTrace.o(13628199665664L, 101538);
          return;
        case 2: 
          locala.logV(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          GMTrace.o(13628199665664L, 101538);
          return;
        case 3: 
          locala.logD(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          GMTrace.o(13628199665664L, 101538);
          return;
        case 4: 
          locala.logI(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          GMTrace.o(13628199665664L, 101538);
          return;
        case 5: 
          locala.logW(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          GMTrace.o(13628199665664L, 101538);
          return;
        case 6: 
          locala.logE(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
          GMTrace.o(13628199665664L, 101538);
          return;
        }
        locala.logF(paramAnonymousString1, "", "", 0, i, j, i, paramAnonymousString2);
        GMTrace.o(13628199665664L, 101538);
      }
    });
    GMTrace.o(13628870754304L, 101543);
  }
  
  public final String name()
  {
    GMTrace.i(13629004972032L, 101544);
    GMTrace.o(13629004972032L, 101544);
    return "boot-db-prepare";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/zero/tasks/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */