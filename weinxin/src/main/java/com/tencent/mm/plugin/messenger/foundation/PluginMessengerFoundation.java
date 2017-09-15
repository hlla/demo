package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ao.j;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.p.a;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bc;
import com.tencent.mm.u.bp;
import com.tencent.mm.u.l;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.c;
import java.util.HashMap;

public class PluginMessengerFoundation
  extends com.tencent.mm.kernel.b.d
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, n
{
  private com.tencent.mm.u.e hlN;
  private d nwX;
  private e nwY;
  private bp nwZ;
  private com.tencent.mm.plugin.chatroom.b nxa;
  
  public PluginMessengerFoundation()
  {
    GMTrace.i(13238162948096L, 98632);
    this.hlN = new com.tencent.mm.u.e();
    this.nwZ = new bp();
    this.nxa = new com.tencent.mm.plugin.chatroom.b();
    GMTrace.o(13238162948096L, 98632);
  }
  
  public HashMap<Integer, g.c> collectDatabaseFactory()
  {
    GMTrace.i(13238968254464L, 98638);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(13236552335360L, 98620);
        String[] arrayOfString = av.gUn;
        GMTrace.o(13236552335360L, 98620);
        return arrayOfString;
      }
    });
    localHashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(13241249955840L, 98655);
        String[] arrayOfString = ad.gUn;
        GMTrace.o(13241249955840L, 98655);
        return arrayOfString;
      }
    });
    localHashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(13240176214016L, 98647);
        String[] arrayOfString = j.gUn;
        GMTrace.o(13240176214016L, 98647);
        return arrayOfString;
      }
    });
    localHashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(13240713084928L, 98651);
        String[] arrayOfString = af.gUn;
        GMTrace.o(13240713084928L, 98651);
        return arrayOfString;
      }
    });
    localHashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(13237491859456L, 98627);
        String[] arrayOfString = az.gUn;
        GMTrace.o(13237491859456L, 98627);
        return arrayOfString;
      }
    });
    localHashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(13240444649472L, 98649);
        String[] arrayOfString = bc.gUn;
        GMTrace.o(13240444649472L, 98649);
        return arrayOfString;
      }
    });
    localHashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(13230646755328L, 98576);
        String[] arrayOfString = ai.gUn;
        GMTrace.o(13230646755328L, 98576);
        return arrayOfString;
      }
    });
    GMTrace.o(13238968254464L, 98638);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.e parame)
  {
    GMTrace.i(13238565601280L, 98635);
    v.i("MicroMsg.TAG", "init thread pool[%s] current tid[%d] priority[%d] process[%s]", new Object[] { com.tencent.mm.sdk.f.e.bKi(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(Thread.currentThread().getPriority()), ((com.tencent.mm.kernel.b.f)com.tencent.mm.kernel.h.vF().vj()).gWE });
    com.tencent.mm.plugin.zero.c.szy = new com.tencent.mm.bn.b() {};
    Object localObject = new a();
    p.a.a(2, (p)localObject);
    p.a.a(17, (p)localObject);
    p.a.a(4, (p)localObject);
    p.a.a(7, new b());
    localObject = new c();
    p.a.a(5, (p)localObject);
    p.a.a(8, (p)localObject);
    p.a.a(9, (p)localObject);
    p.a.a(1, new g());
    com.tencent.mm.kernel.h.vE().a(com.tencent.mm.plugin.messenger.foundation.a.o.class, new com.tencent.mm.kernel.c.c(new com.tencent.mm.modelmulti.o()));
    localObject = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.zero.a.d.class);
    if (parame.ej(""))
    {
      new com.tencent.mm.plugin.zero.tasks.b().after((com.tencent.mm.kernel.b.a)localObject).before(this);
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.messenger.foundation.a.c.class, new com.tencent.mm.plugin.messenger.foundation.a.c()
      {
        public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.b paramAnonymousb)
        {
          GMTrace.i(13232391585792L, 98589);
          paramAnonymousb = a.a(paramAnonymousb);
          GMTrace.o(13232391585792L, 98589);
          return paramAnonymousb;
        }
        
        public final void a(amb paramAnonymousamb, String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          GMTrace.i(13232257368064L, 98588);
          a.a(paramAnonymousamb, paramAnonymousString, null, true, false);
          GMTrace.o(13232257368064L, 98588);
        }
      });
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.messenger.foundation.a.g.class, new com.tencent.mm.plugin.messenger.foundation.a.g()
      {
        public final void a(d.a paramAnonymousa, com.tencent.mm.plugin.messenger.foundation.a.r paramAnonymousr)
        {
          GMTrace.i(13234941722624L, 98608);
          c.a(paramAnonymousa, paramAnonymousr);
          GMTrace.o(13234941722624L, 98608);
        }
      });
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.chatroom.b.a.class, this.nxa);
    }
    GMTrace.o(13238565601280L, 98635);
  }
  
  public void dependency()
  {
    GMTrace.i(13238431383552L, 98634);
    dependsOn(PluginZero.class);
    GMTrace.o(13238431383552L, 98634);
  }
  
  public void execute(com.tencent.mm.kernel.b.e parame)
  {
    GMTrace.i(13238699819008L, 98636);
    if (parame.ej(""))
    {
      this.nwX = new d();
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.messenger.foundation.a.h.class, new com.tencent.mm.kernel.c.c(this.nwX));
      this.nwY = new e();
      com.tencent.mm.kernel.h.a(i.class, new com.tencent.mm.kernel.c.c(this.nwY));
    }
    GMTrace.o(13238699819008L, 98636);
  }
  
  public bp getSysCmdMsgExtension()
  {
    GMTrace.i(14605707378688L, 108821);
    bp localbp = this.nwZ;
    GMTrace.o(14605707378688L, 108821);
    return localbp;
  }
  
  public void installed()
  {
    GMTrace.i(13238297165824L, 98633);
    alias(n.class);
    GMTrace.o(13238297165824L, 98633);
  }
  
  public void onAccountInitialized(e.f paramf)
  {
    GMTrace.i(13239102472192L, 98639);
    d.c.a(Integer.valueOf(10000), this.hlN);
    d.c.a(Integer.valueOf(1), this.hlN);
    d.c.a(Integer.valueOf(10001), this.nwZ);
    d.c.a(Integer.valueOf(10002), this.nwZ);
    GMTrace.o(13239102472192L, 98639);
  }
  
  public void onAccountRelease()
  {
    GMTrace.i(13239236689920L, 98640);
    d.c.aA(Integer.valueOf(10000));
    d.c.aA(Integer.valueOf(1));
    d.c.a(Integer.valueOf(10001), this.nwZ);
    d.c.a(Integer.valueOf(10002), this.nwZ);
    GMTrace.o(13239236689920L, 98640);
  }
  
  public void onDataBaseClosed(com.tencent.mm.bj.g paramg1, com.tencent.mm.bj.g paramg2)
  {
    GMTrace.i(13239907778560L, 98645);
    GMTrace.o(13239907778560L, 98645);
  }
  
  public void onDataBaseOpened(com.tencent.mm.bj.g paramg1, com.tencent.mm.bj.g paramg2)
  {
    GMTrace.i(13239505125376L, 98642);
    paramg2 = this.nwX;
    paramg2.nwU = new com.tencent.mm.ao.r(new j(paramg1));
    paramg2.nwQ = new ad(paramg1);
    paramg2.nwR = new bc(paramg1);
    paramg2.nwT = new af(paramg1);
    paramg2.nwS = new av(paramg1, paramg2.nwQ, paramg2.nwT);
    paramg2.nwS.a(paramg2.nwT, null);
    paramg2.nwV = new az(paramg1);
    paramg2.nwW = new ai(paramg1);
    l.xJ();
    GMTrace.o(13239505125376L, 98642);
  }
  
  public String toString()
  {
    GMTrace.i(13238834036736L, 98637);
    GMTrace.o(13238834036736L, 98637);
    return "plugin-messenger-foundation";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/foundation/PluginMessengerFoundation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */