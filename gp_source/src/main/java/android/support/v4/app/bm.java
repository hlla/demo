package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

final class bm
  extends bs
{
  private final Context b;
  private final PowerManager.WakeLock c;
  private boolean d;
  private final PowerManager.WakeLock e;
  private boolean f;
  
  bm(Context paramContext, ComponentName paramComponentName)
  {
    super(paramComponentName);
    this.b = paramContext.getApplicationContext();
    paramContext = (PowerManager)paramContext.getSystemService("power");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramComponentName.getClassName());
    localStringBuilder.append(":launch");
    this.c = paramContext.newWakeLock(1, localStringBuilder.toString());
    this.c.setReferenceCounted(false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramComponentName.getClassName());
    localStringBuilder.append(":run");
    this.e = paramContext.newWakeLock(1, localStringBuilder.toString());
    this.e.setReferenceCounted(false);
  }
  
  public final void a()
  {
    try
    {
      this.d = false;
      return;
    }
    finally {}
  }
  
  final void a(Intent paramIntent)
  {
    paramIntent = new Intent(paramIntent);
    paramIntent.setComponent(this.a);
    if (this.b.startService(paramIntent) != null) {
      try
      {
        if (!this.d)
        {
          this.d = true;
          if (!this.f) {
            this.c.acquire(60000L);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public final void b()
  {
    try
    {
      if (!this.f)
      {
        this.f = true;
        this.e.acquire(600000L);
        this.c.release();
      }
      return;
    }
    finally {}
  }
  
  public final void c()
  {
    try
    {
      if (this.f)
      {
        if (this.d) {
          this.c.acquire(60000L);
        }
        this.f = false;
        this.e.release();
      }
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */