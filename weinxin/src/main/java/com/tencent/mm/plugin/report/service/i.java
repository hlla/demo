package com.tencent.mm.plugin.report.service;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.report.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import java.util.HashMap;

public class i
  implements am
{
  private static HashMap<Integer, g.c> oSU;
  private g.a oSV;
  private c oSW;
  
  static
  {
    GMTrace.i(13110790324224L, 97683);
    HashMap localHashMap = new HashMap();
    oSU = localHashMap;
    localHashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(13115085291520L, 97715);
        String[] arrayOfString = b.gUn;
        GMTrace.o(13115085291520L, 97715);
        return arrayOfString;
      }
    });
    GMTrace.o(13110790324224L, 97683);
  }
  
  public i()
  {
    GMTrace.i(13109850800128L, 97676);
    this.oSW = new c() {};
    GMTrace.o(13109850800128L, 97676);
  }
  
  private static i aXE()
  {
    GMTrace.i(13110656106496L, 97682);
    i locali = (i)com.tencent.mm.u.l.o(i.class);
    GMTrace.o(13110656106496L, 97682);
    return locali;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(13110387671040L, 97680);
    long l = System.currentTimeMillis();
    String str = h.vI().cachePath + "CommonOneMicroMsg.db";
    this.oSV = g.a(hashCode(), str, oSU, false);
    v.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l), bf.bJP() });
    com.tencent.mm.sdk.b.a.uql.b(this.oSW);
    h.vJ();
    h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13111058759680L, 97685);
        if (!h.vG().uV())
        {
          GMTrace.o(13111058759680L, 97685);
          return;
        }
        bf.d(h.vI().cachePath + "logcat/", "temp_", 10800000L);
        GMTrace.o(13111058759680L, 97685);
      }
      
      public final String toString()
      {
        GMTrace.i(13111192977408L, 97686);
        String str = super.toString() + "|onAccountPostReset";
        GMTrace.o(13111192977408L, 97686);
        return str;
      }
    });
    GMTrace.o(13110387671040L, 97680);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(13110521888768L, 97681);
    GMTrace.o(13110521888768L, 97681);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(13110253453312L, 97679);
    GMTrace.o(13110253453312L, 97679);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(13109985017856L, 97677);
    if (aXE() != null)
    {
      i locali = aXE();
      if (locali.oSV != null)
      {
        locali.oSV.gZ(locali.hashCode());
        locali.oSV = null;
      }
    }
    com.tencent.mm.sdk.b.a.uql.c(this.oSW);
    GMTrace.o(13109985017856L, 97677);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(13110119235584L, 97678);
    GMTrace.o(13110119235584L, 97678);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */