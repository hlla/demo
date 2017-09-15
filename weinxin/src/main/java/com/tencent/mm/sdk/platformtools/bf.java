package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.d;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import junit.framework.Assert;

public final class bf
{
  private static final TimeZone GMT;
  public static final long[] ijF;
  private static final char[] jmw;
  private static final String[] jmx;
  private static final long[] uuz;
  
  static
  {
    GMTrace.i(13903748661248L, 103591);
    ijF = new long[] { 300L, 200L, 300L, 200L };
    uuz = new long[] { 300L, 50L, 300L, 50L };
    GMT = TimeZone.getTimeZone("GMT");
    jmw = new char[] { 60, 62, 34, 39, 38, 13, 10, 32, 9 };
    jmx = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
    GMTrace.o(13903748661248L, 103591);
  }
  
  public static String A(byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    GMTrace.i(13886568792064L, 103463);
    if (paramArrayOfByte == null)
    {
      GMTrace.o(13886568792064L, 103463);
      return "(null)";
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = paramArrayOfByte.length;
    }
    char[] arrayOfChar1 = new char[16];
    char[] tmp43_41 = arrayOfChar1;
    tmp43_41[0] = 48;
    char[] tmp48_43 = tmp43_41;
    tmp48_43[1] = 49;
    char[] tmp53_48 = tmp48_43;
    tmp53_48[2] = 50;
    char[] tmp58_53 = tmp53_48;
    tmp58_53[3] = 51;
    char[] tmp63_58 = tmp58_53;
    tmp63_58[4] = 52;
    char[] tmp68_63 = tmp63_58;
    tmp68_63[5] = 53;
    char[] tmp73_68 = tmp68_63;
    tmp73_68[6] = 54;
    char[] tmp79_73 = tmp73_68;
    tmp79_73[7] = 55;
    char[] tmp85_79 = tmp79_73;
    tmp85_79[8] = 56;
    char[] tmp91_85 = tmp85_79;
    tmp91_85[9] = 57;
    char[] tmp97_91 = tmp91_85;
    tmp97_91[10] = 97;
    char[] tmp103_97 = tmp97_91;
    tmp103_97[11] = 98;
    char[] tmp109_103 = tmp103_97;
    tmp109_103[12] = 99;
    char[] tmp115_109 = tmp109_103;
    tmp115_109[13] = 100;
    char[] tmp121_115 = tmp115_109;
    tmp121_115[14] = 101;
    char[] tmp127_121 = tmp121_115;
    tmp127_121[15] = 102;
    tmp127_121;
    char[] arrayOfChar2 = new char[i * 3 + i / 16];
    int j = 0;
    paramInt = k;
    if (j < i + 0)
    {
      k = paramArrayOfByte[j];
      int m = paramInt + 1;
      arrayOfChar2[paramInt] = ' ';
      int n = m + 1;
      arrayOfChar2[m] = arrayOfChar1[(k >>> 4 & 0xF)];
      paramInt = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(k & 0xF)];
      if ((j % 16 != 0) || (j <= 0)) {
        break label265;
      }
      k = paramInt + 1;
      arrayOfChar2[paramInt] = '\n';
      paramInt = k;
    }
    label265:
    for (;;)
    {
      j += 1;
      break;
      paramArrayOfByte = new String(arrayOfChar2);
      GMTrace.o(13886568792064L, 103463);
      return paramArrayOfByte;
    }
  }
  
  public static boolean D(String... paramVarArgs)
  {
    boolean bool2 = false;
    GMTrace.i(13892742807552L, 103509);
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (mA(paramVarArgs[i])) {
          bool1 = true;
        }
      }
      else
      {
        GMTrace.o(13892742807552L, 103509);
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean F(Context paramContext, String paramString)
  {
    GMTrace.i(13895158726656L, 103527);
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if (!j(paramContext, localIntent))
    {
      v.e("MicroMsg.Util", "jump to url failed, " + paramString);
      GMTrace.o(13895158726656L, 103527);
      return false;
    }
    paramContext.startActivity(localIntent);
    GMTrace.o(13895158726656L, 103527);
    return true;
  }
  
  public static boolean Hq()
  {
    GMTrace.i(13897171992576L, 103542);
    if (!Locale.getDefault().equals(Locale.CHINA))
    {
      GMTrace.o(13897171992576L, 103542);
      return true;
    }
    Object localObject = TimeZone.getDefault();
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT+08:00");
    if (((TimeZone)localObject).getRawOffset() != localTimeZone.getRawOffset())
    {
      GMTrace.o(13897171992576L, 103542);
      return true;
    }
    localObject = (TelephonyManager)aa.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getNetworkCountryIso();
      if ((!mA((String)localObject)) && (!((String)localObject).contains("cn")) && (!((String)localObject).contains("CN")))
      {
        GMTrace.o(13897171992576L, 103542);
        return true;
      }
    }
    GMTrace.o(13897171992576L, 103542);
    return false;
  }
  
  public static boolean J(CharSequence paramCharSequence)
  {
    GMTrace.i(13892474372096L, 103507);
    if ((paramCharSequence == null) || (paramCharSequence.length() <= 0))
    {
      GMTrace.o(13892474372096L, 103507);
      return true;
    }
    GMTrace.o(13892474372096L, 103507);
    return false;
  }
  
  public static CharSequence K(CharSequence paramCharSequence)
  {
    GMTrace.i(13897977298944L, 103548);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if ((c >= '0') && (c <= '9')) {
        localStringBuffer.append(c);
      }
      i += 1;
    }
    paramCharSequence = localStringBuffer.toString();
    GMTrace.o(13897977298944L, 103548);
    return paramCharSequence;
  }
  
  public static long NA()
  {
    GMTrace.i(15696226418688L, 116946);
    long l = System.currentTimeMillis();
    GMTrace.o(15696226418688L, 116946);
    return l;
  }
  
  public static long NB()
  {
    GMTrace.i(13888179404800L, 103475);
    long l = SystemClock.elapsedRealtime();
    GMTrace.o(13888179404800L, 103475);
    return l;
  }
  
  public static long Nz()
  {
    GMTrace.i(13887374098432L, 103469);
    long l = System.currentTimeMillis() / 1000L;
    GMTrace.o(13887374098432L, 103469);
    return l;
  }
  
  public static byte[] O(Bitmap paramBitmap)
  {
    GMTrace.i(13885495050240L, 103455);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    v.i("MicroMsg.Util", "recycle bitmap:%s", new Object[] { paramBitmap });
    paramBitmap.recycle();
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      GMTrace.o(13885495050240L, 103455);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
      }
    }
  }
  
  public static String PF(String paramString)
  {
    GMTrace.i(13883213348864L, 103438);
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("../", "");
    }
    GMTrace.o(13883213348864L, 103438);
    return str;
  }
  
  public static boolean PG(String paramString)
  {
    GMTrace.i(13884689743872L, 103449);
    if (mA(paramString))
    {
      GMTrace.o(13884689743872L, 103449);
      return false;
    }
    boolean bool = Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(paramString).find();
    GMTrace.o(13884689743872L, 103449);
    return bool;
  }
  
  public static boolean PH(String paramString)
  {
    GMTrace.i(13884958179328L, 103451);
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      int k = paramString[i];
      if (((k < 97) || (k > 122)) && ((k < 65) || (k > 90)))
      {
        GMTrace.o(13884958179328L, 103451);
        return false;
      }
      i += 1;
    }
    GMTrace.o(13884958179328L, 103451);
    return true;
  }
  
  public static boolean PI(String paramString)
  {
    GMTrace.i(13885226614784L, 103453);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13885226614784L, 103453);
      return false;
    }
    paramString = paramString.trim();
    try
    {
      long l = Long.valueOf(paramString).longValue();
      if ((l > 0L) && (l <= 4294967295L))
      {
        GMTrace.o(13885226614784L, 103453);
        return true;
      }
    }
    catch (NumberFormatException paramString)
    {
      v.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      GMTrace.o(13885226614784L, 103453);
      return false;
    }
    GMTrace.o(13885226614784L, 103453);
    return false;
  }
  
  public static boolean PJ(String paramString)
  {
    GMTrace.i(13885360832512L, 103454);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13885360832512L, 103454);
      return false;
    }
    boolean bool = paramString.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    GMTrace.o(13885360832512L, 103454);
    return bool;
  }
  
  public static boolean PK(String paramString)
  {
    GMTrace.i(13885629267968L, 103456);
    if (paramString == null)
    {
      GMTrace.o(13885629267968L, 103456);
      return false;
    }
    paramString = paramString.trim();
    if ((paramString.length() < 6) || (paramString.length() > 20))
    {
      GMTrace.o(13885629267968L, 103456);
      return false;
    }
    if (!j(paramString.charAt(0)))
    {
      GMTrace.o(13885629267968L, 103456);
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if ((!j(c)) && (!k(c)) && (c != '-') && (c != '_'))
      {
        GMTrace.o(13885629267968L, 103456);
        return false;
      }
      i += 1;
    }
    GMTrace.o(13885629267968L, 103456);
    return true;
  }
  
  public static boolean PL(String paramString)
  {
    GMTrace.i(13885763485696L, 103457);
    if (paramString == null)
    {
      GMTrace.o(13885763485696L, 103457);
      return false;
    }
    if (paramString.length() < 8)
    {
      GMTrace.o(13885763485696L, 103457);
      return false;
    }
    try
    {
      Long.parseLong(paramString);
      GMTrace.o(13885763485696L, 103457);
      return false;
    }
    catch (NumberFormatException paramString)
    {
      GMTrace.o(13885763485696L, 103457);
    }
    return true;
  }
  
  public static Intent PM(String paramString)
  {
    GMTrace.i(13886837227520L, 103465);
    if ((paramString != null) && (!paramString.equals(""))) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
      GMTrace.o(13886837227520L, 103465);
      return localIntent;
    }
  }
  
  public static int PN(String paramString)
  {
    GMTrace.i(13892877025280L, 103510);
    if (paramString == null)
    {
      GMTrace.o(13892877025280L, 103510);
      return -1;
    }
    int i = paramString.length();
    GMTrace.o(13892877025280L, 103510);
    return i;
  }
  
  public static int PO(String paramString)
  {
    GMTrace.i(13893145460736L, 103512);
    if (mA(paramString))
    {
      GMTrace.o(13893145460736L, 103512);
      return 0;
    }
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime() / 1000L;
      int i = (int)l;
      GMTrace.o(13893145460736L, 103512);
      return i;
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      GMTrace.o(13893145460736L, 103512);
    }
    return 0;
  }
  
  public static int PP(String paramString)
  {
    GMTrace.i(13893816549376L, 103517);
    if (paramString == null)
    {
      GMTrace.o(13893816549376L, 103517);
      return 0;
    }
    try
    {
      long l = Long.decode(paramString).longValue();
      int i = (int)(l & 0xFFFFFFFF);
      GMTrace.o(13893816549376L, 103517);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      v.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      GMTrace.o(13893816549376L, 103517);
    }
    return 0;
  }
  
  public static String PQ(String paramString)
  {
    GMTrace.i(13894084984832L, 103519);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (str.length() <= 16)
    {
      paramString = g.n(str.getBytes());
      GMTrace.o(13894084984832L, 103519);
      return paramString;
    }
    paramString = g.n(str.substring(0, 16).getBytes());
    GMTrace.o(13894084984832L, 103519);
    return paramString;
  }
  
  public static String PR(String paramString)
  {
    GMTrace.i(15696360636416L, 116947);
    paramString = g.n(paramString.getBytes());
    GMTrace.o(15696360636416L, 116947);
    return paramString;
  }
  
  public static byte[] PS(String paramString)
  {
    GMTrace.i(13894621855744L, 103523);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13894621855744L, 103523);
      return new byte[0];
    }
    try
    {
      byte[] arrayOfByte = new byte[paramString.length() / 2];
      int i = 0;
      while (i < arrayOfByte.length)
      {
        arrayOfByte[i] = ((byte)(Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16) & 0xFF));
        i += 1;
      }
      GMTrace.o(13894621855744L, 103523);
      return arrayOfByte;
    }
    catch (NumberFormatException paramString)
    {
      v.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      GMTrace.o(13894621855744L, 103523);
    }
    return new byte[0];
  }
  
  public static int[] PT(String paramString)
  {
    GMTrace.i(13894756073472L, 103524);
    if (paramString == null)
    {
      GMTrace.o(13894756073472L, 103524);
      return null;
    }
    Object localObject = paramString.split(":");
    paramString = new ArrayList();
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = localObject[i];
        if ((str != null) && (str.length() > 0)) {}
        try
        {
          paramString.add(Integer.valueOf(Integer.valueOf(str).intValue()));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
            v.e("MicroMsg.Util", "invalid port num, ignore");
          }
        }
      }
    }
    localObject = new int[paramString.size()];
    i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((Integer)paramString.get(i)).intValue();
      i += 1;
    }
    GMTrace.o(13894756073472L, 103524);
    return (int[])localObject;
  }
  
  public static final String PU(String paramString)
  {
    GMTrace.i(13895024508928L, 103526);
    if (mA(paramString))
    {
      GMTrace.o(13895024508928L, 103526);
      return "";
    }
    try
    {
      String str = new URL(paramString).getHost();
      GMTrace.o(13895024508928L, 103526);
      return str;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      v.printErrStackTrace("MicroMsg.Util", localMalformedURLException, "", new Object[0]);
      v.w("MicroMsg.Util", "get host error");
      GMTrace.o(13895024508928L, 103526);
    }
    return paramString;
  }
  
  public static String PV(String paramString)
  {
    GMTrace.i(13895292944384L, 103528);
    if (paramString == null)
    {
      GMTrace.o(13895292944384L, 103528);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramString.length();
    int i = 0;
    if (i < n)
    {
      char c = paramString.charAt(i);
      int m = 1;
      int j = jmw.length - 1;
      for (;;)
      {
        int k = m;
        if (j >= 0)
        {
          if (jmw[j] == c)
          {
            localStringBuffer.append(jmx[j]);
            k = 0;
          }
        }
        else
        {
          if (k != 0) {
            localStringBuffer.append(c);
          }
          i += 1;
          break;
        }
        j -= 1;
      }
    }
    paramString = localStringBuffer.toString();
    GMTrace.o(13895292944384L, 103528);
    return paramString;
  }
  
  public static String PW(String paramString)
  {
    GMTrace.i(13895427162112L, 103529);
    if ((paramString == null) || (paramString.length() == 0))
    {
      GMTrace.o(13895427162112L, 103529);
      return paramString;
    }
    char[] arrayOfChar;
    int i;
    int j;
    int k;
    int m;
    if (Build.VERSION.SDK_INT < 8)
    {
      int i1 = paramString.length();
      arrayOfChar = new char[i1];
      int n = 0;
      i = 0;
      j = -1;
      if (n < i1)
      {
        char c = paramString.charAt(n);
        k = i + 1;
        arrayOfChar[i] = c;
        if ((c == '&') && (j == -1))
        {
          i = k;
          m = k;
        }
        do
        {
          do
          {
            do
            {
              do
              {
                n += 1;
                j = i;
                i = m;
                break;
                i = j;
                m = k;
              } while (j == -1);
              i = j;
              m = k;
            } while (Character.isLetter(c));
            i = j;
            m = k;
          } while (Character.isDigit(c));
          i = j;
          m = k;
        } while (c == '#');
        if (c == ';')
        {
          i = a(arrayOfChar, j, k - j - 1);
          if (i > 65535)
          {
            i -= 65536;
            arrayOfChar[(j - 1)] = ((char)((i >> 10) + 55296));
            arrayOfChar[j] = ((char)((i & 0x3FF) + 56320));
            i = j + 1;
          }
        }
      }
    }
    for (;;)
    {
      m = i;
      i = -1;
      break;
      if (i != 0)
      {
        arrayOfChar[(j - 1)] = ((char)i);
        i = j;
        continue;
        i = -1;
        m = k;
        break;
        paramString = new String(arrayOfChar, 0, i);
        GMTrace.o(13895427162112L, 103529);
        return paramString;
        GMTrace.o(13895427162112L, 103529);
        return paramString;
      }
      i = k;
    }
  }
  
  public static int PX(String paramString)
  {
    GMTrace.i(13895829815296L, 103532);
    int j = 0;
    try
    {
      i = Integer.parseInt(paramString);
      GMTrace.o(13895829815296L, 103532);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (paramString != null)
        {
          v.e("MicroMsg.Util", "parserInt error " + paramString);
          i = j;
        }
      }
    }
  }
  
  public static long PY(String paramString)
  {
    GMTrace.i(13895964033024L, 103533);
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      GMTrace.o(13895964033024L, 103533);
      return l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (paramString != null)
        {
          v.e("MicroMsg.Util", "parseLong error " + paramString);
          l1 = l2;
        }
      }
    }
  }
  
  public static double PZ(String paramString)
  {
    GMTrace.i(13896098250752L, 103534);
    double d2 = 0.0D;
    try
    {
      d1 = Double.parseDouble(paramString);
      GMTrace.o(13896098250752L, 103534);
      return d1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        double d1 = d2;
        if (paramString != null)
        {
          v.e("MicroMsg.Util", "parseDouble error " + paramString);
          d1 = d2;
        }
      }
    }
  }
  
  public static float Qa(String paramString)
  {
    GMTrace.i(18798937636864L, 140063);
    float f2 = 0.0F;
    try
    {
      f1 = Float.parseFloat(paramString);
      GMTrace.o(18798937636864L, 140063);
      return f1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f1 = f2;
        if (paramString != null)
        {
          v.e("MicroMsg.Util", "parseFloat error " + paramString);
          f1 = f2;
        }
      }
    }
  }
  
  public static byte[] Qb(String paramString)
  {
    GMTrace.i(13897440428032L, 103544);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.Util", "httpGet, url is null");
      GMTrace.o(13897440428032L, 103544);
      return null;
    }
    if (URLUtil.isDataUrl(paramString))
    {
      paramString = Qe(paramString);
      GMTrace.o(13897440428032L, 103544);
      return paramString;
    }
    if (URLUtil.isHttpsUrl(paramString))
    {
      paramString = Qd(paramString);
      GMTrace.o(13897440428032L, 103544);
      return paramString;
    }
    paramString = Qc(paramString);
    GMTrace.o(13897440428032L, 103544);
    return paramString;
  }
  
  private static byte[] Qc(String paramString)
  {
    GMTrace.i(13897574645760L, 103545);
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setRequestMethod("GET");
      int i = paramString.getResponseCode();
      if (i != 200)
      {
        v.e("MicroMsg.Util", "http get response code = %d", new Object[] { Integer.valueOf(i) });
        GMTrace.o(13897574645760L, 103545);
        return null;
      }
      paramString = new BufferedInputStream(paramString.getInputStream());
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['က'];
      for (i = paramString.read(arrayOfByte); i > 0; i = paramString.read(arrayOfByte)) {
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      paramString.close();
      localByteArrayOutputStream.close();
      GMTrace.o(13897574645760L, 103545);
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.Util", "http download failed : %s", new Object[] { paramString.getMessage() });
      GMTrace.o(13897574645760L, 103545);
    }
    return null;
  }
  
  private static byte[] Qd(String paramString)
  {
    GMTrace.i(13897708863488L, 103546);
    try
    {
      paramString = (HttpsURLConnection)new URL(paramString).openConnection();
      paramString.setRequestMethod("GET");
      int i = paramString.getResponseCode();
      if (i != 200)
      {
        v.e("MicroMsg.Util", "https get response code = %d", new Object[] { Integer.valueOf(i) });
        GMTrace.o(13897708863488L, 103546);
        return null;
      }
      paramString = new BufferedInputStream(paramString.getInputStream());
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['က'];
      for (i = paramString.read(arrayOfByte); i > 0; i = paramString.read(arrayOfByte)) {
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      paramString.close();
      localByteArrayOutputStream.close();
      GMTrace.o(13897708863488L, 103546);
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.Util", "getHttpsData failed : %s", new Object[] { paramString.getMessage() });
      GMTrace.o(13897708863488L, 103546);
    }
    return null;
  }
  
  private static byte[] Qe(String paramString)
  {
    GMTrace.i(13897843081216L, 103547);
    try
    {
      int i = paramString.indexOf("base64");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(i + 7);
      }
      paramString = Base64.decode(str, 0);
      GMTrace.o(13897843081216L, 103547);
      return paramString;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.Util", "decode base64 url failed : %s", new Object[] { paramString.getMessage() });
      GMTrace.o(13897843081216L, 103547);
    }
    return null;
  }
  
  public static String Qf(String paramString)
  {
    int i = 0;
    GMTrace.i(13898245734400L, 103550);
    if ((mA(paramString)) || (paramString.startsWith("+")))
    {
      GMTrace.o(13898245734400L, 103550);
      return "";
    }
    if (paramString.length() > 5)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString.subSequence(0, 3));
      if (i < paramString.length() - 5)
      {
        char c = paramString.charAt(i + 3);
        if ((c >= '0') && (c <= '9')) {
          localStringBuffer.append('*');
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuffer.append(c);
        }
      }
      localStringBuffer.append(paramString.charAt(paramString.length() - 2));
      localStringBuffer.append(paramString.charAt(paramString.length() - 1));
      paramString = localStringBuffer.toString();
      GMTrace.o(13898245734400L, 103550);
      return paramString;
    }
    GMTrace.o(13898245734400L, 103550);
    return paramString;
  }
  
  public static Boolean Qg(String paramString)
  {
    GMTrace.i(13898379952128L, 103551);
    Matcher localMatcher = Pattern.compile("^[+][0-9]{10,13}$").matcher(paramString);
    paramString = Pattern.compile("^1[0-9]{10}$").matcher(paramString);
    if ((localMatcher.matches()) || (paramString.matches())) {}
    for (boolean bool = true;; bool = false)
    {
      GMTrace.o(13898379952128L, 103551);
      return Boolean.valueOf(bool);
    }
  }
  
  public static String Qh(String paramString)
  {
    GMTrace.i(13898916823040L, 103555);
    if ((paramString != null) && (paramString.length() > 0))
    {
      int i = paramString.lastIndexOf("@");
      if (i != -1)
      {
        paramString = paramString.substring(0, i);
        GMTrace.o(13898916823040L, 103555);
        return paramString;
      }
    }
    GMTrace.o(13898916823040L, 103555);
    return paramString;
  }
  
  public static String Qi(String paramString)
  {
    GMTrace.i(13899185258496L, 103557);
    if (mA(paramString))
    {
      GMTrace.o(13899185258496L, 103557);
      return "";
    }
    int i = paramString.length();
    if (i < 4)
    {
      paramString = "*~" + i;
      GMTrace.o(13899185258496L, 103557);
      return paramString;
    }
    if (i < 8)
    {
      paramString = paramString.substring(0, 1) + "*" + paramString.substring(i - 2, i - 1) + "~" + i;
      GMTrace.o(13899185258496L, 103557);
      return paramString;
    }
    paramString = paramString.substring(0, 2) + "*" + paramString.substring(i - 3, i - 1) + "~" + i;
    GMTrace.o(13899185258496L, 103557);
    return paramString;
  }
  
  public static boolean Qj(String paramString)
  {
    GMTrace.i(13899990564864L, 103563);
    if (mA(paramString))
    {
      GMTrace.o(13899990564864L, 103563);
      return false;
    }
    try
    {
      paramString = new File(paramString).getCanonicalPath();
      if (paramString.contains("/com.tencent.mm/cache/"))
      {
        GMTrace.o(13899990564864L, 103563);
        return true;
      }
    }
    catch (IOException paramString)
    {
      GMTrace.o(13899990564864L, 103563);
      return false;
    }
    if (!paramString.contains("/com.tencent.mm/"))
    {
      GMTrace.o(13899990564864L, 103563);
      return true;
    }
    GMTrace.o(13899990564864L, 103563);
    return false;
  }
  
  public static boolean Qk(String paramString)
  {
    GMTrace.i(13900124782592L, 103564);
    if (mA(paramString))
    {
      GMTrace.o(13900124782592L, 103564);
      return false;
    }
    int i = paramString.lastIndexOf(".");
    if (i == -1)
    {
      GMTrace.o(13900124782592L, 103564);
      return false;
    }
    boolean bool = Ql(paramString.substring(i + 1));
    GMTrace.o(13900124782592L, 103564);
    return bool;
  }
  
  public static boolean Ql(String paramString)
  {
    GMTrace.i(13900259000320L, 103565);
    if (mA(paramString))
    {
      GMTrace.o(13900259000320L, 103565);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.equals("webp")) && (Build.VERSION.SDK_INT >= 14))
    {
      GMTrace.o(13900259000320L, 103565);
      return true;
    }
    if ((paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("jpeg")) || (paramString.equals("png")))
    {
      GMTrace.o(13900259000320L, 103565);
      return true;
    }
    GMTrace.o(13900259000320L, 103565);
    return false;
  }
  
  public static String Qm(String paramString)
  {
    GMTrace.i(13901735395328L, 103576);
    if (mA(paramString))
    {
      GMTrace.o(13901735395328L, 103576);
      return paramString;
    }
    paramString = paramString.replaceAll("‮", "");
    GMTrace.o(13901735395328L, 103576);
    return paramString;
  }
  
  public static final String Qn(String paramString)
  {
    GMTrace.i(13902003830784L, 103578);
    if (mA(paramString))
    {
      GMTrace.o(13902003830784L, 103578);
      return null;
    }
    paramString = Uri.parse(paramString).getHost();
    GMTrace.o(13902003830784L, 103578);
    return paramString;
  }
  
  public static String U(float paramFloat)
  {
    GMTrace.i(13900930088960L, 103570);
    if (paramFloat < 1024.0F)
    {
      str = String.format("%.1fB", new Object[] { Float.valueOf(paramFloat) });
      GMTrace.o(13900930088960L, 103570);
      return str;
    }
    if (paramFloat < 1048576.0F)
    {
      str = String.format("%.1fKB", new Object[] { Float.valueOf(paramFloat / 1024.0F) });
      GMTrace.o(13900930088960L, 103570);
      return str;
    }
    if (paramFloat < 1.07374182E9F)
    {
      str = String.format("%.1fMB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F) });
      GMTrace.o(13900930088960L, 103570);
      return str;
    }
    String str = String.format("%.1fGB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F / 1024.0F) });
    GMTrace.o(13900930088960L, 103570);
    return str;
  }
  
  public static int a(Integer paramInteger, int paramInt)
  {
    GMTrace.i(13891266412544L, 103498);
    if (paramInteger == null)
    {
      GMTrace.o(13891266412544L, 103498);
      return paramInt;
    }
    paramInt = paramInteger.intValue();
    GMTrace.o(13891266412544L, 103498);
    return paramInt;
  }
  
  private static int a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    GMTrace.i(13895561379840L, 103530);
    if (paramInt2 <= 0)
    {
      GMTrace.o(13895561379840L, 103530);
      return 0;
    }
    if (paramArrayOfChar[paramInt1] == '#')
    {
      if ((paramInt2 > 1) && ((paramArrayOfChar[(paramInt1 + 1)] == 'x') || (paramArrayOfChar[(paramInt1 + 1)] == 'X'))) {
        try
        {
          paramInt1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 2, paramInt2 - 2), 16);
          GMTrace.o(13895561379840L, 103530);
          return paramInt1;
        }
        catch (NumberFormatException paramArrayOfChar)
        {
          GMTrace.o(13895561379840L, 103530);
          return 0;
        }
      }
      try
      {
        paramInt1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 1, paramInt2 - 1), 10);
        GMTrace.o(13895561379840L, 103530);
        return paramInt1;
      }
      catch (NumberFormatException paramArrayOfChar)
      {
        GMTrace.o(13895561379840L, 103530);
        return 0;
      }
    }
    new String(paramArrayOfChar, paramInt1, paramInt2);
    GMTrace.o(13895561379840L, 103530);
    return 0;
  }
  
  public static long a(Long paramLong, long paramLong1)
  {
    GMTrace.i(13891534848000L, 103500);
    if (paramLong == null)
    {
      GMTrace.o(13891534848000L, 103500);
      return paramLong1;
    }
    paramLong1 = paramLong.longValue();
    GMTrace.o(13891534848000L, 103500);
    return paramLong1;
  }
  
  public static String a(long paramLong, double paramDouble)
  {
    GMTrace.i(13886031921152L, 103459);
    paramDouble = Math.round(paramLong * paramDouble / 1048576.0D) / paramDouble;
    String str = paramDouble + " MB";
    GMTrace.o(13886031921152L, 103459);
    return str;
  }
  
  private static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    GMTrace.i(13899587911680L, 103560);
    try
    {
      paramUri = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, paramString, paramArrayOfString, null);
      int i;
      if ((paramUri == null) || (paramUri != null)) {
        paramUri.close();
      }
    }
    finally
    {
      try
      {
        if (paramUri.moveToFirst())
        {
          i = paramUri.getColumnIndex("_data");
          if (i == -1)
          {
            v.e("MicroMsg.Util", "getDataColumn : columnIdx is -1, column with columnName = _data does not exist");
            paramUri.close();
            if (paramUri != null) {
              paramUri.close();
            }
            GMTrace.o(13899587911680L, 103560);
            return null;
          }
          paramContext = paramUri.getString(i);
          if (paramUri != null) {
            paramUri.close();
          }
          GMTrace.o(13899587911680L, 103560);
          return paramContext;
        }
        if (paramUri != null) {
          paramUri.close();
        }
        GMTrace.o(13899587911680L, 103560);
        return null;
      }
      finally
      {
        for (;;) {}
      }
      paramContext = finally;
      paramUri = (Uri)localObject;
    }
    throw paramContext;
  }
  
  public static String a(LinkedHashMap<String, String> paramLinkedHashMap)
  {
    GMTrace.i(13895695597568L, 103531);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<key>");
    Iterator localIterator = paramLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramLinkedHashMap = (Map.Entry)localIterator.next();
      Object localObject1 = paramLinkedHashMap.getKey();
      Object localObject2 = paramLinkedHashMap.getValue();
      paramLinkedHashMap = (LinkedHashMap<String, String>)localObject1;
      if (localObject1 == null) {
        paramLinkedHashMap = "unknow";
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "unknow";
      }
      localStringBuilder.append("<" + paramLinkedHashMap + ">");
      localStringBuilder.append(localObject1);
      localStringBuilder.append("</" + paramLinkedHashMap + ">");
    }
    localStringBuilder.append("</key>");
    paramLinkedHashMap = localStringBuilder.toString();
    GMTrace.o(13895695597568L, 103531);
    return paramLinkedHashMap;
  }
  
  public static long aA(long paramLong)
  {
    GMTrace.i(13887910969344L, 103473);
    long l = System.currentTimeMillis();
    GMTrace.o(13887910969344L, 103473);
    return l - paramLong;
  }
  
  public static long aB(long paramLong)
  {
    GMTrace.i(13888045187072L, 103474);
    long l = SystemClock.elapsedRealtime();
    GMTrace.o(13888045187072L, 103474);
    return l - paramLong;
  }
  
  public static int aE(byte[] paramArrayOfByte)
  {
    GMTrace.i(13901869613056L, 103577);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    int i = paramArrayOfByte.getInt();
    GMTrace.o(13901869613056L, 103577);
    return i;
  }
  
  public static int aF(String paramString, int paramInt)
  {
    GMTrace.i(13903480225792L, 103589);
    try
    {
      int i = Color.parseColor(paramString);
      GMTrace.o(13903480225792L, 103589);
      return i;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.Util", localException, "colorString:%s", new Object[] { paramString });
      GMTrace.o(13903480225792L, 103589);
    }
    return paramInt;
  }
  
  public static ActivityManager.RunningTaskInfo aa(Context paramContext, int paramInt)
  {
    GMTrace.i(13900795871232L, 103569);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1000).iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)paramContext.next();
      if (localRunningTaskInfo.id == paramInt)
      {
        GMTrace.o(13900795871232L, 103569);
        return localRunningTaskInfo;
      }
    }
    GMTrace.o(13900795871232L, 103569);
    return null;
  }
  
  public static String ap(String paramString1, String paramString2)
  {
    GMTrace.i(13891803283456L, 103502);
    if (paramString1 == null)
    {
      GMTrace.o(13891803283456L, 103502);
      return paramString2;
    }
    GMTrace.o(13891803283456L, 103502);
    return paramString1;
  }
  
  public static String ay(long paramLong)
  {
    GMTrace.i(13885897703424L, 103458);
    if (paramLong >> 30 > 0L)
    {
      str = b(paramLong, 10.0D);
      GMTrace.o(13885897703424L, 103458);
      return str;
    }
    if (paramLong >> 20 > 0L)
    {
      str = a(paramLong, 10.0D);
      GMTrace.o(13885897703424L, 103458);
      return str;
    }
    if (paramLong >> 9 > 0L)
    {
      double d = Math.round(paramLong * 10.0D / 1024.0D) / 10.0D;
      str = d + " KB";
      GMTrace.o(13885897703424L, 103458);
      return str;
    }
    String str = paramLong + " B";
    GMTrace.o(13885897703424L, 103458);
    return str;
  }
  
  public static long az(long paramLong)
  {
    GMTrace.i(13887776751616L, 103472);
    long l = System.currentTimeMillis() / 1000L;
    GMTrace.o(13887776751616L, 103472);
    return l - paramLong;
  }
  
  public static String b(long paramLong, double paramDouble)
  {
    GMTrace.i(13886300356608L, 103461);
    paramDouble = Math.round(paramLong * paramDouble / 1.073741824E9D) / paramDouble;
    String str = paramDouble + " GB";
    GMTrace.o(13886300356608L, 103461);
    return str;
  }
  
  public static boolean b(Boolean paramBoolean, boolean paramBoolean1)
  {
    GMTrace.i(13891669065728L, 103501);
    if (paramBoolean == null)
    {
      GMTrace.o(13891669065728L, 103501);
      return paramBoolean1;
    }
    paramBoolean1 = paramBoolean.booleanValue();
    GMTrace.o(13891669065728L, 103501);
    return paramBoolean1;
  }
  
  public static byte[] bJG()
  {
    GMTrace.i(13883884437504L, 103443);
    try
    {
      FileInputStream localFileInputStream = new FileInputStream("/dev/urandom");
      byte[] arrayOfByte = new byte[16];
      int i = localFileInputStream.read(arrayOfByte);
      localFileInputStream.close();
      if (i == 16)
      {
        GMTrace.o(13883884437504L, 103443);
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
      Object localObject = UUID.randomUUID();
      localObject = g.o((((UUID)localObject).toString() + System.currentTimeMillis()).getBytes());
      GMTrace.o(13883884437504L, 103443);
      return (byte[])localObject;
    }
  }
  
  public static boolean bJH()
  {
    GMTrace.i(13884018655232L, 103444);
    int i = new GregorianCalendar().get(11);
    if ((i >= 6L) && (i < 18L))
    {
      GMTrace.o(13884018655232L, 103444);
      return true;
    }
    GMTrace.o(13884018655232L, 103444);
    return false;
  }
  
  public static String bJI()
  {
    GMTrace.i(13884152872960L, 103445);
    Object localObject = TimeZone.getDefault();
    int j = ((TimeZone)localObject).getRawOffset() / 1000;
    if ((((TimeZone)localObject).useDaylightTime()) && (((TimeZone)localObject).inDaylightTime(new java.sql.Date(System.currentTimeMillis())))) {}
    for (int i = 1;; i = 0)
    {
      localObject = String.format("%.2f", new Object[] { Double.valueOf(j / 3600.0D + i) });
      GMTrace.o(13884152872960L, 103445);
      return (String)localObject;
    }
  }
  
  public static long bJJ()
  {
    GMTrace.i(13888313622528L, 103476);
    long l = System.currentTimeMillis() / 86400000L;
    GMTrace.o(13888313622528L, 103476);
    return l * 86400000L;
  }
  
  public static long bJK()
  {
    GMTrace.i(13888447840256L, 103477);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    long l = localCalendar.getTimeInMillis();
    GMTrace.o(13888447840256L, 103477);
    return l;
  }
  
  public static long bJL()
  {
    GMTrace.i(13888850493440L, 103480);
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      if (Build.VERSION.SDK_INT < 18)
      {
        l1 = localStatFs.getBlockSize();
        int i = localStatFs.getAvailableBlocks();
        l2 = i;
        GMTrace.o(13888850493440L, 103480);
        return l2 * l1;
      }
      long l1 = localStatFs.getBlockSizeLong();
      long l2 = localStatFs.getAvailableBlocksLong();
      GMTrace.o(13888850493440L, 103480);
      return l2 * l1;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.Util", "getDataAvailableSize exception:%s", new Object[] { localException.getMessage() });
      GMTrace.o(13888850493440L, 103480);
    }
    return 0L;
  }
  
  public static String bJM()
  {
    GMTrace.i(13889387364352L, 103484);
    Object localObject = (TelephonyManager)aa.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getSimCountryIso();
      if (mA((String)localObject))
      {
        GMTrace.o(13889387364352L, 103484);
        return "";
      }
      localObject = ((String)localObject).toUpperCase().trim();
      GMTrace.o(13889387364352L, 103484);
      return (String)localObject;
    }
    GMTrace.o(13889387364352L, 103484);
    return "";
  }
  
  public static boolean bJN()
  {
    GMTrace.i(13897037774848L, 103541);
    Object localObject1 = u.e(aa.getContext().getSharedPreferences(aa.bIN(), 0));
    Object localObject2 = u.bID();
    if (((String)localObject1).equals("language_default")) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!((String)localObject1).equals("zh_CN"))
      {
        GMTrace.o(13897037774848L, 103541);
        return true;
      }
      localObject1 = TimeZone.getDefault();
      localObject2 = TimeZone.getTimeZone("GMT+08:00");
      if (((TimeZone)localObject1).getRawOffset() != ((TimeZone)localObject2).getRawOffset())
      {
        GMTrace.o(13897037774848L, 103541);
        return true;
      }
      localObject1 = (TelephonyManager)aa.getContext().getSystemService("phone");
      if (localObject1 != null)
      {
        localObject1 = ((TelephonyManager)localObject1).getNetworkCountryIso();
        if ((!mA((String)localObject1)) && (!((String)localObject1).contains("cn")) && (!((String)localObject1).contains("CN")))
        {
          GMTrace.o(13897037774848L, 103541);
          return true;
        }
      }
      GMTrace.o(13897037774848L, 103541);
      return false;
    }
  }
  
  public static View.OnTouchListener bJO()
  {
    GMTrace.i(13897306210304L, 103543);
    View.OnTouchListener local1 = new View.OnTouchListener()
    {
      public final boolean onTouch(final View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(13910996418560L, 103645);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          GMTrace.o(13910996418560L, 103645);
          return false;
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(13940121665536L, 103862);
              paramAnonymousView.setPressed(false);
              GMTrace.o(13940121665536L, 103862);
            }
          });
          continue;
          paramAnonymousView.setPressed(true);
        }
      }
    };
    GMTrace.o(13897306210304L, 103543);
    return local1;
  }
  
  public static ag bJP()
  {
    GMTrace.i(13898648387584L, 103553);
    ag localag = new ag();
    GMTrace.o(13898648387584L, 103553);
    return localag;
  }
  
  public static int bJQ()
  {
    GMTrace.i(13899453693952L, 103559);
    int i = new Random().nextInt();
    GMTrace.o(13899453693952L, 103559);
    return i;
  }
  
  public static String bJR()
  {
    GMTrace.i(13901466959872L, 103574);
    Object localObject = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 16)
    {
      localStringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(((Random)localObject).nextInt(62)));
      i += 1;
    }
    localObject = localStringBuffer.toString();
    GMTrace.o(13901466959872L, 103574);
    return (String)localObject;
  }
  
  public static boolean bJS()
  {
    GMTrace.i(13902138048512L, 103579);
    String str = System.getProperty("java.vm.version");
    if ((!mA(str)) && (str.startsWith("2")))
    {
      GMTrace.o(13902138048512L, 103579);
      return true;
    }
    GMTrace.o(13902138048512L, 103579);
    return false;
  }
  
  /* Error */
  private static List<String> bJT()
  {
    // Byte code:
    //   0: ldc2_w 1262
    //   3: ldc_w 1264
    //   6: invokestatic 31	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 515	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 516	java/util/ArrayList:<init>	()V
    //   16: astore_3
    //   17: invokestatic 1270	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   20: ldc_w 1272
    //   23: invokevirtual 1276	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   26: astore_2
    //   27: new 1278	java/io/LineNumberReader
    //   30: dup
    //   31: new 1280	java/io/InputStreamReader
    //   34: dup
    //   35: aload_2
    //   36: invokevirtual 1283	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   39: invokespecial 1284	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 1287	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 1290	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   52: astore 4
    //   54: aload 4
    //   56: ifnull +92 -> 148
    //   59: aload_1
    //   60: astore_0
    //   61: aload 4
    //   63: invokevirtual 368	java/lang/String:length	()I
    //   66: ifle -20 -> 46
    //   69: aload_1
    //   70: astore_0
    //   71: aload_3
    //   72: aload 4
    //   74: invokeinterface 530 2 0
    //   79: pop
    //   80: goto -34 -> 46
    //   83: astore_2
    //   84: aload_1
    //   85: astore_0
    //   86: ldc -109
    //   88: ldc_w 1292
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_2
    //   98: invokevirtual 696	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: aastore
    //   102: invokestatic 673	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 1293	java/io/LineNumberReader:close	()V
    //   113: ldc -109
    //   115: ldc_w 1295
    //   118: iconst_1
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_3
    //   125: invokeinterface 535 1 0
    //   130: invokestatic 525	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: invokestatic 305	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: ldc2_w 1262
    //   140: ldc_w 1264
    //   143: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   146: aload_3
    //   147: areturn
    //   148: aload_1
    //   149: astore_0
    //   150: aload_2
    //   151: invokevirtual 1298	java/lang/Process:waitFor	()I
    //   154: pop
    //   155: aload_1
    //   156: astore_0
    //   157: aload_2
    //   158: invokevirtual 1301	java/lang/Process:destroy	()V
    //   161: aload_1
    //   162: invokevirtual 1293	java/io/LineNumberReader:close	()V
    //   165: goto -52 -> 113
    //   168: astore_0
    //   169: ldc -109
    //   171: ldc_w 1303
    //   174: iconst_1
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_0
    //   181: invokevirtual 696	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   184: aastore
    //   185: invokestatic 673	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: goto -75 -> 113
    //   191: astore_0
    //   192: ldc -109
    //   194: ldc_w 1303
    //   197: iconst_1
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload_0
    //   204: invokevirtual 696	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   207: aastore
    //   208: invokestatic 673	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: goto -98 -> 113
    //   214: astore_1
    //   215: aconst_null
    //   216: astore_0
    //   217: aload_0
    //   218: ifnull +7 -> 225
    //   221: aload_0
    //   222: invokevirtual 1293	java/io/LineNumberReader:close	()V
    //   225: aload_1
    //   226: athrow
    //   227: astore_0
    //   228: ldc -109
    //   230: ldc_w 1303
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_0
    //   240: invokevirtual 696	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   243: aastore
    //   244: invokestatic 673	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: goto -22 -> 225
    //   250: astore_1
    //   251: goto -34 -> 217
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_1
    //   257: goto -173 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	110	0	localLineNumberReader1	java.io.LineNumberReader
    //   168	13	0	localException1	Exception
    //   191	13	0	localException2	Exception
    //   216	6	0	localObject1	Object
    //   227	13	0	localException3	Exception
    //   45	117	1	localLineNumberReader2	java.io.LineNumberReader
    //   214	12	1	localObject2	Object
    //   250	1	1	localObject3	Object
    //   256	1	1	localObject4	Object
    //   26	10	2	localProcess	Process
    //   83	75	2	localException4	Exception
    //   254	1	2	localException5	Exception
    //   16	131	3	localArrayList	ArrayList
    //   52	21	4	str	String
    // Exception table:
    //   from	to	target	type
    //   48	54	83	java/lang/Exception
    //   61	69	83	java/lang/Exception
    //   71	80	83	java/lang/Exception
    //   150	155	83	java/lang/Exception
    //   157	161	83	java/lang/Exception
    //   161	165	168	java/lang/Exception
    //   109	113	191	java/lang/Exception
    //   17	46	214	finally
    //   221	225	227	java/lang/Exception
    //   48	54	250	finally
    //   61	69	250	finally
    //   71	80	250	finally
    //   86	105	250	finally
    //   150	155	250	finally
    //   157	161	250	finally
    //   17	46	254	java/lang/Exception
  }
  
  public static boolean bJU()
  {
    GMTrace.i(13902943354880L, 103585);
    if (f.fuN == 1)
    {
      GMTrace.o(13902943354880L, 103585);
      return true;
    }
    GMTrace.o(13902943354880L, 103585);
    return false;
  }
  
  public static int bJV()
  {
    GMTrace.i(13903077572608L, 103586);
    Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)aa.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
    {
      int i = arrayOfMemoryInfo[0].getTotalPss() / 1024;
      GMTrace.o(13903077572608L, 103586);
      return i;
    }
    GMTrace.o(13903077572608L, 103586);
    return 0;
  }
  
  public static String[] bU(List<String> paramList)
  {
    GMTrace.i(13883616002048L, 103441);
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    GMTrace.o(13883616002048L, 103441);
    return arrayOfString;
  }
  
  public static boolean bV(List paramList)
  {
    GMTrace.i(13892205936640L, 103505);
    if ((paramList == null) || (paramList.size() == 0))
    {
      GMTrace.o(13892205936640L, 103505);
      return true;
    }
    GMTrace.o(13892205936640L, 103505);
    return false;
  }
  
  public static boolean ba(Context paramContext, String paramString)
  {
    GMTrace.i(13889790017536L, 103487);
    try
    {
      if ((paramString.equals("com.tencent.mm")) || (paramString.startsWith("com.tencent.mm:")) || (Build.VERSION.SDK_INT < 21))
      {
        v.i("MicroMsg.Util", "isProcessRunning, use ActivityManager. process = %s", new Object[] { paramString });
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if (paramContext == null)
        {
          GMTrace.o(13889790017536L, 103487);
          return false;
        }
        paramContext = paramContext.iterator();
      }
      while (paramContext.hasNext())
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localObject != null) && (((ActivityManager.RunningAppProcessInfo)localObject).processName != null) && (((ActivityManager.RunningAppProcessInfo)localObject).processName.equals(paramString)))
        {
          v.w("MicroMsg.Util", "process " + paramString + " is running");
          GMTrace.o(13889790017536L, 103487);
          return true;
          v.i("MicroMsg.Util", "isProcessRunning, use ps command. process = %s", new Object[] { paramString });
          paramContext = bJT().iterator();
          while (paramContext.hasNext())
          {
            localObject = (String)paramContext.next();
            v.d("MicroMsg.Util", "isProcessRunning, process command line = %s", new Object[] { localObject });
            if ((localObject != null) && (((String)localObject).contains(paramString)))
            {
              localObject = ((String)localObject).split("\\s+");
              int i = 0;
              while (i < localObject.length)
              {
                if (paramString.equals(localObject[i]))
                {
                  v.i("MicroMsg.Util", "process %s is running", new Object[] { paramString });
                  GMTrace.o(13889790017536L, 103487);
                  return true;
                }
                i += 1;
              }
            }
          }
        }
      }
      v.w("MicroMsg.Util", "process " + paramString + " is not running");
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      }
    }
    GMTrace.o(13889790017536L, 103487);
    return false;
  }
  
  public static String bk(Context paramContext)
  {
    GMTrace.i(13890058452992L, 103489);
    try
    {
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      GMTrace.o(13890058452992L, 103489);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      v.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      GMTrace.o(13890058452992L, 103489);
    }
    return "(null)";
  }
  
  public static String bk(byte[] paramArrayOfByte)
  {
    GMTrace.i(13886434574336L, 103462);
    paramArrayOfByte = A(paramArrayOfByte, 0);
    GMTrace.o(13886434574336L, 103462);
    return paramArrayOfByte;
  }
  
  public static String bl(byte[] paramArrayOfByte)
  {
    int i = 0;
    GMTrace.i(13886703009792L, 103464);
    if (paramArrayOfByte == null)
    {
      GMTrace.o(13886703009792L, 103464);
      return "(null)";
    }
    char[] arrayOfChar1 = new char[16];
    char[] tmp35_33 = arrayOfChar1;
    tmp35_33[0] = 48;
    char[] tmp40_35 = tmp35_33;
    tmp40_35[1] = 49;
    char[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 50;
    char[] tmp50_45 = tmp45_40;
    tmp50_45[3] = 51;
    char[] tmp55_50 = tmp50_45;
    tmp55_50[4] = 52;
    char[] tmp60_55 = tmp55_50;
    tmp60_55[5] = 53;
    char[] tmp65_60 = tmp60_55;
    tmp65_60[6] = 54;
    char[] tmp71_65 = tmp65_60;
    tmp71_65[7] = 55;
    char[] tmp77_71 = tmp71_65;
    tmp77_71[8] = 56;
    char[] tmp83_77 = tmp77_71;
    tmp83_77[9] = 57;
    char[] tmp89_83 = tmp83_77;
    tmp89_83[10] = 97;
    char[] tmp95_89 = tmp89_83;
    tmp95_89[11] = 98;
    char[] tmp101_95 = tmp95_89;
    tmp101_95[12] = 99;
    char[] tmp107_101 = tmp101_95;
    tmp107_101[13] = 100;
    char[] tmp113_107 = tmp107_101;
    tmp113_107[14] = 101;
    char[] tmp119_113 = tmp113_107;
    tmp119_113[15] = 102;
    tmp119_113;
    int k = paramArrayOfByte.length;
    char[] arrayOfChar2 = new char[k * 3];
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = ' ';
      int i1 = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = i1 + 1;
      arrayOfChar2[i1] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar2);
    GMTrace.o(13886703009792L, 103464);
    return paramArrayOfByte;
  }
  
  public static boolean bm(byte[] paramArrayOfByte)
  {
    GMTrace.i(13892608589824L, 103508);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      GMTrace.o(13892608589824L, 103508);
      return true;
    }
    GMTrace.o(13892608589824L, 103508);
    return false;
  }
  
  public static int bn(byte[] paramArrayOfByte)
  {
    GMTrace.i(13893011243008L, 103511);
    if (paramArrayOfByte == null)
    {
      GMTrace.o(13893011243008L, 103511);
      return -1;
    }
    int i = paramArrayOfByte.length;
    GMTrace.o(13893011243008L, 103511);
    return i;
  }
  
  public static String bo(byte[] paramArrayOfByte)
  {
    GMTrace.i(13894487638016L, 103522);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(String.format("%02x", new Object[] { Integer.valueOf(paramArrayOfByte[i] & 0xFF) }));
        i += 1;
      }
    }
    paramArrayOfByte = localStringBuilder.toString();
    GMTrace.o(13894487638016L, 103522);
    return paramArrayOfByte;
  }
  
  public static boolean bp(Context paramContext)
  {
    GMTrace.i(13889521582080L, 103485);
    String str = paramContext.getClass().getName();
    paramContext = bk(paramContext);
    v.d("MicroMsg.Util", "top activity=" + paramContext + ", context=" + str);
    boolean bool = paramContext.equalsIgnoreCase(str);
    GMTrace.o(13889521582080L, 103485);
    return bool;
  }
  
  public static String bw(Object paramObject)
  {
    GMTrace.i(13890461106176L, 103492);
    if (paramObject != null)
    {
      paramObject = paramObject.toString();
      GMTrace.o(13890461106176L, 103492);
      return (String)paramObject;
    }
    GMTrace.o(13890461106176L, 103492);
    return "null";
  }
  
  public static long bx(Object paramObject)
  {
    GMTrace.i(13892071718912L, 103504);
    if (paramObject == null)
    {
      GMTrace.o(13892071718912L, 103504);
      return 0L;
    }
    if ((paramObject instanceof Long))
    {
      long l = ((Long)paramObject).longValue();
      GMTrace.o(13892071718912L, 103504);
      return l;
    }
    GMTrace.o(13892071718912L, 103504);
    return 0L;
  }
  
  public static long c(Long paramLong)
  {
    GMTrace.i(13890729541632L, 103494);
    if (paramLong == null)
    {
      GMTrace.o(13890729541632L, 103494);
      return 0L;
    }
    long l = paramLong.longValue();
    GMTrace.o(13890729541632L, 103494);
    return l;
  }
  
  public static String c(List<String> paramList, String paramString)
  {
    GMTrace.i(13883347566592L, 103439);
    if (paramList == null)
    {
      GMTrace.o(13883347566592L, 103439);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    if (i < paramList.size())
    {
      if (i == paramList.size() - 1) {
        localStringBuilder.append(((String)paramList.get(i)).trim());
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(((String)paramList.get(i)).trim() + paramString);
      }
    }
    paramList = localStringBuilder.toString();
    GMTrace.o(13883347566592L, 103439);
    return paramList;
  }
  
  public static boolean cV(View paramView)
  {
    GMTrace.i(13893950767104L, 103518);
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localInputMethodManager == null)
      {
        GMTrace.o(13893950767104L, 103518);
        return false;
      }
      bool = localInputMethodManager.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.Util", paramView, "", new Object[0]);
        v.e("MicroMsg.Util", "hide VKB exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
    v.v("MicroMsg.Util", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
    GMTrace.o(13893950767104L, 103518);
    return bool;
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    GMTrace.i(13894353420288L, 103521);
    paramInputStream = d.convertStreamToString(paramInputStream);
    GMTrace.o(13894353420288L, 103521);
    return paramInputStream;
  }
  
  public static void d(String paramString1, String paramString2, long paramLong)
  {
    GMTrace.i(13896366686208L, 103536);
    if (mA(paramString1))
    {
      GMTrace.o(13896366686208L, 103536);
      return;
    }
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) || (!paramString1.isDirectory()))
    {
      GMTrace.o(13896366686208L, 103536);
      return;
    }
    paramString1 = paramString1.listFiles();
    if ((paramString1 == null) || (paramString1.length == 0))
    {
      GMTrace.o(13896366686208L, 103536);
      return;
    }
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString1[i];
      if ((((File)localObject).isFile()) && (((File)localObject).getName().startsWith(paramString2)) && (System.currentTimeMillis() - ((File)localObject).lastModified() - paramLong >= 0L)) {
        ((File)localObject).delete();
      }
      i += 1;
    }
    GMTrace.o(13896366686208L, 103536);
  }
  
  public static int dM(int paramInt1, int paramInt2)
  {
    GMTrace.i(13883750219776L, 103442);
    if (paramInt1 > paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramInt1 = new Random(System.currentTimeMillis()).nextInt(paramInt1 - paramInt2 + 1);
      GMTrace.o(13883750219776L, 103442);
      return paramInt1 + paramInt2;
    }
  }
  
  public static boolean dN(int paramInt1, int paramInt2)
  {
    GMTrace.i(13902540701696L, 103582);
    if (paramInt1 == paramInt2)
    {
      GMTrace.o(13902540701696L, 103582);
      return true;
    }
    GMTrace.o(13902540701696L, 103582);
    return false;
  }
  
  public static boolean deleteFile(String paramString)
  {
    GMTrace.i(13896232468480L, 103535);
    if (mA(paramString))
    {
      GMTrace.o(13896232468480L, 103535);
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      GMTrace.o(13896232468480L, 103535);
      return true;
    }
    if (paramString.isDirectory())
    {
      GMTrace.o(13896232468480L, 103535);
      return false;
    }
    boolean bool = paramString.delete();
    GMTrace.o(13896232468480L, 103535);
    return bool;
  }
  
  public static boolean e(Boolean paramBoolean)
  {
    GMTrace.i(13890997977088L, 103496);
    if (paramBoolean == null)
    {
      GMTrace.o(13890997977088L, 103496);
      return true;
    }
    boolean bool = paramBoolean.booleanValue();
    GMTrace.o(13890997977088L, 103496);
    return bool;
  }
  
  /* Error */
  public static int eA(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc2_w 1550
    //   3: ldc_w 1552
    //   6: invokestatic 31	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 1554	java/util/zip/ZipInputStream
    //   12: dup
    //   13: new 1078	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 1081	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 1555	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore_0
    //   27: aload_3
    //   28: invokevirtual 1559	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +303 -> 338
    //   38: aload_3
    //   39: astore_0
    //   40: aload 4
    //   42: invokevirtual 1562	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   45: astore 5
    //   47: aload_3
    //   48: astore_0
    //   49: aload 5
    //   51: ldc_w 328
    //   54: invokevirtual 225	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   57: ifne -32 -> 25
    //   60: aload_3
    //   61: astore_0
    //   62: aload 5
    //   64: ldc_w 1564
    //   67: invokevirtual 225	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   70: ifne -45 -> 25
    //   73: aload_3
    //   74: astore_0
    //   75: aload 4
    //   77: invokevirtual 1565	java/util/zip/ZipEntry:isDirectory	()Z
    //   80: ifeq +96 -> 176
    //   83: aload_3
    //   84: astore_0
    //   85: aload 5
    //   87: iconst_0
    //   88: aload 5
    //   90: invokevirtual 368	java/lang/String:length	()I
    //   93: iconst_1
    //   94: isub
    //   95: invokevirtual 487	java/lang/String:substring	(II)Ljava/lang/String;
    //   98: astore 4
    //   100: aload_3
    //   101: astore_0
    //   102: new 430	java/io/File
    //   105: dup
    //   106: new 149	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 777	java/lang/StringBuilder:<init>	()V
    //   113: aload_1
    //   114: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: getstatic 1568	java/io/File:separator	Ljava/lang/String;
    //   120: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 4
    //   125: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 431	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 1571	java/io/File:mkdirs	()Z
    //   137: pop
    //   138: goto -113 -> 25
    //   141: astore_1
    //   142: aload_3
    //   143: astore_0
    //   144: ldc -109
    //   146: aload_1
    //   147: ldc_w 317
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 1572	java/util/zip/ZipInputStream:close	()V
    //   165: ldc2_w 1550
    //   168: ldc_w 1552
    //   171: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   174: iconst_m1
    //   175: ireturn
    //   176: aload_3
    //   177: astore_0
    //   178: new 430	java/io/File
    //   181: dup
    //   182: new 149	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 777	java/lang/StringBuilder:<init>	()V
    //   189: aload_1
    //   190: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: getstatic 1568	java/io/File:separator	Ljava/lang/String;
    //   196: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 5
    //   201: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokespecial 431	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: astore 4
    //   212: aload_3
    //   213: astore_0
    //   214: aload 4
    //   216: invokevirtual 1575	java/io/File:createNewFile	()Z
    //   219: pop
    //   220: aload_3
    //   221: astore_0
    //   222: new 1577	java/io/FileOutputStream
    //   225: dup
    //   226: aload 4
    //   228: invokespecial 1580	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   231: astore 4
    //   233: aload_3
    //   234: astore_0
    //   235: sipush 1024
    //   238: newarray <illegal type>
    //   240: astore 5
    //   242: aload_3
    //   243: astore_0
    //   244: aload_3
    //   245: aload 5
    //   247: invokevirtual 1581	java/util/zip/ZipInputStream:read	([B)I
    //   250: istore_2
    //   251: iload_2
    //   252: iconst_m1
    //   253: if_icmpeq +60 -> 313
    //   256: aload_3
    //   257: astore_0
    //   258: aload 4
    //   260: aload 5
    //   262: iconst_0
    //   263: iload_2
    //   264: invokevirtual 1582	java/io/FileOutputStream:write	([BII)V
    //   267: aload_3
    //   268: astore_0
    //   269: aload 4
    //   271: invokevirtual 1585	java/io/FileOutputStream:flush	()V
    //   274: goto -32 -> 242
    //   277: astore_1
    //   278: aload_3
    //   279: astore_0
    //   280: ldc -109
    //   282: aload_1
    //   283: ldc_w 317
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload_3
    //   294: ifnull +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 1572	java/util/zip/ZipInputStream:close	()V
    //   301: ldc2_w 1550
    //   304: ldc_w 1552
    //   307: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   310: bipush -2
    //   312: ireturn
    //   313: aload_3
    //   314: astore_0
    //   315: aload 4
    //   317: invokevirtual 1586	java/io/FileOutputStream:close	()V
    //   320: goto -295 -> 25
    //   323: astore_3
    //   324: aload_0
    //   325: astore_1
    //   326: aload_3
    //   327: astore_0
    //   328: aload_1
    //   329: ifnull +7 -> 336
    //   332: aload_1
    //   333: invokevirtual 1572	java/util/zip/ZipInputStream:close	()V
    //   336: aload_0
    //   337: athrow
    //   338: aload_3
    //   339: invokevirtual 1572	java/util/zip/ZipInputStream:close	()V
    //   342: ldc2_w 1550
    //   345: ldc_w 1552
    //   348: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   351: iconst_0
    //   352: ireturn
    //   353: astore_0
    //   354: ldc -109
    //   356: ldc_w 1588
    //   359: invokestatic 168	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: goto -20 -> 342
    //   365: astore_0
    //   366: ldc -109
    //   368: ldc_w 1588
    //   371: invokestatic 168	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: goto -209 -> 165
    //   377: astore_0
    //   378: ldc -109
    //   380: ldc_w 1588
    //   383: invokestatic 168	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: goto -85 -> 301
    //   389: astore_1
    //   390: ldc -109
    //   392: ldc_w 1588
    //   395: invokestatic 168	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: goto -62 -> 336
    //   401: astore_0
    //   402: aconst_null
    //   403: astore_1
    //   404: goto -76 -> 328
    //   407: astore_1
    //   408: aconst_null
    //   409: astore_3
    //   410: goto -132 -> 278
    //   413: astore_1
    //   414: aconst_null
    //   415: astore_3
    //   416: goto -274 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	paramString1	String
    //   0	419	1	paramString2	String
    //   250	14	2	i	int
    //   24	290	3	localZipInputStream	java.util.zip.ZipInputStream
    //   323	16	3	localObject1	Object
    //   409	7	3	localObject2	Object
    //   31	285	4	localObject3	Object
    //   45	216	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	141	java/io/FileNotFoundException
    //   40	47	141	java/io/FileNotFoundException
    //   49	60	141	java/io/FileNotFoundException
    //   62	73	141	java/io/FileNotFoundException
    //   75	83	141	java/io/FileNotFoundException
    //   85	100	141	java/io/FileNotFoundException
    //   102	138	141	java/io/FileNotFoundException
    //   178	212	141	java/io/FileNotFoundException
    //   214	220	141	java/io/FileNotFoundException
    //   222	233	141	java/io/FileNotFoundException
    //   235	242	141	java/io/FileNotFoundException
    //   244	251	141	java/io/FileNotFoundException
    //   258	267	141	java/io/FileNotFoundException
    //   269	274	141	java/io/FileNotFoundException
    //   315	320	141	java/io/FileNotFoundException
    //   27	33	277	java/io/IOException
    //   40	47	277	java/io/IOException
    //   49	60	277	java/io/IOException
    //   62	73	277	java/io/IOException
    //   75	83	277	java/io/IOException
    //   85	100	277	java/io/IOException
    //   102	138	277	java/io/IOException
    //   178	212	277	java/io/IOException
    //   214	220	277	java/io/IOException
    //   222	233	277	java/io/IOException
    //   235	242	277	java/io/IOException
    //   244	251	277	java/io/IOException
    //   258	267	277	java/io/IOException
    //   269	274	277	java/io/IOException
    //   315	320	277	java/io/IOException
    //   27	33	323	finally
    //   40	47	323	finally
    //   49	60	323	finally
    //   62	73	323	finally
    //   75	83	323	finally
    //   85	100	323	finally
    //   102	138	323	finally
    //   144	157	323	finally
    //   178	212	323	finally
    //   214	220	323	finally
    //   222	233	323	finally
    //   235	242	323	finally
    //   244	251	323	finally
    //   258	267	323	finally
    //   269	274	323	finally
    //   280	293	323	finally
    //   315	320	323	finally
    //   338	342	353	java/io/IOException
    //   161	165	365	java/io/IOException
    //   297	301	377	java/io/IOException
    //   332	336	389	java/io/IOException
    //   9	25	401	finally
    //   9	25	407	java/io/IOException
    //   9	25	413	java/io/FileNotFoundException
  }
  
  public static boolean eB(String paramString1, String paramString2)
  {
    GMTrace.i(13902406483968L, 103581);
    if ((mA(paramString1)) && (mA(paramString2)))
    {
      GMTrace.o(13902406483968L, 103581);
      return true;
    }
    if ((mA(paramString1)) && (!mA(paramString2)))
    {
      GMTrace.o(13902406483968L, 103581);
      return false;
    }
    if ((!mA(paramString1)) && (mA(paramString2)))
    {
      GMTrace.o(13902406483968L, 103581);
      return false;
    }
    boolean bool = paramString1.equals(paramString2);
    GMTrace.o(13902406483968L, 103581);
    return bool;
  }
  
  public static void el(Context paramContext)
  {
    GMTrace.i(13887239880704L, 103468);
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null)
    {
      GMTrace.o(13887239880704L, 103468);
      return;
    }
    paramContext.vibrate(uuz, -1);
    GMTrace.o(13887239880704L, 103468);
  }
  
  public static String em(Context paramContext)
  {
    GMTrace.i(13888716275712L, 103479);
    if (paramContext == null)
    {
      GMTrace.o(13888716275712L, 103479);
      return null;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        GMTrace.o(13888716275712L, 103479);
        return null;
      }
      paramContext = paramContext.getDeviceId();
      if (paramContext == null)
      {
        GMTrace.o(13888716275712L, 103479);
        return null;
      }
      paramContext = paramContext.trim();
      GMTrace.o(13888716275712L, 103479);
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      v.e("MicroMsg.Util", "getDeviceId failed, security exception");
      GMTrace.o(13888716275712L, 103479);
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      }
    }
  }
  
  public static long en(Context paramContext)
  {
    GMTrace.i(13888984711168L, 103481);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      GMTrace.o(13888984711168L, 103481);
      return 0L;
    }
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.availMem / 1024L / 1024L;
    GMTrace.o(13888984711168L, 103481);
    return l;
  }
  
  public static String eo(Context paramContext)
  {
    GMTrace.i(13889118928896L, 103482);
    if (paramContext == null)
    {
      GMTrace.o(13889118928896L, 103482);
      return null;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        v.e("MicroMsg.Util", "getLine1Number failed, null tm");
        GMTrace.o(13889118928896L, 103482);
        return null;
      }
      paramContext = paramContext.getLine1Number();
      GMTrace.o(13889118928896L, 103482);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.Util", "getLine1Number failed:%s ", new Object[] { ag.g(paramContext) });
      GMTrace.o(13889118928896L, 103482);
    }
    return null;
  }
  
  public static String ep(Context paramContext)
  {
    GMTrace.i(13896769339392L, 103539);
    if (paramContext == null)
    {
      GMTrace.o(13896769339392L, 103539);
      return null;
    }
    paramContext = j(paramContext.getPackageName(), paramContext);
    GMTrace.o(13896769339392L, 103539);
    return paramContext;
  }
  
  public static a eq(Context paramContext)
  {
    GMTrace.i(13900393218048L, 103566);
    paramContext = new a(paramContext);
    GMTrace.o(13900393218048L, 103566);
    return paramContext;
  }
  
  public static ComponentName er(Context paramContext)
  {
    GMTrace.i(13900527435776L, 103567);
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity;
        GMTrace.o(13900527435776L, 103567);
        return paramContext;
      }
      GMTrace.o(13900527435776L, 103567);
      return null;
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.Util", "get Top Activity Exception:%s", new Object[] { paramContext.getMessage() });
      GMTrace.o(13900527435776L, 103567);
    }
    return null;
  }
  
  public static String es(Context paramContext)
  {
    GMTrace.i(13900661653504L, 103568);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      String str;
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = paramContext.getAppTasks();
        if ((paramContext == null) || (paramContext.size() <= 0))
        {
          GMTrace.o(13900661653504L, 103568);
          return "";
        }
        paramContext = paramContext.iterator();
        if (paramContext.hasNext())
        {
          paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
          if (paramContext == null)
          {
            GMTrace.o(13900661653504L, 103568);
            return null;
          }
          str = paramContext.getClassName();
          paramContext = str;
          if (str.contains(".")) {
            paramContext = str.substring(str.lastIndexOf(".") + 1);
          }
          GMTrace.o(13900661653504L, 103568);
          return paramContext;
        }
      }
      else
      {
        str = ((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).topActivity.getClassName();
        paramContext = str;
        if (str.contains(".")) {
          paramContext = str.substring(str.lastIndexOf(".") + 1);
        }
        GMTrace.o(13900661653504L, 103568);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.Util", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), ag.g(paramContext) });
      GMTrace.o(13900661653504L, 103568);
    }
    return "";
  }
  
  public static Locale et(Context paramContext)
  {
    GMTrace.i(13901332742144L, 103573);
    Object localObject = u.d(paramContext.getSharedPreferences(aa.bIN(), 0));
    if (((String)localObject).equals("language_default"))
    {
      u.a(paramContext, Locale.ENGLISH);
      paramContext = Locale.getDefault();
      GMTrace.o(13901332742144L, 103573);
      return paramContext;
    }
    localObject = u.Pn((String)localObject);
    u.a(paramContext, (Locale)localObject);
    GMTrace.o(13901332742144L, 103573);
    return (Locale)localObject;
  }
  
  public static String eu(long paramLong)
  {
    GMTrace.i(13884287090688L, 103446);
    String str = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(paramLong));
    GMTrace.o(13884287090688L, 103446);
    return str;
  }
  
  public static String ev(long paramLong)
  {
    GMTrace.i(13884421308416L, 103447);
    String str = new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(1000L * paramLong));
    GMTrace.o(13884421308416L, 103447);
    return str;
  }
  
  public static String ew(long paramLong)
  {
    GMTrace.i(13886166138880L, 103460);
    String str = a(paramLong, 10.0D);
    GMTrace.o(13886166138880L, 103460);
    return str;
  }
  
  public static int ex(long paramLong)
  {
    GMTrace.i(13903614443520L, 103590);
    int i = Math.round((float)paramLong / 1000.0F);
    GMTrace.o(13903614443520L, 103590);
    return i;
  }
  
  public static int f(Integer paramInteger)
  {
    GMTrace.i(13890595323904L, 103493);
    if (paramInteger == null)
    {
      GMTrace.o(13890595323904L, 103493);
      return 0;
    }
    int i = paramInteger.intValue();
    GMTrace.o(13890595323904L, 103493);
    return i;
  }
  
  @TargetApi(19)
  public static String f(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    GMTrace.i(13899722129408L, 103561);
    if ((paramContext == null) || (paramUri == null))
    {
      v.e("MicroMsg.Util", "getFilePath : context is null or uri is null");
      GMTrace.o(13899722129408L, 103561);
      return null;
    }
    String str1 = paramUri.getScheme();
    if (mA(str1))
    {
      v.e("MicroMsg.Util", "input uri error. %s", new Object[] { paramUri });
      GMTrace.o(13899722129408L, 103561);
      return null;
    }
    if (str1.equalsIgnoreCase("file"))
    {
      v.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_FILE");
      paramContext = paramUri.getPath();
      GMTrace.o(13899722129408L, 103561);
      return paramContext;
    }
    if (str1.equalsIgnoreCase("content"))
    {
      v.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_CONTENT: " + paramUri.toString());
      if ("com.google.android.apps.photos.content".equals(paramUri.getAuthority()))
      {
        paramContext = paramUri.getLastPathSegment();
        GMTrace.o(13899722129408L, 103561);
        return paramContext;
      }
      String[] arrayOfString;
      try
      {
        paramContext.grantUriPermission(paramUri.getAuthority(), paramUri, 1);
        str1 = a(paramContext, paramUri, null, null);
        if (!mA(str1))
        {
          GMTrace.o(13899722129408L, 103561);
          return str1;
        }
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          v.e("MicroMsg.Util", "getFilePath : exception = " + localSecurityException);
          arrayOfString = null;
        }
        if (Build.VERSION.SDK_INT < 19) {
          break label506;
        }
      }
      if (DocumentsContract.isDocumentUri(paramContext, paramUri))
      {
        if ("com.android.externalstorage.documents".equals(paramUri.getAuthority()))
        {
          paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
          if ("primary".equalsIgnoreCase(paramContext[0]))
          {
            paramContext = Environment.getExternalStorageDirectory() + "/" + paramContext[1];
            GMTrace.o(13899722129408L, 103561);
            return paramContext;
          }
          GMTrace.o(13899722129408L, 103561);
          return null;
        }
        if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority()))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          paramContext = a(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
          GMTrace.o(13899722129408L, 103561);
          return paramContext;
        }
        if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
        {
          arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
          String str2 = arrayOfString[0];
          if ("image".equals(str2)) {
            paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
          }
          for (;;)
          {
            paramContext = a(paramContext, paramUri, "_id=?", new String[] { arrayOfString[1] });
            GMTrace.o(13899722129408L, 103561);
            return paramContext;
            if ("video".equals(str2))
            {
              paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            }
            else
            {
              paramUri = (Uri)localObject;
              if ("audio".equals(str2)) {
                paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
              }
            }
          }
        }
      }
    }
    label506:
    v.e("MicroMsg.Util", "unknown scheme");
    GMTrace.o(13899722129408L, 103561);
    return null;
  }
  
  public static List<String> f(String[] paramArrayOfString)
  {
    GMTrace.i(13883481784320L, 103440);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      GMTrace.o(13883481784320L, 103440);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localArrayList.add(paramArrayOfString[i]);
      i += 1;
    }
    GMTrace.o(13883481784320L, 103440);
    return localArrayList;
  }
  
  public static boolean f(char paramChar)
  {
    GMTrace.i(13884555526144L, 103448);
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    if ((localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS))
    {
      GMTrace.o(13884555526144L, 103448);
      return true;
    }
    GMTrace.o(13884555526144L, 103448);
    return false;
  }
  
  public static boolean f(Boolean paramBoolean)
  {
    GMTrace.i(13891132194816L, 103497);
    if (paramBoolean == null)
    {
      GMTrace.o(13891132194816L, 103497);
      return false;
    }
    boolean bool = paramBoolean.booleanValue();
    GMTrace.o(13891132194816L, 103497);
    return bool;
  }
  
  public static String formatNumber(String paramString)
  {
    GMTrace.i(13898514169856L, 103552);
    if (mA(paramString))
    {
      GMTrace.o(13898514169856L, 103552);
      return "";
    }
    paramString = paramString.replaceAll(",", "");
    if (paramString.length() <= 3)
    {
      GMTrace.o(13898514169856L, 103552);
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramString.length() - 1;
    while (i >= 0)
    {
      localStringBuffer.append(paramString.charAt(i));
      if (((paramString.length() - i) % 3 == 0) && (i != 0)) {
        localStringBuffer.append(",");
      }
      i -= 1;
    }
    paramString = localStringBuffer.reverse().toString();
    GMTrace.o(13898514169856L, 103552);
    return paramString;
  }
  
  public static String g(Throwable paramThrowable)
  {
    GMTrace.i(15696494854144L, 116948);
    paramThrowable = ag.g(paramThrowable);
    GMTrace.o(15696494854144L, 116948);
    return paramThrowable;
  }
  
  public static void g(Closeable paramCloseable)
  {
    GMTrace.i(13901198524416L, 103572);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      GMTrace.o(13901198524416L, 103572);
      return;
    }
    catch (IOException paramCloseable)
    {
      v.printErrStackTrace("MicroMsg.Util", paramCloseable, "qualityClose", new Object[0]);
      GMTrace.o(13901198524416L, 103572);
    }
  }
  
  public static double getDouble(String paramString, double paramDouble)
  {
    GMTrace.i(13893682331648L, 103516);
    if (paramString == null) {}
    try
    {
      GMTrace.o(13893682331648L, 103516);
      return paramDouble;
    }
    catch (NumberFormatException paramString)
    {
      double d;
      v.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      GMTrace.o(13893682331648L, 103516);
    }
    d = Double.parseDouble(paramString);
    GMTrace.o(13893682331648L, 103516);
    return d;
    return paramDouble;
  }
  
  public static float getFloat(String paramString, float paramFloat)
  {
    GMTrace.i(13893548113920L, 103515);
    if (paramString == null) {}
    try
    {
      GMTrace.o(13893548113920L, 103515);
      return paramFloat;
    }
    catch (NumberFormatException paramString)
    {
      float f;
      v.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      GMTrace.o(13893548113920L, 103515);
    }
    f = Float.parseFloat(paramString);
    GMTrace.o(13893548113920L, 103515);
    return f;
    return paramFloat;
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    GMTrace.i(13893279678464L, 103513);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        GMTrace.o(13893279678464L, 103513);
        return paramInt;
      }
      int i = Integer.decode(paramString).intValue();
      GMTrace.o(13893279678464L, 103513);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      v.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      GMTrace.o(13893279678464L, 103513);
    }
    return paramInt;
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    GMTrace.i(13893413896192L, 103514);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        GMTrace.o(13893413896192L, 103514);
        return paramLong;
      }
      long l = Long.decode(paramString).longValue();
      GMTrace.o(13893413896192L, 103514);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      v.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      GMTrace.o(13893413896192L, 103514);
    }
    return paramLong;
  }
  
  public static String ha(int paramInt)
  {
    GMTrace.i(13887508316160L, 103470);
    String str = String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
    GMTrace.o(13887508316160L, 103470);
    return str;
  }
  
  public static String i(String paramString, Object... paramVarArgs)
  {
    GMTrace.i(13903211790336L, 103587);
    try
    {
      paramVarArgs = String.format(paramString, paramVarArgs);
      paramString = paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        v.i("MicroMsg.Util", "error safeFormatString %s", new Object[] { paramVarArgs.getMessage() });
      }
    }
    GMTrace.o(13903211790336L, 103587);
    return paramString;
  }
  
  public static void i(String paramString, Context paramContext)
  {
    GMTrace.i(13886971445248L, 103466);
    paramContext.startActivity(PM(paramString));
    GMTrace.o(13886971445248L, 103466);
  }
  
  public static byte[] i(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    GMTrace.i(13891400630272L, 103499);
    if (paramArrayOfByte1 == null)
    {
      GMTrace.o(13891400630272L, 103499);
      return paramArrayOfByte2;
    }
    GMTrace.o(13891400630272L, 103499);
    return paramArrayOfByte1;
  }
  
  public static boolean isEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    GMTrace.i(13902809137152L, 103584);
    boolean bool = Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
    GMTrace.o(13902809137152L, 103584);
    return bool;
  }
  
  public static String j(String paramString, Context paramContext)
  {
    GMTrace.i(13896903557120L, 103540);
    if ((paramContext == null) || (mA(paramString)))
    {
      GMTrace.o(13896903557120L, 103540);
      return null;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 64).signatures[0].toByteArray();
      paramString = g.n(paramString);
      GMTrace.o(13896903557120L, 103540);
      return paramString;
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      GMTrace.o(13896903557120L, 103540);
    }
    return null;
  }
  
  public static void j(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(13901601177600L, 103575);
    Object localObject = new Rect();
    paramView.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= paramInt2;
    ((Rect)localObject).bottom += paramInt4;
    ((Rect)localObject).left -= paramInt1;
    ((Rect)localObject).right += paramInt3;
    localObject = new TouchDelegate((Rect)localObject, paramView);
    if (View.class.isInstance(paramView.getParent())) {
      ((View)paramView.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
    GMTrace.o(13901601177600L, 103575);
  }
  
  public static boolean j(char paramChar)
  {
    GMTrace.i(13884823961600L, 103450);
    if (((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z')))
    {
      GMTrace.o(13884823961600L, 103450);
      return true;
    }
    GMTrace.o(13884823961600L, 103450);
    return false;
  }
  
  public static boolean j(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(13890192670720L, 103490);
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      GMTrace.o(13890192670720L, 103490);
      return true;
    }
    GMTrace.o(13890192670720L, 103490);
    return false;
  }
  
  public static void k(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(13887105662976L, 103467);
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null)
    {
      v.w("MicroMsg.Util", "shake:vibrator is null!");
      GMTrace.o(13887105662976L, 103467);
      return;
    }
    if (paramBoolean)
    {
      paramContext.vibrate(ijF, -1);
      GMTrace.o(13887105662976L, 103467);
      return;
    }
    paramContext.cancel();
    GMTrace.o(13887105662976L, 103467);
  }
  
  public static boolean k(char paramChar)
  {
    GMTrace.i(13885092397056L, 103452);
    if ((paramChar >= '0') && (paramChar <= '9'))
    {
      GMTrace.o(13885092397056L, 103452);
      return true;
    }
    GMTrace.o(13885092397056L, 103452);
    return false;
  }
  
  public static String l(InputStream paramInputStream)
  {
    GMTrace.i(13898782605312L, 103554);
    if (paramInputStream == null)
    {
      GMTrace.o(13898782605312L, 103554);
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localStringBuffer.append(new String(arrayOfByte, 0, i));
      }
      try
      {
        paramInputStream.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      try
      {
        paramInputStream.close();
        for (;;)
        {
          paramInputStream = localStringBuffer.toString();
          GMTrace.o(13898782605312L, 103554);
          return paramInputStream;
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            v.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static boolean l(Uri paramUri)
  {
    GMTrace.i(13899856347136L, 103562);
    if (paramUri == null)
    {
      GMTrace.o(13899856347136L, 103562);
      return false;
    }
    if (!"file".equalsIgnoreCase(paramUri.getScheme()))
    {
      GMTrace.o(13899856347136L, 103562);
      return true;
    }
    boolean bool = Qj(paramUri.getPath());
    GMTrace.o(13899856347136L, 103562);
    return bool;
  }
  
  public static boolean mA(String paramString)
  {
    GMTrace.i(13892340154368L, 103506);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13892340154368L, 103506);
      return true;
    }
    GMTrace.o(13892340154368L, 103506);
    return false;
  }
  
  public static String my(String paramString)
  {
    GMTrace.i(13883079131136L, 103437);
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
    }
    GMTrace.o(13883079131136L, 103437);
    return str;
  }
  
  public static String mz(String paramString)
  {
    GMTrace.i(13890863759360L, 103495);
    if (paramString == null)
    {
      GMTrace.o(13890863759360L, 103495);
      return "";
    }
    GMTrace.o(13890863759360L, 103495);
    return paramString;
  }
  
  public static int n(Object paramObject, int paramInt)
  {
    GMTrace.i(13891937501184L, 103503);
    if (paramObject == null)
    {
      GMTrace.o(13891937501184L, 103503);
      return paramInt;
    }
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      GMTrace.o(13891937501184L, 103503);
      return paramInt;
    }
    if ((paramObject instanceof Long))
    {
      paramInt = ((Long)paramObject).intValue();
      GMTrace.o(13891937501184L, 103503);
      return paramInt;
    }
    GMTrace.o(13891937501184L, 103503);
    return paramInt;
  }
  
  public static String n(double paramDouble)
  {
    GMTrace.i(18799071854592L, 140064);
    String str = String.format("%.2f", new Object[] { Double.valueOf(paramDouble) });
    GMTrace.o(18799071854592L, 140064);
    return str;
  }
  
  public static String q(Context paramContext, int paramInt)
  {
    GMTrace.i(13889924235264L, 103488);
    paramContext = d.q(paramContext, paramInt);
    GMTrace.o(13889924235264L, 103488);
    return paramContext;
  }
  
  /* Error */
  public static boolean q(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc2_w 2095
    //   3: ldc_w 2097
    //   6: invokestatic 31	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: invokestatic 123	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   13: ifne +10 -> 23
    //   16: aload_1
    //   17: invokestatic 2099	com/tencent/mm/sdk/platformtools/bf:bm	([B)Z
    //   20: ifeq +22 -> 42
    //   23: ldc -109
    //   25: ldc_w 2101
    //   28: invokestatic 556	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc2_w 2095
    //   34: ldc_w 2097
    //   37: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   40: iconst_0
    //   41: ireturn
    //   42: new 1577	java/io/FileOutputStream
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 2102	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_2
    //   52: astore_0
    //   53: aload_2
    //   54: aload_1
    //   55: invokevirtual 2105	java/io/FileOutputStream:write	([B)V
    //   58: aload_2
    //   59: astore_0
    //   60: aload_2
    //   61: invokevirtual 1585	java/io/FileOutputStream:flush	()V
    //   64: aload_2
    //   65: invokevirtual 1586	java/io/FileOutputStream:close	()V
    //   68: ldc -109
    //   70: ldc_w 2107
    //   73: invokestatic 1440	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: ldc2_w 2095
    //   79: ldc_w 2097
    //   82: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_0
    //   88: ldc -109
    //   90: aload_0
    //   91: ldc_w 317
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: goto -33 -> 68
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_0
    //   109: ldc -109
    //   111: aload_3
    //   112: ldc_w 317
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_1
    //   123: astore_0
    //   124: ldc -109
    //   126: ldc_w 2109
    //   129: invokestatic 556	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 1586	java/io/FileOutputStream:close	()V
    //   140: ldc2_w 2095
    //   143: ldc_w 2097
    //   146: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore_0
    //   152: ldc -109
    //   154: aload_0
    //   155: ldc_w 317
    //   158: iconst_0
    //   159: anewarray 4	java/lang/Object
    //   162: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: goto -25 -> 140
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_0
    //   172: ifnull +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 1586	java/io/FileOutputStream:close	()V
    //   179: aload_1
    //   180: athrow
    //   181: astore_0
    //   182: ldc -109
    //   184: aload_0
    //   185: ldc_w 317
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: goto -16 -> 179
    //   198: astore_1
    //   199: goto -28 -> 171
    //   202: astore_3
    //   203: aload_2
    //   204: astore_1
    //   205: goto -98 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramString	String
    //   0	208	1	paramArrayOfByte	byte[]
    //   50	154	2	localFileOutputStream	java.io.FileOutputStream
    //   104	8	3	localException1	Exception
    //   202	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   64	68	87	java/io/IOException
    //   42	51	104	java/lang/Exception
    //   136	140	151	java/io/IOException
    //   42	51	168	finally
    //   175	179	181	java/io/IOException
    //   53	58	198	finally
    //   60	64	198	finally
    //   109	122	198	finally
    //   124	132	198	finally
    //   53	58	202	java/lang/Exception
    //   60	64	202	java/lang/Exception
  }
  
  public static boolean r(Object paramObject1, Object paramObject2)
  {
    boolean bool = true;
    GMTrace.i(13901064306688L, 103571);
    if (paramObject1 == paramObject2) {}
    for (;;)
    {
      GMTrace.o(13901064306688L, 103571);
      return bool;
      if ((paramObject1 == null) || (paramObject2 == null) || (!paramObject1.equals(paramObject2))) {
        bool = false;
      }
    }
  }
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 2117
    //   3: ldc_w 2119
    //   6: invokestatic 31	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: invokestatic 123	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   13: ifeq +22 -> 35
    //   16: ldc -109
    //   18: ldc_w 2121
    //   21: invokestatic 556	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc2_w 2117
    //   27: ldc_w 2119
    //   30: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   33: aconst_null
    //   34: areturn
    //   35: new 430	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 431	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_3
    //   44: aload_3
    //   45: invokevirtual 1509	java/io/File:exists	()Z
    //   48: ifne +30 -> 78
    //   51: ldc -109
    //   53: ldc_w 2123
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_0
    //   63: aastore
    //   64: invokestatic 2125	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: ldc2_w 2117
    //   70: ldc_w 2119
    //   73: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   76: aconst_null
    //   77: areturn
    //   78: aload_3
    //   79: invokevirtual 2127	java/io/File:length	()J
    //   82: l2i
    //   83: istore_1
    //   84: new 1078	java/io/FileInputStream
    //   87: dup
    //   88: aload_3
    //   89: invokespecial 2128	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   92: astore 4
    //   94: aload 4
    //   96: astore_3
    //   97: iload_1
    //   98: newarray <illegal type>
    //   100: astore 5
    //   102: aload 4
    //   104: astore_3
    //   105: aload 4
    //   107: aload 5
    //   109: invokevirtual 1082	java/io/FileInputStream:read	([B)I
    //   112: istore_2
    //   113: iload_2
    //   114: iload_1
    //   115: if_icmpeq +69 -> 184
    //   118: aload 4
    //   120: astore_3
    //   121: ldc -109
    //   123: ldc_w 2130
    //   126: iconst_3
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: iload_1
    //   137: invokestatic 525	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: dup
    //   142: iconst_2
    //   143: iload_2
    //   144: invokestatic 525	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: invokestatic 2125	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload 4
    //   153: invokevirtual 1083	java/io/FileInputStream:close	()V
    //   156: ldc2_w 2117
    //   159: ldc_w 2119
    //   162: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: ldc -109
    //   170: aload_0
    //   171: ldc_w 317
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: goto -25 -> 156
    //   184: aload 4
    //   186: astore_3
    //   187: ldc -109
    //   189: ldc_w 2132
    //   192: invokestatic 1440	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload 4
    //   197: invokevirtual 1083	java/io/FileInputStream:close	()V
    //   200: ldc2_w 2117
    //   203: ldc_w 2119
    //   206: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   209: aload 5
    //   211: areturn
    //   212: astore_0
    //   213: ldc -109
    //   215: aload_0
    //   216: ldc_w 317
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: goto -26 -> 200
    //   229: astore 5
    //   231: aconst_null
    //   232: astore_0
    //   233: aload_0
    //   234: astore_3
    //   235: ldc -109
    //   237: aload 5
    //   239: ldc_w 317
    //   242: iconst_0
    //   243: anewarray 4	java/lang/Object
    //   246: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: aload_0
    //   250: ifnull +7 -> 257
    //   253: aload_0
    //   254: invokevirtual 1083	java/io/FileInputStream:close	()V
    //   257: ldc2_w 2117
    //   260: ldc_w 2119
    //   263: invokestatic 86	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   266: aconst_null
    //   267: areturn
    //   268: astore_0
    //   269: ldc -109
    //   271: aload_0
    //   272: ldc_w 317
    //   275: iconst_0
    //   276: anewarray 4	java/lang/Object
    //   279: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: goto -25 -> 257
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_3
    //   288: aload_3
    //   289: ifnull +7 -> 296
    //   292: aload_3
    //   293: invokevirtual 1083	java/io/FileInputStream:close	()V
    //   296: aload_0
    //   297: athrow
    //   298: astore_3
    //   299: ldc -109
    //   301: aload_3
    //   302: ldc_w 317
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 321	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: goto -16 -> 296
    //   315: astore_0
    //   316: goto -28 -> 288
    //   319: astore 5
    //   321: aload 4
    //   323: astore_0
    //   324: goto -91 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramString	String
    //   83	54	1	i	int
    //   112	32	2	j	int
    //   43	250	3	localObject	Object
    //   298	4	3	localIOException	IOException
    //   92	230	4	localFileInputStream	FileInputStream
    //   100	110	5	arrayOfByte	byte[]
    //   229	9	5	localException1	Exception
    //   319	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   151	156	167	java/io/IOException
    //   195	200	212	java/io/IOException
    //   78	94	229	java/lang/Exception
    //   253	257	268	java/io/IOException
    //   78	94	285	finally
    //   292	296	298	java/io/IOException
    //   97	102	315	finally
    //   105	113	315	finally
    //   121	151	315	finally
    //   187	195	315	finally
    //   235	249	315	finally
    //   97	102	319	java/lang/Exception
    //   105	113	319	java/lang/Exception
    //   121	151	319	java/lang/Exception
    //   187	195	319	java/lang/Exception
  }
  
  public static List<ResolveInfo> u(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(13890326888448L, 103491);
    if ((paramContext == null) || (paramIntent == null))
    {
      GMTrace.o(13890326888448L, 103491);
      return null;
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    GMTrace.o(13890326888448L, 103491);
    return paramContext;
  }
  
  public static Intent v(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(13903346008064L, 103588);
    paramContext = paramContext.getPackageManager().queryIntentServices(paramIntent, 0);
    if ((paramContext == null) || (paramContext.size() != 1))
    {
      GMTrace.o(13903346008064L, 103588);
      return null;
    }
    Object localObject = (ResolveInfo)paramContext.get(0);
    paramContext = ((ResolveInfo)localObject).serviceInfo.packageName;
    localObject = ((ResolveInfo)localObject).serviceInfo.name;
    v.d("MicroMsg.Util", "createExplicitFromImplicitIntent pa:%s, cl:%s", new Object[] { paramContext, localObject });
    paramContext = new ComponentName(paramContext, (String)localObject);
    paramIntent = new Intent(paramIntent);
    paramIntent.setComponent(paramContext);
    GMTrace.o(13903346008064L, 103588);
    return paramIntent;
  }
  
  public static boolean w(long paramLong1, long paramLong2)
  {
    GMTrace.i(13888582057984L, 103478);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(5) == localCalendar2.get(5)) && (localCalendar1.get(2) == localCalendar2.get(2)))
    {
      GMTrace.o(13888582057984L, 103478);
      return true;
    }
    GMTrace.o(13888582057984L, 103478);
    return false;
  }
  
  public static boolean x(long paramLong1, long paramLong2)
  {
    GMTrace.i(13902674919424L, 103583);
    if (paramLong1 == paramLong2)
    {
      GMTrace.o(13902674919424L, 103583);
      return true;
    }
    GMTrace.o(13902674919424L, 103583);
    return false;
  }
  
  public static String za(String paramString)
  {
    GMTrace.i(13898111516672L, 103549);
    paramString = paramString.replaceAll("[\\.\\-]", "").trim();
    GMTrace.o(13898111516672L, 103549);
    return paramString;
  }
  
  public static final class a
  {
    private Context context;
    
    public a(Context paramContext)
    {
      GMTrace.i(13872341712896L, 103357);
      this.context = paramContext;
      GMTrace.o(13872341712896L, 103357);
    }
    
    public final String toString()
    {
      GMTrace.i(13872475930624L, 103358);
      Object localObject1 = this.context;
      if (localObject1 == null)
      {
        GMTrace.o(13872475930624L, 103358);
        return null;
      }
      Object localObject2 = (ActivityManager)((Context)localObject1).getSystemService("activity");
      localObject1 = ((Context)localObject1).getPackageName();
      if ((localObject2 == null) || (bf.mA((String)localObject1)))
      {
        GMTrace.o(13872475930624L, 103358);
        return null;
      }
      Object localObject3 = ((ActivityManager)localObject2).getRunningTasks(100);
      localObject2 = new StringBuffer();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)((Iterator)localObject3).next();
        if ((localRunningTaskInfo.baseActivity.getClassName().startsWith((String)localObject1)) || (localRunningTaskInfo.topActivity.getClassName().startsWith((String)localObject1))) {
          ((StringBuffer)localObject2).append(String.format("{id:%d num:%d/%d top:%s base:%s}", new Object[] { Integer.valueOf(localRunningTaskInfo.id), Integer.valueOf(localRunningTaskInfo.numRunning), Integer.valueOf(localRunningTaskInfo.numActivities), localRunningTaskInfo.topActivity.getShortClassName(), localRunningTaskInfo.baseActivity.getShortClassName() }));
        }
      }
      localObject1 = ((StringBuffer)localObject2).toString();
      GMTrace.o(13872475930624L, 103358);
      return (String)localObject1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */