package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.jm;
import com.tencent.mm.e.a.jm.a;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.e.a.nx;
import com.tencent.mm.e.a.nx.a;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.a.k;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.platformtools.l.1;
import com.tencent.mm.platformtools.l.2;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.bbom.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.u.o;
import com.tencent.mm.u.p;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.u.af, ai
{
  Context context;
  String fJC;
  au fTa;
  private String gKN;
  private String gKO;
  String gKP;
  Intent gKQ;
  private boolean gKR;
  private int gKS;
  private boolean gKT;
  private long gKU;
  f gKV;
  private com.tencent.mm.booter.notification.a.e gKW;
  @SuppressLint({"HandlerLeak"})
  ad gKX;
  private final com.tencent.mm.sdk.b.c gKY;
  private final com.tencent.mm.sdk.b.c gKZ;
  
  public b(Context paramContext)
  {
    GMTrace.i(514724986880L, 3835);
    this.context = null;
    this.gKV = f.a.gLA;
    this.gKX = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(533247033344L, 3973);
        super.handleMessage(paramAnonymousMessage);
        com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", true).apply();
        String str1 = paramAnonymousMessage.getData().getString("notification.show.talker");
        String str2 = paramAnonymousMessage.getData().getString("notification.show.message.content");
        int i = paramAnonymousMessage.getData().getInt("notification.show.message.type");
        int j = paramAnonymousMessage.getData().getInt("notification.show.tipsflag");
        v.i("MicroMsg.MMNotification", "notify need to deal: %s", new Object[] { str1 });
        try
        {
          if (paramAnonymousMessage.what == 1)
          {
            b.this.a(str1, str2, i, j, true);
            GMTrace.o(533247033344L, 3973);
            return;
          }
          b.this.a(str1, str2, i, j, false);
          GMTrace.o(533247033344L, 3973);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          v.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousMessage, "showNotifiHandler", new Object[0]);
          GMTrace.o(533247033344L, 3973);
        }
      }
    };
    this.gKY = new com.tencent.mm.sdk.b.c() {};
    this.gKZ = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(nx paramAnonymousnx)
      {
        GMTrace.i(522375397376L, 3892);
        Object localObject1;
        int i;
        if ((paramAnonymousnx != null) && ((paramAnonymousnx instanceof nx)))
        {
          localObject1 = paramAnonymousnx.fUT.fTz;
          i = paramAnonymousnx.fUT.msgType;
          paramAnonymousnx = b.this;
        }
        try
        {
          v.w("showSendMsgFailNotification fromUserName:%s msgType:%d", (String)localObject1, new Object[] { Integer.valueOf(i) });
          Object localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramAnonymousnx.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
          if (!En_5b8fbb1e.class.getName().equals(((ComponentName)localObject2).getClassName()))
          {
            localObject2 = new Intent(paramAnonymousnx.context, En_5b8fbb1e.class);
            ((Intent)localObject2).putExtra("nofification_type", "pushcontent_notification");
            ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", i);
            ((Intent)localObject2).addFlags(536870912);
            ((Intent)localObject2).addFlags(67108864);
            localObject1 = PendingIntent.getActivity(paramAnonymousnx.context, 35, (Intent)localObject2, 1073741824);
            localObject1 = new Notification.Builder(paramAnonymousnx.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(paramAnonymousnx.context.getString(R.l.dIh)).setContentText(paramAnonymousnx.context.getString(R.l.eAJ)).setContentIntent((PendingIntent)localObject1).getNotification();
            ((Notification)localObject1).icon = com.tencent.mm.ba.a.bCc();
            ((Notification)localObject1).defaults |= 0x1;
            ((Notification)localObject1).flags |= 0x10;
            paramAnonymousnx.a(35, (Notification)localObject1, true);
          }
          GMTrace.o(522375397376L, 3892);
          return false;
        }
        catch (Exception paramAnonymousnx)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousnx, "", new Object[0]);
          }
        }
      }
    };
    this.context = paramContext;
    this.fJC = "";
    this.gKP = "";
    this.gKN = "";
    this.gKU = 0L;
    this.gKT = false;
    this.gKQ = null;
    this.gKW = new com.tencent.mm.booter.notification.a.e();
    n.a(this);
    com.tencent.mm.modelvoice.e.a(this);
    com.tencent.mm.plugin.base.stub.b.a(this);
    com.tencent.mm.sdk.b.a.uql.b(this.gKZ);
    com.tencent.mm.sdk.b.a.uql.b(this.gKY);
    GMTrace.o(514724986880L, 3835);
  }
  
  static Message a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(515932946432L, 3844);
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("notification.show.talker", paramString1);
    localBundle.putString("notification.show.message.content", paramString2);
    localBundle.putInt("notification.show.message.type", paramInt1);
    localBundle.putInt("notification.show.tipsflag", paramInt2);
    localMessage.setData(localBundle);
    localMessage.what = paramInt3;
    GMTrace.o(515932946432L, 3844);
    return localMessage;
  }
  
  private void cancel()
  {
    GMTrace.i(515664510976L, 3842);
    this.gKT = false;
    e.cancel();
    GMTrace.o(515664510976L, 3842);
  }
  
  public final int a(Notification paramNotification, boolean paramBoolean)
  {
    GMTrace.i(518214647808L, 3861);
    int i = f.a.gLA.a(new NotificationItem(paramNotification, paramBoolean));
    GMTrace.o(518214647808L, 3861);
    return i;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    GMTrace.i(518751518720L, 3865);
    paramNotification = f.a.gLA.gLz.gLr.a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    GMTrace.o(518751518720L, 3865);
    return paramNotification;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt2, String paramString4, PendingIntent paramPendingIntent2, int paramInt3, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    GMTrace.i(517006688256L, 3852);
    paramNotification = f.a.gLA.gLz.gLr.a(paramNotification, paramInt1, 1, paramPendingIntent1, paramString1, paramString2, paramString3, paramBitmap, paramInt2, paramString4, paramPendingIntent2, paramInt3, paramString5, paramPendingIntent3, paramString6);
    GMTrace.o(517006688256L, 3852);
    return paramNotification;
  }
  
  public final Notification a(PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    GMTrace.i(518617300992L, 3864);
    paramPendingIntent = a(null, -1, 0, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    GMTrace.o(518617300992L, 3864);
    return paramPendingIntent;
  }
  
  public final void a(int paramInt, Notification paramNotification, boolean paramBoolean)
  {
    GMTrace.i(518080430080L, 3860);
    f.a.gLA.a(new NotificationItem(paramInt, paramNotification, paramBoolean));
    GMTrace.o(518080430080L, 3860);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    GMTrace.i(516872470528L, 3851);
    com.tencent.mm.bb.d.a("webview", new l.1(paramString3, paramString4, paramBundle, paramString1, paramString2, paramInt), new l.2());
    GMTrace.o(516872470528L, 3851);
  }
  
  public final void a(au paramau)
  {
    GMTrace.i(515798728704L, 3843);
    if (paramau == null)
    {
      GMTrace.o(515798728704L, 3843);
      return;
    }
    if (paramau.field_isSend == 1)
    {
      v.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[] { Long.valueOf(paramau.field_msgSvrId) });
      GMTrace.o(515798728704L, 3843);
      return;
    }
    Object localObject = ay.gm(paramau.gxv);
    if ((localObject != null) && (((ay.b)localObject).scene == 1))
    {
      GMTrace.o(515798728704L, 3843);
      return;
    }
    int i = com.tencent.mm.i.f.d(paramau);
    this.fTa = paramau;
    this.fJC = paramau.field_talker;
    localObject = paramau.field_content;
    int j = paramau.field_type;
    this.gKP = "";
    this.gKQ = null;
    v.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.fJC, Long.valueOf(paramau.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bf.Qi((String)localObject) });
    if (!this.gKV.a(this.fJC, this.fTa, i, false))
    {
      v.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
      GMTrace.o(515798728704L, 3843);
      return;
    }
    this.gKX.sendMessageDelayed(a(this.fJC, (String)localObject, j, i, 0), 200L);
    GMTrace.o(515798728704L, 3843);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(16010161684480L, 119285);
    v.i("MicroMsg.MMNotification", "jacks dealNotify, talker:%s, msgtype:%d, tipsFlag:%d, isRevokeMesasge:%B content:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), bf.Qi(paramString2) });
    int n;
    int m;
    boolean bool1;
    if (paramBoolean)
    {
      localObject1 = new boolean[2];
      Object tmp67_65 = localObject1;
      tmp67_65[0] = 0;
      Object tmp73_67 = tmp67_65;
      tmp73_67[1] = 0;
      tmp73_67;
      n = localObject1[0];
      m = localObject1[1];
      if ((n != 0) || (m != 0)) {
        break label743;
      }
      bool1 = true;
      label105:
      v.d("MicroMsg.MMNotification", "updateNotifyInfo: silent = " + bool1);
      this.gKT = true;
      if (!bool1)
      {
        v.d("MicroMsg.MMNotification", "updateNotifyInfo : modify lastNotSilentTime = " + this.gKU);
        this.gKU = System.currentTimeMillis();
      }
      localObject2 = this.gKV;
      localObject1 = this.gKN;
      localObject2 = ((f)localObject2).gLz.gLr;
      v.d("MicroMsg.Notification.AppMsg.Handle", "dealCurChattingTalker, talker: %s, curChattingTalker: %s, needSound: %B, needShake: %B", new Object[] { paramString1, localObject1, Boolean.valueOf(n), Boolean.valueOf(m) });
      if ((bf.mA(paramString1)) || (bf.mA((String)localObject1)) || (!paramString1.equals(localObject1))) {
        break label862;
      }
      if (((m != 0) || (n != 0)) && (com.tencent.mm.i.f.sl())) {
        break label749;
      }
      v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] is current talker chatroom & no shake & no sound");
      paramInt2 = 1;
    }
    Object localObject3;
    boolean bool3;
    long l;
    for (;;)
    {
      if (paramInt2 == 0) {
        break label868;
      }
      v.w("MicroMsg.MMNotification", "[no notificaion], iscurrent Chatting Talker true, talker[%s] curChattingTalker[%s] needSound[%B] needShake[%B]", new Object[] { paramString1, this.gKN, Boolean.valueOf(n), Boolean.valueOf(m) });
      GMTrace.o(16010161684480L, 119285);
      return;
      localObject2 = this.gKW;
      localObject3 = this.fTa;
      bool3 = this.gKT;
      l = this.gKU;
      localObject1 = new boolean[2];
      Object tmp367_365 = localObject1;
      tmp367_365[0] = 1;
      Object tmp373_367 = tmp367_365;
      tmp373_367[1] = 1;
      tmp373_367;
      if (!com.tencent.mm.booter.notification.a.e.a((boolean[])localObject1, com.tencent.mm.booter.notification.a.e.qw(), com.tencent.mm.booter.notification.a.e.qy()))
      {
        if (com.tencent.mm.booter.notification.a.e.qv()) {
          break label653;
        }
        bool1 = true;
        label403:
        if (!com.tencent.mm.booter.notification.a.e.a((boolean[])localObject1, bool1))
        {
          if (com.tencent.mm.booter.notification.a.e.dh(paramString1)) {
            break label659;
          }
          bool1 = true;
          label423:
          if ((!com.tencent.mm.booter.notification.a.e.a((boolean[])localObject1, bool1)) && (!com.tencent.mm.booter.notification.a.e.a((boolean[])localObject1, com.tencent.mm.booter.notification.a.e.dV(paramInt2), com.tencent.mm.booter.notification.a.e.dW(paramInt2))))
          {
            ((com.tencent.mm.booter.notification.a.e)localObject2).gLM = false;
            if (!ac.Pu("keep_app_silent")) {
              break label665;
            }
            ((com.tencent.mm.booter.notification.a.e)localObject2).gLM = true;
            label472:
            if (((com.tencent.mm.booter.notification.a.e)localObject2).gLM) {
              break label713;
            }
            bool1 = true;
            label483:
            v.i("MicroMsg.Notification.Silent.Handle", "check Refresh Keep is NOT Silent: %B", new Object[] { Boolean.valueOf(bool1) });
            if (((com.tencent.mm.booter.notification.a.e)localObject2).gLM) {
              break label719;
            }
            bool1 = true;
            label515:
            if (!com.tencent.mm.booter.notification.a.e.a((boolean[])localObject1, bool1))
            {
              if (com.tencent.mm.booter.notification.a.e.a(paramString1, (au)localObject3)) {
                break label725;
              }
              bool1 = true;
              label537:
              if (!com.tencent.mm.booter.notification.a.e.a((boolean[])localObject1, bool1))
              {
                if (localObject1[0] != 0)
                {
                  k = localObject1[0];
                  if (com.tencent.mm.booter.notification.a.e.dg(paramString1)) {
                    break label731;
                  }
                  paramInt2 = 1;
                  label570:
                  localObject1[0] = (paramInt2 & k);
                }
                if (localObject1[0] != 0) {
                  localObject1[0] &= com.tencent.mm.booter.notification.a.e.k(paramInt1, paramString2);
                }
                if (com.tencent.mm.booter.notification.a.e.qx()) {
                  break label737;
                }
              }
            }
          }
        }
      }
      label653:
      label659:
      label665:
      label713:
      label719:
      label725:
      label731:
      label737:
      for (int k = 1;; k = 0)
      {
        com.tencent.mm.booter.notification.a.e.a((boolean[])localObject1, k);
        v.i("MicroMsg.Notification.Silent.Handle", "finally silent, sound: %B, shake: %B", new Object[] { Boolean.valueOf(localObject1[0]), Boolean.valueOf(localObject1[1]) });
        break;
        k = 0;
        break label403;
        k = 0;
        break label423;
        if (l <= 0L)
        {
          ((com.tencent.mm.booter.notification.a.e)localObject2).gLM = false;
          break label472;
        }
        if ((System.currentTimeMillis() <= l) || (System.currentTimeMillis() >= l + 5000L)) {
          break label472;
        }
        ((com.tencent.mm.booter.notification.a.e)localObject2).gLM = bool3;
        break label472;
        k = 0;
        break label483;
        k = 0;
        break label515;
        k = 0;
        break label537;
        paramInt2 = 0;
        break label570;
      }
      label743:
      k = 0;
      break label105;
      label749:
      v.i("MicroMsg.Notification.AppMsg.Handle", "notification.shake: curChatting needShake~: %B", new Object[] { Boolean.valueOf(bool3) });
      bf.k(((c)localObject2).mContext, bool3);
      if (n != 0)
      {
        localObject3 = com.tencent.mm.i.f.sp();
        v.i("MicroMsg.Notification.AppMsg.Handle", "notification.playSound: curChattingTalker: %s", new Object[] { localObject3 });
        ((c)localObject2).fxi.dj((String)localObject3);
      }
      v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] is current talker end. talker[%s], current ChattingTalker[%s]. shake %B, sound: %B", new Object[] { paramString1, localObject1, Boolean.valueOf(bool3), Boolean.valueOf(n) });
      paramInt2 = 1;
      continue;
      label862:
      paramInt2 = 0;
    }
    label868:
    Object localObject1 = this.gKV;
    boolean bool2 = this.gKR;
    localObject1 = ((f)localObject1).gLz.gLr;
    if (bool2) {
      if (((!bool3) && (n == 0)) || (!com.tencent.mm.i.f.sl()))
      {
        v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] is mainUI & no shake & no sound");
        paramInt2 = 1;
      }
    }
    while (paramInt2 != 0)
    {
      v.w("MicroMsg.MMNotification", "[no notificaion], isMainUI true, needSound[%B] needShake[%B]", new Object[] { Boolean.valueOf(n), Boolean.valueOf(bool3) });
      GMTrace.o(16010161684480L, 119285);
      return;
      v.i("MicroMsg.Notification.AppMsg.Handle", "notification.shake: mainUI needShake~: %B", new Object[] { Boolean.valueOf(bool3) });
      if ((bool3) && (com.tencent.mm.i.f.sq())) {
        bf.k(((c)localObject1).mContext, bool3);
      }
      if ((n != 0) && (com.tencent.mm.i.f.so()))
      {
        localObject2 = com.tencent.mm.i.f.sp();
        v.i("MicroMsg.Notification.AppMsg.Handle", "notification.playSound: is mainUItalker: %s", new Object[] { localObject2 });
        ((c)localObject1).fxi.dj((String)localObject2);
      }
      v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] is mainUI end. shake %B, sound: %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(n) });
      paramInt2 = 1;
      continue;
      paramInt2 = 0;
    }
    if (paramInt1 == 436207665)
    {
      localObject2 = com.tencent.mm.t.f.a.ek(bf.PW(paramString2));
      if (localObject2 != null) {
        v.e("MicroMsg.MMNotification", "ljd:c2c hongbao message for c2cShowNotification is " + ((com.tencent.mm.t.f.a)localObject2).hiT);
      }
      localObject1 = new ArrayList();
      localObject3 = new IDKey();
      ((IDKey)localObject3).SetID(313);
      ((IDKey)localObject3).SetKey(0);
      ((IDKey)localObject3).SetValue(1);
      ((ArrayList)localObject1).add(localObject3);
      if ((localObject2 != null) && ("1002".equals(((com.tencent.mm.t.f.a)localObject2).hiL)) && (((com.tencent.mm.t.f.a)localObject2).hiT == 1))
      {
        paramString1 = new IDKey();
        paramString1.SetID(313);
        paramString1.SetKey(1);
        paramString1.SetValue(1);
        ((ArrayList)localObject1).add(paramString1);
        com.tencent.mm.plugin.report.service.g.oSF.b((ArrayList)localObject1, true);
        v.e("MicroMsg.MMNotification", "ljd:c2c hongbao message for notification is hide!");
        GMTrace.o(16010161684480L, 119285);
        return;
      }
      if ((localObject2 != null) && ("1002".equals(((com.tencent.mm.t.f.a)localObject2).hiL)))
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(313);
        ((IDKey)localObject2).SetKey(2);
        ((IDKey)localObject2).SetValue(1);
        ((ArrayList)localObject1).add(localObject2);
        com.tencent.mm.plugin.report.service.g.oSF.b((ArrayList)localObject1, true);
        v.i("MicroMsg.MMNotification", "ljd:c2c hongbao message for notification is show!");
      }
    }
    if (paramInt1 == 318767153)
    {
      ap.yY();
      if (!com.tencent.mm.u.c.vr().c(w.a.uCW, true))
      {
        v.i("MicroMsg.MMNotification", "It is a service notify message and the show tips switch is off. So do not show notification.");
        GMTrace.o(16010161684480L, 119285);
        return;
      }
    }
    if ((this.fTa != null) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).em(this.fTa.field_talker)))
    {
      ap.yY();
      if (!com.tencent.mm.u.c.vr().c(w.a.uCX, true))
      {
        v.i("MicroMsg.MMNotification", "It is a wxa custom session notify message and the show tips switch is off. So do not show notification.");
        GMTrace.o(16010161684480L, 119285);
        return;
      }
    }
    Object localObject2 = this.gKV;
    c localc;
    if (this.fTa == null)
    {
      l = 0L;
      localObject3 = this.gKP;
      localObject1 = this.gKQ;
      localObject2 = ((f)localObject2).gLz;
      if (!com.tencent.mm.i.f.sn()) {
        e.cancel();
      }
      localc = ((e)localObject2).gLr;
      v.i("MicroMsg.Notification.AppMsg.Handle", "in sample Notify: needSound: %B, needShake: %B, msgContent: ==, msgType: %d, talker: %s, customNotify: %s, isRevokeMessage:%b", new Object[] { Boolean.valueOf(n), Boolean.valueOf(bool3), Integer.valueOf(paramInt1), paramString1, localObject3, Boolean.valueOf(paramBoolean) });
      if (com.tencent.mm.i.f.sl()) {
        break label1671;
      }
      v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
    }
    for (;;)
    {
      paramString2 = new jm();
      paramString2.fPL.fJC = paramString1;
      localObject1 = paramString2.fPL;
      if (n != 0) {
        break label3960;
      }
      paramBoolean = true;
      ((jm.a)localObject1).fPM = paramBoolean;
      paramString2.fPL.fPN = bool3;
      paramString2.fPL.fCB = com.tencent.mm.i.f.dF(paramString1);
      com.tencent.mm.sdk.b.a.uql.m(paramString2);
      this.gKS = p.fN(o.hkZ);
      GMTrace.o(16010161684480L, 119285);
      return;
      l = this.fTa.field_msgSvrId;
      break;
      label1671:
      if ((com.tencent.mm.i.f.sm()) || ((paramInt1 != 64) && (paramInt1 != 50) && (paramInt1 != 52) && (paramInt1 != 53))) {
        break label1727;
      }
      v.i("MicroMsg.Notification.AppMsg.Handle", "NotificationConfig.isNewVoipMsgNotification() is false,msgType is " + paramInt1);
    }
    label1727:
    String str;
    if (com.tencent.mm.i.f.dG(paramString1))
    {
      str = "@bottle";
      label1739:
      localObject2 = localc.fxi;
      if (!com.tencent.mm.i.f.dG(str)) {
        break label1856;
      }
      paramInt2 = com.tencent.mm.i.f.sS();
      label1759:
      ((com.tencent.mm.booter.notification.a.g)localObject2).gMf = paramInt2;
      ((com.tencent.mm.booter.notification.a.g)localObject2).gMd = com.tencent.mm.i.f.sP();
      ((com.tencent.mm.booter.notification.a.g)localObject2).gMe = com.tencent.mm.i.f.sR();
      ((com.tencent.mm.booter.notification.a.g)localObject2).gMc = com.tencent.mm.i.f.dF(str);
      if ((!paramBoolean) || (localc.fxi.gMd > 0) || (localc.fxi.gMe > 0) || (localc.fxi.gMg)) {
        break label1862;
      }
    }
    label1856:
    label1862:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (paramInt2 == 0) {
        break label1868;
      }
      v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] no refresh notify by revoke");
      break;
      str = paramString1;
      break label1739;
      paramInt2 = 0;
      break label1759;
    }
    label1868:
    Notification localNotification = c.qm();
    com.tencent.mm.booter.notification.a.g localg = localc.fxi;
    label1902:
    Object localObject4;
    int i;
    com.tencent.mm.booter.notification.a.h localh;
    Context localContext;
    label2111:
    Object localObject5;
    Object localObject6;
    boolean bool4;
    if (localg.gMf == -1)
    {
      if (com.tencent.mm.i.f.dG(str))
      {
        paramInt2 = com.tencent.mm.i.f.sS();
        localg.gMf = paramInt2;
      }
    }
    else
    {
      if (localg.gMd == -1) {
        localg.gMd = com.tencent.mm.i.f.sP();
      }
      if (localg.gMe == -1) {
        localg.gMe = com.tencent.mm.i.f.sR();
      }
      if (localg.gMc == -1) {
        localg.gMc = com.tencent.mm.i.f.dF(str);
      }
      localg.gMg = com.tencent.mm.i.f.sn();
      localg.gMj = n;
      localg.gMk = bool3;
      localg.gLW.a(localg.mContext, n, bool3, localNotification, paramString2);
      localg.gLX.o(paramString2, paramInt1);
      localObject2 = localg.gLY;
      localObject4 = localg.mContext;
      i = localg.gMd;
      paramInt2 = localg.gMf;
      bool2 = localg.gMg;
      if (localObject1 == null) {
        break label2638;
      }
      ((com.tencent.mm.booter.notification.a.d)localObject2).PC = ((Intent)localObject1);
      if (!localg.gMg) {
        break label3663;
      }
      localh = localg.gLZ;
      localContext = localg.mContext;
      paramInt2 = localg.gMf;
      i = localg.gMc;
      bool2 = com.tencent.mm.i.f.dG(str);
      if (paramInt2 < 0) {
        break label2846;
      }
      if (!bool2) {
        break label2854;
      }
      paramInt1 = Math.max(1, paramInt2);
      localObject4 = localContext.getString(R.l.esz);
      localObject1 = localContext.getResources().getQuantityString(R.j.dsn, paramInt1, new Object[] { Integer.valueOf(paramInt1) });
      localObject5 = localObject1;
      ap.yY();
      localObject6 = com.tencent.mm.u.c.wT().Ag(str);
      bool2 = com.tencent.mm.i.f.dH(str);
      if (!bool2) {
        break label3979;
      }
      paramInt1 = com.tencent.mm.i.f.dJ(str);
      bool4 = com.tencent.mm.i.f.dI(str);
      if (paramInt1 <= 0) {
        break label3979;
      }
      localObject2 = new StringBuilder().append(localContext.getString(R.l.eyJ));
      if (bool4) {
        break label3194;
      }
      if (i <= 1) {
        break label3172;
      }
    }
    label2238:
    label2260:
    label2270:
    label2319:
    label2335:
    label2437:
    label2507:
    label2638:
    label2774:
    label2779:
    label2833:
    label2846:
    label2854:
    label2868:
    label3159:
    label3172:
    label3194:
    label3648:
    label3663:
    label3701:
    label3706:
    label3729:
    label3845:
    label3853:
    label3860:
    label3897:
    label3917:
    label3946:
    label3960:
    label3979:
    for (localObject2 = (String)localObject1;; localObject2 = localObject1)
    {
      if (paramBoolean)
      {
        localObject1 = null;
        paramInt1 = 0;
      }
      for (;;)
      {
        if (paramBoolean) {
          if (bool2)
          {
            if (i <= 1) {
              break label3648;
            }
            paramString2 = localContext.getResources().getQuantityString(R.j.dso, i, new Object[] { Integer.valueOf(i) }) + paramString2;
            localh.mTitle = ((String)localObject4);
            localh.gMl = paramString2;
            paramString2 = localh;
            paramString2.gMm = ((String)localObject1);
            localObject1 = localg.gMb;
            paramBoolean = localg.gMg;
            if ((!paramBoolean) && (((com.tencent.mm.booter.notification.a.a)localObject1).gLI != null))
            {
              v.i("MicroMsg.NotificationAvatar", "recycle bitmap:%s", new Object[] { ((com.tencent.mm.booter.notification.a.a)localObject1).gLI.toString() });
              ((com.tencent.mm.booter.notification.a.a)localObject1).gLI.recycle();
            }
            ((com.tencent.mm.booter.notification.a.a)localObject1).gLI = null;
            paramString2 = com.tencent.mm.sdk.platformtools.aa.getContext();
            if ((paramBoolean) && (!com.tencent.mm.i.f.dG(str)))
            {
              if ((paramString2 != null) && (!u.mA(str))) {
                break label3917;
              }
              paramString2 = null;
              ((com.tencent.mm.booter.notification.a.a)localObject1).gLI = paramString2;
            }
            paramInt1 = com.tencent.mm.booter.notification.queue.b.qr().de(str);
            paramInt2 = localc.fxi.gLX.gLK;
            i = localc.fxi.gLW.gLJ;
            localObject1 = localc.fxi;
            paramString2 = ((com.tencent.mm.booter.notification.a.g)localObject1).gLY;
            localObject1 = ((com.tencent.mm.booter.notification.a.g)localObject1).mContext;
            if (paramString2.PC != null) {
              break label3946;
            }
            paramString2 = null;
            paramString2 = new NotificationItem(paramInt1, str, localc.a(localNotification, paramInt2, i, paramString2, localc.fxi.gLZ.mTitle, localc.fxi.gLZ.gMl, localc.fxi.gLZ.gMm, localc.fxi.gMb.gLI, str));
            paramString2.gLu = l;
            paramString2.gLv = com.tencent.mm.i.f.dF(str);
            localc.a(paramString2, localc.fxi);
            paramString2 = localc.fxi;
            paramString2.gMf = -1;
            paramString2.gMd = -1;
            paramString2.gMe = -1;
            paramString2.gMc = -1;
            break;
            paramInt2 = 0;
            break label1902;
            bool4 = com.tencent.mm.i.f.dI(str);
            if (paramInt2 >= 0) {}
            for (;;)
            {
              localObject1 = new Intent((Context)localObject4, LauncherUI.class);
              ((Intent)localObject1).putExtra("nofification_type", "new_msg_nofification");
              ((Intent)localObject1).putExtra("Main_User", str);
              ((Intent)localObject1).putExtra("MainUI_User_Last_Msg_Type", paramInt1);
              ((Intent)localObject1).addFlags(536870912);
              ((Intent)localObject1).addFlags(67108864);
              if (!bool2) {
                break label2774;
              }
              ((Intent)localObject1).putExtra("talkerCount", 1);
              if (!bool4)
              {
                ((Intent)localObject1).putExtra("Intro_Is_Muti_Talker", false);
                ((Intent)localObject1).putExtra("Intro_Bottle_unread_count", paramInt2);
              }
              ((com.tencent.mm.booter.notification.a.d)localObject2).PC = ((Intent)localObject1);
              break;
              paramInt2 = com.tencent.mm.i.f.sS();
            }
            if (i >= 0)
            {
              if ((i > 1) || (bool4)) {
                break label2833;
              }
              ((Intent)localObject1).putExtra("Intro_Is_Muti_Talker", false);
              ((Intent)localObject1).putExtra("Intro_Bottle_unread_count", paramInt2);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("talkerCount", i);
              break;
              i = com.tencent.mm.i.f.sP();
              break label2779;
              ((Intent)localObject1).putExtra("Intro_Is_Muti_Talker", true);
            }
            paramInt2 = com.tencent.mm.i.f.sS();
            break label2111;
            localObject1 = null;
            if (TextUtils.isEmpty(str))
            {
              localObject1 = null;
              localObject2 = localObject1;
              if (bf.mA((String)localObject1))
              {
                if (!com.tencent.mm.i.f.dH(str)) {
                  break label3159;
                }
                localObject2 = localContext.getString(R.l.dVj);
              }
            }
            for (localObject1 = com.tencent.mm.bi.b.bKo().Qx((String)localObject2);; localObject1 = localContext.getString(R.l.esz))
            {
              localObject2 = com.tencent.mm.booter.notification.a.h.a(localContext, paramString2, str, paramInt1);
              localObject5 = localObject2;
              localObject4 = localObject1;
              localObject1 = localObject2;
              break;
              ap.yY();
              localObject4 = com.tencent.mm.u.c.wR().Rb(str);
              if (localObject4 == null)
              {
                localObject1 = null;
                break label2868;
              }
              localObject2 = localObject1;
              if (paramInt1 == 318767153)
              {
                localObject2 = localObject1;
                if (!TextUtils.isEmpty(paramString2))
                {
                  localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).bq(paramString2, str);
                  localObject1 = localObject2;
                  if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                    break label2868;
                  }
                }
              }
              if (o.fB(str))
              {
                localObject1 = ((x)localObject4).tK();
                break label2868;
              }
              if (x.eO(str))
              {
                localObject1 = localContext.getString(R.l.dPe, new Object[] { com.tencent.mm.booter.notification.a.h.b((x)localObject4) }).trim();
                break label2868;
              }
              if ((com.tencent.mm.i.f.dH(str)) && (bf.mA(((com.tencent.mm.e.b.af)localObject4).field_nickname)))
              {
                ap.yY();
                localObject4 = com.tencent.mm.u.c.xa().eK(str);
                localObject1 = localObject2;
                if (bf.mA((String)localObject4)) {
                  break label2868;
                }
                localObject1 = localObject4;
                break label2868;
              }
              localObject1 = localObject2;
              if (((x)localObject4).tL() == null) {
                break label2868;
              }
              localObject1 = localObject2;
              if (((x)localObject4).tL().length() <= 0) {
                break label2868;
              }
              localObject1 = ((x)localObject4).tL();
              break label2868;
            }
            localObject1 = " " + paramString2;
            break label2238;
            localObject1 = "";
            break label2238;
            if (!bf.mA((String)localObject3))
            {
              paramInt1 = 0;
              localObject1 = localObject3;
              continue;
            }
            if ((localObject6 != null) && (((ce)localObject6).field_bizChatId != -1L) && (com.tencent.mm.modelbiz.e.dr(str)))
            {
              localObject1 = w.DJ().aa(((ce)localObject6).field_bizChatId);
              if (((com.tencent.mm.modelbiz.a.c)localObject1).DV()) {
                if (bf.mA(((com.tencent.mm.modelbiz.a.c)localObject1).field_chatName)) {
                  localObject1 = com.tencent.mm.sdk.platformtools.aa.getContext().getString(R.l.eMt) + ": " + com.tencent.mm.booter.notification.a.h.dm((String)localObject5);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject3 = localObject1;
        if (bf.mA((String)localObject1)) {
          localObject3 = (String)localObject4 + ": " + com.tencent.mm.booter.notification.a.h.dm((String)localObject5);
        }
        paramInt1 = 1;
        localObject1 = localObject3;
        break label2260;
        localObject1 = ((com.tencent.mm.modelbiz.a.c)localObject1).field_chatName + ": " + com.tencent.mm.booter.notification.a.h.dm((String)localObject5);
        continue;
        localObject1 = w.DL().iE(((ce)localObject6).field_bizChatUserId);
        if (localObject1 != null)
        {
          if (bf.mA(((j)localObject1).field_userName))
          {
            localObject1 = com.tencent.mm.booter.notification.a.h.dm((String)localObject5);
            continue;
          }
          localObject1 = ((j)localObject1).field_userName + ": " + com.tencent.mm.booter.notification.a.h.dm((String)localObject5);
          continue;
          if (!bool2)
          {
            localObject1 = (String)localObject4 + ": " + com.tencent.mm.booter.notification.a.h.dm((String)localObject5);
            paramInt1 = 0;
            break label2260;
          }
          if (((String)localObject5).contains(":\n"))
          {
            localObject3 = ay.gj((String)localObject5);
            localObject6 = new StringBuilder();
            if (((String)localObject5).contains(":\n")) {}
            for (localObject1 = ((String)localObject5).substring(0, ((String)localObject5).indexOf(":\n"));; localObject1 = com.tencent.mm.booter.notification.a.h.f(localContext, str, (String)localObject5))
            {
              localObject1 = (String)localObject1 + ": " + com.tencent.mm.booter.notification.a.h.dm((String)localObject3);
              paramInt1 = 0;
              break;
            }
          }
          localObject1 = com.tencent.mm.booter.notification.a.h.dm((String)localObject5);
          paramInt1 = 0;
          break label2260;
          paramString2 = localContext.getString(R.l.eEu);
          break label2270;
          paramString2 = (String)localObject1;
          break label2270;
          if (bool2) {
            break label2319;
          }
          if (paramInt1 != 0)
          {
            paramString2 = (String)localObject1;
            break label2319;
            localObject1 = localg.gLZ;
            localObject3 = localg.mContext;
            paramInt1 = localg.gMd;
            paramInt2 = localg.gMe;
            i = localg.gMf;
            int j;
            if (paramInt1 >= 0)
            {
              if (paramInt2 < 0) {
                break label3845;
              }
              j = Math.max(1, paramInt1);
              paramInt2 = Math.max(1, paramInt2);
              if (i < 0) {
                break label3853;
              }
              paramInt1 = i;
              if ((j != 1) || (paramInt1 <= 0)) {
                break label3860;
              }
            }
            for (paramString2 = ((Context)localObject3).getResources().getQuantityString(R.j.dsn, paramInt1, new Object[] { Integer.valueOf(paramInt1) });; paramString2 = ((Context)localObject3).getResources().getQuantityString(R.j.dsp, j, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2) }))
            {
              localObject2 = paramString2;
              if (com.tencent.mm.i.f.dJ(null) > 0) {
                localObject2 = ((Context)localObject3).getString(R.l.eyJ) + paramString2;
              }
              ((com.tencent.mm.booter.notification.a.h)localObject1).gMl = ((String)localObject2);
              ((com.tencent.mm.booter.notification.a.h)localObject1).mTitle = ((Context)localObject3).getString(R.l.esz);
              if (!paramBoolean) {
                break label3897;
              }
              localObject2 = null;
              paramString2 = (String)localObject1;
              localObject1 = localObject2;
              break;
              paramInt1 = com.tencent.mm.i.f.sP();
              break label3701;
              paramInt2 = com.tencent.mm.i.f.sR();
              break label3706;
              paramInt1 = com.tencent.mm.i.f.sS();
              break label3729;
            }
            localObject2 = ((Context)localObject3).getString(R.l.eEv);
            paramString2 = (String)localObject1;
            localObject1 = localObject2;
            break label2335;
            localObject2 = com.tencent.mm.x.b.a(str, false, -1);
            if (localObject2 == null)
            {
              paramString2 = null;
              break label2437;
            }
            paramString2 = com.tencent.mm.booter.notification.a.a.b(paramString2, (Bitmap)localObject2);
            break label2437;
            paramString2 = com.tencent.mm.booter.notification.a.d.a((Context)localObject1, paramInt1, paramString2.PC);
            break label2507;
            paramBoolean = false;
            break;
          }
          paramString2 = (String)localObject2;
          break label2319;
        }
        localObject1 = "";
      }
    }
  }
  
  public final void aw(boolean paramBoolean)
  {
    GMTrace.i(515127640064L, 3838);
    v.i("MicroMsg.MMNotification", "set isMainUI: %s, stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bf.bJP() });
    this.gKR = paramBoolean;
    GMTrace.o(515127640064L, 3838);
  }
  
  public final void ax(boolean paramBoolean)
  {
    GMTrace.i(517677776896L, 3857);
    d.ay(paramBoolean);
    GMTrace.o(517677776896L, 3857);
  }
  
  public final int b(Notification paramNotification)
  {
    GMTrace.i(15301626298368L, 114006);
    int i = a(paramNotification, true);
    GMTrace.o(15301626298368L, 114006);
    return i;
  }
  
  public final void cancel(int paramInt)
  {
    GMTrace.i(518483083264L, 3863);
    f localf = f.a.gLA;
    com.tencent.mm.booter.notification.queue.b.qr().cancel(paramInt);
    GMTrace.o(518483083264L, 3863);
  }
  
  public final void cancelNotification(String paramString)
  {
    int i = 1;
    GMTrace.i(515261857792L, 3839);
    v.v("MicroMsg.MMNotification", "cancel notification talker:" + paramString + " last talker:" + this.gKO + "  curChattingTalker:" + this.gKN + " talker count:" + this.gKS);
    if (!this.gKT)
    {
      GMTrace.o(515261857792L, 3839);
      return;
    }
    if ((this.gKO != null) && (this.gKO.equals(this.gKN)) && (this.gKS == 1)) {}
    while (i != 0)
    {
      cancel();
      GMTrace.o(515261857792L, 3839);
      return;
      i = 0;
    }
    ap.yY();
    paramString = com.tencent.mm.u.c.wW().Rl(paramString);
    if ((paramString != null) && (paramString.field_unReadCount != 0))
    {
      cancel();
      GMTrace.o(515261857792L, 3839);
      return;
    }
    if (p.fM(o.hkZ) == 0)
    {
      cancel();
      GMTrace.o(515261857792L, 3839);
      return;
    }
    GMTrace.o(515261857792L, 3839);
  }
  
  public final void dN(int paramInt)
  {
    GMTrace.i(516469817344L, 3848);
    Object localObject = new Intent(this.context, LauncherUI.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("nofification_type", "update_nofification");
    ((Intent)localObject).putExtra("show_update_dialog", true);
    ((Intent)localObject).putExtra("update_type", paramInt);
    localObject = PendingIntent.getActivity(this.context, 0, (Intent)localObject, 0);
    localObject = new Notification.Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.dIL)).setContentText(this.context.getString(R.l.dIi)).setContentIntent((PendingIntent)localObject).getNotification();
    ((Notification)localObject).flags |= 0x10;
    a(34, (Notification)localObject, false);
    GMTrace.o(516469817344L, 3848);
  }
  
  public final void dO(int paramInt)
  {
    GMTrace.i(517409341440L, 3855);
    d.dR(paramInt);
    GMTrace.o(517409341440L, 3855);
  }
  
  public final void dP(int paramInt)
  {
    GMTrace.i(517811994624L, 3858);
    Object localObject1 = f.a.gLA;
    if (paramInt != 0)
    {
      Object localObject2 = com.tencent.mm.booter.notification.queue.b.qr().gLG.dS(paramInt);
      if (((List)localObject2).isEmpty())
      {
        GMTrace.o(517811994624L, 3858);
        return;
      }
      localObject1 = android.support.v4.app.af.h(com.tencent.mm.sdk.platformtools.aa.getContext());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject2).next();
        com.tencent.mm.booter.notification.queue.b.qr().a((android.support.v4.app.af)localObject1, localInteger.intValue());
      }
    }
    GMTrace.o(517811994624L, 3858);
  }
  
  public final void db(String paramString)
  {
    GMTrace.i(514859204608L, 3836);
    this.gKN = paramString;
    GMTrace.o(514859204608L, 3836);
  }
  
  public final void dc(String paramString)
  {
    GMTrace.i(516335599616L, 3847);
    Intent localIntent = new Intent(this.context, LauncherUI.class);
    localIntent.putExtra("Intro_Notify", true);
    localIntent.putExtra("Intro_Notify_User", this.fJC);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    String str = paramString;
    if (!bf.mA(paramString))
    {
      str = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        str = paramString.substring(16);
      }
    }
    paramString = str;
    if (!bf.mA(str))
    {
      paramString = str;
      if (str.startsWith("<"))
      {
        Map localMap = bg.q(str, "e");
        paramString = str;
        if (localMap != null)
        {
          paramString = str;
          if (!bf.mA((String)localMap.get(".e.Content"))) {
            paramString = (String)localMap.get(".e.Content");
          }
        }
      }
    }
    paramString = new Notification.Builder(this.context).setContentTitle(paramString).setContentText(null).setContentIntent(PendingIntent.getActivity(this.context, 0, localIntent, 268435456)).getNotification();
    paramString.icon = com.tencent.mm.ba.a.bCc();
    paramString.flags = 16;
    a(paramString, true);
    GMTrace.o(516335599616L, 3847);
  }
  
  public final Looper getLooper()
  {
    GMTrace.i(516067164160L, 3845);
    Looper localLooper = Looper.getMainLooper();
    GMTrace.o(516067164160L, 3845);
    return localLooper;
  }
  
  public final void j(int paramInt, String paramString)
  {
    GMTrace.i(517140905984L, 3853);
    f.a.gLA.j(paramInt, paramString);
    GMTrace.o(517140905984L, 3853);
  }
  
  public final void l(String paramString, int paramInt)
  {
    GMTrace.i(517543559168L, 3856);
    d.m(paramString, paramInt);
    GMTrace.o(517543559168L, 3856);
  }
  
  public final void notify(int paramInt, Notification paramNotification)
  {
    GMTrace.i(517946212352L, 3859);
    a(paramInt, paramNotification, true);
    GMTrace.o(517946212352L, 3859);
  }
  
  public final void ox()
  {
    GMTrace.i(515530293248L, 3841);
    v.d("MicroMsg.MMNotification", "force cancelNotification");
    cancel();
    GMTrace.o(515530293248L, 3841);
  }
  
  public final void p(List<au> paramList)
  {
    GMTrace.i(516201381888L, 3846);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (paramList == null) {}
      for (i = -1;; i = paramList.size())
      {
        v.w("MicroMsg.MMNotification", "notifyOther newMsgList:%d :%s", new Object[] { Integer.valueOf(i), bf.bJP() });
        GMTrace.o(516201381888L, 3846);
        return;
      }
    }
    int j = paramList.size();
    int i = 0;
    j -= 1;
    au localau;
    for (;;)
    {
      localau = null;
      if (j < 0) {
        break;
      }
      localau = (au)paramList.get(j);
      i = com.tencent.mm.i.f.d(localau);
      if (this.gKV.a(localau.field_talker, localau, i, false)) {
        break;
      }
      j -= 1;
    }
    if (localau == null)
    {
      v.w("MicroMsg.MMNotification", "notifyOther msg == null");
      GMTrace.o(516201381888L, 3846);
      return;
    }
    this.gKP = "";
    this.fJC = localau.field_talker;
    paramList = localau.field_content;
    j = localau.field_type;
    this.fTa = localau;
    v.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.fJC, Long.valueOf(localau.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bf.Qi(paramList) });
    this.gKX.sendMessageDelayed(a(this.fJC, paramList, j, i, 0), 200L);
    GMTrace.o(516201381888L, 3846);
  }
  
  public final String qh()
  {
    GMTrace.i(514993422336L, 3837);
    String str = this.gKN;
    GMTrace.o(514993422336L, 3837);
    return str;
  }
  
  public final void qi()
  {
    GMTrace.i(515396075520L, 3840);
    try
    {
      Object localObject = com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = bf.PX(localObject[i]);
          if (k > 0) {
            ap.getNotification().cancel(k);
          }
          i += 1;
        }
      }
      GMTrace.o(515396075520L, 3840);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.MMNotification", localException, "try cancel notification fail: %s", new Object[] { localException.getMessage() });
      GMTrace.o(515396075520L, 3840);
    }
  }
  
  @TargetApi(16)
  public final boolean qj()
  {
    boolean bool = true;
    GMTrace.i(516604035072L, 3849);
    Object localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
    v.d("MicroMsg.MMNotification", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", new Object[] { ((ComponentName)localObject).getClassName() });
    if (!MobileVerifyUI.class.getName().equals(((ComponentName)localObject).getClassName())) {
      if (bool)
      {
        localObject = new Intent(this.context, MobileVerifyUI.class);
        ((Intent)localObject).addFlags(2);
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("nofification_type", "no_reg_notification");
        localObject = PendingIntent.getActivity(this.context, 36, (Intent)localObject, 1073741824);
        if (Build.VERSION.SDK_INT < 16) {
          break label269;
        }
        Notification.Builder localBuilder = new Notification.Builder(this.context);
        localBuilder.setContentTitle(this.context.getString(R.l.dIh));
        localBuilder.setSmallIcon(com.tencent.mm.ba.a.bCc());
        localBuilder.setWhen(System.currentTimeMillis());
        localBuilder.setContentIntent((PendingIntent)localObject);
        localObject = new Notification.BigTextStyle(localBuilder).bigText(this.context.getString(R.l.eAI)).build();
        ((Notification)localObject).defaults |= 0x1;
      }
    }
    for (((Notification)localObject).flags |= 0x10;; ((Notification)localObject).flags |= 0x10)
    {
      a(36, (Notification)localObject, false);
      GMTrace.o(516604035072L, 3849);
      return bool;
      bool = false;
      break;
      label269:
      localObject = new Notification.Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.dIh)).setContentText(this.context.getString(R.l.eAI)).setContentIntent((PendingIntent)localObject).getNotification();
      ((Notification)localObject).icon = com.tencent.mm.ba.a.bCc();
      ((Notification)localObject).defaults |= 0x1;
    }
  }
  
  public final void qk()
  {
    GMTrace.i(516738252800L, 3850);
    cancel(36);
    GMTrace.o(516738252800L, 3850);
  }
  
  public final void ql()
  {
    GMTrace.i(517275123712L, 3854);
    f localf = f.a.gLA;
    c.ql();
    GMTrace.o(517275123712L, 3854);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/notification/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */