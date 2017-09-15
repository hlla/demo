package com.tencent.mm.plugin.accountsync.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.i.a;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.q;
import com.tencent.mm.modelfriend.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.List;

public class InviteFacebookFriendsUI
  extends MMActivity
  implements e
{
  private ListView irY;
  a irZ;
  private View isa;
  private ProgressDialog isb;
  String isc;
  private final int isd;
  
  public InviteFacebookFriendsUI()
  {
    GMTrace.i(7838583750656L, 58402);
    this.isb = null;
    this.isd = 5;
    GMTrace.o(7838583750656L, 58402);
  }
  
  private void av(String paramString1, String paramString2)
  {
    GMTrace.i(7839120621568L, 58406);
    com.tencent.mm.ui.base.g.a(this, paramString2, paramString1, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(7845026201600L, 58450);
        paramAnonymousDialogInterface = new Intent(InviteFacebookFriendsUI.this.uRf.uRz, FacebookAuthUI.class);
        paramAnonymousDialogInterface.putExtra("is_force_unbind", true);
        InviteFacebookFriendsUI.this.uRf.uRz.startActivity(paramAnonymousDialogInterface);
        InviteFacebookFriendsUI.this.finish();
        GMTrace.o(7845026201600L, 58450);
      }
    }, null);
    GMTrace.o(7839120621568L, 58406);
  }
  
  protected final void KD()
  {
    GMTrace.i(7838986403840L, 58405);
    this.irY = ((ListView)findViewById(R.h.ckp));
    final Object localObject1 = (TextView)findViewById(R.h.bLN);
    ((TextView)localObject1).setText(R.l.egW);
    final Object localObject2 = new p(true, true);
    ((p)localObject2).wlY = new p.b()
    {
      public final void OE()
      {
        GMTrace.i(7842476064768L, 58431);
        GMTrace.o(7842476064768L, 58431);
      }
      
      public final void OF()
      {
        GMTrace.i(7842610282496L, 58432);
        GMTrace.o(7842610282496L, 58432);
      }
      
      public final void OG()
      {
        GMTrace.i(7842744500224L, 58433);
        GMTrace.o(7842744500224L, 58433);
      }
      
      public final void OH()
      {
        GMTrace.i(16933982306304L, 126168);
        GMTrace.o(16933982306304L, 126168);
      }
      
      public final boolean mQ(String paramAnonymousString)
      {
        GMTrace.i(7842207629312L, 58429);
        GMTrace.o(7842207629312L, 58429);
        return false;
      }
      
      public final void mR(String paramAnonymousString)
      {
        GMTrace.i(7842341847040L, 58430);
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this, bf.my(paramAnonymousString));
        paramAnonymousString = InviteFacebookFriendsUI.this;
        if (paramAnonymousString.irZ != null)
        {
          InviteFacebookFriendsUI.a locala = paramAnonymousString.irZ;
          locala.isl = bf.my(paramAnonymousString.isc.trim());
          locala.aEP();
          locala.OL();
        }
        GMTrace.o(7842341847040L, 58430);
      }
    };
    a((p)localObject2);
    this.irZ = new a(this, new k.a()
    {
      public final void OI()
      {
        GMTrace.i(7847844773888L, 58471);
        if (m.ym())
        {
          if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).getCount() == 0)
          {
            localObject1.setVisibility(0);
            GMTrace.o(7847844773888L, 58471);
            return;
          }
          localObject1.setVisibility(8);
        }
        GMTrace.o(7847844773888L, 58471);
      }
      
      public final void OJ()
      {
        GMTrace.i(7847978991616L, 58472);
        GMTrace.o(7847978991616L, 58472);
      }
    });
    this.irY.setAdapter(this.irZ);
    this.isa = findViewById(R.h.ckq);
    this.irY.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(7845428854784L, 58453);
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).OK().length >= 50)
        {
          com.tencent.mm.ui.base.g.h(InviteFacebookFriendsUI.this, R.l.ehc, R.l.dIG);
          GMTrace.o(7845428854784L, 58453);
          return;
        }
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).hj(paramAnonymousInt - InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this).getHeaderViewsCount());
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).OK().length > 0)
        {
          InviteFacebookFriendsUI.this.kp(true);
          GMTrace.o(7845428854784L, 58453);
          return;
        }
        InviteFacebookFriendsUI.this.kp(false);
        GMTrace.o(7845428854784L, 58453);
      }
    });
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + m.ym());
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
        new com.tencent.mm.ui.account.h((com.tencent.mm.ui.g.a.c)localObject2, new com.tencent.mm.v.a()
        {
          public final void m(Bundle paramAnonymousBundle)
          {
            GMTrace.i(7841804976128L, 58426);
            super.m(paramAnonymousBundle);
            GMTrace.o(7841804976128L, 58426);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            GMTrace.i(7841939193856L, 58427);
            super.onError(paramAnonymousInt, paramAnonymousString);
            if (paramAnonymousInt == 3) {
              InviteFacebookFriendsUI.c(InviteFacebookFriendsUI.this);
            }
            GMTrace.o(7841939193856L, 58427);
          }
        }).bQI();
      }
      localObject1 = new com.tencent.mm.modelfriend.v();
      ((com.tencent.mm.modelfriend.v)localObject1).FI();
      localObject2 = new ai(new ai.a()
      {
        public final boolean oQ()
        {
          GMTrace.i(7841536540672L, 58424);
          ap.yY();
          com.tencent.mm.u.c.vr().set(65829, Integer.valueOf(1));
          ap.vd().a(localObject1, 0);
          GMTrace.o(7841536540672L, 58424);
          return false;
        }
      }, false);
      ap.yY();
      if (bf.f((Integer)com.tencent.mm.u.c.vr().get(65829, null)) <= 0) {
        break label453;
      }
      ap.yY();
      com.tencent.mm.u.c.vr().set(65829, Integer.valueOf(1));
      ap.vd().a((com.tencent.mm.y.k)localObject1, 0);
    }
    for (;;)
    {
      ActionBarActivity localActionBarActivity = this.uRf.uRz;
      getString(R.l.dIG);
      this.isb = com.tencent.mm.ui.base.g.a(localActionBarActivity, getString(R.l.eGZ), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(7844489330688L, 58446);
          localObject2.KI();
          ap.vd().c(localObject1);
          GMTrace.o(7844489330688L, 58446);
        }
      });
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(7846905249792L, 58464);
          InviteFacebookFriendsUI.this.aGY();
          InviteFacebookFriendsUI.this.finish();
          GMTrace.o(7846905249792L, 58464);
          return true;
        }
      });
      new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(7844757766144L, 58448);
          BackwardSupportUtil.c.a(InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this));
          GMTrace.o(7844757766144L, 58448);
        }
      };
      a(0, getString(R.l.eha), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(7849052733440L, 58480);
          com.tencent.mm.ui.g.a.c localc = new com.tencent.mm.ui.g.a.c("290293790992170");
          Bundle localBundle = new Bundle();
          localBundle.putString("message", InviteFacebookFriendsUI.this.getString(R.l.egZ));
          final long[] arrayOfLong = InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).OK();
          paramAnonymousMenuItem = Long.toString(arrayOfLong[0]);
          int i = 1;
          while (i < arrayOfLong.length)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem + ",";
            paramAnonymousMenuItem = paramAnonymousMenuItem + Long.toString(arrayOfLong[i]);
            i += 1;
          }
          localBundle.putString("to", paramAnonymousMenuItem);
          localc.a(InviteFacebookFriendsUI.this, "apprequests", localBundle, new c.a()
          {
            public final void a(com.tencent.mm.ui.g.a.b paramAnonymous2b)
            {
              GMTrace.i(7840999669760L, 58420);
              com.tencent.mm.sdk.platformtools.v.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              GMTrace.o(7840999669760L, 58420);
            }
            
            public final void a(com.tencent.mm.ui.g.a.d paramAnonymous2d)
            {
              GMTrace.i(7840865452032L, 58419);
              com.tencent.mm.sdk.platformtools.v.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              GMTrace.o(7840865452032L, 58419);
            }
            
            public final void m(Bundle paramAnonymous2Bundle)
            {
              GMTrace.i(7841133887488L, 58421);
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
              paramAnonymous2Bundle = new ArrayList();
              paramAnonymous2Bundle.add(new i.a(33, Integer.toString(arrayOfLong.length)));
              ap.yY();
              com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.i(paramAnonymous2Bundle));
              paramAnonymous2Bundle = arrayOfLong;
              int j = paramAnonymous2Bundle.length;
              int i = 0;
              while (i < j)
              {
                long l = paramAnonymous2Bundle[i];
                q localq = new q();
                localq.username = Long.toString(l);
                localq.hBf = 5;
                localq.huN = ((int)bf.Nz());
                af.Gd().a(localq);
                i += 1;
              }
              com.tencent.mm.ui.base.g.a(InviteFacebookFriendsUI.this, R.l.ehb, R.l.dIG, R.l.dIW, R.l.dHI, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  GMTrace.i(7843684024320L, 58440);
                  InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).OL();
                  GMTrace.o(7843684024320L, 58440);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  GMTrace.i(7837107355648L, 58391);
                  InviteFacebookFriendsUI.this.finish();
                  GMTrace.o(7837107355648L, 58391);
                }
              });
              GMTrace.o(7841133887488L, 58421);
            }
            
            public final void onCancel()
            {
              GMTrace.i(7841268105216L, 58422);
              com.tencent.mm.sdk.platformtools.v.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
              GMTrace.o(7841268105216L, 58422);
            }
          });
          GMTrace.o(7849052733440L, 58480);
          return true;
        }
      });
      kp(false);
      GMTrace.o(7838986403840L, 58405);
      return;
      label453:
      ((ai)localObject2).v(5000L, 5000L);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(7839389057024L, 58408);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramk.getType() != 32)
    {
      GMTrace.o(7839389057024L, 58408);
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
      GMTrace.o(7839389057024L, 58408);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.irZ.a(null, null);
      GMTrace.o(7839389057024L, 58408);
      return;
    }
    Toast.makeText(this, R.l.eAS, 0).show();
    GMTrace.o(7839389057024L, 58408);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(7839254839296L, 58407);
    int i = R.i.dcH;
    GMTrace.o(7839254839296L, 58407);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(7838717968384L, 58403);
    super.onCreate(paramBundle);
    zd(R.l.ehd);
    ap.vd().a(32, this);
    KD();
    GMTrace.o(7838717968384L, 58403);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(7838852186112L, 58404);
    ap.vd().b(32, this);
    this.irZ.aEP();
    super.onDestroy();
    GMTrace.o(7838852186112L, 58404);
  }
  
  public static final class a
    extends com.tencent.mm.ui.k<com.tencent.mm.modelfriend.h>
  {
    private int[] hAK;
    String isl;
    private boolean[] ism;
    
    public a(Context paramContext, k.a parama)
    {
      super(new com.tencent.mm.modelfriend.h());
      GMTrace.i(7845563072512L, 58454);
      this.uQY = parama;
      GMTrace.o(7845563072512L, 58454);
    }
    
    public final long[] OK()
    {
      int m = 0;
      GMTrace.i(7845831507968L, 58456);
      Object localObject = this.ism;
      int n = localObject.length;
      int i = 0;
      int k;
      for (int j = 0; i < n; j = k)
      {
        k = j;
        if (localObject[i] != 0) {
          k = j + 1;
        }
        i += 1;
      }
      localObject = new long[j];
      j = 0;
      i = m;
      if (j < getCount())
      {
        if (this.ism[j] == 0) {
          break label118;
        }
        localObject[i] = ((com.tencent.mm.modelfriend.h)getItem(j)).gkj;
        i += 1;
      }
      label118:
      for (;;)
      {
        j += 1;
        break;
        GMTrace.o(7845831507968L, 58456);
        return (long[])localObject;
      }
    }
    
    public final void OL()
    {
      GMTrace.i(7846099943424L, 58458);
      com.tencent.mm.modelfriend.i locali = af.Ga();
      String str = this.isl;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" where facebookfriend.status = 102 ");
      if ((str != null) && (str.length() > 0))
      {
        localStringBuilder.append(" and ( ");
        localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
      }
      setCursor(locali.hnp.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
      this.hAK = new int[getCount()];
      this.ism = new boolean[getCount()];
      super.notifyDataSetChanged();
      GMTrace.o(7846099943424L, 58458);
    }
    
    protected final void OM()
    {
      GMTrace.i(7846234161152L, 58459);
      OL();
      GMTrace.o(7846234161152L, 58459);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(7845697290240L, 58455);
      com.tencent.mm.modelfriend.h localh = (com.tencent.mm.modelfriend.h)getItem(paramInt);
      Bitmap localBitmap;
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, R.i.dbU, null);
        paramViewGroup.ioB = ((ImageView)paramView.findViewById(R.h.bGc));
        paramViewGroup.hAR = ((TextView)paramView.findViewById(R.h.ctA));
        paramViewGroup.isn = ((TextView)paramView.findViewById(R.h.bYb));
        paramViewGroup.iso = ((CheckBox)paramView.findViewById(R.h.bYm));
        paramView.setTag(paramViewGroup);
        paramViewGroup.hAR.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, localh.Fe(), paramViewGroup.hAR.getTextSize()));
        localBitmap = com.tencent.mm.x.b.gZ(localh.gkj);
        if (localBitmap != null) {
          break label233;
        }
        paramViewGroup.ioB.setImageDrawable(com.tencent.mm.bg.a.a(this.context, R.k.ber));
        label174:
        paramViewGroup.iso.setChecked(this.ism[paramInt]);
        if (!af.Gd().jk(Long.toString(localh.gkj))) {
          break label245;
        }
        paramViewGroup.isn.setVisibility(0);
      }
      for (;;)
      {
        GMTrace.o(7845697290240L, 58455);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label233:
        paramViewGroup.ioB.setImageBitmap(localBitmap);
        break label174;
        label245:
        paramViewGroup.isn.setVisibility(8);
      }
    }
    
    public final void hj(int paramInt)
    {
      GMTrace.i(7845965725696L, 58457);
      if ((paramInt < 0) || (paramInt >= this.ism.length))
      {
        GMTrace.o(7845965725696L, 58457);
        return;
      }
      boolean[] arrayOfBoolean = this.ism;
      if (this.ism[paramInt] == 0) {}
      for (int i = 1;; i = 0)
      {
        arrayOfBoolean[paramInt] = i;
        super.notifyDataSetChanged();
        GMTrace.o(7845965725696L, 58457);
        return;
      }
    }
    
    public static final class a
    {
      TextView hAR;
      ImageView ioB;
      TextView isn;
      CheckBox iso;
      
      public a()
      {
        GMTrace.i(7845160419328L, 58451);
        GMTrace.o(7845160419328L, 58451);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/accountsync/ui/InviteFacebookFriendsUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */