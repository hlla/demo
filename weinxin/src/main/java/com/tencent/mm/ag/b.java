package com.tencent.mm.ag;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agd;
import com.tencent.mm.protocal.c.age;
import com.tencent.mm.protocal.c.agf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b
  extends k
  implements j
{
  private final com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private LinkedList<agd> hDR;
  public String hDS;
  
  public b(ArrayList<String> paramArrayList)
  {
    GMTrace.i(1531826929664L, 11413);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new age();
    ((b.a)localObject).hrW = new agf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
    ((b.a)localObject).hrU = 489;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    this.hDR = new LinkedList();
    if (paramArrayList.size() > 0)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject = new agd();
        ((agd)localObject).thE = ((String)paramArrayList.get(i));
        this.hDR.add(localObject);
        i += 1;
      }
    }
    GMTrace.o(1531826929664L, 11413);
  }
  
  public final agf Gv()
  {
    GMTrace.i(1532229582848L, 11416);
    agf localagf = (agf)this.gUq.hrT.hsa;
    GMTrace.o(1532229582848L, 11416);
    return localagf;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1531961147392L, 11414);
    v.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.gUt = parame1;
    parame1 = (age)this.gUq.hrS.hsa;
    parame1.jLr = this.hDR.size();
    parame1.jLs = this.hDR;
    int i = a(parame, this.gUq, this);
    GMTrace.o(1531961147392L, 11414);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1532095365120L, 11415);
    v.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(1532095365120L, 11415);
      return;
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1532095365120L, 11415);
  }
  
  public final int getType()
  {
    GMTrace.i(1532363800576L, 11417);
    GMTrace.o(1532363800576L, 11417);
    return 489;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ag/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */