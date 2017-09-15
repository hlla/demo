package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.sdk.platformtools.bf;

public final class p
{
  public static final class a
    extends k.d
    implements k.b
  {
    public os sYi;
    
    public a()
    {
      GMTrace.i(4073373827072L, 30349);
      this.sYi = new os();
      GMTrace.o(4073373827072L, 30349);
    }
    
    public final byte[] zh()
    {
      GMTrace.i(4073508044800L, 30350);
      this.sXU = ac.bHk();
      this.sYi.thY = new avt().bb(bf.bJG());
      this.sYi.tXb = k.a(this);
      byte[] arrayOfByte = this.sYi.toByteArray();
      GMTrace.o(4073508044800L, 30350);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(4073642262528L, 30351);
      GMTrace.o(4073642262528L, 30351);
      return 481;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public ot sYj;
    
    public b()
    {
      GMTrace.i(4065186545664L, 30288);
      this.sYj = new ot();
      GMTrace.o(4065186545664L, 30288);
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(4065320763392L, 30289);
      this.sYj = ((ot)new ot().aD(paramArrayOfByte));
      k.a(this, this.sYj.tXs);
      int i = this.sYj.tXs.tgr;
      GMTrace.o(4065320763392L, 30289);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */