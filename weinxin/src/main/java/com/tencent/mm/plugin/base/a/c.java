package com.tencent.mm.plugin.base.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.network.s;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.x.b;

public final class c
{
  public static final String jNf;
  private static String jNg;
  private static char[] jNh;
  
  static
  {
    GMTrace.i(12825174999040L, 95555);
    jNf = aa.getPackageName();
    jNg = "";
    jNh = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    GMTrace.o(12825174999040L, 95555);
  }
  
  public static boolean J(Context paramContext, String paramString)
  {
    GMTrace.i(12823967039488L, 95546);
    jNg = m.xL();
    String str = jNg;
    if ((paramContext == null) || (paramString == null)) {
      v.e("MicroMsg.ShortcutManager", "add fail, invalid argument");
    }
    for (;;)
    {
      GMTrace.o(12823967039488L, 95546);
      return true;
      v.d("MicroMsg.ShortcutManager", "add shortcut %s", new Object[] { paramString });
      jNg = str;
      paramString = a(paramContext, paramString, true, jNg);
      if (paramString == null) {
        v.e("MicroMsg.ShortcutManager", "add fail, intent is null");
      } else {
        paramContext.sendBroadcast(paramString);
      }
    }
  }
  
  public static boolean K(Context paramContext, String paramString)
  {
    GMTrace.i(12824101257216L, 95547);
    if ((paramContext == null) || (paramString == null))
    {
      v.e("MicroMsg.ShortcutManager", "remove fail, invalid argument");
      GMTrace.o(12824101257216L, 95547);
      return false;
    }
    jNg = m.xL();
    paramString = a(paramContext, paramString, false, jNg);
    if (paramString == null)
    {
      v.e("MicroMsg.ShortcutManager", "remove fail, intent is null");
      GMTrace.o(12824101257216L, 95547);
      return false;
    }
    paramContext.sendBroadcast(paramString);
    GMTrace.o(12824101257216L, 95547);
    return true;
  }
  
  public static String U(byte[] paramArrayOfByte)
  {
    GMTrace.i(12824906563584L, 95553);
    if (paramArrayOfByte == null)
    {
      GMTrace.o(12824906563584L, 95553);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(jNh[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(jNh[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    GMTrace.o(12824906563584L, 95553);
    return paramArrayOfByte;
  }
  
  private static Intent a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    GMTrace.i(12824235474944L, 95548);
    if ((paramString1 == null) || (paramContext == null))
    {
      v.e("MicroMsg.ShortcutManager", "getIntent, wrong parameters");
      GMTrace.o(12824235474944L, 95548);
      return null;
    }
    int i = (int)(paramContext.getResources().getDisplayMetrics().density * 48.0F);
    Object localObject2 = b.a(paramString1, false, -1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      v.e("MicroMsg.ShortcutManager", "getScaledBitmap fail, bmp is null");
      localObject1 = d.yk(a.c.ber);
    }
    if (localObject1 == null) {
      v.e("MicroMsg.ShortcutManager", "use default avatar, bmp is null");
    }
    for (localObject1 = null; localObject1 == null; localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, i, false))
    {
      v.e("MicroMsg.ShortcutManager", "no bmp");
      GMTrace.o(12824235474944L, 95548);
      return null;
    }
    x localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString1);
    if ((localx == null) || ((int)localx.gTG <= 0))
    {
      v.e("MicroMsg.ShortcutManager", "no such user");
      GMTrace.o(12824235474944L, 95548);
      return null;
    }
    String str = rM(paramString1);
    if (bf.mA(str))
    {
      GMTrace.o(12824235474944L, 95548);
      return null;
    }
    if (paramBoolean) {}
    for (localObject2 = "com.android.launcher.action.INSTALL_SHORTCUT";; localObject2 = "com.android.launcher.action.UNINSTALL_SHORTCUT")
    {
      localObject2 = new Intent((String)localObject2);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", o.a(localx, paramString1));
      ((Intent)localObject2).putExtra("duplicate", false);
      paramString1 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
      paramString1.putExtra("LauncherUI.Shortcut.Username", str);
      paramString1.putExtra("LauncherUI.From.Biz.Shortcut", true);
      paramString1.putExtra("app_shortcut_custom_id", str);
      paramString1.setPackage(paramContext.getPackageName());
      paramString1.addFlags(67108864);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", paramString1);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.ICON", (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_SOURCE_KEY", jNf);
      ((Intent)localObject2).putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_OWNER_ID", rM(paramString2));
      ((Intent)localObject2).putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_UNIQUE_ID", str);
      ((Intent)localObject2).putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_TYPE", y(localx));
      ((Intent)localObject2).putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_CONTAINER", 0);
      GMTrace.o(12824235474944L, 95548);
      return (Intent)localObject2;
    }
  }
  
  public static String bp(String paramString1, String paramString2)
  {
    GMTrace.i(12824503910400L, 95550);
    int[] arrayOfInt;
    byte[] arrayOfByte;
    int i;
    for (;;)
    {
      try
      {
        arrayOfInt = new int['Ā'];
        arrayOfByte = new byte['Ā'];
        i = 0;
      }
      catch (Exception paramString1)
      {
        v.e("MicroMsg.ShortcutManager", "Exception in rc4, %s", new Object[] { paramString1.getMessage() });
        v.printErrStackTrace("MicroMsg.ShortcutManager", paramString1, "", new Object[0]);
        GMTrace.o(12824503910400L, 95550);
        return null;
      }
      if (i >= 256) {
        break label258;
      }
      arrayOfByte[i] = ((byte)paramString2.charAt(i % paramString2.length()));
      i = (short)(i + 1);
    }
    for (;;)
    {
      paramString1 = paramString1.toCharArray();
      paramString2 = new char[paramString1.length];
      i = 0;
      int k = 0;
      int j = 0;
      while (i < paramString1.length)
      {
        k = (k + 1) % 256;
        j = (j + arrayOfInt[k]) % 256;
        int m = arrayOfInt[k];
        arrayOfInt[k] = arrayOfInt[j];
        arrayOfInt[j] = m;
        m = arrayOfInt[((arrayOfInt[k] + arrayOfInt[j] % 256) % 256)];
        int n = paramString1[i];
        paramString2[i] = ((char)((char)m ^ n));
        i = (short)(i + 1);
      }
      paramString1 = new String(paramString2);
      GMTrace.o(12824503910400L, 95550);
      return paramString1;
      while (i < 256)
      {
        arrayOfInt[i] = i;
        i += 1;
      }
      i = 0;
      break;
      label258:
      i = 0;
      j = 0;
      while (i < 255)
      {
        j = (j + arrayOfInt[i] + arrayOfByte[i]) % 256;
        k = arrayOfInt[i];
        arrayOfInt[i] = arrayOfInt[j];
        arrayOfInt[j] = k;
        i += 1;
      }
    }
  }
  
  public static String rL(String paramString)
  {
    GMTrace.i(12824638128128L, 95551);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(12824638128128L, 95551);
      return null;
    }
    String str1 = bf.q(aa.getContext(), Process.myPid());
    String str2 = aa.getPackageName();
    v.i("MicroMsg.ShortcutManager", "process name: %s", new Object[] { str1 });
    try
    {
      if (str2.equals(str1))
      {
        boolean bool = com.tencent.mm.kernel.h.vG().uV();
        if (!bool)
        {
          GMTrace.o(12824638128128L, 95551);
          return null;
        }
        com.tencent.mm.kernel.h.vG();
      }
      for (int i = com.tencent.mm.kernel.a.uH(); paramString.startsWith("shortcut_"); i = z.MP().idW.uH())
      {
        paramString = bp(new String(rN(paramString.substring(9))), String.valueOf(i));
        GMTrace.o(12824638128128L, 95551);
        return paramString;
      }
      GMTrace.o(12824638128128L, 95551);
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.ShortcutManager", null, "exception: %s", new Object[] { paramString.getMessage() });
      GMTrace.o(12824638128128L, 95551);
      return null;
    }
    return paramString;
  }
  
  public static String rM(String paramString)
  {
    GMTrace.i(12824772345856L, 95552);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(12824772345856L, 95552);
      return null;
    }
    Object localObject = bf.q(aa.getContext(), Process.myPid());
    String str = aa.getPackageName();
    if ((str.equals(localObject)) && (!com.tencent.mm.kernel.h.vG().uV()))
    {
      GMTrace.o(12824772345856L, 95552);
      return null;
    }
    v.i("MicroMsg.ShortcutManager", "process name: %s", new Object[] { localObject });
    try
    {
      if (str.equals(localObject))
      {
        localObject = new StringBuilder();
        com.tencent.mm.kernel.h.vG();
      }
      for (paramString = bp(paramString, com.tencent.mm.kernel.a.uH()); bf.mA(paramString); paramString = bp(paramString, z.MP().idW.uH()))
      {
        GMTrace.o(12824772345856L, 95552);
        return null;
      }
      paramString = "shortcut_" + U(paramString.getBytes());
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.ShortcutManager", null, "exception: %s", new Object[] { paramString.getMessage() });
      GMTrace.o(12824772345856L, 95552);
      return null;
    }
    GMTrace.o(12824772345856L, 95552);
    return paramString;
  }
  
  public static final byte[] rN(String paramString)
  {
    GMTrace.i(12825040781312L, 95554);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(12825040781312L, 95554);
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16));
      i += 1;
    }
    GMTrace.o(12825040781312L, 95554);
    return arrayOfByte;
  }
  
  public static int y(x paramx)
  {
    GMTrace.i(12824369692672L, 95549);
    if (paramx.bKU())
    {
      GMTrace.o(12824369692672L, 95549);
      return 2;
    }
    if (!o.fF(paramx.field_username))
    {
      GMTrace.o(12824369692672L, 95549);
      return 1;
    }
    GMTrace.o(12824369692672L, 95549);
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */