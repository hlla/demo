package com.google.android.finsky.dl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionInfo;
import android.text.TextUtils;
import com.google.android.finsky.utils.j;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
{
  private static final String[] a = { "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR" };
  private static final String[] b = { "android.permission.CAMERA" };
  private static final String[] c = { "android.permission.GET_ACCOUNTS", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS" };
  private static final String[] d = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "com.google.android.gms.permission.CAR_SPEED" };
  private static final String[] e = { "android.permission.RECORD_AUDIO" };
  private static final String[] f = { "android.permission.CALL_PHONE", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.READ_CALL_LOG", "android.permission.READ_PHONE_STATE", "android.permission.USE_SIP", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL" };
  private static final String[] g = { "android.permission.BODY_SENSORS" };
  private static final String[] h = { "android.permission.READ_SMS", "android.permission.READ_CELL_BROADCASTS", "android.permission.RECEIVE_SMS", "android.permission.RECEIVE_MMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.SEND_SMS" };
  private static final String[] i = { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" };
  private final Context j;
  private Map k = null;
  
  public a(Context paramContext)
  {
    this.j = paramContext;
  }
  
  private final void a(Map paramMap, Set paramSet, boolean paramBoolean, b[] paramArrayOfb)
  {
    String[] arrayOfString = j.a(null);
    Iterator localIterator = paramSet.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        try
        {
          localObject1 = this.j.getPackageManager().getPermissionInfo((String)localObject3, 0);
          if (localObject1 != null)
          {
            paramSet = (Integer)paramMap.get(localObject3);
            Object localObject2 = paramSet;
            label224:
            int m;
            if (paramSet == null)
            {
              if (((((PermissionInfo)localObject1).protectionLevel & 0xF) == 2) && (!"android.permission.SYSTEM_ALERT_WINDOW".equals(localObject3))) {
                continue;
              }
              switch (((String)localObject3).hashCode())
              {
              default: 
                m = -1;
              }
            }
            for (;;)
            {
              switch (m)
              {
              default: 
                int n = arrayOfString.length;
                m = 0;
                while (m < n) {
                  if (!arrayOfString[m].equals(localObject3)) {
                    m += 1;
                  } else {
                    m = 1;
                  }
                }
              }
              while (m == 0)
              {
                localObject2 = Integer.valueOf(9);
                localObject3 = paramArrayOfb[localObject2.intValue()];
                paramSet = (Set)localObject3;
                if (localObject3 == null) {
                  switch (((Integer)localObject2).intValue())
                  {
                  default: 
                    throw new IllegalStateException("invalid permission bucket.");
                  case 0: 
                    paramSet = new b(0, 2131231057, 2131952816, 2131952815);
                  }
                }
                for (;;)
                {
                  paramArrayOfb[localObject2.intValue()] = paramSet;
                  localObject1 = ((PermissionInfo)localObject1).loadLabel(this.j.getPackageManager());
                  if (localObject1 != null) {}
                  for (localObject1 = ((CharSequence)localObject1).toString(); !TextUtils.isEmpty((CharSequence)localObject1); localObject1 = null)
                  {
                    if (!paramBoolean)
                    {
                      paramSet.e.add(localObject1);
                      break;
                    }
                    paramSet.f.add(localObject1);
                    break;
                  }
                  paramSet = new b(9, 2131231072, 2131952826, 2131952825);
                  continue;
                  paramSet = new b(8, 2131231067, 2131952834, 2131952833);
                  continue;
                  paramSet = new b(7, 2131231068, 2131952832, 2131952831);
                  continue;
                  paramSet = new b(6, 2131231056, 2131952830, 2131952829);
                  continue;
                  paramSet = new b(5, 2131231070, 2131952828, 2131952827);
                  continue;
                  paramSet = new b(4, 2131231069, 2131952824, 2131952823);
                  continue;
                  paramSet = new b(3, 2131231066, 2131952822, 2131952821);
                  continue;
                  paramSet = new b(2, 2131231060, 2131952820, 2131952819);
                  continue;
                  paramSet = new b(1, 2131231058, 2131952818, 2131952817);
                }
                m = 0;
                continue;
                m = 1;
              }
              if (!((String)localObject3).equals("android.permission.READ_SOCIAL_STREAM")) {
                break label224;
              }
              m = 2;
              continue;
              if (!((String)localObject3).equals("android.permission.READ_USER_DICTIONARY")) {
                break label224;
              }
              m = 4;
              continue;
              if (!((String)localObject3).equals("com.android.browser.permission.WRITE_HISTORY_BOOKMARKS")) {
                break label224;
              }
              m = 8;
              continue;
              if (!((String)localObject3).equals("android.permission.WRITE_USER_DICTIONARY")) {
                break label224;
              }
              m = 5;
              continue;
              if (!((String)localObject3).equals("android.permission.WRITE_SMS")) {
                break label224;
              }
              m = 6;
              continue;
              if (!((String)localObject3).equals("android.permission.WRITE_PROFILE")) {
                break label224;
              }
              m = 1;
              continue;
              if (!((String)localObject3).equals("android.permission.WRITE_SOCIAL_STREAM")) {
                break label224;
              }
              m = 3;
              continue;
              if (!((String)localObject3).equals("com.android.browser.permission.READ_HISTORY_BOOKMARKS")) {
                break label224;
              }
              m = 7;
              continue;
              if (!((String)localObject3).equals("android.permission.AUTHENTICATE_ACCOUNTS")) {
                break label224;
              }
              m = 9;
              continue;
              if (!((String)localObject3).equals("android.permission.SUBSCRIBED_FEEDS_WRITE")) {
                break label224;
              }
              m = 13;
              continue;
              if (!((String)localObject3).equals("android.permission.READ_PROFILE")) {
                break label224;
              }
              m = 0;
              continue;
              if (!((String)localObject3).equals("android.permission.SUBSCRIBED_FEEDS_READ")) {
                break label224;
              }
              m = 12;
              continue;
              if (!((String)localObject3).equals("android.permission.MANAGE_ACCOUNTS")) {
                break label224;
              }
              m = 10;
              continue;
              if (!((String)localObject3).equals("android.permission.USE_CREDENTIALS")) {
                break label224;
              }
              m = 11;
            }
          }
        }
        catch (NameNotFoundException paramSet)
        {
          for (;;)
          {
            Object localObject1 = null;
          }
        }
      }
    }
  }
  
  public final c a(String[] paramArrayOfString, Set paramSet)
  {
    b[] arrayOfb = new b[10];
    if (paramArrayOfString == null) {
      return new c(arrayOfb, 9, false);
    }
    Object localObject2 = this.k;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      localObject2 = b;
      int n = localObject2.length;
      int m = 0;
      while (m < n)
      {
        ((Map)localObject1).put(localObject2[m], Integer.valueOf(1));
        m += 1;
      }
      localObject2 = a;
      n = localObject2.length;
      m = 0;
      while (m < n)
      {
        ((Map)localObject1).put(localObject2[m], Integer.valueOf(0));
        m += 1;
      }
      localObject2 = c;
      n = localObject2.length;
      m = 0;
      while (m < n)
      {
        ((Map)localObject1).put(localObject2[m], Integer.valueOf(2));
        m += 1;
      }
      localObject2 = d;
      n = localObject2.length;
      m = 0;
      while (m < n)
      {
        ((Map)localObject1).put(localObject2[m], Integer.valueOf(3));
        m += 1;
      }
      localObject2 = e;
      n = localObject2.length;
      m = 0;
      while (m < n)
      {
        ((Map)localObject1).put(localObject2[m], Integer.valueOf(4));
        m += 1;
      }
      localObject2 = f;
      n = localObject2.length;
      m = 0;
      while (m < n)
      {
        ((Map)localObject1).put(localObject2[m], Integer.valueOf(5));
        m += 1;
      }
      localObject2 = g;
      n = localObject2.length;
      m = 0;
      while (m < n)
      {
        ((Map)localObject1).put(localObject2[m], Integer.valueOf(6));
        m += 1;
      }
      localObject2 = h;
      n = localObject2.length;
      m = 0;
      while (m < n)
      {
        ((Map)localObject1).put(localObject2[m], Integer.valueOf(7));
        m += 1;
      }
      localObject2 = i;
      n = localObject2.length;
      m = 0;
      while (m < n)
      {
        ((Map)localObject1).put(localObject2[m], Integer.valueOf(8));
        m += 1;
      }
      this.k = Collections.unmodifiableMap((Map)localObject1);
      localObject1 = this.k;
    }
    paramArrayOfString = new HashSet(Arrays.asList(paramArrayOfString));
    if (paramSet != null) {
      paramArrayOfString.removeAll(paramSet);
    }
    a((Map)localObject1, paramArrayOfString, true, arrayOfb);
    if (paramSet != null) {
      a((Map)localObject1, paramSet, false, arrayOfb);
    }
    return new c(arrayOfb, 9, false);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dl/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */