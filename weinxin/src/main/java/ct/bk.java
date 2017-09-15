package ct;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import com.tencent.map.geolocation.internal.TencentHttpClientFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class bk
{
  private static volatile bk l;
  public final Context a;
  private final bl b;
  private final ExecutorService c;
  private final HashMap<String, bo> d;
  private final PackageManager e;
  private final TelephonyManager f;
  private final WifiManager g;
  private final LocationManager h;
  private final TencentHttpClient i;
  public final CountDownLatch j;
  private String k;
  private List<db> m;
  
  private bk(Context paramContext)
  {
    this.a = paramContext;
    this.e = paramContext.getPackageManager();
    this.f = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.g = ((WifiManager)paramContext.getSystemService("wifi"));
    this.h = ((LocationManager)paramContext.getSystemService("location"));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("channelId", b.a.d(paramContext.getPackageName()));
    this.i = TencentHttpClientFactory.getInstance().getTencentHttpClient(paramContext, (Bundle)localObject);
    localObject = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    if (Build.VERSION.SDK_INT >= 9) {
      ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    }
    this.c = ((ExecutorService)localObject);
    this.d = new HashMap();
    this.d.put("cell", new bp("cell"));
    this.d.put("so", new bq(paramContext, "so"));
    this.b = new bl(this);
    try
    {
      this.b.h = b(paramContext);
      this.j = new CountDownLatch(1);
      new Thread(new Runnable()
      {
        public final void run()
        {
          bk.this.j();
          bk.this.j.countDown();
        }
      }).start();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        b.a.b("AppContext", "transactionTooLarge");
      }
    }
  }
  
  public static bk a(Context paramContext)
  {
    if (l == null) {}
    try
    {
      if (l == null) {
        l = new bk(paramContext);
      }
      return l;
    }
    finally {}
  }
  
  private static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        if (paramContext.containsKey("TencentGeoLocationSDK")) {
          return paramContext.getString("TencentGeoLocationSDK");
        }
        if (paramContext.containsKey("TencentMapSDK"))
        {
          paramContext = paramContext.getString("TencentMapSDK");
          return paramContext;
        }
        return "";
      }
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private String b(String paramString)
  {
    bl localbl = this.b;
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", localbl.d());
    localHashMap.put("app_name", c(localbl.i));
    localHashMap.put("app_label", c(localbl.j));
    localHashMap.put("l", paramString);
    try
    {
      paramString = new JSONObject(localHashMap);
      localbl = this.b;
      localHashMap = new HashMap();
      localHashMap.put("imei", c(localbl.a()));
      localHashMap.put("imsi", c(localbl.b()));
      localHashMap.put("n", c(b.a.b(localbl.e)));
      localHashMap.put("qq", c(b.a.b(localbl.g)));
      localHashMap.put("mac", c(localbl.c().toLowerCase(Locale.ENGLISH)));
      localHashMap.put("model", c(Build.MANUFACTURER + "_" + Build.MODEL));
      paramString = paramString.put("attribute", new JSONObject(localHashMap)).toString();
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  private static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private PackageInfo k()
  {
    try
    {
      PackageInfo localPackageInfo = this.e.getPackageInfo(this.a.getPackageName(), 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return new PackageInfo();
  }
  
  @Nullable
  public final TelephonyManager a()
  {
    return this.f;
  }
  
  public final bl a(long paramLong)
  {
    if (paramLong > 0L) {}
    try
    {
      if (!this.j.await(paramLong, TimeUnit.MILLISECONDS))
      {
        return null;
        this.j.await();
      }
      return this.b;
    }
    catch (InterruptedException localInterruptedException) {}
    return null;
  }
  
  public final bo a(String paramString)
  {
    paramString = (bo)this.d.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return bn.a;
  }
  
  public final String a(String paramString, byte[] paramArrayOfByte)
  {
    long l1 = System.currentTimeMillis();
    paramString = this.i.postSync(paramString, paramArrayOfByte);
    long l2 = System.currentTimeMillis();
    b.a.a("HalleyTimeCost:" + (l2 - l1));
    paramArrayOfByte = b.a.b((byte[])paramString.first);
    if (paramArrayOfByte != null) {
      return new String(paramArrayOfByte, (String)paramString.second);
    }
    b.a.a("AppContext", "postSync: inflate failed");
    return "{}";
  }
  
  public final void a(Object paramObject)
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        if (this.m == null) {
          this.m = new ArrayList();
        }
        Object localObject1 = this.m.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label191;
        }
        localObject2 = ((db)((Iterator)localObject1).next()).c;
        if (paramObject != localObject2) {
          continue;
        }
        n = 1;
        if (n != 0) {
          return;
        }
        localObject1 = paramObject.getClass().getDeclaredMethods();
        int i1 = localObject1.length;
        n = 0;
        if (n >= i1) {
          continue;
        }
        localObject2 = localObject1[n];
        localObject3 = ((Method)localObject2).getName();
        if ((!((String)localObject3).startsWith("on")) || (!((String)localObject3).endsWith("Event"))) {
          break label184;
        }
        localObject3 = ((Method)localObject2).getParameterTypes();
        if (localObject3.length != 1) {
          throw new IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
        }
      }
      finally {}
      Object localObject2 = new db(localObject3[0], (Method)localObject2, paramObject);
      this.m.add(localObject2);
      label184:
      n += 1;
      continue;
      label191:
      int n = 0;
    }
  }
  
  @Nullable
  public final WifiManager b()
  {
    return this.g;
  }
  
  public final void b(Object paramObject)
  {
    List localList;
    try
    {
      localList = this.m;
      if (localList == null) {
        break label119;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        db localdb = (db)localIterator.next();
        Object localObject = localdb.c;
        if ((localObject == null) || (localObject == paramObject)) {
          localArrayList.add(localdb);
        }
      }
      paramObject = localArrayList.iterator();
    }
    finally {}
    while (((Iterator)paramObject).hasNext()) {
      localList.remove((db)((Iterator)paramObject).next());
    }
    label119:
  }
  
  @Nullable
  public final LocationManager c()
  {
    return this.h;
  }
  
  /* Error */
  public final void c(@Nullable Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 384	ct/bk:m	Ljava/util/List;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -9 -> 6
    //   18: aload_3
    //   19: invokeinterface 393 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 399 1 0
    //   31: ifeq -25 -> 6
    //   34: aload_3
    //   35: invokeinterface 403 1 0
    //   40: checkcast 405	ct/db
    //   43: astore 4
    //   45: aload_1
    //   46: invokevirtual 411	java/lang/Object:getClass	()Ljava/lang/Class;
    //   49: aload 4
    //   51: getfield 456	ct/db:a	Ljava/lang/Class;
    //   54: invokevirtual 459	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: istore_2
    //   58: iload_2
    //   59: ifeq -34 -> 25
    //   62: aload 4
    //   64: getfield 462	ct/db:b	Ljava/lang/reflect/Method;
    //   67: aload 4
    //   69: getfield 407	ct/db:c	Ljava/lang/Object;
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: invokevirtual 466	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: goto -59 -> 25
    //   87: astore 4
    //   89: ldc -72
    //   91: ldc -37
    //   93: aload 4
    //   95: invokestatic 469	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: goto -73 -> 25
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	bk
    //   0	106	1	paramObject	Object
    //   57	2	2	bool	boolean
    //   13	22	3	localObject	Object
    //   43	25	4	localdb	db
    //   87	7	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   62	84	87	java/lang/Exception
    //   9	14	101	finally
    //   18	25	101	finally
    //   25	58	101	finally
    //   62	84	101	finally
    //   89	98	101	finally
  }
  
  public final boolean d()
  {
    return this.f != null;
  }
  
  public final boolean e()
  {
    return this.g != null;
  }
  
  public final boolean f()
  {
    return this.h != null;
  }
  
  public final bl g()
  {
    return this.b;
  }
  
  public final ExecutorService h()
  {
    return this.c;
  }
  
  public final String i()
  {
    int i1 = (int)(System.currentTimeMillis() / 86400000L % 5L);
    int n;
    try
    {
      long l1 = Long.parseLong(this.k.substring(1));
      n = (int)(l1 % 5L);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        SharedPreferences localSharedPreferences;
        n = 0;
        continue;
        label275:
        n = 0;
      }
      label280:
      localException1.edit().putBoolean("flag", true).apply();
      str = b(localException2.toString());
      return str;
    }
    localSharedPreferences = this.a.getSharedPreferences("LocationSDK", 0);
    if (i1 == n) {
      if (localSharedPreferences.getBoolean("flag", false)) {}
    }
    for (;;)
    {
      try
      {
        Object localObject1 = this.e.getInstalledPackages(8192);
        localStringBuilder = new StringBuilder();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label280;
        }
        localPackageInfo = (PackageInfo)((Iterator)localObject1).next();
        n = localPackageInfo.applicationInfo.flags;
        localObject2 = localPackageInfo.applicationInfo;
        if ((n & 0x1) > 0) {
          continue;
        }
        localObject2 = localPackageInfo.applicationInfo.loadLabel(this.e).toString();
        if ((((String)localObject2).length() > 30) || (((String)localObject2).startsWith("com.")) || (((String)localObject2).contains("theme"))) {
          break label339;
        }
        if (!((String)localObject2).contains("CheilPengtai")) {
          break label275;
        }
      }
      catch (Exception localException2)
      {
        StringBuilder localStringBuilder;
        PackageInfo localPackageInfo;
        Object localObject2;
        localSharedPreferences.edit().putBoolean("flag", true).apply();
      }
      if (n == 0)
      {
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append('_');
        localStringBuilder.append(localPackageInfo.versionName);
        localStringBuilder.append('|');
        continue;
        for (;;)
        {
          return null;
          String str;
          localException1.edit().putBoolean("flag", false).apply();
        }
        label339:
        n = 1;
      }
    }
  }
  
  /* Error */
  final void j()
  {
    // Byte code:
    //   0: ldc -72
    //   2: ldc_w 560
    //   5: invokestatic 379	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 161	ct/bk:b	Lct/bl;
    //   12: astore 7
    //   14: new 562	java/io/FileInputStream
    //   17: dup
    //   18: new 564	java/io/File
    //   21: dup
    //   22: invokestatic 570	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   25: ldc_w 572
    //   28: invokespecial 575	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   31: invokespecial 578	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore 5
    //   36: aload 5
    //   38: ifnonnull +710 -> 748
    //   41: aload_0
    //   42: getfield 43	ct/bk:a	Landroid/content/Context;
    //   45: invokevirtual 582	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   48: ldc_w 572
    //   51: invokevirtual 588	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnull +674 -> 732
    //   61: sipush 1024
    //   64: newarray <illegal type>
    //   66: astore 5
    //   68: new 238	org/json/JSONObject
    //   71: dup
    //   72: new 271	java/lang/String
    //   75: dup
    //   76: aload 5
    //   78: iconst_0
    //   79: aload 6
    //   81: aload 5
    //   83: invokevirtual 594	java/io/InputStream:read	([B)I
    //   86: invokespecial 597	java/lang/String:<init>	([BII)V
    //   89: invokespecial 598	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   92: astore 5
    //   94: aload 6
    //   96: invokestatic 601	ct/b$a:a	(Ljava/io/Closeable;)V
    //   99: aload 5
    //   101: ifnull +161 -> 262
    //   104: aload 5
    //   106: ldc_w 602
    //   109: iconst_0
    //   110: invokevirtual 605	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   113: pop
    //   114: aload 5
    //   116: ldc_w 607
    //   119: iconst_0
    //   120: invokevirtual 605	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   123: pop
    //   124: aload 5
    //   126: ldc_w 609
    //   129: iconst_0
    //   130: invokevirtual 605	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   133: pop
    //   134: aload 5
    //   136: ldc_w 611
    //   139: iconst_0
    //   140: invokevirtual 605	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   143: pop
    //   144: aload 5
    //   146: ldc_w 613
    //   149: iconst_0
    //   150: invokevirtual 605	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   153: pop
    //   154: aload 5
    //   156: ldc_w 615
    //   159: ldc2_w 616
    //   162: invokevirtual 621	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   165: pop2
    //   166: aload 5
    //   168: ldc_w 623
    //   171: ldc2_w 624
    //   174: invokevirtual 621	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   177: pop2
    //   178: aload 7
    //   180: aload 5
    //   182: ldc_w 627
    //   185: iconst_1
    //   186: invokevirtual 605	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   189: putfield 631	ct/bl:r	Z
    //   192: aload 7
    //   194: aload 5
    //   196: ldc_w 633
    //   199: iconst_0
    //   200: invokevirtual 605	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   203: putfield 635	ct/bl:s	Z
    //   206: aload 7
    //   208: aload 5
    //   210: ldc_w 636
    //   213: iconst_1
    //   214: invokevirtual 605	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   217: putfield 639	ct/bl:t	Z
    //   220: aload 5
    //   222: ldc -33
    //   224: ldc_w 641
    //   227: invokevirtual 645	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   230: astore 6
    //   232: aload 7
    //   234: aload 6
    //   236: putfield 647	ct/bl:o	Ljava/lang/String;
    //   239: aload 7
    //   241: aload 6
    //   243: putfield 650	ct/bl:q	Ljava/lang/String;
    //   246: aload 7
    //   248: aload 5
    //   250: ldc_w 652
    //   253: ldc_w 654
    //   256: invokevirtual 645	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   259: putfield 657	ct/bl:p	Ljava/lang/String;
    //   262: aload_0
    //   263: invokespecial 659	ct/bk:k	()Landroid/content/pm/PackageInfo;
    //   266: astore 6
    //   268: aload 6
    //   270: getfield 662	android/content/pm/PackageInfo:versionCode	I
    //   273: istore_1
    //   274: aload 7
    //   276: aload 6
    //   278: getfield 538	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   281: putfield 229	ct/bl:i	Ljava/lang/String;
    //   284: aload_0
    //   285: getfield 43	ct/bk:a	Landroid/content/Context;
    //   288: invokevirtual 665	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   291: aload_0
    //   292: getfield 51	ct/bk:e	Landroid/content/pm/PackageManager;
    //   295: invokevirtual 517	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   298: astore 5
    //   300: aload 5
    //   302: ifnull +409 -> 711
    //   305: aload 5
    //   307: invokevirtual 518	java/lang/Object:toString	()Ljava/lang/String;
    //   310: astore 5
    //   312: aload 7
    //   314: aload 5
    //   316: putfield 235	ct/bl:j	Ljava/lang/String;
    //   319: aload_0
    //   320: getfield 61	ct/bk:f	Landroid/telephony/TelephonyManager;
    //   323: astore 5
    //   325: aload 5
    //   327: ifnull +109 -> 436
    //   330: iconst_2
    //   331: newarray <illegal type>
    //   333: astore 8
    //   335: aload 5
    //   337: aload 8
    //   339: invokestatic 670	ct/ct:a	(Landroid/telephony/TelephonyManager;[I)V
    //   342: aload 7
    //   344: aload 8
    //   346: iconst_0
    //   347: iaload
    //   348: putfield 672	ct/bl:k	I
    //   351: aload 7
    //   353: aload 8
    //   355: iconst_1
    //   356: iaload
    //   357: putfield 674	ct/bl:l	I
    //   360: aload 7
    //   362: aload 5
    //   364: invokevirtual 677	android/telephony/TelephonyManager:getPhoneType	()I
    //   367: putfield 679	ct/bl:b	I
    //   370: aload 5
    //   372: invokevirtual 682	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   375: getstatic 687	ct/cz:a	Ljava/util/regex/Pattern;
    //   378: invokestatic 690	ct/cz:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
    //   381: astore 8
    //   383: aload 5
    //   385: invokevirtual 693	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   388: getstatic 695	ct/cz:b	Ljava/util/regex/Pattern;
    //   391: invokestatic 690	ct/cz:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
    //   394: astore 9
    //   396: aload 5
    //   398: invokevirtual 698	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   401: getstatic 700	ct/cz:c	Ljava/util/regex/Pattern;
    //   404: invokestatic 690	ct/cz:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
    //   407: astore 5
    //   409: aload_0
    //   410: aload 8
    //   412: putfield 478	ct/bk:k	Ljava/lang/String;
    //   415: aload 7
    //   417: aload 8
    //   419: putfield 702	ct/bl:c	Ljava/lang/String;
    //   422: aload 7
    //   424: aload 9
    //   426: putfield 704	ct/bl:d	Ljava/lang/String;
    //   429: aload 7
    //   431: aload 5
    //   433: putfield 253	ct/bl:e	Ljava/lang/String;
    //   436: aload 7
    //   438: invokestatic 707	ct/da:a	()Ljava/lang/String;
    //   441: ldc_w 709
    //   444: ldc -37
    //   446: invokevirtual 712	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   449: getstatic 269	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   452: invokevirtual 715	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   455: getstatic 717	ct/cz:d	Ljava/util/regex/Pattern;
    //   458: invokestatic 690	ct/cz:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
    //   461: putfield 719	ct/bl:f	Ljava/lang/String;
    //   464: aload_0
    //   465: getfield 51	ct/bk:e	Landroid/content/pm/PackageManager;
    //   468: astore 5
    //   470: aload 5
    //   472: ldc_w 721
    //   475: invokevirtual 724	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   478: istore_2
    //   479: aload 5
    //   481: ldc_w 726
    //   484: invokevirtual 724	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   487: istore_3
    //   488: aload 5
    //   490: ldc_w 728
    //   493: invokevirtual 724	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   496: istore 4
    //   498: ldc -72
    //   500: new 279	java/lang/StringBuilder
    //   503: dup
    //   504: ldc_w 730
    //   507: invokespecial 353	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   510: iload_2
    //   511: invokevirtual 733	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: ldc_w 735
    //   517: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: iload_3
    //   521: invokevirtual 733	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   524: ldc_w 737
    //   527: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: iload 4
    //   532: invokevirtual 733	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   535: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 379	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: new 279	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   548: astore 5
    //   550: aload 5
    //   552: ldc_w 739
    //   555: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: getstatic 294	android/os/Build:MODEL	Ljava/lang/String;
    //   561: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: ldc_w 741
    //   567: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: getstatic 744	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   573: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc_w 741
    //   579: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload 7
    //   584: invokevirtual 245	ct/bl:a	()Ljava/lang/String;
    //   587: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 746
    //   593: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload 7
    //   598: getfield 672	ct/bl:k	I
    //   601: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   604: ldc_w 741
    //   607: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 7
    //   612: getfield 674	ct/bl:l	I
    //   615: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: ldc_w 751
    //   621: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload 6
    //   626: getfield 662	android/content/pm/PackageInfo:versionCode	I
    //   629: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: ldc_w 741
    //   635: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload 6
    //   640: getfield 538	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   643: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: ldc_w 753
    //   649: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload 7
    //   654: invokevirtual 225	ct/bl:d	()Ljava/lang/String;
    //   657: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: ldc_w 741
    //   663: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload 7
    //   668: invokevirtual 755	ct/bl:e	()Ljava/lang/String;
    //   671: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: ldc -72
    //   677: aload 5
    //   679: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 379	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: ldc -72
    //   687: ldc_w 757
    //   690: invokestatic 379	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: return
    //   694: astore 5
    //   696: ldc -72
    //   698: ldc -37
    //   700: aload 5
    //   702: invokestatic 469	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   705: aconst_null
    //   706: astore 5
    //   708: goto -614 -> 94
    //   711: ldc_w 759
    //   714: astore 5
    //   716: goto -404 -> 312
    //   719: astore 5
    //   721: ldc -72
    //   723: ldc_w 761
    //   726: aload 5
    //   728: invokestatic 469	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   731: return
    //   732: aconst_null
    //   733: astore 5
    //   735: goto -636 -> 99
    //   738: astore 5
    //   740: aconst_null
    //   741: astore 5
    //   743: goto -707 -> 36
    //   746: astore 6
    //   748: aload 5
    //   750: astore 6
    //   752: goto -696 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	755	0	this	bk
    //   273	1	1	n	int
    //   478	33	2	bool1	boolean
    //   487	34	3	bool2	boolean
    //   496	35	4	bool3	boolean
    //   34	644	5	localObject1	Object
    //   694	7	5	localException	Exception
    //   706	9	5	str1	String
    //   719	8	5	localThrowable	Throwable
    //   733	1	5	localObject2	Object
    //   738	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   741	8	5	localObject3	Object
    //   54	585	6	localObject4	Object
    //   746	1	6	localIOException	java.io.IOException
    //   750	1	6	localObject5	Object
    //   12	655	7	localbl	bl
    //   333	85	8	localObject6	Object
    //   394	31	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   68	94	694	java/lang/Exception
    //   0	14	719	java/lang/Throwable
    //   14	36	719	java/lang/Throwable
    //   41	56	719	java/lang/Throwable
    //   61	68	719	java/lang/Throwable
    //   68	94	719	java/lang/Throwable
    //   94	99	719	java/lang/Throwable
    //   104	262	719	java/lang/Throwable
    //   262	300	719	java/lang/Throwable
    //   305	312	719	java/lang/Throwable
    //   312	325	719	java/lang/Throwable
    //   330	436	719	java/lang/Throwable
    //   436	693	719	java/lang/Throwable
    //   696	705	719	java/lang/Throwable
    //   14	36	738	java/io/FileNotFoundException
    //   41	56	746	java/io/IOException
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */