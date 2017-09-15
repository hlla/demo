package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.sdk.platformtools.bf;

public final class u
{
  public static final class a
    extends k.d
    implements k.b
  {
    public ack sYt;
    
    public a()
    {
      GMTrace.i(4059549401088L, 30246);
      this.sYt = new ack();
      GMTrace.o(4059549401088L, 30246);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(4059952054272L, 30249);
      GMTrace.o(4059952054272L, 30249);
      return 48;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(4059683618816L, 30247);
      this.sXU = ac.bHk();
      this.sYt.thY = new avt().bb(bf.bJG());
      this.sYt.tXb = k.a(this);
      byte[] arrayOfByte = this.sYt.toByteArray();
      GMTrace.o(4059683618816L, 30247);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(4059817836544L, 30248);
      GMTrace.o(4059817836544L, 30248);
      return 107;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */