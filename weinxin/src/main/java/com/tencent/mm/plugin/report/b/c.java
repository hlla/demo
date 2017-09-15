package com.tencent.mm.plugin.report.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aia;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bf;

public final class c
{
  public static final class a
    extends k.d
    implements k.b
  {
    public aia oRL;
    
    public a()
    {
      GMTrace.i(13105690050560L, 97645);
      this.oRL = new aia();
      GMTrace.o(13105690050560L, 97645);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13106092703744L, 97648);
      GMTrace.o(13106092703744L, 97648);
      return 0;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13105824268288L, 97646);
      this.sXU = ac.bHj();
      this.oRL.thY = new avt().bb(bf.bJG());
      this.oRL.tXb = k.a(this);
      byte[] arrayOfByte = this.oRL.toByteArray();
      GMTrace.o(13105824268288L, 97646);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(13105958486016L, 97647);
      GMTrace.o(13105958486016L, 97647);
      return 499;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */