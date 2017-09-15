package com.tencent.mm.e.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.sdk.b.b;
import java.util.List;

public final class ji
  extends b
{
  public a fPu;
  public b fPv;
  
  public ji()
  {
    this((byte)0);
    GMTrace.i(4359391805440L, 32480);
    GMTrace.o(4359391805440L, 32480);
  }
  
  private ji(byte paramByte)
  {
    GMTrace.i(4359526023168L, 32481);
    this.fPu = new a();
    this.fPv = new b();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4359526023168L, 32481);
  }
  
  public static final class a
  {
    public int fJr;
    public float fNS;
    public String fPA;
    public boolean fPd;
    public float fPw;
    public int fPx;
    public int fPy;
    public String fPz;
    
    public a()
    {
      GMTrace.i(4365028950016L, 32522);
      this.fJr = 0;
      this.fPw = 0.0F;
      this.fNS = 0.0F;
      this.fPx = 0;
      this.fPy = 0;
      this.fPd = false;
      GMTrace.o(4365028950016L, 32522);
    }
  }
  
  public static final class b
  {
    public int fJr;
    public boolean fPB;
    public List<ait> fPC;
    public int fPD;
    
    public b()
    {
      GMTrace.i(4328924381184L, 32253);
      this.fJr = 0;
      this.fPB = false;
      this.fPD = -1;
      GMTrace.o(4328924381184L, 32253);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */