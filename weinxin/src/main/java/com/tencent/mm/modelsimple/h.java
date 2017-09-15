package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.lc;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class h
  extends k
  implements j
{
  public static int hRr;
  public static int hRs;
  public static int hRt;
  public static int hRu;
  private b gUq;
  private com.tencent.mm.y.e gUt;
  
  static
  {
    GMTrace.i(1340298231808L, 9986);
    hRr = 1;
    hRs = 2;
    hRt = 3;
    hRu = 4;
    GMTrace.o(1340298231808L, 9986);
  }
  
  public h(int paramInt)
  {
    GMTrace.i(1339492925440L, 9980);
    b.a locala = new b.a();
    locala.hrV = new lc();
    locala.hrW = new ld();
    locala.uri = "/cgi-bin/micromsg-bin/checkunbind";
    locala.hrU = 254;
    locala.hrX = 131;
    locala.hrY = 1000000131;
    this.gUq = locala.BE();
    ((lc)this.gUq.hrS.hsa).tpM = paramInt;
    GMTrace.o(1339492925440L, 9980);
  }
  
  public final String IP()
  {
    GMTrace.i(1339761360896L, 9982);
    try
    {
      String str = ((ld)this.gUq.hrT.hsa).tpN;
      v.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() " + str);
      GMTrace.o(1339761360896L, 9982);
      return str;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", localException, "", new Object[0]);
      GMTrace.o(1339761360896L, 9982);
    }
    return null;
  }
  
  public final ld IQ()
  {
    GMTrace.i(1340029796352L, 9984);
    ld localld = (ld)this.gUq.hrT.hsa;
    GMTrace.o(1340029796352L, 9984);
    return localld;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1339627143168L, 9981);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(1339627143168L, 9981);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1340164014080L, 9985);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1340164014080L, 9985);
  }
  
  public final int getType()
  {
    GMTrace.i(1339895578624L, 9983);
    GMTrace.o(1339895578624L, 9983);
    return 254;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */