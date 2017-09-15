package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bf;

public final class av
{
  public static final class a
    extends k.d
    implements k.b
  {
    public bjf hmf;
    
    public a()
    {
      GMTrace.i(684778848256L, 5102);
      this.hmf = new bjf();
      GMTrace.o(684778848256L, 5102);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(685181501440L, 5105);
      GMTrace.o(685181501440L, 5105);
      return 0;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(684913065984L, 5103);
      this.sXU = ac.bHi();
      this.hmf.thY = new avt().bb(bf.bJG());
      this.hmf.tXb = k.a(this);
      byte[] arrayOfByte = this.hmf.toByteArray();
      GMTrace.o(684913065984L, 5103);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(685047283712L, 5104);
      GMTrace.o(685047283712L, 5104);
      return 617;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public bjg hmg;
    
    public b()
    {
      GMTrace.i(680349663232L, 5069);
      this.hmg = new bjg();
      GMTrace.o(680349663232L, 5069);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(680618098688L, 5071);
      GMTrace.o(680618098688L, 5071);
      return 0;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(680483880960L, 5070);
      this.hmg = ((bjg)new bjg().aD(paramArrayOfByte));
      k.a(this, this.hmg.tXs);
      int i = this.hmg.tXs.tgr;
      GMTrace.o(680483880960L, 5070);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */