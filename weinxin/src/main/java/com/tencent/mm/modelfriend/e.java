package com.tencent.mm.modelfriend;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.x.h;
import com.tencent.mm.x.i;

public final class e
  extends com.tencent.mm.u.e
{
  public e()
  {
    GMTrace.i(4456431222784L, 33203);
    GMTrace.o(4456431222784L, 33203);
  }
  
  protected final au a(bu parambu, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(4456565440512L, 33204);
    Object localObject = com.tencent.mm.platformtools.n.a(parambu.tdz);
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      v.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
      GMTrace.o(4456565440512L, 33204);
      return null;
    }
    localObject = au.a.RE((String)localObject);
    if (bf.mz(((au.a)localObject).rTh).length() > 0)
    {
      h localh = new h();
      localh.username = ((au.a)localObject).rTh;
      localh.gkg = 3;
      localh.aV(true);
      localh.hrk = ((au.a)localObject).uIk;
      localh.hrj = ((au.a)localObject).uIl;
      localh.fRM = -1;
      v.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { ((au.a)localObject).rTh, localh.Bs(), localh.Bt() });
      com.tencent.mm.x.n.Bm().a(localh);
    }
    parambu = super.a(parambu, paramString1, paramString2, paramString3);
    GMTrace.o(4456565440512L, 33204);
    return parambu;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */