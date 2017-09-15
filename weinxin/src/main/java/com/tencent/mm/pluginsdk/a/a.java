package com.tencent.mm.pluginsdk.a;

import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.u.a;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static u.a a(u paramu)
  {
    GMTrace.i(839129235456L, 6252);
    Bundle localBundle = new Bundle();
    localBundle.putInt("kscene_type", 73);
    paramu = a(paramu, localBundle);
    GMTrace.o(839129235456L, 6252);
    return paramu;
  }
  
  private static u.a a(u paramu, Bundle paramBundle)
  {
    GMTrace.i(839263453184L, 6253);
    if (paramu == null)
    {
      GMTrace.o(839263453184L, 6253);
      return null;
    }
    if (((i.e)paramu.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(839263453184L, 6253);
      return null;
    }
    Object localObject = ((i.e)paramu.htc.zg()).sXG.ueM.tfJ;
    if ((localObject != null) && (((azz)localObject).tZD != null) && (((azz)localObject).tZD.size() > 0))
    {
      u.a locala = new u.a();
      localObject = ((azz)localObject).tZD.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bdr localbdr = (bdr)((Iterator)localObject).next();
        if (localbdr.oSb == 19) {
          locala.fGM = localbdr.udp;
        } else if (localbdr.oSb == 20) {
          locala.hSj = localbdr.udp;
        } else if (localbdr.oSb == 21) {
          locala.fNx = localbdr.udp;
        }
      }
      locala.hSk = paramBundle;
      locala.type = 0;
      if (!bf.mA(locala.fGM))
      {
        locala.username = ((i.d)paramu.htc.BG()).sXD.tMP.jLx;
        GMTrace.o(839263453184L, 6253);
        return locala;
      }
    }
    GMTrace.o(839263453184L, 6253);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */