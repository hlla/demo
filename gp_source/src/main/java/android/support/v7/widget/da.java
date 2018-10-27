package android.support.v7.widget;

import android.support.v4.view.ah;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class da
{
  public int a = Integer.MIN_VALUE;
  public int[] b;
  public boolean c = false;
  public int[] d;
  public boolean e = false;
  private cy[] f;
  private boolean g = false;
  private dg h;
  private boolean i = false;
  private int[] j;
  private dg k;
  private boolean l = false;
  private dg m;
  private boolean n = false;
  private boolean o;
  private boolean p = false;
  private final boolean q;
  private int[] r;
  private boolean s = false;
  private int t = Integer.MIN_VALUE;
  private boolean u = true;
  private df v = new df(-100000);
  private df w = new df(0);
  
  da(GridLayout paramGridLayout, boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  private final void a(int paramInt, float paramFloat)
  {
    Arrays.fill(this.j, 0);
    int i2 = this.x.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = this.x.getChildAt(i1);
      if (((View)localObject).getVisibility() != 8)
      {
        localObject = GridLayout.a((View)localObject);
        if (!this.q)
        {
          localObject = ((de)localObject).b;
          label69:
          float f1 = ((dh)localObject).e;
          if (f1 != 0.0F)
          {
            int i3 = Math.round(paramInt * f1 / paramFloat);
            this.j[i1] = i3;
            paramFloat -= f1;
            paramInt -= i3;
          }
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        continue;
        localObject = ((de)localObject).a;
        break label69;
      }
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    this.w.a = paramInt1;
    this.v.a = (-paramInt2);
    this.s = false;
  }
  
  private final void a(dg paramdg, boolean paramBoolean)
  {
    int i2 = 0;
    Object localObject = (df[])paramdg.b;
    int i1 = 0;
    while (i1 < localObject.length)
    {
      localObject[i1].a = Integer.MIN_VALUE;
      i1 += 1;
    }
    localObject = (dc[])b().b;
    i1 = i2;
    while (i1 < localObject.length)
    {
      int i3 = localObject[i1].a(paramBoolean);
      df localdf = (df)paramdg.a(i1);
      int i4 = localdf.a;
      i2 = i3;
      if (!paramBoolean) {
        i2 = -i3;
      }
      localdf.a = Math.max(i4, i2);
      i1 += 1;
    }
  }
  
  private static void a(List paramList, dd paramdd, df paramdf, boolean paramBoolean)
  {
    if (paramdd.a() != 0)
    {
      if (paramBoolean)
      {
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((cy)localIterator.next()).a.equals(paramdd));
      }
    }
    else {
      return;
    }
    paramList.add(new cy(paramdd, paramdf));
  }
  
  private static void a(List paramList, dg paramdg)
  {
    int i1 = 0;
    for (;;)
    {
      dd[] arrayOfdd = (dd[])paramdg.a;
      if (i1 >= arrayOfdd.length) {
        break;
      }
      a(paramList, arrayOfdd[i1], ((df[])paramdg.b)[i1], false);
      i1 += 1;
    }
  }
  
  private final boolean a(int[] paramArrayOfInt)
  {
    return a(i(), paramArrayOfInt, true);
  }
  
  private static boolean a(int[] paramArrayOfInt, cy paramcy)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramcy.b)
    {
      dd localdd = paramcy.a;
      int i2 = localdd.b;
      int i1 = localdd.a;
      int i3 = paramcy.c.a;
      i2 = paramArrayOfInt[i2] + i3;
      bool1 = bool2;
      if (i2 > paramArrayOfInt[i1])
      {
        paramArrayOfInt[i1] = i2;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final boolean a(cy[] paramArrayOfcy, int[] paramArrayOfInt, boolean paramBoolean)
  {
    boolean bool3 = false;
    int i5 = 0;
    if (!this.q) {}
    for (String str = "vertical";; str = "horizontal")
    {
      int i6 = a() + 1;
      Object localObject1 = null;
      int i1 = 0;
      if (i1 < paramArrayOfcy.length)
      {
        Arrays.fill(paramArrayOfInt, 0);
        int i2 = 0;
        int i3;
        cy localcy;
        boolean bool2;
        while (i2 < i6)
        {
          int i7 = paramArrayOfcy.length;
          i3 = 0;
          boolean bool1 = false;
          while (i3 < i7)
          {
            bool1 |= a(paramArrayOfInt, paramArrayOfcy[i3]);
            i3 += 1;
          }
          if (bool1)
          {
            i2 += 1;
          }
          else
          {
            if (localObject1 != null)
            {
              paramArrayOfInt = new ArrayList();
              localObject2 = new ArrayList();
              i1 = i5;
              if (i1 < paramArrayOfcy.length)
              {
                localcy = paramArrayOfcy[i1];
                if (localObject1[i1] != 0) {
                  paramArrayOfInt.add(localcy);
                }
                if (localcy.b) {}
                for (;;)
                {
                  i1 += 1;
                  break;
                  ((List)localObject2).add(localcy);
                }
              }
              paramArrayOfcy = this.x.e;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(" constraints: ");
              ((StringBuilder)localObject1).append(b(paramArrayOfInt));
              ((StringBuilder)localObject1).append(" are inconsistent; permanently removing: ");
              ((StringBuilder)localObject1).append(b((List)localObject2));
              ((StringBuilder)localObject1).append(". ");
              paramArrayOfcy.println(((StringBuilder)localObject1).toString());
            }
            bool2 = true;
          }
        }
        do
        {
          return bool2;
          bool2 = bool3;
        } while (!paramBoolean);
        Object localObject2 = new boolean[paramArrayOfcy.length];
        i2 = 0;
        while (i2 < i6)
        {
          int i4 = paramArrayOfcy.length;
          i3 = 0;
          while (i3 < i4)
          {
            localObject2[i3] |= a(paramArrayOfInt, paramArrayOfcy[i3]);
            i3 += 1;
          }
          i2 += 1;
        }
        if (i1 == 0) {
          localObject1 = localObject2;
        }
        i2 = 0;
        label368:
        if (i2 >= paramArrayOfcy.length) {}
        for (;;)
        {
          i1 += 1;
          break;
          if (localObject2[i2] != 0)
          {
            localcy = paramArrayOfcy[i2];
            dd localdd = localcy.a;
            if (localdd.b >= localdd.a) {}
          }
          else
          {
            i2 += 1;
            break label368;
          }
          localcy.b = false;
        }
      }
      return true;
    }
  }
  
  private final cy[] a(List paramList)
  {
    paramList = new db(this, (cy[])paramList.toArray(new cy[paramList.size()]));
    int i2 = paramList.a.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramList.a(i1);
      i1 += 1;
    }
    return paramList.b;
  }
  
  private final int b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    return c()[a()];
  }
  
  private final String b(List paramList)
  {
    if (!this.q) {}
    for (String str = "y";; str = "x")
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      int i1 = 1;
      if (localIterator.hasNext())
      {
        paramList = (cy)localIterator.next();
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        for (;;)
        {
          dd localdd = paramList.a;
          int i2 = localdd.b;
          int i3 = localdd.a;
          int i4 = paramList.c.a;
          if (i2 >= i3)
          {
            paramList = new StringBuilder();
            paramList.append(str);
            paramList.append(i2);
            paramList.append("-");
            paramList.append(str);
            paramList.append(i3);
            paramList.append("<=");
            paramList.append(-i4);
          }
          for (paramList = paramList.toString();; paramList = paramList.toString())
          {
            localStringBuilder.append(paramList);
            break;
            paramList = new StringBuilder();
            paramList.append(str);
            paramList.append(i3);
            paramList.append("-");
            paramList.append(str);
            paramList.append(i2);
            paramList.append(">=");
            paramList.append(i4);
          }
          i1 = 0;
        }
      }
      return localStringBuilder.toString();
    }
  }
  
  private final dg c(boolean paramBoolean)
  {
    cz localcz = cz.a(dd.class, df.class);
    dh[] arrayOfdh = (dh[])b().a;
    int i2 = arrayOfdh.length;
    int i1 = 0;
    if (i1 < i2)
    {
      if (!paramBoolean) {
        localdd = arrayOfdh[i1].c;
      }
      for (dd localdd = new dd(localdd.a, localdd.b);; localdd = arrayOfdh[i1].c)
      {
        localcz.a(localdd, new df());
        i1 += 1;
        break;
      }
    }
    return localcz.a();
  }
  
  private final int f()
  {
    int i1;
    if (this.t == Integer.MIN_VALUE)
    {
      int i3 = this.x.getChildCount();
      int i2 = 0;
      i1 = -1;
      if (i2 < i3)
      {
        Object localObject = GridLayout.a(this.x.getChildAt(i2));
        if (!this.q) {}
        for (localObject = ((de)localObject).b;; localObject = ((de)localObject).a)
        {
          localObject = ((dh)localObject).c;
          i1 = Math.max(Math.max(Math.max(i1, ((dd)localObject).b), ((dd)localObject).a), ((dd)localObject).a());
          i2 += 1;
          break;
        }
      }
      if (i1 != -1) {
        break label125;
      }
      i1 = Integer.MIN_VALUE;
    }
    label125:
    for (;;)
    {
      this.t = Math.max(0, i1);
      return this.t;
    }
  }
  
  private final dg g()
  {
    if (this.k == null) {
      this.k = c(true);
    }
    if (!this.l)
    {
      a(this.k, true);
      this.l = true;
    }
    return this.k;
  }
  
  private final dg h()
  {
    if (this.h == null) {
      this.h = c(false);
    }
    if (!this.i)
    {
      a(this.h, false);
      this.i = true;
    }
    return this.h;
  }
  
  private final cy[] i()
  {
    if (this.f != null)
    {
      if (!this.g)
      {
        g();
        h();
        this.g = true;
      }
      return this.f;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(localArrayList1, g());
    a(localArrayList2, h());
    if (!this.u) {}
    for (;;)
    {
      int i1 = a();
      a(localArrayList1, new dd(0, i1), this.w, false);
      a(localArrayList2, new dd(i1, 0), this.v, false);
      this.f = ((cy[])GridLayout.a(a(localArrayList1), a(localArrayList2)));
      break;
      int i2;
      for (i1 = 0; i1 < a(); i1 = i2)
      {
        i2 = i1 + 1;
        a(localArrayList1, new dd(i1, i2), new df(0), true);
      }
    }
  }
  
  private final int[] j()
  {
    if (this.j == null) {
      this.j = new int[this.x.getChildCount()];
    }
    return this.j;
  }
  
  public final int a()
  {
    return Math.max(this.a, f());
  }
  
  public final void a(int paramInt)
  {
    StringBuilder localStringBuilder;
    if ((paramInt != Integer.MIN_VALUE) && (paramInt < f()))
    {
      localStringBuilder = new StringBuilder();
      if (this.q) {
        break label68;
      }
    }
    label68:
    for (String str = "row";; str = "column")
    {
      localStringBuilder.append(str);
      localStringBuilder.append("Count must be greater than or equal to the maximum of all grid indices ");
      localStringBuilder.append("(and spans) defined in the LayoutParams of each child");
      GridLayout.a(localStringBuilder.toString());
      this.a = paramInt;
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.u = paramBoolean;
    d();
  }
  
  public final int b(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    switch (i1)
    {
    default: 
      return 0;
    case 1073741824: 
      return b(paramInt, paramInt);
    case 0: 
      return b(0, 100000);
    }
    return b(0, paramInt);
  }
  
  public final dg b()
  {
    Object localObject2;
    int i2;
    int i1;
    Object localObject1;
    boolean bool;
    if (this.m == null)
    {
      localObject2 = cz.a(dh.class, dc.class);
      i2 = this.x.getChildCount();
      i1 = 0;
      if (i1 < i2)
      {
        localObject1 = GridLayout.a(this.x.getChildAt(i1));
        bool = this.q;
        if (!bool) {}
        for (localObject1 = ((de)localObject1).b;; localObject1 = ((de)localObject1).a)
        {
          ((cz)localObject2).a(localObject1, ((dh)localObject1).a(bool).b());
          i1 += 1;
          break;
        }
      }
      this.m = ((cz)localObject2).a();
    }
    if (!this.n)
    {
      localObject1 = (dc[])this.m.b;
      i1 = 0;
      while (i1 < localObject1.length)
      {
        localObject1[i1].a();
        i1 += 1;
      }
      int i4 = this.x.getChildCount();
      i2 = 0;
      if (i2 < i4)
      {
        localObject2 = this.x.getChildAt(i2);
        localObject1 = GridLayout.a((View)localObject2);
        bool = this.q;
        if (!bool) {}
        for (localObject1 = ((de)localObject1).b;; localObject1 = ((de)localObject1).a)
        {
          Object localObject3 = this.x;
          if (((View)localObject2).getVisibility() != 8) {
            i1 = GridLayout.b((View)localObject2, bool);
          }
          for (i1 = ((GridLayout)localObject3).a((View)localObject2, bool) + i1;; i1 = 0)
          {
            if (((dh)localObject1).e != 0.0F) {}
            for (int i3 = j()[i2];; i3 = 0)
            {
              localObject3 = (dc)this.m.a(i2);
              GridLayout localGridLayout = this.x;
              i3 += i1;
              int i5 = ((dc)localObject3).a;
              if (((dh)localObject1).b == GridLayout.d) {
                if (((dh)localObject1).e == 0.0F) {
                  i1 = 0;
                }
              }
              for (;;)
              {
                ((dc)localObject3).a = (i1 & i5);
                i1 = ((dh)localObject1).a(this.q).a((View)localObject2, i3, ah.a(localGridLayout));
                ((dc)localObject3).a(i1, i3 - i1);
                i2 += 1;
                break;
                i1 = 2;
                continue;
                i1 = 2;
              }
            }
          }
        }
      }
      this.n = true;
    }
    return this.m;
  }
  
  final void b(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (int[] arrayOfInt = this.d;; arrayOfInt = this.b)
    {
      int i3 = this.x.getChildCount();
      int i1 = 0;
      if (i1 >= i3) {
        break;
      }
      View localView = this.x.getChildAt(i1);
      boolean bool;
      if (localView.getVisibility() != 8)
      {
        localObject = GridLayout.a(localView);
        bool = this.q;
        if (bool) {
          break label128;
        }
      }
      label128:
      for (Object localObject = ((de)localObject).b;; localObject = ((de)localObject).a)
      {
        localObject = ((dh)localObject).c;
        if (!paramBoolean) {}
        for (int i2 = ((dd)localObject).a;; i2 = ((dd)localObject).b)
        {
          arrayOfInt[i2] = Math.max(arrayOfInt[i2], this.x.a(localView, bool, paramBoolean));
          i1 += 1;
          break;
        }
      }
    }
  }
  
  public final void c(int paramInt)
  {
    a(paramInt, paramInt);
    c();
  }
  
  public final int[] c()
  {
    int i5 = 0;
    if (this.r == null) {
      this.r = new int[a() + 1];
    }
    int[] arrayOfInt;
    int i3;
    float f1;
    Object localObject;
    if (!this.s)
    {
      arrayOfInt = this.r;
      if (!this.p) {
        break label359;
      }
      if (!this.o) {
        break label349;
      }
      Arrays.fill(j(), 0);
      a(arrayOfInt);
      i2 = this.w.a * this.x.getChildCount() + 1;
      if (i2 >= 2)
      {
        i3 = this.x.getChildCount();
        f1 = 0.0F;
        i1 = 0;
        if (i1 < i3)
        {
          localObject = this.x.getChildAt(i1);
          if (((View)localObject).getVisibility() != 8)
          {
            localObject = GridLayout.a((View)localObject);
            if (!this.q)
            {
              localObject = ((de)localObject).b;
              label147:
              f1 = ((dh)localObject).e + f1;
            }
          }
          for (;;)
          {
            i1 += 1;
            break;
            localObject = ((de)localObject).a;
            break label147;
          }
        }
        i1 = -1;
        bool = true;
        i3 = 0;
        if (i3 < i2)
        {
          int i4 = (int)((i3 + i2) / 2L);
          e();
          a(i4, f1);
          bool = a(i(), arrayOfInt, false);
          if (bool)
          {
            i1 = i4 + 1;
            i3 = i2;
            i2 = i1;
            i1 = i4;
          }
          for (;;)
          {
            i4 = i3;
            i3 = i2;
            i2 = i4;
            break;
            i2 = i3;
            i3 = i4;
          }
        }
        if (i1 > 0) {
          break label324;
        }
      }
    }
    for (;;)
    {
      if (!this.u)
      {
        i2 = arrayOfInt[0];
        i3 = arrayOfInt.length;
        i1 = i5;
        while (i1 < i3)
        {
          arrayOfInt[i1] -= i2;
          i1 += 1;
        }
      }
      this.s = true;
      return this.r;
      label324:
      if (!bool)
      {
        e();
        a(i1, f1);
        a(arrayOfInt);
        continue;
        label349:
        a(arrayOfInt);
      }
    }
    label359:
    int i2 = this.x.getChildCount();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label459;
      }
      localObject = this.x.getChildAt(i1);
      if (((View)localObject).getVisibility() != 8)
      {
        localObject = GridLayout.a((View)localObject);
        if (this.q) {
          break label449;
        }
        localObject = ((de)localObject).b;
        label415:
        if (((dh)localObject).e != 0.0F) {
          break;
        }
      }
      i1 += 1;
    }
    label449:
    label459:
    for (boolean bool = true;; bool = false)
    {
      this.o = bool;
      this.p = true;
      break;
      localObject = ((de)localObject).a;
      break label415;
    }
  }
  
  public final void d()
  {
    this.t = Integer.MIN_VALUE;
    this.m = null;
    this.k = null;
    this.h = null;
    this.b = null;
    this.d = null;
    this.f = null;
    this.r = null;
    this.j = null;
    this.p = false;
    e();
  }
  
  public final void e()
  {
    this.n = false;
    this.l = false;
    this.i = false;
    this.c = false;
    this.e = false;
    this.g = false;
    this.s = false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */