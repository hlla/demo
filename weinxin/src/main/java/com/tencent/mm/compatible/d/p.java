package com.tencent.mm.compatible.d;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public final class p
{
  public static n gQR;
  public static b gQS;
  public static a gQT;
  public static u gQU;
  public static y gQV;
  public static r gQW;
  public static t gQX;
  public static w gQY;
  public static s gQZ;
  private static int gRa;
  public static j gRb;
  public static o gRc;
  private static String gRd;
  
  static
  {
    GMTrace.i(13804293324800L, 102850);
    gQR = new n();
    gQS = new b();
    gQT = new a();
    gQU = new u();
    gQV = new y();
    gQW = new r();
    gQX = new t();
    gQY = new w();
    gQZ = new s();
    gRa = -1;
    gRb = new j();
    gRc = new o();
    gRd = null;
    GMTrace.o(13804293324800L, 102850);
  }
  
  public static String aw(Context paramContext)
  {
    GMTrace.i(13802414276608L, 102836);
    try
    {
      v.i("MicroMsg.DeviceInfo", "lm: getManufacturer CurrentLanguage is %s", new Object[] { com.tencent.mm.sdk.platformtools.u.ea(paramContext) });
      if ((gQX == null) || (gQX.gRq == null) || (gQX.gRq.size() == 0))
      {
        v.i("MicroMsg.DeviceInfo", "lm: getManufacturer return is %s", new Object[] { Build.MANUFACTURER });
        paramContext = Build.MANUFACTURER;
        GMTrace.o(13802414276608L, 102836);
        return paramContext;
      }
      paramContext = (String)gQX.gRq.get(".manufacturerName." + com.tencent.mm.sdk.platformtools.u.ea(paramContext));
      v.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      boolean bool = bf.mA(paramContext);
      if (!bool)
      {
        GMTrace.o(13802414276608L, 102836);
        return paramContext;
      }
      paramContext = (String)gQX.gRq.get(".manufacturerName.en");
      v.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", new Object[] { paramContext });
      bool = bf.mA(paramContext);
      if (!bool)
      {
        GMTrace.o(13802414276608L, 102836);
        return paramContext;
      }
      paramContext = Build.MANUFACTURER;
      GMTrace.o(13802414276608L, 102836);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = Build.MANUFACTURER;
      GMTrace.o(13802414276608L, 102836);
    }
    return paramContext;
  }
  
  public static String ax(Context paramContext)
  {
    GMTrace.i(13802548494336L, 102837);
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperatorName();
      GMTrace.o(13802548494336L, 102837);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      v.printErrStackTrace("MicroMsg.DeviceInfo", paramContext, "getMobileSPType", new Object[0]);
      GMTrace.o(13802548494336L, 102837);
    }
    return "";
  }
  
  public static void du(String paramString)
  {
    GMTrace.i(13802145841152L, 102834);
    v.i("MicroMsg.DeviceInfo", "update deviceInfo %s", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13802145841152L, 102834);
      return;
    }
    if (paramString.hashCode() == gRa)
    {
      GMTrace.o(13802145841152L, 102834);
      return;
    }
    gRa = paramString.hashCode();
    gQR.reset();
    gQS.reset();
    gQT.reset();
    gRb.reset();
    gQU.reset();
    gQV.reset();
    Object localObject = gQW;
    ((r)localObject).gRe = 0;
    ((r)localObject).gRf = 0;
    localObject = gQX;
    ((t)localObject).gRp = "";
    ((t)localObject).gRq = null;
    gQY.fWX = false;
    gQZ.reset();
    new q();
    if (!q.a(paramString, gQR, gQS, gQT, gRb, gQU, gQV, gQW, gQX, gQY, gQZ))
    {
      GMTrace.o(13802145841152L, 102834);
      return;
    }
    v.d("MicroMsg.DeviceInfo", "steve: mCameraInfo.mNeedEnhance = " + gQS.gPo);
    GMTrace.o(13802145841152L, 102834);
  }
  
  public static String getAndroidId()
  {
    GMTrace.i(13802951147520L, 102840);
    String str = Settings.Secure.getString(aa.getContext().getContentResolver(), "android_id");
    v.i("MicroMsg.DeviceInfo", "androidid:[%s]", new Object[] { str });
    GMTrace.o(13802951147520L, 102840);
    return str;
  }
  
  public static String getDeviceID(Context paramContext)
  {
    GMTrace.i(13801474752512L, 102829);
    if (paramContext == null)
    {
      GMTrace.o(13801474752512L, 102829);
      return null;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        GMTrace.o(13801474752512L, 102829);
        return null;
      }
      paramContext = paramContext.getDeviceId();
      if (paramContext == null)
      {
        GMTrace.o(13801474752512L, 102829);
        return null;
      }
      paramContext = paramContext.trim();
      GMTrace.o(13801474752512L, 102829);
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      v.e("MicroMsg.DeviceInfo", "getDeviceId failed, security exception");
      GMTrace.o(13801474752512L, 102829);
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.DeviceInfo", paramContext, "", new Object[0]);
      }
    }
  }
  
  public static String getSimCountryIso()
  {
    GMTrace.i(13802682712064L, 102838);
    Object localObject = (TelephonyManager)aa.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getSimCountryIso();
      v.i("MicroMsg.DeviceInfo", "get isoCode:[%s]", new Object[] { localObject });
      GMTrace.o(13802682712064L, 102838);
      return (String)localObject;
    }
    GMTrace.o(13802682712064L, 102838);
    return null;
  }
  
  public static String rA()
  {
    GMTrace.i(13801340534784L, 102828);
    Object localObject = (String)k.rj().get(258);
    if (localObject != null)
    {
      GMTrace.o(13801340534784L, 102828);
      return (String)localObject;
    }
    String str = getDeviceID(aa.getContext());
    localObject = str;
    if (str == null) {
      localObject = "1234567890ABCDEF";
    }
    k.rj().set(258, localObject);
    GMTrace.o(13801340534784L, 102828);
    return (String)localObject;
  }
  
  public static String rB()
  {
    GMTrace.i(13801608970240L, 102830);
    StringBuilder localStringBuilder;
    String str;
    if (gRd == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Settings.Secure.getString(aa.getContext().getContentResolver(), "android_id"));
      str = (String)k.rj().get(256);
      if (str == null) {
        break label182;
      }
      localStringBuilder.append(str);
      str = (String)k.rj().get(259);
      if (str == null) {
        break label199;
      }
      v.d("MicroMsg.DeviceInfo", "getHardWareId from file " + str);
    }
    for (;;)
    {
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      gRd = "A" + g.n(str.getBytes()).substring(0, 15);
      v.w("MicroMsg.DeviceInfo", "guid:%s, dev=%s", new Object[] { gRd, str });
      str = gRd;
      GMTrace.o(13801608970240L, 102830);
      return str;
      label182:
      str = rE();
      k.rj().set(256, str);
      break;
      label199:
      str = Build.MANUFACTURER + Build.MODEL + m.rq();
      k.rj().set(259, str);
      v.d("MicroMsg.DeviceInfo", "getHardWareId " + str);
    }
  }
  
  public static String rC()
  {
    GMTrace.i(13801743187968L, 102831);
    Object localObject = (WifiManager)aa.getContext().getSystemService("wifi");
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        break label56;
      }
    }
    label56:
    for (localObject = ((WifiInfo)localObject).getMacAddress();; localObject = null)
    {
      GMTrace.o(13801743187968L, 102831);
      return (String)localObject;
      localObject = ((WifiManager)localObject).getConnectionInfo();
      break;
    }
  }
  
  public static String rD()
  {
    GMTrace.i(13801877405696L, 102832);
    String str = null;
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter != null) {
      str = localBluetoothAdapter.getAddress();
    }
    GMTrace.o(13801877405696L, 102832);
    return str;
  }
  
  private static String rE()
  {
    GMTrace.i(13802011623424L, 102833);
    String str1 = bf.em(aa.getContext());
    String str2;
    if ((str1 != null) && (str1.length() > 0))
    {
      str2 = ("A" + str1 + "123456789ABCDEF").substring(0, 15);
      v.w("MicroMsg.DeviceInfo", "generated deviceId=" + str2);
      GMTrace.o(13802011623424L, 102833);
      return str2;
    }
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    str1 = "A";
    int i = 0;
    for (;;)
    {
      str2 = str1;
      if (i >= 15) {
        break;
      }
      str1 = str1 + (char)(localRandom.nextInt(25) + 65);
      i += 1;
    }
  }
  
  public static String rF()
  {
    GMTrace.i(13802280058880L, 102835);
    String str = Build.MODEL;
    GMTrace.o(13802280058880L, 102835);
    return str;
  }
  
  /* Error */
  public static String[] rG()
  {
    // Byte code:
    //   0: ldc2_w 437
    //   3: ldc_w 439
    //   6: invokestatic 44	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: iconst_2
    //   10: anewarray 168	java/lang/String
    //   13: astore_3
    //   14: aload_3
    //   15: iconst_0
    //   16: ldc -53
    //   18: aastore
    //   19: aload_3
    //   20: iconst_1
    //   21: ldc_w 441
    //   24: aastore
    //   25: aconst_null
    //   26: astore_2
    //   27: new 443	java/io/BufferedReader
    //   30: dup
    //   31: new 445	java/io/FileReader
    //   34: dup
    //   35: ldc_w 447
    //   38: invokespecial 448	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   41: sipush 8192
    //   44: invokespecial 451	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 454	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: invokestatic 458	com/tencent/mm/sdk/platformtools/bf:mz	(Ljava/lang/String;)Ljava/lang/String;
    //   55: ldc_w 460
    //   58: invokevirtual 464	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   61: astore_2
    //   62: iconst_2
    //   63: istore_0
    //   64: iload_0
    //   65: aload_2
    //   66: arraylength
    //   67: if_icmpge +41 -> 108
    //   70: aload_3
    //   71: iconst_0
    //   72: new 149	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   79: aload_3
    //   80: iconst_0
    //   81: aaload
    //   82: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: iload_0
    //   87: aaload
    //   88: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 466
    //   94: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: aastore
    //   101: iload_0
    //   102: iconst_1
    //   103: iadd
    //   104: istore_0
    //   105: goto -41 -> 64
    //   108: aload_3
    //   109: iconst_1
    //   110: aload_1
    //   111: invokevirtual 454	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   114: invokestatic 458	com/tencent/mm/sdk/platformtools/bf:mz	(Ljava/lang/String;)Ljava/lang/String;
    //   117: ldc_w 460
    //   120: invokevirtual 464	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   123: iconst_2
    //   124: aaload
    //   125: aastore
    //   126: aload_1
    //   127: invokevirtual 469	java/io/BufferedReader:close	()V
    //   130: ldc2_w 437
    //   133: ldc_w 439
    //   136: invokestatic 108	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   139: aload_3
    //   140: areturn
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull -15 -> 130
    //   148: aload_1
    //   149: invokevirtual 469	java/io/BufferedReader:close	()V
    //   152: goto -22 -> 130
    //   155: astore_1
    //   156: goto -26 -> 130
    //   159: astore_1
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 469	java/io/BufferedReader:close	()V
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: goto -41 -> 130
    //   174: astore_2
    //   175: goto -7 -> 168
    //   178: astore_3
    //   179: aload_1
    //   180: astore_2
    //   181: aload_3
    //   182: astore_1
    //   183: goto -23 -> 160
    //   186: astore_2
    //   187: goto -43 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   63	42	0	i	int
    //   47	80	1	localBufferedReader	BufferedReader
    //   141	1	1	localIOException1	IOException
    //   143	6	1	localObject1	Object
    //   155	1	1	localException1	Exception
    //   159	10	1	localObject2	Object
    //   170	10	1	localException2	Exception
    //   182	1	1	localObject3	Object
    //   26	139	2	arrayOfString1	String[]
    //   174	1	2	localException3	Exception
    //   180	1	2	localObject4	Object
    //   186	1	2	localIOException2	IOException
    //   13	127	3	arrayOfString2	String[]
    //   178	4	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   27	48	141	java/io/IOException
    //   148	152	155	java/lang/Exception
    //   27	48	159	finally
    //   126	130	170	java/lang/Exception
    //   164	168	174	java/lang/Exception
    //   48	62	178	finally
    //   64	101	178	finally
    //   108	126	178	finally
    //   48	62	186	java/io/IOException
    //   64	101	186	java/io/IOException
    //   108	126	186	java/io/IOException
  }
  
  public static String rH()
  {
    GMTrace.i(13803085365248L, 102841);
    Object localObject2 = null;
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      Object localObject1 = localObject2;
      if (localBluetoothAdapter != null)
      {
        localObject1 = localObject2;
        if (localBluetoothAdapter.isEnabled()) {
          localObject1 = localBluetoothAdapter.getAddress();
        }
      }
      localObject1 = bf.mz((String)localObject1);
      GMTrace.o(13803085365248L, 102841);
      return (String)localObject1;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.DeviceInfo", "getBlueToothAddress failed: %s", new Object[] { bf.g(localException) });
      GMTrace.o(13803085365248L, 102841);
    }
    return "";
  }
  
  @SuppressLint({"NewApi"})
  public static String rI()
  {
    GMTrace.i(13803219582976L, 102842);
    for (Object localObject = null;; localObject = str)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 14) {
          break label41;
        }
        str = Build.getRadioVersion();
        localObject = str;
      }
      catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
      {
        String str;
        v.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError, "May cause dvmFindCatchBlock crash!", new Object[0]);
        throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError));
      }
      catch (Throwable localThrowable)
      {
        label41:
        for (;;) {}
      }
      localObject = bf.mz((String)localObject);
      GMTrace.o(13803219582976L, 102842);
      return (String)localObject;
      str = Build.RADIO;
    }
  }
  
  public static String rJ()
  {
    GMTrace.i(13803353800704L, 102843);
    String str = Build.VERSION.RELEASE;
    GMTrace.o(13803353800704L, 102843);
    return str;
  }
  
  public static String rK()
  {
    GMTrace.i(13803488018432L, 102844);
    try
    {
      String str = bf.mz(((TelephonyManager)aa.getContext().getSystemService("phone")).getSubscriberId());
      GMTrace.o(13803488018432L, 102844);
      return str;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.DeviceInfo", localException, "getPhoneIMSI", new Object[0]);
      GMTrace.o(13803488018432L, 102844);
    }
    return "";
  }
  
  public static String rL()
  {
    GMTrace.i(13803622236160L, 102845);
    try
    {
      String str = bf.mz(((TelephonyManager)aa.getContext().getSystemService("phone")).getSimSerialNumber());
      GMTrace.o(13803622236160L, 102845);
      return str;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.DeviceInfo", localException, "getPhoneICCID", new Object[0]);
      GMTrace.o(13803622236160L, 102845);
    }
    return "";
  }
  
  @SuppressLint({"NewApi"})
  public static String rM()
  {
    GMTrace.i(13803756453888L, 102846);
    String str = null;
    if (Build.VERSION.SDK_INT >= 9) {
      str = Build.SERIAL;
    }
    str = bf.mz(str);
    GMTrace.o(13803756453888L, 102846);
    return str;
  }
  
  public static Map<String, String> rN()
  {
    GMTrace.i(13803890671616L, 102847);
    HashMap localHashMap = new HashMap();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[] { "/system/bin/cat", "/proc/cpuinfo" }).start().getInputStream()));
      for (;;)
      {
        Object localObject = localBufferedReader.readLine();
        if (localObject == null) {
          break;
        }
        if (!((String)localObject).trim().equals(""))
        {
          localObject = ((String)localObject).split(":");
          if (localObject.length > 1) {
            localHashMap.put(localObject[0].trim().toLowerCase(), localObject[1].trim());
          }
        }
      }
      GMTrace.o(13803890671616L, 102847);
    }
    catch (IOException localIOException) {}
    for (;;)
    {
      return localHashMap;
      localIOException.close();
    }
  }
  
  public static int rO()
  {
    GMTrace.i(13804024889344L, 102848);
    try
    {
      int i = new File("/sys/devices/system/cpu").listFiles(new a()).length;
      GMTrace.o(13804024889344L, 102848);
      return i;
    }
    catch (Exception localException)
    {
      GMTrace.o(13804024889344L, 102848);
    }
    return 1;
  }
  
  public static String rP()
  {
    GMTrace.i(13804159107072L, 102849);
    String str = "android-" + Build.MODEL + "-" + Build.VERSION.SDK_INT;
    GMTrace.o(13804159107072L, 102849);
    return str;
  }
  
  final class a
    implements FileFilter
  {
    a()
    {
      GMTrace.i(13799327268864L, 102813);
      GMTrace.o(13799327268864L, 102813);
    }
    
    public final boolean accept(File paramFile)
    {
      GMTrace.i(13799461486592L, 102814);
      if (Pattern.matches("cpu[0-9]+", paramFile.getName()))
      {
        GMTrace.o(13799461486592L, 102814);
        return true;
      }
      GMTrace.o(13799461486592L, 102814);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */