package com.tencent.mm.booter.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.af;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class e
  extends a
{
  public c gLr;
  private Context mContext;
  private NotificationManager sO;
  
  public e()
  {
    GMTrace.i(519019954176L, 3867);
    this.mContext = aa.getContext();
    this.sO = ((NotificationManager)this.mContext.getSystemService("notification"));
    this.gLr = new c();
    GMTrace.o(519019954176L, 3867);
  }
  
  public static void cancel()
  {
    GMTrace.i(519154171904L, 3868);
    af localaf = af.h(aa.getContext());
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = b.qr().qt().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (!localLinkedList.contains(localInteger))
      {
        b.qr().a(localaf, localInteger.intValue());
        localLinkedList.add(localInteger);
      }
    }
    GMTrace.o(519154171904L, 3868);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/notification/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */