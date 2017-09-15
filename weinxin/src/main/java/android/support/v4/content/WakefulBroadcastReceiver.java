package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver
  extends BroadcastReceiver
{
  private static final SparseArray<PowerManager.WakeLock> tH = new SparseArray();
  private static int tI = 1;
  
  public static ComponentName a(Context paramContext, Intent paramIntent)
  {
    synchronized (tH)
    {
      int i = tI;
      int j = tI + 1;
      tI = j;
      if (j <= 0) {
        tI = 1;
      }
      paramIntent.putExtra("android.support.content.wakelockid", i);
      paramIntent = paramContext.startService(paramIntent);
      if (paramIntent == null) {
        return null;
      }
      paramContext = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "wake:" + paramIntent.flattenToShortString());
      paramContext.setReferenceCounted(false);
      paramContext.acquire(60000L);
      tH.put(i, paramContext);
      return paramIntent;
    }
  }
  
  public static boolean c(Intent arg0)
  {
    int i = ???.getIntExtra("android.support.content.wakelockid", 0);
    if (i == 0) {
      return false;
    }
    synchronized (tH)
    {
      PowerManager.WakeLock localWakeLock = (PowerManager.WakeLock)tH.get(i);
      if (localWakeLock != null)
      {
        localWakeLock.release();
        tH.remove(i);
        return true;
      }
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/content/WakefulBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */