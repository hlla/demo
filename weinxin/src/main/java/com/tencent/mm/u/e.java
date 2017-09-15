package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bn.a.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;

public class e
  implements d
{
  private static final a hkI;
  
  static
  {
    GMTrace.i(13291447386112L, 99029);
    hkI = new a();
    GMTrace.o(13291447386112L, 99029);
  }
  
  public e()
  {
    GMTrace.i(13290776297472L, 99024);
    GMTrace.o(13290776297472L, 99024);
  }
  
  public static void a(com.tencent.mm.plugin.messenger.foundation.a.a parama)
  {
    GMTrace.i(13290910515200L, 99025);
    hkI.bI(parama);
    GMTrace.o(13290910515200L, 99025);
  }
  
  public au a(bu parambu, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(13291178950656L, 99027);
    if (paramString3.equals(paramString1)) {}
    for (paramString3 = paramString2;; paramString3 = paramString1)
    {
      au localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().x(paramString3, parambu.tdE);
      v.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[] { Long.valueOf(parambu.tdE), Long.valueOf(localau.field_msgId), paramString1, paramString2, paramString3 });
      if ((localau.field_msgId != 0L) && (localau.field_createTime + 604800000L < ay.i(paramString3, parambu.ofk)))
      {
        v.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(parambu.tdE), Long.valueOf(localau.field_msgId) });
        ay.L(localau.field_msgId);
        localau.x(0L);
      }
      paramString1 = localau;
      if (localau.field_msgId == 0L)
      {
        paramString1 = new au();
        paramString1.y(parambu.tdE);
        paramString1.z(ay.i(paramString3, parambu.ofk));
        paramString1.setType(parambu.mrC);
        paramString1.setContent(bf.Qm(bf.mz(n.a(parambu.tdz))));
      }
      GMTrace.o(13291178950656L, 99027);
      return paramString1;
    }
  }
  
  public d.b b(d.a parama)
  {
    GMTrace.i(13291044732928L, 99026);
    Object localObject1 = parama.hsc;
    Object localObject2 = (String)com.tencent.mm.kernel.h.vI().vr().get(2, "");
    if (((String)localObject2).length() <= 0)
    {
      GMTrace.o(13291044732928L, 99026);
      return null;
    }
    String str1 = n.a(((bu)localObject1).tdx);
    String str2 = n.a(((bu)localObject1).tdy);
    if ((bf.mz(str1).length() <= 0) || (bf.mz(str2).length() <= 0))
    {
      v.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
      GMTrace.o(13291044732928L, 99026);
      return null;
    }
    au localau = a((bu)localObject1, str1, str2, (String)localObject2);
    if (localau == null)
    {
      GMTrace.o(13291044732928L, 99026);
      return null;
    }
    boolean bool;
    int i;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wZ().has(str1)) || (((String)localObject2).equals(str1)))
    {
      bool = true;
      if (!bool) {
        break label331;
      }
      localau.dw(1);
      localau.cH(str2);
      i = ((bu)localObject1).jLP;
      label195:
      localau.dv(i);
      if (((bu)localObject1).mrC == 10000) {
        localau.dv(4);
      }
      localau.cN(((bu)localObject1).tdC);
      hkI.a(parama, localau, str1, str2, bool);
      if (localau.field_msgId != 0L) {
        break label367;
      }
      ay.a(localau, parama);
      localau.x(ay.i(localau));
      localObject2 = new d.b(localau, true);
      localObject1 = localObject2;
      if (!parama.hsd) {
        az.k(localau.field_talker, parama.hsc.ofk * 1000L);
      }
    }
    for (localObject1 = localObject2;; localObject1 = new d.b(localau, false))
    {
      GMTrace.o(13291044732928L, 99026);
      return (d.b)localObject1;
      bool = false;
      break;
      label331:
      localau.dw(0);
      localau.cH(str1);
      if (((bu)localObject1).jLP > 3)
      {
        i = ((bu)localObject1).jLP;
        break label195;
      }
      i = 3;
      break label195;
      label367:
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().b(((bu)localObject1).tdE, localau);
    }
  }
  
  public void h(au paramau)
  {
    GMTrace.i(13291313168384L, 99028);
    GMTrace.o(13291313168384L, 99028);
  }
  
  private static final class a
    extends com.tencent.mm.bn.a<com.tencent.mm.plugin.messenger.foundation.a.a>
    implements com.tencent.mm.plugin.messenger.foundation.a.a
  {
    public a()
    {
      GMTrace.i(13290373644288L, 99021);
      GMTrace.o(13290373644288L, 99021);
    }
    
    public final void a(final d.a parama, final au paramau, final String paramString1, final String paramString2, final boolean paramBoolean)
    {
      GMTrace.i(13290507862016L, 99022);
      a(new a.a() {});
      GMTrace.o(13290507862016L, 99022);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */