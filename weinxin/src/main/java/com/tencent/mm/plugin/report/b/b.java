package com.tencent.mm.plugin.report.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aia;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bf;

public final class b
{
  public static final class a
    extends k.d
    implements k.b
  {
    public aia oRL;
    
    public a()
    {
      GMTrace.i(13105153179648L, 97641);
      this.oRL = new aia();
      GMTrace.o(13105153179648L, 97641);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13105555832832L, 97644);
      GMTrace.o(13105555832832L, 97644);
      return 0;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13105287397376L, 97642);
      this.sXU = ac.bHj();
      this.oRL.thY = new avt().bb(bf.bJG());
      this.oRL.tXb = k.a(this);
      byte[] arrayOfByte = this.oRL.toByteArray();
      GMTrace.o(13105287397376L, 97642);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(13105421615104L, 97643);
      GMTrace.o(13105421615104L, 97643);
      return 694;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */