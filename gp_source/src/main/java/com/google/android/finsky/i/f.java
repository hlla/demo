package com.google.android.finsky.i;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.finsky.ag.d;
import java.util.List;

public final class f
{
  private final a a;
  private final Context b;
  
  public f(Context paramContext, a parama)
  {
    this.a = parama;
    this.b = paramContext;
  }
  
  public final void a(int paramInt, Runnable paramRunnable)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new g(this, paramRunnable, paramInt), paramInt);
  }
  
  public final boolean a()
  {
    if (!((Boolean)d.jG.b()).booleanValue()) {
      return this.a.b();
    }
    Object localObject = ((ActivityManager)this.b.getSystemService("activity")).getRecentTasks(1, 0);
    if (!((List)localObject).isEmpty())
    {
      localObject = (RecentTaskInfo)((List)localObject).get(0);
      return (((RecentTaskInfo)localObject).baseIntent != null) && (((RecentTaskInfo)localObject).baseIntent.getComponent() != null) && (!this.b.getPackageName().equals(((RecentTaskInfo)localObject).baseIntent.getComponent().getPackageName()));
    }
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/i/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */