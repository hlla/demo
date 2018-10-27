package com.google.android.finsky.dl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionInfo;
import android.text.TextUtils;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dh.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static final String[] a = { "com.android.vending.BILLING" };
  private static final String[] b;
  private static final String[] c;
  private static final String[] d;
  private static final String[] e;
  private static final String[] f;
  private static final String[] g;
  private static final String[] h = { "android.permission.GET_ACCOUNTS", "android.permission.MANAGE_ACCOUNTS", "android.permission.READ_PROFILE", "android.permission.WRITE_PROFILE" };
  private static final String[] i = { "android.permission.ACCESS_MOCK_LOCATION", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCOUNT_MANAGER", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.BATTERY_STATS", "android.permission.BLUETOOTH", "android.permission.BROADCAST_STICKY", "android.permission.CHANGE_CONFIGURATION", "android.permission.CHANGE_NETWORK_STATE", "android.permission.CHANGE_WIFI_MULTICAST_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.CHANGE_WIMAX_STATE", "android.permission.CLEAR_APP_CACHE", "android.permission.DISABLE_KEYGUARD", "android.permission.EXPAND_STATUS_BAR", "android.permission.FLASHLIGHT", "android.permission.GET_PACKAGE_SIZE", "android.permission.INTERNET", "android.permission.KILL_BACKGROUND_PROCESSES", "android.permission.MODIFY_AUDIO_SETTINGS", "android.permission.NFC", "android.permission.PERSISTENT_ACTIVITY", "android.permission.READ_SYNC_SETTINGS", "android.permission.READ_USER_DICTIONARY", "android.permission.RECEIVE_BOOT_COMPLETED", "android.permission.REORDER_TASKS", "android.permission.SERIAL_PORT", "android.permission.SET_ALWAYS_FINISH", "android.permission.SET_ANIMATION_SCALE", "android.permission.SET_DEBUG_APP", "android.permission.SET_PREFERRED_APPLICATIONS", "android.permission.SET_PROCESS_LIMIT", "android.permission.SET_TIME_ZONE", "android.permission.SET_WALLPAPER", "android.permission.SIGNAL_PERSISTENT_PROCESSES", "android.permission.SYSTEM_ALERT_WINDOW", "android.permission.USE_CREDENTIALS", "android.permission.USE_SIP", "android.permission.VIBRATE", "android.permission.WAKE_LOCK", "android.permission.WRITE_SETTINGS", "android.permission.WRITE_SYNC_SETTINGS", "android.permission.WRITE_USER_DICTIONARY", "com.android.alarm.permission.SET_ALARM", "com.android.browser.permission.WRITE_HISTORY_BOOKMARKS", "com.android.launcher.permission.INSTALL_SHORTCUT", "com.android.launcher.permission.UNINSTALL_SHORTCUT", "com.android.vending.CHECK_LICENSE", "com.google.android.providers.gsf.permission.READ_GSERVICES" };
  private static final String[] j;
  private static final String[] k;
  private static final String[] l;
  private static final String[] m;
  private static final String[] n;
  private static final String[] o;
  private static final String[] p;
  private static final String[] q;
  private final Context r;
  private Set s = null;
  private Map t = null;
  private final com.google.android.finsky.bo.c u;
  private final a v;
  
  static
  {
    c = new String[] { "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR" };
    e = new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS" };
    j = new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS", "android.permission.ACCESS_GPS", "com.google.android.gms.permission.CAR_SPEED" };
    o = new String[] { "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.WRITE_SMS", "android.permission.SEND_SMS", "android.permission.RECEIVE_MMS", "android.permission.RECEIVE_WAP_PUSH" };
    l = new String[] { "android.permission.CALL_PHONE", "android.permission.WRITE_CALL_LOG", "android.permission.READ_CALL_LOG", "android.permission.CALL_PRIVILEGED", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.MODIFY_PHONE_STATE" };
    m = new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.MOUNT_FORMAT_FILESYSTEMS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS" };
    d = new String[] { "android.permission.CAMERA", "android.permission.RECORD_VIDEO" };
    k = new String[] { "android.permission.RECORD_AUDIO" };
    f = new String[] { "android.permission.READ_LOGS", "android.permission.GET_TASKS", "android.permission.DUMP", "com.android.browser.permission.READ_HISTORY_BOOKMARKS" };
    n = new String[] { "android.permission.WRITE_APN_SETTINGS" };
    q = new String[] { "android.permission.ACCESS_WIFI_STATE" };
    b = new String[] { "android.permission.BLUETOOTH_ADMIN" };
    g = new String[] { "android.permission.READ_PHONE_STATE" };
    p = new String[] { "android.permission.BODY_SENSORS" };
  }
  
  public d(Context paramContext, a parama, com.google.android.finsky.bo.c paramc)
  {
    this.r = paramContext;
    this.v = parama;
    this.u = paramc;
  }
  
  public static b a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("invalid permission bucket.");
    case 16: 
      return new b(16, 2131231072, 2131952942, 2131952941);
    case 15: 
      return new b(15, 2131231056, 2131952951, 2131952955);
    case 14: 
      return new b(14, 2131231062, 2131952932, 2131952931);
    case 13: 
      return new b(13, 2131231055, 2131952922, 2131952921);
    case 12: 
      return new b(12, 2131231071, 2131952953, 2131952952);
    case 11: 
      return new b(11, 2131231069, 2131952940, 2131952939);
    case 10: 
      return new b(10, 2131231058, 2131952926, 2131952925);
    case 9: 
      return new b(9, 2131231067, 2131952946, 2131952945);
    case 8: 
      return new b(8, 2131231070, 2131952944, 2131952943);
    case 7: 
      return new b(7, 2131231068, 2131952950, 2131952949);
    case 6: 
      return new b(6, 2131231066, 2131952938, 2131952937);
    case 5: 
      return new b(5, 2131231060, 2131952928, 2131952927);
    case 4: 
      return new b(4, 2131231057, 2131952924, 2131952923);
    case 3: 
      return new b(3, 2131231064, 2131952934, 2131952933);
    case 2: 
      return new b(2, 2131231061, 2131952948, 2131952947);
    case 1: 
      return new b(1, 2131231063, 2131952930, 2131952929);
    }
    return new b(0, 2131231065, 2131952936, 2131952935);
  }
  
  public static void a(com.google.android.finsky.cg.b paramb, String paramString)
  {
    paramb.f(paramString, 1);
  }
  
  private final void a(Map paramMap, Set paramSet, boolean paramBoolean1, boolean paramBoolean2, b[] paramArrayOfb)
  {
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (Integer)paramMap.get(str);
      paramSet = (Set)localObject;
      if (localObject == null)
      {
        boolean bool = a().contains(str);
        if (bool) {
          break label181;
        }
        if ((bool) || (!a(str))) {
          continue;
        }
      }
      for (;;)
      {
        paramSet = Integer.valueOf(16);
        localObject = paramArrayOfb[paramSet.intValue()];
        if (localObject == null)
        {
          localObject = a(paramSet.intValue());
          paramArrayOfb[paramSet.intValue()] = localObject;
        }
        for (paramSet = (Set)localObject;; paramSet = (Set)localObject)
        {
          localObject = b(str);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          if (!paramBoolean2)
          {
            paramSet.e.add(localObject);
            break;
          }
          paramSet.f.add(localObject);
          break;
        }
        label181:
        if (!paramBoolean1) {
          break;
        }
      }
    }
  }
  
  private final boolean a(String paramString)
  {
    try
    {
      paramString = this.r.getPackageManager().getPermissionInfo(paramString, 0);
      if (paramString != null)
      {
        int i1 = paramString.protectionLevel;
        if (i1 == 1) {
          return true;
        }
      }
    }
    catch (NameNotFoundException paramString) {}
    return false;
  }
  
  private final String b(String paramString)
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = this.r.getPackageManager().getPermissionInfo(paramString, 0);
      paramString = (String)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((PermissionInfo)localObject2).loadLabel(this.r.getPackageManager());
        paramString = (String)localObject1;
        if (localObject2 != null) {
          paramString = ((CharSequence)localObject2).toString();
        }
      }
      return paramString;
    }
    catch (NameNotFoundException paramString) {}
    return null;
  }
  
  public final c a(String[] paramArrayOfString, Set paramSet, boolean paramBoolean)
  {
    return a(paramArrayOfString, paramSet, paramBoolean, false);
  }
  
  public final c a(String[] paramArrayOfString, Set paramSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    b[] arrayOfb = new b[17];
    if (paramArrayOfString == null) {
      return new c(arrayOfb, 16, false);
    }
    Map localMap = b();
    if (paramBoolean1)
    {
      paramArrayOfString = new HashSet(Arrays.asList(paramArrayOfString));
      if (paramSet != null) {
        paramArrayOfString.removeAll(paramSet);
      }
      for (paramBoolean1 = false;; paramBoolean1 = false)
      {
        a(localMap, paramArrayOfString, paramBoolean2, true, arrayOfb);
        if (paramSet != null) {
          a(localMap, paramSet, paramBoolean2, false, arrayOfb);
        }
        return new c(arrayOfb, 16, paramBoolean1);
      }
    }
    HashSet localHashSet;
    if (paramSet != null)
    {
      localHashSet = new HashSet(Arrays.asList(paramArrayOfString));
      localHashSet.removeAll(paramSet);
      paramSet = localMap.keySet();
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext()) {
        if (paramSet.contains((String)localIterator.next())) {
          paramBoolean1 = true;
        }
      }
    }
    for (;;)
    {
      paramArrayOfString = new HashSet(Arrays.asList(paramArrayOfString));
      paramSet = null;
      break;
      localHashSet = new HashSet(localHashSet);
      localHashSet.removeAll(paramSet);
      paramSet = localHashSet.iterator();
      for (;;)
      {
        if (paramSet.hasNext()) {
          if (a((String)paramSet.next()))
          {
            paramBoolean1 = true;
            break;
          }
        }
      }
      return new c(arrayOfb, 16, false);
      paramBoolean1 = false;
    }
  }
  
  public final Set a()
  {
    if (this.s == null)
    {
      this.s = new HashSet(Arrays.asList(i));
      if (this.u.cY().a(12607368L)) {
        this.s.remove("android.permission.SYSTEM_ALERT_WINDOW");
      }
    }
    return this.s;
  }
  
  public final Map b()
  {
    Object localObject2 = this.t;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      localObject2 = a;
      int i2 = localObject2.length;
      int i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(0));
        i1 += 1;
      }
      localObject2 = h;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(3));
        i1 += 1;
      }
      localObject2 = e;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(5));
        i1 += 1;
      }
      localObject2 = c;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(4));
        i1 += 1;
      }
      localObject2 = j;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(6));
        i1 += 1;
      }
      localObject2 = o;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(7));
        i1 += 1;
      }
      localObject2 = l;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(8));
        i1 += 1;
      }
      localObject2 = m;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(9));
        i1 += 1;
      }
      localObject2 = d;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(10));
        i1 += 1;
      }
      localObject2 = k;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(11));
        i1 += 1;
      }
      localObject2 = f;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(1));
        i1 += 1;
      }
      localObject2 = n;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(2));
        i1 += 1;
      }
      localObject2 = q;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(12));
        i1 += 1;
      }
      localObject2 = b;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(13));
        i1 += 1;
      }
      localObject2 = g;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(14));
        i1 += 1;
      }
      localObject2 = p;
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((Map)localObject1).put(localObject2[i1], Integer.valueOf(15));
        i1 += 1;
      }
      this.t = Collections.unmodifiableMap((Map)localObject1);
      localObject1 = this.t;
    }
    return (Map)localObject1;
  }
  
  public final boolean b(com.google.android.finsky.cg.b paramb, String paramString)
  {
    boolean bool1 = true;
    paramb = paramb.a(paramString);
    if (paramb != null) {
      if (paramb.G != 1) {}
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramb = this.v.a(paramString);
        bool2 = bool1;
        if (paramb != null) {
          bool2 = paramb.m;
        }
      }
      return bool2;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dl/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */