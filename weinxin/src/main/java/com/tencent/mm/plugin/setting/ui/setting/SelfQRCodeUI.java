package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileObserver;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.aa;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bg;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.y.k;
import java.io.File;

public class SelfQRCodeUI
  extends MMActivity
  implements com.tencent.mm.y.e
{
  private static final String phz;
  private Bitmap hqF;
  private ProgressDialog isb;
  private ImageView jaK;
  private long kAc;
  private ImageView pgQ;
  private byte[] pgR;
  private TextView phv;
  private TextView phw;
  private boolean phx;
  private a phy;
  private String userName;
  
  static
  {
    GMTrace.i(4696278302720L, 34990);
    phz = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/";
    GMTrace.o(4696278302720L, 34990);
  }
  
  public SelfQRCodeUI()
  {
    GMTrace.i(4694130819072L, 34974);
    this.isb = null;
    this.pgQ = null;
    this.jaK = null;
    this.phv = null;
    this.phw = null;
    this.userName = "";
    this.phx = false;
    this.pgR = null;
    this.hqF = null;
    GMTrace.o(4694130819072L, 34974);
  }
  
  public static void aZJ()
  {
    GMTrace.i(4695607214080L, 34985);
    com.tencent.mm.plugin.report.service.g.oSF.a(219L, 14L, 1L, true);
    GMTrace.o(4695607214080L, 34985);
  }
  
  private void sl(int paramInt)
  {
    GMTrace.i(16881905827840L, 125780);
    if (this.phx) {
      ap.yY();
    }
    for (int i = bf.f((Integer)c.vr().get(66561, null));; i = 0)
    {
      final com.tencent.mm.aq.a locala = new com.tencent.mm.aq.a(this.userName, i, paramInt);
      ap.vd().a(locala, 0);
      ActionBarActivity localActionBarActivity = this.uRf.uRz;
      getString(R.l.dIG);
      this.isb = com.tencent.mm.ui.base.g.a(localActionBarActivity, getString(R.l.eQA), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(4710236946432L, 35094);
          ap.vd().c(locala);
          if ((o.dH(SelfQRCodeUI.c(SelfQRCodeUI.this))) || (com.tencent.mm.modelbiz.e.ib(SelfQRCodeUI.c(SelfQRCodeUI.this)))) {
            SelfQRCodeUI.this.finish();
          }
          GMTrace.o(4710236946432L, 35094);
        }
      });
      GMTrace.o(16881905827840L, 125780);
      return;
    }
  }
  
  protected final void KD()
  {
    GMTrace.i(4694801907712L, 34979);
    this.userName = getIntent().getStringExtra("from_userName");
    if (bf.mA(this.userName)) {
      this.userName = m.xL();
    }
    if (m.xL().equals(this.userName)) {
      this.phx = true;
    }
    Object localObject1;
    Object localObject2;
    if (o.dH(this.userName))
    {
      zd(R.l.eTM);
      ((TextView)findViewById(R.h.cur)).setText("");
      ko(false);
      this.pgQ = ((ImageView)findViewById(R.h.cCf));
      this.jaK = ((ImageView)findViewById(R.h.bVT));
      this.phv = ((TextView)findViewById(R.h.cnT));
      this.phw = ((TextView)findViewById(R.h.bJw));
      if ((!o.dH(this.userName)) && (!com.tencent.mm.modelbiz.e.ib(this.userName))) {
        break label398;
      }
      sl(1);
      a.b.a(this.jaK, this.userName);
      ap.yY();
      localObject1 = c.wR().Rb(this.userName);
      this.phv.setSingleLine(false);
      this.phv.setMaxLines(3);
      this.phv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if (localObject1 == null) {
        break label386;
      }
      localObject2 = ((af)localObject1).field_nickname;
      localObject1 = localObject2;
      if (bf.mA((String)localObject2))
      {
        ap.yY();
        localObject1 = c.xa().fW(this.userName).field_displayname;
      }
      this.phv.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, (CharSequence)localObject1, this.phv.getTextSize()));
      label288:
      this.phw.setVisibility(8);
    }
    for (;;)
    {
      a(0, R.g.bha, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(4708357898240L, 35080);
          SelfQRCodeUI.b(SelfQRCodeUI.this);
          GMTrace.o(4708357898240L, 35080);
          return true;
        }
      });
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(4669971628032L, 34794);
          SelfQRCodeUI.this.aGY();
          SelfQRCodeUI.this.finish();
          GMTrace.o(4669971628032L, 34794);
          return true;
        }
      });
      GMTrace.o(4694801907712L, 34979);
      return;
      if (com.tencent.mm.modelbiz.e.ib(this.userName))
      {
        zd(R.l.eeI);
        ((TextView)findViewById(R.h.cur)).setText(R.l.eeJ);
        ko(false);
        break;
      }
      zd(R.l.eTF);
      break;
      label386:
      this.phv.setVisibility(8);
      break label288;
      label398:
      ap.yY();
      localObject2 = (String)c.vr().get(42, null);
      localObject1 = getString(R.l.dHa);
      if (!bf.mA((String)localObject2))
      {
        localObject1 = (String)localObject1 + (String)localObject2;
        label449:
        v.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[] { localObject1 });
        if (this.hqF != null) {
          break label746;
        }
        v.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[] { "bitmap == null" });
        sl(1);
      }
      for (;;)
      {
        a.b.a(this.jaK, m.xL());
        ap.yY();
        localObject1 = (String)c.vr().get(4, null);
        v.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[] { localObject1 });
        this.phv.setText(com.tencent.mm.pluginsdk.ui.d.h.c(this, (CharSequence)localObject1, com.tencent.mm.bg.a.T(this.uRf.uRz, R.f.aXr)));
        localObject2 = bg.zL();
        localObject1 = bf.mz(((bg)localObject2).getProvince());
        localObject2 = bf.mz(((bg)localObject2).getCity());
        localObject1 = com.tencent.mm.u.n.eM((String)localObject1) + " " + (String)localObject2;
        v.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[] { localObject1 });
        this.phw.setText((CharSequence)localObject1);
        ap.yY();
        switch (bf.a((Integer)c.vr().get(12290, null), 0))
        {
        default: 
          break;
        case 1: 
          this.phv.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bg.a.a(this, R.k.dxi), null);
          break;
          ap.yY();
          localObject2 = (String)c.vr().get(2, null);
          localObject1 = (String)localObject1 + (String)localObject2;
          x.QP((String)localObject2);
          break label449;
          label746:
          this.pgQ.setImageBitmap(this.hqF);
        }
      }
      this.phv.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bg.a.a(this, R.k.dxh), null);
    }
  }
  
  protected final int Om()
  {
    GMTrace.i(16881771610112L, 125779);
    GMTrace.o(16881771610112L, 125779);
    return 1;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(4695472996352L, 34984);
    v.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    Object localObject = (com.tencent.mm.aq.a)paramk;
    if (paramk.getType() == 168)
    {
      if (com.tencent.mm.plugin.setting.a.imc.b(this.uRf.uRz, paramInt1, paramInt2, paramString))
      {
        GMTrace.o(4695472996352L, 34984);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Toast.makeText(this, getString(R.l.elK, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        GMTrace.o(4695472996352L, 34984);
        return;
      }
      this.pgR = ((com.tencent.mm.aq.a)localObject).hOl;
      this.hqF = com.tencent.mm.sdk.platformtools.d.bd(this.pgR);
      if ((!o.dH(this.userName)) && (!com.tencent.mm.modelbiz.e.ib(this.userName))) {
        break label264;
      }
      ko(true);
      paramString = ((com.tencent.mm.aq.a)localObject).hOj;
      if (!bf.mA(paramString)) {
        ((TextView)findViewById(R.h.cur)).setText(paramString);
      }
    }
    for (;;)
    {
      this.pgQ.setImageBitmap(this.hqF);
      GMTrace.o(4695472996352L, 34984);
      return;
      label264:
      if (this.phx)
      {
        paramString = ((com.tencent.mm.aq.a)localObject).hOk;
        paramk = (TextView)findViewById(R.h.cIH);
        localObject = (View)paramk.getParent();
        if (!bf.mA(paramString))
        {
          paramk.setText(paramString);
          ((View)localObject).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              GMTrace.i(16884187529216L, 125797);
              SelfQRCodeUI.f(SelfQRCodeUI.this);
              GMTrace.o(16884187529216L, 125797);
            }
          });
          ((View)localObject).setVisibility(0);
        }
        else
        {
          ((View)localObject).setVisibility(8);
        }
      }
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(4694265036800L, 34975);
    int i = R.i.dnE;
    GMTrace.o(4694265036800L, 34975);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(4694399254528L, 34976);
    super.onCreate(paramBundle);
    this.phy = new a(this);
    this.phy.start();
    ap.vd().a(168, this);
    KD();
    this.pgQ.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(16884321746944L, 125798);
        int i = SelfQRCodeUI.a(SelfQRCodeUI.this).getWidth();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)SelfQRCodeUI.a(SelfQRCodeUI.this).getLayoutParams();
        localLayoutParams.width = i;
        localLayoutParams.height = i;
        SelfQRCodeUI.a(SelfQRCodeUI.this).setLayoutParams(localLayoutParams);
        GMTrace.o(16884321746944L, 125798);
      }
    });
    GMTrace.o(4694399254528L, 34976);
  }
  
  public void onDestroy()
  {
    GMTrace.i(4694533472256L, 34977);
    ap.vd().b(168, this);
    if (this.phy != null) {
      this.phy.stop();
    }
    if ((this.hqF != null) && (!this.hqF.isRecycled())) {
      this.hqF.recycle();
    }
    super.onDestroy();
    GMTrace.o(4694533472256L, 34977);
  }
  
  protected void onResume()
  {
    GMTrace.i(4694667689984L, 34978);
    super.onResume();
    if ((o.dH(this.userName)) || (com.tencent.mm.modelbiz.e.ib(this.userName)))
    {
      GMTrace.o(4694667689984L, 34978);
      return;
    }
    View localView = findViewById(R.h.cCi);
    this.kAc = m.xQ();
    v.d("MicroMsg.SelfQRCodeNewUI", (this.kAc & 0x2) + ",extstatus:" + this.kAc);
    if ((this.kAc & 0x2) != 0L)
    {
      localView.setVisibility(0);
      this.pgQ.setAlpha(0.1F);
      findViewById(R.h.cCh).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(4669703192576L, 34792);
          com.tencent.mm.bb.d.w(SelfQRCodeUI.this, "setting", ".ui.setting.SettingsAddMeUI");
          GMTrace.o(4669703192576L, 34792);
        }
      });
      GMTrace.o(4694667689984L, 34978);
      return;
    }
    localView.setVisibility(8);
    this.pgQ.setAlpha(1.0F);
    GMTrace.o(4694667689984L, 34978);
  }
  
  public final class a
    extends FileObserver
  {
    private MMActivity phB;
    private String phC;
    
    public a(MMActivity paramMMActivity)
    {
      super(8);
      GMTrace.i(4619103109120L, 34415);
      this.phB = paramMMActivity;
      GMTrace.o(4619103109120L, 34415);
    }
    
    public final void onEvent(int paramInt, String paramString)
    {
      GMTrace.i(4619237326848L, 34416);
      if ((paramString != null) && (paramInt == 8) && ((this.phC == null) || (!paramString.equalsIgnoreCase(this.phC))))
      {
        this.phC = paramString;
        Uri.fromFile(new File(SelfQRCodeUI.aZK() + paramString));
        SelfQRCodeUI.aZJ();
        v.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
      }
      GMTrace.o(4619237326848L, 34416);
    }
    
    public final void start()
    {
      GMTrace.i(4619371544576L, 34417);
      super.startWatching();
      GMTrace.o(4619371544576L, 34417);
    }
    
    public final void stop()
    {
      GMTrace.i(4619505762304L, 34418);
      super.stopWatching();
      GMTrace.o(4619505762304L, 34418);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */