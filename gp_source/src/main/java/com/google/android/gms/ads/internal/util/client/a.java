package com.google.android.gms.ads.internal.util.client;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.i;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.l;
import com.google.android.gms.common.util.h;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e = com.google.android.gms.ads.c.class.getName();
  public static final String f;
  public static final Handler g = new Handler(Looper.getMainLooper());
  
  static
  {
    a = i.class.getName();
    b = l.class.getName();
    c = com.google.android.gms.ads.b.c.class.getName();
    d = com.google.android.gms.ads.b.d.class.getName();
    f = com.google.android.gms.ads.g.a.class.getName();
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return a(paramContext.getResources().getDisplayMetrics(), paramInt);
  }
  
  public static int a(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramDisplayMetrics);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    if (paramContext != null) {}
    for (paramContext = Settings.Secure.getString(paramContext, "android_id");; paramContext = null)
    {
      if (paramContext == null) {
        paramContext = "emulator";
      }
      for (;;)
      {
        return a(paramContext);
        if (a()) {
          break;
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < 2) {}
      try
      {
        localObject1 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject1).update(paramString.getBytes());
        localObject1 = String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, ((MessageDigest)localObject1).digest()) });
        return (String)localObject1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i += 1;
      }
      catch (ArithmeticException paramString) {}
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString2 = new StringTokenizer(paramString1, paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString2.hasMoreElements())
    {
      localStringBuilder.append(paramString2.nextToken());
      int i = 2;
      while ((i > 0) && (paramString2.hasMoreElements()))
      {
        localStringBuilder.append(".");
        localStringBuilder.append(paramString2.nextToken());
        i -= 1;
      }
      paramString1 = localStringBuilder.toString();
    }
    return paramString1;
  }
  
  public static Throwable a(Throwable paramThrowable)
  {
    if (!((Boolean)n.bH.a()).booleanValue())
    {
      LinkedList localLinkedList = new LinkedList();
      while (paramThrowable != null)
      {
        localLinkedList.push(paramThrowable);
        paramThrowable = paramThrowable.getCause();
      }
      paramThrowable = null;
      Throwable localThrowable;
      int j;
      do
      {
        localObject = paramThrowable;
        if (localLinkedList.isEmpty()) {
          break;
        }
        localThrowable = (Throwable)localLinkedList.pop();
        StackTraceElement[] arrayOfStackTraceElement = localThrowable.getStackTrace();
        localObject = new ArrayList();
        ((ArrayList)localObject).add(new StackTraceElement(localThrowable.getClass().getName(), "<filtered>", "<filtered>", 1));
        int k = arrayOfStackTraceElement.length;
        int i = 0;
        j = 0;
        if (i < k)
        {
          StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
          if (b(localStackTraceElement.getClassName()))
          {
            ((ArrayList)localObject).add(localStackTraceElement);
            j = 1;
          }
          for (;;)
          {
            i += 1;
            break;
            String str = localStackTraceElement.getClassName();
            if ((TextUtils.isEmpty(str)) || ((!str.startsWith("android.")) && (!str.startsWith("java.")))) {
              ((ArrayList)localObject).add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
            } else {
              ((ArrayList)localObject).add(localStackTraceElement);
            }
          }
        }
      } while (j == 0);
      if (paramThrowable != null) {}
      for (paramThrowable = new Throwable(localThrowable.getMessage(), paramThrowable);; paramThrowable = new Throwable(localThrowable.getMessage()))
      {
        paramThrowable.setStackTrace((StackTraceElement[])((ArrayList)localObject).toArray(new StackTraceElement[0]));
        break;
      }
    }
    Object localObject = paramThrowable;
    return (Throwable)localObject;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramContext, paramString1, paramString2, paramBundle, true, new b());
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean, d paramd)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      paramContext = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", paramString2);
      paramString1 = paramBundle.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        paramContext.appendQueryParameter(paramString2, paramBundle.getString(paramString2));
      }
      paramd.a(paramContext.toString());
      return;
      Context localContext = paramContext.getApplicationContext();
      Object localObject = localContext;
      if (localContext == null) {
        localObject = paramContext;
      }
      paramBundle.putString("os", Build.VERSION.RELEASE);
      paramBundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
      paramBundle.putString("appid", ((Context)localObject).getPackageName());
      localObject = paramString1;
      if (paramString1 == null)
      {
        int i = com.google.android.gms.common.d.d(paramContext);
        paramContext = new StringBuilder(20);
        paramContext.append(i);
        paramContext.append(".");
        paramContext.append(12451000);
        localObject = paramContext.toString();
      }
      paramBundle.putString("js", (String)localObject);
    }
  }
  
  public static void a(ViewGroup paramViewGroup, AdSizeParcel paramAdSizeParcel, String paramString1, String paramString2)
  {
    k.e(paramString2);
    if (paramViewGroup.getChildCount() == 0)
    {
      paramString2 = paramViewGroup.getContext();
      TextView localTextView = new TextView(paramString2);
      localTextView.setGravity(17);
      localTextView.setText(paramString1);
      localTextView.setTextColor(-65536);
      localTextView.setBackgroundColor(-16777216);
      paramString1 = new FrameLayout(paramString2);
      paramString1.setBackgroundColor(-65536);
      int i = a(paramString2, 3);
      paramString1.addView(localTextView, new FrameLayout.LayoutParams(paramAdSizeParcel.j - i, paramAdSizeParcel.c - i, 17));
      paramViewGroup.addView(paramString1, paramAdSizeParcel.j, paramAdSizeParcel.c);
    }
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(true);
    paramHttpURLConnection.setReadTimeout(60000);
    if (paramString != null) {
      paramHttpURLConnection.setRequestProperty("User-Agent", paramString);
    }
    paramHttpURLConnection.setUseCaches(false);
  }
  
  public static boolean a()
  {
    return Build.DEVICE.startsWith("generic");
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getMetrics(localDisplayMetrics);
    return b(localDisplayMetrics, paramInt);
  }
  
  public static int b(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return Math.round(paramInt / paramDisplayMetrics.density);
  }
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    if (paramContext != null) {
      return Settings.Secure.getString(paramContext, "android_id");
    }
    return null;
  }
  
  public static boolean b()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static boolean b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith((String)n.bF.a()))) {}
    try
    {
      boolean bool = Class.forName(paramString).isAnnotationPresent(com.google.android.gms.ads.internal.q.a.a.class);
      return bool;
    }
    catch (Exception localException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        break label71;
      }
    }
    return true;
    return false;
    label71:
    for (paramString = new String("Fail to check class type for class ");; paramString = "Fail to check class type for class ".concat(paramString))
    {
      k.b(paramString, localException);
      return false;
    }
  }
  
  public static String c()
  {
    Object localObject1 = UUID.randomUUID();
    byte[] arrayOfByte1 = BigInteger.valueOf(((UUID)localObject1).getLeastSignificantBits()).toByteArray();
    byte[] arrayOfByte2 = BigInteger.valueOf(((UUID)localObject1).getMostSignificantBits()).toByteArray();
    localObject1 = new BigInteger(1, arrayOfByte1).toString();
    int i = 0;
    while (i < 2)
    {
      try
      {
        Object localObject2 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject2).update(arrayOfByte1);
        ((MessageDigest)localObject2).update(arrayOfByte2);
        byte[] arrayOfByte3 = new byte[8];
        System.arraycopy(((MessageDigest)localObject2).digest(), 0, arrayOfByte3, 0, 8);
        localObject2 = new BigInteger(1, arrayOfByte3).toString();
        localObject1 = localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return (String)localObject1;
  }
  
  public static boolean c(Context paramContext)
  {
    int i = com.google.android.gms.common.d.a(paramContext, 12451000);
    return (i == 0) || (i == 2);
  }
  
  public static boolean c(Context paramContext, int paramInt)
  {
    return com.google.android.gms.common.d.a(paramContext, paramInt) == 0;
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      bool1 = bool2;
      if ((int)(paramContext.heightPixels / paramContext.density) < 600) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @TargetApi(17)
  public static boolean e(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int i;
    int j;
    if (h.a())
    {
      paramContext.getRealMetrics(localDisplayMetrics);
      i = localDisplayMetrics.heightPixels;
      j = localDisplayMetrics.widthPixels;
    }
    for (;;)
    {
      paramContext.getMetrics(localDisplayMetrics);
      int k = localDisplayMetrics.heightPixels;
      int m = localDisplayMetrics.widthPixels;
      return (k == i) && (m == j);
      try
      {
        i = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(paramContext, new Object[0])).intValue();
        j = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public static int f(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/client/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */