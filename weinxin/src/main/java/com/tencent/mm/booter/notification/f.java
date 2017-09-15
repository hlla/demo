package com.tencent.mm.booter.notification;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
{
  public e gLz;
  
  public f()
  {
    GMTrace.i(521570091008L, 3886);
    this.gLz = new e();
    GMTrace.o(521570091008L, 3886);
  }
  
  public final int a(NotificationItem paramNotificationItem)
  {
    GMTrace.i(521838526464L, 3888);
    int i = this.gLz.a(paramNotificationItem, null);
    GMTrace.o(521838526464L, 3888);
    return i;
  }
  
  public final boolean a(String paramString, au paramau, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(521704308736L, 3887);
    if (bf.mA(paramString))
    {
      GMTrace.o(521704308736L, 3887);
      return false;
    }
    paramBoolean = c.a(paramString, paramau, paramInt, paramBoolean);
    GMTrace.o(521704308736L, 3887);
    return paramBoolean;
  }
  
  public final void j(int paramInt, String paramString)
  {
    GMTrace.i(521972744192L, 3889);
    v.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    int i = paramInt;
    if (paramInt == -1) {
      i = com.tencent.mm.i.f.sR();
    }
    c.dQ(i);
    ArrayList localArrayList;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localArrayList = c.qo();
      if (localArrayList != null) {
        break label327;
      }
      localArrayList = new ArrayList();
    }
    label327:
    for (;;)
    {
      Object localObject2 = localArrayList.iterator();
      Object localObject1;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (c.a)((Iterator)localObject2).next();
        if (((c.a)localObject1).userName.equals(paramString)) {
          localArrayList.remove(localObject1);
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new c.a();
        }
        ((c.a)localObject2).userName = paramString;
        ((c.a)localObject2).gLe = com.tencent.mm.i.f.dF(paramString);
        if ((((c.a)localObject2).gLe == 0) && (localArrayList.isEmpty()))
        {
          c.d(null);
          GMTrace.o(521972744192L, 3889);
          return;
        }
        paramString = localArrayList;
        if (((c.a)localObject2).gLe > 0)
        {
          localArrayList.add(localObject2);
          paramString = localArrayList;
        }
        c.d(paramString);
        GMTrace.o(521972744192L, 3889);
        return;
        localArrayList = new ArrayList();
        localObject1 = com.tencent.mm.i.f.sQ();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = new ArrayList();
        }
        localObject1 = paramString.iterator();
        for (;;)
        {
          paramString = localArrayList;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramString = (String)((Iterator)localObject1).next();
          localObject2 = new c.a();
          ((c.a)localObject2).userName = paramString;
          ((c.a)localObject2).gLe = com.tencent.mm.i.f.dF(paramString);
          localArrayList.add(localObject2);
        }
        localObject1 = null;
      }
    }
  }
  
  private static final class a
  {
    public static final f gLA;
    
    static
    {
      GMTrace.i(514590769152L, 3834);
      gLA = new f();
      GMTrace.o(514590769152L, 3834);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/notification/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */