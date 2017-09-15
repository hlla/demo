package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.l;
import android.support.v4.view.a.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public final class StaggeredGridLayoutManager
  extends RecyclerView.h
{
  private int WG;
  public int Xd;
  public boolean Xr;
  boolean Xs;
  private boolean Xu;
  int Xv;
  int Xw;
  private b[] acY;
  ab acZ;
  ab ada;
  private int adb;
  private final y adc;
  private BitSet add;
  LazySpanLookup ade;
  private int adf;
  private boolean adg;
  private boolean adh;
  private SavedState adi;
  private int adj;
  private final a adk;
  private boolean adl;
  private final Runnable adm;
  private final Rect gG;
  
  private View Z(boolean paramBoolean)
  {
    int j = this.acZ.fj();
    int k = this.acZ.fk();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.acZ.aV(localView);
      if ((this.acZ.aW(localView) <= j) || (n >= k)) {
        break label104;
      }
      if ((n >= j) || (!paramBoolean)) {
        return localView;
      }
      if (localObject != null) {
        break label104;
      }
      localObject = localView;
    }
    label104:
    for (;;)
    {
      i += 1;
      break;
      return (View)localObject;
    }
  }
  
  private int a(RecyclerView.m paramm, y paramy, RecyclerView.q paramq)
  {
    this.add.set(0, this.WG, true);
    int i;
    int n;
    label61:
    int j;
    int k;
    label85:
    View localView;
    LayoutParams localLayoutParams;
    int i4;
    label181:
    int i1;
    if (this.adc.WZ) {
      if (paramy.WV == 1)
      {
        i = Integer.MAX_VALUE;
        ad(paramy.WV, i);
        if (!this.Xs) {
          break label463;
        }
        n = this.acZ.fk();
        j = 0;
        if ((paramy.WT < 0) || (paramy.WT >= paramq.getItemCount())) {
          break label475;
        }
        k = 1;
        if ((k == 0) || ((!this.adc.WZ) && (this.add.isEmpty()))) {
          break label1653;
        }
        localView = paramm.bk(paramy.WT);
        paramy.WT += paramy.WU;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i4 = localLayoutParams.aas.ge();
        localObject1 = this.ade;
        if ((((LazySpanLookup)localObject1).mData != null) && (i4 < ((LazySpanLookup)localObject1).mData.length)) {
          break label481;
        }
        j = -1;
        if (j != -1) {
          break label494;
        }
        i1 = 1;
        label190:
        if (i1 == 0) {
          break label704;
        }
        if (!localLayoutParams.adq) {
          break label500;
        }
        localObject1 = this.acY[0];
      }
    }
    label211:
    Object localObject2;
    label237:
    label260:
    label305:
    label329:
    int m;
    label463:
    label475:
    label481:
    label494:
    label500:
    label525:
    int i5;
    int i2;
    label557:
    do
    {
      localObject2 = this.ade;
      ((LazySpanLookup)localObject2).bz(i4);
      ((LazySpanLookup)localObject2).mData[i4] = ((b)localObject1).mIndex;
      localLayoutParams.adp = ((b)localObject1);
      if (paramy.WV != 1) {
        break label716;
      }
      super.c(localView, -1, false);
      if (!localLayoutParams.adq) {
        break label759;
      }
      if (this.Xd != 1) {
        break label727;
      }
      a(localView, this.adj, b(this.RQ, this.aaq, 0, localLayoutParams.height, true), false);
      if (paramy.WV != 1) {
        break label1061;
      }
      if (!localLayoutParams.adq) {
        break label859;
      }
      j = bu(n);
      k = j + this.acZ.aX(localView);
      if ((i1 == 0) || (!localLayoutParams.adq)) {
        break label1744;
      }
      localObject2 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
      ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).adt = new int[this.WG];
      m = 0;
      while (m < this.WG)
      {
        ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).adt[m] = (j - this.acY[m].bD(j));
        m += 1;
      }
      i = Integer.MIN_VALUE;
      break;
      if (paramy.WV == 1)
      {
        i = paramy.WX + paramy.WS;
        break;
      }
      i = paramy.WW - paramy.WS;
      break;
      n = this.acZ.fj();
      break label61;
      k = 0;
      break label85;
      j = localObject1.mData[i4];
      break label181;
      i1 = 0;
      break label190;
      if (!bv(paramy.WV)) {
        break label611;
      }
      j = this.WG - 1;
      m = -1;
      k = -1;
      if (paramy.WV != 1) {
        break label626;
      }
      localObject2 = null;
      i3 = Integer.MAX_VALUE;
      i5 = this.acZ.fj();
      i2 = j;
      j = i3;
      localObject1 = localObject2;
    } while (i2 == m);
    Object localObject1 = this.acY[i2];
    int i3 = ((b)localObject1).bD(i5);
    if (i3 < j) {
      j = i3;
    }
    for (;;)
    {
      i2 += k;
      localObject2 = localObject1;
      break label557;
      label611:
      j = 0;
      m = this.WG;
      k = 1;
      break label525;
      label626:
      localObject2 = null;
      i3 = Integer.MIN_VALUE;
      i5 = this.acZ.fk();
      i2 = j;
      j = i3;
      label650:
      localObject1 = localObject2;
      if (i2 == m) {
        break label211;
      }
      localObject1 = this.acY[i2];
      i3 = ((b)localObject1).bC(i5);
      if (i3 > j) {
        j = i3;
      }
      for (;;)
      {
        i2 += k;
        localObject2 = localObject1;
        break label650;
        label704:
        localObject1 = this.acY[j];
        break label237;
        label716:
        super.c(localView, 0, false);
        break label260;
        label727:
        a(localView, b(this.aar, this.aap, 0, localLayoutParams.width, true), this.adj, false);
        break label305;
        label759:
        if (this.Xd == 1)
        {
          a(localView, b(this.adb, this.aap, 0, localLayoutParams.width, false), b(this.RQ, this.aaq, 0, localLayoutParams.height, true), false);
          break label305;
        }
        a(localView, b(this.aar, this.aap, 0, localLayoutParams.width, true), b(this.adb, this.aaq, 0, localLayoutParams.height, false), false);
        break label305;
        label859:
        j = ((b)localObject1).bD(n);
        break label329;
        ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).ads = -1;
        ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).kC = i4;
        this.ade.a((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2);
        m = j;
        for (;;)
        {
          if ((localLayoutParams.adq) && (paramy.WU == -1)) {
            if (i1 == 0)
            {
              if (paramy.WV != 1) {
                break label1230;
              }
              i1 = this.acY[0].bD(Integer.MIN_VALUE);
              j = 1;
              label942:
              if (j >= this.WG) {
                break label1218;
              }
              if (this.acY[j].bD(Integer.MIN_VALUE) == i1) {
                break label1209;
              }
              j = 0;
              label971:
              if (j != 0) {
                break label1224;
              }
              j = 1;
            }
          }
          for (;;)
          {
            if (j != 0)
            {
              localObject2 = this.ade.bA(i4);
              if (localObject2 != null) {
                ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).adu = true;
              }
              this.adl = true;
            }
            if (paramy.WV != 1) {
              break label1461;
            }
            if (!localLayoutParams.adq) {
              break label1307;
            }
            j = this.WG - 1;
            while (j >= 0)
            {
              this.acY[j].br(localView);
              j -= 1;
            }
            label1061:
            if (localLayoutParams.adq) {}
            for (k = bt(n);; k = ((b)localObject1).bC(n))
            {
              m = this.acZ.aX(localView);
              if ((i1 == 0) || (!localLayoutParams.adq)) {
                break label1199;
              }
              localObject2 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
              ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).adt = new int[this.WG];
              j = 0;
              while (j < this.WG)
              {
                ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).adt[j] = (this.acY[j].bC(k) - k);
                j += 1;
              }
            }
            ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).ads = 1;
            ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).kC = i4;
            this.ade.a((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2);
            label1199:
            m = k - m;
            break;
            label1209:
            j += 1;
            break label942;
            label1218:
            j = 1;
            break label971;
            label1224:
            j = 0;
            continue;
            label1230:
            i1 = this.acY[0].bC(Integer.MIN_VALUE);
            j = 1;
            label1246:
            if (j < this.WG) {
              if (this.acY[j].bC(Integer.MIN_VALUE) == i1) {}
            }
            for (j = 0;; j = 1)
            {
              if (j != 0) {
                break label1301;
              }
              j = 1;
              break;
              j += 1;
              break label1246;
            }
            label1301:
            j = 0;
          }
          label1307:
          localLayoutParams.adp.br(localView);
          label1317:
          if ((eU()) && (this.Xd == 1)) {
            if (localLayoutParams.adq)
            {
              j = this.ada.fk();
              label1349:
              i2 = this.ada.aX(localView);
              i1 = j;
              j -= i2;
              if (this.Xd != 1) {
                break label1603;
              }
              h(localView, j, m, i1, k);
              label1392:
              if (!localLayoutParams.adq) {
                break label1619;
              }
              ad(this.adc.WV, i);
              label1413:
              a(paramm, this.adc);
              if ((this.adc.WY) && (localView.isFocusable()))
              {
                if (!localLayoutParams.adq) {
                  break label1637;
                }
                this.add.clear();
              }
            }
          }
          for (;;)
          {
            j = 1;
            break;
            label1461:
            if (localLayoutParams.adq)
            {
              j = this.WG - 1;
              while (j >= 0)
              {
                this.acY[j].bq(localView);
                j -= 1;
              }
              break label1317;
            }
            localLayoutParams.adp.bq(localView);
            break label1317;
            j = this.ada.fk() - (this.WG - 1 - ((b)localObject1).mIndex) * this.adb;
            break label1349;
            if (localLayoutParams.adq) {}
            for (j = this.ada.fj();; j = ((b)localObject1).mIndex * this.adb + this.ada.fj())
            {
              i1 = this.ada.aX(localView) + j;
              break;
            }
            label1603:
            h(localView, m, j, k, i1);
            break label1392;
            label1619:
            a((b)localObject1, this.adc.WV, i);
            break label1413;
            label1637:
            this.add.set(((b)localObject1).mIndex, false);
          }
          label1653:
          if (j == 0) {
            a(paramm, this.adc);
          }
          if (this.adc.WV == -1) {
            i = bt(this.acZ.fj());
          }
          for (i = this.acZ.fj() - i; i > 0; i = bu(this.acZ.fk()) - this.acZ.fk()) {
            return Math.min(paramy.WS, i);
          }
          return 0;
          label1744:
          m = j;
        }
        localObject1 = localObject2;
      }
      localObject1 = localObject2;
    }
  }
  
  private void a(int paramInt, RecyclerView.q paramq)
  {
    boolean bool2 = false;
    this.adc.WS = 0;
    this.adc.WT = paramInt;
    int i;
    boolean bool1;
    if (fU())
    {
      i = paramq.aaG;
      if (i != -1)
      {
        boolean bool3 = this.Xs;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label189;
          }
          paramInt = this.acZ.fl();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      int j;
      if ((this.aak != null) && (RecyclerView.w(this.aak)))
      {
        j = 1;
        label87:
        if (j == 0) {
          break label208;
        }
        this.adc.WW = (this.acZ.fj() - i);
        this.adc.WX = (paramInt + this.acZ.fk());
      }
      for (;;)
      {
        this.adc.WY = false;
        this.adc.WR = true;
        paramq = this.adc;
        bool1 = bool2;
        if (this.acZ.getMode() == 0)
        {
          bool1 = bool2;
          if (this.acZ.getEnd() == 0) {
            bool1 = true;
          }
        }
        paramq.WZ = bool1;
        return;
        bool1 = false;
        break;
        label189:
        i = this.acZ.fl();
        paramInt = 0;
        break label67;
        j = 0;
        break label87;
        label208:
        this.adc.WX = (paramInt + this.acZ.getEnd());
        this.adc.WW = (-i);
      }
      paramInt = 0;
      i = 0;
    }
  }
  
  private void a(RecyclerView.m paramm, int paramInt)
  {
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        if (this.acZ.aW(localView) <= paramInt)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.adq) {
            break label105;
          }
          i = 0;
          if (i >= this.WG) {
            break label79;
          }
          if (this.acY[i].adA.size() != 1) {
            break label72;
          }
        }
      }
      label72:
      label79:
      label105:
      while (localLayoutParams.adp.adA.size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < this.WG)
        {
          this.acY[i].gR();
          i += 1;
        }
      }
      localLayoutParams.adp.gR();
      a(localView, paramm);
    }
  }
  
  private void a(RecyclerView.m paramm, RecyclerView.q paramq, boolean paramBoolean)
  {
    int i = bu(Integer.MIN_VALUE);
    if (i == Integer.MIN_VALUE) {}
    do
    {
      do
      {
        return;
        i = this.acZ.fk() - i;
      } while (i <= 0);
      i -= -c(-i, paramm, paramq);
    } while ((!paramBoolean) || (i <= 0));
    this.acZ.ba(i);
  }
  
  private void a(RecyclerView.m paramm, y paramy)
  {
    int k = 1;
    int i = 1;
    if ((!paramy.WR) || (paramy.WZ)) {
      return;
    }
    if (paramy.WS == 0)
    {
      if (paramy.WV == -1)
      {
        b(paramm, paramy.WX);
        return;
      }
      a(paramm, paramy.WW);
      return;
    }
    int m;
    if (paramy.WV == -1)
    {
      n = paramy.WW;
      int i1 = paramy.WW;
      for (j = this.acY[0].bC(i1); i < this.WG; j = k)
      {
        m = this.acY[i].bC(i1);
        k = j;
        if (m > j) {
          k = m;
        }
        i += 1;
      }
      i = n - j;
      if (i < 0) {}
      for (i = paramy.WX;; i = paramy.WX - Math.min(i, paramy.WS))
      {
        b(paramm, i);
        return;
      }
    }
    int n = paramy.WX;
    int j = this.acY[0].bD(n);
    i = k;
    while (i < this.WG)
    {
      m = this.acY[i].bD(n);
      k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    i = j - paramy.WX;
    if (i < 0) {}
    for (i = paramy.WW;; i = Math.min(i, paramy.WS) + j)
    {
      a(paramm, i);
      return;
      j = paramy.WW;
    }
  }
  
  private void a(b paramb, int paramInt1, int paramInt2)
  {
    int i = paramb.adD;
    if (paramInt1 == -1) {
      if (i + paramb.gN() <= paramInt2) {
        this.add.set(paramb.mIndex, false);
      }
    }
    while (paramb.gP() - i < paramInt2) {
      return;
    }
    this.add.set(paramb.mIndex, false);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramView, this.gG);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = i(paramInt1, localLayoutParams.leftMargin + this.gG.left, localLayoutParams.rightMargin + this.gG.right);
    paramInt2 = i(paramInt2, localLayoutParams.topMargin + this.gG.top, localLayoutParams.bottomMargin + this.gG.bottom);
    if (a(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private View aa(boolean paramBoolean)
  {
    int j = this.acZ.fj();
    int k = this.acZ.fk();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.acZ.aV(localView);
      int n = this.acZ.aW(localView);
      if ((n <= j) || (m >= k)) {
        break label106;
      }
      if ((n <= k) || (!paramBoolean)) {
        return localView;
      }
      if (localObject != null) {
        break label106;
      }
      localObject = localView;
    }
    label106:
    for (;;)
    {
      i -= 1;
      break;
      return (View)localObject;
    }
  }
  
  private void ad(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.WG)
    {
      if (!this.acY[i].adA.isEmpty()) {
        a(this.acY[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private void b(RecyclerView.m paramm, int paramInt)
  {
    int i = getChildCount() - 1;
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (i >= 0)
      {
        localView = getChildAt(i);
        if (this.acZ.aV(localView) >= paramInt)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.adq) {
            break label119;
          }
          j = 0;
          if (j >= this.WG) {
            break label88;
          }
          if (this.acY[j].adA.size() != 1) {
            break label79;
          }
        }
      }
      label79:
      label88:
      label119:
      while (localLayoutParams.adp.adA.size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < this.WG)
        {
          this.acY[j].gQ();
          j += 1;
        }
      }
      localLayoutParams.adp.gQ();
      a(localView, paramm);
      i -= 1;
    }
  }
  
  private void b(RecyclerView.m paramm, RecyclerView.q paramq, boolean paramBoolean)
  {
    int i = bt(Integer.MAX_VALUE);
    if (i == Integer.MAX_VALUE) {}
    do
    {
      do
      {
        return;
        i -= this.acZ.fj();
      } while (i <= 0);
      i -= c(i, paramm, paramq);
    } while ((!paramBoolean) || (i <= 0));
    this.acZ.ba(-i);
  }
  
  private void br(int paramInt)
  {
    this.adb = (paramInt / this.WG);
    this.adj = View.MeasureSpec.makeMeasureSpec(paramInt, this.ada.getMode());
  }
  
  private void bs(int paramInt)
  {
    int i = 1;
    this.adc.WV = paramInt;
    y localy = this.adc;
    boolean bool2 = this.Xs;
    boolean bool1;
    if (paramInt == -1)
    {
      bool1 = true;
      if (bool2 != bool1) {
        break label49;
      }
    }
    label49:
    for (paramInt = i;; paramInt = -1)
    {
      localy.WU = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private int bt(int paramInt)
  {
    int j = this.acY[0].bC(paramInt);
    int i = 1;
    while (i < this.WG)
    {
      int m = this.acY[i].bC(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int bu(int paramInt)
  {
    int j = this.acY[0].bD(paramInt);
    int i = 1;
    while (i < this.WG)
    {
      int m = this.acY[i].bD(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private boolean bv(int paramInt)
  {
    int i;
    if (this.Xd == 0) {
      if (paramInt == -1)
      {
        i = 1;
        if (i == this.Xs) {
          break label29;
        }
      }
    }
    label29:
    label63:
    label66:
    for (;;)
    {
      return true;
      i = 0;
      break;
      return false;
      if (paramInt == -1)
      {
        i = 1;
        if (i != this.Xs) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == eU()) {
          break label66;
        }
        return false;
        i = 0;
        break;
      }
    }
  }
  
  private int c(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    int i;
    int j;
    if (paramInt > 0)
    {
      i = gJ();
      j = 1;
      this.adc.WR = true;
      a(i, paramq);
      bs(j);
      this.adc.WT = (i + this.adc.WU);
      j = Math.abs(paramInt);
      this.adc.WS = j;
      i = a(paramm, this.adc, paramq);
      if (j >= i) {
        break label116;
      }
    }
    for (;;)
    {
      this.acZ.ba(-paramInt);
      this.adg = this.Xs;
      return paramInt;
      j = -1;
      i = gK();
      break;
      label116:
      if (paramInt < 0) {
        paramInt = -i;
      } else {
        paramInt = i;
      }
    }
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
  
  private boolean eU()
  {
    return android.support.v4.view.z.J(this.aak) == 1;
  }
  
  private boolean gH()
  {
    if ((getChildCount() == 0) || (this.adf == 0) || (!this.hi)) {
      return false;
    }
    int j;
    if (this.Xs) {
      j = gJ();
    }
    for (int i = gK(); (j == 0) && (gI() != null); i = gJ())
    {
      this.ade.clear();
      this.aam = true;
      requestLayout();
      return true;
      j = gK();
    }
    if (!this.adl) {
      return false;
    }
    if (this.Xs) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = this.ade.n(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.adl = false;
      this.ade.bx(i + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.ade.n(j, localFullSpanItem1.kC, k * -1);
    if (localFullSpanItem2 == null) {
      this.ade.bx(localFullSpanItem1.kC);
    }
    for (;;)
    {
      this.aam = true;
      requestLayout();
      return true;
      this.ade.bx(localFullSpanItem2.kC + 1);
    }
  }
  
  private View gI()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.WG);
    localBitSet.set(0, this.WG, true);
    int j;
    int k;
    label57:
    int m;
    label65:
    int n;
    View localView;
    LayoutParams localLayoutParams;
    Object localObject;
    if ((this.Xd == 1) && (eU()))
    {
      j = 1;
      if (!this.Xs) {
        break label184;
      }
      k = -1;
      if (i >= k) {
        break label193;
      }
      m = 1;
      n = i;
      if (n == k) {
        break label458;
      }
      localView = getChildAt(n);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(localLayoutParams.adp.mIndex)) {
        break label271;
      }
      localObject = localLayoutParams.adp;
      if (!this.Xs) {
        break label204;
      }
      if (((b)localObject).gP() >= this.acZ.fk()) {
        break label253;
      }
      if (((LayoutParams)((View)((b)localObject).adA.get(((b)localObject).adA.size() - 1)).getLayoutParams()).adq) {
        break label199;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label258;
      }
      return localView;
      j = -1;
      break;
      label184:
      k = i + 1;
      i = 0;
      break label57;
      label193:
      m = -1;
      break label65;
      label199:
      i = 0;
      continue;
      label204:
      if (((b)localObject).gN() > this.acZ.fj())
      {
        if (!((LayoutParams)((View)((b)localObject).adA.get(0)).getLayoutParams()).adq) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else {
        label253:
        i = 0;
      }
    }
    label258:
    localBitSet.clear(localLayoutParams.adp.mIndex);
    label271:
    int i1;
    if ((!localLayoutParams.adq) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.Xs)
      {
        i = this.acZ.aW(localView);
        i1 = this.acZ.aW((View)localObject);
        if (i < i1) {
          return localView;
        }
        if (i != i1) {
          break label460;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.adp.mIndex - ((LayoutParams)localObject).adp.mIndex < 0)
        {
          i = 1;
          label380:
          if (j >= 0) {
            break label442;
          }
        }
        label442:
        for (i1 = 1;; i1 = 0)
        {
          if (i == i1) {
            break label448;
          }
          return localView;
          i = this.acZ.aV(localView);
          i1 = this.acZ.aV((View)localObject);
          if (i > i1) {
            return localView;
          }
          if (i != i1) {
            break label460;
          }
          i = 1;
          break;
          i = 0;
          break label380;
        }
      }
      label448:
      n += m;
      break;
      label458:
      return null;
      label460:
      i = 0;
    }
  }
  
  private int gJ()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return be(getChildAt(i - 1));
  }
  
  private int gK()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return be(getChildAt(0));
  }
  
  private int h(RecyclerView.q paramq)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    ab localab = this.acZ;
    View localView;
    if (!this.Xu)
    {
      bool1 = true;
      localView = Z(bool1);
      if (this.Xu) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ah.a(paramq, localab, localView, aa(bool1), this, this.Xu, this.Xs);
      bool1 = false;
      break;
    }
  }
  
  private static void h(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    g(paramView, localLayoutParams.leftMargin + paramInt1, localLayoutParams.topMargin + paramInt2, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
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
  
  private int i(RecyclerView.q paramq)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    ab localab = this.acZ;
    View localView;
    if (!this.Xu)
    {
      bool1 = true;
      localView = Z(bool1);
      if (this.Xu) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ah.a(paramq, localab, localView, aa(bool1), this, this.Xu);
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
    ab localab = this.acZ;
    View localView;
    if (!this.Xu)
    {
      bool1 = true;
      localView = Z(bool1);
      if (this.Xu) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ah.b(paramq, localab, localView, aa(bool1), this, this.Xu);
      bool1 = false;
      break;
    }
  }
  
  private void m(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    int i;
    if (this.Xs)
    {
      k = gJ();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label32:
      this.ade.by(i);
      switch (paramInt3)
      {
      default: 
        label76:
        if (j > k) {
          break;
        }
      }
    }
    for (;;)
    {
      return;
      k = gK();
      break;
      label93:
      j = paramInt1 + 1;
      i = paramInt2;
      break label32;
      label104:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label32;
      this.ade.af(paramInt1, paramInt2);
      break label76;
      this.ade.ae(paramInt1, paramInt2);
      break label76;
      this.ade.ae(paramInt1, 1);
      this.ade.af(paramInt2, 1);
      break label76;
      if (this.Xs) {}
      for (paramInt1 = gK(); i <= paramInt1; paramInt1 = gJ())
      {
        requestLayout();
        return;
      }
    }
  }
  
  public final void A(int paramInt1, int paramInt2)
  {
    m(paramInt1, paramInt2, 2);
  }
  
  public final void B(int paramInt1, int paramInt2)
  {
    m(paramInt1, paramInt2, 4);
  }
  
  public final void C(int paramInt1, int paramInt2)
  {
    m(paramInt1, paramInt2, 8);
  }
  
  public final int a(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    return c(paramInt, paramm, paramq);
  }
  
  public final int a(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if (this.Xd == 0) {
      return this.WG;
    }
    return super.a(paramm, paramq);
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public final View a(View paramView, int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    int j = 0;
    if (getChildCount() == 0) {
      return null;
    }
    paramView = bf(paramView);
    if (paramView == null) {
      return null;
    }
    eT();
    switch (paramInt)
    {
    default: 
      paramInt = Integer.MIN_VALUE;
    }
    while (paramInt == Integer.MIN_VALUE)
    {
      return null;
      paramInt = -1;
      continue;
      paramInt = 1;
      continue;
      if (this.Xd == 1)
      {
        paramInt = -1;
      }
      else
      {
        paramInt = Integer.MIN_VALUE;
        continue;
        if (this.Xd == 1)
        {
          paramInt = 1;
        }
        else
        {
          paramInt = Integer.MIN_VALUE;
          continue;
          if (this.Xd == 0)
          {
            paramInt = -1;
          }
          else
          {
            paramInt = Integer.MIN_VALUE;
            continue;
            if (this.Xd == 0) {
              paramInt = 1;
            } else {
              paramInt = Integer.MIN_VALUE;
            }
          }
        }
      }
    }
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    boolean bool = ((LayoutParams)localObject).adq;
    localObject = ((LayoutParams)localObject).adp;
    if (paramInt == 1) {}
    for (int i = gJ();; i = gK())
    {
      a(i, paramq);
      bs(paramInt);
      this.adc.WT = (this.adc.WU + i);
      this.adc.WS = ((int)(0.33333334F * this.acZ.fl()));
      this.adc.WY = true;
      this.adc.WR = false;
      a(paramm, this.adc, paramq);
      this.adg = this.Xs;
      if (bool) {
        break;
      }
      paramm = ((b)localObject).ag(i, paramInt);
      if ((paramm == null) || (paramm == paramView)) {
        break;
      }
      return paramm;
    }
    if (bv(paramInt))
    {
      j = this.WG - 1;
      while (j >= 0)
      {
        paramm = this.acY[j].ag(i, paramInt);
        if ((paramm != null) && (paramm != paramView)) {
          return paramm;
        }
        j -= 1;
      }
    }
    do
    {
      j += 1;
      if (j >= this.WG) {
        break;
      }
      paramm = this.acY[j].ag(i, paramInt);
    } while ((paramm == null) || (paramm == paramView));
    return paramm;
    return null;
  }
  
  public final void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.Xd == 1)
    {
      paramInt2 = j(paramInt2, j + paramRect.height(), android.support.v4.view.z.U(this.aak));
      paramInt1 = j(paramInt1, i + this.adb * this.WG, android.support.v4.view.z.T(this.aak));
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = j(paramInt1, i + paramRect.width(), android.support.v4.view.z.T(this.aak));
      paramInt2 = j(paramInt2, j + this.adb * this.WG, android.support.v4.view.z.U(this.aak));
    }
  }
  
  public final void a(RecyclerView.m paramm, RecyclerView.q paramq, View paramView, b paramb)
  {
    int k = 1;
    int i = 1;
    int j = -1;
    paramm = paramView.getLayoutParams();
    if (!(paramm instanceof LayoutParams))
    {
      super.b(paramView, paramb);
      return;
    }
    paramm = (LayoutParams)paramm;
    int m;
    int n;
    if (this.Xd == 0)
    {
      m = paramm.gL();
      if (paramm.adq) {
        i = this.WG;
      }
      n = -1;
      k = i;
      i = n;
    }
    for (;;)
    {
      paramb.k(b.l.a(m, k, j, i, paramm.adq));
      return;
      i = paramm.gL();
      if (paramm.adq)
      {
        n = this.WG;
        m = -1;
        j = i;
        k = -1;
        i = n;
      }
      else
      {
        m = -1;
        j = i;
        n = -1;
        i = k;
        k = n;
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new z(paramRecyclerView.getContext())
    {
      public final PointF aW(int paramAnonymousInt)
      {
        paramAnonymousInt = StaggeredGridLayoutManager.this.bw(paramAnonymousInt);
        if (paramAnonymousInt == 0) {
          return null;
        }
        if (StaggeredGridLayoutManager.this.Xd == 0) {
          return new PointF(paramAnonymousInt, 0.0F);
        }
        return new PointF(0.0F, paramAnonymousInt);
      }
    };
    paramRecyclerView.aaG = paramInt;
    a(paramRecyclerView);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.m paramm)
  {
    removeCallbacks(this.adm);
    int i = 0;
    while (i < this.WG)
    {
      this.acY[i].clear();
      i += 1;
    }
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final void aX(int paramInt)
  {
    if ((this.adi != null) && (this.adi.XK != paramInt))
    {
      SavedState localSavedState = this.adi;
      localSavedState.adx = null;
      localSavedState.adw = 0;
      localSavedState.XK = -1;
      localSavedState.adv = -1;
    }
    this.Xv = paramInt;
    this.Xw = Integer.MIN_VALUE;
    requestLayout();
  }
  
  public final int b(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
  {
    return c(paramInt, paramm, paramq);
  }
  
  public final int b(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    if (this.Xd == 1) {
      return this.WG;
    }
    return super.b(paramm, paramq);
  }
  
  public final int b(RecyclerView.q paramq)
  {
    return h(paramq);
  }
  
  public final void bg(int paramInt)
  {
    super.bg(paramInt);
    int i = 0;
    while (i < this.WG)
    {
      this.acY[i].bF(paramInt);
      i += 1;
    }
  }
  
  public final void bh(int paramInt)
  {
    super.bh(paramInt);
    int i = 0;
    while (i < this.WG)
    {
      this.acY[i].bF(paramInt);
      i += 1;
    }
  }
  
  public final void bi(int paramInt)
  {
    if (paramInt == 0) {
      gH();
    }
  }
  
  public final int bw(int paramInt)
  {
    if (getChildCount() == 0) {
      if (!this.Xs) {}
    }
    for (;;)
    {
      return 1;
      return -1;
      if (paramInt < gK()) {}
      for (int i = 1; i != this.Xs; i = 0) {
        return -1;
      }
    }
  }
  
  public final int c(RecyclerView.q paramq)
  {
    return h(paramq);
  }
  
  public final void c(RecyclerView.m paramm, RecyclerView.q paramq)
  {
    int j = 1;
    a locala = this.adk;
    locala.kC = -1;
    locala.wa = Integer.MIN_VALUE;
    locala.XC = false;
    locala.ado = false;
    if (((this.adi != null) || (this.Xv != -1)) && (paramq.getItemCount() == 0))
    {
      d(paramm);
      label61:
      return;
    }
    int m;
    int i;
    label181:
    Object localObject;
    boolean bool;
    if (this.adi != null)
    {
      if (this.adi.adw > 0) {
        if (this.adi.adw == this.WG)
        {
          k = 0;
          if (k < this.WG)
          {
            this.acY[k].clear();
            m = this.adi.adx[k];
            i = m;
            if (m != Integer.MIN_VALUE) {
              if (!this.adi.XM) {
                break label181;
              }
            }
            for (i = m + this.acZ.fk();; i = m + this.acZ.fj())
            {
              this.acY[k].bE(i);
              k += 1;
              break;
            }
          }
        }
        else
        {
          localObject = this.adi;
          ((SavedState)localObject).adx = null;
          ((SavedState)localObject).adw = 0;
          ((SavedState)localObject).ady = 0;
          ((SavedState)localObject).adz = null;
          ((SavedState)localObject).adr = null;
          this.adi.XK = this.adi.adv;
        }
      }
      this.adh = this.adi.adh;
      bool = this.adi.Xr;
      q(null);
      if ((this.adi != null) && (this.adi.Xr != bool)) {
        this.adi.Xr = bool;
      }
      this.Xr = bool;
      requestLayout();
      eT();
      if (this.adi.XK != -1)
      {
        this.Xv = this.adi.XK;
        locala.XC = this.adi.XM;
        if (this.adi.ady > 1)
        {
          this.ade.mData = this.adi.adz;
          this.ade.adr = this.adi.adr;
        }
        label386:
        if ((!paramq.aaW) && (this.Xv != -1)) {
          break label635;
        }
        i = 0;
        label404:
        if (i == 0)
        {
          if (!this.adg) {
            break label1154;
          }
          m = paramq.getItemCount();
          i = getChildCount() - 1;
          label430:
          if (i < 0) {
            break label1148;
          }
          k = be(getChildAt(i));
          if ((k < 0) || (k >= m)) {
            break label1139;
          }
          i = k;
        }
      }
    }
    label635:
    label726:
    label792:
    label822:
    label858:
    label996:
    label1024:
    label1046:
    label1139:
    label1148:
    label1154:
    int n;
    int i1;
    for (;;)
    {
      locala.kC = i;
      locala.wa = Integer.MIN_VALUE;
      if ((this.adi == null) && ((locala.XC != this.adg) || (eU() != this.adh)))
      {
        this.ade.clear();
        locala.ado = true;
      }
      if ((getChildCount() <= 0) || ((this.adi != null) && (this.adi.adw > 0))) {
        break label1376;
      }
      if (!locala.ado) {
        break label1218;
      }
      i = 0;
      while (i < this.WG)
      {
        this.acY[i].clear();
        if (locala.wa != Integer.MIN_VALUE) {
          this.acY[i].bE(locala.wa);
        }
        i += 1;
      }
      locala.XC = this.Xs;
      break;
      eT();
      locala.XC = this.Xs;
      break label386;
      if ((this.Xv < 0) || (this.Xv >= paramq.getItemCount()))
      {
        this.Xv = -1;
        this.Xw = Integer.MIN_VALUE;
        i = 0;
        break label404;
      }
      if ((this.adi == null) || (this.adi.XK == -1) || (this.adi.adw <= 0))
      {
        localObject = aV(this.Xv);
        if (localObject != null)
        {
          if (this.Xs)
          {
            i = gJ();
            locala.kC = i;
            if (this.Xw == Integer.MIN_VALUE) {
              break label822;
            }
            if (!locala.XC) {
              break label792;
            }
          }
          for (locala.wa = (this.acZ.fk() - this.Xw - this.acZ.aW((View)localObject));; locala.wa = (this.acZ.fj() + this.Xw - this.acZ.aV((View)localObject)))
          {
            i = 1;
            break;
            i = gK();
            break label726;
          }
          if (this.acZ.aX((View)localObject) > this.acZ.fl()) {
            if (locala.XC)
            {
              i = this.acZ.fk();
              locala.wa = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.acZ.fj();
        break label858;
        i = this.acZ.aV((View)localObject) - this.acZ.fj();
        if (i < 0)
        {
          locala.wa = (-i);
        }
        else
        {
          i = this.acZ.fk() - this.acZ.aW((View)localObject);
          if (i < 0)
          {
            locala.wa = i;
          }
          else
          {
            locala.wa = Integer.MIN_VALUE;
            continue;
            locala.kC = this.Xv;
            if (this.Xw == Integer.MIN_VALUE) {
              if (bw(locala.kC) == 1)
              {
                bool = true;
                locala.XC = bool;
                if (!locala.XC) {
                  break label1046;
                }
                i = locala.adn.acZ.fk();
                locala.wa = i;
              }
            }
            for (;;)
            {
              locala.ado = true;
              break;
              bool = false;
              break label996;
              i = locala.adn.acZ.fj();
              break label1024;
              i = this.Xw;
              if (locala.XC) {
                locala.wa = (locala.adn.acZ.fk() - i);
              } else {
                locala.wa = (i + locala.adn.acZ.fj());
              }
            }
            locala.wa = Integer.MIN_VALUE;
            locala.kC = this.Xv;
          }
        }
      }
      i -= 1;
      break label430;
      i = 0;
      continue;
      n = paramq.getItemCount();
      i1 = getChildCount();
      k = 0;
      for (;;)
      {
        if (k >= i1) {
          break label1212;
        }
        m = be(getChildAt(k));
        if (m >= 0)
        {
          i = m;
          if (m < n) {
            break;
          }
        }
        k += 1;
      }
      label1212:
      i = 0;
    }
    label1218:
    int k = 0;
    if (k < this.WG)
    {
      localObject = this.acY[k];
      bool = this.Xs;
      n = locala.wa;
      if (bool)
      {
        i = ((b)localObject).bD(Integer.MIN_VALUE);
        label1266:
        ((b)localObject).clear();
        if ((i != Integer.MIN_VALUE) && ((!bool) || (i >= ((b)localObject).adn.acZ.fk())) && ((bool) || (i <= ((b)localObject).adn.acZ.fj()))) {
          break label1341;
        }
      }
      for (;;)
      {
        k += 1;
        break;
        i = ((b)localObject).bC(Integer.MIN_VALUE);
        break label1266;
        label1341:
        m = i;
        if (n != Integer.MIN_VALUE) {
          m = i + n;
        }
        ((b)localObject).adC = m;
        ((b)localObject).adB = m;
      }
    }
    label1376:
    b(paramm);
    this.adc.WR = false;
    this.adl = false;
    br(this.ada.fl());
    a(locala.kC, paramq);
    label1475:
    float f1;
    label1499:
    float f2;
    if (locala.XC)
    {
      bs(-1);
      a(paramm, this.adc, paramq);
      bs(1);
      this.adc.WT = (locala.kC + this.adc.WU);
      a(paramm, this.adc, paramq);
      if (this.ada.getMode() == 1073741824) {
        break label1861;
      }
      f1 = 0.0F;
      m = getChildCount();
      i = 0;
      if (i >= m) {
        break label1630;
      }
      localObject = getChildAt(i);
      f2 = this.ada.aX((View)localObject);
      if (f2 < f1) {
        break label2045;
      }
      if (!((LayoutParams)((View)localObject).getLayoutParams()).adq) {
        break label2048;
      }
      f2 = 1.0F * f2 / this.WG;
    }
    label1630:
    label1799:
    label1861:
    label1889:
    label2039:
    label2045:
    label2048:
    for (;;)
    {
      f1 = Math.max(f1, f2);
      for (;;)
      {
        i += 1;
        break label1499;
        bs(1);
        a(paramm, this.adc, paramq);
        bs(-1);
        this.adc.WT = (locala.kC + this.adc.WU);
        a(paramm, this.adc, paramq);
        break label1475;
        n = this.adb;
        k = Math.round(this.WG * f1);
        i = k;
        if (this.ada.getMode() == Integer.MIN_VALUE) {
          i = Math.min(k, this.ada.fl());
        }
        br(i);
        if (this.adb != n)
        {
          i = 0;
          if (i < m)
          {
            localObject = getChildAt(i);
            LayoutParams localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
            if (!localLayoutParams.adq)
            {
              if ((!eU()) || (this.Xd != 1)) {
                break label1799;
              }
              ((View)localObject).offsetLeftAndRight(-(this.WG - 1 - localLayoutParams.adp.mIndex) * this.adb - -(this.WG - 1 - localLayoutParams.adp.mIndex) * n);
            }
            for (;;)
            {
              i += 1;
              break;
              k = localLayoutParams.adp.mIndex * this.adb;
              i1 = localLayoutParams.adp.mIndex * n;
              if (this.Xd == 1) {
                ((View)localObject).offsetLeftAndRight(k - i1);
              } else {
                ((View)localObject).offsetTopAndBottom(k - i1);
              }
            }
          }
        }
        if (getChildCount() > 0)
        {
          if (this.Xs)
          {
            a(paramm, paramq, true);
            b(paramm, paramq, false);
          }
        }
        else
        {
          m = 0;
          k = 0;
          i = m;
          if (j != 0)
          {
            i = m;
            if (!paramq.aaW) {
              if ((this.adf == 0) || (getChildCount() <= 0) || ((!this.adl) && (gI() == null))) {
                break label2039;
              }
            }
          }
        }
        for (j = 1;; j = 0)
        {
          i = k;
          if (j != 0)
          {
            removeCallbacks(this.adm);
            i = k;
            if (gH()) {
              i = 1;
            }
          }
          this.Xv = -1;
          this.Xw = Integer.MIN_VALUE;
          this.adg = locala.XC;
          this.adh = eU();
          this.adi = null;
          if (i == 0) {
            break label61;
          }
          j = 0;
          break;
          b(paramm, paramq, true);
          a(paramm, paramq, false);
          break label1889;
        }
      }
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
  
  public final RecyclerView.LayoutParams e(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public final void eM()
  {
    this.ade.clear();
    requestLayout();
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
    return this.adi == null;
  }
  
  public final boolean eR()
  {
    return this.Xd == 0;
  }
  
  public final boolean eS()
  {
    return this.Xd == 1;
  }
  
  public final int f(RecyclerView.q paramq)
  {
    return j(paramq);
  }
  
  public final int g(RecyclerView.q paramq)
  {
    return j(paramq);
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent = a.a(paramAccessibilityEvent);
      localView1 = Z(false);
      localView2 = aa(false);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i = be(localView1);
    int j = be(localView2);
    if (i < j)
    {
      paramAccessibilityEvent.setFromIndex(i);
      paramAccessibilityEvent.setToIndex(j);
      return;
    }
    paramAccessibilityEvent.setFromIndex(j);
    paramAccessibilityEvent.setToIndex(i);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.adi = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.adi != null) {
      return new SavedState(this.adi);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.Xr = this.Xr;
    localSavedState.XM = this.adg;
    localSavedState.adh = this.adh;
    int i;
    label126:
    View localView;
    label146:
    label153:
    int j;
    label181:
    int k;
    if ((this.ade != null) && (this.ade.mData != null))
    {
      localSavedState.adz = this.ade.mData;
      localSavedState.ady = localSavedState.adz.length;
      localSavedState.adr = this.ade.adr;
      if (getChildCount() <= 0) {
        break label310;
      }
      if (!this.adg) {
        break label250;
      }
      i = gJ();
      localSavedState.XK = i;
      if (!this.Xs) {
        break label258;
      }
      localView = aa(true);
      if (localView != null) {
        break label268;
      }
      i = -1;
      localSavedState.adv = i;
      localSavedState.adw = this.WG;
      localSavedState.adx = new int[this.WG];
      j = 0;
      if (j >= this.WG) {
        break label328;
      }
      if (!this.adg) {
        break label277;
      }
      k = this.acY[j].bD(Integer.MIN_VALUE);
      i = k;
      if (k != Integer.MIN_VALUE) {
        i = k - this.acZ.fk();
      }
    }
    for (;;)
    {
      localSavedState.adx[j] = i;
      j += 1;
      break label181;
      localSavedState.ady = 0;
      break;
      label250:
      i = gK();
      break label126;
      label258:
      localView = Z(true);
      break label146;
      label268:
      i = be(localView);
      break label153;
      label277:
      k = this.acY[j].bC(Integer.MIN_VALUE);
      i = k;
      if (k != Integer.MIN_VALUE) {
        i = k - this.acZ.fj();
      }
    }
    label310:
    localSavedState.XK = -1;
    localSavedState.adv = -1;
    localSavedState.adw = 0;
    label328:
    return localSavedState;
  }
  
  public final void q(String paramString)
  {
    if (this.adi == null) {
      super.q(paramString);
    }
  }
  
  public final void z(int paramInt1, int paramInt2)
  {
    m(paramInt1, paramInt2, 1);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    StaggeredGridLayoutManager.b adp;
    boolean adq;
    
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
    
    public final int gL()
    {
      if (this.adp == null) {
        return -1;
      }
      return this.adp.mIndex;
    }
  }
  
  static final class LazySpanLookup
  {
    List<FullSpanItem> adr;
    int[] mData;
    
    public final void a(FullSpanItem paramFullSpanItem)
    {
      if (this.adr == null) {
        this.adr = new ArrayList();
      }
      int j = this.adr.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.adr.get(i);
        if (localFullSpanItem.kC == paramFullSpanItem.kC) {
          this.adr.remove(i);
        }
        if (localFullSpanItem.kC >= paramFullSpanItem.kC)
        {
          this.adr.add(i, paramFullSpanItem);
          return;
        }
        i += 1;
      }
      this.adr.add(paramFullSpanItem);
    }
    
    final void ae(int paramInt1, int paramInt2)
    {
      if ((this.mData == null) || (paramInt1 >= this.mData.length)) {}
      do
      {
        return;
        bz(paramInt1 + paramInt2);
        System.arraycopy(this.mData, paramInt1 + paramInt2, this.mData, paramInt1, this.mData.length - paramInt1 - paramInt2);
        Arrays.fill(this.mData, this.mData.length - paramInt2, this.mData.length, -1);
      } while (this.adr == null);
      int i = this.adr.size() - 1;
      label87:
      FullSpanItem localFullSpanItem;
      if (i >= 0)
      {
        localFullSpanItem = (FullSpanItem)this.adr.get(i);
        if (localFullSpanItem.kC >= paramInt1)
        {
          if (localFullSpanItem.kC >= paramInt1 + paramInt2) {
            break label144;
          }
          this.adr.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break label87;
        break;
        label144:
        localFullSpanItem.kC -= paramInt2;
      }
    }
    
    final void af(int paramInt1, int paramInt2)
    {
      if ((this.mData == null) || (paramInt1 >= this.mData.length)) {}
      for (;;)
      {
        return;
        bz(paramInt1 + paramInt2);
        System.arraycopy(this.mData, paramInt1, this.mData, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
        Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
        if (this.adr != null)
        {
          int i = this.adr.size() - 1;
          while (i >= 0)
          {
            FullSpanItem localFullSpanItem = (FullSpanItem)this.adr.get(i);
            if (localFullSpanItem.kC >= paramInt1) {
              localFullSpanItem.kC += paramInt2;
            }
            i -= 1;
          }
        }
      }
    }
    
    public final FullSpanItem bA(int paramInt)
    {
      Object localObject;
      if (this.adr == null)
      {
        localObject = null;
        return (FullSpanItem)localObject;
      }
      int i = this.adr.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label61;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.adr.get(i);
        localObject = localFullSpanItem;
        if (localFullSpanItem.kC == paramInt) {
          break;
        }
        i -= 1;
      }
      label61:
      return null;
    }
    
    final int bx(int paramInt)
    {
      if (this.adr != null)
      {
        int i = this.adr.size() - 1;
        while (i >= 0)
        {
          if (((FullSpanItem)this.adr.get(i)).kC >= paramInt) {
            this.adr.remove(i);
          }
          i -= 1;
        }
      }
      return by(paramInt);
    }
    
    final int by(int paramInt)
    {
      if (this.mData == null) {
        return -1;
      }
      if (paramInt >= this.mData.length) {
        return -1;
      }
      FullSpanItem localFullSpanItem;
      int i;
      if (this.adr != null)
      {
        localFullSpanItem = bA(paramInt);
        if (localFullSpanItem != null) {
          this.adr.remove(localFullSpanItem);
        }
        int j = this.adr.size();
        i = 0;
        if (i >= j) {
          break label178;
        }
        if (((FullSpanItem)this.adr.get(i)).kC < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          localFullSpanItem = (FullSpanItem)this.adr.get(i);
          this.adr.remove(i);
        }
        for (i = localFullSpanItem.kC;; i = -1)
        {
          if (i != -1) {
            break label162;
          }
          Arrays.fill(this.mData, paramInt, this.mData.length, -1);
          return this.mData.length;
          i += 1;
          break;
        }
        label162:
        Arrays.fill(this.mData, paramInt, i + 1, -1);
        return i + 1;
        label178:
        i = -1;
      }
    }
    
    final void bz(int paramInt)
    {
      if (this.mData == null)
      {
        this.mData = new int[Math.max(paramInt, 10) + 1];
        Arrays.fill(this.mData, -1);
      }
      while (paramInt < this.mData.length) {
        return;
      }
      int[] arrayOfInt = this.mData;
      int i = this.mData.length;
      while (i <= paramInt) {
        i *= 2;
      }
      this.mData = new int[i];
      System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
      Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
    }
    
    final void clear()
    {
      if (this.mData != null) {
        Arrays.fill(this.mData, -1);
      }
      this.adr = null;
    }
    
    public final FullSpanItem n(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject;
      if (this.adr == null)
      {
        localObject = null;
        return (FullSpanItem)localObject;
      }
      int j = this.adr.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label112;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.adr.get(i);
        if (localFullSpanItem.kC >= paramInt2) {
          return null;
        }
        if (localFullSpanItem.kC >= paramInt1)
        {
          localObject = localFullSpanItem;
          if (paramInt3 == 0) {
            break;
          }
          localObject = localFullSpanItem;
          if (localFullSpanItem.ads == paramInt3) {
            break;
          }
          localObject = localFullSpanItem;
          if (localFullSpanItem.adu) {
            break;
          }
        }
        i += 1;
      }
      label112:
      return null;
    }
    
    static class FullSpanItem
      implements Parcelable
    {
      public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator() {};
      int ads;
      int[] adt;
      boolean adu;
      int kC;
      
      public FullSpanItem() {}
      
      public FullSpanItem(Parcel paramParcel)
      {
        this.kC = paramParcel.readInt();
        this.ads = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          this.adu = bool;
          int i = paramParcel.readInt();
          if (i > 0)
          {
            this.adt = new int[i];
            paramParcel.readIntArray(this.adt);
          }
          return;
          bool = false;
        }
      }
      
      final int bB(int paramInt)
      {
        if (this.adt == null) {
          return 0;
        }
        return this.adt[paramInt];
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String toString()
      {
        return "FullSpanItem{mPosition=" + this.kC + ", mGapDir=" + this.ads + ", mHasUnwantedGapAfter=" + this.adu + ", mGapPerSpan=" + Arrays.toString(this.adt) + '}';
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.kC);
        paramParcel.writeInt(this.ads);
        if (this.adu) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if ((this.adt == null) || (this.adt.length <= 0)) {
            break;
          }
          paramParcel.writeInt(this.adt.length);
          paramParcel.writeIntArray(this.adt);
          return;
        }
        paramParcel.writeInt(0);
      }
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int XK;
    boolean XM;
    boolean Xr;
    boolean adh;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> adr;
    int adv;
    int adw;
    int[] adx;
    int ady;
    int[] adz;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.XK = paramParcel.readInt();
      this.adv = paramParcel.readInt();
      this.adw = paramParcel.readInt();
      if (this.adw > 0)
      {
        this.adx = new int[this.adw];
        paramParcel.readIntArray(this.adx);
      }
      this.ady = paramParcel.readInt();
      if (this.ady > 0)
      {
        this.adz = new int[this.ady];
        paramParcel.readIntArray(this.adz);
      }
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.Xr = bool1;
        if (paramParcel.readInt() != 1) {
          break label152;
        }
        bool1 = true;
        label113:
        this.XM = bool1;
        if (paramParcel.readInt() != 1) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.adh = bool1;
        this.adr = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label113;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.adw = paramSavedState.adw;
      this.XK = paramSavedState.XK;
      this.adv = paramSavedState.adv;
      this.adx = paramSavedState.adx;
      this.ady = paramSavedState.ady;
      this.adz = paramSavedState.adz;
      this.Xr = paramSavedState.Xr;
      this.XM = paramSavedState.XM;
      this.adh = paramSavedState.adh;
      this.adr = paramSavedState.adr;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeInt(this.XK);
      paramParcel.writeInt(this.adv);
      paramParcel.writeInt(this.adw);
      if (this.adw > 0) {
        paramParcel.writeIntArray(this.adx);
      }
      paramParcel.writeInt(this.ady);
      if (this.ady > 0) {
        paramParcel.writeIntArray(this.adz);
      }
      if (this.Xr)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.XM) {
          break label120;
        }
        paramInt = 1;
        label87:
        paramParcel.writeInt(paramInt);
        if (!this.adh) {
          break label125;
        }
      }
      label120:
      label125:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeList(this.adr);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label87;
      }
    }
  }
  
  private final class a
  {
    boolean XC;
    boolean ado;
    int kC;
    int wa;
  }
  
  final class b
  {
    public ArrayList<View> adA;
    int adB;
    int adC;
    int adD;
    final int mIndex;
    
    private void gM()
    {
      Object localObject = (View)this.adA.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.adB = this.adn.acZ.aV((View)localObject);
      if (localLayoutParams.adq)
      {
        localObject = this.adn.ade.bA(localLayoutParams.aas.ge());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).ads == -1)) {
          this.adB -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).bB(this.mIndex);
        }
      }
    }
    
    private void gO()
    {
      Object localObject = (View)this.adA.get(this.adA.size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.adC = this.adn.acZ.aW((View)localObject);
      if (localLayoutParams.adq)
      {
        localObject = this.adn.ade.bA(localLayoutParams.aas.ge());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).ads == 1))
        {
          int i = this.adC;
          this.adC = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).bB(this.mIndex) + i);
        }
      }
    }
    
    public final View ag(int paramInt1, int paramInt2)
    {
      View localView2 = null;
      View localView1 = null;
      int i;
      if (paramInt2 == -1)
      {
        i = this.adA.size();
        paramInt2 = 0;
        if (paramInt2 < i)
        {
          localView2 = (View)this.adA.get(paramInt2);
          if (localView2.isFocusable())
          {
            if (StaggeredGridLayoutManager.be(localView2) > paramInt1) {}
            for (int k = 1;; k = 0)
            {
              if (k != this.adn.Xr) {
                break label88;
              }
              paramInt2 += 1;
              localView1 = localView2;
              break;
            }
          }
        }
        label88:
        return localView1;
      }
      paramInt2 = this.adA.size() - 1;
      localView1 = localView2;
      if (paramInt2 >= 0)
      {
        localView2 = (View)this.adA.get(paramInt2);
        if (localView2.isFocusable())
        {
          if (StaggeredGridLayoutManager.be(localView2) > paramInt1)
          {
            i = 1;
            label141:
            if (this.adn.Xr) {
              break label176;
            }
          }
          label176:
          for (int j = 1;; j = 0)
          {
            if (i != j) {
              break label182;
            }
            localView1 = localView2;
            paramInt2 -= 1;
            break;
            i = 0;
            break label141;
          }
        }
      }
      label182:
      return localView1;
    }
    
    final int bC(int paramInt)
    {
      if (this.adB != Integer.MIN_VALUE) {
        paramInt = this.adB;
      }
      while (this.adA.size() == 0) {
        return paramInt;
      }
      gM();
      return this.adB;
    }
    
    final int bD(int paramInt)
    {
      if (this.adC != Integer.MIN_VALUE) {
        paramInt = this.adC;
      }
      while (this.adA.size() == 0) {
        return paramInt;
      }
      gO();
      return this.adC;
    }
    
    final void bE(int paramInt)
    {
      this.adB = paramInt;
      this.adC = paramInt;
    }
    
    final void bF(int paramInt)
    {
      if (this.adB != Integer.MIN_VALUE) {
        this.adB += paramInt;
      }
      if (this.adC != Integer.MIN_VALUE) {
        this.adC += paramInt;
      }
    }
    
    final void bq(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.adp = this;
      this.adA.add(0, paramView);
      this.adB = Integer.MIN_VALUE;
      if (this.adA.size() == 1) {
        this.adC = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.aas.isRemoved()) || (localLayoutParams.aas.gs())) {
        this.adD += this.adn.acZ.aX(paramView);
      }
    }
    
    final void br(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.adp = this;
      this.adA.add(paramView);
      this.adC = Integer.MIN_VALUE;
      if (this.adA.size() == 1) {
        this.adB = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.aas.isRemoved()) || (localLayoutParams.aas.gs())) {
        this.adD += this.adn.acZ.aX(paramView);
      }
    }
    
    final void clear()
    {
      this.adA.clear();
      this.adB = Integer.MIN_VALUE;
      this.adC = Integer.MIN_VALUE;
      this.adD = 0;
    }
    
    final int gN()
    {
      if (this.adB != Integer.MIN_VALUE) {
        return this.adB;
      }
      gM();
      return this.adB;
    }
    
    final int gP()
    {
      if (this.adC != Integer.MIN_VALUE) {
        return this.adC;
      }
      gO();
      return this.adC;
    }
    
    final void gQ()
    {
      int i = this.adA.size();
      View localView = (View)this.adA.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.adp = null;
      if ((localLayoutParams.aas.isRemoved()) || (localLayoutParams.aas.gs())) {
        this.adD -= this.adn.acZ.aX(localView);
      }
      if (i == 1) {
        this.adB = Integer.MIN_VALUE;
      }
      this.adC = Integer.MIN_VALUE;
    }
    
    final void gR()
    {
      View localView = (View)this.adA.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.adp = null;
      if (this.adA.size() == 0) {
        this.adC = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.aas.isRemoved()) || (localLayoutParams.aas.gs())) {
        this.adD -= this.adn.acZ.aX(localView);
      }
      this.adB = Integer.MIN_VALUE;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/StaggeredGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */