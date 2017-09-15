package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.is;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.s;

public class LauncherUIBottomTabView
  extends RelativeLayout
  implements c
{
  protected int lxv;
  private long mBI;
  private int uQA;
  private boolean uQB;
  private int uQC;
  private boolean uQD;
  private c.a uQe;
  protected a uQf;
  protected a uQg;
  protected a uQh;
  protected a uQi;
  private int uQj;
  private int uQk;
  private int uQl;
  private int uQm;
  private int uQn;
  private int uQo;
  private int uQp;
  private int uQq;
  private int uQr;
  private int uQs;
  private int uQt;
  private int uQu;
  private int uQv;
  protected View.OnClickListener uQw;
  private ad uQx;
  private int uQy;
  private int uQz;
  
  public LauncherUIBottomTabView(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(1877437579264L, 13988);
    this.lxv = 0;
    this.uQj = 0;
    this.uQn = 0;
    this.mBI = 0L;
    this.uQu = -1;
    this.uQv = 0;
    this.uQw = new View.OnClickListener()
    {
      private final long qpq;
      
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1604841373696L, 11957);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          v.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.uql.m(new is());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          GMTrace.o(1604841373696L, 11957);
          return;
        }
        if (LauncherUIBottomTabView.d(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            v.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).lG(i);
            GMTrace.o(1604841373696L, 11957);
            return;
          }
          v.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        v.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        GMTrace.o(1604841373696L, 11957);
      }
    };
    this.uQx = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(3093315977216L, 23047);
        v.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).lG(0);
        GMTrace.o(3093315977216L, 23047);
      }
    };
    this.uQy = 0;
    this.uQz = 0;
    this.uQA = 0;
    this.uQB = false;
    this.uQC = 0;
    this.uQD = false;
    init();
    GMTrace.o(1877437579264L, 13988);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1877571796992L, 13989);
    this.lxv = 0;
    this.uQj = 0;
    this.uQn = 0;
    this.mBI = 0L;
    this.uQu = -1;
    this.uQv = 0;
    this.uQw = new View.OnClickListener()
    {
      private final long qpq;
      
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1604841373696L, 11957);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          v.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.uql.m(new is());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          GMTrace.o(1604841373696L, 11957);
          return;
        }
        if (LauncherUIBottomTabView.d(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            v.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).lG(i);
            GMTrace.o(1604841373696L, 11957);
            return;
          }
          v.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        v.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        GMTrace.o(1604841373696L, 11957);
      }
    };
    this.uQx = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(3093315977216L, 23047);
        v.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).lG(0);
        GMTrace.o(3093315977216L, 23047);
      }
    };
    this.uQy = 0;
    this.uQz = 0;
    this.uQA = 0;
    this.uQB = false;
    this.uQC = 0;
    this.uQD = false;
    init();
    GMTrace.o(1877571796992L, 13989);
  }
  
  public LauncherUIBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1877706014720L, 13990);
    this.lxv = 0;
    this.uQj = 0;
    this.uQn = 0;
    this.mBI = 0L;
    this.uQu = -1;
    this.uQv = 0;
    this.uQw = new View.OnClickListener()
    {
      private final long qpq;
      
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1604841373696L, 11957);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if ((LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(LauncherUIBottomTabView.this) <= 300L))
        {
          v.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).removeMessages(0);
          com.tencent.mm.sdk.b.a.uql.m(new is());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
          LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
          GMTrace.o(1604841373696L, 11957);
          return;
        }
        if (LauncherUIBottomTabView.d(LauncherUIBottomTabView.this) != null)
        {
          if ((i != 0) || (LauncherUIBottomTabView.a(LauncherUIBottomTabView.this) != 0))
          {
            v.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
            LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
            LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).lG(i);
            GMTrace.o(1604841373696L, 11957);
            return;
          }
          v.v("MicroMsg.LauncherUITabView", "do double click check");
          LauncherUIBottomTabView.c(LauncherUIBottomTabView.this).sendEmptyMessageDelayed(0, 300L);
        }
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, System.currentTimeMillis());
        LauncherUIBottomTabView.a(LauncherUIBottomTabView.this, i);
        v.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramAnonymousView.getTag() });
        GMTrace.o(1604841373696L, 11957);
      }
    };
    this.uQx = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(3093315977216L, 23047);
        v.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.d(LauncherUIBottomTabView.this).lG(0);
        GMTrace.o(3093315977216L, 23047);
      }
    };
    this.uQy = 0;
    this.uQz = 0;
    this.uQA = 0;
    this.uQB = false;
    this.uQC = 0;
    this.uQD = false;
    init();
    GMTrace.o(1877706014720L, 13990);
  }
  
  private a a(int paramInt, ViewGroup paramViewGroup)
  {
    GMTrace.i(1877974450176L, 13992);
    a locala = new a();
    locala.uQF = r.eC(getContext()).inflate(R.i.din, paramViewGroup, false);
    if (com.tencent.mm.bg.a.dM(getContext())) {}
    for (locala.uQF = r.eC(getContext()).inflate(R.i.dio, paramViewGroup, false);; locala.uQF = r.eC(getContext()).inflate(R.i.din, paramViewGroup, false))
    {
      locala.uQG = ((TabIconView)locala.uQF.findViewById(R.h.bWq));
      locala.uQH = ((TextView)locala.uQF.findViewById(R.h.bWs));
      locala.uQI = ((TextView)locala.uQF.findViewById(R.h.cKB));
      locala.uQI.setBackgroundResource(s.fg(getContext()));
      locala.uQJ = ((ImageView)locala.uQF.findViewById(R.h.bJO));
      locala.uQF.setTag(Integer.valueOf(paramInt));
      locala.uQF.setOnClickListener(this.uQw);
      float f1 = com.tencent.mm.bg.a.U(getContext(), R.f.aXV);
      float f2 = com.tencent.mm.bg.a.dK(getContext());
      locala.uQH.setTextSize(0, f1 * f2);
      GMTrace.o(1877974450176L, 13992);
      return locala;
    }
  }
  
  private void init()
  {
    GMTrace.i(1878108667904L, 13993);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(0);
    addView(localLinearLayout, new RelativeLayout.LayoutParams(-1, -2));
    this.uQv = ((int)(com.tencent.mm.bg.a.U(getContext(), R.f.aWS) * com.tencent.mm.bg.a.dK(getContext())));
    a locala = a(0, localLinearLayout);
    locala.uQF.setId(-16777215);
    locala.uQH.setText(R.l.cgP);
    locala.uQH.setTextColor(getResources().getColor(R.e.aVh));
    locala.uQG.g(R.k.dxJ, R.k.dxK, R.k.dxL, com.tencent.mm.bg.a.dM(getContext()));
    locala.uQI.setVisibility(4);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.uQv);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(locala.uQF, localLayoutParams);
    this.uQf = locala;
    locala = a(1, localLinearLayout);
    locala.uQF.setId(-16777214);
    locala.uQH.setText(R.l.eyH);
    locala.uQH.setTextColor(getResources().getColor(R.e.aVi));
    locala.uQG.g(R.k.dxG, R.k.dxH, R.k.dxI, com.tencent.mm.bg.a.dM(getContext()));
    locala.uQI.setVisibility(4);
    localLayoutParams = new LinearLayout.LayoutParams(0, this.uQv);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(locala.uQF, localLayoutParams);
    this.uQh = locala;
    locala = a(2, localLinearLayout);
    locala.uQF.setId(-16777213);
    locala.uQH.setText(R.l.eyF);
    locala.uQH.setTextColor(getResources().getColor(R.e.aVi));
    locala.uQG.g(R.k.dxM, R.k.dxN, R.k.dxO, com.tencent.mm.bg.a.dM(getContext()));
    locala.uQI.setVisibility(4);
    localLayoutParams = new LinearLayout.LayoutParams(0, this.uQv);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(locala.uQF, localLayoutParams);
    this.uQg = locala;
    locala = a(3, localLinearLayout);
    locala.uQF.setId(-16777212);
    locala.uQH.setText(R.l.ezf);
    locala.uQH.setTextColor(getResources().getColor(R.e.aVi));
    locala.uQG.g(R.k.dxP, R.k.dxQ, R.k.dxR, com.tencent.mm.bg.a.dM(getContext()));
    locala.uQI.setVisibility(4);
    localLayoutParams = new LinearLayout.LayoutParams(0, this.uQv);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(locala.uQF, localLayoutParams);
    this.uQi = locala;
    this.uQj = getResources().getColor(R.e.aVh);
    this.uQk = ((this.uQj & 0xFF0000) >> 16);
    this.uQl = ((this.uQj & 0xFF00) >> 8);
    this.uQm = (this.uQj & 0xFF);
    this.uQn = getResources().getColor(R.e.aVi);
    this.uQo = ((this.uQn & 0xFF0000) >> 16);
    this.uQp = ((this.uQn & 0xFF00) >> 8);
    this.uQq = (this.uQn & 0xFF);
    this.uQr = (this.uQk - this.uQo);
    this.uQs = (this.uQl - this.uQp);
    this.uQt = (this.uQm - this.uQq);
    GMTrace.o(1878108667904L, 13993);
  }
  
  public final void a(c.a parama)
  {
    GMTrace.i(1877840232448L, 13991);
    this.uQe = parama;
    GMTrace.o(1877840232448L, 13991);
  }
  
  public final void bOo()
  {
    GMTrace.i(1878377103360L, 13995);
    if ((this.uQf == null) || (this.uQh == null) || (this.uQg == null))
    {
      GMTrace.o(1878377103360L, 13995);
      return;
    }
    GMTrace.o(1878377103360L, 13995);
  }
  
  public final int bOp()
  {
    GMTrace.i(1879585062912L, 14004);
    int i = this.uQy;
    GMTrace.o(1879585062912L, 14004);
    return i;
  }
  
  public final int bOq()
  {
    GMTrace.i(1879719280640L, 14005);
    int i = this.uQz;
    GMTrace.o(1879719280640L, 14005);
    return i;
  }
  
  public final int bOr()
  {
    GMTrace.i(1879853498368L, 14006);
    int i = this.uQA;
    GMTrace.o(1879853498368L, 14006);
    return i;
  }
  
  public final int bOs()
  {
    GMTrace.i(1879987716096L, 14007);
    int i = this.uQC;
    GMTrace.o(1879987716096L, 14007);
    return i;
  }
  
  public final boolean bOt()
  {
    GMTrace.i(1880121933824L, 14008);
    boolean bool = this.uQB;
    GMTrace.o(1880121933824L, 14008);
    return bool;
  }
  
  public final boolean bOu()
  {
    GMTrace.i(1880256151552L, 14009);
    boolean bool = this.uQD;
    GMTrace.o(1880256151552L, 14009);
    return bool;
  }
  
  public final int bOv()
  {
    GMTrace.i(1879316627456L, 14002);
    int i = this.lxv;
    GMTrace.o(1879316627456L, 14002);
    return i;
  }
  
  public final void i(int paramInt, float paramFloat)
  {
    GMTrace.i(1879182409728L, 14001);
    int i = (int)(255.0F * paramFloat);
    int j = 255 - i;
    int k = ((int)(this.uQr * paramFloat + this.uQo) << 16) + ((int)(this.uQs * paramFloat + this.uQp) << 8) + (int)(this.uQt * paramFloat + this.uQq) - 16777216;
    int m = ((int)(this.uQr * (1.0F - paramFloat) + this.uQo) << 16) + ((int)(this.uQs * (1.0F - paramFloat) + this.uQp) << 8) + (int)(this.uQt * (1.0F - paramFloat) + this.uQq) - 16777216;
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(1879182409728L, 14001);
      return;
      this.uQf.uQG.zt(j);
      this.uQh.uQG.zt(i);
      this.uQf.uQH.setTextColor(m);
      this.uQh.uQH.setTextColor(k);
      GMTrace.o(1879182409728L, 14001);
      return;
      this.uQh.uQG.zt(j);
      this.uQg.uQG.zt(i);
      this.uQh.uQH.setTextColor(m);
      this.uQg.uQH.setTextColor(k);
      GMTrace.o(1879182409728L, 14001);
      return;
      this.uQg.uQG.zt(j);
      this.uQi.uQG.zt(i);
      this.uQg.uQH.setTextColor(m);
      this.uQi.uQH.setTextColor(k);
    }
  }
  
  public final void kb(boolean paramBoolean)
  {
    int i = 4;
    GMTrace.i(1878779756544L, 13998);
    this.uQB = paramBoolean;
    this.uQg.uQI.setVisibility(4);
    ImageView localImageView = this.uQg.uQJ;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
    GMTrace.o(1878779756544L, 13998);
  }
  
  public final void kc(boolean paramBoolean)
  {
    int i = 4;
    GMTrace.i(1879048192000L, 14000);
    this.uQD = paramBoolean;
    this.uQi.uQI.setVisibility(4);
    ImageView localImageView = this.uQi.uQJ;
    if (paramBoolean) {
      i = 0;
    }
    localImageView.setVisibility(i);
    GMTrace.o(1879048192000L, 14000);
  }
  
  public final void lF(int paramInt)
  {
    GMTrace.i(1879450845184L, 14003);
    this.lxv = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.mBI = System.currentTimeMillis();
      this.uQu = this.lxv;
      GMTrace.o(1879450845184L, 14003);
      return;
      this.uQf.uQG.zt(255);
      this.uQg.uQG.zt(0);
      this.uQh.uQG.zt(0);
      this.uQi.uQG.zt(0);
      this.uQf.uQH.setTextColor(this.uQj);
      this.uQg.uQH.setTextColor(this.uQn);
      this.uQh.uQH.setTextColor(this.uQn);
      this.uQi.uQH.setTextColor(this.uQn);
      continue;
      this.uQf.uQG.zt(0);
      this.uQg.uQG.zt(255);
      this.uQh.uQG.zt(0);
      this.uQi.uQG.zt(0);
      this.uQf.uQH.setTextColor(this.uQn);
      this.uQg.uQH.setTextColor(this.uQj);
      this.uQh.uQH.setTextColor(this.uQn);
      this.uQi.uQH.setTextColor(this.uQn);
      continue;
      this.uQf.uQG.zt(0);
      this.uQg.uQG.zt(0);
      this.uQh.uQG.zt(255);
      this.uQi.uQG.zt(0);
      this.uQf.uQH.setTextColor(this.uQn);
      this.uQg.uQH.setTextColor(this.uQn);
      this.uQh.uQH.setTextColor(this.uQj);
      this.uQi.uQH.setTextColor(this.uQn);
      continue;
      this.uQf.uQG.zt(0);
      this.uQg.uQG.zt(0);
      this.uQh.uQG.zt(0);
      this.uQi.uQG.zt(255);
      this.uQf.uQH.setTextColor(this.uQn);
      this.uQg.uQH.setTextColor(this.uQn);
      this.uQh.uQH.setTextColor(this.uQn);
      this.uQi.uQH.setTextColor(this.uQj);
    }
  }
  
  public final void yQ(int paramInt)
  {
    GMTrace.i(1878242885632L, 13994);
    v.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[] { Integer.valueOf(paramInt) });
    this.uQy = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uQf.uQI.setText(getContext().getString(R.l.eYH));
        this.uQf.uQI.setVisibility(0);
        this.uQf.uQJ.setVisibility(4);
        GMTrace.o(1878242885632L, 13994);
        return;
      }
      this.uQf.uQI.setText(String.valueOf(paramInt));
      this.uQf.uQI.setVisibility(0);
      this.uQf.uQJ.setVisibility(4);
      GMTrace.o(1878242885632L, 13994);
      return;
    }
    this.uQf.uQI.setText("");
    this.uQf.uQI.setVisibility(4);
    GMTrace.o(1878242885632L, 13994);
  }
  
  public final void yR(int paramInt)
  {
    GMTrace.i(1878511321088L, 13996);
    this.uQz = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uQh.uQI.setText(getContext().getString(R.l.eYH));
        this.uQh.uQI.setVisibility(0);
        this.uQh.uQJ.setVisibility(4);
        GMTrace.o(1878511321088L, 13996);
        return;
      }
      this.uQh.uQI.setText(String.valueOf(paramInt));
      this.uQh.uQI.setVisibility(0);
      this.uQh.uQJ.setVisibility(4);
      GMTrace.o(1878511321088L, 13996);
      return;
    }
    this.uQh.uQI.setText("");
    this.uQh.uQI.setVisibility(4);
    GMTrace.o(1878511321088L, 13996);
  }
  
  public final void yS(int paramInt)
  {
    GMTrace.i(1878645538816L, 13997);
    this.uQA = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uQg.uQI.setText(getContext().getString(R.l.eYH));
        this.uQg.uQI.setVisibility(0);
        this.uQg.uQJ.setVisibility(4);
        GMTrace.o(1878645538816L, 13997);
        return;
      }
      this.uQg.uQI.setText(String.valueOf(paramInt));
      this.uQg.uQI.setVisibility(0);
      this.uQg.uQJ.setVisibility(4);
      GMTrace.o(1878645538816L, 13997);
      return;
    }
    this.uQg.uQI.setText("");
    this.uQg.uQI.setVisibility(4);
    GMTrace.o(1878645538816L, 13997);
  }
  
  public final void yT(int paramInt)
  {
    GMTrace.i(1878913974272L, 13999);
    this.uQC = paramInt;
    if (paramInt > 0)
    {
      if (paramInt > 99)
      {
        this.uQi.uQI.setText(getContext().getString(R.l.eYH));
        this.uQi.uQI.setVisibility(0);
        this.uQi.uQJ.setVisibility(4);
        GMTrace.o(1878913974272L, 13999);
        return;
      }
      this.uQi.uQI.setText(String.valueOf(paramInt));
      this.uQi.uQI.setVisibility(0);
      this.uQi.uQJ.setVisibility(4);
      GMTrace.o(1878913974272L, 13999);
      return;
    }
    this.uQi.uQI.setText("");
    this.uQi.uQI.setVisibility(4);
    GMTrace.o(1878913974272L, 13999);
  }
  
  protected final class a
  {
    View uQF;
    TabIconView uQG;
    TextView uQH;
    TextView uQI;
    ImageView uQJ;
    
    protected a()
    {
      GMTrace.i(3087678832640L, 23005);
      GMTrace.o(3087678832640L, 23005);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/LauncherUIBottomTabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */