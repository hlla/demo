package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.g.h;
import android.support.v4.g.r;
import android.support.v4.g.v;
import android.support.v4.os.c;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.view.ag;
import android.support.v4.view.t;
import android.support.v4.widget.aa;
import android.support.v7.e.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements t
{
  public static final Interpolator N;
  private static final int[] O;
  private static final Class[] P;
  private static final int[] Q = { 16843830 };
  public static final boolean a;
  public static final boolean b;
  public static final boolean c;
  public static final boolean d;
  public cm A;
  public final fp B = new fp(this);
  public fq C;
  public EdgeEffect D;
  public final int[] E;
  public final int[] F;
  public final fw G;
  public final Rect H = new Rect();
  public final RectF I = new RectF();
  public EdgeEffect J;
  public final Runnable K = new eo(this);
  public final fy L = new fy(this);
  public final hz M = new hz();
  private final AccessibilityManager R;
  private ex S;
  private boolean T;
  private boolean U = false;
  private int V = 0;
  private int W;
  private int aA = 0;
  private android.support.v4.view.u aB;
  private final Rect aC = new Rect();
  private int aD;
  private VelocityTracker aE;
  private final ib aF;
  private ey aa = new ey();
  private boolean ab;
  private boolean ac;
  private int ad;
  private int ae;
  private int af = 0;
  private fb ag;
  private Runnable ah;
  private int ai;
  private int aj;
  private int ak = 0;
  private final int al;
  private final int am;
  private final int[] an;
  private final int[] ao;
  private final fr ap = new fr(this);
  private fk aq;
  private final List ar;
  private RecyclerView.SavedState as;
  private boolean at = true;
  private float au = Float.MIN_VALUE;
  private float av = Float.MIN_VALUE;
  private fm aw;
  private List ax;
  private final int[] ay;
  private int az = -1;
  public ga e;
  public fl f;
  public eu g;
  public x h;
  public boolean i;
  public EdgeEffect j;
  public be k;
  public boolean l = false;
  public boolean m;
  public ck n;
  public boolean o;
  public boolean p;
  public ez q = new bk();
  public final ArrayList r = new ArrayList();
  public boolean s;
  public boolean t;
  public ff u;
  public boolean v;
  public boolean w;
  public EdgeEffect x;
  public final ArrayList y = new ArrayList();
  public boolean z;
  
  static
  {
    O = new int[] { 16842987 };
    boolean bool;
    if (Build.VERSION.SDK_INT != 18) {
      if (Build.VERSION.SDK_INT != 19) {
        if (Build.VERSION.SDK_INT != 20) {
          bool = false;
        }
      }
    }
    for (;;)
    {
      c = bool;
      if (Build.VERSION.SDK_INT >= 23) {}
      for (bool = true;; bool = false)
      {
        a = bool;
        d = true;
        if (Build.VERSION.SDK_INT >= 21) {}
        for (bool = true;; bool = false)
        {
          b = bool;
          P = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
          N = new eq();
          return;
        }
      }
      bool = true;
      continue;
      bool = true;
      continue;
      bool = true;
    }
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (b) {
      localObject1 = new cm();
    }
    for (;;)
    {
      this.A = ((cm)localObject1);
      this.G = new fw();
      this.s = false;
      this.t = false;
      this.ag = new fd(this);
      this.z = false;
      this.an = new int[2];
      this.ay = new int[2];
      this.E = new int[2];
      this.ao = new int[2];
      this.F = new int[2];
      this.ar = new ArrayList();
      this.ah = new ep(this);
      this.aF = new er(this);
      label356:
      boolean bool;
      label430:
      Object localObject2;
      if (paramAttributeSet != null)
      {
        localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, O, paramInt, 0);
        this.T = ((TypedArray)localObject1).getBoolean(0, true);
        ((TypedArray)localObject1).recycle();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        localObject1 = ViewConfiguration.get(paramContext);
        this.aD = ((ViewConfiguration)localObject1).getScaledTouchSlop();
        this.au = ag.a((ViewConfiguration)localObject1, paramContext);
        this.av = ag.b((ViewConfiguration)localObject1, paramContext);
        this.am = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
        this.al = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
        if (getOverScrollMode() == 2)
        {
          bool = true;
          setWillNotDraw(bool);
          this.q.setListener(this.ag);
          this.h = new x(new et(this));
          this.k = new be(new es(this));
          if (ac.a(this) == 0) {
            ac.b(this);
          }
          if (ac.f(this) == 0) {
            ac.b(this, 1);
          }
          this.R = ((AccessibilityManager)getContext().getSystemService("accessibility"));
          setAccessibilityDelegateCompat(new ga(this));
          if (paramAttributeSet != null)
          {
            localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, a.a, paramInt, 0);
            localObject2 = ((TypedArray)localObject1).getString(a.h);
            if (((TypedArray)localObject1).getInt(a.b, -1) == -1) {
              setDescendantFocusability(262144);
            }
            this.ab = ((TypedArray)localObject1).getBoolean(a.c, false);
            if (this.ab)
            {
              localObject4 = (StateListDrawable)((TypedArray)localObject1).getDrawable(a.f);
              localObject5 = ((TypedArray)localObject1).getDrawable(a.g);
              StateListDrawable localStateListDrawable = (StateListDrawable)((TypedArray)localObject1).getDrawable(a.d);
              Drawable localDrawable = ((TypedArray)localObject1).getDrawable(a.e);
              if ((localObject4 == null) || (localObject5 == null) || (localStateListDrawable == null) || (localDrawable == null))
              {
                paramContext = new StringBuilder();
                paramContext.append("Trying to set fast scroller without both required drawables.");
                paramContext.append(a());
                throw new IllegalArgumentException(paramContext.toString());
              }
              Resources localResources = getContext().getResources();
              new ca(this, (StateListDrawable)localObject4, (Drawable)localObject5, localStateListDrawable, localDrawable, localResources.getDimensionPixelSize(2131165814), localResources.getDimensionPixelSize(2131165816), localResources.getDimensionPixelOffset(2131165815));
            }
            ((TypedArray)localObject1).recycle();
            if (localObject2 == null) {}
            label797:
            do
            {
              if (Build.VERSION.SDK_INT >= 21)
              {
                paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Q, paramInt, 0);
                bool = paramContext.getBoolean(0, true);
                paramContext.recycle();
              }
              for (;;)
              {
                setNestedScrollingEnabled(bool);
                return;
                bool = true;
              }
              localObject1 = ((String)localObject2).trim();
            } while (((String)localObject1).isEmpty());
            if (((String)localObject1).charAt(0) == '.')
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramContext.getPackageName());
              ((StringBuilder)localObject2).append((String)localObject1);
              localObject1 = ((StringBuilder)localObject2).toString();
            }
          }
        }
      }
      try
      {
        if (!isInEditMode())
        {
          localObject2 = paramContext.getClassLoader();
          localObject5 = ((ClassLoader)localObject2).loadClass((String)localObject1).asSubclass(ff.class);
        }
        try
        {
          localObject4 = ((Class)localObject5).getConstructor(P);
          localObject2 = new Object[4];
          localObject2[0] = paramContext;
          localObject2[1] = paramAttributeSet;
          localObject2[2] = Integer.valueOf(paramInt);
          localObject2[3] = Integer.valueOf(0);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          try
          {
            localObject4 = ((Class)localObject5).getConstructor(new Class[0]);
            localObject3 = null;
          }
          catch (NoSuchMethodException paramContext)
          {
            paramContext.initCause((Throwable)localObject3);
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramAttributeSet.getPositionDescription());
            ((StringBuilder)localObject3).append(": Error creating LayoutManager ");
            ((StringBuilder)localObject3).append((String)localObject1);
            throw new IllegalStateException(((StringBuilder)localObject3).toString(), paramContext);
          }
        }
        ((Constructor)localObject4).setAccessible(true);
        setLayoutManager((ff)((Constructor)localObject4).newInstance((Object[])localObject2));
      }
      catch (ClassNotFoundException paramContext)
      {
        for (;;)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramAttributeSet.getPositionDescription());
          ((StringBuilder)localObject2).append(": Unable to find LayoutManager ");
          ((StringBuilder)localObject2).append((String)localObject1);
          throw new IllegalStateException(((StringBuilder)localObject2).toString(), paramContext);
          localObject2 = getClass().getClassLoader();
          continue;
          if (!((String)localObject1).contains("."))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(RecyclerView.class.getPackage().getName());
            ((StringBuilder)localObject2).append('.');
            ((StringBuilder)localObject2).append((String)localObject1);
            localObject1 = ((StringBuilder)localObject2).toString();
          }
        }
        setDescendantFocusability(262144);
        bool = true;
        break label797;
        bool = false;
        break label430;
        this.T = true;
        break label356;
        localObject1 = null;
      }
      catch (InvocationTargetException paramContext)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAttributeSet.getPositionDescription());
        ((StringBuilder)localObject2).append(": Could not instantiate the LayoutManager: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        throw new IllegalStateException(((StringBuilder)localObject2).toString(), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAttributeSet.getPositionDescription());
        ((StringBuilder)localObject2).append(": Could not instantiate the LayoutManager: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        throw new IllegalStateException(((StringBuilder)localObject2).toString(), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAttributeSet.getPositionDescription());
        ((StringBuilder)localObject2).append(": Cannot access non-public constructor ");
        ((StringBuilder)localObject2).append((String)localObject1);
        throw new IllegalStateException(((StringBuilder)localObject2).toString(), paramContext);
      }
      catch (ClassCastException paramContext)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAttributeSet.getPositionDescription());
        ((StringBuilder)localObject2).append(": Class is not a LayoutManager ");
        ((StringBuilder)localObject2).append((String)localObject1);
        throw new IllegalStateException(((StringBuilder)localObject2).toString(), paramContext);
      }
    }
  }
  
  private final void A()
  {
    fw localfw = this.G;
    localfw.b = -1L;
    localfw.c = -1;
    localfw.d = -1;
  }
  
  private final void B()
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.L.c;
      localOverScroller.getFinalX();
      localOverScroller.getCurrX();
      localOverScroller.getFinalY();
      localOverScroller.getCurrY();
    }
  }
  
  private final void C()
  {
    this.G.a(1);
    B();
    this.G.f = false;
    aD_();
    this.M.a();
    k();
    y();
    Object localObject1;
    if (this.at) {
      if (hasFocus()) {
        if (this.g != null) {
          localObject1 = getFocusedChild();
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = i((View)localObject1);
        if (localObject1 != null) {
          localObject1 = a((View)localObject1);
        }
      }
      for (;;)
      {
        Object localObject2;
        long l1;
        int i1;
        label148:
        Object localObject3;
        if (localObject1 != null)
        {
          localObject2 = this.G;
          if (this.g.a)
          {
            l1 = ((fz)localObject1).f;
            ((fw)localObject2).b = l1;
            if (!this.l) {
              if (((fz)localObject1).l())
              {
                i1 = ((fz)localObject1).i;
                ((fw)localObject2).c = i1;
                localObject3 = this.G;
                localObject1 = ((fz)localObject1).c;
                i1 = ((View)localObject1).getId();
                while ((!((View)localObject1).isFocused()) && ((localObject1 instanceof ViewGroup)) && (((View)localObject1).hasFocus()))
                {
                  localObject2 = ((ViewGroup)localObject1).getFocusedChild();
                  localObject1 = localObject2;
                  if (((View)localObject2).getId() != -1)
                  {
                    i1 = ((View)localObject2).getId();
                    localObject1 = localObject2;
                  }
                }
                ((fw)localObject3).d = i1;
              }
            }
          }
        }
        for (;;)
        {
          localObject1 = this.G;
          boolean bool;
          if (((fw)localObject1).k) {
            if (this.t) {
              bool = true;
            }
          }
          for (;;)
          {
            ((fw)localObject1).n = bool;
            this.t = false;
            this.s = false;
            ((fw)localObject1).e = ((fw)localObject1).j;
            ((fw)localObject1).g = this.g.c();
            a(this.an);
            int i2;
            if (this.G.k)
            {
              i2 = this.k.a();
              i1 = 0;
              if (i1 < i2)
              {
                localObject1 = b(this.k.b(i1));
                if (((fz)localObject1).b()) {}
                for (;;)
                {
                  i1 += 1;
                  break;
                  if ((!((fz)localObject1).j()) || (this.g.a))
                  {
                    localObject2 = this.q.recordPreLayoutInformation(this.G, (fz)localObject1, ez.buildAdapterChangeFlagsForAnimations((fz)localObject1), ((fz)localObject1).o());
                    this.M.a((fz)localObject1, (fc)localObject2);
                    if ((this.G.n) && (((fz)localObject1).r()) && (!((fz)localObject1).l()) && (!((fz)localObject1).b()) && (!((fz)localObject1).j()))
                    {
                      l1 = d((fz)localObject1);
                      this.M.a(l1, (fz)localObject1);
                    }
                  }
                }
              }
            }
            if (!this.G.j) {
              E();
            }
            for (;;)
            {
              b(true);
              a(false);
              this.G.h = 2;
              return;
              i2 = this.k.b();
              i1 = 0;
              if (i1 < i2) {
                break;
              }
              localObject1 = this.G;
              bool = ((fw)localObject1).l;
              ((fw)localObject1).l = false;
              this.u.a(this.B, (fw)localObject1);
              this.G.l = bool;
              i1 = 0;
              if (i1 < this.k.a())
              {
                localObject3 = b(this.k.b(i1));
                fc localfc;
                if (!((fz)localObject3).b())
                {
                  localObject1 = (ia)this.M.a.get(localObject3);
                  if ((localObject1 == null) || ((((ia)localObject1).a & 0x4) == 0))
                  {
                    int i3 = ez.buildAdapterChangeFlagsForAnimations((fz)localObject3);
                    bool = ((fz)localObject3).b(8192);
                    i2 = i3;
                    if (!bool) {
                      i2 = i3 | 0x1000;
                    }
                    localfc = this.q.recordPreLayoutInformation(this.G, (fz)localObject3, i2, ((fz)localObject3).o());
                    if (!bool) {
                      break label706;
                    }
                    a((fz)localObject3, localfc);
                  }
                }
                for (;;)
                {
                  i1 += 1;
                  break;
                  label706:
                  hz localhz = this.M;
                  localObject2 = (ia)localhz.a.get(localObject3);
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    localObject1 = ia.a();
                    localhz.a.put(localObject3, localObject1);
                  }
                  ((ia)localObject1).a |= 0x2;
                  ((ia)localObject1).c = localfc;
                }
              }
              E();
            }
            localObject1 = b(this.k.c(i1));
            if (((fz)localObject1).b()) {}
            for (;;)
            {
              i1 += 1;
              break;
              if (((fz)localObject1).i == -1) {
                ((fz)localObject1).i = ((fz)localObject1).l;
              }
            }
            bool = false;
            continue;
            bool = false;
          }
          i1 = ((fz)localObject1).d();
          break label148;
          i1 = -1;
          break label148;
          l1 = -1L;
          break;
          A();
        }
        localObject1 = null;
        continue;
        localObject1 = null;
      }
      localObject1 = null;
      continue;
      localObject1 = null;
      continue;
      localObject1 = null;
    }
  }
  
  private final void D()
  {
    aD_();
    k();
    this.G.a(6);
    this.h.e();
    this.G.g = this.g.c();
    fw localfw = this.G;
    localfw.a = 0;
    localfw.e = false;
    this.u.a(this.B, localfw);
    localfw = this.G;
    localfw.l = false;
    this.as = null;
    boolean bool;
    if (localfw.k) {
      if (this.q != null) {
        bool = true;
      }
    }
    for (;;)
    {
      localfw.k = bool;
      localfw.h = 4;
      b(true);
      a(false);
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private final void E()
  {
    int i2 = 0;
    int i3 = this.k.b();
    int i1 = 0;
    Object localObject;
    if (i1 >= i3)
    {
      localObject = this.B;
      i3 = ((fp)localObject).b.size();
      i1 = 0;
      while (i1 < i3)
      {
        ((fz)((fp)localObject).b.get(i1)).a();
        i1 += 1;
      }
      i3 = ((fp)localObject).a.size();
      i1 = 0;
      while (i1 < i3)
      {
        ((fz)((fp)localObject).a.get(i1)).a();
        i1 += 1;
      }
      ArrayList localArrayList = ((fp)localObject).c;
      if (localArrayList != null)
      {
        i3 = localArrayList.size();
        i1 = i2;
        while (i1 < i3)
        {
          ((fz)((fp)localObject).c.get(i1)).a();
          i1 += 1;
        }
      }
    }
    else
    {
      localObject = b(this.k.c(i1));
      if (((fz)localObject).b()) {}
      for (;;)
      {
        i1 += 1;
        break;
        ((fz)localObject).a();
      }
    }
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.az) {
      if (i1 != 0) {
        break label75;
      }
    }
    label75:
    for (i1 = 1;; i1 = 0)
    {
      this.az = paramMotionEvent.getPointerId(i1);
      int i2 = (int)(paramMotionEvent.getX(i1) + 0.5F);
      this.ai = i2;
      this.ad = i2;
      i1 = (int)(paramMotionEvent.getY(i1) + 0.5F);
      this.aj = i1;
      this.ae = i1;
      return;
    }
  }
  
  public static void a(View paramView, Rect paramRect)
  {
    b(paramView, paramRect);
  }
  
  private final void a(View paramView1, View paramView2)
  {
    boolean bool1 = false;
    if (paramView2 != null) {}
    for (Object localObject = paramView2;; localObject = paramView1)
    {
      this.H.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
      localObject = ((View)localObject).getLayoutParams();
      Rect localRect;
      if ((localObject instanceof fj))
      {
        localObject = (fj)localObject;
        if (!((fj)localObject).b)
        {
          localObject = ((fj)localObject).a;
          localRect = this.H;
          localRect.left -= ((Rect)localObject).left;
          localRect = this.H;
          localRect.right += ((Rect)localObject).right;
          localRect = this.H;
          localRect.top -= ((Rect)localObject).top;
          localRect = this.H;
          int i1 = localRect.bottom;
          localRect.bottom = (((Rect)localObject).bottom + i1);
        }
      }
      if (paramView2 == null) {}
      for (;;)
      {
        localObject = this.u;
        localRect = this.H;
        boolean bool2 = this.m;
        if (paramView2 == null) {
          bool1 = true;
        }
        ((ff)localObject).a(this, paramView1, localRect, bool2 ^ true, bool1);
        return;
        offsetDescendantRectToMyCoords(paramView2, this.H);
        offsetRectIntoDescendantCoords(paramView1, this.H);
      }
    }
  }
  
  private final void a(int[] paramArrayOfInt)
  {
    int i6 = this.k.a();
    if (i6 != 0)
    {
      int i1 = Integer.MAX_VALUE;
      int i4 = Integer.MIN_VALUE;
      int i3 = 0;
      if (i3 < i6)
      {
        fz localfz = b(this.k.b(i3));
        int i2 = i1;
        int i5 = i4;
        if (!localfz.b())
        {
          i5 = localfz.c();
          i2 = i1;
          if (i5 < i1) {
            i2 = i5;
          }
          if (i5 > i4) {
            break label105;
          }
          i5 = i4;
        }
        label105:
        for (;;)
        {
          i3 += 1;
          i1 = i2;
          i4 = i5;
          break;
        }
      }
      paramArrayOfInt[0] = i1;
      paramArrayOfInt[1] = i4;
      return;
    }
    paramArrayOfInt[0] = -1;
    paramArrayOfInt[1] = -1;
  }
  
  private final boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    d();
    int[] arrayOfInt;
    int i2;
    int i3;
    int i1;
    int i4;
    if (this.g != null)
    {
      a(paramInt1, paramInt2, this.F);
      arrayOfInt = this.F;
      i2 = arrayOfInt[0];
      i3 = arrayOfInt[1];
      i1 = paramInt1 - i2;
      i4 = paramInt2 - i3;
    }
    for (;;)
    {
      if (!this.r.isEmpty()) {
        invalidate();
      }
      if (a(i2, i3, i1, i4, this.ay, 0))
      {
        paramInt2 = this.ai;
        arrayOfInt = this.ay;
        paramInt1 = arrayOfInt[0];
        this.ai = (paramInt2 - paramInt1);
        paramInt2 = this.aj;
        i1 = arrayOfInt[1];
        this.aj = (paramInt2 - i1);
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(paramInt1, i1);
        }
        paramMotionEvent = this.ao;
        paramInt1 = paramMotionEvent[0];
        arrayOfInt = this.ay;
        paramMotionEvent[0] = (paramInt1 + arrayOfInt[0]);
        paramInt1 = paramMotionEvent[1];
        arrayOfInt[1] += paramInt1;
      }
      while (getOverScrollMode() == 2)
      {
        if (i2 != 0) {}
        for (;;)
        {
          f(i2, i3);
          do
          {
            if (!awakenScrollBars()) {
              invalidate();
            }
            return (i2 != 0) || (i3 != 0);
          } while (i3 == 0);
        }
      }
      float f1;
      float f2;
      float f3;
      float f4;
      if ((paramMotionEvent != null) && ((paramMotionEvent.getSource() & 0x2002) != 8194))
      {
        f1 = paramMotionEvent.getX();
        f2 = i1;
        f3 = paramMotionEvent.getY();
        f4 = i4;
        if (f2 >= 0.0F) {
          break label420;
        }
        g();
        aa.a(this.x, -f2 / getWidth(), 1.0F - f3 / getHeight());
        i1 = 1;
      }
      for (;;)
      {
        if (f4 < 0.0F)
        {
          i();
          aa.a(this.J, -f4 / getHeight(), f1 / getWidth());
        }
        for (;;)
        {
          label346:
          ac.e(this);
          do
          {
            c(paramInt1, paramInt2);
            break;
            if (f4 > 0.0F)
            {
              j();
              aa.a(this.j, f4 / getHeight(), 1.0F - f1 / getWidth());
              break label346;
            }
            if ((i1 != 0) || (f2 != 0.0F)) {
              break label346;
            }
          } while (f4 == 0.0F);
        }
        label420:
        if (f2 > 0.0F)
        {
          h();
          aa.a(this.D, f2 / getWidth(), f3 / getHeight());
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
      }
      i1 = 0;
      i4 = 0;
      i2 = 0;
      i3 = 0;
    }
  }
  
  static fz b(View paramView)
  {
    if (paramView != null) {
      return ((fj)paramView.getLayoutParams()).d;
    }
    return null;
  }
  
  static void b(fz paramfz)
  {
    Object localObject = paramfz.h;
    if (localObject != null)
    {
      localObject = (View)((WeakReference)localObject).get();
      while (localObject != null)
      {
        if (localObject == paramfz.c) {
          return;
        }
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof View)) {
          localObject = (View)localObject;
        } else {
          localObject = null;
        }
      }
      paramfz.h = null;
    }
  }
  
  public static void b(View paramView, Rect paramRect)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    Rect localRect = localfj.a;
    int i1 = paramView.getLeft();
    int i2 = localRect.left;
    int i3 = localfj.leftMargin;
    int i4 = paramView.getTop();
    int i5 = localRect.top;
    int i6 = localfj.topMargin;
    int i7 = paramView.getRight();
    int i8 = localRect.right;
    int i9 = localfj.rightMargin;
    int i10 = paramView.getBottom();
    int i11 = localRect.bottom;
    paramRect.set(i1 - i2 - i3, i4 - i5 - i6, i7 + i8 + i9, localfj.bottomMargin + (i11 + i10));
  }
  
  public static int c(View paramView)
  {
    paramView = b(paramView);
    if (paramView != null) {
      return paramView.d();
    }
    return -1;
  }
  
  public static int d(View paramView)
  {
    paramView = b(paramView);
    if (paramView != null) {
      return paramView.c();
    }
    return -1;
  }
  
  private final long d(fz paramfz)
  {
    if (!this.g.a) {
      return paramfz.l;
    }
    return paramfz.f;
  }
  
  static RecyclerView g(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      if ((paramView instanceof RecyclerView)) {
        return (RecyclerView)paramView;
      }
      paramView = (ViewGroup)paramView;
      int i2 = paramView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        RecyclerView localRecyclerView = g(paramView.getChildAt(i1));
        if (localRecyclerView == null) {
          i1 += 1;
        } else {
          return localRecyclerView;
        }
      }
      return null;
    }
    return null;
  }
  
  private final boolean g(int paramInt1, int paramInt2)
  {
    return r().a(paramInt1, paramInt2);
  }
  
  private final View i(View paramView)
  {
    for (ViewParent localViewParent = paramView.getParent();; localViewParent = paramView.getParent())
    {
      if (localViewParent == null) {}
      while ((localViewParent == this) || (!(localViewParent instanceof View)))
      {
        if (localViewParent == this) {
          return paramView;
        }
        return null;
      }
      paramView = (View)localViewParent;
    }
  }
  
  static long q()
  {
    if (!b) {
      return 0L;
    }
    return System.nanoTime();
  }
  
  private final void s()
  {
    this.L.b();
    Object localObject = this.u;
    if (localObject != null)
    {
      localObject = ((ff)localObject).n;
      if (localObject != null) {
        ((ft)localObject).d();
      }
    }
  }
  
  private final void t()
  {
    this.j = null;
    this.J = null;
    this.D = null;
    this.x = null;
  }
  
  private final void u()
  {
    boolean bool2 = false;
    Object localObject = this.aE;
    if (localObject != null) {
      ((VelocityTracker)localObject).clear();
    }
    n_(0);
    localObject = this.x;
    if (localObject != null)
    {
      ((EdgeEffect)localObject).onRelease();
      bool2 = this.x.isFinished();
    }
    localObject = this.J;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      ((EdgeEffect)localObject).onRelease();
      bool1 = bool2 | this.J.isFinished();
    }
    localObject = this.D;
    bool2 = bool1;
    if (localObject != null)
    {
      ((EdgeEffect)localObject).onRelease();
      bool2 = bool1 | this.D.isFinished();
    }
    localObject = this.j;
    bool1 = bool2;
    if (localObject != null)
    {
      ((EdgeEffect)localObject).onRelease();
      bool1 = bool2 | this.j.isFinished();
    }
    if (bool1) {
      ac.e(this);
    }
  }
  
  private final void v()
  {
    u();
    b(0);
  }
  
  private final boolean w()
  {
    return this.ak > 0;
  }
  
  private final boolean x()
  {
    return (this.q != null) && (this.u.u());
  }
  
  private final void y()
  {
    boolean bool2 = false;
    if (this.l)
    {
      this.h.a();
      if (this.U) {
        this.u.z();
      }
    }
    if (x()) {
      this.h.b();
    }
    for (;;)
    {
      int i1;
      if (!this.s) {
        if (!this.t) {
          i1 = 0;
        }
      }
      for (;;)
      {
        fw localfw = this.G;
        boolean bool1;
        if (this.m) {
          if (this.q != null)
          {
            bool1 = this.l;
            if (bool1) {
              if (bool1) {
                if (this.g.a) {
                  bool1 = true;
                }
              }
            }
          }
        }
        for (;;)
        {
          localfw.k = bool1;
          if (!localfw.k) {
            bool1 = bool2;
          }
          for (;;)
          {
            localfw.j = bool1;
            return;
            bool1 = bool2;
            if (i1 != 0)
            {
              bool1 = bool2;
              if (!this.l)
              {
                bool1 = bool2;
                if (x()) {
                  bool1 = true;
                }
              }
            }
          }
          bool1 = false;
          continue;
          bool1 = true;
          continue;
          if (i1 != 0) {
            break;
          }
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
        }
        i1 = 1;
        continue;
        i1 = 1;
      }
      this.h.e();
    }
  }
  
  private final void z()
  {
    if (this.g == null)
    {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (this.u == null)
    {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    Object localObject1 = this.G;
    ((fw)localObject1).f = false;
    if (((fw)localObject1).h == 1)
    {
      C();
      this.u.b(this);
      D();
    }
    label516:
    label623:
    label626:
    label629:
    label700:
    label819:
    Object localObject3;
    for (;;)
    {
      this.G.a(4);
      aD_();
      k();
      localObject1 = this.G;
      ((fw)localObject1).h = 1;
      int i1;
      long l1;
      boolean bool1;
      int i3;
      if (((fw)localObject1).k)
      {
        i1 = this.k.a() - 1;
        if (i1 >= 0) {
          break label1051;
        }
        localObject1 = this.M;
        localObject2 = this.aF;
        i1 = ((hz)localObject1).a.size() - 1;
        if (i1 >= 0) {}
      }
      else
      {
        this.u.a(this.B);
        localObject1 = this.G;
        ((fw)localObject1).i = ((fw)localObject1).g;
        this.l = false;
        this.U = false;
        ((fw)localObject1).k = false;
        ((fw)localObject1).j = false;
        localObject1 = this.B.c;
        if (localObject1 != null) {
          ((ArrayList)localObject1).clear();
        }
        localObject1 = this.u;
        if (((ff)localObject1).l)
        {
          ((ff)localObject1).k = 0;
          ((ff)localObject1).l = false;
          this.B.b();
        }
        this.u.a(this.G);
        b(true);
        a(false);
        this.M.a();
        localObject1 = this.an;
        i1 = localObject1[0];
        i2 = localObject1[1];
        a((int[])localObject1);
        localObject1 = this.an;
        if ((localObject1[0] != i1) || (localObject1[1] != i2)) {
          f(0, 0);
        }
        if ((this.at) && (this.g != null) && (hasFocus()) && (getDescendantFocusability() != 393216) && ((getDescendantFocusability() != 131072) || (!isFocused()))) {
          if (!isFocused())
          {
            localObject1 = getFocusedChild();
            if (!this.k.d((View)localObject1)) {}
          }
          else
          {
            l1 = this.G.b;
            if (l1 == -1L) {
              break label819;
            }
            localObject1 = this.g;
            bool1 = ((eu)localObject1).a;
            if (bool1) {
              break label700;
            }
            localObject1 = null;
          }
        }
        for (;;)
        {
          if ((localObject1 == null) || (this.k.d(((fz)localObject1).c)) || (!((fz)localObject1).c.hasFocusable())) {
            if (this.k.a() > 0)
            {
              localObject1 = this.G;
              i2 = ((fw)localObject1).c;
              i1 = i2;
              if (i2 == -1) {
                i1 = 0;
              }
              i3 = ((fw)localObject1).a();
              i2 = i1;
              if (i2 >= i3)
              {
                i1 = Math.min(i3, i1) - 1;
                for (;;)
                {
                  if (i1 >= 0)
                  {
                    localObject1 = g(i1);
                    if (localObject1 != null)
                    {
                      if (!((fz)localObject1).c.hasFocusable())
                      {
                        i1 -= 1;
                        continue;
                      }
                      localObject1 = ((fz)localObject1).c;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              i1 = this.G.d;
              if (i1 == -1L) {
                break label629;
              }
              localObject2 = ((View)localObject1).findViewById(i1);
              if (localObject2 == null) {
                break label626;
              }
              if (!((View)localObject2).isFocusable()) {
                break label623;
              }
              localObject1 = localObject2;
            }
            for (;;)
            {
              ((View)localObject1).requestFocus();
              A();
              return;
              continue;
            }
            localObject1 = null;
            continue;
            localObject1 = null;
            continue;
            localObject1 = g(i2);
            if (localObject1 == null) {
              break label516;
            }
            if (!((fz)localObject1).c.hasFocusable())
            {
              i2 += 1;
              break;
            }
            localObject1 = ((fz)localObject1).c;
            continue;
            localObject1 = null;
            continue;
            localObject1 = ((fz)localObject1).c;
          }
          if (localObject1 == null)
          {
            localObject1 = null;
          }
          else if (bool1)
          {
            i2 = this.k.b();
            localObject1 = null;
            i1 = 0;
            if (i1 < i2)
            {
              localObject2 = b(this.k.c(i1));
              if (localObject2 != null) {
                if (!((fz)localObject2).l()) {
                  if (((fz)localObject2).f == l1)
                  {
                    localObject1 = localObject2;
                    if (!this.k.d(((fz)localObject2).c)) {
                      continue;
                    }
                    localObject1 = localObject2;
                  }
                }
              }
              for (;;)
              {
                i1 += 1;
                break;
                continue;
              }
            }
          }
          else
          {
            localObject1 = null;
            continue;
            localObject1 = null;
          }
        }
      }
      localObject3 = (fz)((hz)localObject1).a.b(i1);
      Object localObject4 = (ia)((hz)localObject1).a.d(i1);
      int i2 = ((ia)localObject4).a;
      if ((i2 & 0x3) != 3) {
        if ((i2 & 0x1) == 0) {
          if ((i2 & 0xE) == 14) {
            ((ib)localObject2).b((fz)localObject3, ((ia)localObject4).c, ((ia)localObject4).b);
          }
        }
      }
      for (;;)
      {
        ia.a((ia)localObject4);
        i1 -= 1;
        break;
        if ((i2 & 0xC) == 12)
        {
          ((ib)localObject2).c((fz)localObject3, ((ia)localObject4).c, ((ia)localObject4).b);
        }
        else if ((i2 & 0x4) != 0)
        {
          ((ib)localObject2).a((fz)localObject3, ((ia)localObject4).c, null);
        }
        else if ((i2 & 0x8) != 0)
        {
          ((ib)localObject2).b((fz)localObject3, ((ia)localObject4).c, ((ia)localObject4).b);
          continue;
          fc localfc = ((ia)localObject4).c;
          if (localfc == null)
          {
            ((ib)localObject2).a((fz)localObject3);
          }
          else
          {
            ((ib)localObject2).a((fz)localObject3, localfc, ((ia)localObject4).b);
            continue;
            ((ib)localObject2).a((fz)localObject3);
          }
        }
      }
      label1051:
      localObject1 = b(this.k.b(i1));
      boolean bool2;
      if (!((fz)localObject1).b())
      {
        l1 = d((fz)localObject1);
        localObject4 = this.q.recordPostLayoutInformation(this.G, (fz)localObject1);
        localObject2 = (fz)this.M.b.a(l1, null);
        if ((localObject2 == null) || (((fz)localObject2).b())) {
          break label1527;
        }
        bool1 = this.M.a((fz)localObject2);
        bool2 = this.M.a((fz)localObject1);
        if (bool1) {
          break label1506;
        }
        label1153:
        localObject3 = this.M.a((fz)localObject2, 4);
        this.M.b((fz)localObject1, (fc)localObject4);
        localObject4 = this.M.a((fz)localObject1, 8);
        if (localObject3 != null) {
          break label1405;
        }
        i3 = this.k.a();
        i2 = 0;
        if (i2 < i3) {
          break label1281;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        ((StringBuilder)localObject3).append(localObject2);
        ((StringBuilder)localObject3).append(" cannot be found but it is necessary for ");
        ((StringBuilder)localObject3).append(localObject1);
        ((StringBuilder)localObject3).append(a());
        Log.e("RecyclerView", ((StringBuilder)localObject3).toString());
      }
      for (;;)
      {
        i1 -= 1;
        break;
        label1281:
        localObject3 = b(this.k.b(i2));
        if (localObject3 == localObject1) {}
        while (d((fz)localObject3) != l1)
        {
          i2 += 1;
          break;
        }
        localObject2 = this.g;
        if ((localObject2 != null) && (((eu)localObject2).a)) {
          break label1623;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        ((StringBuilder)localObject2).append(localObject3);
        ((StringBuilder)localObject2).append(" \n View Holder 2:");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(a());
        throw new IllegalStateException(((StringBuilder)localObject2).toString());
        label1405:
        ((fz)localObject2).a(false);
        if (bool1) {
          a((fz)localObject2);
        }
        if (localObject2 == localObject1) {
          label1429:
          if (this.q.animateChange((fz)localObject2, (fz)localObject1, (fc)localObject3, (fc)localObject4)) {
            m();
          }
        } else {
          if (bool2) {
            break label1497;
          }
        }
        for (;;)
        {
          ((fz)localObject2).o = ((fz)localObject1);
          a((fz)localObject2);
          this.B.b((fz)localObject2);
          ((fz)localObject1).a(false);
          ((fz)localObject1).p = ((fz)localObject2);
          break label1429;
          break;
          label1497:
          a((fz)localObject1);
        }
        label1506:
        if (localObject2 != localObject1) {
          break label1153;
        }
        this.M.b((fz)localObject1, (fc)localObject4);
        continue;
        label1527:
        this.M.b((fz)localObject1, (fc)localObject4);
      }
      localObject1 = this.h;
      if (((!((x)localObject1).c.isEmpty()) && (!((x)localObject1).b.isEmpty())) || (this.u.p != getWidth()) || (this.u.g != getHeight()))
      {
        this.u.b(this);
        D();
      }
      else
      {
        this.u.b(this);
      }
    }
    label1623:
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
    ((StringBuilder)localObject2).append(localObject3);
    ((StringBuilder)localObject2).append(" \n View Holder 2:");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(a());
    throw new IllegalStateException(((StringBuilder)localObject2).toString());
  }
  
  public final fz a(int paramInt, boolean paramBoolean)
  {
    int i2 = this.k.b();
    int i1 = 0;
    Object localObject1 = null;
    if (i1 < i2)
    {
      fz localfz = b(this.k.c(i1));
      Object localObject2 = localObject1;
      if (localfz != null)
      {
        if (!localfz.l()) {
          break label65;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        i1 += 1;
        localObject1 = localObject2;
        break;
        label65:
        if (!paramBoolean)
        {
          localObject2 = localObject1;
          if (localfz.c() != paramInt) {}
        }
        else
        {
          while (localfz.l == paramInt)
          {
            localObject1 = localfz;
            if (!this.k.d(localfz.c)) {
              break label124;
            }
            localObject2 = localfz;
            break;
          }
          localObject2 = localObject1;
        }
      }
    }
    label124:
    return (fz)localObject1;
  }
  
  public final fz a(View paramView)
  {
    Object localObject = paramView.getParent();
    if ((localObject != null) && (localObject != this))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("View ");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(" is not a direct child of ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return b(paramView);
  }
  
  final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", adapter:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", layout:");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", context:");
    localStringBuilder.append(getContext());
    return localStringBuilder.toString();
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = paramInt1 + paramInt2;
    int i3 = this.k.b();
    int i1 = 0;
    if (i1 >= i3)
    {
      localObject = this.B;
      i1 = ((fp)localObject).b.size() - 1;
      if (i1 >= 0)
      {
        fz localfz = (fz)((fp)localObject).b.get(i1);
        if (localfz == null) {}
        for (;;)
        {
          i1 -= 1;
          break;
          i3 = localfz.l;
          if (i3 >= i2)
          {
            localfz.a(-paramInt2, paramBoolean);
          }
          else if (i3 >= paramInt1)
          {
            localfz.c(8);
            ((fp)localObject).a(i1);
          }
        }
      }
      requestLayout();
      return;
    }
    Object localObject = b(this.k.c(i1));
    if (localObject == null) {}
    for (;;)
    {
      i1 += 1;
      break;
      if (!((fz)localObject).b())
      {
        int i4 = ((fz)localObject).l;
        if (i4 >= i2)
        {
          ((fz)localObject).a(-paramInt2, paramBoolean);
          this.G.l = true;
        }
        else if (i4 >= paramInt1)
        {
          ((fz)localObject).c(8);
          ((fz)localObject).a(-paramInt2, paramBoolean);
          ((fz)localObject).l = (paramInt1 - 1);
          this.G.l = true;
        }
      }
    }
  }
  
  final void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    aD_();
    k();
    c.a("RV Scroll");
    B();
    if (paramInt1 != 0) {}
    for (paramInt1 = this.u.a(paramInt1, this.B, this.G);; paramInt1 = 0)
    {
      if (paramInt2 != 0) {}
      for (paramInt2 = this.u.b(paramInt2, this.B, this.G);; paramInt2 = 0)
      {
        c.a();
        int i2 = this.k.a();
        int i1 = 0;
        if (i1 < i2)
        {
          View localView = this.k.b(i1);
          Object localObject = a(localView);
          if (localObject == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            localObject = ((fz)localObject).p;
            if (localObject != null)
            {
              localObject = ((fz)localObject).c;
              int i3 = localView.getLeft();
              int i4 = localView.getTop();
              if ((i3 != ((View)localObject).getLeft()) || (i4 != ((View)localObject).getTop())) {
                ((View)localObject).layout(i3, i4, ((View)localObject).getWidth() + i3, ((View)localObject).getHeight() + i4);
              }
            }
          }
        }
        b(true);
        a(false);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramInt1;
          paramArrayOfInt[1] = paramInt2;
        }
        return;
      }
    }
  }
  
  public final void a(fe paramfe)
  {
    ff localff = this.u;
    if (localff != null) {
      localff.a("Cannot add item decoration during a scroll  or layout");
    }
    if (this.r.isEmpty()) {
      setWillNotDraw(false);
    }
    this.r.add(paramfe);
    n();
    requestLayout();
  }
  
  public void a(fm paramfm)
  {
    if (this.ax == null) {
      this.ax = new ArrayList();
    }
    this.ax.add(paramfm);
  }
  
  final void a(fz paramfz)
  {
    View localView = paramfz.c;
    ViewParent localViewParent = localView.getParent();
    this.B.b(a(localView));
    if (paramfz.m())
    {
      this.k.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (localViewParent == this)
    {
      paramfz = this.k;
      int i1 = paramfz.b.a(localView);
      if (i1 < 0)
      {
        paramfz = new StringBuilder();
        paramfz.append("view is not a child, cannot hide ");
        paramfz.append(localView);
        throw new IllegalArgumentException(paramfz.toString());
      }
      paramfz.a.a(i1);
      paramfz.a(localView);
      return;
    }
    this.k.a(localView, -1, true);
  }
  
  final void a(fz paramfz, fc paramfc)
  {
    paramfz.a(0, 8192);
    if ((this.G.n) && (paramfz.r()) && (!paramfz.l()) && (!paramfz.b()))
    {
      long l1 = d(paramfz);
      this.M.a(l1, paramfz);
    }
    this.M.a(paramfz, paramfc);
  }
  
  final void a(String paramString)
  {
    if (!w())
    {
      if (this.V > 0)
      {
        paramString = new StringBuilder();
        paramString.append(a());
        Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(paramString.toString()));
      }
      return;
    }
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
      paramString.append(a());
      throw new IllegalStateException(paramString.toString());
    }
    throw new IllegalStateException(paramString);
  }
  
  final void a(boolean paramBoolean)
  {
    if (this.af <= 0) {
      this.af = 1;
    }
    if (paramBoolean) {}
    for (;;)
    {
      if (this.af == 1) {
        if (paramBoolean) {
          break label51;
        }
      }
      for (;;)
      {
        if (!this.v) {
          this.w = false;
        }
        this.af -= 1;
        return;
        label51:
        if ((this.w) && (!this.v) && (this.u != null) && (this.g != null)) {
          z();
        }
      }
      if (!this.v) {
        this.w = false;
      }
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return r().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return r().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  final boolean a(fz paramfz, int paramInt)
  {
    if (w())
    {
      paramfz.k = paramInt;
      this.ar.add(paramfz);
      return false;
    }
    ac.b(paramfz.c, paramInt);
    return true;
  }
  
  final void aD_()
  {
    this.af += 1;
    if ((this.af == 1) && (!this.v)) {
      this.w = false;
    }
  }
  
  final void b()
  {
    Object localObject = this.q;
    if (localObject != null) {
      ((ez)localObject).endAnimations();
    }
    localObject = this.u;
    if (localObject != null)
    {
      ((ff)localObject).b(this.B);
      this.u.a(this.B);
    }
    this.B.a();
  }
  
  final void b(int paramInt)
  {
    if (paramInt != this.aA)
    {
      this.aA = paramInt;
      if (paramInt != 2) {
        s();
      }
      h(paramInt);
      Object localObject = this.aw;
      if (localObject != null) {
        ((fm)localObject).a(this, paramInt);
      }
      localObject = this.ax;
      if (localObject != null)
      {
        int i1 = ((List)localObject).size() - 1;
        while (i1 >= 0)
        {
          ((fm)this.ax.get(i1)).a(this, paramInt);
          i1 -= 1;
        }
      }
    }
  }
  
  public final void b(fe paramfe)
  {
    ff localff = this.u;
    if (localff != null) {
      localff.a("Cannot remove item decoration during a scroll  or layout");
    }
    this.r.remove(paramfe);
    if (this.r.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label59;
      }
    }
    label59:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      n();
      requestLayout();
      return;
    }
  }
  
  public void b(fm paramfm)
  {
    List localList = this.ax;
    if (localList != null) {
      localList.remove(paramfm);
    }
  }
  
  final void b(boolean paramBoolean)
  {
    this.ak -= 1;
    if (this.ak <= 0)
    {
      this.ak = 0;
      if (paramBoolean)
      {
        int i1 = this.W;
        this.W = 0;
        Object localObject;
        if ((i1 != 0) && (l()))
        {
          localObject = AccessibilityEvent.obtain();
          ((AccessibilityEvent)localObject).setEventType(2048);
          if (Build.VERSION.SDK_INT >= 19) {
            ((AccessibilityEvent)localObject).setContentChangeTypes(i1);
          }
          sendAccessibilityEventUnchecked((AccessibilityEvent)localObject);
        }
        i1 = this.ar.size() - 1;
        if (i1 >= 0)
        {
          localObject = (fz)this.ar.get(i1);
          if (((fz)localObject).c.getParent() != this) {}
          for (;;)
          {
            i1 -= 1;
            break;
            if (!((fz)localObject).b())
            {
              int i2 = ((fz)localObject).k;
              if (i2 != -1)
              {
                ac.b(((fz)localObject).c, i2);
                ((fz)localObject).k = -1;
              }
            }
          }
        }
        this.ar.clear();
      }
    }
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  final int c(fz paramfz)
  {
    if ((!paramfz.b(524)) && ((paramfz.d & 0x1) != 0))
    {
      x localx = this.h;
      int i2 = paramfz.l;
      int i5 = localx.b.size();
      int i4 = 0;
      int i1 = i2;
      if (i4 < i5)
      {
        paramfz = (z)localx.b.get(i4);
        switch (paramfz.a)
        {
        default: 
          i1 = i2;
        }
        for (;;)
        {
          i4 += 1;
          i2 = i1;
          break;
          i1 = i2;
          if (paramfz.d <= i2)
          {
            i1 = i2 + paramfz.b;
            continue;
            i1 = paramfz.d;
            if (i1 == i2)
            {
              i1 = paramfz.b;
            }
            else
            {
              int i3 = i2;
              if (i1 < i2) {
                i3 = i2 - 1;
              }
              i1 = i3;
              if (paramfz.b <= i3)
              {
                i1 = i3 + 1;
                continue;
                i3 = paramfz.d;
                i1 = i2;
                if (i3 <= i2)
                {
                  i1 = paramfz.b;
                  if (i3 + i1 > i2) {
                    break label222;
                  }
                  i1 = i2 - i1;
                }
              }
            }
          }
        }
        label222:
        i1 = -1;
      }
      return i1;
    }
    return -1;
  }
  
  public void c()
  {
    List localList = this.ax;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public final void c(int paramInt)
  {
    int i1 = getItemDecorationCount();
    StringBuilder localStringBuilder;
    if ((paramInt < 0) || (paramInt >= i1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is an invalid index for size ");
      localStringBuilder.append(i1);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    i1 = getItemDecorationCount();
    if ((paramInt < 0) || (paramInt >= i1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is an invalid index for size ");
      localStringBuilder.append(i1);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    b((fe)this.r.get(paramInt));
  }
  
  final void c(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    EdgeEffect localEdgeEffect = this.x;
    boolean bool1 = bool2;
    if (localEdgeEffect != null)
    {
      if (!localEdgeEffect.isFinished()) {
        break label197;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      localEdgeEffect = this.D;
      bool2 = bool1;
      if (localEdgeEffect != null)
      {
        if (!localEdgeEffect.isFinished()) {
          break label169;
        }
        bool2 = bool1;
      }
      for (;;)
      {
        localEdgeEffect = this.J;
        bool1 = bool2;
        if (localEdgeEffect != null)
        {
          if (!localEdgeEffect.isFinished()) {
            break label141;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          localEdgeEffect = this.j;
          bool2 = bool1;
          if (localEdgeEffect != null)
          {
            if (!localEdgeEffect.isFinished()) {
              break label113;
            }
            bool2 = bool1;
          }
          for (;;)
          {
            if (bool2) {
              ac.e(this);
            }
            return;
            label113:
            bool2 = bool1;
            if (paramInt2 < 0)
            {
              this.j.onRelease();
              bool2 = bool1 | this.j.isFinished();
            }
          }
          label141:
          bool1 = bool2;
          if (paramInt2 > 0)
          {
            this.J.onRelease();
            bool1 = bool2 | this.J.isFinished();
          }
        }
        label169:
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.D.onRelease();
          bool2 = bool1 | this.D.isFinished();
        }
      }
      label197:
      bool1 = bool2;
      if (paramInt1 > 0)
      {
        this.x.onRelease();
        bool1 = this.x.isFinished();
      }
    }
  }
  
  final void c(boolean paramBoolean)
  {
    this.U |= paramBoolean;
    this.l = true;
    int i2 = this.k.b();
    int i1 = 0;
    if (i1 >= i2)
    {
      n();
      localObject1 = this.B;
      i2 = ((fp)localObject1).b.size();
      i1 = 0;
      if (i1 < i2)
      {
        localObject2 = (fz)((fp)localObject1).b.get(i1);
        if (localObject2 == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          ((fz)localObject2).c(6);
          ((fz)localObject2).a(null);
        }
      }
      Object localObject2 = ((fp)localObject1).h.g;
      if (localObject2 == null) {}
      for (;;)
      {
        ((fp)localObject1).c();
        do
        {
          return;
        } while (((eu)localObject2).a);
      }
    }
    Object localObject1 = b(this.k.c(i1));
    if (localObject1 == null) {}
    for (;;)
    {
      i1 += 1;
      break;
      if (!((fz)localObject1).b()) {
        ((fz)localObject1).c(6);
      }
    }
  }
  
  public void c_(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    Object localObject = this.u;
    if (localObject == null) {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    while (this.v) {
      return;
    }
    if (!((ff)localObject).n()) {
      paramInt1 = 0;
    }
    if (!this.u.o()) {
      paramInt2 = i1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {}
      while (paramInt2 != 0)
      {
        localObject = this.L;
        ((fy)localObject).a(paramInt1, paramInt2, ((fy)localObject).a(paramInt1, paramInt2), N);
        return;
      }
      return;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof fj)) && (this.u.a((fj)paramLayoutParams));
  }
  
  public int computeHorizontalScrollExtent()
  {
    int i2 = 0;
    ff localff = this.u;
    int i1 = i2;
    if (localff != null)
    {
      i1 = i2;
      if (localff.n()) {
        i1 = this.u.d(this.G);
      }
    }
    return i1;
  }
  
  public int computeHorizontalScrollOffset()
  {
    int i2 = 0;
    ff localff = this.u;
    int i1 = i2;
    if (localff != null)
    {
      i1 = i2;
      if (localff.n()) {
        i1 = this.u.b(this.G);
      }
    }
    return i1;
  }
  
  public int computeHorizontalScrollRange()
  {
    int i2 = 0;
    ff localff = this.u;
    int i1 = i2;
    if (localff != null)
    {
      i1 = i2;
      if (localff.n()) {
        i1 = this.u.f(this.G);
      }
    }
    return i1;
  }
  
  public int computeVerticalScrollExtent()
  {
    int i2 = 0;
    ff localff = this.u;
    int i1 = i2;
    if (localff != null)
    {
      i1 = i2;
      if (localff.o()) {
        i1 = this.u.e(this.G);
      }
    }
    return i1;
  }
  
  public int computeVerticalScrollOffset()
  {
    int i2 = 0;
    ff localff = this.u;
    int i1 = i2;
    if (localff != null)
    {
      i1 = i2;
      if (localff.o()) {
        i1 = this.u.c(this.G);
      }
    }
    return i1;
  }
  
  public int computeVerticalScrollRange()
  {
    int i2 = 0;
    ff localff = this.u;
    int i1 = i2;
    if (localff != null)
    {
      i1 = i2;
      if (localff.o()) {
        i1 = this.u.g(this.G);
      }
    }
    return i1;
  }
  
  final void d()
  {
    if ((!this.m) || (this.l))
    {
      c.a("RV FullInvalidate");
      z();
      c.a();
    }
    do
    {
      do
      {
        return;
      } while (!this.h.d());
      if ((this.h.a(4)) && (!this.h.a(11)))
      {
        c.a("RV PartialInvalidate");
        aD_();
        k();
        this.h.b();
        if (this.w) {}
        for (;;)
        {
          a(true);
          b(true);
          c.a();
          return;
          int i2 = this.k.a();
          int i1 = 0;
          if (i1 < i2)
          {
            fz localfz = b(this.k.b(i1));
            if (localfz == null) {}
            while ((localfz.b()) || (!localfz.r()))
            {
              i1 += 1;
              break;
            }
            z();
          }
          else
          {
            this.h.c();
          }
        }
      }
    } while (!this.h.d());
    c.a("RV FullInvalidate");
    z();
    c.a();
  }
  
  public void d(int paramInt)
  {
    ff localff;
    if (!this.v)
    {
      f();
      localff = this.u;
      if (localff == null) {
        Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      }
    }
    else
    {
      return;
    }
    localff.c(paramInt);
    awakenScrollBars();
  }
  
  final void d(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(ff.a(paramInt1, getPaddingLeft() + getPaddingRight(), ac.r(this)), ff.a(paramInt2, getPaddingTop() + getPaddingBottom(), ac.s(this)));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return r().a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return r().a(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return r().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return r().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i3 = 0;
    super.draw(paramCanvas);
    int i2 = this.r.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((fe)this.r.get(i1)).a(paramCanvas, this, this.G);
      i1 += 1;
    }
    EdgeEffect localEdgeEffect = this.x;
    if (localEdgeEffect != null) {
      if (!localEdgeEffect.isFinished())
      {
        i2 = paramCanvas.save();
        if (this.T)
        {
          i1 = getPaddingBottom();
          paramCanvas.rotate(270.0F);
          paramCanvas.translate(i1 + -getHeight(), 0.0F);
          localEdgeEffect = this.x;
          if (localEdgeEffect != null) {
            if (localEdgeEffect.draw(paramCanvas))
            {
              i1 = 1;
              label128:
              paramCanvas.restoreToCount(i2);
            }
          }
        }
      }
    }
    for (;;)
    {
      localEdgeEffect = this.J;
      int i4;
      if (localEdgeEffect != null) {
        if (!localEdgeEffect.isFinished())
        {
          i4 = paramCanvas.save();
          if (this.T) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          localEdgeEffect = this.J;
          if (localEdgeEffect != null) {
            if (localEdgeEffect.draw(paramCanvas))
            {
              i2 = 1;
              paramCanvas.restoreToCount(i4);
              i1 |= i2;
            }
          }
        }
      }
      for (;;)
      {
        localEdgeEffect = this.D;
        i2 = i1;
        int i5;
        if (localEdgeEffect != null)
        {
          i2 = i1;
          if (!localEdgeEffect.isFinished())
          {
            i4 = paramCanvas.save();
            i5 = getWidth();
            if (!this.T) {
              break label487;
            }
          }
        }
        label458:
        label487:
        for (i2 = getPaddingTop();; i2 = 0)
        {
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-i2, -i5);
          localEdgeEffect = this.D;
          if (localEdgeEffect != null) {
            if (localEdgeEffect.draw(paramCanvas)) {
              i2 = 1;
            }
          }
          for (;;)
          {
            i2 = i1 | i2;
            paramCanvas.restoreToCount(i4);
            localEdgeEffect = this.j;
            i1 = i2;
            if (localEdgeEffect != null)
            {
              i1 = i2;
              if (!localEdgeEffect.isFinished())
              {
                i4 = paramCanvas.save();
                paramCanvas.rotate(180.0F);
                if (!this.T) {
                  break label458;
                }
                paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
              }
            }
            for (;;)
            {
              localEdgeEffect = this.j;
              i1 = i3;
              if (localEdgeEffect != null)
              {
                i1 = i3;
                if (localEdgeEffect.draw(paramCanvas)) {
                  i1 = 1;
                }
              }
              i1 = i2 | i1;
              paramCanvas.restoreToCount(i4);
              if ((i1 == 0) && (this.q != null) && (this.r.size() > 0) && (this.q.isRunning())) {}
              for (;;)
              {
                ac.e(this);
                do
                {
                  return;
                } while (i1 == 0);
              }
              paramCanvas.translate(-getWidth(), -getHeight());
            }
            i2 = 0;
            continue;
            i2 = 0;
          }
        }
        i2 = 0;
        break;
        i2 = 0;
        break;
      }
      i1 = 0;
      break label128;
      i1 = 0;
      break label128;
      i1 = 0;
      break;
      i1 = 0;
      continue;
      i1 = 0;
    }
  }
  
  final void e(int paramInt)
  {
    ff localff = this.u;
    if (localff != null)
    {
      localff.c(paramInt);
      awakenScrollBars();
    }
  }
  
  public void e(int paramInt1, int paramInt2) {}
  
  public void e(View paramView) {}
  
  final Rect f(View paramView)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    if (!localfj.b) {
      return localfj.a;
    }
    if ((!this.G.e) || ((!localfj.d.r()) && (!localfj.d.j())))
    {
      Rect localRect = localfj.a;
      localRect.set(0, 0, 0, 0);
      int i2 = this.r.size();
      int i1 = 0;
      while (i1 < i2)
      {
        this.H.set(0, 0, 0, 0);
        ((fe)this.r.get(i1)).a(this.H, paramView, this, this.G);
        localRect.left += this.H.left;
        localRect.top += this.H.top;
        localRect.right += this.H.right;
        localRect.bottom += this.H.bottom;
        i1 += 1;
      }
      localfj.b = false;
      return localRect;
    }
    return localfj.a;
  }
  
  public final void f()
  {
    b(0);
    s();
  }
  
  public void f(int paramInt)
  {
    ff localff;
    if (!this.v)
    {
      localff = this.u;
      if (localff == null) {
        Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      }
    }
    else
    {
      return;
    }
    localff.a(this, paramInt);
  }
  
  final void f(int paramInt1, int paramInt2)
  {
    this.V += 1;
    int i1 = getScrollX();
    int i2 = getScrollY();
    onScrollChanged(i1, i2, i1, i2);
    e(paramInt1, paramInt2);
    Object localObject = this.aw;
    if (localObject != null) {
      ((fm)localObject).a(this, paramInt1, paramInt2);
    }
    localObject = this.ax;
    if (localObject != null)
    {
      i1 = ((List)localObject).size() - 1;
      while (i1 >= 0)
      {
        ((fm)this.ax.get(i1)).a(this, paramInt1, paramInt2);
        i1 -= 1;
      }
    }
    this.V -= 1;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    int i4 = 0;
    Object localObject = this.u.a(paramView, paramInt);
    if (localObject == null)
    {
      int i1;
      if (this.g != null) {
        if (this.u != null) {
          if (!w()) {
            if (!this.v) {
              i1 = 1;
            }
          }
        }
      }
      for (;;)
      {
        localObject = FocusFinder.getInstance();
        label271:
        label341:
        int i2;
        if (i1 == 0)
        {
          localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
          if (localObject != null) {}
          for (;;)
          {
            if ((localObject != null) && (!((View)localObject).hasFocusable()))
            {
              if (getFocusedChild() == null) {
                return super.focusSearch(paramView, paramInt);
              }
              a((View)localObject, null);
              return paramView;
            }
            if (localObject == null) {}
            while ((localObject == this) || (i((View)localObject) == null)) {
              return super.focusSearch(paramView, paramInt);
            }
            if ((paramView != null) && (i(paramView) != null))
            {
              this.H.set(0, 0, paramView.getWidth(), paramView.getHeight());
              this.aC.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
              offsetDescendantRectToMyCoords(paramView, this.H);
              offsetDescendantRectToMyCoords((View)localObject, this.aC);
              if (ac.h(this.u.m) != 1) {
                break label639;
              }
            }
            label639:
            for (int i3 = -1;; i3 = 1)
            {
              if (this.H.left < this.aC.left) {}
              for (;;)
              {
                if (this.H.right >= this.aC.right) {}
                do
                {
                  if (this.H.right > this.aC.right) {
                    if (this.H.left > this.aC.left) {
                      i1 = -1;
                    }
                  }
                  for (;;)
                  {
                    if (this.H.top < this.aC.top) {}
                    for (;;)
                    {
                      if (this.H.bottom >= this.aC.bottom) {}
                      do
                      {
                        if (this.H.bottom > this.aC.bottom)
                        {
                          i2 = i4;
                          if (this.H.top > this.aC.top) {
                            i2 = -1;
                          }
                        }
                        for (;;)
                        {
                          switch (paramInt)
                          {
                          default: 
                            paramView = new StringBuilder();
                            paramView.append("Invalid direction: ");
                            paramView.append(paramInt);
                            paramView.append(a());
                            throw new IllegalArgumentException(paramView.toString());
                          case 1: 
                            if ((i2 >= 0) && ((i2 != 0) || (i3 * i1 > 0))) {
                              break;
                            }
                          case 130: 
                          case 66: 
                          case 33: 
                          case 17: 
                          case 2: 
                            for (;;)
                            {
                              return (View)localObject;
                              if (i2 <= 0) {
                                break;
                              }
                              continue;
                              if (i1 <= 0) {
                                break;
                              }
                              continue;
                              if (i2 >= 0) {
                                break;
                              }
                              continue;
                              if (i1 >= 0) {
                                break;
                              }
                              if ((goto 484) && (i2 <= 0)) {
                                if ((i2 != 0) || (i3 * i1 < 0)) {
                                  break;
                                }
                              }
                            }
                            if (this.H.top >= this.aC.bottom) {
                              break label341;
                            }
                            i2 = i4;
                            continue;
                            i2 = 1;
                          }
                        }
                      } while (this.H.bottom > this.aC.top);
                    }
                    i1 = 0;
                    continue;
                    if (this.H.left >= this.aC.right) {
                      break label271;
                    }
                    i1 = 0;
                    continue;
                    i1 = 1;
                  }
                } while (this.H.right > this.aC.left);
              }
            }
            if (i1 != 0)
            {
              d();
              if (i(paramView) == null) {
                break;
              }
              aD_();
              localObject = this.u.c(paramInt, this.B, this.G);
              a(false);
            }
          }
          return null;
        }
        if (paramInt == 2) {}
        for (;;)
        {
          if (!this.u.o()) {
            if (this.u.n())
            {
              if (ac.h(this.u.m) != 1) {
                break label828;
              }
              i1 = 1;
              label734:
              if (paramInt != 2) {
                break label822;
              }
              i2 = 1;
              label742:
              if ((i2 ^ i1) != 0) {
                break label816;
              }
              i1 = 17;
              label752:
              if (((FocusFinder)localObject).findNextFocus(this, paramView, i1) != null) {}
            }
          }
          label816:
          label822:
          label828:
          label860:
          for (;;)
          {
            d();
            if (i(paramView) != null)
            {
              aD_();
              this.u.c(paramInt, this.B, this.G);
              a(false);
              localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
              break;
            }
            return null;
            i1 = 66;
            break label752;
            i2 = 0;
            break label742;
            i1 = 0;
            break label734;
            if (paramInt == 2) {}
            for (i1 = 130;; i1 = 33)
            {
              if (((FocusFinder)localObject).findNextFocus(this, paramView, i1) == null) {
                break label860;
              }
              break;
            }
          }
          if (paramInt != 1) {
            break;
          }
        }
        i1 = 0;
        continue;
        i1 = 0;
        continue;
        i1 = 0;
        continue;
        i1 = 0;
      }
    }
    return (View)localObject;
  }
  
  public final fz g(int paramInt)
  {
    Object localObject = null;
    if (!this.l)
    {
      int i2 = this.k.b();
      int i1 = 0;
      localObject = null;
      if (i1 < i2)
      {
        fz localfz = b(this.k.c(i1));
        if (localfz != null) {
          if (!localfz.l()) {
            if (c(localfz) == paramInt)
            {
              localObject = localfz;
              if (!this.k.d(localfz.c)) {
                break label103;
              }
              localObject = localfz;
            }
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          continue;
        }
      }
    }
    label103:
    return (fz)localObject;
  }
  
  final void g()
  {
    if (this.x == null)
    {
      this.x = ey.a(this);
      if (this.T) {
        this.x.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      }
    }
    else
    {
      return;
    }
    this.x.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    Object localObject = this.u;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RecyclerView has no LayoutManager");
      ((StringBuilder)localObject).append(a());
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return ((ff)localObject).l();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    ff localff = this.u;
    if (localff == null)
    {
      paramAttributeSet = new StringBuilder();
      paramAttributeSet.append("RecyclerView has no LayoutManager");
      paramAttributeSet.append(a());
      throw new IllegalStateException(paramAttributeSet.toString());
    }
    return localff.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    ff localff = this.u;
    if (localff == null)
    {
      paramLayoutParams = new StringBuilder();
      paramLayoutParams.append("RecyclerView has no LayoutManager");
      paramLayoutParams.append(a());
      throw new IllegalStateException(paramLayoutParams.toString());
    }
    return localff.a(paramLayoutParams);
  }
  
  public eu getAdapter()
  {
    return this.g;
  }
  
  public int getBaseline()
  {
    if (this.u != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    ex localex = this.S;
    if (localex == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return localex.a();
  }
  
  public boolean getClipToPadding()
  {
    return this.T;
  }
  
  public ga getCompatAccessibilityDelegate()
  {
    return this.e;
  }
  
  public ey getEdgeEffectFactory()
  {
    return this.aa;
  }
  
  public ez getItemAnimator()
  {
    return this.q;
  }
  
  public int getItemDecorationCount()
  {
    return this.r.size();
  }
  
  public ff getLayoutManager()
  {
    return this.u;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.al;
  }
  
  public int getMinFlingVelocity()
  {
    return this.am;
  }
  
  public fk getOnFlingListener()
  {
    return this.aq;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.at;
  }
  
  public fn getRecycledViewPool()
  {
    return this.B.d();
  }
  
  public int getScrollState()
  {
    return this.aA;
  }
  
  final void h()
  {
    if (this.D == null)
    {
      this.D = ey.a(this);
      if (this.T) {
        this.D.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      }
    }
    else
    {
      return;
    }
    this.D.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  public void h(int paramInt) {}
  
  final void h(View paramView)
  {
    paramView = b(paramView);
    if ((this.g != null) && (paramView != null)) {}
  }
  
  public boolean hasNestedScrollingParent()
  {
    return r().a(0);
  }
  
  final void i()
  {
    if (this.J == null)
    {
      this.J = ey.a(this);
      if (this.T) {
        this.J.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      }
    }
    else
    {
      return;
    }
    this.J.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public boolean isAttachedToWindow()
  {
    return this.p;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return r().a;
  }
  
  final void j()
  {
    if (this.j == null)
    {
      this.j = ey.a(this);
      if (this.T) {
        this.j.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      }
    }
    else
    {
      return;
    }
    this.j.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  final void k()
  {
    this.ak += 1;
  }
  
  final boolean l()
  {
    AccessibilityManager localAccessibilityManager = this.R;
    return (localAccessibilityManager != null) && (localAccessibilityManager.isEnabled());
  }
  
  final void m()
  {
    if ((!this.z) && (this.p))
    {
      ac.a(this, this.ah);
      this.z = true;
    }
  }
  
  public final void n()
  {
    int i2 = 0;
    int i3 = this.k.b();
    int i1 = 0;
    while (i1 < i3)
    {
      ((fj)this.k.c(i1).getLayoutParams()).b = true;
      i1 += 1;
    }
    fp localfp = this.B;
    i3 = localfp.b.size();
    i1 = i2;
    if (i1 < i3)
    {
      fj localfj = (fj)((fz)localfp.b.get(i1)).c.getLayoutParams();
      if (localfj == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        localfj.b = true;
      }
    }
  }
  
  public final void n_(int paramInt)
  {
    r().b(paramInt);
  }
  
  public final void o()
  {
    if (this.r.size() != 0)
    {
      ff localff = this.u;
      if (localff != null) {
        localff.a("Cannot invalidate item decorations during a scroll or layout");
      }
      n();
      requestLayout();
    }
  }
  
  public void onAttachedToWindow()
  {
    boolean bool = true;
    super.onAttachedToWindow();
    this.ak = 0;
    this.p = true;
    if (this.m) {
      if (isLayoutRequested()) {}
    }
    for (;;)
    {
      this.m = bool;
      this.z = false;
      Display localDisplay;
      float f1;
      if (b)
      {
        this.n = ((ck)ck.c.get());
        if (this.n == null)
        {
          this.n = new ck();
          localDisplay = ac.N(this);
          if (!isInEditMode()) {
            break label130;
          }
          f1 = 60.0F;
        }
      }
      for (;;)
      {
        this.n.a = ((1.0E9F / f1));
        ck.c.set(this.n);
        this.n.b.add(this);
        return;
        label130:
        if (localDisplay != null)
        {
          float f2 = localDisplay.getRefreshRate();
          f1 = f2;
          if (f2 < 30.0F) {
            f1 = 60.0F;
          }
        }
        else
        {
          f1 = 60.0F;
        }
      }
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.q;
    if (localObject != null) {
      ((ez)localObject).endAnimations();
    }
    f();
    this.p = false;
    this.ar.clear();
    removeCallbacks(this.ah);
    while (ia.d.a() != null) {}
    if (b)
    {
      localObject = this.n;
      if (localObject != null)
      {
        ((ck)localObject).b.remove(this);
        this.n = null;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = this.r.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((fe)this.r.get(i1)).a(paramCanvas, this);
      i1 += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    float f2;
    float f1;
    if ((this.u != null) && (!this.v) && (paramMotionEvent.getAction() == 8))
    {
      if ((paramMotionEvent.getSource() & 0x2) == 0) {
        break label114;
      }
      if (!this.u.o()) {
        break label109;
      }
      f2 = -paramMotionEvent.getAxisValue(9);
      if (!this.u.n()) {
        break label104;
      }
      f1 = paramMotionEvent.getAxisValue(10);
    }
    for (;;)
    {
      if (f2 != 0.0F) {}
      for (;;)
      {
        a((int)(this.au * f1), (int)(f2 * this.av), paramMotionEvent);
        do
        {
          return false;
        } while (f1 == 0.0F);
      }
      label104:
      f1 = 0.0F;
      continue;
      label109:
      f2 = 0.0F;
      break;
      label114:
      if ((paramMotionEvent.getSource() & 0x400000) != 0)
      {
        f1 = paramMotionEvent.getAxisValue(26);
        if (this.u.o())
        {
          f2 = -f1;
          f1 = 0.0F;
        }
        else if (this.u.n())
        {
          f2 = 0.0F;
        }
        else
        {
          f2 = 0.0F;
          f1 = 0.0F;
        }
      }
      else
      {
        f2 = 0.0F;
        f1 = 0.0F;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c.a("RV OnLayout");
    z();
    c.a();
    this.m = true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = this.u;
    if (localObject == null) {
      d(paramInt1, paramInt2);
    }
    int i2;
    do
    {
      return;
      do
      {
        do
        {
          if (!((ff)localObject).k()) {
            break label173;
          }
          int i1 = View.MeasureSpec.getMode(paramInt1);
          i2 = View.MeasureSpec.getMode(paramInt2);
          this.u.d(paramInt1, paramInt2);
          if (i1 == 1073741824) {
            break;
          }
        } while (this.g == null);
        if (this.G.h == 1) {
          C();
        }
        this.u.b(paramInt1, paramInt2);
        this.G.f = true;
        D();
        this.u.c(paramInt1, paramInt2);
      } while (!this.u.r());
      this.u.b(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
      this.G.f = true;
      D();
      this.u.c(paramInt1, paramInt2);
      return;
    } while (i2 != 1073741824);
    return;
    label173:
    if (this.o)
    {
      this.u.d(paramInt1, paramInt2);
      return;
    }
    if (this.i)
    {
      aD_();
      k();
      y();
      b(true);
      localObject = this.G;
      if (((fw)localObject).j)
      {
        ((fw)localObject).e = true;
        this.i = false;
        a(false);
      }
    }
    while (!this.G.j) {
      for (;;)
      {
        localObject = this.g;
        if (localObject != null) {}
        for (this.G.g = ((eu)localObject).c();; this.G.g = 0)
        {
          aD_();
          this.u.d(paramInt1, paramInt2);
          a(false);
          this.G.e = false;
          return;
        }
        this.h.e();
        this.G.e = false;
      }
    }
    setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (!w()) {
      return super.onRequestFocusInDescendants(paramInt, paramRect);
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof RecyclerView.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    Parcelable localParcelable;
    do
    {
      do
      {
        return;
        this.as = ((RecyclerView.SavedState)paramParcelable);
        super.onRestoreInstanceState(this.as.e);
        paramParcelable = this.u;
      } while (paramParcelable == null);
      localParcelable = this.as.a;
    } while (localParcelable == null);
    paramParcelable.a(localParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    Object localObject = this.as;
    if (localObject == null)
    {
      localObject = this.u;
      if (localObject != null)
      {
        localSavedState.a = ((ff)localObject).m();
        return localSavedState;
      }
      localSavedState.a = null;
      return localSavedState;
    }
    localSavedState.a = ((RecyclerView.SavedState)localObject).a;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {}
    for (;;)
    {
      t();
      do
      {
        return;
      } while (paramInt2 == paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public final boolean p()
  {
    return (!this.m) || (this.l) || (this.h.d());
  }
  
  final android.support.v4.view.u r()
  {
    if (this.aB == null) {
      this.aB = new android.support.v4.view.u(this);
    }
    return this.aB;
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    fz localfz = b(paramView);
    if (localfz != null)
    {
      if (!localfz.m()) {
        break label36;
      }
      localfz.i();
    }
    label36:
    while (localfz.b())
    {
      paramView.clearAnimation();
      h(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    paramView = new StringBuilder();
    paramView.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
    paramView.append(localfz);
    paramView.append(a());
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    ft localft = this.u.n;
    if (localft == null) {
      if ((!w()) && (paramView2 != null)) {
        a(paramView1, paramView2);
      }
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      if (!localft.d) {
        break;
      }
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.u.a(this, paramView, paramRect, paramBoolean, false);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int i2 = this.y.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((fl)this.y.get(i1)).a();
      i1 += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.af == 0) && (!this.v))
    {
      super.requestLayout();
      return;
    }
    this.w = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    ff localff = this.u;
    if (localff == null) {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    while (this.v) {
      return;
    }
    boolean bool1 = localff.n();
    boolean bool2 = this.u.o();
    if (bool1) {}
    for (;;)
    {
      if (!bool1) {
        paramInt1 = 0;
      }
      if (!bool2) {
        paramInt2 = 0;
      }
      a(paramInt1, paramInt2, null);
      return;
      if (!bool2) {
        break;
      }
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    int i2 = 0;
    if (!w())
    {
      super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
      return;
    }
    int i1;
    if (paramAccessibilityEvent != null) {
      if (Build.VERSION.SDK_INT >= 19) {
        i1 = paramAccessibilityEvent.getContentChangeTypes();
      }
    }
    for (;;)
    {
      if (i1 == 0) {
        i1 = i2;
      }
      for (;;)
      {
        this.W = (i1 | this.W);
        return;
      }
      i1 = 0;
      continue;
      i1 = 0;
    }
  }
  
  public void setAccessibilityDelegateCompat(ga paramga)
  {
    this.e = paramga;
    ac.a(this, this.e);
  }
  
  public void setAdapter(eu parameu)
  {
    setLayoutFrozen(false);
    eu localeu = this.g;
    if (localeu != null)
    {
      localeu.b(this.ap);
      this.g.b(this);
    }
    b();
    this.h.a();
    localeu = this.g;
    this.g = parameu;
    if (parameu != null)
    {
      parameu.a(this.ap);
      parameu.a(this);
    }
    Object localObject = this.B;
    parameu = this.g;
    ((fp)localObject).a();
    localObject = ((fp)localObject).d();
    if (localeu == null) {}
    for (;;)
    {
      if (((fn)localObject).a == 0) {
        ((fn)localObject).a();
      }
      if (parameu != null) {
        ((fn)localObject).b();
      }
      this.G.l = true;
      c(false);
      requestLayout();
      return;
      ((fn)localObject).c();
    }
  }
  
  public void setChildDrawingOrderCallback(ex paramex)
  {
    if (paramex != this.S)
    {
      this.S = paramex;
      if (this.S == null) {
        break label28;
      }
    }
    label28:
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.T) {
      t();
    }
    this.T = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.m) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(ey paramey)
  {
    android.support.v4.g.u.a(paramey);
    this.aa = paramey;
    t();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setItemAnimator(ez paramez)
  {
    ez localez = this.q;
    if (localez != null)
    {
      localez.endAnimations();
      this.q.setListener(null);
    }
    this.q = paramez;
    paramez = this.q;
    if (paramez != null) {
      paramez.setListener(this.ag);
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    fp localfp = this.B;
    localfp.e = paramInt;
    localfp.b();
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.v)
    {
      a("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.v = false;
        if ((this.w) && (this.u != null) && (this.g != null)) {
          requestLayout();
        }
        this.w = false;
      }
    }
    else
    {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0));
    this.v = true;
    this.ac = true;
    f();
  }
  
  public void setLayoutManager(ff paramff)
  {
    Object localObject;
    if (paramff != this.u)
    {
      f();
      if (this.u == null) {
        break label265;
      }
      localObject = this.q;
      if (localObject != null) {
        ((ez)localObject).endAnimations();
      }
      this.u.b(this.B);
      this.u.a(this.B);
      this.B.a();
      this.u.a(null);
      this.u = null;
    }
    for (;;)
    {
      be localbe = this.k;
      localObject = localbe.a;
      bf localbf;
      do
      {
        ((bf)localObject).a = 0L;
        localbf = ((bf)localObject).b;
        localObject = localbf;
      } while (localbf != null);
      int i1 = localbe.c.size() - 1;
      while (i1 >= 0)
      {
        localbe.b.d((View)localbe.c.get(i1));
        localbe.c.remove(i1);
        i1 -= 1;
      }
      localbe.b.b();
      this.u = paramff;
      if (paramff != null)
      {
        if (paramff.m != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("LayoutManager ");
          ((StringBuilder)localObject).append(paramff);
          ((StringBuilder)localObject).append(" is already attached to a RecyclerView:");
          ((StringBuilder)localObject).append(paramff.m.a());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        this.u.a(this);
      }
      this.B.b();
      requestLayout();
      return;
      label265:
      this.B.a();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    r().a(paramBoolean);
  }
  
  public void setOnFlingListener(fk paramfk)
  {
    this.aq = paramfk;
  }
  
  @Deprecated
  public void setOnScrollListener(fm paramfm)
  {
    this.aw = paramfm;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.at = paramBoolean;
  }
  
  public void setRecycledViewPool(fn paramfn)
  {
    fp localfp = this.B;
    fn localfn = localfp.d;
    if (localfn != null) {
      localfn.c();
    }
    localfp.d = paramfn;
    if ((localfp.d != null) && (localfp.h.getAdapter() != null)) {
      localfp.d.b();
    }
  }
  
  public void setRecyclerListener(fq paramfq)
  {
    this.C = paramfq;
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("; using default value");
      Log.w("RecyclerView", localStringBuilder.toString());
    case 0: 
      this.aD = localViewConfiguration.getScaledTouchSlop();
      return;
    }
    this.aD = localViewConfiguration.getScaledPagingTouchSlop();
  }
  
  public void setViewCacheExtension(fx paramfx)
  {
    this.B.g = paramfx;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return r().a(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    r().b(0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/RecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */