package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.fa;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class f
  implements com.tencent.mm.pluginsdk.b.a
{
  static
  {
    GMTrace.i(14625840037888L, 108971);
    com.tencent.mm.pluginsdk.b.b.a(new f(), new String[] { "//sport" });
    GMTrace.o(14625840037888L, 108971);
  }
  
  public f()
  {
    GMTrace.i(14625437384704L, 108968);
    GMTrace.o(14625437384704L, 108968);
  }
  
  public static void init()
  {
    GMTrace.i(14625571602432L, 108969);
    GMTrace.o(14625571602432L, 108969);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    int i = 0;
    GMTrace.i(14625705820160L, 108970);
    if (v.getLogLevel() > 1)
    {
      GMTrace.o(14625705820160L, 108970);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      GMTrace.o(14625705820160L, 108970);
      return true;
    }
    paramContext = paramArrayOfString[1];
    switch (paramContext.hashCode())
    {
    default: 
      i = -1;
      label86:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      GMTrace.o(14625705820160L, 108970);
      return true;
      if (!paramContext.equals("setdevicestep")) {
        break;
      }
      break label86;
      if (!paramContext.equals("clear")) {
        break;
      }
      i = 1;
      break label86;
      if (!paramContext.equals("setextapistep")) {
        break;
      }
      i = 2;
      break label86;
      i = Integer.valueOf(paramArrayOfString[2]).intValue();
      long l = bf.bJK() / 10000L;
      ((com.tencent.mm.plugin.sport.b.b)h.h(com.tencent.mm.plugin.sport.b.b.class)).E(202, l);
      ((com.tencent.mm.plugin.sport.b.b)h.h(com.tencent.mm.plugin.sport.b.b.class)).E(201, i);
      continue;
      ((com.tencent.mm.plugin.sport.b.b)h.h(com.tencent.mm.plugin.sport.b.b.class)).bmf();
      Process.killProcess(Process.myPid());
      continue;
      paramContext = new fa();
      paramContext.fJg.action = 2;
      paramContext.fJg.fJj = Integer.valueOf(paramArrayOfString[2]).intValue();
      paramContext.fJg.fJk = 1L;
      com.tencent.mm.sdk.b.a.uql.a(paramContext, Looper.getMainLooper());
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/console/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */