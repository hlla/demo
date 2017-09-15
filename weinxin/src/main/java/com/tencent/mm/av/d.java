package com.tencent.mm.av;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.fg;
import com.tencent.mm.e.a.fg.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.h;
import com.tencent.mm.x.i;

public final class d
  extends com.tencent.mm.u.e
{
  public d()
  {
    GMTrace.i(1424184311808L, 10611);
    GMTrace.o(1424184311808L, 10611);
  }
  
  protected final au a(bu parambu, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(1424318529536L, 10612);
    paramString2 = com.tencent.mm.platformtools.n.a(parambu.tdz);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      v.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
      GMTrace.o(1424318529536L, 10612);
      return null;
    }
    paramString2 = au.a.RE(paramString2);
    if (((paramString2.uIi != null) || (paramString2.uIj != null)) && ((paramString2.scene == 10) || (paramString2.scene == 11)))
    {
      paramString3 = new fg();
      paramString3.fJD.fJF = paramString2.uIi;
      paramString3.fJD.fJG = paramString2.uIj;
      com.tencent.mm.sdk.b.a.uql.m(paramString3);
      if (paramString3.fJE.fJH)
      {
        v.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
        GMTrace.o(1424318529536L, 10612);
        return null;
      }
    }
    if (paramString2.oty > 0L) {
      com.tencent.mm.x.b.d(paramString2.oty, paramString2.uIh);
    }
    if (bf.mz(paramString2.rTh).length() > 0)
    {
      paramString3 = new h();
      paramString3.username = paramString2.rTh;
      paramString3.gkg = 3;
      paramString3.aV(true);
      paramString3.fRM = -1;
      paramString3.hrk = paramString2.uIk;
      paramString3.hrj = paramString2.uIl;
      paramString3.fRM = -1;
      v.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { paramString2.rTh, paramString3.Bs(), paramString3.Bt() });
      com.tencent.mm.x.n.Bm().a(paramString3);
    }
    paramString3 = new f();
    paramString3.field_createTime = e.i(paramString1, parambu.ofk);
    paramString3.field_isSend = 0;
    paramString3.field_msgContent = com.tencent.mm.platformtools.n.a(parambu.tdz);
    paramString3.field_svrId = parambu.tdE;
    paramString3.field_talker = paramString2.rTh;
    paramString3.field_type = 0;
    parambu = l.Kz().kZ(paramString3.field_talker);
    if (parambu != null)
    {
      v.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + paramString3.field_talker + " , real talker = " + parambu.field_talker);
      paramString3.field_encryptTalker = paramString3.field_talker;
      paramString3.field_talker = parambu.field_talker;
    }
    ap.yY();
    parambu = com.tencent.mm.u.c.wR().Rb(paramString3.field_talker);
    if ((parambu != null) && (com.tencent.mm.j.a.ez(parambu.field_type)) && (parambu.gTG > 0L))
    {
      v.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + paramString3.field_talker + " has already been in user's contact list");
      GMTrace.o(1424318529536L, 10612);
      return null;
    }
    l.Ky().a(paramString3);
    GMTrace.o(1424318529536L, 10612);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/av/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */