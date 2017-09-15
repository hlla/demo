package ct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public final class da
{
  public static boolean a = false;
  private static long b = 0L;
  private static boolean c = false;
  
  public static String a()
  {
    String str1 = "";
    String str2 = str1;
    str3 = str1;
    try
    {
      Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
      for (;;)
      {
        str2 = str1;
        str3 = str1;
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        str2 = str1;
        str3 = str1;
        NetworkInterface localNetworkInterface = (NetworkInterface)localEnumeration.nextElement();
        if (localNetworkInterface != null)
        {
          str2 = str1;
          str3 = str1;
          if (localNetworkInterface.getName().equalsIgnoreCase("wlan0"))
          {
            str2 = str1;
            str3 = str1;
            byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
            if (arrayOfByte != null)
            {
              str2 = str1;
              str3 = str1;
              if (arrayOfByte.length != 0)
              {
                str2 = str1;
                str3 = str1;
                StringBuilder localStringBuilder = new StringBuilder();
                str2 = str1;
                str3 = str1;
                int j = arrayOfByte.length;
                int i = 0;
                while (i < j)
                {
                  str2 = str1;
                  str3 = str1;
                  localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(arrayOfByte[i]) }));
                  i += 1;
                }
                str2 = str1;
                str3 = str1;
                if (localStringBuilder.length() > 0)
                {
                  str2 = str1;
                  str3 = str1;
                  localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
                }
                str2 = str1;
                str3 = str1;
                str1 = localStringBuilder.toString();
                str2 = str1;
                str3 = str1;
                b.a.b("Wifis", "interfaceName=" + localNetworkInterface.getName() + ", mac=" + str1);
              }
            }
          }
        }
      }
      return str3;
    }
    catch (Exception localException)
    {
      b.a.b("Wifis", localException.toString());
      return str2;
      return localException;
    }
    catch (Error localError)
    {
      b.a.b("Wifis", localError.toString());
    }
  }
  
  public static boolean a(WifiManager paramWifiManager)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramWifiManager != null) {}
    for (bool1 = bool2;; bool1 = bool2)
    {
      try
      {
        if (System.currentTimeMillis() - b <= 4000L) {
          break label64;
        }
        bool1 = bool2;
        b.a.b("wifis", "force scan");
        bool1 = bool2;
        bool2 = paramWifiManager.startScan();
        bool1 = bool2;
        c = bool2;
        bool1 = bool2;
        b = System.currentTimeMillis();
        bool1 = bool2;
      }
      catch (Exception paramWifiManager)
      {
        for (;;)
        {
          label64:
          a = true;
        }
      }
      finally {}
      return bool1;
      bool1 = bool2;
      bool2 = c;
    }
  }
  
  @SuppressLint({"NewApi"})
  public static boolean a(bk parambk)
  {
    parambk = parambk.b();
    boolean bool1 = false;
    boolean bool2;
    if (parambk != null)
    {
      bool2 = parambk.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = parambk.isScanAlwaysAvailable();
      }
      return bool1;
    }
    catch (Error parambk)
    {
      return bool2;
    }
    catch (Exception parambk) {}
    return bool2;
  }
  
  public static String b(bk parambk)
  {
    Object localObject = parambk.a;
    if (localObject == null) {
      return "{}";
    }
    try
    {
      parambk = (WifiManager)((Context)localObject).getSystemService("wifi");
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if ((parambk != null) && (localObject != null))
      {
        parambk = parambk.getConnectionInfo();
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((parambk != null) && (localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          localObject = parambk.getBSSID();
          if ((localObject == null) || (((String)localObject).equals("000000000000")) || (((String)localObject).equals("00-00-00-00-00-00")) || (((String)localObject).equals("00:00:00:00:00:00"))) {
            break label225;
          }
          int i = parambk.getRssi();
          if ((i < -100) || (i > -20)) {
            break label228;
          }
          parambk = parambk.getSSID().replace("\"", "").replace("|", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("{");
          localStringBuilder.append("\"mac\":\"");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("\",\"rssi\":");
          localStringBuilder.append(i);
          localStringBuilder.append(",\"ssid\":\"");
          localStringBuilder.append(parambk);
          localStringBuilder.append("\"}");
          parambk = localStringBuilder.toString();
          return parambk;
        }
        return "{}";
      }
    }
    catch (Exception parambk)
    {
      return "{}";
    }
    return "{}";
    label225:
    return "{}";
    label228:
    return "{}";
  }
  
  public static List<ScanResult> b(WifiManager paramWifiManager)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramWifiManager != null) {
      localObject1 = localObject2;
    }
    try
    {
      paramWifiManager = paramWifiManager.getScanResults();
      localObject1 = paramWifiManager;
      a = false;
      localObject1 = paramWifiManager;
    }
    catch (Exception paramWifiManager)
    {
      for (;;)
      {
        a = true;
      }
    }
    paramWifiManager = (WifiManager)localObject1;
    if (localObject1 == null) {
      paramWifiManager = Collections.emptyList();
    }
    return paramWifiManager;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */