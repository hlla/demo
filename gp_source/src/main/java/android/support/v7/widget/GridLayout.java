package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ac;
import android.support.v7.d.a;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.reflect.Array;
import java.util.Arrays;

public class GridLayout
  extends ViewGroup
{
  public static final cx a = new cu();
  public static final cx b = new cw();
  public static final cx c;
  public static final cx d;
  private static final int f;
  private static final cx g;
  private static final cx h;
  private static final int i;
  private static final int j;
  private static final cx k;
  private static final cx l;
  private static final cx m;
  private static final Printer n = new LogPrinter(3, GridLayout.class.getName());
  private static final Printer o = new co();
  private static final int p = a.r;
  private static final cx q;
  private static final int r = a.s;
  private static final int s;
  private static final cx t;
  private static final cx u;
  private static final int v;
  private int A = 0;
  private boolean B = false;
  private final da C = new da(this, false);
  public Printer e = n;
  private int w = 1;
  private int x;
  private final da y = new da(this, true);
  private int z = 0;
  
  static
  {
    i = a.p;
    v = a.u;
    f = a.o;
    s = a.t;
    j = a.q;
    d = new cp();
    l = new cq();
    u = new cr();
    t = l;
    g = u;
    c = l;
    k = u;
    m = a(c, k);
    q = a(k, c);
    h = new ct();
  }
  
  public GridLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.x = paramContext.getResources().getDimensionPixelOffset(2131165527);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a);
    try
    {
      setRowCount(paramContext.getInt(r, Integer.MIN_VALUE));
      setColumnCount(paramContext.getInt(i, Integer.MIN_VALUE));
      setOrientation(paramContext.getInt(p, 0));
      setUseDefaultMargins(paramContext.getBoolean(v, false));
      setAlignmentMode(paramContext.getInt(f, 1));
      setRowOrderPreserved(paramContext.getBoolean(s, true));
      setColumnOrderPreserved(paramContext.getBoolean(j, true));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1 + paramInt2), View.MeasureSpec.getMode(paramInt1));
  }
  
  static int a(int[] paramArrayOfInt, int paramInt)
  {
    int i3 = paramArrayOfInt.length;
    int i2 = 0;
    int i1 = paramInt;
    paramInt = i2;
    while (paramInt < i3)
    {
      i1 = Math.max(i1, paramArrayOfInt[paramInt]);
      paramInt += 1;
    }
    return i1;
  }
  
  static cx a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (int i1 = 112;; i1 = 7)
    {
      if (!paramBoolean) {}
      for (int i2 = 4;; i2 = 0)
      {
        switch ((i1 & paramInt) >> i2)
        {
        default: 
          return d;
        case 7: 
          return b;
        case 8388613: 
          return k;
        case 8388611: 
          return c;
        case 3: 
          if (!paramBoolean) {
            return t;
          }
          return m;
        case 5: 
          if (!paramBoolean) {
            return g;
          }
          return q;
        }
        return h;
      }
    }
  }
  
  private static cx a(cx paramcx1, cx paramcx2)
  {
    return new cs(paramcx1, paramcx2);
  }
  
  static de a(View paramView)
  {
    return (de)paramView.getLayoutParams();
  }
  
  public static dh a()
  {
    return a(Integer.MIN_VALUE, 1, d, 0.0F);
  }
  
  public static dh a(int paramInt)
  {
    return a(paramInt, 1, d, 1.0F);
  }
  
  public static dh a(int paramInt1, int paramInt2, cx paramcx, float paramFloat)
  {
    if (paramInt1 != Integer.MIN_VALUE) {}
    for (boolean bool = true;; bool = false) {
      return new dh(bool, paramInt1, paramInt2, paramcx, paramFloat);
    }
  }
  
  private final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      de localde;
      if (localView.getVisibility() != 8)
      {
        localde = (de)localView.getLayoutParams();
        if (paramBoolean) {
          a(localView, paramInt1, paramInt2, localde.width, localde.height);
        }
      }
      else
      {
        i1 += 1;
        continue;
      }
      if (this.A == 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (!bool) {}
        for (Object localObject = localde.b;; localObject = localde.a)
        {
          if (((dh)localObject).a(bool) != b) {
            break label221;
          }
          dd localdd = ((dh)localObject).c;
          if (!bool) {}
          for (localObject = this.C;; localObject = this.y)
          {
            localObject = ((da)localObject).c();
            int i3 = localObject[localdd.a] - localObject[localdd.b] - a(localView, bool);
            if (bool)
            {
              a(localView, paramInt1, paramInt2, i3, localde.height);
              break;
            }
            a(localView, paramInt1, paramInt2, localde.width, i3);
            break;
          }
        }
        label221:
        break;
      }
    }
  }
  
  private static void a(de paramde, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dd localdd = new dd(paramInt1, paramInt1 + paramInt2);
    paramde.b = paramde.b.a(localdd);
    localdd = new dd(paramInt3, paramInt3 + paramInt4);
    paramde.a = paramde.a.a(localdd);
  }
  
  private final void a(de paramde, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "row";; str = "column")
    {
      if (!paramBoolean) {}
      for (paramde = paramde.b;; paramde = paramde.a)
      {
        dd localdd = paramde.c;
        int i1 = localdd.b;
        if (i1 == Integer.MIN_VALUE) {}
        for (;;)
        {
          if (!paramBoolean) {}
          for (paramde = this.C;; paramde = this.y)
          {
            i1 = paramde.a;
            if (i1 != Integer.MIN_VALUE)
            {
              if (localdd.a > i1)
              {
                paramde = new StringBuilder();
                paramde.append(str);
                paramde.append(" indices (start + span) mustn't exceed the ");
                paramde.append(str);
                paramde.append(" count");
                a(paramde.toString());
              }
              if (localdd.a() > i1)
              {
                paramde = new StringBuilder();
                paramde.append(str);
                paramde.append(" span mustn't exceed the ");
                paramde.append(str);
                paramde.append(" count");
                a(paramde.toString());
              }
            }
            return;
          }
          if (i1 < 0)
          {
            paramde = new StringBuilder();
            paramde.append(str);
            paramde.append(" indices must be positive");
            a(paramde.toString());
          }
        }
      }
    }
  }
  
  private final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.measure(getChildMeasureSpec(paramInt1, a(paramView, true), paramInt3), getChildMeasureSpec(paramInt2, a(paramView, false), paramInt4));
  }
  
  static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(". ");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static Object[] a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    Object localObject = paramArrayOfObject1.getClass().getComponentType();
    int i1 = paramArrayOfObject1.length;
    int i2 = paramArrayOfObject2.length;
    localObject = (Object[])Array.newInstance((Class)localObject, i1 + i2);
    System.arraycopy(paramArrayOfObject1, 0, localObject, 0, i1);
    System.arraycopy(paramArrayOfObject2, 0, localObject, i1, i2);
    return (Object[])localObject;
  }
  
  static int b(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramView.getMeasuredHeight();
    }
    return paramView.getMeasuredWidth();
  }
  
  private final int b(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.w != 1)
    {
      if (!paramBoolean1) {}
      for (Object localObject = this.C;; localObject = this.y)
      {
        if (!paramBoolean2)
        {
          if (((da)localObject).d == null) {
            ((da)localObject).d = new int[((da)localObject).a() + 1];
          }
          if (!((da)localObject).e)
          {
            ((da)localObject).b(false);
            ((da)localObject).e = true;
          }
        }
        for (localObject = ((da)localObject).d;; localObject = ((da)localObject).b)
        {
          paramView = (de)paramView.getLayoutParams();
          if (!paramBoolean1) {}
          for (paramView = paramView.b;; paramView = paramView.a)
          {
            if (!paramBoolean2) {}
            for (int i1 = paramView.c.a;; i1 = paramView.c.b) {
              return localObject[i1];
            }
          }
          if (((da)localObject).b == null) {
            ((da)localObject).b = new int[((da)localObject).a() + 1];
          }
          if (!((da)localObject).c)
          {
            ((da)localObject).b(true);
            ((da)localObject).c = true;
          }
        }
      }
    }
    return a(paramView, paramBoolean1, paramBoolean2);
  }
  
  private final boolean b()
  {
    boolean bool = true;
    if (ac.h(this) != 1) {
      bool = false;
    }
    return bool;
  }
  
  static boolean b(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  private final void c()
  {
    this.z = 0;
    da localda = this.y;
    if (localda != null) {
      localda.d();
    }
    localda = this.C;
    if (localda != null) {
      localda.d();
    }
    d();
  }
  
  private final void d()
  {
    da localda = this.y;
    if ((localda != null) && (this.C != null))
    {
      localda.e();
      this.C.e();
    }
  }
  
  private final int e()
  {
    int i4 = getChildCount();
    int i2 = 1;
    int i1 = 0;
    while (i1 < i4)
    {
      View localView = getChildAt(i1);
      int i3 = i2;
      if (localView.getVisibility() != 8) {
        i3 = ((de)localView.getLayoutParams()).hashCode() + i2 * 31;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  private final void f()
  {
    int i1;
    for (;;)
    {
      i1 = this.z;
      if (i1 == 0) {
        break;
      }
      if (i1 == e()) {
        break label452;
      }
      this.e.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
      c();
    }
    int i8 = this.A;
    if (i8 != 0) {}
    for (Object localObject = this.C;; localObject = this.y)
    {
      int i5 = ((da)localObject).a;
      if (i5 == Integer.MIN_VALUE) {
        i5 = 0;
      }
      for (;;)
      {
        int[] arrayOfInt = new int[i5];
        int i9 = getChildCount();
        int i6 = 0;
        int i2 = 0;
        i1 = 0;
        if (i6 < i9)
        {
          de localde = (de)getChildAt(i6).getLayoutParams();
          if (i8 != 0) {}
          for (localObject = localde.a;; localObject = localde.b)
          {
            dd localdd = ((dh)localObject).c;
            boolean bool1 = ((dh)localObject).d;
            int i10 = localdd.a();
            if (bool1) {
              i1 = localdd.b;
            }
            if (i8 != 0) {}
            for (localObject = localde.b;; localObject = localde.a)
            {
              localdd = ((dh)localObject).c;
              boolean bool2 = ((dh)localObject).d;
              int i7 = localdd.a();
              if (i5 == 0)
              {
                if (bool2) {}
                for (i3 = localdd.b;; i3 = i2)
                {
                  if (i5 == 0)
                  {
                    i2 = i3;
                    if (i8 != 0) {
                      a(localde, i2, i7, i1, i10);
                    }
                    for (;;)
                    {
                      i2 += i7;
                      i6 += 1;
                      break;
                      a(localde, i1, i10, i2, i7);
                    }
                  }
                  int i4;
                  if (!bool1)
                  {
                    i4 = i1;
                    i2 = i3;
                    label264:
                    i3 = i2 + i7;
                    if (i3 <= arrayOfInt.length)
                    {
                      i1 = i2;
                      label278:
                      if (i1 >= i3) {
                        i1 = i4;
                      }
                    }
                  }
                  for (;;)
                  {
                    i3 = arrayOfInt.length;
                    Arrays.fill(arrayOfInt, Math.min(i2, i3), Math.min(i2 + i7, i3), i1 + i10);
                    break;
                    if (arrayOfInt[i1] <= i4)
                    {
                      i1 += 1;
                      break label278;
                    }
                    if (bool2)
                    {
                      i4 += 1;
                      break label264;
                    }
                    if (i3 > i5)
                    {
                      i4 += 1;
                      i2 = 0;
                      break label264;
                    }
                    i2 += 1;
                    break label264;
                    i2 = i3;
                    i4 = i1;
                    if (!bool2) {
                      break label264;
                    }
                    i2 = i3;
                  }
                }
              }
              if (bool2) {}
              for (int i3 = Math.min(localdd.b, i5);; i3 = 0)
              {
                i7 = Math.min(i7, i5 - i3);
                break;
              }
            }
          }
        }
        this.z = e();
        label452:
        return;
      }
    }
  }
  
  final int a(View paramView, boolean paramBoolean)
  {
    return b(paramView, paramBoolean, true) + b(paramView, paramBoolean, false);
  }
  
  final int a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    Object localObject = (de)paramView.getLayoutParams();
    int i1;
    if (!paramBoolean1) {
      if (!paramBoolean2) {
        i1 = ((de)localObject).bottomMargin;
      }
    }
    for (;;)
    {
      if (i1 == Integer.MIN_VALUE)
      {
        if (!this.B)
        {
          i1 = 0;
          return i1;
        }
        if (!paramBoolean1) {}
        for (localObject = ((de)localObject).b;; localObject = ((de)localObject).a)
        {
          if (!paramBoolean1) {}
          for (da localda = this.C;; localda = this.y)
          {
            localObject = ((dh)localObject).c;
            if ((paramBoolean1) && (b())) {
              if (paramBoolean2) {
                break label133;
              }
            }
            for (;;)
            {
              i1 = i2;
              if (paramView.getClass() == android.support.v4.widget.Space.class) {
                break;
              }
              i1 = i2;
              if (paramView.getClass() == android.widget.Space.class) {
                break;
              }
              i1 = this.x / 2;
              break;
              if (!paramBoolean2) {
                label133:
                localda.a();
              }
            }
          }
        }
      }
      return i1;
      i1 = ((de)localObject).topMargin;
      continue;
      if (!paramBoolean2) {
        i1 = ((de)localObject).rightMargin;
      } else {
        i1 = ((de)localObject).leftMargin;
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof de))
    {
      paramLayoutParams = (de)paramLayoutParams;
      a(paramLayoutParams, true);
      a(paramLayoutParams, false);
      return true;
    }
    return false;
  }
  
  public int getAlignmentMode()
  {
    return this.w;
  }
  
  public int getColumnCount()
  {
    return this.y.a();
  }
  
  public int getOrientation()
  {
    return this.A;
  }
  
  public Printer getPrinter()
  {
    return this.e;
  }
  
  public int getRowCount()
  {
    return this.C.a();
  }
  
  public boolean getUseDefaultMargins()
  {
    return this.B;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    f();
    paramInt3 -= paramInt1;
    int i1 = getPaddingLeft();
    int i2 = getPaddingTop();
    int i3 = getPaddingRight();
    paramInt1 = getPaddingBottom();
    this.y.c(paramInt3 - i1 - i3);
    this.C.c(paramInt4 - paramInt2 - i2 - paramInt1);
    int[] arrayOfInt1 = this.y.c();
    int[] arrayOfInt2 = this.C.c();
    paramInt4 = getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt4)
    {
      View localView = getChildAt(paramInt1);
      int i10;
      int i4;
      int i8;
      int i13;
      int i5;
      int i6;
      int i9;
      int i7;
      if (localView.getVisibility() != 8)
      {
        Object localObject2 = (de)localView.getLayoutParams();
        Object localObject1 = ((de)localObject2).a;
        localObject2 = ((de)localObject2).b;
        Object localObject3 = ((dh)localObject1).c;
        Object localObject4 = ((dh)localObject2).c;
        i10 = arrayOfInt1[localObject3.b];
        i4 = arrayOfInt2[localObject4.b];
        i8 = arrayOfInt1[localObject3.a] - i10;
        i13 = arrayOfInt2[localObject4.a] - i4;
        int i16 = b(localView, true);
        int i14 = b(localView, false);
        localObject1 = ((dh)localObject1).a(true);
        localObject2 = ((dh)localObject2).a(false);
        localObject3 = (dc)this.y.b().a(paramInt1);
        localObject4 = (dc)this.C.b().a(paramInt1);
        int i11 = ((cx)localObject1).a(localView, i8 - ((dc)localObject3).a(true));
        i5 = ((cx)localObject2).a(localView, i13 - ((dc)localObject4).a(true));
        paramInt2 = b(localView, true, true);
        i6 = b(localView, false, true);
        i9 = b(localView, true, false);
        int i17 = paramInt2 + i9;
        int i15 = i6 + b(localView, false, false);
        int i12 = ((dc)localObject3).a(this, localView, (cx)localObject1, i16 + i17, true);
        i7 = ((dc)localObject4).a(this, localView, (cx)localObject2, i14 + i15, false);
        i8 = ((cx)localObject1).a(i16, i8 - i17);
        i13 = ((cx)localObject2).a(i14, i13 - i15);
        i10 = i12 + (i10 + i11);
        if (!b()) {
          break label522;
        }
      }
      label522:
      for (paramInt2 = paramInt3 - i8 - i3 - i9 - i10;; paramInt2 = i10 + (i1 + paramInt2))
      {
        i4 = i7 + (i2 + i4 + i5) + i6;
        if ((i8 != localView.getMeasuredWidth()) || (i13 != localView.getMeasuredHeight())) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
        }
        localView.layout(paramInt2, i4, i8 + paramInt2, i13 + i4);
        paramInt1 += 1;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    f();
    d();
    int i4 = getPaddingLeft() + getPaddingRight();
    int i3 = getPaddingTop() + getPaddingBottom();
    int i5 = a(paramInt1, -i4);
    int i6 = a(paramInt2, -i3);
    a(i5, i6, true);
    int i2;
    int i1;
    if (this.A == 0)
    {
      i2 = this.y.b(i5);
      a(i5, i6, false);
      i1 = this.C.b(i6);
    }
    for (;;)
    {
      i2 = Math.max(i2 + i4, getSuggestedMinimumWidth());
      i1 = Math.max(i1 + i3, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSizeAndState(i2, paramInt1, 0), View.resolveSizeAndState(i1, paramInt2, 0));
      return;
      i1 = this.C.b(i6);
      a(i5, i6, false);
      i2 = this.y.b(i5);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    c();
  }
  
  public void setAlignmentMode(int paramInt)
  {
    this.w = paramInt;
    requestLayout();
  }
  
  public void setColumnCount(int paramInt)
  {
    this.y.a(paramInt);
    c();
    requestLayout();
  }
  
  public void setColumnOrderPreserved(boolean paramBoolean)
  {
    this.y.a(paramBoolean);
    c();
    requestLayout();
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.A != paramInt)
    {
      this.A = paramInt;
      c();
      requestLayout();
    }
  }
  
  public void setPrinter(Printer paramPrinter)
  {
    Printer localPrinter = paramPrinter;
    if (paramPrinter == null) {
      localPrinter = o;
    }
    this.e = localPrinter;
  }
  
  public void setRowCount(int paramInt)
  {
    this.C.a(paramInt);
    c();
    requestLayout();
  }
  
  public void setRowOrderPreserved(boolean paramBoolean)
  {
    this.C.a(paramBoolean);
    c();
    requestLayout();
  }
  
  public void setUseDefaultMargins(boolean paramBoolean)
  {
    this.B = paramBoolean;
    requestLayout();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/GridLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */