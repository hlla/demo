package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.aav;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.sdk.platformtools.bf;

public final class s
{
  public static final class a
    extends k.d
    implements k.b
  {
    public aav sYq;
    
    public a()
    {
      GMTrace.i(4076326617088L, 30371);
      this.sYq = new aav();
      GMTrace.o(4076326617088L, 30371);
    }
    
    public final byte[] zh()
    {
      GMTrace.i(4076460834816L, 30372);
      this.sXU = ac.bHk();
      this.sYq.thY = new avt().bb(bf.bJG());
      this.sYq.tXb = k.a(this);
      byte[] arrayOfByte = this.sYq.toByteArray();
      GMTrace.o(4076460834816L, 30372);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(4076595052544L, 30373);
      GMTrace.o(4076595052544L, 30373);
      return 572;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */