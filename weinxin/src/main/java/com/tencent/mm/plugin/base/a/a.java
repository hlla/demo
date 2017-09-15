package com.tencent.mm.plugin.base.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.bp.a;
import com.tencent.mm.e.a.bp.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;

public final class a
{
  public static Intent a(Context paramContext, bp parambp, int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    GMTrace.i(15656095318016L, 116647);
    if ((paramContext == null) || (parambp.fEP.username == null))
    {
      v.e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
      GMTrace.o(15656095318016L, 116647);
      return null;
    }
    if ((paramBitmap == null) && (paramBoolean))
    {
      v.e("MicroMsg.AppBrandShortcutManager", "no bmp");
      GMTrace.o(15656095318016L, 116647);
      return null;
    }
    Object localObject2 = parambp.fEP.username;
    if (TextUtils.isEmpty(parambp.fEQ.fER)) {}
    String str;
    for (Object localObject1 = localObject2;; localObject1 = parambp.fEQ.fER)
    {
      str = parambp.fEQ.appId;
      localObject3 = rK((String)localObject2);
      if (!bf.mA((String)localObject3)) {
        break;
      }
      GMTrace.o(15656095318016L, 116647);
      return null;
    }
    if (paramBoolean) {}
    StringBuilder localStringBuilder;
    for (localObject2 = "com.android.launcher.action.INSTALL_SHORTCUT";; localObject2 = "com.android.launcher.action.UNINSTALL_SHORTCUT")
    {
      localStringBuilder = new StringBuilder();
      parambp = parambp.fEQ.fES;
      int j = parambp.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(parambp[i]);
        i += 1;
      }
    }
    parambp = g.n(((String)localObject1 + localStringBuilder.toString()).getBytes());
    localObject2 = new Intent((String)localObject2);
    ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", (String)localObject1);
    ((Intent)localObject2).putExtra("duplicate", false);
    localObject1 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
    ((Intent)localObject1).putExtra("type", 1);
    ((Intent)localObject1).putExtra("id", (String)localObject3);
    ((Intent)localObject1).putExtra("ext_info", rK(str));
    Object localObject3 = new StringBuilder();
    ap.yY();
    ((Intent)localObject1).putExtra("token", bo(str, com.tencent.mm.u.c.uH()));
    ((Intent)localObject1).putExtra("digest", parambp);
    ((Intent)localObject1).putExtra("ext_info_1", paramInt);
    ((Intent)localObject1).setPackage(paramContext.getPackageName());
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject1);
    ((Intent)localObject2).putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
    GMTrace.o(15656095318016L, 116647);
    return (Intent)localObject2;
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    Object localObject = null;
    GMTrace.i(12822222209024L, 95533);
    if ((paramContext == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      GMTrace.o(12822222209024L, 95533);
      return null;
    }
    int i = (int)(com.tencent.mm.bg.a.getDensity(paramContext) * 48.0F);
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, i, false);
    paramBitmap = (Bitmap)localObject;
    if (localBitmap != null)
    {
      paramBitmap = localBitmap.copy(Bitmap.Config.ARGB_8888, true);
      localBitmap.recycle();
    }
    if (paramInt == 2) {
      a(paramContext, paramBitmap, com.tencent.mm.bg.a.V(paramContext, R.l.dFV));
    }
    for (;;)
    {
      GMTrace.o(12822222209024L, 95533);
      return paramBitmap;
      if (paramInt == 1) {
        a(paramContext, paramBitmap, com.tencent.mm.bg.a.V(paramContext, R.l.dFW));
      }
    }
  }
  
  public static Bitmap a(bp parambp)
  {
    GMTrace.i(15656229535744L, 116648);
    String[] arrayOfString = parambp.fEQ.fES;
    int j = arrayOfString.length;
    int i = 0;
    parambp = null;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      if (!bf.mA((String)localObject))
      {
        localObject = com.tencent.mm.modelappbrand.a.b.AY().gN((String)localObject);
        if (localObject != null)
        {
          parambp = (bp)localObject;
          if (!((Bitmap)localObject).isRecycled()) {}
        }
        else
        {
          parambp = null;
        }
      }
      i += 1;
    }
    GMTrace.o(15656229535744L, 116648);
    return parambp;
  }
  
  private static void a(Context paramContext, Bitmap paramBitmap, String paramString)
  {
    GMTrace.i(12822356426752L, 95534);
    if ((paramContext == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      GMTrace.o(12822356426752L, 95534);
      return;
    }
    if (bf.mA(paramString))
    {
      GMTrace.o(12822356426752L, 95534);
      return;
    }
    int i = paramBitmap.getWidth();
    float f3 = com.tencent.mm.bg.a.getDensity(paramContext);
    float f1 = 4.0F * f3;
    float f2 = 2.0F * f3;
    paramContext = new Paint();
    paramContext.setTextSize(f3 * 6.0F);
    paramContext.setFakeBoldText(true);
    paramContext.setAntiAlias(true);
    f3 = paramContext.measureText(paramString);
    Paint.FontMetrics localFontMetrics = paramContext.getFontMetrics();
    float f4 = localFontMetrics.bottom;
    float f5 = localFontMetrics.top;
    paramContext.setColor(Color.parseColor("#459AE9"));
    paramBitmap = new Canvas(paramBitmap);
    Rect localRect = new Rect((int)(i - f3 - 2.0F * f1), i * 2 / 3, i, (int)(f4 - f5 + i * 2 / 3 + 2.0F * f2));
    paramBitmap.drawRect(localRect, paramContext);
    paramContext.setColor(-1);
    paramBitmap.drawText(paramString, localRect.left + f1, localRect.top + f2 - localFontMetrics.ascent, paramContext);
    GMTrace.o(12822356426752L, 95534);
  }
  
  public static boolean b(Context paramContext, String paramString, int paramInt)
  {
    GMTrace.i(12821551120384L, 95528);
    if ((paramContext == null) || (paramString == null))
    {
      v.e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
      GMTrace.o(12821551120384L, 95528);
      return false;
    }
    Object localObject = new bp();
    ((bp)localObject).fEP.username = paramString;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    if (((bp)localObject).fEQ.fES == null)
    {
      v.e("MicroMsg.AppBrandShortcutManager", "no such user");
      GMTrace.o(12821551120384L, 95528);
      return false;
    }
    Bitmap localBitmap = a((bp)localObject);
    if (localBitmap == null)
    {
      v.i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
      GMTrace.o(12821551120384L, 95528);
      return true;
    }
    localObject = a(paramContext, (bp)localObject, paramInt, a(paramContext, localBitmap, paramInt), true);
    if (localObject == null)
    {
      v.e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
      GMTrace.o(12821551120384L, 95528);
      return false;
    }
    paramContext.sendBroadcast((Intent)localObject);
    v.i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", new Object[] { paramString });
    GMTrace.o(12821551120384L, 95528);
    return true;
  }
  
  public static String bo(String paramString1, String paramString2)
  {
    GMTrace.i(12822759079936L, 95537);
    paramString1 = g.n((g.n(paramString1.getBytes()) + c.bp(paramString2, paramString1)).getBytes());
    GMTrace.o(12822759079936L, 95537);
    return paramString1;
  }
  
  public static String rJ(String paramString)
  {
    GMTrace.i(12822490644480L, 95535);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(12822490644480L, 95535);
      return null;
    }
    v.i("MicroMsg.AppBrandShortcutManager", "process name: %s", new Object[] { bf.q(aa.getContext(), Process.myPid()) });
    if (paramString.startsWith("shortcut_"))
    {
      paramString = c.bp(new String(c.rN(paramString.substring(9))), p.rA());
      GMTrace.o(12822490644480L, 95535);
      return paramString;
    }
    GMTrace.o(12822490644480L, 95535);
    return paramString;
  }
  
  private static String rK(String paramString)
  {
    GMTrace.i(12822624862208L, 95536);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(12822624862208L, 95536);
      return null;
    }
    v.i("MicroMsg.AppBrandShortcutManager", "process name: %s", new Object[] { bf.q(aa.getContext(), Process.myPid()) });
    paramString = c.bp(paramString, p.rA());
    if (bf.mA(paramString))
    {
      GMTrace.o(12822624862208L, 95536);
      return null;
    }
    paramString = "shortcut_" + c.U(paramString.getBytes());
    GMTrace.o(12822624862208L, 95536);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */