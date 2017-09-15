package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.a;
import android.support.design.widget.c;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.t;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.bm.a.c;
import com.tencent.mm.bm.a.e;
import com.tencent.mm.bm.a.f;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

public final class e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static int wsJ;
  public static int wsK;
  public static int wsL;
  private ViewTreeObserver Rn;
  public RecyclerView aak;
  private View hz;
  private View kOE;
  public Context mContext;
  public boolean oLJ;
  public View puO;
  public n.c qHD;
  public n.d qHE;
  public l qHF;
  private boolean shI;
  private boolean shJ;
  public boolean shK;
  public boolean shL;
  public n.a wkZ;
  public n.b wla;
  public l wsA;
  private LinearLayout wsB;
  private LinearLayout wsC;
  public b wsD;
  public boolean wsE;
  public boolean wsF;
  public boolean wsG;
  private int wsH;
  private BottomSheetBehavior wsI;
  private int wsM;
  private int wsN;
  private int wsO;
  public int wsP;
  public boolean wsQ;
  public boolean wsR;
  public boolean wsS;
  public boolean wsT;
  public int wsU;
  public a wsV;
  public c wsy;
  public n.d wsz;
  
  static
  {
    GMTrace.i(13076699021312L, 97429);
    wsJ = 0;
    wsK = 1;
    wsL = 2;
    GMTrace.o(13076699021312L, 97429);
  }
  
  public e(Context paramContext, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(13072940924928L, 97401);
    this.wsE = false;
    this.wsF = false;
    this.wsG = false;
    this.shI = false;
    this.wsM = 4;
    this.wsN = (this.wsM * 3);
    this.wsO = 6;
    this.oLJ = false;
    this.wsR = false;
    this.shL = false;
    this.wsS = false;
    this.wsT = false;
    this.wsU = 0;
    this.wsP = paramInt;
    this.mContext = paramContext;
    this.wsQ = paramBoolean;
    this.wsT = false;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() > 0) {
        this.hz = paramContext.getChildAt(0);
      }
    }
    else
    {
      paramContext = this.mContext;
      this.qHF = new l();
      this.wsA = new l();
      this.wsy = new c(paramContext);
      this.kOE = View.inflate(paramContext, a.f.wye, null);
      this.wsB = ((LinearLayout)this.kOE.findViewById(a.e.wxX));
      this.wsC = ((LinearLayout)this.kOE.findViewById(a.e.wxV));
      this.puO = this.kOE.findViewById(a.e.wxZ);
      this.aak = ((RecyclerView)this.kOE.findViewById(a.e.wxW));
      this.aak.Zl = true;
      this.shI = aKD();
      if (this.wsP != wsJ) {
        break label635;
      }
      if (!this.shI) {
        break label607;
      }
      this.wsM = 7;
      this.wsN = (this.wsM * 2);
      this.wsH = (a.U(this.mContext, a.c.wxK) + a.U(this.mContext, a.c.bac));
      label336:
      if (this.wsQ) {
        this.wsH += a.U(this.mContext, a.c.bac);
      }
      label362:
      if ((this.wsQ) && (this.puO != null) && (this.wsT)) {
        this.puO.setVisibility(0);
      }
      if (this.wsP != wsJ) {
        break label863;
      }
      this.aak.a(new GridLayoutManager(this.mContext, this.wsM));
      int i = a.U(this.mContext, a.c.bab);
      paramInt = a.U(this.mContext, a.c.bac);
      if (this.wsQ) {
        paramInt = a.fromDPToPix(this.mContext, 0);
      }
      this.aak.setPadding(i, paramInt, i, 0);
    }
    for (;;)
    {
      this.wsD = new b();
      this.wsD.Yi = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(13077504327680L, 97435);
          paramAnonymousAdapterView = (m)e.this.qHF.vjl.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.udt))
          {
            GMTrace.o(13077504327680L, 97435);
            return;
          }
          if (paramAnonymousInt < e.this.qHF.size()) {
            if (e.this.qHE != null) {
              e.this.qHE.c(e.this.qHF.getItem(paramAnonymousInt), paramAnonymousInt);
            }
          }
          for (;;)
          {
            if (!e.this.oLJ) {
              e.this.bza();
            }
            e.this.wsR = true;
            e.this.wsU = paramAnonymousInt;
            e.this.wsD.aab.notifyChanged();
            GMTrace.o(13077504327680L, 97435);
            return;
            if ((e.this.wsA.size() > 0) && (paramAnonymousInt < e.this.qHF.size() + e.this.wsA.size()) && (e.this.wsz != null)) {
              e.this.wsz.c(e.this.wsA.getItem(paramAnonymousInt - e.this.qHF.size()), paramAnonymousInt);
            }
          }
        }
      };
      this.aak.a(this.wsD);
      this.aak.setOverScrollMode(1);
      this.wsy.setContentView(this.kOE);
      this.wsI = BottomSheetBehavior.i((View)this.kOE.getParent());
      this.wsI.g(this.wsH);
      this.wsI.fj = new BottomSheetBehavior.a()
      {
        public final void d(float paramAnonymousFloat)
        {
          GMTrace.i(13055761055744L, 97273);
          if ((e.this.puO != null) && (!e.this.wsT))
          {
            if (!e.this.aak.canScrollVertically(-1))
            {
              e.this.puO.setVisibility(4);
              GMTrace.o(13055761055744L, 97273);
              return;
            }
            if ((e.this.wsQ) && (paramAnonymousFloat != 0.0F))
            {
              e.this.puO.setVisibility(0);
              GMTrace.o(13055761055744L, 97273);
              return;
            }
            e.this.puO.setVisibility(4);
          }
          GMTrace.o(13055761055744L, 97273);
        }
        
        public final void k(int paramAnonymousInt)
        {
          GMTrace.i(13055626838016L, 97272);
          GMTrace.o(13055626838016L, 97272);
        }
      };
      this.wsy.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(13069719699456L, 97377);
          e.this.wsy = null;
          GMTrace.o(13069719699456L, 97377);
        }
      });
      GMTrace.o(13072940924928L, 97401);
      return;
      this.hz = paramContext;
      break;
      label607:
      this.wsH = (a.U(this.mContext, a.c.wxJ) + a.U(this.mContext, a.c.bac));
      break label336;
      label635:
      if (this.wsP == wsL)
      {
        this.wsF = true;
        paramInt = a.U(this.mContext, a.c.wxP);
        if (this.shI) {
          this.wsO = 2;
        }
        for (this.wsH = ((int)(paramInt * 2.5D) + a.U(this.mContext, a.c.wxO));; this.wsH = ((int)(paramInt * 3.5D) + a.U(this.mContext, a.c.wxO)))
        {
          if (!this.wsQ) {
            break label751;
          }
          this.wsH += a.fromDPToPix(this.mContext, 88);
          break;
          this.wsO = 3;
        }
        label751:
        break label362;
      }
      this.wsG = true;
      paramInt = a.U(this.mContext, a.c.wxQ);
      if (this.shI) {
        this.wsO = 4;
      }
      for (this.wsH = ((int)(paramInt * 4.5D) + a.U(this.mContext, a.c.wxO));; this.wsH = ((int)(paramInt * 6.5D) + a.U(this.mContext, a.c.wxO)))
      {
        if (!this.wsQ) {
          break label861;
        }
        this.wsH += a.U(this.mContext, a.c.bac);
        break;
        this.wsO = 6;
      }
      label861:
      break label362;
      label863:
      this.aak.a(new LinearLayoutManager());
    }
  }
  
  private boolean aKD()
  {
    GMTrace.i(13073746231296L, 97407);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels)
    {
      GMTrace.o(13073746231296L, 97407);
      return true;
    }
    GMTrace.o(13073746231296L, 97407);
    return false;
  }
  
  public final void byZ()
  {
    GMTrace.i(13073343578112L, 97404);
    this.shI = aKD();
    if (this.qHD != null) {
      this.qHD.a(this.qHF);
    }
    FrameLayout.LayoutParams localLayoutParams;
    int j;
    if (this.wsy != null)
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.kOE.getLayoutParams();
      j = this.qHF.size();
      if (!this.wsE) {
        break label411;
      }
      i = j + 1;
      if (this.wsP != wsJ) {
        break label436;
      }
      if (this.wsD.getItemCount() > this.wsN) {
        localLayoutParams.height = this.wsH;
      }
      label106:
      if ((this.shI) && (this.hz != null))
      {
        Rect localRect = new Rect();
        this.hz.getWindowVisibleDisplayFrame(localRect);
        localLayoutParams.width = localRect.right;
      }
      this.kOE.setLayoutParams(localLayoutParams);
      if ((this.wsA != null) && (this.wsD != null)) {
        this.wsD.aab.notifyChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.wsy.getWindow().addFlags(Integer.MIN_VALUE);
      }
      if ((this.shJ) && (Build.VERSION.SDK_INT >= 23) && (this.wsy != null))
      {
        this.wsy.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.wsy.getWindow().setStatusBarColor(0);
      }
      if (this.shK) {
        this.wsy.getWindow().addFlags(1024);
      }
      if (!this.shL) {
        break label455;
      }
      this.wsy.getWindow().setFlags(8, 8);
      this.wsy.getWindow().addFlags(131200);
      this.wsy.getWindow().getDecorView().setSystemUiVisibility(6);
      label318:
      if (this.wsI != null) {
        this.wsI.fb = false;
      }
      if (this.wsV != null) {
        this.wsy.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(13048647516160L, 97220);
            if (!e.this.wsR) {
              e.this.wsV.onDismiss();
            }
            GMTrace.o(13048647516160L, 97220);
          }
        });
      }
      if (this.hz != null) {
        if (this.Rn != null) {
          break label510;
        }
      }
    }
    label411:
    label436:
    label455:
    label510:
    for (int i = 1;; i = 0)
    {
      this.Rn = this.hz.getViewTreeObserver();
      if (i != 0) {
        this.Rn.addOnGlobalLayoutListener(this);
      }
      this.wsy.show();
      GMTrace.o(13073343578112L, 97404);
      return;
      i = j;
      if (this.wsA.size() <= 0) {
        break;
      }
      i = j + this.wsA.size();
      break;
      if (i <= this.wsO) {
        break label106;
      }
      localLayoutParams.height = this.wsH;
      break label106;
      this.wsy.getWindow().clearFlags(8);
      this.wsy.getWindow().clearFlags(131072);
      this.wsy.getWindow().clearFlags(128);
      this.wsy.getWindow().getDecorView().setSystemUiVisibility(0);
      break label318;
    }
  }
  
  public final void bza()
  {
    GMTrace.i(13073477795840L, 97405);
    if (this.Rn != null)
    {
      if (!this.Rn.isAlive()) {
        this.Rn = this.hz.getViewTreeObserver();
      }
      this.Rn.removeGlobalOnLayoutListener(this);
      this.Rn = null;
    }
    if (this.wsy != null)
    {
      if (this.wsI != null) {
        this.wsI.fb = true;
      }
      this.wsy.dismiss();
    }
    GMTrace.o(13073477795840L, 97405);
  }
  
  public final void d(CharSequence paramCharSequence, int paramInt)
  {
    GMTrace.i(13073209360384L, 97403);
    if ((this.wsB != null) && (this.wsQ))
    {
      this.wsB.setVisibility(0);
      this.wsB.removeAllViews();
      this.wsB.setGravity(paramInt);
      View localView = LayoutInflater.from(this.mContext).inflate(a.f.wyi, null);
      TextView localTextView = (TextView)localView.findViewById(a.e.hdt);
      localTextView.setText(paramCharSequence);
      localTextView.setGravity(paramInt | 0x50);
      this.wsB.addView(localView, -1, -2);
    }
    GMTrace.o(13073209360384L, 97403);
  }
  
  public final void dC(View paramView)
  {
    GMTrace.i(13073075142656L, 97402);
    if ((this.wsB != null) && (this.wsQ))
    {
      this.wsB.setVisibility(0);
      this.wsB.removeAllViews();
      this.wsB.setGravity(17);
      this.wsB.addView(paramView, -1, -2);
    }
    GMTrace.o(13073075142656L, 97402);
  }
  
  public final boolean isShowing()
  {
    GMTrace.i(13073612013568L, 97406);
    if (this.wsy != null)
    {
      if (this.wsy.isShowing())
      {
        GMTrace.o(13073612013568L, 97406);
        return true;
      }
      GMTrace.o(13073612013568L, 97406);
      return false;
    }
    GMTrace.o(13073612013568L, 97406);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    GMTrace.i(13072806707200L, 97400);
    if (isShowing())
    {
      View localView = this.hz;
      if ((localView == null) || (!localView.isShown()))
      {
        bza();
        GMTrace.o(13072806707200L, 97400);
        return;
      }
      if ((isShowing()) && (this.shI != aKD())) {
        bza();
      }
    }
    GMTrace.o(13072806707200L, 97400);
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
  
  public final class b
    extends RecyclerView.a<a>
  {
    AdapterView.OnItemClickListener Yi;
    
    public b()
    {
      GMTrace.i(13081128206336L, 97462);
      GMTrace.o(13081128206336L, 97462);
    }
    
    public final int getItemCount()
    {
      GMTrace.i(13081262424064L, 97463);
      if (e.this.wsE)
      {
        i = e.this.qHF.size();
        j = e.this.wsA.size();
        GMTrace.o(13081262424064L, 97463);
        return i + j + 1;
      }
      int i = e.this.qHF.size();
      int j = e.this.wsA.size();
      GMTrace.o(13081262424064L, 97463);
      return i + j;
    }
    
    public final class a
      extends RecyclerView.t
      implements View.OnClickListener
    {
      TextView iUi;
      ImageView jiQ;
      TextView qgl;
      RadioButton wsX;
      ImageView wsY;
      LinearLayout wsZ;
      
      public a(View paramView)
      {
        super();
        GMTrace.i(13071732965376L, 97392);
        paramView.setOnClickListener(this);
        this.iUi = ((TextView)paramView.findViewById(a.e.title));
        this.jiQ = ((ImageView)paramView.findViewById(a.e.icon));
        this.wsZ = ((LinearLayout)paramView.findViewById(a.e.cze));
        if ((e.this.wsF) || (e.this.wsG))
        {
          this.qgl = ((TextView)paramView.findViewById(a.e.bHS));
          this.wsX = ((RadioButton)paramView.findViewById(a.e.cuU));
          this.wsY = ((ImageView)paramView.findViewById(a.e.divider));
        }
        GMTrace.o(13071732965376L, 97392);
      }
      
      public final void onClick(View paramView)
      {
        GMTrace.i(13071867183104L, 97393);
        if (e.b.this.Yi != null) {
          e.b.this.Yi.onItemClick(null, paramView, getPosition(), getPosition());
        }
        GMTrace.o(13071867183104L, 97393);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */