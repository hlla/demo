package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.a;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.h
{
  int Xd;
  private c Xo;
  ab Xp;
  private boolean Xq;
  private boolean Xr = false;
  boolean Xs = false;
  private boolean Xt = false;
  private boolean Xu = true;
  public int Xv = -1;
  public int Xw = Integer.MIN_VALUE;
  private boolean Xx;
  public SavedState Xy = null;
  final a Xz = new a();
  
  public LinearLayoutManager()
  {
    this(1, false);
  }
  
  public LinearLayoutManager(int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    q(null);
    if (this.Xr)
    {
      this.Xr = false;
      requestLayout();
    }
    this.aan = true;
  }
  
  private void I(int paramInt1, int paramInt2)
  {
    this.Xo.WS = (this.Xp.fk() - paramInt2);
    c localc = this.Xo;
    if (this.Xs) {}
    for (int i = -1;; i = 1)
    {
      localc.WU = i;
      this.Xo.WT = paramInt1;
      this.Xo.WV = 1;
      this.Xo.wa = paramInt2;
      this.Xo.XF = Integer.MIN_VALUE;
      return;
    }
  }
  
  private void J(int paramInt1, int paramInt2)
  {
    this.Xo.WS = (paramInt2 - this.Xp.fj());
    this.Xo.WT = paramInt1;
    c localc = this.Xo;
    if (this.Xs) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.WU = paramInt1;
      this.Xo.WV = -1;
      this.Xo.wa = paramInt2;
      this.Xo.XF = Integer.MIN_VALUE;
      return;
    }
  }
  
  private View O(boolean paramBoolean)
  {
    if (this.Xs) {
      return a(getChildCount() - 1, -1, paramBoolean, true);
    }
    return a(0, getChildCount(), paramBoolean, true);
  }
  
  private View P(boolean paramBoolean)
  {
    if (this.Xs) {
      return a(0, getChildCount(), paramBoolean, true);
    }
    return a(getChildCount() - 1, -1, paramBoolean, true);
  }
  
  private int a(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq, boolean paramBoolean)
  {
    int i = this.Xp.fk() - paramInt;
    if (i > 0)
    {
      int j = -c(-i, paramm, paramq);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.Xp.fk() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.Xp.ba(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int a(RecyclerView.m paramm, c paramc, RecyclerView.q paramq, boolean paramBoolean)
  {
    int k = paramc.WS;
    if (paramc.XF != Integer.MIN_VALUE)
    {
      if (paramc.WS < 0) {
        paramc.XF += paramc.WS;
      }
      a(paramm, paramc);
    }
    int i = paramc.WS + paramc.XG;
    b localb = new b();
    do
    {
      int j;
      do
      {
        if (((!paramc.WZ) && (i <= 0)) || (!paramc.k(paramq))) {
          break;
        }
        localb.XD = 0;
        localb.mFinished = false;
        localb.XE = false;
        localb.OE = false;
        a(paramm, paramq, paramc, localb);
        if (localb.mFinished) {
          break;
        }
        paramc.wa += localb.XD * paramc.WV;
        if ((localb.XE) && (this.Xo.XJ == null))
        {
          j = i;
          if (paramq.aaW) {}
        }
        else
        {
          paramc.WS -= localb.XD;
          j = i - localb.XD;
        }
        if (paramc.XF != Integer.MIN_VALUE)
        {
          paramc.XF += localb.XD;
          if (paramc.WS < 0) {
            paramc.XF += paramc.WS;
          }
          a(paramm, paramc);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localb.OE);
    return k - paramc.WS;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.q paramq)
  {
    int i = -1;
    int j = 1;
    this.Xo.WZ = eW();
    this.Xo.XG = a(paramq);
    this.Xo.WV = paramInt1;
    if (paramInt1 == 1)
    {
      paramq = this.Xo;
      paramq.XG += this.Xp.getEndPadding();
      paramq = eZ();
      localc = this.Xo;
      if (this.Xs) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localc.WU = paramInt1;
        this.Xo.WT = (be(paramq) + this.Xo.WU);
        this.Xo.wa = this.Xp.aW(paramq);
        paramInt1 = this.Xp.aW(paramq) - this.Xp.fk();
        this.Xo.WS = paramInt2;
        if (paramBoolean)
        {
          paramq = this.Xo;
          paramq.WS -= paramInt1;
        }
        this.Xo.XF = paramInt1;
        return;
      }
    }
    paramq = eY();
    c localc = this.Xo;
    localc.XG += this.Xp.fj();
    localc = this.Xo;
    if (this.Xs) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localc.WU = paramInt1;
      this.Xo.WT = (be(paramq) + this.Xo.WU);
      this.Xo.wa = this.Xp.aV(paramq);
      paramInt1 = -this.Xp.aV(paramq) + this.Xp.fj();
      break;
    }
  }
  
  private void a(a parama)
  {
    I(parama.kC, parama.XB);
  }
  
  private void a(RecyclerView.m paramm, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          a(paramInt2, paramm);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (i > paramInt2)
        {
          a(i, paramm);
          i -= 1;
        }
      }
    }
  }
  
  private void a(RecyclerView.m paramm, c paramc)
  {
    if ((!paramc.WR) || (paramc.WZ)) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (paramc.WV == -1)
      {
        i = paramc.XF;
        j = getChildCount();
        if (i >= 0)
        {
          k = this.Xp.getEnd() - i;
          if (this.Xs)
          {
            i = 0;
            while (i < j)
            {
              paramc = getChildAt(i);
              if (this.Xp.aV(paramc) < k)
              {
                a(paramm, 0, i);
                return;
              }
              i += 1;
            }
          }
          else
          {
            i = j - 1;
            while (i >= 0)
            {
              paramc = getChildAt(i);
              if (this.Xp.aV(paramc) < k)
              {
                a(paramm, j - 1, i);
                return;
              }
              i -= 1;
            }
          }
        }
      }
      else
      {
        j = paramc.XF;
        if (j >= 0)
        {
          k = getChildCount();
          if (this.Xs)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramc = getChildAt(i);
              if (this.Xp.aW(paramc) > j)
              {
                a(paramm, k - 1, i);
                return;
              }
              i -= 1;
            }
          }
          else
          {
            i = 0;
            while (i < k)
            {
              paramc = getChildAt(i);
              if (this.Xp.aW(paramc) > j)
              {
                a(paramm, 0, i);
                return;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private int b(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq, boolean paramBoolean)
  {
    int i = paramInt - this.Xp.fj();
    if (i > 0)
    {
      int j = -c(i, paramm, paramq);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.Xp.fj();
        i = j;
        if (paramInt > 0)
        {
          this.Xp.ba(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private void b(a parama)
  {
    J(parama.kC, parama.XB);
  }
  
  private int c(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.Xo.WR = true;
    eV();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, paramq);
      k = this.Xo.XF + a(paramm, this.Xo, paramq, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.Xp.ba(-paramInt);
    this.Xo.XI = paramInt;
    return paramInt;
  }
  
  private View d(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if (this.Xs) {
      return f(paramm, paramq);
    }
    return g(paramm, paramq);
  }
  
  private View e(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if (this.Xs) {
      return g(paramm, paramq);
    }
    return f(paramm, paramq);
  }
  
  private void eT()
  {
    boolean bool = true;
    if ((this.Xd == 1) || (!eU())) {
      bool = this.Xr;
    }
    for (;;)
    {
      this.Xs = bool;
      return;
      if (this.Xr) {
        bool = false;
      }
    }
  }
  
  private boolean eW()
  {
    return (this.Xp.getMode() == 0) && (this.Xp.getEnd() == 0);
  }
  
  private View eY()
  {
    if (this.Xs) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private View eZ()
  {
    if (this.Xs) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View f(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    return a(paramm, paramq, 0, getChildCount(), paramq.getItemCount());
  }
  
  private View g(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    return a(paramm, paramq, getChildCount() - 1, -1, paramq.getItemCount());
  }
  
  private int h(RecyclerView.q paramq)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    eV();
    ab localab = this.Xp;
    View localView;
    if (!this.Xu)
    {
      bool1 = true;
      localView = O(bool1);
      if (this.Xu) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ah.a(paramq, localab, localView, P(bool1), this, this.Xu, this.Xs);
      bool1 = false;
      break;
    }
  }
  
  private int i(RecyclerView.q paramq)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    eV();
    ab localab = this.Xp;
    View localView;
    if (!this.Xu)
    {
      bool1 = true;
      localView = O(bool1);
      if (this.Xu) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ah.a(paramq, localab, localView, P(bool1), this, this.Xu);
      bool1 = false;
      break;
    }
  }
  
  private int j(RecyclerView.q paramq)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    eV();
    ab localab = this.Xp;
    View localView;
    if (!this.Xu)
    {
      bool1 = true;
      localView = O(bool1);
      if (this.Xu) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ah.b(paramq, localab, localView, P(bool1), this, this.Xu);
      bool1 = false;
      break;
    }
  }
  
  public int a(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if (this.Xd == 1) {
      return 0;
    }
    return c(paramInt, paramm, paramq);
  }
  
  public int a(RecyclerView.q paramq)
  {
    int j = 0;
    if (paramq.aaG != -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = this.Xp.fl();
      }
      return j;
    }
  }
  
  public final View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    eV();
    int j = this.Xp.fj();
    int k = this.Xp.fk();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label130;
      }
      localView = getChildAt(paramInt1);
      int m = this.Xp.aV(localView);
      int n = this.Xp.aW(localView);
      if ((m >= k) || (n <= j)) {
        break label133;
      }
      if ((paramBoolean1) && ((m < j) || (n > k))) {
        break;
      }
      return localView;
    }
    if ((paramBoolean2) && (localObject == null)) {
      localObject = localView;
    }
    label130:
    label133:
    for (;;)
    {
      paramInt1 += i;
      break;
      return (View)localObject;
    }
  }
  
  View a(RecyclerView.m paramm, RecyclerView.q paramq, int paramInt1, int paramInt2, int paramInt3)
  {
    paramm = null;
    eV();
    int j = this.Xp.fj();
    int k = this.Xp.fk();
    int i;
    label35:
    View localView;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      paramq = null;
      if (paramInt1 == paramInt2) {
        break label147;
      }
      localView = getChildAt(paramInt1);
      int m = be(localView);
      if ((m < 0) || (m >= paramInt3)) {
        break label159;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).aas.isRemoved()) {
        break label105;
      }
      if (paramq != null) {
        break label159;
      }
      paramq = localView;
    }
    label105:
    label147:
    label157:
    label159:
    for (;;)
    {
      paramInt1 += i;
      break label35;
      i = -1;
      break;
      Object localObject;
      if (this.Xp.aV(localView) < k)
      {
        localObject = localView;
        if (this.Xp.aW(localView) >= j) {}
      }
      else
      {
        if (paramm != null) {
          break label159;
        }
        paramm = localView;
        continue;
        if (paramm == null) {
          break label157;
        }
        localObject = paramm;
      }
      return (View)localObject;
      return paramq;
    }
  }
  
  public View a(View paramView, int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    eT();
    if (getChildCount() == 0) {}
    label42:
    label134:
    label136:
    label142:
    for (;;)
    {
      return null;
      paramInt = aY(paramInt);
      if (paramInt != Integer.MIN_VALUE)
      {
        eV();
        if (paramInt == -1)
        {
          paramView = e(paramm, paramq);
          if (paramView == null) {
            break label134;
          }
          eV();
          a(paramInt, (int)(0.33333334F * this.Xp.fl()), false, paramq);
          this.Xo.XF = Integer.MIN_VALUE;
          this.Xo.WR = false;
          a(paramm, this.Xo, paramq, true);
          if (paramInt != -1) {
            break label136;
          }
        }
        for (paramm = eY();; paramm = eZ())
        {
          if ((paramm == paramView) || (!paramm.isFocusable())) {
            break label142;
          }
          return paramm;
          paramView = d(paramm, paramq);
          break label42;
          break;
        }
      }
    }
  }
  
  void a(RecyclerView.m paramm, RecyclerView.q paramq, a parama, int paramInt) {}
  
  void a(RecyclerView.m paramm, RecyclerView.q paramq, c paramc, b paramb)
  {
    paramm = paramc.a(paramm);
    if (paramm == null)
    {
      paramb.mFinished = true;
      return;
    }
    paramq = (RecyclerView.LayoutParams)paramm.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label63:
    int k;
    int m;
    int i;
    int j;
    label286:
    int n;
    int i1;
    if (paramc.XJ == null)
    {
      bool2 = this.Xs;
      if (paramc.WV == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label410;
        }
        super.c(paramm, -1, false);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramm.getLayoutParams();
        Rect localRect = this.aak.bc(paramm);
        k = localRect.left;
        m = localRect.right;
        i = localRect.top;
        j = localRect.bottom;
        k = RecyclerView.h.b(this.aar, this.aap, k + m + 0 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, eR());
        i = RecyclerView.h.b(this.RQ, this.aaq, j + i + 0 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, eS());
        if (a(paramm, k, i, localLayoutParams)) {
          paramm.measure(k, i);
        }
        paramb.XD = this.Xp.aX(paramm);
        if (this.Xd != 1) {
          break label533;
        }
        if (!eU()) {
          break label470;
        }
        i = this.aar - getPaddingRight();
        j = i - this.Xp.aY(paramm);
        if (paramc.WV != -1) {
          break label492;
        }
        m = paramc.wa;
        n = paramc.wa;
        i1 = paramb.XD;
        k = j;
        n -= i1;
        j = i;
        i = k;
        k = n;
      }
    }
    for (;;)
    {
      g(paramm, i + paramq.leftMargin, k + paramq.topMargin, j - paramq.rightMargin, m - paramq.bottomMargin);
      if ((paramq.aas.isRemoved()) || (paramq.aas.gs())) {
        paramb.XE = true;
      }
      paramb.OE = paramm.isFocusable();
      return;
      bool1 = false;
      break;
      label410:
      super.c(paramm, 0, false);
      break label63;
      bool2 = this.Xs;
      if (paramc.WV == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label460;
        }
        super.c(paramm, -1, true);
        break;
      }
      label460:
      super.c(paramm, 0, true);
      break label63;
      label470:
      j = getPaddingLeft();
      i = this.Xp.aY(paramm) + j;
      break label286;
      label492:
      k = paramc.wa;
      m = paramc.wa;
      i1 = paramb.XD;
      n = i;
      m += i1;
      i = j;
      j = n;
      continue;
      label533:
      k = getPaddingTop();
      m = this.Xp.aY(paramm) + k;
      if (paramc.WV == -1)
      {
        j = paramc.wa;
        i = paramc.wa - paramb.XD;
      }
      else
      {
        i = paramc.wa;
        j = paramc.wa + paramb.XD;
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new z(paramRecyclerView.getContext())
    {
      public final PointF aW(int paramAnonymousInt)
      {
        return LinearLayoutManager.this.aW(paramAnonymousInt);
      }
    };
    paramRecyclerView.aaG = paramInt;
    a(paramRecyclerView);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.m paramm)
  {
    super.a(paramRecyclerView, paramm);
    if (this.Xx)
    {
      d(paramm);
      paramm.clear();
    }
  }
  
  public final View aV(int paramInt)
  {
    int i = getChildCount();
    Object localObject;
    if (i == 0) {
      localObject = null;
    }
    View localView;
    do
    {
      return (View)localObject;
      int j = paramInt - be(getChildAt(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = getChildAt(j);
      localObject = localView;
    } while (be(localView) == paramInt);
    return super.aV(paramInt);
  }
  
  public final PointF aW(int paramInt)
  {
    int i = 1;
    int j = 0;
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < be(getChildAt(0))) {
      j = 1;
    }
    paramInt = i;
    if (j != this.Xs) {
      paramInt = -1;
    }
    if (this.Xd == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public final void aX(int paramInt)
  {
    this.Xv = paramInt;
    this.Xw = Integer.MIN_VALUE;
    if (this.Xy != null) {
      this.Xy.XK = -1;
    }
    requestLayout();
  }
  
  final int aY(int paramInt)
  {
    int j = -1;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = Integer.MIN_VALUE;
    case 1: 
    case 2: 
    case 33: 
    case 130: 
    case 17: 
      do
      {
        do
        {
          return i;
          return 1;
          i = j;
        } while (this.Xd == 1);
        return Integer.MIN_VALUE;
        if (this.Xd == 1) {
          return 1;
        }
        return Integer.MIN_VALUE;
        i = j;
      } while (this.Xd == 0);
      return Integer.MIN_VALUE;
    }
    if (this.Xd == 0) {
      return 1;
    }
    return Integer.MIN_VALUE;
  }
  
  public int b(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if (this.Xd == 0) {
      return 0;
    }
    return c(paramInt, paramm, paramq);
  }
  
  public final int b(RecyclerView.q paramq)
  {
    return h(paramq);
  }
  
  public final int c(RecyclerView.q paramq)
  {
    return h(paramq);
  }
  
  public void c(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if (((this.Xy != null) || (this.Xv != -1)) && (paramq.getItemCount() == 0))
    {
      d(paramm);
      return;
    }
    if ((this.Xy != null) && (this.Xy.fd())) {
      this.Xv = this.Xy.XK;
    }
    eV();
    this.Xo.WR = false;
    eT();
    Object localObject1 = this.Xz;
    ((a)localObject1).kC = -1;
    ((a)localObject1).XB = Integer.MIN_VALUE;
    ((a)localObject1).XC = false;
    this.Xz.XC = (this.Xs ^ this.Xt);
    Object localObject2 = this.Xz;
    int i;
    label157:
    label211:
    int j;
    label240:
    label242:
    label265:
    label290:
    int m;
    int n;
    int k;
    if ((paramq.aaW) || (this.Xv == -1))
    {
      i = 0;
      if (i == 0)
      {
        if (getChildCount() == 0) {
          break label1759;
        }
        if (this.aak != null) {
          break label1261;
        }
        localObject1 = null;
        if (localObject1 == null) {
          break label1608;
        }
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject1).getLayoutParams();
        if ((localLayoutParams.aas.isRemoved()) || (localLayoutParams.aas.ge() < 0) || (localLayoutParams.aas.ge() >= paramq.getItemCount())) {
          break label1296;
        }
        i = 1;
        if (i == 0) {
          break label1608;
        }
        j = ((a)localObject2).XA.Xp.fi();
        if (j < 0) {
          break label1301;
        }
        ((a)localObject2).aT((View)localObject1);
        i = 1;
        if (i == 0)
        {
          ((a)localObject2).fc();
          if (!this.Xt) {
            break label1764;
          }
          i = paramq.getItemCount() - 1;
          ((a)localObject2).kC = i;
        }
      }
      i = a(paramq);
      if (this.Xo.XI < 0) {
        break label1769;
      }
      j = 0;
      m = j + this.Xp.fj();
      n = i + this.Xp.getEndPadding();
      j = m;
      k = n;
      if (paramq.aaW)
      {
        j = m;
        k = n;
        if (this.Xv != -1)
        {
          j = m;
          k = n;
          if (this.Xw != Integer.MIN_VALUE)
          {
            localObject1 = aV(this.Xv);
            j = m;
            k = n;
            if (localObject1 != null)
            {
              if (!this.Xs) {
                break label1781;
              }
              i = this.Xp.fk() - this.Xp.aW((View)localObject1) - this.Xw;
              label414:
              if (i <= 0) {
                break label1813;
              }
              j = m + i;
              k = n;
            }
          }
        }
      }
      label428:
      if (!this.Xz.XC) {
        break label1831;
      }
      if (!this.Xs) {
        break label1826;
      }
      i = 1;
      label447:
      a(paramm, paramq, this.Xz, i);
      b(paramm);
      this.Xo.WZ = eW();
      this.Xo.XH = paramq.aaW;
      if (!this.Xz.XC) {
        break label1848;
      }
      b(this.Xz);
      this.Xo.XG = j;
      a(paramm, this.Xo, paramq, false);
      j = this.Xo.wa;
      m = this.Xo.WT;
      i = k;
      if (this.Xo.WS > 0) {
        i = k + this.Xo.WS;
      }
      a(this.Xz);
      this.Xo.XG = i;
      localObject1 = this.Xo;
      ((c)localObject1).WT += this.Xo.WU;
      a(paramm, this.Xo, paramq, false);
      k = this.Xo.wa;
      i = j;
      if (this.Xo.WS > 0)
      {
        i = this.Xo.WS;
        J(m, j);
        this.Xo.XG = i;
        a(paramm, this.Xo, paramq, false);
        i = this.Xo.wa;
      }
      j = i;
      i = k;
    }
    for (;;)
    {
      label690:
      if (getChildCount() > 0) {
        if ((this.Xs ^ this.Xt))
        {
          k = a(i, paramm, paramq, true);
          m = j + k;
          j = b(m, paramm, paramq, false);
          m += j;
          k = i + k + j;
        }
      }
      for (;;)
      {
        boolean bool;
        label1166:
        label1193:
        label1199:
        label1261:
        label1296:
        label1301:
        int i1;
        if ((!paramq.aaY) || (getChildCount() == 0) || (paramq.aaW) || (!eQ()))
        {
          if (!paramq.aaW)
          {
            this.Xv = -1;
            this.Xw = Integer.MIN_VALUE;
            paramm = this.Xp;
            paramm.YR = paramm.fl();
          }
          this.Xq = this.Xt;
          this.Xy = null;
          return;
          if ((this.Xv < 0) || (this.Xv >= paramq.getItemCount()))
          {
            this.Xv = -1;
            this.Xw = Integer.MIN_VALUE;
            i = 0;
            break;
          }
          ((a)localObject2).kC = this.Xv;
          if ((this.Xy != null) && (this.Xy.fd()))
          {
            ((a)localObject2).XC = this.Xy.XM;
            if (((a)localObject2).XC) {}
            for (((a)localObject2).XB = (this.Xp.fk() - this.Xy.XL);; ((a)localObject2).XB = (this.Xp.fj() + this.Xy.XL))
            {
              i = 1;
              break;
            }
          }
          if (this.Xw == Integer.MIN_VALUE)
          {
            localObject1 = aV(this.Xv);
            if (localObject1 != null) {
              if (this.Xp.aX((View)localObject1) > this.Xp.fl()) {
                ((a)localObject2).fc();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.Xp.aV((View)localObject1) - this.Xp.fj() < 0)
            {
              ((a)localObject2).XB = this.Xp.fj();
              ((a)localObject2).XC = false;
            }
            else if (this.Xp.fk() - this.Xp.aW((View)localObject1) < 0)
            {
              ((a)localObject2).XB = this.Xp.fk();
              ((a)localObject2).XC = true;
            }
            else
            {
              if (((a)localObject2).XC) {}
              for (i = this.Xp.aW((View)localObject1) + this.Xp.fi();; i = this.Xp.aV((View)localObject1))
              {
                ((a)localObject2).XB = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = be(getChildAt(0));
                if (this.Xv >= i) {
                  break label1193;
                }
                bool = true;
                if (bool != this.Xs) {
                  break label1199;
                }
              }
              for (bool = true;; bool = false)
              {
                ((a)localObject2).XC = bool;
                ((a)localObject2).fc();
                break;
                bool = false;
                break label1166;
              }
              ((a)localObject2).XC = this.Xs;
              if (this.Xs) {
                ((a)localObject2).XB = (this.Xp.fk() - this.Xw);
              } else {
                ((a)localObject2).XB = (this.Xp.fj() + this.Xw);
              }
            }
          }
          localObject1 = this.aak.getFocusedChild();
          if ((localObject1 == null) || (this.Za.aP((View)localObject1)))
          {
            localObject1 = null;
            break label157;
          }
          break label157;
          i = 0;
          break label211;
          ((a)localObject2).kC = be((View)localObject1);
          if (((a)localObject2).XC)
          {
            i = ((a)localObject2).XA.Xp.fk() - j - ((a)localObject2).XA.Xp.aW((View)localObject1);
            ((a)localObject2).XB = (((a)localObject2).XA.Xp.fk() - i);
            if (i <= 0) {
              break label240;
            }
            j = ((a)localObject2).XA.Xp.aX((View)localObject1);
            k = ((a)localObject2).XB;
            m = ((a)localObject2).XA.Xp.fj();
            j = k - j - (Math.min(((a)localObject2).XA.Xp.aV((View)localObject1) - m, 0) + m);
            if (j >= 0) {
              break label240;
            }
            k = ((a)localObject2).XB;
            ((a)localObject2).XB = (Math.min(i, -j) + k);
            break label240;
          }
          k = ((a)localObject2).XA.Xp.aV((View)localObject1);
          i = k - ((a)localObject2).XA.Xp.fj();
          ((a)localObject2).XB = k;
          if (i <= 0) {
            break label240;
          }
          m = ((a)localObject2).XA.Xp.aX((View)localObject1);
          n = ((a)localObject2).XA.Xp.fk();
          i1 = ((a)localObject2).XA.Xp.aW((View)localObject1);
          j = ((a)localObject2).XA.Xp.fk() - Math.min(0, n - j - i1) - (k + m);
          if (j >= 0) {
            break label240;
          }
          ((a)localObject2).XB -= Math.min(i, -j);
          break label240;
          label1608:
          if (this.Xq == this.Xt)
          {
            if (((a)localObject2).XC)
            {
              localObject1 = d(paramm, paramq);
              label1635:
              if (localObject1 == null) {
                break label1759;
              }
              ((a)localObject2).aT((View)localObject1);
              if ((!paramq.aaW) && (eQ()))
              {
                if ((this.Xp.aV((View)localObject1) < this.Xp.fk()) && (this.Xp.aW((View)localObject1) >= this.Xp.fj())) {
                  break label1743;
                }
                i = 1;
                label1701:
                if (i != 0) {
                  if (!((a)localObject2).XC) {
                    break label1748;
                  }
                }
              }
            }
            label1743:
            label1748:
            for (i = this.Xp.fk();; i = this.Xp.fj())
            {
              ((a)localObject2).XB = i;
              i = 1;
              break;
              localObject1 = e(paramm, paramq);
              break label1635;
              i = 0;
              break label1701;
            }
          }
          label1759:
          i = 0;
          break label242;
          label1764:
          i = 0;
          break label265;
          label1769:
          k = 0;
          j = i;
          i = k;
          break label290;
          label1781:
          i = this.Xp.aV((View)localObject1);
          j = this.Xp.fj();
          i = this.Xw - (i - j);
          break label414;
          label1813:
          k = n - i;
          j = m;
          break label428;
          label1826:
          i = -1;
          break label447;
          label1831:
          if (this.Xs)
          {
            i = -1;
            break label447;
          }
          i = 1;
          break label447;
          label1848:
          a(this.Xz);
          this.Xo.XG = k;
          a(paramm, this.Xo, paramq, false);
          k = this.Xo.wa;
          m = this.Xo.WT;
          i = j;
          if (this.Xo.WS > 0) {
            i = j + this.Xo.WS;
          }
          b(this.Xz);
          this.Xo.XG = i;
          localObject1 = this.Xo;
          ((c)localObject1).WT += this.Xo.WU;
          a(paramm, this.Xo, paramq, false);
          i = this.Xo.wa;
          if (this.Xo.WS <= 0) {
            break label2418;
          }
          j = this.Xo.WS;
          I(m, k);
          this.Xo.XG = j;
          a(paramm, this.Xo, paramq, false);
          k = this.Xo.wa;
          j = i;
          i = k;
          break label690;
          k = b(j, paramm, paramq, true);
          i += k;
          n = a(i, paramm, paramq, false);
          m = j + k + n;
          k = i + n;
          continue;
        }
        i = 0;
        j = 0;
        localObject1 = paramm.aaB;
        int i2 = ((List)localObject1).size();
        int i3 = be(getChildAt(0));
        n = 0;
        label2123:
        if (n < i2)
        {
          localObject2 = (RecyclerView.t)((List)localObject1).get(n);
          if (((RecyclerView.t)localObject2).isRemoved()) {
            break label2395;
          }
          if (((RecyclerView.t)localObject2).ge() < i3)
          {
            bool = true;
            label2165:
            if (bool == this.Xs) {
              break label2235;
            }
            i1 = -1;
            label2177:
            if (i1 != -1) {
              break label2241;
            }
            i1 = this.Xp.aX(((RecyclerView.t)localObject2).abf) + i;
            i = j;
            j = i1;
          }
        }
        for (;;)
        {
          i1 = n + 1;
          n = j;
          j = i;
          i = n;
          n = i1;
          break label2123;
          bool = false;
          break label2165;
          label2235:
          i1 = 1;
          break label2177;
          label2241:
          i1 = this.Xp.aX(((RecyclerView.t)localObject2).abf) + j;
          j = i;
          i = i1;
          continue;
          this.Xo.XJ = ((List)localObject1);
          if (i > 0)
          {
            J(be(eY()), m);
            this.Xo.XG = i;
            this.Xo.WS = 0;
            this.Xo.aU(null);
            a(paramm, this.Xo, paramq, false);
          }
          if (j > 0)
          {
            I(be(eZ()), k);
            this.Xo.XG = j;
            this.Xo.WS = 0;
            this.Xo.aU(null);
            a(paramm, this.Xo, paramq, false);
          }
          this.Xo.XJ = null;
          break;
          label2395:
          i1 = i;
          i = j;
          j = i1;
        }
        k = i;
        m = j;
      }
      label2418:
      j = k;
      k = i;
      i = j;
      j = k;
    }
  }
  
  public final int d(RecyclerView.q paramq)
  {
    return i(paramq);
  }
  
  public final int e(RecyclerView.q paramq)
  {
    return i(paramq);
  }
  
  public RecyclerView.LayoutParams eN()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public boolean eQ()
  {
    return (this.Xy == null) && (this.Xq == this.Xt);
  }
  
  public final boolean eR()
  {
    return this.Xd == 0;
  }
  
  public final boolean eS()
  {
    return this.Xd == 1;
  }
  
  protected final boolean eU()
  {
    return android.support.v4.view.z.J(this.aak) == 1;
  }
  
  final void eV()
  {
    if (this.Xo == null) {
      this.Xo = new c();
    }
    if (this.Xp == null) {
      switch (this.Xd)
      {
      default: 
        throw new IllegalArgumentException("invalid orientation");
      }
    }
    for (Object localObject = new ab.1(this);; localObject = new ab.2(this))
    {
      this.Xp = ((ab)localObject);
      return;
    }
  }
  
  final boolean eX()
  {
    if ((this.aaq != 1073741824) && (this.aap != 1073741824))
    {
      int j = getChildCount();
      int i = 0;
      if (i < j)
      {
        ViewGroup.LayoutParams localLayoutParams = getChildAt(i).getLayoutParams();
        if ((localLayoutParams.width >= 0) || (localLayoutParams.height >= 0)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label75;
        }
        return true;
        i += 1;
        break;
      }
    }
    label75:
    return false;
  }
  
  public final int f(RecyclerView.q paramq)
  {
    return j(paramq);
  }
  
  public final int fa()
  {
    View localView = a(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return be(localView);
  }
  
  public final int fb()
  {
    View localView = a(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return be(localView);
  }
  
  public final int g(RecyclerView.q paramq)
  {
    return j(paramq);
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent = a.a(paramAccessibilityEvent);
      paramAccessibilityEvent.setFromIndex(fa());
      paramAccessibilityEvent.setToIndex(fb());
    }
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.Xy = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.Xy != null) {
      return new SavedState(this.Xy);
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      eV();
      boolean bool = this.Xq ^ this.Xs;
      localSavedState.XM = bool;
      if (bool)
      {
        localView = eZ();
        localSavedState.XL = (this.Xp.fk() - this.Xp.aW(localView));
        localSavedState.XK = be(localView);
        return localSavedState;
      }
      View localView = eY();
      localSavedState.XK = be(localView);
      localSavedState.XL = (this.Xp.aV(localView) - this.Xp.fj());
      return localSavedState;
    }
    localSavedState.XK = -1;
    return localSavedState;
  }
  
  public final void q(String paramString)
  {
    if (this.Xy == null) {
      super.q(paramString);
    }
  }
  
  public final void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
    }
    q(null);
    if (paramInt == this.Xd) {
      return;
    }
    this.Xd = paramInt;
    this.Xp = null;
    requestLayout();
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int XK;
    int XL;
    boolean XM;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.XK = paramParcel.readInt();
      this.XL = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.XM = bool;
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.XK = paramSavedState.XK;
      this.XL = paramSavedState.XL;
      this.XM = paramSavedState.XM;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final boolean fd()
    {
      return this.XK >= 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.XK);
      paramParcel.writeInt(this.XL);
      if (this.XM) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  final class a
  {
    int XB;
    boolean XC;
    int kC;
    
    a() {}
    
    public final void aT(View paramView)
    {
      if (this.XC) {}
      for (this.XB = (LinearLayoutManager.this.Xp.aW(paramView) + LinearLayoutManager.this.Xp.fi());; this.XB = LinearLayoutManager.this.Xp.aV(paramView))
      {
        this.kC = LinearLayoutManager.be(paramView);
        return;
      }
    }
    
    final void fc()
    {
      if (this.XC) {}
      for (int i = LinearLayoutManager.this.Xp.fk();; i = LinearLayoutManager.this.Xp.fj())
      {
        this.XB = i;
        return;
      }
    }
    
    public final String toString()
    {
      return "AnchorInfo{mPosition=" + this.kC + ", mCoordinate=" + this.XB + ", mLayoutFromEnd=" + this.XC + '}';
    }
  }
  
  protected static final class b
  {
    public boolean OE;
    public int XD;
    public boolean XE;
    public boolean mFinished;
  }
  
  static final class c
  {
    boolean WR = true;
    int WS;
    int WT;
    int WU;
    int WV;
    boolean WZ;
    int XF;
    int XG = 0;
    boolean XH = false;
    int XI;
    List<RecyclerView.t> XJ = null;
    int wa;
    
    final View a(RecyclerView.m paramm)
    {
      if (this.XJ != null)
      {
        int j = this.XJ.size();
        int i = 0;
        while (i < j)
        {
          paramm = ((RecyclerView.t)this.XJ.get(i)).abf;
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramm.getLayoutParams();
          if ((!localLayoutParams.aas.isRemoved()) && (this.WT == localLayoutParams.aas.ge()))
          {
            aU(paramm);
            return paramm;
          }
          i += 1;
        }
        return null;
      }
      paramm = paramm.bk(this.WT);
      this.WT += this.WU;
      return paramm;
    }
    
    public final void aU(View paramView)
    {
      int m = this.XJ.size();
      Object localObject = null;
      int i = Integer.MAX_VALUE;
      int j = 0;
      if (j < m)
      {
        View localView = ((RecyclerView.t)this.XJ.get(j)).abf;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((localView == paramView) || (localLayoutParams.aas.isRemoved())) {
          break label154;
        }
        int k = (localLayoutParams.aas.ge() - this.WT) * this.WU;
        if ((k < 0) || (k >= i)) {
          break label154;
        }
        localObject = localView;
        if (k != 0)
        {
          localObject = localView;
          i = k;
        }
      }
      label154:
      for (;;)
      {
        j += 1;
        break;
        if (localObject == null)
        {
          this.WT = -1;
          return;
        }
        this.WT = ((RecyclerView.LayoutParams)((View)localObject).getLayoutParams()).aas.ge();
        return;
      }
    }
    
    final boolean k(RecyclerView.q paramq)
    {
      return (this.WT >= 0) && (this.WT < paramq.getItemCount());
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/LinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */