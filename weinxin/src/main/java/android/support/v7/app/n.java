package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.support.v4.view.ao;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.k;
import android.support.v7.view.a;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class n
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final Interpolator Ia;
  private static final Interpolator Ib;
  private static final boolean Ic;
  public u HI;
  private boolean HL;
  private ArrayList<Object> HM = new ArrayList();
  final ao IA = new ao()
  {
    public final void bZ()
    {
      ((View)n.this.If.getParent()).invalidate();
    }
  };
  private Context Id;
  public ActionBarOverlayLayout Ie;
  public ActionBarContainer If;
  public ActionBarContextView Ig;
  public View Ih;
  public android.support.v7.widget.ai Ii;
  private int Ij = -1;
  private boolean Ik;
  a Il;
  b Im;
  b.a In;
  private boolean Io;
  private int Ip = 0;
  public boolean Iq = true;
  public boolean Ir;
  public boolean Is;
  private boolean It;
  private boolean Iu = true;
  public h Iv;
  private boolean Iw;
  boolean Ix;
  final am Iy = new an()
  {
    public final void q(View paramAnonymousView)
    {
      if ((n.this.Iq) && (n.this.Ih != null))
      {
        z.c(n.this.Ih, 0.0F);
        z.c(n.this.If, 0.0F);
      }
      n.this.If.setVisibility(8);
      n.this.If.J(false);
      n.this.Iv = null;
      paramAnonymousView = n.this;
      if (paramAnonymousView.In != null)
      {
        paramAnonymousView.In.a(paramAnonymousView.Im);
        paramAnonymousView.Im = null;
        paramAnonymousView.In = null;
      }
      if (n.this.Ie != null) {
        z.Z(n.this.Ie);
      }
    }
  };
  final am Iz = new an()
  {
    public final void q(View paramAnonymousView)
    {
      n.this.Iv = null;
      n.this.If.requestLayout();
    }
  };
  private ArrayList<Object> jT = new ArrayList();
  public Context mContext;
  private Dialog oL;
  private Activity qb;
  
  static
  {
    boolean bool2 = true;
    if (!n.class.desiredAssertionStatus())
    {
      bool1 = true;
      $assertionsDisabled = bool1;
      Ia = new AccelerateInterpolator();
      Ib = new DecelerateInterpolator();
      if (Build.VERSION.SDK_INT < 14) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Ic = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public n(Activity paramActivity, boolean paramBoolean)
  {
    this.qb = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    aJ(paramActivity);
    if (!paramBoolean) {
      this.Ih = paramActivity.findViewById(16908290);
    }
  }
  
  public n(Dialog paramDialog)
  {
    this.oL = paramDialog;
    aJ(paramDialog.getWindow().getDecorView());
  }
  
  private void B(boolean paramBoolean)
  {
    float f2;
    float f1;
    Object localObject1;
    Object localObject2;
    if (a(this.Ir, this.Is, this.It)) {
      if (!this.Iu)
      {
        this.Iu = true;
        if (this.Iv != null) {
          this.Iv.cancel();
        }
        this.If.setVisibility(0);
        if ((this.Ip != 0) || (!Ic) || ((!this.Iw) && (!paramBoolean))) {
          break label271;
        }
        z.c(this.If, 0.0F);
        f2 = -this.If.getHeight();
        f1 = f2;
        if (paramBoolean)
        {
          localObject1 = new int[2];
          Object tmp107_105 = localObject1;
          tmp107_105[0] = 0;
          Object tmp111_107 = tmp107_105;
          tmp111_107[1] = 0;
          tmp111_107;
          this.If.getLocationInWindow((int[])localObject1);
          f1 = f2 - localObject1[1];
        }
        z.c(this.If, f1);
        localObject1 = new h();
        localObject2 = z.V(this.If).r(0.0F);
        ((android.support.v4.view.ai)localObject2).a(this.IA);
        ((h)localObject1).a((android.support.v4.view.ai)localObject2);
        if ((this.Iq) && (this.Ih != null))
        {
          z.c(this.Ih, f1);
          ((h)localObject1).a(z.V(this.Ih).r(0.0F));
        }
        ((h)localObject1).c(Ib);
        ((h)localObject1).dk();
        ((h)localObject1).b(this.Iz);
        this.Iv = ((h)localObject1);
        ((h)localObject1).start();
        if (this.Ie != null) {
          z.Z(this.Ie);
        }
      }
    }
    label271:
    while (!this.Iu) {
      for (;;)
      {
        return;
        z.d(this.If, 1.0F);
        z.c(this.If, 0.0F);
        if ((this.Iq) && (this.Ih != null)) {
          z.c(this.Ih, 0.0F);
        }
        this.Iz.q(null);
      }
    }
    this.Iu = false;
    if (this.Iv != null) {
      this.Iv.cancel();
    }
    if ((this.Ip == 0) && (Ic) && ((this.Iw) || (paramBoolean)))
    {
      z.d(this.If, 1.0F);
      this.If.J(true);
      localObject1 = new h();
      f2 = -this.If.getHeight();
      f1 = f2;
      if (paramBoolean)
      {
        localObject2 = new int[2];
        Object tmp420_418 = localObject2;
        tmp420_418[0] = 0;
        Object tmp424_420 = tmp420_418;
        tmp424_420[1] = 0;
        tmp424_420;
        this.If.getLocationInWindow((int[])localObject2);
        f1 = f2 - localObject2[1];
      }
      localObject2 = z.V(this.If).r(f1);
      ((android.support.v4.view.ai)localObject2).a(this.IA);
      ((h)localObject1).a((android.support.v4.view.ai)localObject2);
      if ((this.Iq) && (this.Ih != null)) {
        ((h)localObject1).a(z.V(this.Ih).r(f1));
      }
      ((h)localObject1).c(Ia);
      ((h)localObject1).dk();
      ((h)localObject1).b(this.Iy);
      this.Iv = ((h)localObject1);
      ((h)localObject1).start();
      return;
    }
    this.Iy.q(null);
  }
  
  public static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void aJ(View paramView)
  {
    this.Ie = ((ActionBarOverlayLayout)paramView.findViewById(a.f.JZ));
    if (this.Ie != null)
    {
      localObject = this.Ie;
      ((ActionBarOverlayLayout)localObject).Sr = this;
      if (((ActionBarOverlayLayout)localObject).getWindowToken() != null)
      {
        ((ActionBarOverlayLayout)localObject).Sr.onWindowVisibilityChanged(((ActionBarOverlayLayout)localObject).Sb);
        if (((ActionBarOverlayLayout)localObject).Sk != 0)
        {
          ((ActionBarOverlayLayout)localObject).onWindowSystemUiVisibilityChanged(((ActionBarOverlayLayout)localObject).Sk);
          z.Z((View)localObject);
        }
      }
    }
    Object localObject = paramView.findViewById(a.f.JL);
    if ((localObject instanceof u)) {}
    for (localObject = (u)localObject;; localObject = ((Toolbar)localObject).gZ())
    {
      this.HI = ((u)localObject);
      this.Ig = ((ActionBarContextView)paramView.findViewById(a.f.JQ));
      this.If = ((ActionBarContainer)paramView.findViewById(a.f.JN));
      if ((this.HI != null) && (this.Ig != null) && (this.If != null)) {
        break label240;
      }
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
      if (!(localObject instanceof Toolbar)) {
        break;
      }
    }
    if ("Can't make a decor toolbar out of " + localObject != null) {}
    for (paramView = localObject.getClass().getSimpleName();; paramView = "null") {
      throw new IllegalStateException(paramView);
    }
    label240:
    this.mContext = this.HI.getContext();
    if ((this.HI.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.Ik = true;
      }
      paramView = a.n(this.mContext);
      paramView.df();
      z(paramView.de());
      paramView = this.mContext.obtainStyledAttributes(null, a.k.aV, a.a.actionBarStyle, 0);
      if (!paramView.getBoolean(a.k.Lh, false)) {
        break label365;
      }
      if (this.Ie.Sg) {
        break;
      }
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.Ix = true;
    this.Ie.setHideOnContentScrollEnabled(true);
    label365:
    i = paramView.getDimensionPixelSize(a.k.Lf, 0);
    if (i != 0) {
      setElevation(i);
    }
    paramView.recycle();
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.HI.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.Ik = true;
    }
    this.HI.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  private void z(boolean paramBoolean)
  {
    boolean bool = true;
    this.Io = paramBoolean;
    int i;
    label50:
    label83:
    Object localObject;
    if (!this.Io)
    {
      this.HI.b(null);
      this.If.a(this.Ii);
      if (this.HI.getNavigationMode() != 2) {
        break label160;
      }
      i = 1;
      if (this.Ii != null)
      {
        if (i == 0) {
          break label165;
        }
        this.Ii.setVisibility(0);
        if (this.Ie != null) {
          z.Z(this.Ie);
        }
      }
      localObject = this.HI;
      if ((this.Io) || (i == 0)) {
        break label177;
      }
      paramBoolean = true;
      label102:
      ((u)localObject).N(paramBoolean);
      localObject = this.Ie;
      if ((this.Io) || (i == 0)) {
        break label182;
      }
    }
    label160:
    label165:
    label177:
    label182:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ActionBarOverlayLayout)localObject).Sh = paramBoolean;
      return;
      this.If.a(null);
      this.HI.b(this.Ii);
      break;
      i = 0;
      break label50;
      this.Ii.setVisibility(8);
      break label83;
      paramBoolean = false;
      break label102;
    }
  }
  
  public final void A(boolean paramBoolean)
  {
    this.Iq = paramBoolean;
  }
  
  public final void C(boolean paramBoolean)
  {
    android.support.v4.view.ai localai2;
    android.support.v4.view.ai localai1;
    if (paramBoolean)
    {
      if (!this.It)
      {
        this.It = true;
        if (this.Ie != null) {
          ActionBarOverlayLayout.dP();
        }
        B(false);
      }
      if (!paramBoolean) {
        break label114;
      }
      localai2 = this.HI.c(4, 100L);
      localai1 = this.Ig.c(0, 200L);
    }
    for (;;)
    {
      h localh = new h();
      localh.a(localai2, localai1);
      localh.start();
      return;
      if (!this.It) {
        break;
      }
      this.It = false;
      if (this.Ie != null) {
        ActionBarOverlayLayout.dP();
      }
      B(false);
      break;
      label114:
      localai1 = this.HI.c(0, 200L);
      localai2 = this.Ig.c(8, 100L);
    }
  }
  
  public final b a(b.a parama)
  {
    if (this.Il != null) {
      this.Il.finish();
    }
    this.Ie.setHideOnContentScrollEnabled(false);
    this.Ig.dO();
    parama = new a(this.Ig.getContext(), parama);
    if (parama.dd())
    {
      parama.invalidate();
      this.Ig.c(parama);
      C(true);
      this.Ig.sendAccessibilityEvent(32);
      this.Il = parama;
      return parama;
    }
    return null;
  }
  
  public final void cJ()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void cK()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void cL()
  {
    setDisplayOptions(16, 16);
  }
  
  public final boolean collapseActionView()
  {
    if ((this.HI != null) && (this.HI.hasExpandedActionView()))
    {
      this.HI.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void da()
  {
    if (this.Is)
    {
      this.Is = false;
      B(true);
    }
  }
  
  public final void db()
  {
    if (!this.Is)
    {
      this.Is = true;
      B(true);
    }
  }
  
  public final void dc()
  {
    if (this.Iv != null)
    {
      this.Iv.cancel();
      this.Iv = null;
    }
  }
  
  public final void e(CharSequence paramCharSequence)
  {
    this.HI.e(paramCharSequence);
  }
  
  public final View getCustomView()
  {
    return this.HI.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.HI.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.If.getHeight();
  }
  
  public final Context getThemedContext()
  {
    int i;
    if (this.Id == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
      i = localTypedValue.resourceId;
      if (i == 0) {
        break label61;
      }
    }
    label61:
    for (this.Id = new ContextThemeWrapper(this.mContext, i);; this.Id = this.mContext) {
      return this.Id;
    }
  }
  
  public final CharSequence getTitle()
  {
    return this.HI.getTitle();
  }
  
  public final void hide()
  {
    if (!this.Ir)
    {
      this.Ir = true;
      B(false);
    }
  }
  
  public final boolean isShowing()
  {
    int i = this.If.getHeight();
    return (this.Iu) && ((i == 0) || (this.Ie.dR() < i));
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    z(a.n(this.mContext).de());
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.Ip = paramInt;
  }
  
  public final boolean requestFocus()
  {
    ViewGroup localViewGroup = this.HI.eI();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.If.l(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.HI.eI(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    this.HI.setCustomView(paramView);
  }
  
  public final void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      return;
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    if ((paramInt & 0x4) != 0) {
      this.Ik = true;
    }
    this.HI.setDisplayOptions(paramInt);
  }
  
  public final void setElevation(float paramFloat)
  {
    z.g(this.If, paramFloat);
  }
  
  public final void setIcon(int paramInt)
  {
    this.HI.setIcon(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.HI.setLogo(paramDrawable);
  }
  
  public final void show()
  {
    if (this.Ir)
    {
      this.Ir = false;
      B(false);
    }
  }
  
  public final void w(boolean paramBoolean)
  {
    if (!this.Ik) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public final void x(boolean paramBoolean)
  {
    this.Iw = paramBoolean;
    if ((!paramBoolean) && (this.Iv != null)) {
      this.Iv.cancel();
    }
  }
  
  public final void y(boolean paramBoolean)
  {
    if (paramBoolean == this.HL) {}
    for (;;)
    {
      return;
      this.HL = paramBoolean;
      int j = this.HM.size();
      int i = 0;
      while (i < j)
      {
        this.HM.get(i);
        i += 1;
      }
    }
  }
  
  public final class a
    extends b
    implements f.a
  {
    private final Context IC;
    private b.a IE;
    private WeakReference<View> IF;
    private final f dW;
    
    public a(Context paramContext, b.a parama)
    {
      this.IC = paramContext;
      this.IE = parama;
      this$1 = new f(paramContext);
      n.this.Qx = 1;
      this.dW = n.this;
      this.dW.a(this);
    }
    
    public final boolean a(f paramf, MenuItem paramMenuItem)
    {
      if (this.IE != null) {
        return this.IE.a(this, paramMenuItem);
      }
      return false;
    }
    
    public final void b(f paramf)
    {
      if (this.IE == null) {
        return;
      }
      invalidate();
      n.this.Ig.showOverflowMenu();
    }
    
    public final boolean dd()
    {
      this.dW.dv();
      try
      {
        boolean bool = this.IE.a(this, this.dW);
        return bool;
      }
      finally
      {
        this.dW.dw();
      }
    }
    
    public final void finish()
    {
      if (n.this.Il != this) {
        return;
      }
      if (!n.a(n.this.Ir, n.this.Is, false))
      {
        n.this.Im = this;
        n.this.In = this.IE;
      }
      for (;;)
      {
        this.IE = null;
        n.this.C(false);
        n.this.Ig.dN();
        n.this.HI.eI().sendAccessibilityEvent(32);
        n.this.Ie.setHideOnContentScrollEnabled(n.this.Ix);
        n.this.Il = null;
        return;
        this.IE.a(this);
      }
    }
    
    public final View getCustomView()
    {
      if (this.IF != null) {
        return (View)this.IF.get();
      }
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.dW;
    }
    
    public final MenuInflater getMenuInflater()
    {
      return new g(this.IC);
    }
    
    public final CharSequence getSubtitle()
    {
      return n.this.Ig.uJ;
    }
    
    public final CharSequence getTitle()
    {
      return n.this.Ig.uI;
    }
    
    public final void invalidate()
    {
      if (n.this.Il != this) {
        return;
      }
      this.dW.dv();
      try
      {
        this.IE.b(this, this.dW);
        return;
      }
      finally
      {
        this.dW.dw();
      }
    }
    
    public final boolean isTitleOptional()
    {
      return n.this.Ig.RW;
    }
    
    public final void setCustomView(View paramView)
    {
      n.this.Ig.setCustomView(paramView);
      this.IF = new WeakReference(paramView);
    }
    
    public final void setSubtitle(int paramInt)
    {
      setSubtitle(n.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      n.this.Ig.setSubtitle(paramCharSequence);
    }
    
    public final void setTitle(int paramInt)
    {
      setTitle(n.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      n.this.Ig.setTitle(paramCharSequence);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      super.setTitleOptionalHint(paramBoolean);
      n.this.Ig.K(paramBoolean);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */