package com.tencent.c.a;

import android.content.Context;
import com.tencent.c.c.b.c;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static com.tencent.c.b.a wOE = null;
  
  public static void a(Context paramContext, a parama)
  {
    if (wOE == null) {
      wOE = new com.tencent.c.b.a(paramContext);
    }
    paramContext = wOE;
    List localList = com.tencent.c.e.a.fy(paramContext.mContext);
    if (localList.size() == 0)
    {
      parama.e(-10, null);
      return;
    }
    com.tencent.c.c.b.a locala = new com.tencent.c.c.b.a();
    locala.wPk = com.tencent.c.b.a.cdu();
    locala.wPi = new c();
    locala.wPi.wPL = 6;
    locala.wPi.wPc = 1;
    locala.wPi.requestType = 0;
    locala.wPi.wPM = 0;
    locala.wPi.wPN = 0;
    locala.wPi.wPO = null;
    locala.wPi.wPP = 0;
    locala.wPi.wPT = 1;
    locala.wPj = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      com.tencent.c.c.b.b localb = com.tencent.c.b.a.a(paramContext.mContext, (a)localList.get(i), i);
      locala.wPj.add(localb);
      i += 1;
    }
    paramContext = paramContext.wOF.a(locala);
    if (paramContext == null)
    {
      parama.e(-20, null);
      return;
    }
    parama.e(0, paramContext);
  }
  
  public static abstract interface a
  {
    public abstract void e(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */