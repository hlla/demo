package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.y.k;

public final class e
  extends k
  implements j
{
  private com.tencent.mm.y.e gUt;
  private com.tencent.mm.network.p htc;
  private String mGi;
  private int uin;
  
  public e(String paramString, int paramInt)
  {
    GMTrace.i(8009040265216L, 59672);
    this.gUt = null;
    this.mGi = null;
    this.uin = 0;
    this.mGi = paramString;
    this.uin = paramInt;
    GMTrace.o(8009040265216L, 59672);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(8009174482944L, 59673);
    this.gUt = parame1;
    this.htc = new a();
    ((a)this.htc).uin = this.uin;
    ((c.a)this.htc.BG()).mGe.tax = this.mGi;
    int i = a(parame, this.htc, this);
    GMTrace.o(8009174482944L, 59673);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(8009442918400L, 59675);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(8009442918400L, 59675);
  }
  
  public final int getType()
  {
    GMTrace.i(8009308700672L, 59674);
    GMTrace.o(8009308700672L, 59674);
    return 623;
  }
  
  public static final class a
    implements com.tencent.mm.network.p
  {
    private final c.a mGj;
    private final c.b mGk;
    int uin;
    
    public a()
    {
      GMTrace.i(8010919313408L, 59686);
      this.mGj = new c.a();
      this.mGk = new c.b();
      GMTrace.o(8010919313408L, 59686);
    }
    
    public final int BD()
    {
      GMTrace.i(8011590402048L, 59691);
      GMTrace.o(8011590402048L, 59691);
      return 0;
    }
    
    public final k.d BG()
    {
      GMTrace.i(8011321966592L, 59689);
      this.mGj.sXP = com.tencent.mm.compatible.d.p.rB();
      this.mGj.sXO = d.DEVICE_TYPE;
      this.mGj.sXN = d.sXh;
      this.mGj.dj(this.uin);
      c.a locala = this.mGj;
      GMTrace.o(8011321966592L, 59689);
      return locala;
    }
    
    public final boolean BH()
    {
      GMTrace.i(8011456184320L, 59690);
      GMTrace.o(8011456184320L, 59690);
      return false;
    }
    
    public final int getType()
    {
      GMTrace.i(8011053531136L, 59687);
      GMTrace.o(8011053531136L, 59687);
      return 623;
    }
    
    public final String getUri()
    {
      GMTrace.i(8011187748864L, 59688);
      GMTrace.o(8011187748864L, 59688);
      return "/cgi-bin/micromsg-bin/androidgcmreg";
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gcm/modelgcm/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */