package com.tencent.mm.ai;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class b
{
  private static Map<String, a> hJj;
  private static String hJk;
  
  static
  {
    GMTrace.i(13333994405888L, 99346);
    hJj = null;
    hJk = null;
    GMTrace.o(13333994405888L, 99346);
  }
  
  public static boolean Hm()
  {
    GMTrace.i(13332786446336L, 99337);
    if (!u.ea(aa.getContext()).equals("zh_CN"))
    {
      GMTrace.o(13332786446336L, 99337);
      return true;
    }
    GMTrace.o(13332786446336L, 99337);
    return false;
  }
  
  public static boolean Hn()
  {
    GMTrace.i(13332920664064L, 99338);
    boolean bool = bf.Hq();
    GMTrace.o(13332920664064L, 99338);
    return bool;
  }
  
  public static boolean Ho()
  {
    GMTrace.i(13333054881792L, 99339);
    if ((m.xK() == 0) && (bf.Hq()))
    {
      GMTrace.o(13333054881792L, 99339);
      return false;
    }
    GMTrace.o(13333054881792L, 99339);
    return true;
  }
  
  public static boolean Hp()
  {
    GMTrace.i(13333323317248L, 99341);
    if (!u.bID().equals("zh_CN"))
    {
      GMTrace.o(13333323317248L, 99341);
      return true;
    }
    TimeZone localTimeZone1 = TimeZone.getDefault();
    TimeZone localTimeZone2 = TimeZone.getTimeZone("GMT+08:00");
    if (localTimeZone1.getRawOffset() != localTimeZone2.getRawOffset())
    {
      GMTrace.o(13333323317248L, 99341);
      return true;
    }
    GMTrace.o(13333323317248L, 99341);
    return false;
  }
  
  public static boolean Hq()
  {
    GMTrace.i(15694213152768L, 116931);
    boolean bool = bf.Hq();
    GMTrace.o(15694213152768L, 116931);
    return bool;
  }
  
  public static a g(Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(13333591752704L, 99343);
    localObject1 = null;
    try
    {
      localObject2 = paramContext.getResources().getConfiguration().locale.getLanguage();
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        localObject1 = localObject2;
        if (((String)localObject2).equals(hJk)) {}
      }
      else
      {
        localObject1 = localObject2;
        hJj = null;
        localObject3 = localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3 = localObject1;
        continue;
        paramContext = "";
      }
    }
    if (hJj == null)
    {
      hJj = new HashMap();
      hJk = (String)localObject3;
      localObject2 = null;
      localObject1 = null;
      for (;;)
      {
        try
        {
          localObject3 = paramContext.getAssets().open("country_code.txt");
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramContext = new byte[((InputStream)localObject3).available()];
          localObject1 = localObject3;
          localObject2 = localObject3;
          ((InputStream)localObject3).read(paramContext);
          localObject1 = localObject3;
          localObject2 = localObject3;
          str = new String(paramContext);
          paramContext = str;
          if (localObject3 == null) {}
        }
        catch (IOException paramContext)
        {
          int i;
          localObject2 = localObject1;
          v.e("MicroMsg.InternationaPluginlLogic", "exception:%s", new Object[] { bf.g(paramContext) });
          if (localObject1 == null) {
            break label536;
          }
          try
          {
            ((InputStream)localObject1).close();
            paramContext = "";
          }
          catch (IOException paramContext)
          {
            v.e("MicroMsg.InternationaPluginlLogic", "exception:%s", new Object[] { bf.g(paramContext) });
            paramContext = "";
          }
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            continue;
          }
          try
          {
            ((InputStream)localObject2).close();
            throw paramContext;
          }
          catch (IOException paramString1)
          {
            v.e("MicroMsg.InternationaPluginlLogic", "exception:%s", new Object[] { bf.g(paramString1) });
            continue;
          }
          localObject2 = new a();
          ((a)localObject2).hJl = localObject1[0];
          ((a)localObject2).hJm = localObject1[1];
          int k = paramString2.length;
          int j = 0;
          if (j >= k) {
            continue;
          }
          String str = paramString2[j];
          localObject3 = str.trim().split(":");
          if (localObject3.length >= 2) {
            continue;
          }
          v.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", new Object[] { str });
          j += 1;
          continue;
          str = localObject3[0];
          if (!localObject1[1].equals(str)) {
            continue;
          }
          ((a)localObject2).hJn = localObject3[1];
          hJj.put(((a)localObject2).hJl, localObject2);
          continue;
        }
        try
        {
          ((InputStream)localObject3).close();
          paramContext = str;
        }
        catch (IOException paramContext)
        {
          v.e("MicroMsg.InternationaPluginlLogic", "exception:%s", new Object[] { bf.g(paramContext) });
          paramContext = str;
        }
      }
      paramContext = paramContext.trim().split("\n");
      paramString2 = bf.mz(paramString2).trim().split(",");
      i = 0;
      for (;;)
      {
        if (i >= paramContext.length) {
          break label501;
        }
        localObject1 = paramContext[i].trim().split(" ");
        if (localObject1.length >= 2) {
          break;
        }
        v.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", new Object[] { paramContext[i] });
        i += 1;
      }
    }
    label501:
    paramContext = (a)hJj.get(paramString1.toUpperCase());
    GMTrace.o(13333591752704L, 99343);
    return paramContext;
  }
  
  public static boolean jO(String paramString)
  {
    GMTrace.i(13333725970432L, 99344);
    if ((paramString != null) && (paramString.length() > 1) && (paramString.startsWith("+")) && (!paramString.startsWith("+86")))
    {
      GMTrace.o(13333725970432L, 99344);
      return true;
    }
    GMTrace.o(13333725970432L, 99344);
    return false;
  }
  
  public static String jP(String paramString)
  {
    GMTrace.i(13333860188160L, 99345);
    if ((paramString.startsWith("+886")) || (paramString.startsWith("+86")))
    {
      GMTrace.o(13333860188160L, 99345);
      return "zh-TW";
    }
    if ((paramString.startsWith("+852")) || (paramString.startsWith("+853")))
    {
      GMTrace.o(13333860188160L, 99345);
      return "zh-HK";
    }
    if (paramString.startsWith("+81"))
    {
      GMTrace.o(13333860188160L, 99345);
      return "ja";
    }
    if (paramString.startsWith("+82"))
    {
      GMTrace.o(13333860188160L, 99345);
      return "ko";
    }
    if (paramString.startsWith("+66"))
    {
      GMTrace.o(13333860188160L, 99345);
      return "th";
    }
    if (paramString.startsWith("+84"))
    {
      GMTrace.o(13333860188160L, 99345);
      return "vi";
    }
    if (paramString.startsWith("+62"))
    {
      GMTrace.o(13333860188160L, 99345);
      return "id";
    }
    if (paramString.startsWith("+55"))
    {
      GMTrace.o(13333860188160L, 99345);
      return "pt";
    }
    if (paramString.startsWith("+34"))
    {
      GMTrace.o(13333860188160L, 99345);
      return "es-419";
    }
    GMTrace.o(13333860188160L, 99345);
    return "en";
  }
  
  public static final class a
  {
    public String hJl;
    public String hJm;
    public String hJn;
    
    public a()
    {
      GMTrace.i(13332518010880L, 99335);
      GMTrace.o(13332518010880L, 99335);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ai/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */