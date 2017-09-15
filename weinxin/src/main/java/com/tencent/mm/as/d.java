package com.tencent.mm.as;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.a.o;
import com.tencent.mm.bi.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aiw;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.protocal.c.bor;
import com.tencent.mm.protocal.c.bqn;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class d
{
  public static final int hOU;
  public static final Pattern hOV;
  public static int hOW;
  private static String hgh;
  
  static
  {
    GMTrace.i(1317749653504L, 9818);
    hOU = Color.parseColor("#45C01A");
    hOV = Pattern.compile(";");
    hOW = 1;
    hgh = "";
    GMTrace.o(1317749653504L, 9818);
  }
  
  public static aiw AU()
  {
    GMTrace.i(1315199516672L, 9799);
    try
    {
      ap.yY();
      Object localObject = (String)c.vr().get(67591, null);
      if (localObject != null)
      {
        aiw localaiw = new aiw();
        localObject = ((String)localObject).split(",");
        localaiw.tvi = Integer.valueOf(localObject[0]).intValue();
        localaiw.tvl = Integer.valueOf(localObject[1]).intValue();
        localaiw.tlu = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localaiw.tlt = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        v.i("MicroMsg.FTS.FTSExportLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localaiw.tlu), Float.valueOf(localaiw.tlt) });
        GMTrace.o(1315199516672L, 9799);
        return localaiw;
      }
      v.i("MicroMsg.FTS.FTSExportLogic", "lbs location is null, lbsContent is null!");
      GMTrace.o(1315199516672L, 9799);
      return null;
    }
    catch (Exception localException)
    {
      v.i("MicroMsg.FTS.FTSExportLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      GMTrace.o(1315199516672L, 9799);
    }
    return null;
  }
  
  /* Error */
  public static int EJ()
  {
    // Byte code:
    //   0: ldc2_w 146
    //   3: sipush 9802
    //   6: invokestatic 27	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 149	java/util/Properties
    //   12: dup
    //   13: invokespecial 150	java/util/Properties:<init>	()V
    //   16: astore 4
    //   18: aconst_null
    //   19: astore_1
    //   20: new 152	java/io/FileInputStream
    //   23: dup
    //   24: new 154	java/io/File
    //   27: dup
    //   28: invokestatic 157	com/tencent/mm/as/d:Ik	()Ljava/lang/String;
    //   31: ldc -97
    //   33: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_2
    //   40: aload_2
    //   41: astore_1
    //   42: aload 4
    //   44: aload_2
    //   45: invokevirtual 168	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   48: aload_2
    //   49: invokestatic 172	com/tencent/mm/a/e:b	(Ljava/io/InputStream;)V
    //   52: aload 4
    //   54: ldc -82
    //   56: ldc -80
    //   58: invokevirtual 180	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 101	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   64: invokevirtual 105	java/lang/Integer:intValue	()I
    //   67: istore_0
    //   68: ldc2_w 146
    //   71: sipush 9802
    //   74: invokestatic 56	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   77: iload_0
    //   78: ireturn
    //   79: astore_3
    //   80: aconst_null
    //   81: astore_2
    //   82: aload_2
    //   83: astore_1
    //   84: ldc 121
    //   86: aload_3
    //   87: aload_3
    //   88: invokevirtual 144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 184	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_2
    //   99: invokestatic 172	com/tencent/mm/a/e:b	(Ljava/io/InputStream;)V
    //   102: goto -50 -> 52
    //   105: astore_3
    //   106: aload_1
    //   107: astore_2
    //   108: aload_3
    //   109: astore_1
    //   110: aload_2
    //   111: invokestatic 172	com/tencent/mm/a/e:b	(Ljava/io/InputStream;)V
    //   114: aload_1
    //   115: athrow
    //   116: astore_3
    //   117: aload_1
    //   118: astore_2
    //   119: aload_3
    //   120: astore_1
    //   121: goto -11 -> 110
    //   124: astore_3
    //   125: goto -43 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   67	11	0	i	int
    //   19	102	1	localObject1	Object
    //   39	80	2	localObject2	Object
    //   79	9	3	localException1	Exception
    //   105	4	3	localObject3	Object
    //   116	4	3	localObject4	Object
    //   124	1	3	localException2	Exception
    //   16	37	4	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   20	40	79	java/lang/Exception
    //   20	40	105	finally
    //   42	48	116	finally
    //   84	98	116	finally
    //   42	48	124	java/lang/Exception
  }
  
  public static int EK()
  {
    GMTrace.i(1315333734400L, 9800);
    Object localObject4 = aa.getContext().getAssets();
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = ((AssetManager)localObject4).open("config.conf");
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        v.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", localException, localException.getMessage(), new Object[0]);
        com.tencent.mm.a.e.b((InputStream)localObject1);
      }
    }
    finally
    {
      com.tencent.mm.a.e.b((InputStream)localObject3);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    GMTrace.o(1315333734400L, 9800);
    return i;
  }
  
  public static boolean Ij()
  {
    GMTrace.i(1315467952128L, 9801);
    if (hOW > 1)
    {
      GMTrace.o(1315467952128L, 9801);
      return true;
    }
    GMTrace.o(1315467952128L, 9801);
    return false;
  }
  
  public static String Ik()
  {
    GMTrace.i(1315736387584L, 9803);
    if (bf.mA(hgh)) {
      hgh = com.tencent.mm.compatible.util.e.hgh.replace("/data/user/0", "/data/data");
    }
    Object localObject = new File(hgh, "fts/res");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).getAbsolutePath();
    GMTrace.o(1315736387584L, 9803);
    return (String)localObject;
  }
  
  public static String Il()
  {
    GMTrace.i(1316541693952L, 9809);
    if (al.isWifi(aa.getContext()))
    {
      GMTrace.o(1316541693952L, 9809);
      return "wifi";
    }
    if (al.is4G(aa.getContext()))
    {
      GMTrace.o(1316541693952L, 9809);
      return "4g";
    }
    if (al.is3G(aa.getContext()))
    {
      GMTrace.o(1316541693952L, 9809);
      return "3g";
    }
    if (al.is2G(aa.getContext()))
    {
      GMTrace.o(1316541693952L, 9809);
      return "2g";
    }
    if (!al.isConnected(aa.getContext()))
    {
      GMTrace.o(1316541693952L, 9809);
      return "fail";
    }
    GMTrace.o(1316541693952L, 9809);
    return "";
  }
  
  public static Intent Im()
  {
    GMTrace.i(1317078564864L, 9813);
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
    localIntent.putExtra("neverGetA8Key", true);
    GMTrace.o(1317078564864L, 9813);
    return localIntent;
  }
  
  public static boolean In()
  {
    GMTrace.i(16175920578560L, 120520);
    if (v.getLogLevel() == 0)
    {
      GMTrace.o(16175920578560L, 120520);
      return true;
    }
    GMTrace.o(16175920578560L, 120520);
    return false;
  }
  
  public static int a(JSONObject paramJSONObject, String paramString, Context paramContext)
  {
    GMTrace.i(16867141877760L, 125670);
    int j;
    int i;
    if (paramJSONObject == null)
    {
      j = 0;
      i = j;
      if (j == 0)
      {
        if (!paramString.equals(paramContext.getString(R.l.ePH))) {
          break label63;
        }
        i = 2;
      }
    }
    for (;;)
    {
      GMTrace.o(16867141877760L, 125670);
      return i;
      j = paramJSONObject.optInt("businessType");
      break;
      label63:
      if (paramString.equals(paramContext.getString(R.l.ePK)))
      {
        i = 8;
      }
      else if (paramString.equals(paramContext.getString(R.l.ePI)))
      {
        i = 1;
      }
      else
      {
        v.i("MicroMsg.FTS.FTSExportLogic", "option " + paramString + " no type");
        i = j;
      }
    }
  }
  
  public static Drawable a(int paramInt, Context paramContext)
  {
    GMTrace.i(16867276095488L, 125671);
    int i = R.k.dzD;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      paramContext = paramContext.getResources().getDrawable(paramInt);
      GMTrace.o(16867276095488L, 125671);
      return paramContext;
      paramInt = R.k.dzC;
      continue;
      paramInt = R.k.dzz;
      continue;
      paramInt = R.k.dzu;
      continue;
      paramInt = R.k.dzy;
      continue;
      paramInt = R.k.dzv;
      continue;
      paramInt = R.k.dzA;
      continue;
      paramInt = R.k.dzB;
    }
  }
  
  public static Spannable a(CharSequence paramCharSequence, String paramString)
  {
    GMTrace.i(17863842725888L, 133096);
    paramCharSequence = com.tencent.mm.plugin.fts.d.f.b(com.tencent.mm.plugin.fts.d.b.a.d(paramCharSequence, paramString));
    if ((paramCharSequence.mbY instanceof Spannable))
    {
      paramCharSequence = (Spannable)paramCharSequence.mbY;
      GMTrace.o(17863842725888L, 133096);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableString(paramCharSequence.mbY);
    GMTrace.o(17863842725888L, 133096);
    return paramCharSequence;
  }
  
  public static Spannable a(CharSequence paramCharSequence, List<String> paramList)
  {
    GMTrace.i(17863976943616L, 133097);
    paramCharSequence = com.tencent.mm.plugin.fts.d.f.b(com.tencent.mm.plugin.fts.d.b.a.b(paramCharSequence, paramList));
    if ((paramCharSequence.mbY instanceof Spannable))
    {
      paramCharSequence = (Spannable)paramCharSequence.mbY;
      GMTrace.o(17863976943616L, 133097);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableString(paramCharSequence.mbY);
    GMTrace.o(17863976943616L, 133097);
    return paramCharSequence;
  }
  
  public static Spannable a(CharSequence paramCharSequence, List<String> paramList, String paramString)
  {
    GMTrace.i(17864245379072L, 133099);
    paramCharSequence = com.tencent.mm.plugin.fts.d.f.b(com.tencent.mm.plugin.fts.d.b.a.a(paramCharSequence, paramString, paramList));
    if ((paramCharSequence.mbY instanceof Spannable))
    {
      paramCharSequence = (Spannable)paramCharSequence.mbY;
      GMTrace.o(17864245379072L, 133099);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableString(paramCharSequence.mbY);
    GMTrace.o(17864245379072L, 133099);
    return paramCharSequence;
  }
  
  public static Spannable a(CharSequence paramCharSequence, List<String> paramList, boolean paramBoolean, String paramString)
  {
    GMTrace.i(17864379596800L, 133100);
    paramCharSequence = com.tencent.mm.plugin.fts.d.f.b(com.tencent.mm.plugin.fts.d.b.a.a(paramCharSequence, paramString, paramList, true, paramBoolean));
    if ((paramCharSequence.mbY instanceof Spannable))
    {
      paramCharSequence = (Spannable)paramCharSequence.mbY;
      GMTrace.o(17864379596800L, 133100);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableString(paramCharSequence.mbY);
    GMTrace.o(17864379596800L, 133100);
    return paramCharSequence;
  }
  
  private static String a(String paramString, a parama)
  {
    GMTrace.i(1312917815296L, 9782);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString.substring(0, parama.start));
    localStringBuffer.append("<em class=\"highlight\">");
    localStringBuffer.append(paramString.substring(parama.start, parama.end));
    localStringBuffer.append("</em>");
    if (parama.end < paramString.length()) {
      localStringBuffer.append(paramString.substring(parama.end, paramString.length()));
    }
    paramString = localStringBuffer.toString();
    GMTrace.o(1312917815296L, 9782);
    return paramString;
  }
  
  public static String a(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2)
  {
    GMTrace.i(1312380944384L, 9778);
    if (bf.mA(paramString1))
    {
      GMTrace.o(1312380944384L, 9778);
      return "";
    }
    paramString2 = b(paramString1, paramString2);
    if (paramString2.isAvailable())
    {
      paramString1 = a(paramString1, paramString2);
      GMTrace.o(1312380944384L, 9778);
      return paramString1;
    }
    paramString2 = new ArrayList();
    int i = 0;
    if (i < paramString1.length())
    {
      char c = paramString1.charAt(i);
      String str;
      if (com.tencent.mm.plugin.fts.a.d.f(c))
      {
        str = SpellMap.d(c);
        if ((str != null) && (str.length() > 1)) {
          if (paramBoolean) {
            paramString2.add(str.substring(0, 1).toLowerCase());
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramString2.add(str);
        continue;
        paramString2.add("");
        continue;
        paramString2.add("");
      }
    }
    paramList = c(paramString2, paramList).iterator();
    while (paramList.hasNext()) {
      paramString1 = a(paramString1, (a)paramList.next());
    }
    GMTrace.o(1312380944384L, 9778);
    return paramString1;
  }
  
  public static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    GMTrace.i(1316273258496L, 9807);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("type", String.valueOf(paramInt2));
    localHashMap.put("lang", u.ea(aa.getContext()));
    localHashMap.put("platform", "android");
    localHashMap.put("version", String.valueOf(hOW));
    boolean bool6 = false;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    switch (paramInt1)
    {
    default: 
      bool6 = bool2;
      bool4 = bool3;
      bool5 = bool1;
      bool2 = bool6;
      bool3 = bool5;
      bool1 = bool4;
    }
    for (;;)
    {
      v.i("MicroMsg.FTS.FTSExportLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool3) {
        localHashMap.put("isSug", "1");
      }
      if (bool2) {
        localHashMap.put("isLocalSug", "1");
      }
      if (bool1) {
        localHashMap.put("isMostSearchBiz", "1");
      }
      if (!paramBoolean) {
        localHashMap.put("isHomePage", "0");
      }
      float f2 = com.tencent.mm.bg.a.dI(aa.getContext());
      float f1 = f2;
      if (f2 != 1.0F)
      {
        f1 = f2;
        if (f2 != 0.875F)
        {
          f1 = f2;
          if (f2 != 1.125F)
          {
            f1 = f2;
            if (f2 != 1.25F)
            {
              f1 = f2;
              if (f2 != 1.375F)
              {
                f1 = f2;
                if (f2 != 1.625F)
                {
                  f1 = f2;
                  if (f2 != 1.875F)
                  {
                    f1 = f2;
                    if (f2 != 2.025F) {
                      f1 = 1.0F;
                    }
                  }
                }
              }
            }
          }
        }
      }
      localHashMap.put("fontRatio", String.valueOf(f1));
      localHashMap.put("netType", Il());
      if (com.tencent.mm.am.b.HK())
      {
        localObject = com.tencent.mm.am.b.HM();
        if (localObject != null) {
          localHashMap.put("musicSnsId", ((anc)localObject).tps);
        }
      }
      GMTrace.o(1316273258496L, 9807);
      return localHashMap;
      Object localObject = j.kc("mixGlobal");
      if (paramBoolean)
      {
        bool5 = bool1;
        bool4 = bool3;
        bool6 = bool2;
        if (((JSONObject)localObject).optInt("mixSugSwitch", 0) != 1) {
          break;
        }
        bool2 = false;
        bool3 = true;
        bool1 = false;
        continue;
      }
      if (paramInt2 == 1)
      {
        bool5 = bool1;
        bool4 = bool3;
        bool6 = bool2;
        if (((JSONObject)localObject).optInt("bizSugSwitch", 0) != 1) {
          break;
        }
        bool2 = false;
        bool3 = true;
        bool1 = false;
        continue;
      }
      if (paramInt2 == 8)
      {
        bool5 = bool1;
        bool4 = bool3;
        bool6 = bool2;
        if (((JSONObject)localObject).optInt("snsSugSwitch", 0) != 1) {
          break;
        }
        bool2 = false;
        bool3 = true;
        bool1 = false;
        continue;
      }
      if (paramInt2 == 1024)
      {
        bool5 = bool1;
        bool4 = bool3;
        bool6 = bool2;
        if (((JSONObject)localObject).optInt("novelSugSwitch", 0) != 1) {
          break;
        }
        bool2 = false;
        bool3 = true;
        bool1 = false;
        continue;
      }
      if (paramInt2 == 512)
      {
        bool5 = bool1;
        bool4 = bool3;
        bool6 = bool2;
        if (((JSONObject)localObject).optInt("musicSugSwitch", 0) != 1) {
          break;
        }
        bool2 = false;
        bool3 = true;
        bool1 = false;
        continue;
      }
      if ((paramInt2 != 384) && (paramInt2 != 256))
      {
        bool5 = bool1;
        bool4 = bool3;
        bool6 = bool2;
        if (paramInt2 != 128) {
          break;
        }
      }
      bool5 = bool1;
      bool4 = bool3;
      bool6 = bool2;
      if (((JSONObject)localObject).optInt("emotionSugSwitch", 0) != 1) {
        break;
      }
      bool2 = false;
      bool3 = true;
      bool1 = false;
      continue;
      bool1 = bool6;
      if (paramInt2 == 1)
      {
        bool1 = bool6;
        if (j.kc("bizTab").optInt("bizSugSwitch", 0) == 1) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (paramInt2 == 2)
      {
        bool2 = bool1;
        if (j.kc("articleTab").optInt("sugSwitch", 0) == 1) {
          bool2 = true;
        }
      }
      bool3 = bool2;
      bool1 = bool4;
      if (paramInt2 == 8)
      {
        localObject = j.kc("snsTab");
        if (((JSONObject)localObject).optInt("sugSwitch", 0) == 1) {
          bool2 = true;
        }
        bool3 = bool2;
        bool1 = bool4;
        if (((JSONObject)localObject).optInt("localSugSwitch", 0) == 1)
        {
          bool1 = true;
          bool3 = bool2;
        }
      }
      bool4 = bool3;
      if (!paramBoolean)
      {
        bool4 = bool3;
        if (paramInt2 == 4)
        {
          bool4 = bool3;
          if (j.kc("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
            bool4 = true;
          }
        }
      }
      bool2 = bool5;
      if (paramInt2 == 1)
      {
        bool2 = bool5;
        if (j.kc("bizTab").optInt("mfsBizSwitch", 0) == 1) {
          bool2 = true;
        }
      }
      bool5 = bool4;
      if (paramInt2 == 1024)
      {
        bool5 = bool4;
        if (j.kc("novelTab").optInt("sugSwitch", 0) == 1) {
          bool5 = true;
        }
      }
      bool3 = bool5;
      if (paramInt2 == 512)
      {
        bool3 = bool5;
        if (j.kc("musicTab").optInt("sugSwitch", 0) == 1) {
          bool3 = true;
        }
      }
      bool5 = bool3;
      bool4 = bool2;
      bool6 = bool1;
      if (paramInt2 != 384) {
        break;
      }
      if (j.kc("emotionTab").optInt("sugSwitch", 0) == 1) {
        bool3 = true;
      }
      bool4 = bool1;
      bool1 = bool2;
      bool2 = bool4;
      continue;
      bool5 = bool1;
      bool4 = bool3;
      bool6 = bool2;
      if (j.kc("bizEntry").optInt("sugSwitch") != 1) {
        break;
      }
      bool2 = false;
      bool3 = true;
      bool1 = false;
      continue;
      bool5 = bool1;
      bool4 = bool3;
      bool6 = bool2;
      if (j.kc("bizUnionTopEntry").optInt("sugSwitch") != 1) {
        break;
      }
      bool2 = false;
      bool3 = true;
      bool1 = false;
    }
  }
  
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    GMTrace.i(1316004823040L, 9805);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    GMTrace.o(1316004823040L, 9805);
  }
  
  public static Map<String, String> aV(int paramInt1, int paramInt2)
  {
    GMTrace.i(1316139040768L, 9806);
    switch (paramInt1)
    {
    default: 
      localMap = a(paramInt1, false, paramInt2);
      GMTrace.o(1316139040768L, 9806);
      return localMap;
    }
    Map localMap = n.a(paramInt1, false, paramInt2);
    GMTrace.o(1316139040768L, 9806);
    return localMap;
  }
  
  public static boolean af(String paramString1, String paramString2)
  {
    int i = 0;
    GMTrace.i(17864513814528L, 133101);
    if (paramString1 == paramString2)
    {
      GMTrace.o(17864513814528L, 133101);
      return true;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      GMTrace.o(17864513814528L, 133101);
      return false;
    }
    if (paramString1.startsWith(paramString2))
    {
      GMTrace.o(17864513814528L, 133101);
      return true;
    }
    if (TextUtils.isEmpty(paramString1)) {}
    StringBuilder localStringBuilder;
    for (paramString1 = "";; paramString1 = localStringBuilder.toString())
    {
      boolean bool = paramString1.startsWith(paramString2);
      GMTrace.o(17864513814528L, 133101);
      return bool;
      localStringBuilder = new StringBuilder(paramString1.length());
      while (i < paramString1.length())
      {
        localStringBuilder.append(SpellMap.d(paramString1.charAt(i)));
        i += 1;
      }
    }
  }
  
  private static a b(CharSequence paramCharSequence, String paramString)
  {
    GMTrace.i(1312112508928L, 9776);
    paramString = SpellMap.mx(paramString.toLowerCase());
    g.bKx();
    String str = paramCharSequence.toString();
    str = com.tencent.mm.bi.f.bKu().eG(str, "");
    com.tencent.mm.bi.b.bKo();
    paramString = c(SpellMap.mx(com.tencent.mm.bi.b.eF(str, "").replaceAll(" ", "").toLowerCase()), paramString);
    if (paramString.isAvailable())
    {
      int i = paramString.start;
      while ((i < paramString.end) && (i < paramCharSequence.length()))
      {
        if (paramCharSequence.charAt(i) == ' ') {
          paramString.end += 1;
        }
        i += 1;
      }
    }
    GMTrace.o(1312112508928L, 9776);
    return paramString;
  }
  
  private static a b(List<String> paramList, String paramString)
  {
    GMTrace.i(1313186250752L, 9784);
    a locala = new a();
    int i = 0;
    String str;
    if (i < paramList.size())
    {
      str = (String)paramList.get(i);
      if (bf.mA(str)) {
        break label218;
      }
      if (str.startsWith(paramString))
      {
        if (locala.start < 0) {
          locala.start = i;
        }
        locala.end = (i + 1);
      }
    }
    else
    {
      GMTrace.o(1313186250752L, 9784);
      return locala;
    }
    int j;
    if (paramString.startsWith(str)) {
      j = i + 1;
    }
    for (;;)
    {
      if ((j < paramList.size()) && (!bf.mA((String)paramList.get(j))))
      {
        str = str + (String)paramList.get(j);
        if ((paramString.length() > str.length()) && (paramString.startsWith(str))) {
          break label225;
        }
        if ((paramString.length() <= str.length()) && (str.startsWith(paramString)))
        {
          locala.start = i;
          locala.end = (j + 1);
        }
      }
      label218:
      i += 1;
      break;
      label225:
      j += 1;
    }
  }
  
  public static String b(String paramString1, List<String> paramList, String paramString2)
  {
    GMTrace.i(17864111161344L, 133098);
    if (bf.mA(paramString1))
    {
      GMTrace.o(17864111161344L, 133098);
      return "";
    }
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = bf.c(paramList, "");
    }
    paramString2 = SpellMap.mx(((String)localObject).toLowerCase());
    paramString2 = c(SpellMap.mx(paramString1.toString().toLowerCase()), paramString2);
    if (paramString2.isAvailable())
    {
      paramString1 = a(paramString1, paramString2);
      GMTrace.o(17864111161344L, 133098);
      return paramString1;
    }
    paramString2 = b(paramString1, bf.c(paramList, ""));
    if (paramString2.isAvailable())
    {
      paramString1 = a(paramString1, paramString2);
      GMTrace.o(17864111161344L, 133098);
      return paramString1;
    }
    paramString2 = SpellMap.mx(paramString1.toString().toLowerCase());
    localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = c(paramString2, SpellMap.mx(((String)paramList.next()).toLowerCase()));
      if (locala.isAvailable()) {
        ((ArrayList)localObject).add(locala);
      }
    }
    if (((ArrayList)localObject).size() > 0)
    {
      paramList = ((ArrayList)localObject).iterator();
      while (paramList.hasNext()) {
        paramString1 = a(paramString1, (a)paramList.next());
      }
      GMTrace.o(17864111161344L, 133098);
      return paramString1;
    }
    GMTrace.o(17864111161344L, 133098);
    return paramString1;
  }
  
  private static a c(CharSequence paramCharSequence, String paramString)
  {
    GMTrace.i(1313454686208L, 9786);
    int i = paramCharSequence.toString().indexOf(paramString);
    paramCharSequence = new a();
    if (i >= 0)
    {
      paramCharSequence.start = i;
      paramCharSequence.end = (paramCharSequence.start + paramString.length());
    }
    GMTrace.o(1313454686208L, 9786);
    return paramCharSequence;
  }
  
  public static String c(int paramInt, Map<String, String> paramMap)
  {
    GMTrace.i(1316407476224L, 9808);
    switch (paramInt)
    {
    default: 
      paramMap = m(paramMap);
      GMTrace.o(1316407476224L, 9808);
      return paramMap;
    }
    paramMap = n.m(paramMap);
    GMTrace.o(1316407476224L, 9808);
    return paramMap;
  }
  
  private static ArrayList<a> c(List<String> paramList1, List<String> paramList2)
  {
    GMTrace.i(1313052033024L, 9783);
    ArrayList localArrayList = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      a locala = b(paramList1, ((String)paramList2.next()).toLowerCase());
      if (locala.isAvailable()) {
        localArrayList.add(locala);
      }
    }
    GMTrace.o(1313052033024L, 9783);
    return localArrayList;
  }
  
  public static final String gm(int paramInt)
  {
    GMTrace.i(17830288293888L, 132846);
    Object localObject = new StringBuilder().append(paramInt).append("_");
    h.vG();
    localObject = o.getString(com.tencent.mm.kernel.a.uH()) + "_" + System.currentTimeMillis();
    GMTrace.o(17830288293888L, 132846);
    return (String)localObject;
  }
  
  public static int gn(int paramInt)
  {
    GMTrace.i(18933960671232L, 141069);
    if (paramInt == 201) {
      paramInt = 1006;
    }
    for (;;)
    {
      GMTrace.o(18933960671232L, 141069);
      return paramInt;
      if (paramInt == 3) {
        paramInt = 1005;
      } else if (paramInt == 16) {
        paramInt = 1042;
      } else if (paramInt == 20) {
        paramInt = 1053;
      } else {
        paramInt = 1000;
      }
    }
  }
  
  public static boolean iX(String paramString)
  {
    GMTrace.i(1315870605312L, 9804);
    Object localObject1 = aa.getContext().getAssets();
    try
    {
      localObject1 = ((AssetManager)localObject1).open("fts_template.zip");
      if (localObject1 == null)
      {
        v.e("MicroMsg.FTS.FTSExportLogic", "file inputStream not found");
        GMTrace.o(1315870605312L, 9804);
        return false;
      }
    }
    catch (IOException localIOException1)
    {
      InputStream localInputStream;
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", localIOException1, "", new Object[0]);
        localInputStream = null;
      }
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.getParentFile().mkdirs();
      try
      {
        paramString = new FileOutputStream(paramString);
        if (paramString == null) {}
      }
      catch (FileNotFoundException paramString)
      {
        for (;;)
        {
          try
          {
            a(localInputStream, paramString);
            com.tencent.mm.a.e.b(localInputStream);
            com.tencent.mm.a.e.a(paramString);
            GMTrace.o(1315870605312L, 9804);
            return true;
          }
          catch (IOException localIOException2)
          {
            v.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", localIOException2, "", new Object[0]);
            com.tencent.mm.a.e.b(localInputStream);
            com.tencent.mm.a.e.a(paramString);
            GMTrace.o(1315870605312L, 9804);
            return false;
          }
          finally
          {
            com.tencent.mm.a.e.b(localInputStream);
            com.tencent.mm.a.e.a(paramString);
          }
          paramString = paramString;
          v.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", paramString, "", new Object[0]);
          paramString = null;
        }
      }
      com.tencent.mm.a.e.b(localInputStream);
      GMTrace.o(1315870605312L, 9804);
    }
    return false;
  }
  
  public static String m(Map<String, String> paramMap)
  {
    GMTrace.i(1316675911680L, 9810);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(Ik());
    if (paramMap.size() > 0)
    {
      localStringBuffer.append("/app.html?");
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuffer.append((String)localEntry.getKey());
        localStringBuffer.append("=");
        localStringBuffer.append((String)localEntry.getValue());
        localStringBuffer.append("&");
      }
      if (!paramMap.containsKey("sessionId"))
      {
        localStringBuffer.append("sessionId");
        localStringBuffer.append("=");
        localStringBuffer.append(gm(bf.PX((String)paramMap.get("scene"))));
        localStringBuffer.append("&");
      }
      paramMap = localStringBuffer.substring(0, localStringBuffer.length() - 1);
      GMTrace.o(1316675911680L, 9810);
      return paramMap;
    }
    localStringBuffer.append("/app.html");
    paramMap = localStringBuffer.toString();
    GMTrace.o(1316675911680L, 9810);
    return paramMap;
  }
  
  public static String n(Map<String, ? extends Object> paramMap)
  {
    GMTrace.i(16176054796288L, 120521);
    StringBuffer localStringBuffer = new StringBuffer();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuffer.append((String)localEntry.getKey());
      localStringBuffer.append("=");
      if (localEntry.getValue() != null) {
        localStringBuffer.append(localEntry.getValue().toString());
      }
      localStringBuffer.append("&");
    }
    paramMap = localStringBuffer.substring(0, localStringBuffer.length() - 1).toString();
    GMTrace.o(16176054796288L, 120521);
    return paramMap;
  }
  
  static final class a
  {
    int end;
    int start;
    
    a()
    {
      GMTrace.i(1324192104448L, 9866);
      this.start = -1;
      this.end = -1;
      GMTrace.o(1324192104448L, 9866);
    }
    
    final boolean isAvailable()
    {
      GMTrace.i(1324326322176L, 9867);
      if (this.start >= 0)
      {
        GMTrace.o(1324326322176L, 9867);
        return true;
      }
      GMTrace.o(1324326322176L, 9867);
      return false;
    }
  }
  
  public static final class b
  {
    public String aQd;
    public String fDj;
    public int fRE;
    public int hOX;
    public int hOY;
    public int hOZ;
    public LinkedList<bij> hPa;
    public String hPb;
    public int hPc;
    public String hPd;
    public String hPe;
    public int hPf;
    public LinkedList<String> hPg;
    public int hPh;
    public int hPi;
    public String hPj;
    public bek hPk;
    public LinkedList<lz> hPl;
    public LinkedList<ant> hPm;
    public int hPn;
    public bqn hPo;
    public bor hPp;
    public int offset;
    public int scene;
    
    public b()
    {
      GMTrace.i(14450014814208L, 107661);
      this.hPa = new LinkedList();
      this.hPg = new LinkedList();
      this.hPl = new LinkedList();
      this.hPm = new LinkedList();
      GMTrace.o(14450014814208L, 107661);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/as/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */