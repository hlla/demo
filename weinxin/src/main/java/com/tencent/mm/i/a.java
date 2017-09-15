package com.tencent.mm.i;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.z;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public class a
{
  public static final String gST;
  private static SharedPreferences gSU;
  private static SharedPreferences gSV;
  private static String gSW;
  
  static
  {
    GMTrace.i(4095117099008L, 30511);
    gST = null;
    gSU = null;
    gSV = null;
    gSW = gST;
    GMTrace.o(4095117099008L, 30511);
  }
  
  public static boolean az(int paramInt1, int paramInt2)
  {
    GMTrace.i(4094982881280L, 30510);
    if (sr())
    {
      GMTrace.o(4094982881280L, 30510);
      return true;
    }
    int i = ss();
    int j = su();
    int k = st();
    int m = sv();
    if ((i == k) && (j == m))
    {
      GMTrace.o(4094982881280L, 30510);
      return false;
    }
    if ((i == k) && (j < m))
    {
      if ((paramInt1 == i) && (paramInt2 > j) && (paramInt2 < m))
      {
        GMTrace.o(4094982881280L, 30510);
        return true;
      }
      GMTrace.o(4094982881280L, 30510);
      return false;
    }
    if (k > i)
    {
      if (((paramInt1 > i) && (paramInt1 < k)) || ((paramInt1 == i) && (paramInt2 > j)) || ((paramInt1 == k) && (paramInt2 < m)))
      {
        GMTrace.o(4094982881280L, 30510);
        return true;
      }
      GMTrace.o(4094982881280L, 30510);
      return false;
    }
    if ((k < i) || ((i == k) && (j > m)))
    {
      if (((paramInt1 > i) && (paramInt1 <= 23)) || ((paramInt1 == i) && (paramInt2 > j)) || ((paramInt1 == k) && (paramInt2 < m)) || ((paramInt1 > 0) && (paramInt1 < k)))
      {
        GMTrace.o(4094982881280L, 30510);
        return true;
      }
      GMTrace.o(4094982881280L, 30510);
      return false;
    }
    GMTrace.o(4094982881280L, 30510);
    return true;
  }
  
  static void dA(String paramString)
  {
    GMTrace.i(16293629526016L, 121397);
    aa.bIO().edit().putString("settings.ringtone", paramString).commit();
    com.tencent.mm.kernel.a.uT().edit().putString("settings.ringtone", paramString).commit();
    GMTrace.o(16293629526016L, 121397);
  }
  
  public static SharedPreferences sj()
  {
    GMTrace.i(4093238050816L, 30497);
    SharedPreferences localSharedPreferences = z.MI();
    gSV = localSharedPreferences;
    GMTrace.o(4093238050816L, 30497);
    return localSharedPreferences;
  }
  
  public static boolean sk()
  {
    GMTrace.i(4093372268544L, 30498);
    boolean bool = com.tencent.mm.kernel.a.uT().getBoolean("command_notification_status", false);
    GMTrace.o(4093372268544L, 30498);
    return bool;
  }
  
  public static boolean sl()
  {
    GMTrace.i(4093506486272L, 30499);
    boolean bool = com.tencent.mm.kernel.a.uT().getBoolean("settings_new_msg_notification", true);
    GMTrace.o(4093506486272L, 30499);
    return bool;
  }
  
  public static boolean sm()
  {
    GMTrace.i(4093640704000L, 30500);
    boolean bool = com.tencent.mm.kernel.a.uT().getBoolean("settings_new_voip_msg_notification", true);
    GMTrace.o(4093640704000L, 30500);
    return bool;
  }
  
  public static boolean sn()
  {
    GMTrace.i(4093774921728L, 30501);
    boolean bool = com.tencent.mm.kernel.a.uT().getBoolean("settings_show_detail", true);
    GMTrace.o(4093774921728L, 30501);
    return bool;
  }
  
  public static boolean so()
  {
    GMTrace.i(4093909139456L, 30502);
    boolean bool = com.tencent.mm.kernel.a.uT().getBoolean("settings_sound", true);
    GMTrace.o(4093909139456L, 30502);
    return bool;
  }
  
  public static String sp()
  {
    GMTrace.i(4094043357184L, 30503);
    String str2 = com.tencent.mm.kernel.a.uT().getString("settings.ringtone", gST);
    String str1 = str2;
    if (str2 != gST)
    {
      str1 = str2;
      if (!str2.equals(gSW))
      {
        RingtoneManager localRingtoneManager = new RingtoneManager(aa.getContext());
        localRingtoneManager.setType(2);
        str1 = str2;
        if (localRingtoneManager.getRingtonePosition(Uri.parse(str2)) < 0)
        {
          str1 = gST;
          dA(str1);
          v.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
        }
        gSW = str1;
      }
    }
    GMTrace.o(4094043357184L, 30503);
    return str1;
  }
  
  public static boolean sq()
  {
    GMTrace.i(4094177574912L, 30504);
    boolean bool = com.tencent.mm.kernel.a.uT().getBoolean("settings_shake", true);
    GMTrace.o(4094177574912L, 30504);
    return bool;
  }
  
  public static boolean sr()
  {
    GMTrace.i(4094311792640L, 30505);
    boolean bool = com.tencent.mm.kernel.a.uT().getBoolean("settings_active_time_full", true);
    GMTrace.o(4094311792640L, 30505);
    return bool;
  }
  
  public static int ss()
  {
    GMTrace.i(4094446010368L, 30506);
    int i = com.tencent.mm.kernel.a.uT().getInt("settings_active_begin_time_hour", 8);
    GMTrace.o(4094446010368L, 30506);
    return i;
  }
  
  public static int st()
  {
    GMTrace.i(4094580228096L, 30507);
    int i = com.tencent.mm.kernel.a.uT().getInt("settings_active_end_time_hour", 23);
    GMTrace.o(4094580228096L, 30507);
    return i;
  }
  
  public static int su()
  {
    GMTrace.i(4094714445824L, 30508);
    int i = com.tencent.mm.kernel.a.uT().getInt("settings_active_begin_time_min", 0);
    GMTrace.o(4094714445824L, 30508);
    return i;
  }
  
  public static int sv()
  {
    GMTrace.i(4094848663552L, 30509);
    int i = com.tencent.mm.kernel.a.uT().getInt("settings_active_end_time_min", 0);
    GMTrace.o(4094848663552L, 30509);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */