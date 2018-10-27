package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class n
{
  public boolean a;
  public boolean b;
  public final IntentFilter c;
  public final BroadcastReceiver d;
  
  n(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
  {
    this.c = paramIntentFilter;
    this.d = paramBroadcastReceiver;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("Receiver{");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" filter=");
    localStringBuilder.append(this.c);
    if (this.b) {
      localStringBuilder.append(" DEAD");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */