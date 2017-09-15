package com.tencent.mm.ui.friend;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.lh;
import com.tencent.mm.e.a.lh.b;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.p;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.x.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class InviteFriendUI
  extends MMActivity
  implements d.a
{
  private ImageView hAQ;
  private String weP;
  private int weQ;
  private String weR;
  private String weS;
  private String weT;
  private Button weU;
  private int weV;
  private int weW;
  private String weX;
  private String weY;
  
  public InviteFriendUI()
  {
    GMTrace.i(2817095892992L, 20989);
    this.weX = null;
    this.weY = null;
    GMTrace.o(2817095892992L, 20989);
  }
  
  protected final void KD()
  {
    GMTrace.i(2817901199360L, 20995);
    this.hAQ = ((ImageView)findViewById(R.h.bXS));
    TextView localTextView1 = (TextView)findViewById(R.h.bXW);
    TextView localTextView3 = (TextView)findViewById(R.h.bXY);
    TextView localTextView2 = (TextView)findViewById(R.h.bXX);
    this.weU = ((Button)findViewById(R.h.bXV));
    Button localButton = (Button)findViewById(R.h.bXZ);
    localTextView1.setText(this.weR);
    localTextView2.setText(getString(R.l.bXX, new Object[] { this.weR }));
    Object localObject;
    if (this.weQ == 1)
    {
      this.hAQ.setBackgroundDrawable(com.tencent.mm.bg.a.a(this, R.k.dwj));
      localTextView3.setText(getString(R.l.dGT) + this.weP);
      localObject = com.tencent.mm.a.g.n(this.weP.getBytes());
      ap.yY();
      if (!com.tencent.mm.u.c.isSDCardAvailable())
      {
        localObject = com.tencent.mm.x.n.Bl().aS(aa.getContext());
        if (localObject == null) {
          break label592;
        }
        this.hAQ.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      label214:
      if (this.weQ == 0)
      {
        this.hAQ.setBackgroundDrawable(com.tencent.mm.bg.a.a(this, R.k.dwk));
        localTextView3.setText(getString(R.l.dGV) + this.weP);
        long l = o.aY(this.weP);
        localObject = null;
        if (l != 0L) {
          localObject = com.tencent.mm.x.b.Q(l);
        }
        if (localObject != null) {
          break label609;
        }
        this.hAQ.setImageDrawable(com.tencent.mm.bg.a.a(this, R.k.dwk));
        label307:
        localButton.setVisibility(0);
      }
      if (this.weQ == 2)
      {
        this.weU.setText(R.l.epN);
        this.hAQ.setBackgroundDrawable(com.tencent.mm.bg.a.a(this, R.g.bes));
        localTextView3.setText(getString(R.l.dGO) + this.weP);
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
          break label620;
        }
        localObject = com.tencent.mm.x.n.Bl().aS(aa.getContext());
        label397:
        if (localObject == null) {
          break label631;
        }
        this.hAQ.setImageBitmap((Bitmap)localObject);
        label409:
        if (TextUtils.isEmpty(this.weR))
        {
          localTextView1.setText(bf.Qh(this.weP));
          localTextView2.setText(getString(R.l.bXX, new Object[] { bf.Qh(this.weP) }));
        }
      }
      if (this.weQ == 3)
      {
        this.weU.setText(R.l.esE);
        localObject = j.a(new com.tencent.mm.pluginsdk.ui.tools.d(this.weY, this.weY));
        if (localObject == null) {
          break label648;
        }
        this.hAQ.setImageBitmap((Bitmap)localObject);
      }
    }
    for (;;)
    {
      localButton.setVisibility(8);
      this.weU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          GMTrace.i(2809713917952L, 20934);
          switch (InviteFriendUI.a(InviteFriendUI.this))
          {
          }
          label695:
          for (;;)
          {
            GMTrace.o(2809713917952L, 20934);
            return;
            ap.yY();
            final Object localObject1 = (String)com.tencent.mm.u.c.vr().get(42, "");
            if (localObject1 != null)
            {
              paramAnonymousView = (View)localObject1;
              if (((String)localObject1).length() != 0) {}
            }
            else
            {
              ap.yY();
              paramAnonymousView = (String)com.tencent.mm.u.c.vr().get(2, "");
            }
            paramAnonymousView = InviteFriendUI.this.getString(R.l.esR, new Object[] { paramAnonymousView });
            localObject1 = Uri.parse("smsto:" + InviteFriendUI.b(InviteFriendUI.this));
            final Object localObject2 = new Intent("android.intent.action.SENDTO", (Uri)localObject1);
            ((Intent)localObject2).putExtra("sms_body", paramAnonymousView);
            final Object localObject3 = InviteFriendUI.this.getPackageManager();
            Object localObject4 = ((PackageManager)localObject3).queryIntentActivities((Intent)localObject2, 65536);
            localObject2 = new HashMap();
            localObject4 = ((List)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject4).next();
              if (!localResolveInfo.activityInfo.packageName.equals("com.whatsapp")) {
                ((HashMap)localObject2).put(localResolveInfo.activityInfo.name, localResolveInfo);
              }
            }
            if (((HashMap)localObject2).size() == 1)
            {
              localObject3 = ((HashMap)localObject2).keySet().iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localObject3 = (String)((Iterator)localObject3).next();
                localObject4 = new Intent();
                ((Intent)localObject4).setComponent(new ComponentName(((ResolveInfo)((HashMap)localObject2).get(localObject3)).activityInfo.packageName, ((ResolveInfo)((HashMap)localObject2).get(localObject3)).activityInfo.name));
                ((Intent)localObject4).setAction("android.intent.action.SENDTO");
                ((Intent)localObject4).setData((Uri)localObject1);
                ((Intent)localObject4).putExtra("sms_body", paramAnonymousView);
                InviteFriendUI.this.startActivity((Intent)localObject4);
                InviteFriendUI.c(InviteFriendUI.this);
              }
              GMTrace.o(2809713917952L, 20934);
              return;
            }
            if (((HashMap)localObject2).size() > 1)
            {
              localObject4 = new com.tencent.mm.ui.tools.l(InviteFriendUI.this);
              ((com.tencent.mm.ui.tools.l)localObject4).wkZ = new n.a()
              {
                public final void a(ImageView paramAnonymous2ImageView, MenuItem paramAnonymous2MenuItem)
                {
                  GMTrace.i(2791997177856L, 20802);
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2ImageView.setImageDrawable(((ResolveInfo)localObject2.get(paramAnonymous2MenuItem)).loadIcon(localObject3));
                  GMTrace.o(2791997177856L, 20802);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).wla = new n.b()
              {
                public final void a(TextView paramAnonymous2TextView, MenuItem paramAnonymous2MenuItem)
                {
                  GMTrace.i(2823001473024L, 21033);
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2TextView.setText(((ResolveInfo)localObject2.get(paramAnonymous2MenuItem)).loadLabel(localObject3).toString());
                  GMTrace.o(2823001473024L, 21033);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).qHD = new n.c()
              {
                public final void a(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  GMTrace.i(2811056095232L, 20944);
                  Iterator localIterator = localObject2.keySet().iterator();
                  while (localIterator.hasNext()) {
                    paramAnonymous2l.add((String)localIterator.next());
                  }
                  GMTrace.o(2811056095232L, 20944);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).qHE = new n.d()
              {
                public final void c(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  GMTrace.i(2819377594368L, 21006);
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                  Intent localIntent = new Intent();
                  localIntent.setComponent(new ComponentName(((ResolveInfo)localObject2.get(paramAnonymous2MenuItem)).activityInfo.packageName, ((ResolveInfo)localObject2.get(paramAnonymous2MenuItem)).activityInfo.name));
                  localIntent.setAction("android.intent.action.SENDTO");
                  localIntent.setData(localObject1);
                  localIntent.putExtra("sms_body", paramAnonymousView);
                  InviteFriendUI.this.startActivity(localIntent);
                  GMTrace.o(2819377594368L, 21006);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).bkT();
              InviteFriendUI.c(InviteFriendUI.this);
              GMTrace.o(2809713917952L, 20934);
              return;
            }
            Toast.makeText(InviteFriendUI.this, R.l.eQw, 1).show();
            GMTrace.o(2809713917952L, 20934);
            return;
            int i = o.aY(InviteFriendUI.b(InviteFriendUI.this));
            new g(InviteFriendUI.this, new g.a()
            {
              public final void k(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                GMTrace.i(2816424804352L, 20984);
                if (paramAnonymous2Boolean) {
                  InviteFriendUI.this.finish();
                }
                GMTrace.o(2816424804352L, 20984);
              }
            }).r(new int[] { i });
            GMTrace.o(2809713917952L, 20934);
            return;
            paramAnonymousView = new h(InviteFriendUI.this, new h.a()
            {
              public final void lz(boolean paramAnonymous2Boolean)
              {
                GMTrace.i(2816961675264L, 20988);
                if (paramAnonymous2Boolean) {
                  af.Gh().x(InviteFriendUI.d(InviteFriendUI.this), 1);
                }
                GMTrace.o(2816961675264L, 20988);
              }
            });
            localObject2 = InviteFriendUI.e(InviteFriendUI.this);
            localObject1 = InviteFriendUI.b(InviteFriendUI.this);
            ap.vd().a(489, paramAnonymousView);
            localObject2 = af.Gh().jj((String)localObject2);
            if ((localObject2 == null) || (((Cursor)localObject2).getCount() <= 1)) {
              paramAnonymousView.Ud((String)localObject1);
            }
            for (;;)
            {
              if (localObject2 == null) {
                break label695;
              }
              ((Cursor)localObject2).close();
              break;
              paramAnonymousView.j((Cursor)localObject2);
            }
          }
        }
      });
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2809982353408L, 20936);
          paramAnonymousView = new lh();
          paramAnonymousView.fRR.opType = 0;
          paramAnonymousView.fRR.fRT = (InviteFriendUI.b(InviteFriendUI.this) + "@qqim");
          paramAnonymousView.fRR.fRU = InviteFriendUI.f(InviteFriendUI.this);
          com.tencent.mm.sdk.b.a.uql.m(paramAnonymousView);
          if (paramAnonymousView.fRS.fFa) {
            com.tencent.mm.plugin.c.a.imb.e(new Intent().putExtra("Chat_User", InviteFriendUI.b(InviteFriendUI.this) + "@qqim"), InviteFriendUI.this);
          }
          InviteFriendUI.this.finish();
          GMTrace.o(2809982353408L, 20936);
        }
      });
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2787970646016L, 20772);
          InviteFriendUI.this.finish();
          GMTrace.o(2787970646016L, 20772);
          return true;
        }
      });
      GMTrace.o(2817901199360L, 20995);
      return;
      localObject = af.FZ().jb((String)localObject);
      if (localObject != null)
      {
        localObject = m.a(((com.tencent.mm.modelfriend.b)localObject).ER(), this);
        break;
      }
      localObject = null;
      break;
      label592:
      this.hAQ.setImageDrawable(com.tencent.mm.bg.a.a(this, R.k.dwj));
      break label214;
      label609:
      this.hAQ.setImageBitmap((Bitmap)localObject);
      break label307;
      label620:
      localObject = com.tencent.mm.x.b.gW(this.weS);
      break label397;
      label631:
      this.hAQ.setImageDrawable(com.tencent.mm.bg.a.a(this, R.g.bes));
      break label409;
      label648:
      this.hAQ.setImageResource(R.k.ber);
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2817632763904L, 20993);
    int i = R.i.dfD;
    GMTrace.o(2817632763904L, 20993);
    return i;
  }
  
  public final void ho(String paramString)
  {
    GMTrace.i(2818035417088L, 20996);
    if ((this.weP == null) || (this.weP.equals("")))
    {
      GMTrace.o(2818035417088L, 20996);
      return;
    }
    long l = com.tencent.mm.x.b.hb(paramString);
    if ((l > 0L) && (this.weP.equals(String.valueOf(l))) && (this.weQ == 0)) {
      this.hAQ.setImageBitmap(com.tencent.mm.x.b.a(paramString, false, -1));
    }
    GMTrace.o(2818035417088L, 20996);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2817230110720L, 20990);
    super.onCreate(paramBundle);
    zd(R.l.esF);
    paramBundle = getIntent();
    this.weQ = paramBundle.getIntExtra("friend_type", -1);
    this.weR = paramBundle.getStringExtra("friend_nick");
    this.weP = paramBundle.getStringExtra("friend_num");
    this.weS = paramBundle.getStringExtra("friend_googleID");
    this.weT = paramBundle.getStringExtra("friend_googleItemID");
    this.weP = bf.mz(this.weP);
    this.weX = paramBundle.getStringExtra("friend_linkedInID");
    this.weY = paramBundle.getStringExtra("friend_linkedInPicUrl");
    KD();
    this.weV = paramBundle.getIntExtra("search_kvstat_scene", 0);
    this.weW = paramBundle.getIntExtra("search_kvstat_position", 0);
    GMTrace.o(2817230110720L, 20990);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2817766981632L, 20994);
    super.onDestroy();
    GMTrace.o(2817766981632L, 20994);
  }
  
  protected void onPause()
  {
    GMTrace.i(2817364328448L, 20991);
    super.onPause();
    com.tencent.mm.x.n.Bl().e(this);
    GMTrace.o(2817364328448L, 20991);
  }
  
  protected void onResume()
  {
    GMTrace.i(2817498546176L, 20992);
    super.onResume();
    com.tencent.mm.x.n.Bl().d(this);
    GMTrace.o(2817498546176L, 20992);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/friend/InviteFriendUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */