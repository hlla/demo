package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.accountsync.ui.InviteFacebookFriendsUI;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@Deprecated
public class FacebookFriendUI
  extends MMActivity
  implements com.tencent.mm.x.d.a, e
{
  private ListView irY;
  private View isa;
  private ProgressDialog isb;
  String isc;
  private boolean ngn;
  d uVW;
  private TextView uVX;
  
  public FacebookFriendUI()
  {
    GMTrace.i(2687038914560L, 20020);
    this.isb = null;
    this.uVX = null;
    this.ngn = false;
    GMTrace.o(2687038914560L, 20020);
  }
  
  private void av(String paramString1, String paramString2)
  {
    GMTrace.i(2688112656384L, 20028);
    g.a(this, paramString2, paramString1, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(2725022531584L, 20303);
        paramAnonymousDialogInterface = new Intent(FacebookFriendUI.this.uRf.uRz, FacebookAuthUI.class);
        paramAnonymousDialogInterface.putExtra("is_force_unbind", true);
        FacebookFriendUI.this.uRf.uRz.startActivity(paramAnonymousDialogInterface);
        FacebookFriendUI.this.finish();
        GMTrace.o(2725022531584L, 20303);
      }
    }, null);
    GMTrace.o(2688112656384L, 20028);
  }
  
  protected final void KD()
  {
    GMTrace.i(2687844220928L, 20026);
    this.irY = ((ListView)findViewById(R.h.ckp));
    this.uVX = ((TextView)findViewById(R.h.bLI));
    this.uVX.setText(R.l.egY);
    final Object localObject1 = (TextView)findViewById(R.h.bLN);
    ((TextView)localObject1).setText(R.l.egW);
    final Object localObject2 = new p(true, true);
    ((p)localObject2).wlY = new p.b()
    {
      public final void OE()
      {
        GMTrace.i(2732404506624L, 20358);
        GMTrace.o(2732404506624L, 20358);
      }
      
      public final void OF()
      {
        GMTrace.i(2732538724352L, 20359);
        GMTrace.o(2732538724352L, 20359);
      }
      
      public final void OG()
      {
        GMTrace.i(2732672942080L, 20360);
        GMTrace.o(2732672942080L, 20360);
      }
      
      public final void OH()
      {
        GMTrace.i(16823118462976L, 125342);
        GMTrace.o(16823118462976L, 125342);
      }
      
      public final boolean mQ(String paramAnonymousString)
      {
        GMTrace.i(2732136071168L, 20356);
        GMTrace.o(2732136071168L, 20356);
        return false;
      }
      
      public final void mR(String paramAnonymousString)
      {
        GMTrace.i(2732270288896L, 20357);
        FacebookFriendUI.a(FacebookFriendUI.this, bf.my(paramAnonymousString));
        paramAnonymousString = FacebookFriendUI.this;
        if (paramAnonymousString.uVW != null) {
          paramAnonymousString.uVW.yB(paramAnonymousString.isc);
        }
        GMTrace.o(2732270288896L, 20357);
      }
    };
    a((p)localObject2);
    this.uVW = new d(this, new k.a()
    {
      public final void OI()
      {
        GMTrace.i(2774817308672L, 20674);
        if ((m.ym()) && (FacebookFriendUI.a(FacebookFriendUI.this)))
        {
          if (FacebookFriendUI.b(FacebookFriendUI.this).getCount() != 0) {
            break label64;
          }
          localObject1.setVisibility(0);
        }
        for (;;)
        {
          FacebookFriendUI.c(FacebookFriendUI.this);
          GMTrace.o(2774817308672L, 20674);
          return;
          label64:
          localObject1.setVisibility(8);
        }
      }
      
      public final void OJ()
      {
        GMTrace.i(2774951526400L, 20675);
        GMTrace.o(2774951526400L, 20675);
      }
    });
    this.uVW.uVS = new d.a()
    {
      public final void zv(int paramAnonymousInt)
      {
        GMTrace.i(2674422448128L, 19926);
        if (paramAnonymousInt > 0)
        {
          FacebookFriendUI.d(FacebookFriendUI.this).setVisibility(8);
          GMTrace.o(2674422448128L, 19926);
          return;
        }
        FacebookFriendUI.d(FacebookFriendUI.this).setVisibility(0);
        GMTrace.o(2674422448128L, 19926);
      }
    };
    this.irY.setAdapter(this.uVW);
    this.isa = findViewById(R.h.ckq);
    this.irY.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(2764079890432L, 20594);
        paramAnonymousAdapterView = (com.tencent.mm.modelfriend.h)FacebookFriendUI.b(FacebookFriendUI.this).getItem(paramAnonymousInt - FacebookFriendUI.e(FacebookFriendUI.this).getHeaderViewsCount());
        if ((paramAnonymousAdapterView.status == 100) || (paramAnonymousAdapterView.status == 101))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.getUsername());
          paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.EV());
          paramAnonymousView.putExtra("Contact_KFacebookId", paramAnonymousAdapterView.gkj);
          paramAnonymousView.putExtra("Contact_KFacebookName", paramAnonymousAdapterView.Fe());
          paramAnonymousView.putExtra("Contact_Scene", 31);
          com.tencent.mm.plugin.c.a.imb.d(paramAnonymousView, FacebookFriendUI.this);
        }
        if (paramAnonymousAdapterView.status == 102)
        {
          GMTrace.o(2764079890432L, 20594);
          return;
        }
        GMTrace.o(2764079890432L, 20594);
      }
    });
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + m.ym());
    if (m.ym())
    {
      this.irY.setVisibility(0);
      this.isa.setVisibility(8);
      ap.yY();
      long l = bf.c((Long)com.tencent.mm.u.c.vr().get(65831, null));
      ap.yY();
      localObject1 = bf.mz((String)com.tencent.mm.u.c.vr().get(65830, null));
      if ((bf.aA(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new com.tencent.mm.ui.g.a.c("290293790992170");
        ((com.tencent.mm.ui.g.a.c)localObject2).TW((String)localObject1);
        new h((com.tencent.mm.ui.g.a.c)localObject2, new com.tencent.mm.v.a()
        {
          public final void m(Bundle paramAnonymousBundle)
          {
            GMTrace.i(2771864518656L, 20652);
            super.m(paramAnonymousBundle);
            GMTrace.o(2771864518656L, 20652);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            GMTrace.i(2771998736384L, 20653);
            super.onError(paramAnonymousInt, paramAnonymousString);
            if (paramAnonymousInt == 3) {
              FacebookFriendUI.f(FacebookFriendUI.this);
            }
            GMTrace.o(2771998736384L, 20653);
          }
        }).bQI();
      }
      localObject1 = new com.tencent.mm.modelfriend.v();
      ((com.tencent.mm.modelfriend.v)localObject1).FI();
      localObject2 = new ai(new ai.a()
      {
        public final boolean oQ()
        {
          GMTrace.i(2763811454976L, 20592);
          ap.yY();
          com.tencent.mm.u.c.vr().set(65829, Integer.valueOf(1));
          ap.vd().a(localObject1, 0);
          GMTrace.o(2763811454976L, 20592);
          return false;
        }
      }, false);
      ap.yY();
      if (bf.f((Integer)com.tencent.mm.u.c.vr().get(65829, null)) > 0)
      {
        ap.yY();
        com.tencent.mm.u.c.vr().set(65829, Integer.valueOf(1));
        ap.vd().a((k)localObject1, 0);
        ActionBarActivity localActionBarActivity = this.uRf.uRz;
        getString(R.l.dIG);
        this.isb = g.a(localActionBarActivity, getString(R.l.eGZ), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(2755624173568L, 20531);
            localObject2.KI();
            ap.vd().c(localObject1);
            GMTrace.o(2755624173568L, 20531);
          }
        });
        a(0, getString(R.l.ejT), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            GMTrace.i(2686099390464L, 20013);
            FacebookFriendUI.this.startActivity(new Intent(FacebookFriendUI.this, InviteFacebookFriendsUI.class));
            GMTrace.o(2686099390464L, 20013);
            return true;
          }
        });
      }
    }
    for (;;)
    {
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2780722888704L, 20718);
          FacebookFriendUI.this.aGY();
          FacebookFriendUI.this.finish();
          GMTrace.o(2780722888704L, 20718);
          return true;
        }
      });
      new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2653350264832L, 19769);
          BackwardSupportUtil.c.a(FacebookFriendUI.e(FacebookFriendUI.this));
          GMTrace.o(2653350264832L, 19769);
        }
      };
      GMTrace.o(2687844220928L, 20026);
      return;
      ((ai)localObject2).v(5000L, 5000L);
      break;
      this.irY.setVisibility(8);
      this.isa.setVisibility(0);
      ((TextView)findViewById(R.h.ckr)).setText(R.l.ejM);
      this.isa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2665429860352L, 19859);
          FacebookFriendUI.this.startActivity(new Intent(FacebookFriendUI.this, FacebookAuthUI.class));
          GMTrace.o(2665429860352L, 19859);
        }
      });
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2687978438656L, 20027);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramk.getType() != 32)
    {
      GMTrace.o(2687978438656L, 20027);
      return;
    }
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramk = paramString;
      if (bf.mA(paramString)) {
        paramk = "error";
      }
      av(getString(R.l.dIG), paramk);
      GMTrace.o(2687978438656L, 20027);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.uVW.a(null, null);
      GMTrace.o(2687978438656L, 20027);
      return;
    }
    Toast.makeText(this, R.l.eAS, 0).show();
    GMTrace.o(2687978438656L, 20027);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2687710003200L, 20025);
    int i = R.i.dcH;
    GMTrace.o(2687710003200L, 20025);
    return i;
  }
  
  public final void ho(String paramString)
  {
    GMTrace.i(2688246874112L, 20029);
    this.uVW.notifyDataSetChanged();
    GMTrace.o(2688246874112L, 20029);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2687173132288L, 20021);
    super.onCreate(paramBundle);
    zd(R.l.ejS);
    ap.vd().a(32, this);
    KD();
    GMTrace.o(2687173132288L, 20021);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2687575785472L, 20024);
    ap.vd().b(32, this);
    this.uVW.aEP();
    super.onDestroy();
    GMTrace.o(2687575785472L, 20024);
  }
  
  public void onPause()
  {
    GMTrace.i(2687441567744L, 20023);
    super.onPause();
    com.tencent.mm.x.n.Bl().e(this);
    GMTrace.o(2687441567744L, 20023);
  }
  
  protected void onResume()
  {
    GMTrace.i(2687307350016L, 20022);
    super.onResume();
    com.tencent.mm.x.n.Bl().d(this);
    this.uVW.notifyDataSetChanged();
    GMTrace.o(2687307350016L, 20022);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/FacebookFriendUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */