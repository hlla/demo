package com.tencent.mm.y;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.i;
import com.tencent.mm.network.p;
import com.tencent.mm.network.q;
import com.tencent.mm.network.q.a;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.axh;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.c.a;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y.a;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.aq;

public final class s
  extends q.a
{
  ad handler;
  private p htc;
  g htp;
  h htq;
  
  public s(p paramp) {}
  
  public s(p paramp, ad paramad)
  {
    GMTrace.i(13408485244928L, 99901);
    this.htc = paramp;
    this.htp = new r(paramp.BG(), paramp.getType());
    this.htq = new t(paramp.zg(), paramp.getType());
    this.handler = paramad;
    GMTrace.o(13408485244928L, 99901);
  }
  
  public final int BD()
  {
    GMTrace.i(13408887898112L, 99904);
    int i = this.htc.BD();
    GMTrace.o(13408887898112L, 99904);
    return i;
  }
  
  public final boolean BH()
  {
    GMTrace.i(13408619462656L, 99902);
    boolean bool = this.htc.BH();
    GMTrace.o(13408619462656L, 99902);
    return bool;
  }
  
  public final int BM()
  {
    GMTrace.i(13408753680384L, 99903);
    int i = this.htc.hashCode();
    GMTrace.o(13408753680384L, 99903);
    return i;
  }
  
  public final g Cm()
  {
    GMTrace.i(13409022115840L, 99905);
    g localg = this.htp;
    GMTrace.o(13409022115840L, 99905);
    return localg;
  }
  
  public final h Cn()
  {
    GMTrace.i(13409156333568L, 99906);
    h localh = this.htq;
    GMTrace.o(13409156333568L, 99906);
    return localh;
  }
  
  public final int Co()
  {
    int j = -1;
    GMTrace.i(13410095857664L, 99913);
    int i = getType();
    v.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
    case 701: 
    case 702: 
      for (i = -1;; i = aq.b(this.htc))
      {
        GMTrace.o(13410095857664L, 99913);
        return i;
      }
    }
    Object localObject2 = this.htc;
    Object localObject1 = (y.a)((p)localObject2).BG();
    y.b localb = (y.b)((p)localObject2).zg();
    v.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", new Object[] { Integer.valueOf(126), bf.bJP() });
    if (localb.sXI != 0) {
      v.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(localb.sXI) });
    }
    for (;;)
    {
      i = localb.sXI;
      break;
      Object localObject3 = localb.sYz.tQZ;
      if (localObject3 != null)
      {
        int k = ((axh)localObject3).tfN;
        localObject2 = ((axh)localObject3).tfx;
        localObject3 = n.a(((axh)localObject3).tfy);
        int m = ((or)localObject2).tfZ.tXB;
        int n = ((or)localObject2).tsC;
        label247:
        byte[] arrayOfByte2;
        if (localObject3 == null)
        {
          i = -1;
          v.d("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), bf.Qi(bf.bl((byte[])localObject3)) });
          byte[] arrayOfByte1 = n.a(((or)localObject2).tfZ);
          arrayOfByte2 = ((y.a)localObject1).sXF;
          localObject1 = null;
          if (bf.bm(arrayOfByte1)) {
            break label636;
          }
          m = arrayOfByte1.length;
          localObject1 = bf.Qi(bf.bl(arrayOfByte1));
          if (arrayOfByte2 != null) {
            break label622;
          }
          i = -1;
          label342:
          v.d("MicroMsg.MMReqRespReg2", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(m), localObject1, Integer.valueOf(i), bf.Qi(bf.bl(arrayOfByte2)) });
          localObject1 = new PByteArray();
          m = MMProtocalJni.computerKeyWithAllStr(((or)localObject2).tsC, arrayOfByte1, arrayOfByte2, (PByteArray)localObject1, 0);
          localObject1 = ((PByteArray)localObject1).value;
          if (localObject1 != null) {
            break label629;
          }
          i = -1;
          label424:
          v.i("MicroMsg.MMReqRespReg2", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), bf.Qi(bf.bl((byte[])localObject1)) });
          label461:
          if (localObject1 == null) {
            break label647;
          }
          localObject2 = localObject1;
          label470:
          localb.sXH = ((byte[])localObject2);
          if ((k & 0x4) == 0) {
            break label719;
          }
          v.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
          if (bf.bm((byte[])localObject1)) {
            break label694;
          }
          localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject3, (byte[])localObject1);
          if (localObject3 != null) {
            break label655;
          }
          i = -1;
          label514:
          localObject2 = bf.bl((byte[])localObject3);
          if (localObject1 != null) {
            break label662;
          }
        }
        for (;;)
        {
          v.d("MicroMsg.MMReqRespReg2", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject2, Integer.valueOf(j), bf.Qi(bf.bl((byte[])localObject1)) });
          if (bf.bm((byte[])localObject1)) {
            break label669;
          }
          v.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", new Object[] { bf.Qi(bf.bl((byte[])localObject1)) });
          localb.aW((byte[])localObject1);
          localb.sXI = 1;
          break;
          i = localObject3.length;
          break label247;
          label622:
          i = arrayOfByte2.length;
          break label342;
          label629:
          i = localObject1.length;
          break label424;
          label636:
          v.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
          break label461;
          label647:
          localObject2 = new byte[0];
          break label470;
          label655:
          i = localObject3.length;
          break label514;
          label662:
          j = localObject1.length;
        }
        label669:
        v.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
        localb.aW(new byte[0]);
        localb.sXI = 2;
        continue;
        label694:
        v.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
        localb.aW(new byte[0]);
        localb.sXI = 2;
        continue;
        label719:
        v.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
        localb.aW((byte[])localObject3);
        localb.sXI = 1;
      }
      else
      {
        v.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
        localb.aW(new byte[0]);
        localb.sXI = 2;
      }
    }
  }
  
  public final void a(com.tencent.mm.network.d paramd, final i parami, final int paramInt1, final int paramInt2)
  {
    GMTrace.i(13409961639936L, 99912);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13400834834432L, 99844);
        s locals = new s(new j(), s.this.handler);
        try
        {
          parami.a(locals, paramInt1, paramInt2, "");
          GMTrace.o(13400834834432L, 99844);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          v.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { bf.g(localRemoteException) });
          GMTrace.o(13400834834432L, 99844);
        }
      }
    });
    GMTrace.o(13409961639936L, 99912);
  }
  
  public final void a(final i parami, final int paramInt1, final int paramInt2)
  {
    GMTrace.i(13409827422208L, 99911);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13400566398976L, 99842);
        int k = aq.ze().getInt("key_auth_update_version", 0);
        int j;
        Object localObject;
        if (k <= 637665332)
        {
          i = 701;
          j = i;
          if (k == 0)
          {
            localObject = aa.getContext().getSharedPreferences("ticket_prefs", 4);
            if (!bf.mA(((SharedPreferences)localObject).getString("_auth_ticket", ""))) {
              break label312;
            }
            v.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
            c.oRz.a(148L, 50L, 1L, true);
            j = 702;
          }
          label89:
          v.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(com.tencent.mm.protocal.d.sXh), Integer.valueOf(637665332), Integer.valueOf(j) });
          if (j == 701) {
            c.oRz.a(148L, 48L, 1L, true);
          }
          if (((s.a(s.this).getType() != 702) && (s.a(s.this).getType() != 701)) || (((i.g)s.a(s.this).zg()).sXI != 2)) {
            break label410;
          }
        }
        label312:
        label410:
        for (int i = 1;; i = 0)
        {
          v.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", new Object[] { Integer.valueOf(s.a(s.this).getType()), Integer.valueOf(j), Integer.valueOf(i) });
          localObject = i.c.a.sXC.aI(j, i);
          if (localObject == null) {}
          for (localObject = null;; localObject = new s((p)localObject, s.this.handler))
          {
            try
            {
              parami.a((q)localObject, paramInt1, paramInt2, "");
              GMTrace.o(13400566398976L, 99842);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              v.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { bf.g(localRemoteException) });
              GMTrace.o(13400566398976L, 99842);
              return;
            }
            i = 702;
            break;
            c.oRz.a(148L, 49L, 1L, true);
            v.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", new Object[] { bf.Qi(((SharedPreferences)localObject).getString("_auth_ticket", "")) });
            j = i;
            break label89;
          }
        }
      }
    });
    GMTrace.o(13409827422208L, 99911);
  }
  
  public final void a(i parami, final int paramInt1, final int paramInt2, final String paramString)
  {
    GMTrace.i(13409693204480L, 99910);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13397345173504L, 99818);
        v.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", new Object[] { Integer.valueOf(s.a(s.this).getType()), bf.bJP() });
        i.f localf = (i.f)s.a(s.this).BG();
        i.g localg = (i.g)s.a(s.this).zg();
        if (localg == null)
        {
          v.f("MicroMsg.RemoteReqResp", "null auth.resp");
          GMTrace.o(13397345173504L, 99818);
          return;
        }
        i.c.a.sXC.a(localf, localg, paramInt1, paramInt2, paramString);
        GMTrace.o(13397345173504L, 99818);
      }
    });
    GMTrace.o(13409693204480L, 99910);
  }
  
  public final int getType()
  {
    GMTrace.i(13409290551296L, 99907);
    int i = this.htc.getType();
    GMTrace.o(13409290551296L, 99907);
    return i;
  }
  
  public final String getUri()
  {
    GMTrace.i(13409424769024L, 99908);
    String str = this.htc.getUri();
    GMTrace.o(13409424769024L, 99908);
    return str;
  }
  
  public final void hz(String paramString)
  {
    GMTrace.i(13409558986752L, 99909);
    GMTrace.o(13409558986752L, 99909);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */