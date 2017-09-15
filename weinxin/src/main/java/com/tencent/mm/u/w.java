package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import java.util.Iterator;
import java.util.List;

public final class w
{
  public static void yF()
  {
    GMTrace.i(14628524392448L, 108991);
    Object localObject = o.yz().iterator();
    x localx1;
    while (((Iterator)localObject).hasNext())
    {
      localx1 = (x)((Iterator)localObject).next();
      if ((localx1 != null) && ((int)localx1.gTG != 0) && (localx1.field_showHead == 32))
      {
        localx1.dc(localx1.sZ());
        v.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + localx1.field_username);
        ap.yY();
        c.wR().a(localx1.field_username, localx1);
      }
    }
    localObject = o.hlg;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localx1 = localObject[i];
      x localx2 = c.wR().Rb(localx1);
      if ((localx2 != null) && (((int)localx2.gTG != 0) || (a.ez(localx2.field_type))))
      {
        localx2.tl();
        c.wR().a(localx1, localx2);
      }
      i += 1;
    }
    GMTrace.o(14628524392448L, 108991);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */