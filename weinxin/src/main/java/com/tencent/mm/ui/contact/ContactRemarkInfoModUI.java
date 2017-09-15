package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.protocal.c.aqi;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.l.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI
  extends MMActivity
  implements com.tencent.mm.y.e
{
  private String aIP;
  private String gkA;
  private String hOI;
  private x jht;
  private ProgressDialog kng;
  private String mYF;
  private int orm;
  private MMTagPanel ouO;
  private List<String> ouP;
  private m.b ouQ;
  private String sRf;
  private String username;
  private MMClearEditText vUM;
  private TextView vUN;
  private MMEditText vUO;
  private TextView vUP;
  private TextView vUQ;
  private TextView vUR;
  private TextView vUS;
  private ImageView vUT;
  private ImageView vUU;
  private TextView vUV;
  private View vUW;
  private View vUX;
  private View vUY;
  private String vUZ;
  private boolean vVa;
  private boolean vVb;
  private boolean vVc;
  private boolean vVd;
  private boolean vVe;
  private a vVf;
  private TextView vVg;
  private ScrollView vVh;
  private ProfileEditPhoneNumberView vVi;
  private String vVj;
  private String vVk;
  private String vVl;
  boolean vVm;
  boolean vVn;
  private boolean vVo;
  
  public ContactRemarkInfoModUI()
  {
    GMTrace.i(1720671272960L, 12820);
    this.vVa = false;
    this.vVb = false;
    this.vVc = false;
    this.vVd = false;
    this.vVe = false;
    this.vVf = new a();
    this.ouQ = new m.b()
    {
      public final void a(int paramAnonymousInt, m paramAnonymousm, Object paramAnonymousObject)
      {
        GMTrace.i(17926522404864L, 133563);
        v.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
        ContactRemarkInfoModUI.d(ContactRemarkInfoModUI.this);
        GMTrace.o(17926522404864L, 133563);
      }
    };
    this.vVm = true;
    this.vVn = false;
    this.vVo = false;
    GMTrace.o(1720671272960L, 12820);
  }
  
  private void TN(String paramString)
  {
    GMTrace.i(1722147667968L, 12831);
    if (u.mA(paramString))
    {
      GMTrace.o(1722147667968L, 12831);
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      GMTrace.o(1722147667968L, 12831);
      return;
    }
    if (paramString.length() > 204800L)
    {
      g.b(this, getString(R.l.dXD), null, true);
      GMTrace.o(1722147667968L, 12831);
      return;
    }
    float f = com.tencent.mm.bg.a.getDensity(this);
    paramString = BackwardSupportUtil.b.c(this.vUZ, f);
    if (paramString != null)
    {
      this.vUR.setVisibility(8);
      this.vUU.setVisibility(8);
      this.vUT.setVisibility(0);
      this.vUT.setImageBitmap(paramString);
      this.vVa = true;
    }
    GMTrace.o(1722147667968L, 12831);
  }
  
  private String TO(String paramString)
  {
    GMTrace.i(1723892498432L, 12844);
    if (!com.tencent.mm.a.e.aO(paramString))
    {
      GMTrace.o(1723892498432L, 12844);
      return null;
    }
    int i = BackwardSupportUtil.ExifHelper.Pb(paramString);
    Object localObject = new StringBuilder();
    com.tencent.mm.ar.c.Ii();
    localObject = com.tencent.mm.ar.c.jV(this.username) + ".tmp";
    if (!com.tencent.mm.sdk.platformtools.d.a(paramString, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject))
    {
      v.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
      GMTrace.o(1723892498432L, 12844);
      return null;
    }
    if ((i != 0) && (!com.tencent.mm.sdk.platformtools.d.a((String)localObject, i, Bitmap.CompressFormat.JPEG, 70, (String)localObject)))
    {
      v.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
      GMTrace.o(1723892498432L, 12844);
      return null;
    }
    GMTrace.o(1723892498432L, 12844);
    return (String)localObject;
  }
  
  private void aTL()
  {
    GMTrace.i(1724026716160L, 12845);
    ap.yY();
    this.jht = com.tencent.mm.u.c.wR().Rb(this.username);
    this.mYF = this.jht.field_contactLabelIds;
    this.ouP = com.tencent.mm.plugin.label.a.a.aFz().ze(this.mYF);
    if (!u.mA(this.mYF))
    {
      this.ouO.setVisibility(0);
      this.vVg.setVisibility(8);
      this.ouO.a(this.ouP, this.ouP);
      GMTrace.o(1724026716160L, 12845);
      return;
    }
    this.ouO.setVisibility(8);
    this.vVg.setVisibility(0);
    GMTrace.o(1724026716160L, 12845);
  }
  
  private void ajo()
  {
    GMTrace.i(1720805490688L, 12821);
    ProfileEditPhoneNumberView localProfileEditPhoneNumberView = this.vVi;
    Object localObject = localProfileEditPhoneNumberView.bEk();
    boolean bool;
    if (((ArrayList)localObject).isEmpty())
    {
      if (localProfileEditPhoneNumberView.sIc == null) {
        break label169;
      }
      bool = true;
    }
    for (;;)
    {
      this.vVo = bool;
      if ((!bXI()) && (!bXJ()) && (!lu(false)) && (!this.vVo)) {
        break;
      }
      ko(true);
      GMTrace.o(1720805490688L, 12821);
      return;
      if (localProfileEditPhoneNumberView.sIc == null)
      {
        bool = true;
      }
      else if (((ArrayList)localObject).size() != localProfileEditPhoneNumberView.sIc.length)
      {
        bool = true;
      }
      else
      {
        localObject = ((ArrayList)localObject).iterator();
        int i = 0;
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label169;
          }
          if (!((String)((Iterator)localObject).next()).equals(localProfileEditPhoneNumberView.sIc[i]))
          {
            bool = true;
            break;
          }
          i += 1;
        }
        label169:
        bool = false;
      }
    }
    ko(false);
    GMTrace.o(1720805490688L, 12821);
  }
  
  private void bXF()
  {
    GMTrace.i(1721879232512L, 12829);
    this.vUN.setFocusableInTouchMode(true);
    this.vUN.requestFocus();
    this.vUM.clearFocus();
    this.vUO.clearFocus();
    this.vVi.clearFocus();
    aGY();
    GMTrace.o(1721879232512L, 12829);
  }
  
  private void bXG()
  {
    GMTrace.i(1722013450240L, 12830);
    Bitmap localBitmap = com.tencent.mm.ar.c.Ii().jY(this.username);
    if (localBitmap != null)
    {
      this.vUR.setVisibility(8);
      this.vUU.setVisibility(8);
      this.vUT.setVisibility(0);
      this.vUT.setImageBitmap(localBitmap);
    }
    this.vVa = true;
    GMTrace.o(1722013450240L, 12830);
  }
  
  private void bXH()
  {
    GMTrace.i(1722550321152L, 12834);
    if (!this.vVo)
    {
      GMTrace.o(1722550321152L, 12834);
      return;
    }
    Object localObject2 = new amo();
    ((amo)localObject2).tPo = this.username;
    Object localObject3 = new aqi();
    Object localObject1 = this.vVi.bEk();
    ((aqi)localObject3).jLr = ((ArrayList)localObject1).size();
    ((aqi)localObject3).tTt = new LinkedList();
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      aqh localaqh = new aqh();
      localaqh.tTs = str;
      ((aqi)localObject3).tTt.add(localaqh);
    }
    ((amo)localObject2).tPk = ((aqi)localObject3);
    ap.yY();
    com.tencent.mm.u.c.wQ().b(new e.a(60, (com.tencent.mm.bd.a)localObject2));
    ap.yY();
    localObject2 = com.tencent.mm.u.c.wR().Rb(this.username);
    if ((localObject2 != null) && ((int)((com.tencent.mm.j.a)localObject2).gTG > 0) && (com.tencent.mm.j.a.ez(((com.tencent.mm.e.b.af)localObject2).field_type)))
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + ",")
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject1 = (String)localObject1 + (String)localObject3;
      }
      v.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[] { this.username, localObject1 });
      this.jht.cr((String)localObject1);
      ap.yY();
      com.tencent.mm.u.c.wR().Q(this.jht);
    }
    GMTrace.o(1722550321152L, 12834);
  }
  
  private boolean bXI()
  {
    GMTrace.i(1722818756608L, 12836);
    String str = this.vUO.getText().toString();
    if (((this.gkA == null) || (!this.gkA.equals(str))) && ((!u.mA(this.gkA)) || (!u.mA(str))))
    {
      GMTrace.o(1722818756608L, 12836);
      return true;
    }
    GMTrace.o(1722818756608L, 12836);
    return false;
  }
  
  private boolean bXJ()
  {
    GMTrace.i(1722952974336L, 12837);
    if ((!u.mA(this.vUZ)) || (this.vVe))
    {
      GMTrace.o(1722952974336L, 12837);
      return true;
    }
    GMTrace.o(1722952974336L, 12837);
    return false;
  }
  
  private void bXK()
  {
    GMTrace.i(1723489845248L, 12841);
    this.vVe = true;
    this.vUU.setVisibility(8);
    this.vUR.setVisibility(0);
    this.vUT.setVisibility(8);
    this.vUT.setImageBitmap(null);
    ajo();
    GMTrace.o(1723489845248L, 12841);
  }
  
  private void goBack()
  {
    GMTrace.i(1723087192064L, 12838);
    boolean bool1 = bXJ();
    boolean bool2 = lu(true);
    boolean bool3 = bXI();
    if ((bool1) || (bool2) || (bool3))
    {
      g.b(this, getString(R.l.dZf), null, getString(R.l.dZh), getString(R.l.dZg), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(14304254361600L, 106575);
          ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this);
          GMTrace.o(14304254361600L, 106575);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(17923972268032L, 133544);
          ContactRemarkInfoModUI.this.finish();
          GMTrace.o(17923972268032L, 133544);
        }
      });
      GMTrace.o(1723087192064L, 12838);
      return;
    }
    aGY();
    finish();
    GMTrace.o(1723087192064L, 12838);
  }
  
  private boolean lu(boolean paramBoolean)
  {
    GMTrace.i(1722684538880L, 12835);
    String str = this.vUM.getText().toString();
    if (!paramBoolean)
    {
      if (((this.aIP == null) || (!this.aIP.equals(str))) && ((!u.mA(this.aIP)) || (!u.mA(str))))
      {
        GMTrace.o(1722684538880L, 12835);
        return true;
      }
      GMTrace.o(1722684538880L, 12835);
      return false;
    }
    if (((this.aIP == null) || (!this.aIP.equals(str))) && ((!u.mA(this.aIP)) || (!u.mA(str)))) {}
    for (int i = 1; (i != 0) && ((str == null) || (!str.equals(this.jht.field_nickname))); i = 0)
    {
      GMTrace.o(1722684538880L, 12835);
      return true;
    }
    GMTrace.o(1722684538880L, 12835);
    return false;
  }
  
  private void t(boolean paramBoolean, int paramInt)
  {
    GMTrace.i(1721610797056L, 12827);
    if (this.vVc)
    {
      this.vUP.setVisibility(8);
      if ((paramBoolean) && (u.mA(this.gkA)))
      {
        this.vUQ.setVisibility(0);
        this.vUY.setVisibility(8);
      }
      for (;;)
      {
        this.vUM.setVisibility(0);
        GMTrace.o(1721610797056L, 12827);
        return;
        if (paramInt == R.h.bFq)
        {
          this.vUQ.setVisibility(8);
          this.vUY.setVisibility(0);
        }
      }
    }
    this.vUP.setVisibility(0);
    this.vUQ.setVisibility(0);
    this.vUM.setVisibility(8);
    this.vUY.setVisibility(8);
    GMTrace.o(1721610797056L, 12827);
  }
  
  protected final void KD()
  {
    GMTrace.i(1721745014784L, 12828);
    this.vUN = ((TextView)findViewById(R.h.bFk));
    this.vUP = ((TextView)findViewById(R.h.bFs));
    this.vUQ = ((TextView)findViewById(R.h.bFq));
    this.vUR = ((TextView)findViewById(R.h.bFr));
    this.vUM = ((MMClearEditText)findViewById(R.h.bFj));
    this.vUO = ((MMEditText)findViewById(R.h.bFi));
    this.vUT = ((ImageView)findViewById(R.h.cxE));
    this.vUU = ((ImageView)findViewById(R.h.cxF));
    this.vUS = ((TextView)findViewById(R.h.cSY));
    this.vUY = findViewById(R.h.bFh);
    this.vVi = ((ProfileEditPhoneNumberView)findViewById(R.h.ckF));
    this.vVi.kUK = this.jht;
    final Object localObject = this.vVi;
    String str1 = this.vVj;
    String str2 = this.vVk;
    ((ProfileEditPhoneNumberView)localObject).sIa = str1;
    ((ProfileEditPhoneNumberView)localObject).sIb = str2;
    ((ProfileEditPhoneNumberView)localObject).aTK();
    this.vVi.sIf = new ProfileEditPhoneNumberView.a()
    {
      public final void adT()
      {
        GMTrace.i(17926656622592L, 133564);
        ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this);
        GMTrace.o(17926656622592L, 133564);
      }
      
      public final void bEm()
      {
        GMTrace.i(17926790840320L, 133565);
        o.r(ContactRemarkInfoModUI.e(ContactRemarkInfoModUI.this));
        q.Hz().gg(7);
        GMTrace.o(17926790840320L, 133565);
      }
    };
    this.ouO = ((MMTagPanel)findViewById(R.h.bFg));
    this.ouO.mpl = false;
    this.vVh = ((ScrollView)findViewById(R.h.czW));
    this.vVg = ((TextView)findViewById(R.h.bFe));
    this.vVg.setText(R.l.eBc);
    this.ouO.setOnClickListener(this.vVf);
    this.vVg.setOnClickListener(this.vVf);
    zd(R.l.dYG);
    label658:
    int i;
    if (!u.mA(this.aIP))
    {
      this.vUM.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.aIP), this.vUM.getTextSize()));
      this.vUP.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.aIP), this.vUP.getTextSize()));
      this.vUM.setSelection(this.vUM.getText().length());
      localObject = com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.gkA), this.vUQ.getTextSize());
      this.vUO.setText((CharSequence)localObject);
      this.vUO.setSelection(this.vUO.getText().length());
      if (!u.mA(this.gkA))
      {
        this.vUQ.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.gkA), this.vUQ.getTextSize()));
        this.vUQ.setTextColor(getResources().getColor(R.e.aVo));
      }
      this.vUP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(17926388187136L, 133562);
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.aHc();
          GMTrace.o(17926388187136L, 133562);
        }
      });
      this.vUQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1765902647296L, 13157);
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.aHc();
          GMTrace.o(1765902647296L, 13157);
        }
      });
      this.vUM.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          GMTrace.i(17924509138944L, 133548);
          ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this);
          GMTrace.o(17924509138944L, 133548);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(17924374921216L, 133547);
          GMTrace.o(17924374921216L, 133547);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(17924240703488L, 133546);
          GMTrace.o(17924240703488L, 133546);
        }
      });
      this.vUS.setText(com.tencent.mm.ui.tools.h.aH(800, this.vUO.getEditableText().toString()));
      this.vUO.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          GMTrace.i(17925448663040L, 133555);
          if (!paramAnonymousBoolean)
          {
            ContactRemarkInfoModUI.i(ContactRemarkInfoModUI.this).setBackgroundResource(R.g.bfV);
            GMTrace.o(17925448663040L, 133555);
            return;
          }
          ContactRemarkInfoModUI.i(ContactRemarkInfoModUI.this).setBackgroundResource(R.g.bfU);
          GMTrace.o(17925448663040L, 133555);
        }
      });
      this.vUO.addTextChangedListener(new b());
      if (u.mA(this.hOI)) {
        break label944;
      }
      this.vUR.setVisibility(8);
      this.vUT.setVisibility(0);
      com.tencent.mm.ar.c.Ii();
      if (com.tencent.mm.ar.c.jW(this.username)) {
        break label937;
      }
      com.tencent.mm.ar.c.Ii().a(this.username, this.hOI, new com.tencent.mm.ar.c.a()
      {
        public final void bl(final boolean paramAnonymousBoolean)
        {
          GMTrace.i(17927461928960L, 133570);
          ContactRemarkInfoModUI.u(ContactRemarkInfoModUI.this).post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(17927059275776L, 133567);
              if (!paramAnonymousBoolean)
              {
                g.bk(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(R.l.dGM));
                ContactRemarkInfoModUI.s(ContactRemarkInfoModUI.this).setVisibility(0);
                ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this).setVisibility(8);
                ContactRemarkInfoModUI.u(ContactRemarkInfoModUI.this).setVisibility(8);
                GMTrace.o(17927059275776L, 133567);
                return;
              }
              ContactRemarkInfoModUI.v(ContactRemarkInfoModUI.this);
              GMTrace.o(17927059275776L, 133567);
            }
          });
          GMTrace.o(17927461928960L, 133570);
        }
      });
      this.vUT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(17924643356672L, 133549);
          if (!ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this))
          {
            GMTrace.o(17924643356672L, 133549);
            return;
          }
          ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this);
          Intent localIntent = new Intent(ContactRemarkInfoModUI.this, ContactRemarkImagePreviewUI.class);
          localIntent.putExtra("Contact_User", ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this));
          if ((!u.mA(ContactRemarkInfoModUI.m(ContactRemarkInfoModUI.this))) && (!ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this))) {
            com.tencent.mm.ar.c.Ii();
          }
          for (paramAnonymousView = com.tencent.mm.ar.c.jV(ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this));; paramAnonymousView = ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this))
          {
            localIntent.putExtra("remark_image_path", paramAnonymousView);
            localIntent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this));
            ContactRemarkInfoModUI.this.startActivityForResult(localIntent, 400);
            GMTrace.o(17924643356672L, 133549);
            return;
          }
        }
      });
      this.vUR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1822274093056L, 13577);
          if ((u.mA(ContactRemarkInfoModUI.m(ContactRemarkInfoModUI.this))) || (ContactRemarkInfoModUI.p(ContactRemarkInfoModUI.this)))
          {
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false);
            ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this);
          }
          GMTrace.o(1822274093056L, 13577);
        }
      });
      localObject = com.tencent.mm.modelfriend.af.FZ().ja(this.jht.field_username);
      if ((localObject != null) && (!u.mA(((com.tencent.mm.modelfriend.b)localObject).ES())) && (!((com.tencent.mm.modelfriend.b)localObject).ES().equals(this.vUM.getText().toString()))) {
        break label964;
      }
      i = 0;
      label738:
      if ((i == 0) && (this.orm == 14) && (!u.mA(this.sRf)) && (!this.sRf.equals(this.vUM.getText().toString()))) {
        break label1054;
      }
      label781:
      a(0, getString(R.l.dHh), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(17926253969408L, 133561);
          ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.this.aGY();
          GMTrace.o(17926253969408L, 133561);
          return false;
        }
      }, l.b.uSj);
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(1777713807360L, 13245);
          ContactRemarkInfoModUI.r(ContactRemarkInfoModUI.this);
          GMTrace.o(1777713807360L, 13245);
          return true;
        }
      });
      if (!u.mA(this.aIP)) {
        break label1155;
      }
      ko(true);
    }
    for (;;)
    {
      this.vUU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(17925180227584L, 133553);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
          ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this);
          GMTrace.o(17925180227584L, 133553);
        }
      });
      if (!this.vVd)
      {
        this.vVc = true;
        t(true, -1);
      }
      bXF();
      GMTrace.o(1721745014784L, 12828);
      return;
      this.vUM.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.jht.tK()), this.vUM.getTextSize()));
      this.vUP.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.jht.tK()), this.vUM.getTextSize()));
      break;
      label937:
      bXG();
      break label658;
      label944:
      this.vUR.setVisibility(0);
      this.vUT.setVisibility(8);
      break label658;
      label964:
      this.vUV = ((TextView)findViewById(R.h.ckL));
      this.vUW = findViewById(R.h.ckG);
      this.vUX = findViewById(R.h.ckM);
      this.vUW.setVisibility(0);
      this.vUV.setText(getString(R.l.dZu, new Object[] { ((com.tencent.mm.modelfriend.b)localObject).ES() }));
      this.vUX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14302777966592L, 106564);
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setText(localObject.ES());
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setSelection(ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).getText().length());
          ContactRemarkInfoModUI.x(ContactRemarkInfoModUI.this).setVisibility(8);
          GMTrace.o(14302777966592L, 106564);
        }
      });
      i = 1;
      break label738;
      label1054:
      this.vUV = ((TextView)findViewById(R.h.ckL));
      this.vUW = findViewById(R.h.ckG);
      this.vUX = findViewById(R.h.ckM);
      this.vUW.setVisibility(0);
      this.vUV.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(getString(R.l.dZt, new Object[] { this.sRf })), this.vUV.getTextSize()));
      this.vUX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(17924911792128L, 133551);
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setText(com.tencent.mm.pluginsdk.ui.d.h.b(ContactRemarkInfoModUI.this, u.mz(ContactRemarkInfoModUI.y(ContactRemarkInfoModUI.this)), ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).getTextSize()));
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setSelection(ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).getText().length());
          ContactRemarkInfoModUI.x(ContactRemarkInfoModUI.this).setVisibility(8);
          GMTrace.o(17924911792128L, 133551);
        }
      });
      break label781;
      label1155:
      ko(false);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(1723624062976L, 12842);
    v.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.kng != null)
    {
      this.kng.dismiss();
      this.kng = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      g.b(this, getString(R.l.dGL), null, true);
      GMTrace.o(1723624062976L, 12842);
      return;
    }
    if (paramk.getType() == 575)
    {
      if (this.vUZ != null)
      {
        paramString = new File(this.vUZ);
        if (paramString.exists())
        {
          com.tencent.mm.ar.c.Ii();
          paramString.renameTo(new File(com.tencent.mm.ar.c.jV(this.username)));
        }
      }
      paramString = ((com.tencent.mm.ar.b)paramk).hOI;
      if (!u.mA(paramString)) {
        this.hOI = paramString;
      }
    }
    for (;;)
    {
      finish();
      GMTrace.o(1723624062976L, 12842);
      return;
      if (paramk.getType() == 576)
      {
        this.vUZ = null;
        this.hOI = null;
        this.vVa = false;
        ap.yY();
        this.jht = com.tencent.mm.u.c.wR().Rb(this.username);
        this.jht.cm("");
        ap.yY();
        com.tencent.mm.u.c.wR().a(this.username, this.jht);
      }
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1721476579328L, 12826);
    int i = R.i.cZy;
    GMTrace.o(1721476579328L, 12826);
    return i;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(1723355627520L, 12840);
    v.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      v.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
      GMTrace.o(1723355627520L, 12840);
      return;
    }
    Context localContext;
    switch (paramInt1)
    {
    default: 
      GMTrace.o(1723355627520L, 12840);
      return;
    case 100: 
      localContext = getApplicationContext();
      ap.yY();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.k.b(localContext, paramIntent, com.tencent.mm.u.c.xb());
      if (paramIntent == null)
      {
        GMTrace.o(1723355627520L, 12840);
        return;
      }
      this.vUZ = TO(paramIntent);
      TN(this.vUZ);
      this.vVb = true;
      this.vVe = false;
      ajo();
      GMTrace.o(1723355627520L, 12840);
      return;
    case 200: 
      localContext = getApplicationContext();
      ap.yY();
      paramIntent = com.tencent.mm.ui.tools.a.c(localContext, paramIntent, com.tencent.mm.u.c.xb());
      if (paramIntent == null)
      {
        GMTrace.o(1723355627520L, 12840);
        return;
      }
      this.vUZ = TO(paramIntent);
      TN(this.vUZ);
      this.vVb = true;
      this.vVe = false;
      ajo();
      GMTrace.o(1723355627520L, 12840);
      return;
    case 400: 
      if (paramIntent.getBooleanExtra("response_delete", false)) {
        bXK();
      }
      GMTrace.o(1723355627520L, 12840);
      return;
    }
    if ((lu(true)) || (bXI()) || (bXJ()) || (paramIntent.getBooleanExtra("hasLableChange", false)))
    {
      ko(true);
      GMTrace.o(1723355627520L, 12840);
      return;
    }
    ko(false);
    GMTrace.o(1723355627520L, 12840);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1720939708416L, 12822);
    super.onCreate(paramBundle);
    ap.vd().a(575, this);
    ap.vd().a(576, this);
    this.orm = getIntent().getIntExtra("Contact_Scene", 9);
    this.sRf = getIntent().getStringExtra("Contact_RoomNickname");
    this.vVd = getIntent().getBooleanExtra("view_mode", false);
    this.vVl = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
    this.vVj = getIntent().getStringExtra("contact_phone_number_by_md5");
    this.vVk = getIntent().getStringExtra("contact_phone_number_list");
    this.username = getIntent().getStringExtra("Contact_User");
    if (u.mA(this.username))
    {
      finish();
      GMTrace.o(1720939708416L, 12822);
      return;
    }
    ap.yY();
    this.jht = com.tencent.mm.u.c.wR().Rb(this.username);
    this.aIP = this.jht.field_conRemark;
    this.gkA = this.jht.gkA;
    this.hOI = this.jht.gkB;
    this.mYF = this.jht.field_contactLabelIds;
    this.ouP = com.tencent.mm.plugin.label.a.a.aFz().ze(this.mYF);
    KD();
    ajo();
    GMTrace.o(1720939708416L, 12822);
  }
  
  public void onDestroy()
  {
    GMTrace.i(1721342361600L, 12825);
    ap.vd().b(575, this);
    ap.vd().b(576, this);
    super.onDestroy();
    GMTrace.o(1721342361600L, 12825);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(1723221409792L, 12839);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      goBack();
      GMTrace.o(1723221409792L, 12839);
      return true;
    }
    GMTrace.o(1723221409792L, 12839);
    return false;
  }
  
  protected void onPause()
  {
    GMTrace.i(1721208143872L, 12824);
    ap.yY();
    com.tencent.mm.u.c.wR().b(this.ouQ);
    super.onPause();
    GMTrace.o(1721208143872L, 12824);
  }
  
  public void onResume()
  {
    GMTrace.i(1721073926144L, 12823);
    super.onResume();
    ap.yY();
    com.tencent.mm.u.c.wR().a(this.ouQ);
    aTL();
    GMTrace.o(1721073926144L, 12823);
  }
  
  private final class a
    implements View.OnClickListener
  {
    public a()
    {
      GMTrace.i(1832743075840L, 13655);
      GMTrace.o(1832743075840L, 13655);
    }
    
    public final void onClick(View paramView)
    {
      GMTrace.i(1832877293568L, 13656);
      ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this);
      GMTrace.o(1832877293568L, 13656);
    }
  }
  
  private final class b
    implements TextWatcher
  {
    private int pgY;
    private String vVs;
    
    public b()
    {
      GMTrace.i(1793954152448L, 13366);
      this.pgY = 800;
      this.vVs = "";
      GMTrace.o(1793954152448L, 13366);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      GMTrace.i(1794356805632L, 13369);
      this.pgY = com.tencent.mm.ui.tools.h.aH(800, paramEditable.toString());
      if (this.pgY < 0) {
        this.pgY = 0;
      }
      if (ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this) != null) {
        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this).setText(this.pgY);
      }
      ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this);
      GMTrace.o(1794356805632L, 13369);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(1794088370176L, 13367);
      GMTrace.o(1794088370176L, 13367);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(1794222587904L, 13368);
      GMTrace.o(1794222587904L, 13368);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/ContactRemarkInfoModUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */