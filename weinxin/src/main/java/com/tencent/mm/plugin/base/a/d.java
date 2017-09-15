package com.tencent.mm.plugin.base.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ag.b.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.b;
import com.tencent.mm.x.h;
import com.tencent.mm.x.i;
import com.tencent.mm.x.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  public static List<com.tencent.mm.x.d.a> jNi;
  
  static
  {
    GMTrace.i(12826651394048L, 95566);
    jNi = new LinkedList();
    GMTrace.o(12826651394048L, 95566);
  }
  
  public static Bitmap L(Context paramContext, String paramString)
  {
    GMTrace.i(12825577652224L, 95558);
    paramString = b.a(paramString, false, -1);
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      int i = (int)(paramContext.getResources().getDisplayMetrics().density * 48.0F);
      paramContext = Bitmap.createScaledBitmap(paramString, i, i, false);
      GMTrace.o(12825577652224L, 95558);
      return paramContext;
    }
    GMTrace.o(12825577652224L, 95558);
    return paramString;
  }
  
  private static boolean M(Context paramContext, String paramString)
  {
    GMTrace.i(12826248740864L, 95563);
    label238:
    for (;;)
    {
      try
      {
        ContentResolver localContentResolver = paramContext.getContentResolver();
        paramContext = paramContext.getPackageManager().getInstalledPackages(8);
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)paramContext.next()).providers;
            if (arrayOfProviderInfo == null) {
              continue;
            }
            int j = arrayOfProviderInfo.length;
            int i = 0;
            if (i < j)
            {
              ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
              if ("com.android.launcher.permission.READ_SETTINGS".equals(localProviderInfo.readPermission))
              {
                paramContext = localProviderInfo.authority;
                paramContext = localContentResolver.query(Uri.parse("content://" + paramContext + "/favorites?notify=true"), new String[] { "title", "iconResource" }, "title=?", new String[] { paramString }, null);
                if (paramContext == null) {
                  break label238;
                }
                if (paramContext.getCount() <= 0) {
                  continue;
                }
                bool = true;
                paramContext.close();
                GMTrace.o(12826248740864L, 95563);
                return bool;
              }
              if ("com.android.launcher.permission.READ_SETTINGS".equals(localProviderInfo.writePermission))
              {
                paramContext = localProviderInfo.authority;
                continue;
              }
              i += 1;
              continue;
            }
            continue;
          }
        }
        paramContext = null;
        continue;
        boolean bool = false;
        continue;
        bool = false;
      }
      catch (Exception paramContext)
      {
        GMTrace.o(12826248740864L, 95563);
        return false;
      }
    }
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean)
  {
    GMTrace.i(12825846087680L, 95560);
    v.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBitmap == null) && (paramBoolean))
    {
      v.e("MicroMsg.WebviewShrotcutManager", "no bmp");
      GMTrace.o(12825846087680L, 95560);
      return null;
    }
    String str = rK(paramString1);
    if (bf.mA(str))
    {
      GMTrace.o(12825846087680L, 95560);
      return null;
    }
    if (paramBoolean) {}
    for (Object localObject = "com.android.launcher.action.INSTALL_SHORTCUT";; localObject = "com.android.launcher.action.UNINSTALL_SHORTCUT")
    {
      Intent localIntent = new Intent((String)localObject);
      localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString3);
      localIntent.putExtra("duplicate", false);
      localObject = "";
      h localh = n.Bm().hs(paramString1);
      paramString1 = (String)localObject;
      if (localh != null) {
        paramString1 = g.n((paramString3 + localh.Bt()).getBytes());
      }
      localObject = new Intent("com.tencent.mm.action.WX_SHORTCUT");
      ((Intent)localObject).putExtra("type", 2);
      ((Intent)localObject).putExtra("id", str);
      ((Intent)localObject).putExtra("ext_info", rK(paramString2));
      ((Intent)localObject).putExtra("ext_info_1", rK(paramString3));
      paramString3 = new StringBuilder();
      ap.yY();
      ((Intent)localObject).putExtra("token", bo(paramString2, com.tencent.mm.u.c.uH()));
      ((Intent)localObject).putExtra("digest", paramString1);
      ((Intent)localObject).setPackage(paramContext.getPackageName());
      ((Intent)localObject).addFlags(67108864);
      localIntent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject);
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
      GMTrace.o(12825846087680L, 95560);
      return localIntent;
    }
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, a parama)
  {
    GMTrace.i(12825309216768L, 95556);
    if ((paramContext == null) || (bf.mA(paramString1)))
    {
      v.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
      if (parama != null) {
        parama.cO(false);
      }
      GMTrace.o(12825309216768L, 95556);
      return;
    }
    v.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", new Object[] { paramString1 });
    if ((!ap.zb()) || (ap.uP()))
    {
      v.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
      if (parama != null) {
        parama.cO(false);
      }
      GMTrace.o(12825309216768L, 95556);
      return;
    }
    ap.yY();
    x localx = com.tencent.mm.u.c.wR().Rb(paramString1);
    String str = "";
    if (localx != null) {
      str = localx.tK();
    }
    if (bf.mA(str))
    {
      v.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
      ag.a.hlA.a(paramString1, "", new ag.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          GMTrace.i(12823430168576L, 95542);
          v.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            if (this.jNj != null)
            {
              this.jNj.cO(false);
              GMTrace.o(12823430168576L, 95542);
            }
          }
          else
          {
            ap.yY();
            paramAnonymousString = com.tencent.mm.u.c.wR().Rb(paramString1);
            if ((paramAnonymousString == null) || (bf.mA(paramAnonymousString.tK())))
            {
              if (this.jNj != null)
              {
                this.jNj.cO(false);
                GMTrace.o(12823430168576L, 95542);
              }
            }
            else {
              d.a(paramContext, paramString1, paramString2, paramAnonymousString.tK(), this.jNj);
            }
          }
          GMTrace.o(12823430168576L, 95542);
        }
      });
      GMTrace.o(12825309216768L, 95556);
      return;
    }
    a(paramContext, paramString1, paramString2, str, parama);
    GMTrace.o(12825309216768L, 95556);
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final a parama)
  {
    GMTrace.i(12825443434496L, 95557);
    if (M(paramContext, paramString3))
    {
      v.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
      if (parama != null) {
        parama.cO(true);
      }
      GMTrace.o(12825443434496L, 95557);
      return;
    }
    com.tencent.mm.x.d.a local2 = new com.tencent.mm.x.d.a()
    {
      public final void ho(String paramAnonymousString)
      {
        GMTrace.i(12823698604032L, 95544);
        if (!this.hqA.equals(paramAnonymousString))
        {
          GMTrace.o(12823698604032L, 95544);
          return;
        }
        v.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", new Object[] { paramAnonymousString });
        d.jNi.remove(this);
        n.Bl().b(this);
        paramAnonymousString = d.L(paramContext, this.hqA);
        if ((paramAnonymousString == null) || (paramAnonymousString.isRecycled()))
        {
          if (parama != null)
          {
            parama.cO(false);
            GMTrace.o(12823698604032L, 95544);
          }
        }
        else
        {
          paramAnonymousString = d.a(paramContext, this.hqA, paramString2, paramString3, paramAnonymousString, true);
          if (paramAnonymousString == null)
          {
            v.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (parama != null)
            {
              parama.cO(false);
              GMTrace.o(12823698604032L, 95544);
            }
          }
          else
          {
            paramContext.sendBroadcast(paramAnonymousString);
            if (parama != null) {
              parama.cO(true);
            }
          }
        }
        GMTrace.o(12823698604032L, 95544);
      }
    };
    jNi.add(local2);
    n.Bl().a(local2);
    Bitmap localBitmap = L(paramContext, paramString1);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      v.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
      new ai(new b(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(12823161733120L, 95540);
          v.i("MicroMsg.WebviewShrotcutManager", "expired");
          if (d.jNi.contains(this.jNm))
          {
            d.jNi.remove(this.jNm);
            n.Bl().b(this.jNm);
            if (parama != null) {
              parama.cO(false);
            }
          }
          GMTrace.o(12823161733120L, 95540);
        }
      }), false).v(5000L, 5000L);
      GMTrace.o(12825443434496L, 95557);
      return;
    }
    jNi.remove(local2);
    n.Bl().b(local2);
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, localBitmap, true);
    if (paramString1 == null)
    {
      v.e("MicroMsg.WebviewShrotcutManager", "intent is null");
      if (parama != null) {
        parama.cO(false);
      }
      GMTrace.o(12825443434496L, 95557);
      return;
    }
    paramContext.sendBroadcast(paramString1);
    if (parama != null) {
      parama.cO(true);
    }
    GMTrace.o(12825443434496L, 95557);
  }
  
  public static String bo(String paramString1, String paramString2)
  {
    GMTrace.i(12826114523136L, 95562);
    paramString1 = g.n((g.n(paramString1.getBytes()) + c.bp(paramString2, paramString1)).getBytes());
    GMTrace.o(12826114523136L, 95562);
    return paramString1;
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(12825711869952L, 95559);
    if ((paramContext == null) || (bf.mA(paramString3))) {
      v.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
    }
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, null, false);
    if (paramString1 == null)
    {
      v.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
      GMTrace.o(12825711869952L, 95559);
      return;
    }
    paramContext.sendBroadcast(paramString1);
    GMTrace.o(12825711869952L, 95559);
  }
  
  private static String rK(String paramString)
  {
    GMTrace.i(12825980305408L, 95561);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(12825980305408L, 95561);
      return null;
    }
    paramString = c.bp(paramString, p.rA());
    if (bf.mA(paramString))
    {
      GMTrace.o(12825980305408L, 95561);
      return null;
    }
    paramString = "shortcut_" + c.U(paramString.getBytes());
    GMTrace.o(12825980305408L, 95561);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void cO(boolean paramBoolean);
  }
  
  private static final class b
    implements ai.a
  {
    private Runnable ibz;
    
    b(Runnable paramRunnable)
    {
      GMTrace.i(12821282684928L, 95526);
      this.ibz = paramRunnable;
      GMTrace.o(12821282684928L, 95526);
    }
    
    public final boolean oQ()
    {
      GMTrace.i(12821416902656L, 95527);
      if (this.ibz != null) {
        this.ibz.run();
      }
      GMTrace.o(12821416902656L, 95527);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */