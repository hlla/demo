package com.tencent.mm.ui.bizchat;

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
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.modelbiz.a.b;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.d.a;
import com.tencent.mm.modelbiz.a.d.a.a;
import com.tencent.mm.modelbiz.a.d.a.b;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.a.x;
import com.tencent.mm.modelbiz.m;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.b;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.l;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BizChatroomInfoUI
  extends MMPreference
  implements m, com.tencent.mm.y.e
{
  private static boolean krU;
  private int fromScene;
  private SharedPreferences hgn;
  private ProgressDialog isb;
  private f isp;
  private boolean jUD;
  private long jZq;
  private String jZw;
  private boolean kkZ;
  private boolean krC;
  private int krD;
  private com.tencent.mm.pluginsdk.ui.d krI;
  boolean krJ;
  private SignaturePreference krp;
  private ContactListExpandPreference krt;
  private CheckBoxPreference kru;
  private CheckBoxPreference krv;
  private CheckBoxPreference krw;
  private j osq;
  private d.a vtU;
  private c vtp;
  private String vuR;
  private boolean vuS;
  private boolean vuT;
  private boolean vuU;
  private int vuV;
  private j vuW;
  
  static
  {
    GMTrace.i(2981646827520L, 22215);
    krU = false;
    GMTrace.o(2981646827520L, 22215);
  }
  
  public BizChatroomInfoUI()
  {
    GMTrace.i(2976949207040L, 22180);
    this.isb = null;
    this.hgn = null;
    this.krC = false;
    this.vuS = false;
    this.vtp = null;
    this.osq = null;
    this.vuW = null;
    this.krI = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2971043627008L, 22136);
        GMTrace.o(2971043627008L, 22136);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        GMTrace.i(2970909409280L, 22135);
        com.tencent.mm.ah.n.GX().bi(paramAnonymousInt);
        GMTrace.o(2970909409280L, 22135);
      }
    });
    this.krJ = false;
    this.jUD = false;
    this.vtU = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        GMTrace.i(3005403365376L, 22392);
        if ((paramAnonymousb != null) && (paramAnonymousb.hwz != null) && (paramAnonymousb.hwo == BizChatroomInfoUI.g(BizChatroomInfoUI.this)) && (paramAnonymousb.hwy != d.a.a.hwv))
        {
          v.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
          paramAnonymousb = w.DJ().aa(BizChatroomInfoUI.g(BizChatroomInfoUI.this));
          BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousb);
          BizChatroomInfoUI.h(BizChatroomInfoUI.this);
        }
        GMTrace.o(3005403365376L, 22392);
      }
    };
    GMTrace.o(2976949207040L, 22180);
  }
  
  private boolean Tk(String paramString)
  {
    GMTrace.i(2977754513408L, 22186);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        gt localgt = new gt();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("id");
          paramString = w.DL().iE(str);
          if (paramString != null) {
            break label264;
          }
          paramString = new j();
          paramString.field_userId = str;
          paramString.field_userName = ((JSONObject)localObject).getString("nick_name");
          paramString.field_brandUserName = this.jZw;
          paramString.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
          paramString.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
          paramString.field_UserVersion = ((JSONObject)localObject).getInt("ver");
          if (this.vuW == null) {
            break label267;
          }
          localObject = this.vuW.field_addMemberUrl;
          paramString.field_addMemberUrl = ((String)localObject);
          if (!w.DL().b(paramString)) {
            w.DL().a(paramString);
          }
          localObject = new gs();
          ((gs)localObject).tjg = paramString.field_userId;
          localgt.tjh.add(localObject);
          i += 1;
          continue;
        }
        a(localgt, null);
        GMTrace.o(2977754513408L, 22186);
        return true;
      }
      catch (JSONException paramString)
      {
        v.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", new Object[] { paramString.getMessage() });
        v.printErrStackTrace("MicroMsg.BizChatroomInfoUI", paramString, "", new Object[0]);
      }
      GMTrace.o(2977754513408L, 22186);
      return false;
      label264:
      continue;
      label267:
      Object localObject = null;
    }
  }
  
  private void a(final gt paramgt1, gt paramgt2)
  {
    GMTrace.i(2977888731136L, 22187);
    v.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
    if (paramgt1 == null) {}
    for (String str = getString(R.l.eLV);; str = getString(R.l.dBZ))
    {
      w.DN();
      paramgt1 = com.tencent.mm.modelbiz.a.h.a(this.vtp.field_brandUserName, this.vtp.field_bizChatServId, paramgt1, paramgt2, this);
      getString(R.l.dIG);
      this.isb = g.a(this, str, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2990639415296L, 22282);
          ap.vd().c(paramgt1);
          GMTrace.o(2990639415296L, 22282);
        }
      });
      GMTrace.o(2977888731136L, 22187);
      return;
    }
  }
  
  private void aTv()
  {
    GMTrace.i(2978828255232L, 22194);
    v.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
    if (this.hgn == null) {
      this.hgn = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.vuS) {
      this.vuU = this.vtp.fu(16);
    }
    for (this.vuV = this.vtp.field_bitFlag;; this.vuV = this.osq.field_bitFlag)
    {
      if (this.krw != null) {
        this.hgn.edit().putBoolean("room_placed_to_the_top", this.vuU).commit();
      }
      this.isp.notifyDataSetChanged();
      GMTrace.o(2978828255232L, 22194);
      return;
      this.vuU = this.osq.fu(16);
    }
  }
  
  private void ajd()
  {
    GMTrace.i(2979230908416L, 22197);
    if (this.vuS)
    {
      this.krD = com.tencent.mm.modelbiz.a.e.ab(this.jZq);
      if (this.krD != 0)
      {
        qL(getString(R.l.elf, new Object[] { getString(R.l.eNv), Integer.valueOf(this.krD) }));
        GMTrace.o(2979230908416L, 22197);
        return;
      }
    }
    qL(getString(R.l.eNv));
    GMTrace.o(2979230908416L, 22197);
  }
  
  private void aje()
  {
    GMTrace.i(2978559819776L, 22192);
    Object localObject;
    if (this.krt != null)
    {
      if (!this.vuS) {
        break label88;
      }
      localObject = com.tencent.mm.modelbiz.a.e.ac(this.jZq);
      if (localObject == null) {
        break label113;
      }
      this.krD = ((List)localObject).size();
      label45:
      if (this.krD > 1) {
        break label121;
      }
      this.krt.jr(true).js(false);
    }
    for (;;)
    {
      this.krt.k(this.jZw, (List)localObject);
      GMTrace.o(2978559819776L, 22192);
      return;
      label88:
      localObject = new LinkedList();
      ((List)localObject).add(this.vtp.field_bizChatServId);
      break;
      label113:
      this.krD = 0;
      break label45;
      label121:
      this.krt.jr(true).js(this.krC);
    }
  }
  
  private void ajg()
  {
    GMTrace.i(2978962472960L, 22195);
    if (this.hgn == null) {
      this.hgn = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.vuS)
    {
      this.kkZ = this.vtp.fu(1);
      this.vuV = this.vtp.field_bitFlag;
      if (!this.kkZ) {
        break label166;
      }
      zj(0);
      if (this.kru != null) {
        this.hgn.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.isp.notifyDataSetChanged();
      GMTrace.o(2978962472960L, 22195);
      return;
      this.kkZ = this.osq.fu(1);
      this.vuV = this.osq.field_bitFlag;
      break;
      label166:
      zj(8);
      if (this.kru != null) {
        this.hgn.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void aji()
  {
    GMTrace.i(2979096690688L, 22196);
    if ((this.vtp != null) && (this.krp != null))
    {
      if (ajj())
      {
        Object localObject2 = this.vtp.field_chatName;
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 50) {
            localObject1 = ((String)localObject2).substring(0, 32);
          }
        }
        v.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[] { localObject1 });
        SignaturePreference localSignaturePreference = this.krp;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 0) {}
        }
        else
        {
          localObject2 = getString(R.l.eTW);
        }
        localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.h.a(this, (CharSequence)localObject2));
        GMTrace.o(2979096690688L, 22196);
        return;
      }
      this.krp.setSummary(getString(R.l.eMs));
    }
    GMTrace.o(2979096690688L, 22196);
  }
  
  private boolean ajj()
  {
    GMTrace.i(2979365126144L, 22198);
    if (this.vuS) {}
    for (String str = this.vtp.field_chatName; bf.mA(str); str = this.osq.field_userName)
    {
      GMTrace.o(2979365126144L, 22198);
      return false;
    }
    GMTrace.o(2979365126144L, 22198);
    return true;
  }
  
  private void bTm()
  {
    GMTrace.i(2978694037504L, 22193);
    v.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
    if (this.hgn == null) {
      this.hgn = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.vuS)
    {
      this.vuT = this.vtp.fu(8);
      this.vuV = this.vtp.field_bitFlag;
      if (!this.vuT) {
        break label171;
      }
      if (this.krv != null) {
        this.hgn.edit().putBoolean("room_save_to_contact", true).commit();
      }
    }
    for (;;)
    {
      this.isp.notifyDataSetChanged();
      GMTrace.o(2978694037504L, 22193);
      return;
      this.vuT = this.osq.fu(8);
      this.vuV = this.osq.field_bitFlag;
      break;
      label171:
      if (this.krv != null) {
        this.hgn.edit().putBoolean("room_save_to_contact", false).commit();
      }
    }
  }
  
  private void bTn()
  {
    GMTrace.i(2979767779328L, 22201);
    if (this.krt != null)
    {
      aji();
      ajd();
      ajg();
      aje();
      bTm();
      aTv();
      this.krt.notifyChanged();
    }
    this.isp.notifyDataSetChanged();
    GMTrace.o(2979767779328L, 22201);
  }
  
  private void bTo()
  {
    GMTrace.i(2979901997056L, 22202);
    v.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
    this.vtp.field_chatName = this.vuR;
    this.vtp.field_bitFlag = this.vuV;
    this.kkZ = this.vtp.fu(1);
    this.vuT = this.vtp.fu(8);
    this.vuU = this.vtp.fu(16);
    w.DJ().b(this.vtp);
    if (this.vuU) {
      w.DK().Y(this.vtp.field_bizChatLocalId);
    }
    for (;;)
    {
      this.hgn.edit().putBoolean("room_placed_to_the_top", w.DK().X(this.vtp.field_bizChatLocalId)).commit();
      aji();
      ajg();
      aTv();
      bTm();
      Toast.makeText(this, getString(R.l.eLQ), 0).show();
      GMTrace.o(2979901997056L, 22202);
      return;
      if (!this.vuU) {
        w.DK().Z(this.vtp.field_bizChatLocalId);
      }
    }
  }
  
  private void q(boolean paramBoolean, int paramInt)
  {
    GMTrace.i(2978425602048L, 22191);
    this.vuV = this.vtp.field_bitFlag;
    this.vuR = this.vtp.field_chatName;
    Object localObject;
    if (this.vuS)
    {
      if (paramBoolean) {
        localObject = this.vtp;
      }
      for (((c)localObject).field_bitFlag |= paramInt;; ((c)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
      {
        v.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[] { Integer.valueOf(this.vtp.field_bitFlag) });
        w.DJ().b(this.vtp);
        localObject = new gq();
        ((gq)localObject).tiZ = this.vtp.field_bizChatServId;
        ((gq)localObject).tjb = this.vtp.field_bitFlag;
        w.DN();
        com.tencent.mm.modelbiz.a.h.a(this.vtp.field_brandUserName, (gq)localObject, this);
        GMTrace.o(2978425602048L, 22191);
        return;
        localObject = this.vtp;
      }
    }
    if (paramBoolean) {
      localObject = this.osq;
    }
    for (((j)localObject).field_bitFlag |= paramInt;; ((j)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
    {
      w.DL().b(this.osq);
      this.vtp.field_bitFlag = this.osq.field_bitFlag;
      w.DJ().b(this.vtp);
      break;
      localObject = this.osq;
    }
  }
  
  public final j AC(int paramInt)
  {
    GMTrace.i(17878606675968L, 133206);
    if ((this.krt.getItem(paramInt) instanceof j))
    {
      j localj = (j)this.krt.getItem(paramInt);
      GMTrace.o(17878606675968L, 133206);
      return localj;
    }
    GMTrace.o(17878606675968L, 133206);
    return null;
  }
  
  protected final void KD()
  {
    GMTrace.i(2978157166592L, 22189);
    this.isp = this.vpG;
    Object localObject = null;
    if (this.vtp != null)
    {
      localObject = this.vtp.field_ownerUserId;
      this.krD = this.vtp.DU().size();
    }
    if (bf.mA((String)localObject))
    {
      this.krC = false;
      v.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
      this.krt = ((ContactListExpandPreference)this.isp.Tc("roominfo_contact_anchor"));
      this.krt.a(this.isp, this.krt.igr);
      this.krp = ((SignaturePreference)this.isp.Tc("room_name"));
      this.kru = ((CheckBoxPreference)this.isp.Tc("room_notify_new_msg"));
      this.krw = ((CheckBoxPreference)this.isp.Tc("room_placed_to_the_top"));
      this.krv = ((CheckBoxPreference)this.isp.Tc("room_save_to_contact"));
      localObject = this.krt;
      boolean bool = this.vuS;
      if (((ContactListExpandPreference)localObject).sLE != null) {
        ((ContactListExpandPreference)localObject).sLE.sKQ.sLg = bool;
      }
      localObject = this.krt;
      bool = this.krC;
      if (((ContactListExpandPreference)localObject).sLE != null) {
        ((ContactListExpandPreference)localObject).sLE.sKQ.sLf = bool;
      }
      if (!this.krC) {
        break label439;
      }
      this.krt.jr(true).js(true);
    }
    for (;;)
    {
      if (this.vtp != null) {
        this.krt.MR(this.vtp.field_ownerUserId);
      }
      this.krt.bES();
      this.krt.bEV();
      if (!this.vuS)
      {
        this.isp.aV("room_save_to_contact", true);
        this.isp.aV("room_name", true);
        this.isp.aV("room_del_quit", true);
      }
      bTm();
      aTv();
      ajg();
      if (this.krt != null)
      {
        this.mTv.setOnScrollListener(this.krI);
        this.krt.a(this.krI);
        this.krt.a(new ContactListExpandPreference.a()
        {
          public final void ajm()
          {
            GMTrace.i(2989834108928L, 22276);
            if (BizChatroomInfoUI.b(BizChatroomInfoUI.this) != null) {
              BizChatroomInfoUI.b(BizChatroomInfoUI.this).bET();
            }
            GMTrace.o(2989834108928L, 22276);
          }
          
          public final void kG(int paramAnonymousInt)
          {
            GMTrace.i(2989565673472L, 22274);
            BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousInt);
            GMTrace.o(2989565673472L, 22274);
          }
          
          public final void kH(int paramAnonymousInt)
          {
            boolean bool = true;
            GMTrace.i(2989699891200L, 22275);
            j localj = BizChatroomInfoUI.this.AC(paramAnonymousInt);
            if ((localj == null) || (bf.mA(localj.field_profileUrl)))
            {
              if (localj == null) {}
              for (;;)
              {
                v.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
                GMTrace.o(2989699891200L, 22275);
                return;
                bool = false;
              }
            }
            v.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[] { localj.field_profileUrl });
            w.DN();
            com.tencent.mm.modelbiz.a.h.a(localj.field_userId, localj.field_brandUserName, BizChatroomInfoUI.this);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", localj.field_profileUrl);
            localIntent.putExtra("useJs", true);
            com.tencent.mm.bb.d.b(BizChatroomInfoUI.this.uRf.uRz, "webview", ".ui.tools.WebViewUI", localIntent);
            GMTrace.o(2989699891200L, 22275);
          }
          
          public final void kI(int paramAnonymousInt)
          {
            GMTrace.i(2989968326656L, 22277);
            BizChatroomInfoUI.c(BizChatroomInfoUI.this);
            GMTrace.o(2989968326656L, 22277);
          }
        });
      }
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2985673359360L, 22245);
          BizChatroomInfoUI.this.finish();
          GMTrace.o(2985673359360L, 22245);
          return true;
        }
      });
      GMTrace.o(2978157166592L, 22189);
      return;
      this.krC = ((String)localObject).equals(w.DL().iG(this.jZw));
      break;
      label439:
      this.krt.jr(true).js(false);
    }
  }
  
  public final int OO()
  {
    GMTrace.i(2978022948864L, 22188);
    int i = R.o.fsZ;
    GMTrace.o(2978022948864L, 22188);
    return i;
  }
  
  public final com.tencent.mm.ui.base.preference.h a(SharedPreferences paramSharedPreferences)
  {
    GMTrace.i(2980036214784L, 22203);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, paramSharedPreferences);
    GMTrace.o(2980036214784L, 22203);
    return paramSharedPreferences;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(2979633561600L, 22200);
    if (paramk == null)
    {
      v.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      GMTrace.o(2979633561600L, 22200);
      return;
    }
    v.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramk.getType()) });
    this.krD = com.tencent.mm.modelbiz.a.e.ab(this.jZq);
    v.d("MicroMsg.BizChatroomInfoUI", "now is " + this.krD);
    if (this.isb != null) {
      this.isb.dismiss();
    }
    paramString = com.tencent.mm.f.a.dn(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      GMTrace.o(2979633561600L, 22200);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      v.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
      bTo();
      GMTrace.o(2979633561600L, 22200);
      return;
    }
    paramk.getType();
    GMTrace.o(2979633561600L, 22200);
  }
  
  public final void a(int paramInt, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(2979499343872L, 22199);
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    if (paramk.getType() == 1355)
    {
      Object localObject = ((com.tencent.mm.modelbiz.a.n)paramk).Eb();
      paramk = ((com.tencent.mm.modelbiz.a.n)paramk).Ec();
      localObject = w.DJ().ir(((ms)localObject).tru.tyW.tiZ);
      if (localObject == null)
      {
        Toast.makeText(aa.getContext(), getString(R.l.eLP), 0).show();
        GMTrace.o(2979499343872L, 22199);
        return;
      }
      if (this.fromScene == 2)
      {
        localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
        localIntent.putExtra("Contact_User", paramk.tjf);
        localIntent.putExtra("biz_chat_chat_id", ((c)localObject).field_bizChatLocalId);
        com.tencent.mm.bb.d.a(this, ".ui.bizchat.BizChatConversationUI", localIntent);
        GMTrace.o(2979499343872L, 22199);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("Chat_User", paramk.tjf);
      localIntent.putExtra("key_biz_chat_id", ((c)localObject).field_bizChatLocalId);
      localIntent.putExtra("finish_direct", true);
      localIntent.putExtra("key_need_send_video", false);
      localIntent.putExtra("key_is_biz_chat", true);
      com.tencent.mm.plugin.chatroom.a.imb.e(localIntent, this);
      GMTrace.o(2979499343872L, 22199);
      return;
    }
    if (paramk.getType() == 1356)
    {
      if (paramInt != 0)
      {
        bTo();
        GMTrace.o(2979499343872L, 22199);
      }
    }
    else if ((paramk.getType() == 1353) && (paramInt >= 0) && (this.osq != null))
    {
      this.osq = w.DL().iE(this.osq.field_userId);
      bTn();
    }
    GMTrace.o(2979499343872L, 22199);
  }
  
  public final boolean a(final f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    GMTrace.i(2978291384320L, 22190);
    paramf = paramPreference.igr;
    if (paramf.equals("room_name"))
    {
      paramf = "";
      if (ajj()) {
        paramf = this.vtp.field_chatName;
      }
      g.a(this.uRf.uRz, getString(R.l.eMI), paramf, "", 32, new g.b()
      {
        public final boolean u(CharSequence paramAnonymousCharSequence)
        {
          GMTrace.i(2989028802560L, 22270);
          boolean bool = BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramf, paramAnonymousCharSequence);
          GMTrace.o(2989028802560L, 22270);
          return bool;
        }
      });
    }
    label203:
    do
    {
      for (;;)
      {
        GMTrace.o(2978291384320L, 22190);
        return false;
        if (paramf.equals("room_notify_new_msg"))
        {
          if (!this.kkZ) {}
          for (bool1 = true;; bool1 = false)
          {
            this.kkZ = bool1;
            q(this.kkZ, 1);
            ajg();
            break;
          }
        }
        if (paramf.equals("room_placed_to_the_top"))
        {
          if (!this.vuU) {}
          for (;;)
          {
            this.vuU = bool1;
            q(this.vuU, 16);
            if (this.vtp == null) {
              break;
            }
            if (!this.vuU) {
              break label203;
            }
            w.DK().Y(this.vtp.field_bizChatLocalId);
            break;
            bool1 = false;
          }
          w.DK().Z(this.vtp.field_bizChatLocalId);
        }
        else
        {
          if (!paramf.equals("room_del_quit")) {
            break;
          }
          v.d("MicroMsg.BizChatroomInfoUI", " quit " + this.jZq);
          g.a(this.uRf.uRz, getString(R.l.ebi), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2985941794816L, 22247);
              BizChatroomInfoUI.d(BizChatroomInfoUI.this);
              GMTrace.o(2985941794816L, 22247);
            }
          }, null);
        }
      }
    } while (!paramf.equals("room_save_to_contact"));
    if (!this.vuT) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.vuT = bool1;
      q(this.vuT, 8);
      bTm();
      break;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    GMTrace.i(2977620295680L, 22185);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      GMTrace.o(2977620295680L, 22185);
      return;
    }
    switch (paramInt1)
    {
    default: 
      GMTrace.o(2977620295680L, 22185);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    String str;
    boolean bool;
    if (paramIntent != null)
    {
      v.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
      str = paramIntent.getString("enterprise_members");
      v.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", new Object[] { str });
      if (this.vuS) {
        bool = Tk(str);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        Toast.makeText(this, getString(R.l.eLP), 0).show();
        GMTrace.o(2977620295680L, 22185);
        return;
        sr localsr = new sr();
        c localc = new c();
        if (this.vuW != null) {}
        for (paramIntent = this.vuW.field_addMemberUrl;; paramIntent = null)
        {
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.jZw;
          if (!com.tencent.mm.modelbiz.a.e.a(localc, str, this.osq.field_userId, localsr)) {
            break label279;
          }
          w.DN();
          paramIntent = com.tencent.mm.modelbiz.a.h.a(this.jZw, localsr, this);
          getString(R.l.dIG);
          this.isb = g.a(this, getString(R.l.dBZ), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(2999632003072L, 22349);
              ap.vd().c(paramIntent);
              GMTrace.o(2999632003072L, 22349);
            }
          });
          bool = true;
          break;
        }
        label279:
        bool = false;
      }
      else
      {
        GMTrace.o(2977620295680L, 22185);
        return;
        bool = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2977083424768L, 22181);
    super.onCreate(paramBundle);
    w.DJ().a(this.vtU, Looper.getMainLooper());
    this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
    this.jZw = getIntent().getStringExtra("Chat_User");
    this.jZq = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.vtp = w.DJ().aa(this.jZq);
    if (this.vtp != null)
    {
      this.vuR = this.vtp.field_chatName;
      this.vuS = com.tencent.mm.modelbiz.a.e.it(this.vtp.field_bizChatServId);
      if (!this.vuS) {
        this.osq = w.DL().iE(this.vtp.field_bizChatServId);
      }
      this.vuW = w.DL().iF(this.jZw);
    }
    KD();
    if ((this.vtp == null) || (this.vtp.field_bizChatServId == null) || (this.jZw == null))
    {
      GMTrace.o(2977083424768L, 22181);
      return;
    }
    if (this.vtp.DV())
    {
      w.DN();
      com.tencent.mm.modelbiz.a.h.Z(this.vtp.field_bizChatServId, this.jZw);
      GMTrace.o(2977083424768L, 22181);
      return;
    }
    w.DN();
    com.tencent.mm.modelbiz.a.h.a(this.vtp.field_bizChatServId, this.jZw, this);
    GMTrace.o(2977083424768L, 22181);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2977486077952L, 22184);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.ui.h.a.dismiss();
    w.DJ().a(this.vtU);
    super.onDestroy();
    GMTrace.o(2977486077952L, 22184);
  }
  
  public void onPause()
  {
    GMTrace.i(2977351860224L, 22183);
    super.onPause();
    GMTrace.o(2977351860224L, 22183);
  }
  
  public void onResume()
  {
    GMTrace.i(2977217642496L, 22182);
    aji();
    ajd();
    ajg();
    aTv();
    bTm();
    aje();
    this.isp.notifyDataSetChanged();
    super.onResume();
    if (!this.krJ)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bf.mA(str))
      {
        final int i = this.isp.Te(str);
        setSelection(i - 3);
        new ad().postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2997350301696L, 22332);
            View localView = ((com.tencent.mm.ui.base.preference.a)BizChatroomInfoUI.a(BizChatroomInfoUI.this)).a(i, BizChatroomInfoUI.this.mTv);
            if (localView != null) {
              com.tencent.mm.ui.h.a.b(BizChatroomInfoUI.this.uRf.uRz, localView);
            }
            GMTrace.o(2997350301696L, 22332);
          }
        }, 10L);
      }
      this.krJ = true;
    }
    GMTrace.o(2977217642496L, 22182);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bizchat/BizChatroomInfoUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */