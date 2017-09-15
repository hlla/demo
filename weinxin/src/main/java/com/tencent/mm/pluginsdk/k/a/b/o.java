package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.c.po;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.protocal.q.b;
import com.tencent.mm.y.i;
import java.util.LinkedList;

public final class o
  extends n
{
  public o()
  {
    GMTrace.i(847048081408L, 6311);
    GMTrace.o(847048081408L, 6311);
  }
  
  public static void acB()
  {
    GMTrace.i(16426370859008L, 122386);
    o localo = new o();
    h.vH().gXs.a(localo, 0);
    GMTrace.o(16426370859008L, 122386);
  }
  
  protected final p bDs()
  {
    GMTrace.i(847584952320L, 6315);
    a locala = new a();
    q.a locala1 = (q.a)locala.sEG;
    locala1.dj(0);
    locala1.sYk.tub.ttZ.tpF.addAll(this.sEC);
    GMTrace.o(847584952320L, 6315);
    return locala;
  }
  
  protected final String getTag()
  {
    GMTrace.i(847182299136L, 6312);
    GMTrace.o(847182299136L, 6312);
    return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneEncryptCheckResUpdate";
  }
  
  public final int getType()
  {
    GMTrace.i(847450734592L, 6314);
    GMTrace.o(847450734592L, 6314);
    return 722;
  }
  
  protected final kx h(p paramp)
  {
    GMTrace.i(847316516864L, 6313);
    paramp = ((a)paramp).sEH.sYn;
    GMTrace.o(847316516864L, 6313);
    return paramp;
  }
  
  private static final class a
    extends i
  {
    final q.a sEG;
    public final q.b sEH;
    
    public a()
    {
      GMTrace.i(852819443712L, 6354);
      this.sEG = new q.a();
      this.sEH = new q.b();
      GMTrace.o(852819443712L, 6354);
    }
    
    public final int BD()
    {
      GMTrace.i(853490532352L, 6359);
      GMTrace.o(853490532352L, 6359);
      return 1;
    }
    
    public final int getType()
    {
      GMTrace.i(853087879168L, 6356);
      GMTrace.o(853087879168L, 6356);
      return 722;
    }
    
    public final String getUri()
    {
      GMTrace.i(853222096896L, 6357);
      GMTrace.o(853222096896L, 6357);
      return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
    }
    
    protected final k.d zf()
    {
      GMTrace.i(852953661440L, 6355);
      q.a locala = this.sEG;
      GMTrace.o(852953661440L, 6355);
      return locala;
    }
    
    public final k.e zg()
    {
      GMTrace.i(853356314624L, 6358);
      q.b localb = this.sEH;
      GMTrace.o(853356314624L, 6358);
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */