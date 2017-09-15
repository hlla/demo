package com.tencent.mm.modelfriend;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.aya;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class z
  extends k
  implements j
{
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  
  public z(String paramString, List<String> paramList)
  {
    GMTrace.i(4435761692672L, 33049);
    this.gUt = null;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new axz();
    ((b.a)localObject).hrW = new aya();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
    ((b.a)localObject).hrU = 432;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (axz)this.gUq.hrS.hsa;
    ((axz)localObject).tsG = paramString;
    ((axz)localObject).tLz = new LinkedList();
    ((axz)localObject).tLy = paramList.size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      if (!bf.mA(paramList)) {
        ((axz)localObject).tLz.add(new avu().OU(paramList));
      }
    }
    GMTrace.o(4435761692672L, 33049);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4435895910400L, 33050);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(4435895910400L, 33050);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4436164345856L, 33052);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(4436164345856L, 33052);
  }
  
  public final int getType()
  {
    GMTrace.i(4436030128128L, 33051);
    GMTrace.o(4436030128128L, 33051);
    return 432;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */