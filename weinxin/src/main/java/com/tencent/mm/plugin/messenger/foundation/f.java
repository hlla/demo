package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bn.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.r.c;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.p.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  implements com.tencent.mm.plugin.zero.a.f
{
  private r nxc;
  
  public f()
  {
    GMTrace.i(13234136416256L, 98602);
    GMTrace.o(13234136416256L, 98602);
  }
  
  public final void a(lt paramlt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    GMTrace.i(13234404851712L, 98604);
    p localp = p.a.pg(paramlt.tqs);
    if (localp != null) {
      try
      {
        localp.a(paramlt, paramArrayOfByte, paramBoolean, this.nxc);
        GMTrace.o(13234404851712L, 98604);
        return;
      }
      catch (IOException paramlt)
      {
        v.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + paramlt.getMessage());
        throw new RuntimeException("docmd: parse protobuf error");
      }
    }
    v.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[] { Integer.valueOf(paramlt.tqs) });
    GMTrace.o(13234404851712L, 98604);
  }
  
  public final void aX(Object paramObject)
  {
    GMTrace.i(13234270633984L, 98603);
    b localb = com.tencent.mm.plugin.messenger.foundation.a.s.aJR();
    if (localb != null) {
      this.nxc = ((r)localb.get());
    }
    if (this.nxc == null) {
      this.nxc = new a();
    }
    if ((paramObject instanceof l))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ac(((l)paramObject).TAG);
      GMTrace.o(13234270633984L, 98603);
      return;
    }
    if ((paramObject instanceof String))
    {
      if (paramObject.equals("NetSceneInit"))
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ac((String)paramObject);
        GMTrace.o(13234270633984L, 98603);
      }
    }
    else if ((paramObject instanceof r.c)) {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ac(paramObject.toString());
    }
    GMTrace.o(13234270633984L, 98603);
  }
  
  public final void aY(Object paramObject)
  {
    GMTrace.i(13234539069440L, 98605);
    if ((paramObject instanceof l))
    {
      this.nxc.acL();
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ad(((l)paramObject).TAG);
      ae localae = com.tencent.mm.kernel.h.vL();
      String str = ((l)paramObject).TAG;
      com.tencent.mm.modelmulti.s locals = ((l)paramObject).hKA;
      paramObject = (l)paramObject;
      if ((((l)paramObject).hKI == null) || (((l)paramObject).hKI.sYx.tmy == null)) {}
      for (paramObject = null;; paramObject = ((l)paramObject).hKI.sYx.tmy.jLs)
      {
        localae.D(new b(str, locals, (LinkedList)paramObject));
        GMTrace.o(13234539069440L, 98605);
        return;
      }
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      this.nxc.acL();
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ad((String)paramObject);
      GMTrace.o(13234539069440L, 98605);
      return;
    }
    if ((paramObject instanceof r.c))
    {
      this.nxc.acL();
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ad(paramObject.toString());
    }
    GMTrace.o(13234539069440L, 98605);
  }
  
  public final void aZ(Object paramObject)
  {
    GMTrace.i(13234673287168L, 98606);
    if ((paramObject instanceof l)) {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ad(((l)paramObject).TAG);
    }
    GMTrace.o(13234673287168L, 98606);
  }
  
  private static final class a
    implements r
  {
    public a()
    {
      GMTrace.i(13237626077184L, 98628);
      GMTrace.o(13237626077184L, 98628);
    }
    
    public final void a(au paramau, bu parambu)
    {
      GMTrace.i(13237894512640L, 98630);
      GMTrace.o(13237894512640L, 98630);
    }
    
    public final void acL()
    {
      GMTrace.i(13237760294912L, 98629);
      GMTrace.o(13237760294912L, 98629);
    }
  }
  
  static final class b
    implements Runnable
  {
    private String TAG;
    private final com.tencent.mm.modelmulti.s hKA;
    private final LinkedList<lt> lDO;
    private int nxd;
    
    public b(String paramString, com.tencent.mm.modelmulti.s params, LinkedList<lt> paramLinkedList)
    {
      GMTrace.i(13240847302656L, 98652);
      this.TAG = paramString;
      this.hKA = params;
      this.lDO = paramLinkedList;
      GMTrace.o(13240847302656L, 98652);
    }
    
    public final void run()
    {
      GMTrace.i(13240981520384L, 98653);
      int i;
      if (this.hKA != null)
      {
        i = this.hKA.hMu;
        if ((i == 3) || ((!this.hKA.hMt) && ((i == 1) || (i == 2) || (i == 8))))
        {
          this.nxd = 0;
          Iterator localIterator = this.lDO.iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = (lt)localIterator.next();
            Object localObject2 = n.a(((lt)localObject1).tqt);
            if (((lt)localObject1).tqs == 5) {
              try
              {
                localObject1 = ((bu)new bu().aD((byte[])localObject2)).tdx.toString();
                localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb((String)localObject1);
                if ((((String)localObject1).endsWith("@chatroom")) && (((af)localObject2).gkp == 0)) {
                  this.nxd += 1;
                }
              }
              catch (IOException localIOException)
              {
                v.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + localIOException.getMessage());
              }
            }
          }
          if (this.nxd > 0)
          {
            if (this.nxd > 5) {
              break label344;
            }
            com.tencent.mm.plugin.report.c.oRz.a(202L, this.nxd, 1L, false);
            v.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.nxd);
            switch (i)
            {
            }
          }
        }
      }
      for (;;)
      {
        v.i(this.TAG, "muteroom idkeyStat:aiScene = " + i);
        GMTrace.o(13240981520384L, 98653);
        return;
        label344:
        if (this.nxd <= 10)
        {
          com.tencent.mm.plugin.report.c.oRz.a(202L, 6L, 1L, false);
          break;
        }
        if (this.nxd <= 15)
        {
          com.tencent.mm.plugin.report.c.oRz.a(202L, 7L, 1L, false);
          break;
        }
        if (this.nxd <= 20)
        {
          com.tencent.mm.plugin.report.c.oRz.a(202L, 8L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.c.oRz.a(202L, 9L, 1L, false);
        break;
        com.tencent.mm.plugin.report.c.oRz.a(202L, 10L, 1L, false);
        continue;
        com.tencent.mm.plugin.report.c.oRz.a(202L, 11L, 1L, false);
        continue;
        com.tencent.mm.plugin.report.c.oRz.a(202L, 12L, 1L, false);
        continue;
        com.tencent.mm.plugin.report.c.oRz.a(202L, 13L, 1L, false);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/foundation/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */