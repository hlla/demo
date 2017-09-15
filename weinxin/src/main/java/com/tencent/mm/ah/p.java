package com.tencent.mm.ah;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.i.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.b;

public final class p
{
  private static String[] hHI;
  
  static
  {
    GMTrace.i(3508317192192L, 26139);
    hHI = null;
    GMTrace.o(3508317192192L, 26139);
  }
  
  public static boolean Hb()
  {
    GMTrace.i(3507109232640L, 26130);
    if (hHI == null) {
      Hc();
    }
    if ((Build.VERSION.SDK_INT >= 14) && (hHI != null) && (hHI.length > 0) && (com.tencent.mm.compatible.d.p.gRb.gQx == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.WebpUtil", "isSupportWebp: %b", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(3507109232640L, 26130);
      return bool;
    }
  }
  
  private static void Hc()
  {
    GMTrace.i(3507243450368L, 26131);
    try
    {
      String str = ((a)h.h(a.class)).sV().getValue("BizEnableWebpUrl");
      v.d("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", new Object[] { str });
      if (!bf.mA(str))
      {
        hHI = str.split(";");
        v.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(hHI.length) });
      }
      GMTrace.o(3507243450368L, 26131);
      return;
    }
    catch (b localb)
    {
      v.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
      GMTrace.o(3507243450368L, 26131);
      return;
    }
    catch (Exception localException)
    {
      v.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", new Object[] { localException.getMessage() });
      GMTrace.o(3507243450368L, 26131);
    }
  }
  
  private static int Hd()
  {
    GMTrace.i(3507780321280L, 26135);
    Context localContext = aa.getContext();
    if (al.isWifi(localContext))
    {
      GMTrace.o(3507780321280L, 26135);
      return 1;
    }
    if (al.is4G(localContext))
    {
      GMTrace.o(3507780321280L, 26135);
      return 4;
    }
    if (al.is3G(localContext))
    {
      GMTrace.o(3507780321280L, 26135);
      return 3;
    }
    if (al.is2G(localContext))
    {
      GMTrace.o(3507780321280L, 26135);
      return 2;
    }
    GMTrace.o(3507780321280L, 26135);
    return 0;
  }
  
  public static String gb(int paramInt)
  {
    GMTrace.i(3507914539008L, 26136);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(Hd()), Integer.valueOf(2) });
    GMTrace.o(3507914539008L, 26136);
    return str;
  }
  
  public static String gc(int paramInt)
  {
    GMTrace.i(3508048756736L, 26137);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(Hd()), Integer.valueOf(1) });
    GMTrace.o(3508048756736L, 26137);
    return str;
  }
  
  private static boolean jE(String paramString)
  {
    GMTrace.i(3507377668096L, 26132);
    if ((hHI != null) && (hHI.length > 0) && (!bf.mA(paramString)))
    {
      String[] arrayOfString = hHI;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.startsWith(arrayOfString[i]))
        {
          GMTrace.o(3507377668096L, 26132);
          return true;
        }
        i += 1;
      }
    }
    GMTrace.o(3507377668096L, 26132);
    return false;
  }
  
  public static String jF(String paramString)
  {
    GMTrace.i(3507511885824L, 26133);
    if ((hHI == null) || (hHI.length == 0))
    {
      v.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
      Hc();
    }
    if (!jE(paramString))
    {
      v.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
      GMTrace.o(3507511885824L, 26133);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      String str1 = ((Uri)localObject).getQueryParameter("wxtype");
      boolean bool = bf.mA(str1);
      if (bool)
      {
        GMTrace.o(3507511885824L, 26133);
        return paramString;
      }
      str1 = str1.toLowerCase();
      v.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, wxtype:%s", new Object[] { str1 });
      if (!str1.equals("gif"))
      {
        bool = str1.contains("gif");
        if (!bool) {}
      }
      else
      {
        GMTrace.o(3507511885824L, 26133);
        return paramString;
      }
      String str2 = ((Uri)localObject).getQueryParameter("tp");
      if (!bf.mA(str2))
      {
        bool = str2.equals("webp");
        if (bool)
        {
          GMTrace.o(3507511885824L, 26133);
          return paramString;
        }
      }
      if (!bf.mA(str1))
      {
        localObject = ((Uri)localObject).buildUpon().appendQueryParameter("tp", "webp").build().toString();
        v.d("MicroMsg.WebpUtil", "webpURL: %s", new Object[] { localObject });
        GMTrace.o(3507511885824L, 26133);
        return (String)localObject;
      }
    }
    catch (Exception localException)
    {
      GMTrace.o(3507511885824L, 26133);
      return paramString;
    }
    GMTrace.o(3507511885824L, 26133);
    return paramString;
  }
  
  public static boolean jG(String paramString)
  {
    GMTrace.i(3507646103552L, 26134);
    try
    {
      boolean bool = bf.mA(paramString);
      if (bool)
      {
        GMTrace.o(3507646103552L, 26134);
        return false;
      }
      bool = jE(paramString);
      if (!bool)
      {
        GMTrace.o(3507646103552L, 26134);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bf.mA(paramString))
      {
        bool = paramString.equals("webp");
        if (bool)
        {
          GMTrace.o(3507646103552L, 26134);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      GMTrace.o(3507646103552L, 26134);
      return false;
    }
    GMTrace.o(3507646103552L, 26134);
    return false;
  }
  
  public static String jH(String paramString)
  {
    GMTrace.i(3508182974464L, 26138);
    try
    {
      boolean bool = jE(paramString);
      if (!bool)
      {
        GMTrace.o(3508182974464L, 26138);
        return null;
      }
      paramString = Uri.parse(paramString).getQueryParameter("wxtype").toLowerCase();
      bool = bf.mA(paramString);
      if (bool)
      {
        GMTrace.o(3508182974464L, 26138);
        return null;
      }
      paramString = paramString.toLowerCase();
      GMTrace.o(3508182974464L, 26138);
      return paramString;
    }
    catch (Exception paramString)
    {
      GMTrace.o(3508182974464L, 26138);
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */