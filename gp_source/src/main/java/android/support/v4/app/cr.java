package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.content.d;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class cr
  implements Iterable
{
  public final Context a;
  private final ArrayList b = new ArrayList();
  
  private cr(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static cr a(Context paramContext)
  {
    return new cr(paramContext);
  }
  
  public final cr a(ComponentName paramComponentName)
  {
    int i = this.b.size();
    try
    {
      for (paramComponentName = ca.a(this.a, paramComponentName); paramComponentName != null; paramComponentName = ca.a(this.a, paramComponentName.getComponent())) {
        this.b.add(i, paramComponentName);
      }
      return this;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
      throw new IllegalArgumentException(paramComponentName);
    }
  }
  
  public final cr a(Intent paramIntent)
  {
    this.b.add(paramIntent);
    return this;
  }
  
  public final void a()
  {
    if (this.b.isEmpty()) {
      throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
    Object localObject = this.b;
    localObject = (Intent[])((ArrayList)localObject).toArray(new Intent[((ArrayList)localObject).size()]);
    localObject[0] = new Intent(localObject[0]).addFlags(268484608);
    d.a(this.a, (Intent[])localObject);
  }
  
  @Deprecated
  public final Iterator iterator()
  {
    return this.b.iterator();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */