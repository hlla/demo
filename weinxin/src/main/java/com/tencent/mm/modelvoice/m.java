package com.tencent.mm.modelvoice;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.c.b.i;
import com.tencent.mm.e.a.mx;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.bg;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import com.tencent.mm.y.d.c;
import java.util.HashMap;
import junit.framework.Assert;

public class m
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private u ibM;
  private bg ibN;
  private i ibO;
  private r ibP;
  private c ibQ;
  
  static
  {
    GMTrace.i(566667247616L, 4222);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(559419490304L, 4168);
        String[] arrayOfString = u.gUn;
        GMTrace.o(559419490304L, 4168);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(536065605632L, 3994);
        String[] arrayOfString = bg.gUn;
        GMTrace.o(536065605632L, 3994);
        return arrayOfString;
      }
    });
    GMTrace.o(566667247616L, 4222);
  }
  
  public m()
  {
    GMTrace.i(565325070336L, 4212);
    this.ibP = new r();
    this.ibQ = new c() {};
    GMTrace.o(565325070336L, 4212);
  }
  
  public static bg LA()
  {
    GMTrace.i(565727723520L, 4215);
    h.vG().uQ();
    if (Ly().ibN == null) {
      if (h.vI().gXW == null) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      Ly().ibN = new bg(h.vI().gXW);
      bg localbg = Ly().ibN;
      GMTrace.o(565727723520L, 4215);
      return localbg;
    }
  }
  
  public static i LB()
  {
    GMTrace.i(565861941248L, 4216);
    h.vG().uQ();
    if (Ly().ibO == null) {
      Ly().ibO = new i();
    }
    i locali = Ly().ibO;
    GMTrace.o(565861941248L, 4216);
    return locali;
  }
  
  private static m Ly()
  {
    GMTrace.i(565459288064L, 4213);
    m localm = (m)l.o(m.class);
    GMTrace.o(565459288064L, 4213);
    return localm;
  }
  
  public static u Lz()
  {
    GMTrace.i(565593505792L, 4214);
    h.vG().uQ();
    if (Ly().ibM == null) {
      if (h.vI().gXW == null) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      Ly().ibM = new u(h.vI().gXW);
      u localu = Ly().ibM;
      GMTrace.o(565593505792L, 4214);
      return localu;
    }
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(566398812160L, 4220);
    d.c.a(Integer.valueOf(34), this.ibP);
    com.tencent.mm.sdk.b.a.uql.b(this.ibQ);
    b.a(new a(), new String[] { "//voicetrymore" });
    GMTrace.o(566398812160L, 4220);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(566533029888L, 4221);
    GMTrace.o(566533029888L, 4221);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(566264594432L, 4219);
    GMTrace.o(566264594432L, 4219);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(565996158976L, 4217);
    if (Ly().ibO != null) {
      Ly().ibO.fBf = 0;
    }
    d.c.aA(Integer.valueOf(34));
    com.tencent.mm.sdk.b.a.uql.c(this.ibQ);
    b.B(new String[] { "//voicetrymore" });
    GMTrace.o(565996158976L, 4217);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(566130376704L, 4218);
    HashMap localHashMap = gJh;
    GMTrace.o(566130376704L, 4218);
    return localHashMap;
  }
  
  static final class a
    implements com.tencent.mm.pluginsdk.b.a
  {
    a()
    {
      GMTrace.i(17481053765632L, 130244);
      GMTrace.o(17481053765632L, 130244);
    }
    
    public final boolean a(Context paramContext, String[] paramArrayOfString)
    {
      GMTrace.i(17481187983360L, 130245);
      paramContext = paramArrayOfString[0];
      int i = -1;
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      do
      {
        GMTrace.o(17481187983360L, 130245);
        return false;
        if (!paramContext.equals("//voicetrymore")) {
          break;
        }
        i = 0;
        break;
      } while ((paramArrayOfString.length <= 1) || (paramArrayOfString[1] == null));
      i = bf.getInt(paramArrayOfString[1], 1);
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        i.fBi = bool;
        v.i("MicroMsg.SubCoreVoice", "summervoicetrymore enable[%d]", new Object[] { Integer.valueOf(i) });
        GMTrace.o(17481187983360L, 130245);
        return true;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */