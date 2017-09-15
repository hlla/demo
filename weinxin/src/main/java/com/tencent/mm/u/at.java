package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.protocal.c.aco;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bf;

public final class at
{
  public static final class a
    extends k.d
    implements k.b
  {
    public acn hmb;
    
    public a()
    {
      GMTrace.i(689073815552L, 5134);
      this.hmb = new acn();
      GMTrace.o(689073815552L, 5134);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(689476468736L, 5137);
      GMTrace.o(689476468736L, 5137);
      return 0;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(689208033280L, 5135);
      this.sXU = ac.bHi();
      this.hmb.thY = new avt().bb(bf.bJG());
      this.hmb.tXb = k.a(this);
      byte[] arrayOfByte = this.hmb.toByteArray();
      GMTrace.o(689208033280L, 5135);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(689342251008L, 5136);
      GMTrace.o(689342251008L, 5136);
      return 616;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public aco hmc;
    
    public b()
    {
      GMTrace.i(631494410240L, 4705);
      this.hmc = new aco();
      GMTrace.o(631494410240L, 4705);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(631762845696L, 4707);
      GMTrace.o(631762845696L, 4707);
      return 0;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(631628627968L, 4706);
      this.hmc = ((aco)new aco().aD(paramArrayOfByte));
      k.a(this, this.hmc.tXs);
      int i = this.hmc.tXs.tgr;
      GMTrace.o(631628627968L, 4706);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */