package com.tencent.mm.i;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.a.rr.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.a.d;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.h;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.p;
import java.util.List;
import java.util.Map;

public final class f
  extends a
{
  private static String TAG;
  
  static
  {
    GMTrace.i(4099680501760L, 30545);
    TAG = "MicroMsg.NotificationConfig";
    GMTrace.o(4099680501760L, 30545);
  }
  
  public static void aA(int paramInt1, int paramInt2)
  {
    GMTrace.i(4096325058560L, 30520);
    SharedPreferences localSharedPreferences = aa.bIO();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    localSharedPreferences = com.tencent.mm.kernel.a.uT();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    GMTrace.o(4096325058560L, 30520);
  }
  
  public static void aB(int paramInt1, int paramInt2)
  {
    GMTrace.i(4096459276288L, 30521);
    SharedPreferences localSharedPreferences = aa.bIO();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    localSharedPreferences = com.tencent.mm.kernel.a.uT();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    GMTrace.o(4096459276288L, 30521);
  }
  
  public static void aF(boolean paramBoolean)
  {
    GMTrace.i(4095251316736L, 30512);
    aa.bIO().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    com.tencent.mm.kernel.a.uT().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    GMTrace.o(4095251316736L, 30512);
  }
  
  public static void aG(boolean paramBoolean)
  {
    GMTrace.i(4095385534464L, 30513);
    aa.bIO().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    com.tencent.mm.kernel.a.uT().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    GMTrace.o(4095385534464L, 30513);
  }
  
  public static void aH(boolean paramBoolean)
  {
    GMTrace.i(4095519752192L, 30514);
    aa.bIO().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    com.tencent.mm.kernel.a.uT().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    GMTrace.o(4095519752192L, 30514);
  }
  
  public static void aI(boolean paramBoolean)
  {
    GMTrace.i(4095653969920L, 30515);
    com.tencent.mm.kernel.a.uT().edit().putBoolean("command_notification_status", paramBoolean).commit();
    v.i(TAG, "[NOTIFICATION SETTINGS]is notification by system: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    GMTrace.o(4095653969920L, 30515);
  }
  
  public static void aJ(boolean paramBoolean)
  {
    GMTrace.i(4095788187648L, 30516);
    aa.bIO().edit().putBoolean("settings_sound", paramBoolean).commit();
    com.tencent.mm.kernel.a.uT().edit().putBoolean("settings_sound", paramBoolean).commit();
    v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    GMTrace.o(4095788187648L, 30516);
  }
  
  public static void aK(boolean paramBoolean)
  {
    GMTrace.i(4095922405376L, 30517);
    aa.bIO().edit().putBoolean("settings_shake", paramBoolean).commit();
    com.tencent.mm.kernel.a.uT().edit().putBoolean("settings_shake", paramBoolean).commit();
    v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    GMTrace.o(4095922405376L, 30517);
  }
  
  public static void aL(boolean paramBoolean)
  {
    GMTrace.i(4096190840832L, 30519);
    aa.bIO().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    com.tencent.mm.kernel.a.uT().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    GMTrace.o(4096190840832L, 30519);
  }
  
  public static int d(au paramau)
  {
    GMTrace.i(4097935671296L, 30532);
    if (o.eV(paramau.field_talker)) {}
    for (int i = 0; (paramau != null) && (paramau.field_bizChatId != -1L) && (e.dr(paramau.field_talker)); i = 3)
    {
      com.tencent.mm.modelbiz.a.c localc = w.DJ().aa(paramau.field_bizChatId);
      if ((localc.DV()) || (!localc.fu(1))) {
        break;
      }
      GMTrace.o(4097935671296L, 30532);
      return i;
    }
    paramau = paramau.gxv;
    if (bf.mA(paramau))
    {
      GMTrace.o(4097935671296L, 30532);
      return i;
    }
    paramau = bg.q(paramau, "msgsource");
    if ((paramau == null) || (paramau.isEmpty()))
    {
      GMTrace.o(4097935671296L, 30532);
      return i;
    }
    try
    {
      int j = Integer.parseInt((String)paramau.get(".msgsource.tips"));
      i = j;
      j = i;
      if ((i & 0x1) == 0)
      {
        j = i;
        if ((i & 0x2) != 0) {
          j = 0;
        }
      }
      GMTrace.o(4097935671296L, 30532);
      return j;
    }
    catch (Exception paramau)
    {
      GMTrace.o(4097935671296L, 30532);
    }
    return i;
  }
  
  public static void dA(String paramString)
  {
    GMTrace.i(4096056623104L, 30518);
    a.dA(paramString);
    v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[] { paramString });
    GMTrace.o(4096056623104L, 30518);
  }
  
  public static boolean dD(String paramString)
  {
    GMTrace.i(4097264582656L, 30527);
    rr localrr = new rr();
    localrr.fYy.fJB = 1;
    localrr.fYy.content = paramString;
    com.tencent.mm.sdk.b.a.uql.m(localrr);
    if ((localrr.fYz.type == 2) || (paramString.equals(au.uIc)))
    {
      GMTrace.o(4097264582656L, 30527);
      return true;
    }
    GMTrace.o(4097264582656L, 30527);
    return false;
  }
  
  public static boolean dE(String paramString)
  {
    GMTrace.i(4097398800384L, 30528);
    rr localrr = new rr();
    localrr.fYy.fJB = 1;
    localrr.fYy.content = paramString;
    com.tencent.mm.sdk.b.a.uql.m(localrr);
    if ((localrr.fYz.type == 3) || (paramString.equals(au.uIb)))
    {
      GMTrace.o(4097398800384L, 30528);
      return true;
    }
    GMTrace.o(4097398800384L, 30528);
    return false;
  }
  
  public static int dF(String paramString)
  {
    GMTrace.i(4098472542208L, 30536);
    int i = p.F(paramString, null);
    GMTrace.o(4098472542208L, 30536);
    return i;
  }
  
  public static boolean dG(String paramString)
  {
    GMTrace.i(4098606759936L, 30537);
    boolean bool = x.eO(paramString);
    GMTrace.o(4098606759936L, 30537);
    return bool;
  }
  
  public static boolean dH(String paramString)
  {
    GMTrace.i(4098740977664L, 30538);
    boolean bool = paramString.toLowerCase().endsWith("@chatroom");
    GMTrace.o(4098740977664L, 30538);
    return bool;
  }
  
  public static boolean dI(String paramString)
  {
    GMTrace.i(4099009413120L, 30540);
    if ((o.fJ(paramString)) || ((o.dH(paramString)) && (!o.fI(paramString))))
    {
      GMTrace.o(4099009413120L, 30540);
      return true;
    }
    GMTrace.o(4099009413120L, 30540);
    return false;
  }
  
  public static int dJ(String paramString)
  {
    GMTrace.i(4099143630848L, 30541);
    ap.yY();
    int i = com.tencent.mm.u.c.wW().Ry(paramString);
    GMTrace.o(4099143630848L, 30541);
    return i;
  }
  
  public static boolean e(au paramau)
  {
    GMTrace.i(4099277848576L, 30542);
    if (paramau == null)
    {
      GMTrace.o(4099277848576L, 30542);
      return false;
    }
    boolean bool = paramau.RD(m.xL());
    GMTrace.o(4099277848576L, 30542);
    return bool;
  }
  
  public static void et(int paramInt)
  {
    GMTrace.i(4096727711744L, 30523);
    com.tencent.mm.kernel.a.uT().edit().putInt("notification.status.webonline.push.open", paramInt).commit();
    GMTrace.o(4096727711744L, 30523);
  }
  
  public static boolean eu(int paramInt)
  {
    GMTrace.i(4097130364928L, 30526);
    if ((paramInt == 50) || (paramInt == 53))
    {
      GMTrace.o(4097130364928L, 30526);
      return true;
    }
    GMTrace.o(4097130364928L, 30526);
    return false;
  }
  
  public static boolean sM()
  {
    GMTrace.i(4096593494016L, 30522);
    boolean bool = com.tencent.mm.u.c.eN(com.tencent.mm.kernel.a.uS());
    GMTrace.o(4096593494016L, 30522);
    return bool;
  }
  
  public static boolean sN()
  {
    GMTrace.i(4096861929472L, 30524);
    boolean bool = m.eV(com.tencent.mm.kernel.a.uT().getInt("notification.status.webonline.push.open", 0));
    GMTrace.o(4096861929472L, 30524);
    return bool;
  }
  
  public static void sO()
  {
    GMTrace.i(4096996147200L, 30525);
    SharedPreferences localSharedPreferences = aa.bIO();
    SharedPreferences.Editor localEditor = com.tencent.mm.kernel.a.uT().edit();
    boolean bool1 = localSharedPreferences.getBoolean("settings_new_msg_notification", true);
    localEditor.putBoolean("settings_new_msg_notification", bool1);
    localEditor.putBoolean("settings_new_voip_msg_notification", localSharedPreferences.getBoolean("settings_new_voip_msg_notification", true));
    boolean bool2 = localSharedPreferences.getBoolean("settings_show_detail", true);
    localEditor.putBoolean("settings_show_detail", bool2);
    boolean bool3 = localSharedPreferences.getBoolean("settings_sound", true);
    localEditor.putBoolean("settings_sound", bool3);
    String str = localSharedPreferences.getString("settings.ringtone", gST);
    localEditor.putString("settings.ringtone", str);
    boolean bool4 = localSharedPreferences.getBoolean("settings_shake", true);
    localEditor.putBoolean("settings_shake", bool4);
    boolean bool5 = localSharedPreferences.getBoolean("settings_active_time_full", true);
    localEditor.putBoolean("settings_active_time_full", bool5);
    int i = localSharedPreferences.getInt("settings_active_begin_time_hour", 8);
    localEditor.putInt("settings_active_begin_time_hour", i);
    int j = localSharedPreferences.getInt("settings_active_begin_time_min", 0);
    localEditor.putInt("settings_active_begin_time_min", j);
    int k = localSharedPreferences.getInt("settings_active_end_time_hour", 23);
    localEditor.putInt("settings_active_end_time_hour", k);
    int m = localSharedPreferences.getInt("settings_active_end_time_min", 0);
    localEditor.putInt("settings_active_end_time_min", m);
    localEditor.commit();
    v.i(TAG, "notification config copyDefault, newMsgNotification: %B, showDetail: %B, isSound: %B, ringTone: %s, isShake: %B, isActiveTime: %B, begin: %d:%d, end: %d:Td", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), str, Boolean.valueOf(bool4), Boolean.valueOf(bool5), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
    GMTrace.o(4096996147200L, 30525);
  }
  
  public static int sP()
  {
    GMTrace.i(4098069889024L, 30533);
    if (!ap.zb())
    {
      v.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      GMTrace.o(4098069889024L, 30533);
      return 0;
    }
    int i = p.fN(o.hkZ);
    GMTrace.o(4098069889024L, 30533);
    return i;
  }
  
  public static List<String> sQ()
  {
    GMTrace.i(4098204106752L, 30534);
    List localList = p.s(o.hkZ, -1);
    GMTrace.o(4098204106752L, 30534);
    return localList;
  }
  
  public static int sR()
  {
    GMTrace.i(4098338324480L, 30535);
    if (!ap.zb())
    {
      v.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
      GMTrace.o(4098338324480L, 30535);
      return 0;
    }
    int i = p.fM(o.hkZ);
    GMTrace.o(4098338324480L, 30535);
    return i;
  }
  
  public static int sS()
  {
    GMTrace.i(4098875195392L, 30539);
    int i = h.xI();
    GMTrace.o(4098875195392L, 30539);
    return i;
  }
  
  public static boolean sT()
  {
    GMTrace.i(4099412066304L, 30543);
    ap.yY();
    boolean bool = ((Boolean)com.tencent.mm.u.c.vr().get(73217, Boolean.valueOf(true))).booleanValue();
    GMTrace.o(4099412066304L, 30543);
    return bool;
  }
  
  public static boolean sU()
  {
    GMTrace.i(4099546284032L, 30544);
    ap.yY();
    boolean bool = ((Boolean)com.tencent.mm.u.c.vr().get(73218, Boolean.valueOf(true))).booleanValue();
    GMTrace.o(4099546284032L, 30544);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/i/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */