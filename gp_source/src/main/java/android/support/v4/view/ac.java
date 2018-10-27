package android.support.v4.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.a;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class ac
{
  private static boolean a = false;
  private static Field b;
  private static ThreadLocal c;
  private static WeakHashMap d;
  private static WeakHashMap e;
  
  static
  {
    new AtomicInteger(1);
    e = null;
  }
  
  public static boolean A(View paramView)
  {
    return paramView.hasOverlappingRendering();
  }
  
  public static boolean B(View paramView)
  {
    if (Build.VERSION.SDK_INT < 17) {
      return false;
    }
    return paramView.isPaddingRelative();
  }
  
  public static ColorStateList C(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getBackgroundTintList();
    }
    if ((paramView instanceof ab)) {
      return ((ab)paramView).getSupportBackgroundTintList();
    }
    return null;
  }
  
  public static PorterDuff.Mode D(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getBackgroundTintMode();
    }
    if ((paramView instanceof ab)) {
      return ((ab)paramView).getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public static void E(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setNestedScrollingEnabled(false);
    }
    while (!(paramView instanceof s)) {
      return;
    }
    ((s)paramView).setNestedScrollingEnabled(false);
  }
  
  public static boolean F(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.isNestedScrollingEnabled();
    }
    if ((paramView instanceof s)) {
      return ((s)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public static void G(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.stopNestedScroll();
    }
    while (!(paramView instanceof s)) {
      return;
    }
    ((s)paramView).stopNestedScroll();
  }
  
  public static void H(View paramView)
  {
    if ((paramView instanceof t)) {
      ((t)paramView).n_(1);
    }
  }
  
  public static boolean I(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isLaidOut();
    }
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
  
  public static float J(View paramView)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return 0.0F;
    }
    return paramView.getZ();
  }
  
  public static Rect K(View paramView)
  {
    if (Build.VERSION.SDK_INT < 18) {
      return null;
    }
    return paramView.getClipBounds();
  }
  
  public static boolean L(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramView.isAttachedToWindow();
    }
    return paramView.getWindowToken() != null;
  }
  
  public static boolean M(View paramView)
  {
    return paramView.hasOnClickListeners();
  }
  
  public static Display N(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getDisplay();
    }
    if (L(paramView)) {
      return ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay();
    }
    return null;
  }
  
  private static void O(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
  
  @SuppressLint({"InlinedApi"})
  public static int a(View paramView)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return 0;
    }
    return paramView.getImportantForAutofill();
  }
  
  private static Rect a()
  {
    if (c == null) {
      c = new ThreadLocal();
    }
    Rect localRect2 = (Rect)c.get();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      localRect1 = new Rect();
      c.set(localRect1);
    }
    localRect1.setEmpty();
    return localRect1;
  }
  
  public static bf a(View paramView, bf parambf)
  {
    Object localObject = parambf;
    if (Build.VERSION.SDK_INT >= 21)
    {
      parambf = (WindowInsets)bf.a(parambf);
      localObject = paramView.onApplyWindowInsets(parambf);
      paramView = parambf;
      if (localObject != parambf) {
        paramView = new WindowInsets((WindowInsets)localObject);
      }
      localObject = bf.a(paramView);
    }
    return (bf)localObject;
  }
  
  @Deprecated
  public static void a(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(View paramView, ColorStateList paramColorStateList)
  {
    int j = 1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setBackgroundTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramView.getBackground();
        i = j;
        if (paramView.getBackgroundTintList() == null)
        {
          i = j;
          if (paramView.getBackgroundTintMode() == null) {
            i = 0;
          }
        }
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramColorStateList);
        }
      }
    }
    while (!(paramView instanceof ab))
    {
      int i;
      return;
    }
    ((ab)paramView).setSupportBackgroundTintList(paramColorStateList);
  }
  
  public static void a(View paramView, PorterDuff.Mode paramMode)
  {
    int j = 1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setBackgroundTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramView.getBackground();
        i = j;
        if (paramView.getBackgroundTintList() == null)
        {
          i = j;
          if (paramView.getBackgroundTintMode() == null) {
            i = 0;
          }
        }
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramMode);
        }
      }
    }
    while (!(paramView instanceof ab))
    {
      int i;
      return;
    }
    ((ab)paramView).setSupportBackgroundTintMode(paramMode);
  }
  
  public static void a(View paramView, Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramView.setClipBounds(paramRect);
    }
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    paramView.setBackground(paramDrawable);
  }
  
  public static void a(View paramView, a parama)
  {
    paramView.onInitializeAccessibilityNodeInfo(parama.a);
  }
  
  public static void a(View paramView, aa paramaa)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramView.setPointerIcon((PointerIcon)paramaa.a);
    }
  }
  
  public static void a(View paramView, b paramb)
  {
    if (paramb != null) {}
    for (paramb = paramb.a;; paramb = null)
    {
      paramView.setAccessibilityDelegate(paramb);
      return;
    }
  }
  
  public static void a(View paramView, y paramy)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramy != null) {
        paramView.setOnApplyWindowInsetsListener(new ad(paramy));
      }
    }
    else {
      return;
    }
    paramView.setOnApplyWindowInsetsListener(null);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }
  
  public static void a(View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setTransitionName(paramString);
      return;
    }
    if (d == null) {
      d = new WeakHashMap();
    }
    d.put(paramView, paramString);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    paramView.setHasTransientState(paramBoolean);
  }
  
  @Deprecated
  public static boolean a(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
  
  public static boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    return paramView.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public static boolean a(View paramView, KeyEvent paramKeyEvent)
  {
    Object localObject1 = null;
    if (Build.VERSION.SDK_INT < 28)
    {
      paramView = af.a(paramView);
      Object localObject2 = paramView.a;
      if ((localObject2 == null) || (((WeakReference)localObject2).get() != paramKeyEvent))
      {
        paramView.a = new WeakReference(paramKeyEvent);
        localObject2 = paramView.a();
        paramView = (View)localObject1;
        if (paramKeyEvent.getAction() == 1)
        {
          int i = ((SparseArray)localObject2).indexOfKey(paramKeyEvent.getKeyCode());
          paramView = (View)localObject1;
          if (i >= 0)
          {
            paramView = (WeakReference)((SparseArray)localObject2).valueAt(i);
            ((SparseArray)localObject2).removeAt(i);
          }
        }
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = (WeakReference)((SparseArray)localObject2).get(paramKeyEvent.getKeyCode());
        }
        if (localObject1 != null)
        {
          paramView = (View)((WeakReference)localObject1).get();
          if ((paramView != null) && (L(paramView))) {
            af.b(paramView);
          }
          return true;
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  public static bf b(View paramView, bf parambf)
  {
    Object localObject = parambf;
    if (Build.VERSION.SDK_INT >= 21)
    {
      parambf = (WindowInsets)bf.a(parambf);
      localObject = paramView.dispatchApplyWindowInsets(parambf);
      paramView = parambf;
      if (localObject != parambf) {
        paramView = new WindowInsets((WindowInsets)localObject);
      }
      localObject = bf.a(paramView);
    }
    return (bf)localObject;
  }
  
  public static void b(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setImportantForAutofill(8);
    }
  }
  
  @Deprecated
  public static void b(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  public static void b(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 19)
    {
      int i = paramInt;
      if (paramInt == 4) {
        i = 2;
      }
      paramView.setImportantForAccessibility(i);
      return;
    }
    paramView.setImportantForAccessibility(paramInt);
  }
  
  static boolean b(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      af localaf = af.a(paramView);
      if (paramKeyEvent.getAction() != 0) {}
      int i;
      Object localObject;
      do
      {
        paramView = localaf.a(paramView, paramKeyEvent);
        if (paramKeyEvent.getAction() == 0)
        {
          i = paramKeyEvent.getKeyCode();
          if ((paramView != null) && (!KeyEvent.isModifierKey(i))) {
            localaf.a().put(i, new WeakReference(paramView));
          }
        }
        return paramView != null;
        localObject = localaf.b;
        if (localObject != null) {
          ((WeakHashMap)localObject).clear();
        }
      } while (af.c.isEmpty());
      for (;;)
      {
        synchronized (af.c)
        {
          if (localaf.b == null) {
            break label231;
          }
          i = af.c.size() - 1;
          if (i >= 0)
          {
            localObject = (View)((WeakReference)af.c.get(i)).get();
            if (localObject != null)
            {
              localaf.b.put(localObject, Boolean.TRUE);
              localObject = ((View)localObject).getParent();
              if (!(localObject instanceof View))
              {
                i -= 1;
                continue;
              }
              localaf.b.put((View)localObject, Boolean.TRUE);
              localObject = ((ViewParent)localObject).getParent();
              continue;
            }
            af.c.remove(i);
          }
        }
        break;
        label231:
        localaf.b = new WeakHashMap();
      }
    }
    return false;
  }
  
  @Deprecated
  public static void c(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
  
  @Deprecated
  public static void c(View paramView, int paramInt)
  {
    paramView.setLayerType(paramInt, null);
  }
  
  public static boolean c(View paramView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((a) || (b == null)) {}
    try
    {
      Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
      b = localField;
      localField.setAccessible(true);
      return false;
    }
    finally
    {
      try
      {
        paramView = b.get(paramView);
        bool1 = bool2;
        if (paramView != null) {
          bool1 = true;
        }
        return bool1;
      }
      finally
      {
        a = true;
      }
      paramView = finally;
      a = true;
      return false;
    }
  }
  
  @Deprecated
  public static void d(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
  
  public static void d(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramView.setAccessibilityLiveRegion(paramInt);
    }
  }
  
  public static boolean d(View paramView)
  {
    return paramView.hasTransientState();
  }
  
  public static void e(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }
  
  @Deprecated
  public static void e(View paramView, float paramFloat)
  {
    paramView.setPivotX(paramFloat);
  }
  
  public static void e(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.offsetTopAndBottom(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Rect localRect = a();
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      }
      for (boolean bool = localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;; bool = false)
      {
        h(paramView, paramInt);
        if ((!bool) || (!localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
          break;
        }
        ((View)localViewParent).invalidate(localRect);
        return;
      }
    }
    h(paramView, paramInt);
  }
  
  public static int f(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }
  
  @Deprecated
  public static void f(View paramView, float paramFloat)
  {
    paramView.setPivotY(paramFloat);
  }
  
  public static void f(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.offsetLeftAndRight(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Rect localRect = a();
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      }
      for (boolean bool = localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;; bool = false)
      {
        i(paramView, paramInt);
        if ((!bool) || (!localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
          break;
        }
        ((View)localViewParent).invalidate(localRect);
        return;
      }
    }
    i(paramView, paramInt);
  }
  
  @Deprecated
  public static float g(View paramView)
  {
    return paramView.getAlpha();
  }
  
  public static void g(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setElevation(paramFloat);
    }
  }
  
  public static void g(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.setScrollIndicators(paramInt, 3);
    }
  }
  
  public static int h(View paramView)
  {
    if (Build.VERSION.SDK_INT < 17) {
      return 0;
    }
    return paramView.getLayoutDirection();
  }
  
  private static void h(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    if (paramView.getVisibility() == 0)
    {
      O(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        O((View)paramView);
      }
    }
  }
  
  public static void i(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      paramView.setLayoutDirection(0);
    }
  }
  
  private static void i(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
    if (paramView.getVisibility() == 0)
    {
      O(paramView);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        O((View)paramView);
      }
    }
  }
  
  public static ViewParent j(View paramView)
  {
    return paramView.getParentForAccessibility();
  }
  
  @Deprecated
  public static int k(View paramView)
  {
    return paramView.getMeasuredWidthAndState();
  }
  
  @Deprecated
  public static int l(View paramView)
  {
    return paramView.getMeasuredHeightAndState();
  }
  
  public static int m(View paramView)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 0;
    }
    return paramView.getAccessibilityLiveRegion();
  }
  
  public static int n(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getPaddingStart();
    }
    return paramView.getPaddingLeft();
  }
  
  public static int o(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramView.getPaddingEnd();
    }
    return paramView.getPaddingRight();
  }
  
  @Deprecated
  public static float p(View paramView)
  {
    return paramView.getTranslationX();
  }
  
  @Deprecated
  public static float q(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public static int r(View paramView)
  {
    return paramView.getMinimumWidth();
  }
  
  public static int s(View paramView)
  {
    return paramView.getMinimumHeight();
  }
  
  public static az t(View paramView)
  {
    if (e == null) {
      e = new WeakHashMap();
    }
    az localaz2 = (az)e.get(paramView);
    az localaz1 = localaz2;
    if (localaz2 == null)
    {
      localaz1 = new az(paramView);
      e.put(paramView, localaz1);
    }
    return localaz1;
  }
  
  public static float u(View paramView)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return 0.0F;
    }
    return paramView.getElevation();
  }
  
  public static String v(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getTransitionName();
    }
    if (d != null) {
      return (String)d.get(paramView);
    }
    return null;
  }
  
  public static int w(View paramView)
  {
    return paramView.getWindowSystemUiVisibility();
  }
  
  public static void x(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      paramView.requestApplyInsets();
      return;
    }
    paramView.requestFitSystemWindows();
  }
  
  public static boolean y(View paramView)
  {
    return paramView.getFitsSystemWindows();
  }
  
  @Deprecated
  public static void z(View paramView)
  {
    paramView.setFitsSystemWindows(true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */