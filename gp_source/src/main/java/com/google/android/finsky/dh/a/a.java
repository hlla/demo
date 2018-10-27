package com.google.android.finsky.dh.a;

import android.annotation.TargetApi;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.StrictMode;
import com.google.android.finsky.aq.s;
import com.google.android.finsky.ez.d;
import com.google.android.finsky.p2p.g;
import com.google.android.finsky.p2p.i;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.t;
import com.google.wireless.android.finsky.c.a.q;
import com.google.wireless.android.finsky.c.a.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  implements com.google.android.finsky.dh.a, com.google.android.finsky.packagemanager.h
{
  private static final com.google.android.finsky.dh.b a = new com.google.android.finsky.dh.b(null, null, null, false, false, false, false, -1, 0, 0L, false, -1, -1, false, null, false, false, false);
  private Set b = null;
  private final AtomicBoolean c = new AtomicBoolean(false);
  private final Context d;
  private final DevicePolicyManager e;
  private final com.google.android.finsky.bo.c f;
  private Map g = null;
  private final com.google.android.finsky.p2p.c h;
  private final AtomicBoolean i = new AtomicBoolean(false);
  private final PackageManager j;
  private final Map k = new ConcurrentHashMap();
  private final com.google.android.finsky.passivestate.b l;
  private final d m;
  
  public a(Context paramContext, com.google.android.finsky.instantappscompatibility.b paramb, DevicePolicyManager paramDevicePolicyManager, d paramd, com.google.android.finsky.bo.c paramc, com.google.android.finsky.p2p.c paramc1, com.google.android.finsky.passivestate.b paramb1)
  {
    this.d = paramContext;
    this.j = paramb.a;
    this.e = paramDevicePolicyManager;
    this.m = paramd;
    this.f = paramc;
    this.h = paramc1;
    this.l = paramb1;
  }
  
  private final com.google.android.finsky.dh.b a(PackageInfo paramPackageInfo)
  {
    for (;;)
    {
      int i4;
      boolean bool1;
      boolean bool2;
      boolean bool4;
      label414:
      boolean bool5;
      label499:
      boolean bool8;
      try
      {
        Object localObject1;
        if (!this.f.cY().a(12653679L))
        {
          boolean bool9 = com.google.android.finsky.instantappscompatibility.b.a(paramPackageInfo);
          if (!bool9)
          {
            int i3 = paramPackageInfo.versionCode;
            if (paramPackageInfo.applicationInfo.metaData == null) {
              break label969;
            }
            n = paramPackageInfo.applicationInfo.metaData.getInt("com.android.vending.derived.apk.id", 0);
            if (!this.f.cY().a(12637130L)) {
              break label963;
            }
            localObject1 = this.g;
            if (localObject1 == null) {
              break label957;
            }
            localObject1 = (Long)((Map)localObject1).get(paramPackageInfo.packageName);
            if (localObject1 == null)
            {
              l1 = this.h.a(paramPackageInfo);
              break label755;
              i4 = paramPackageInfo.applicationInfo.flags & 0x1;
              if ((paramPackageInfo.applicationInfo.flags & 0x80) == 0) {
                break label951;
              }
              bool6 = true;
              if ((paramPackageInfo.applicationInfo.flags & 0x2) == 0) {
                break label945;
              }
              bool7 = true;
              i1 = this.j.getApplicationEnabledSetting(paramPackageInfo.packageName);
              if (i1 != 0) {
                break label868;
              }
              bool1 = paramPackageInfo.applicationInfo.enabled ^ true;
              bool2 = false;
              int i5 = paramPackageInfo.applicationInfo.targetSdkVersion;
              if (!android.support.v4.os.a.b()) {
                break label863;
              }
              i1 = com.google.android.finsky.instantappscompatibility.b.a(paramPackageInfo.applicationInfo);
              if (!this.f.cY().a(12650166L)) {
                break label857;
              }
              if (paramPackageInfo.applicationInfo.metaData == null) {
                break label851;
              }
              bool3 = paramPackageInfo.applicationInfo.metaData.getBoolean("com.android.disable_update_preview_app", false);
              break label758;
              if (!this.l.a(paramPackageInfo.packageName)) {
                break label828;
              }
              Object localObject4 = new Intent("com.google.android.passive.state.flag");
              ((Intent)localObject4).setPackage(paramPackageInfo.packageName);
              Object localObject3 = this.j.queryIntentActivities((Intent)localObject4, 131072);
              localObject1 = localObject3;
              if (((List)localObject3).isEmpty())
              {
                ((Intent)localObject4).setAction("com.google.android.passive.state.flag".substring(11));
                localObject1 = this.j.queryIntentActivities((Intent)localObject4, 131072);
                if (((List)localObject1).isEmpty()) {
                  break label822;
                }
              }
              localObject1 = new ComponentName(paramPackageInfo.packageName, ((ResolveInfo)((List)localObject1).get(0)).activityInfo.name);
              if (this.j.getComponentEnabledSetting((ComponentName)localObject1) != 1) {
                break label816;
              }
              bool4 = true;
              localObject3 = paramPackageInfo.packageName;
              int i6 = paramPackageInfo.signatures.length;
              localObject4 = new String[i6];
              int i2 = 0;
              if (i2 < i6)
              {
                localObject4[i2] = t.a(paramPackageInfo.signatures[i2].toByteArray());
                i2 += 1;
                continue;
              }
              localObject1 = paramPackageInfo.packageName;
              Object localObject5 = this.b;
              if (localObject5 != null)
              {
                bool5 = ((Set)localObject5).contains(localObject1);
                if (!com.google.android.finsky.utils.a.d()) {
                  break label798;
                }
                if (paramPackageInfo.splitNames == null) {
                  break label792;
                }
                if (paramPackageInfo.splitNames.length <= 0) {
                  break label786;
                }
                localObject1 = (String[])Arrays.copyOf(paramPackageInfo.splitNames, paramPackageInfo.splitNames.length);
                Arrays.sort((Object[])localObject1);
                break label769;
                return new com.google.android.finsky.dh.b((String)localObject3, (String[])localObject4, null, bool8, bool6, bool1, bool2, i3, n, l1, bool5, i5, i1, bool7, (String[])localObject1, bool9, bool3, bool4);
              }
              localObject5 = this.e.getActiveAdmins();
              if (localObject5 == null) {
                break label810;
              }
              localObject5 = ((List)localObject5).iterator();
              if (!((Iterator)localObject5).hasNext()) {
                break label804;
              }
              if (!((ComponentName)((Iterator)localObject5).next()).getPackageName().equals(localObject1)) {
                continue;
              }
              bool5 = true;
              continue;
            }
            else
            {
              l1 = ((Long)localObject1).longValue();
            }
          }
          else
          {
            if (!this.f.cY().a(12646399L)) {
              continue;
            }
            return a;
          }
        }
        else
        {
          if (paramPackageInfo.signatures == null)
          {
            FinskyLog.d("Package %s has null signatures", new Object[] { paramPackageInfo.packageName });
            return a;
          }
          if (paramPackageInfo.signatures.length <= 0) {
            continue;
          }
          localObject1 = paramPackageInfo.signatures[0];
          if (localObject1 == null) {
            continue;
          }
          continue;
        }
        continue;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        FinskyLog.c("Package %s not installed", new Object[] { paramPackageInfo.packageName });
        return a;
      }
      for (;;)
      {
        label755:
        label758:
        if (i4 == 0)
        {
          bool3 = false;
          break;
          for (;;)
          {
            label769:
            if (i4 == 0)
            {
              bool8 = false;
              break;
            }
            bool8 = true;
            break;
            label786:
            localObject2 = null;
            continue;
            label792:
            localObject2 = null;
            continue;
            label798:
            localObject2 = null;
          }
          label804:
          bool5 = false;
          break label499;
          label810:
          bool5 = false;
          break label499;
          label816:
          bool4 = false;
          break label414;
          label822:
          bool4 = false;
          break label414;
          label828:
          bool4 = false;
          break label414;
        }
        if (bool3)
        {
          bool3 = true;
          break;
        }
        bool3 = false;
        break;
        label851:
        bool3 = false;
      }
      label857:
      boolean bool3 = false;
      continue;
      label863:
      int i1 = 1;
      continue;
      label868:
      if (i1 != 3) {
        if (i1 != 4) {
          bool1 = false;
        }
      }
      for (;;)
      {
        if (bool1)
        {
          bool3 = true;
          bool2 = bool1;
          bool1 = bool3;
          break;
        }
        if (i1 != 2)
        {
          bool3 = false;
          bool2 = bool1;
          bool1 = bool3;
          break;
        }
        bool3 = true;
        bool2 = bool1;
        bool1 = bool3;
        break;
        bool1 = true;
        continue;
        bool1 = true;
      }
      label945:
      boolean bool7 = false;
      continue;
      label951:
      boolean bool6 = false;
      continue;
      label957:
      Object localObject2 = null;
      continue;
      label963:
      long l1 = 0L;
      continue;
      label969:
      int n = 0;
    }
  }
  
  private final com.google.android.finsky.dh.b b(PackageInfo paramPackageInfo)
  {
    com.google.android.finsky.dh.b localb = a(paramPackageInfo);
    this.k.put(paramPackageInfo.packageName, localb);
    return localb;
  }
  
  private final com.google.android.finsky.dh.b d(String paramString, boolean paramBoolean)
  {
    boolean bool = this.m.b(paramString);
    if (!paramBoolean) {}
    while (bool)
    {
      if (!bool) {}
      for (int n = 192;; n = 4202688) {
        try
        {
          com.google.android.finsky.dh.b localb = b(this.j.getPackageInfo(paramString, n));
          return localb;
        }
        catch (NameNotFoundException localNameNotFoundException)
        {
          this.k.put(paramString, a);
        }
      }
    }
    this.k.put(paramString, a);
    return a;
    return a;
  }
  
  private final void h(String paramString)
  {
    com.google.android.finsky.p2p.c localc;
    if (this.f.cY().a(12637130L)) {
      localc = this.h;
    }
    try
    {
      PackageInfo localPackageInfo = localc.b.getPackageInfo(paramString, 4194304);
      if (localPackageInfo == null)
      {
        localc.a.a(paramString).a(g.a);
        return;
      }
      localc.a(localPackageInfo, com.google.android.finsky.p2p.c.c(localPackageInfo));
      return;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        FinskyLog.a("Package no longer installed: %s", new Object[] { paramString });
        Object localObject = null;
      }
    }
  }
  
  public final com.google.android.finsky.dh.b a(String paramString)
  {
    return a(paramString, false);
  }
  
  public final com.google.android.finsky.dh.b a(String paramString, boolean paramBoolean)
  {
    com.google.android.finsky.dh.b localb2 = (com.google.android.finsky.dh.b)this.k.get(paramString);
    com.google.android.finsky.dh.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = d(paramString, false);
    }
    if (!localb1.equals(a))
    {
      if ((paramBoolean) || (!localb1.k)) {
        return localb1;
      }
      return null;
    }
    return null;
  }
  
  public final Collection a()
  {
    StrictMode.noteSlowCall("PackageManagerRepository.getAllBlocking");
    Object localObject3;
    if (this.f.cY().a(12650364L))
    {
      if (!this.c.get())
      {
        Object localObject4;
        Object localObject5;
        if (!this.i.compareAndSet(false, true))
        {
          localObject1 = this.j.getInstalledPackages(192);
          localObject3 = new ArrayList(((List)localObject1).size());
          localObject4 = ((List)localObject1).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (PackageInfo)((Iterator)localObject4).next();
            localObject2 = (com.google.android.finsky.dh.b)this.k.get(((PackageInfo)localObject5).packageName);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = a((PackageInfo)localObject5);
            }
            if ((!((com.google.android.finsky.dh.b)localObject1).k) && (!((com.google.android.finsky.dh.b)localObject1).equals(a))) {
              ((List)localObject3).add(localObject1);
            }
          }
          return (Collection)localObject3;
        }
        localObject2 = this.j.getInstalledPackages(192);
        if (!this.f.cY().a(12656975L))
        {
          if ((this.f.cY().a(12637130L)) && (this.f.cY().a(12655261L)))
          {
            localObject1 = this.h;
            localObject3 = new HashMap();
            localObject5 = (List)com.google.android.finsky.af.h.a(((com.google.android.finsky.p2p.c)localObject1).a.b.a(new s()));
            localObject4 = new HashMap(((List)localObject5).size());
            localObject5 = ((List)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (r)((Iterator)localObject5).next();
              ((Map)localObject4).put(((r)localObject6).e, localObject6);
            }
            localObject5 = new ArrayList();
            Object localObject6 = ((List)localObject2).iterator();
            label401:
            label413:
            label429:
            label577:
            while (((Iterator)localObject6).hasNext())
            {
              PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject6).next();
              r localr = (r)((Map)localObject4).get(localPackageInfo.packageName);
              q localq;
              if (localr == null)
              {
                localq = com.google.android.finsky.p2p.c.c(localPackageInfo);
                if (localq == null)
                {
                  ((Map)localObject3).put(localPackageInfo.packageName, Long.valueOf(0L));
                  ((List)localObject5).add(i.a(localPackageInfo, localq));
                }
              }
              for (;;)
              {
                if (localr == null) {
                  break label577;
                }
                ((Map)localObject4).remove(localPackageInfo.packageName);
                break;
                if ((localq.a & 0x1) == 0) {
                  break label413;
                }
                ((Map)localObject3).put(localPackageInfo.packageName, Long.valueOf(localq.c));
                break label429;
                if (localr.d != localPackageInfo.lastUpdateTime) {
                  break label401;
                }
                localq = localr.c;
                if (localq == null) {}
                while ((localq.a & 0x1) == 0)
                {
                  ((Map)localObject3).put(localPackageInfo.packageName, Long.valueOf(0L));
                  break;
                }
                ((Map)localObject3).put(localPackageInfo.packageName, Long.valueOf(localr.c.c));
              }
            }
            if (!((List)localObject5).isEmpty()) {
              ((com.google.android.finsky.p2p.c)localObject1).a.b.a((List)localObject5).a(com.google.android.finsky.p2p.e.a);
            }
            localObject4 = ((Map)localObject4).keySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (String)((Iterator)localObject4).next();
              ((com.google.android.finsky.p2p.c)localObject1).a.a((String)localObject5).a(com.google.android.finsky.p2p.f.a);
            }
            this.g = ((Map)localObject3);
          }
          localObject1 = ((List)localObject2).iterator();
          while (((Iterator)localObject1).hasNext()) {
            b((PackageInfo)((Iterator)localObject1).next());
          }
          this.g = null;
          this.b = null;
          this.c.set(true);
        }
      }
      else
      {
        localObject1 = new ArrayList(this.k.size());
        localObject2 = this.k.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.google.android.finsky.dh.b)((Entry)((Iterator)localObject2).next()).getValue();
          if ((!((com.google.android.finsky.dh.b)localObject3).k) && (!((com.google.android.finsky.dh.b)localObject3).equals(a))) {
            ((List)localObject1).add(localObject3);
          }
        }
        return (Collection)localObject1;
      }
      localObject3 = this.e.getActiveAdmins();
      if (localObject3 != null)
      {
        localObject1 = new HashSet(((List)localObject3).size());
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Set)localObject1).add(((ComponentName)((Iterator)localObject3).next()).getPackageName());
        }
      }
      for (;;)
      {
        this.b = ((Set)localObject1);
        break;
        localObject1 = new HashSet();
      }
    }
    Object localObject2 = this.j.getInstalledPackages(192);
    Object localObject1 = new ArrayList(((List)localObject2).size());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = a((PackageInfo)((Iterator)localObject2).next());
      if ((!((com.google.android.finsky.dh.b)localObject3).k) && (!((com.google.android.finsky.dh.b)localObject3).equals(a))) {
        ((List)localObject1).add(localObject3);
      }
    }
    return (Collection)localObject1;
  }
  
  public final void a(String[] paramArrayOfString)
  {
    int i1 = paramArrayOfString.length;
    int n = 0;
    while (n < i1)
    {
      d(paramArrayOfString[n], false);
      n += 1;
    }
  }
  
  public final void b(String paramString)
  {
    h(paramString);
    d(paramString, false);
  }
  
  public final void b(String paramString, boolean paramBoolean)
  {
    h(paramString);
    d(paramString, false);
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString, boolean paramBoolean)
  {
    h(paramString);
    d(paramString, paramBoolean ^ true);
  }
  
  public final void d(String paramString)
  {
    this.k.remove(paramString);
  }
  
  @TargetApi(21)
  public final boolean e(String paramString)
  {
    if (com.google.android.finsky.ba.a.b(this.d)) {
      if (this.j.getLeanbackLaunchIntentForPackage(paramString) == null) {}
    }
    while (this.j.getLaunchIntentForPackage(paramString) != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final String f(String paramString)
  {
    try
    {
      paramString = this.j.getPackageInfo(paramString, 0).versionName;
      return paramString;
    }
    catch (NameNotFoundException paramString) {}
    return null;
  }
  
  public final int g(String paramString)
  {
    try
    {
      int n = this.j.getPackageInfo(paramString, 0).versionCode;
      return n;
    }
    catch (NameNotFoundException paramString) {}
    return -1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dh/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */