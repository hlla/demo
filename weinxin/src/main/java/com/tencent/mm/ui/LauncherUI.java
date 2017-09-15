package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.i;
import com.tencent.mm.app.i.1;
import com.tencent.mm.app.i.2;
import com.tencent.mm.app.i.a;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.e.a.ab;
import com.tencent.mm.e.a.az;
import com.tencent.mm.e.a.if;
import com.tencent.mm.e.a.w;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.kernel.b.3;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.l.t;
import com.tencent.mm.pluginsdk.l.v;
import com.tencent.mm.pluginsdk.l.y;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.af;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.account.WelcomeSelectView;
import com.tencent.mm.ui.account.WelcomeView;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.en;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class LauncherUI
  extends MMFragmentActivity
  implements i.a
{
  private static ArrayList<LauncherUI> uPU;
  private static boolean uPV;
  public static long uPW;
  private Intent fNF;
  public HomeUI uPX;
  private j uPY;
  private boolean uPZ;
  public boolean uQa;
  boolean uQb;
  private boolean uQc;
  
  static
  {
    GMTrace.i(1701209702400L, 12675);
    uPU = new ArrayList();
    uPV = true;
    GMTrace.o(1701209702400L, 12675);
  }
  
  public LauncherUI()
  {
    GMTrace.i(1682821873664L, 12538);
    this.uPX = new HomeUI();
    this.uPY = new j();
    this.fNF = null;
    this.uPZ = false;
    this.uQa = false;
    this.uQb = false;
    this.uQc = false;
    GMTrace.o(1682821873664L, 12538);
  }
  
  private void ag(Intent paramIntent)
  {
    GMTrace.i(1688056365056L, 12577);
    v.i("MicroMsg.LauncherUI", "handleJump");
    if (!ap.zb())
    {
      v.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
      startActivity(new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864));
      finish();
      GMTrace.o(1688056365056L, 12577);
      return;
    }
    Object localObject1 = new if();
    ((if)localObject1).fNE.fNF = this.fNF;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
    if ("talkroom_notification".equals(com.tencent.mm.sdk.platformtools.r.i(paramIntent, "nofification_type")))
    {
      paramIntent = com.tencent.mm.sdk.platformtools.r.i(paramIntent, "enter_chat_usrname");
      if (!com.tencent.mm.platformtools.u.mA(paramIntent))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enter_room_username", paramIntent);
        ((Intent)localObject1).setFlags(268435456);
        com.tencent.mm.bb.d.b(this, "talkroom", ".ui.TalkRoomUI", (Intent)localObject1);
      }
      GMTrace.o(1688056365056L, 12577);
      return;
    }
    if ("back_to_pcmgr_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      if (!paramIntent.getBooleanExtra("newPCBackup", true)) {
        v.i("MicroMsg.LauncherUI", "summerbak jump BakToPcUI");
      }
      for (paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");; paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI"))
      {
        paramIntent.setFlags(268435456);
        MMWizardActivity.w(this, paramIntent);
        GMTrace.o(1688056365056L, 12577);
        return;
        v.i("MicroMsg.LauncherUI", "summerbak jump BackupPcUI");
      }
    }
    if ("back_to_pcmgr_error_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.w(this, paramIntent);
      GMTrace.o(1688056365056L, 12577);
      return;
    }
    if ("backup_move_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.w(this, paramIntent);
      GMTrace.o(1688056365056L, 12577);
      return;
    }
    int i;
    String str;
    int j;
    if (com.tencent.mm.sdk.platformtools.r.a(paramIntent, "show_update_dialog", false))
    {
      i = com.tencent.mm.sdk.platformtools.r.a(paramIntent, "update_type", -1);
      if (i == -1) {
        v.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
      }
    }
    else
    {
      str = com.tencent.mm.sdk.platformtools.r.i(paramIntent, "Main_User");
      j = 0;
      i = j;
      if (str != null)
      {
        i = j;
        if (!str.equals(""))
        {
          ap.yY();
          localObject1 = com.tencent.mm.u.c.wW().Rl(str);
          i = j;
          if (localObject1 != null) {
            i = ((aj)localObject1).field_unReadCount;
          }
        }
      }
      j = i;
      if (i == 0) {
        j = com.tencent.mm.sdk.platformtools.r.a(paramIntent, "pushcontent_unread_count", 0);
      }
      MMAppMgr.ox();
      com.tencent.mm.sdk.b.a.uql.m(new ab());
      this.uPX.yW(0);
      boolean bool = com.tencent.mm.sdk.platformtools.r.a(paramIntent, "Intro_Is_Muti_Talker", true);
      v.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((!bool) && (j > 0))
      {
        i = com.tencent.mm.sdk.platformtools.r.a(paramIntent, "Intro_Bottle_unread_count", 0);
        if (i > 0)
        {
          v.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.bb.d.w(this, "bottle", ".ui.BottleConversationUI");
        }
      }
      if ((bool) || (j <= 0)) {
        break label1193;
      }
      if (!o.fl(str)) {
        break label833;
      }
      v.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
      localObject1 = new Intent();
      ((Intent)localObject1).addFlags(67108864);
      ((Intent)localObject1).putExtra("type", 20);
      com.tencent.mm.bb.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
    }
    for (;;)
    {
      if (com.tencent.mm.sdk.platformtools.r.a(paramIntent, "kstyle_show_bind_mobile_afterauth", 0) > 0)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.account.bind.BindMobileUI");
        ((Intent)localObject1).putExtra("kstyle_bind_recommend_show", paramIntent.getIntExtra("kstyle_bind_recommend_show", 0));
        ((Intent)localObject1).putExtra("kstyle_bind_wording", paramIntent.getParcelableExtra("kstyle_bind_wording"));
        MMWizardActivity.w(this, (Intent)localObject1);
      }
      GMTrace.o(1688056365056L, 12577);
      return;
      com.tencent.mm.plugin.report.service.g.oSF.a(405L, 28L, 1L, true);
      if (l.y.bCk() == null) {
        break;
      }
      localObject1 = l.y.bCk().a(this, null);
      if (localObject1 == null) {
        break;
      }
      Object localObject2 = com.tencent.mm.plugin.report.service.g.oSF;
      if (i == 2) {}
      for (long l = 29L;; l = 30L)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject2).a(405L, l, 1L, true);
        ((l.t)localObject1).update(i);
        break;
      }
      label833:
      if (o.ft(str))
      {
        v.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
        localObject1 = new Intent();
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("type", 11);
        com.tencent.mm.bb.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
      }
      else
      {
        j = paramIntent.getIntExtra("MainUI_User_Last_Msg_Type", 34);
        i = 1;
        if (j == 34) {
          i = 2;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("Chat_Mode", i);
        if ("new_msg_nofification".equals(com.tencent.mm.sdk.platformtools.r.i(paramIntent, "nofification_type"))) {
          ((Bundle)localObject1).putInt("chat_from_scene", 1);
        }
        localObject2 = bPy();
        if (localObject2 != null) {
          if (com.tencent.mm.modelbiz.e.dr(str))
          {
            paramIntent.putExtra("Contact_User", str);
            paramIntent.addFlags(67108864);
            paramIntent.putExtra("biz_chat_from_scene", 4);
            com.tencent.mm.bb.d.a(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          }
          else
          {
            if (com.tencent.mm.modelbiz.e.ic(str))
            {
              localObject1 = com.tencent.mm.modelbiz.e.hW(str);
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((BizInfo)localObject1).CL())
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = "";
                }
                paramIntent.putExtra("rawUrl", (String)localObject2);
                paramIntent.putExtra("useJs", true);
                paramIntent.putExtra("srcUsername", str);
                paramIntent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                paramIntent.addFlags(67108864);
                com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", paramIntent);
                break;
              }
            }
            if (x.em(str))
            {
              paramIntent.putExtra("Contact_User", str);
              paramIntent.addFlags(67108864);
              paramIntent.putExtra("app_brand_conversation_from_scene", 3);
              paramIntent.putExtra("finish_direct", true);
              paramIntent.putExtra("key_need_send_video", false);
              com.tencent.mm.bb.d.a(this, ".ui.conversation.AppBrandServiceConversationUI", paramIntent);
            }
            else
            {
              ((LauncherUI)localObject2).a(str, (Bundle)localObject1, false);
              continue;
              label1193:
              if (com.tencent.mm.sdk.platformtools.r.a(paramIntent, "From_fail_notify", false))
              {
                if (!com.tencent.mm.platformtools.u.mA(str))
                {
                  localObject1 = bPy();
                  if (localObject1 != null)
                  {
                    localObject2 = new Bundle();
                    ((Bundle)localObject2).putBoolean("Chat_Mode", com.tencent.mm.sdk.platformtools.r.a(paramIntent, "resend_fail_messages", false));
                    if (com.tencent.mm.modelbiz.e.dr(str))
                    {
                      paramIntent.putExtra("Contact_User", str);
                      paramIntent.addFlags(67108864);
                      paramIntent.putExtra("biz_chat_from_scene", 4);
                      com.tencent.mm.bb.d.a(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
                    }
                    else
                    {
                      ((LauncherUI)localObject1).a(str, (Bundle)localObject2, false);
                    }
                  }
                }
                else if (com.tencent.mm.sdk.platformtools.r.a(paramIntent, "jump_sns_from_notify", false))
                {
                  localObject1 = new Intent();
                  ((Intent)localObject1).addFlags(67108864);
                  ((Intent)localObject1).putExtra("is_need_resend_sns", paramIntent.getBooleanExtra("is_need_resend_sns", false));
                  ((Intent)localObject1).putExtra("sns_resume_state", paramIntent.getBooleanExtra("sns_resume_state", false));
                  ((Intent)localObject1).putExtra("sns_timeline_NeedFirstLoadint", paramIntent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
                  com.tencent.mm.bb.d.b(this, "sns", ".ui.En_424b8e16", (Intent)localObject1);
                }
              }
              else if (com.tencent.mm.sdk.platformtools.r.a(paramIntent, "biz_chat_need_to_jump_to_chatting_ui", false))
              {
                if ((bPy() != null) && (com.tencent.mm.modelbiz.e.dr(str)))
                {
                  paramIntent.putExtra("Contact_User", str);
                  paramIntent.addFlags(67108864);
                  com.tencent.mm.bb.d.a(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
                }
              }
              else {
                this.uPX.yW(0);
              }
            }
          }
        }
      }
    }
  }
  
  private void bPA()
  {
    GMTrace.i(14913602846720L, 111115);
    uPV = false;
    int i;
    Object localObject2;
    long l1;
    label470:
    label649:
    Object localObject4;
    if ((this.fNF != null) && (!com.tencent.mm.sdk.platformtools.r.a(this.fNF, "Intro_Switch", false)) && (ap.za()) && (!ap.uP()))
    {
      i = 1;
      if (i == 0) {
        break label2101;
      }
      v.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[] { Boolean.valueOf(this.uQa) });
      if (!this.uQa)
      {
        this.uQa = true;
        localObject1 = this.uPX;
        getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
        localObject2 = ((HomeUI)localObject1).uOv.getSharedPreferences("system_config_prefs", 4);
        if (((SharedPreferences)localObject2).getBoolean("first_launch_weixin", true))
        {
          ((SharedPreferences)localObject2).edit().putBoolean("first_launch_weixin", false).commit();
          XLogSetup.realSetupXlog();
        }
        ((HomeUI)localObject1).bPq();
        ((HomeUI)localObject1).uOp = new u(this);
        ((HomeUI)localObject1).uOf = true;
        NotifyReceiver.pX();
        ap.getNotification().dP(1);
        v.d("MicroMsg.LauncherUI", "on main tab create");
        l1 = System.currentTimeMillis();
        if (ap.zb()) {
          break label831;
        }
        v.e("MicroMsg.LauncherUI", "mmcore has not ready, finish launcherui");
        ((HomeUI)localObject1).uOv.finish();
        ag(getIntent());
      }
      this.uPX.bPb();
      v.i("MicroMsg.LauncherUI", "resumeNormalJump");
      MMFragmentActivity.a.bQf();
      if (("pushcontent_notification".equals(com.tencent.mm.sdk.platformtools.r.i(getIntent(), "nofification_type"))) && (!com.tencent.mm.platformtools.u.mA(com.tencent.mm.sdk.platformtools.r.i(getIntent(), "Main_FromUserName"))))
      {
        localObject1 = com.tencent.mm.sdk.platformtools.r.i(getIntent(), "Main_FromUserName");
        i = com.tencent.mm.sdk.platformtools.r.a(getIntent(), "MainUI_User_Last_Msg_Type", 0);
        v.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + (String)localObject1 + i);
        com.tencent.mm.plugin.report.service.g.oSF.i(10856, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(0) });
      }
      localObject1 = com.tencent.mm.sdk.platformtools.r.i(getIntent(), "LauncherUI.Shortcut.LaunchType");
      if (localObject1 != null)
      {
        if (!((String)localObject1).equals("launch_type_voip")) {
          break label1759;
        }
        v.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
        startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip"));
        com.tencent.mm.plugin.report.service.g.oSF.i(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
      }
      localObject1 = com.tencent.mm.sdk.platformtools.r.i(getIntent(), "LauncherUI.switch.tab");
      if (!com.tencent.mm.platformtools.u.mA((String)localObject1))
      {
        this.uPX.SC((String)localObject1);
        getIntent().putExtra("LauncherUI.switch.tab", "");
      }
      if ((com.tencent.mm.sdk.platformtools.r.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) || (this.uQc))
      {
        this.uQc = false;
        localObject1 = bPy();
        if (localObject1 != null)
        {
          localObject1 = ((LauncherUI)localObject1).uPX;
          ap.vL().bIX();
          if (((HomeUI)localObject1).uOe)
          {
            v.i("MicroMsg.LauncherUI", "remove setTagRunnable");
            ae.I(((HomeUI)localObject1).uOx);
          }
          ae.v(((HomeUI)localObject1).uPe);
        }
        getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
        getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
      }
      bool1 = com.tencent.mm.sdk.platformtools.r.a(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
      if (!bool1) {
        break label1835;
      }
      localObject1 = com.tencent.mm.sdk.platformtools.r.i(getIntent(), "LauncherUI.Shortcut.Username");
      if (bool1)
      {
        v.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = " + (String)localObject1);
        if (!com.tencent.mm.platformtools.u.mA((String)localObject1))
        {
          localObject4 = com.tencent.mm.plugin.base.a.c.rL((String)localObject1);
          if (!com.tencent.mm.platformtools.u.mA((String)localObject4)) {
            if (o.eU((String)localObject4))
            {
              v.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
              if (!com.tencent.mm.modelbiz.e.hZ((String)localObject4)) {
                break label2079;
              }
              if (!com.tencent.mm.modelbiz.e.dr((String)localObject4)) {
                break label1860;
              }
              localObject1 = new Intent();
              ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
              ((Intent)localObject1).putExtra("Contact_User", (String)localObject4);
              ((Intent)localObject1).putExtra("biz_chat_from_scene", 9);
              ((Intent)localObject1).addFlags(67108864);
              startActivity((Intent)localObject1);
            }
          }
        }
      }
    }
    for (;;)
    {
      getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
      getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
      this.uQb = true;
      GMTrace.o(14913602846720L, 111115);
      return;
      i = 0;
      break;
      label831:
      long l2 = System.currentTimeMillis();
      MMActivity.et(((HomeUI)localObject1).uOv);
      try
      {
        localObject2 = new HashSet();
        localObject4 = ((HomeUI)localObject1).getString(R.l.eaJ).split(";");
        ((Set)localObject2).add(localObject4[0]);
        ((Set)localObject2).add(localObject4[1]);
        com.tencent.mm.u.n.c((Set)localObject2);
        com.tencent.mm.sdk.b.a.uql.m(new az());
        v.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - l2));
        ((HomeUI)localObject1).mwN = ((LayoutInflater)((HomeUI)localObject1).uOv.getSystemService("layout_inflater"));
        l2 = System.currentTimeMillis();
        ((HomeUI)localObject1).ipa = r.eC(((HomeUI)localObject1).uOv).inflate(R.i.dhx, null);
        v.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - l2));
        ((HomeUI)localObject1).uOv.setContentView(((HomeUI)localObject1).ipa);
        Looper.myQueue().addIdleHandler(((HomeUI)localObject1).uOM);
        ((HomeUI)localObject1).uOj = true;
        ((HomeUI)localObject1).uOF = ((VoiceSearchLayout)((HomeUI)localObject1).uOv.findViewById(R.h.cNr));
        ((HomeUI)localObject1).uOF.xj(BackwardSupportUtil.b.a(((HomeUI)localObject1).uOv, 100.0F));
        ((HomeUI)localObject1).uOn = ((CustomViewPager)((HomeUI)localObject1).uOv.findViewById(R.h.cqv));
        ((HomeUI)localObject1).uOn.BW(4);
        if (((HomeUI)localObject1).uOm != null)
        {
          ((HomeUI)localObject1).uOm.a(null);
          ((View)((HomeUI)localObject1).uOm).setVisibility(8);
        }
        ((HomeUI)localObject1).uOn.DC = true;
        ((HomeUI)localObject1).uOo = new HomeUI.c((HomeUI)localObject1, ((HomeUI)localObject1).uOv, ((HomeUI)localObject1).uOn);
        localObject2 = ((HomeUI)localObject1).uOm;
        if (((HomeUI)localObject1).uOm != null)
        {
          ((HomeUI)localObject1).uOm.a(null);
          ((View)((HomeUI)localObject1).uOm).setVisibility(8);
          ((ViewGroup)((HomeUI)localObject1).uOn.getParent()).removeView((View)((HomeUI)localObject1).uOm);
        }
        localObject4 = new LinearLayout.LayoutParams(-1, -2);
        LauncherUIBottomTabView localLauncherUIBottomTabView = new LauncherUIBottomTabView(((HomeUI)localObject1).uOv);
        ((ViewGroup)((HomeUI)localObject1).uOn.getParent()).addView(localLauncherUIBottomTabView, (ViewGroup.LayoutParams)localObject4);
        ((HomeUI)localObject1).uOm = localLauncherUIBottomTabView;
        ((View)((HomeUI)localObject1).uOm).setVisibility(0);
        ((HomeUI)localObject1).uOm.a(((HomeUI)localObject1).uOo);
        if ((localObject2 != null) && (localObject2 != ((HomeUI)localObject1).uOm))
        {
          ((HomeUI)localObject1).uOm.kb(((c)localObject2).bOt());
          ((HomeUI)localObject1).uOm.kc(((c)localObject2).bOu());
          ((HomeUI)localObject1).uOm.yQ(((c)localObject2).bOp());
          ((HomeUI)localObject1).uOm.yR(((c)localObject2).bOq());
          ((HomeUI)localObject1).uOm.yS(((c)localObject2).bOr());
          ((HomeUI)localObject1).uOm.yT(((c)localObject2).bOs());
          ((HomeUI)localObject1).uOm.lF(((c)localObject2).bOv());
        }
        ((HomeUI)localObject1).yW(0);
        v.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - l2));
        l2 = System.currentTimeMillis();
        v.d("MicroMsg.LauncherUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - l2));
        l2 = System.currentTimeMillis();
        if ((!com.tencent.mm.sdk.platformtools.r.a(((HomeUI)localObject1).uOv.getIntent(), "LauncherUI.enter_from_reg", false)) && (MMAppMgr.oK()) && (ap.zb()) && (ac.Ps("show_whatsnew")))
        {
          v.i("MicroMsg.LauncherUI", "dz[showWhatsNewForResult from onMainTabCreate]");
          com.tencent.mm.bb.d.b(((HomeUI)localObject1).uOv, "whatsnew", ".ui.WhatsNewUI", new Intent(), 1);
        }
        com.tencent.mm.app.plugin.b.cV(3);
        v.d("MicroMsg.LauncherUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - l2));
        ((HomeUI)localObject1).bPq();
        ((HomeUI)localObject1).Gx.show();
        ((HomeUI)localObject1).ipa.post(new HomeUI.1((HomeUI)localObject1));
        v.v("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - l1));
        ae.f(new HomeUI.12((HomeUI)localObject1), 2000L);
        ((HomeUI)localObject1).ipa.addOnLayoutChangeListener(new HomeUI.23((HomeUI)localObject1));
        com.tencent.mm.pluginsdk.e.a(((HomeUI)localObject1).uOv, ((HomeUI)localObject1).ipa);
        ((HomeUI)localObject1).ipa.postDelayed(new HomeUI.34((HomeUI)localObject1), 20L);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.LauncherUI", localException, "", new Object[0]);
        }
      }
      label1759:
      if (!((String)localObject1).equals("launch_type_voip_audio")) {
        break label470;
      }
      v.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
      startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio"));
      com.tencent.mm.plugin.report.service.g.oSF.i(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      break label470;
      label1835:
      bool1 = com.tencent.mm.sdk.platformtools.r.a(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
      localObject1 = getIntent().getAction();
      break label649;
      label1860:
      if (com.tencent.mm.modelbiz.e.ib((String)localObject4))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject1).putExtra("enterprise_biz_name", (String)localObject4);
        ((Intent)localObject1).putExtra("enterprise_biz_display_name", com.tencent.mm.u.n.eK((String)localObject4));
        startActivity((Intent)localObject1);
      }
      else
      {
        if (com.tencent.mm.modelbiz.e.ic((String)localObject4))
        {
          localObject1 = com.tencent.mm.modelbiz.e.hW((String)localObject4);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((BizInfo)localObject1).CL())
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = "";
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
            ((Intent)localObject1).putExtra("useJs", true);
            ((Intent)localObject1).putExtra("srcUsername", (String)localObject4);
            ((Intent)localObject1).putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            ((Intent)localObject1).addFlags(67108864);
            com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
            break;
          }
        }
        localObject1 = bPy();
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("chat_from_scene", 3);
        ((LauncherUI)localObject1).a((String)localObject4, (Bundle)localObject3, false);
        continue;
        label2079:
        localObject1 = bPy();
        if (localObject1 != null) {
          ((LauncherUI)localObject1).a((String)localObject4, null, false);
        }
      }
    }
    label2101:
    v.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump");
    v.i("MicroMsg.LauncherUI", "resumeLogoutJump");
    MMFragmentActivity.a.bQf();
    Object localObject1 = ao.hlE.A("login_user_name", "");
    if ((ap.za()) || (!((String)localObject1).equals("")))
    {
      f.rW(8);
      localObject1 = com.tencent.mm.kernel.h.vH();
      ((com.tencent.mm.kernel.b)localObject1).gXs.a(new bb(new b.3((com.tencent.mm.kernel.b)localObject1), "reset accinfo"), 0);
      if ((this.fNF.getFlags() & 0x4000000) != 67108864) {
        break label2464;
      }
    }
    label2464:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.sdk.platformtools.r.a(this.fNF, "Intro_Notify", false);
      v.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[] { Boolean.valueOf(this.uQa), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(ap.uP()) });
      ap.hold();
      localObject1 = new w();
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      if (ap.zb()) {
        com.tencent.mm.kernel.h.vJ().eh("[" + this.uQa + " " + bool1 + " " + bool2 + "]");
      }
      if (com.tencent.mm.sdk.platformtools.r.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
        this.uQc = true;
      }
      if ((!com.tencent.mm.sdk.platformtools.r.a(this.fNF, "Intro_Switch", false)) && ((!ap.uP()) || (!this.uQa))) {
        break;
      }
      v.appenderClose();
      BaseEvent.onSingalCrash(0);
      finish();
      localObject1 = new Intent(this, LauncherUI.class);
      ((Intent)localObject1).addFlags(67108864);
      startActivity((Intent)localObject1);
      ap.unhold();
      v.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
      v.bIF();
      ap.unhold();
      Process.killProcess(Process.myPid());
      ap.unhold();
      GMTrace.o(14913602846720L, 111115);
      return;
    }
    if (!ao.hlE.A("login_user_name", "").equals(""))
    {
      i = com.tencent.mm.sdk.platformtools.bf.PX(ao.hlE.A("last_login_use_voice", ""));
      v.i("MicroMsg.LauncherUI", "pluginSwitch  " + i);
      if ((i & 0x20000) != 0)
      {
        startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.account.LoginVoiceUI"));
        label2551:
        com.tencent.mm.ui.base.b.eL(this);
      }
    }
    for (;;)
    {
      f.rW(8);
      break;
      startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.account.LoginPasswordUI"));
      break label2551;
      localObject1 = new WelcomeSelectView(this);
      setContentView((View)localObject1);
      ((WelcomeView)localObject1).bRd();
    }
  }
  
  private boolean bPB()
  {
    GMTrace.i(1684164050944L, 12548);
    if ((this.fNF != null) && ((com.tencent.mm.sdk.platformtools.r.a(this.fNF, "absolutely_exit", false)) || (com.tencent.mm.sdk.platformtools.r.a(this.fNF, "absolutely_exit_pid", 0) == Process.myPid())))
    {
      v.w("MicroMsg.LauncherUI", "launcherOnResume exit absolutely!!!");
      finish();
      f.rW(8);
      MMAppMgr.ks(com.tencent.mm.sdk.platformtools.r.a(this.fNF, "kill_service", true));
      GMTrace.o(1684164050944L, 12548);
      return true;
    }
    if ((this.fNF != null) && (com.tencent.mm.sdk.platformtools.r.a(this.fNF, "can_finish", false)))
    {
      v.i("MicroMsg.LauncherUI", "exit obviously");
      ap.vd().aW(true);
      if (k.aK(getApplicationContext()))
      {
        Context localContext = getApplicationContext();
        localContext.stopService(new Intent(localContext, CoreService.class));
      }
      f.rW(8);
      sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), "com.tencent.mm.permission.MM_MESSAGE");
      finish();
      com.tencent.mm.ui.base.b.eN(this);
      GMTrace.o(1684164050944L, 12548);
      return true;
    }
    GMTrace.o(1684164050944L, 12548);
    return false;
  }
  
  public static LauncherUI bPy()
  {
    GMTrace.i(1686848405504L, 12568);
    if (uPU.isEmpty())
    {
      v.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[] { com.tencent.mm.platformtools.u.ND() });
      GMTrace.o(1686848405504L, 12568);
      return null;
    }
    LauncherUI localLauncherUI = (LauncherUI)uPU.get(0);
    GMTrace.o(1686848405504L, 12568);
    return localLauncherUI;
  }
  
  private void bPz()
  {
    GMTrace.i(1684432486400L, 12550);
    int i = uPU.indexOf(this);
    if (i >= 0) {
      uPU.remove(i);
    }
    v.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(uPU.size()), Integer.valueOf(hashCode()) });
    GMTrace.o(1684432486400L, 12550);
  }
  
  public static void ez(Context paramContext)
  {
    GMTrace.i(1682956091392L, 12539);
    Intent localIntent = new Intent(paramContext, LauncherUI.class);
    localIntent.addFlags(67108864);
    paramContext.startActivity(localIntent);
    GMTrace.o(1682956091392L, 12539);
  }
  
  public final void O(float paramFloat)
  {
    int j = 0;
    int i = 0;
    GMTrace.i(1690874937344L, 12598);
    Object localObject = this.uPX;
    v.v("MicroMsg.LauncherUI", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(240L), ((HomeUI)localObject).uOu });
    if (!((HomeUI)localObject).bPv()) {
      i = 1;
    }
    do
    {
      if (i == 0) {
        super.O(paramFloat);
      }
      GMTrace.o(1690874937344L, 12598);
      return;
      if (HomeUI.a.uPF == ((HomeUI)localObject).uOu) {
        break;
      }
    } while (Float.compare(1.0F, paramFloat) > 0);
    for (i = j;; i = 1)
    {
      localObject = ((HomeUI)localObject).uOv.findViewById(R.h.caJ);
      if (Float.compare(1.0F, paramFloat) <= 0)
      {
        com.tencent.mm.ui.tools.j.n((View)localObject, 0.0F);
        break;
      }
      com.tencent.mm.ui.tools.j.n((View)localObject, ((View)localObject).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
      break;
    }
  }
  
  public final boolean VC()
  {
    GMTrace.i(1691411808256L, 12602);
    boolean bool = HomeUI.VC();
    GMTrace.o(1691411808256L, 12602);
    return bool;
  }
  
  public final void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    GMTrace.i(1688593235968L, 12581);
    this.uPX.a(paramString, paramBundle, paramBoolean);
    GMTrace.o(1688593235968L, 12581);
  }
  
  protected final boolean bDR()
  {
    GMTrace.i(18814506893312L, 140179);
    GMTrace.o(18814506893312L, 140179);
    return true;
  }
  
  public final q bPC()
  {
    GMTrace.i(1691814461440L, 12605);
    Object localObject1 = this.uPX;
    if (!((HomeUI)localObject1).uPi) {}
    for (localObject1 = ((HomeUI)localObject1).uOX;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.bPC();
      }
      GMTrace.o(1691814461440L, 12605);
      return (q)localObject2;
    }
  }
  
  public final void d(boolean paramBoolean, int paramInt)
  {
    long l = 120L;
    GMTrace.i(1691277590528L, 12601);
    Object localObject = this.uPX;
    v.v("MicroMsg.LauncherUI", "ashutest: on settle %B, speed %d, status %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), ((HomeUI)localObject).uOu });
    int i;
    if (((HomeUI)localObject).bPv())
    {
      if (HomeUI.a.uPF != ((HomeUI)localObject).uOu)
      {
        i = 0;
        if (i == 0) {
          super.d(paramBoolean, paramInt);
        }
        GMTrace.o(1691277590528L, 12601);
        return;
      }
      localObject = ((HomeUI)localObject).uOv.findViewById(R.h.caJ);
      if (!paramBoolean) {
        break label140;
      }
      if (paramInt <= 0) {
        break label132;
      }
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.j.a((View)localObject, l, 0.0F, 0.125F);
      i = 1;
      break;
      label132:
      l = 240L;
    }
    label140:
    if (paramInt > 0) {}
    for (;;)
    {
      com.tencent.mm.ui.tools.j.a((View)localObject, l, ((View)localObject).getWidth() * -1 / 4, 0.75F);
      break;
      l = 240L;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    GMTrace.i(1690472284160L, 12595);
    HomeUI localHomeUI = this.uPX;
    v.i("MicroMsg.LauncherUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      ae.I(localHomeUI.uPd);
    }
    int i;
    if ((localHomeUI.uOX != null) && (localHomeUI.uOX.hMt)) {
      if (localHomeUI.uOX.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)) {
        i = 1;
      }
    }
    while (i != 0)
    {
      GMTrace.o(1690472284160L, 12595);
      return true;
      i = 0;
      continue;
      if ((paramKeyEvent.getKeyCode() == 25) && (paramKeyEvent.getAction() == 0) && (ap.zb()))
      {
        if (com.tencent.mm.am.b.HK()) {}
        for (i = 3;; i = 5)
        {
          ap.yZ().ec(i);
          i = 1;
          break;
        }
      }
      if ((paramKeyEvent.getKeyCode() == 24) && (paramKeyEvent.getAction() == 0) && (ap.zb()))
      {
        if (com.tencent.mm.am.b.HK()) {}
        for (i = 3;; i = 5)
        {
          ap.yZ().eb(i);
          i = 1;
          break;
        }
      }
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (localHomeUI.uOp != null) && (localHomeUI.uOp.isShowing()))
      {
        localHomeUI.uOp.dismiss();
        i = 1;
      }
      else if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
      {
        localHomeUI.bPf();
        i = 1;
      }
      else if ((localHomeUI.uOo != null) && (paramKeyEvent.getAction() == 0) && (((q)localHomeUI.uOo.I(localHomeUI.uOn.ys)).onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
      {
        i = 1;
      }
      else if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
      {
        if (i.oj().fwe)
        {
          i = 1;
        }
        else if ((localHomeUI.uOF != null) && (localHomeUI.uOF.getVisibility() == 0))
        {
          localHomeUI.uOF.bEF();
          i = 1;
        }
        else
        {
          if ((ap.zb()) && (com.tencent.mm.kernel.h.vG().gXf) && (al.isWap(localHomeUI.uOv)))
          {
            Object localObject = localHomeUI.uOv;
            HomeUI.33 local33 = new HomeUI.33(localHomeUI);
            if (!ap.zb()) {
              i = 0;
            }
            for (;;)
            {
              if (i == 0) {
                break label645;
              }
              i = 1;
              break;
              ap.yY();
              i = ((Integer)com.tencent.mm.u.c.vr().get(65, Integer.valueOf(0))).intValue();
              if (i >= 5)
              {
                i = 0;
              }
              else if (!ac.Ps("show_wap_adviser"))
              {
                i = 0;
              }
              else
              {
                View localView = View.inflate((Context)localObject, R.i.djX, null);
                ((TextView)localView.findViewById(R.h.cmU)).setText(R.l.eDo);
                localObject = new h.a((Context)localObject);
                ((h.a)localObject).zR(R.l.dIG);
                ((h.a)localObject).db(localView);
                ((h.a)localObject).zU(R.l.dHL).a(new MMAppMgr.9(i));
                ((h.a)localObject).kH(false);
                ((h.a)localObject).zV(R.l.eDl).b(new MMAppMgr.10());
                ((h.a)localObject).a(new MMAppMgr.11(local33));
                ((h.a)localObject).WD().show();
                i = 1;
              }
            }
          }
          label645:
          i = al.getBackgroundLimitType(localHomeUI.uOv);
          if ((ap.zb()) && (com.tencent.mm.kernel.h.vG().gXf) && (al.isLimited(i)))
          {
            ap.yY();
            if ((com.tencent.mm.sdk.platformtools.bf.e((Boolean)com.tencent.mm.u.c.vr().get(16385, null))) && (MMAppMgr.a(localHomeUI.uOv, i, new HomeUI.35(localHomeUI, i), new HomeUI.36(localHomeUI))))
            {
              i = 1;
              continue;
            }
          }
          localHomeUI.bOi();
        }
      }
      else
      {
        i = 0;
      }
    }
    try
    {
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      GMTrace.o(1690472284160L, 12595);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      v.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", new Object[] { paramKeyEvent.getMessage() });
      v.printErrStackTrace("MicroMsg.LauncherUI", paramKeyEvent, "", new Object[0]);
      GMTrace.o(1690472284160L, 12595);
    }
    return false;
  }
  
  public void finish()
  {
    GMTrace.i(1685908881408L, 12561);
    super.finish();
    bPz();
    v.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(uPU.size()), com.tencent.mm.sdk.platformtools.bf.bJP() });
    GMTrace.o(1685908881408L, 12561);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(1686445752320L, 12565);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    v.v("MicroMsg.LauncherUI", "edw on activity result");
    HomeUI localHomeUI = this.uPX;
    if ((paramInt1 == 2001) && (localHomeUI.uOX != null)) {
      localHomeUI.uOX.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    int i = 0xFFFF & paramInt1;
    v.w("MicroMsg.LauncherUI", "check request code %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (i = 0; (i != 0) && (localHomeUI.uOX == null); i = 1)
    {
      v.i("MicroMsg.LauncherUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      ae.I(localHomeUI.uOE);
      localHomeUI.uOE.uPK = 0;
      localHomeUI.uOE.fFI = paramInt1;
      localHomeUI.uOE.aMA = paramInt2;
      localHomeUI.uOE.fFJ = paramIntent;
      ae.v(localHomeUI.uOE);
      GMTrace.o(1686445752320L, 12565);
      return;
    }
    if (localHomeUI.uOf)
    {
      if (paramInt1 == 1)
      {
        ap.yY();
        if (!com.tencent.mm.sdk.platformtools.bf.f((Boolean)com.tencent.mm.u.c.vr().get(12323, null))) {
          com.tencent.mm.platformtools.m.a(localHomeUI.uOv, null, false, 3);
        }
        GMTrace.o(1686445752320L, 12565);
        return;
      }
      if ((paramInt1 == 65534) && (paramInt2 == -1))
      {
        ac.Pt("welcome_page_show");
        k.e(localHomeUI.uOv, true);
        MMAppMgr.ox();
        MMAppMgr.a(localHomeUI.uOv, true);
        localHomeUI.uOv.finish();
      }
    }
    GMTrace.o(1686445752320L, 12565);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(1683492962304L, 12543);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.uPX;
    com.tencent.mm.pluginsdk.e.a(paramConfiguration.uOv, paramConfiguration.ipa);
    GMTrace.o(1683492962304L, 12543);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1683358744576L, 12542);
    long l1 = System.currentTimeMillis();
    v.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), com.tencent.mm.sdk.platformtools.bf.eq(this) });
    super.onCreate(paramBundle);
    long l2 = System.currentTimeMillis();
    int i = getTaskId();
    Object localObject2 = getPackageName();
    paramBundle = getIntent();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (com.tencent.mm.sdk.platformtools.r.a(paramBundle, "absolutely_exit", false))
      {
        bool1 = true;
        v.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
      }
    }
    Object localObject1 = null;
    paramBundle = null;
    Object localObject3;
    if (!bool1)
    {
      localObject3 = uPU.iterator();
      localObject1 = paramBundle;
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (LauncherUI)((Iterator)localObject3).next();
        if (((LauncherUI)localObject1).getTaskId() != i)
        {
          v.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", new Object[] { Integer.valueOf(localObject1.hashCode()), Integer.valueOf(((LauncherUI)localObject1).getTaskId()), Integer.valueOf(i) });
          paramBundle = com.tencent.mm.sdk.platformtools.bf.aa(this, i);
          if (paramBundle != null)
          {
            v.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), paramBundle.topActivity.getClassName(), paramBundle.baseActivity.getClassName(), Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
            if (paramBundle.baseActivity.getPackageName().equals(localObject2)) {
              break label423;
            }
            v.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + paramBundle.baseActivity.getPackageName());
            finish();
            if (com.tencent.mm.sdk.platformtools.bf.aa(this, ((LauncherUI)localObject1).getTaskId()) != null)
            {
              v.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
              paramBundle = new Intent(this, LauncherUI.class);
              paramBundle.addFlags(268435456);
              startActivity(paramBundle);
            }
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        v.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
        GMTrace.o(1683358744576L, 12542);
        return;
        v.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", new Object[] { Integer.valueOf(i) });
        finish();
        i = 0;
        continue;
        label423:
        ((LauncherUI)localObject1).finish();
        uPU.remove(localObject1);
        break;
        if (!uPU.isEmpty())
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = com.tencent.mm.sdk.platformtools.bf.aa(this, i);
          }
          if (paramBundle == null) {
            break label694;
          }
          localObject1 = paramBundle.baseActivity.getClassName();
          localObject2 = paramBundle.baseActivity.getClassName();
          v.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), localObject2, localObject1, Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
          localObject3 = getComponentName().getClassName();
          if ((paramBundle.numActivities > 1) && (((String)localObject3).equals(localObject1)) && (((String)localObject3).equals(localObject2)))
          {
            finish();
            v.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(uPU.size()) });
            i = 0;
            continue;
          }
          v.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[] { Integer.valueOf(uPU.size()), Boolean.valueOf(bool1) });
          uPU.clear();
        }
        for (;;)
        {
          uPU.add(this);
          v.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d, use time %d", new Object[] { Integer.valueOf(uPU.size()), Long.valueOf(System.currentTimeMillis() - l2) });
          i = 1;
          break;
          label694:
          v.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(uPU.size()) });
          uPU.clear();
        }
      }
    }
    v.i("MicroMsg.LauncherUI", "onCreate normally");
    paramBundle = this.uPX;
    paramBundle.uOv = this;
    NotifyReceiver.pW();
    com.tencent.mm.pluginsdk.e.R(paramBundle.uOv);
    paramBundle.Gx = cO().cP();
    if (paramBundle.Gx != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.Gx.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.aSD)));
      }
      paramBundle.Gx.hide();
    }
    setRequestedOrientation(1);
    i.oj().fwj.add(this);
    paramBundle = ao.hlE.A("login_user_name", "");
    this.fNF = getIntent();
    v.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s, DefaultBootStep.isStartupOnInitThread() %s", new Object[] { paramBundle, Boolean.valueOf(ap.za()), Boolean.valueOf(uPV), Boolean.valueOf(WorkerProfile.fvQ) });
    if (((!uPV) || (!WorkerProfile.fvQ)) && ((ap.za()) || (!paramBundle.equals(""))))
    {
      uPW = l1;
      v.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
      this.uPZ = true;
      GMTrace.o(1683358744576L, 12542);
      return;
    }
    if ((WorkerProfile.oC().fxa) && (!WorkerProfile.oC().oD()))
    {
      uPW = MMApplicationLike.sAppStartTime;
      v.i("MicroMsg.LauncherUI", "start time check isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
      setRequestedOrientation(1);
      paramBundle = i.oj();
      bool1 = ap.za();
      bool2 = ao.hlE.A("login_user_name", "").equals("");
      if ((bool1) || (!bool2)) {
        break label1314;
      }
      i = 1;
      label1066:
      if (paramBundle.fwe) {
        paramBundle.ol();
      }
      localObject1 = new i.1(paramBundle);
      com.tencent.mm.u.bf.zK().hgn.edit().putInt("MicroMsg.RegStyleStoragestyle_id", 21).commit();
      l1 = System.currentTimeMillis();
      localObject2 = new SplashWelcomeView(this);
      ((SplashWelcomeView)localObject2).uUJ = ((en)localObject1);
      ((SplashWelcomeView)localObject2).uUM = new i.2(paramBundle);
      if (!(this instanceof Activity)) {
        break label1319;
      }
      setContentView((View)localObject2);
    }
    for (;;)
    {
      if ((i == 0) && (paramBundle.fwh != null))
      {
        paramBundle.fwh.setCallback(null);
        paramBundle.fwh = null;
      }
      v.d("MicroMsg.INIT", "start time check initWindow  Last: " + (System.currentTimeMillis() - l1));
      v.d("MicroMsg.INIT", "start time check APPCreate to Window Show Last: " + (System.currentTimeMillis() - uPW));
      v.i("MicroMsg.LauncherUI", "start time check after initwindow time from launcherui==" + (System.currentTimeMillis() - uPW));
      GMTrace.o(1683358744576L, 12542);
      return;
      uPW = l1;
      v.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
      break;
      label1314:
      i = 0;
      break label1066;
      label1319:
      if ((paramBundle.fwa == null) || (paramBundle.fwb == null))
      {
        paramBundle.fwc = new WindowManager.LayoutParams();
        paramBundle.fwc.height = -1;
        paramBundle.fwc.width = -1;
        paramBundle.fwb = ((WindowManager)getSystemService("window"));
        paramBundle.fwc.x = 0;
        paramBundle.fwc.y = 0;
        paramBundle.fwc.type = 2002;
        paramBundle.mView = ((View)localObject2);
        paramBundle.fwc.gravity = 51;
        paramBundle.fwc.format = 1;
        paramBundle.fwa = new FrameLayout(this);
        paramBundle.fwa.setPadding(0, 0, 0, 0);
        paramBundle.fwd = new ViewGroup.LayoutParams(-1, -1);
        paramBundle.fwa.addView(paramBundle.mView, paramBundle.fwd);
        paramBundle.fwb.addView(paramBundle.fwa, paramBundle.fwc);
        paramBundle.fwe = true;
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    GMTrace.i(1685506228224L, 12558);
    HomeUI localHomeUI = this.uPX;
    if ((localHomeUI.uOX != null) && (localHomeUI.uOX.hMt))
    {
      GMTrace.o(1685506228224L, 12558);
      return false;
    }
    int i = localHomeUI.uOv.cO().cP().getHeight();
    if (i == 0)
    {
      DisplayMetrics localDisplayMetrics = localHomeUI.uOv.getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
        i = localHomeUI.uOv.getResources().getDimensionPixelSize(R.f.aWQ);
      }
    }
    for (;;)
    {
      localHomeUI.uOC = paramMenu.add(0, 1, 0, R.l.eYc);
      localHomeUI.uOC.setIcon(R.k.dsL);
      int j = com.tencent.mm.bg.a.fromDPToPix(localHomeUI.uOv, 68);
      localHomeUI.uOD = paramMenu.add(0, 2, 0, R.l.eYb);
      if (localHomeUI.uOz == null)
      {
        paramMenu = new ViewGroup.LayoutParams(j, i);
        localHomeUI.uOz = View.inflate(localHomeUI.uOv, R.i.cTu, null);
        localHomeUI.uOA = ((ImageView)localHomeUI.uOz.findViewById(R.h.icon));
        localHomeUI.uOB = localHomeUI.uOz.findViewById(R.h.cIE);
        localHomeUI.uOz.setLayoutParams(paramMenu);
        localHomeUI.uOz.setBackgroundResource(R.g.bbD);
        localHomeUI.uOz.setMinimumHeight(i);
        localHomeUI.uOz.setMinimumWidth(j);
        localHomeUI.uOA.setImageResource(R.k.dsy);
        localHomeUI.uOz.setContentDescription(localHomeUI.getString(R.l.eYb));
        localHomeUI.uOz.setOnClickListener(new HomeUI.56(localHomeUI));
        localHomeUI.uOz.post(new HomeUI.2(localHomeUI));
      }
      localHomeUI.kh(false);
      android.support.v4.view.m.a(localHomeUI.uOD, localHomeUI.uOz);
      if (localHomeUI.uOC != null)
      {
        android.support.v4.view.m.a(localHomeUI.uOC, 2);
        localHomeUI.uOC.setVisible(true);
      }
      if (localHomeUI.uOD != null)
      {
        android.support.v4.view.m.a(localHomeUI.uOD, 2);
        localHomeUI.uOD.setVisible(true);
      }
      localHomeUI.uOz.getLayoutParams().width = j;
      localHomeUI.uOz.getLayoutParams().height = i;
      v.v("MicroMsg.LauncherUI", "onCreateOptionsMenu");
      GMTrace.o(1685506228224L, 12558);
      return true;
      i = localHomeUI.uOv.getResources().getDimensionPixelSize(R.f.aWR);
    }
  }
  
  protected void onDestroy()
  {
    GMTrace.i(1686311534592L, 12564);
    super.onDestroy();
    HomeUI localHomeUI = this.uPX;
    com.tencent.mm.sdk.b.a.uql.c(localHomeUI.uOP);
    com.tencent.mm.sdk.b.a.uql.c(localHomeUI.uOS);
    com.tencent.mm.sdk.b.a.uql.c(localHomeUI.uOR);
    ae.I(localHomeUI.uPd);
    Looper.myQueue().removeIdleHandler(localHomeUI.uOL);
    if (localHomeUI.uOf) {
      Looper.myQueue().removeIdleHandler(localHomeUI.uOM);
    }
    if (localHomeUI.uOF != null) {
      localHomeUI.uOF.sJU = null;
    }
    localHomeUI.uPl.clear();
    bPz();
    v.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), com.tencent.mm.sdk.platformtools.bf.eq(this), Integer.valueOf(uPU.size()) });
    i.oj().fwj.remove(this);
    GMTrace.o(1686311534592L, 12564);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    GMTrace.i(1684298268672L, 12549);
    v.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[] { Integer.valueOf(hashCode()), com.tencent.mm.sdk.platformtools.bf.eq(this) });
    this.fNF = paramIntent;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!WorkerProfile.oC().oD())
    {
      GMTrace.o(1684298268672L, 12549);
      return;
    }
    if (bPB())
    {
      v.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
      GMTrace.o(1684298268672L, 12549);
      return;
    }
    if ((this.fNF != null) && (com.tencent.mm.sdk.platformtools.r.a(this.fNF, "Intro_Need_Clear_Top ", false)))
    {
      v.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
      finish();
      ez(this);
      GMTrace.o(1684298268672L, 12549);
      return;
    }
    HomeUI localHomeUI = this.uPX;
    if ((paramIntent.getFlags() & 0x4000000) == 67108864)
    {
      localHomeUI.ki(false);
      localHomeUI.uOh = true;
      localHomeUI.uOi = com.tencent.mm.sdk.platformtools.r.a(paramIntent, "Intro_Notify", false);
    }
    localHomeUI.yW(0);
    if (this.uQa)
    {
      v.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
      if (!WorkerProfile.oC().oD())
      {
        GMTrace.o(1684298268672L, 12549);
        return;
      }
      ag(paramIntent);
    }
    GMTrace.o(1684298268672L, 12549);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = 0;
    GMTrace.i(1685640445952L, 12559);
    HomeUI localHomeUI = this.uPX;
    int i;
    if ((localHomeUI.uOv.bPC() != null) && (localHomeUI.uOv.bPC().isShowing())) {
      i = j;
    }
    while (i != 0)
    {
      GMTrace.o(1685640445952L, 12559);
      return true;
      if (localHomeUI.uOX != null)
      {
        i = j;
        if (localHomeUI.uOX.hMt) {
          break;
        }
      }
      else
      {
        if (paramMenuItem.getItemId() == 2)
        {
          com.tencent.mm.plugin.report.service.g.oSF.A(10919, "0");
          localHomeUI.bPf();
        }
        for (;;)
        {
          i = 1;
          break;
          i = j;
          if (paramMenuItem.getItemId() != 1) {
            break;
          }
          bool = com.tencent.mm.pluginsdk.i.a.a(localHomeUI.uOv, "android.permission.ACCESS_COARSE_LOCATION", 65, null, null);
          v.i("MicroMsg.LauncherUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            localHomeUI.bPh();
          }
        }
      }
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    GMTrace.o(1685640445952L, 12559);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(1686177316864L, 12563);
    v.d("MicroMsg.LauncherUI", "onPause, chatting is show ");
    super.onPause();
    q localq = bPC();
    HomeUI localHomeUI = this.uPX;
    com.tencent.mm.sdk.a.b.aX(false);
    localHomeUI.uOu = HomeUI.a.uPG;
    if (!ap.yQ()) {
      ap.getNotification().aw(false);
    }
    if (localHomeUI.uOY != null) {}
    for (boolean bool = localHomeUI.uOY.isShown();; bool = false)
    {
      v.i("MicroMsg.LauncherUI", "edw onPause, chatting is show " + bool);
      com.tencent.mm.sdk.f.e.post(new HomeUI.53(localHomeUI, bool), "directReport_onPause");
      if (!localHomeUI.uOv.isFinishing()) {
        com.tencent.mm.ui.widget.j.a(localHomeUI.uOv);
      }
      if (localHomeUI.uOf)
      {
        v.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onMainTabPause");
        if (WorkerProfile.oC().oD())
        {
          localHomeUI.bPl();
          if (ap.zb())
          {
            ap.yY();
            com.tencent.mm.u.c.vr().b(localHomeUI.uOI);
            ap.yY();
            com.tencent.mm.u.c.wW().b(localHomeUI);
            com.tencent.mm.q.c.uk().b(localHomeUI.uOH);
            com.tencent.mm.sdk.b.a.uql.c(localHomeUI.uOG);
            com.tencent.mm.sdk.b.a.uql.c(localHomeUI.uOJ);
            com.tencent.mm.sdk.b.a.uql.c(localHomeUI.uNJ);
          }
        }
      }
      if ((localHomeUI.uOp != null) && (localHomeUI.uOp.isShowing())) {
        localHomeUI.uOp.dismiss();
      }
      if ((localHomeUI.uOX != null) && (localHomeUI.uOX.bPY())) {
        localHomeUI.uOX.uSO.mEnable = false;
      }
      v.v("MicroMsg.LauncherUI", "KEVIN Launcher onPause %d", new Object[] { Integer.valueOf(localHomeUI.lBf) });
      if (localHomeUI.uOg != null)
      {
        ap.vd().b(255, localHomeUI.uOg);
        ap.vd().b(384, localHomeUI.uOg);
        localHomeUI.uOg = null;
      }
      if ((WorkerProfile.oC().oD()) && (localq == null)) {
        break;
      }
      GMTrace.o(1686177316864L, 12563);
      return;
    }
    this.uQb = false;
    GMTrace.o(1686177316864L, 12563);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(1691546025984L, 12603);
    Object localObject = this.uPY;
    int i;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      if (paramArrayOfInt == null)
      {
        i = -1;
        v.w("MicroMsg.LauncherUICheckPermissionHelper", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, com.tencent.mm.sdk.platformtools.bf.bJP() });
        ae.f(new j.1((j)localObject), 500L);
        i = 1;
        if (i == 0)
        {
          localObject = this.uPX;
          switch (paramInt)
          {
          }
        }
      }
    }
    for (;;)
    {
      GMTrace.o(1691546025984L, 12603);
      return;
      i = paramArrayOfInt.length;
      break;
      v.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        i = 0;
        break;
      case 32: 
      case 64: 
      case 96: 
        i = R.l.eFD;
        if (paramInt == 96)
        {
          i = R.l.eFC;
          if (paramArrayOfInt[0] != 0) {
            break label458;
          }
          if (paramInt != 32) {
            break label420;
          }
          com.tencent.mm.plugin.report.c.oRz.a(462L, 0L, 1L, true);
          if (((j)localObject).uQK != null) {
            ((j)localObject).uQK.run();
          }
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramInt != 64) {
            break label358;
          }
          i = R.l.eFA;
          break label358;
          if (paramInt == 96)
          {
            com.tencent.mm.plugin.report.c.oRz.a(462L, 1L, 1L, true);
            break label382;
          }
          com.tencent.mm.plugin.report.c.oRz.a(462L, 2L, 1L, true);
          break label382;
          com.tencent.mm.ui.base.g.a(this, getString(i), getString(R.l.eFE), getString(R.l.evo), getString(R.l.cancel), false, new j.2((j)localObject, paramInt, this), new j.3((j)localObject, paramInt, this));
        }
      case 33: 
      case 70: 
      case 97: 
        label358:
        label382:
        label420:
        label458:
        i = R.l.eFD;
        if (paramInt == 97)
        {
          i = R.l.eFC;
          label532:
          if (paramArrayOfInt[0] != 0) {
            break label618;
          }
          if (paramInt != 33) {
            break label578;
          }
          com.tencent.mm.plugin.report.c.oRz.a(462L, 9L, 1L, true);
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramInt != 70) {
            break label532;
          }
          i = R.l.eFA;
          break label532;
          label578:
          if (paramInt == 97)
          {
            com.tencent.mm.plugin.report.c.oRz.a(462L, 10L, 1L, true);
          }
          else
          {
            com.tencent.mm.plugin.report.c.oRz.a(462L, 11L, 1L, true);
            continue;
            label618:
            ((j)localObject).oGy = false;
            com.tencent.mm.ui.base.g.a(this, getString(i), getString(R.l.eFE), getString(R.l.evo), getString(R.l.cancel), false, new j.4((j)localObject, paramInt, this), new j.5((j)localObject, paramInt, this));
          }
        }
        if (paramInt == 80) {}
        for (paramInt = R.l.eFB; paramArrayOfInt[0] != 0; paramInt = R.l.eFy)
        {
          com.tencent.mm.ui.base.g.a(((HomeUI)localObject).uOv, ((HomeUI)localObject).getString(paramInt), ((HomeUI)localObject).getString(R.l.eFE), ((HomeUI)localObject).getString(R.l.evo), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.38((HomeUI)localObject), new HomeUI.39((HomeUI)localObject));
          GMTrace.o(1691546025984L, 12603);
          return;
        }
        if (paramArrayOfInt[0] == 0)
        {
          ((HomeUI)localObject).bPh();
          GMTrace.o(1691546025984L, 12603);
          return;
        }
        com.tencent.mm.ui.base.g.a(((HomeUI)localObject).uOv, ((HomeUI)localObject).getString(R.l.eFA), ((HomeUI)localObject).getString(R.l.eFE), ((HomeUI)localObject).getString(R.l.evo), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.40((HomeUI)localObject), null);
        GMTrace.o(1691546025984L, 12603);
        return;
        if (paramArrayOfInt[0] == 0)
        {
          paramArrayOfString = ((HomeUI)localObject).yX(((HomeUI)localObject).lBf);
          if ((paramArrayOfString instanceof g)) {
            ((g)paramArrayOfString).bOV();
          }
          GMTrace.o(1691546025984L, 12603);
          return;
        }
        com.tencent.mm.ui.base.g.a(((HomeUI)localObject).uOv, ((HomeUI)localObject).getString(R.l.eFA), ((HomeUI)localObject).getString(R.l.eFE), ((HomeUI)localObject).getString(R.l.evo), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.41((HomeUI)localObject), null);
        GMTrace.o(1691546025984L, 12603);
        return;
        if (paramArrayOfInt[0] == 0)
        {
          if (((HomeUI)localObject).uOX != null)
          {
            ((HomeUI)localObject).uOX.bVY();
            GMTrace.o(1691546025984L, 12603);
          }
        }
        else
        {
          if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
          for (paramInt = R.l.eFy;; paramInt = R.l.eFB)
          {
            if (paramArrayOfInt[0] != 0) {
              com.tencent.mm.ui.base.g.a(((HomeUI)localObject).uOv, ((HomeUI)localObject).getString(paramInt), ((HomeUI)localObject).getString(R.l.eFE), ((HomeUI)localObject).getString(R.l.evo), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.42((HomeUI)localObject), new HomeUI.43((HomeUI)localObject));
            }
            GMTrace.o(1691546025984L, 12603);
            return;
          }
          if (paramArrayOfInt[0] == 0)
          {
            if (((HomeUI)localObject).uOX != null)
            {
              if (paramInt == 19)
              {
                ((HomeUI)localObject).uOX.aTz();
                GMTrace.o(1691546025984L, 12603);
                return;
              }
              if (paramInt == 21)
              {
                ((HomeUI)localObject).uOX.bTZ();
                GMTrace.o(1691546025984L, 12603);
                return;
              }
              ((HomeUI)localObject).uOX.bTX();
              GMTrace.o(1691546025984L, 12603);
            }
          }
          else
          {
            if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
            for (paramInt = R.l.eFy;; paramInt = R.l.eFB)
            {
              if (paramArrayOfInt[0] != 0) {
                com.tencent.mm.ui.base.g.a(((HomeUI)localObject).uOv, ((HomeUI)localObject).getString(paramInt), ((HomeUI)localObject).getString(R.l.eFE), ((HomeUI)localObject).getString(R.l.evo), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.44((HomeUI)localObject), new HomeUI.46((HomeUI)localObject));
              }
              GMTrace.o(1691546025984L, 12603);
              return;
            }
            if (paramArrayOfInt[0] == 0)
            {
              ((HomeUI)localObject).uOX.bUb();
              GMTrace.o(1691546025984L, 12603);
              return;
            }
            com.tencent.mm.ui.base.g.a(((HomeUI)localObject).uOv, ((HomeUI)localObject).getString(R.l.eFy), ((HomeUI)localObject).getString(R.l.eFE), ((HomeUI)localObject).getString(R.l.evo), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.47((HomeUI)localObject), null);
            GMTrace.o(1691546025984L, 12603);
            return;
            if (paramArrayOfInt[0] == 0)
            {
              if (paramInt == 67)
              {
                ((HomeUI)localObject).uOX.bVC();
                GMTrace.o(1691546025984L, 12603);
                return;
              }
              ((HomeUI)localObject).uOX.bVD();
              GMTrace.o(1691546025984L, 12603);
              return;
            }
            com.tencent.mm.ui.base.g.a(((HomeUI)localObject).uOv, ((HomeUI)localObject).getString(R.l.eFA), ((HomeUI)localObject).getString(R.l.eFE), ((HomeUI)localObject).getString(R.l.evo), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.48((HomeUI)localObject), null);
            GMTrace.o(1691546025984L, 12603);
            return;
            if (paramArrayOfInt[0] == 0)
            {
              ((HomeUI)localObject).uOX.bUa();
              GMTrace.o(1691546025984L, 12603);
              return;
            }
            com.tencent.mm.ui.base.g.a(((HomeUI)localObject).uOv, ((HomeUI)localObject).getString(R.l.eFA), ((HomeUI)localObject).getString(R.l.eFE), ((HomeUI)localObject).getString(R.l.evo), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.49((HomeUI)localObject), null);
            GMTrace.o(1691546025984L, 12603);
            return;
            if (paramArrayOfInt[0] == 0)
            {
              if (paramInt == 82)
              {
                ((HomeUI)localObject).uOX.aTy();
                GMTrace.o(1691546025984L, 12603);
                return;
              }
              ((HomeUI)localObject).uOX.bTY();
              GMTrace.o(1691546025984L, 12603);
              return;
            }
            com.tencent.mm.ui.base.g.a(((HomeUI)localObject).uOv, ((HomeUI)localObject).getString(R.l.eFB), ((HomeUI)localObject).getString(R.l.eFE), ((HomeUI)localObject).getString(R.l.evo), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.50((HomeUI)localObject), null);
          }
        }
        break;
      }
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    GMTrace.i(1686982623232L, 12569);
    super.onRestoreInstanceState(paramBundle);
    HomeUI localHomeUI = this.uPX;
    localHomeUI.uOK = paramBundle.getString("last_restore_talker");
    v.d("MicroMsg.LauncherUI", "onRestoreInstantceState:%s", new Object[] { localHomeUI.uOK });
    GMTrace.o(1686982623232L, 12569);
  }
  
  public void onResume()
  {
    GMTrace.i(1684566704128L, 12551);
    super.onResume();
    if (bPB())
    {
      v.i("MicroMsg.LauncherUI", "onResume handleExitIntent");
      GMTrace.o(1684566704128L, 12551);
      return;
    }
    v.i("MicroMsg.LauncherUI", "onResume hasLoaderFinished:%b", new Object[] { Boolean.valueOf(this.uPZ) });
    if (!this.uPZ)
    {
      GMTrace.o(1684566704128L, 12551);
      return;
    }
    bPA();
    if (this.uPY.oGy)
    {
      boolean bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "");
      v.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_PHONE_STATE", 97, "", "");
        v.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          v.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 70, "", "")) });
        }
      }
    }
    GMTrace.o(1684566704128L, 12551);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    GMTrace.i(1687116840960L, 12570);
    HomeUI localHomeUI = this.uPX;
    if ((localHomeUI.uOX != null) && (!com.tencent.mm.sdk.platformtools.bf.mA(localHomeUI.uOX.bTW())))
    {
      v.d("MicroMsg.LauncherUI", "onSaveInstanceState:%s", new Object[] { localHomeUI.uOX.bTW() });
      paramBundle.putString("last_restore_talker", localHomeUI.uOX.bTW());
    }
    GMTrace.o(1687116840960L, 12570);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    Object localObject2 = null;
    GMTrace.i(1683090309120L, 12540);
    Object localObject3 = this.uPX;
    Object localObject1 = localObject2;
    if (((HomeUI)localObject3).uOX != null)
    {
      localObject1 = localObject2;
      if (((HomeUI)localObject3).uOX.vIs != null)
      {
        if (((HomeUI)localObject3).uOX.bPY()) {
          break label76;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.onWindowStartingActionMode(paramCallback);
      }
      GMTrace.o(1683090309120L, 12540);
      return (ActionMode)localObject2;
      label76:
      localObject1 = localObject2;
      if (!com.tencent.mm.compatible.util.d.eq(22))
      {
        localObject3 = ((HomeUI)localObject3).uOX.vIs.startActionMode(paramCallback);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public final void oo()
  {
    GMTrace.i(1686579970048L, 12566);
    v.d("MicroMsg.LauncherUI", "KEVIN onInit");
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14923400740864L, 111188);
        LauncherUI.a(LauncherUI.this);
        GMTrace.o(14923400740864L, 111188);
      }
      
      public final String toString()
      {
        GMTrace.i(14923534958592L, 111189);
        String str = super.toString() + "|onInit";
        GMTrace.o(14923534958592L, 111189);
        return str;
      }
    });
    GMTrace.o(1686579970048L, 12566);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/LauncherUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */