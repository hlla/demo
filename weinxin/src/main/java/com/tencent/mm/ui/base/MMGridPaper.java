package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public final class MMGridPaper
  extends LinearLayout
{
  protected View QB;
  protected MMDotView kQr;
  protected int kwB;
  protected int mNumColumns;
  protected ad oNC;
  protected int veT;
  protected int veU;
  protected MMFlipper vhP;
  protected j vhQ;
  protected int vhR;
  protected int vhS;
  protected int vhT;
  protected int vhU;
  protected int vhV;
  protected int vhW;
  protected int vhX;
  protected int vhY;
  protected boolean vhZ;
  final MMFlipper.b vhr;
  final MMFlipper.a vhs;
  protected int vib;
  protected int vic;
  protected int vid;
  protected int vie;
  protected int vif;
  protected boolean vig;
  protected boolean vih;
  protected int vii;
  protected int vij;
  protected int vik;
  protected int vil;
  protected int vim;
  protected boolean vin;
  protected int vio;
  protected int vip;
  
  public MMGridPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3305782640640L, 24630);
    this.vhT = 0;
    this.vhU = 0;
    this.vhV = 3;
    this.vhW = 0;
    this.vhX = (this.vhV - 1);
    this.vhY = 0;
    this.mNumColumns = 0;
    this.kwB = 0;
    this.vhZ = false;
    this.vib = 9;
    this.vic = -1;
    this.vid = -1;
    this.vie = 96;
    this.vif = 96;
    this.veT = 10;
    this.veU = 10;
    this.vig = false;
    this.vih = false;
    this.vii = -1;
    this.vij = -1;
    this.vik = 0;
    this.vil = -1;
    this.vim = -1;
    this.vin = false;
    this.vio = 0;
    this.vip = 0;
    this.vhs = new MMFlipper.a()
    {
      public final void cN(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(3351148232704L, 24968);
        v.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(MMGridPaper.this.vhR), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.vhS), Boolean.valueOf(MMGridPaper.this.vih), Boolean.valueOf(MMGridPaper.this.vig) });
        if (((Math.abs(MMGridPaper.this.vhS - paramAnonymousInt2) < 50) && (Math.abs(MMGridPaper.this.vhR - paramAnonymousInt1) < 50)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          v.d("MicroMsg.MMGridPaper", "match width height limit, return");
          GMTrace.o(3351148232704L, 24968);
          return;
        }
        if ((MMGridPaper.this.vih) && (MMGridPaper.this.vhR > paramAnonymousInt1) && (!MMGridPaper.this.vig))
        {
          v.d("MicroMsg.MMGridPaper", "match ori limit, return");
          GMTrace.o(3351148232704L, 24968);
          return;
        }
        v.v("MicroMsg.MMGridPaper", "onMeasure: match");
        v.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[] { Boolean.valueOf(MMGridPaper.this.vin) });
        MMGridPaper.this.vig = false;
        if (!MMGridPaper.this.vin)
        {
          MMGridPaper.this.vhS = paramAnonymousInt2;
          MMGridPaper.this.vhR = paramAnonymousInt1;
        }
        MMGridPaper.this.refresh();
        GMTrace.o(3351148232704L, 24968);
      }
    };
    this.vhr = new MMFlipper.b()
    {
      public final void sd(final int paramAnonymousInt)
      {
        GMTrace.i(3284710457344L, 24473);
        v.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(MMGridPaper.this.vhW), Integer.valueOf(MMGridPaper.this.vhX), Integer.valueOf(MMGridPaper.this.vhY) });
        if ((paramAnonymousInt <= MMGridPaper.this.vhW) && (MMGridPaper.this.vhW > 0)) {
          MMGridPaper.this.oNC.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(3285381545984L, 24478);
              MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.vhP.getChildAt(MMGridPaper.this.vhP.getChildCount() - 1);
              int i = paramAnonymousInt - (MMGridPaper.this.vhP.getChildCount() >> 1);
              v.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[] { Integer.valueOf(MMGridPaper.this.vhP.getChildCount() - 1), Integer.valueOf(i) });
              MMGridPaper.this.vhP.removeViewAt(MMGridPaper.this.vhP.getChildCount() - 1);
              localMMGridPaperGridView.a(i, MMGridPaper.this.kwB, MMGridPaper.this.mNumColumns, MMGridPaper.this.vhQ);
              MMGridPaper.this.vhP.addView(localMMGridPaperGridView, 0);
              i = MMGridPaper.this.vhP.getChildCount();
              MMGridPaper.this.vhP.Aa(i >> 1);
              MMGridPaper.a(MMGridPaper.this, -1);
              GMTrace.o(3285381545984L, 24478);
            }
          });
        }
        for (;;)
        {
          MMGridPaper.this.vhU = paramAnonymousInt;
          MMGridPaper.this.kQr.zZ(paramAnonymousInt);
          GMTrace.o(3284710457344L, 24473);
          return;
          if ((paramAnonymousInt >= MMGridPaper.this.vhX) && (MMGridPaper.this.vhX < MMGridPaper.this.vhY - 1)) {
            MMGridPaper.this.oNC.post(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(3326317953024L, 24783);
                MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.vhP.getChildAt(0);
                int i = paramAnonymousInt + (MMGridPaper.this.vhP.getChildCount() >> 1);
                v.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", new Object[] { Integer.valueOf(i) });
                MMGridPaper.this.vhP.removeViewAt(0);
                localMMGridPaperGridView.a(i, MMGridPaper.this.kwB, MMGridPaper.this.mNumColumns, MMGridPaper.this.vhQ);
                MMGridPaper.this.vhP.addView(localMMGridPaperGridView);
                i = MMGridPaper.this.vhP.getChildCount();
                MMGridPaper.this.vhP.Aa(i >> 1);
                MMGridPaper.a(MMGridPaper.this, 1);
                GMTrace.o(3326317953024L, 24783);
              }
            });
          }
        }
      }
    };
    this.oNC = new ad(Looper.getMainLooper());
    View.inflate(getContext(), a.h.hdY, this);
    this.vik = bEZ();
    GMTrace.o(3305782640640L, 24630);
  }
  
  private int bEZ()
  {
    GMTrace.i(3307259035648L, 24641);
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {}
    for (int i = 1;; i = 2)
    {
      GMTrace.o(3307259035648L, 24641);
      return i;
    }
  }
  
  private void bFa()
  {
    GMTrace.i(3307527471104L, 24643);
    v.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
    if (this.kQr == null)
    {
      this.kQr = ((MMDotView)findViewById(a.g.hcf));
      MMDotView localMMDotView = this.kQr;
      int i = this.vib;
      v.d("MicroMsg.MMDotView", "setMaxCount:%d", new Object[] { Integer.valueOf(i) });
      localMMDotView.gMK = i;
    }
    if (this.vhP == null)
    {
      this.vhP = ((MMFlipper)findViewById(a.g.hcg));
      this.vhP.vhs = this.vhs;
      this.vhP.vhr = this.vhr;
    }
    bRR();
    bRS();
    GMTrace.o(3307527471104L, 24643);
  }
  
  private void bRR()
  {
    GMTrace.i(3307393253376L, 24642);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((-1 != this.vic) && (bEZ() == 2))
    {
      localView = findViewById(a.g.hce);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.vic);
      if (i != localLayoutParams.height)
      {
        v.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[] { Integer.valueOf(this.vic) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.oNC.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(3336518500352L, 24859);
            v.w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.a(MMGridPaper.this);
            GMTrace.o(3336518500352L, 24859);
          }
        });
      }
      GMTrace.o(3307393253376L, 24642);
      return;
    }
    if ((-1 != this.vid) && (bEZ() == 1))
    {
      localView = findViewById(a.g.hce);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.vid);
      if (i != localLayoutParams.height)
      {
        v.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[] { Integer.valueOf(this.vid) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.oNC.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(3158545793024L, 23533);
            v.w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.a(MMGridPaper.this);
            GMTrace.o(3158545793024L, 23533);
          }
        });
      }
    }
    GMTrace.o(3307393253376L, 24642);
  }
  
  private void bRS()
  {
    GMTrace.i(3307661688832L, 24644);
    v.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[] { Integer.valueOf(this.vhR), Integer.valueOf(this.vhS) });
    if ((this.vhR == 0) || (this.vhS == 0))
    {
      v.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
      GMTrace.o(3307661688832L, 24644);
      return;
    }
    int j = a.fromDPToPix(getContext(), this.vie);
    int i = a.fromDPToPix(getContext(), this.vif);
    j = Math.max(this.vhR / j, 1);
    i = Math.max(this.vhS / i, 1);
    if ((j != this.mNumColumns) || (i != this.kwB)) {
      this.vhZ = true;
    }
    this.mNumColumns = j;
    if (this.vil != -1) {
      this.mNumColumns = Math.min(this.mNumColumns, this.vil);
    }
    this.kwB = i;
    if (this.vim != -1) {
      this.kwB = Math.min(this.kwB, this.vim);
    }
    int m = this.mNumColumns * this.kwB;
    this.vhY = 0;
    boolean bool;
    if (this.vhQ == null)
    {
      i = 0;
      j = i + 0;
      v.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.vih) });
      if (j < 0) {
        break label343;
      }
      bool = true;
      label261:
      Assert.assertTrue(bool);
      if (this.vih)
      {
        k = dW(j, this.mNumColumns);
        i = bEZ();
      }
      switch (i)
      {
      default: 
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label553;
      }
      bRR();
      GMTrace.o(3307661688832L, 24644);
      return;
      i = this.vhQ.getCount();
      break;
      label343:
      bool = false;
      break label261;
      k = Math.min(k, this.vij);
      n = (this.vif + 10) * k + 8;
      v.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(this.vic), Boolean.valueOf(this.vig) });
      if (this.vic != n)
      {
        this.vic = n;
        i = 0;
      }
      else
      {
        i = 1;
        continue;
        k = Math.min(k, this.vii);
        n = (this.vif + 10) * k + 8;
        v.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(this.vid), Boolean.valueOf(this.vig) });
        if (this.vid != n)
        {
          this.vid = n;
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
    label553:
    this.vhY = dW(j, m);
    int n = this.vhY;
    int k = this.vhT;
    MMGridPaperGridView localMMGridPaperGridView;
    if ((k == 0) || (m <= 0))
    {
      v.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      i = 0;
      this.vhU = Math.min(n - 1, i);
      this.vhV = Math.min(3, this.vhY);
      this.vhW = Math.min(this.vhY - this.vhV, Math.max(0, this.vhU - (this.vhV >> 1)));
      this.vhX = (this.vhW + this.vhV - 1);
      v.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[] { Integer.valueOf(this.vie), Integer.valueOf(this.vif), Integer.valueOf(this.kwB), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.vhV), Integer.valueOf(this.vhY), Integer.valueOf(this.vhU), Integer.valueOf(this.vhW), Integer.valueOf(this.vhX) });
      if ((this.vhP.getChildCount() != this.vhV) || (this.vhZ))
      {
        v.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[] { Boolean.valueOf(this.vhZ) });
        this.vhZ = false;
        this.vhP.removeAllViews();
        i = this.vhW;
        while (i <= this.vhX)
        {
          localMMGridPaperGridView = (MMGridPaperGridView)inflate(getContext(), a.h.hdW, null);
          localMMGridPaperGridView.a(i, this.kwB, this.mNumColumns, this.vhQ);
          localMMGridPaperGridView.setHorizontalSpacing(a.fromDPToPix(getContext(), this.veT));
          localMMGridPaperGridView.setVerticalSpacing(a.fromDPToPix(getContext(), this.veU));
          this.vhP.addView(localMMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
          i += 1;
        }
      }
    }
    for (;;)
    {
      if (j >= m)
      {
        j -= m;
        i += 1;
      }
      else
      {
        v.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
        break;
        i = this.vhW;
        if (i <= this.vhX)
        {
          localMMGridPaperGridView = (MMGridPaperGridView)this.vhP.getChildAt(i - this.vhW);
          if (localMMGridPaperGridView.mIndex != i)
          {
            v.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[] { Integer.valueOf(localMMGridPaperGridView.mIndex), Integer.valueOf(i) });
            localMMGridPaperGridView.a(i, this.kwB, this.mNumColumns, this.vhQ);
            if (localMMGridPaperGridView.viz != null) {
              localMMGridPaperGridView.viz.notifyDataSetChanged();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            v.v("MicroMsg.MMGridPaper", "same grid index, continus");
          }
        }
        bRT();
        GMTrace.o(3307661688832L, 24644);
        return;
        j = k;
        i = 0;
      }
    }
  }
  
  private void bRT()
  {
    GMTrace.i(3307930124288L, 24646);
    v.v("MicroMsg.MMGridPaper", "set DotView");
    boolean bool;
    if (this.vhY >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.kQr.zY(this.vhY);
      if ((this.vhQ != null) && (this.vhY > 1)) {
        break label147;
      }
      this.kQr.setVisibility(8);
      v.v("MicroMsg.MMGridPaper", "set DotView gone");
    }
    for (;;)
    {
      if (this.vhU >= this.vhY) {
        this.vhU = (this.vhY - 1);
      }
      this.vhP.Aa(this.vhU - this.vhW);
      this.vhP.Ab(this.vhU);
      this.kQr.zZ(this.vhU);
      GMTrace.o(3307930124288L, 24646);
      return;
      bool = false;
      break;
      label147:
      this.kQr.setVisibility(0);
      v.v("MicroMsg.MMGridPaper", "set DotView visible");
    }
  }
  
  private static int dW(int paramInt1, int paramInt2)
  {
    GMTrace.i(3307795906560L, 24645);
    if (paramInt2 <= 0)
    {
      v.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      GMTrace.o(3307795906560L, 24645);
      return 0;
    }
    for (;;)
    {
      int j;
      int i;
      if (j > 0)
      {
        j -= paramInt2;
        i += 1;
      }
      else
      {
        v.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        GMTrace.o(3307795906560L, 24645);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  public final void Ad(int paramInt)
  {
    GMTrace.i(3306319511552L, 24634);
    this.vil = paramInt;
    GMTrace.o(3306319511552L, 24634);
  }
  
  public final void a(j paramj)
  {
    boolean bool = true;
    GMTrace.i(3306990600192L, 24639);
    this.vhQ = paramj;
    if (paramj == null) {}
    for (;;)
    {
      v.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", new Object[] { Boolean.valueOf(bool) });
      if (this.vhQ != null) {
        this.vhQ.vit = new j.a()
        {
          public final void bRU()
          {
            GMTrace.i(3335847411712L, 24854);
            MMGridPaper.this.refresh();
            GMTrace.o(3335847411712L, 24854);
          }
        };
      }
      bFa();
      GMTrace.o(3306990600192L, 24639);
      return;
      bool = false;
    }
  }
  
  public final void bRK()
  {
    GMTrace.i(3305916858368L, 24631);
    this.vie = 70;
    GMTrace.o(3305916858368L, 24631);
  }
  
  public final void bRL()
  {
    GMTrace.i(3306051076096L, 24632);
    this.vif = 70;
    GMTrace.o(3306051076096L, 24632);
  }
  
  public final void bRM()
  {
    GMTrace.i(3306185293824L, 24633);
    this.vim = 3;
    GMTrace.o(3306185293824L, 24633);
  }
  
  public final void bRN()
  {
    GMTrace.i(3306453729280L, 24635);
    this.vih = true;
    GMTrace.o(3306453729280L, 24635);
  }
  
  public final void bRO()
  {
    GMTrace.i(3306587947008L, 24636);
    this.vij = 3;
    this.vii = 3;
    GMTrace.o(3306587947008L, 24636);
  }
  
  public final void bRP()
  {
    GMTrace.i(3306722164736L, 24637);
    this.veT = 8;
    this.veU = 15;
    GMTrace.o(3306722164736L, 24637);
  }
  
  public final void bRQ()
  {
    GMTrace.i(3306856382464L, 24638);
    this.QB = null;
    ViewGroup localViewGroup = (ViewGroup)findViewById(a.g.hch);
    localViewGroup.removeAllViews();
    if (this.QB != null) {
      localViewGroup.addView(this.QB);
    }
    GMTrace.o(3306856382464L, 24638);
  }
  
  @TargetApi(8)
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(3308198559744L, 24648);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      v.d("MicroMsg.MMGridPaper", "onConfigChanged:" + paramConfiguration.orientation);
      this.vig = true;
    }
    GMTrace.o(3308198559744L, 24648);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(3308064342016L, 24647);
    v.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.vik != bEZ())
    {
      this.vik = bEZ();
      v.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
      this.vig = true;
      clearAnimation();
      bRR();
      bRS();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    GMTrace.o(3308064342016L, 24647);
  }
  
  public final void refresh()
  {
    GMTrace.i(3307124817920L, 24640);
    this.vhT = (this.vhU * this.mNumColumns * this.kwB);
    v.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[] { Integer.valueOf(this.vhU), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.kwB), Integer.valueOf(this.vhT) });
    bFa();
    GMTrace.o(3307124817920L, 24640);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MMGridPaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */