package com.tencent.mm.plugin.subapp.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class b
  implements d, e
{
  private Queue<a> qRp;
  private boolean qRq;
  
  public b()
  {
    GMTrace.i(5848269062144L, 43573);
    this.qRp = null;
    this.qRq = false;
    GMTrace.o(5848269062144L, 43573);
  }
  
  private void bmP()
  {
    GMTrace.i(5848537497600L, 43575);
    if (this.qRq)
    {
      GMTrace.o(5848537497600L, 43575);
      return;
    }
    if (this.qRp.size() == 0)
    {
      GMTrace.o(5848537497600L, 43575);
      return;
    }
    Object localObject = (a)this.qRp.peek();
    if (((a)localObject).qRr.size() == 0)
    {
      this.qRp.poll();
      ap.yY();
      c.vr().set(8193, ((a)localObject).ira);
      ap.yY();
      c.vr().set(8449, Long.valueOf(bf.Nz()));
      GMTrace.o(5848537497600L, 43575);
      return;
    }
    localObject = (String)((a)localObject).qRr.peek();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      GMTrace.o(5848537497600L, 43575);
      return;
    }
    this.qRq = true;
    localObject = new a((String)localObject);
    ap.vd().a(141, this);
    ap.vd().a((k)localObject, 0);
    GMTrace.o(5848537497600L, 43575);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(5848671715328L, 43576);
    if (paramk.getType() != 141)
    {
      this.qRq = false;
      GMTrace.o(5848671715328L, 43576);
      return;
    }
    ap.vd().b(141, this);
    paramString = ((a)paramk).url;
    paramk = (a)this.qRp.peek();
    if ((paramk == null) || (paramk.qRr.size() == 0))
    {
      v.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
      this.qRp = new LinkedList();
      this.qRq = false;
      GMTrace.o(5848671715328L, 43576);
      return;
    }
    if (paramk.qRr.size() == 0)
    {
      v.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
      this.qRp.poll();
      this.qRq = false;
      GMTrace.o(5848671715328L, 43576);
      return;
    }
    if (!((String)paramk.qRr.peek()).equals(paramString))
    {
      v.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
      this.qRp.poll();
      this.qRq = false;
      GMTrace.o(5848671715328L, 43576);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      v.e("MicroMsg.PushMessageExtension", "down failed [" + paramInt1 + "," + paramInt2 + "] ignore this message : img:[" + paramString + "] ");
      this.qRp.poll();
      this.qRq = false;
      GMTrace.o(5848671715328L, 43576);
      return;
    }
    paramk.qRr.poll();
    this.qRq = false;
    bmP();
    GMTrace.o(5848671715328L, 43576);
  }
  
  public final d.b b(d.a parama)
  {
    GMTrace.i(5848403279872L, 43574);
    parama = com.tencent.mm.platformtools.n.a(parama.hsc.tdz);
    if (this.qRp == null) {
      this.qRp = new LinkedList();
    }
    parama = new a(parama);
    if (parama.ira != null)
    {
      this.qRp.offer(parama);
      bmP();
    }
    GMTrace.o(5848403279872L, 43574);
    return null;
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(5848805933056L, 43577);
    GMTrace.o(5848805933056L, 43577);
  }
  
  static final class a
  {
    public String ira;
    public Queue<String> qRr;
    
    a(String paramString)
    {
      GMTrace.i(5848134844416L, 43572);
      this.ira = paramString;
      this.qRr = new LinkedList();
      v.d("MicroMsg.PushMessageExtension", "DoSceneStruct:" + paramString);
      paramString = com.tencent.mm.pluginsdk.l.a.a.aT(aa.getContext(), paramString);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        v.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
        GMTrace.o(5848134844416L, 43572);
        return;
      }
      int i = 0;
      while (i < paramString.size())
      {
        Object localObject = ((com.tencent.mm.pluginsdk.l.a.a)paramString.get(i)).sFB;
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext()) {
            this.qRr.offer(((Map.Entry)((Iterator)localObject).next()).getValue());
          }
        }
        i += 1;
      }
      GMTrace.o(5848134844416L, 43572);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */