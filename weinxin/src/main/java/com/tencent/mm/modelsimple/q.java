package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aod;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.protocal.c.zn;
import com.tencent.mm.protocal.c.zo;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class q
  extends k
  implements j
{
  public static String hRJ;
  public static String hRK;
  public static String hRL;
  public static String hRM;
  public static String hRN;
  public static String hRO;
  public static String hRP;
  public static String hRQ;
  public static String hRR;
  public static String hRS;
  private static int hRT;
  private static int hRU;
  private static int hRV;
  private static int hRW;
  private static boolean hRX;
  private com.tencent.mm.y.e gUt;
  
  static
  {
    GMTrace.i(1367275995136L, 10187);
    hRU = 0;
    hRV = 22;
    hRW = 0;
    hRX = false;
    GMTrace.o(1367275995136L, 10187);
  }
  
  public q(int paramInt)
  {
    GMTrace.i(1366739124224L, 10183);
    hRT = paramInt;
    GMTrace.o(1366739124224L, 10183);
  }
  
  public static int Jb()
  {
    GMTrace.i(1365799600128L, 10176);
    int i = hRU;
    GMTrace.o(1365799600128L, 10176);
    return i;
  }
  
  public static boolean Jc()
  {
    GMTrace.i(1365933817856L, 10177);
    if ((hRW & 0x2) != 0)
    {
      GMTrace.o(1365933817856L, 10177);
      return true;
    }
    GMTrace.o(1365933817856L, 10177);
    return false;
  }
  
  public static boolean Jd()
  {
    GMTrace.i(1366068035584L, 10178);
    if ((hRV & 0x4) != 0)
    {
      GMTrace.o(1366068035584L, 10178);
      return true;
    }
    GMTrace.o(1366068035584L, 10178);
    return false;
  }
  
  public static int Je()
  {
    GMTrace.i(1366336471040L, 10180);
    int i = hRT;
    GMTrace.o(1366336471040L, 10180);
    return i;
  }
  
  public static boolean Jf()
  {
    GMTrace.i(1366470688768L, 10181);
    if ((hRW & 0x200) != 0)
    {
      GMTrace.o(1366470688768L, 10181);
      return true;
    }
    GMTrace.o(1366470688768L, 10181);
    return false;
  }
  
  public static boolean Jg()
  {
    GMTrace.i(1366604906496L, 10182);
    if ((hRW & 0x400) != 0)
    {
      GMTrace.o(1366604906496L, 10182);
      return true;
    }
    GMTrace.o(1366604906496L, 10182);
    return false;
  }
  
  public static void bo(boolean paramBoolean)
  {
    GMTrace.i(1366202253312L, 10179);
    if (paramBoolean)
    {
      hRV |= 0x4;
      GMTrace.o(1366202253312L, 10179);
      return;
    }
    hRV &= 0xFFFFFFFB;
    GMTrace.o(1366202253312L, 10179);
  }
  
  public static boolean gw(int paramInt)
  {
    GMTrace.i(1365665382400L, 10175);
    if (hRT == paramInt)
    {
      GMTrace.o(1365665382400L, 10175);
      return false;
    }
    GMTrace.o(1365665382400L, 10175);
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1367007559680L, 10185);
    b.a locala = new b.a();
    zn localzn = new zn();
    localzn.lda = u.bID();
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[] { localzn.lda });
    locala.hrV = localzn;
    locala.hrW = new zo();
    locala.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
    locala.hrU = 526;
    locala.hrX = 0;
    locala.hrY = 0;
    this.gUt = parame1;
    int i = a(parame, locala.BE(), this);
    GMTrace.o(1367007559680L, 10185);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1367141777408L, 10186);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (zo)((com.tencent.mm.y.b)paramp).hrT.hsa;
      hRU = paramArrayOfByte.tEm;
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[] { Integer.valueOf(hRU), Integer.valueOf(paramArrayOfByte.tdn) });
      Object localObject = bg.q(paramArrayOfByte.tEl, "summary");
      paramInt1 = hRV;
      if (localObject != null)
      {
        hRJ = (String)((Map)localObject).get(".summary.banner");
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", new Object[] { Integer.valueOf(paramArrayOfByte.tEj), paramArrayOfByte.tEl });
        localObject = (zn)((com.tencent.mm.y.b)paramp).hrS.hsa;
        Iterator localIterator = paramArrayOfByte.tEk.iterator();
        while (localIterator.hasNext())
        {
          paramp = (aod)localIterator.next();
          if (paramp.tgU.bGP().hashCode() != ((zn)localObject).tXb.tgU.bGP().hashCode())
          {
            localObject = bg.q(paramp.tRD, "wording");
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneGetOnlineInfo", paramp.tRD);
            if (localObject != null)
            {
              hRK = (String)((Map)localObject).get(".wording.title");
              hRL = (String)((Map)localObject).get(".wording.notify");
              hRM = (String)((Map)localObject).get(".wording.mute_title");
              hRN = (String)((Map)localObject).get(".wording.mute_tips");
              hRO = (String)((Map)localObject).get(".wording.exit");
              hRP = (String)((Map)localObject).get(".wording.exit_confirm");
              hRQ = (String)((Map)localObject).get(".wording.lock_title");
              hRR = (String)((Map)localObject).get(".wording.mute_lock_title");
              hRS = (String)((Map)localObject).get(".wording.exit");
            }
            paramInt1 = paramp.tRF;
          }
        }
      }
    }
    for (;;)
    {
      int i = paramArrayOfByte.tdn;
      hRW = i;
      if ((i & 0x2) == 0)
      {
        hRX = true;
        if (paramInt1 != hRV)
        {
          hRV = paramInt1;
          ap.yY();
          c.uR();
        }
        if ((paramArrayOfByte.tdn & 0x40) != 0)
        {
          ap.yY();
          paramArrayOfByte = c.wR().Rb("filehelper");
          if (paramArrayOfByte != null)
          {
            paramp = paramArrayOfByte;
            if (!bf.mA(paramArrayOfByte.field_username)) {}
          }
          else
          {
            com.tencent.mm.u.v.w(paramArrayOfByte);
            ap.yY();
            paramp = c.wR().Rb("filehelper");
          }
          if ((paramp != null) && (!a.ez(paramp.field_type)))
          {
            paramp.tc();
            ap.yY();
            c.wR().a(paramp.field_username, paramp);
          }
          ap.yY();
          paramp = c.wW().Rl("filehelper");
          if (paramp != null) {
            break label657;
          }
          paramp = new ae("filehelper");
          paramp.s(bf.NA());
          ap.yY();
          c.wW().d(paramp);
        }
      }
      for (;;)
      {
        this.gUt.a(paramInt2, paramInt3, paramString, this);
        GMTrace.o(1367141777408L, 10186);
        return;
        hRX = false;
        break;
        label657:
        paramp.s(bf.NA());
        ap.yY();
        c.wW().a(paramp, "filehelper");
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(1366873341952L, 10184);
    GMTrace.o(1366873341952L, 10184);
    return 526;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */