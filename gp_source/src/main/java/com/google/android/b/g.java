package com.google.android.b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g
{
  public static final Pattern a;
  public static final Pattern b;
  public static final AtomicBoolean c;
  private static final Uri d;
  private static final Uri e = Uri.parse("content://com.google.android.gsf.gservices");
  private static final HashMap f;
  private static HashMap g;
  private static final HashMap h = new HashMap();
  private static final HashMap i;
  private static final HashMap j;
  private static boolean k;
  private static String[] l = new String[0];
  private static Object m;
  
  static
  {
    d = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    b = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    a = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    c = new AtomicBoolean();
    f = new HashMap();
    i = new HashMap();
    j = new HashMap();
  }
  
  public static int a(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    Object localObject = a(paramContentResolver);
    localInteger = (Integer)a(i, paramString, Integer.valueOf(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    String str = a(paramContentResolver, paramString, null);
    paramContentResolver = localInteger;
    n = paramInt;
    if (str != null) {}
    try
    {
      n = Integer.parseInt(str);
      paramContentResolver = Integer.valueOf(n);
    }
    catch (NumberFormatException paramContentResolver)
    {
      for (;;)
      {
        paramContentResolver = localInteger;
        n = paramInt;
      }
    }
    a(localObject, i, paramString, paramContentResolver);
    return n;
  }
  
  public static long a(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    Object localObject = a(paramContentResolver);
    localLong = (Long)a(j, paramString, Long.valueOf(paramLong));
    if (localLong != null) {
      return localLong.longValue();
    }
    String str = a(paramContentResolver, paramString, null);
    paramContentResolver = localLong;
    l1 = paramLong;
    if (str != null) {}
    try
    {
      l1 = Long.parseLong(str);
      paramContentResolver = Long.valueOf(l1);
    }
    catch (NumberFormatException paramContentResolver)
    {
      for (;;)
      {
        paramContentResolver = localLong;
        l1 = paramLong;
      }
    }
    a(localObject, j, paramString, paramContentResolver);
    return l1;
  }
  
  public static Object a(ContentResolver paramContentResolver)
  {
    try
    {
      b(paramContentResolver);
      paramContentResolver = m;
      return paramContentResolver;
    }
    finally {}
  }
  
  private static Object a(HashMap paramHashMap, String paramString, Object paramObject)
  {
    try
    {
      if (paramHashMap.containsKey(paramString))
      {
        paramString = paramHashMap.get(paramString);
        paramHashMap = paramString;
        if (paramString == null) {
          paramHashMap = (HashMap)paramObject;
        }
        return paramHashMap;
      }
      return null;
    }
    finally {}
  }
  
  public static String a(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      try
      {
        b(paramContentResolver);
        localObject2 = m;
        if (g.containsKey(paramString1)) {
          break label265;
        }
        localObject1 = l;
        int i1 = localObject1.length;
        int n = 0;
        if (n >= i1) {
          break label124;
        }
        if (!paramString1.startsWith(localObject1[n]))
        {
          n += 1;
          continue;
        }
        if (!k)
        {
          c(paramContentResolver, l);
          if (g.containsKey(paramString1))
          {
            paramContentResolver = (String)g.get(paramString1);
            if (paramContentResolver != null) {
              break label307;
            }
            return paramString2;
          }
          return paramString2;
        }
      }
      finally {}
      if (g.isEmpty())
      {
        continue;
        label124:
        Cursor localCursor = paramContentResolver.query(e, null, null, new String[] { paramString1 }, null);
        if (localCursor != null) {}
        label265:
        label303:
        try
        {
          if (localCursor.moveToFirst())
          {
            localObject1 = localCursor.getString(1);
            paramContentResolver = (ContentResolver)localObject1;
            if (localObject1 != null)
            {
              paramContentResolver = (ContentResolver)localObject1;
              if (((String)localObject1).equals(paramString2)) {
                paramContentResolver = paramString2;
              }
            }
            a(localObject2, paramString1, paramContentResolver);
            if (paramContentResolver == null) {}
            for (;;)
            {
              paramContentResolver = paramString2;
              return paramString2;
              paramString2 = paramContentResolver;
            }
          }
          a(localObject2, paramString1, null);
          paramContentResolver = paramString2;
          return paramString2;
        }
        finally
        {
          if (localCursor == null) {
            break label303;
          }
          localCursor.close();
        }
        paramContentResolver = paramString2;
        if (localCursor != null)
        {
          localCursor.close();
          return paramString2;
          paramContentResolver = (String)g.get(paramString1);
          if (paramContentResolver == null) {}
          for (;;)
          {
            return paramString2;
            paramString2 = paramContentResolver;
          }
        }
        return paramContentResolver;
        label307:
        paramString2 = paramContentResolver;
      }
    }
  }
  
  public static Map a(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    paramContentResolver = paramContentResolver.query(d, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver != null) {
      try
      {
        if (paramContentResolver.moveToNext()) {
          paramVarArgs.put(paramContentResolver.getString(0), paramContentResolver.getString(1));
        }
        return paramVarArgs;
      }
      finally
      {
        paramContentResolver.close();
      }
    }
  }
  
  private static void a(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == m) {
        g.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
  
  private static void a(Object paramObject1, HashMap paramHashMap, String paramString, Object paramObject2)
  {
    try
    {
      if (paramObject1 == m)
      {
        paramHashMap.put(paramString, paramObject2);
        g.remove(paramString);
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(ContentResolver paramContentResolver, String paramString, boolean paramBoolean)
  {
    Object localObject = a(paramContentResolver);
    Boolean localBoolean = (Boolean)a(f, paramString, Boolean.valueOf(paramBoolean));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    String str = a(paramContentResolver, paramString, null);
    paramContentResolver = localBoolean;
    boolean bool = paramBoolean;
    if (str != null)
    {
      paramContentResolver = localBoolean;
      bool = paramBoolean;
      if (!str.equals(""))
      {
        if (!b.matcher(str).matches()) {
          break label99;
        }
        paramContentResolver = Boolean.valueOf(true);
        bool = true;
      }
    }
    for (;;)
    {
      a(localObject, f, paramString, paramContentResolver);
      return bool;
      label99:
      if (a.matcher(str).matches())
      {
        paramContentResolver = Boolean.valueOf(false);
        bool = false;
      }
      else
      {
        paramContentResolver = new StringBuilder();
        paramContentResolver.append("attempt to read gservices key ");
        paramContentResolver.append(paramString);
        paramContentResolver.append(" (value \"");
        paramContentResolver.append(str);
        paramContentResolver.append("\") as boolean");
        Log.w("Gservices", paramContentResolver.toString());
        paramContentResolver = localBoolean;
        bool = paramBoolean;
      }
    }
  }
  
  private static void b(ContentResolver paramContentResolver)
  {
    if (g == null)
    {
      c.set(false);
      g = new HashMap();
      m = new Object();
      k = false;
      paramContentResolver.registerContentObserver(e, true, new h());
    }
    while (!c.getAndSet(false)) {
      return;
    }
    g.clear();
    f.clear();
    i.clear();
    j.clear();
    h.clear();
    m = new Object();
    k = false;
  }
  
  public static void b(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    int n = 0;
    int i1 = paramVarArgs.length;
    if (i1 != 0) {
      for (;;)
      {
        HashSet localHashSet;
        ArrayList localArrayList;
        try
        {
          b(paramContentResolver);
          localHashSet = new HashSet((l.length + i1) * 4 / 3 + 1);
          localHashSet.addAll(Arrays.asList(l));
          localArrayList = new ArrayList();
          if (n < i1)
          {
            String str = paramVarArgs[n];
            if (!localHashSet.add(str)) {
              break label189;
            }
            localArrayList.add(str);
          }
        }
        finally {}
        if (localArrayList.isEmpty()) {}
        for (paramVarArgs = new String[0];; paramVarArgs = (String[])localArrayList.toArray(new String[localArrayList.size()]))
        {
          if (!k) {
            c(paramContentResolver, l);
          }
          for (;;)
          {
            return;
            if (g.isEmpty()) {
              break;
            }
            if (paramVarArgs.length != 0) {
              c(paramContentResolver, paramVarArgs);
            }
          }
          l = (String[])localHashSet.toArray(new String[localHashSet.size()]);
        }
        label189:
        n += 1;
      }
    }
  }
  
  private static void c(ContentResolver paramContentResolver, String[] paramArrayOfString)
  {
    g.putAll(a(paramContentResolver, paramArrayOfString));
    k = true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */