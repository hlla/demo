package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public abstract class MMBaseSelectContactUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, MultiSelectContactView.a, MultiSelectContactView.b, MultiSelectContactView.c, VerticalScrollBar.a, l, p.b
{
  public p kuK;
  public MultiSelectContactView nwC;
  public ListView oBp;
  private View puO;
  public int scene;
  private AlphabetScrollBar vWj;
  private o vWk;
  public m vWl;
  private com.tencent.mm.ui.base.o vWm;
  private View vWn;
  private View vWo;
  private TextView vWp;
  private LabelContainerView vWq;
  private TextView vWr;
  private MMTagPanel vWs;
  private boolean vWt;
  private List<String> vWu;
  
  public MMBaseSelectContactUI()
  {
    GMTrace.i(1795296329728L, 13376);
    this.vWt = true;
    this.vWu = new ArrayList();
    GMTrace.o(1795296329728L, 13376);
  }
  
  private String bXT()
  {
    GMTrace.i(1796370071552L, 13384);
    String str;
    if (this.kuK != null)
    {
      str = this.kuK.bzR();
      GMTrace.o(1796370071552L, 13384);
      return str;
    }
    if (this.nwC != null)
    {
      str = this.nwC.bzR();
      GMTrace.o(1796370071552L, 13384);
      return str;
    }
    GMTrace.o(1796370071552L, 13384);
    return "";
  }
  
  private void bXU()
  {
    GMTrace.i(1796504289280L, 13385);
    boolean bool;
    if (this.kuK != null) {
      bool = this.kuK.bZj();
    }
    while ((bool) && (bf.mA(bXT()))) {
      if ((this.vWu != null) && (this.vWu.size() > 0))
      {
        this.vWq.setVisibility(0);
        this.vWs.a(null, this.vWu);
        GMTrace.o(1796504289280L, 13385);
        return;
        if (this.nwC != null) {
          bool = this.nwC.hasFocus();
        } else {
          bool = false;
        }
      }
      else
      {
        this.vWq.setVisibility(8);
        GMTrace.o(1796504289280L, 13385);
        return;
      }
    }
    if (this.vWq != null) {
      this.vWq.setVisibility(8);
    }
    GMTrace.o(1796504289280L, 13385);
  }
  
  private void bXW()
  {
    GMTrace.i(1799457079296L, 13407);
    v.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
    a(this.oBp, 0);
    this.oBp.setAdapter(this.vWk);
    this.vWk.notifyDataSetChanged();
    if ((Oh()) && (this.vWj != null)) {
      this.vWj.setVisibility(0);
    }
    this.vWo.setVisibility(8);
    GMTrace.o(1799457079296L, 13407);
  }
  
  public void Aa(String paramString)
  {
    GMTrace.i(1800262385664L, 13413);
    v.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[] { paramString });
    GMTrace.o(1800262385664L, 13413);
  }
  
  public void KD()
  {
    GMTrace.i(1795967418368L, 13381);
    qL(Oi());
    this.oBp = ((ListView)findViewById(R.h.cBE));
    this.vWk = Oj();
    this.vWl = Ok();
    this.puO = findViewById(R.h.cDp);
    if (bXZ())
    {
      this.vWo = findViewById(R.h.coh);
      this.vWp = ((TextView)findViewById(R.h.cog));
      this.vWo.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(1748051689472L, 13024);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
          MMBaseSelectContactUI.this.bXX();
          MMBaseSelectContactUI.this.bXY();
          GMTrace.o(1748051689472L, 13024);
          return false;
        }
      });
      if (!Og()) {
        break label380;
      }
      this.kuK = new p(true, true);
      this.kuK.wlY = this;
      a(this.kuK);
    }
    for (;;)
    {
      a(this.oBp, 0);
      this.oBp.setAdapter(this.vWk);
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(1777445371904L, 13243);
          MMBaseSelectContactUI.this.aII();
          GMTrace.o(1777445371904L, 13243);
          return true;
        }
      });
      if (this.vWl != null) {
        this.vWl.a(new m.a()
        {
          public final void r(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
          {
            GMTrace.i(1748722778112L, 13029);
            v.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if ((paramAnonymousBoolean) && (paramAnonymousInt == 0))
            {
              if (!bf.mA(paramAnonymousString))
              {
                MMBaseSelectContactUI.b(MMBaseSelectContactUI.this);
                GMTrace.o(1748722778112L, 13029);
                return;
              }
              MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
              GMTrace.o(1748722778112L, 13029);
              return;
            }
            MMBaseSelectContactUI.c(MMBaseSelectContactUI.this);
            GMTrace.o(1748722778112L, 13029);
          }
        });
      }
      this.oBp.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(1829521850368L, 13631);
          if ((!MMBaseSelectContactUI.this.Og()) && (MMBaseSelectContactUI.d(MMBaseSelectContactUI.this) != null))
          {
            paramAnonymousAbsListView = MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).getChildAt(MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).getFirstVisiblePosition());
            if ((paramAnonymousAbsListView == null) || (paramAnonymousAbsListView.getTop() != 0)) {
              break label88;
            }
            MMBaseSelectContactUI.f(MMBaseSelectContactUI.this).setVisibility(8);
          }
          while (paramAnonymousInt1 < 2)
          {
            GMTrace.o(1829521850368L, 13631);
            return;
            label88:
            MMBaseSelectContactUI.f(MMBaseSelectContactUI.this).setVisibility(0);
          }
          ap.yY();
          if (!bf.f((Boolean)c.vr().get(12296, null)))
          {
            ap.yY();
            c.vr().set(12296, Boolean.valueOf(true));
            if (MMBaseSelectContactUI.g(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.g(MMBaseSelectContactUI.this).dismiss();
            }
            MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, s.a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.getString(R.l.ezh), 4000L));
          }
          GMTrace.o(1829521850368L, 13631);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          GMTrace.i(1829387632640L, 13630);
          if (paramAnonymousInt != 0)
          {
            MMBaseSelectContactUI.this.aGY();
            MMBaseSelectContactUI.this.bXY();
          }
          GMTrace.o(1829387632640L, 13630);
        }
      });
      this.oBp.setOnItemClickListener(this);
      if (Oh())
      {
        this.vWj = ((AlphabetScrollBar)findViewById(R.h.cBG));
        this.vWj.setVisibility(0);
        this.vWj.voh = this;
      }
      if (aJK())
      {
        this.vWq = ((LabelContainerView)findViewById(R.h.cBD));
        this.vWr = ((TextView)this.vWq.findViewById(16908310));
        this.vWr.setText(R.l.evy);
        this.vWs = ((MMTagPanel)this.vWq.findViewById(R.h.bFN));
        this.vWs.mTf = R.g.bkq;
        this.vWs.mTg = R.e.aVo;
        this.vWq.vWe = new LabelContainerView.a()
        {
          public final void aoA()
          {
            GMTrace.i(1706444193792L, 12714);
            if (MMBaseSelectContactUI.d(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).clearFocus();
            }
            if (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null)
            {
              MMBaseSelectContactUI.h(MMBaseSelectContactUI.this).clearFocus();
              MMBaseSelectContactUI.h(MMBaseSelectContactUI.this).bZF();
            }
            MMBaseSelectContactUI.i(MMBaseSelectContactUI.this).requestFocus();
            MMBaseSelectContactUI.i(MMBaseSelectContactUI.this).setVisibility(8);
            GMTrace.o(1706444193792L, 12714);
          }
          
          public final void aoB()
          {
            GMTrace.i(1706578411520L, 12715);
            MMBaseSelectContactUI.this.aGY();
            GMTrace.o(1706578411520L, 12715);
          }
        };
        this.vWs.vkU = new MMTagPanel.a()
        {
          public final void aoC()
          {
            GMTrace.i(1787645919232L, 13319);
            GMTrace.o(1787645919232L, 13319);
          }
          
          public final void h(boolean paramAnonymousBoolean, int paramAnonymousInt)
          {
            GMTrace.i(1787511701504L, 13318);
            GMTrace.o(1787511701504L, 13318);
          }
          
          public final void uI(String paramAnonymousString)
          {
            GMTrace.i(1787109048320L, 13315);
            GMTrace.o(1787109048320L, 13315);
          }
          
          public final void uJ(String paramAnonymousString)
          {
            GMTrace.i(1787243266048L, 13316);
            MMBaseSelectContactUI.this.Aa(paramAnonymousString);
            GMTrace.o(1787243266048L, 13316);
          }
          
          public final void uK(String paramAnonymousString)
          {
            GMTrace.i(1787377483776L, 13317);
            GMTrace.o(1787377483776L, 13317);
          }
          
          public final void uL(String paramAnonymousString)
          {
            GMTrace.i(1787780136960L, 13320);
            GMTrace.o(1787780136960L, 13320);
          }
          
          public final void uM(String paramAnonymousString)
          {
            GMTrace.i(1787914354688L, 13321);
            GMTrace.o(1787914354688L, 13321);
          }
        };
      }
      GMTrace.o(1795967418368L, 13381);
      return;
      label380:
      this.nwC = ((MultiSelectContactView)findViewById(R.h.bFO));
      this.nwC.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
      this.nwC.sHS = this;
      this.nwC.sHT = this;
      this.nwC.sHR = this;
      this.nwC.setVisibility(0);
      this.vWn = new View(this.uRf.uRz);
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, this.nwC.getMeasuredHeight());
      this.vWn.setLayoutParams(localLayoutParams);
      this.vWn.setVisibility(4);
      this.oBp.addHeaderView(this.vWn);
      findViewById(R.h.cqu).setVisibility(0);
    }
  }
  
  public final void OE()
  {
    GMTrace.i(1799188643840L, 13405);
    bXW();
    if (aJK()) {
      bXU();
    }
    GMTrace.o(1799188643840L, 13405);
  }
  
  public final void OF()
  {
    GMTrace.i(1799322861568L, 13406);
    GMTrace.o(1799322861568L, 13406);
  }
  
  public final void OG()
  {
    GMTrace.i(1800665038848L, 13416);
    GMTrace.o(1800665038848L, 13416);
  }
  
  public final void OH()
  {
    GMTrace.i(16857880854528L, 125601);
    GMTrace.o(16857880854528L, 125601);
  }
  
  public void Of()
  {
    GMTrace.i(1795833200640L, 13380);
    this.scene = getIntent().getIntExtra("scene", 0);
    GMTrace.o(1795833200640L, 13380);
  }
  
  public abstract boolean Og();
  
  public abstract boolean Oh();
  
  public abstract String Oi();
  
  public abstract o Oj();
  
  public abstract m Ok();
  
  public void a(ListView paramListView, int paramInt)
  {
    GMTrace.i(1797578031104L, 13393);
    GMTrace.o(1797578031104L, 13393);
  }
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    GMTrace.i(1799859732480L, 13410);
    GMTrace.o(1799859732480L, 13410);
    return false;
  }
  
  public int[] aIH()
  {
    GMTrace.i(1797443813376L, 13392);
    GMTrace.o(1797443813376L, 13392);
    return new int[] { 131072, 131075 };
  }
  
  public void aII()
  {
    GMTrace.i(1797712248832L, 13394);
    aGY();
    finish();
    GMTrace.o(1797712248832L, 13394);
  }
  
  public boolean aJK()
  {
    GMTrace.i(1800128167936L, 13412);
    GMTrace.o(1800128167936L, 13412);
    return false;
  }
  
  public boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    GMTrace.i(1799725514752L, 13409);
    GMTrace.o(1799725514752L, 13409);
    return false;
  }
  
  public final void bEj()
  {
    GMTrace.i(1797309595648L, 13391);
    if (aJK()) {
      bXU();
    }
    GMTrace.o(1797309595648L, 13391);
  }
  
  public final n bXR()
  {
    GMTrace.i(1795564765184L, 13378);
    if (this.oBp.getHeaderViewsCount() > 0)
    {
      localn = (n)((HeaderViewListAdapter)this.oBp.getAdapter()).getWrappedAdapter();
      GMTrace.o(1795564765184L, 13378);
      return localn;
    }
    n localn = (n)this.oBp.getAdapter();
    GMTrace.o(1795564765184L, 13378);
    return localn;
  }
  
  public o bXS()
  {
    GMTrace.i(17927193493504L, 133568);
    o localo = this.vWk;
    GMTrace.o(17927193493504L, 133568);
    return localo;
  }
  
  public boolean bXV()
  {
    GMTrace.i(1799054426112L, 13404);
    GMTrace.o(1799054426112L, 13404);
    return false;
  }
  
  public final void bXX()
  {
    GMTrace.i(1800396603392L, 13414);
    if (this.kuK != null)
    {
      if (!bf.mA(this.kuK.bzR()))
      {
        p localp = this.kuK;
        if (localp.wlX != null) {
          localp.wlX.lE(true);
        }
        GMTrace.o(1800396603392L, 13414);
      }
    }
    else if ((this.nwC != null) && (!bf.mA(this.nwC.bzR()))) {
      this.nwC.sHN.setText("");
    }
    GMTrace.o(1800396603392L, 13414);
  }
  
  public final void bXY()
  {
    GMTrace.i(1800530821120L, 13415);
    if (this.kuK != null)
    {
      if (this.kuK.bZj())
      {
        this.kuK.clearFocus();
        GMTrace.o(1800530821120L, 13415);
      }
    }
    else if ((this.nwC != null) && (this.nwC.hasFocus())) {
      this.nwC.clearFocus();
    }
    GMTrace.o(1800530821120L, 13415);
  }
  
  public boolean bXZ()
  {
    GMTrace.i(1800933474304L, 13418);
    if (this.vWl != null)
    {
      GMTrace.o(1800933474304L, 13418);
      return true;
    }
    GMTrace.o(1800933474304L, 13418);
    return false;
  }
  
  public final ListView bcP()
  {
    GMTrace.i(15328335626240L, 114205);
    ListView localListView = this.oBp;
    GMTrace.o(15328335626240L, 114205);
    return localListView;
  }
  
  public final Activity getActivity()
  {
    GMTrace.i(1799993950208L, 13411);
    GMTrace.o(1799993950208L, 13411);
    return this;
  }
  
  public int getLayoutId()
  {
    GMTrace.i(1797041160192L, 13389);
    int i = R.i.djh;
    GMTrace.o(1797041160192L, 13389);
    return i;
  }
  
  public void he(int paramInt)
  {
    GMTrace.i(1796235853824L, 13383);
    GMTrace.o(1796235853824L, 13383);
  }
  
  public void mK(String paramString)
  {
    GMTrace.i(1799591297024L, 13408);
    GMTrace.o(1799591297024L, 13408);
  }
  
  public final boolean mQ(String paramString)
  {
    GMTrace.i(1798785990656L, 13402);
    GMTrace.o(1798785990656L, 13402);
    return false;
  }
  
  public final void mR(String paramString)
  {
    GMTrace.i(1798920208384L, 13403);
    v.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[] { paramString });
    if (aJK())
    {
      if (this.kuK != null) {
        this.kuK.bZk();
      }
      bXU();
    }
    if (!bf.mA(paramString))
    {
      this.vWl.a(paramString, aIH(), bXV());
      GMTrace.o(1798920208384L, 13403);
      return;
    }
    this.vWl.QZ();
    this.vWl.notifyDataSetChanged();
    bXW();
    GMTrace.o(1798920208384L, 13403);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1795430547456L, 13377);
    super.onCreate(paramBundle);
    v.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
    if (!ap.zb())
    {
      v.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
      v.bIG();
      finish();
      GMTrace.o(1795430547456L, 13377);
      return;
    }
    Of();
    v.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
    KD();
    v.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
    GMTrace.o(1795430547456L, 13377);
  }
  
  public void onDestroy()
  {
    GMTrace.i(1796906942464L, 13388);
    super.onDestroy();
    if (this.vWj != null) {
      this.vWj.voh = null;
    }
    if (this.vWk != null) {
      this.vWk.finish();
    }
    if (this.vWl != null) {
      this.vWl.finish();
    }
    if (this.vWm != null) {
      this.vWm.dismiss();
    }
    GMTrace.o(1796906942464L, 13388);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GMTrace.i(1796101636096L, 13382);
    int i = paramInt - this.oBp.getHeaderViewsCount();
    int j;
    if (i >= 0)
    {
      paramAdapterView = bXR().BG(i);
      paramAdapterView.Oc().Oe();
      if (paramAdapterView.vYm)
      {
        j = com.tencent.mm.as.g.f(paramAdapterView.mbx, paramAdapterView.mby, paramAdapterView.axZ());
        switch (paramAdapterView.mbx)
        {
        default: 
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (paramAdapterView.vYl) {
        i = 1;
      }
      if (paramAdapterView.klJ == 5) {
        i = 7;
      }
      paramAdapterView = String.format("%s,%d,%d,%d,%d", new Object[] { paramAdapterView.fRC, Integer.valueOf(paramAdapterView.scene), Integer.valueOf(i), Integer.valueOf(paramAdapterView.mbs), Integer.valueOf(j) });
      v.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramAdapterView });
      com.tencent.mm.plugin.report.service.g.oSF.A(13234, paramAdapterView);
      if (!bXR().BH(paramInt)) {
        he(paramInt);
      }
      GMTrace.o(1796101636096L, 13382);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(1797846466560L, 13395);
    if (paramKeyEvent.getKeyCode() == 4) {
      aII();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(1797846466560L, 13395);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(1796638507008L, 13386);
    super.onPause();
    if (this.vWm != null) {
      this.vWm.dismiss();
    }
    GMTrace.o(1796638507008L, 13386);
  }
  
  protected void onResume()
  {
    GMTrace.i(1796772724736L, 13387);
    super.onResume();
    if ((aJK()) && (this.vWt))
    {
      this.vWt = false;
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1706846846976L, 12717);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, com.tencent.mm.plugin.label.a.a.aFz().aFu());
          MMBaseSelectContactUI.j(MMBaseSelectContactUI.this);
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(1786572177408L, 13311);
              MMBaseSelectContactUI.k(MMBaseSelectContactUI.this);
              GMTrace.o(1786572177408L, 13311);
            }
          });
          GMTrace.o(1706846846976L, 12717);
        }
        
        public final String toString()
        {
          GMTrace.i(1706981064704L, 12718);
          String str = super.toString() + "|updateLabelList";
          GMTrace.o(1706981064704L, 12718);
          return str;
        }
      });
    }
    GMTrace.o(1796772724736L, 13387);
  }
  
  public final void rZ(String paramString)
  {
    GMTrace.i(1797980684288L, 13396);
    if (this.vWk != null)
    {
      int i = this.vWk.TL(paramString);
      if (i == 0)
      {
        this.oBp.setSelection(0);
        GMTrace.o(1797980684288L, 13396);
        return;
      }
      if (i > 0)
      {
        if (Og())
        {
          this.oBp.setSelection(i);
          GMTrace.o(1797980684288L, 13396);
          return;
        }
        if (this.nwC != null)
        {
          this.oBp.setSelectionFromTop(i, this.nwC.getMeasuredHeight());
          GMTrace.o(1797980684288L, 13396);
        }
      }
      else
      {
        v.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[] { Integer.valueOf(i), paramString });
      }
    }
    GMTrace.o(1797980684288L, 13396);
  }
  
  public final void zC(String paramString)
  {
    GMTrace.i(1797175377920L, 13390);
    v.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[] { paramString });
    if (aJK()) {
      bXU();
    }
    if (this.vWl != null)
    {
      if (!bf.mA(paramString))
      {
        this.vWl.a(paramString, aIH(), bXV());
        GMTrace.o(1797175377920L, 13390);
        return;
      }
      this.vWl.QZ();
      this.vWl.notifyDataSetChanged();
      bXW();
    }
    GMTrace.o(1797175377920L, 13390);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/MMBaseSelectContactUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */