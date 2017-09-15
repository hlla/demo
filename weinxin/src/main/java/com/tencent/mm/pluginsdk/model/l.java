package com.tencent.mm.pluginsdk.model;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class l
  extends w
{
  public String sAO;
  
  public l(String paramString, LinkedList<String> paramLinkedList)
  {
    GMTrace.i(752961454080L, 5610);
    v.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", new Object[] { paramString });
    this.sAO = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new acc();
    ((b.a)localObject).hrW = new acd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
    ((b.a)localObject).hrU = 452;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.lbI = ((b.a)localObject).BE();
    localObject = (acc)this.lbI.hrS.hsa;
    ((acc)localObject).mqG = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bf.mA(str)) {
        paramString.add(n.mw(str));
      }
    }
    ((acc)localObject).thh = paramString;
    ((acc)localObject).tCc = paramLinkedList.size();
    GMTrace.o(752961454080L, 5610);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(753095671808L, 5611);
    v.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      GMTrace.o(753095671808L, 5611);
      return;
    }
    GMTrace.o(753095671808L, 5611);
  }
  
  public final byte[] aBo()
  {
    GMTrace.i(753229889536L, 5612);
    try
    {
      byte[] arrayOfByte = ((b.b)this.lbI.BG()).zh();
      GMTrace.o(753229889536L, 5612);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.NetSceneGetUserInfoInApp", localException.getMessage());
      v.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", localException, "", new Object[0]);
      GMTrace.o(753229889536L, 5612);
    }
    return null;
  }
  
  public final void ar(byte[] paramArrayOfByte)
  {
    GMTrace.i(753364107264L, 5613);
    if (paramArrayOfByte == null)
    {
      v.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
      GMTrace.o(753364107264L, 5613);
      return;
    }
    b.c localc = this.lbI.hrT;
    try
    {
      localc.y(paramArrayOfByte);
      GMTrace.o(753364107264L, 5613);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      v.e("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte.getMessage());
      v.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte, "", new Object[0]);
      GMTrace.o(753364107264L, 5613);
    }
  }
  
  public final int getType()
  {
    GMTrace.i(753498324992L, 5614);
    GMTrace.o(753498324992L, 5614);
    return 14;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */