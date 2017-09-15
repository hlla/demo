package com.tencent.mm.e.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.sdk.b.b;

public final class pr
  extends b
{
  public a fWr;
  public b fWs;
  
  public pr()
  {
    this((byte)0);
    GMTrace.i(4230945439744L, 31523);
    GMTrace.o(4230945439744L, 31523);
  }
  
  private pr(byte paramByte)
  {
    GMTrace.i(4231079657472L, 31524);
    this.fWr = new a();
    this.fWs = new b();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4231079657472L, 31524);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public String fCE;
    public Bundle fFl;
    public String fKJ;
    public int fWA;
    public int fWB;
    public String fWC;
    public String fWt;
    public int fWu;
    public int fWv;
    public String fWw;
    public boolean fWx;
    public boolean fWy;
    public LaunchParamsOptional fWz;
    public int scene;
    public String userName;
    
    public a()
    {
      GMTrace.i(4312147165184L, 32128);
      this.fWy = true;
      this.fWz = new LaunchParamsOptional();
      GMTrace.o(4312147165184L, 32128);
    }
  }
  
  public static final class b
  {
    public boolean fWD;
    public String fWE;
    
    public b()
    {
      GMTrace.i(4199806926848L, 31291);
      GMTrace.o(4199806926848L, 31291);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/pr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */