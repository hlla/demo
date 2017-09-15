package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.i.c;
import com.tencent.mm.sdk.platformtools.bf;

public final class u
{
  private static volatile u sBg;
  
  static
  {
    GMTrace.i(751887712256L, 5602);
    sBg = null;
    GMTrace.o(751887712256L, 5602);
  }
  
  private u()
  {
    GMTrace.i(750813970432L, 5594);
    GMTrace.o(750813970432L, 5594);
  }
  
  public static u bCB()
  {
    GMTrace.i(750948188160L, 5595);
    if (sBg == null) {}
    try
    {
      if (sBg == null) {
        sBg = new u();
      }
      u localu = sBg;
      GMTrace.o(750948188160L, 5595);
      return localu;
    }
    finally {}
  }
  
  public static t t(int paramInt, Bundle paramBundle)
  {
    GMTrace.i(751082405888L, 5596);
    switch (paramInt)
    {
    default: 
      paramBundle = new q();
      GMTrace.o(751082405888L, 5596);
      return paramBundle;
    case 2: 
      paramBundle = new a(paramBundle);
      GMTrace.o(751082405888L, 5596);
      return paramBundle;
    }
    paramBundle = new x();
    GMTrace.o(751082405888L, 5596);
    return paramBundle;
  }
  
  public static int wR(int paramInt)
  {
    GMTrace.i(751216623616L, 5597);
    switch (paramInt)
    {
    default: 
      GMTrace.o(751216623616L, 5597);
      return 5;
    case 0: 
      paramInt = bf.getInt(com.tencent.mm.i.g.sW().z("QQBroswer", "RecommendCount"), 5);
      GMTrace.o(751216623616L, 5597);
      return paramInt;
    }
    GMTrace.o(751216623616L, 5597);
    return Integer.MAX_VALUE;
  }
  
  public static void wS(int paramInt)
  {
    GMTrace.i(751350841344L, 5598);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(751350841344L, 5598);
      return;
      com.tencent.mm.plugin.report.service.g.oSF.i(10998, new Object[] { Integer.valueOf(0) });
      GMTrace.o(751350841344L, 5598);
      return;
      com.tencent.mm.plugin.report.service.g.oSF.i(11091, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public static void wT(int paramInt)
  {
    GMTrace.i(751485059072L, 5599);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(751485059072L, 5599);
      return;
      com.tencent.mm.plugin.report.service.g.oSF.i(10998, new Object[] { Integer.valueOf(1) });
      GMTrace.o(751485059072L, 5599);
      return;
      com.tencent.mm.plugin.report.service.g.oSF.i(11091, new Object[] { Integer.valueOf(1) });
    }
  }
  
  public static void wU(int paramInt)
  {
    GMTrace.i(751619276800L, 5600);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(751619276800L, 5600);
      return;
      com.tencent.mm.plugin.report.service.g.oSF.i(10998, new Object[] { Integer.valueOf(3) });
      GMTrace.o(751619276800L, 5600);
      return;
      com.tencent.mm.plugin.report.service.g.oSF.i(11091, new Object[] { Integer.valueOf(3) });
    }
  }
  
  public static void wV(int paramInt)
  {
    GMTrace.i(751753494528L, 5601);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(751753494528L, 5601);
      return;
      com.tencent.mm.plugin.report.service.g.oSF.i(10998, new Object[] { Integer.valueOf(2) });
      GMTrace.o(751753494528L, 5601);
      return;
      com.tencent.mm.plugin.report.service.g.oSF.i(11091, new Object[] { Integer.valueOf(2) });
    }
  }
  
  public static final class a
  {
    public int sBh;
    public int sBi;
    public String sBj;
    public int sBk;
    public String sBl;
    
    public a()
    {
      GMTrace.i(759940775936L, 5662);
      GMTrace.o(759940775936L, 5662);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */