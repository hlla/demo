package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.l;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public final class GridLayoutManager
  extends LinearLayoutManager
{
  boolean WF = false;
  public int WG = -1;
  int[] WH;
  View[] WI;
  final SparseIntArray WJ = new SparseIntArray();
  final SparseIntArray WK = new SparseIntArray();
  public b WL = new a();
  final Rect WM = new Rect();
  
  public GridLayoutManager()
  {
    super(1, false);
    aS(4);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt)
  {
    aS(paramInt);
  }
  
  private int a(RecyclerView.m paramm, RecyclerView.q paramq, int paramInt)
  {
    if (!paramq.aaW) {
      return this.WL.F(paramInt, this.WG);
    }
    paramInt = paramm.bj(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.WL.F(paramInt, this.WG);
  }
  
  private void a(RecyclerView.m paramm, RecyclerView.q paramq, int paramInt, boolean paramBoolean)
  {
    int j;
    int i;
    int k;
    int m;
    int n;
    label53:
    LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      j = 1;
      i = 0;
      k = paramInt;
      paramInt = i;
      if ((this.Xd != 1) || (!eU())) {
        break label164;
      }
      m = this.WG - 1;
      n = -1;
      i = paramInt;
      paramInt = m;
      m = n;
      if (i == k) {
        return;
      }
      View localView = this.WI[i];
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      LayoutParams.a(localLayoutParams, c(paramm, paramq, be(localView)));
      if ((m != -1) || (LayoutParams.b(localLayoutParams) <= 1)) {
        break label179;
      }
      LayoutParams.b(localLayoutParams, paramInt - (LayoutParams.b(localLayoutParams) - 1));
    }
    for (;;)
    {
      n = LayoutParams.b(localLayoutParams);
      i += j;
      paramInt = n * m + paramInt;
      break label53;
      paramInt -= 1;
      j = -1;
      k = -1;
      break;
      label164:
      n = 0;
      i = paramInt;
      m = 1;
      paramInt = n;
      break label53;
      label179:
      LayoutParams.b(localLayoutParams, paramInt);
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramView, this.WM);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i;
    if (!paramBoolean1)
    {
      i = paramInt1;
      if (this.Xd != 1) {}
    }
    else
    {
      i = i(paramInt1, localLayoutParams.leftMargin + this.WM.left, localLayoutParams.rightMargin + this.WM.right);
    }
    if (!paramBoolean1)
    {
      paramInt1 = paramInt2;
      if (this.Xd != 0) {}
    }
    else
    {
      paramInt1 = i(paramInt2, localLayoutParams.topMargin + this.WM.top, localLayoutParams.bottomMargin + this.WM.bottom);
    }
    if (paramBoolean2) {
      if ((!this.aao) || (!RecyclerView.h.k(paramView.getMeasuredWidth(), i, localLayoutParams.width)) || (!RecyclerView.h.k(paramView.getMeasuredHeight(), paramInt1, localLayoutParams.height))) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        paramView.measure(i, paramInt1);
      }
      return;
      paramBoolean1 = false;
      continue;
      paramBoolean1 = a(paramView, i, paramInt1, localLayoutParams);
    }
  }
  
  private void aR(int paramInt)
  {
    int k = 0;
    int[] arrayOfInt2 = this.WH;
    int n = this.WG;
    int[] arrayOfInt1;
    if ((arrayOfInt2 != null) && (arrayOfInt2.length == n + 1))
    {
      arrayOfInt1 = arrayOfInt2;
      if (arrayOfInt2[(arrayOfInt2.length - 1)] == paramInt) {}
    }
    else
    {
      arrayOfInt1 = new int[n + 1];
    }
    arrayOfInt1[0] = 0;
    int m = paramInt / n;
    int i1 = paramInt % n;
    int i = 1;
    int j = 0;
    paramInt = k;
    if (i <= n)
    {
      paramInt += i1;
      if ((paramInt <= 0) || (n - paramInt >= i1)) {
        break label137;
      }
      k = m + 1;
      paramInt -= n;
    }
    for (;;)
    {
      j += k;
      arrayOfInt1[i] = j;
      i += 1;
      break;
      this.WH = arrayOfInt1;
      return;
      label137:
      k = m;
    }
  }
  
  private int b(RecyclerView.m paramm, RecyclerView.q paramq, int paramInt)
  {
    int i;
    if (!paramq.aaW) {
      i = this.WL.E(paramInt, this.WG);
    }
    int j;
    do
    {
      return i;
      j = this.WK.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramm.bj(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.WL.E(paramInt, this.WG);
  }
  
  private int c(RecyclerView.m paramm, RecyclerView.q paramq, int paramInt)
  {
    int i;
    if (!paramq.aaW) {
      i = this.WL.aT(paramInt);
    }
    int j;
    do
    {
      return i;
      j = this.WJ.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramm.bj(paramInt);
    if (paramInt == -1) {
      return 1;
    }
    return this.WL.aT(paramInt);
  }
  
  private void eO()
  {
    if (this.Xd == 1) {}
    for (int i = this.aar - getPaddingRight() - getPaddingLeft();; i = this.RQ - getPaddingBottom() - getPaddingTop())
    {
      aR(i);
      return;
    }
  }
  
  private void eP()
  {
    if ((this.WI == null) || (this.WI.length != this.WG)) {
      this.WI = new View[this.WG];
    }
  }
  
  private static int i(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    int i;
    do
    {
      return paramInt1;
      i = View.MeasureSpec.getMode(paramInt1);
    } while ((i != Integer.MIN_VALUE) && (i != 1073741824));
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
  }
  
  public final void A(int paramInt1, int paramInt2)
  {
    this.WL.WP.clear();
  }
  
  public final void B(int paramInt1, int paramInt2)
  {
    this.WL.WP.clear();
  }
  
  public final void C(int paramInt1, int paramInt2)
  {
    this.WL.WP.clear();
  }
  
  public final int a(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    eO();
    eP();
    return super.a(paramInt, paramm, paramq);
  }
  
  public final int a(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if (this.Xd == 0) {
      return this.WG;
    }
    if (paramq.getItemCount() <= 0) {
      return 0;
    }
    return a(paramm, paramq, paramq.getItemCount() - 1) + 1;
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  final View a(RecyclerView.m paramm, RecyclerView.q paramq, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    eV();
    int j = this.Xp.fj();
    int k = this.Xp.fk();
    int i;
    Object localObject2;
    label37:
    View localView;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject2 = null;
      if (paramInt1 == paramInt2) {
        break label164;
      }
      localView = getChildAt(paramInt1);
      int m = be(localView);
      if ((m < 0) || (m >= paramInt3) || (b(paramm, paramq, m) != 0)) {
        break label179;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).aas.isRemoved()) {
        break label120;
      }
      if (localObject2 != null) {
        break label179;
      }
      localObject2 = localView;
    }
    label120:
    label164:
    label176:
    label179:
    for (;;)
    {
      paramInt1 += i;
      break label37;
      i = -1;
      break;
      Object localObject3;
      if (this.Xp.aV(localView) < k)
      {
        localObject3 = localView;
        if (this.Xp.aW(localView) >= j) {}
      }
      else
      {
        if (localObject1 != null) {
          break label179;
        }
        localObject1 = localView;
        continue;
        if (localObject1 == null) {
          break label176;
        }
        localObject3 = localObject1;
      }
      return (View)localObject3;
      return (View)localObject2;
    }
  }
  
  public final View a(View paramView, int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    View localView = bf(paramView);
    if (localView == null) {
      paramm = null;
    }
    LayoutParams localLayoutParams;
    int i4;
    int i5;
    int i8;
    label83:
    int m;
    int k;
    label100:
    int n;
    label118:
    int i;
    int j;
    int i1;
    label129:
    int i6;
    int i7;
    do
    {
      return paramm;
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      i4 = LayoutParams.a(localLayoutParams);
      i5 = LayoutParams.a(localLayoutParams) + LayoutParams.b(localLayoutParams);
      if (super.a(paramView, paramInt, paramm, paramq) == null) {
        return null;
      }
      if (aY(paramInt) != 1) {
        break label258;
      }
      i8 = 1;
      if (i8 == this.Xs) {
        break label264;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label269;
      }
      paramInt = getChildCount() - 1;
      m = -1;
      k = -1;
      if ((this.Xd != 1) || (!eU())) {
        break label283;
      }
      n = 1;
      paramView = null;
      i = -1;
      j = 0;
      i1 = paramInt;
      if (i1 == k) {
        break label361;
      }
      paramq = getChildAt(i1);
      if (paramq == localView) {
        break label361;
      }
      if (!paramq.isFocusable()) {
        break label363;
      }
      localLayoutParams = (LayoutParams)paramq.getLayoutParams();
      i6 = LayoutParams.a(localLayoutParams);
      i7 = LayoutParams.a(localLayoutParams) + LayoutParams.b(localLayoutParams);
      if (i6 != i4) {
        break;
      }
      paramm = paramq;
    } while (i7 == i5);
    int i3 = 0;
    if (paramView == null)
    {
      paramInt = 1;
      label215:
      if (paramInt == 0) {
        break label363;
      }
      i = LayoutParams.a(localLayoutParams);
      paramInt = Math.min(i7, i5) - Math.max(i6, i4);
      paramView = paramq;
    }
    for (;;)
    {
      i1 += m;
      j = paramInt;
      break label129;
      label258:
      i8 = 0;
      break;
      label264:
      paramInt = 0;
      break label83;
      label269:
      k = getChildCount();
      paramInt = 0;
      m = 1;
      break label100;
      label283:
      n = 0;
      break label118;
      paramInt = Math.max(i6, i4);
      int i2 = Math.min(i7, i5) - paramInt;
      if (i2 > j)
      {
        paramInt = 1;
        break label215;
      }
      paramInt = i3;
      if (i2 != j) {
        break label215;
      }
      if (i6 > i) {}
      for (i2 = 1;; i2 = 0)
      {
        paramInt = i3;
        if (n != i2) {
          break;
        }
        paramInt = 1;
        break;
      }
      label361:
      return paramView;
      label363:
      paramInt = j;
    }
  }
  
  public final void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.WH == null) {
      super.a(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.Xd == 1)
    {
      paramInt2 = j(paramInt2, j + paramRect.height(), z.U(this.aak));
      paramInt1 = j(paramInt1, i + this.WH[(this.WH.length - 1)], z.T(this.aak));
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = j(paramInt1, i + paramRect.width(), z.T(this.aak));
      paramInt2 = j(paramInt2, j + this.WH[(this.WH.length - 1)], z.U(this.aak));
    }
  }
  
  final void a(RecyclerView.m paramm, RecyclerView.q paramq, LinearLayoutManager.a parama, int paramInt)
  {
    int i = 1;
    super.a(paramm, paramq, parama, paramInt);
    eO();
    if ((paramq.getItemCount() > 0) && (!paramq.aaW))
    {
      if (paramInt == 1) {}
      for (paramInt = i;; paramInt = 0)
      {
        i = b(paramm, paramq, parama.kC);
        if (paramInt == 0) {
          break;
        }
        while ((i > 0) && (parama.kC > 0))
        {
          parama.kC -= 1;
          i = b(paramm, paramq, parama.kC);
        }
      }
      int k = paramq.getItemCount();
      paramInt = parama.kC;
      while (paramInt < k - 1)
      {
        int j = b(paramm, paramq, paramInt + 1);
        if (j <= i) {
          break;
        }
        paramInt += 1;
        i = j;
      }
      parama.kC = paramInt;
    }
    eP();
  }
  
  final void a(RecyclerView.m paramm, RecyclerView.q paramq, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    int i2 = this.Xp.fm();
    int j;
    int k;
    label37:
    boolean bool1;
    label57:
    int i;
    int n;
    if (i2 != 1073741824)
    {
      j = 1;
      if (getChildCount() <= 0) {
        break label203;
      }
      k = this.WH[this.WG];
      if (j != 0) {
        eO();
      }
      if (paramc.WU != 1) {
        break label209;
      }
      bool1 = true;
      i = this.WG;
      if (bool1) {
        break label1408;
      }
      i = b(paramm, paramq, paramc.WT) + c(paramm, paramq, paramc.WT);
      n = 0;
    }
    for (;;)
    {
      int i1;
      if ((n < this.WG) && (paramc.k(paramq)) && (i > 0))
      {
        m = paramc.WT;
        i1 = c(paramm, paramq, m);
        if (i1 > this.WG)
        {
          throw new IllegalArgumentException("Item at position " + m + " requires " + i1 + " spans but GridLayoutManager has only " + this.WG + " spans.");
          j = 0;
          break;
          label203:
          k = 0;
          break label37;
          label209:
          bool1 = false;
          break label57;
        }
        i -= i1;
        if (i >= 0)
        {
          View localView = paramc.a(paramm);
          if (localView != null)
          {
            this.WI[n] = localView;
            n += 1;
            continue;
          }
        }
      }
      if (n == 0)
      {
        paramb.mFinished = true;
        return;
      }
      i = 0;
      float f1 = 0.0F;
      a(paramm, paramq, n, bool1);
      int m = 0;
      label322:
      int i3;
      int i4;
      label370:
      label418:
      boolean bool2;
      if (m < n)
      {
        paramm = this.WI[m];
        if (paramc.XJ == null) {
          if (bool1)
          {
            super.c(paramm, -1, false);
            paramq = (LayoutParams)paramm.getLayoutParams();
            i3 = this.WH[(LayoutParams.a(paramq) + LayoutParams.b(paramq))];
            i4 = this.WH[LayoutParams.a(paramq)];
            if (this.Xd != 0) {
              break label558;
            }
            i1 = paramq.height;
            i3 = b(i3 - i4, i2, 0, i1, false);
            i4 = this.Xp.fl();
            int i5 = this.Xp.getMode();
            if (this.Xd != 1) {
              break label567;
            }
            i1 = paramq.height;
            i1 = b(i4, i5, 0, i1, true);
            if (this.Xd != 1) {
              break label582;
            }
            if (paramq.height != -1) {
              break label576;
            }
            bool2 = true;
            label450:
            a(paramm, i3, i1, bool2, false);
            i1 = this.Xp.aX(paramm);
            if (i1 <= i) {
              break label1405;
            }
            i = i1;
          }
        }
      }
      label558:
      label567:
      label576:
      label582:
      label712:
      label760:
      label792:
      label831:
      label840:
      label858:
      label946:
      label990:
      label999:
      label1096:
      label1318:
      label1354:
      label1390:
      label1399:
      label1405:
      for (;;)
      {
        float f2 = this.Xp.aY(paramm) * 1.0F / LayoutParams.b(paramq);
        if (f2 > f1) {
          f1 = f2;
        }
        for (;;)
        {
          m += 1;
          break;
          super.c(paramm, 0, false);
          break label322;
          if (bool1)
          {
            super.c(paramm, -1, true);
            break label322;
          }
          super.c(paramm, 0, true);
          break label322;
          i1 = paramq.width;
          break label370;
          i1 = paramq.width;
          break label418;
          bool2 = false;
          break label450;
          if (paramq.width == -1) {}
          for (bool2 = true;; bool2 = false)
          {
            a(paramm, i1, i3, bool2, false);
            break;
          }
          if (j != 0)
          {
            aR(Math.max(Math.round(this.WG * f1), k));
            i = 0;
            k = 0;
            j = i;
            if (k >= n) {
              break label858;
            }
            paramm = this.WI[k];
            paramq = (LayoutParams)paramm.getLayoutParams();
            m = this.WH[(LayoutParams.a(paramq) + LayoutParams.b(paramq))];
            i1 = this.WH[LayoutParams.a(paramq)];
            if (this.Xd == 0)
            {
              j = paramq.height;
              m = b(m - i1, 1073741824, 0, j, false);
              i1 = this.Xp.fl();
              i2 = this.Xp.getMode();
              if (this.Xd != 1) {
                break label831;
              }
              j = paramq.height;
              j = b(i1, i2, 0, j, true);
              if (this.Xd != 1) {
                break label840;
              }
              a(paramm, m, j, false, true);
              j = this.Xp.aX(paramm);
              if (j <= i) {
                break label1399;
              }
              i = j;
            }
          }
          for (;;)
          {
            k += 1;
            break;
            j = paramq.width;
            break label712;
            j = paramq.width;
            break label760;
            a(paramm, j, m, false, true);
            break label792;
            j = i;
            m = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
            i = 0;
            if (i < n)
            {
              paramm = this.WI[i];
              if (this.Xp.aX(paramm) != j)
              {
                paramq = (LayoutParams)paramm.getLayoutParams();
                i1 = this.WH[(LayoutParams.a(paramq) + LayoutParams.b(paramq))];
                i2 = this.WH[LayoutParams.a(paramq)];
                if (this.Xd != 0) {
                  break label990;
                }
                k = paramq.height;
                k = b(i1 - i2, 1073741824, 0, k, false);
                if (this.Xd != 1) {
                  break label999;
                }
                a(paramm, k, m, true, true);
              }
              for (;;)
              {
                i += 1;
                break;
                k = paramq.width;
                break label946;
                a(paramm, m, k, true, true);
              }
            }
            paramb.XD = j;
            m = 0;
            k = 0;
            i1 = 0;
            i = 0;
            if (this.Xd == 1) {
              if (paramc.WV == -1)
              {
                i = paramc.wa;
                j = i - j;
                i4 = 0;
                i1 = k;
                i2 = j;
                i3 = i;
                k = i4;
                j = m;
                i = i1;
                m = i2;
                i1 = i3;
                if (k >= n) {
                  break label1390;
                }
                paramm = this.WI[k];
                paramq = (LayoutParams)paramm.getLayoutParams();
                if (this.Xd != 1) {
                  break label1354;
                }
                if (!eU()) {
                  break label1318;
                }
                i = getPaddingLeft() + this.WH[(LayoutParams.a(paramq) + LayoutParams.b(paramq))];
                j = i - this.Xp.aY(paramm);
              }
            }
            for (;;)
            {
              g(paramm, paramq.leftMargin + j, paramq.topMargin + m, i - paramq.rightMargin, i1 - paramq.bottomMargin);
              if ((paramq.aas.isRemoved()) || (paramq.aas.gs())) {
                paramb.XE = true;
              }
              paramb.OE |= paramm.isFocusable();
              k += 1;
              break label1096;
              i1 = paramc.wa;
              i = i1 + j;
              j = i1;
              break;
              if (paramc.WV == -1)
              {
                k = paramc.wa;
                m = k - j;
                j = i1;
                break;
              }
              m = paramc.wa;
              k = m + j;
              j = i1;
              break;
              i = getPaddingLeft();
              j = this.WH[LayoutParams.a(paramq)] + i;
              i = this.Xp.aY(paramm) + j;
              continue;
              m = getPaddingTop();
              m = this.WH[LayoutParams.a(paramq)] + m;
              i1 = this.Xp.aY(paramm) + m;
            }
            Arrays.fill(this.WI, null);
            return;
          }
        }
      }
      label1408:
      n = 0;
    }
  }
  
  public final void a(RecyclerView.m paramm, RecyclerView.q paramq, View paramView, b paramb)
  {
    boolean bool2 = false;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.b(paramView, paramb);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = a(paramm, paramq, paramView.aas.ge());
    if (this.Xd == 0)
    {
      j = paramView.WN;
      k = paramView.WO;
      if ((this.WG > 1) && (paramView.WO == this.WG)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramb.k(b.l.a(j, k, i, 1, bool1));
        return;
      }
    }
    int j = paramView.WN;
    int k = paramView.WO;
    boolean bool1 = bool2;
    if (this.WG > 1)
    {
      bool1 = bool2;
      if (paramView.WO == this.WG) {
        bool1 = true;
      }
    }
    paramb.k(b.l.a(i, 1, j, k, bool1));
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final void aS(int paramInt)
  {
    if (paramInt == this.WG) {
      return;
    }
    this.WF = true;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Span count should be at least 1. Provided " + paramInt);
    }
    this.WG = paramInt;
    this.WL.WP.clear();
  }
  
  public final int b(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    eO();
    eP();
    return super.b(paramInt, paramm, paramq);
  }
  
  public final int b(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if (this.Xd == 1) {
      return this.WG;
    }
    if (paramq.getItemCount() <= 0) {
      return 0;
    }
    return a(paramm, paramq, paramq.getItemCount() - 1) + 1;
  }
  
  public final void c(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if (paramq.aaW)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        int k = localLayoutParams.aas.ge();
        this.WJ.put(k, localLayoutParams.WO);
        this.WK.put(k, localLayoutParams.WN);
        i += 1;
      }
    }
    super.c(paramm, paramq);
    this.WJ.clear();
    this.WK.clear();
    if (!paramq.aaW) {
      this.WF = false;
    }
  }
  
  public final RecyclerView.LayoutParams e(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public final void eM()
  {
    this.WL.WP.clear();
  }
  
  public final RecyclerView.LayoutParams eN()
  {
    if (this.Xd == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public final boolean eQ()
  {
    return (this.Xy == null) && (!this.WF);
  }
  
  public final void z(int paramInt1, int paramInt2)
  {
    this.WL.WP.clear();
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    int WN = -1;
    int WO = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static final class a
    extends GridLayoutManager.b
  {
    public final int D(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
    
    public final int aT(int paramInt)
    {
      return 1;
    }
  }
  
  public static abstract class b
  {
    final SparseIntArray WP = new SparseIntArray();
    private boolean WQ = false;
    
    public int D(int paramInt1, int paramInt2)
    {
      int n = aT(paramInt1);
      if (n == paramInt2) {
        return 0;
      }
      int j;
      int i;
      int k;
      if ((this.WQ) && (this.WP.size() > 0))
      {
        j = this.WP.size() - 1;
        i = 0;
        while (i <= j)
        {
          k = i + j >>> 1;
          if (this.WP.keyAt(k) < paramInt1) {
            i = k + 1;
          } else {
            j = k - 1;
          }
        }
        i -= 1;
        if ((i >= 0) && (i < this.WP.size()))
        {
          i = this.WP.keyAt(i);
          if (i < 0) {
            break label216;
          }
          j = this.WP.get(i) + aT(i);
          k = i + 1;
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        label149:
        if (j < paramInt1)
        {
          k = aT(j);
          int m = i + k;
          if (m == paramInt2) {
            i = 0;
          }
          for (;;)
          {
            j += 1;
            break label149;
            i = -1;
            break;
            i = k;
            if (m <= paramInt2) {
              i = m;
            }
          }
        }
        if (i + n > paramInt2) {
          break;
        }
        return i;
        label216:
        j = 0;
        i = 0;
      }
    }
    
    final int E(int paramInt1, int paramInt2)
    {
      int i;
      if (!this.WQ) {
        i = D(paramInt1, paramInt2);
      }
      int j;
      do
      {
        return i;
        j = this.WP.get(paramInt1, -1);
        i = j;
      } while (j != -1);
      paramInt2 = D(paramInt1, paramInt2);
      this.WP.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public final int F(int paramInt1, int paramInt2)
    {
      int n = aT(paramInt1);
      int k = 0;
      int i = 0;
      int j = 0;
      int m;
      if (k < paramInt1)
      {
        m = aT(k);
        j += m;
        if (j == paramInt2)
        {
          j = i + 1;
          i = 0;
        }
      }
      for (;;)
      {
        m = k + 1;
        k = i;
        i = j;
        j = k;
        k = m;
        break;
        if (j > paramInt2)
        {
          j = i + 1;
          i = m;
          continue;
          paramInt1 = i;
          if (j + n > paramInt2) {
            paramInt1 = i + 1;
          }
          return paramInt1;
        }
        else
        {
          m = j;
          j = i;
          i = m;
        }
      }
    }
    
    public abstract int aT(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/GridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */