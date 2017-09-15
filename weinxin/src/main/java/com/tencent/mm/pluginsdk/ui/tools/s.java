package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.smtt.sdk.WebView;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class s
{
  private static aq ihu;
  private static final Pattern sWf;
  private static final Map<String, String> sWg;
  private static final Map<String, String> sWh;
  
  static
  {
    GMTrace.i(1078707879936L, 8037);
    ihu = null;
    sWf = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("silk", "audio/silk"));
    ((ArrayList)localObject).add(new Pair("jpg", "image/jpg"));
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      localHashMap1.put(localPair.first, localPair.second);
      localHashMap2.put(localPair.second, localPair.first);
    }
    sWg = Collections.unmodifiableMap(localHashMap1);
    sWh = Collections.unmodifiableMap(localHashMap2);
    GMTrace.o(1078707879936L, 8037);
  }
  
  public static boolean Nn(String paramString)
  {
    GMTrace.i(1075352436736L, 8012);
    if (paramString == null)
    {
      GMTrace.o(1075352436736L, 8012);
      return false;
    }
    boolean bool = paramString.toLowerCase().contains(" MicroMessenger/".trim().toLowerCase());
    GMTrace.o(1075352436736L, 8012);
    return bool;
  }
  
  public static final String No(String paramString)
  {
    GMTrace.i(1076963049472L, 8024);
    if (!bf.mA(paramString)) {
      try
      {
        String str = URLEncoder.encode(paramString, "utf-8");
        GMTrace.o(1076963049472L, 8024);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
      }
    }
    GMTrace.o(1076963049472L, 8024);
    return paramString;
  }
  
  public static final String Np(String paramString)
  {
    GMTrace.i(1077097267200L, 8025);
    if (!bf.mA(paramString))
    {
      try
      {
        byte[] arrayOfByte = paramString.getBytes("utf-8");
        paramString = arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          paramString = paramString.getBytes();
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
        }
      }
      paramString = Base64.encodeToString(paramString, 2);
      GMTrace.o(1077097267200L, 8025);
      return paramString;
    }
    GMTrace.o(1077097267200L, 8025);
    return paramString;
  }
  
  public static String Nq(String paramString)
  {
    GMTrace.i(1077499920384L, 8028);
    if (bf.mA(paramString))
    {
      GMTrace.o(1077499920384L, 8028);
      return null;
    }
    if (!sWf.matcher(paramString).matches())
    {
      GMTrace.o(1077499920384L, 8028);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("base64,") + 7).trim();
    GMTrace.o(1077499920384L, 8028);
    return paramString;
  }
  
  public static Boolean Nr(String paramString)
  {
    GMTrace.i(1077768355840L, 8030);
    if ((paramString != null) && (paramString.startsWith("Refused to frame")))
    {
      paramString = paramString.split("'");
      if ((paramString.length > 1) && (paramString[1].equalsIgnoreCase("weixinpreinject://iframe")))
      {
        GMTrace.o(1077768355840L, 8030);
        return Boolean.valueOf(true);
      }
    }
    GMTrace.o(1077768355840L, 8030);
    return Boolean.valueOf(false);
  }
  
  public static Boolean Ns(String paramString)
  {
    GMTrace.i(1077902573568L, 8031);
    if ((paramString != null) && (paramString.startsWith("Refused to frame")))
    {
      paramString = paramString.split("'");
      if ((paramString.length > 1) && (paramString[1].equalsIgnoreCase("weixinping://iframe")))
      {
        GMTrace.o(1077902573568L, 8031);
        return Boolean.valueOf(true);
      }
    }
    GMTrace.o(1077902573568L, 8031);
    return Boolean.valueOf(false);
  }
  
  public static String Nt(String paramString)
  {
    GMTrace.i(1078036791296L, 8032);
    String str2 = "";
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.startsWith("Refused to frame"))
      {
        paramString = paramString.split("'");
        str1 = str2;
        if (paramString.length > 2) {
          str1 = paramString[1];
        }
      }
    }
    GMTrace.o(1078036791296L, 8032);
    return str1;
  }
  
  public static String Nu(String paramString)
  {
    GMTrace.i(1078171009024L, 8033);
    if (bf.mA(paramString))
    {
      GMTrace.o(1078171009024L, 8033);
      return null;
    }
    String str2 = (String)sWg.get(paramString.toLowerCase());
    String str1 = str2;
    if (bf.mA(str2))
    {
      str1 = str2;
      if (!bf.mA(paramString)) {
        str1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      }
    }
    GMTrace.o(1078171009024L, 8033);
    return str1;
  }
  
  public static String Nv(String paramString)
  {
    GMTrace.i(1078305226752L, 8034);
    paramString = Nu(Nw(paramString));
    GMTrace.o(1078305226752L, 8034);
    return paramString;
  }
  
  public static String Nw(String paramString)
  {
    GMTrace.i(1078439444480L, 8035);
    if (bf.mA(paramString))
    {
      GMTrace.o(1078439444480L, 8035);
      return null;
    }
    int i = paramString.lastIndexOf('.');
    if ((i < 0) || (i >= paramString.length() - 1))
    {
      GMTrace.o(1078439444480L, 8035);
      return null;
    }
    paramString = paramString.substring(i + 1);
    GMTrace.o(1078439444480L, 8035);
    return paramString;
  }
  
  public static String Nx(String paramString)
  {
    GMTrace.i(1078573662208L, 8036);
    if (bf.mA(paramString))
    {
      GMTrace.o(1078573662208L, 8036);
      return null;
    }
    String str2 = (String)sWh.get(paramString.toLowerCase());
    String str1 = str2;
    if (bf.mA(str2)) {
      str1 = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
    }
    GMTrace.o(1078573662208L, 8036);
    return str1;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    GMTrace.i(1075755089920L, 8015);
    if (ihu == null) {
      ihu = new aq(1, "webview-save-image", 1);
    }
    ihu.c(new c(paramContext, paramString1, paramString2, paramBoolean));
    GMTrace.o(1075755089920L, 8015);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, b paramb)
  {
    GMTrace.i(1075889307648L, 8016);
    if (ihu == null) {
      ihu = new aq(1, "webview-save-image", 1);
    }
    ihu.c(new c(paramContext, paramString1, paramString2, paramBoolean, 1, paramb));
    GMTrace.o(1075889307648L, 8016);
  }
  
  public static void a(WebView paramWebView)
  {
    GMTrace.i(1076023525376L, 8017);
    if (paramWebView == null)
    {
      GMTrace.o(1076023525376L, 8017);
      return;
    }
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUtil", "initPingIFrame");
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1067433590784L, 7953);
        this.sWi.evaluateJavascript("javascript:var ping_iframe = document.getElementById('ping_iframe');if (ping_iframe === null) {ping_iframe = document.createElement('iframe');ping_iframe.id = 'ping_iframe';ping_iframe.style.display = 'none';document.documentElement.appendChild(ping_iframe);ping_iframe.src = ' weixinping://iframe ' }", null);
        GMTrace.o(1067433590784L, 7953);
      }
    });
    GMTrace.o(1076023525376L, 8017);
  }
  
  public static void a(WebView paramWebView, String paramString1, String paramString2)
  {
    GMTrace.i(1076291960832L, 8019);
    a(paramWebView, paramString1, paramString2, true);
    GMTrace.o(1076291960832L, 8019);
  }
  
  public static void a(final WebView paramWebView, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    GMTrace.i(1076426178560L, 8020);
    if ((paramWebView == null) || (bf.mA(paramString1)) || (bf.mA(paramString2)))
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
      GMTrace.o(1076426178560L, 8020);
      return;
    }
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
    b(paramWebView);
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1138032115712L, 8479);
        if (this.sWj)
        {
          paramWebView.evaluateJavascript("javascript:document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2, null);
          GMTrace.o(1138032115712L, 8479);
          return;
        }
        paramWebView.evaluateJavascript("javascript:console.log('" + paramString1 + "' + " + paramString2 + ")", null);
        GMTrace.o(1138032115712L, 8479);
      }
    });
    GMTrace.o(1076426178560L, 8020);
  }
  
  public static String aY(Context paramContext, String paramString)
  {
    GMTrace.i(1075218219008L, 8011);
    Object localObject = "MicroMsg.WebViewUtil, appendUserAgent fail, context is null, stack = " + bf.bJP();
    boolean bool;
    if (paramContext != null)
    {
      bool = true;
      Assert.assertTrue((String)localObject, bool);
      if (paramString != null) {
        break label214;
      }
    }
    label214:
    for (paramString = " MicroMessenger/";; paramString = paramString + " MicroMessenger/")
    {
      localObject = ay(paramContext, aa.getPackageName());
      paramContext = paramString;
      if (localObject != null)
      {
        paramContext = paramString + f.Z(null, d.sXh);
        paramContext = paramContext + "." + ((PackageInfo)localObject).versionCode;
      }
      paramString = al.ee(aa.getContext());
      paramContext = paramContext + " NetType/" + paramString;
      paramContext = paramContext + " Language/" + u.ea(aa.getContext());
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUtil", "appendUserAgent, uaStr = " + paramContext);
      GMTrace.o(1075218219008L, 8011);
      return paramContext;
      bool = false;
      break;
    }
  }
  
  public static final String ac(Map<String, Object> paramMap)
  {
    GMTrace.i(1076828831744L, 8023);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if ((!bf.mA(str)) && (localObject != null) && ((!(localObject instanceof String)) || (!bf.mA((String)localObject))))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append(str);
        localStringBuilder.append("=");
        localStringBuilder.append(localObject);
      }
    }
    paramMap = localStringBuilder.toString();
    GMTrace.o(1076828831744L, 8023);
    return paramMap;
  }
  
  public static PackageInfo ay(Context paramContext, String paramString)
  {
    GMTrace.i(1075620872192L, 8014);
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUtil", "getPackageInfo fail, packageName is null");
      GMTrace.o(1075620872192L, 8014);
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      GMTrace.o(1075620872192L, 8014);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.WebViewUtil", paramContext, "", new Object[0]);
      GMTrace.o(1075620872192L, 8014);
    }
    return null;
  }
  
  public static void b(WebView paramWebView)
  {
    GMTrace.i(1076157743104L, 8018);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUtil", "initIFrame");
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1140045381632L, 8494);
        this.sWi.evaluateJavascript("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}", null);
        GMTrace.o(1140045381632L, 8494);
      }
    });
    GMTrace.o(1076157743104L, 8018);
  }
  
  public static String bGE()
  {
    i = 0;
    GMTrace.i(1077365702656L, 8027);
    try
    {
      int j = com.tencent.mm.compatible.d.v.rR();
      i = j;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", new Object[] { localException1 });
      }
      if (i != 1) {
        break label77;
      }
      Object localObject1 = dH(aa.getContext());
      GMTrace.o(1077365702656L, 8027);
      return (String)localObject1;
      InetAddress localInetAddress;
      try
      {
        do
        {
          localObject1 = NetworkInterface.getNetworkInterfaces();
          Object localObject2;
          while (!((Enumeration)localObject2).hasMoreElements())
          {
            do
            {
              if (!((Enumeration)localObject1).hasMoreElements()) {
                break;
              }
              localObject2 = (NetworkInterface)((Enumeration)localObject1).nextElement();
            } while (localObject2 == null);
            localObject2 = ((NetworkInterface)localObject2).getInetAddresses();
          }
          localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
        } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
        if (bf.mA(localInetAddress.getHostAddress()))
        {
          GMTrace.o(1077365702656L, 8027);
          return "127.0.0.1";
        }
      }
      catch (Exception localException2)
      {
        GMTrace.o(1077365702656L, 8027);
        return "127.0.0.1";
      }
      String str = localInetAddress.getHostAddress();
      GMTrace.o(1077365702656L, 8027);
      return str;
    }
    if (i == 0)
    {
      GMTrace.o(1077365702656L, 8027);
      return "127.0.0.1";
    }
  }
  
  public static String bwm()
  {
    GMTrace.i(1077634138112L, 8029);
    Object localObject = (ConnectivityManager)aa.getContext().getSystemService("connectivity");
    if (localObject == null)
    {
      GMTrace.o(1077634138112L, 8029);
      return "no";
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      GMTrace.o(1077634138112L, 8029);
      return "no";
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      GMTrace.o(1077634138112L, 8029);
      return "WIFI";
    }
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      GMTrace.o(1077634138112L, 8029);
      return (String)localObject;
    }
    GMTrace.o(1077634138112L, 8029);
    return "no";
  }
  
  private static String dH(Context paramContext)
  {
    GMTrace.i(1077231484928L, 8026);
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    try
    {
      paramContext = paramContext.getConnectionInfo();
      if (paramContext == null)
      {
        GMTrace.o(1077231484928L, 8026);
        return "127.0.0.1";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      int i = paramContext.getIpAddress();
      paramContext = String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i & 0xFF), Integer.valueOf(i >> 8 & 0xFF), Integer.valueOf(i >> 16 & 0xFF), Integer.valueOf(i >> 24 & 0xFF) });
      GMTrace.o(1077231484928L, 8026);
    }
    return paramContext;
  }
  
  public static boolean eq(String paramString1, String paramString2)
  {
    GMTrace.i(1075486654464L, 8013);
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() < 0) || (paramString2.length() < 0))
    {
      GMTrace.o(1075486654464L, 8013);
      return false;
    }
    if (paramString2.length() > paramString1.length())
    {
      GMTrace.o(1075486654464L, 8013);
      return false;
    }
    if (paramString2.equalsIgnoreCase(paramString1.substring(0, paramString2.length())))
    {
      GMTrace.o(1075486654464L, 8013);
      return true;
    }
    GMTrace.o(1075486654464L, 8013);
    return false;
  }
  
  public static String er(String paramString1, String paramString2)
  {
    GMTrace.i(1076560396288L, 8021);
    if ((bf.mA(paramString1)) || (bf.mA(paramString2)))
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
      GMTrace.o(1076560396288L, 8021);
      return null;
    }
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
    paramString1 = "document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2;
    GMTrace.o(1076560396288L, 8021);
    return paramString1;
  }
  
  public static final class a
  {
    private static final Pattern sWl;
    public final String charset;
    public final String mimeType;
    
    static
    {
      GMTrace.i(1141521776640L, 8505);
      sWl = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");
      GMTrace.o(1141521776640L, 8505);
    }
    
    private a(String paramString1, String paramString2)
    {
      GMTrace.i(1141119123456L, 8502);
      this.mimeType = paramString1;
      this.charset = paramString2;
      GMTrace.o(1141119123456L, 8502);
    }
    
    public static a Ny(String paramString)
    {
      String str = null;
      GMTrace.i(1141387558912L, 8504);
      if (bf.mA(paramString))
      {
        GMTrace.o(1141387558912L, 8504);
        return null;
      }
      Object localObject = sWl.matcher(paramString);
      if (!((Matcher)localObject).find())
      {
        GMTrace.o(1141387558912L, 8504);
        return null;
      }
      localObject = ((Matcher)localObject).group(0);
      if (paramString.contains("charset=")) {
        str = paramString.substring(paramString.indexOf("charset=") + 8).trim();
      }
      paramString = str;
      if (bf.mA(str)) {
        paramString = "UTF-8";
      }
      paramString = new a((String)localObject, paramString);
      GMTrace.o(1141387558912L, 8504);
      return paramString;
    }
    
    public final String toString()
    {
      GMTrace.i(1141253341184L, 8503);
      String str = "ContentType{mimeType='" + this.mimeType + '\'' + ", charset='" + this.charset + '\'' + '}';
      GMTrace.o(1141253341184L, 8503);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract void xI(String paramString);
  }
  
  private static final class c
    implements aq.a
  {
    private static Pattern sWm;
    private static Pattern sWn;
    private Context context;
    private String hOL;
    private String imagePath;
    private int opType;
    private String sWo;
    private String sWp;
    private boolean sWq;
    private s.b sWr;
    
    static
    {
      GMTrace.i(1132663406592L, 8439);
      sWm = Pattern.compile("image/[A-Za-z0-9]+");
      sWn = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
      GMTrace.o(1132663406592L, 8439);
    }
    
    public c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
    {
      this(paramContext, paramString1, paramString2, paramBoolean, 0, null);
      GMTrace.i(1131723882496L, 8432);
      GMTrace.o(1131723882496L, 8432);
    }
    
    public c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, s.b paramb)
    {
      GMTrace.i(1131858100224L, 8433);
      this.context = paramContext;
      this.hOL = paramString1;
      this.sWp = paramString2;
      this.sWq = paramBoolean;
      this.opType = paramInt;
      this.sWr = paramb;
      GMTrace.o(1131858100224L, 8433);
    }
    
    private void a(String paramString1, String paramString2, InputStream paramInputStream)
    {
      GMTrace.i(1132394971136L, 8437);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", new Object[] { paramString1, paramString2 });
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (!bf.mA(paramString1))
      {
        paramString1 = sWm.matcher(paramString1);
        localObject1 = localObject2;
        if (paramString1.find()) {
          localObject1 = paramString1.group().substring(paramString1.group().lastIndexOf('/') + 1);
        }
      }
      paramString1 = (String)localObject1;
      if (bf.mA((String)localObject1))
      {
        paramString1 = (String)localObject1;
        if (!bf.mA(paramString2))
        {
          paramString2 = sWn.matcher(paramString2);
          paramString1 = (String)localObject1;
          if (paramString2.find()) {
            paramString1 = paramString2.group().substring(paramString2.group().lastIndexOf('.') + 1);
          }
        }
      }
      paramString2 = paramString1;
      int i;
      if (bf.mA(paramString1))
      {
        paramString1 = new q(this.hOL);
        i = paramString1.aGN.lastIndexOf('.');
        if (i != -1) {
          break label230;
        }
      }
      label230:
      for (paramString2 = "jpg";; paramString2 = paramString1.aGN.substring(i + 1))
      {
        this.imagePath = k.ms(paramString2);
        paramString1 = new FileOutputStream(this.imagePath);
        paramString2 = new byte[' '];
        for (;;)
        {
          i = paramInputStream.read(paramString2);
          if (i == -1) {
            break;
          }
          paramString1.write(paramString2, 0, i);
        }
      }
      try
      {
        paramString1.flush();
        paramString1.close();
        if (this.opType == 0)
        {
          this.sWo = this.context.getString(R.l.eaP, new Object[] { k.Nl() });
          k.b(this.imagePath, this.context);
        }
        GMTrace.o(1132394971136L, 8437);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUtil", "close os failed : %s", new Object[] { paramString1.getMessage() });
        }
      }
    }
    
    private static void a(HttpURLConnection paramHttpURLConnection, InputStream paramInputStream)
    {
      GMTrace.i(1132260753408L, 8436);
      if (paramHttpURLConnection != null) {
        paramHttpURLConnection.disconnect();
      }
      if (paramInputStream != null) {
        try
        {
          paramInputStream.close();
          GMTrace.o(1132260753408L, 8436);
          return;
        }
        catch (Exception paramHttpURLConnection)
        {
          com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.WebViewUtil", paramHttpURLConnection, "", new Object[0]);
        }
      }
      GMTrace.o(1132260753408L, 8436);
    }
    
    /* Error */
    private void bGF()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aconst_null
      //   4: astore 5
      //   6: aconst_null
      //   7: astore_3
      //   8: ldc2_w 203
      //   11: sipush 8435
      //   14: invokestatic 35	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   17: new 206	java/net/URL
      //   20: dup
      //   21: aload_0
      //   22: getfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   25: invokespecial 207	java/net/URL:<init>	(Ljava/lang/String;)V
      //   28: invokevirtual 211	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   31: checkcast 191	java/net/HttpURLConnection
      //   34: astore_2
      //   35: aload 5
      //   37: astore_3
      //   38: aload_2
      //   39: ldc -43
      //   41: invokevirtual 216	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   44: aload 5
      //   46: astore_3
      //   47: aload_2
      //   48: ldc -38
      //   50: aload_0
      //   51: getfield 70	com/tencent/mm/pluginsdk/ui/tools/s$c:sWp	Ljava/lang/String;
      //   54: invokevirtual 222	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   57: aload 5
      //   59: astore_3
      //   60: aload_2
      //   61: iconst_1
      //   62: invokevirtual 226	java/net/HttpURLConnection:setAllowUserInteraction	(Z)V
      //   65: aload 5
      //   67: astore_3
      //   68: aload_2
      //   69: invokevirtual 230	java/net/HttpURLConnection:getResponseCode	()I
      //   72: istore_1
      //   73: iload_1
      //   74: sipush 200
      //   77: if_icmpeq +141 -> 218
      //   80: iload_1
      //   81: sipush 301
      //   84: if_icmpeq +10 -> 94
      //   87: iload_1
      //   88: sipush 302
      //   91: if_icmpne +95 -> 186
      //   94: aload 5
      //   96: astore_3
      //   97: aload_2
      //   98: ldc -24
      //   100: invokevirtual 235	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   103: astore 6
      //   105: aload 6
      //   107: astore 4
      //   109: aload 6
      //   111: ifnonnull +14 -> 125
      //   114: aload 5
      //   116: astore_3
      //   117: aload_2
      //   118: ldc -19
      //   120: invokevirtual 235	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   123: astore 4
      //   125: aload 5
      //   127: astore_3
      //   128: ldc 84
      //   130: ldc -17
      //   132: iconst_1
      //   133: anewarray 4	java/lang/Object
      //   136: dup
      //   137: iconst_0
      //   138: aload 4
      //   140: aastore
      //   141: invokestatic 91	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   144: aload 5
      //   146: astore_3
      //   147: aload 4
      //   149: invokestatic 97	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
      //   152: ifne +34 -> 186
      //   155: aload 5
      //   157: astore_3
      //   158: aload_0
      //   159: aload 4
      //   161: putfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   164: aload 5
      //   166: astore_3
      //   167: aload_0
      //   168: invokespecial 241	com/tencent/mm/pluginsdk/ui/tools/s$c:bGF	()V
      //   171: aload_2
      //   172: aconst_null
      //   173: invokestatic 243	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   176: ldc2_w 203
      //   179: sipush 8435
      //   182: invokestatic 52	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   185: return
      //   186: aload 5
      //   188: astore_3
      //   189: aload_0
      //   190: aload_0
      //   191: getfield 66	com/tencent/mm/pluginsdk/ui/tools/s$c:context	Landroid/content/Context;
      //   194: getstatic 246	com/tencent/mm/R$l:fnG	I
      //   197: invokevirtual 248	android/content/Context:getString	(I)Ljava/lang/String;
      //   200: putfield 174	com/tencent/mm/pluginsdk/ui/tools/s$c:sWo	Ljava/lang/String;
      //   203: aload_2
      //   204: aconst_null
      //   205: invokestatic 243	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   208: ldc2_w 203
      //   211: sipush 8435
      //   214: invokestatic 52	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   217: return
      //   218: aload 5
      //   220: astore_3
      //   221: aload_2
      //   222: invokevirtual 251	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
      //   225: astore 6
      //   227: aload 5
      //   229: astore_3
      //   230: aload_2
      //   231: invokevirtual 255	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   234: astore 4
      //   236: aload 4
      //   238: astore_3
      //   239: aload_0
      //   240: aload 6
      //   242: aload_2
      //   243: ldc_w 257
      //   246: invokevirtual 235	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   249: aload 4
      //   251: invokespecial 259	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
      //   254: aload_2
      //   255: aload 4
      //   257: invokestatic 243	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   260: ldc2_w 203
      //   263: sipush 8435
      //   266: invokestatic 52	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   269: return
      //   270: astore 4
      //   272: aconst_null
      //   273: astore_2
      //   274: ldc 84
      //   276: ldc_w 261
      //   279: iconst_1
      //   280: anewarray 4	java/lang/Object
      //   283: dup
      //   284: iconst_0
      //   285: aload 4
      //   287: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   290: aastore
      //   291: invokestatic 186	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   294: aload_3
      //   295: aload_2
      //   296: invokestatic 243	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   299: ldc2_w 203
      //   302: sipush 8435
      //   305: invokestatic 52	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   308: return
      //   309: astore_2
      //   310: aconst_null
      //   311: astore 5
      //   313: aload 4
      //   315: astore_3
      //   316: aload 5
      //   318: astore 4
      //   320: aload 4
      //   322: aload_3
      //   323: invokestatic 243	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   326: aload_2
      //   327: athrow
      //   328: astore 5
      //   330: aload_2
      //   331: astore 4
      //   333: aload 5
      //   335: astore_2
      //   336: goto -16 -> 320
      //   339: astore 4
      //   341: aload_2
      //   342: astore 5
      //   344: aload 4
      //   346: astore_2
      //   347: aload_3
      //   348: astore 4
      //   350: aload 5
      //   352: astore_3
      //   353: goto -33 -> 320
      //   356: astore 4
      //   358: aconst_null
      //   359: astore 5
      //   361: aload_2
      //   362: astore_3
      //   363: aload 5
      //   365: astore_2
      //   366: goto -92 -> 274
      //   369: astore 6
      //   371: aload 4
      //   373: astore_3
      //   374: aload_2
      //   375: astore 5
      //   377: aload 6
      //   379: astore 4
      //   381: aload_3
      //   382: astore_2
      //   383: aload 5
      //   385: astore_3
      //   386: goto -112 -> 274
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	389	0	this	c
      //   72	20	1	i	int
      //   34	262	2	localHttpURLConnection	HttpURLConnection
      //   309	22	2	localObject1	Object
      //   335	48	2	localObject2	Object
      //   7	379	3	localObject3	Object
      //   1	255	4	localObject4	Object
      //   270	44	4	localException1	Exception
      //   318	14	4	localObject5	Object
      //   339	6	4	localObject6	Object
      //   348	1	4	localObject7	Object
      //   356	16	4	localException2	Exception
      //   379	1	4	localObject8	Object
      //   4	313	5	localObject9	Object
      //   328	6	5	localObject10	Object
      //   342	42	5	localObject11	Object
      //   103	138	6	str	String
      //   369	9	6	localException3	Exception
      // Exception table:
      //   from	to	target	type
      //   17	35	270	java/lang/Exception
      //   17	35	309	finally
      //   38	44	328	finally
      //   47	57	328	finally
      //   60	65	328	finally
      //   68	73	328	finally
      //   97	105	328	finally
      //   117	125	328	finally
      //   128	144	328	finally
      //   147	155	328	finally
      //   158	164	328	finally
      //   167	171	328	finally
      //   189	203	328	finally
      //   221	227	328	finally
      //   230	236	328	finally
      //   239	254	328	finally
      //   274	294	339	finally
      //   38	44	356	java/lang/Exception
      //   47	57	356	java/lang/Exception
      //   60	65	356	java/lang/Exception
      //   68	73	356	java/lang/Exception
      //   97	105	356	java/lang/Exception
      //   117	125	356	java/lang/Exception
      //   128	144	356	java/lang/Exception
      //   147	155	356	java/lang/Exception
      //   158	164	356	java/lang/Exception
      //   167	171	356	java/lang/Exception
      //   189	203	356	java/lang/Exception
      //   221	227	356	java/lang/Exception
      //   230	236	356	java/lang/Exception
      //   239	254	369	java/lang/Exception
    }
    
    /* Error */
    public final boolean Bn()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 6
      //   3: aconst_null
      //   4: astore 4
      //   6: aconst_null
      //   7: astore_3
      //   8: aconst_null
      //   9: astore 7
      //   11: aconst_null
      //   12: astore 8
      //   14: aconst_null
      //   15: astore 5
      //   17: ldc2_w 263
      //   20: sipush 8438
      //   23: invokestatic 35	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   26: aload_0
      //   27: getfield 72	com/tencent/mm/pluginsdk/ui/tools/s$c:sWq	Z
      //   30: ifne +28 -> 58
      //   33: aload_0
      //   34: aload_0
      //   35: getfield 66	com/tencent/mm/pluginsdk/ui/tools/s$c:context	Landroid/content/Context;
      //   38: getstatic 267	com/tencent/mm/R$l:fnH	I
      //   41: invokevirtual 248	android/content/Context:getString	(I)Ljava/lang/String;
      //   44: putfield 174	com/tencent/mm/pluginsdk/ui/tools/s$c:sWo	Ljava/lang/String;
      //   47: ldc2_w 263
      //   50: sipush 8438
      //   53: invokestatic 52	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   56: iconst_1
      //   57: ireturn
      //   58: aload_0
      //   59: getfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   62: invokestatic 97	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
      //   65: ifeq +14 -> 79
      //   68: ldc2_w 263
      //   71: sipush 8438
      //   74: invokestatic 52	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   77: iconst_0
      //   78: ireturn
      //   79: aload_0
      //   80: getfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   83: astore 9
      //   85: invokestatic 273	com/tencent/smtt/sdk/ac:ceR	()Lcom/tencent/smtt/sdk/ac;
      //   88: astore 10
      //   90: aload 10
      //   92: ifnull +212 -> 304
      //   95: aload 10
      //   97: invokevirtual 276	com/tencent/smtt/sdk/ac:ceS	()Z
      //   100: ifeq +204 -> 304
      //   103: aload 10
      //   105: invokevirtual 280	com/tencent/smtt/sdk/ac:ceT	()Lcom/tencent/smtt/sdk/ad;
      //   108: getfield 286	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
      //   111: ldc_w 288
      //   114: ldc_w 290
      //   117: iconst_1
      //   118: anewarray 292	java/lang/Class
      //   121: dup
      //   122: iconst_0
      //   123: ldc 113
      //   125: aastore
      //   126: iconst_1
      //   127: anewarray 4	java/lang/Object
      //   130: dup
      //   131: iconst_0
      //   132: aload 9
      //   134: aastore
      //   135: invokevirtual 298	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
      //   138: astore 9
      //   140: aload 9
      //   142: ifnonnull +150 -> 292
      //   145: iconst_0
      //   146: istore_2
      //   147: iload_2
      //   148: ifeq +300 -> 448
      //   151: aload_0
      //   152: ldc -125
      //   154: invokestatic 137	com/tencent/mm/pluginsdk/ui/tools/k:ms	(Ljava/lang/String;)Ljava/lang/String;
      //   157: putfield 139	com/tencent/mm/pluginsdk/ui/tools/s$c:imagePath	Ljava/lang/String;
      //   160: aload 6
      //   162: astore_3
      //   163: aload_0
      //   164: getfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   167: ldc_w 300
      //   170: invokevirtual 304	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   173: istore_1
      //   174: iload_1
      //   175: ifle +21 -> 196
      //   178: aload 6
      //   180: astore_3
      //   181: aload_0
      //   182: aload_0
      //   183: getfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   186: iload_1
      //   187: bipush 7
      //   189: iadd
      //   190: invokevirtual 121	java/lang/String:substring	(I)Ljava/lang/String;
      //   193: putfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   196: aload 6
      //   198: astore_3
      //   199: new 141	java/io/FileOutputStream
      //   202: dup
      //   203: aload_0
      //   204: getfield 139	com/tencent/mm/pluginsdk/ui/tools/s$c:imagePath	Ljava/lang/String;
      //   207: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   210: astore 4
      //   212: aload_0
      //   213: getfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   216: iconst_0
      //   217: invokestatic 310	android/util/Base64:decode	(Ljava/lang/String;I)[B
      //   220: astore_3
      //   221: aload_3
      //   222: ifnull +9 -> 231
      //   225: aload 4
      //   227: aload_3
      //   228: invokevirtual 313	java/io/FileOutputStream:write	([B)V
      //   231: aload 4
      //   233: invokevirtual 155	java/io/FileOutputStream:flush	()V
      //   236: aload 4
      //   238: invokevirtual 158	java/io/FileOutputStream:close	()V
      //   241: aload_0
      //   242: aload_0
      //   243: getfield 66	com/tencent/mm/pluginsdk/ui/tools/s$c:context	Landroid/content/Context;
      //   246: getstatic 163	com/tencent/mm/R$l:eaP	I
      //   249: iconst_1
      //   250: anewarray 4	java/lang/Object
      //   253: dup
      //   254: iconst_0
      //   255: invokestatic 166	com/tencent/mm/pluginsdk/ui/tools/k:Nl	()Ljava/lang/String;
      //   258: aastore
      //   259: invokevirtual 172	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
      //   262: putfield 174	com/tencent/mm/pluginsdk/ui/tools/s$c:sWo	Ljava/lang/String;
      //   265: aload_0
      //   266: getfield 139	com/tencent/mm/pluginsdk/ui/tools/s$c:imagePath	Ljava/lang/String;
      //   269: aload_0
      //   270: getfield 66	com/tencent/mm/pluginsdk/ui/tools/s$c:context	Landroid/content/Context;
      //   273: invokestatic 178	com/tencent/mm/pluginsdk/ui/tools/k:b	(Ljava/lang/String;Landroid/content/Context;)V
      //   276: aload 4
      //   278: invokevirtual 158	java/io/FileOutputStream:close	()V
      //   281: ldc2_w 263
      //   284: sipush 8438
      //   287: invokestatic 52	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   290: iconst_1
      //   291: ireturn
      //   292: aload 9
      //   294: checkcast 315	java/lang/Boolean
      //   297: invokevirtual 318	java/lang/Boolean:booleanValue	()Z
      //   300: istore_2
      //   301: goto -154 -> 147
      //   304: aload 9
      //   306: invokestatic 323	android/webkit/URLUtil:isDataUrl	(Ljava/lang/String;)Z
      //   309: istore_2
      //   310: goto -163 -> 147
      //   313: astore_3
      //   314: ldc 84
      //   316: ldc_w 325
      //   319: iconst_1
      //   320: anewarray 4	java/lang/Object
      //   323: dup
      //   324: iconst_0
      //   325: aload_3
      //   326: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   329: aastore
      //   330: invokestatic 186	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   333: goto -52 -> 281
      //   336: astore_3
      //   337: aload 5
      //   339: astore 4
      //   341: aload_3
      //   342: astore 5
      //   344: aload 4
      //   346: astore_3
      //   347: ldc 84
      //   349: ldc_w 327
      //   352: iconst_1
      //   353: anewarray 4	java/lang/Object
      //   356: dup
      //   357: iconst_0
      //   358: aload 5
      //   360: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   363: aastore
      //   364: invokestatic 186	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   367: aload 4
      //   369: ifnull -88 -> 281
      //   372: aload 4
      //   374: invokevirtual 158	java/io/FileOutputStream:close	()V
      //   377: goto -96 -> 281
      //   380: astore_3
      //   381: ldc 84
      //   383: ldc_w 325
      //   386: iconst_1
      //   387: anewarray 4	java/lang/Object
      //   390: dup
      //   391: iconst_0
      //   392: aload_3
      //   393: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   396: aastore
      //   397: invokestatic 186	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   400: goto -119 -> 281
      //   403: astore 5
      //   405: aload_3
      //   406: astore 4
      //   408: aload 5
      //   410: astore_3
      //   411: aload 4
      //   413: ifnull +8 -> 421
      //   416: aload 4
      //   418: invokevirtual 158	java/io/FileOutputStream:close	()V
      //   421: aload_3
      //   422: athrow
      //   423: astore 4
      //   425: ldc 84
      //   427: ldc_w 325
      //   430: iconst_1
      //   431: anewarray 4	java/lang/Object
      //   434: dup
      //   435: iconst_0
      //   436: aload 4
      //   438: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   441: aastore
      //   442: invokestatic 186	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   445: goto -24 -> 421
      //   448: aload_0
      //   449: getfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   452: invokestatic 332	com/tencent/smtt/sdk/x:isHttpsUrl	(Ljava/lang/String;)Z
      //   455: ifeq +351 -> 806
      //   458: new 206	java/net/URL
      //   461: dup
      //   462: aload_0
      //   463: getfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   466: invokespecial 207	java/net/URL:<init>	(Ljava/lang/String;)V
      //   469: invokevirtual 211	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   472: checkcast 334	javax/net/ssl/HttpsURLConnection
      //   475: astore 5
      //   477: aload 7
      //   479: astore_3
      //   480: aload 8
      //   482: astore 4
      //   484: aload 5
      //   486: ldc -43
      //   488: invokevirtual 335	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   491: aload 7
      //   493: astore_3
      //   494: aload 8
      //   496: astore 4
      //   498: aload 5
      //   500: ldc -38
      //   502: aload_0
      //   503: getfield 70	com/tencent/mm/pluginsdk/ui/tools/s$c:sWp	Ljava/lang/String;
      //   506: invokevirtual 336	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   509: aload 7
      //   511: astore_3
      //   512: aload 8
      //   514: astore 4
      //   516: aload 5
      //   518: iconst_1
      //   519: invokevirtual 337	javax/net/ssl/HttpsURLConnection:setAllowUserInteraction	(Z)V
      //   522: aload 7
      //   524: astore_3
      //   525: aload 8
      //   527: astore 4
      //   529: aload 5
      //   531: invokevirtual 338	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
      //   534: istore_1
      //   535: iload_1
      //   536: sipush 200
      //   539: if_icmpeq +159 -> 698
      //   542: iload_1
      //   543: sipush 301
      //   546: if_icmpeq +10 -> 556
      //   549: iload_1
      //   550: sipush 302
      //   553: if_icmpne +115 -> 668
      //   556: aload 7
      //   558: astore_3
      //   559: aload 8
      //   561: astore 4
      //   563: aload 5
      //   565: ldc -24
      //   567: invokevirtual 339	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   570: astore 9
      //   572: aload 9
      //   574: astore 6
      //   576: aload 9
      //   578: ifnonnull +19 -> 597
      //   581: aload 7
      //   583: astore_3
      //   584: aload 8
      //   586: astore 4
      //   588: aload 5
      //   590: ldc -19
      //   592: invokevirtual 339	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   595: astore 6
      //   597: aload 7
      //   599: astore_3
      //   600: aload 8
      //   602: astore 4
      //   604: ldc 84
      //   606: ldc -17
      //   608: iconst_1
      //   609: anewarray 4	java/lang/Object
      //   612: dup
      //   613: iconst_0
      //   614: aload 6
      //   616: aastore
      //   617: invokestatic 91	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   620: aload 7
      //   622: astore_3
      //   623: aload 8
      //   625: astore 4
      //   627: aload 6
      //   629: invokestatic 97	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
      //   632: ifne +36 -> 668
      //   635: aload 7
      //   637: astore_3
      //   638: aload 8
      //   640: astore 4
      //   642: aload_0
      //   643: aload 6
      //   645: putfield 68	com/tencent/mm/pluginsdk/ui/tools/s$c:hOL	Ljava/lang/String;
      //   648: aload 7
      //   650: astore_3
      //   651: aload 8
      //   653: astore 4
      //   655: aload_0
      //   656: invokespecial 241	com/tencent/mm/pluginsdk/ui/tools/s$c:bGF	()V
      //   659: aload 5
      //   661: aconst_null
      //   662: invokestatic 243	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   665: goto -384 -> 281
      //   668: aload 7
      //   670: astore_3
      //   671: aload 8
      //   673: astore 4
      //   675: aload_0
      //   676: aload_0
      //   677: getfield 66	com/tencent/mm/pluginsdk/ui/tools/s$c:context	Landroid/content/Context;
      //   680: getstatic 246	com/tencent/mm/R$l:fnG	I
      //   683: invokevirtual 248	android/content/Context:getString	(I)Ljava/lang/String;
      //   686: putfield 174	com/tencent/mm/pluginsdk/ui/tools/s$c:sWo	Ljava/lang/String;
      //   689: aload 5
      //   691: aconst_null
      //   692: invokestatic 243	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   695: goto -414 -> 281
      //   698: aload 7
      //   700: astore_3
      //   701: aload 8
      //   703: astore 4
      //   705: aload 5
      //   707: invokevirtual 340	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
      //   710: astore 9
      //   712: aload 7
      //   714: astore_3
      //   715: aload 8
      //   717: astore 4
      //   719: aload 5
      //   721: invokevirtual 341	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
      //   724: astore 6
      //   726: aload 6
      //   728: astore_3
      //   729: aload 6
      //   731: astore 4
      //   733: aload_0
      //   734: aload 9
      //   736: aload 5
      //   738: ldc_w 257
      //   741: invokevirtual 339	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   744: aload 6
      //   746: invokespecial 259	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
      //   749: aload 5
      //   751: aload 6
      //   753: invokestatic 243	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   756: goto -475 -> 281
      //   759: astore 5
      //   761: aconst_null
      //   762: astore_3
      //   763: ldc 84
      //   765: ldc_w 343
      //   768: iconst_1
      //   769: anewarray 4	java/lang/Object
      //   772: dup
      //   773: iconst_0
      //   774: aload 5
      //   776: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   779: aastore
      //   780: invokestatic 186	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   783: aload_3
      //   784: aload 4
      //   786: invokestatic 243	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   789: goto -508 -> 281
      //   792: astore 5
      //   794: aconst_null
      //   795: astore 6
      //   797: aload 6
      //   799: aload_3
      //   800: invokestatic 243	com/tencent/mm/pluginsdk/ui/tools/s$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   803: aload 5
      //   805: athrow
      //   806: aload_0
      //   807: invokespecial 241	com/tencent/mm/pluginsdk/ui/tools/s$c:bGF	()V
      //   810: goto -529 -> 281
      //   813: astore 4
      //   815: aload 5
      //   817: astore 6
      //   819: aload 4
      //   821: astore 5
      //   823: goto -26 -> 797
      //   826: astore 5
      //   828: aload_3
      //   829: astore 6
      //   831: aload 4
      //   833: astore_3
      //   834: goto -37 -> 797
      //   837: astore 6
      //   839: aload 5
      //   841: astore_3
      //   842: aload 6
      //   844: astore 5
      //   846: goto -83 -> 763
      //   849: astore_3
      //   850: goto -439 -> 411
      //   853: astore 5
      //   855: goto -511 -> 344
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	858	0	this	c
      //   173	381	1	i	int
      //   146	164	2	bool	boolean
      //   7	221	3	localObject1	Object
      //   313	13	3	localException1	Exception
      //   336	6	3	localException2	Exception
      //   346	1	3	localObject2	Object
      //   380	26	3	localException3	Exception
      //   410	432	3	localObject3	Object
      //   849	1	3	localObject4	Object
      //   4	413	4	localObject5	Object
      //   423	14	4	localException4	Exception
      //   482	303	4	localObject6	Object
      //   813	19	4	localObject7	Object
      //   15	344	5	localException5	Exception
      //   403	6	5	localObject8	Object
      //   475	275	5	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
      //   759	16	5	localException6	Exception
      //   792	24	5	localObject9	Object
      //   821	1	5	localObject10	Object
      //   826	14	5	localObject11	Object
      //   844	1	5	localException7	Exception
      //   853	1	5	localException8	Exception
      //   1	829	6	localObject12	Object
      //   837	6	6	localException9	Exception
      //   9	704	7	localObject13	Object
      //   12	704	8	localObject14	Object
      //   83	652	9	localObject15	Object
      //   88	16	10	localac	com.tencent.smtt.sdk.ac
      // Exception table:
      //   from	to	target	type
      //   276	281	313	java/lang/Exception
      //   163	174	336	java/lang/Exception
      //   181	196	336	java/lang/Exception
      //   199	212	336	java/lang/Exception
      //   372	377	380	java/lang/Exception
      //   163	174	403	finally
      //   181	196	403	finally
      //   199	212	403	finally
      //   347	367	403	finally
      //   416	421	423	java/lang/Exception
      //   458	477	759	java/lang/Exception
      //   458	477	792	finally
      //   484	491	813	finally
      //   498	509	813	finally
      //   516	522	813	finally
      //   529	535	813	finally
      //   563	572	813	finally
      //   588	597	813	finally
      //   604	620	813	finally
      //   627	635	813	finally
      //   642	648	813	finally
      //   655	659	813	finally
      //   675	689	813	finally
      //   705	712	813	finally
      //   719	726	813	finally
      //   733	749	813	finally
      //   763	783	826	finally
      //   484	491	837	java/lang/Exception
      //   498	509	837	java/lang/Exception
      //   516	522	837	java/lang/Exception
      //   529	535	837	java/lang/Exception
      //   563	572	837	java/lang/Exception
      //   588	597	837	java/lang/Exception
      //   604	620	837	java/lang/Exception
      //   627	635	837	java/lang/Exception
      //   642	648	837	java/lang/Exception
      //   655	659	837	java/lang/Exception
      //   675	689	837	java/lang/Exception
      //   705	712	837	java/lang/Exception
      //   719	726	837	java/lang/Exception
      //   733	749	837	java/lang/Exception
      //   212	221	849	finally
      //   225	231	849	finally
      //   231	276	849	finally
      //   212	221	853	java/lang/Exception
      //   225	231	853	java/lang/Exception
      //   231	276	853	java/lang/Exception
    }
    
    public final boolean Bo()
    {
      GMTrace.i(1131992317952L, 8434);
      if (1 == this.opType)
      {
        this.sWr.xI(this.imagePath);
        GMTrace.o(1131992317952L, 8434);
        return true;
      }
      if (!bf.mA(this.sWo)) {
        Toast.makeText(this.context, this.sWo, 1).show();
      }
      for (;;)
      {
        GMTrace.o(1131992317952L, 8434);
        return true;
        Toast.makeText(this.context, this.context.getString(R.l.fnG), 1).show();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */