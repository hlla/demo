package com.tencent.mm.e.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.am.a;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.sdk.b.b;

public final class jc
  extends b
{
  public a fOT;
  
  public jc()
  {
    this((byte)0);
    GMTrace.i(4187995766784L, 31203);
    GMTrace.o(4187995766784L, 31203);
  }
  
  private jc(byte paramByte)
  {
    GMTrace.i(4188129984512L, 31204);
    this.fOT = new a();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4188129984512L, 31204);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public long duration;
    public int errCode;
    public anc fOP;
    public a fOU;
    public boolean fOV;
    public String fOW;
    public String state;
    
    public a()
    {
      GMTrace.i(4257117896704L, 31718);
      GMTrace.o(4257117896704L, 31718);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/jc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */