package com.google.android.finsky.ah;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.api.d;
import com.google.android.finsky.api.i;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.j;
import com.google.android.finsky.volley.h;
import com.google.wireless.android.finsky.dfe.nano.ContentFilters.ContentFilterSettingsResponse;
import com.google.wireless.android.finsky.dfe.nano.bc;
import com.google.wireless.android.finsky.dfe.nano.be;
import com.google.wireless.android.finsky.dfe.nano.bf;
import com.google.wireless.android.finsky.dfe.nano.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class a
{
  private static final Pattern a = Pattern.compile(Character.toString(':'));
  private static final Pattern b = Pattern.compile(Character.toString(';'));
  
  public static int a(bf parambf)
  {
    if ((parambf.a & 0x1) != 0) {
      return parambf.f;
    }
    return -1;
  }
  
  public static Bundle a(bg parambg, bf parambf)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("authority", parambg.b);
    localBundle.putInt("filter_level", parambf.f);
    localBundle.putString("label", parambf.e);
    parambg = parambf.c;
    if (parambg != null)
    {
      parambg = parambg.g;
      if (parambg != null) {
        localBundle.putString("icon", parambg);
      }
    }
    return localBundle;
  }
  
  private static b a(String paramString)
  {
    String[] arrayOfString = b.split(paramString);
    if (arrayOfString.length < 3)
    {
      FinskyLog.d("Incorrect number of values, expected at least 3 in: %s", new Object[] { paramString });
      return null;
    }
    paramString = a.split(arrayOfString[0]);
    int[] arrayOfInt = new int[paramString.length];
    int i = 0;
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        j = Integer.parseInt(paramString[i]);
        arrayOfInt[i] = j;
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        try
        {
          i = Integer.parseInt(arrayOfString[1]);
        }
        catch (NumberFormatException paramString)
        {
          int j;
          FinskyLog.a(paramString, "Could not parse number selection values from: %s", new Object[] { arrayOfString[1] });
          return null;
        }
        try
        {
          j = Integer.parseInt(arrayOfString[2]);
          return new b(arrayOfInt, i, j);
        }
        catch (NumberFormatException paramString)
        {
          FinskyLog.a(paramString, "Could not parse number selection values from: %s", new Object[] { arrayOfString[2] });
        }
        paramString = paramString;
        FinskyLog.a(paramString, "Could not parse number selection values from: %s", new Object[] { arrayOfString[i] });
        return null;
      }
    }
    return null;
  }
  
  public static bf a(bg parambg, b[] paramArrayOfb)
  {
    Object localObject = null;
    int i = 0;
    for (;;)
    {
      if (paramArrayOfb == null) {
        break label145;
      }
      if (i >= paramArrayOfb.length) {
        break;
      }
      if (a(parambg.f, paramArrayOfb[i].b))
      {
        j = i;
        if (parambg.b == paramArrayOfb[i].a) {
          break label55;
        }
      }
      i += 1;
    }
    label55:
    label128:
    label130:
    label145:
    for (int j = -1;; j = -1)
    {
      if (j != -1) {}
      for (paramArrayOfb = paramArrayOfb[j];; paramArrayOfb = null)
      {
        bf[] arrayOfbf = parambg.g;
        j = arrayOfbf.length;
        i = 0;
        parambg = (bg)localObject;
        if (i < j)
        {
          parambg = arrayOfbf[i];
          if (paramArrayOfb == null) {
            break label130;
          }
          if ((parambg.a & 0x1) == 0) {
            if (paramArrayOfb.c == -1) {
              break label128;
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramArrayOfb.c == parambg.f) {
            do
            {
              return parambg;
            } while (parambg.g);
          }
        }
      }
    }
  }
  
  public static String a(b[] paramArrayOfb)
  {
    String[] arrayOfString = new String[paramArrayOfb.length];
    int i = 0;
    while (i < paramArrayOfb.length)
    {
      b localb = paramArrayOfb[i];
      StringBuilder localStringBuilder = new StringBuilder();
      int j = 0;
      for (;;)
      {
        int[] arrayOfInt = localb.b;
        if (j >= arrayOfInt.length) {
          break;
        }
        localStringBuilder.append(arrayOfInt[j]);
        int k = j + 1;
        j = k;
        if (k < localb.b.length)
        {
          localStringBuilder.append(':');
          j = k;
        }
      }
      localStringBuilder.append(';');
      localStringBuilder.append(localb.a);
      localStringBuilder.append(';');
      localStringBuilder.append(localb.c);
      arrayOfString[i] = localStringBuilder.toString();
      i += 1;
    }
    return j.a(arrayOfString);
  }
  
  public static List a(ContentFilters.ContentFilterSettingsResponse paramContentFilterSettingsResponse)
  {
    ArrayList localArrayList = new ArrayList();
    bg[] arrayOfbg = paramContentFilterSettingsResponse.h;
    int k = arrayOfbg.length;
    int i = 0;
    while (i < k)
    {
      bg localbg = arrayOfbg[i];
      bf[] arrayOfbf = localbg.g;
      int m = arrayOfbf.length;
      bf localbf1 = arrayOfbf[(m - 1)];
      int j = 0;
      while (j < m)
      {
        bf localbf2 = arrayOfbf[j];
        paramContentFilterSettingsResponse = localbf2;
        if (localbf2.g) {
          break label88;
        }
        j += 1;
      }
      paramContentFilterSettingsResponse = localbf1;
      label88:
      localArrayList.add(new b(localbg.f, localbg.b, a(paramContentFilterSettingsResponse)));
      i += 1;
    }
    return localArrayList;
  }
  
  private static void a(Context paramContext, i parami, com.google.android.finsky.accounts.c paramc, String paramString)
  {
    String str = (String)com.google.android.finsky.ag.c.C.a();
    paramc = paramc.cQ().iterator();
    while (paramc.hasNext()) {
      parami.a(((Account)paramc.next()).name).a(str);
    }
    parami = new Intent("com.google.android.finsky.action.CONTENT_FILTERS_CHANGED");
    if (paramString != null) {
      parami.putExtra("consistency_token", paramString);
    }
    paramContext.sendBroadcast(parami);
  }
  
  public static void a(Context paramContext, i parami, com.google.android.finsky.accounts.c paramc, boolean paramBoolean, bc parambc, String paramString)
  {
    if (paramBoolean)
    {
      Object localObject1 = parambc.b;
      ArrayList localArrayList = new ArrayList();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        localArrayList.add(new b(((be)localObject2).b, ((be)localObject2).a, ((be)localObject2).c));
        i += 1;
      }
      localObject1 = (b[])localArrayList.toArray(new b[localObject1.length]);
      com.google.android.finsky.ag.c.D.a(a((b[])localObject1));
      com.google.android.finsky.ag.c.C.a(parambc.a);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        com.google.android.finsky.ag.c.A.a(paramString);
      }
      for (;;)
      {
        a(paramContext, parami, paramc, paramString);
        return;
        com.google.android.finsky.ag.c.A.c();
      }
      com.google.android.finsky.ag.c.C.c();
    }
  }
  
  public static void a(Context paramContext, h paramh, i parami, com.google.android.finsky.accounts.c paramc, boolean paramBoolean, ContentFilters.ContentFilterSettingsResponse paramContentFilterSettingsResponse, b[] paramArrayOfb)
  {
    if (!paramBoolean) {
      com.google.android.finsky.ag.c.C.c();
    }
    for (;;)
    {
      paramh.a(null, 5);
      a(paramContext, parami, paramc, null);
      return;
      if ((paramArrayOfb != null) && (paramContentFilterSettingsResponse != null))
      {
        com.google.android.finsky.ag.c.D.a(a(paramArrayOfb));
        q localq = com.google.android.finsky.ag.c.C;
        bg[] arrayOfbg = paramContentFilterSettingsResponse.h;
        StringBuilder localStringBuilder = new StringBuilder();
        int m = arrayOfbg.length;
        int i = 0;
        if (i < m)
        {
          bg localbg = arrayOfbg[i];
          int n = paramArrayOfb.length;
          int j = 0;
          label99:
          int k;
          Object localObject;
          if (j < n)
          {
            paramContentFilterSettingsResponse = paramArrayOfb[j];
            k = paramContentFilterSettingsResponse.a;
            if (k >= 0)
            {
              localObject = paramContentFilterSettingsResponse.b;
              if (localObject != null) {
                break label186;
              }
            }
            FinskyLog.d("Badly formatted ContentFilterSelection authorityId is negative or documentTypes is null. [ContentFilterSelection=%s]", new Object[] { paramContentFilterSettingsResponse });
            paramContentFilterSettingsResponse = null;
          }
          for (;;)
          {
            if (paramContentFilterSettingsResponse == null)
            {
              j += 1;
              break label99;
            }
            localStringBuilder.append(paramContentFilterSettingsResponse);
            i += 1;
            break;
            label186:
            if ((localbg.c & 0x1) == 0) {}
            int[] arrayOfInt;
            do
            {
              FinskyLog.d("Badly formatted FilterRange authorityId is missing or documentType is null. [FilterRange=%s]", new Object[] { localbg });
              paramContentFilterSettingsResponse = null;
              break;
              arrayOfInt = localbg.f;
            } while (arrayOfInt == null);
            if (localbg.b == k)
            {
              if (a(arrayOfInt, (int[])localObject))
              {
                k = 0;
                localObject = localbg.g;
                if (k < localObject.length)
                {
                  localObject = localObject[k];
                  int i1 = ((bf)localObject).a;
                  if ((i1 & 0x1) == 0) {}
                  while (((i1 & 0x4) == 0) || (paramContentFilterSettingsResponse.c != ((bf)localObject).f))
                  {
                    k += 1;
                    break;
                  }
                  paramContentFilterSettingsResponse = ((bf)localObject).b;
                }
                else
                {
                  paramContentFilterSettingsResponse = null;
                }
              }
              else
              {
                paramContentFilterSettingsResponse = null;
              }
            }
            else {
              paramContentFilterSettingsResponse = null;
            }
          }
        }
        localq.a(localStringBuilder.toString());
      }
    }
  }
  
  private static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    if (i < paramArrayOfInt2.length)
    {
      int j = 0;
      for (;;)
      {
        if (j >= paramArrayOfInt1.length)
        {
          i += 1;
          break;
        }
        if (paramArrayOfInt2[i] == paramArrayOfInt1[j]) {
          break label46;
        }
        j += 1;
      }
      label46:
      bool1 = true;
    }
    return bool1;
  }
  
  public static b[] a(q paramq)
  {
    Object localObject = (String)paramq.a();
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      String[] arrayOfString = j.a((String)localObject);
      localObject = new b[arrayOfString.length];
      int i = 0;
      while (i < arrayOfString.length)
      {
        b localb = a(arrayOfString[i]);
        if (localb != null)
        {
          localObject[i] = localb;
          i += 1;
        }
        else
        {
          localObject = null;
        }
      }
    }
    for (;;)
    {
      if (localObject == null) {
        paramq.c();
      }
      return (b[])localObject;
      continue;
      localObject = new b[0];
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ah/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */