package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.support.constraint.a.a.e;
import android.support.constraint.a.a.f;
import android.support.constraint.a.a.h;
import android.support.constraint.a.a.i;
import android.support.constraint.a.a.j;
import android.support.constraint.a.a.o;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.Xml;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintLayout
  extends ViewGroup
{
  private SparseArray a = new SparseArray();
  private b b = null;
  private boolean c = true;
  private i d = new i();
  private int e = Integer.MAX_VALUE;
  private int f = Integer.MAX_VALUE;
  private int g = 0;
  private int h = 0;
  private int i = 2;
  private final ArrayList j = new ArrayList(100);
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private final f a(int paramInt)
  {
    if (paramInt != 0)
    {
      View localView = (View)this.a.get(paramInt);
      if (localView != this)
      {
        if (localView != null) {
          return ((a)localView.getLayoutParams()).X;
        }
        return null;
      }
      return this.d;
    }
    return this.d;
  }
  
  private final f a(View paramView)
  {
    if (paramView != this)
    {
      if (paramView != null) {
        return ((a)paramView.getLayoutParams()).X;
      }
      return null;
    }
    return this.d;
  }
  
  protected static a a()
  {
    return new a();
  }
  
  private final void a(AttributeSet paramAttributeSet)
  {
    this.d.f = this;
    this.a.put(getId(), this);
    this.b = null;
    int m;
    label180:
    b localb;
    Context localContext;
    XmlResourceParser localXmlResourceParser;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, d.a);
      int n = paramAttributeSet.getIndexCount();
      int k = 0;
      if (k < n)
      {
        m = paramAttributeSet.getIndex(k);
        if (m == d.e) {
          this.h = paramAttributeSet.getDimensionPixelOffset(m, this.h);
        }
        do
        {
          for (;;)
          {
            k += 1;
            break;
            if (m == d.d)
            {
              this.g = paramAttributeSet.getDimensionPixelOffset(m, this.g);
            }
            else if (m == d.c)
            {
              this.f = paramAttributeSet.getDimensionPixelOffset(m, this.f);
            }
            else if (m == d.b)
            {
              this.e = paramAttributeSet.getDimensionPixelOffset(m, this.e);
            }
            else
            {
              if (m != d.U) {
                break label180;
              }
              this.i = paramAttributeSet.getInt(m, this.i);
            }
          }
        } while (m != d.g);
        m = paramAttributeSet.getResourceId(m, 0);
        this.b = new b();
        localb = this.b;
        localContext = getContext();
        localXmlResourceParser = localContext.getResources().getXml(m);
      }
    }
    for (;;)
    {
      try
      {
        m = localXmlResourceParser.getEventType();
        break label393;
        m = localXmlResourceParser.next();
        break label393;
        String str = localXmlResourceParser.getName();
        Object localObject = Xml.asAttributeSet(localXmlResourceParser);
        localc = new c();
        localObject = localContext.obtainStyledAttributes((AttributeSet)localObject, d.V);
        b.a(localc, (TypedArray)localObject);
        ((TypedArray)localObject).recycle();
        if (!str.equalsIgnoreCase("Guideline"))
        {
          localb.a.put(Integer.valueOf(localc.H), localc);
          continue;
        }
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        c localc;
        com.google.e.a.a.a.a.a.a.a(localXmlPullParserException);
        break;
        localc.G = true;
        continue;
      }
      catch (IOException localIOException)
      {
        com.google.e.a.a.a.a.a.a.a(localIOException);
      }
      break;
      localXmlResourceParser.getName();
      continue;
      paramAttributeSet.recycle();
      this.d.ad = this.i;
      return;
      label393:
      if (m == 1) {
        break;
      }
      switch (m)
      {
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof a;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new a(paramLayoutParams);
  }
  
  public int getMaxHeight()
  {
    return this.e;
  }
  
  public int getMaxWidth()
  {
    return this.f;
  }
  
  public int getMinHeight()
  {
    return this.g;
  }
  
  public int getMinWidth()
  {
    return this.h;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      Object localObject = (a)localView.getLayoutParams();
      if ((localView.getVisibility() != 8) || (((a)localObject).v))
      {
        label52:
        localObject = ((a)localObject).X;
        paramInt3 = ((f)localObject).g();
        paramInt4 = ((f)localObject).h();
        localView.layout(paramInt3, paramInt4, ((f)localObject).c() + paramInt3, ((f)localObject).f() + paramInt4);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if (paramBoolean) {
          break label52;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i8 = getPaddingLeft();
    int i9 = getPaddingTop();
    Object localObject1 = this.d;
    ((f)localObject1).aa = i8;
    ((f)localObject1).ab = i9;
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i4 = getPaddingLeft();
    int i5 = getPaddingRight();
    localObject1 = h.a;
    Object localObject2 = h.a;
    getLayoutParams();
    switch (i3)
    {
    default: 
      k = 0;
    }
    for (;;)
    {
      label175:
      label290:
      int i6;
      Object localObject3;
      label417:
      label435:
      label471:
      label596:
      label680:
      Object localObject4;
      label1149:
      label1155:
      label1388:
      label1532:
      float f1;
      switch (n)
      {
      default: 
        m = 0;
        this.d.c(0);
        this.d.d(0);
        this.d.a((h)localObject1);
        this.d.a(k);
        this.d.b((h)localObject2);
        this.d.b(m);
        this.d.c(this.h - getPaddingLeft() - getPaddingRight());
        this.d.d(this.g - getPaddingTop() - getPaddingBottom());
        if (this.c)
        {
          this.c = false;
          m = getChildCount();
          k = 0;
          if (k < m) {
            break label1388;
          }
        }
        int i10;
        do
        {
          i4 = getPaddingTop() + getPaddingBottom();
          i5 = getPaddingLeft() + getPaddingRight();
          i6 = getChildCount();
          i2 = 0;
          if (i2 < i6)
          {
            localObject1 = getChildAt(i2);
            boolean bool;
            if (((View)localObject1).getVisibility() != 8)
            {
              localObject2 = (a)((View)localObject1).getLayoutParams();
              localObject3 = ((a)localObject2).X;
              if (!((a)localObject2).v)
              {
                i1 = ((a)localObject2).width;
                m = ((a)localObject2).height;
                bool = ((a)localObject2).t;
                if ((!bool) && (!((a)localObject2).V)) {
                  break label596;
                }
              }
            }
            for (;;)
            {
              if (i1 == 0) {
                n = getChildMeasureSpec(paramInt1, i5, -2);
              }
              for (k = 1;; k = 0)
              {
                if (m == 0) {
                  i1 = getChildMeasureSpec(paramInt2, i4, -2);
                }
                for (m = 1;; m = 0)
                {
                  ((View)localObject1).measure(n, i1);
                  i1 = ((View)localObject1).getMeasuredWidth();
                  n = ((View)localObject1).getMeasuredHeight();
                  ((f)localObject3).a(i1);
                  ((f)localObject3).b(n);
                  if (k != 0) {
                    ((f)localObject3).Z = i1;
                  }
                  if (m == 0) {}
                  for (;;)
                  {
                    if (!((a)localObject2).E) {}
                    for (;;)
                    {
                      i2 += 1;
                      break;
                      k = ((View)localObject1).getBaseline();
                      if (k != -1) {
                        ((f)localObject3).c = k;
                      }
                    }
                    ((f)localObject3).Y = n;
                  }
                  if (m == -1) {
                    break label435;
                  }
                  i1 = getChildMeasureSpec(paramInt2, i4, m);
                }
                if (i1 == -1) {
                  break label417;
                }
                n = getChildMeasureSpec(paramInt1, i5, i1);
              }
              if (bool) {}
              for (;;)
              {
                if (((a)localObject2).width == -1) {
                  break label680;
                }
                if (((a)localObject2).V)
                {
                  k = 0;
                  i3 = 0;
                  n = m;
                  m = i3;
                  break label471;
                }
                if ((((a)localObject2).y == 1) || (((a)localObject2).height == -1)) {
                  break;
                }
                k = 0;
                i3 = 0;
                n = m;
                m = i3;
                break label471;
                if (((a)localObject2).z == 1) {
                  break;
                }
              }
            }
          }
          if (getChildCount() <= 0) {}
          for (;;)
          {
            i4 = this.j.size();
            i3 = i9 + getPaddingBottom();
            i5 = i8 + getPaddingRight();
            if (i4 > 0)
            {
              localObject1 = this.d.s;
              localObject2 = h.d;
              localObject3 = this.d.R;
              localObject4 = h.d;
              k = 0;
              m = 0;
              i1 = 0;
              if (i1 < i4)
              {
                f localf = (f)this.j.get(i1);
                View localView;
                if (!(localf instanceof j))
                {
                  localView = (View)localf.f;
                  if (localView != null) {}
                }
                for (;;)
                {
                  i1 += 1;
                  break;
                  if (localView.getVisibility() != 8)
                  {
                    a locala = (a)localView.getLayoutParams();
                    if (locala.width == -2) {}
                    for (n = getChildMeasureSpec(paramInt1, i5, locala.width);; n = View.MeasureSpec.makeMeasureSpec(localf.c(), 1073741824))
                    {
                      if (locala.height == -2) {}
                      for (i2 = getChildMeasureSpec(paramInt2, i3, locala.height);; i2 = View.MeasureSpec.makeMeasureSpec(localf.f(), 1073741824))
                      {
                        localView.measure(n, i2);
                        i2 = localView.getMeasuredWidth();
                        n = localView.getMeasuredHeight();
                        if (i2 != localf.c())
                        {
                          localf.a(i2);
                          if (localObject1 == localObject2) {
                            if (localf.i() > this.d.c())
                            {
                              m = localf.i();
                              i2 = localf.a(e.g).b();
                              this.d.a(Math.max(this.h, m + i2));
                              m = 1;
                            }
                          }
                        }
                        for (;;)
                        {
                          if (n != localf.f())
                          {
                            localf.b(n);
                            if (localObject3 != localObject4) {
                              break label1155;
                            }
                            if (localf.j() <= this.d.f()) {
                              break label1149;
                            }
                            m = localf.j();
                            n = localf.a(e.b).b();
                            this.d.b(Math.max(this.g, m + n));
                            m = 1;
                          }
                          for (;;)
                          {
                            n = m;
                            if (locala.E)
                            {
                              i2 = localView.getBaseline();
                              n = m;
                              if (i2 != -1)
                              {
                                n = m;
                                if (i2 != localf.c)
                                {
                                  localf.c = i2;
                                  n = 1;
                                }
                              }
                            }
                            if (Build.VERSION.SDK_INT >= 11)
                            {
                              k = combineMeasuredStates(k, localView.getMeasuredState());
                              m = n;
                              break;
                            }
                            m = n;
                            break;
                            m = 1;
                            continue;
                            m = 1;
                          }
                          m = 1;
                          continue;
                          m = 1;
                        }
                      }
                    }
                  }
                }
              }
              n = k;
              if (m != 0) {
                this.d.o();
              }
            }
            for (n = k;; n = 0)
            {
              k = this.d.c() + i5;
              m = this.d.f() + i3;
              if (Build.VERSION.SDK_INT >= 11)
              {
                paramInt1 = resolveSizeAndState(k, paramInt1, n);
                k = resolveSizeAndState(m, paramInt2, n << 16);
                paramInt2 = Math.min(this.f, paramInt1) & 0xFFFFFF;
                k = Math.min(this.e, k) & 0xFFFFFF;
                localObject1 = this.d;
                paramInt1 = paramInt2;
                if (((i)localObject1).ae) {
                  paramInt1 = paramInt2 | 0x1000000;
                }
                paramInt2 = k;
                if (((i)localObject1).ac) {
                  paramInt2 = k | 0x1000000;
                }
                setMeasuredDimension(paramInt1, paramInt2);
                return;
              }
              setMeasuredDimension(k, m);
              return;
            }
            this.d.o();
          }
          if (!getChildAt(k).isLayoutRequested()) {
            break;
          }
          this.j.clear();
          localObject1 = this.b;
          if (localObject1 != null) {
            ((b)localObject1).a(this);
          }
          i10 = getChildCount();
          this.d.af.clear();
          i4 = 0;
        } while (i4 >= i10);
        localObject3 = getChildAt(i4);
        localObject2 = a((View)localObject3);
        if (localObject2 != null)
        {
          localObject1 = (a)((View)localObject3).getLayoutParams();
          ((f)localObject2).a();
          ((f)localObject2).W = ((View)localObject3).getVisibility();
          ((f)localObject2).f = localObject3;
          localObject3 = this.d;
          ((o)localObject3).af.add(localObject2);
          localObject4 = ((f)localObject2).J;
          if (localObject4 != null) {
            break label3389;
          }
          ((f)localObject2).J = ((f)localObject3);
          if ((!((a)localObject1).V) || (!((a)localObject1).t)) {
            this.j.add(localObject2);
          }
          if (!((a)localObject1).v) {
            break label1716;
          }
          localObject2 = (j)localObject2;
          k = ((a)localObject1).o;
          if (k != -1) {
            break label1687;
          }
          k = ((a)localObject1).p;
          if (k != -1) {
            break label1658;
          }
          f1 = ((a)localObject1).q;
          if (f1 != -1.0F) {
            break label1629;
          }
        }
        label1629:
        label1658:
        label1687:
        label1716:
        while ((((a)localObject1).J == -1) && (((a)localObject1).K == -1) && (((a)localObject1).L == -1) && (((a)localObject1).M == -1) && (((a)localObject1).S == -1) && (((a)localObject1).R == -1) && (((a)localObject1).c == -1) && (((a)localObject1).b == -1) && (((a)localObject1).a == -1) && (((a)localObject1).e == -1) && (((a)localObject1).f == -1) && (((a)localObject1).width != -1) && (((a)localObject1).height != -1)) {
          for (;;)
          {
            i4 += 1;
            break;
            if (f1 > -1.0F)
            {
              ((j)localObject2).af = f1;
              ((j)localObject2).ad = -1;
              ((j)localObject2).ae = -1;
              continue;
              if (k >= 0)
              {
                ((j)localObject2).af = -1.0F;
                ((j)localObject2).ad = -1;
                ((j)localObject2).ae = k;
                continue;
                if (k >= 0)
                {
                  ((j)localObject2).af = -1.0F;
                  ((j)localObject2).ad = k;
                  ((j)localObject2).ae = -1;
                }
              }
            }
          }
        }
        m = ((a)localObject1).J;
        k = ((a)localObject1).K;
        i2 = ((a)localObject1).L;
        i1 = ((a)localObject1).M;
        i3 = ((a)localObject1).G;
        n = ((a)localObject1).H;
        f1 = ((a)localObject1).I;
        if (Build.VERSION.SDK_INT < 17)
        {
          i5 = ((a)localObject1).w;
          i3 = ((a)localObject1).x;
          i1 = ((a)localObject1).N;
          i2 = ((a)localObject1).O;
          i6 = ((a)localObject1).k;
          n = ((a)localObject1).l;
          f1 = ((a)localObject1).r;
          if (i5 != -1)
          {
            k = i3;
            m = i5;
            label1951:
            if (i1 != -1)
            {
              i3 = i2;
              i2 = i1;
              i1 = i3;
              i3 = i6;
              label1973:
              if (m != -1)
              {
                localObject3 = a(m);
                if (localObject3 != null) {
                  ((f)localObject2).a(e.f, (f)localObject3, e.f, ((a)localObject1).leftMargin, i3);
                }
                label2012:
                if (i2 != -1)
                {
                  localObject3 = a(i2);
                  if (localObject3 != null) {
                    ((f)localObject2).a(e.g, (f)localObject3, e.f, ((a)localObject1).rightMargin, n);
                  }
                  label2051:
                  k = ((a)localObject1).S;
                  if (k != -1)
                  {
                    localObject3 = a(k);
                    if (localObject3 != null) {
                      ((f)localObject2).a(e.h, (f)localObject3, e.h, ((a)localObject1).topMargin, ((a)localObject1).n);
                    }
                    label2100:
                    k = ((a)localObject1).c;
                    if (k != -1)
                    {
                      localObject3 = a(k);
                      if (localObject3 != null) {
                        ((f)localObject2).a(e.b, (f)localObject3, e.h, ((a)localObject1).bottomMargin, ((a)localObject1).i);
                      }
                      label2149:
                      k = ((a)localObject1).a;
                      if (k != -1)
                      {
                        localObject4 = (View)this.a.get(k);
                        localObject3 = a(((a)localObject1).a);
                        if (localObject3 != null) {}
                      }
                      else
                      {
                        label2192:
                        if (f1 < 0.0F)
                        {
                          label2198:
                          f1 = ((a)localObject1).T;
                          if (f1 < 0.0F)
                          {
                            label2210:
                            if (isInEditMode())
                            {
                              k = ((a)localObject1).e;
                              if ((k != -1) || (((a)localObject1).f != -1))
                              {
                                m = ((a)localObject1).f;
                                ((f)localObject2).aa = k;
                                ((f)localObject2).ab = m;
                              }
                            }
                            if (!((a)localObject1).t) {
                              if (((a)localObject1).width == -1)
                              {
                                ((f)localObject2).a(h.c);
                                ((f)localObject2).a(e.f).c = ((a)localObject1).leftMargin;
                                ((f)localObject2).a(e.g).c = ((a)localObject1).rightMargin;
                                label2317:
                                if (!((a)localObject1).V) {
                                  if (((a)localObject1).height == -1)
                                  {
                                    ((f)localObject2).b(h.c);
                                    ((f)localObject2).a(e.h).c = ((a)localObject1).topMargin;
                                    ((f)localObject2).a(e.b).c = ((a)localObject1).bottomMargin;
                                    label2374:
                                    localObject3 = ((a)localObject1).d;
                                    if (localObject3 == null) {}
                                    for (;;)
                                    {
                                      ((f)localObject2).v = ((a)localObject1).u;
                                      ((f)localObject2).U = ((a)localObject1).W;
                                      ((f)localObject2).r = ((a)localObject1).s;
                                      ((f)localObject2).Q = ((a)localObject1).U;
                                      k = ((a)localObject1).z;
                                      m = ((a)localObject1).D;
                                      n = ((a)localObject1).B;
                                      ((f)localObject2).A = k;
                                      ((f)localObject2).E = m;
                                      ((f)localObject2).C = n;
                                      k = ((a)localObject1).y;
                                      m = ((a)localObject1).C;
                                      n = ((a)localObject1).A;
                                      ((f)localObject2).z = k;
                                      ((f)localObject2).D = m;
                                      ((f)localObject2).B = n;
                                      break;
                                      if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                                        break label2535;
                                      }
                                      ((f)localObject2).g = 0.0F;
                                    }
                                    label2535:
                                    n = ((String)localObject3).length();
                                    m = ((String)localObject3).indexOf(',');
                                    if (m <= 0)
                                    {
                                      k = -1;
                                      m = 0;
                                      label2562:
                                      i1 = ((String)localObject3).indexOf(':');
                                      if (i1 < 0)
                                      {
                                        label2576:
                                        localObject3 = ((String)localObject3).substring(m);
                                        if (((String)localObject3).length() <= 0) {
                                          break;
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
      try
      {
        f1 = Float.parseFloat((String)localObject3);
        while (f1 > 0.0F)
        {
          ((f)localObject2).g = f1;
          ((f)localObject2).h = k;
          break;
          f1 = 0.0F;
          continue;
          if (i1 >= n - 1) {
            break label2576;
          }
          localObject4 = ((String)localObject3).substring(m, i1);
          localObject3 = ((String)localObject3).substring(i1 + 1);
          if ((((String)localObject4).length() <= 0) || (((String)localObject3).length() > 0)) {}
          try
          {
            f1 = Float.parseFloat((String)localObject4);
            float f2 = Float.parseFloat((String)localObject3);
            if (f1 > 0.0F)
            {
              if (f2 <= 0.0F)
              {
                f1 = 0.0F;
                continue;
              }
              if (k != 1)
              {
                f1 = Math.abs(f1 / f2);
                continue;
              }
              f1 = Math.abs(f2 / f1);
              continue;
            }
            f1 = 0.0F;
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            int i7;
            f1 = 0.0F;
          }
          f1 = 0.0F;
          continue;
          f1 = 0.0F;
        }
        if (m < n - 1)
        {
          localObject4 = ((String)localObject3).substring(0, m);
          if (!((String)localObject4).equalsIgnoreCase("W")) {
            if (((String)localObject4).equalsIgnoreCase("H")) {
              k = 1;
            }
          }
          for (;;)
          {
            m += 1;
            break;
            k = -1;
            continue;
            k = 0;
          }
        }
        k = -1;
        m = 0;
        break label2562;
        ((f)localObject2).b(h.b);
        ((f)localObject2).b(0);
        break label2374;
        ((f)localObject2).b(h.a);
        ((f)localObject2).b(((a)localObject1).height);
        break label2374;
        ((f)localObject2).a(h.b);
        ((f)localObject2).a(0);
        break label2317;
        ((f)localObject2).a(h.a);
        ((f)localObject2).a(((a)localObject1).width);
        break label2317;
        if (f1 == 0.5F) {
          break label2210;
        }
        ((f)localObject2).O = f1;
        break label2210;
        if (f1 == 0.5F) {
          break label2198;
        }
        ((f)localObject2).p = f1;
        break label2198;
        if ((localObject4 == null) || (!(((View)localObject4).getLayoutParams() instanceof a))) {
          break label2192;
        }
        localObject4 = (a)((View)localObject4).getLayoutParams();
        ((a)localObject1).E = true;
        ((a)localObject4).E = true;
        ((f)localObject2).a(e.a).a(((f)localObject3).a(e.a), 0, -1, android.support.constraint.a.a.d.b, 0, true);
        ((f)localObject2).a(e.h).c();
        ((f)localObject2).a(e.b).c();
        break label2192;
        k = ((a)localObject1).b;
        if (k == -1) {
          break label2149;
        }
        localObject3 = a(k);
        if (localObject3 == null) {
          break label2149;
        }
        ((f)localObject2).a(e.b, (f)localObject3, e.b, ((a)localObject1).bottomMargin, ((a)localObject1).i);
        break label2149;
        k = ((a)localObject1).R;
        if (k == -1) {
          break label2100;
        }
        localObject3 = a(k);
        if (localObject3 == null) {
          break label2100;
        }
        ((f)localObject2).a(e.h, (f)localObject3, e.b, ((a)localObject1).topMargin, ((a)localObject1).n);
        break label2100;
        if (i1 == -1) {
          break label2051;
        }
        localObject3 = a(i1);
        if (localObject3 == null) {
          break label2051;
        }
        ((f)localObject2).a(e.g, (f)localObject3, e.g, ((a)localObject1).rightMargin, n);
        break label2051;
        if (k == -1) {
          break label2012;
        }
        localObject3 = a(k);
        if (localObject3 == null) {
          break label2012;
        }
        ((f)localObject2).a(e.f, (f)localObject3, e.g, ((a)localObject1).leftMargin, i3);
        break label2012;
        if (i2 != -1)
        {
          i5 = i1;
          i3 = i6;
          i1 = i2;
          i2 = i5;
          break label1973;
        }
        i3 = ((a)localObject1).h;
        if (i3 != -1)
        {
          i1 = i2;
          i2 = i3;
          i3 = i6;
          break label1973;
        }
        i3 = ((a)localObject1).g;
        if (i3 != -1)
        {
          i2 = i3;
          i5 = i1;
          i3 = i6;
          i1 = i2;
          i2 = i5;
          break label1973;
        }
        i5 = i1;
        i3 = i6;
        i1 = i2;
        i2 = i5;
        break label1973;
        if (i3 == -1)
        {
          m = ((a)localObject1).Q;
          if (m == -1)
          {
            i7 = ((a)localObject1).P;
            k = i7;
            m = i5;
            if (i7 != -1) {
              break label1951;
            }
            k = i3;
            m = i5;
            break label1951;
          }
          k = i3;
          break label1951;
        }
        k = i3;
        m = i5;
        break label1951;
        break label1973;
        label3389:
        ((o)localObject4).a((f)localObject2);
        break label1532;
        k += 1;
        break label290;
        m = Math.min(this.e, m) - (i1 + i2);
        break label175;
        localObject2 = h.d;
        break label175;
        localObject2 = h.d;
        m = 0;
        break label175;
        localObject1 = h.d;
        continue;
        k = Math.min(this.f, k) - (i4 + i5);
        continue;
        localObject1 = h.d;
        k = 0;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          f1 = 0.0F;
        }
      }
    }
  }
  
  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    Object localObject = a(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof j)))
    {
      localObject = (a)paramView.getLayoutParams();
      ((a)localObject).X = new j();
      ((a)localObject).v = true;
      ((j)((a)localObject).X).e(((a)localObject).F);
    }
    this.a.put(paramView.getId(), paramView);
    this.c = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    this.a.remove(paramView.getId());
    this.d.a(a(paramView));
    this.c = true;
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.c = true;
  }
  
  public void setConstraintSet(b paramb)
  {
    this.b = paramb;
  }
  
  public void setId(int paramInt)
  {
    this.a.remove(getId());
    super.setId(paramInt);
    this.a.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt != this.e)
    {
      this.e = paramInt;
      requestLayout();
    }
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt != this.f)
    {
      this.f = paramInt;
      requestLayout();
    }
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt != this.g)
    {
      this.g = paramInt;
      requestLayout();
    }
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt != this.h)
    {
      this.h = paramInt;
      requestLayout();
    }
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.d.ad = paramInt;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/ConstraintLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */