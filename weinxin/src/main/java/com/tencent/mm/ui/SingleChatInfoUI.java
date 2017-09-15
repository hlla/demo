package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.m;
import com.tencent.mm.pluginsdk.l.n;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay.a;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.contact.e;
import java.util.LinkedList;
import java.util.List;

public class SingleChatInfoUI
  extends MMPreference
  implements l.m
{
  private static boolean jUD;
  private String fJC;
  private ad handler;
  private SharedPreferences hgn;
  private f isp;
  private x jht;
  private boolean kkZ;
  private int krG;
  private com.tencent.mm.pluginsdk.ui.d krI;
  boolean krJ;
  private String krR;
  private ContactListExpandPreference krt;
  private CheckBoxPreference kru;
  private CheckBoxPreference krw;
  
  static
  {
    GMTrace.i(3469662486528L, 25851);
    jUD = false;
    GMTrace.o(3469662486528L, 25851);
  }
  
  public SingleChatInfoUI()
  {
    GMTrace.i(3467246567424L, 25833);
    this.handler = new ad(Looper.getMainLooper());
    this.hgn = null;
    this.krG = -1;
    this.krI = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2832262496256L, 21102);
        GMTrace.o(2832262496256L, 21102);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        GMTrace.i(2832128278528L, 21101);
        GMTrace.o(2832128278528L, 21101);
      }
    });
    this.krJ = false;
    this.krR = "";
    GMTrace.o(3467246567424L, 25833);
  }
  
  private void ajg()
  {
    GMTrace.i(3468454526976L, 25842);
    if (this.hgn == null) {
      this.hgn = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    this.kkZ = this.jht.tD();
    if (this.kkZ)
    {
      zj(0);
      if (this.kru != null) {
        this.hgn.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.isp.notifyDataSetChanged();
      GMTrace.o(3468454526976L, 25842);
      return;
      zj(8);
      if (this.kru != null) {
        this.hgn.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  public final void B(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(3468588744704L, 25843);
    if ((paramString1.equals(this.fJC)) && (this.krt != null)) {
      this.krt.notifyChanged();
    }
    GMTrace.o(3468588744704L, 25843);
  }
  
  protected final void KD()
  {
    GMTrace.i(3468186091520L, 25840);
    this.isp = this.vpG;
    qL(getString(R.l.eNv));
    this.krt = ((ContactListExpandPreference)this.isp.Tc("roominfo_contact_anchor"));
    this.krt.a(this.isp, this.krt.igr);
    this.krt.jr(true).js(false);
    if ((this.jht != null) && (this.jht.field_deleteFlag == 1)) {
      this.krt.jr(false);
    }
    this.kru = ((CheckBoxPreference)this.isp.Tc("room_notify_new_msg"));
    this.krw = ((CheckBoxPreference)this.isp.Tc("room_placed_to_the_top"));
    if (this.hgn == null) {
      this.hgn = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    Object localObject;
    if (this.jht != null)
    {
      localObject = this.hgn.edit();
      ap.yY();
      ((SharedPreferences.Editor)localObject).putBoolean("room_placed_to_the_top", com.tencent.mm.u.c.wW().Rs(this.jht.field_username)).commit();
      this.kkZ = this.jht.tD();
      this.hgn.edit().putBoolean("room_notify_new_msg", this.kkZ).commit();
    }
    for (;;)
    {
      ap.yY();
      this.krG = com.tencent.mm.u.c.wT().Ay(this.fJC);
      this.isp.notifyDataSetChanged();
      if (this.krt != null)
      {
        localObject = new LinkedList();
        ((List)localObject).add(this.fJC);
        this.krt.k(this.fJC, (List)localObject);
        this.mTv.setOnScrollListener(this.krI);
        this.krt.a(this.krI);
        this.krt.a(new ContactListExpandPreference.a()
        {
          public final void ajm()
          {
            GMTrace.i(2831725625344L, 21098);
            if (SingleChatInfoUI.b(SingleChatInfoUI.this) != null) {
              SingleChatInfoUI.b(SingleChatInfoUI.this).bET();
            }
            GMTrace.o(2831725625344L, 21098);
          }
          
          public final void kG(int paramAnonymousInt)
          {
            GMTrace.i(2831457189888L, 21096);
            GMTrace.o(2831457189888L, 21096);
          }
          
          public final void kH(int paramAnonymousInt)
          {
            GMTrace.i(2831591407616L, 21097);
            String str = SingleChatInfoUI.b(SingleChatInfoUI.this).xp(paramAnonymousInt);
            Object localObject2 = u.mz(SingleChatInfoUI.b(SingleChatInfoUI.this).xr(paramAnonymousInt));
            Object localObject1 = localObject2;
            if (u.mA((String)localObject2))
            {
              ap.yY();
              bb localbb = com.tencent.mm.u.c.wS().AG(str);
              localObject1 = localObject2;
              if (localbb != null)
              {
                localObject1 = localObject2;
                if (!u.mA(localbb.field_encryptUsername)) {
                  localObject1 = localbb.field_conRemark;
                }
              }
            }
            if (u.mA(str))
            {
              GMTrace.o(2831591407616L, 21097);
              return;
            }
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("Contact_User", str);
            ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
            ((Intent)localObject2).putExtra("Contact_Nick", u.mz(SingleChatInfoUI.b(SingleChatInfoUI.this).xq(paramAnonymousInt)));
            ((Intent)localObject2).putExtra("Contact_RoomMember", true);
            ap.yY();
            localObject1 = com.tencent.mm.u.c.wR().Rb(str);
            if ((localObject1 != null) && ((int)((com.tencent.mm.j.a)localObject1).gTG > 0) && (com.tencent.mm.j.a.ez(((af)localObject1).field_type))) {
              e.a((Intent)localObject2, str);
            }
            ((Intent)localObject2).putExtra("Kdel_from", 0);
            com.tencent.mm.bb.d.b(SingleChatInfoUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject2, 0);
            GMTrace.o(2831591407616L, 21097);
          }
          
          public final void kI(int paramAnonymousInt)
          {
            GMTrace.i(2831859843072L, 21099);
            SingleChatInfoUI.c(SingleChatInfoUI.this);
            GMTrace.o(2831859843072L, 21099);
          }
        });
      }
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2880044007424L, 21458);
          SingleChatInfoUI.this.finish();
          GMTrace.o(2880044007424L, 21458);
          return true;
        }
      });
      GMTrace.o(3468186091520L, 25840);
      return;
      this.hgn.edit().putBoolean("room_notify_new_msg", false).commit();
      this.kkZ = false;
    }
  }
  
  public final int OO()
  {
    GMTrace.i(3468051873792L, 25839);
    int i = R.o.ftR;
    GMTrace.o(3468051873792L, 25839);
    return i;
  }
  
  public final h a(SharedPreferences paramSharedPreferences)
  {
    GMTrace.i(3468722962432L, 25844);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, paramSharedPreferences);
    GMTrace.o(3468722962432L, 25844);
    return paramSharedPreferences;
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool = true;
    GMTrace.i(3468320309248L, 25841);
    paramf = paramPreference.igr;
    if (paramf.equals("room_notify_new_msg")) {
      if (!this.kkZ)
      {
        this.kkZ = bool;
        if (!this.kkZ) {
          break label155;
        }
        o.n(this.jht);
        label51:
        ap.yY();
        this.jht = com.tencent.mm.u.c.wR().Rb(this.fJC);
        if (this.hgn == null) {
          this.hgn = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.hgn.edit().putBoolean("room_notify_new_msg", this.kkZ).commit();
        ajg();
      }
    }
    for (;;)
    {
      GMTrace.o(3468320309248L, 25841);
      return false;
      bool = false;
      break;
      label155:
      o.o(this.jht);
      break label51;
      if (paramf.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.krR, 0);
        if (this.jht != null)
        {
          ap.yY();
          if (com.tencent.mm.u.c.wW().Rs(this.jht.field_username)) {
            o.m(this.jht.field_username, true);
          }
          for (;;)
          {
            paramf = paramf.edit();
            ap.yY();
            paramf.putBoolean("room_placed_to_the_top", com.tencent.mm.u.c.wW().Rs(this.jht.field_username)).commit();
            break;
            o.l(this.jht.field_username, true);
          }
        }
      }
      else if (paramf.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.jht.field_username);
        com.tencent.mm.bb.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
      }
      else if (paramf.equals("room_search_chatting_content"))
      {
        paramf = new Intent();
        paramf.putExtra("detail_username", this.fJC);
        com.tencent.mm.bb.d.b(this, "search", ".ui.FTSChattingTalkerUI", paramf);
      }
      else if (paramf.equals("room_clear_chatting_history"))
      {
        paramf = getString(R.l.elk, new Object[] { this.jht.tL() });
        com.tencent.mm.ui.base.g.a(this.uRf.uRz, paramf, "", getString(R.l.dGl), getString(R.l.dGk), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2898700271616L, 21597);
            SingleChatInfoUI.d(SingleChatInfoUI.this);
            GMTrace.o(2898700271616L, 21597);
          }
        }, null, R.e.aSJ);
      }
      else if (paramf.equals("room_expose"))
      {
        paramf = new Intent();
        paramf.putExtra("k_username", this.fJC);
        paramf.putExtra("showShare", false);
        paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(39) }));
        com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(3467917656064L, 25838);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      GMTrace.o(3467917656064L, 25838);
      return;
    }
    switch (paramInt1)
    {
    default: 
      GMTrace.o(3467917656064L, 25838);
      return;
    }
    if (paramInt2 == -1)
    {
      finish();
      GMTrace.o(3467917656064L, 25838);
      return;
    }
    GMTrace.o(3467917656064L, 25838);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3467380785152L, 25834);
    super.onCreate(paramBundle);
    if (l.a.szL != null) {
      l.a.szL.a(this);
    }
    this.fJC = getIntent().getStringExtra("Single_Chat_Talker");
    ap.yY();
    this.jht = com.tencent.mm.u.c.wR().Rb(this.fJC);
    this.krR = (getPackageName() + "_preferences");
    KD();
    GMTrace.o(3467380785152L, 25834);
  }
  
  public void onDestroy()
  {
    GMTrace.i(3467783438336L, 25837);
    com.tencent.mm.ui.h.a.dismiss();
    if (l.a.szL != null) {
      l.a.szL.b(this);
    }
    super.onDestroy();
    GMTrace.o(3467783438336L, 25837);
  }
  
  public void onPause()
  {
    GMTrace.i(3467649220608L, 25836);
    super.onPause();
    GMTrace.o(3467649220608L, 25836);
  }
  
  public void onResume()
  {
    GMTrace.i(3467515002880L, 25835);
    ajg();
    Object localObject;
    if (this.krt != null)
    {
      localObject = new LinkedList();
      ((List)localObject).add(this.fJC);
      this.krt.k(this.fJC, (List)localObject);
    }
    this.isp.notifyDataSetChanged();
    super.onResume();
    if (!this.krJ)
    {
      localObject = getIntent().getStringExtra("need_matte_high_light_item");
      if (!u.mA((String)localObject))
      {
        final int i = this.isp.Te((String)localObject);
        setSelection(i - 3);
        new ad().postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(3476104937472L, 25899);
            View localView = ((com.tencent.mm.ui.base.preference.a)SingleChatInfoUI.a(SingleChatInfoUI.this)).a(i, SingleChatInfoUI.this.mTv);
            if (localView != null) {
              com.tencent.mm.ui.h.a.b(SingleChatInfoUI.this.uRf.uRz, localView);
            }
            GMTrace.o(3476104937472L, 25899);
          }
        }, 10L);
      }
      this.krJ = true;
    }
    GMTrace.o(3467515002880L, 25835);
  }
  
  private static final class a
    implements DialogInterface.OnCancelListener
  {
    public a()
    {
      GMTrace.i(2087488323584L, 15553);
      GMTrace.o(2087488323584L, 15553);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      GMTrace.i(2087622541312L, 15554);
      SingleChatInfoUI.bQr();
      GMTrace.o(2087622541312L, 15554);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/SingleChatInfoUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */