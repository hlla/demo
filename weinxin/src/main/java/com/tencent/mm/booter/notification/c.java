package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.y.d;
import android.support.v4.app.y.g;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.e.a.ii;
import com.tencent.mm.e.a.ii.b;
import com.tencent.mm.e.a.v.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.LauncherUI;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
{
  public static String gLb;
  public static String gLc;
  public static String gLd;
  g fxi;
  Context mContext;
  
  static
  {
    GMTrace.i(508282535936L, 3787);
    gLb = "com.tencent.preference.notification.key.unread.msg";
    gLc = "com.tencent.preference.notification.key.unread.talker";
    gLd = "com.tencent.preference.notification.key.all.notified.msgid";
    GMTrace.o(508282535936L, 3787);
  }
  
  public c()
  {
    GMTrace.i(506135052288L, 3771);
    this.mContext = aa.getContext();
    this.fxi = new g(this.mContext);
    GMTrace.o(506135052288L, 3771);
  }
  
  public static void E(long paramLong)
  {
    GMTrace.i(507745665024L, 3783);
    if (paramLong == 0L)
    {
      GMTrace.o(507745665024L, 3783);
      return;
    }
    String str2 = qp();
    String str1 = str2;
    if (str2.length() > 3000) {
      str1 = str2.substring(str2.length() / 2, str2.length());
    }
    if (F(paramLong))
    {
      GMTrace.o(507745665024L, 3783);
      return;
    }
    str1 = str1 + paramLong + "%";
    f.sj().edit().putString(gLd, str1).apply();
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", new Object[] { str1 });
    GMTrace.o(507745665024L, 3783);
  }
  
  private static boolean F(long paramLong)
  {
    GMTrace.i(507879882752L, 3784);
    if (paramLong == 0L)
    {
      GMTrace.o(507879882752L, 3784);
      return false;
    }
    String str = qp();
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", new Object[] { str, Long.valueOf(paramLong) });
    if (str.contains(paramLong + "%"))
    {
      GMTrace.o(507879882752L, 3784);
      return true;
    }
    GMTrace.o(507879882752L, 3784);
    return false;
  }
  
  private static a a(List<a> paramList, String paramString)
  {
    GMTrace.i(507074576384L, 3778);
    if ((paramList == null) || (paramString == null))
    {
      GMTrace.o(507074576384L, 3778);
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if (locala.userName.equals(paramString))
      {
        GMTrace.o(507074576384L, 3778);
        return locala;
      }
    }
    GMTrace.o(507074576384L, 3778);
    return null;
  }
  
  public static boolean a(String paramString, au paramau, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(506403487744L, 3773);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (!ap.zb())
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      GMTrace.o(506403487744L, 3773);
      return false;
    }
    if ((paramau != null) && (F(paramau.field_msgSvrId)) && (!paramBoolean))
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", new Object[] { Long.valueOf(paramau.field_msgSvrId) });
      GMTrace.o(506403487744L, 3773);
      return false;
    }
    if ((paramInt & 0x1) == 0)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      GMTrace.o(506403487744L, 3773);
      return false;
    }
    ap.yY();
    if ((com.tencent.mm.u.c.wM()) && (!m.eV(m.xR())))
    {
      ap.yY();
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(com.tencent.mm.u.c.wM()), Boolean.valueOf(m.eV(m.xR())) });
      GMTrace.o(506403487744L, 3773);
      return false;
    }
    if (o.eQ(paramString))
    {
      paramau = new ii();
      paramau.fNK.fJr = 3;
      com.tencent.mm.sdk.b.a.uql.m(paramau);
      if (!paramau.fNL.fFa)
      {
        paramau = new ii();
        paramau.fNK.fJr = 1;
        paramau.fNK.fNM = paramString;
        paramau.fNK.fNN = 3;
        com.tencent.mm.sdk.b.a.uql.m(paramau);
      }
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      GMTrace.o(506403487744L, 3773);
      return false;
    }
    if ((o.fJ(paramString)) || ((o.dH(paramString)) && (!o.fI(paramString)) && (paramau != null) && (!paramau.RD(m.xL())) && (paramau.field_type != 64) && (paramau != null) && (!paramau.bMr())))
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      GMTrace.o(506403487744L, 3773);
      return false;
    }
    GMTrace.o(506403487744L, 3773);
    return true;
  }
  
  public static void d(ArrayList<a> paramArrayList)
  {
    GMTrace.i(507477229568L, 3781);
    if (paramArrayList == null)
    {
      f.sj().edit().putString(gLc, "").apply();
      if (paramArrayList != null) {
        break label149;
      }
    }
    label149:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadTalker %s", new Object[] { paramArrayList });
      GMTrace.o(507477229568L, 3781);
      return;
      try
      {
        ArrayList localArrayList = new ArrayList(paramArrayList);
        f.sj().edit().putString(gLc, com.tencent.mm.booter.notification.queue.c.a(localArrayList)).apply();
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
        f.sj().edit().putString(gLc, "").apply();
      }
      break;
    }
  }
  
  public static void dQ(int paramInt)
  {
    GMTrace.i(507611447296L, 3782);
    paramInt = Math.max(0, paramInt);
    f.sj().edit().putInt(gLb, paramInt).apply();
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", new Object[] { Integer.valueOf(paramInt) });
    GMTrace.o(507611447296L, 3782);
  }
  
  public static void ql()
  {
    GMTrace.i(508148318208L, 3786);
    f.sj().edit().putString(gLd, "").apply();
    GMTrace.o(508148318208L, 3786);
  }
  
  static Notification qm()
  {
    GMTrace.i(506269270016L, 3772);
    Notification localNotification = new Notification();
    localNotification.icon = R.g.icon;
    localNotification.ledARGB = -16711936;
    localNotification.ledOnMS = 300;
    localNotification.ledOffMS = 1000;
    GMTrace.o(506269270016L, 3772);
    return localNotification;
  }
  
  private static int qn()
  {
    GMTrace.i(507208794112L, 3779);
    int i = f.sj().getInt(gLb, 0);
    GMTrace.o(507208794112L, 3779);
    return i;
  }
  
  public static ArrayList<a> qo()
  {
    GMTrace.i(507343011840L, 3780);
    try
    {
      ArrayList localArrayList1 = (ArrayList)com.tencent.mm.booter.notification.queue.c.df(f.sj().getString(gLc, ""));
      if (localArrayList1 == null)
      {
        localArrayList1 = new ArrayList();
        GMTrace.o(507343011840L, 3780);
        return localArrayList1;
      }
      GMTrace.o(507343011840L, 3780);
      return localArrayList1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localClassNotFoundException, "", new Object[0]);
      ArrayList localArrayList2 = new ArrayList();
      GMTrace.o(507343011840L, 3780);
      return localArrayList2;
    }
    catch (IOException localIOException)
    {
      com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
      ArrayList localArrayList3 = new ArrayList();
      GMTrace.o(507343011840L, 3780);
      return localArrayList3;
    }
  }
  
  private static String qp()
  {
    GMTrace.i(508014100480L, 3785);
    String str = f.sj().getString(gLd, "");
    GMTrace.o(508014100480L, 3785);
    return str;
  }
  
  public final int a(NotificationItem paramNotificationItem, g paramg)
  {
    GMTrace.i(506537705472L, 3774);
    if ((!l.cB(this.mContext)) && (Build.VERSION.SDK_INT >= 16) && (paramNotificationItem != null) && (paramNotificationItem.so != null))
    {
      paramNotificationItem.so.priority = 1;
      if (!f.sk())
      {
        paramNotificationItem.so.vibrate = new long[0];
        if ((!paramg.gMk) && (!paramg.gMj)) {
          paramNotificationItem.so.priority = 0;
        }
      }
    }
    int i = super.a(paramNotificationItem, paramg);
    GMTrace.o(506537705472L, 3774);
    return i;
  }
  
  @TargetApi(21)
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt3, String paramString4, PendingIntent paramPendingIntent2, int paramInt4, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    GMTrace.i(506806140928L, 3776);
    Object localObject = paramNotification;
    int i;
    Notification localNotification;
    int j;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = new y.d(this.mContext);
      i = paramInt1;
      if (paramInt1 == -1) {
        i = com.tencent.mm.ba.a.bCc();
      }
      ((y.d)localObject).so.ledARGB = -16711936;
      ((y.d)localObject).so.ledOnMS = 300;
      ((y.d)localObject).so.ledOffMS = 1000;
      if ((((y.d)localObject).so.ledOnMS == 0) || (((y.d)localObject).so.ledOffMS == 0)) {
        break label426;
      }
      paramInt1 = 1;
      localNotification = ((y.d)localObject).so;
      j = ((y.d)localObject).so.flags;
      if (paramInt1 == 0) {
        break label431;
      }
    }
    label426:
    label431:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localNotification.flags = (paramInt1 | j & 0xFFFFFFFE);
      ((y.d)localObject).L(i).c(paramString3).rR = paramPendingIntent1;
      ((y.d)localObject).sj = true;
      if (paramString1 != null) {
        ((y.d)localObject).a(paramString1);
      }
      if (paramString2 != null) {
        ((y.d)localObject).b(paramString2);
      }
      ((y.d)localObject).so.defaults = paramInt2;
      if ((paramInt2 & 0x4) != 0)
      {
        paramPendingIntent1 = ((y.d)localObject).so;
        paramPendingIntent1.flags |= 0x1;
      }
      if (paramBitmap != null) {
        ((y.d)localObject).rU = paramBitmap;
      }
      if (paramNotification != null)
      {
        if (paramNotification.sound != null)
        {
          paramPendingIntent1 = paramNotification.sound;
          ((y.d)localObject).so.sound = paramPendingIntent1;
          ((y.d)localObject).so.audioStreamType = -1;
        }
        if (paramNotification.vibrate != null)
        {
          paramNotification = paramNotification.vibrate;
          ((y.d)localObject).so.vibrate = paramNotification;
        }
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (paramString4 != null) {
          ((y.d)localObject).a(paramInt3, paramString4, paramPendingIntent2);
        }
        if (paramString5 != null) {
          ((y.d)localObject).a(paramInt4, paramString5, paramPendingIntent3);
        }
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        ((y.d)localObject).sk = "msg";
        paramNotification = new com.tencent.mm.e.a.v();
        paramNotification.fCT.username = paramString6;
        paramNotification.fCT.title = paramString1;
        com.tencent.mm.sdk.b.a.uql.m(paramNotification);
        if (paramNotification.fCT.fCU != null) {
          paramNotification.fCT.fCU.a((y.d)localObject);
        }
      }
      localObject = ((y.d)localObject).getNotification();
      GMTrace.o(506806140928L, 3776);
      return (Notification)localObject;
      paramInt1 = 0;
      break;
    }
  }
  
  @TargetApi(11)
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    GMTrace.i(506671923200L, 3775);
    paramNotification = a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, 0, null, null, 0, null, null, paramString4);
    GMTrace.o(506671923200L, 3775);
    return paramNotification;
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(506940358656L, 3777);
    Context localContext = aa.getContext();
    boolean bool1 = e.qy();
    paramBoolean = e.qw();
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) });
    if (paramLong == 0L)
    {
      GMTrace.o(506940358656L, 3777);
      return;
    }
    if ((bf.mA(paramString1)) || (bf.mA(paramString2)) || (bf.mA(paramString3)))
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
      GMTrace.o(506940358656L, 3777);
      return;
    }
    if ((f.sM()) && (!f.sN()))
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
      GMTrace.o(506940358656L, 3777);
      return;
    }
    if (!f.sl())
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
      GMTrace.o(506940358656L, 3777);
      return;
    }
    if (F(paramLong))
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
      GMTrace.o(506940358656L, 3777);
      return;
    }
    com.tencent.mm.booter.notification.queue.b.qr().restore();
    int j = qn() + 1;
    Object localObject1 = a(qo(), paramString1);
    int i;
    Object localObject2;
    label289:
    int k;
    int m;
    int n;
    int i1;
    String str1;
    String str2;
    if (localObject1 == null)
    {
      i = 0;
      i += 1;
      localObject2 = qo();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject2 = a((List)localObject1, paramString1);
      if (localObject2 != null) {
        break label681;
      }
      localObject2 = new a();
      ((a)localObject2).userName = paramString1;
      ((a)localObject2).gLe = 1;
      ((ArrayList)localObject1).add(localObject2);
      d((ArrayList)localObject1);
      dQ(qn() + 1);
      k = ((ArrayList)localObject1).size();
      if (e.qv())
      {
        paramBoolean = false;
        bool1 = false;
      }
      localObject1 = qm();
      m = com.tencent.mm.booter.notification.queue.b.qr().de(paramString1);
      this.fxi.gMe = j;
      this.fxi.gMd = k;
      this.fxi.gMk = bool1;
      this.fxi.gMj = paramBoolean;
      boolean bool2 = f.sn();
      n = com.tencent.mm.ba.a.bCc();
      localObject2 = this.fxi;
      ((g)localObject2).gLW.a(((g)localObject2).mContext, paramBoolean, bool1, (Notification)localObject1, null);
      i1 = ((g)localObject2).gLW.gLJ;
      localObject2 = new Intent(localContext, LauncherUI.class);
      ((Intent)localObject2).putExtra("nofification_type", "new_msg_nofification");
      ((Intent)localObject2).putExtra("Main_User", paramString1);
      ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", paramInt);
      ((Intent)localObject2).addFlags(536870912);
      ((Intent)localObject2).addFlags(67108864);
      if (!bool2) {
        break label696;
      }
      ((Intent)localObject2).putExtra("talkerCount", 1);
      ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", false);
      ((Intent)localObject2).putExtra("pushcontent_unread_count", j);
      localObject2 = com.tencent.mm.booter.notification.a.d.a(localContext, m, (Intent)localObject2);
      str1 = h.c(localContext, paramString2, bool2);
      str2 = h.a(localContext, paramString3, k, j, i, bool2);
      paramString3 = h.d(localContext, paramString3, bool2);
      if (!f.sn()) {
        break label739;
      }
    }
    label681:
    label696:
    label739:
    for (paramString2 = com.tencent.mm.booter.notification.a.a.b(localContext, com.tencent.mm.booter.notification.a.a.u(paramString1, paramString4));; paramString2 = null)
    {
      paramString2 = new NotificationItem(m, paramString1, a((Notification)localObject1, n, i1, (PendingIntent)localObject2, str1, str2, paramString3, paramString2, paramString1));
      paramString2.gLu = paramLong;
      paramString2.gLv = i;
      a(paramString2, this.fxi);
      d.dR(this.fxi.gMe);
      d.m(paramString1, i);
      GMTrace.o(506940358656L, 3777);
      return;
      i = ((a)localObject1).gLe;
      break;
      ((a)localObject2).gLe += 1;
      break label289;
      if (k <= 1) {
        ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", false);
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("talkerCount", k);
        break;
        ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
      }
    }
  }
  
  private static final class a
    implements Serializable
  {
    public int gLe;
    public String userName;
    
    public a()
    {
      GMTrace.i(533381251072L, 3974);
      GMTrace.o(533381251072L, 3974);
    }
    
    public final String toString()
    {
      GMTrace.i(533515468800L, 3975);
      String str = "[" + this.userName + "(" + this.gLe + ")]";
      GMTrace.o(533515468800L, 3975);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/notification/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */