package com.tencent.mm.as;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.sn;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.n;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private static HashMap<String, w.a> hPH;
  private static k hPI;
  private static HashMap<String, Long> hPJ;
  public static e htA;
  
  static
  {
    GMTrace.i(1307951759360L, 9745);
    HashMap localHashMap = new HashMap();
    hPH = localHashMap;
    localHashMap.put("zh_CN", w.a.uFa);
    hPH.put("zh_HK", w.a.uFc);
    hPH.put("zh_TW", w.a.uFb);
    hPH.put("en", w.a.uFd);
    hPH.put("ar", w.a.uFe);
    hPH.put("de", w.a.uFf);
    hPH.put("de_DE", w.a.uFg);
    hPH.put("es", w.a.uFh);
    hPH.put("fr", w.a.uFi);
    hPH.put("he", w.a.uFj);
    hPH.put("hi", w.a.uFk);
    hPH.put("id", w.a.uFl);
    hPH.put("in", w.a.uFm);
    hPH.put("it", w.a.uFn);
    hPH.put("iw", w.a.uFo);
    hPH.put("ja", w.a.uFp);
    hPH.put("ko", w.a.uFq);
    hPH.put("lo", w.a.uFr);
    hPH.put("ms", w.a.uFs);
    hPH.put("my", w.a.uFt);
    hPH.put("pl", w.a.uFu);
    hPH.put("pt", w.a.uFv);
    hPH.put("ru", w.a.uFw);
    hPH.put("th", w.a.uFx);
    hPH.put("tr", w.a.uFy);
    hPH.put("vi", w.a.uFz);
    htA = new e()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
      {
        GMTrace.i(1309025501184L, 9753);
        v.i("MicroMsg.FTS.FTSWebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousk instanceof k))
        {
          ap.vd().b(1948, j.htA);
          paramAnonymousString = new sn();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label170;
          }
          Object localObject = (k)paramAnonymousk;
          paramAnonymousk = ((k)localObject).hPP;
          localObject = ((k)localObject).hPO;
          v.i("MicroMsg.FTS.FTSWebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[] { paramAnonymousk.tjN });
          if (j.ag(((bos)localObject).lda, paramAnonymousk.tjN) != j.a.hPK) {
            break label159;
          }
          paramAnonymousString.fZX.result = 0;
        }
        for (;;)
        {
          a.uql.m(paramAnonymousString);
          GMTrace.o(1309025501184L, 9753);
          return;
          label159:
          paramAnonymousString.fZX.result = -1;
          continue;
          label170:
          paramAnonymousString.fZX.result = -1;
        }
      }
    };
    GMTrace.o(1307951759360L, 9745);
  }
  
  /* Error */
  private static String Iw()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc2_w 184
    //   5: sipush 9742
    //   8: invokestatic 28	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: invokestatic 191	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   14: invokevirtual 197	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: astore_0
    //   18: invokestatic 191	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   21: invokestatic 203	com/tencent/mm/sdk/platformtools/u:ea	(Landroid/content/Context;)Ljava/lang/String;
    //   24: astore_2
    //   25: aload_0
    //   26: new 205	java/lang/StringBuilder
    //   29: dup
    //   30: ldc -49
    //   32: invokespecial 210	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_2
    //   36: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokevirtual 223	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore_0
    //   46: aload_0
    //   47: astore_1
    //   48: aload_1
    //   49: astore_0
    //   50: new 225	java/lang/String
    //   53: dup
    //   54: aload_1
    //   55: invokestatic 231	com/tencent/mm/loader/stub/b:c	(Ljava/io/InputStream;)[B
    //   58: invokespecial 234	java/lang/String:<init>	([B)V
    //   61: astore_2
    //   62: aload_1
    //   63: invokestatic 240	com/tencent/mm/a/e:b	(Ljava/io/InputStream;)V
    //   66: aload_2
    //   67: astore_0
    //   68: ldc2_w 184
    //   71: sipush 9742
    //   74: invokestatic 178	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   77: aload_0
    //   78: areturn
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: ldc -14
    //   86: aload_2
    //   87: aload_2
    //   88: invokevirtual 245	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 251	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_1
    //   99: invokestatic 240	com/tencent/mm/a/e:b	(Ljava/io/InputStream;)V
    //   102: aconst_null
    //   103: astore_0
    //   104: goto -36 -> 68
    //   107: astore_0
    //   108: aload_1
    //   109: invokestatic 240	com/tencent/mm/a/e:b	(Ljava/io/InputStream;)V
    //   112: aload_0
    //   113: athrow
    //   114: astore_2
    //   115: aload_0
    //   116: astore_1
    //   117: aload_2
    //   118: astore_0
    //   119: goto -11 -> 108
    //   122: astore_2
    //   123: goto -41 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	87	0	localObject1	Object
    //   107	9	0	localObject2	Object
    //   118	1	0	localObject3	Object
    //   1	116	1	localObject4	Object
    //   24	43	2	str	String
    //   79	9	2	localException1	Exception
    //   114	4	2	localObject5	Object
    //   122	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   18	46	79	java/lang/Exception
    //   18	46	107	finally
    //   50	62	114	finally
    //   84	98	114	finally
    //   50	62	122	java/lang/Exception
  }
  
  public static int ag(String paramString1, String paramString2)
  {
    GMTrace.i(1307280670720L, 9740);
    int i;
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString2.put("updateTime", System.currentTimeMillis());
      paramString2 = paramString2.toString();
      ap.yY();
      c.vr().a(kb(paramString1), paramString2);
      i = a.hPK;
      GMTrace.o(1307280670720L, 9740);
      return i;
    }
    catch (JSONException paramString1)
    {
      i = a.hPM;
      GMTrace.o(1307280670720L, 9740);
    }
    return i;
  }
  
  public static boolean gs(int paramInt)
  {
    GMTrace.i(15313169022976L, 114092);
    if (hPJ == null) {
      hPJ = new HashMap();
    }
    String str = u.ea(aa.getContext());
    Long localLong = (Long)hPJ.get(str);
    Object localObject1 = localLong;
    if (localLong == null) {
      localObject1 = Long.valueOf(0L);
    }
    if (System.currentTimeMillis() - ((Long)localObject1).longValue() < 600000L)
    {
      GMTrace.o(15313169022976L, 114092);
      return false;
    }
    long l = System.currentTimeMillis();
    hPJ.put(str, Long.valueOf(l));
    if (hPI != null)
    {
      ap.vd().c(hPI);
      hPI = null;
    }
    v.i("MicroMsg.FTS.FTSWebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[] { str, Integer.valueOf(paramInt), Long.valueOf(0L) });
    ap.yY();
    localObject1 = (String)c.vr().get(kb(str), null);
    try
    {
      if (!bf.mA((String)localObject1))
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null) {
          break label230;
        }
        i = a.hPM;
        if (i != a.hPK) {
          break label274;
        }
        GMTrace.o(15313169022976L, 114092);
        return false;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int i;
        Object localObject2 = null;
        continue;
        label230:
        l = ((JSONObject)localObject2).optLong("updateTime");
        if (((JSONObject)localObject2).optLong("timevalSec") * 1000L + l < System.currentTimeMillis()) {
          i = a.hPL;
        } else {
          i = a.hPK;
        }
      }
      label274:
      hPI = new k(null, paramInt, 0L, null);
      ap.vd().a(1948, htA);
      ap.vd().a(hPI, 0);
      GMTrace.o(15313169022976L, 114092);
    }
    return true;
  }
  
  private static w.a kb(String paramString)
  {
    GMTrace.i(16268665028608L, 121211);
    w.a locala = (w.a)hPH.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = w.a.uFd;
    }
    GMTrace.o(16268665028608L, 121211);
    return paramString;
  }
  
  public static JSONObject kc(String paramString)
  {
    GMTrace.i(1307414888448L, 9741);
    String str = u.ea(aa.getContext());
    try
    {
      ap.yY();
      localObject1 = (String)c.vr().get(kb(str), null);
      if (bf.mA((String)localObject1)) {
        break label177;
      }
      localObject3 = new JSONObject((String)localObject1).optJSONObject("data").optJSONObject(paramString);
      localObject1 = "Config Storage";
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject4;
        Object localObject6;
        Object localObject2 = "";
        Object localObject3 = null;
        continue;
        localObject2 = "";
        localObject3 = null;
      }
    }
    localObject4 = localObject1;
    localObject6 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject6 = new JSONObject(Iw()).optJSONObject("data").optJSONObject(paramString);
      localObject4 = "Asset";
      localObject1 = localObject6;
      localObject3 = localObject4;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject5 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject5;
      }
    }
    localObject4 = localObject1;
    if (localObject1 == null) {
      localObject4 = new JSONObject();
    }
    v.i("MicroMsg.FTS.FTSWebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[] { str, paramString, localObject3 });
    GMTrace.o(1307414888448L, 9741);
    return (JSONObject)localObject4;
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(1318823395328L, 9826);
      hPK = 1;
      hPL = 2;
      hPM = 3;
      hPN = new int[] { hPK, hPL, hPM };
      GMTrace.o(1318823395328L, 9826);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/as/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */