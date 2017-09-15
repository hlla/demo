package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.booter.notification.queue.NotificationQueue.ParcelNotificationQueue;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.i.f;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.base.a.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.LauncherUI;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  private static boolean gLf;
  private static boolean gLg;
  private static boolean gLh;
  private static int gLi;
  private static int gLj;
  private static boolean gLk;
  private static String gLl;
  public static boolean gLm;
  public static boolean gLn;
  private static int gLo;
  private static boolean gLp;
  private static Uri gLq;
  
  static
  {
    GMTrace.i(523851792384L, 3903);
    gLf = true;
    gLg = true;
    gLh = false;
    gLi = -1;
    gLj = -1;
    gLk = true;
    gLl = "samsung";
    gLm = true;
    gLn = false;
    gLo = -1;
    gLp = true;
    gLq = Uri.parse("content://com.android.badge/badge");
    GMTrace.o(523851792384L, 3903);
  }
  
  public static int a(Notification paramNotification, g paramg)
  {
    GMTrace.i(523314921472L, 3899);
    if ((paramNotification == null) || (!gLf))
    {
      GMTrace.o(523314921472L, 3899);
      return 0;
    }
    int i;
    if (paramg == null) {
      i = 0;
    }
    try
    {
      for (;;)
      {
        paramg = Class.forName("android.app.MiuiNotification").newInstance();
        Field localField = paramg.getClass().getDeclaredField("messageCount");
        localField.setAccessible(true);
        localField.set(paramg, Integer.valueOf(i));
        paramNotification.getClass().getField("extraNotification").set(paramNotification, paramg);
        v.i("MicroMsg.BusinessNotification", "miuiNotification: %d", new Object[] { Integer.valueOf(i) });
        GMTrace.o(523314921472L, 3899);
        return i;
        int j = paramg.gMe;
        paramg = b.qr().gLF;
        if (paramg.gLE == null) {
          paramg.restore();
        }
        paramg = paramg.gLE.iterator();
        for (i = 0; paramg.hasNext(); i = ((NotificationItem)paramg.next()).gLy + i) {}
        i = j - i;
      }
    }
    catch (NoSuchFieldException paramNotification)
    {
      for (;;)
      {
        gLf = false;
      }
    }
    catch (IllegalArgumentException paramNotification)
    {
      for (;;)
      {
        gLf = false;
      }
    }
    catch (IllegalAccessException paramNotification)
    {
      for (;;)
      {
        gLf = false;
      }
    }
    catch (ClassNotFoundException paramNotification)
    {
      for (;;)
      {
        gLf = false;
      }
    }
    catch (InstantiationException paramNotification)
    {
      for (;;)
      {
        gLf = false;
      }
    }
    catch (Exception paramNotification)
    {
      for (;;)
      {
        gLf = false;
      }
    }
  }
  
  private static boolean a(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = true;
    GMTrace.i(523717574656L, 3902);
    if (!gLp)
    {
      GMTrace.o(523717574656L, 3902);
      return false;
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        if (paramString != null)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramString);
          localBundle.putStringArrayList("app_shortcut_custom_id", localArrayList);
          localBundle.putInt("app_badge_count", paramInt);
          localBundle.putString("app_shortcut_class_name", aa.bIM() + ".ui.LauncherUI");
          paramContext = paramContext.getContentResolver();
          if ((paramContext != null) && (paramContext.call(gLq, "setAppBadgeCount", null, localBundle) != null))
          {
            v.i("MicroMsg.BusinessNotification", "shortcutId: %s, normalNotification badge count: %d, result: %b", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
            GMTrace.o(523717574656L, 3902);
            return bool;
          }
        }
        else
        {
          localBundle.putStringArrayList("app_shortcut_custom_id", null);
          continue;
        }
        bool = false;
      }
      catch (Exception paramContext)
      {
        gLp = false;
        v.i("MicroMsg.BusinessNotification", "no support normal badge");
        v.e("MicroMsg.BusinessNotification", "alvin: no support normal badge");
        GMTrace.o(523717574656L, 3902);
        return false;
      }
    }
  }
  
  public static void ay(boolean paramBoolean)
  {
    GMTrace.i(523180703744L, 3898);
    if (!gLp)
    {
      GMTrace.o(523180703744L, 3898);
      return;
    }
    Object localObject = aa.getContext();
    if (localObject == null)
    {
      GMTrace.o(523180703744L, 3898);
      return;
    }
    localObject = ((Context)localObject).getContentResolver();
    if (localObject == null)
    {
      GMTrace.o(523180703744L, 3898);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        v.i("MicroMsg.BusinessNotification", "sync all user badge");
        localObject = ((ContentResolver)localObject).call(gLq, "getShortcutList", null, null);
        if (localObject == null)
        {
          v.i("MicroMsg.BusinessNotification", "getShortcutList return null");
          GMTrace.o(523180703744L, 3898);
          return;
        }
        localObject = ((Bundle)localObject).getString("shortcut_list");
        if (localObject != null)
        {
          localObject = new JSONArray((String)localObject);
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            String str = ((JSONObject)((JSONArray)localObject).get(i)).getString("app_shortcut_custom_id");
            if ((str == null) || (str.equalsIgnoreCase("null"))) {
              break label232;
            }
            str = c.rL(str);
            if (paramBoolean)
            {
              j = 0;
              m(str, j);
              break label232;
            }
            int j = f.dF(str);
            continue;
          }
        }
        GMTrace.o(523180703744L, 3898);
        return;
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.BusinessNotification", localException, "sync all user badge: no support getShortcutList", new Object[0]);
        GMTrace.o(523180703744L, 3898);
        return;
      }
      label232:
      i += 1;
    }
  }
  
  public static void dR(int paramInt)
  {
    GMTrace.i(522912268288L, 3896);
    Object localObject;
    int i;
    if ((aa.getContext() != null) && (qq()))
    {
      localObject = aa.getContext();
      if (paramInt != -1) {
        break label260;
      }
      i = f.sR();
    }
    for (;;)
    {
      if ((localObject != null) && (qq()) && (gLo != i))
      {
        gLo = i;
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", i);
        localIntent.putExtra("badge_count_package_name", aa.getPackageName());
        localIntent.putExtra("badge_count_class_name", LauncherUI.class.getName());
        v.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[] { Integer.valueOf(i), Build.BRAND });
        ((Context)localObject).sendBroadcast(localIntent);
      }
      label153:
      boolean bool;
      if (gLk)
      {
        if (Build.VERSION.SDK_INT < 11) {
          gLk = false;
        }
      }
      else
      {
        if (!gLh) {
          break label417;
        }
        bool = gLg;
        label163:
        if ((!bool) || (gLi == paramInt)) {}
      }
      try
      {
        localObject = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        ((Intent)localObject).putExtra("packageName", aa.getPackageName());
        ((Intent)localObject).putExtra("className", LauncherUI.class.getName());
        ((Intent)localObject).putExtra("notificationNum", paramInt);
        aa.getContext().sendBroadcast((Intent)localObject);
        v.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[] { Integer.valueOf(paramInt) });
        n(null, paramInt);
        GMTrace.o(522912268288L, 3896);
        return;
        label260:
        i = paramInt;
        continue;
        if (gLj == paramInt) {
          break label153;
        }
        for (;;)
        {
          try
          {
            localObject = new Bundle();
            ((Bundle)localObject).putString("package", aa.getPackageName());
            ((Bundle)localObject).putString("class", LauncherUI.class.getName());
            ((Bundle)localObject).putInt("badgenumber", paramInt);
            if (aa.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, (Bundle)localObject) == null) {
              break label412;
            }
            bool = true;
            gLk = bool;
            v.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(gLk) });
          }
          catch (Exception localException1)
          {
            v.i("MicroMsg.BusinessNotification", "no huawei badge");
            v.e("MicroMsg.BusinessNotification", "alvin: no badge" + localException1.toString());
            gLk = false;
          }
          break;
          label412:
          bool = false;
        }
        label417:
        gLh = true;
        if (!Build.BRAND.equals("vivo"))
        {
          gLg = false;
          bool = false;
          break label163;
        }
        gLg = true;
        bool = true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          gLg = false;
          v.printErrStackTrace("MicroMsg.BusinessNotification", localException2, "", new Object[0]);
        }
      }
    }
  }
  
  public static void m(String paramString, int paramInt)
  {
    GMTrace.i(523046486016L, 3897);
    if (u.mA(paramString))
    {
      v.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
      GMTrace.o(523046486016L, 3897);
      return;
    }
    paramString = c.rM(paramString);
    if (u.mA(paramString))
    {
      GMTrace.o(523046486016L, 3897);
      return;
    }
    n(paramString, paramInt);
    GMTrace.o(523046486016L, 3897);
  }
  
  private static void n(String paramString, int paramInt)
  {
    GMTrace.i(523583356928L, 3901);
    if (aa.getContext() == null)
    {
      v.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
      GMTrace.o(523583356928L, 3901);
      return;
    }
    Context localContext = aa.getContext();
    int i = paramInt;
    if (paramInt < 0) {
      i = f.sR();
    }
    a(localContext, paramString, i);
    GMTrace.o(523583356928L, 3901);
  }
  
  private static boolean qq()
  {
    GMTrace.i(523449139200L, 3900);
    if (gLn)
    {
      boolean bool = gLm;
      GMTrace.o(523449139200L, 3900);
      return bool;
    }
    gLn = true;
    if (!Build.BRAND.equals(gLl))
    {
      gLm = false;
      GMTrace.o(523449139200L, 3900);
      return false;
    }
    gLm = true;
    GMTrace.o(523449139200L, 3900);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/notification/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */