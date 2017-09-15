package com.tencent.mm.e.a;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.au;
import java.util.List;

public final class lz
  extends b
{
  public a fSV;
  public b fSW;
  
  public lz()
  {
    this((byte)0);
    GMTrace.i(4309194375168L, 32106);
    GMTrace.o(4309194375168L, 32106);
  }
  
  private lz(byte paramByte)
  {
    GMTrace.i(4309328592896L, 32107);
    this.fSV = new a();
    this.fSW = new b();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4309328592896L, 32107);
  }
  
  public static final class a
  {
    public Context context;
    public String desc;
    public long fGD;
    public rl fJV;
    public String fKm;
    public String fKq;
    public String fSX;
    public ru fSY;
    public int fSZ;
    public cb fSz;
    public au fTa;
    public List<au> fTb;
    public String fTc;
    public String fTd;
    public d fTe;
    public String title;
    public String toUser;
    public int type;
    
    public a()
    {
      GMTrace.i(4247185784832L, 31644);
      this.type = 0;
      this.fGD = 0L;
      this.fSZ = 0;
      GMTrace.o(4247185784832L, 31644);
    }
  }
  
  public static final class b
  {
    public String fKq;
    public cb fSz;
    public d fTe;
    public c fTf;
    public String fTg;
    public boolean fTh;
    public boolean fTi;
    
    public b()
    {
      GMTrace.i(4220879110144L, 31448);
      this.fTh = false;
      this.fTi = false;
      GMTrace.o(4220879110144L, 31448);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/lz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */