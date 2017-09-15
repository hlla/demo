package android.support.v7.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.view.menu.l.a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements r, t
{
  static final int[] xQ = { a.a.actionBarSize, 16842841 };
  private final s Dj;
  private u HI;
  private boolean Ix;
  private int Sa;
  public int Sb = 0;
  private ContentFrameLayout Sc;
  private ActionBarContainer Sd;
  private Drawable Se;
  private boolean Sf;
  public boolean Sg;
  public boolean Sh;
  private boolean Si;
  private int Sj;
  public int Sk;
  private final Rect Sl = new Rect();
  private final Rect Sm = new Rect();
  private final Rect Sn = new Rect();
  private final Rect So = new Rect();
  private final Rect Sp = new Rect();
  private final Rect Sq = new Rect();
  public a Sr;
  private final int Ss = 600;
  private q St;
  private ai Su;
  private final am Sv = new an()
  {
    public final void as(View paramAnonymousView)
    {
      ActionBarOverlayLayout.a(ActionBarOverlayLayout.this, null);
      ActionBarOverlayLayout.a(ActionBarOverlayLayout.this);
    }
    
    public final void q(View paramAnonymousView)
    {
      ActionBarOverlayLayout.a(ActionBarOverlayLayout.this, null);
      ActionBarOverlayLayout.a(ActionBarOverlayLayout.this);
    }
  };
  private final Runnable Sw = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.b(ActionBarOverlayLayout.this);
      ActionBarOverlayLayout.a(ActionBarOverlayLayout.this, z.V(ActionBarOverlayLayout.d(ActionBarOverlayLayout.this)).r(0.0F).a(ActionBarOverlayLayout.c(ActionBarOverlayLayout.this)));
    }
  };
  private final Runnable Sx = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.b(ActionBarOverlayLayout.this);
      ActionBarOverlayLayout.a(ActionBarOverlayLayout.this, z.V(ActionBarOverlayLayout.d(ActionBarOverlayLayout.this)).r(-ActionBarOverlayLayout.d(ActionBarOverlayLayout.this).getHeight()).a(ActionBarOverlayLayout.c(ActionBarOverlayLayout.this)));
    }
  };
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    this.Dj = new s(this);
  }
  
  private static boolean a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    boolean bool = false;
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramView.leftMargin != paramRect.left)
    {
      paramView.leftMargin = paramRect.left;
      bool = true;
    }
    if (paramView.topMargin != paramRect.top)
    {
      paramView.topMargin = paramRect.top;
      bool = true;
    }
    if (paramView.rightMargin != paramRect.right)
    {
      paramView.rightMargin = paramRect.right;
      bool = true;
    }
    if ((paramBoolean) && (paramView.bottomMargin != paramRect.bottom))
    {
      paramView.bottomMargin = paramRect.bottom;
      return true;
    }
    return bool;
  }
  
  private void az(int paramInt)
  {
    dS();
    paramInt = Math.max(0, Math.min(paramInt, this.Sd.getHeight()));
    z.c(this.Sd, -paramInt);
  }
  
  public static void dP() {}
  
  private void dQ()
  {
    if (this.Sc == null)
    {
      this.Sc = ((ContentFrameLayout)findViewById(a.f.JM));
      this.Sd = ((ActionBarContainer)findViewById(a.f.JN));
      localObject = findViewById(a.f.JL);
      if (!(localObject instanceof u)) {
        break label61;
      }
    }
    for (Object localObject = (u)localObject;; localObject = ((Toolbar)localObject).gZ())
    {
      this.HI = ((u)localObject);
      return;
      label61:
      if (!(localObject instanceof Toolbar)) {
        break;
      }
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + localObject.getClass().getSimpleName());
  }
  
  private void dS()
  {
    removeCallbacks(this.Sw);
    removeCallbacks(this.Sx);
    if (this.Su != null) {
      this.Su.cancel();
    }
  }
  
  private void init(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(xQ);
    this.Sa = localTypedArray.getDimensionPixelSize(0, 0);
    this.Se = localTypedArray.getDrawable(1);
    if (this.Se == null)
    {
      bool1 = true;
      setWillNotDraw(bool1);
      localTypedArray.recycle();
      if (paramContext.getApplicationInfo().targetSdkVersion >= 19) {
        break label91;
      }
    }
    label91:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Sf = bool1;
      this.St = q.a(paramContext, null);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(Menu paramMenu, l.a parama)
  {
    dQ();
    this.HI.a(paramMenu, parama);
  }
  
  public final void aA(int paramInt)
  {
    boolean bool = true;
    dQ();
    switch (paramInt)
    {
    case 2: 
    case 5: 
    default: 
      return;
    }
    this.Sg = true;
    if (getContext().getApplicationInfo().targetSdkVersion < 19) {}
    for (;;)
    {
      this.Sf = bool;
      return;
      bool = false;
    }
  }
  
  public final void b(Window.Callback paramCallback)
  {
    dQ();
    this.HI.b(paramCallback);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final int dR()
  {
    if (this.Sd != null) {
      return -(int)z.S(this.Sd);
    }
    return 0;
  }
  
  public final boolean dT()
  {
    dQ();
    return this.HI.dT();
  }
  
  public final boolean dU()
  {
    dQ();
    return this.HI.dU();
  }
  
  public final void dV()
  {
    dQ();
    this.HI.dV();
  }
  
  public final void dW()
  {
    dQ();
    this.HI.dismissPopupMenus();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.Se != null) && (!this.Sf)) {
      if (this.Sd.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i = (int)(this.Sd.getBottom() + z.S(this.Sd) + 0.5F);; i = 0)
    {
      this.Se.setBounds(0, i, getWidth(), this.Se.getIntrinsicHeight() + i);
      this.Se.draw(paramCanvas);
      return;
    }
  }
  
  public final void e(CharSequence paramCharSequence)
  {
    dQ();
    this.HI.e(paramCharSequence);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    dQ();
    z.Y(this);
    boolean bool = a(this.Sd, paramRect, false);
    this.So.set(paramRect);
    at.a(this, this.So, this.Sl);
    if (!this.Sm.equals(this.Sl))
    {
      this.Sm.set(this.Sl);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getNestedScrollAxes()
  {
    return this.Dj.xn;
  }
  
  public final boolean hideOverflowMenu()
  {
    dQ();
    return this.HI.hideOverflowMenu();
  }
  
  public final boolean isOverflowMenuShowing()
  {
    dQ();
    return this.HI.isOverflowMenuShowing();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    init(getContext());
    z.Z(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dS();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    getPaddingRight();
    paramInt4 = getPaddingTop();
    getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i = localView.getMeasuredWidth();
        int j = localView.getMeasuredHeight();
        int k = localLayoutParams.leftMargin + paramInt3;
        int m = localLayoutParams.topMargin + paramInt4;
        localView.layout(k, m, i + k, j + m);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    dQ();
    measureChildWithMargins(this.Sd, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.Sd.getLayoutParams();
    int i1 = Math.max(0, this.Sd.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i = this.Sd.getMeasuredHeight();
    int j = ((LayoutParams)localObject).topMargin;
    int n = Math.max(0, ((LayoutParams)localObject).bottomMargin + (i + j));
    int m = at.combineMeasuredStates(0, z.N(this.Sd));
    int k;
    if ((z.Y(this) & 0x100) != 0)
    {
      j = 1;
      if (j == 0) {
        break label444;
      }
      k = this.Sa;
      i = k;
      if (this.Sh)
      {
        i = k;
        if (this.Sd.RJ != null) {
          i = k + this.Sa;
        }
      }
    }
    for (;;)
    {
      label153:
      this.Sn.set(this.Sl);
      this.Sp.set(this.So);
      if ((!this.Sg) && (j == 0))
      {
        localObject = this.Sn;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.Sn;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        a(this.Sc, this.Sn, true);
        if (!this.Sq.equals(this.Sp))
        {
          this.Sq.set(this.Sp);
          this.Sc.e(this.Sp);
        }
        measureChildWithMargins(this.Sc, paramInt1, 0, paramInt2, 0);
        localObject = (LayoutParams)this.Sc.getLayoutParams();
        i = Math.max(i1, this.Sc.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
        j = this.Sc.getMeasuredHeight();
        k = ((LayoutParams)localObject).topMargin;
        j = Math.max(n, ((LayoutParams)localObject).bottomMargin + (j + k));
        k = at.combineMeasuredStates(m, z.N(this.Sc));
        m = getPaddingLeft();
        n = getPaddingRight();
        j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(z.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), z.resolveSizeAndState(j, paramInt2, k << 16));
        return;
        j = 0;
        break;
        label444:
        if (this.Sd.getVisibility() == 8) {
          break label506;
        }
        i = this.Sd.getMeasuredHeight();
        break label153;
        localObject = this.Sp;
        ((Rect)localObject).top = (i + ((Rect)localObject).top);
        localObject = this.Sp;
      }
      label506:
      i = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = 0;
    if ((!this.Ix) || (!paramBoolean)) {
      return false;
    }
    this.St.a(0, 0, (int)paramFloat2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    if (this.St.getFinalY() > this.Sd.getHeight()) {
      i = 1;
    }
    if (i != 0)
    {
      dS();
      this.Sx.run();
    }
    for (;;)
    {
      this.Si = true;
      return true;
      dS();
      this.Sw.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.Sj += paramInt2;
    az(this.Sj);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.Dj.xn = paramInt;
    this.Sj = dR();
    dS();
    if (this.Sr != null) {
      this.Sr.dc();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.Sd.getVisibility() != 0)) {
      return false;
    }
    return this.Ix;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.Ix) && (!this.Si))
    {
      if (this.Sj <= this.Sd.getHeight())
      {
        dS();
        postDelayed(this.Sw, 600L);
      }
    }
    else {
      return;
    }
    dS();
    postDelayed(this.Sx, 600L);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    dQ();
    int k = this.Sk;
    this.Sk = paramInt;
    int i;
    int j;
    if ((paramInt & 0x4) == 0)
    {
      i = 1;
      if ((paramInt & 0x100) == 0) {
        break label120;
      }
      j = 1;
      label49:
      if (this.Sr != null)
      {
        a locala = this.Sr;
        if (j != 0) {
          break label125;
        }
        label66:
        locala.A(bool);
        if ((i == 0) && (j != 0)) {
          break label131;
        }
        this.Sr.da();
      }
    }
    for (;;)
    {
      if ((((k ^ paramInt) & 0x100) != 0) && (this.Sr != null)) {
        z.Z(this);
      }
      return;
      i = 0;
      break;
      label120:
      j = 0;
      break label49;
      label125:
      bool = false;
      break label66;
      label131:
      this.Sr.db();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.Sb = paramInt;
    if (this.Sr != null) {
      this.Sr.onWindowVisibilityChanged(paramInt);
    }
  }
  
  public final void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.Ix)
    {
      this.Ix = paramBoolean;
      if (!paramBoolean)
      {
        dS();
        az(0);
      }
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    dQ();
    return this.HI.showOverflowMenu();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract void A(boolean paramBoolean);
    
    public abstract void da();
    
    public abstract void db();
    
    public abstract void dc();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/ActionBarOverlayLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */