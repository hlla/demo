package com.tencent.mm.booter.notification.queue;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.i.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class NotificationQueue
{
  public ParcelNotificationQueue gLE;
  
  public NotificationQueue()
  {
    GMTrace.i(510430019584L, 3803);
    GMTrace.o(510430019584L, 3803);
  }
  
  private void save()
  {
    GMTrace.i(510564237312L, 3804);
    if (this.gLE == null)
    {
      GMTrace.o(510564237312L, 3804);
      return;
    }
    v.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", new Object[] { Integer.valueOf(this.gLE.size()) });
    if (this.gLE.isEmpty())
    {
      f.sj().edit().putString("com.tencent.preference.notification.queue", "").apply();
      if (this.gLE == null) {
        restore();
      }
      v.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", new Object[] { Integer.valueOf(this.gLE.size()) });
      GMTrace.o(510564237312L, 3804);
      return;
    }
    GMTrace.o(510564237312L, 3804);
  }
  
  public final boolean c(NotificationItem paramNotificationItem)
  {
    try
    {
      GMTrace.i(510832672768L, 3806);
      if (this.gLE == null) {
        restore();
      }
      boolean bool = this.gLE.remove(paramNotificationItem);
      if (bool) {
        save();
      }
      GMTrace.o(510832672768L, 3806);
      return bool;
    }
    finally {}
  }
  
  public final boolean d(NotificationItem paramNotificationItem)
  {
    try
    {
      GMTrace.i(511101108224L, 3808);
      if (this.gLE == null) {
        restore();
      }
      boolean bool = this.gLE.add(paramNotificationItem);
      if (bool) {
        save();
      }
      GMTrace.o(511101108224L, 3808);
      return bool;
    }
    finally {}
  }
  
  public final NotificationItem dT(int paramInt)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(510966890496L, 3807);
        if (this.gLE == null) {
          restore();
        }
        Iterator localIterator = this.gLE.iterator();
        if (localIterator.hasNext())
        {
          NotificationItem localNotificationItem = (NotificationItem)localIterator.next();
          if (localNotificationItem.id != paramInt) {
            continue;
          }
          if ((localNotificationItem != null) && (this.gLE.remove(localNotificationItem))) {
            save();
          }
          GMTrace.o(510966890496L, 3807);
          return localNotificationItem;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public final void restore()
  {
    try
    {
      GMTrace.i(510698455040L, 3805);
      v.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
      if (this.gLE == null) {
        this.gLE = new ParcelNotificationQueue();
      }
      v.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", new Object[] { Integer.valueOf(this.gLE.size()) });
      GMTrace.o(510698455040L, 3805);
      return;
    }
    finally {}
  }
  
  public static class ParcelNotificationQueue
    extends LinkedList<NotificationItem>
    implements Parcelable
  {
    public static final Parcelable.Creator<ParcelNotificationQueue> CREATOR;
    
    static
    {
      GMTrace.i(512174850048L, 3816);
      CREATOR = new Parcelable.Creator() {};
      GMTrace.o(512174850048L, 3816);
    }
    
    public ParcelNotificationQueue()
    {
      GMTrace.i(511772196864L, 3813);
      GMTrace.o(511772196864L, 3813);
    }
    
    public int describeContents()
    {
      GMTrace.i(511906414592L, 3814);
      GMTrace.o(511906414592L, 3814);
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      GMTrace.i(512040632320L, 3815);
      paramParcel.writeInt(size());
      Iterator localIterator = iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeParcelable((NotificationItem)localIterator.next(), 0);
      }
      GMTrace.o(512040632320L, 3815);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/notification/queue/NotificationQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */