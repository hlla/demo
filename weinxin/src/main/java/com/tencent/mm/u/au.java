package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.acs;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bf;

public final class au
{
  public static final class a
    extends k.d
    implements k.b
  {
    public acr hmd;
    
    public a()
    {
      GMTrace.i(643842441216L, 4797);
      this.hmd = new acr();
      GMTrace.o(643842441216L, 4797);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(644245094400L, 4800);
      GMTrace.o(644245094400L, 4800);
      return 0;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(643976658944L, 4798);
      this.sXU = ac.bHi();
      this.hmd.thY = new avt().bb(bf.bJG());
      this.hmd.tXb = k.a(this);
      byte[] arrayOfByte = this.hmd.toByteArray();
      GMTrace.o(643976658944L, 4798);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(644110876672L, 4799);
      GMTrace.o(644110876672L, 4799);
      return 618;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public acs hme;
    
    public b()
    {
      GMTrace.i(615119847424L, 4583);
      this.hme = new acs();
      GMTrace.o(615119847424L, 4583);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(615388282880L, 4585);
      GMTrace.o(615388282880L, 4585);
      return 0;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(615254065152L, 4584);
      this.hme = ((acs)new acs().aD(paramArrayOfByte));
      k.a(this, this.hme.tXs);
      int i = this.hme.tXs.tgr;
      GMTrace.o(615254065152L, 4584);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */