package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.az.a;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.a.e;
import com.tencent.mm.u.a.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aw;
import com.tencent.mm.u.ax;
import com.tencent.mm.u.bg;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import java.lang.ref.WeakReference;

public final class k
  extends b
{
  protected aw wdk;
  
  public k(Context paramContext, aw paramaw)
  {
    super(paramContext);
    GMTrace.i(14498467414016L, 108022);
    this.wdk = null;
    this.wdk = paramaw;
    final int i;
    final int j;
    if (this.view != null)
    {
      paramContext = (MMImageView)this.view.findViewById(R.h.cgR);
      paramaw = (TextView)this.view.findViewById(R.h.cgS);
      switch (this.wdk.type)
      {
      case 5: 
      default: 
        paramaw = this.view;
        i = this.wdk.type;
        j = this.wdk.showType;
        switch (i)
        {
        case 5: 
        default: 
          paramContext = null;
        }
        break;
      }
    }
    for (;;)
    {
      paramaw.setOnClickListener(paramContext);
      GMTrace.o(14498467414016L, 108022);
      return;
      paramContext.setImageResource(R.k.dAa);
      paramaw.setText(R.l.dML);
      break;
      paramContext.setImageResource(R.k.dAb);
      paramaw.setText(R.l.ekj);
      break;
      paramContext.setImageResource(R.k.dzZ);
      paramaw.setText(R.l.dMT);
      break;
      paramContext.setImageResource(R.k.dAg);
      paramaw.setText(R.l.dMN);
      break;
      paramContext.setImageResource(R.k.dAc);
      paramaw.setText(R.l.dMR);
      break;
      paramContext.setImageResource(R.k.dAd);
      paramaw.setText(R.l.dMQ);
      break;
      paramContext.setImageResource(R.k.dAe);
      paramaw.setText(R.l.dMS);
      break;
      paramContext.setImageResource(R.k.dAf);
      paramaw.setText(R.l.dMO);
      break;
      paramContext.setImageResource(R.k.dzY);
      paramaw.setText(R.l.dMK);
      break;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14498064760832L, 108019);
          ax.zj().aJ(i, j);
          paramAnonymousView = (Context)k.this.sLV.get();
          if (paramAnonymousView != null)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(11002, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            ap.yY();
            boolean bool = bf.f((Boolean)com.tencent.mm.u.c.vr().get(4103, null));
            new Intent().putExtra("KEnterFromBanner", true);
            if (!bool)
            {
              d.w(paramAnonymousView, "nearby", ".ui.NearbyFriendsIntroUI");
              GMTrace.o(14498064760832L, 108019);
              return;
            }
            Object localObject = bg.zM();
            if (localObject == null)
            {
              d.w(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              GMTrace.o(14498064760832L, 108019);
              return;
            }
            String str = bf.mz(((bg)localObject).getProvince());
            int i = bf.a(Integer.valueOf(((bg)localObject).gkh), 0);
            if ((bf.mA(str)) || (i == 0))
            {
              d.w(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              GMTrace.o(14498064760832L, 108019);
              return;
            }
            localObject = LauncherUI.bPy();
            if (localObject != null) {
              ((LauncherUI)localObject).uPX.SC("tab_find_friend");
            }
            a.dl(paramAnonymousView);
          }
          GMTrace.o(14498064760832L, 108019);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14502493945856L, 108052);
          ax.zj().aJ(i, j);
          paramAnonymousView = (Context)k.this.sLV.get();
          if (paramAnonymousView != null)
          {
            ap.yY();
            if (!com.tencent.mm.u.c.isSDCardAvailable())
            {
              s.eP(paramAnonymousView);
              GMTrace.o(14502493945856L, 108052);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("intent_set_avatar", true);
            localIntent.putExtra("KEnterFromBanner", true);
            d.b(paramAnonymousView, "setting", ".ui.setting.SettingsPersonalInfoUI", localIntent);
            com.tencent.mm.plugin.report.service.g.oSF.i(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          }
          GMTrace.o(14502493945856L, 108052);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14499675373568L, 108031);
          ax.zj().aJ(i, j);
          k.m((Context)k.this.sLV.get(), false);
          GMTrace.o(14499675373568L, 108031);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14494172446720L, 107990);
          ax.zj().aJ(i, j);
          k.m((Context)k.this.sLV.get(), true);
          GMTrace.o(14494172446720L, 107990);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14496454148096L, 108007);
          ax.zj().aJ(i, j);
          paramAnonymousView = (Context)k.this.sLV.get();
          Intent localIntent = new Intent();
          localIntent.putExtra("preceding_scence", 17);
          d.b(paramAnonymousView, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
          com.tencent.mm.plugin.report.service.g.oSF.i(11002, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
          com.tencent.mm.plugin.report.service.g.oSF.i(12065, new Object[] { Integer.valueOf(2) });
          GMTrace.o(14496454148096L, 108007);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14504372994048L, 108066);
          ax.zj().aJ(i, j);
          d.w((Context)k.this.sLV.get(), "game", ".ui.GameCenterUI");
          com.tencent.mm.plugin.report.service.g.oSF.i(11002, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
          GMTrace.o(14504372994048L, 108066);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14507594219520L, 108090);
          ax.zj().aJ(i, j);
          paramAnonymousView = (Context)k.this.sLV.get();
          int i;
          if ((com.tencent.mm.u.m.xW() & 0x10000) == 0)
          {
            i = 1;
            if (i == 0) {
              break label101;
            }
            d.w(paramAnonymousView, "masssend", ".ui.MassSendHistoryUI");
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(11002, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
            GMTrace.o(14507594219520L, 108090);
            return;
            i = 0;
            break;
            label101:
            d.b(paramAnonymousView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
          }
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14509875920896L, 108107);
          ax.zj().aJ(i, j);
          paramAnonymousView = (Context)k.this.sLV.get();
          ap.yY();
          String str = (String)com.tencent.mm.u.c.vr().get(68377, null);
          ap.yY();
          com.tencent.mm.u.c.vr().set(68377, "");
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
          if (!bf.mA(str)) {}
          for (boolean bool1 = false;; bool1 = true)
          {
            boolean bool2 = bool1;
            if (com.tencent.mm.plugin.sns.b.m.pPa != null)
            {
              bool2 = bool1;
              if (com.tencent.mm.plugin.sns.b.m.pPa.Ks() > 0) {
                bool2 = false;
              }
            }
            localIntent.putExtra("sns_resume_state", bool2);
            d.b(paramAnonymousView, "sns", ".ui.En_424b8e16", localIntent);
            com.tencent.mm.plugin.report.service.g.oSF.i(11002, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
            GMTrace.o(14509875920896L, 108107);
            return;
          }
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14498333196288L, 108021);
          ax.zj().aJ(i, j);
          d.b((Context)k.this.sLV.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
          GMTrace.o(14498333196288L, 108021);
        }
      };
    }
  }
  
  public static void m(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(16020630667264L, 119363);
    if (paramContext == null)
    {
      GMTrace.o(16020630667264L, 119363);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, BindMContactIntroUI.class);
    localIntent.putExtra("key_upload_scene", 8);
    localIntent.putExtra("is_bind_for_contact_sync", paramBoolean);
    localIntent.putExtra("KEnterFromBanner", true);
    MMWizardActivity.w(paramContext, localIntent);
    paramContext = com.tencent.mm.u.a.g.Ae().gu("4");
    if ((paramContext != null) && (!bf.mA(paramContext.value)) && ((paramContext.value.equals("1")) || (paramContext.value.equals("2"))))
    {
      com.tencent.mm.u.a.g.Ae().gu("4").result = "1";
      f.gz("4");
      if (paramContext.value.equals("1"))
      {
        ap.yY();
        com.tencent.mm.u.c.vr().set(328195, Boolean.valueOf(true));
        GMTrace.o(16020630667264L, 119363);
        return;
      }
      ap.yY();
      com.tencent.mm.u.c.vr().set(328196, Boolean.valueOf(true));
      GMTrace.o(16020630667264L, 119363);
      return;
    }
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(11002, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      GMTrace.o(16020630667264L, 119363);
      return;
    }
    com.tencent.mm.plugin.report.service.g.oSF.i(11002, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    GMTrace.o(16020630667264L, 119363);
  }
  
  public final void destroy()
  {
    GMTrace.i(14498735849472L, 108024);
    GMTrace.o(14498735849472L, 108024);
  }
  
  public final int getLayoutId()
  {
    GMTrace.i(14498601631744L, 108023);
    int i = R.i.dhz;
    GMTrace.o(14498601631744L, 108023);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */