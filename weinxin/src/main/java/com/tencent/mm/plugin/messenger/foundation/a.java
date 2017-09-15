package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.ajg;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.nd;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.o;

public final class a
  implements p
{
  private static final a nwJ;
  
  static
  {
    GMTrace.i(13236283899904L, 98618);
    nwJ = new a();
    GMTrace.o(13236283899904L, 98618);
  }
  
  public a()
  {
    GMTrace.i(13235747028992L, 98614);
    GMTrace.o(13235747028992L, 98614);
  }
  
  public static com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.b paramb)
  {
    GMTrace.i(13235881246720L, 98615);
    paramb = nwJ.bI(paramb);
    GMTrace.o(13235881246720L, 98615);
    return paramb;
  }
  
  public static void a(amb paramamb, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13236149682176L, 98617);
    if (paramamb == null)
    {
      v.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
      GMTrace.o(13236149682176L, 98617);
      return;
    }
    String str1 = n.a(paramamb.trH);
    String str2 = bf.mz(paramamb.tOZ);
    if ((bf.mA(str1)) && (bf.mA(str2)))
    {
      v.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
      GMTrace.o(13236149682176L, 98617);
      return;
    }
    v.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s", new Object[] { paramamb.trH, paramamb.tPc, paramamb.tPd });
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(str1);
    if ((localObject1 != null) && (str1.equals(((af)localObject1).field_encryptUsername)))
    {
      v.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[] { str1 });
      GMTrace.o(13236149682176L, 98617);
      return;
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((x)localObject1).bLa();
      if (localObject2 == null) {}
    }
    for (;;)
    {
      Object localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new x(str1);
      }
      ((x)localObject3).setUsername(str1);
      ((x)localObject3).bO(paramamb.hAq);
      ((x)localObject3).setType(paramamb.tqP & paramamb.tqQ);
      if ((paramBoolean1) && (localObject2 != null) && ((int)((com.tencent.mm.j.a)localObject2).gTG > 0))
      {
        v.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[] { str1, Integer.valueOf(((af)localObject2).field_type), Integer.valueOf(((af)localObject3).field_type) });
        ((x)localObject3).setType(((af)localObject3).field_type | ((af)localObject2).field_type);
      }
      long l;
      label351:
      label657:
      boolean bool;
      label901:
      int i;
      if (!bf.mA(str2))
      {
        ((x)localObject3).bX(str2);
        if (localObject2 != null) {
          break label1237;
        }
        l = 0L;
        ((x)localObject3).gTG = l;
        ((x)localObject3).bR(n.a(paramamb.tJy));
        ((x)localObject3).bS(n.a(paramamb.trx));
        ((x)localObject3).bT(n.a(paramamb.jdField_try));
        ((x)localObject3).di(paramamb.hAl);
        ((x)localObject3).dl(paramamb.tqV);
        ((x)localObject3).bQ(n.a(paramamb.tOT));
        ((x)localObject3).dm(paramamb.tqZ);
        ((x)localObject3).dn(paramamb.hAp);
        ((x)localObject3).ck(RegionCodeDecoder.ab(paramamb.hAu, paramamb.hAm, paramamb.hAn));
        ((x)localObject3).ce(paramamb.hAo);
        ((x)localObject3).de(paramamb.tLd);
        ((x)localObject3).cj(paramamb.tLe);
        ((x)localObject3).setSource(paramamb.teq);
        ((x)localObject3).dd(paramamb.tLh);
        ((x)localObject3).bU(paramamb.tLg);
        if (o.fK(paramamb.tLf)) {
          ((x)localObject3).ci(paramamb.tLf);
        }
        if (((x)localObject3).bKX()) {
          ((x)localObject3).dp((int)bf.Nz());
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((x)localObject3).cs(paramString);
        }
        ((x)localObject3).bP(n.a(paramamb.tOz));
        ((x)localObject3).bV(n.a(paramamb.tOB));
        ((x)localObject3).bW(n.a(paramamb.tOA));
        ((x)localObject3).bY(paramamb.trK);
        ((x)localObject3).cl(paramamb.tfn);
        ((x)localObject3).cm(paramamb.tPj);
        if (bf.bm(paramArrayOfByte)) {
          break label1249;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().w(str1, paramArrayOfByte);
        ((x)localObject3).dg(paramamb.tPi);
        if ((paramamb.tPe != null) && (paramamb.tPe.tdL != null))
        {
          ((x)localObject3).cn(paramamb.tPe.tdL.thK);
          ((x)localObject3).co(paramamb.tPe.tdL.thL);
          ((x)localObject3).cp(paramamb.tPe.tdL.thM);
        }
        if ((localObject2 != null) && (!com.tencent.mm.j.a.ez(((af)localObject2).field_type))) {
          com.tencent.mm.j.a.ez(((af)localObject3).field_type);
        }
        if (o.fE(str1)) {
          ((x)localObject3).tl();
        }
        if (((x)localObject3).bKU()) {
          ((x)localObject3).to();
        }
        ((x)localObject3).cq(paramamb.gkF);
        ((x)localObject3).dr(paramamb.tPn);
        int j = (int)((com.tencent.mm.j.a)localObject3).gTG;
        localObject1 = ((af)localObject3).field_nickname;
        String str3 = ((x)localObject3).pC();
        int k = ((af)localObject3).field_deleteFlag;
        int m = ((af)localObject3).field_type;
        int n = paramamb.tqP;
        int i1 = paramamb.tqQ;
        int i2 = ((af)localObject3).gkm;
        int i3 = ((af)localObject3).gkp;
        String str4 = paramamb.hAu;
        String str5 = paramamb.hAm;
        String str6 = paramamb.hAn;
        int i4 = ((x)localObject3).getSource();
        String str7 = ((af)localObject3).field_contactLabelIds;
        if (paramamb.tfn != null) {
          break label1273;
        }
        bool = true;
        if (paramamb.tfn != null) {
          break label1279;
        }
        i = 0;
        label911:
        if (paramamb.tfn != null) {
          break label1291;
        }
        paramString = "";
        label922:
        v.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)", new Object[] { str1, str2, Integer.valueOf(j), localObject1, str3, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), str4, str5, str6, Integer.valueOf(i4), str7, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        nwJ.a((x)localObject3, (x)localObject2, paramamb, paramArrayOfByte, paramBoolean2);
        if (bf.mA(str2)) {
          break label1302;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(str2, (x)localObject3);
      }
      for (;;)
      {
        nwJ.b((x)localObject3, (x)localObject2, paramamb, paramArrayOfByte, paramBoolean2);
        if ((((af)localObject3).field_type & 0x800) == 0) {
          break label1326;
        }
        if ((localObject2 != null) && ((((af)localObject2).field_type & 0x800) == (((af)localObject3).field_type & 0x800))) {
          break label1376;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rq(((af)localObject3).field_username);
        GMTrace.o(13236149682176L, 98617);
        return;
        if ((localObject2 == null) || ((int)((com.tencent.mm.j.a)localObject2).gTG <= 0)) {
          break;
        }
        ((x)localObject3).bX(((af)localObject2).field_encryptUsername);
        break;
        label1237:
        l = (int)((com.tencent.mm.j.a)localObject2).gTG;
        break label351;
        label1249:
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rg(str1);
        break label657;
        label1273:
        bool = false;
        break label901;
        label1279:
        i = paramamb.tfn.length();
        break label911;
        label1291:
        paramString = bf.Qi(paramamb.tfn);
        break label922;
        label1302:
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Q((x)localObject3);
      }
      label1326:
      if ((localObject2 == null) || ((((af)localObject2).field_type & 0x800) != (((af)localObject3).field_type & 0x800))) {
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rr(((af)localObject3).field_username);
      }
      label1376:
      GMTrace.o(13236149682176L, 98617);
      return;
      localObject2 = localObject1;
      localObject1 = null;
    }
  }
  
  public final void a(lt paramlt, byte[] paramArrayOfByte, boolean paramBoolean, r paramr)
  {
    GMTrace.i(13236015464448L, 98616);
    switch (paramlt.tqs)
    {
    }
    for (;;)
    {
      GMTrace.o(13236015464448L, 98616);
      return;
      paramlt = (amb)new amb().aD(paramArrayOfByte);
      if (paramBoolean) {}
      for (;;)
      {
        a(paramlt, "", paramArrayOfByte, false, paramBoolean);
        GMTrace.o(13236015464448L, 98616);
        return;
        paramArrayOfByte = null;
      }
      paramlt = (nd)new nd().aD(paramArrayOfByte);
      paramArrayOfByte = n.a(paramlt.trH);
      v.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[] { paramArrayOfByte });
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rk(paramArrayOfByte);
      o.eX(paramArrayOfByte);
      s.a(4, paramlt);
    }
  }
  
  private static final class a
    extends com.tencent.mm.bn.a<com.tencent.mm.plugin.messenger.foundation.a.b>
    implements com.tencent.mm.plugin.messenger.foundation.a.b
  {
    public a()
    {
      GMTrace.i(13230780973056L, 98577);
      GMTrace.o(13230780973056L, 98577);
    }
    
    public final void a(final x paramx1, final x paramx2, final amb paramamb, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      GMTrace.i(13230915190784L, 98578);
      a(new com.tencent.mm.bn.a.a() {});
      GMTrace.o(13230915190784L, 98578);
    }
    
    public final void b(final x paramx1, final x paramx2, final amb paramamb, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      GMTrace.i(13231049408512L, 98579);
      a(new com.tencent.mm.bn.a.a() {});
      GMTrace.o(13231049408512L, 98579);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/foundation/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */