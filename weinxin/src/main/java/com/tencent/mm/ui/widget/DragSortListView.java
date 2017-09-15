package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bm.a.j;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView
  extends ListView
{
  private int EK;
  private int jcu;
  private int jcv;
  private DataSetObserver mObserver;
  private View wqE;
  private Point wqF;
  private Point wqG;
  private int wqH;
  private boolean wqI;
  private float wqJ;
  private float wqK;
  private int wqL;
  private int wqM;
  private int wqN;
  private boolean wqO;
  private int wqP;
  private int wqQ;
  private int wqR;
  private int wqS;
  private int wqT;
  private b wqU;
  public g wqV;
  public l wqW;
  boolean wqX;
  private int wqY;
  private int wqZ;
  private boolean wrA;
  private e wrB;
  private boolean wrC;
  private boolean wrD;
  private i wrE;
  private k wrF;
  private j wrG;
  private f wrH;
  boolean wrI;
  private float wrJ;
  boolean wrK;
  private boolean wrL;
  private int wra;
  private int wrb;
  private View[] wrc;
  private d wrd;
  private float wre;
  private float wrf;
  private int wrg;
  private int wrh;
  private float wri;
  private float wrj;
  private float wrk;
  private float wrl;
  private float wrm;
  private c wrn;
  private int wro;
  private int wrp;
  private int wrq;
  private int wrr;
  private boolean wrs;
  boolean wrt;
  h wru;
  private MotionEvent wrv;
  private int wrw;
  private float wrx;
  private float wry;
  private a wrz;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(13057908539392L, 97289);
    this.wqF = new Point();
    this.wqG = new Point();
    this.wqI = false;
    this.wqJ = 1.0F;
    this.wqK = 1.0F;
    this.wqO = false;
    this.wqX = true;
    this.EK = 0;
    this.wqY = 1;
    this.wrb = 0;
    this.wrc = new View[1];
    this.wre = 0.33333334F;
    this.wrf = 0.33333334F;
    this.wrm = 0.5F;
    this.wrn = new c()
    {
      public final float av(float paramAnonymousFloat)
      {
        GMTrace.i(13067035344896L, 97357);
        float f = DragSortListView.a(DragSortListView.this);
        GMTrace.o(13067035344896L, 97357);
        return f * paramAnonymousFloat;
      }
    };
    this.wrr = 0;
    this.wrs = false;
    this.wrt = false;
    this.wru = null;
    this.wrw = 0;
    this.wrx = 0.25F;
    this.wry = 0.0F;
    this.wrA = false;
    this.wrC = false;
    this.wrD = false;
    this.wrE = new i();
    this.wrJ = 0.0F;
    this.wrK = false;
    this.wrL = false;
    int j = 150;
    int i = 150;
    boolean bool1;
    float f;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, a.j.fpG, 0, 0);
      this.wqY = Math.max(1, paramContext.getDimensionPixelSize(a.j.wyP, 1));
      this.wrA = paramContext.getBoolean(a.j.wze, false);
      if (this.wrA) {
        this.wrB = new e();
      }
      this.wqJ = paramContext.getFloat(a.j.wyW, this.wqJ);
      this.wqK = this.wqJ;
      this.wqX = paramContext.getBoolean(a.j.wyQ, this.wqX);
      this.wrx = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(a.j.wzc, 0.75F)));
      if (this.wrx <= 0.0F) {
        break label669;
      }
      bool1 = true;
      this.wqO = bool1;
      f = paramContext.getFloat(a.j.wyS, this.wre);
      if (f <= 0.5F) {
        break label675;
      }
      this.wrf = 0.5F;
      label372:
      if (f <= 0.5F) {
        break label683;
      }
    }
    label669:
    label675:
    label683:
    for (this.wre = 0.5F;; this.wre = f)
    {
      if (getHeight() != 0) {
        cak();
      }
      this.wrm = paramContext.getFloat(a.j.wyY, this.wrm);
      j = paramContext.getInt(a.j.wyZ, 150);
      i = paramContext.getInt(a.j.wyU, 150);
      if (paramContext.getBoolean(a.j.wzf, true))
      {
        bool1 = paramContext.getBoolean(a.j.wza, false);
        int k = paramContext.getInt(a.j.wzb, 1);
        boolean bool2 = paramContext.getBoolean(a.j.wzd, true);
        int m = paramContext.getInt(a.j.wyT, 0);
        int n = paramContext.getResourceId(a.j.wyR, 0);
        int i1 = paramContext.getResourceId(a.j.wyV, 0);
        int i2 = paramContext.getResourceId(a.j.wyO, 0);
        int i3 = paramContext.getColor(a.j.wyX, -16777216);
        paramAttributeSet = new a(this, n, m, k, i2, i1);
        paramAttributeSet.wql = bool1;
        paramAttributeSet.wqk = bool2;
        paramAttributeSet.wvu = i3;
        this.wru = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
      this.wrd = new d();
      if (j > 0) {
        this.wrF = new k(j);
      }
      if (i > 0) {
        this.wrH = new f(i);
      }
      this.wrv = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DataSetObserver()
      {
        private void cancel()
        {
          GMTrace.i(13072135618560L, 97395);
          if (DragSortListView.b(DragSortListView.this) == 4) {
            DragSortListView.this.caf();
          }
          GMTrace.o(13072135618560L, 97395);
        }
        
        public final void onChanged()
        {
          GMTrace.i(13072269836288L, 97396);
          cancel();
          GMTrace.o(13072269836288L, 97396);
        }
        
        public final void onInvalidated()
        {
          GMTrace.i(13072404054016L, 97397);
          cancel();
          GMTrace.o(13072404054016L, 97397);
        }
      };
      GMTrace.o(13057908539392L, 97289);
      return;
      bool1 = false;
      break;
      this.wrf = f;
      break label372;
    }
  }
  
  private int Cg(int paramInt)
  {
    GMTrace.i(13058445410304L, 97293);
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      paramInt = localView.getHeight();
      GMTrace.o(13058445410304L, 97293);
      return paramInt;
    }
    paramInt = eo(paramInt, Ci(paramInt));
    GMTrace.o(13058445410304L, 97293);
    return paramInt;
  }
  
  private void Ch(int paramInt)
  {
    GMTrace.i(13059384934400L, 97300);
    this.EK = 1;
    if (this.wqW != null) {
      this.wqW.remove(paramInt);
    }
    can();
    cai();
    cag();
    if (this.wrt)
    {
      this.EK = 3;
      GMTrace.o(13059384934400L, 97300);
      return;
    }
    this.EK = 0;
    GMTrace.o(13059384934400L, 97300);
  }
  
  private int Ci(int paramInt)
  {
    GMTrace.i(13060995547136L, 97312);
    if (paramInt == this.wqP)
    {
      GMTrace.o(13060995547136L, 97312);
      return 0;
    }
    Object localObject = getChildAt(paramInt - getFirstVisiblePosition());
    if (localObject != null)
    {
      paramInt = b(paramInt, (View)localObject, false);
      GMTrace.o(13060995547136L, 97312);
      return paramInt;
    }
    int i = this.wrE.wsf.get(paramInt, -1);
    if (i != -1)
    {
      GMTrace.o(13060995547136L, 97312);
      return i;
    }
    localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.wrc.length) {
      this.wrc = new View[j];
    }
    if (i >= 0) {
      if (this.wrc[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.wrc[i] = localObject;
        i = b(paramInt, (View)localObject, true);
        localObject = this.wrE;
        j = ((i)localObject).wsf.get(paramInt, -1);
        if (j != i)
        {
          if (j != -1) {
            break label311;
          }
          if (((i)localObject).wsf.size() == ((i)localObject).uuR) {
            ((i)localObject).wsf.delete(((Integer)((i)localObject).wsg.remove(0)).intValue());
          }
        }
      }
    }
    for (;;)
    {
      ((i)localObject).wsf.put(paramInt, i);
      ((i)localObject).wsg.add(Integer.valueOf(paramInt));
      GMTrace.o(13060995547136L, 97312);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.wrc[i], this);
      break;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
      break;
      label311:
      ((i)localObject).wsg.remove(Integer.valueOf(paramInt));
    }
  }
  
  private void H(MotionEvent paramMotionEvent)
  {
    GMTrace.i(13060190240768L, 97306);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      this.jcu = this.wro;
      this.jcv = this.wrp;
    }
    this.wro = ((int)paramMotionEvent.getX());
    this.wrp = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.jcu = this.wro;
      this.jcv = this.wrp;
    }
    this.wqS = ((int)paramMotionEvent.getRawX() - this.wro);
    this.wqT = ((int)paramMotionEvent.getRawY() - this.wrp);
    GMTrace.o(13060190240768L, 97306);
  }
  
  private void a(int paramInt, Canvas paramCanvas)
  {
    GMTrace.i(13058176974848L, 97291);
    Drawable localDrawable = getDivider();
    int m = getDividerHeight();
    ViewGroup localViewGroup;
    int j;
    int k;
    int i;
    if ((localDrawable != null) && (m != 0))
    {
      localViewGroup = (ViewGroup)getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        j = getPaddingLeft();
        k = getWidth() - getPaddingRight();
        i = localViewGroup.getChildAt(0).getHeight();
        if (paramInt <= this.wqP) {
          break label146;
        }
        i += localViewGroup.getTop();
        paramInt = i + m;
      }
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.clipRect(j, i, k, paramInt);
      localDrawable.setBounds(j, i, k, paramInt);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
      GMTrace.o(13058176974848L, 97291);
      return;
      label146:
      paramInt = localViewGroup.getBottom() - i;
      i = paramInt - m;
    }
  }
  
  private void a(int paramInt, View paramView, boolean paramBoolean)
  {
    GMTrace.i(13060861329408L, 97311);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i;
    if ((paramInt != this.wqP) && (paramInt != this.wqM) && (paramInt != this.wqN))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.wqM) || (paramInt == this.wqN))
      {
        if (paramInt >= this.wqP) {
          break label174;
        }
        ((b)paramView).tW = 80;
      }
    }
    for (;;)
    {
      int k = paramView.getVisibility();
      int j = 0;
      i = j;
      if (paramInt == this.wqP)
      {
        i = j;
        if (this.wqE != null) {
          i = 4;
        }
      }
      if (i != k) {
        paramView.setVisibility(i);
      }
      GMTrace.o(13060861329408L, 97311);
      return;
      i = eo(paramInt, b(paramInt, paramView, paramBoolean));
      break;
      label174:
      if (paramInt > this.wqP) {
        ((b)paramView).tW = 48;
      }
    }
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    GMTrace.i(13061129764864L, 97313);
    if (paramInt == this.wqP)
    {
      GMTrace.o(13061129764864L, 97313);
      return 0;
    }
    View localView = paramView;
    if (paramInt >= getHeaderViewsCount()) {
      if (paramInt < getCount() - getFooterViewsCount()) {
        break label88;
      }
    }
    label88:
    for (localView = paramView;; localView = ((ViewGroup)paramView).getChildAt(0))
    {
      paramView = localView.getLayoutParams();
      if ((paramView == null) || (paramView.height <= 0)) {
        break;
      }
      paramInt = paramView.height;
      GMTrace.o(13061129764864L, 97313);
      return paramInt;
    }
    paramInt = localView.getHeight();
    if ((paramInt == 0) || (paramBoolean))
    {
      dA(localView);
      paramInt = localView.getMeasuredHeight();
    }
    GMTrace.o(13061129764864L, 97313);
    return paramInt;
  }
  
  private boolean b(boolean paramBoolean, float paramFloat)
  {
    GMTrace.i(13059787587584L, 97303);
    if (this.wqE != null)
    {
      this.wrd.cao();
      if (paramBoolean) {
        l(this.wqP - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.wrA)
        {
          e locale = this.wrB;
          if (locale.wsa)
          {
            locale.mBuilder.append("</DSLVStates>\n");
            locale.flush();
            locale.wsa = false;
          }
        }
        GMTrace.o(13059787587584L, 97303);
        return true;
        if (this.wrH != null) {
          this.wrH.start();
        } else {
          cah();
        }
      }
    }
    GMTrace.o(13059787587584L, 97303);
    return false;
  }
  
  private void c(int paramInt, View paramView, boolean paramBoolean)
  {
    GMTrace.i(13062337724416L, 97322);
    this.wrC = true;
    if (this.wru != null)
    {
      this.wqG.set(this.wro, this.wrp);
      this.wru.d(this.wqF);
    }
    int i = this.wqF.x;
    int m = this.wqF.y;
    int j = getPaddingLeft();
    int k;
    int n;
    int i1;
    label308:
    int i4;
    int i5;
    int i6;
    label437:
    label487:
    int i3;
    int i2;
    label543:
    float f2;
    if (((this.wrr & 0x1) == 0) && (i > j))
    {
      this.wqF.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      n = getFirstVisiblePosition();
      i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.wrr & 0x8) == 0)
      {
        j = i;
        if (n <= this.wqP) {
          j = Math.max(getChildAt(this.wqP - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.wrr & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.wqP) {
          k = Math.min(getChildAt(this.wqP - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label886;
      }
      this.wqF.y = j;
      this.wqH = (this.wqF.y + this.wra);
      i4 = this.wqM;
      i5 = this.wqN;
      i = getFirstVisiblePosition();
      j = this.wqM;
      View localView2 = getChildAt(j - i);
      View localView1 = localView2;
      if (localView2 == null)
      {
        j = i + getChildCount() / 2;
        localView1 = getChildAt(j - i);
      }
      i1 = localView1.getTop();
      k = localView1.getHeight();
      i = en(j, i1);
      i6 = getDividerHeight();
      if (this.wqH >= i) {
        break label971;
      }
      m = i;
      n = j;
      j = n;
      k = m;
      if (n >= 0)
      {
        n -= 1;
        i = Cg(n);
        if (n != 0) {
          break label915;
        }
        i = i1 - i6 - i;
        k = m;
        j = n;
      }
      n = getHeaderViewsCount();
      i3 = getFooterViewsCount();
      i1 = this.wqM;
      i2 = this.wqN;
      float f1 = this.wry;
      if (!this.wqO) {
        break label1176;
      }
      i6 = Math.abs(i - k);
      if (this.wqH >= i) {
        break label1112;
      }
      f2 = this.wrx;
      m = (int)(i6 * (0.5F * f2));
      f2 = m;
      k += m;
      if (this.wqH >= k) {
        break label1127;
      }
      this.wqM = (j - 1);
      this.wqN = j;
      this.wry = ((k - this.wqH) * 0.5F / f2);
      label614:
      if (this.wqM >= n) {
        break label1191;
      }
      this.wqM = n;
      this.wqN = n;
      j = n;
      label639:
      if ((this.wqM == i1) && (this.wqN == i2) && (this.wry == f1)) {
        break label1344;
      }
    }
    label886:
    label915:
    label971:
    label1112:
    label1127:
    label1176:
    label1191:
    label1320:
    label1326:
    label1344:
    for (i = 1;; i = 0)
    {
      if (j != this.wqL) {
        this.wqL = j;
      }
      for (j = 1;; j = i)
      {
        if (j != 0)
        {
          cal();
          k = Ci(paramInt);
          n = paramView.getHeight();
          i1 = eo(paramInt, k);
          if (paramInt == this.wqP) {
            break label1326;
          }
          i = n - k;
        }
        for (k = i1 - k;; k = i1)
        {
          i2 = this.wqZ;
          m = i2;
          if (this.wqP != this.wqM)
          {
            m = i2;
            if (this.wqP != this.wqN) {
              m = i2 - this.wqY;
            }
          }
          if (paramInt <= i4)
          {
            if (paramInt <= this.wqM) {
              break label1320;
            }
            i = m - k + 0;
          }
          for (;;)
          {
            setSelectionFromTop(paramInt, i + paramView.getTop() - getPaddingTop());
            layoutChildren();
            if ((j != 0) || (paramBoolean)) {
              invalidate();
            }
            this.wrC = false;
            GMTrace.o(13062337724416L, 97322);
            return;
            if (((this.wrr & 0x2) != 0) || (i >= j)) {
              break;
            }
            this.wqF.x = j;
            break;
            if (this.wqZ + m <= k) {
              break label308;
            }
            this.wqF.y = (k - this.wqZ);
            break label308;
            i2 = i1 - (i + i6);
            i1 = en(n, i2);
            j = n;
            k = m;
            i = i1;
            if (this.wqH >= i1) {
              break label487;
            }
            m = i1;
            i = i1;
            i1 = i2;
            break label437;
            int i7 = getCount();
            i2 = i1;
            i1 = k;
            n = i;
            m = j;
            for (;;)
            {
              j = m;
              k = n;
              if (m >= i7) {
                break;
              }
              if (m == i7 - 1)
              {
                i = i2 + i6 + i1;
                j = m;
                k = n;
                break;
              }
              i2 += i6 + i1;
              i3 = Cg(m + 1);
              i1 = en(m + 1, i2);
              j = m;
              k = n;
              i = i1;
              if (this.wqH < i1) {
                break;
              }
              m += 1;
              n = i1;
              i = i1;
              i1 = i3;
            }
            m = k;
            k = i;
            i = m;
            break label543;
            if (this.wqH >= i - m)
            {
              this.wqM = j;
              this.wqN = (j + 1);
              this.wry = (0.5F * ((i - this.wqH) / f2 + 1.0F));
              break label614;
            }
            this.wqM = j;
            this.wqN = j;
            break label614;
            if (this.wqN < getCount() - i3) {
              break label639;
            }
            j = getCount() - i3 - 1;
            this.wqM = j;
            this.wqN = j;
            break label639;
            if (paramInt == i5)
            {
              if (paramInt <= this.wqM) {
                i = i - m + 0;
              } else if (paramInt == this.wqN) {
                i = n - i1 + 0;
              } else {
                i += 0;
              }
            }
            else if (paramInt <= this.wqM) {
              i = 0 - m;
            } else if (paramInt == this.wqN) {
              i = 0 - k;
            } else {
              i = 0;
            }
          }
          i = n;
        }
      }
    }
  }
  
  private void cag()
  {
    GMTrace.i(13059116498944L, 97298);
    this.wqP = -1;
    this.wqM = -1;
    this.wqN = -1;
    this.wqL = -1;
    GMTrace.o(13059116498944L, 97298);
  }
  
  private void cah()
  {
    GMTrace.i(13059250716672L, 97299);
    this.EK = 2;
    if ((this.wqV != null) && (this.wqL >= 0) && (this.wqL < getCount()))
    {
      int i = getHeaderViewsCount();
      this.wqV.bQ(this.wqP - i, this.wqL - i);
    }
    can();
    cai();
    cag();
    cal();
    if (this.wrt)
    {
      this.EK = 3;
      GMTrace.o(13059250716672L, 97299);
      return;
    }
    this.EK = 0;
    GMTrace.o(13059250716672L, 97299);
  }
  
  private void cai()
  {
    int i = 0;
    GMTrace.i(13059519152128L, 97301);
    int j = getFirstVisiblePosition();
    if (this.wqP < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
    GMTrace.o(13059519152128L, 97301);
  }
  
  private void caj()
  {
    GMTrace.i(13060056023040L, 97305);
    this.wrw = 0;
    this.wrt = false;
    if (this.EK == 3) {
      this.EK = 0;
    }
    this.wqK = this.wqJ;
    this.wrK = false;
    i locali = this.wrE;
    locali.wsf.clear();
    locali.wsg.clear();
    GMTrace.o(13060056023040L, 97305);
  }
  
  private void cak()
  {
    GMTrace.i(13060458676224L, 97308);
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.wrj = (i + this.wre * f1);
    float f2 = i;
    this.wri = (f1 * (1.0F - this.wrf) + f2);
    this.wrg = ((int)this.wrj);
    this.wrh = ((int)this.wri);
    this.wrk = (this.wrj - i);
    this.wrl = (i + j - this.wri);
    GMTrace.o(13060458676224L, 97308);
  }
  
  private void cal()
  {
    GMTrace.i(13060727111680L, 97310);
    int j = getFirstVisiblePosition();
    int k = getLastVisiblePosition();
    int i = Math.max(0, getHeaderViewsCount() - j);
    k = Math.min(k - j, getCount() - 1 - getFooterViewsCount() - j);
    while (i <= k)
    {
      View localView = getChildAt(i);
      if (localView != null) {
        a(j + i, localView, false);
      }
      i += 1;
    }
    GMTrace.o(13060727111680L, 97310);
  }
  
  private void cam()
  {
    GMTrace.i(13061666635776L, 97317);
    if (this.wqE != null)
    {
      dA(this.wqE);
      this.wqZ = this.wqE.getMeasuredHeight();
      this.wra = (this.wqZ / 2);
    }
    GMTrace.o(13061666635776L, 97317);
  }
  
  private void can()
  {
    GMTrace.i(13062471942144L, 97323);
    if (this.wqE != null)
    {
      this.wqE.setVisibility(8);
      if (this.wru != null) {
        this.wru.dB(this.wqE);
      }
      this.wqE = null;
      invalidate();
    }
    GMTrace.o(13062471942144L, 97323);
  }
  
  private void dA(View paramView)
  {
    GMTrace.i(13061532418048L, 97316);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.wrb, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      GMTrace.o(13061532418048L, 97316);
      return;
    }
  }
  
  private int en(int paramInt1, int paramInt2)
  {
    GMTrace.i(13058579628032L, 97294);
    int i = getHeaderViewsCount();
    int j = getFooterViewsCount();
    if ((paramInt1 <= i) || (paramInt1 >= getCount() - j))
    {
      GMTrace.o(13058579628032L, 97294);
      return paramInt2;
    }
    j = getDividerHeight();
    int m = this.wqZ - this.wqY;
    int k = Ci(paramInt1);
    int n = Cg(paramInt1);
    if (this.wqN <= this.wqP) {
      if ((paramInt1 == this.wqN) && (this.wqM != this.wqN)) {
        if (paramInt1 == this.wqP)
        {
          i = paramInt2 + n - this.wqZ;
          if (paramInt1 > this.wqP) {
            break label265;
          }
        }
      }
    }
    label265:
    for (paramInt1 = (this.wqZ - j - Ci(paramInt1 - 1)) / 2 + i;; paramInt1 = (k - j - this.wqZ) / 2 + i)
    {
      GMTrace.o(13058579628032L, 97294);
      return paramInt1;
      i = n - k + paramInt2 - m;
      break;
      i = paramInt2;
      if (paramInt1 <= this.wqN) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > this.wqP) {
        break;
      }
      i = paramInt2 - m;
      break;
      if ((paramInt1 > this.wqP) && (paramInt1 <= this.wqM))
      {
        i = paramInt2 + m;
        break;
      }
      i = paramInt2;
      if (paramInt1 != this.wqN) {
        break;
      }
      i = paramInt2;
      if (this.wqM == this.wqN) {
        break;
      }
      i = paramInt2 + (n - k);
      break;
    }
  }
  
  private int eo(int paramInt1, int paramInt2)
  {
    GMTrace.i(13061263982592L, 97314);
    getDividerHeight();
    int i;
    int j;
    int k;
    if ((this.wqO) && (this.wqM != this.wqN))
    {
      i = 1;
      j = this.wqZ - this.wqY;
      k = (int)(this.wry * j);
      if (paramInt1 != this.wqP) {
        break label141;
      }
      if (this.wqP != this.wqM) {
        break label111;
      }
      if (i == 0) {
        break label103;
      }
      i = k + this.wqY;
    }
    for (;;)
    {
      GMTrace.o(13061263982592L, 97314);
      return i;
      i = 0;
      break;
      label103:
      i = this.wqZ;
      continue;
      label111:
      if (this.wqP == this.wqN)
      {
        i = this.wqZ - k;
      }
      else
      {
        i = this.wqY;
        continue;
        label141:
        if (paramInt1 == this.wqM)
        {
          if (i != 0) {
            i = paramInt2 + k;
          } else {
            i = paramInt2 + j;
          }
        }
        else
        {
          i = paramInt2;
          if (paramInt1 == this.wqN) {
            i = paramInt2 + j - k;
          }
        }
      }
    }
  }
  
  private void lO(boolean paramBoolean)
  {
    GMTrace.i(13062203506688L, 97321);
    int i = getFirstVisiblePosition();
    int j = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null)
    {
      GMTrace.o(13062203506688L, 97321);
      return;
    }
    c(i + j, localView, true);
    GMTrace.o(13062203506688L, 97321);
  }
  
  public final boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(13062069288960L, 97320);
    if ((this.EK != 0) || (!this.wrt) || (this.wqE != null) || (paramView == null) || (!this.wqX))
    {
      GMTrace.o(13062069288960L, 97320);
      return false;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.wqM = paramInt1;
    this.wqN = paramInt1;
    this.wqP = paramInt1;
    this.wqL = paramInt1;
    this.EK = 4;
    this.wrr = 0;
    this.wrr |= paramInt2;
    this.wqE = paramView;
    cam();
    this.wqQ = paramInt3;
    this.wqR = paramInt4;
    this.wrq = this.wrp;
    this.wqF.x = (this.wro - this.wqQ);
    this.wqF.y = (this.wrp - this.wqR);
    paramView = getChildAt(this.wqP - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.wrA)
    {
      paramView = this.wrB;
      paramView.mBuilder.append("<DSLVStates>\n");
      paramView.wrZ = 0;
      paramView.wsa = true;
    }
    switch (this.wrw)
    {
    }
    for (;;)
    {
      requestLayout();
      if (this.wrG != null) {
        this.wrG.start();
      }
      GMTrace.o(13062069288960L, 97320);
      return true;
      super.onTouchEvent(this.wrv);
      continue;
      super.onInterceptTouchEvent(this.wrv);
    }
  }
  
  public final boolean au(float paramFloat)
  {
    GMTrace.i(13059653369856L, 97302);
    this.wrI = true;
    boolean bool = b(true, paramFloat);
    GMTrace.o(13059653369856L, 97302);
    return bool;
  }
  
  public final void caf()
  {
    GMTrace.i(13058982281216L, 97297);
    if (this.EK == 4)
    {
      this.wrd.cao();
      can();
      cag();
      cal();
      if (this.wrt)
      {
        this.EK = 3;
        GMTrace.o(13058982281216L, 97297);
        return;
      }
      this.EK = 0;
    }
    GMTrace.o(13058982281216L, 97297);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    GMTrace.i(13058311192576L, 97292);
    super.dispatchDraw(paramCanvas);
    if (this.EK != 0)
    {
      if (this.wqM != this.wqP) {
        a(this.wqM, paramCanvas);
      }
      if ((this.wqN != this.wqM) && (this.wqN != this.wqP)) {
        a(this.wqN, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.wqE != null)
    {
      k = this.wqE.getWidth();
      m = this.wqE.getHeight();
      int j = this.wqF.x;
      int n = getWidth();
      i = j;
      if (j < 0) {
        i = -j;
      }
      if (i >= n) {
        break label234;
      }
      f = (n - i) / n;
    }
    label234:
    for (f *= f;; f = 0.0F)
    {
      i = (int)(f * (255.0F * this.wqK));
      paramCanvas.save();
      paramCanvas.translate(this.wqF.x, this.wqF.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.wqE.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      GMTrace.o(13058311192576L, 97292);
      return;
    }
  }
  
  public final void l(int paramInt, float paramFloat)
  {
    GMTrace.i(13058848063488L, 97296);
    if ((this.EK == 0) || (this.EK == 4))
    {
      if (this.EK == 0)
      {
        this.wqP = (getHeaderViewsCount() + paramInt);
        this.wqM = this.wqP;
        this.wqN = this.wqP;
        this.wqL = this.wqP;
        View localView = getChildAt(this.wqP - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.EK = 1;
      this.wrJ = paramFloat;
      if (this.wrt) {
        switch (this.wrw)
        {
        }
      }
      while (this.wrF != null)
      {
        this.wrF.start();
        GMTrace.o(13058848063488L, 97296);
        return;
        super.onTouchEvent(this.wrv);
        continue;
        super.onInterceptTouchEvent(this.wrv);
      }
      Ch(paramInt);
    }
    GMTrace.o(13058848063488L, 97296);
  }
  
  protected void layoutChildren()
  {
    GMTrace.i(13061935071232L, 97319);
    super.layoutChildren();
    if (this.wqE != null)
    {
      if ((this.wqE.isLayoutRequested()) && (!this.wqI)) {
        cam();
      }
      this.wqE.layout(0, 0, this.wqE.getMeasuredWidth(), this.wqE.getMeasuredHeight());
      this.wqI = false;
    }
    GMTrace.o(13061935071232L, 97319);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(13058713845760L, 97295);
    super.onDraw(paramCanvas);
    if (this.wrA)
    {
      paramCanvas = this.wrB;
      if (paramCanvas.wsa)
      {
        paramCanvas.mBuilder.append("<DSLVState>\n");
        int j = paramCanvas.wrM.getChildCount();
        int k = paramCanvas.wrM.getFirstVisiblePosition();
        paramCanvas.mBuilder.append("    <Positions>");
        int i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(k + i).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Positions>\n");
        paramCanvas.mBuilder.append("    <Tops>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.wrM.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Tops>\n");
        paramCanvas.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.wrM.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Bottoms>\n");
        paramCanvas.mBuilder.append("    <FirstExpPos>").append(paramCanvas.wrM.wqM).append("</FirstExpPos>\n");
        paramCanvas.mBuilder.append("    <FirstExpBlankHeight>").append(paramCanvas.wrM.Cg(paramCanvas.wrM.wqM) - paramCanvas.wrM.Ci(paramCanvas.wrM.wqM)).append("</FirstExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SecondExpPos>").append(paramCanvas.wrM.wqN).append("</SecondExpPos>\n");
        paramCanvas.mBuilder.append("    <SecondExpBlankHeight>").append(paramCanvas.wrM.Cg(paramCanvas.wrM.wqN) - paramCanvas.wrM.Ci(paramCanvas.wrM.wqN)).append("</SecondExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SrcPos>").append(paramCanvas.wrM.wqP).append("</SrcPos>\n");
        paramCanvas.mBuilder.append("    <SrcHeight>").append(paramCanvas.wrM.wqZ + paramCanvas.wrM.getDividerHeight()).append("</SrcHeight>\n");
        paramCanvas.mBuilder.append("    <ViewHeight>").append(paramCanvas.wrM.getHeight()).append("</ViewHeight>\n");
        paramCanvas.mBuilder.append("    <LastY>").append(paramCanvas.wrM.jcv).append("</LastY>\n");
        paramCanvas.mBuilder.append("    <FloatY>").append(paramCanvas.wrM.wqH).append("</FloatY>\n");
        paramCanvas.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.wrM.en(k + i, paramCanvas.wrM.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</ShuffleEdges>\n");
        paramCanvas.mBuilder.append("</DSLVState>\n");
        paramCanvas.wrY += 1;
        if (paramCanvas.wrY > 1000)
        {
          paramCanvas.flush();
          paramCanvas.wrY = 0;
        }
      }
    }
    GMTrace.o(13058713845760L, 97295);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(13060324458496L, 97307);
    if (!this.wqX)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      GMTrace.o(13060324458496L, 97307);
      return bool;
    }
    H(paramMotionEvent);
    this.wrs = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.EK != 0)
      {
        this.wrD = true;
        GMTrace.o(13060324458496L, 97307);
        return true;
      }
      this.wrt = true;
    }
    if (this.wqE != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.wrt = false;
      }
      GMTrace.o(13060324458496L, 97307);
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.wrK = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.wrw = 1;
        }
        break;
      case 1: 
      case 3: 
        caj();
        break;
        this.wrw = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(13061800853504L, 97318);
    super.onMeasure(paramInt1, paramInt2);
    if (this.wqE != null)
    {
      if (this.wqE.isLayoutRequested()) {
        cam();
      }
      this.wqI = true;
    }
    this.wrb = paramInt1;
    GMTrace.o(13061800853504L, 97318);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(13060592893952L, 97309);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    cak();
    GMTrace.o(13060592893952L, 97309);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(13059921805312L, 97304);
    if (this.wrD)
    {
      this.wrD = false;
      GMTrace.o(13059921805312L, 97304);
      return false;
    }
    if (!this.wqX)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      GMTrace.o(13059921805312L, 97304);
      return bool1;
    }
    boolean bool1 = this.wrs;
    this.wrs = false;
    if (!bool1) {
      H(paramMotionEvent);
    }
    boolean bool2;
    if (this.EK == 4)
    {
      paramMotionEvent.getAction();
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        bool2 = true;
        GMTrace.o(13059921805312L, 97304);
        return bool2;
        if (this.EK == 4) {
          caf();
        }
        caj();
        continue;
        if (this.EK == 4)
        {
          this.wrI = false;
          b(false, 0.0F);
        }
        caj();
        continue;
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        this.wqF.x = (j - this.wqQ);
        this.wqF.y = (i - this.wqR);
        lO(true);
        j = Math.min(i, this.wqH + this.wra);
        int k = Math.max(i, this.wqH - this.wra);
        paramMotionEvent = this.wrd;
        if (paramMotionEvent.wrX) {}
        for (i = paramMotionEvent.wrV;; i = -1)
        {
          if ((j <= this.jcv) || (j <= this.wrh) || (i == 1)) {
            break label327;
          }
          if (i != -1) {
            this.wrd.cao();
          }
          this.wrd.Cj(1);
          break;
        }
        label327:
        if ((k < this.jcv) && (k < this.wrg) && (i != 0))
        {
          if (i != -1) {
            this.wrd.cao();
          }
          this.wrd.Cj(0);
        }
        else if ((k >= this.wrg) && (j <= this.wrh) && (this.wrd.wrX))
        {
          this.wrd.cao();
        }
      }
    }
    if ((this.EK == 0) && (super.onTouchEvent(paramMotionEvent))) {}
    for (bool1 = true;; bool1 = false) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.wrw = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        caj();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public void requestLayout()
  {
    GMTrace.i(13061398200320L, 97315);
    if (!this.wrC) {
      super.requestLayout();
    }
    GMTrace.o(13061398200320L, 97315);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    GMTrace.i(13058042757120L, 97290);
    if (paramListAdapter != null)
    {
      this.wrz = new a(paramListAdapter);
      paramListAdapter.registerDataSetObserver(this.mObserver);
      if ((paramListAdapter instanceof g)) {
        this.wqV = ((g)paramListAdapter);
      }
      if ((paramListAdapter instanceof b)) {
        this.wqU = ((b)paramListAdapter);
      }
      if ((paramListAdapter instanceof l)) {
        this.wqW = ((l)paramListAdapter);
      }
    }
    for (;;)
    {
      super.setAdapter(this.wrz);
      GMTrace.o(13058042757120L, 97290);
      return;
      this.wrz = null;
    }
  }
  
  private final class a
    extends BaseAdapter
  {
    private ListAdapter FA;
    
    public a(ListAdapter paramListAdapter)
    {
      GMTrace.i(13056029491200L, 97275);
      this.FA = paramListAdapter;
      this.FA.registerDataSetObserver(new DataSetObserver()
      {
        public final void onChanged()
        {
          GMTrace.i(13052539830272L, 97249);
          DragSortListView.a.this.notifyDataSetChanged();
          GMTrace.o(13052539830272L, 97249);
        }
        
        public final void onInvalidated()
        {
          GMTrace.i(13052674048000L, 97250);
          DragSortListView.a.this.notifyDataSetInvalidated();
          GMTrace.o(13052674048000L, 97250);
        }
      });
      GMTrace.o(13056029491200L, 97275);
    }
    
    public final boolean areAllItemsEnabled()
    {
      GMTrace.i(13056566362112L, 97279);
      boolean bool = this.FA.areAllItemsEnabled();
      GMTrace.o(13056566362112L, 97279);
      return bool;
    }
    
    public final int getCount()
    {
      GMTrace.i(13056432144384L, 97278);
      int i = this.FA.getCount();
      GMTrace.o(13056432144384L, 97278);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      GMTrace.i(13056297926656L, 97277);
      Object localObject = this.FA.getItem(paramInt);
      GMTrace.o(13056297926656L, 97277);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(13056163708928L, 97276);
      long l = this.FA.getItemId(paramInt);
      GMTrace.o(13056163708928L, 97276);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      GMTrace.i(13056834797568L, 97281);
      paramInt = this.FA.getItemViewType(paramInt);
      GMTrace.o(13056834797568L, 97281);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(13057371668480L, 97285);
      if (paramView != null)
      {
        paramViewGroup = (b)paramView;
        View localView1 = paramViewGroup.getChildAt(0);
        View localView2 = this.FA.getView(paramInt, localView1, DragSortListView.this);
        paramView = paramViewGroup;
        if (localView2 != localView1)
        {
          if (localView1 != null) {
            paramViewGroup.removeViewAt(0);
          }
          paramViewGroup.addView(localView2);
          paramView = paramViewGroup;
        }
        DragSortListView.a(DragSortListView.this, DragSortListView.this.getHeaderViewsCount() + paramInt, paramView);
        GMTrace.o(13057371668480L, 97285);
        return paramView;
      }
      paramViewGroup = this.FA.getView(paramInt, null, DragSortListView.this);
      if ((paramViewGroup instanceof Checkable)) {}
      for (paramView = new c(DragSortListView.this.getContext());; paramView = new b(DragSortListView.this.getContext()))
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.addView(paramViewGroup);
        break;
      }
    }
    
    public final int getViewTypeCount()
    {
      GMTrace.i(13056969015296L, 97282);
      int i = this.FA.getViewTypeCount();
      GMTrace.o(13056969015296L, 97282);
      return i;
    }
    
    public final boolean hasStableIds()
    {
      GMTrace.i(13057103233024L, 97283);
      boolean bool = this.FA.hasStableIds();
      GMTrace.o(13057103233024L, 97283);
      return bool;
    }
    
    public final boolean isEmpty()
    {
      GMTrace.i(13057237450752L, 97284);
      boolean bool = this.FA.isEmpty();
      GMTrace.o(13057237450752L, 97284);
      return bool;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      GMTrace.i(13056700579840L, 97280);
      boolean bool = this.FA.isEnabled(paramInt);
      GMTrace.o(13056700579840L, 97280);
      return bool;
    }
  }
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract float av(float paramFloat);
  }
  
  private final class d
    implements Runnable
  {
    private boolean wrP;
    private long wrQ;
    private long wrR;
    private int wrS;
    private float wrT;
    private long wrU;
    int wrV;
    private float wrW;
    boolean wrX;
    
    public d()
    {
      GMTrace.i(13079249158144L, 97448);
      this.wrX = false;
      GMTrace.o(13079249158144L, 97448);
    }
    
    public final void Cj(int paramInt)
    {
      GMTrace.i(13079383375872L, 97449);
      if (!this.wrX)
      {
        this.wrP = false;
        this.wrX = true;
        this.wrU = SystemClock.uptimeMillis();
        this.wrQ = this.wrU;
        this.wrV = paramInt;
        DragSortListView.this.post(this);
      }
      GMTrace.o(13079383375872L, 97449);
    }
    
    public final void cao()
    {
      GMTrace.i(13079517593600L, 97450);
      DragSortListView.this.removeCallbacks(this);
      this.wrX = false;
      GMTrace.o(13079517593600L, 97450);
    }
    
    public final void run()
    {
      GMTrace.i(13079651811328L, 97451);
      if (this.wrP)
      {
        this.wrX = false;
        GMTrace.o(13079651811328L, 97451);
        return;
      }
      int j = DragSortListView.this.getFirstVisiblePosition();
      int i = DragSortListView.this.getLastVisiblePosition();
      int m = DragSortListView.this.getCount();
      int k = DragSortListView.this.getPaddingTop();
      int n = DragSortListView.this.getHeight() - k - DragSortListView.this.getPaddingBottom();
      int i1 = Math.min(DragSortListView.f(DragSortListView.this), DragSortListView.s(DragSortListView.this) + DragSortListView.d(DragSortListView.this));
      int i2 = Math.max(DragSortListView.f(DragSortListView.this), DragSortListView.s(DragSortListView.this) - DragSortListView.d(DragSortListView.this));
      View localView;
      if (this.wrV == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.wrX = false;
          GMTrace.o(13079651811328L, 97451);
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.wrX = false;
          GMTrace.o(13079651811328L, 97451);
          return;
        }
        this.wrW = DragSortListView.v(DragSortListView.this).av((DragSortListView.t(DragSortListView.this) - i2) / DragSortListView.u(DragSortListView.this));
        this.wrR = SystemClock.uptimeMillis();
        this.wrT = ((float)(this.wrR - this.wrQ));
        this.wrS = Math.round(this.wrW * this.wrT);
        if (this.wrS < 0) {
          break label517;
        }
        this.wrS = Math.min(n, this.wrS);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.wrS;
        j = m;
        if (i == 0)
        {
          j = m;
          if (m > k) {
            j = k;
          }
        }
        DragSortListView.a(DragSortListView.this, true);
        DragSortListView.this.setSelectionFromTop(i, j - k);
        DragSortListView.this.layoutChildren();
        DragSortListView.this.invalidate();
        DragSortListView.a(DragSortListView.this, false);
        DragSortListView.c(DragSortListView.this, i, localView);
        this.wrQ = this.wrR;
        DragSortListView.this.post(this);
        GMTrace.o(13079651811328L, 97451);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.wrX = false;
          GMTrace.o(13079651811328L, 97451);
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.wrX = false;
          GMTrace.o(13079651811328L, 97451);
          return;
        }
        this.wrW = (-DragSortListView.v(DragSortListView.this).av((i1 - DragSortListView.w(DragSortListView.this)) / DragSortListView.x(DragSortListView.this)));
        break;
        label517:
        this.wrS = Math.max(-n, this.wrS);
      }
    }
  }
  
  private final class e
  {
    File iyn;
    StringBuilder mBuilder;
    int wrY;
    int wrZ;
    boolean wsa;
    
    public e()
    {
      GMTrace.i(13072538271744L, 97398);
      this.mBuilder = new StringBuilder();
      this.wrY = 0;
      this.wrZ = 0;
      this.wsa = false;
      this.iyn = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
      if (!this.iyn.exists()) {
        try
        {
          this.iyn.createNewFile();
          v.d("mobeta", "file created");
          GMTrace.o(13072538271744L, 97398);
          return;
        }
        catch (IOException this$1)
        {
          v.w("mobeta", "Could not create dslv_state.txt");
          v.d("mobeta", DragSortListView.this.getMessage());
        }
      }
      GMTrace.o(13072538271744L, 97398);
    }
    
    /* Error */
    public final void flush()
    {
      // Byte code:
      //   0: ldc2_w 94
      //   3: ldc 96
      //   5: invokestatic 36	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   8: aload_0
      //   9: getfield 47	com/tencent/mm/ui/widget/DragSortListView$e:wsa	Z
      //   12: ifne +12 -> 24
      //   15: ldc2_w 94
      //   18: ldc 96
      //   20: invokestatic 82	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   23: return
      //   24: aconst_null
      //   25: astore_3
      //   26: iconst_1
      //   27: istore_1
      //   28: aload_0
      //   29: getfield 45	com/tencent/mm/ui/widget/DragSortListView$e:wrZ	I
      //   32: ifne +5 -> 37
      //   35: iconst_0
      //   36: istore_1
      //   37: new 98	java/io/FileWriter
      //   40: dup
      //   41: aload_0
      //   42: getfield 62	com/tencent/mm/ui/widget/DragSortListView$e:iyn	Ljava/io/File;
      //   45: iload_1
      //   46: invokespecial 101	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
      //   49: astore_2
      //   50: aload_2
      //   51: aload_0
      //   52: getfield 41	com/tencent/mm/ui/widget/DragSortListView$e:mBuilder	Ljava/lang/StringBuilder;
      //   55: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   58: invokevirtual 108	java/io/FileWriter:write	(Ljava/lang/String;)V
      //   61: aload_0
      //   62: getfield 41	com/tencent/mm/ui/widget/DragSortListView$e:mBuilder	Ljava/lang/StringBuilder;
      //   65: iconst_0
      //   66: aload_0
      //   67: getfield 41	com/tencent/mm/ui/widget/DragSortListView$e:mBuilder	Ljava/lang/StringBuilder;
      //   70: invokevirtual 112	java/lang/StringBuilder:length	()I
      //   73: invokevirtual 116	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
      //   76: pop
      //   77: aload_2
      //   78: invokevirtual 118	java/io/FileWriter:flush	()V
      //   81: aload_0
      //   82: aload_0
      //   83: getfield 45	com/tencent/mm/ui/widget/DragSortListView$e:wrZ	I
      //   86: iconst_1
      //   87: iadd
      //   88: putfield 45	com/tencent/mm/ui/widget/DragSortListView$e:wrZ	I
      //   91: aload_2
      //   92: invokevirtual 121	java/io/FileWriter:close	()V
      //   95: ldc2_w 94
      //   98: ldc 96
      //   100: invokestatic 82	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   103: return
      //   104: astore_2
      //   105: ldc2_w 94
      //   108: ldc 96
      //   110: invokestatic 82	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   113: return
      //   114: astore_2
      //   115: aconst_null
      //   116: astore_2
      //   117: aload_2
      //   118: ifnull +7 -> 125
      //   121: aload_2
      //   122: invokevirtual 121	java/io/FileWriter:close	()V
      //   125: ldc2_w 94
      //   128: ldc 96
      //   130: invokestatic 82	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   133: return
      //   134: astore_2
      //   135: ldc2_w 94
      //   138: ldc 96
      //   140: invokestatic 82	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   143: return
      //   144: astore_2
      //   145: aload_3
      //   146: ifnull +7 -> 153
      //   149: aload_3
      //   150: invokevirtual 121	java/io/FileWriter:close	()V
      //   153: aload_2
      //   154: athrow
      //   155: astore_3
      //   156: goto -3 -> 153
      //   159: astore 4
      //   161: aload_2
      //   162: astore_3
      //   163: aload 4
      //   165: astore_2
      //   166: goto -21 -> 145
      //   169: astore_3
      //   170: goto -53 -> 117
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	173	0	this	e
      //   27	19	1	bool	boolean
      //   49	43	2	localFileWriter	java.io.FileWriter
      //   104	1	2	localIOException1	IOException
      //   114	1	2	localIOException2	IOException
      //   116	6	2	localObject1	Object
      //   134	1	2	localIOException3	IOException
      //   144	18	2	localObject2	Object
      //   165	1	2	localObject3	Object
      //   25	125	3	localObject4	Object
      //   155	1	3	localIOException4	IOException
      //   162	1	3	localObject5	Object
      //   169	1	3	localIOException5	IOException
      //   159	5	4	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   91	95	104	java/io/IOException
      //   28	35	114	java/io/IOException
      //   37	50	114	java/io/IOException
      //   121	125	134	java/io/IOException
      //   28	35	144	finally
      //   37	50	144	finally
      //   149	153	155	java/io/IOException
      //   50	91	159	finally
      //   50	91	169	java/io/IOException
    }
  }
  
  private final class f
    extends DragSortListView.m
  {
    private int wsb;
    private int wsc;
    private float wsd;
    private float wse;
    
    public f(int paramInt)
    {
      super(0.5F, paramInt);
      GMTrace.i(13080457117696L, 97457);
      GMTrace.o(13080457117696L, 97457);
    }
    
    private int cap()
    {
      GMTrace.i(13080725553152L, 97459);
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.j(DragSortListView.this) + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.wsb - i);
      i = -1;
      if (localView != null) {
        if (this.wsb == this.wsc) {
          i = localView.getTop();
        }
      }
      for (;;)
      {
        GMTrace.o(13080725553152L, 97459);
        return i;
        if (this.wsb < this.wsc)
        {
          i = localView.getTop() - j;
        }
        else
        {
          i = localView.getBottom() + j - DragSortListView.k(DragSortListView.this);
          continue;
          this.RE = true;
        }
      }
    }
    
    public final void aw(float paramFloat)
    {
      GMTrace.i(13080859770880L, 97460);
      int i = cap();
      int j = DragSortListView.this.getPaddingLeft();
      float f1 = DragSortListView.e(DragSortListView.this).y - i;
      float f2 = DragSortListView.e(DragSortListView.this).x - j;
      paramFloat = 1.0F - paramFloat;
      if ((paramFloat < Math.abs(f1 / this.wsd)) || (paramFloat < Math.abs(f2 / this.wse)))
      {
        DragSortListView.e(DragSortListView.this).y = (i + (int)(this.wsd * paramFloat));
        DragSortListView.e(DragSortListView.this).x = (DragSortListView.this.getPaddingLeft() + (int)(this.wse * paramFloat));
        DragSortListView.g(DragSortListView.this);
      }
      GMTrace.o(13080859770880L, 97460);
    }
    
    public final void onStart()
    {
      GMTrace.i(13080591335424L, 97458);
      this.wsb = DragSortListView.h(DragSortListView.this);
      this.wsc = DragSortListView.i(DragSortListView.this);
      DragSortListView.b(DragSortListView.this, 2);
      this.wsd = (DragSortListView.e(DragSortListView.this).y - cap());
      this.wse = (DragSortListView.e(DragSortListView.this).x - DragSortListView.this.getPaddingLeft());
      GMTrace.o(13080591335424L, 97458);
    }
    
    public final void onStop()
    {
      GMTrace.i(13080993988608L, 97461);
      DragSortListView.l(DragSortListView.this);
      GMTrace.o(13080993988608L, 97461);
    }
  }
  
  public static abstract interface g
  {
    public abstract void bQ(int paramInt1, int paramInt2);
  }
  
  public static abstract interface h
  {
    public abstract View Ck(int paramInt);
    
    public abstract void d(Point paramPoint);
    
    public abstract void dB(View paramView);
  }
  
  private final class i
  {
    int uuR;
    SparseIntArray wsf;
    ArrayList<Integer> wsg;
    
    public i()
    {
      GMTrace.i(13057774321664L, 97288);
      this.wsf = new SparseIntArray(3);
      this.wsg = new ArrayList(3);
      this.uuR = 3;
      GMTrace.o(13057774321664L, 97288);
    }
  }
  
  private final class j
    extends DragSortListView.m
  {
    private float wsh;
    private float wsi;
    
    public final void aw(float paramFloat)
    {
      GMTrace.i(13071061876736L, 97387);
      if (DragSortListView.b(this.wrM) != 4)
      {
        this.RE = true;
        GMTrace.o(13071061876736L, 97387);
        return;
      }
      DragSortListView.a(this.wrM, (int)(this.wsi * paramFloat + (1.0F - paramFloat) * this.wsh));
      DragSortListView.e(this.wrM).y = (DragSortListView.f(this.wrM) - DragSortListView.c(this.wrM));
      DragSortListView.g(this.wrM);
      GMTrace.o(13071061876736L, 97387);
    }
    
    public final void onStart()
    {
      GMTrace.i(13070927659008L, 97386);
      this.wsh = DragSortListView.c(this.wrM);
      this.wsi = DragSortListView.d(this.wrM);
      GMTrace.o(13070927659008L, 97386);
    }
  }
  
  private final class k
    extends DragSortListView.m
  {
    private int kuN;
    private int wsc;
    private float wsj;
    private float wsk;
    private float wsl;
    private int wsm;
    private int wsn;
    private int wso;
    
    public k(int paramInt)
    {
      super(0.5F, paramInt);
      GMTrace.i(13078041198592L, 97439);
      this.wsm = -1;
      this.wsn = -1;
      GMTrace.o(13078041198592L, 97439);
    }
    
    public final void aw(float paramFloat)
    {
      GMTrace.i(13078309634048L, 97441);
      paramFloat = 1.0F - paramFloat;
      int j = DragSortListView.this.getFirstVisiblePosition();
      View localView = DragSortListView.this.getChildAt(this.kuN - j);
      Object localObject;
      int i;
      if (DragSortListView.o(DragSortListView.this))
      {
        float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / 1000.0F;
        if (f1 == 0.0F)
        {
          GMTrace.o(13078309634048L, 97441);
          return;
        }
        float f2 = DragSortListView.p(DragSortListView.this);
        int k = DragSortListView.this.getWidth();
        localObject = DragSortListView.this;
        float f3 = DragSortListView.p(DragSortListView.this);
        if (DragSortListView.p(DragSortListView.this) > 0.0F) {}
        for (i = 1;; i = -1)
        {
          DragSortListView.a((DragSortListView)localObject, i * f1 * k + f3);
          this.wsj += f2 * f1;
          DragSortListView.e(DragSortListView.this).x = ((int)this.wsj);
          if ((this.wsj >= k) || (this.wsj <= -k)) {
            break;
          }
          this.mStartTime = SystemClock.uptimeMillis();
          DragSortListView.g(DragSortListView.this);
          GMTrace.o(13078309634048L, 97441);
          return;
        }
      }
      if (localView != null)
      {
        if (this.wsm == -1)
        {
          this.wsm = DragSortListView.b(DragSortListView.this, this.kuN, localView);
          this.wsk = (localView.getHeight() - this.wsm);
        }
        i = Math.max((int)(this.wsk * paramFloat), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (i + this.wsm);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.wso != this.kuN)
      {
        localView = DragSortListView.this.getChildAt(this.wso - j);
        if (localView != null)
        {
          if (this.wsn == -1)
          {
            this.wsn = DragSortListView.b(DragSortListView.this, this.wso, localView);
            this.wsl = (localView.getHeight() - this.wsn);
          }
          i = Math.max((int)(paramFloat * this.wsl), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.wsn);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      GMTrace.o(13078309634048L, 97441);
    }
    
    public final void onStart()
    {
      int i = -1;
      GMTrace.i(13078175416320L, 97440);
      this.wsm = -1;
      this.wsn = -1;
      this.kuN = DragSortListView.m(DragSortListView.this);
      this.wso = DragSortListView.n(DragSortListView.this);
      this.wsc = DragSortListView.i(DragSortListView.this);
      DragSortListView.b(DragSortListView.this, 1);
      this.wsj = DragSortListView.e(DragSortListView.this).x;
      if (DragSortListView.o(DragSortListView.this))
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.p(DragSortListView.this) == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.wsj < 0.0F) {}
          for (;;)
          {
            DragSortListView.a(localDragSortListView, i * f);
            GMTrace.o(13078175416320L, 97440);
            return;
            i = 1;
          }
        }
        f *= 2.0F;
        if ((DragSortListView.p(DragSortListView.this) < 0.0F) && (DragSortListView.p(DragSortListView.this) > -f))
        {
          DragSortListView.a(DragSortListView.this, -f);
          GMTrace.o(13078175416320L, 97440);
          return;
        }
        if ((DragSortListView.p(DragSortListView.this) > 0.0F) && (DragSortListView.p(DragSortListView.this) < f)) {
          DragSortListView.a(DragSortListView.this, f);
        }
        GMTrace.o(13078175416320L, 97440);
        return;
      }
      DragSortListView.q(DragSortListView.this);
      GMTrace.o(13078175416320L, 97440);
    }
    
    public final void onStop()
    {
      GMTrace.i(13078443851776L, 97442);
      DragSortListView.r(DragSortListView.this);
      GMTrace.o(13078443851776L, 97442);
    }
  }
  
  public static abstract interface l
  {
    public abstract void remove(int paramInt);
  }
  
  private class m
    implements Runnable
  {
    boolean RE;
    private float mAlpha;
    protected long mStartTime;
    private float wsp;
    private float wsq;
    private float wsr;
    private float wss;
    private float wst;
    
    public m(float paramFloat, int paramInt)
    {
      GMTrace.i(13070122352640L, 97380);
      this.mAlpha = 0.5F;
      this.wsp = paramInt;
      paramFloat = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
      this.wst = paramFloat;
      this.wsq = paramFloat;
      this.wsr = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
      this.wss = (1.0F / (1.0F - this.mAlpha));
      GMTrace.o(13070122352640L, 97380);
    }
    
    public void aw(float paramFloat)
    {
      GMTrace.i(13070525005824L, 97383);
      GMTrace.o(13070525005824L, 97383);
    }
    
    public void onStart()
    {
      GMTrace.i(13070390788096L, 97382);
      GMTrace.o(13070390788096L, 97382);
    }
    
    public void onStop()
    {
      GMTrace.i(13070659223552L, 97384);
      GMTrace.o(13070659223552L, 97384);
    }
    
    public void run()
    {
      GMTrace.i(13070793441280L, 97385);
      if (this.RE)
      {
        GMTrace.o(13070793441280L, 97385);
        return;
      }
      float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.wsp;
      if (f1 >= 1.0F)
      {
        aw(1.0F);
        onStop();
        GMTrace.o(13070793441280L, 97385);
        return;
      }
      if (f1 < this.mAlpha) {
        f1 *= this.wsq * f1;
      }
      for (;;)
      {
        aw(f1);
        DragSortListView.this.post(this);
        GMTrace.o(13070793441280L, 97385);
        return;
        if (f1 < 1.0F - this.mAlpha)
        {
          float f2 = this.wsr;
          f1 = f1 * this.wss + f2;
        }
        else
        {
          f1 = 1.0F - (f1 - 1.0F) * (this.wst * (f1 - 1.0F));
        }
      }
    }
    
    public final void start()
    {
      GMTrace.i(13070256570368L, 97381);
      this.mStartTime = SystemClock.uptimeMillis();
      this.RE = false;
      onStart();
      DragSortListView.this.post(this);
      GMTrace.o(13070256570368L, 97381);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/DragSortListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */