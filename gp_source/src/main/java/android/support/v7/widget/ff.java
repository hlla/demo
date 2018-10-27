package android.support.v7.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.v4.view.ac;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class ff
{
  private final hy a = new fg(this);
  private boolean b = true;
  private final hy c = new fh(this);
  public boolean e = false;
  public be f;
  public int g;
  public int h;
  public hw i = new hw(this.a);
  public boolean j = true;
  public int k;
  public boolean l;
  public RecyclerView m;
  public ft n;
  public hw o = new hw(this.c);
  public int p;
  public int q;
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = i1;
    switch (i2)
    {
    default: 
      paramInt1 = Math.max(paramInt2, paramInt3);
    case 1073741824: 
      return paramInt1;
    }
    return Math.min(i1, Math.max(paramInt2, paramInt3));
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i1 = 0;
    paramInt1 = Math.max(0, paramInt1 - paramInt3);
    if (!paramBoolean) {
      if (paramInt4 >= 0)
      {
        paramInt2 = 1073741824;
        paramInt1 = paramInt4;
      }
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
      if (paramInt4 != -1) {
        if (paramInt4 != -2)
        {
          paramInt2 = 0;
          paramInt1 = i1;
        }
        else if (paramInt2 == Integer.MIN_VALUE)
        {
          paramInt2 = Integer.MIN_VALUE;
        }
        else if (paramInt2 != 1073741824)
        {
          paramInt2 = 0;
        }
        else
        {
          paramInt2 = Integer.MIN_VALUE;
          continue;
          if (paramInt4 >= 0)
          {
            paramInt2 = 1073741824;
            paramInt1 = paramInt4;
          }
          else if (paramInt4 == -1)
          {
            switch (paramInt2)
            {
            default: 
              paramInt2 = 0;
              paramInt1 = i1;
              break;
            case 1073741824: 
            case -2147483648: 
              break;
            case 0: 
              paramInt2 = 0;
              paramInt1 = i1;
              break;
            }
          }
          else if (paramInt4 == -2)
          {
            paramInt2 = 0;
            paramInt1 = i1;
          }
          else
          {
            paramInt2 = 0;
            paramInt1 = i1;
          }
        }
      }
    }
  }
  
  private static boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramInt3 <= 0) {}
    while (paramInt1 == paramInt3)
    {
      switch (i1)
      {
      default: 
      case -2147483648: 
      case 1073741824: 
        do
        {
          do
          {
            return false;
          } while (paramInt2 < paramInt1);
          return true;
        } while (paramInt2 != paramInt1);
        return true;
      }
      return true;
    }
    return false;
  }
  
  private final void e(int paramInt)
  {
    if (d(paramInt) != null)
    {
      be localbe = this.f;
      paramInt = localbe.a(paramInt);
      View localView = localbe.b.b(paramInt);
      if (localView != null)
      {
        if (localbe.a.d(paramInt)) {
          localbe.b(localView);
        }
        localbe.b.a(paramInt);
      }
    }
  }
  
  public static int f(View paramView)
  {
    Rect localRect = ((fj)paramView.getLayoutParams()).a;
    int i1 = paramView.getMeasuredWidth();
    int i2 = localRect.left;
    return localRect.right + (i1 + i2);
  }
  
  private final void f(int paramInt)
  {
    d(paramInt);
    this.f.d(paramInt);
  }
  
  public static int g(View paramView)
  {
    Rect localRect = ((fj)paramView.getLayoutParams()).a;
    int i1 = paramView.getMeasuredHeight();
    int i2 = localRect.top;
    return localRect.bottom + (i1 + i2);
  }
  
  public static int h(View paramView)
  {
    return paramView.getLeft() - ((fj)paramView.getLayoutParams()).a.left;
  }
  
  public static int i(View paramView)
  {
    return paramView.getTop() - ((fj)paramView.getLayoutParams()).a.top;
  }
  
  public static int j(View paramView)
  {
    int i1 = paramView.getRight();
    return ((fj)paramView.getLayoutParams()).a.right + i1;
  }
  
  public static int k(View paramView)
  {
    int i1 = paramView.getBottom();
    return ((fj)paramView.getLayoutParams()).a.bottom + i1;
  }
  
  public void A() {}
  
  public void B() {}
  
  public void C() {}
  
  public void D() {}
  
  public int a(int paramInt, fp paramfp, fw paramfw)
  {
    return 0;
  }
  
  public final int a(View paramView)
  {
    return ((fj)paramView.getLayoutParams()).d.c();
  }
  
  public fj a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new fj(paramContext, paramAttributeSet);
  }
  
  public fj a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof fj)) {
      return new fj((fj)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new fj((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new fj(paramLayoutParams);
  }
  
  public View a(int paramInt)
  {
    int i2 = w();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = d(i1);
      fz localfz = RecyclerView.b(localView);
      if (localfz == null) {}
      while ((localfz.c() != paramInt) || (localfz.b()) || ((!this.m.G.e) && (localfz.l())))
      {
        i1 += 1;
        break;
      }
      return localView;
    }
    return null;
  }
  
  public View a(View paramView, int paramInt)
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, fw paramfw, fi paramfi) {}
  
  public void a(int paramInt, fi paramfi) {}
  
  public final void a(int paramInt, fp paramfp)
  {
    View localView = d(paramInt);
    e(paramInt);
    paramfp.a(localView);
  }
  
  public void a(Parcelable paramParcelable) {}
  
  final void a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      this.m = paramRecyclerView;
      this.f = paramRecyclerView.k;
      this.p = paramRecyclerView.getWidth();
    }
    for (this.g = paramRecyclerView.getHeight();; this.g = 0)
    {
      this.q = 1073741824;
      this.h = 1073741824;
      return;
      this.m = null;
      this.f = null;
      this.p = 0;
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
  }
  
  final void a(fp paramfp)
  {
    int i2 = paramfp.a.size();
    int i1 = i2 - 1;
    if (i1 >= 0)
    {
      View localView = ((fz)paramfp.a.get(i1)).c;
      fz localfz = RecyclerView.b(localView);
      if (localfz.b()) {}
      for (;;)
      {
        i1 -= 1;
        break;
        localfz.a(false);
        if (localfz.m()) {
          this.m.removeDetachedView(localView, false);
        }
        ez localez = this.m.q;
        if (localez != null) {
          localez.endAnimation(localfz);
        }
        localfz.a(true);
        paramfp.b(localView);
      }
    }
    paramfp.a.clear();
    paramfp = paramfp.c;
    if (paramfp != null) {
      paramfp.clear();
    }
    if (i2 > 0) {
      this.m.invalidate();
    }
  }
  
  final void a(fp paramfp, int paramInt, View paramView)
  {
    fz localfz = RecyclerView.b(paramView);
    if (!localfz.b())
    {
      if ((localfz.j()) && (!localfz.l()) && (!this.m.g.a))
      {
        e(paramInt);
        paramfp.a(localfz);
      }
    }
    else {
      return;
    }
    f(paramInt);
    paramfp.c(paramView);
    this.m.M.c(localfz);
  }
  
  public void a(fp paramfp, fw paramfw)
  {
    Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
  }
  
  public final void a(ft paramft)
  {
    Object localObject = this.n;
    if (localObject == null) {}
    for (;;)
    {
      this.n = paramft;
      paramft = this.n;
      localObject = this.m;
      if (paramft.e)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("An instance of ");
        localStringBuilder.append(paramft.getClass().getSimpleName());
        localStringBuilder.append(" was started ");
        localStringBuilder.append("more than once. Each instance of");
        localStringBuilder.append(paramft.getClass().getSimpleName());
        localStringBuilder.append(" ");
        localStringBuilder.append("is intended to only be used once. You should create a new instance for ");
        localStringBuilder.append("each use.");
        Log.w("RecyclerView", localStringBuilder.toString());
      }
      paramft.c = ((RecyclerView)localObject);
      paramft.a = this;
      int i1 = paramft.f;
      if (i1 == -1) {
        throw new IllegalArgumentException("Invalid target position");
      }
      localObject = paramft.c;
      ((RecyclerView)localObject).G.m = i1;
      paramft.d = true;
      paramft.b = true;
      i1 = paramft.f;
      paramft.g = ((RecyclerView)localObject).u.a(i1);
      paramft.a();
      paramft.c.L.a();
      paramft.e = true;
      return;
      if ((paramft != localObject) && (((ft)localObject).d)) {
        ((ft)localObject).d();
      }
    }
  }
  
  public void a(fw paramfw) {}
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    Rect localRect = this.m.f(paramView);
    int i3 = localRect.left;
    int i4 = localRect.right;
    int i1 = localRect.top;
    int i2 = localRect.bottom;
    paramInt1 = a(this.p, this.q, i3 + i4 + paramInt1 + (i() + j() + localfj.leftMargin + localfj.rightMargin), localfj.width, n());
    paramInt2 = a(this.g, this.h, i2 + i1 + paramInt2 + (g() + h() + localfj.topMargin + localfj.bottomMargin), localfj.height, o());
    if (b(paramView, paramInt1, paramInt2, localfj)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    Rect localRect = localfj.a;
    paramView.layout(localRect.left + paramInt1 + localfj.leftMargin, localRect.top + paramInt2 + localfj.topMargin, paramInt3 - localRect.right - localfj.rightMargin, paramInt4 - localRect.bottom - localfj.bottomMargin);
  }
  
  public final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = RecyclerView.b(paramView);
    if ((paramBoolean) || (((fz)localObject1).l())) {
      this.m.M.b((fz)localObject1);
    }
    for (;;)
    {
      fj localfj1 = (fj)paramView.getLayoutParams();
      if ((((fz)localObject1).g()) || (((fz)localObject1).e())) {
        if (((fz)localObject1).e())
        {
          ((fz)localObject1).f();
          this.f.a(paramView, paramInt, paramView.getLayoutParams(), false);
        }
      }
      for (;;)
      {
        if (localfj1.c)
        {
          ((fz)localObject1).c.invalidate();
          localfj1.c = false;
        }
        return;
        ((fz)localObject1).h();
        break;
        Object localObject2;
        if (paramView.getParent() == this.m)
        {
          int i2 = this.f.c(paramView);
          int i1 = paramInt;
          if (paramInt == -1) {
            i1 = this.f.a();
          }
          if (i2 == -1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
            ((StringBuilder)localObject1).append(this.m.indexOfChild(paramView));
            ((StringBuilder)localObject1).append(this.m.a());
            throw new IllegalStateException(((StringBuilder)localObject1).toString());
          }
          if (i2 != i1)
          {
            paramView = this.m.u;
            localObject2 = paramView.d(i2);
            if (localObject2 == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Cannot move a child from non-existing index:");
              ((StringBuilder)localObject1).append(i2);
              ((StringBuilder)localObject1).append(paramView.m.toString());
              throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
            }
            paramView.f(i2);
            fj localfj2 = (fj)((View)localObject2).getLayoutParams();
            fz localfz = RecyclerView.b((View)localObject2);
            if (localfz.l()) {
              paramView.m.M.b(localfz);
            }
            for (;;)
            {
              paramView.f.a((View)localObject2, i1, localfj2, localfz.l());
              break;
              paramView.m.M.c(localfz);
            }
          }
        }
        else
        {
          this.f.a(paramView, paramInt, false);
          localfj1.b = true;
          localObject2 = this.n;
          if ((localObject2 != null) && (((ft)localObject2).d) && (RecyclerView.d(paramView) == ((ft)localObject2).f)) {
            ((ft)localObject2).g = paramView;
          }
        }
      }
      this.m.M.c((fz)localObject1);
    }
  }
  
  public final void a(View paramView, Rect paramRect)
  {
    RecyclerView localRecyclerView = this.m;
    if (localRecyclerView == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    paramRect.set(localRecyclerView.f(paramView));
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = true;
    Object localObject1 = this.m;
    Object localObject2 = ((RecyclerView)localObject1).B;
    localObject2 = ((RecyclerView)localObject1).G;
    if ((localObject1 != null) && (paramAccessibilityEvent != null))
    {
      boolean bool1 = bool2;
      if (!((RecyclerView)localObject1).canScrollVertically(1))
      {
        bool1 = bool2;
        if (!this.m.canScrollVertically(-1))
        {
          bool1 = bool2;
          if (!this.m.canScrollHorizontally(-1))
          {
            bool1 = bool2;
            if (!this.m.canScrollHorizontally(1)) {
              bool1 = false;
            }
          }
        }
      }
      paramAccessibilityEvent.setScrollable(bool1);
      localObject1 = this.m.g;
      if (localObject1 != null) {
        paramAccessibilityEvent.setItemCount(((eu)localObject1).c());
      }
    }
  }
  
  public void a(String paramString)
  {
    RecyclerView localRecyclerView = this.m;
    if (localRecyclerView != null) {
      localRecyclerView.a(paramString);
    }
  }
  
  public final boolean a(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    int[] arrayOfInt = new int[2];
    int i2 = i();
    int i3 = g();
    int i4 = this.p;
    int i10 = j();
    int i1 = this.g;
    int i7 = h();
    int i11 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
    int i8 = paramView.getTop() + paramRect.top - paramView.getScrollY();
    int i12 = paramRect.width();
    int i9 = paramRect.height();
    int i6 = i11 - i2;
    i2 = Math.min(0, i6);
    int i5 = i8 - i3;
    i3 = Math.min(0, i5);
    i10 = i11 + i12 - (i4 - i10);
    i4 = Math.max(0, i10);
    i7 = Math.max(0, i8 + i9 - (i1 - i7));
    if (ac.h(this.m) != 1)
    {
      i1 = i2;
      if (i2 == 0) {
        i1 = Math.min(i6, i4);
      }
    }
    for (;;)
    {
      i2 = i3;
      if (i3 == 0) {
        i2 = Math.min(i5, i7);
      }
      arrayOfInt[0] = i1;
      arrayOfInt[1] = i2;
      i1 = arrayOfInt[0];
      i2 = arrayOfInt[1];
      if (paramBoolean2)
      {
        paramView = paramRecyclerView.getFocusedChild();
        if (paramView != null)
        {
          i3 = i();
          i4 = g();
          i5 = this.p;
          i6 = j();
          i7 = this.g;
          i8 = h();
          paramRect = this.m.H;
          RecyclerView.b(paramView, paramRect);
          if ((paramRect.left - i1 >= i5 - i6) || (paramRect.right - i1 <= i3) || (paramRect.top - i2 >= i7 - i8) || (paramRect.bottom - i2 <= i4)) {}
        }
      }
      else
      {
        if (i1 != 0) {}
        while (i2 != 0)
        {
          if (!paramBoolean1) {
            paramRecyclerView.c_(i1, i2);
          }
          for (;;)
          {
            return true;
            paramRecyclerView.scrollBy(i1, i2);
          }
        }
      }
      return false;
      if (i4 == 0) {
        i1 = Math.max(i2, i10);
      } else {
        i1 = i4;
      }
    }
  }
  
  public boolean a(fj paramfj)
  {
    return paramfj != null;
  }
  
  boolean a(View paramView, int paramInt1, int paramInt2, fj paramfj)
  {
    return (!this.b) || (!b(paramView.getMeasuredWidth(), paramInt1, paramfj.width)) || (!b(paramView.getMeasuredHeight(), paramInt2, paramfj.height));
  }
  
  public int b(int paramInt, fp paramfp, fw paramfw)
  {
    return 0;
  }
  
  public int b(fp paramfp, fw paramfw)
  {
    int i2 = 1;
    paramfp = this.m;
    int i1 = i2;
    if (paramfp != null)
    {
      i1 = i2;
      if (paramfp.g != null)
      {
        i1 = i2;
        if (o()) {
          i1 = this.m.g.c();
        }
      }
    }
    return i1;
  }
  
  public int b(fw paramfw)
  {
    return 0;
  }
  
  final void b(int paramInt1, int paramInt2)
  {
    this.p = View.MeasureSpec.getSize(paramInt1);
    this.q = View.MeasureSpec.getMode(paramInt1);
    if ((this.q == 0) && (!RecyclerView.a)) {
      this.p = 0;
    }
    this.g = View.MeasureSpec.getSize(paramInt2);
    this.h = View.MeasureSpec.getMode(paramInt2);
    if ((this.h == 0) && (!RecyclerView.a)) {
      this.g = 0;
    }
  }
  
  final void b(RecyclerView paramRecyclerView)
  {
    b(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
  }
  
  public final void b(fp paramfp)
  {
    int i1 = w() - 1;
    if (i1 >= 0)
    {
      if (RecyclerView.b(d(i1)).b()) {}
      for (;;)
      {
        i1 -= 1;
        break;
        a(i1, paramfp);
      }
    }
  }
  
  public final void b(View paramView)
  {
    a(paramView, -1, false);
  }
  
  public final void b(View paramView, Rect paramRect)
  {
    Object localObject = ((fj)paramView.getLayoutParams()).a;
    int i1 = -((Rect)localObject).left;
    int i2 = -((Rect)localObject).top;
    int i3 = paramView.getWidth();
    int i4 = ((Rect)localObject).right;
    int i5 = paramView.getHeight();
    paramRect.set(i1, i2, i3 + i4, ((Rect)localObject).bottom + i5);
    if (this.m != null)
    {
      localObject = paramView.getMatrix();
      if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
      {
        RectF localRectF = this.m.I;
        localRectF.set(paramRect);
        ((Matrix)localObject).mapRect(localRectF);
        paramRect.set((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
      }
    }
    paramRect.offset(paramView.getLeft(), paramView.getTop());
  }
  
  boolean b(View paramView, int paramInt1, int paramInt2, fj paramfj)
  {
    return (paramView.isLayoutRequested()) || (!this.b) || (!b(paramView.getWidth(), paramInt1, paramfj.width)) || (!b(paramView.getHeight(), paramInt2, paramfj.height));
  }
  
  public int c(fp paramfp, fw paramfw)
  {
    int i2 = 1;
    paramfp = this.m;
    int i1 = i2;
    if (paramfp != null)
    {
      i1 = i2;
      if (paramfp.g != null)
      {
        i1 = i2;
        if (n()) {
          i1 = this.m.g.c();
        }
      }
    }
    return i1;
  }
  
  public int c(fw paramfw)
  {
    return 0;
  }
  
  public View c(int paramInt, fp paramfp, fw paramfw)
  {
    return null;
  }
  
  public void c(int paramInt) {}
  
  final void c(int paramInt1, int paramInt2)
  {
    int i3 = Integer.MAX_VALUE;
    int i2 = Integer.MIN_VALUE;
    int i10 = w();
    if (i10 != 0)
    {
      int i1 = 0;
      int i5 = Integer.MIN_VALUE;
      int i8 = Integer.MAX_VALUE;
      while (i1 < i10)
      {
        localObject = d(i1);
        Rect localRect = this.m.H;
        RecyclerView.b((View)localObject, localRect);
        i4 = i8;
        if (localRect.left < i8) {
          i4 = localRect.left;
        }
        i6 = i5;
        if (localRect.right > i5) {
          i6 = localRect.right;
        }
        int i7 = i3;
        if (localRect.top < i3) {
          i7 = localRect.top;
        }
        int i9 = i2;
        if (localRect.bottom > i2) {
          i9 = localRect.bottom;
        }
        i1 += 1;
        i8 = i4;
        i5 = i6;
        i3 = i7;
        i2 = i9;
      }
      this.m.H.set(i8, i3, i5, i2);
      Object localObject = this.m.H;
      int i4 = ((Rect)localObject).width();
      i5 = i();
      int i6 = j();
      i1 = ((Rect)localObject).height();
      i2 = g();
      i3 = h();
      paramInt1 = a(paramInt1, i4 + i5 + i6, ac.r(this.m));
      paramInt2 = a(paramInt2, i1 + i2 + i3, ac.s(this.m));
      RecyclerView.a(this.m, paramInt1, paramInt2);
      return;
    }
    this.m.d(paramInt1, paramInt2);
  }
  
  public final void c(View paramView)
  {
    a(paramView, 0, false);
  }
  
  public int d(fw paramfw)
  {
    return 0;
  }
  
  public final View d(int paramInt)
  {
    be localbe = this.f;
    if (localbe != null) {
      return localbe.b(paramInt);
    }
    return null;
  }
  
  public final void d(int paramInt1, int paramInt2)
  {
    this.m.d(paramInt1, paramInt2);
  }
  
  public final void d(View paramView)
  {
    a(paramView, -1, true);
  }
  
  public final int e()
  {
    return this.p;
  }
  
  public int e(fw paramfw)
  {
    return 0;
  }
  
  public final void e(View paramView)
  {
    a(paramView, 0, true);
  }
  
  public final int f()
  {
    return this.g;
  }
  
  public int f(fw paramfw)
  {
    return 0;
  }
  
  public final int g()
  {
    RecyclerView localRecyclerView = this.m;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingTop();
    }
    return 0;
  }
  
  public int g(fw paramfw)
  {
    return 0;
  }
  
  public final int h()
  {
    RecyclerView localRecyclerView = this.m;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingBottom();
    }
    return 0;
  }
  
  public final int i()
  {
    RecyclerView localRecyclerView = this.m;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingLeft();
    }
    return 0;
  }
  
  public final int j()
  {
    RecyclerView localRecyclerView = this.m;
    if (localRecyclerView != null) {
      return localRecyclerView.getPaddingRight();
    }
    return 0;
  }
  
  public boolean k()
  {
    return this.e;
  }
  
  public abstract fj l();
  
  public Parcelable m()
  {
    return null;
  }
  
  public boolean n()
  {
    return false;
  }
  
  public boolean o()
  {
    return false;
  }
  
  boolean r()
  {
    return false;
  }
  
  public boolean u()
  {
    return false;
  }
  
  public final void v()
  {
    RecyclerView localRecyclerView = this.m;
    if (localRecyclerView != null) {
      localRecyclerView.requestLayout();
    }
  }
  
  public final int w()
  {
    be localbe = this.f;
    if (localbe != null) {
      return localbe.a();
    }
    return 0;
  }
  
  public final View x()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getFocusedChild();
      if ((localObject != null) && (!this.f.d((View)localObject))) {
        return (View)localObject;
      }
      return null;
    }
    return null;
  }
  
  public final int y()
  {
    Object localObject = this.m;
    if (localObject != null) {}
    for (localObject = ((RecyclerView)localObject).getAdapter();; localObject = null)
    {
      if (localObject != null) {
        return ((eu)localObject).c();
      }
      return 0;
    }
  }
  
  public void z() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */