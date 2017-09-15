package com.tencent.mm.modelvoice;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.c.b.i;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.e.a.ih;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.h.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.y.d.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class q
{
  private static HashMap<String, WeakReference<com.tencent.mm.y.h>> ibU;
  
  static
  {
    GMTrace.i(14301033136128L, 106551);
    ibU = new HashMap();
    GMTrace.o(14301033136128L, 106551);
  }
  
  public static float B(au paramau)
  {
    GMTrace.i(14300764700672L, 106549);
    if ((paramau != null) && (paramau.bLP())) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      float f2 = (float)new n(paramau.field_content).time / 1000.0F;
      float f1 = f2;
      if (f2 < 1.0F) {
        f1 = 1.0F;
      }
      f1 = Math.round(f1 * 10.0F) / 10.0F;
      GMTrace.o(14300764700672L, 106549);
      return f1;
    }
  }
  
  public static boolean C(au paramau)
  {
    GMTrace.i(549084725248L, 4091);
    if ((paramau == null) || (!paramau.bLP()))
    {
      GMTrace.o(549084725248L, 4091);
      return false;
    }
    boolean bool = new n(paramau.field_content).hZO;
    GMTrace.o(549084725248L, 4091);
    return bool;
  }
  
  public static boolean D(au paramau)
  {
    GMTrace.i(549218942976L, 4092);
    if ((paramau == null) || (!paramau.bLP()) || (paramau.field_isSend == 1))
    {
      GMTrace.o(549218942976L, 4092);
      return false;
    }
    if (new n(paramau.field_content).time == 0L)
    {
      GMTrace.o(549218942976L, 4092);
      return true;
    }
    GMTrace.o(549218942976L, 4092);
    return false;
  }
  
  public static String E(String paramString, boolean paramBoolean)
  {
    GMTrace.i(547339894784L, 4078);
    g.a locala = new g.a();
    String str = com.tencent.mm.sdk.platformtools.h.a(xf(), "msg_", paramString, ".amr", 2);
    v.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + locala.se());
    if (bf.mA(str))
    {
      GMTrace.o(547339894784L, 4078);
      return null;
    }
    if (paramBoolean)
    {
      GMTrace.o(547339894784L, 4078);
      return str;
    }
    if (new File(str).exists())
    {
      GMTrace.o(547339894784L, 4078);
      return str;
    }
    paramString = xe() + paramString;
    if (new File(paramString + ".amr").exists()) {
      j.p(paramString + ".amr", str, true);
    }
    for (;;)
    {
      GMTrace.o(547339894784L, 4078);
      return str;
      if (new File(paramString).exists()) {
        j.p(paramString, str, true);
      }
    }
  }
  
  public static void E(au paramau)
  {
    GMTrace.i(549353160704L, 4093);
    if ((paramau == null) || (!paramau.bLP()))
    {
      GMTrace.o(549353160704L, 4093);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramau.field_msgId);
    if (((ce)localObject).field_msgId != paramau.field_msgId)
    {
      GMTrace.o(549353160704L, 4093);
      return;
    }
    localObject = new n(((ce)localObject).field_content);
    if (((n)localObject).hZO)
    {
      GMTrace.o(549353160704L, 4093);
      return;
    }
    ((n)localObject).hZO = true;
    StringBuilder localStringBuilder = new StringBuilder().append(((n)localObject).hZN).append(":").append(((n)localObject).time).append(":");
    if (((n)localObject).hZO) {}
    for (int i = 1;; i = 0)
    {
      paramau.setContent(i + "\n");
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramau.field_msgId, paramau);
      GMTrace.o(549353160704L, 4093);
      return;
    }
  }
  
  public static boolean K(String paramString, int paramInt)
  {
    GMTrace.i(14299690958848L, 106541);
    boolean bool = j(paramString, paramInt, 0);
    GMTrace.o(14299690958848L, 106541);
    return bool;
  }
  
  public static List<p> LE()
  {
    GMTrace.i(14300630482944L, 106548);
    Object localObject1 = m.Lz();
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo";
    localObject2 = (String)localObject2 + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime";
    localObject2 = ((u)localObject1).hnp.a((String)localObject2, null, 2);
    int i = 0;
    int j;
    if (((Cursor)localObject2).moveToFirst())
    {
      localObject1 = new ArrayList();
      do
      {
        p localp = new p();
        localp.b((Cursor)localObject2);
        ((List)localObject1).add(localp);
        j = i + 1;
        i = j;
      } while (((Cursor)localObject2).moveToNext());
    }
    for (;;)
    {
      v.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:" + j);
      ((Cursor)localObject2).close();
      GMTrace.o(14300630482944L, 106548);
      return (List<p>)localObject1;
      j = 0;
      localObject1 = null;
    }
  }
  
  public static int a(p paramp, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, d.a parama)
  {
    GMTrace.i(14299959394304L, 106543);
    g.a locala = new g.a();
    p localp = m.Lz().ax(paramp.fTG);
    if ((localp != null) && (localp.status == 99))
    {
      GMTrace.o(14299959394304L, 106543);
      return 0;
    }
    if ((((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().x(paramp.fRV, paramp.fTG).field_msgSvrId == paramp.fTG) && (localp == null))
    {
      GMTrace.o(14299959394304L, 106543);
      return 0;
    }
    boolean bool1;
    String str1;
    String str2;
    int i;
    if (localp != null)
    {
      paramp.fyw = localp.fyw;
      paramp.fRM |= 0x1;
      v.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.sd() + "checktime :" + locala.se());
      boolean bool2 = false;
      bool1 = bool2;
      if (paramArrayOfByte != null)
      {
        bool1 = bool2;
        if (paramArrayOfByte.length > 1)
        {
          if (localp != null) {
            v.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But  VoiceInfo is not new !");
          }
          str1 = paramp.iaK;
          str2 = paramp.fyw;
          i = an(str1, str2).write(paramArrayOfByte, paramArrayOfByte.length, 0);
          if (i >= 0) {
            break label630;
          }
          v.e("MicroMsg.VoiceLogic", "Write Failed File:" + str2 + " newOffset:" + i + " voiceFormat:" + str1);
          bool1 = false;
        }
      }
      label285:
      v.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.sd() + "checktime :" + locala.se());
      paramp.hZT = (System.currentTimeMillis() / 1000L);
      paramp.fRM |= 0x100;
      if (!bool1) {
        break label755;
      }
      paramp.status = 99;
    }
    for (;;)
    {
      paramp.fRM |= 0x40;
      if (localp != null) {
        break label830;
      }
      if (bool1) {
        paramp.hZW = ((int)a(paramp, bool1, paramInt, paramString1, paramString2, parama));
      }
      if (parama != null)
      {
        paramp.gxu = ay.c(parama);
        if (parama.hsc != null) {
          paramp.hJz = parama.hsc.tdF;
        }
      }
      v.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.sd() + "checktime :" + locala.se());
      paramp.fRM = -1;
      v.d("MicroMsg.VoiceLogic", "Insert fileName:" + paramp.fyw + " stat:" + paramp.status + " net:" + paramp.hYB + " total:" + paramp.hrb);
      if (m.Lz().b(paramp)) {
        break label779;
      }
      v.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + paramp.fyw + " stat:" + paramp.status + " net:" + paramp.hYB + " total:" + paramp.hrb);
      GMTrace.o(14299959394304L, 106543);
      return -2;
      paramp.fyw = u.mg(paramp.hZN);
      break;
      label630:
      if (paramArrayOfByte.length != i)
      {
        v.e("MicroMsg.VoiceLogic", "Write File:" + str2 + " fileOff:" + i + " bufLen:" + paramArrayOfByte.length + " voiceFormat:" + str1);
        bool1 = false;
        break label285;
      }
      v.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str2 + "] + buf:" + paramArrayOfByte.length + " voiceFormat:" + str1);
      lX(str2);
      bool1 = true;
      break label285;
      label755:
      if (paramp.hrb == 0) {
        paramp.status = 5;
      } else {
        paramp.status = 6;
      }
    }
    label779:
    v.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.sd() + "checktime :" + locala.se());
    if (bool1)
    {
      GMTrace.o(14299959394304L, 106543);
      return 1;
      label830:
      v.d("MicroMsg.VoiceLogic", "Sync Update file:" + paramp.fyw + " stat:" + paramp.status);
      if (!a(paramp))
      {
        GMTrace.o(14299959394304L, 106543);
        return -44;
      }
      if (bool1)
      {
        a(paramp, parama);
        GMTrace.o(14299959394304L, 106543);
        return 1;
      }
    }
    if ((localp != null) && (localp.hZP == paramp.hrb))
    {
      a(localp.fyw, localp.hZP, parama);
      v.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + localp.fyw);
    }
    v.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[] { parama, Boolean.valueOf(bool1), bf.bJP() });
    m.LB().run();
    GMTrace.o(14299959394304L, 106543);
    return 0;
  }
  
  public static int a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, int paramInt3)
  {
    GMTrace.i(14299825176576L, 106542);
    if (paramString1 == null)
    {
      GMTrace.o(14299825176576L, 106542);
      return -1;
    }
    v.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + paramString1 + "] newOff:" + paramInt1 + " SvrID:" + paramLong + " clientID:" + paramString2 + " hasSendEndFlag " + paramInt2);
    p localp = m.Lz().mh(paramString1);
    if (localp == null)
    {
      GMTrace.o(14299825176576L, 106542);
      return -1;
    }
    localp.hYB = paramInt1;
    localp.hZT = (System.currentTimeMillis() / 1000L);
    localp.fRM = 264;
    if ((bf.mA(localp.clientId)) && (paramString2 != null))
    {
      localp.clientId = paramString2;
      localp.fRM |= 0x200;
    }
    if ((localp.fTG == 0L) && (paramLong != 0L))
    {
      localp.fTG = paramLong;
      localp.fRM |= 0x4;
    }
    int j = 0;
    int i = j;
    if (localp.hrb <= paramInt1)
    {
      i = j;
      if (localp.status == 3)
      {
        i = j;
        if (paramInt2 == 1)
        {
          localp.status = 99;
          localp.fRM |= 0x40;
          paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(localp.hZW);
          paramString2.cH(localp.fRV);
          paramString2.y(localp.fTG);
          paramString2.dv(2);
          paramString2.setContent(n.b(localp.hZN, localp.ibS, false));
          paramString2.yA(paramInt3);
          ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(localp.hZW, paramString2);
          v.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + paramString1 + " total:" + localp.hrb + " status:" + localp.status + " netTimes:" + localp.hZX + " msgId:" + paramString2.field_msgId);
          i = 1;
          lX(paramString1);
        }
      }
    }
    if (!a(localp))
    {
      GMTrace.o(14299825176576L, 106542);
      return -4;
    }
    GMTrace.o(14299825176576L, 106542);
    return i;
  }
  
  public static int a(String paramString, int paramInt, d.a parama)
  {
    GMTrace.i(548413636608L, 4086);
    if (paramString == null)
    {
      GMTrace.o(548413636608L, 4086);
      return -1;
    }
    p localp = m.Lz().mh(paramString);
    if (localp == null)
    {
      GMTrace.o(548413636608L, 4086);
      return -1;
    }
    localp.hZP = paramInt;
    localp.hZT = (System.currentTimeMillis() / 1000L);
    localp.fRM = 272;
    int j = 0;
    int i = j;
    if (localp.hrb > 0)
    {
      i = j;
      if (paramInt >= localp.hrb)
      {
        a(localp, parama);
        localp.status = 99;
        localp.fRM |= 0x40;
        v.d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localp.hrb + " status:" + localp.status + " netTimes:" + localp.hZX);
        i = 1;
        lX(paramString);
      }
    }
    v.d("MicroMsg.VoiceLogic", "updateRecv file:" + paramString + " newsize:" + paramInt + " total:" + localp.hrb + " status:" + localp.status);
    if (!a(localp))
    {
      GMTrace.o(548413636608L, 4086);
      return -3;
    }
    GMTrace.o(548413636608L, 4086);
    return i;
  }
  
  private static long a(p paramp, boolean paramBoolean, int paramInt, String paramString1, String paramString2, d.a parama)
  {
    GMTrace.i(548279418880L, 4085);
    if (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cC(paramp.fTG))
    {
      v.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(paramp.fTG) });
      if (bf.mz(paramp.fyw).length() > 0) {
        m.Lz().gR(paramp.fyw);
      }
      for (;;)
      {
        GMTrace.o(548279418880L, 4085);
        return -1L;
        v.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
      }
    }
    au localau = new au();
    localau.y(paramp.fTG);
    localau.cI(paramp.fyw);
    localau.z(ay.i(paramp.fRV, paramp.hZS));
    localau.cH(paramp.fRV);
    int i;
    if (com.tencent.mm.u.m.eH(paramp.hZN))
    {
      i = 1;
      localau.dw(i);
      localau.setType(34);
      localau.cM(paramString1);
      localau.yA(paramp.iaR);
      localau.dv(paramInt);
      if (parama != null) {
        break label567;
      }
      paramInt = paramp.gxu;
      if (paramInt != 0)
      {
        v.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[] { Integer.valueOf(paramInt) });
        localau.dF(paramInt);
        if ((localau.field_msgId == 0L) && (localau.field_isSend == 0) && ((paramInt & 0x2) != 0)) {
          localau.z(ay.a(localau.field_talker, paramp.hZS, true, localau.field_msgSeq));
        }
      }
      if (paramp.hJz != 0) {
        localau.B(paramp.hJz);
      }
      v.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramp.hJz) });
      label336:
      v.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[] { paramString2 });
      if (!bf.mA(paramString2))
      {
        localau.cN(paramString2);
        localau.cO(ay.gn(paramString2));
      }
      if (paramBoolean) {
        break label577;
      }
      localau.setContent(n.b(paramp.hZN, 0L, false));
    }
    for (;;)
    {
      if (!bf.mA(paramString2))
      {
        localau.cN(paramString2);
        localau.cO(ay.gn(paramString2));
        paramp = ay.gm(paramString2);
        if (paramp != null)
        {
          localau.cO(paramp.hmy);
          localau.cL(paramp.hmx);
          v.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[] { paramp.hmx });
          if (paramp.hmz != null)
          {
            paramString1 = new ih();
            paramString1.fNI.fCQ = localau;
            paramString1.fNI.fNJ = paramp;
            com.tencent.mm.sdk.b.a.uql.m(paramString1);
          }
        }
      }
      v.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[] { Long.valueOf(localau.field_msgSvrId), Long.valueOf(localau.field_msgSeq) });
      long l = ay.i(localau);
      GMTrace.o(548279418880L, 4085);
      return l;
      i = 0;
      break;
      label567:
      ay.a(localau, parama);
      break label336;
      label577:
      localau.setContent(n.b(paramp.hZN, paramp.ibS, false));
    }
  }
  
  private static boolean a(p paramp)
  {
    GMTrace.i(548816289792L, 4089);
    if (paramp == null)
    {
      GMTrace.o(548816289792L, 4089);
      return false;
    }
    if (paramp.fRM == -1)
    {
      GMTrace.o(548816289792L, 4089);
      return false;
    }
    boolean bool = m.Lz().a(paramp.fyw, paramp);
    GMTrace.o(548816289792L, 4089);
    return bool;
  }
  
  private static boolean a(p paramp, d.a parama)
  {
    GMTrace.i(548145201152L, 4084);
    try
    {
      paramp.hZW = ((int)a(paramp, true, 3, "", paramp.gxv, parama));
      paramp.fRM |= 0x800;
      boolean bool = a(paramp);
      GMTrace.o(548145201152L, 4084);
      return bool;
    }
    catch (Exception paramp)
    {
      v.e("MicroMsg.VoiceLogic", "exception:%s", new Object[] { bf.g(paramp) });
      GMTrace.o(548145201152L, 4084);
    }
    return false;
  }
  
  public static boolean a(String paramString, com.tencent.mm.y.h paramh)
  {
    GMTrace.i(14299422523392L, 106539);
    if (paramString == null)
    {
      GMTrace.o(14299422523392L, 106539);
      return false;
    }
    p localp = m.Lz().mh(paramString);
    if (localp == null)
    {
      v.d("MicroMsg.VoiceLogic", "startSend null record : " + paramString);
      GMTrace.o(14299422523392L, 106539);
      return false;
    }
    if (localp.status != 1)
    {
      GMTrace.o(14299422523392L, 106539);
      return false;
    }
    localp.status = 2;
    localp.fRM = 64;
    ibU.put(paramString, new WeakReference(paramh));
    boolean bool = a(localp);
    GMTrace.o(14299422523392L, 106539);
    return bool;
  }
  
  public static b an(String paramString1, String paramString2)
  {
    GMTrace.i(546803023872L, 4074);
    u localu = m.Lz();
    paramString2 = jt(paramString2);
    switch (bf.getInt(paramString1, -1))
    {
    case 2: 
    case 3: 
    default: 
      if (localu.icd.get(paramString2) == null) {
        localu.icd.put(paramString2, new a(paramString2));
      }
      paramString1 = (b)localu.icd.get(paramString2);
      GMTrace.o(546803023872L, 4074);
      return paramString1;
    case 4: 
      if (localu.icf.get(paramString2) == null) {
        localu.icf.put(paramString2, new h(paramString2));
      }
      paramString1 = (b)localu.icf.get(paramString2);
      GMTrace.o(546803023872L, 4074);
      return paramString1;
    }
    if (localu.ice.get(paramString2) == null) {
      localu.ice.put(paramString2, new l(paramString2));
    }
    paramString1 = (b)localu.ice.get(paramString2);
    GMTrace.o(546803023872L, 4074);
    return paramString1;
  }
  
  public static float aw(long paramLong)
  {
    float f2 = 60.0F;
    float f1 = 1.0F;
    GMTrace.i(548950507520L, 4090);
    float f3 = (float)paramLong / 1000.0F;
    if (f3 < 1.0F) {}
    for (;;)
    {
      if (f1 > 60.0F) {
        f1 = f2;
      }
      for (;;)
      {
        f1 = Math.round(f1);
        GMTrace.o(548950507520L, 4090);
        return f1;
      }
      f1 = f3;
    }
  }
  
  public static String c(String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(548547854336L, 4087);
    if (bf.mA(paramString1))
    {
      GMTrace.o(548547854336L, 4087);
      return null;
    }
    if ((!bf.mA(paramString2)) && (!paramString2.startsWith("amr_")) && (!paramString2.startsWith("spx_"))) {
      paramString2.startsWith("silk_");
    }
    paramString1 = lY(paramString1);
    if (bf.mA(paramString1))
    {
      GMTrace.o(548547854336L, 4087);
      return null;
    }
    if (!j.p(jt(paramString2), jt(paramString1), false))
    {
      GMTrace.o(548547854336L, 4087);
      return null;
    }
    j(paramString1, paramInt, 1);
    GMTrace.o(548547854336L, 4087);
    return paramString1;
  }
  
  public static int gO(int paramInt)
  {
    GMTrace.i(14299288305664L, 106538);
    paramInt = (paramInt - 6) / 32;
    GMTrace.o(14299288305664L, 106538);
    return paramInt * 20;
  }
  
  public static boolean gP(int paramInt)
  {
    GMTrace.i(14300227829760L, 106545);
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramInt);
    if ((localau.field_msgId == 0L) || (localau.field_imgPath == null))
    {
      GMTrace.o(14300227829760L, 106545);
      return false;
    }
    if (bf.mA(localau.field_imgPath))
    {
      GMTrace.o(14300227829760L, 106545);
      return false;
    }
    Object localObject = localau.field_imgPath;
    localObject = m.Lz().mh((String)localObject);
    if ((localObject == null) || (bf.mA(((p)localObject).fyw)))
    {
      GMTrace.o(14300227829760L, 106545);
      return false;
    }
    ((p)localObject).status = 3;
    ((p)localObject).hYB = 0;
    ((p)localObject).hZS = (System.currentTimeMillis() / 1000L);
    ((p)localObject).hZT = (System.currentTimeMillis() / 1000L);
    ((p)localObject).fRM = 8648;
    boolean bool = a((p)localObject);
    v.d("MicroMsg.VoiceLogic", " file:" + ((p)localObject).fyw + " msgid:" + ((p)localObject).hZW + "  stat:" + ((p)localObject).status);
    if ((((p)localObject).hZW == 0) || (bf.mA(((p)localObject).fRV)))
    {
      v.e("MicroMsg.VoiceLogic", " failed msg id:" + ((p)localObject).hZW + " user:" + ((p)localObject).fRV);
      GMTrace.o(14300227829760L, 106545);
      return bool;
    }
    localau.dv(1);
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(localau.field_msgId, localau);
    m.LB().run();
    GMTrace.o(14300227829760L, 106545);
    return true;
  }
  
  private static boolean j(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(548010983424L, 4083);
    if (paramString == null)
    {
      GMTrace.o(548010983424L, 4083);
      return false;
    }
    v.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + paramString + "], fullPath[" + jt(paramString) + "]");
    p localp = m.Lz().mh(paramString);
    if (localp == null)
    {
      GMTrace.o(548010983424L, 4083);
      return false;
    }
    if ((localp.status != 97) && (localp.status != 98)) {
      localp.status = 3;
    }
    localp.hrb = o.ly(paramString);
    if (localp.hrb <= 0)
    {
      lB(paramString);
      GMTrace.o(548010983424L, 4083);
      return false;
    }
    localp.hZT = (System.currentTimeMillis() / 1000L);
    localp.ibS = paramInt1;
    localp.fRM = 3424;
    au localau = new au();
    localau.cH(localp.fRV);
    localau.setType(34);
    localau.dw(1);
    localau.cI(paramString);
    if (localp.status == 97)
    {
      localau.dv(2);
      localau.setContent(n.b(localp.hZN, localp.ibS, false));
    }
    for (;;)
    {
      localau.z(ay.gk(localp.fRV));
      localau.yA(paramInt2);
      a.a.qB().b(localau);
      localp.hZW = ((int)ay.i(localau));
      boolean bool = a(localp);
      ibU.remove(paramString);
      GMTrace.o(548010983424L, 4083);
      return bool;
      if (localp.status == 98)
      {
        localau.dv(5);
        localau.setContent(n.b(localp.hZN, -1L, true));
      }
      else
      {
        localau.dv(1);
        localau.setContent(n.b(localp.hZN, localp.ibS, false));
      }
    }
  }
  
  public static String jt(String paramString)
  {
    GMTrace.i(547205677056L, 4077);
    if (bf.mA(paramString))
    {
      GMTrace.o(547205677056L, 4077);
      return null;
    }
    paramString = E(paramString, false);
    GMTrace.o(547205677056L, 4077);
    return paramString;
  }
  
  public static boolean lB(String paramString)
  {
    GMTrace.i(548682072064L, 4088);
    com.tencent.mm.plugin.report.service.g.oSF.a(111L, 234L, 1L, false);
    if (paramString == null)
    {
      GMTrace.o(548682072064L, 4088);
      return false;
    }
    p localp = m.Lz().mh(paramString);
    if (localp == null)
    {
      v.e("MicroMsg.VoiceLogic", "Set error failed file:" + paramString);
      GMTrace.o(548682072064L, 4088);
      return false;
    }
    localp.status = 98;
    localp.hZT = (System.currentTimeMillis() / 1000L);
    localp.fRM = 320;
    boolean bool = a(localp);
    v.d("MicroMsg.VoiceLogic", "setError file:" + paramString + " msgid:" + localp.hZW + " old stat:" + localp.status);
    if ((localp.hZW == 0) || (bf.mA(localp.fRV)))
    {
      v.e("MicroMsg.VoiceLogic", "setError failed msg id:" + localp.hZW + " user:" + localp.fRV);
      GMTrace.o(548682072064L, 4088);
      return bool;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(localp.hZW);
    com.tencent.mm.plugin.report.c.oRz.a(111L, 33L, 1L, true);
    paramString.x(localp.hZW);
    paramString.dv(5);
    paramString.cH(localp.fRV);
    paramString.setContent(n.b(localp.hZN, -1L, true));
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramString.field_msgId, paramString);
    GMTrace.o(548682072064L, 4088);
    return bool;
  }
  
  public static boolean lC(String paramString)
  {
    GMTrace.i(14300093612032L, 106544);
    paramString = m.Lz().mh(paramString);
    if (paramString == null)
    {
      GMTrace.o(14300093612032L, 106544);
      return false;
    }
    if (paramString.status == 3)
    {
      au localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramString.hZW);
      localau.setContent(n.b(paramString.hZN, paramString.ibS, false));
      localau.dv(2);
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramString.hZW, localau);
    }
    paramString.status = 97;
    paramString.hZT = (System.currentTimeMillis() / 1000L);
    paramString.fRM = 320;
    boolean bool = a(paramString);
    GMTrace.o(14300093612032L, 106544);
    return bool;
  }
  
  public static boolean lV(String paramString)
  {
    GMTrace.i(546668806144L, 4073);
    if (paramString == null)
    {
      GMTrace.o(546668806144L, 4073);
      return false;
    }
    paramString = m.Lz().mh(paramString);
    if (paramString == null)
    {
      GMTrace.o(546668806144L, 4073);
      return false;
    }
    if (paramString.hZX >= 250)
    {
      GMTrace.o(546668806144L, 4073);
      return false;
    }
    paramString.hZX += 1;
    paramString.fRM = 8192;
    boolean bool = a(paramString);
    GMTrace.o(546668806144L, 4073);
    return bool;
  }
  
  public static b lW(String paramString)
  {
    GMTrace.i(546937241600L, 4075);
    u localu = m.Lz();
    String str = jt(paramString);
    switch (o.lT(paramString))
    {
    default: 
      if (localu.icd.get(str) == null) {
        localu.icd.put(str, new a(str));
      }
      paramString = (b)localu.icd.get(str);
      GMTrace.o(546937241600L, 4075);
      return paramString;
    case 0: 
      if (localu.icd.get(str) == null) {
        localu.icd.put(str, new a(str));
      }
      paramString = (b)localu.icd.get(str);
      GMTrace.o(546937241600L, 4075);
      return paramString;
    case 1: 
      if (localu.ice.get(str) == null) {
        localu.ice.put(str, new l(str));
      }
      paramString = (b)localu.ice.get(str);
      GMTrace.o(546937241600L, 4075);
      return paramString;
    }
    if (localu.icf.get(str) == null) {
      localu.icf.put(str, new h(str));
    }
    paramString = (b)localu.icf.get(str);
    GMTrace.o(546937241600L, 4075);
    return paramString;
  }
  
  public static void lX(String paramString)
  {
    GMTrace.i(547071459328L, 4076);
    u localu = m.Lz();
    String str = jt(paramString);
    switch (o.lT(paramString))
    {
    default: 
      paramString = (a)localu.icd.get(str);
      if (paramString != null)
      {
        paramString.Lv();
        localu.icd.remove(str);
      }
      GMTrace.o(547071459328L, 4076);
      return;
    case 0: 
      paramString = (a)localu.icd.get(str);
      if (paramString != null)
      {
        paramString.Lv();
        localu.icd.remove(str);
      }
      GMTrace.o(547071459328L, 4076);
      return;
    case 1: 
      paramString = (l)localu.ice.get(str);
      if (paramString != null)
      {
        paramString.Lv();
        localu.ice.remove(str);
      }
      GMTrace.o(547071459328L, 4076);
      return;
    }
    paramString = (h)localu.icf.get(str);
    if (paramString != null)
    {
      paramString.Lv();
      localu.icf.remove(str);
    }
    GMTrace.o(547071459328L, 4076);
  }
  
  public static String lY(String paramString)
  {
    GMTrace.i(547474112512L, 4079);
    String str = u.mg(com.tencent.mm.u.m.xL());
    p localp = new p();
    localp.fyw = str;
    localp.fRV = paramString;
    localp.hZS = (System.currentTimeMillis() / 1000L);
    localp.clientId = str;
    localp.hZT = (System.currentTimeMillis() / 1000L);
    localp.status = 1;
    localp.hZN = com.tencent.mm.u.m.xL();
    localp.fRM = -1;
    if (!m.Lz().b(localp))
    {
      GMTrace.o(547474112512L, 4079);
      return null;
    }
    v.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
    GMTrace.o(547474112512L, 4079);
    return str;
  }
  
  public static boolean lZ(String paramString)
  {
    GMTrace.i(14299556741120L, 106540);
    if (paramString == null)
    {
      GMTrace.o(14299556741120L, 106540);
      return false;
    }
    v.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + paramString + "]");
    p localp = m.Lz().mh(paramString);
    if (localp == null)
    {
      GMTrace.o(14299556741120L, 106540);
      return false;
    }
    localp.status = 8;
    localp.hrb = o.ly(paramString);
    localp.fRM = 64;
    boolean bool = a(localp);
    GMTrace.o(14299556741120L, 106540);
    return bool;
  }
  
  public static boolean ma(String paramString)
  {
    GMTrace.i(547608330240L, 4080);
    if (paramString == null)
    {
      GMTrace.o(547608330240L, 4080);
      return false;
    }
    p localp = m.Lz().mh(paramString);
    if (localp == null)
    {
      v.d("MicroMsg.VoiceLogic", "cancel null download : " + paramString);
      GMTrace.o(547608330240L, 4080);
      return true;
    }
    v.d("MicroMsg.VoiceLogic", "cancel download : " + paramString + " SvrlId:" + localp.fTG);
    if (localp.fTG != 0L) {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().E(localp.fRV, localp.fTG);
    }
    boolean bool = mc(paramString);
    GMTrace.o(547608330240L, 4080);
    return bool;
  }
  
  public static boolean mb(String paramString)
  {
    GMTrace.i(547742547968L, 4081);
    if (paramString == null)
    {
      GMTrace.o(547742547968L, 4081);
      return false;
    }
    p localp = m.Lz().mh(paramString);
    if (localp == null)
    {
      v.i("MicroMsg.VoiceLogic", "cancel null record : " + paramString);
      GMTrace.o(547742547968L, 4081);
      return true;
    }
    v.i("MicroMsg.VoiceLogic", "cancel record : " + paramString + " LocalId:" + localp.hZW);
    if (localp.hZW != 0) {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cB(localp.hZW);
    }
    boolean bool = mc(paramString);
    GMTrace.o(547742547968L, 4081);
    return bool;
  }
  
  public static boolean mc(String paramString)
  {
    GMTrace.i(547876765696L, 4082);
    if (bf.mA(paramString))
    {
      GMTrace.o(547876765696L, 4082);
      return false;
    }
    m.Lz().gR(paramString);
    lX(paramString);
    boolean bool = new File(jt(paramString)).delete();
    GMTrace.o(547876765696L, 4082);
    return bool;
  }
  
  public static au md(String paramString)
  {
    GMTrace.i(14300362047488L, 106546);
    if (paramString == null)
    {
      GMTrace.o(14300362047488L, 106546);
      return null;
    }
    paramString = m.Lz().mh(paramString);
    if (paramString == null)
    {
      GMTrace.o(14300362047488L, 106546);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramString.hZW);
    GMTrace.o(14300362047488L, 106546);
    return paramString;
  }
  
  public static p me(String paramString)
  {
    GMTrace.i(15659853414400L, 116675);
    paramString = m.Lz().mh(paramString);
    GMTrace.o(15659853414400L, 116675);
    return paramString;
  }
  
  public static int mf(String paramString)
  {
    GMTrace.i(14300898918400L, 106550);
    if (ibU.get(paramString) != null)
    {
      paramString = (com.tencent.mm.y.h)((WeakReference)ibU.get(paramString)).get();
      if (paramString != null)
      {
        int i = (int)paramString.pn();
        GMTrace.o(14300898918400L, 106550);
        return i;
      }
    }
    GMTrace.o(14300898918400L, 106550);
    return -1;
  }
  
  public static String xe()
  {
    GMTrace.i(14589332815872L, 108699);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.vJ();
    localObject = com.tencent.mm.kernel.h.vI().gXV + "voice/";
    GMTrace.o(14589332815872L, 108699);
    return (String)localObject;
  }
  
  public static String xf()
  {
    GMTrace.i(14589467033600L, 108700);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.vJ();
    localObject = com.tencent.mm.kernel.h.vI().gXV + "voice2/";
    GMTrace.o(14589467033600L, 108700);
    return (String)localObject;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */