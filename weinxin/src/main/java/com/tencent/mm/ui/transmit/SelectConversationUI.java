package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.a;
import com.tencent.mm.e.a.fn;
import com.tencent.mm.e.a.kq;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.lz.a;
import com.tencent.mm.e.a.lz.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.k.a;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bt;
import com.tencent.mm.u.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.a.a;
import com.tencent.mm.ui.chatting.ab;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.l.b;
import com.tencent.mm.ui.r;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(19)
public class SelectConversationUI
  extends MMBaseSelectContactUI
{
  private static final int wot;
  private long fFo;
  private long fGD;
  private String fSi;
  private au fTa;
  private int fromScene;
  private String imagePath;
  private int ipj;
  private List<String> jzO;
  private String kcC;
  private int[] lLm;
  private int msgType;
  private boolean vWx;
  private boolean vXv;
  private TextView vuO;
  private boolean woA;
  private boolean woB;
  private int woC;
  private boolean woD;
  private int woE;
  private String woF;
  private String woG;
  private Boolean woH;
  private boolean woI;
  private boolean woJ;
  private List<String> woK;
  private ReportUtil.ReportArgs woL;
  private String woM;
  private String woN;
  private MenuItem.OnMenuItemClickListener woO;
  private MenuItem.OnMenuItemClickListener woP;
  private int wou;
  private boolean wov;
  private boolean wow;
  private boolean wox;
  private boolean woy;
  private boolean woz;
  
  static
  {
    GMTrace.i(3026609766400L, 22550);
    wot = com.tencent.mm.ui.contact.s.q(new int[] { 1, 2 });
    GMTrace.o(3026609766400L, 22550);
  }
  
  public SelectConversationUI()
  {
    GMTrace.i(3019630444544L, 22498);
    this.wov = false;
    this.wow = false;
    this.wox = false;
    this.woy = false;
    this.woz = false;
    this.woA = false;
    this.fromScene = 0;
    this.woB = false;
    this.vXv = false;
    this.woD = false;
    this.woE = 3;
    this.woH = Boolean.valueOf(false);
    this.woI = false;
    this.woJ = false;
    this.woK = null;
    this.imagePath = null;
    this.woN = null;
    this.kcC = null;
    this.lLm = new int[] { R.h.bAX, R.h.bAY, R.h.bAZ, R.h.bBa, R.h.bBb };
    this.woO = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(17933233291264L, 133613);
        paramAnonymousMenuItem = SelectConversationUI.this;
        boolean bool;
        if (!SelectConversationUI.a(SelectConversationUI.this))
        {
          bool = true;
          SelectConversationUI.a(paramAnonymousMenuItem, bool);
          SelectConversationUI.this.bXR().lv(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.this.vWl.lv(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.k(SelectConversationUI.this);
          paramAnonymousMenuItem = SelectConversationUI.m(SelectConversationUI.this);
          if (SelectConversationUI.a(SelectConversationUI.this)) {
            break label118;
          }
        }
        label118:
        for (int i = SelectConversationUI.l(SelectConversationUI.this);; i = R.l.eQt)
        {
          paramAnonymousMenuItem.setText(i);
          GMTrace.o(17933233291264L, 133613);
          return true;
          bool = false;
          break;
        }
      }
    };
    this.woP = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(17928133017600L, 133575);
        if (SelectConversationUI.n(SelectConversationUI.this))
        {
          GMTrace.o(17928133017600L, 133575);
          return false;
        }
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Conv_User", u.c(SelectConversationUI.o(SelectConversationUI.this), ","));
        Intent localIntent = (Intent)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localIntent != null) {
          SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem, localIntent);
        }
        for (;;)
        {
          GMTrace.o(17928133017600L, 133575);
          return true;
          if (SelectConversationUI.p(SelectConversationUI.this))
          {
            SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem);
            SelectConversationUI.this.finish();
          }
          else
          {
            SelectConversationUI.b(SelectConversationUI.this, paramAnonymousMenuItem);
          }
        }
      }
    };
    GMTrace.o(3019630444544L, 22498);
  }
  
  private void Ol()
  {
    GMTrace.i(3023254323200L, 22525);
    if (!this.woI)
    {
      GMTrace.o(3023254323200L, 22525);
      return;
    }
    if ((this.woK != null) && (this.woK.size() > 0))
    {
      aA(1, getString(R.l.dIs) + "(" + this.woK.size() + ")");
      a(this.woP);
      ae(1, true);
      GMTrace.o(3023254323200L, 22525);
      return;
    }
    if (!this.woJ)
    {
      aA(1, getString(R.l.dHz));
      a(this.woO);
      ae(1, true);
      GMTrace.o(3023254323200L, 22525);
      return;
    }
    aA(1, getString(R.l.dIA));
    a(this.woO);
    ae(1, true);
    GMTrace.o(3023254323200L, 22525);
  }
  
  private void a(Intent paramIntent1, Intent paramIntent2)
  {
    GMTrace.i(3021509492736L, 22512);
    v.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=" + paramIntent2);
    paramIntent2.putExtras(paramIntent1.getExtras());
    startActivityForResult(paramIntent2, 2);
    com.tencent.mm.ui.base.b.x(this.uRf.uRz, paramIntent2);
    GMTrace.o(3021509492736L, 22512);
  }
  
  private static void a(Intent paramIntent, String paramString1, String paramString2)
  {
    GMTrace.i(3020972621824L, 22508);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString2);
    a(paramIntent, paramString1, localLinkedList);
    GMTrace.o(3020972621824L, 22508);
  }
  
  private static void a(Intent paramIntent, String paramString, List<String> paramList)
  {
    GMTrace.i(3021106839552L, 22509);
    if (paramList.size() > 0)
    {
      paramIntent.putExtra("be_send_card_name", paramString);
      paramIntent.putExtra("received_card_name", u.c(paramList, ","));
      paramIntent.putExtra("Is_Chatroom", false);
    }
    GMTrace.o(3021106839552L, 22509);
  }
  
  private void a(com.tencent.mm.pluginsdk.ui.applet.d.a parama)
  {
    GMTrace.i(17934441250816L, 133622);
    final Object localObject = (HashMap)getIntent().getSerializableExtra("appbrand_params");
    int i = bt.getInt(((HashMap)localObject).get("type"), 1);
    String str1 = bt.b(((HashMap)localObject).get("title"), "");
    String str2 = bt.b(((HashMap)localObject).get("img_url"), null);
    if ((i == 2) || (i == 3))
    {
      String str3 = bt.b(((HashMap)localObject).get("app_id"), null);
      i = bt.getInt(((HashMap)localObject).get("pkg_type"), 0);
      int j = bt.getInt(((HashMap)localObject).get("pkg_version"), 0);
      String str4 = bt.b(((HashMap)localObject).get("cache_key"), null);
      String str5 = bt.b(((HashMap)localObject).get("path"), null);
      String str6 = bt.b(((HashMap)localObject).get("delay_load_img_path"), null);
      boolean bool = bt.ax(((HashMap)localObject).get("is_dynamic"));
      localObject = ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aR(this);
      final String str7 = com.tencent.mm.plugin.appbrand.k.b.aM(this);
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", str3);
      localBundle.putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      localBundle.putInt("msg_pkg_type", i);
      localBundle.putInt("pkg_version", j);
      localBundle.putString("image_url", str2);
      localBundle.putBoolean("is_dynamic_page", bool);
      localBundle.putString("title", str1);
      localBundle.putString("cache_key", str4);
      localBundle.putString("msg_path", str5);
      localBundle.putString("delay_load_img_path", str6);
      ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).a(str7, (View)localObject, localBundle);
      parama.cO((View)localObject);
      parama.c(Boolean.valueOf(true));
      parama.bEO();
      parama.jqA = new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(17933501726720L, 133615);
          ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).a(str7, localObject);
          GMTrace.o(17933501726720L, 133615);
        }
      };
      GMTrace.o(17934441250816L, 133622);
      return;
    }
    parama.MN(getResources().getString(R.l.dDH) + str1);
    parama.MO(str2).bEN();
    parama.c(Boolean.valueOf(true));
    GMTrace.o(17934441250816L, 133622);
  }
  
  private void a(com.tencent.mm.pluginsdk.ui.applet.d.a parama, String paramString)
  {
    GMTrace.i(3021375275008L, 22511);
    ap.yY();
    com.tencent.mm.u.c.wR().QZ(paramString);
    String str = com.tencent.mm.u.n.eK(paramString);
    if (!bf.mA(this.woG)) {
      str = this.woG;
    }
    ap.yY();
    if (com.tencent.mm.u.o.eW(com.tencent.mm.u.c.wR().QZ(paramString).field_verifyFlag)) {}
    for (paramString = getResources().getString(R.l.dHk);; paramString = getResources().getString(R.l.dHl))
    {
      parama.MN(paramString + str);
      GMTrace.o(3021375275008L, 22511);
      return;
    }
  }
  
  private static void b(Intent paramIntent, String paramString1, String paramString2)
  {
    GMTrace.i(3021241057280L, 22510);
    if (paramString1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("cardNameToSend is null", bool);
      paramIntent.putExtra("be_send_card_name", paramString1);
      paramIntent.putExtra("received_card_name", paramString2);
      paramIntent.putExtra("Is_Chatroom", true);
      GMTrace.o(3021241057280L, 22510);
      return;
    }
  }
  
  private void b(com.tencent.mm.pluginsdk.ui.applet.d.a parama)
  {
    GMTrace.i(3021777928192L, 22514);
    final Object localObject1;
    final Object localObject2;
    f.a locala;
    switch (this.msgType)
    {
    case 6: 
    case 7: 
    case 14: 
    case 15: 
    default: 
      GMTrace.o(3021777928192L, 22514);
      return;
    case 4: 
      parama.MN(this.fSi);
      parama.bEM();
      GMTrace.o(3021777928192L, 22514);
      return;
    case 0: 
    case 16: 
      if (this.fTa == null) {}
      float f;
      for (localObject1 = null;; localObject1 = com.tencent.mm.sdk.platformtools.d.a(((com.tencent.mm.ah.f)localObject2).jw((String)localObject1), f, 0))
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (this.imagePath != null) {
            localObject2 = com.tencent.mm.sdk.platformtools.d.Pf(this.imagePath);
          }
        }
        parama.a((Bitmap)localObject2, 3);
        GMTrace.o(3021777928192L, 22514);
        return;
        localObject1 = this.fTa.field_imgPath;
        localObject2 = com.tencent.mm.ah.n.GT();
        f = com.tencent.mm.bg.a.getDensity(aa.getContext());
      }
    case 1: 
      parama.a(bZT(), 2);
      GMTrace.o(3021777928192L, 22514);
      return;
    case 11: 
      parama.a(bZT(), 2);
      GMTrace.o(3021777928192L, 22514);
      return;
    case 9: 
      ap.yY();
      localObject2 = com.tencent.mm.u.c.wT().Au(this.fSi);
      localObject1 = "";
      if (localObject2 != null) {
        localObject1 = ((au.b)localObject2).label;
      }
      parama.MN(this.uRf.uRz.getString(R.l.dHt) + (String)localObject1);
      GMTrace.o(3021777928192L, 22514);
      return;
    case 5: 
      if (!bf.mA(this.woM))
      {
        parama.MP(this.woM);
        GMTrace.o(3021777928192L, 22514);
        return;
      }
      if (!bf.mA(this.fTa.field_imgPath))
      {
        parama.MP(this.fTa.field_imgPath);
        GMTrace.o(3021777928192L, 22514);
        return;
      }
      parama.MP(this.imagePath);
      GMTrace.o(3021777928192L, 22514);
      return;
    case 8: 
      ap.yY();
      localObject1 = com.tencent.mm.u.c.wT().At(this.fSi);
      this.woF = ((au.a)localObject1).rTh;
      this.woG = ((au.a)localObject1).fER;
      this.woH = Boolean.valueOf(com.tencent.mm.u.o.eW(((au.a)localObject1).rUD));
      a(parama, this.woF);
      GMTrace.o(3021777928192L, 22514);
      return;
    case 2: 
    case 10: 
      locala = f.a.ek(bf.PW(this.fSi));
      if ((this.fTa.bLN()) && (locala == null)) {
        locala = f.a.B(bf.PW(this.fSi), bf.PW(this.fSi));
      }
      break;
    }
    for (;;)
    {
      if (locala == null)
      {
        if (this.woN != null)
        {
          localObject1 = getResources().getString(R.l.dIP);
          localObject2 = this.woN;
          parama.MN((String)localObject1 + (String)localObject2);
        }
        GMTrace.o(3021777928192L, 22514);
        return;
      }
      localObject1 = locala.title;
      Object localObject3;
      if (locala.type == 5)
      {
        localObject2 = getResources().getString(R.l.dIM);
        localObject3 = locala.url;
      }
      for (;;)
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        parama.MN((String)localObject2 + (String)localObject3);
        if (locala.thumburl == null) {
          break;
        }
        parama.MO(locala.thumburl).bEN();
        GMTrace.o(3021777928192L, 22514);
        return;
        if (locala.type == 6)
        {
          localObject2 = getResources().getString(R.l.dHf);
        }
        else if (locala.type == 24)
        {
          localObject2 = getResources().getString(R.l.dHK);
          localObject1 = new lz();
          ((lz)localObject1).fSV.type = 0;
          ((lz)localObject1).fSV.fSX = locala.hhG;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
          localObject1 = bf.ap(((lz)localObject1).fSW.fTf.desc, locala.description).replaceAll("\n", " ");
        }
        else if (locala.type == 19)
        {
          localObject2 = getResources().getString(R.l.dIj);
        }
        else if (locala.type == 3)
        {
          localObject2 = getResources().getString(R.l.dHA);
        }
        else if (locala.type == 4)
        {
          localObject2 = getResources().getString(R.l.dIP);
        }
        else if (locala.type == 8)
        {
          localObject2 = getResources().getString(R.l.dGF);
        }
        else if ((locala.type == 33) || (locala.type == 36))
        {
          if ((locala.hjE == 2) || (locala.hjE == 3) || (locala.type == 36))
          {
            localObject1 = ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aR(this);
            parama.cO((View)localObject1);
            parama.c(Boolean.valueOf(true));
            parama.bEO();
            Object localObject4 = com.tencent.mm.ah.n.GT().jw(this.fTa.field_imgPath);
            localObject2 = com.tencent.mm.plugin.appbrand.k.b.aM(this);
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("app_id", locala.hjD);
            ((Bundle)localObject3).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(locala.hjJ), Integer.valueOf(locala.hjG) }));
            ((Bundle)localObject3).putInt("msg_pkg_type", locala.hjJ);
            ((Bundle)localObject3).putInt("pkg_version", locala.hjG);
            if (!bf.mA((String)localObject4)) {
              ((Bundle)localObject3).putString("image_url", "file://" + (String)localObject4);
            }
            localObject4 = (com.tencent.mm.t.a)locala.n(com.tencent.mm.t.a.class);
            if (localObject4 != null)
            {
              ((Bundle)localObject3).putBoolean("is_dynamic_page", ((com.tencent.mm.t.a)localObject4).hgY);
              ((Bundle)localObject3).putString("cache_key", ((com.tencent.mm.t.a)localObject4).hgZ);
            }
            ((Bundle)localObject3).putString("title", locala.title);
            ((Bundle)localObject3).putString("msg_path", locala.hjB);
            ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).a((String)localObject2, (View)localObject1, (Bundle)localObject3);
            parama.jqA = new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                GMTrace.i(17930012065792L, 133589);
                ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).a(localObject2, localObject1);
                GMTrace.o(17930012065792L, 133589);
              }
            };
            GMTrace.o(3021777928192L, 22514);
            return;
          }
          localObject2 = getResources().getString(R.l.dDH);
        }
        else
        {
          localObject2 = getResources().getString(R.l.dDe);
        }
      }
      localObject1 = u.ap(ab.eS(this.uRf.uRz).fSW.fTe.title, "");
      parama.MN(getResources().getString(R.l.dHy) + (String)localObject1);
      GMTrace.o(3021777928192L, 22514);
      return;
      localObject1 = ab.eS(this.uRf.uRz);
      int i = 0;
      if (((lz)localObject1).fSV.fTb != null) {
        i = ((lz)localObject1).fSV.fTb.size();
      }
      localObject1 = this.uRf.uRz.getString(R.l.eLA, new Object[] { Integer.valueOf(i) });
      parama.MN(getResources().getString(R.l.dHx) + (String)localObject1);
      GMTrace.o(3021777928192L, 22514);
      return;
      if (this.kcC == null) {
        break;
      }
      parama.MN(getResources().getString(R.l.dHf) + this.kcC);
      break;
    }
  }
  
  private Bitmap bZT()
  {
    GMTrace.i(3022046363648L, 22516);
    com.tencent.mm.modelvideo.o.KW();
    String str = com.tencent.mm.modelvideo.s.lx(this.fTa.field_imgPath);
    Object localObject = str;
    if (str == null) {
      localObject = this.imagePath;
    }
    localObject = com.tencent.mm.sdk.platformtools.d.Pf((String)localObject);
    GMTrace.o(3022046363648L, 22516);
    return (Bitmap)localObject;
  }
  
  private void bZU()
  {
    GMTrace.i(3022180581376L, 22517);
    v.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 14);
    localIntent.putExtra("titile", getString(R.l.dCK));
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.vWU);
    localIntent.putExtra("already_select_contact", u.c(this.woK, ","));
    localIntent.putExtra("max_limit_num", 9);
    this.uRf.uRz.startActivityForResult(localIntent, 5);
    GMTrace.o(3022180581376L, 22517);
  }
  
  private void bZV()
  {
    GMTrace.i(3022314799104L, 22518);
    v.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.vWR);
    localIntent.putExtra("list_type", 3);
    localIntent.putExtra("be_send_card_name", this.woF);
    localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
    localIntent.putExtra("Add_SendCard", true);
    localIntent.putExtra("titile", getString(R.l.dCK));
    this.uRf.uRz.startActivityForResult(localIntent, 3);
    GMTrace.o(3022314799104L, 22518);
  }
  
  private void bZW()
  {
    GMTrace.i(3022449016832L, 22519);
    v.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 5);
    localIntent.putExtra("titile", getString(R.l.dCK));
    if (((this.fromScene == 4) || (this.fromScene == 9)) && (getIntent().getIntExtra("jsapi_select_mode", 0) == 1))
    {
      localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
      localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.q(new int[] { 32, 16, 1, 2, 4, 16384 }));
    }
    for (;;)
    {
      this.uRf.uRz.startActivityForResult(localIntent, 1);
      GMTrace.o(3022449016832L, 22519);
      return;
      localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.vWT);
    }
  }
  
  private void c(com.tencent.mm.pluginsdk.ui.applet.d.a parama)
  {
    GMTrace.i(3021912145920L, 22515);
    switch (this.msgType)
    {
    }
    for (;;)
    {
      GMTrace.o(3021912145920L, 22515);
      return;
      parama.a(new h.a.a()
      {
        public final void auB()
        {
          GMTrace.i(3018422484992L, 22489);
          Intent localIntent = new Intent(SelectConversationUI.this.uRf.uRz, RetransmitPreviewUI.class);
          localIntent.putExtra("Retr_Msg_content", SelectConversationUI.h(SelectConversationUI.this));
          SelectConversationUI.this.startActivity(localIntent);
          com.tencent.mm.ui.base.b.eM(SelectConversationUI.this.uRf.uRz);
          GMTrace.o(3018422484992L, 22489);
        }
      });
      GMTrace.o(3021912145920L, 22515);
      return;
      parama.a(new h.a.a()
      {
        public final void auB()
        {
          GMTrace.i(3045534466048L, 22691);
          Intent localIntent = new Intent(SelectConversationUI.this.uRf.uRz, ImageGalleryUI.class);
          localIntent.putExtra("img_gallery_msg_id", SelectConversationUI.i(SelectConversationUI.this));
          localIntent.putExtra("img_gallery_msg_svr_id", SelectConversationUI.j(SelectConversationUI.this).field_msgSvrId);
          localIntent.putExtra("img_gallery_talker", SelectConversationUI.j(SelectConversationUI.this).field_talker);
          localIntent.putExtra("img_gallery_chatroom_name", SelectConversationUI.j(SelectConversationUI.this).field_talker);
          localIntent.putExtra("img_preview_only", true);
          SelectConversationUI.this.startActivity(localIntent);
          com.tencent.mm.ui.base.b.eM(SelectConversationUI.this.uRf.uRz);
          GMTrace.o(3045534466048L, 22691);
        }
      });
      GMTrace.o(3021912145920L, 22515);
      return;
      ap.yY();
      final Object localObject = com.tencent.mm.u.c.wT().Au(this.fSi);
      parama.a(new h.a.a()
      {
        public final void auB()
        {
          GMTrace.i(3040031539200L, 22650);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          localIntent.putExtra("kwebmap_slat", localObject.mZn);
          localIntent.putExtra("kwebmap_lng", localObject.mZo);
          localIntent.putExtra("Kwebmap_locaion", this.woS);
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.bb.d.b(SelectConversationUI.this.uRf.uRz, "location", ".ui.RedirectUI", localIntent);
          GMTrace.o(3040031539200L, 22650);
        }
      });
      GMTrace.o(3021912145920L, 22515);
      return;
      localObject = f.a.ek(bf.PW(this.fSi));
      if (localObject == null)
      {
        GMTrace.o(3021912145920L, 22515);
        return;
      }
      if (((f.a)localObject).type == 5)
      {
        parama.a(new h.a.a()
        {
          public final void auB()
          {
            GMTrace.i(3053990182912L, 22754);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", this.val$url);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.bb.d.b(SelectConversationUI.this.uRf.uRz, "webview", ".ui.tools.WebViewUI", localIntent);
            GMTrace.o(3053990182912L, 22754);
          }
        });
        GMTrace.o(3021912145920L, 22515);
        return;
      }
      if (((f.a)localObject).type == 6)
      {
        parama.a(new h.a.a()
        {
          public final void auB()
          {
            GMTrace.i(3013322211328L, 22451);
            Intent localIntent = new Intent();
            localIntent.setClassName(SelectConversationUI.this.uRf.uRz, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            localIntent.putExtra("app_msg_id", SelectConversationUI.i(SelectConversationUI.this));
            localIntent.putExtra("app_show_share", false);
            SelectConversationUI.this.startActivity(localIntent);
            GMTrace.o(3013322211328L, 22451);
          }
        });
        GMTrace.o(3021912145920L, 22515);
        return;
      }
      if (((f.a)localObject).type == 24)
      {
        parama.a(new h.a.a()
        {
          public final void auB()
          {
            GMTrace.i(3013859082240L, 22455);
            kq localkq = new kq();
            localkq.fQY.context = SelectConversationUI.this.uRf.uRz;
            localkq.fQY.fGD = SelectConversationUI.i(SelectConversationUI.this);
            localkq.fQY.fQZ = localObject.hhG;
            localkq.fQY.fQp = false;
            com.tencent.mm.sdk.b.a.uql.m(localkq);
            GMTrace.o(3013859082240L, 22455);
          }
        });
        GMTrace.o(3021912145920L, 22515);
        return;
      }
      if (((f.a)localObject).type == 19)
      {
        parama.a(new h.a.a()
        {
          public final void auB()
          {
            GMTrace.i(3040299974656L, 22652);
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.i(SelectConversationUI.this));
            localIntent.putExtra("record_xml", localObject.hhG);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.bb.d.b(SelectConversationUI.this.uRf.uRz, "record", ".ui.RecordMsgDetailUI", localIntent);
            GMTrace.o(3040299974656L, 22652);
          }
        });
        GMTrace.o(3021912145920L, 22515);
        return;
      }
      if (((f.a)localObject).type == 3)
      {
        parama.a(new h.a.a()
        {
          public final void auB()
          {
            GMTrace.i(3053319094272L, 22749);
            Object localObject2 = p.s(localObject.url, "message");
            String str = p.s(localObject.hhf, "message");
            Object localObject1;
            if (al.isMobile(SelectConversationUI.this.uRf.uRz))
            {
              localObject1 = localObject2;
              if (str != null)
              {
                if (str.length() > 0) {
                  break label131;
                }
                localObject1 = localObject2;
              }
            }
            for (;;)
            {
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
              ((Intent)localObject2).putExtra("showShare", false);
              com.tencent.mm.bb.d.b(SelectConversationUI.this.uRf.uRz, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
              GMTrace.o(3053319094272L, 22749);
              return;
              if (localObject2 != null)
              {
                localObject1 = localObject2;
                if (((String)localObject2).length() > 0) {}
              }
              else
              {
                label131:
                localObject1 = str;
              }
            }
          }
        });
        GMTrace.o(3021912145920L, 22515);
        return;
      }
      if (((f.a)localObject).type == 4)
      {
        parama.a(new h.a.a()
        {
          public final void auB()
          {
            GMTrace.i(3053587529728L, 22751);
            GMTrace.o(3053587529728L, 22751);
          }
        });
        GMTrace.o(3021912145920L, 22515);
        return;
        parama.a(new h.a.a()
        {
          public final void auB()
          {
            GMTrace.i(3053050658816L, 22747);
            Object localObject = ab.eS(SelectConversationUI.this.uRf.uRz);
            localObject = f.a.ek(bf.PW(com.tencent.mm.plugin.record.a.m.b(((lz)localObject).fSW.fTe.title, ((lz)localObject).fSW.fTe.desc, ((lz)localObject).fSW.fSz.fFr.fFt.txF, ((lz)localObject).fSV.fTc)));
            if (localObject == null)
            {
              GMTrace.o(3053050658816L, 22747);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.i(SelectConversationUI.this));
            localIntent.putExtra("record_xml", ((f.a)localObject).hhG);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.bb.d.b(SelectConversationUI.this.uRf.uRz, "record", ".ui.RecordMsgDetailUI", localIntent);
            GMTrace.o(3053050658816L, 22747);
          }
        });
        GMTrace.o(3021912145920L, 22515);
        return;
        ab.eS(this.uRf.uRz);
        GMTrace.o(3021912145920L, 22515);
        return;
        parama.a(new h.a.a()
        {
          public final void auB()
          {
            GMTrace.i(17930951589888L, 133596);
            Intent localIntent = new Intent();
            localIntent.setClassName(SelectConversationUI.this.uRf.uRz, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            localIntent.putExtra("app_msg_id", SelectConversationUI.i(SelectConversationUI.this));
            localIntent.putExtra("app_show_share", false);
            SelectConversationUI.this.startActivity(localIntent);
            GMTrace.o(17930951589888L, 133596);
          }
        });
      }
    }
  }
  
  private void d(int paramInt, Intent paramIntent)
  {
    GMTrace.i(14990643822592L, 111689);
    Intent localIntent = paramIntent;
    if (this.msgType == 5)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("emoji_thumb_path", this.woM);
      localIntent.putExtra("emoji_activity_id", getIntent().getStringExtra("emoji_activity_id"));
    }
    super.setResult(-1, localIntent);
    GMTrace.o(14990643822592L, 111689);
  }
  
  private boolean lJ(boolean paramBoolean)
  {
    GMTrace.i(3023388540928L, 22526);
    if (paramBoolean)
    {
      if (this.woK.size() < 9) {}
    }
    else {
      while (this.woK.size() > 9)
      {
        String str = getString(R.l.eQj, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9)) });
        com.tencent.mm.ui.base.g.a(this.uRf.uRz, str, getString(R.l.dIk), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(17932964855808L, 133611);
            GMTrace.o(17932964855808L, 133611);
          }
        });
        GMTrace.o(3023388540928L, 22526);
        return true;
      }
    }
    GMTrace.o(3023388540928L, 22526);
    return false;
  }
  
  private void n(final Intent paramIntent, String paramString)
  {
    GMTrace.i(3021643710464L, 22513);
    if (com.tencent.mm.ui.contact.s.ee(this.ipj, 256))
    {
      d(-1, paramIntent);
      finish();
      GMTrace.o(3021643710464L, 22513);
      return;
    }
    if (u.mA(paramString))
    {
      v.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
      GMTrace.o(3021643710464L, 22513);
      return;
    }
    if (com.tencent.mm.u.o.dH(paramString))
    {
      int i = j.eC(paramString);
      if (this.woD)
      {
        int j = u.getInt(com.tencent.mm.i.g.sV().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50);
        if (i > j)
        {
          v.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          com.tencent.mm.ui.base.g.b(this, getString(R.l.eQi, new Object[] { Integer.valueOf(j) }), "", true);
          GMTrace.o(3021643710464L, 22513);
          return;
        }
      }
      getString(R.l.eQg, new Object[] { Integer.valueOf(i) });
    }
    com.tencent.mm.pluginsdk.ui.applet.d.a locala = new com.tencent.mm.pluginsdk.ui.applet.d.a(this.uRf.uRz);
    locala.bs(paramString);
    if (this.vXv)
    {
      a(locala, this.woF);
      if (paramString.endsWith("@chatroom"))
      {
        b(paramIntent, this.woF, paramString);
        locala.c(Boolean.valueOf(true));
      }
    }
    for (;;)
    {
      
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          GMTrace.i(3054258618368L, 22756);
          SelectConversationUI.this.aGY();
          boolean bool = paramIntent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
          if (bool) {
            if (!paramAnonymousBoolean) {
              break label129;
            }
          }
          label129:
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            v.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", new Object[] { Integer.valueOf(13943), Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.g.oSF.i(13943, new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (!paramAnonymousBoolean) {
              break;
            }
            paramIntent.putExtra("custom_send_text", paramAnonymousString);
            SelectConversationUI.a(SelectConversationUI.this, paramIntent);
            SelectConversationUI.this.finish();
            GMTrace.o(3054258618368L, 22756);
            return;
          }
          if (bool)
          {
            paramAnonymousString = paramIntent.getStringExtra("Select_Contact");
            ap.yY();
            com.tencent.mm.u.c.wW().Rk(paramAnonymousString);
          }
          GMTrace.o(3054258618368L, 22756);
        }
      }.show();
      GMTrace.o(3021643710464L, 22513);
      return;
      a(paramIntent, this.woF, paramString);
      break;
      if (this.wow)
      {
        if (this.fFo != -1L)
        {
          c(locala);
          paramString = new fn();
          paramString.fKc.fFo = this.fFo;
          paramString.fKc.fKd = locala;
          paramString.fKc.fCZ = this.uRf.uRz;
          com.tencent.mm.sdk.b.a.uql.m(paramString);
        }
        for (;;)
        {
          locala.c(Boolean.valueOf(true));
          break;
          if ((this.msgType == 17) && (this.woC != 0))
          {
            paramString = this.uRf.uRz.getString(R.l.eLA, new Object[] { Integer.valueOf(this.woC) });
            locala.MN(getResources().getString(R.l.dHx) + paramString);
          }
        }
      }
      String str;
      if (this.wox)
      {
        final Object localObject = (HashMap)getIntent().getSerializableExtra("webview_params");
        paramString = (String)((HashMap)localObject).get("img_url");
        str = (String)((HashMap)localObject).get("title");
        localObject = (String)((HashMap)localObject).get("url");
        locala.MN(getResources().getString(R.l.dIM) + str);
        locala.a(new h.a.a()
        {
          public final void auB()
          {
            GMTrace.i(3052782223360L, 22745);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", localObject);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.bb.d.b(SelectConversationUI.this.uRf.uRz, "webview", ".ui.tools.WebViewUI", localIntent);
            GMTrace.o(3052782223360L, 22745);
          }
        });
        locala.MO(paramString).bEN();
        locala.c(Boolean.valueOf(true));
      }
      else if (this.woy)
      {
        a(locala);
      }
      else if (this.woA)
      {
        str = getResources().getString(R.l.dHn);
        paramString = str;
        if (this.kcC != null) {
          paramString = str + this.kcC;
        }
        locala.MN(paramString);
        locala.c(Boolean.valueOf(false));
      }
      else
      {
        b(locala);
        c(locala);
        locala.c(Boolean.valueOf(true));
      }
    }
  }
  
  protected final void Of()
  {
    GMTrace.i(3019898880000L, 22500);
    super.Of();
    this.wov = getIntent().getBooleanExtra("select_is_ret", false);
    this.fromScene = getIntent().getIntExtra("scene_from", 0);
    v.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    if (this.fromScene == 1) {
      this.wow = true;
    }
    for (;;)
    {
      this.woB = getIntent().getBooleanExtra("send_to_biz", false);
      this.fFo = getIntent().getLongExtra("select_fav_local_id", -1L);
      this.woC = getIntent().getIntExtra("select_fav_select_count", 0);
      this.woI = getIntent().getBooleanExtra("mutil_select_is_ret", false);
      this.vXv = getIntent().getBooleanExtra("Select_Send_Card", false);
      this.woD = getIntent().getBooleanExtra("Retr_Big_File", false);
      if (this.vXv) {
        this.woF = getIntent().getStringExtra("Select_Talker_Name");
      }
      this.ipj = getIntent().getIntExtra("Select_Conv_Type", wot);
      this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
      this.fGD = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      ap.yY();
      this.fTa = com.tencent.mm.u.c.wT().cA(this.fGD);
      this.imagePath = getIntent().getStringExtra("image_path");
      this.woN = getIntent().getStringExtra("ad_video_title");
      this.kcC = getIntent().getStringExtra("desc_title");
      this.woM = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.fSi = getIntent().getStringExtra("Retr_Msg_content");
      if ((this.fSi == null) && (this.fTa != null)) {
        this.fSi = this.fTa.field_content;
      }
      this.woL = ((ReportUtil.ReportArgs)getIntent().getParcelableExtra("Select_Report_Args"));
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(com.tencent.mm.ui.contact.s.bYb());
      Object localObject = getIntent().getStringExtra("Select_block_List");
      if (!u.mA((String)localObject)) {
        localHashSet.addAll(u.f(((String)localObject).split(",")));
      }
      if (com.tencent.mm.ui.contact.s.ee(this.ipj, 2))
      {
        localObject = com.tencent.mm.ui.contact.s.bYc();
        com.tencent.mm.ui.contact.s.f((HashSet)localObject);
        localHashSet.addAll((Collection)localObject);
      }
      this.jzO = new ArrayList();
      this.jzO.addAll(localHashSet);
      if (com.tencent.mm.ui.contact.s.ee(this.ipj, 1)) {
        this.vWx = true;
      }
      if (this.woI)
      {
        this.woK = new LinkedList();
        if (this.woI)
        {
          a(1, getString(R.l.dHz), this.woO, l.b.uSj);
          Ol();
        }
      }
      GMTrace.o(3019898880000L, 22500);
      return;
      if (this.fromScene == 2) {
        this.wox = true;
      } else if (this.fromScene == 3) {
        this.woy = true;
      } else if (this.fromScene == 6) {
        this.woz = true;
      } else if (this.fromScene == 7) {
        this.woA = true;
      }
    }
  }
  
  protected final boolean Og()
  {
    GMTrace.i(3022851670016L, 22522);
    GMTrace.o(3022851670016L, 22522);
    return false;
  }
  
  protected final boolean Oh()
  {
    GMTrace.i(3022583234560L, 22520);
    GMTrace.o(3022583234560L, 22520);
    return false;
  }
  
  protected final String Oi()
  {
    GMTrace.i(3022717452288L, 22521);
    String str = getIntent().getStringExtra("Select_Conv_ui_title");
    if ((str == null) || (str.length() <= 0))
    {
      str = getString(R.l.eQn);
      GMTrace.o(3022717452288L, 22521);
      return str;
    }
    GMTrace.o(3022717452288L, 22521);
    return str;
  }
  
  protected final com.tencent.mm.ui.contact.o Oj()
  {
    GMTrace.i(3020033097728L, 22501);
    t localt = new t(this, this.jzO, this.vWx, this.woJ, this.woB, this.ipj);
    GMTrace.o(3020033097728L, 22501);
    return localt;
  }
  
  protected final com.tencent.mm.ui.contact.m Ok()
  {
    GMTrace.i(3020167315456L, 22502);
    q localq = new q(this, this.jzO, this.woJ, this.scene);
    GMTrace.o(3020167315456L, 22502);
    return localq;
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    GMTrace.i(3020301533184L, 22503);
    super.a(paramListView, paramInt);
    if (this.vuO == null) {
      if (!this.vXv) {
        break label124;
      }
    }
    label124:
    for (this.wou = R.l.eQt;; this.wou = R.l.eQk)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3040568410112L, 22654);
          if (SelectConversationUI.a(SelectConversationUI.this))
          {
            SelectConversationUI.b(SelectConversationUI.this);
            GMTrace.o(3040568410112L, 22654);
            return;
          }
          if (SelectConversationUI.c(SelectConversationUI.this))
          {
            SelectConversationUI.d(SelectConversationUI.this);
            GMTrace.o(3040568410112L, 22654);
            return;
          }
          SelectConversationUI.e(SelectConversationUI.this);
          GMTrace.o(3040568410112L, 22654);
        }
      };
      String str = getString(this.wou);
      View localView = r.eC(this).inflate(R.i.dfq, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(R.h.bGw);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.vuO = ((TextView)localObject);
      this.vuO.setVisibility(paramInt);
      GMTrace.o(3020301533184L, 22503);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    GMTrace.i(3022985887744L, 22523);
    if ((parama.vWh) && (parama.jht != null))
    {
      boolean bool = this.woK.contains(parama.jht.field_username);
      GMTrace.o(3022985887744L, 22523);
      return bool;
    }
    GMTrace.o(3022985887744L, 22523);
    return false;
  }
  
  public final int[] aIH()
  {
    GMTrace.i(3023656976384L, 22528);
    int[] arrayOfInt = getIntent().getIntArrayExtra("search_range");
    if (this.fromScene == 4)
    {
      GMTrace.o(3023656976384L, 22528);
      return new int[] { 131072 };
    }
    if (arrayOfInt != null)
    {
      GMTrace.o(3023656976384L, 22528);
      return arrayOfInt;
    }
    arrayOfInt = super.aIH();
    GMTrace.o(3023656976384L, 22528);
    return arrayOfInt;
  }
  
  protected final void aII()
  {
    GMTrace.i(3020435750912L, 22504);
    if (this.fromScene == 5) {
      com.tencent.mm.ui.base.g.a(this, getString(R.l.eyb), null, getString(R.l.send), getString(R.l.cancel), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3016275001344L, 22473);
          paramAnonymousDialogInterface.dismiss();
          GMTrace.o(3016275001344L, 22473);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3033186435072L, 22599);
          SelectConversationUI.f(SelectConversationUI.this);
          SelectConversationUI.this.aGY();
          GMTrace.o(3033186435072L, 22599);
        }
      });
    }
    for (;;)
    {
      if (this.woL != null) {
        ReportUtil.a(this, this.woL);
      }
      GMTrace.o(3020435750912L, 22504);
      return;
      super.aII();
      aGY();
    }
  }
  
  protected final boolean bXV()
  {
    GMTrace.i(3023522758656L, 22527);
    GMTrace.o(3023522758656L, 22527);
    return true;
  }
  
  public final void he(int paramInt)
  {
    GMTrace.i(3020704186368L, 22506);
    int i;
    if (this.woJ)
    {
      i = paramInt - this.oBp.getHeaderViewsCount();
      if (i < 0)
      {
        v.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
        bZU();
        GMTrace.o(3020704186368L, 22506);
        return;
      }
      localObject1 = bXR();
      localObject2 = ((com.tencent.mm.ui.contact.n)localObject1).BG(i);
      if (localObject2 == null)
      {
        GMTrace.o(3020704186368L, 22506);
        return;
      }
      if (((com.tencent.mm.ui.contact.a.a)localObject2).jht == null)
      {
        GMTrace.o(3020704186368L, 22506);
        return;
      }
      localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject2).jht.field_username;
      v.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[] { localObject2 });
      if ((!this.woK.contains(localObject2)) && (lJ(true)))
      {
        bXX();
        GMTrace.o(3020704186368L, 22506);
        return;
      }
      bXX();
      this.nwC.MD((String)localObject2);
      if (this.woK.contains(localObject2)) {
        this.woK.remove(localObject2);
      }
      for (;;)
      {
        Ol();
        ((com.tencent.mm.ui.contact.n)localObject1).notifyDataSetChanged();
        GMTrace.o(3020704186368L, 22506);
        return;
        this.woK.add(localObject2);
      }
    }
    if (paramInt < this.oBp.getHeaderViewsCount())
    {
      v.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      if (this.vXv)
      {
        bZV();
        GMTrace.o(3020704186368L, 22506);
        return;
      }
      bZW();
      GMTrace.o(3020704186368L, 22506);
      return;
    }
    Object localObject1 = (com.tencent.mm.ui.contact.a.a)this.oBp.getAdapter().getItem(paramInt);
    if (localObject1 == null)
    {
      GMTrace.o(3020704186368L, 22506);
      return;
    }
    if (((localObject1 instanceof com.tencent.mm.ui.contact.a.b)) && (((com.tencent.mm.ui.contact.a.b)localObject1).aIO == getResources().getString(R.l.dCA)))
    {
      v.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("list_attr", 16384);
      com.tencent.mm.bb.d.b(this, "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject1, 4);
      this.wox = true;
      GMTrace.o(3020704186368L, 22506);
      return;
    }
    if ((localObject1 instanceof com.tencent.mm.ui.contact.a.f))
    {
      localObject3 = (com.tencent.mm.ui.contact.a.f)localObject1;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("scene", this.scene);
      localObject2 = new ArrayList();
      localObject3 = ((com.tencent.mm.ui.contact.a.f)localObject3).lYu;
      i = localObject3.length;
      paramInt = 0;
      while (paramInt < i)
      {
        ((ArrayList)localObject2).add(localObject3[paramInt]);
        paramInt += 1;
      }
      ((Intent)localObject1).putExtra("query_phrase_list", (Serializable)localObject2);
      com.tencent.mm.bb.d.a(this, ".ui.transmit.MMCreateChatroomUI", (Intent)localObject1, 1);
      GMTrace.o(3020704186368L, 22506);
      return;
    }
    localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).jht;
    if (localObject1 == null)
    {
      GMTrace.o(3020704186368L, 22506);
      return;
    }
    localObject1 = ((af)localObject1).field_username;
    v.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[] { localObject1 });
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("Select_Conv_User", (String)localObject1);
    Object localObject3 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
    if (localObject3 != null) {
      a((Intent)localObject2, (Intent)localObject3);
    }
    for (;;)
    {
      aGY();
      GMTrace.o(3020704186368L, 22506);
      return;
      if ((this.wov) || (this.vXv) || (this.wow) || (this.wox) || (this.woy))
      {
        n((Intent)localObject2, (String)localObject1);
      }
      else
      {
        d(-1, (Intent)localObject2);
        finish();
      }
    }
  }
  
  public final void mK(String paramString)
  {
    GMTrace.i(3023120105472L, 22524);
    this.woK.remove(paramString);
    bXR().notifyDataSetChanged();
    Ol();
    GMTrace.o(3023120105472L, 22524);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    GMTrace.i(3020838404096L, 22507);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      v.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    Object localObject1;
    Object localObject2;
    while (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        v.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
        localObject2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject2 != null)
        {
          a(paramIntent, (Intent)localObject2);
          GMTrace.o(3020838404096L, 22507);
          return;
          v.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
        }
        else
        {
          if ((this.wov) || (this.vXv) || (this.wow) || (this.wox) || (this.woy))
          {
            n(paramIntent, (String)localObject1);
            GMTrace.o(3020838404096L, 22507);
            return;
          }
          d(-1, paramIntent);
          finish();
        }
      }
      else
      {
        GMTrace.o(3020838404096L, 22507);
        return;
      }
    }
    if (paramInt1 == 2)
    {
      switch (paramInt2)
      {
      }
      for (;;)
      {
        GMTrace.o(3020838404096L, 22507);
        return;
        finish();
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("Select_stay_in_wx", false)))
        {
          paramIntent = new Intent(this, TaskRedirectUI.class);
          paramIntent.addFlags(268435456);
          startActivity(paramIntent);
          GMTrace.o(3020838404096L, 22507);
          return;
          if (paramIntent != null) {
            this.woL = ((ReportUtil.ReportArgs)paramIntent.getParcelableExtra("Select_Report_Args"));
          }
        }
      }
    }
    if (paramInt1 == 3)
    {
      switch (paramInt2)
      {
      }
      for (;;)
      {
        GMTrace.o(3020838404096L, 22507);
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("received_card_name");
          if (!bf.mA(paramIntent))
          {
            localObject1 = new com.tencent.mm.pluginsdk.ui.applet.d.a(this.uRf.uRz);
            ((com.tencent.mm.pluginsdk.ui.applet.d.a)localObject1).bs(paramIntent);
            a((com.tencent.mm.pluginsdk.ui.applet.d.a)localObject1, this.woF);
            {
              public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
              {
                GMTrace.i(3019496226816L, 22497);
                SelectConversationUI.this.aGY();
                Intent localIntent;
                if (paramAnonymousBoolean)
                {
                  localIntent = new Intent();
                  if (!paramIntent.endsWith("@chatroom")) {
                    break label92;
                  }
                  SelectConversationUI.c(localIntent, SelectConversationUI.g(SelectConversationUI.this), paramIntent);
                }
                for (;;)
                {
                  localIntent.putExtra("custom_send_text", paramAnonymousString);
                  SelectConversationUI.a(SelectConversationUI.this, localIntent);
                  SelectConversationUI.this.finish();
                  GMTrace.o(3019496226816L, 22497);
                  return;
                  label92:
                  SelectConversationUI.a(SelectConversationUI.this, localIntent, SelectConversationUI.g(SelectConversationUI.this), paramIntent);
                }
              }
            }.show();
          }
        }
      }
    }
    if (paramInt1 == 4)
    {
      if (paramInt2 == -1) {
        n(paramIntent, paramIntent.getStringExtra("Select_Contact"));
      }
      GMTrace.o(3020838404096L, 22507);
      return;
    }
    if (paramInt1 == 5)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        localObject1 = this.woK.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.nwC.ME((String)localObject2);
        }
        if (!u.mA(paramIntent)) {
          this.woK = u.f(paramIntent.split(","));
        }
        for (;;)
        {
          paramIntent = this.woK.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.nwC.aK((String)localObject1, false);
          }
          this.woK.clear();
        }
        Ol();
        bXR().notifyDataSetChanged();
      }
      GMTrace.o(3020838404096L, 22507);
      return;
    }
    v.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = " + paramInt1);
    GMTrace.o(3020838404096L, 22507);
  }
  
  public void onBackPressed()
  {
    GMTrace.i(3020569968640L, 22505);
    super.aII();
    GMTrace.o(3020569968640L, 22505);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3019764662272L, 22499);
    com.tencent.mm.pluginsdk.e.f(this);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Select_App_Id");
    String str = getIntent().getStringExtra("Select_Open_Id");
    v.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + paramBundle + ", openId = " + str);
    if ((!u.mA(paramBundle)) && (!u.mA(str))) {
      new com.tencent.mm.plugin.base.stub.d(this, paramBundle, str, new com.tencent.mm.plugin.base.stub.d.a()
      {
        public final void cP(boolean paramAnonymousBoolean)
        {
          GMTrace.i(3047681949696L, 22707);
          boolean bool = SelectConversationUI.this.isFinishing();
          v.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + paramAnonymousBoolean + ", isFinishing = " + bool);
          if ((!paramAnonymousBoolean) && (!bool)) {
            SelectConversationUI.this.finish();
          }
          GMTrace.o(3047681949696L, 22707);
        }
      }).acB();
    }
    com.tencent.mm.pluginsdk.e.g(this);
    GMTrace.o(3019764662272L, 22499);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/transmit/SelectConversationUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */