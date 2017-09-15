package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ao;

public final class z
{
  private static boolean hasInit;
  private static z ieY;
  private static boolean ifh;
  private s gJo;
  private ad handler;
  private aa ieZ;
  private ab ifa;
  private Context ifb;
  private a ifc;
  private y ifd;
  private x ife;
  private Looper iff;
  private v ifg;
  
  static
  {
    GMTrace.i(13660009267200L, 101775);
    hasInit = false;
    ifh = false;
    GMTrace.o(13660009267200L, 101775);
  }
  
  private z()
  {
    GMTrace.i(13656385388544L, 101748);
    GMTrace.o(13656385388544L, 101748);
  }
  
  private static z MG()
  {
    GMTrace.i(13656519606272L, 101749);
    if (ieY == null) {
      ieY = new z();
    }
    z localz = ieY;
    GMTrace.o(13656519606272L, 101749);
    return localz;
  }
  
  private static SharedPreferences MH()
  {
    GMTrace.i(13656653824000L, 101750);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences("notify_key_pref_no_account", 4);
    GMTrace.o(13656653824000L, 101750);
    return localSharedPreferences;
  }
  
  public static SharedPreferences MI()
  {
    GMTrace.i(13656788041728L, 101751);
    Object localObject2 = MH().getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (bf.mA((String)localObject2))
    {
      localObject2 = ao.hlE.A("login_weixin_username", "");
      localObject1 = localObject2;
      if (!bf.mA((String)localObject2))
      {
        MH().edit().putString("login_weixin_username", (String)localObject2).commit();
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((String)localObject1).replace("[\\/\\\\]", "#").trim();
    }
    localObject1 = "notify_key_pref" + (String)localObject2;
    localObject1 = com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences((String)localObject1, 4);
    GMTrace.o(13656788041728L, 101751);
    return (SharedPreferences)localObject1;
  }
  
  public static void MJ()
  {
    GMTrace.i(13656922259456L, 101752);
    SharedPreferences localSharedPreferences;
    int i;
    if (!hasInit)
    {
      localSharedPreferences = MI();
      long l = localSharedPreferences.getLong("wakeup_alarm_last_tick", 0L);
      i = localSharedPreferences.getInt("wakeup_alarm_last_cnt", 0);
      if ((l == 0L) || (l > bf.NA()))
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", new Object[] { Integer.valueOf(i) });
        localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bf.NA()).commit();
        localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
        GMTrace.o(13656922259456L, 101752);
        return;
      }
      if (bf.aA(l) <= 86400000L) {
        break label225;
      }
      localSharedPreferences.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
      localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bf.NA()).commit();
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      hasInit = true;
      GMTrace.o(13656922259456L, 101752);
      return;
      label225:
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", new Object[] { Integer.valueOf(i + 1) });
    }
  }
  
  public static boolean MK()
  {
    GMTrace.i(13657056477184L, 101753);
    String str = ao.hlE.A("login_user_name", "");
    Object localObject = str;
    if (str != null) {
      localObject = str.replace("[\\/\\\\]", "#").trim();
    }
    localObject = com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences("notify_key_pref" + (String)localObject, 4);
    int i = ((SharedPreferences)localObject).getInt("wakeup_alarm_launch_cnt", 0);
    int j = ((SharedPreferences)localObject).getInt("wakeup_alarm_last_cnt", 0);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i > 10)
    {
      i = 1;
      if (j <= 10) {
        break label139;
      }
    }
    label139:
    for (j = 1;; j = 0)
    {
      GMTrace.o(13657056477184L, 101753);
      return j | i;
      i = 0;
      break;
    }
  }
  
  public static aa ML()
  {
    GMTrace.i(13657190694912L, 101754);
    aa localaa = MG().ieZ;
    GMTrace.o(13657190694912L, 101754);
    return localaa;
  }
  
  public static ab MM()
  {
    GMTrace.i(13657459130368L, 101756);
    ab localab = MG().ifa;
    GMTrace.o(13657459130368L, 101756);
    return localab;
  }
  
  public static ad MN()
  {
    GMTrace.i(13657996001280L, 101760);
    ad localad = MG().handler;
    GMTrace.o(13657996001280L, 101760);
    return localad;
  }
  
  public static a MO()
  {
    GMTrace.i(13658264436736L, 101762);
    a locala = MG().ifc;
    GMTrace.o(13658264436736L, 101762);
    return locala;
  }
  
  public static s MP()
  {
    GMTrace.i(13658532872192L, 101764);
    s locals = MG().gJo;
    GMTrace.o(13658532872192L, 101764);
    return locals;
  }
  
  public static y MQ()
  {
    GMTrace.i(13658801307648L, 101766);
    y localy = MG().ifd;
    GMTrace.o(13658801307648L, 101766);
    return localy;
  }
  
  public static x MR()
  {
    GMTrace.i(13659069743104L, 101768);
    x localx = MG().ife;
    GMTrace.o(13659069743104L, 101768);
    return localx;
  }
  
  public static Looper MS()
  {
    GMTrace.i(13659338178560L, 101770);
    if (MG().iff == null)
    {
      localObject = e.Qt("MMPushCore_handlerThread");
      ((HandlerThread)localObject).start();
      MG().iff = ((HandlerThread)localObject).getLooper();
    }
    Object localObject = MG().iff;
    GMTrace.o(13659338178560L, 101770);
    return (Looper)localObject;
  }
  
  public static v MT()
  {
    GMTrace.i(13659472396288L, 101771);
    v localv = MG().ifg;
    GMTrace.o(13659472396288L, 101771);
    return localv;
  }
  
  public static boolean MU()
  {
    GMTrace.i(13659875049472L, 101774);
    MG();
    boolean bool = ifh;
    GMTrace.o(13659875049472L, 101774);
    return bool;
  }
  
  public static void a(aa paramaa)
  {
    GMTrace.i(13657324912640L, 101755);
    MG().ieZ = paramaa;
    GMTrace.o(13657324912640L, 101755);
  }
  
  public static void a(ab paramab)
  {
    GMTrace.i(13657593348096L, 101757);
    MG().ifa = paramab;
    GMTrace.o(13657593348096L, 101757);
  }
  
  public static void a(v paramv)
  {
    GMTrace.i(13659606614016L, 101772);
    MG().ifg = paramv;
    GMTrace.o(13659606614016L, 101772);
  }
  
  public static void a(x paramx)
  {
    GMTrace.i(13659203960832L, 101769);
    MG().ife = paramx;
    GMTrace.o(13659203960832L, 101769);
  }
  
  public static void a(y paramy)
  {
    GMTrace.i(13658935525376L, 101767);
    MG().ifd = paramy;
    GMTrace.o(13658935525376L, 101767);
  }
  
  public static void a(a parama)
  {
    GMTrace.i(13658398654464L, 101763);
    MG().ifc = parama;
    GMTrace.o(13658398654464L, 101763);
  }
  
  public static void a(ad paramad)
  {
    GMTrace.i(13658130219008L, 101761);
    MG().handler = paramad;
    GMTrace.o(13658130219008L, 101761);
  }
  
  public static void b(s params)
  {
    GMTrace.i(13658667089920L, 101765);
    MG().gJo = params;
    GMTrace.o(13658667089920L, 101765);
  }
  
  public static void bA(boolean paramBoolean)
  {
    GMTrace.i(13659740831744L, 101773);
    MG();
    ifh = paramBoolean;
    GMTrace.o(13659740831744L, 101773);
  }
  
  public static Context getContext()
  {
    GMTrace.i(13657727565824L, 101758);
    Context localContext = MG().ifb;
    GMTrace.o(13657727565824L, 101758);
    return localContext;
  }
  
  public static void setContext(Context paramContext)
  {
    GMTrace.i(13657861783552L, 101759);
    MG().ifb = paramContext;
    GMTrace.o(13657861783552L, 101759);
  }
  
  public static abstract interface a
  {
    public abstract void av(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */