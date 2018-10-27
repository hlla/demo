package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
public abstract class y
  extends BroadcastReceiver
{
  private static int a = 1;
  private static final SparseArray b = new SparseArray();
  
  public static ComponentName a(Context paramContext, Intent paramIntent)
  {
    synchronized (b)
    {
      int i = a;
      int j = a + 1;
      a = j;
      if (j > 0)
      {
        paramIntent.putExtra("android.support.content.wakelockid", i);
        paramIntent = paramContext.startService(paramIntent);
        if (paramIntent != null)
        {
          paramContext = (PowerManager)paramContext.getSystemService("power");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("androidx.core:wake:");
          localStringBuilder.append(paramIntent.flattenToShortString());
          paramContext = paramContext.newWakeLock(1, localStringBuilder.toString());
          paramContext.setReferenceCounted(false);
          paramContext.acquire(60000L);
          b.put(i, paramContext);
          return paramIntent;
        }
        return null;
      }
      a = 1;
    }
  }
  
  public static boolean a(Intent arg0)
  {
    int i = ???.getIntExtra("android.support.content.wakelockid", 0);
    if (i != 0) {
      synchronized (b)
      {
        Object localObject1 = (PowerManager.WakeLock)b.get(i);
        if (localObject1 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("No active wake lock id #");
          ((StringBuilder)localObject1).append(i);
          Log.w("WakefulBroadcastReceiv.", ((StringBuilder)localObject1).toString());
          return true;
        }
        ((PowerManager.WakeLock)localObject1).release();
        b.remove(i);
        return true;
      }
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */