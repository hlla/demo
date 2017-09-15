package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.y.k;

public final class f
  extends k
  implements j
{
  private com.tencent.mm.y.e gUt;
  private com.tencent.mm.network.p htc;
  private String mGi;
  private int uin;
  
  public f(String paramString, int paramInt)
  {
    GMTrace.i(8017495982080L, 59735);
    this.gUt = null;
    this.uin = 0;
    this.mGi = null;
    this.mGi = paramString;
    this.uin = paramInt;
    GMTrace.o(8017495982080L, 59735);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(8017630199808L, 59736);
    this.gUt = parame1;
    this.htc = new a();
    ((a)this.htc).uin = this.uin;
    ((d.a)this.htc.BG()).mGg.tax = this.mGi;
    int i = a(parame, this.htc, this);
    GMTrace.o(8017630199808L, 59736);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(8017898635264L, 59738);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(8017898635264L, 59738);
  }
  
  public final int getType()
  {
    GMTrace.i(8017764417536L, 59737);
    GMTrace.o(8017764417536L, 59737);
    return 624;
  }
  
  public static final class a
    implements com.tencent.mm.network.p
  {
    private final d.a mGl;
    private final d.b mGm;
    int uin;
    
    public a()
    {
      GMTrace.i(8009577136128L, 59676);
      this.mGl = new d.a();
      this.mGm = new d.b();
      GMTrace.o(8009577136128L, 59676);
    }
    
    public final int BD()
    {
      GMTrace.i(8010248224768L, 59681);
      GMTrace.o(8010248224768L, 59681);
      return 0;
    }
    
    public final k.d BG()
    {
      GMTrace.i(8009979789312L, 59679);
      this.mGl.sXP = com.tencent.mm.compatible.d.p.rB();
      this.mGl.sXO = d.DEVICE_TYPE;
      this.mGl.sXN = d.sXh;
      this.mGl.dj(this.uin);
      d.a locala = this.mGl;
      GMTrace.o(8009979789312L, 59679);
      return locala;
    }
    
    public final boolean BH()
    {
      GMTrace.i(8010114007040L, 59680);
      GMTrace.o(8010114007040L, 59680);
      return false;
    }
    
    public final int getType()
    {
      GMTrace.i(8009711353856L, 59677);
      GMTrace.o(8009711353856L, 59677);
      return 624;
    }
    
    public final String getUri()
    {
      GMTrace.i(8009845571584L, 59678);
      GMTrace.o(8009845571584L, 59678);
      return "/cgi-bin/micromsg-bin/androidgcmunreg";
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gcm/modelgcm/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */