package android.support.v4.e;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.a.n;
import android.support.v4.content.a.l;
import android.support.v4.g.i;
import android.support.v4.g.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  public static final Object a = new Object();
  public static final v b = new v();
  public static final i c = new i(16);
  private static final u d = new u("fonts");
  private static final Comparator e = new p();
  
  public static Typeface a(Context paramContext, a parama, l arg2, Handler paramHandler, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(parama.b);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    Typeface localTypeface = (Typeface)c.a(localObject);
    if (localTypeface == null)
    {
      if (!paramBoolean) {}
      while (paramInt1 != -1)
      {
        parama = new c(paramContext, parama, paramInt2, (String)localObject);
        if (paramBoolean) {}
        try
        {
          paramContext = ((t)d.a(parama, paramInt1)).b;
          return paramContext;
        }
        catch (InterruptedException paramContext) {}
        if (??? != null) {}
        for (paramContext = new d(???, paramHandler);; paramContext = null) {
          synchronized (a)
          {
            if (!b.containsKey(localObject))
            {
              if (paramContext != null)
              {
                paramHandler = new ArrayList();
                paramHandler.add(paramContext);
                b.put(localObject, paramHandler);
              }
              paramContext = d;
              ??? = new e((String)localObject);
              paramContext.a(new w(parama, new Handler(), ???));
              return null;
            }
            if (paramContext != null) {
              ((ArrayList)b.get(localObject)).add(paramContext);
            }
            return null;
          }
        }
      }
      paramContext = a(paramContext, parama, paramInt2);
      if (??? != null)
      {
        paramInt1 = paramContext.a;
        if (paramInt1 != 0) {
          break label276;
        }
        ???.a(paramContext.b, paramHandler);
      }
      for (;;)
      {
        return paramContext.b;
        label276:
        ???.a(paramInt1, paramHandler);
      }
    }
    else
    {
      if (??? != null) {
        ???.a(localTypeface);
      }
      return localTypeface;
    }
    return null;
  }
  
  public static Typeface a(Context paramContext, r[] paramArrayOfr)
  {
    return android.support.v4.a.e.a(paramContext, paramArrayOfr, 0);
  }
  
  public static q a(Context paramContext, a parama)
  {
    Object localObject2 = paramContext.getPackageManager();
    Object localObject3 = paramContext.getResources();
    Object localObject1 = parama.c;
    ProviderInfo localProviderInfo = ((PackageManager)localObject2).resolveContentProvider((String)localObject1, 0);
    if (localProviderInfo == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("No package found for authority: ");
      paramContext.append((String)localObject1);
      throw new PackageManager.NameNotFoundException(paramContext.toString());
    }
    if (!localProviderInfo.packageName.equals(parama.d))
    {
      paramContext = new StringBuilder();
      paramContext.append("Found content provider ");
      paramContext.append((String)localObject1);
      paramContext.append(", but package was not ");
      paramContext.append(parama.d);
      throw new PackageManager.NameNotFoundException(paramContext.toString());
    }
    localObject1 = ((PackageManager)localObject2).getPackageInfo(localProviderInfo.packageName, 64).signatures;
    localObject2 = new ArrayList();
    int i = 0;
    while (i < localObject1.length)
    {
      ((List)localObject2).add(localObject1[i].toByteArray());
      i += 1;
    }
    Collections.sort((List)localObject2, e);
    localObject1 = parama.a;
    if (localObject1 == null) {
      localObject1 = android.support.v4.content.a.c.a((Resources)localObject3, 0);
    }
    for (;;)
    {
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject3 = new ArrayList((Collection)((List)localObject1).get(i));
        Collections.sort((List)localObject3, e);
        if (((List)localObject2).size() != ((List)localObject3).size())
        {
          i += 1;
        }
        else
        {
          int j = 0;
          for (;;)
          {
            if (j >= ((List)localObject2).size()) {
              break label329;
            }
            if (!Arrays.equals((byte[])((List)localObject2).get(j), (byte[])((List)localObject3).get(j))) {
              break;
            }
            j += 1;
          }
        }
      }
      label329:
      for (localObject1 = localProviderInfo;; localObject1 = null)
      {
        if (localObject1 != null) {
          return new q(0, a(paramContext, parama, ((ProviderInfo)localObject1).authority));
        }
        return new q(1, null);
      }
    }
  }
  
  static t a(Context paramContext, a parama, int paramInt)
  {
    int i = -3;
    try
    {
      parama = a(paramContext, parama);
      int j = parama.b;
      if (j == 0)
      {
        paramContext = android.support.v4.a.e.a(paramContext, parama.a, paramInt);
        if (paramContext != null) {
          i = 0;
        }
        return new t(paramContext, i);
      }
      if (j == 1) {
        i = -2;
      }
      return new t(null, i);
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return new t(null, -1);
  }
  
  public static Map a(Context paramContext, r[] paramArrayOfr, CancellationSignal paramCancellationSignal)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfr.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfr[i];
      if (((r)localObject).b != 0) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((r)localObject).d;
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, n.a(paramContext, paramCancellationSignal, (Uri)localObject));
        }
      }
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static void a(Context paramContext, a parama, s params, Handler paramHandler)
  {
    paramHandler.post(new f(paramContext, parama, new Handler(), params));
  }
  
  private static r[] a(Context paramContext, a parama, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Uri localUri1 = new Uri.Builder().scheme("content").authority(paramString).build();
    Uri localUri2 = new Uri.Builder().scheme("content").authority(paramString).appendPath("file").build();
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT > 16) {
          continue;
        }
        paramContext = paramContext.getContentResolver();
        parama = parama.e;
        paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { parama }, null);
        if (paramContext == null) {
          continue;
        }
        try
        {
          if (paramContext.getCount() <= 0) {
            continue;
          }
          int m = paramContext.getColumnIndex("result_code");
          paramString = new ArrayList();
          n = paramContext.getColumnIndex("_id");
          int i1 = paramContext.getColumnIndex("file_id");
          int i2 = paramContext.getColumnIndex("font_ttc_index");
          int i3 = paramContext.getColumnIndex("font_weight");
          int i4 = paramContext.getColumnIndex("font_italic");
          parama = paramString;
          if (!paramContext.moveToNext()) {
            continue;
          }
          if (m == -1) {
            continue;
          }
          i = paramContext.getInt(m);
          if (i2 == -1) {
            continue;
          }
          j = paramContext.getInt(i2);
          if (i1 == -1) {
            continue;
          }
          parama = ContentUris.withAppendedId(localUri2, paramContext.getLong(i1));
          if (i3 == -1) {
            continue;
          }
          k = paramContext.getInt(i3);
          if (i4 == -1) {
            continue;
          }
          if (paramContext.getInt(i4) != 1) {
            continue;
          }
          bool = true;
          paramString.add(new r(parama, j, k, bool, i));
          continue;
          if (paramContext == null) {
            continue;
          }
        }
        finally {}
      }
      finally
      {
        int n;
        int i;
        int j;
        int k;
        boolean bool;
        paramContext = null;
        continue;
      }
      paramContext.close();
      throw parama;
      bool = false;
      continue;
      bool = false;
      continue;
      k = 400;
      continue;
      parama = ContentUris.withAppendedId(localUri1, paramContext.getLong(n));
      continue;
      j = 0;
      continue;
      i = 0;
      continue;
      parama = localArrayList;
      if (paramContext != null) {
        paramContext.close();
      }
      return (r[])parama.toArray(new r[0]);
      parama = localArrayList;
      continue;
      paramContext = paramContext.getContentResolver();
      parama = parama.e;
      paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { parama }, null, null);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */