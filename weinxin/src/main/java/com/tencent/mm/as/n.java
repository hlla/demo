package com.tencent.mm.as;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public final class n
{
  public static final boolean IA()
  {
    GMTrace.i(14449880596480L, 107660);
    com.tencent.mm.storage.c localc = com.tencent.mm.u.c.c.Az().dX("100223");
    if (localc.isValid())
    {
      if (bf.getInt((String)localc.bKA().get("switchWeAppTemplate"), 0) == 1)
      {
        GMTrace.o(14449880596480L, 107660);
        return true;
      }
      GMTrace.o(14449880596480L, 107660);
      return false;
    }
    GMTrace.o(14449880596480L, 107660);
    return false;
  }
  
  public static String Ik()
  {
    GMTrace.i(1323521015808L, 9861);
    Object localObject = new File(e.hgh.replace("/data/user/0", "/data/data"), "wxa_fts/res");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).getAbsolutePath();
    GMTrace.o(1323521015808L, 9861);
    return (String)localObject;
  }
  
  public static int Iz()
  {
    GMTrace.i(1323789451264L, 9863);
    int i = Integer.valueOf(l(new File(Ik(), "config.conf")).getProperty("version", "0")).intValue();
    GMTrace.o(1323789451264L, 9863);
    return i;
  }
  
  public static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    GMTrace.i(1324057886720L, 9865);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("type", String.valueOf(paramInt2));
    localHashMap.put("lang", u.ea(aa.getContext()));
    localHashMap.put("platform", "android");
    localHashMap.put("version", String.valueOf(Iz()));
    Object localObject;
    if (paramBoolean)
    {
      localObject = "1";
      localHashMap.put("isHomePage", localObject);
      localObject = com.tencent.mm.u.c.c.Az().dX("100192");
      if ((!((com.tencent.mm.storage.c)localObject).isValid()) || (!"1".equals(((com.tencent.mm.storage.c)localObject).bKA().get("openSearchSuggestion")))) {
        break label231;
      }
    }
    label231:
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Boolean.valueOf(false) });
      if (bool) {
        localHashMap.put("isSug", "1");
      }
      GMTrace.o(1324057886720L, 9865);
      return localHashMap;
      localObject = "0";
      break;
    }
  }
  
  /* Error */
  public static Properties l(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 200
    //   3: sipush 9862
    //   6: invokestatic 15	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 111	java/util/Properties
    //   12: dup
    //   13: invokespecial 202	java/util/Properties:<init>	()V
    //   16: astore_3
    //   17: aload_0
    //   18: invokevirtual 205	java/io/File:isFile	()Z
    //   21: ifeq +23 -> 44
    //   24: new 207	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_3
    //   36: aload_1
    //   37: invokevirtual 214	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   40: aload_1
    //   41: invokestatic 219	com/tencent/mm/a/e:b	(Ljava/io/InputStream;)V
    //   44: ldc2_w 200
    //   47: sipush 9862
    //   50: invokestatic 57	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   53: aload_3
    //   54: areturn
    //   55: astore_2
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: ldc -78
    //   62: aload_2
    //   63: ldc -35
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 225	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_1
    //   73: invokestatic 219	com/tencent/mm/a/e:b	(Ljava/io/InputStream;)V
    //   76: goto -32 -> 44
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_0
    //   82: aload_0
    //   83: invokestatic 219	com/tencent/mm/a/e:b	(Ljava/io/InputStream;)V
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: goto -7 -> 82
    //   92: astore_2
    //   93: goto -35 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramFile	File
    //   32	41	1	localFileInputStream	java.io.FileInputStream
    //   79	8	1	localObject1	Object
    //   88	1	1	localObject2	Object
    //   55	8	2	localException1	Exception
    //   92	1	2	localException2	Exception
    //   16	38	3	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   24	33	55	java/lang/Exception
    //   24	33	79	finally
    //   35	40	88	finally
    //   60	72	88	finally
    //   35	40	92	java/lang/Exception
  }
  
  public static String m(Map<String, String> paramMap)
  {
    GMTrace.i(1323923668992L, 9864);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(Ik());
    localStringBuffer.append("/app.html?");
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuffer.append("&");
      localStringBuffer.append((String)localEntry.getKey());
      localStringBuffer.append("=");
      localStringBuffer.append((String)localEntry.getValue());
    }
    if (!paramMap.containsKey("sessionId"))
    {
      localStringBuffer.append("&");
      localStringBuffer.append("sessionId");
      localStringBuffer.append("=");
      localStringBuffer.append(d.gm(bf.PX((String)paramMap.get("scene"))));
    }
    paramMap = localStringBuffer.toString();
    GMTrace.o(1323923668992L, 9864);
    return paramMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/as/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */