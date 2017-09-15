package ct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends PhoneStateListener
{
  volatile boolean a;
  private final bk b;
  private CellInfo c = null;
  private SignalStrength d = null;
  private ServiceState e = null;
  private long f;
  private HandlerThread g;
  private Handler h;
  
  public b(bk parambk)
  {
    this.b = parambk;
  }
  
  private void a(int paramInt)
  {
    TelephonyManager localTelephonyManager = this.b.a();
    try
    {
      localTelephonyManager.listen(this, paramInt);
      return;
    }
    catch (Exception localException)
    {
      a.a("TxCellProvider", "listenCellState: failed! flags=" + paramInt, localException);
    }
  }
  
  @SuppressLint({"NewApi"})
  private boolean a(CellInfo paramCellInfo)
  {
    if (paramCellInfo == null) {}
    while ((!ct.a(paramCellInfo)) || (ct.a(this.c, paramCellInfo))) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      if (this.c != null)
      {
        long l = System.currentTimeMillis();
        if (l - this.f > 2000L) {}
        for (int i = 1; i != 0; i = 0)
        {
          this.f = l;
          cg localcg = cg.a(this.b, this.c);
          try
          {
            if ((this.h != null) && (localcg != null))
            {
              c localc = new c(this.b);
              localc.a(localcg);
              this.h.post(localc);
            }
            return;
          }
          finally {}
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public final void a()
  {
    int i = 1;
    if (this.a) {}
    for (;;)
    {
      return;
      if (this.b != null)
      {
        this.g = new HandlerThread("NewCellProvider");
        if (this.g != null)
        {
          this.g.start();
          this.h = new b(this.g.getLooper(), (byte)0);
          this.h.sendEmptyMessageDelayed(0, 3000L);
        }
        while (i != 0)
        {
          try
          {
            CellInfo localCellInfo = ct.a(this.b);
            if ((a(localCellInfo)) && (cg.a(this.b, localCellInfo) != null)) {
              this.c = localCellInfo;
            }
            a(1281);
            this.a = true;
            return;
          }
          catch (Exception localException)
          {
            return;
          }
          i = 0;
        }
      }
    }
  }
  
  public final void b()
  {
    if (!this.a) {
      return;
    }
    this.a = false;
    a(0);
    try
    {
      if (this.h != null)
      {
        this.h.removeCallbacksAndMessages(null);
        this.h = null;
      }
      this.g.quit();
      this.g = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = 0L;
      a.a("TxCellProvider", "shutdown: state=[shutdown]");
      return;
    }
    finally {}
  }
  
  @SuppressLint({"NewApi"})
  public final void onCellInfoChanged(List<CellInfo> paramList)
  {
    int k = 1;
    Object localObject = null;
    if (paramList == null)
    {
      a.b("TxCellProvider", "onCellInfoChanged: cellinfo list is null ");
      c();
      return;
    }
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      CellInfo localCellInfo = (CellInfo)localIterator.next();
      if (!localCellInfo.isRegistered()) {
        break label190;
      }
      localObject = localCellInfo;
    }
    label80:
    label89:
    label132:
    label137:
    label184:
    label190:
    for (;;)
    {
      break;
      int i;
      int j;
      if (localObject == null)
      {
        i = 1;
        if (paramList == null) {
          break label132;
        }
        j = 1;
        if (paramList.size() <= 0) {
          break label137;
        }
        if ((j & i & k) == 0) {
          break label184;
        }
      }
      for (paramList = (CellInfo)paramList.get(0);; paramList = (List<CellInfo>)localObject)
      {
        if (a(paramList))
        {
          this.c = paramList;
          c();
          return;
          i = 0;
          break;
          j = 0;
          break label80;
          k = 0;
          break label89;
        }
        localObject = new StringBuilder("onCellInfoChanged: illegal cell or same cell ");
        if (paramList == null) {}
        for (paramList = "null cell";; paramList = paramList.toString())
        {
          a.b("TxCellProvider", paramList);
          return;
        }
      }
    }
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    int j = 1;
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {}
    do
    {
      ServiceState localServiceState;
      do
      {
        return;
        localServiceState = this.e;
      } while ((localServiceState != null) && (localServiceState.getState() == paramServiceState.getState()));
      this.e = paramServiceState;
    } while (!this.a);
    int i;
    boolean bool;
    if (this.e != null) {
      if (this.e.getState() == 0)
      {
        i = 1;
        paramServiceState = this.b.a();
        bool = ct.a(this.b.a);
        if (paramServiceState == null) {
          break label171;
        }
        if (paramServiceState.getSimState() != 5) {
          break label166;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (j == 0)) {
        i = 0;
      }
      paramServiceState = new Message();
      paramServiceState.what = 12999;
      paramServiceState.arg1 = 12003;
      paramServiceState.arg2 = i;
      this.b.c(paramServiceState);
      return;
      if (this.e.getState() == 1)
      {
        i = 0;
        break;
      }
      i = -1;
      break;
      label166:
      j = 0;
      continue;
      label171:
      j = 0;
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null) {}
    for (;;)
    {
      return;
      try
      {
        SignalStrength localSignalStrength = this.d;
        int i = this.b.g().b;
        if ((localSignalStrength == null) || (ct.a(i, localSignalStrength, paramSignalStrength)))
        {
          this.d = paramSignalStrength;
          c();
          return;
        }
      }
      catch (Exception paramSignalStrength)
      {
        a.b("TxCellProvider", paramSignalStrength.toString());
      }
    }
  }
  
  public final class a
  {
    private static a c;
    public c a;
    public d b = new d();
    
    public a()
    {
      this.b.a();
      this.a = new c();
      this.a.a();
    }
    
    private static double a(double paramDouble)
    {
      return 3.141592653589793D * paramDouble / 180.0D;
    }
    
    public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      paramDouble1 = a(paramDouble1);
      paramDouble3 = a(paramDouble3);
      paramDouble2 = a(paramDouble2);
      paramDouble4 = a(paramDouble4);
      double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
      return Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6178.137D * 10000.0D) / 10000.0D * 1000.0D;
    }
    
    public static double a(double paramDouble, int paramInt)
    {
      try
      {
        if (Double.isNaN(paramDouble)) {
          return 0.0D;
        }
        paramDouble = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.HALF_DOWN).doubleValue();
        return paramDouble;
      }
      catch (Exception localException) {}
      return 0.0D;
    }
    
    public static x a()
    {
      return y.a();
    }
    
    public static String a(Context paramContext)
    {
      int i = c(paramContext);
      if (i != -1)
      {
        if (i == 0) {
          return "mobile";
        }
        if (i == 1) {
          return "wifi";
        }
      }
      return "none";
    }
    
    public static String a(cg paramcg, boolean paramBoolean)
    {
      if (paramcg == null) {
        return "[]";
      }
      int j = paramcg.b;
      int k = paramcg.c;
      int m = paramcg.a;
      Object localObject1 = new ArrayList();
      Object localObject2 = paramcg.a();
      int i;
      int n;
      int i1;
      if (ct.a(m, j, k, paramcg.d, paramcg.e))
      {
        i = paramcg.d;
        int i2 = paramcg.e;
        int i3 = paramcg.f;
        n = paramcg.g;
        i1 = paramcg.h;
        paramcg = new StringBuilder();
        paramcg.append("{");
        paramcg.append("\"mcc\":");
        paramcg.append(j);
        paramcg.append(",\"mnc\":");
        paramcg.append(k);
        paramcg.append(",\"lac\":");
        paramcg.append(i);
        paramcg.append(",\"cellid\":");
        paramcg.append(i2);
        paramcg.append(",\"rss\":");
        paramcg.append(i3);
        paramcg.append(",\"seed\":");
        if (paramBoolean)
        {
          i = 1;
          paramcg.append(i);
          if ((n != Integer.MAX_VALUE) && (i1 != Integer.MAX_VALUE))
          {
            paramcg.append(",\"stationLat\":");
            paramcg.append(String.format("%.6f", new Object[] { Float.valueOf(n / 14400.0F) }));
            paramcg.append(",\"stationLng\":");
            paramcg.append(String.format("%.6f", new Object[] { Float.valueOf(i1 / 14400.0F) }));
          }
          paramcg.append("}");
          ((ArrayList)localObject1).add(paramcg.toString());
        }
      }
      for (;;)
      {
        try
        {
          paramcg = ((List)localObject2).iterator();
          if (paramcg.hasNext())
          {
            localObject2 = (NeighboringCellInfo)paramcg.next();
            i = ((NeighboringCellInfo)localObject2).getLac();
            n = ((NeighboringCellInfo)localObject2).getCid();
            if (!ct.a(m, j, k, i, n)) {
              break label561;
            }
            i1 = ((NeighboringCellInfo)localObject2).getRssi();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("{");
            ((StringBuilder)localObject2).append("\"mcc\":");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(",\"mnc\":");
            ((StringBuilder)localObject2).append(k);
            ((StringBuilder)localObject2).append(",\"lac\":");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(",\"cellid\":");
            ((StringBuilder)localObject2).append(n);
            ((StringBuilder)localObject2).append(",\"rss\":");
            ((StringBuilder)localObject2).append((i1 << 1) - 113);
            ((StringBuilder)localObject2).append("}");
            ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
            continue;
          }
          i = 0;
        }
        catch (Exception paramcg)
        {
          paramcg = new StringBuilder("[");
          localObject2 = new cx(",");
          localObject1 = ((Iterable)localObject1).iterator();
          paramcg.append(((cx)localObject2).a(new StringBuilder(), (Iterator)localObject1).toString());
          paramcg.append("]");
          return paramcg.toString();
        }
        break;
        a("illeagal main cell! ", j, k, m, paramcg.d, paramcg.e);
        continue;
        label561:
        a("illeagal neighboringCell! ", j, k, m, i, n);
      }
    }
    
    public static String a(ch paramch)
    {
      if (paramch == null) {
        return "{}";
      }
      Location localLocation = paramch.a;
      StringBuilder localStringBuilder = new StringBuilder();
      double d1 = a(localLocation.getLatitude(), 6);
      double d2 = a(localLocation.getLongitude(), 6);
      double d3 = a(localLocation.getAltitude(), 1);
      double d4 = a(localLocation.getAccuracy(), 1);
      double d5 = a(localLocation.getBearing(), 1);
      double d6 = a(localLocation.getSpeed(), 1);
      localStringBuilder.append("{");
      localStringBuilder.append("\"latitude\":");
      localStringBuilder.append(d1);
      localStringBuilder.append(",\"longitude\":");
      localStringBuilder.append(d2);
      localStringBuilder.append(",\"additional\":");
      localStringBuilder.append("\"" + d3 + "," + d4 + "," + d5 + "," + d6 + "," + paramch.b + "\"");
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public static String a(ck paramck)
    {
      if ((paramck == null) || (paramck.a() == null)) {
        return "[]";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      if ((paramck.a() == null) || (paramck.a().size() <= 0))
      {
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
      paramck = paramck.a();
      Iterator localIterator = paramck.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        ScanResult localScanResult = (ScanResult)localIterator.next();
        paramck.size();
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("{\"mac\":\"").append(localScanResult.BSSID).append("\",");
        localStringBuilder.append("\"rssi\":").append(localScanResult.level).append("}");
        i += 1;
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    
    public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, List paramList)
    {
      paramContext = h.a(paramContext, paramString1, paramString2, paramString3);
      if (paramContext != null) {
        paramContext.a(paramList);
      }
    }
    
    public static void a(Closeable paramCloseable)
    {
      if (paramCloseable != null) {}
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable) {}
    }
    
    /* Error */
    public static void a(CharSequence paramCharSequence, java.io.File paramFile, java.nio.charset.Charset paramCharset)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: new 348	java/io/BufferedWriter
      //   5: dup
      //   6: new 350	java/io/OutputStreamWriter
      //   9: dup
      //   10: new 352	java/io/FileOutputStream
      //   13: dup
      //   14: aload_1
      //   15: iconst_1
      //   16: invokespecial 355	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   19: aload_2
      //   20: invokespecial 358	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
      //   23: invokespecial 361	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
      //   26: astore_2
      //   27: aload_2
      //   28: astore_1
      //   29: aload_2
      //   30: aload_0
      //   31: invokevirtual 364	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
      //   34: pop
      //   35: aload_2
      //   36: astore_1
      //   37: aload_2
      //   38: invokevirtual 367	java/io/BufferedWriter:flush	()V
      //   41: aload_2
      //   42: invokestatic 369	ct/b$a:a	(Ljava/io/Closeable;)V
      //   45: return
      //   46: astore_0
      //   47: aconst_null
      //   48: astore_1
      //   49: aload_0
      //   50: athrow
      //   51: astore_0
      //   52: aload_1
      //   53: invokestatic 369	ct/b$a:a	(Ljava/io/Closeable;)V
      //   56: aload_0
      //   57: athrow
      //   58: astore_0
      //   59: aload_3
      //   60: astore_1
      //   61: goto -9 -> 52
      //   64: astore_0
      //   65: aload_2
      //   66: astore_1
      //   67: goto -18 -> 49
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	70	0	paramCharSequence	CharSequence
      //   0	70	1	paramFile	java.io.File
      //   0	70	2	paramCharset	java.nio.charset.Charset
      //   1	59	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	27	46	java/io/IOException
      //   29	35	51	finally
      //   37	41	51	finally
      //   49	51	51	finally
      //   2	27	58	finally
      //   29	35	64	java/io/IOException
      //   37	41	64	java/io/IOException
    }
    
    public static void a(String paramString)
    {
      a("#", 4, paramString);
    }
    
    private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      boolean bool = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCellInfoWithJsonFormat: ");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.append("isGsm=");
      if (paramInt3 == 1) {}
      for (;;)
      {
        paramString.append(bool);
        localStringBuilder.append(", mcc,mnc=").append(paramInt1).append(",").append(paramInt2);
        localStringBuilder.append(", lac,cid=").append(paramInt4).append(",").append(paramInt5);
        return;
        bool = false;
      }
    }
    
    private static void a(String paramString1, int paramInt, String paramString2)
    {
      Object localObject = TencentExtraKeys.getTencentLogs();
      if (paramString2 != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((TencentLog)((Iterator)localObject).next()).println(paramString1, paramInt, paramString2);
        }
      }
    }
    
    public static void a(String paramString1, String paramString2)
    {
      a(paramString1, 4, paramString2);
    }
    
    public static void a(String paramString1, String paramString2, Throwable paramThrowable)
    {
      a(paramString1, 6, paramString2 + " exception: " + Log.getStackTraceString(paramThrowable));
    }
    
    /* Error */
    public static void a(byte[] paramArrayOfByte, java.io.File paramFile)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: new 408	java/io/BufferedOutputStream
      //   5: dup
      //   6: new 352	java/io/FileOutputStream
      //   9: dup
      //   10: aload_1
      //   11: iconst_1
      //   12: invokespecial 355	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   15: invokespecial 411	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   18: astore_2
      //   19: aload_2
      //   20: astore_1
      //   21: aload_2
      //   22: aload_0
      //   23: invokevirtual 415	java/io/BufferedOutputStream:write	([B)V
      //   26: aload_2
      //   27: astore_1
      //   28: aload_2
      //   29: invokevirtual 416	java/io/BufferedOutputStream:flush	()V
      //   32: aload_2
      //   33: invokestatic 369	ct/b$a:a	(Ljava/io/Closeable;)V
      //   36: return
      //   37: astore_0
      //   38: aconst_null
      //   39: astore_1
      //   40: aload_0
      //   41: athrow
      //   42: astore_0
      //   43: aload_1
      //   44: invokestatic 369	ct/b$a:a	(Ljava/io/Closeable;)V
      //   47: aload_0
      //   48: athrow
      //   49: astore_0
      //   50: aload_3
      //   51: astore_1
      //   52: goto -9 -> 43
      //   55: astore_0
      //   56: aload_2
      //   57: astore_1
      //   58: goto -18 -> 40
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	paramArrayOfByte	byte[]
      //   0	61	1	paramFile	java.io.File
      //   18	39	2	localBufferedOutputStream	java.io.BufferedOutputStream
      //   1	50	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	37	java/io/IOException
      //   21	26	42	finally
      //   28	32	42	finally
      //   40	42	42	finally
      //   2	19	49	finally
      //   21	26	55	java/io/IOException
      //   28	32	55	java/io/IOException
    }
    
    public static boolean a(int paramInt)
    {
      return paramInt == 0;
    }
    
    public static boolean a(Location paramLocation, double[] paramArrayOfDouble)
    {
      int n = (int)(paramLocation.getLatitude() * 1000000.0D);
      int i1 = (int)(paramLocation.getLongitude() * 1000000.0D);
      paramLocation = d("tencent_loc_lib");
      int k = 0;
      int m = 0;
      while (k < paramLocation.length())
      {
        int i2 = paramLocation.charAt(k);
        int j = 256;
        int i = j;
        if (i2 >= 65)
        {
          i = j;
          if (i2 <= 90) {
            i = i2 - 65;
          }
        }
        j = i;
        if (i2 >= 97)
        {
          j = i;
          if (i2 <= 122) {
            j = i2 - 97 + 64;
          }
        }
        i = j;
        if (i2 >= 48)
        {
          i = j;
          if (i2 <= 57) {
            i = i2 + 128 - 48;
          }
        }
        m += i;
        k += 1;
      }
      paramLocation = new double[2];
      try
      {
        e.b(n ^ m, m ^ i1, paramLocation);
        paramArrayOfDouble[0] = paramLocation[0];
        paramArrayOfDouble[1] = paramLocation[1];
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;) {}
      }
    }
    
    public static boolean a(Object paramObject)
    {
      return paramObject == null;
    }
    
    public static boolean a(Object paramObject1, Object paramObject2)
    {
      return (paramObject1 == null) || (paramObject2 == null);
    }
    
    public static boolean a(Object paramObject, Object... paramVarArgs)
    {
      if ((paramVarArgs == null) && (paramObject == null)) {}
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
      int j = paramVarArgs.length;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label44;
        }
        if (paramVarArgs[i] != null) {
          break;
        }
        i += 1;
      }
      label44:
      return true;
    }
    
    public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2)
    {
      if ((paramList1 == null) || (paramList2 == null)) {
        return false;
      }
      int n = paramList1.size();
      int i1 = paramList2.size();
      if ((n == 0) && (i1 == 0)) {
        return true;
      }
      if ((n == 0) || (i1 == 0)) {
        return false;
      }
      int m;
      int j;
      int i;
      label79:
      Object localObject;
      label161:
      int k;
      if (paramList1.size() > paramList2.size())
      {
        paramList2 = paramList2.iterator();
        m = 1;
        j = 0;
        i = 0;
        if (!paramList2.hasNext()) {
          break label233;
        }
        localObject = (ScanResult)paramList2.next();
        Iterator localIterator = paramList1.iterator();
        for (;;)
        {
          if (localIterator.hasNext()) {
            if (((ScanResult)localIterator.next()).BSSID.equals(((ScanResult)localObject).BSSID)) {
              if ((m == 1) && (((ScanResult)localObject).level > -50))
              {
                i += 1;
                k = i;
                if (m == 2)
                {
                  k = i;
                  if (((ScanResult)localObject).level > -60) {
                    k = i + 1;
                  }
                }
                if ((m == 3) && (((ScanResult)localObject).level > -60))
                {
                  i = k + 1;
                  label209:
                  j += 1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        m += 1;
        break label79;
        localObject = paramList1;
        paramList1 = paramList2;
        paramList2 = (List<ScanResult>)localObject;
        break;
        label233:
        if (i == 3)
        {
          a("TxWifiChange", 4, "big 3 is similar");
          return false;
        }
        i = n + i1;
        if ((j << 1 < i * 0.85D) || (j < 13)) {}
        for (boolean bool = true;; bool = false)
        {
          a("TxWifiChange", "isDiffrent:c=" + n + ",k=" + j + ",f=" + i + ",r=0.85,s=" + bool);
          return bool;
        }
        i = k;
        break label209;
        break label161;
      }
    }
    
    /* Error */
    public static byte[] a(java.io.File paramFile)
    {
      // Byte code:
      //   0: new 466	java/io/ByteArrayOutputStream
      //   3: dup
      //   4: invokespecial 467	java/io/ByteArrayOutputStream:<init>	()V
      //   7: astore_3
      //   8: sipush 8192
      //   11: newarray <illegal type>
      //   13: astore 4
      //   15: new 469	java/io/BufferedInputStream
      //   18: dup
      //   19: new 471	java/io/FileInputStream
      //   22: dup
      //   23: aload_0
      //   24: invokespecial 474	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   27: invokespecial 477	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   30: astore_2
      //   31: aload_2
      //   32: astore_0
      //   33: aload_2
      //   34: aload 4
      //   36: invokevirtual 481	java/io/BufferedInputStream:read	([B)I
      //   39: istore_1
      //   40: iload_1
      //   41: iconst_m1
      //   42: if_icmpeq +34 -> 76
      //   45: aload_2
      //   46: astore_0
      //   47: aload_3
      //   48: aload 4
      //   50: iconst_0
      //   51: iload_1
      //   52: invokevirtual 484	java/io/ByteArrayOutputStream:write	([BII)V
      //   55: goto -24 -> 31
      //   58: astore_3
      //   59: aload_2
      //   60: astore_0
      //   61: aload_3
      //   62: astore_2
      //   63: aload_2
      //   64: athrow
      //   65: astore_3
      //   66: aload_0
      //   67: astore_2
      //   68: aload_3
      //   69: astore_0
      //   70: aload_2
      //   71: invokestatic 369	ct/b$a:a	(Ljava/io/Closeable;)V
      //   74: aload_0
      //   75: athrow
      //   76: aload_2
      //   77: astore_0
      //   78: aload_3
      //   79: invokevirtual 488	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   82: astore_3
      //   83: aload_2
      //   84: invokestatic 369	ct/b$a:a	(Ljava/io/Closeable;)V
      //   87: aload_3
      //   88: areturn
      //   89: astore_0
      //   90: aconst_null
      //   91: astore_2
      //   92: goto -22 -> 70
      //   95: astore_2
      //   96: aconst_null
      //   97: astore_0
      //   98: goto -35 -> 63
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	paramFile	java.io.File
      //   39	13	1	i	int
      //   30	62	2	localObject1	Object
      //   95	1	2	localIOException1	IOException
      //   7	41	3	localByteArrayOutputStream	ByteArrayOutputStream
      //   58	4	3	localIOException2	IOException
      //   65	14	3	localObject2	Object
      //   82	6	3	arrayOfByte1	byte[]
      //   13	36	4	arrayOfByte2	byte[]
      // Exception table:
      //   from	to	target	type
      //   33	40	58	java/io/IOException
      //   47	55	58	java/io/IOException
      //   78	83	58	java/io/IOException
      //   33	40	65	finally
      //   47	55	65	finally
      //   63	65	65	finally
      //   78	83	65	finally
      //   15	31	89	finally
      //   15	31	95	java/io/IOException
    }
    
    public static byte[] a(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        return null;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
      try
      {
        localDeflaterOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        localDeflaterOutputStream.finish();
        localDeflaterOutputStream.flush();
        localDeflaterOutputStream.close();
        return localByteArrayOutputStream.toByteArray();
      }
      catch (Exception paramArrayOfByte) {}
      return null;
    }
    
    public static a b()
    {
      try
      {
        if (c == null) {
          c = new a();
        }
        a locala = c;
        return locala;
      }
      finally {}
    }
    
    public static <T> T b(T paramT, Object paramObject)
    {
      if (paramT == null) {
        throw new NullPointerException(String.valueOf(paramObject));
      }
      return paramT;
    }
    
    public static String b(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    public static void b(String paramString1, String paramString2)
    {
      a(paramString1, 6, paramString2);
    }
    
    public static boolean b(Context paramContext)
    {
      int i = 1;
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {}
      while (i != 0)
      {
        return false;
        i = 0;
      }
      for (;;)
      {
        try
        {
          paramContext = ((ConnectivityManager)localObject).getNetworkInfo(0);
          localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
          if (localObject != null)
          {
            boolean bool2 = ((NetworkInfo)localObject).isConnected();
            bool1 = bool2;
            if (!bool2)
            {
              bool1 = bool2;
              if (paramContext != null) {
                bool1 = paramContext.isConnected();
              }
            }
            return bool1;
          }
        }
        catch (Exception paramContext)
        {
          return false;
        }
        boolean bool1 = false;
      }
    }
    
    public static boolean b(Object paramObject)
    {
      return paramObject != null;
    }
    
    @Nullable
    public static byte[] b(byte[] paramArrayOfByte)
    {
      int i = 0;
      if (paramArrayOfByte == null) {
        return null;
      }
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      InflaterInputStream localInflaterInputStream = new InflaterInputStream(localByteArrayInputStream);
      paramArrayOfByte = new byte[0];
      byte[] arrayOfByte2 = new byte['Ѐ'];
      for (;;)
      {
        try
        {
          int j = localInflaterInputStream.read(arrayOfByte2);
          if (j > 0)
          {
            i += j;
            byte[] arrayOfByte1 = new byte[i];
            System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramArrayOfByte.length, j);
            paramArrayOfByte = arrayOfByte1;
            if (j <= 0) {
              try
              {
                localByteArrayInputStream.close();
                localInflaterInputStream.close();
                return paramArrayOfByte;
              }
              catch (IOException paramArrayOfByte)
              {
                return null;
              }
            }
          }
        }
        catch (Exception paramArrayOfByte)
        {
          return null;
        }
      }
    }
    
    private static int c(Context paramContext)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {}
      for (int i = 1; i != 0; i = 0) {
        return -1;
      }
      try
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null)
        {
          i = paramContext.getType();
          return i;
        }
      }
      catch (Exception paramContext) {}
      return -1;
    }
    
    public static boolean c(String paramString)
    {
      do
      {
        JSONObject localJSONObject;
        do
        {
          try
          {
            localJSONObject = new JSONObject(paramString);
            if (paramString.contains("latitude")) {
              return true;
            }
          }
          catch (Exception paramString)
          {
            return false;
          }
          paramString = localJSONObject.optJSONArray("cells");
        } while ((paramString != null) && (paramString.length() > 0));
        paramString = localJSONObject.optJSONArray("wifis");
      } while ((paramString != null) && (paramString.length() > 0));
      return false;
    }
    
    public static String d(String paramString)
    {
      try
      {
        Object localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        localObject = ((MessageDigest)localObject).digest();
        StringBuilder localStringBuilder = new StringBuilder();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append(Integer.toHexString(localObject[i] & 0xFF)).append("");
          i += 1;
        }
        localObject = localStringBuilder.toString();
        return (String)localObject;
      }
      catch (Exception localException) {}
      return paramString;
    }
  }
  
  final class b
    extends Handler
  {
    private b(Looper paramLooper)
    {
      super();
    }
    
    @SuppressLint({"NewApi"})
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!b.this.a) {
        return;
      }
      sendEmptyMessageDelayed(0, 20000L);
      Object localObject = null;
      TelephonyManager localTelephonyManager = b.a(b.this).a();
      paramMessage = (Message)localObject;
      if (localTelephonyManager != null) {}
      try
      {
        paramMessage = localTelephonyManager.getAllCellInfo();
        b.a(b.this, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          b.a.a("TxCellProvider", "cannot get cell location", paramMessage);
          paramMessage = (Message)localObject;
        }
      }
      catch (Error paramMessage)
      {
        for (;;)
        {
          paramMessage = (Message)localObject;
        }
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    private bk a;
    private cg b;
    
    public c(bk parambk)
    {
      this.a = parambk;
    }
    
    public final void a(cg paramcg)
    {
      this.b = paramcg;
    }
    
    public final void run()
    {
      bk localbk = this.a;
      cg localcg = this.b;
      if (localcg != null)
      {
        localcg.a(ct.c(localbk));
        localbk.c(localcg);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */