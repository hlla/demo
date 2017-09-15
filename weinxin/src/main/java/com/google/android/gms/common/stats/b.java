package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.gms.c.aa;
import com.google.android.gms.c.j;
import com.google.android.gms.c.u;
import com.google.android.gms.common.internal.f;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static final Object aqT = new Object();
  private static b asg;
  private static final ComponentName asl = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
  private static Integer asn;
  private final List<String> ash;
  private final List<String> asi;
  private final List<String> asj;
  private final List<String> ask;
  private e asm;
  
  private b()
  {
    if (getLogLevel() == d.LOG_LEVEL_OFF)
    {
      this.ash = Collections.EMPTY_LIST;
      this.asi = Collections.EMPTY_LIST;
      this.asj = Collections.EMPTY_LIST;
      this.ask = Collections.EMPTY_LIST;
      return;
    }
    Object localObject = (String)c.a.asq.get();
    if (localObject == null)
    {
      localObject = Collections.EMPTY_LIST;
      this.ash = ((List)localObject);
      localObject = (String)c.a.asr.get();
      if (localObject != null) {
        break label171;
      }
      localObject = Collections.EMPTY_LIST;
      label83:
      this.asi = ((List)localObject);
      localObject = (String)c.a.ass.get();
      if (localObject != null) {
        break label184;
      }
      localObject = Collections.EMPTY_LIST;
      label106:
      this.asj = ((List)localObject);
      localObject = (String)c.a.ast.get();
      if (localObject != null) {
        break label197;
      }
    }
    label171:
    label184:
    label197:
    for (localObject = Collections.EMPTY_LIST;; localObject = Arrays.asList(((String)localObject).split(",")))
    {
      this.ask = ((List)localObject);
      this.asm = new e(((Long)c.a.asu.get()).longValue());
      return;
      localObject = Arrays.asList(((String)localObject).split(","));
      break;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label83;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label106;
    }
  }
  
  private static ServiceInfo b(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager().queryIntentServices(paramIntent, 128);
    if ((paramContext == null) || (paramContext.size() == 0))
    {
      String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), aa.cd(20) });
      return null;
    }
    if (paramContext.size() > 1)
    {
      String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), aa.cd(20) });
      paramIntent = paramContext.iterator();
      if (paramIntent.hasNext())
      {
        paramContext = ((ResolveInfo)paramIntent.next()).serviceInfo.name;
        return null;
      }
    }
    return ((ResolveInfo)paramContext.get(0)).serviceInfo;
  }
  
  private static int getLogLevel()
  {
    if (asn == null) {}
    for (;;)
    {
      try
      {
        if (!u.kU()) {
          continue;
        }
        i = ((Integer)c.a.asp.get()).intValue();
        asn = Integer.valueOf(i);
      }
      catch (SecurityException localSecurityException)
      {
        int i;
        asn = Integer.valueOf(d.LOG_LEVEL_OFF);
        continue;
      }
      return asn.intValue();
      i = d.LOG_LEVEL_OFF;
    }
  }
  
  public static b kw()
  {
    synchronized (aqT)
    {
      if (asg == null) {
        asg = new b();
      }
      return asg;
    }
  }
  
  public final void a(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
    a(paramContext, paramServiceConnection, null, null, 1);
  }
  
  public final void a(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent, int paramInt)
  {
    if (!f.apP) {
      return;
    }
    String str1 = String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramServiceConnection));
    int i = getLogLevel();
    label46:
    long l2;
    long l1;
    if ((i == d.LOG_LEVEL_OFF) || (this.asm == null))
    {
      i = 0;
      if (i == 0) {
        break label343;
      }
      l2 = System.currentTimeMillis();
      paramServiceConnection = null;
      if ((getLogLevel() & d.asy) != 0) {
        paramServiceConnection = aa.cd(5);
      }
      l1 = 0L;
      if ((getLogLevel() & d.asA) != 0) {
        l1 = Debug.getNativeHeapAllocatedSize();
      }
      if ((paramInt != 1) && (paramInt != 4)) {
        break label345;
      }
    }
    for (paramServiceConnection = new ConnectionEvent(l2, paramInt, null, null, null, null, paramServiceConnection, str1, SystemClock.elapsedRealtime(), l1);; paramServiceConnection = new ConnectionEvent(l2, paramInt, aa.K(paramContext), paramString, paramIntent.processName, paramIntent.name, paramServiceConnection, str1, SystemClock.elapsedRealtime(), l1))
    {
      paramContext.startService(new Intent().setComponent(asl).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramServiceConnection));
      return;
      if ((paramInt == 4) || (paramInt == 1))
      {
        if (this.asm.Z(str1))
        {
          i = 1;
          break label46;
        }
        i = 0;
        break label46;
      }
      Object localObject = b(paramContext, paramIntent);
      if (localObject == null)
      {
        String.format("Client %s made an invalid request %s", new Object[] { paramString, paramIntent.toUri(0) });
        i = 0;
        break label46;
      }
      paramServiceConnection = aa.K(paramContext);
      String str2 = ((ServiceInfo)localObject).processName;
      localObject = ((ServiceInfo)localObject).name;
      if ((this.ash.contains(paramServiceConnection)) || (this.asi.contains(paramString)) || (this.asj.contains(str2)) || (this.ask.contains(localObject)) || ((str2.equals(paramServiceConnection)) && ((i & d.asz) != 0)))
      {
        i = 0;
        break label46;
      }
      this.asm.Y(str1);
      i = 1;
      break label46;
      label343:
      break;
      label345:
      paramIntent = b(paramContext, paramIntent);
    }
  }
  
  public final boolean a(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return a(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }
  
  public final boolean a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if ((localComponentName == null) || ((f.apP) && ("com.google.android.gms".equals(localComponentName.getPackageName())))) {}
    for (boolean bool = false; bool; bool = u.h(paramContext, localComponentName.getPackageName())) {
      return false;
    }
    bool = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
    if (bool) {
      a(paramContext, paramServiceConnection, paramString, paramIntent, 2);
    }
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/stats/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */