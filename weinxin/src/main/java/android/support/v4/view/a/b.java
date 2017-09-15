package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class b
{
  public static final e zK = new j();
  public final Object zL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22)
    {
      zK = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      zK = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      zK = new i();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      zK = new h();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      zK = new g();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      zK = new f();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      zK = new d();
      return;
    }
  }
  
  public b(Object paramObject)
  {
    this.zL = paramObject;
  }
  
  public static b a(b paramb)
  {
    paramb = zK.l(paramb.zL);
    if (paramb != null) {
      return new b(paramb);
    }
    return null;
  }
  
  public final boolean a(a parama)
  {
    return zK.e(this.zL, parama.Ai);
  }
  
  public final void addAction(int paramInt)
  {
    zK.c(this.zL, paramInt);
  }
  
  public final void addChild(View paramView)
  {
    zK.c(this.zL, paramView);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.zL != null) {
          break;
        }
      } while (((b)paramObject).zL == null);
      return false;
    } while (this.zL.equals(((b)paramObject).zL));
    return false;
  }
  
  public final int getActions()
  {
    return zK.m(this.zL);
  }
  
  public final void getBoundsInParent(Rect paramRect)
  {
    zK.a(this.zL, paramRect);
  }
  
  public final void getBoundsInScreen(Rect paramRect)
  {
    zK.b(this.zL, paramRect);
  }
  
  public final CharSequence getClassName()
  {
    return zK.n(this.zL);
  }
  
  public final CharSequence getContentDescription()
  {
    return zK.o(this.zL);
  }
  
  public final CharSequence getPackageName()
  {
    return zK.p(this.zL);
  }
  
  public final int hashCode()
  {
    if (this.zL == null) {
      return 0;
    }
    return this.zL.hashCode();
  }
  
  public final boolean isAccessibilityFocused()
  {
    return zK.E(this.zL);
  }
  
  public final boolean isClickable()
  {
    return zK.t(this.zL);
  }
  
  public final boolean isEnabled()
  {
    return zK.u(this.zL);
  }
  
  public final boolean isFocusable()
  {
    return zK.v(this.zL);
  }
  
  public final boolean isFocused()
  {
    return zK.w(this.zL);
  }
  
  public final boolean isLongClickable()
  {
    return zK.x(this.zL);
  }
  
  public final boolean isSelected()
  {
    return zK.A(this.zL);
  }
  
  public final boolean isVisibleToUser()
  {
    return zK.D(this.zL);
  }
  
  public final void k(Object paramObject)
  {
    zK.g(this.zL, ((l)paramObject).zL);
  }
  
  public final void recycle()
  {
    zK.B(this.zL);
  }
  
  public final void setAccessibilityFocused(boolean paramBoolean)
  {
    zK.i(this.zL, paramBoolean);
  }
  
  public final void setBoundsInParent(Rect paramRect)
  {
    zK.c(this.zL, paramRect);
  }
  
  public final void setBoundsInScreen(Rect paramRect)
  {
    zK.d(this.zL, paramRect);
  }
  
  public final void setClassName(CharSequence paramCharSequence)
  {
    zK.b(this.zL, paramCharSequence);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    zK.a(this.zL, paramBoolean);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    zK.c(this.zL, paramCharSequence);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    zK.b(this.zL, paramBoolean);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    zK.c(this.zL, paramBoolean);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    zK.d(this.zL, paramBoolean);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    zK.e(this.zL, paramBoolean);
  }
  
  public final void setPackageName(CharSequence paramCharSequence)
  {
    zK.d(this.zL, paramCharSequence);
  }
  
  public final void setParent(View paramView)
  {
    zK.d(this.zL, paramView);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    zK.f(this.zL, paramBoolean);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    zK.g(this.zL, paramBoolean);
  }
  
  public final void setSource(View paramView)
  {
    zK.e(this.zL, paramView);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    zK.e(this.zL, paramCharSequence);
  }
  
  public final void setVisibleToUser(boolean paramBoolean)
  {
    zK.h(this.zL, paramBoolean);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Object localObject = new Rect();
    getBoundsInParent((Rect)localObject);
    localStringBuilder.append("; boundsInParent: " + localObject);
    getBoundsInScreen((Rect)localObject);
    localStringBuilder.append("; boundsInScreen: " + localObject);
    localStringBuilder.append("; packageName: ").append(getPackageName());
    localStringBuilder.append("; className: ").append(getClassName());
    localStringBuilder.append("; text: ").append(zK.q(this.zL));
    localStringBuilder.append("; contentDescription: ").append(getContentDescription());
    localStringBuilder.append("; viewId: ").append(zK.F(this.zL));
    localStringBuilder.append("; checkable: ").append(zK.r(this.zL));
    localStringBuilder.append("; checked: ").append(zK.s(this.zL));
    localStringBuilder.append("; focusable: ").append(isFocusable());
    localStringBuilder.append("; focused: ").append(isFocused());
    localStringBuilder.append("; selected: ").append(isSelected());
    localStringBuilder.append("; clickable: ").append(isClickable());
    localStringBuilder.append("; longClickable: ").append(isLongClickable());
    localStringBuilder.append("; enabled: ").append(isEnabled());
    localStringBuilder.append("; password: ").append(zK.y(this.zL));
    localStringBuilder.append("; scrollable: " + zK.z(this.zL));
    localStringBuilder.append("; [");
    int i = getActions();
    if (i != 0)
    {
      int j = 1 << Integer.numberOfTrailingZeros(i);
      i = (j ^ 0xFFFFFFFF) & i;
      switch (j)
      {
      default: 
        localObject = "ACTION_UNKNOWN";
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        if (i != 0) {
          localStringBuilder.append(", ");
        }
        break;
        localObject = "ACTION_FOCUS";
        continue;
        localObject = "ACTION_CLEAR_FOCUS";
        continue;
        localObject = "ACTION_SELECT";
        continue;
        localObject = "ACTION_CLEAR_SELECTION";
        continue;
        localObject = "ACTION_CLICK";
        continue;
        localObject = "ACTION_LONG_CLICK";
        continue;
        localObject = "ACTION_ACCESSIBILITY_FOCUS";
        continue;
        localObject = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        continue;
        localObject = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        continue;
        localObject = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        continue;
        localObject = "ACTION_NEXT_HTML_ELEMENT";
        continue;
        localObject = "ACTION_PREVIOUS_HTML_ELEMENT";
        continue;
        localObject = "ACTION_SCROLL_FORWARD";
        continue;
        localObject = "ACTION_SCROLL_BACKWARD";
        continue;
        localObject = "ACTION_CUT";
        continue;
        localObject = "ACTION_COPY";
        continue;
        localObject = "ACTION_PASTE";
        continue;
        localObject = "ACTION_SET_SELECTION";
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public static final a Aa = new a(16384);
    public static final a Ab = new a(32768);
    public static final a Ac = new a(65536);
    public static final a Ad = new a(131072);
    public static final a Ae = new a(262144);
    public static final a Af = new a(524288);
    public static final a Ag = new a(1048576);
    public static final a Ah = new a(2097152);
    public static final a zM = new a(1);
    public static final a zN = new a(2);
    public static final a zO = new a(4);
    public static final a zP = new a(8);
    public static final a zQ = new a(16);
    public static final a zR = new a(32);
    public static final a zS = new a(64);
    public static final a zT = new a(128);
    public static final a zU = new a(256);
    public static final a zV = new a(512);
    public static final a zW = new a(1024);
    public static final a zX = new a(2048);
    public static final a zY = new a(4096);
    public static final a zZ = new a(8192);
    public final Object Ai;
    
    private a(int paramInt)
    {
      this(b.zK.a(paramInt, null));
    }
    
    private a(Object paramObject)
    {
      this.Ai = paramObject;
    }
  }
  
  static class b
    extends b.i
  {
    public final Object a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, false);
    }
    
    public final Object a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, false, 0);
    }
    
    public final Object a(int paramInt, CharSequence paramCharSequence)
    {
      return new AccessibilityNodeInfo.AccessibilityAction(paramInt, null);
    }
    
    public final void a(Object paramObject, CharSequence paramCharSequence)
    {
      ((AccessibilityNodeInfo)paramObject).setError(paramCharSequence);
    }
    
    public final boolean e(Object paramObject1, Object paramObject2)
    {
      return ((AccessibilityNodeInfo)paramObject1).removeAction((AccessibilityNodeInfo.AccessibilityAction)paramObject2);
    }
  }
  
  static final class c
    extends b.b
  {}
  
  static class d
    extends b.j
  {
    public final boolean A(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isSelected();
    }
    
    public final void B(Object paramObject)
    {
      ((AccessibilityNodeInfo)paramObject).recycle();
    }
    
    public final void a(Object paramObject, Rect paramRect)
    {
      ((AccessibilityNodeInfo)paramObject).getBoundsInParent(paramRect);
    }
    
    public final void a(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setClickable(paramBoolean);
    }
    
    public final void b(Object paramObject, Rect paramRect)
    {
      ((AccessibilityNodeInfo)paramObject).getBoundsInScreen(paramRect);
    }
    
    public final void b(Object paramObject, CharSequence paramCharSequence)
    {
      ((AccessibilityNodeInfo)paramObject).setClassName(paramCharSequence);
    }
    
    public final void b(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setEnabled(paramBoolean);
    }
    
    public final void c(Object paramObject, int paramInt)
    {
      ((AccessibilityNodeInfo)paramObject).addAction(paramInt);
    }
    
    public final void c(Object paramObject, Rect paramRect)
    {
      ((AccessibilityNodeInfo)paramObject).setBoundsInParent(paramRect);
    }
    
    public final void c(Object paramObject, View paramView)
    {
      ((AccessibilityNodeInfo)paramObject).addChild(paramView);
    }
    
    public final void c(Object paramObject, CharSequence paramCharSequence)
    {
      ((AccessibilityNodeInfo)paramObject).setContentDescription(paramCharSequence);
    }
    
    public final void c(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setFocusable(paramBoolean);
    }
    
    public final void d(Object paramObject, Rect paramRect)
    {
      ((AccessibilityNodeInfo)paramObject).setBoundsInScreen(paramRect);
    }
    
    public final void d(Object paramObject, View paramView)
    {
      ((AccessibilityNodeInfo)paramObject).setParent(paramView);
    }
    
    public final void d(Object paramObject, CharSequence paramCharSequence)
    {
      ((AccessibilityNodeInfo)paramObject).setPackageName(paramCharSequence);
    }
    
    public final void d(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setFocused(paramBoolean);
    }
    
    public final void e(Object paramObject, View paramView)
    {
      ((AccessibilityNodeInfo)paramObject).setSource(paramView);
    }
    
    public final void e(Object paramObject, CharSequence paramCharSequence)
    {
      ((AccessibilityNodeInfo)paramObject).setText(paramCharSequence);
    }
    
    public final void e(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setLongClickable(paramBoolean);
    }
    
    public final void f(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setScrollable(paramBoolean);
    }
    
    public final void g(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setSelected(paramBoolean);
    }
    
    public final Object l(Object paramObject)
    {
      return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)paramObject);
    }
    
    public final int m(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getActions();
    }
    
    public final CharSequence n(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getClassName();
    }
    
    public final CharSequence o(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getContentDescription();
    }
    
    public final CharSequence p(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getPackageName();
    }
    
    public final CharSequence q(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getText();
    }
    
    public final boolean r(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isCheckable();
    }
    
    public final boolean s(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isChecked();
    }
    
    public final boolean t(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isClickable();
    }
    
    public final boolean u(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isEnabled();
    }
    
    public final boolean v(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isFocusable();
    }
    
    public final boolean w(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isFocused();
    }
    
    public final boolean x(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isLongClickable();
    }
    
    public final boolean y(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isPassword();
    }
    
    public final boolean z(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isScrollable();
    }
  }
  
  public static abstract interface e
  {
    public abstract boolean A(Object paramObject);
    
    public abstract void B(Object paramObject);
    
    public abstract int C(Object paramObject);
    
    public abstract boolean D(Object paramObject);
    
    public abstract boolean E(Object paramObject);
    
    public abstract String F(Object paramObject);
    
    public abstract Object a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract Object a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);
    
    public abstract Object a(int paramInt, CharSequence paramCharSequence);
    
    public abstract void a(Object paramObject, Rect paramRect);
    
    public abstract void a(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void a(Object paramObject, boolean paramBoolean);
    
    public abstract void b(Object paramObject, Rect paramRect);
    
    public abstract void b(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void b(Object paramObject, boolean paramBoolean);
    
    public abstract void c(Object paramObject, int paramInt);
    
    public abstract void c(Object paramObject, Rect paramRect);
    
    public abstract void c(Object paramObject, View paramView);
    
    public abstract void c(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void c(Object paramObject, boolean paramBoolean);
    
    public abstract void d(Object paramObject, int paramInt);
    
    public abstract void d(Object paramObject, Rect paramRect);
    
    public abstract void d(Object paramObject, View paramView);
    
    public abstract void d(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void d(Object paramObject, boolean paramBoolean);
    
    public abstract void e(Object paramObject, View paramView);
    
    public abstract void e(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void e(Object paramObject, boolean paramBoolean);
    
    public abstract boolean e(Object paramObject1, Object paramObject2);
    
    public abstract void f(Object paramObject, View paramView);
    
    public abstract void f(Object paramObject1, Object paramObject2);
    
    public abstract void f(Object paramObject, boolean paramBoolean);
    
    public abstract void g(Object paramObject1, Object paramObject2);
    
    public abstract void g(Object paramObject, boolean paramBoolean);
    
    public abstract void h(Object paramObject, boolean paramBoolean);
    
    public abstract void i(Object paramObject, boolean paramBoolean);
    
    public abstract void j(Object paramObject, boolean paramBoolean);
    
    public abstract Object l(Object paramObject);
    
    public abstract int m(Object paramObject);
    
    public abstract CharSequence n(Object paramObject);
    
    public abstract CharSequence o(Object paramObject);
    
    public abstract CharSequence p(Object paramObject);
    
    public abstract CharSequence q(Object paramObject);
    
    public abstract boolean r(Object paramObject);
    
    public abstract boolean s(Object paramObject);
    
    public abstract boolean t(Object paramObject);
    
    public abstract boolean u(Object paramObject);
    
    public abstract boolean v(Object paramObject);
    
    public abstract boolean w(Object paramObject);
    
    public abstract boolean x(Object paramObject);
    
    public abstract boolean y(Object paramObject);
    
    public abstract boolean z(Object paramObject);
  }
  
  static class f
    extends b.d
  {
    public final int C(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getMovementGranularities();
    }
    
    public final boolean D(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isVisibleToUser();
    }
    
    public final boolean E(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isAccessibilityFocused();
    }
    
    public final void d(Object paramObject, int paramInt)
    {
      ((AccessibilityNodeInfo)paramObject).setMovementGranularities(paramInt);
    }
    
    public final void h(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setVisibleToUser(paramBoolean);
    }
    
    public final void i(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setAccessibilityFocused(paramBoolean);
    }
  }
  
  static class g
    extends b.f
  {
    public final void f(Object paramObject, View paramView)
    {
      ((AccessibilityNodeInfo)paramObject).setLabelFor(paramView);
    }
  }
  
  static class h
    extends b.g
  {
    public final String F(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getViewIdResourceName();
    }
  }
  
  static class i
    extends b.h
  {
    public Object a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
    }
    
    public Object a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, false);
    }
    
    public final void f(Object paramObject1, Object paramObject2)
    {
      ((AccessibilityNodeInfo)paramObject1).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)paramObject2);
    }
    
    public final void g(Object paramObject1, Object paramObject2)
    {
      ((AccessibilityNodeInfo)paramObject1).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)paramObject2);
    }
    
    public final void j(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setContentInvalid(true);
    }
  }
  
  static class j
    implements b.e
  {
    public boolean A(Object paramObject)
    {
      return false;
    }
    
    public void B(Object paramObject) {}
    
    public int C(Object paramObject)
    {
      return 0;
    }
    
    public boolean D(Object paramObject)
    {
      return false;
    }
    
    public boolean E(Object paramObject)
    {
      return false;
    }
    
    public String F(Object paramObject)
    {
      return null;
    }
    
    public Object a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return null;
    }
    
    public Object a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return null;
    }
    
    public Object a(int paramInt, CharSequence paramCharSequence)
    {
      return null;
    }
    
    public void a(Object paramObject, Rect paramRect) {}
    
    public void a(Object paramObject, CharSequence paramCharSequence) {}
    
    public void a(Object paramObject, boolean paramBoolean) {}
    
    public void b(Object paramObject, Rect paramRect) {}
    
    public void b(Object paramObject, CharSequence paramCharSequence) {}
    
    public void b(Object paramObject, boolean paramBoolean) {}
    
    public void c(Object paramObject, int paramInt) {}
    
    public void c(Object paramObject, Rect paramRect) {}
    
    public void c(Object paramObject, View paramView) {}
    
    public void c(Object paramObject, CharSequence paramCharSequence) {}
    
    public void c(Object paramObject, boolean paramBoolean) {}
    
    public void d(Object paramObject, int paramInt) {}
    
    public void d(Object paramObject, Rect paramRect) {}
    
    public void d(Object paramObject, View paramView) {}
    
    public void d(Object paramObject, CharSequence paramCharSequence) {}
    
    public void d(Object paramObject, boolean paramBoolean) {}
    
    public void e(Object paramObject, View paramView) {}
    
    public void e(Object paramObject, CharSequence paramCharSequence) {}
    
    public void e(Object paramObject, boolean paramBoolean) {}
    
    public boolean e(Object paramObject1, Object paramObject2)
    {
      return false;
    }
    
    public void f(Object paramObject, View paramView) {}
    
    public void f(Object paramObject1, Object paramObject2) {}
    
    public void f(Object paramObject, boolean paramBoolean) {}
    
    public void g(Object paramObject1, Object paramObject2) {}
    
    public void g(Object paramObject, boolean paramBoolean) {}
    
    public void h(Object paramObject, boolean paramBoolean) {}
    
    public void i(Object paramObject, boolean paramBoolean) {}
    
    public void j(Object paramObject, boolean paramBoolean) {}
    
    public Object l(Object paramObject)
    {
      return null;
    }
    
    public int m(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence n(Object paramObject)
    {
      return null;
    }
    
    public CharSequence o(Object paramObject)
    {
      return null;
    }
    
    public CharSequence p(Object paramObject)
    {
      return null;
    }
    
    public CharSequence q(Object paramObject)
    {
      return null;
    }
    
    public boolean r(Object paramObject)
    {
      return false;
    }
    
    public boolean s(Object paramObject)
    {
      return false;
    }
    
    public boolean t(Object paramObject)
    {
      return false;
    }
    
    public boolean u(Object paramObject)
    {
      return false;
    }
    
    public boolean v(Object paramObject)
    {
      return false;
    }
    
    public boolean w(Object paramObject)
    {
      return false;
    }
    
    public boolean x(Object paramObject)
    {
      return false;
    }
    
    public boolean y(Object paramObject)
    {
      return false;
    }
    
    public boolean z(Object paramObject)
    {
      return false;
    }
  }
  
  public static final class k
  {
    public final Object zL;
    
    public k(Object paramObject)
    {
      this.zL = paramObject;
    }
  }
  
  public static final class l
  {
    public final Object zL;
    
    private l(Object paramObject)
    {
      this.zL = paramObject;
    }
    
    public static l a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      return new l(b.zK.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, false));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */