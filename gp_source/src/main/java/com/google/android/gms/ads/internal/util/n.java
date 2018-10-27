package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class n
{
  public static final Handler a = new f(Looper.getMainLooper());
  public boolean b = true;
  public final Object c = new Object();
  public String d;
  private boolean e = false;
  private boolean f = false;
  
  public static Bitmap a(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
    paramView.setDrawingCacheEnabled(false);
    return localBitmap;
  }
  
  public static DisplayMetrics a(WindowManager paramWindowManager)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static WebResourceResponse a(HttpURLConnection paramHttpURLConnection)
  {
    Object localObject1 = bt.A.e;
    localObject1 = paramHttpURLConnection.getContentType();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (String str = localObject1.split(";")[0].trim();; str = "")
    {
      localObject1 = bt.A.e;
      localObject1 = paramHttpURLConnection.getContentType();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(";");
        if (localObject1.length != 1) {}
      }
      else
      {
        localObject1 = "";
      }
      for (;;)
      {
        Object localObject3 = paramHttpURLConnection.getHeaderFields();
        Object localObject2 = new HashMap(((Map)localObject3).size());
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          if ((localEntry.getKey() != null) && (localEntry.getValue() != null) && (((List)localEntry.getValue()).size() > 0)) {
            ((Map)localObject2).put((String)localEntry.getKey(), (String)((List)localEntry.getValue()).get(0));
          }
        }
        return bt.A.g.a(str, (String)localObject1, paramHttpURLConnection.getResponseCode(), paramHttpURLConnection.getResponseMessage(), (Map)localObject2, paramHttpURLConnection.getInputStream());
        int i = 1;
        for (;;)
        {
          if (i >= localObject1.length) {
            break label288;
          }
          if (localObject1[i].trim().startsWith("charset"))
          {
            localObject2 = localObject1[i].trim().split("=");
            if (localObject2.length > 1)
            {
              localObject1 = localObject2[1].trim();
              break;
            }
          }
          i += 1;
        }
        label288:
        localObject1 = "";
      }
    }
  }
  
  public static PopupWindow a(View paramView, int paramInt1, int paramInt2)
  {
    return new PopupWindow(paramView, paramInt1, paramInt2, false);
  }
  
  public static String a()
  {
    return UUID.randomUUID().toString();
  }
  
  public static String a(Context paramContext, View paramView, AdSizeParcel paramAdSizeParcel)
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.f.a()).booleanValue())
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("width", paramAdSizeParcel.i);
        localJSONObject2.put("height", paramAdSizeParcel.b);
        localJSONObject1.put("size", localJSONObject2);
        localJSONObject1.put("activity", s(paramContext));
        if (paramAdSizeParcel.e) {}
        for (;;)
        {
          return localJSONObject1.toString();
          paramContext = new JSONArray();
          if (paramView != null) {
            break;
          }
          if (paramContext.length() > 0) {
            localJSONObject1.put("parents", paramContext);
          }
        }
        paramAdSizeParcel = paramView.getParent();
      }
      catch (JSONException paramContext)
      {
        e.e("Fail to get view hierarchy json", paramContext);
        return null;
      }
      if (paramAdSizeParcel != null) {
        if (!(paramAdSizeParcel instanceof ViewGroup)) {
          break label226;
        }
      }
      label226:
      for (int i = ((ViewGroup)paramAdSizeParcel).indexOfChild(paramView);; i = -1)
      {
        paramView = new JSONObject();
        paramView.put("type", paramAdSizeParcel.getClass().getName());
        paramView.put("index_of_child", i);
        paramContext.put(paramView);
        if (paramAdSizeParcel != null)
        {
          if ((paramAdSizeParcel instanceof View))
          {
            paramView = (View)paramAdSizeParcel;
            break;
          }
          paramView = null;
          break;
        }
        paramView = null;
        break;
      }
    }
    return null;
  }
  
  public static String a(InputStreamReader paramInputStreamReader)
  {
    StringBuilder localStringBuilder = new StringBuilder(8192);
    char[] arrayOfChar = new char['ࠀ'];
    for (;;)
    {
      int i = paramInputStreamReader.read(arrayOfChar);
      if (i == -1) {
        break;
      }
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    return Uri.parse(paramString).buildUpon().query(null).build().toString();
  }
  
  public static Map a(Uri paramUri)
  {
    if (paramUri != null)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = bt.A.g.a(paramUri).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramUri.getQueryParameter(str));
      }
      return localHashMap;
    }
    return null;
  }
  
  private final JSONArray a(Collection paramCollection)
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a(localJSONArray, paramCollection.next());
    }
    return localJSONArray;
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    finally
    {
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
    }
  }
  
  @TargetApi(18)
  public static void a(Context paramContext, Uri paramUri)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", paramUri);
      Bundle localBundle = new Bundle();
      localIntent.putExtras(localBundle);
      b(paramContext, localIntent);
      localBundle.putString("com.android.browser.application_id", paramContext.getPackageName());
      paramContext.startActivity(localIntent);
      paramContext = paramUri.toString();
      paramUri = new StringBuilder(String.valueOf(paramContext).length() + 26);
      paramUri.append("Opening ");
      paramUri.append(paramContext);
      paramUri.append(" in a new browser.");
      e.b(paramUri.toString());
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      e.c("No browser is found.", paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    a(paramContext, paramString1, localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = bt.A.e;
      paramBundle.putString("device", b());
      paramBundle.putString("eids", TextUtils.join(",", com.google.android.gms.ads.internal.f.n.a()));
    }
    Object localObject = com.google.android.gms.ads.internal.client.u.h.a;
    com.google.android.gms.ads.internal.util.client.a.a(paramContext, paramString1, paramString2, paramBundle, paramBoolean, new s(paramContext, paramString1));
  }
  
  public static void a(Context paramContext, String paramString, List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      new bl(paramContext, paramString, (String)paramList.next()).c();
    }
  }
  
  public static void a(Context paramContext, List paramList)
  {
    Activity localActivity;
    if ((paramContext instanceof Activity))
    {
      localActivity = (Activity)paramContext;
      if (!TextUtils.isEmpty(org.chromium.customtabsclient.shared.a.a(localActivity)))
      {
        if (paramList != null) {
          break label33;
        }
        e.a("Cannot ping urls: empty list.");
      }
    }
    label33:
    com.google.android.gms.ads.internal.i.a locala;
    do
    {
      do
      {
        return;
        if (!com.google.android.gms.ads.internal.i.a.a(paramContext))
        {
          e.a("Cannot ping url because custom tabs is not supported");
          return;
        }
        locala = new com.google.android.gms.ads.internal.i.a();
        locala.c = new q(paramList, locala, paramContext);
      } while (locala.a != null);
      paramContext = org.chromium.customtabsclient.shared.a.a(localActivity);
    } while (paramContext == null);
    locala.b = new org.chromium.customtabsclient.shared.b(locala);
    android.support.c.b.a(localActivity, paramContext, locala.b);
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    l.a(paramRunnable);
  }
  
  private final void a(JSONArray paramJSONArray, Object paramObject)
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONArray.put(b((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONArray.put(a((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramJSONArray.put(a((Collection)paramObject));
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      JSONArray localJSONArray = new JSONArray();
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        a(localJSONArray, paramObject[i]);
        i += 1;
      }
      paramJSONArray.put(localJSONArray);
      return;
    }
    paramJSONArray.put(paramObject);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONObject.put(paramString, b((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONObject.put(paramString, a((Map)paramObject));
      return;
    }
    if (!(paramObject instanceof Collection))
    {
      if ((paramObject instanceof Object[]))
      {
        paramJSONObject.put(paramString, a(Arrays.asList((Object[])paramObject)));
        return;
      }
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "null";
    }
    paramJSONObject.put(str, a((Collection)paramObject));
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.abs(paramInt1 - paramInt2) <= paramInt3;
  }
  
  @TargetApi(24)
  public static boolean a(Activity paramActivity, Configuration paramConfiguration)
  {
    boolean bool2 = false;
    boolean bool1;
    if (((Boolean)com.google.android.gms.ads.internal.f.n.aO.a()).booleanValue())
    {
      bool1 = paramActivity.isInMultiWindowMode() ^ true;
      return bool1;
    }
    com.google.android.gms.ads.internal.util.client.a locala = com.google.android.gms.ads.internal.client.u.h.a;
    int j = com.google.android.gms.ads.internal.util.client.a.a(paramActivity, paramConfiguration.screenHeightDp);
    int k = com.google.android.gms.ads.internal.util.client.a.a(paramActivity, paramConfiguration.screenWidthDp);
    paramConfiguration = a((WindowManager)paramActivity.getApplicationContext().getSystemService("window"));
    int m = paramConfiguration.heightPixels;
    int n = paramConfiguration.widthPixels;
    int i = paramActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {}
    for (i = paramActivity.getResources().getDimensionPixelSize(i);; i = 0)
    {
      int i1 = (int)Math.round(paramActivity.getResources().getDisplayMetrics().density + 0.5D);
      i1 = ((Integer)com.google.android.gms.ads.internal.f.n.bl.a()).intValue() * i1;
      bool1 = bool2;
      if (!a(m, i + j, i1)) {
        break;
      }
      bool1 = bool2;
      if (!a(n, k, i1)) {
        break;
      }
      return true;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = com.google.android.gms.ads.internal.reward.c.b(paramContext);
    paramContext = new Intent();
    paramContext.setClassName((Context)localObject, "com.google.android.gms.ads.AdActivity");
    localObject = ((Context)localObject).getPackageManager();
    try
    {
      paramContext = ((PackageManager)localObject).resolveActivity(paramContext, 65536);
      if (paramContext == null) {}
      while (paramContext.activityInfo == null)
      {
        e.e("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
        return false;
      }
      if ((paramContext.activityInfo.configChanges & 0x10) == 0) {
        e.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboard" }));
      }
      for (boolean bool = false;; bool = true)
      {
        if ((paramContext.activityInfo.configChanges & 0x20) == 0)
        {
          e.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboardHidden" }));
          bool = false;
        }
        if ((paramContext.activityInfo.configChanges & 0x80) == 0)
        {
          e.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "orientation" }));
          bool = false;
        }
        if ((paramContext.activityInfo.configChanges & 0x100) == 0)
        {
          e.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenLayout" }));
          bool = false;
        }
        if ((paramContext.activityInfo.configChanges & 0x200) == 0)
        {
          e.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "uiMode" }));
          bool = false;
        }
        if ((paramContext.activityInfo.configChanges & 0x400) == 0)
        {
          e.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenSize" }));
          bool = false;
        }
        if ((paramContext.activityInfo.configChanges & 0x800) != 0) {
          break;
        }
        e.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "smallestScreenSize" }));
        return false;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      e.e("Could not verify that com.google.android.gms.ads.AdActivity is declared in AndroidManifest.xml", paramContext);
      bt.A.i.a(paramContext, "AdUtil.hasAdActivity");
      return false;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = com.google.android.gms.ads.internal.reward.c.b(paramContext);
    String str = paramContext.getPackageName();
    return com.google.android.gms.common.b.c.a.a(paramContext).a.getPackageManager().checkPermission(paramString, str) == 0;
  }
  
  public static boolean a(View paramView, PowerManager paramPowerManager, KeyguardManager paramKeyguardManager)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    int i;
    if (bt.A.e.b) {
      i = 1;
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramView.getVisibility() == 0)
      {
        if (paramView.isShown()) {
          break label45;
        }
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        label45:
        if (paramPowerManager != null)
        {
          bool1 = bool2;
          if (!paramPowerManager.isScreenOn()) {}
        }
        else
        {
          bool1 = bool2;
          if (i != 0) {
            if (((Boolean)com.google.android.gms.ads.internal.f.n.aG.a()).booleanValue())
            {
              if (!paramView.getLocalVisibleRect(new Rect()))
              {
                bool1 = bool3;
                if (!paramView.getGlobalVisibleRect(new Rect())) {
                  bool1 = bool2;
                }
              }
              else
              {
                bool1 = true;
              }
            }
            else {
              bool1 = true;
            }
          }
        }
      }
      if (paramKeyguardManager != null)
      {
        if (paramKeyguardManager.inKeyguardRestrictedInputMode())
        {
          if (!d(paramView)) {
            i = 0;
          } else {
            i = 1;
          }
        }
        else {
          i = 1;
        }
      }
      else {
        i = 1;
      }
    }
  }
  
  public static int[] a(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.findViewById(16908290);
      if (paramActivity != null) {
        return new int[] { paramActivity.getWidth(), paramActivity.getHeight() };
      }
    }
    return f();
  }
  
  public static int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString = String.valueOf(paramString);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 22);
      localStringBuilder.append("Could not parse value:");
      localStringBuilder.append(paramString);
      e.e(localStringBuilder.toString());
    }
    return 0;
  }
  
  public static Bitmap b(View paramView)
  {
    try
    {
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      if (i == 0) {}
      while (j == 0)
      {
        e.e("Width or height of view is zero");
        return null;
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
      Canvas localCanvas = new Canvas(localBitmap);
      paramView.layout(0, 0, i, j);
      paramView.draw(localCanvas);
      return localBitmap;
    }
    catch (RuntimeException paramView)
    {
      e.c("Fail to capture the webview", paramView);
    }
    return null;
  }
  
  public static String b()
  {
    String str2 = Build.MANUFACTURER;
    String str1 = Build.MODEL;
    Object localObject = str1;
    if (!str1.startsWith(str2))
    {
      localObject = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str1).length());
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str1);
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  @TargetApi(18)
  public static void b(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (Build.VERSION.SDK_INT >= 18)) {
      if (paramIntent.getExtras() != null) {
        break label53;
      }
    }
    label53:
    for (Bundle localBundle = new Bundle();; localBundle = paramIntent.getExtras())
    {
      localBundle.putBinder("android.support.customtabs.extra.SESSION", null);
      localBundle.putString("com.android.browser.application_id", paramContext.getPackageName());
      paramIntent.putExtras(localBundle);
      return;
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.openFileOutput(paramString1, 0);
      paramContext.write(paramString2.getBytes("UTF-8"));
      paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
      e.c("Error writing to file in internal storage.", paramContext);
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.aB.a()).booleanValue()) {
      a(paramContext, paramString1, paramString2, paramBundle, paramBoolean);
    }
  }
  
  public static int[] b(Activity paramActivity)
  {
    int[] arrayOfInt = a(paramActivity);
    com.google.android.gms.ads.internal.util.client.a locala = com.google.android.gms.ads.internal.client.u.h.a;
    int i = com.google.android.gms.ads.internal.util.client.a.b(paramActivity, arrayOfInt[0]);
    locala = com.google.android.gms.ads.internal.client.u.h.a;
    return new int[] { i, com.google.android.gms.ads.internal.util.client.a.b(paramActivity, arrayOfInt[1]) };
  }
  
  public static Bitmap c(View paramView)
  {
    localObject2 = null;
    localObject1 = null;
    try
    {
      boolean bool = paramView.isDrawingCacheEnabled();
      paramView.setDrawingCacheEnabled(true);
      Bitmap localBitmap = paramView.getDrawingCache();
      if (localBitmap != null) {
        localObject1 = Bitmap.createBitmap(localBitmap);
      }
      try
      {
        paramView.setDrawingCacheEnabled(bool);
        return (Bitmap)localObject1;
      }
      catch (RuntimeException paramView) {}
    }
    catch (RuntimeException paramView)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
    e.c("Fail to capture the web view", paramView);
    return (Bitmap)localObject1;
  }
  
  public static Bundle c()
  {
    localBundle = new Bundle();
    try
    {
      if (!((Boolean)com.google.android.gms.ads.internal.f.n.aT.a()).booleanValue()) {}
      for (;;)
      {
        Object localObject = Runtime.getRuntime();
        localBundle.putLong("runtime_free_memory", ((Runtime)localObject).freeMemory());
        localBundle.putLong("runtime_max_memory", ((Runtime)localObject).maxMemory());
        localBundle.putLong("runtime_total_memory", ((Runtime)localObject).totalMemory());
        localBundle.putInt("web_view_count", bt.A.i.f.get());
        return localBundle;
        localObject = new Debug.MemoryInfo();
        Debug.getMemoryInfo((Debug.MemoryInfo)localObject);
        localBundle.putParcelable("debug_memory_info", (Parcelable)localObject);
      }
      return localBundle;
    }
    catch (Exception localException)
    {
      e.e("Unable to gather memory stats", localException);
    }
  }
  
  public static WebResourceResponse c(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("User-Agent", bt.A.e.b(paramContext, paramString1));
      localHashMap.put("Cache-Control", "max-stale=3600");
      new ax(paramContext);
      paramContext = (String)ax.a(0, paramString2, localHashMap, null).get(60L, TimeUnit.SECONDS);
      if (paramContext != null)
      {
        paramContext = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(paramContext.getBytes("UTF-8")));
        return paramContext;
      }
    }
    catch (InterruptedException paramContext)
    {
      e.e("Could not fetch MRAID JS.", paramContext);
      return null;
    }
    catch (ExecutionException paramContext)
    {
      for (;;) {}
    }
    catch (IOException paramContext)
    {
      for (;;) {}
    }
    catch (TimeoutException paramContext)
    {
      for (;;) {}
    }
  }
  
  public static String c(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.openFileInput(paramString);
      paramString = new ByteArrayOutputStream();
      com.google.android.gms.common.util.g.a(paramContext, paramString, true);
      paramContext = new String(paramString.toByteArray(), "UTF-8");
      return paramContext;
    }
    catch (IOException paramContext)
    {
      e.b("Error reading from internal storage.");
    }
    return "";
  }
  
  public static boolean c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }
    return false;
  }
  
  public static int[] c(Activity paramActivity)
  {
    Object localObject1 = paramActivity.getWindow();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((Window)localObject1).findViewById(16908290);
      if (localObject2 != null)
      {
        localObject1 = new int[2];
        localObject1[0] = ((View)localObject2).getTop();
        localObject1[1] = ((View)localObject2).getBottom();
      }
    }
    for (;;)
    {
      localObject2 = com.google.android.gms.ads.internal.client.u.h.a;
      int i = com.google.android.gms.ads.internal.util.client.a.b(paramActivity, localObject1[0]);
      localObject2 = com.google.android.gms.ads.internal.client.u.h.a;
      return new int[] { i, com.google.android.gms.ads.internal.util.client.a.b(paramActivity, localObject1[1]) };
      localObject1 = f();
    }
  }
  
  public static Bundle d()
  {
    com.google.android.gms.ads.internal.b.e locale = bt.A.i.f().l();
    if ((locale != null) && (locale != null) && ((!bt.A.i.f().b()) || (!bt.A.i.f().c()))) {
      throw new NoSuchMethodError();
    }
    return null;
  }
  
  protected static String d(Context paramContext)
  {
    try
    {
      paramContext = new WebView(paramContext).getSettings().getUserAgentString();
      return paramContext;
    }
    finally {}
    return e();
  }
  
  public static boolean d(View paramView)
  {
    paramView = paramView.getRootView();
    if (paramView != null)
    {
      paramView = paramView.getContext();
      if ((paramView instanceof Activity)) {
        paramView = (Activity)paramView;
      }
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView = paramView.getWindow();
        if (paramView != null) {}
        for (paramView = paramView.getAttributes();; paramView = null) {
          return (paramView != null) && ((paramView.flags & 0x80000) != 0);
        }
      }
      return false;
      paramView = null;
      continue;
      paramView = null;
    }
  }
  
  public static boolean d(String paramString)
  {
    if (com.google.android.gms.ads.internal.util.client.e.b())
    {
      if (((Boolean)com.google.android.gms.ads.internal.f.n.bn.a()).booleanValue())
      {
        Object localObject = (String)com.google.android.gms.ads.internal.f.n.bo.a();
        int j;
        int i;
        if (!((String)localObject).isEmpty())
        {
          localObject = ((String)localObject).split(";");
          j = localObject.length;
          i = 0;
        }
        for (;;)
        {
          if (i >= j)
          {
            localObject = (String)com.google.android.gms.ads.internal.f.n.bp.a();
            if (!((String)localObject).isEmpty())
            {
              localObject = ((String)localObject).split(";");
              j = localObject.length;
              i = 0;
              while (i < j) {
                if (!localObject[i].equals(paramString)) {
                  i += 1;
                } else {
                  return true;
                }
              }
              return false;
            }
            return true;
          }
          if (localObject[i].equals(paramString)) {
            break;
          }
          i += 1;
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  public static int e(View paramView)
  {
    if (paramView != null)
    {
      for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (!(localViewParent instanceof AdapterView)); localViewParent = localViewParent.getParent()) {}
      if (localViewParent != null) {
        return ((AdapterView)localViewParent).getPositionForView(paramView);
      }
      return -1;
    }
    return -1;
  }
  
  public static AlertDialog.Builder e(Context paramContext)
  {
    return new AlertDialog.Builder(paramContext);
  }
  
  private static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("Mozilla/5.0 (Linux; U; Android");
    if (Build.VERSION.RELEASE != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(Build.VERSION.RELEASE);
    }
    localStringBuilder.append("; ");
    localStringBuilder.append(Locale.getDefault());
    if (Build.DEVICE != null)
    {
      localStringBuilder.append("; ");
      localStringBuilder.append(Build.DEVICE);
      if (Build.DISPLAY != null)
      {
        localStringBuilder.append(" Build/");
        localStringBuilder.append(Build.DISPLAY);
      }
    }
    localStringBuilder.append(") AppleWebKit/533 Version/4.0 Safari/533");
    return localStringBuilder.toString();
  }
  
  public static com.google.android.gms.ads.internal.e.a f(Context paramContext)
  {
    return new com.google.android.gms.ads.internal.e.a(paramContext);
  }
  
  private static int[] f()
  {
    return new int[] { 0, 0 };
  }
  
  public static boolean g(Context paramContext)
  {
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
      if ((localObject != null) && (localKeyguardManager != null))
      {
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if (Process.myPid() == localRunningAppProcessInfo.pid) {
              if ((localRunningAppProcessInfo.importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
              {
                boolean bool = t(paramContext);
                if (bool) {
                  return true;
                }
              }
            }
          }
          return false;
        }
        return false;
      }
      return false;
    }
    finally {}
    return false;
  }
  
  public static boolean h(Context paramContext)
  {
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
      if ((localObject != null) && (localKeyguardManager != null))
      {
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if (Process.myPid() == localRunningAppProcessInfo.pid) {
              if ((localRunningAppProcessInfo.importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
              {
                boolean bool = t(paramContext);
                if (bool) {
                  break label104;
                }
              }
            }
          }
          return true;
          label104:
          return false;
        }
        return false;
      }
      return false;
    }
    finally {}
    return false;
  }
  
  public static Bitmap i(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramContext instanceof Activity)) {}
    try
    {
      paramContext = ((Activity)paramContext).getWindow();
      localObject1 = localObject2;
      if (paramContext != null) {
        localObject1 = c(paramContext.getDecorView().getRootView());
      }
      return (Bitmap)localObject1;
    }
    catch (RuntimeException paramContext)
    {
      e.c("Fail to capture screen shot", paramContext);
    }
    return null;
  }
  
  public static int j(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext != null) {
      return paramContext.targetSdkVersion;
    }
    return 0;
  }
  
  public static KeyguardManager k(Context paramContext)
  {
    paramContext = paramContext.getSystemService("keyguard");
    if ((paramContext != null) && ((paramContext instanceof KeyguardManager))) {
      return (KeyguardManager)paramContext;
    }
    return null;
  }
  
  public static boolean l(Context paramContext)
  {
    try
    {
      paramContext.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
      return false;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      return true;
    }
    finally
    {
      paramContext = finally;
      e.c("Error loading class.", paramContext);
      bt.A.i.a(paramContext, "AdUtil.isLiteSdk");
    }
    return false;
  }
  
  public static void m(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      ((Boolean)com.google.android.gms.ads.internal.f.n.ab.a()).booleanValue();
      return;
    }
    catch (IllegalStateException paramContext) {}
  }
  
  public static String n(Context paramContext)
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.ao.a()).booleanValue()) {
      return paramContext.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
    }
    return "";
  }
  
  public static Bundle p(Context paramContext)
  {
    int i = 0;
    if (((Boolean)com.google.android.gms.ads.internal.f.n.ap.a()).booleanValue())
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
      Bundle localBundle = new Bundle();
      if (localSharedPreferences.contains("IABConsent_CMPPresent")) {
        localBundle.putBoolean("IABConsent_CMPPresent", localSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
      }
      paramContext = localBundle;
      if (i < 4)
      {
        paramContext = new String[] { "IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents" }[i];
        if (!localSharedPreferences.contains(paramContext)) {}
        for (;;)
        {
          i += 1;
          break;
          localBundle.putString(paramContext, localSharedPreferences.getString(paramContext, null));
        }
      }
    }
    else
    {
      paramContext = null;
    }
    return paramContext;
  }
  
  public static boolean r(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getWindow();
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.getDecorView() != null)
        {
          Rect localRect1 = new Rect();
          Rect localRect2 = new Rect();
          paramContext.getDecorView().getGlobalVisibleRect(localRect1, null);
          paramContext.getDecorView().getWindowVisibleDisplayFrame(localRect2);
          bool1 = bool2;
          if (localRect1.bottom != 0)
          {
            bool1 = bool2;
            if (localRect2.bottom != 0)
            {
              bool1 = bool2;
              if (localRect1.top == localRect2.top) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static String s(Context paramContext)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext == null) {
        break label68;
      }
      paramContext = paramContext.getRunningTasks(1);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        paramContext = (ActivityManager.RunningTaskInfo)paramContext.get(0);
        if ((paramContext != null) && (paramContext.topActivity != null))
        {
          paramContext = paramContext.topActivity.getClassName();
          return paramContext;
        }
      }
    }
    catch (Exception paramContext) {}
    return null;
    label68:
    return null;
  }
  
  private static boolean t(Context paramContext)
  {
    paramContext = (PowerManager)paramContext.getSystemService("power");
    if (paramContext != null) {
      return paramContext.isScreenOn();
    }
    return false;
  }
  
  public final JSONObject a(Bundle paramBundle)
  {
    JSONObject localJSONObject = null;
    if (paramBundle != null) {}
    try
    {
      localJSONObject = b(paramBundle);
      return localJSONObject;
    }
    catch (JSONException paramBundle)
    {
      e.c("Error converting Bundle to JSON", paramBundle);
    }
    return null;
  }
  
  public final JSONObject a(Map paramMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(localJSONObject, str, paramMap.get(str));
      }
      return localJSONObject;
    }
    catch (ClassCastException paramMap)
    {
      paramMap = String.valueOf(paramMap.getMessage());
      if (paramMap.length() == 0) {}
      for (paramMap = new String("Could not convert map to JSON: ");; paramMap = "Could not convert map to JSON: ".concat(paramMap)) {
        throw new JSONException(paramMap);
      }
    }
  }
  
  public final void a(Context paramContext, String paramString, WebSettings paramWebSettings)
  {
    paramWebSettings.setUserAgentString(b(paramContext, paramString));
  }
  
  public final void a(Context paramContext, String paramString, HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(false);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", b(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(false);
  }
  
  public final boolean a(View paramView, Context paramContext)
  {
    Object localObject = paramContext.getApplicationContext();
    if (localObject != null) {}
    for (localObject = (PowerManager)((Context)localObject).getSystemService("power");; localObject = null) {
      return a(paramView, (PowerManager)localObject, k(paramContext));
    }
  }
  
  public final String b(Context paramContext, String paramString)
  {
    Object localObject1;
    synchronized (this.c)
    {
      localObject1 = this.d;
      if (localObject1 != null) {
        return (String)localObject1;
      }
      if (paramString == null) {}
    }
    try
    {
      this.d = bt.A.g.a(paramContext);
      if (!TextUtils.isEmpty(this.d)) {}
      for (;;)
      {
        localObject1 = String.valueOf(this.d);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject1).length() + 10 + String.valueOf(paramString).length());
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" (Mobile; ");
        localStringBuilder.append(paramString);
        this.d = localStringBuilder.toString();
        try
        {
          if (com.google.android.gms.common.b.c.a.a(paramContext).a()) {
            this.d = String.valueOf(this.d).concat(";aia");
          }
          this.d = String.valueOf(this.d).concat(")");
          paramContext = this.d;
          return paramContext;
          paramContext = finally;
          throw paramContext;
          localObject1 = com.google.android.gms.ads.internal.client.u.h.a;
          if (com.google.android.gms.ads.internal.util.client.a.b())
          {
            this.d = d(paramContext);
            continue;
          }
          this.d = null;
          a.post(new r(this, paramContext));
          for (;;)
          {
            localObject1 = this.d;
            if (localObject1 != null) {
              break;
            }
            try
            {
              this.c.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              this.d = e();
              str = String.valueOf(this.d);
              if (str.length() != 0) {
                break label312;
              }
            }
            str = new String("Interrupted, use default user agent: ");
            e.e(str);
          }
          paramContext = e();
          return paramContext;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            bt.A.i.a(paramContext, "AdUtil.getUserAgent");
            continue;
            label312:
            String str = "Interrupted, use default user agent: ".concat(str);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public final JSONObject b(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a(localJSONObject, str, paramBundle.get(str));
    }
    return localJSONObject;
  }
  
  public final boolean b(Context paramContext)
  {
    if (!this.f)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      paramContext.getApplicationContext().registerReceiver(new u(this), localIntentFilter);
      this.f = true;
      return true;
    }
    return false;
  }
  
  public final boolean c(Context paramContext)
  {
    if (!this.e)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.google.android.gms.ads.internal.zxxz.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
      paramContext.getApplicationContext().registerReceiver(new t(), localIntentFilter);
      this.e = true;
      return true;
    }
    return false;
  }
  
  @Deprecated
  public final String o(Context paramContext)
  {
    if (!((Boolean)com.google.android.gms.ads.internal.f.n.ao.a()).booleanValue()) {
      return "";
    }
    try
    {
      paramContext = (String)l.a(new o(this, paramContext)).get();
      return paramContext;
    }
    catch (InterruptedException paramContext)
    {
      Thread.interrupted();
      return "";
    }
    catch (ExecutionException paramContext) {}
    return "";
  }
  
  @Deprecated
  public final Bundle q(Context paramContext)
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.ap.a()).booleanValue()) {}
    try
    {
      paramContext = (Bundle)l.a(new p(this, paramContext)).get();
      return paramContext;
    }
    catch (InterruptedException paramContext)
    {
      Thread.interrupted();
      return null;
    }
    catch (ExecutionException paramContext) {}
    return null;
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */