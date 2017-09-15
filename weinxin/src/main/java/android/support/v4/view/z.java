package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public final class z
{
  static final m xZ = new a();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      xZ = new l();
      return;
    }
    if (i >= 21)
    {
      xZ = new k();
      return;
    }
    if (i >= 19)
    {
      xZ = new j();
      return;
    }
    if (i >= 17)
    {
      xZ = new h();
      return;
    }
    if (i >= 16)
    {
      xZ = new g();
      return;
    }
    if (i >= 15)
    {
      xZ = new e();
      return;
    }
    if (i >= 14)
    {
      xZ = new f();
      return;
    }
    if (i >= 11)
    {
      xZ = new d();
      return;
    }
    if (i >= 9)
    {
      xZ = new c();
      return;
    }
    if (i >= 7)
    {
      xZ = new b();
      return;
    }
  }
  
  public static int C(View paramView)
  {
    return xZ.C(paramView);
  }
  
  public static boolean D(View paramView)
  {
    return xZ.D(paramView);
  }
  
  public static boolean E(View paramView)
  {
    return xZ.E(paramView);
  }
  
  public static void F(View paramView)
  {
    xZ.F(paramView);
  }
  
  public static int G(View paramView)
  {
    return xZ.G(paramView);
  }
  
  public static float H(View paramView)
  {
    return xZ.H(paramView);
  }
  
  public static int I(View paramView)
  {
    return xZ.I(paramView);
  }
  
  public static int J(View paramView)
  {
    return xZ.J(paramView);
  }
  
  public static ViewParent K(View paramView)
  {
    return xZ.K(paramView);
  }
  
  public static boolean L(View paramView)
  {
    return xZ.L(paramView);
  }
  
  public static int M(View paramView)
  {
    return xZ.M(paramView);
  }
  
  public static int N(View paramView)
  {
    return xZ.N(paramView);
  }
  
  public static void O(View paramView)
  {
    xZ.l(paramView, 1);
  }
  
  public static int P(View paramView)
  {
    return xZ.P(paramView);
  }
  
  public static int Q(View paramView)
  {
    return xZ.Q(paramView);
  }
  
  public static float R(View paramView)
  {
    return xZ.R(paramView);
  }
  
  public static float S(View paramView)
  {
    return xZ.S(paramView);
  }
  
  public static int T(View paramView)
  {
    return xZ.T(paramView);
  }
  
  public static int U(View paramView)
  {
    return xZ.U(paramView);
  }
  
  public static ai V(View paramView)
  {
    return xZ.V(paramView);
  }
  
  public static float W(View paramView)
  {
    return xZ.W(paramView);
  }
  
  public static float X(View paramView)
  {
    return xZ.X(paramView);
  }
  
  public static int Y(View paramView)
  {
    return xZ.Y(paramView);
  }
  
  public static void Z(View paramView)
  {
    xZ.Z(paramView);
  }
  
  public static ap a(View paramView, ap paramap)
  {
    return xZ.a(paramView, paramap);
  }
  
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    xZ.a(paramView, paramInt, paramPaint);
  }
  
  public static void a(View paramView, ColorStateList paramColorStateList)
  {
    xZ.a(paramView, paramColorStateList);
  }
  
  public static void a(View paramView, Paint paramPaint)
  {
    xZ.a(paramView, paramPaint);
  }
  
  public static void a(View paramView, PorterDuff.Mode paramMode)
  {
    xZ.a(paramView, paramMode);
  }
  
  public static void a(View paramView, a parama)
  {
    xZ.a(paramView, parama);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    xZ.a(paramView, paramRunnable);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    xZ.a(paramView, paramRunnable, paramLong);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    xZ.a(paramView, paramBoolean);
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    xZ.a(paramViewGroup, true);
  }
  
  public static boolean aa(View paramView)
  {
    return xZ.aa(paramView);
  }
  
  public static void ab(View paramView)
  {
    xZ.ab(paramView);
  }
  
  public static void ac(View paramView)
  {
    xZ.c(paramView, false);
  }
  
  public static boolean ad(View paramView)
  {
    return xZ.ad(paramView);
  }
  
  public static boolean ae(View paramView)
  {
    return xZ.ae(paramView);
  }
  
  public static ColorStateList af(View paramView)
  {
    return xZ.af(paramView);
  }
  
  public static PorterDuff.Mode ag(View paramView)
  {
    return xZ.ag(paramView);
  }
  
  public static boolean ah(View paramView)
  {
    return xZ.ah(paramView);
  }
  
  public static void ai(View paramView)
  {
    xZ.ai(paramView);
  }
  
  public static boolean aj(View paramView)
  {
    return xZ.aj(paramView);
  }
  
  public static float ak(View paramView)
  {
    return xZ.ak(paramView);
  }
  
  public static boolean al(View paramView)
  {
    return xZ.al(paramView);
  }
  
  public static boolean am(View paramView)
  {
    return xZ.am(paramView);
  }
  
  public static ap b(View paramView, ap paramap)
  {
    return xZ.b(paramView, paramap);
  }
  
  public static void b(View paramView, float paramFloat)
  {
    xZ.b(paramView, paramFloat);
  }
  
  public static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    xZ.b(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void b(View paramView, t paramt)
  {
    xZ.b(paramView, paramt);
  }
  
  public static void b(View paramView, boolean paramBoolean)
  {
    xZ.b(paramView, paramBoolean);
  }
  
  public static void c(View paramView, float paramFloat)
  {
    xZ.c(paramView, paramFloat);
  }
  
  public static void c(View paramView, int paramInt1, int paramInt2)
  {
    xZ.c(paramView, paramInt1, 3);
  }
  
  public static void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    xZ.c(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return xZ.combineMeasuredStates(paramInt1, paramInt2);
  }
  
  public static void d(View paramView, float paramFloat)
  {
    xZ.d(paramView, paramFloat);
  }
  
  public static void e(View paramView, float paramFloat)
  {
    xZ.e(paramView, paramFloat);
  }
  
  public static void f(View paramView, float paramFloat)
  {
    xZ.f(paramView, paramFloat);
  }
  
  public static void g(View paramView, float paramFloat)
  {
    xZ.g(paramView, paramFloat);
  }
  
  public static boolean g(View paramView, int paramInt)
  {
    return xZ.g(paramView, paramInt);
  }
  
  public static boolean h(View paramView, int paramInt)
  {
    return xZ.h(paramView, paramInt);
  }
  
  public static void i(View paramView, int paramInt)
  {
    xZ.i(paramView, paramInt);
  }
  
  public static void j(View paramView, int paramInt)
  {
    xZ.j(paramView, paramInt);
  }
  
  public static void k(View paramView, int paramInt)
  {
    xZ.k(paramView, paramInt);
  }
  
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return xZ.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  static class a
    implements z.m
  {
    WeakHashMap<View, ai> ya = null;
    
    public int C(View paramView)
    {
      return 2;
    }
    
    public boolean D(View paramView)
    {
      return false;
    }
    
    public boolean E(View paramView)
    {
      return false;
    }
    
    public void F(View paramView)
    {
      paramView.invalidate();
    }
    
    public int G(View paramView)
    {
      return 0;
    }
    
    public float H(View paramView)
    {
      return 1.0F;
    }
    
    public int I(View paramView)
    {
      return 0;
    }
    
    public int J(View paramView)
    {
      return 0;
    }
    
    public ViewParent K(View paramView)
    {
      return paramView.getParent();
    }
    
    public boolean L(View paramView)
    {
      boolean bool2 = false;
      paramView = paramView.getBackground();
      boolean bool1 = bool2;
      if (paramView != null)
      {
        bool1 = bool2;
        if (paramView.getOpacity() == -1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public int M(View paramView)
    {
      return paramView.getMeasuredWidth();
    }
    
    public int N(View paramView)
    {
      return 0;
    }
    
    public int P(View paramView)
    {
      return paramView.getPaddingLeft();
    }
    
    public int Q(View paramView)
    {
      return paramView.getPaddingRight();
    }
    
    public float R(View paramView)
    {
      return 0.0F;
    }
    
    public float S(View paramView)
    {
      return 0.0F;
    }
    
    public int T(View paramView)
    {
      return aa.T(paramView);
    }
    
    public int U(View paramView)
    {
      return aa.U(paramView);
    }
    
    public ai V(View paramView)
    {
      return new ai(paramView);
    }
    
    public float W(View paramView)
    {
      return 0.0F;
    }
    
    public float X(View paramView)
    {
      return 0.0F;
    }
    
    public int Y(View paramView)
    {
      return 0;
    }
    
    public void Z(View paramView) {}
    
    public ap a(View paramView, ap paramap)
    {
      return paramap;
    }
    
    public void a(View paramView, int paramInt, Paint paramPaint) {}
    
    public void a(View paramView, ColorStateList paramColorStateList)
    {
      if ((paramView instanceof x)) {
        ((x)paramView).d(paramColorStateList);
      }
    }
    
    public void a(View paramView, Paint paramPaint) {}
    
    public void a(View paramView, PorterDuff.Mode paramMode)
    {
      if ((paramView instanceof x)) {
        ((x)paramView).a(paramMode);
      }
    }
    
    public void a(View paramView, a parama) {}
    
    public void a(View paramView, Runnable paramRunnable)
    {
      paramView.postDelayed(paramRunnable, bN());
    }
    
    public void a(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postDelayed(paramRunnable, bN() + paramLong);
    }
    
    public void a(View paramView, boolean paramBoolean) {}
    
    public void a(ViewGroup paramViewGroup, boolean paramBoolean) {}
    
    public boolean aa(View paramView)
    {
      return false;
    }
    
    public void ab(View paramView) {}
    
    public boolean ad(View paramView)
    {
      return true;
    }
    
    public boolean ae(View paramView)
    {
      return false;
    }
    
    public ColorStateList af(View paramView)
    {
      if ((paramView instanceof x)) {
        return ((x)paramView).bL();
      }
      return null;
    }
    
    public PorterDuff.Mode ag(View paramView)
    {
      if ((paramView instanceof x)) {
        return ((x)paramView).bM();
      }
      return null;
    }
    
    public boolean ah(View paramView)
    {
      if ((paramView instanceof p)) {
        return ((p)paramView).isNestedScrollingEnabled();
      }
      return false;
    }
    
    public void ai(View paramView)
    {
      if ((paramView instanceof p)) {
        ((p)paramView).stopNestedScroll();
      }
    }
    
    public boolean aj(View paramView)
    {
      return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
    }
    
    public float ak(View paramView)
    {
      return an(paramView) + X(paramView);
    }
    
    public boolean al(View paramView)
    {
      return paramView.getWindowToken() != null;
    }
    
    public boolean am(View paramView)
    {
      return false;
    }
    
    public float an(View paramView)
    {
      return 0.0F;
    }
    
    public ap b(View paramView, ap paramap)
    {
      return paramap;
    }
    
    public void b(View paramView, float paramFloat) {}
    
    public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void b(View paramView, t paramt) {}
    
    public void b(View paramView, boolean paramBoolean) {}
    
    long bN()
    {
      return 10L;
    }
    
    public void c(View paramView, float paramFloat) {}
    
    public void c(View paramView, int paramInt1, int paramInt2) {}
    
    public void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void c(View paramView, boolean paramBoolean) {}
    
    public int combineMeasuredStates(int paramInt1, int paramInt2)
    {
      return paramInt1 | paramInt2;
    }
    
    public void d(View paramView, float paramFloat) {}
    
    public void e(View paramView, float paramFloat) {}
    
    public void f(View paramView, float paramFloat) {}
    
    public void g(View paramView, float paramFloat) {}
    
    public boolean g(View paramView, int paramInt)
    {
      if ((paramView instanceof w))
      {
        paramView = (w)paramView;
        int i = paramView.computeHorizontalScrollOffset();
        int j = paramView.computeHorizontalScrollRange() - paramView.computeHorizontalScrollExtent();
        if (j != 0) {
          if (paramInt < 0) {
            if (i > 0) {
              paramInt = 1;
            }
          }
        }
        while (paramInt != 0)
        {
          return true;
          paramInt = 0;
          continue;
          if (i < j - 1) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
        }
      }
      return false;
    }
    
    public boolean h(View paramView, int paramInt)
    {
      if ((paramView instanceof w))
      {
        paramView = (w)paramView;
        int i = paramView.computeVerticalScrollOffset();
        int j = paramView.computeVerticalScrollRange() - paramView.computeVerticalScrollExtent();
        if (j != 0) {
          if (paramInt < 0) {
            if (i > 0) {
              paramInt = 1;
            }
          }
        }
        while (paramInt != 0)
        {
          return true;
          paramInt = 0;
          continue;
          if (i < j - 1) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
        }
      }
      return false;
    }
    
    public void i(View paramView, int paramInt) {}
    
    public void j(View paramView, int paramInt)
    {
      int i = paramView.getTop();
      paramView.offsetTopAndBottom(paramInt);
      if (paramInt != 0)
      {
        ViewParent localViewParent = paramView.getParent();
        if ((localViewParent instanceof View))
        {
          paramInt = Math.abs(paramInt);
          ((View)localViewParent).invalidate(paramView.getLeft(), i - paramInt, paramView.getRight(), i + paramView.getHeight() + paramInt);
        }
      }
      else
      {
        return;
      }
      paramView.invalidate();
    }
    
    public void k(View paramView, int paramInt)
    {
      int i = paramView.getLeft();
      paramView.offsetLeftAndRight(paramInt);
      if (paramInt != 0)
      {
        ViewParent localViewParent = paramView.getParent();
        if ((localViewParent instanceof View))
        {
          paramInt = Math.abs(paramInt);
          ((View)localViewParent).invalidate(i - paramInt, paramView.getTop(), i + paramView.getWidth() + paramInt, paramView.getBottom());
        }
      }
      else
      {
        return;
      }
      paramView.invalidate();
    }
    
    public void l(View paramView, int paramInt) {}
    
    public int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
    {
      return View.resolveSize(paramInt1, paramInt2);
    }
  }
  
  static class b
    extends z.a
  {
    public final boolean L(View paramView)
    {
      return paramView.isOpaque();
    }
    
    public final void a(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      if (ab.yh == null) {}
      try
      {
        ab.yh = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
        ab.yh.setAccessible(true);
        try
        {
          ab.yh.invoke(paramViewGroup, new Object[] { Boolean.valueOf(true) });
          return;
        }
        catch (InvocationTargetException paramViewGroup) {}catch (IllegalArgumentException paramViewGroup) {}catch (IllegalAccessException paramViewGroup) {}
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
    }
  }
  
  static class c
    extends z.b
  {
    public final int C(View paramView)
    {
      return paramView.getOverScrollMode();
    }
  }
  
  static class d
    extends z.c
  {
    public final float H(View paramView)
    {
      return paramView.getAlpha();
    }
    
    public final int I(View paramView)
    {
      return paramView.getLayerType();
    }
    
    public final int M(View paramView)
    {
      return paramView.getMeasuredWidthAndState();
    }
    
    public final int N(View paramView)
    {
      return paramView.getMeasuredState();
    }
    
    public final float R(View paramView)
    {
      return paramView.getTranslationX();
    }
    
    public final float S(View paramView)
    {
      return paramView.getTranslationY();
    }
    
    public final float W(View paramView)
    {
      return paramView.getScaleX();
    }
    
    public final void a(View paramView, int paramInt, Paint paramPaint)
    {
      paramView.setLayerType(paramInt, paramPaint);
    }
    
    public void a(View paramView, Paint paramPaint)
    {
      a(paramView, paramView.getLayerType(), paramPaint);
      paramView.invalidate();
    }
    
    public final void ab(View paramView)
    {
      paramView.jumpDrawablesToCurrentState();
    }
    
    public final void b(View paramView, float paramFloat)
    {
      paramView.setTranslationX(paramFloat);
    }
    
    public final void b(View paramView, boolean paramBoolean)
    {
      paramView.setActivated(paramBoolean);
    }
    
    final long bN()
    {
      return ValueAnimator.getFrameDelay();
    }
    
    public final void c(View paramView, float paramFloat)
    {
      paramView.setTranslationY(paramFloat);
    }
    
    public final void c(View paramView, boolean paramBoolean)
    {
      paramView.setSaveFromParentEnabled(false);
    }
    
    public final int combineMeasuredStates(int paramInt1, int paramInt2)
    {
      return View.combineMeasuredStates(paramInt1, paramInt2);
    }
    
    public final void d(View paramView, float paramFloat)
    {
      paramView.setAlpha(paramFloat);
    }
    
    public final void e(View paramView, float paramFloat)
    {
      paramView.setScaleX(paramFloat);
    }
    
    public final void f(View paramView, float paramFloat)
    {
      paramView.setScaleY(paramFloat);
    }
    
    public void j(View paramView, int paramInt)
    {
      ac.j(paramView, paramInt);
    }
    
    public void k(View paramView, int paramInt)
    {
      ac.k(paramView, paramInt);
    }
    
    public final int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
    {
      return View.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
    }
  }
  
  static class e
    extends z.f
  {
    public final boolean am(View paramView)
    {
      return paramView.hasOnClickListeners();
    }
  }
  
  static class f
    extends z.d
  {
    static Field yb;
    static boolean yc = false;
    
    public final boolean D(View paramView)
    {
      if (yc) {}
      for (;;)
      {
        return false;
        if (yb == null) {}
        try
        {
          Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
          yb = localField;
          localField.setAccessible(true);
        }
        catch (Throwable paramView)
        {
          try
          {
            paramView = yb.get(paramView);
            if (paramView == null) {
              continue;
            }
            return true;
          }
          catch (Throwable paramView)
          {
            yc = true;
          }
          paramView = paramView;
          yc = true;
          return false;
        }
      }
      return false;
    }
    
    public final ai V(View paramView)
    {
      if (this.ya == null) {
        this.ya = new WeakHashMap();
      }
      ai localai2 = (ai)this.ya.get(paramView);
      ai localai1 = localai2;
      if (localai2 == null)
      {
        localai1 = new ai(paramView);
        this.ya.put(paramView, localai1);
      }
      return localai1;
    }
    
    public final void a(View paramView, a parama)
    {
      if (parama == null) {}
      for (parama = null;; parama = parama.wq)
      {
        paramView.setAccessibilityDelegate((View.AccessibilityDelegate)parama);
        return;
      }
    }
    
    public final void a(View paramView, boolean paramBoolean)
    {
      paramView.setFitsSystemWindows(paramBoolean);
    }
    
    public final boolean g(View paramView, int paramInt)
    {
      return paramView.canScrollHorizontally(paramInt);
    }
    
    public final boolean h(View paramView, int paramInt)
    {
      return paramView.canScrollVertically(paramInt);
    }
  }
  
  static class g
    extends z.e
  {
    public final boolean E(View paramView)
    {
      return paramView.hasTransientState();
    }
    
    public final void F(View paramView)
    {
      paramView.postInvalidateOnAnimation();
    }
    
    public final int G(View paramView)
    {
      return paramView.getImportantForAccessibility();
    }
    
    public final ViewParent K(View paramView)
    {
      return paramView.getParentForAccessibility();
    }
    
    public final int T(View paramView)
    {
      return paramView.getMinimumWidth();
    }
    
    public final int U(View paramView)
    {
      return paramView.getMinimumHeight();
    }
    
    public void Z(View paramView)
    {
      paramView.requestFitSystemWindows();
    }
    
    public final void a(View paramView, Runnable paramRunnable)
    {
      paramView.postOnAnimation(paramRunnable);
    }
    
    public final void a(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postOnAnimationDelayed(paramRunnable, paramLong);
    }
    
    public final boolean aa(View paramView)
    {
      return paramView.getFitsSystemWindows();
    }
    
    public final boolean ad(View paramView)
    {
      return paramView.hasOverlappingRendering();
    }
    
    public final void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void i(View paramView, int paramInt)
    {
      int i = paramInt;
      if (paramInt == 4) {
        i = 2;
      }
      paramView.setImportantForAccessibility(i);
    }
  }
  
  static class h
    extends z.g
  {
    public final int J(View paramView)
    {
      return paramView.getLayoutDirection();
    }
    
    public final int P(View paramView)
    {
      return paramView.getPaddingStart();
    }
    
    public final int Q(View paramView)
    {
      return paramView.getPaddingEnd();
    }
    
    public final int Y(View paramView)
    {
      return paramView.getWindowSystemUiVisibility();
    }
    
    public final void a(View paramView, Paint paramPaint)
    {
      paramView.setLayerPaint(paramPaint);
    }
    
    public final boolean ae(View paramView)
    {
      return paramView.isPaddingRelative();
    }
    
    public final void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  static class i
    extends z.h
  {}
  
  static class j
    extends z.i
  {
    public final boolean aj(View paramView)
    {
      return paramView.isLaidOut();
    }
    
    public final boolean al(View paramView)
    {
      return paramView.isAttachedToWindow();
    }
    
    public final void i(View paramView, int paramInt)
    {
      paramView.setImportantForAccessibility(paramInt);
    }
    
    public final void l(View paramView, int paramInt)
    {
      paramView.setAccessibilityLiveRegion(1);
    }
  }
  
  static class k
    extends z.j
  {
    public final float X(View paramView)
    {
      return paramView.getElevation();
    }
    
    public final void Z(View paramView)
    {
      paramView.requestApplyInsets();
    }
    
    public final ap a(View paramView, ap paramap)
    {
      Object localObject = paramap;
      if ((paramap instanceof aq))
      {
        WindowInsets localWindowInsets = ((aq)paramap).zI;
        paramView = paramView.onApplyWindowInsets(localWindowInsets);
        localObject = paramap;
        if (paramView != localWindowInsets) {
          localObject = new aq(paramView);
        }
      }
      return (ap)localObject;
    }
    
    public final void a(View paramView, ColorStateList paramColorStateList)
    {
      paramView.setBackgroundTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramView.getBackground();
        if ((paramView.getBackgroundTintList() == null) || (paramView.getBackgroundTintMode() == null)) {
          break label64;
        }
      }
      label64:
      for (int i = 1;; i = 0)
      {
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramColorStateList);
        }
        return;
      }
    }
    
    public final void a(View paramView, PorterDuff.Mode paramMode)
    {
      paramView.setBackgroundTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramView.getBackground();
        if ((paramView.getBackgroundTintList() == null) || (paramView.getBackgroundTintMode() == null)) {
          break label64;
        }
      }
      label64:
      for (int i = 1;; i = 0)
      {
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramMode);
        }
        return;
      }
    }
    
    public final ColorStateList af(View paramView)
    {
      return paramView.getBackgroundTintList();
    }
    
    public final PorterDuff.Mode ag(View paramView)
    {
      return paramView.getBackgroundTintMode();
    }
    
    public final boolean ah(View paramView)
    {
      return paramView.isNestedScrollingEnabled();
    }
    
    public final void ai(View paramView)
    {
      paramView.stopNestedScroll();
    }
    
    public final float ak(View paramView)
    {
      return paramView.getZ();
    }
    
    public final float an(View paramView)
    {
      return paramView.getTranslationZ();
    }
    
    public final ap b(View paramView, ap paramap)
    {
      Object localObject = paramap;
      if ((paramap instanceof aq))
      {
        WindowInsets localWindowInsets = ((aq)paramap).zI;
        paramView = paramView.dispatchApplyWindowInsets(localWindowInsets);
        localObject = paramap;
        if (paramView != localWindowInsets) {
          localObject = new aq(paramView);
        }
      }
      return (ap)localObject;
    }
    
    public final void b(View paramView, t paramt)
    {
      if (paramt == null)
      {
        paramView.setOnApplyWindowInsetsListener(null);
        return;
      }
      paramView.setOnApplyWindowInsetsListener(new ad.1(paramt));
    }
    
    public final void g(View paramView, float paramFloat)
    {
      paramView.setElevation(paramFloat);
    }
    
    public void j(View paramView, int paramInt)
    {
      Rect localRect = ad.bO();
      ViewParent localViewParent = paramView.getParent();
      int i;
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
          i = 1;
        }
      }
      for (;;)
      {
        ac.j(paramView, paramInt);
        if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
          ((View)localViewParent).invalidate(localRect);
        }
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
    
    public void k(View paramView, int paramInt)
    {
      Rect localRect = ad.bO();
      ViewParent localViewParent = paramView.getParent();
      int i;
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
          i = 1;
        }
      }
      for (;;)
      {
        ac.k(paramView, paramInt);
        if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
          ((View)localViewParent).invalidate(localRect);
        }
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  static final class l
    extends z.k
  {
    public final void c(View paramView, int paramInt1, int paramInt2)
    {
      paramView.setScrollIndicators(paramInt1, paramInt2);
    }
    
    public final void j(View paramView, int paramInt)
    {
      paramView.offsetTopAndBottom(paramInt);
    }
    
    public final void k(View paramView, int paramInt)
    {
      paramView.offsetLeftAndRight(paramInt);
    }
  }
  
  static abstract interface m
  {
    public abstract int C(View paramView);
    
    public abstract boolean D(View paramView);
    
    public abstract boolean E(View paramView);
    
    public abstract void F(View paramView);
    
    public abstract int G(View paramView);
    
    public abstract float H(View paramView);
    
    public abstract int I(View paramView);
    
    public abstract int J(View paramView);
    
    public abstract ViewParent K(View paramView);
    
    public abstract boolean L(View paramView);
    
    public abstract int M(View paramView);
    
    public abstract int N(View paramView);
    
    public abstract int P(View paramView);
    
    public abstract int Q(View paramView);
    
    public abstract float R(View paramView);
    
    public abstract float S(View paramView);
    
    public abstract int T(View paramView);
    
    public abstract int U(View paramView);
    
    public abstract ai V(View paramView);
    
    public abstract float W(View paramView);
    
    public abstract float X(View paramView);
    
    public abstract int Y(View paramView);
    
    public abstract void Z(View paramView);
    
    public abstract ap a(View paramView, ap paramap);
    
    public abstract void a(View paramView, int paramInt, Paint paramPaint);
    
    public abstract void a(View paramView, ColorStateList paramColorStateList);
    
    public abstract void a(View paramView, Paint paramPaint);
    
    public abstract void a(View paramView, PorterDuff.Mode paramMode);
    
    public abstract void a(View paramView, a parama);
    
    public abstract void a(View paramView, Runnable paramRunnable);
    
    public abstract void a(View paramView, Runnable paramRunnable, long paramLong);
    
    public abstract void a(View paramView, boolean paramBoolean);
    
    public abstract void a(ViewGroup paramViewGroup, boolean paramBoolean);
    
    public abstract boolean aa(View paramView);
    
    public abstract void ab(View paramView);
    
    public abstract boolean ad(View paramView);
    
    public abstract boolean ae(View paramView);
    
    public abstract ColorStateList af(View paramView);
    
    public abstract PorterDuff.Mode ag(View paramView);
    
    public abstract boolean ah(View paramView);
    
    public abstract void ai(View paramView);
    
    public abstract boolean aj(View paramView);
    
    public abstract float ak(View paramView);
    
    public abstract boolean al(View paramView);
    
    public abstract boolean am(View paramView);
    
    public abstract ap b(View paramView, ap paramap);
    
    public abstract void b(View paramView, float paramFloat);
    
    public abstract void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void b(View paramView, t paramt);
    
    public abstract void b(View paramView, boolean paramBoolean);
    
    public abstract void c(View paramView, float paramFloat);
    
    public abstract void c(View paramView, int paramInt1, int paramInt2);
    
    public abstract void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void c(View paramView, boolean paramBoolean);
    
    public abstract int combineMeasuredStates(int paramInt1, int paramInt2);
    
    public abstract void d(View paramView, float paramFloat);
    
    public abstract void e(View paramView, float paramFloat);
    
    public abstract void f(View paramView, float paramFloat);
    
    public abstract void g(View paramView, float paramFloat);
    
    public abstract boolean g(View paramView, int paramInt);
    
    public abstract boolean h(View paramView, int paramInt);
    
    public abstract void i(View paramView, int paramInt);
    
    public abstract void j(View paramView, int paramInt);
    
    public abstract void k(View paramView, int paramInt);
    
    public abstract void l(View paramView, int paramInt);
    
    public abstract int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */