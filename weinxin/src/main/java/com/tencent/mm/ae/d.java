package com.tencent.mm.ae;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bn;
import java.util.HashMap;

public class d
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private b hDD;
  private c hDE;
  
  static
  {
    GMTrace.i(4091090567168L, 30481);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4089614172160L, 30470);
        String[] arrayOfString = b.gUn;
        GMTrace.o(4089614172160L, 30470);
        return arrayOfString;
      }
    });
    GMTrace.o(4091090567168L, 30481);
  }
  
  public d()
  {
    GMTrace.i(4090016825344L, 30473);
    GMTrace.o(4090016825344L, 30473);
  }
  
  private static d Gs()
  {
    GMTrace.i(4090151043072L, 30474);
    com.tencent.mm.plugin.subapp.a locala = (com.tencent.mm.plugin.subapp.a)ap.yR().gs("plugin.subapp");
    d locald2 = (d)locala.Hh(d.class.getName());
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      locala.b(d.class.getName(), locald1);
    }
    GMTrace.o(4090151043072L, 30474);
    return locald1;
  }
  
  public static b Gt()
  {
    GMTrace.i(4090285260800L, 30475);
    h.vG().uQ();
    if (Gs().hDD == null)
    {
      localObject = Gs();
      ap.yY();
      ((d)localObject).hDD = new b(com.tencent.mm.u.c.wO());
    }
    Object localObject = Gs().hDD;
    GMTrace.o(4090285260800L, 30475);
    return (b)localObject;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(4090822131712L, 30479);
    if (this.hDE == null) {
      this.hDE = new c();
    }
    com.tencent.mm.u.ag.a.hlA = this.hDE;
    v.d("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[] { this.hDE });
    GMTrace.o(4090822131712L, 30479);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(4090956349440L, 30480);
    GMTrace.o(4090956349440L, 30480);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(4090687913984L, 30478);
    GMTrace.o(4090687913984L, 30478);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(4090419478528L, 30476);
    GMTrace.o(4090419478528L, 30476);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(4090553696256L, 30477);
    HashMap localHashMap = gJh;
    GMTrace.o(4090553696256L, 30477);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ae/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */