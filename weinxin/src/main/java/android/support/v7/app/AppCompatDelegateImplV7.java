package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.u;
import android.support.v4.view.ae;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.ap;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.a.a.c;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.j;
import android.support.v7.a.a.k;
import android.support.v7.view.b.a;
import android.support.v7.view.d;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.view.menu.e.a;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.l.a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.a;
import android.support.v7.widget.am;
import android.support.v7.widget.ar;
import android.support.v7.widget.at;
import android.support.v7.widget.x;
import android.support.v7.widget.x.a;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

class AppCompatDelegateImplV7
  extends e
  implements android.support.v4.view.k, f.a
{
  private TextView Fy;
  android.support.v7.widget.t GM;
  private a GN;
  private d GO;
  android.support.v7.view.b GP;
  ActionBarContextView GQ;
  PopupWindow GR;
  Runnable GS;
  ai GT = null;
  private boolean GU;
  ViewGroup GV;
  private View GW;
  private boolean GX;
  private boolean GY;
  private boolean GZ;
  private PanelFeatureState[] Ha;
  private PanelFeatureState Hb;
  private boolean Hc;
  public boolean Hd;
  public int He;
  private final Runnable Hf = new Runnable()
  {
    public final void run()
    {
      if ((AppCompatDelegateImplV7.this.He & 0x1) != 0) {
        AppCompatDelegateImplV7.this.av(0);
      }
      if ((AppCompatDelegateImplV7.this.He & 0x1000) != 0) {
        AppCompatDelegateImplV7.this.av(108);
      }
      AppCompatDelegateImplV7.this.Hd = false;
      AppCompatDelegateImplV7.this.He = 0;
    }
  };
  private boolean Hg;
  private j Hh;
  private Rect hd;
  private Rect he;
  
  AppCompatDelegateImplV7(Context paramContext, Window paramWindow, c paramc)
  {
    super(paramContext, paramWindow, paramc);
  }
  
  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int k = -1;
    if ((paramPanelFeatureState.DR) || (this.GD)) {}
    Object localObject1;
    int i;
    label115:
    label120:
    label124:
    label126:
    Object localObject2;
    label266:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramPanelFeatureState.Hm == 0)
          {
            localObject1 = this.mContext;
            if ((((Context)localObject1).getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label115;
            }
            i = 1;
            if (((Context)localObject1).getApplicationInfo().targetSdkVersion < 11) {
              break label120;
            }
          }
          for (int j = 1;; j = 0)
          {
            if ((i != 0) && (j != 0)) {
              break label124;
            }
            localObject1 = this.Fe.getCallback();
            if ((localObject1 == null) || (((Window.Callback)localObject1).onMenuOpened(paramPanelFeatureState.Hm, paramPanelFeatureState.Hq))) {
              break label126;
            }
            a(paramPanelFeatureState, true);
            return;
            i = 0;
            break;
          }
        }
        localObject1 = (WindowManager)this.mContext.getSystemService("window");
      } while ((localObject1 == null) || (!b(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.Hn != null) && (!paramPanelFeatureState.Hw)) {
        break label826;
      }
      if (paramPanelFeatureState.Hn != null) {
        break label581;
      }
      localObject2 = cV();
      TypedValue localTypedValue = new TypedValue();
      paramKeyEvent = ((Context)localObject2).getResources().newTheme();
      paramKeyEvent.setTo(((Context)localObject2).getTheme());
      paramKeyEvent.resolveAttribute(a.a.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        paramKeyEvent.applyStyle(localTypedValue.resourceId, true);
      }
      paramKeyEvent.resolveAttribute(a.a.II, localTypedValue, true);
      if (localTypedValue.resourceId == 0) {
        break;
      }
      paramKeyEvent.applyStyle(localTypedValue.resourceId, true);
      localObject2 = new d((Context)localObject2, 0);
      ((Context)localObject2).getTheme().setTo(paramKeyEvent);
      paramPanelFeatureState.Hs = ((Context)localObject2);
      paramKeyEvent = ((Context)localObject2).obtainStyledAttributes(a.k.bl);
      paramPanelFeatureState.background = paramKeyEvent.getResourceId(a.k.LI, 0);
      paramPanelFeatureState.windowAnimations = paramKeyEvent.getResourceId(a.k.LG, 0);
      paramKeyEvent.recycle();
      paramPanelFeatureState.Hn = new c(paramPanelFeatureState.Hs);
      paramPanelFeatureState.gravity = 81;
    } while (paramPanelFeatureState.Hn == null);
    label359:
    if (paramPanelFeatureState.Hp != null)
    {
      paramPanelFeatureState.Ho = paramPanelFeatureState.Hp;
      i = 1;
      label376:
      if (i == 0) {
        break label799;
      }
      if (paramPanelFeatureState.Ho == null) {
        break label821;
      }
      if (paramPanelFeatureState.Hp == null) {
        break label801;
      }
      i = 1;
      label396:
      if (i == 0) {
        break label824;
      }
      paramKeyEvent = paramPanelFeatureState.Ho.getLayoutParams();
      if (paramKeyEvent != null) {
        break label862;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label581:
    label796:
    label799:
    label801:
    label821:
    label824:
    label826:
    label862:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.Hn.setBackgroundResource(i);
      localObject2 = paramPanelFeatureState.Ho.getParent();
      if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
        ((ViewGroup)localObject2).removeView(paramPanelFeatureState.Ho);
      }
      paramPanelFeatureState.Hn.addView(paramPanelFeatureState.Ho, paramKeyEvent);
      if (!paramPanelFeatureState.Ho.hasFocus()) {
        paramPanelFeatureState.Ho.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.Hu = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.gravity;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
        ((WindowManager)localObject1).addView(paramPanelFeatureState.Hn, paramKeyEvent);
        paramPanelFeatureState.DR = true;
        return;
        paramKeyEvent.applyStyle(a.j.KV, true);
        break label266;
        if ((!paramPanelFeatureState.Hw) || (paramPanelFeatureState.Hn.getChildCount() <= 0)) {
          break label359;
        }
        paramPanelFeatureState.Hn.removeAllViews();
        break label359;
        if (paramPanelFeatureState.Hq != null)
        {
          if (this.GO == null) {
            this.GO = new d();
          }
          paramKeyEvent = this.GO;
          if (paramPanelFeatureState.Hq == null) {}
          for (paramKeyEvent = null;; paramKeyEvent = paramKeyEvent.Qi)
          {
            paramPanelFeatureState.Ho = ((View)paramKeyEvent);
            if (paramPanelFeatureState.Ho == null) {
              break label796;
            }
            i = 1;
            break;
            if (paramPanelFeatureState.Hr == null)
            {
              paramPanelFeatureState.Hr = new android.support.v7.view.menu.e(paramPanelFeatureState.Hs, a.h.KJ);
              paramPanelFeatureState.Hr.dV = paramKeyEvent;
              paramPanelFeatureState.Hq.a(paramPanelFeatureState.Hr);
            }
            paramKeyEvent = paramPanelFeatureState.Hr;
            localObject2 = paramPanelFeatureState.Hn;
            if (paramKeyEvent.Qi == null)
            {
              paramKeyEvent.Qi = ((ExpandedMenuView)paramKeyEvent.Du.inflate(a.h.KG, (ViewGroup)localObject2, false));
              if (paramKeyEvent.Ql == null) {
                paramKeyEvent.Ql = new e.a(paramKeyEvent);
              }
              paramKeyEvent.Qi.setAdapter(paramKeyEvent.Ql);
              paramKeyEvent.Qi.setOnItemClickListener(paramKeyEvent);
            }
          }
        }
        i = 0;
        break label376;
        break;
        if (paramPanelFeatureState.Hr.getAdapter().getCount() > 0)
        {
          i = 1;
          break label396;
        }
        i = 0;
        break label396;
        break;
        if (paramPanelFeatureState.Hp != null)
        {
          paramKeyEvent = paramPanelFeatureState.Hp.getLayoutParams();
          if (paramKeyEvent != null)
          {
            i = k;
            if (paramKeyEvent.width == -1) {
              continue;
            }
          }
        }
        i = -2;
      }
    }
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.isSystem()) {}
    while (((!paramPanelFeatureState.Ht) && (!b(paramPanelFeatureState, paramKeyEvent))) || (paramPanelFeatureState.Hq == null)) {
      return false;
    }
    return paramPanelFeatureState.Hq.performShortcut(paramInt, paramKeyEvent, 1);
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.GD) {
      return false;
    }
    if (paramPanelFeatureState.Ht) {
      return true;
    }
    if ((this.Hb != null) && (this.Hb != paramPanelFeatureState)) {
      a(this.Hb, false);
    }
    Window.Callback localCallback = this.Fe.getCallback();
    if (localCallback != null) {
      paramPanelFeatureState.Hp = localCallback.onCreatePanelView(paramPanelFeatureState.Hm);
    }
    int i;
    label89:
    Context localContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if ((paramPanelFeatureState.Hm == 0) || (paramPanelFeatureState.Hm == 108))
    {
      i = 1;
      if ((i != 0) && (this.GM != null)) {
        this.GM.dV();
      }
      if ((paramPanelFeatureState.Hp != null) || ((i != 0) && ((this.Gx instanceof k)))) {
        break label624;
      }
      if ((paramPanelFeatureState.Hq != null) && (!paramPanelFeatureState.Hx)) {
        break label494;
      }
      if (paramPanelFeatureState.Hq == null)
      {
        localContext = this.mContext;
        if (((paramPanelFeatureState.Hm != 0) && (paramPanelFeatureState.Hm != 108)) || (this.GM == null)) {
          break label652;
        }
        localTypedValue = new TypedValue();
        localTheme = localContext.getTheme();
        localTheme.resolveAttribute(a.a.actionBarTheme, localTypedValue, true);
        if (localTypedValue.resourceId == 0) {
          break label471;
        }
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
        label256:
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        if (localObject2 == null) {
          break label652;
        }
        localObject1 = new d(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new f((Context)localObject1);
      ((f)localObject1).a(this);
      paramPanelFeatureState.e((f)localObject1);
      if (paramPanelFeatureState.Hq == null) {
        break;
      }
      if ((i != 0) && (this.GM != null))
      {
        if (this.GN == null) {
          this.GN = new a();
        }
        this.GM.a(paramPanelFeatureState.Hq, this.GN);
      }
      paramPanelFeatureState.Hq.dv();
      if (!localCallback.onCreatePanelMenu(paramPanelFeatureState.Hm, paramPanelFeatureState.Hq))
      {
        paramPanelFeatureState.e(null);
        if ((i == 0) || (this.GM == null)) {
          break;
        }
        this.GM.a(null, this.GN);
        return false;
        i = 0;
        break label89;
        label471:
        localTheme.resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
        localObject1 = null;
        break label256;
      }
      paramPanelFeatureState.Hx = false;
      label494:
      paramPanelFeatureState.Hq.dv();
      if (paramPanelFeatureState.Hy != null)
      {
        paramPanelFeatureState.Hq.f(paramPanelFeatureState.Hy);
        paramPanelFeatureState.Hy = null;
      }
      if (!localCallback.onPreparePanel(0, paramPanelFeatureState.Hp, paramPanelFeatureState.Hq))
      {
        if ((i != 0) && (this.GM != null)) {
          this.GM.a(null, this.GN);
        }
        paramPanelFeatureState.Hq.dw();
        return false;
      }
      if (paramKeyEvent != null)
      {
        i = paramKeyEvent.getDeviceId();
        if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
          break label646;
        }
      }
      label624:
      label646:
      for (boolean bool = true;; bool = false)
      {
        paramPanelFeatureState.Hv = bool;
        paramPanelFeatureState.Hq.setQwertyMode(paramPanelFeatureState.Hv);
        paramPanelFeatureState.Hq.dw();
        paramPanelFeatureState.Ht = true;
        paramPanelFeatureState.Hu = false;
        this.Hb = paramPanelFeatureState;
        return true;
        i = -1;
        break;
      }
      label652:
      localObject1 = localContext;
    }
  }
  
  private void cW()
  {
    Object localObject1;
    if (!this.GU)
    {
      localObject1 = this.mContext.obtainStyledAttributes(a.k.bl);
      if (!((TypedArray)localObject1).hasValue(a.k.LJ))
      {
        ((TypedArray)localObject1).recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      }
      if (((TypedArray)localObject1).getBoolean(a.k.LS, false))
      {
        requestWindowFeature(1);
        if (((TypedArray)localObject1).getBoolean(a.k.LK, false)) {
          requestWindowFeature(109);
        }
        if (((TypedArray)localObject1).getBoolean(a.k.LL, false)) {
          requestWindowFeature(10);
        }
        this.GB = ((TypedArray)localObject1).getBoolean(a.k.LH, false);
        ((TypedArray)localObject1).recycle();
        this.Fe.getDecorView();
        localObject1 = LayoutInflater.from(this.mContext);
        if (this.GC) {
          break label459;
        }
        if (!this.GB) {
          break label288;
        }
        localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(a.h.KF, null);
        this.Gz = false;
        this.Gy = false;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.Gy + ", windowActionBarOverlay: " + this.Gz + ", android:windowIsFloating: " + this.GB + ", windowActionModeOverlay: " + this.GA + ", windowNoTitle: " + this.GC + " }");
        if (!((TypedArray)localObject1).getBoolean(a.k.LJ, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label288:
        if (!this.Gy) {
          break label1134;
        }
        localObject1 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(a.a.actionBarTheme, (TypedValue)localObject1, true);
        if (((TypedValue)localObject1).resourceId != 0) {}
        for (localObject1 = new d(this.mContext, ((TypedValue)localObject1).resourceId);; localObject1 = this.mContext)
        {
          localObject1 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(a.h.KO, null);
          this.GM = ((android.support.v7.widget.t)((ViewGroup)localObject1).findViewById(a.f.JZ));
          this.GM.b(this.Fe.getCallback());
          if (this.Gz) {
            this.GM.aA(109);
          }
          if (this.GX) {
            this.GM.aA(2);
          }
          if (this.GY) {
            this.GM.aA(5);
          }
          break;
        }
        label459:
        if (this.GA) {}
        for (localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(a.h.KN, null);; localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(a.h.KM, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label521;
          }
          z.b((View)localObject1, new android.support.v4.view.t()
          {
            public final ap a(View paramAnonymousView, ap paramAnonymousap)
            {
              int i = paramAnonymousap.getSystemWindowInsetTop();
              int j = AppCompatDelegateImplV7.this.aw(i);
              ap localap = paramAnonymousap;
              if (i != j) {
                localap = paramAnonymousap.d(paramAnonymousap.getSystemWindowInsetLeft(), j, paramAnonymousap.getSystemWindowInsetRight(), paramAnonymousap.getSystemWindowInsetBottom());
              }
              return z.a(paramAnonymousView, localap);
            }
          });
          break;
        }
        label521:
        ((x)localObject1).a(new x.a()
        {
          public final void d(Rect paramAnonymousRect)
          {
            paramAnonymousRect.top = AppCompatDelegateImplV7.this.aw(paramAnonymousRect.top);
          }
        });
        continue;
      }
      if (this.GM == null) {
        this.Fy = ((TextView)((ViewGroup)localObject1).findViewById(a.f.title));
      }
      at.bx((View)localObject1);
      Object localObject2 = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(a.f.JM);
      ViewGroup localViewGroup = (ViewGroup)this.Fe.findViewById(16908290);
      if (localViewGroup != null)
      {
        while (localViewGroup.getChildCount() > 0)
        {
          View localView = localViewGroup.getChildAt(0);
          localViewGroup.removeViewAt(0);
          ((ContentFrameLayout)localObject2).addView(localView);
        }
        localViewGroup.setId(-1);
        ((ContentFrameLayout)localObject2).setId(16908290);
        if ((localViewGroup instanceof FrameLayout)) {
          ((FrameLayout)localViewGroup).setForeground(null);
        }
      }
      this.Fe.setContentView((View)localObject1);
      ((ContentFrameLayout)localObject2).VX = new ContentFrameLayout.a()
      {
        public final void onDetachedFromWindow()
        {
          Object localObject = AppCompatDelegateImplV7.this;
          if (((AppCompatDelegateImplV7)localObject).GM != null) {
            ((AppCompatDelegateImplV7)localObject).GM.dW();
          }
          if (((AppCompatDelegateImplV7)localObject).GR != null)
          {
            ((AppCompatDelegateImplV7)localObject).Fe.getDecorView().removeCallbacks(((AppCompatDelegateImplV7)localObject).GS);
            if (!((AppCompatDelegateImplV7)localObject).GR.isShowing()) {}
          }
          try
          {
            ((AppCompatDelegateImplV7)localObject).GR.dismiss();
            ((AppCompatDelegateImplV7)localObject).GR = null;
            ((AppCompatDelegateImplV7)localObject).cX();
            localObject = ((AppCompatDelegateImplV7)localObject).au(0);
            if ((localObject != null) && (((AppCompatDelegateImplV7.PanelFeatureState)localObject).Hq != null)) {
              ((AppCompatDelegateImplV7.PanelFeatureState)localObject).Hq.close();
            }
            return;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;) {}
          }
        }
      };
      this.GV = ((ViewGroup)localObject1);
      if ((this.Gu instanceof Activity)) {}
      for (localObject1 = ((Activity)this.Gu).getTitle();; localObject1 = this.uI)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          f((CharSequence)localObject1);
        }
        localObject1 = (ContentFrameLayout)this.GV.findViewById(16908290);
        localObject2 = this.Fe.getDecorView();
        int i = ((View)localObject2).getPaddingLeft();
        int j = ((View)localObject2).getPaddingTop();
        int k = ((View)localObject2).getPaddingRight();
        int m = ((View)localObject2).getPaddingBottom();
        ((ContentFrameLayout)localObject1).VW.set(i, j, k, m);
        if (z.aj((View)localObject1)) {
          ((ContentFrameLayout)localObject1).requestLayout();
        }
        localObject2 = this.mContext.obtainStyledAttributes(a.k.bl);
        i = a.k.LQ;
        if (((ContentFrameLayout)localObject1).VQ == null) {
          ((ContentFrameLayout)localObject1).VQ = new TypedValue();
        }
        ((TypedArray)localObject2).getValue(i, ((ContentFrameLayout)localObject1).VQ);
        i = a.k.LR;
        if (((ContentFrameLayout)localObject1).VR == null) {
          ((ContentFrameLayout)localObject1).VR = new TypedValue();
        }
        ((TypedArray)localObject2).getValue(i, ((ContentFrameLayout)localObject1).VR);
        if (((TypedArray)localObject2).hasValue(a.k.LO))
        {
          i = a.k.LO;
          if (((ContentFrameLayout)localObject1).VS == null) {
            ((ContentFrameLayout)localObject1).VS = new TypedValue();
          }
          ((TypedArray)localObject2).getValue(i, ((ContentFrameLayout)localObject1).VS);
        }
        if (((TypedArray)localObject2).hasValue(a.k.LP))
        {
          i = a.k.LP;
          if (((ContentFrameLayout)localObject1).VT == null) {
            ((ContentFrameLayout)localObject1).VT = new TypedValue();
          }
          ((TypedArray)localObject2).getValue(i, ((ContentFrameLayout)localObject1).VT);
        }
        if (((TypedArray)localObject2).hasValue(a.k.LM))
        {
          i = a.k.LM;
          if (((ContentFrameLayout)localObject1).VU == null) {
            ((ContentFrameLayout)localObject1).VU = new TypedValue();
          }
          ((TypedArray)localObject2).getValue(i, ((ContentFrameLayout)localObject1).VU);
        }
        if (((TypedArray)localObject2).hasValue(a.k.LN))
        {
          i = a.k.LN;
          if (((ContentFrameLayout)localObject1).VV == null) {
            ((ContentFrameLayout)localObject1).VV = new TypedValue();
          }
          ((TypedArray)localObject2).getValue(i, ((ContentFrameLayout)localObject1).VV);
        }
        ((TypedArray)localObject2).recycle();
        ((ContentFrameLayout)localObject1).requestLayout();
        this.GU = true;
        localObject1 = au(0);
        if ((!this.GD) && ((localObject1 == null) || (((PanelFeatureState)localObject1).Hq == null))) {
          invalidatePanelMenu(108);
        }
        return;
      }
      label1134:
      localObject1 = null;
    }
  }
  
  private void cY()
  {
    if (this.GU) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    this.He |= 1 << paramInt;
    if (!this.Hd)
    {
      z.a(this.Fe.getDecorView(), this.Hf);
      this.Hd = true;
    }
  }
  
  public final PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.Ha;
    int i;
    int j;
    if (arrayOfPanelFeatureState != null)
    {
      i = arrayOfPanelFeatureState.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label57;
      }
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.Hq == paramMenu))
      {
        return localPanelFeatureState;
        i = 0;
        break;
      }
      j += 1;
    }
    label57:
    return null;
  }
  
  View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((this.Gu instanceof LayoutInflater.Factory))
    {
      paramString = ((LayoutInflater.Factory)this.Gu).onCreateView(paramString, paramContext, paramAttributeSet);
      if (paramString != null) {
        return paramString;
      }
    }
    return null;
  }
  
  public final void a(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < this.Ha.length) {
            localPanelFeatureState = this.Ha[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.Hq;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).DR)) {}
    while (this.GD) {
      return;
    }
    this.Gu.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  public final void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.Hm == 0) && (this.GM != null) && (this.GM.isOverflowMenuShowing())) {
      c(paramPanelFeatureState.Hq);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.DR) && (paramPanelFeatureState.Hn != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.Hn);
        if (paramBoolean) {
          a(paramPanelFeatureState.Hm, paramPanelFeatureState, null);
        }
      }
      paramPanelFeatureState.Ht = false;
      paramPanelFeatureState.Hu = false;
      paramPanelFeatureState.DR = false;
      paramPanelFeatureState.Ho = null;
      paramPanelFeatureState.Hw = true;
    } while (this.Hb != paramPanelFeatureState);
    this.Hb = null;
  }
  
  public final boolean a(f paramf, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = this.Fe.getCallback();
    if ((localCallback != null) && (!this.GD))
    {
      paramf = a(paramf.dC());
      if (paramf != null) {
        return localCallback.onMenuItemSelected(paramf.Hm, paramMenuItem);
      }
    }
    return false;
  }
  
  public final void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    cW();
    ((ViewGroup)this.GV.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.Gu.onContentChanged();
  }
  
  final void ar(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = cP();
      if (localObject != null) {
        ((ActionBar)localObject).y(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localObject = au(paramInt);
    } while (!((PanelFeatureState)localObject).DR);
    a((PanelFeatureState)localObject, false);
  }
  
  final boolean as(int paramInt)
  {
    if (paramInt == 108)
    {
      ActionBar localActionBar = cP();
      if (localActionBar != null) {
        localActionBar.y(true);
      }
      return true;
    }
    return false;
  }
  
  final PanelFeatureState au(int paramInt)
  {
    Object localObject2 = this.Ha;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.Ha = ((PanelFeatureState[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
      return (PanelFeatureState)localObject2;
    }
    return (PanelFeatureState)localObject2;
  }
  
  public final void av(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = au(paramInt);
    if (localPanelFeatureState.Hq != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.Hq.e(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.Hy = localBundle;
      }
      localPanelFeatureState.Hq.dv();
      localPanelFeatureState.Hq.clear();
    }
    localPanelFeatureState.Hx = true;
    localPanelFeatureState.Hw = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.GM != null))
    {
      localPanelFeatureState = au(0);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.Ht = false;
        b(localPanelFeatureState, null);
      }
    }
  }
  
  public final int aw(int paramInt)
  {
    int j = 1;
    int k = 1;
    int m = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.GQ != null) && ((this.GQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.GQ.getLayoutParams();
      if (this.GQ.isShown())
      {
        if (this.hd == null)
        {
          this.hd = new Rect();
          this.he = new Rect();
        }
        localObject2 = this.hd;
        Rect localRect = this.he;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        at.a(this.GV, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label355;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.GW != null) {
            break label279;
          }
          this.GW = new View(this.mContext);
          this.GW.setBackgroundColor(this.mContext.getResources().getColor(a.c.IP));
          this.GV.addView(this.GW, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label201:
          if (this.GW == null) {
            break label317;
          }
          label208:
          j = paramInt;
          if (!this.GA)
          {
            j = paramInt;
            if (k != 0) {
              j = 0;
            }
          }
          paramInt = j;
          j = i;
          i = k;
          label233:
          if (j != 0) {
            this.GQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.GW != null)
      {
        localObject1 = this.GW;
        if (i == 0) {
          break label342;
        }
      }
      label279:
      label317:
      label342:
      for (i = m;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        return paramInt;
        i = 0;
        break;
        localObject2 = this.GW.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.GW.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 1;
        break label201;
        k = 0;
        break label208;
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == 0) {
          break label348;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        i = 0;
        break label233;
      }
      label348:
      j = 0;
      i = 0;
      break label233;
      label355:
      i = 0;
      break label201;
      i = 0;
    }
  }
  
  public final void b(f paramf)
  {
    if ((this.GM != null) && (this.GM.dT()) && ((!ae.b(ViewConfiguration.get(this.mContext))) || (this.GM.dU())))
    {
      paramf = this.Fe.getCallback();
      if (!this.GM.isOverflowMenuShowing()) {
        if ((paramf != null) && (!this.GD))
        {
          if ((this.Hd) && ((this.He & 0x1) != 0))
          {
            this.Fe.getDecorView().removeCallbacks(this.Hf);
            this.Hf.run();
          }
          PanelFeatureState localPanelFeatureState = au(0);
          if ((localPanelFeatureState.Hq != null) && (!localPanelFeatureState.Hx) && (paramf.onPreparePanel(0, localPanelFeatureState.Hp, localPanelFeatureState.Hq)))
          {
            paramf.onMenuOpened(108, localPanelFeatureState.Hq);
            this.GM.showOverflowMenu();
          }
        }
      }
      do
      {
        return;
        this.GM.hideOverflowMenu();
      } while (this.GD);
      paramf.onPanelClosed(108, au(0).Hq);
      return;
    }
    paramf = au(0);
    paramf.Hw = true;
    a(paramf, false);
    a(paramf, null);
  }
  
  public final void c(f paramf)
  {
    if (this.GZ) {
      return;
    }
    this.GZ = true;
    this.GM.dW();
    Window.Callback localCallback = this.Fe.getCallback();
    if ((localCallback != null) && (!this.GD)) {
      localCallback.onPanelClosed(108, paramf);
    }
    this.GZ = false;
  }
  
  public final void cQ()
  {
    cW();
  }
  
  public final void cR()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      android.support.v4.view.h.a(localLayoutInflater, this);
      return;
    }
    android.support.v4.view.h.a(localLayoutInflater);
  }
  
  public final void cU()
  {
    cW();
    if ((!this.Gy) || (this.Gx != null)) {}
    for (;;)
    {
      return;
      if ((this.Gu instanceof Activity)) {
        this.Gx = new n((Activity)this.Gu, this.Gz);
      }
      while (this.Gx != null)
      {
        this.Gx.w(this.Hg);
        return;
        if ((this.Gu instanceof Dialog)) {
          this.Gx = new n((Dialog)this.Gu);
        }
      }
    }
  }
  
  public final void cX()
  {
    if (this.GT != null) {
      this.GT.cancel();
    }
  }
  
  final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 82) && (this.Gu.dispatchKeyEvent(paramKeyEvent))) {}
    int i;
    label180:
    do
    {
      int j;
      do
      {
        do
        {
          return true;
          j = paramKeyEvent.getKeyCode();
          if (paramKeyEvent.getAction() == 0) {}
          for (i = 1; i != 0; i = 0) {
            switch (j)
            {
            default: 
              if (Build.VERSION.SDK_INT < 11) {
                onKeyShortcut(j, paramKeyEvent);
              }
              return false;
            }
          }
        } while (paramKeyEvent.getRepeatCount() != 0);
        localPanelFeatureState = au(0);
      } while (localPanelFeatureState.DR);
      b(localPanelFeatureState, paramKeyEvent);
      return true;
      if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
      for (bool = true;; bool = false)
      {
        this.Hc = bool;
        break;
      }
      switch (j)
      {
      default: 
        return false;
      }
    } while (this.GP != null);
    PanelFeatureState localPanelFeatureState = au(0);
    if ((this.GM != null) && (this.GM.dT()) && (!ae.b(ViewConfiguration.get(this.mContext)))) {
      if (!this.GM.isOverflowMenuShowing())
      {
        if ((this.GD) || (!b(localPanelFeatureState, paramKeyEvent))) {
          break label483;
        }
        bool = this.GM.showOverflowMenu();
      }
    }
    label268:
    while (bool)
    {
      paramKeyEvent = (AudioManager)this.mContext.getSystemService("audio");
      if (paramKeyEvent == null) {
        break;
      }
      paramKeyEvent.playSoundEffect(0);
      return true;
      bool = this.GM.hideOverflowMenu();
      continue;
      if ((!localPanelFeatureState.DR) && (!localPanelFeatureState.Hu)) {
        break label345;
      }
      bool = localPanelFeatureState.DR;
      a(localPanelFeatureState, true);
    }
    label345:
    if (localPanelFeatureState.Ht)
    {
      if (!localPanelFeatureState.Hx) {
        break label489;
      }
      localPanelFeatureState.Ht = false;
    }
    label483:
    label489:
    for (boolean bool = b(localPanelFeatureState, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        a(localPanelFeatureState, paramKeyEvent);
        bool = true;
        break label268;
        bool = this.Hc;
        this.Hc = false;
        paramKeyEvent = au(0);
        if ((paramKeyEvent != null) && (paramKeyEvent.DR))
        {
          if (bool) {
            break;
          }
          a(paramKeyEvent, true);
          return true;
        }
        if (this.GP != null)
        {
          this.GP.finish();
          i = 1;
        }
        while (i != 0)
        {
          return true;
          paramKeyEvent = cP();
          if ((paramKeyEvent != null) && (paramKeyEvent.collapseActionView())) {
            i = 1;
          } else {
            i = 0;
          }
        }
        break label180;
      }
      bool = false;
      break label268;
    }
  }
  
  final void f(CharSequence paramCharSequence)
  {
    if (this.GM != null) {
      this.GM.e(paramCharSequence);
    }
    do
    {
      return;
      if (this.Gx != null)
      {
        this.Gx.e(paramCharSequence);
        return;
      }
    } while (this.Fy == null);
    this.Fy.setText(paramCharSequence);
  }
  
  public final View findViewById(int paramInt)
  {
    cW();
    return this.Fe.findViewById(paramInt);
  }
  
  public final void invalidateOptionsMenu()
  {
    ActionBar localActionBar = cP();
    if ((localActionBar != null) && (localActionBar.cM())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.Gy) && (this.GU))
    {
      ActionBar localActionBar = cP();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    cS();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (((this.Gu instanceof Activity)) && (u.b((Activity)this.Gu) != null))
    {
      paramBundle = this.Gx;
      if (paramBundle == null) {
        this.Hg = true;
      }
    }
    else
    {
      return;
    }
    paramBundle.w(true);
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    int j = 0;
    Object localObject1 = a(paramString, paramContext, paramAttributeSet);
    if (localObject1 != null)
    {
      paramString = (String)localObject1;
      return paramString;
    }
    boolean bool1;
    label34:
    int i;
    label79:
    Object localObject2;
    boolean bool2;
    if (Build.VERSION.SDK_INT < 21)
    {
      bool1 = true;
      if (this.Hh == null) {
        this.Hh = new j();
      }
      if (!bool1) {
        break label425;
      }
      localObject1 = (ViewParent)paramView;
      if (localObject1 != null) {
        break label361;
      }
      i = 0;
      if (i == 0) {
        break label425;
      }
      i = 1;
      localObject2 = this.Hh;
      bool2 = ar.hd();
      if ((i == 0) || (paramView == null)) {
        break label845;
      }
    }
    label248:
    label251:
    label320:
    label361:
    label425:
    label845:
    for (paramView = paramView.getContext();; paramView = paramContext)
    {
      paramView = j.a(paramView, paramAttributeSet, bool1, true);
      localObject1 = paramView;
      if (bool2) {
        localObject1 = am.p(paramView);
      }
      paramView = null;
      switch (paramString.hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          if ((paramView == null) && (paramContext != localObject1)) {
            paramView = ((j)localObject2).a((Context)localObject1, paramString, paramAttributeSet);
          }
          break;
        }
        break;
      }
      for (;;)
      {
        paramString = paramView;
        if (paramView == null) {
          break;
        }
        j.a(paramView, paramAttributeSet);
        return paramView;
        bool1 = false;
        break label34;
        localObject2 = this.Fe.getDecorView();
        for (;;)
        {
          if (localObject1 == null)
          {
            i = 1;
            break;
          }
          if ((localObject1 == localObject2) || (!(localObject1 instanceof View)) || (z.al((View)localObject1)))
          {
            i = 0;
            break;
          }
          localObject1 = ((ViewParent)localObject1).getParent();
        }
        i = 0;
        break label79;
        if (!paramString.equals("TextView")) {
          break label248;
        }
        i = j;
        break label251;
        if (!paramString.equals("ImageView")) {
          break label248;
        }
        i = 1;
        break label251;
        if (!paramString.equals("Button")) {
          break label248;
        }
        i = 2;
        break label251;
        if (!paramString.equals("EditText")) {
          break label248;
        }
        i = 3;
        break label251;
        if (!paramString.equals("Spinner")) {
          break label248;
        }
        i = 4;
        break label251;
        if (!paramString.equals("ImageButton")) {
          break label248;
        }
        i = 5;
        break label251;
        if (!paramString.equals("CheckBox")) {
          break label248;
        }
        i = 6;
        break label251;
        if (!paramString.equals("RadioButton")) {
          break label248;
        }
        i = 7;
        break label251;
        if (!paramString.equals("CheckedTextView")) {
          break label248;
        }
        i = 8;
        break label251;
        if (!paramString.equals("AutoCompleteTextView")) {
          break label248;
        }
        i = 9;
        break label251;
        if (!paramString.equals("MultiAutoCompleteTextView")) {
          break label248;
        }
        i = 10;
        break label251;
        if (!paramString.equals("RatingBar")) {
          break label248;
        }
        i = 11;
        break label251;
        if (!paramString.equals("SeekBar")) {
          break label248;
        }
        i = 12;
        break label251;
        paramView = new AppCompatTextView((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatImageView((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatButton((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatEditText((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatSpinner((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatImageButton((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatCheckBox((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatRadioButton((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatCheckedTextView((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatAutoCompleteTextView((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatMultiAutoCompleteTextView((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatRatingBar((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatSeekBar((Context)localObject1, paramAttributeSet);
        break label320;
      }
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if (this.Gx != null) {
      this.Gx.onDestroy();
    }
  }
  
  final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = cP();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent))) {}
    boolean bool;
    do
    {
      do
      {
        return true;
        if ((this.Hb == null) || (!a(this.Hb, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          break;
        }
      } while (this.Hb == null);
      this.Hb.Hu = true;
      return true;
      if (this.Hb != null) {
        break;
      }
      localObject = au(0);
      b((PanelFeatureState)localObject, paramKeyEvent);
      bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((PanelFeatureState)localObject).Ht = false;
    } while (bool);
    return false;
  }
  
  public final void onPostResume()
  {
    ActionBar localActionBar = cP();
    if (localActionBar != null) {
      localActionBar.x(true);
    }
  }
  
  public final void onStop()
  {
    ActionBar localActionBar = cP();
    if (localActionBar != null) {
      localActionBar.x(false);
    }
  }
  
  public final boolean requestWindowFeature(int paramInt)
  {
    int i;
    if (paramInt == 8) {
      i = 108;
    }
    while ((this.GC) && (i == 108))
    {
      return false;
      i = paramInt;
      if (paramInt == 9) {
        i = 109;
      }
    }
    if ((this.Gy) && (i == 1)) {
      this.Gy = false;
    }
    switch (i)
    {
    default: 
      return this.Fe.requestFeature(i);
    case 108: 
      cY();
      this.Gy = true;
      return true;
    case 109: 
      cY();
      this.Gz = true;
      return true;
    case 10: 
      cY();
      this.GA = true;
      return true;
    case 2: 
      cY();
      this.GX = true;
      return true;
    case 5: 
      cY();
      this.GY = true;
      return true;
    }
    cY();
    this.GC = true;
    return true;
  }
  
  public final void setContentView(int paramInt)
  {
    cW();
    ViewGroup localViewGroup = (ViewGroup)this.GV.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.Gu.onContentChanged();
  }
  
  public final void setContentView(View paramView)
  {
    cW();
    ViewGroup localViewGroup = (ViewGroup)this.GV.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.Gu.onContentChanged();
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    cW();
    ViewGroup localViewGroup = (ViewGroup)this.GV.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.Gu.onContentChanged();
  }
  
  private static final class PanelFeatureState
  {
    boolean DR;
    int Hm;
    ViewGroup Hn;
    View Ho;
    View Hp;
    f Hq;
    android.support.v7.view.menu.e Hr;
    Context Hs;
    boolean Ht;
    boolean Hu;
    public boolean Hv;
    boolean Hw;
    boolean Hx;
    Bundle Hy;
    int background;
    int gravity;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.Hm = paramInt;
      this.Hw = false;
    }
    
    final void e(f paramf)
    {
      if (paramf == this.Hq) {}
      do
      {
        return;
        if (this.Hq != null) {
          this.Hq.b(this.Hr);
        }
        this.Hq = paramf;
      } while ((paramf == null) || (this.Hr == null));
      paramf.a(this.Hr);
    }
    
    private static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c() {});
      boolean DR;
      int Hm;
      Bundle iR;
      
      public static SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        boolean bool = true;
        SavedState localSavedState = new SavedState();
        localSavedState.Hm = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          localSavedState.DR = bool;
          if (localSavedState.DR) {
            localSavedState.iR = paramParcel.readBundle(paramClassLoader);
          }
          return localSavedState;
          bool = false;
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.Hm);
        if (this.DR) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if (this.DR) {
            paramParcel.writeBundle(this.iR);
          }
          return;
        }
      }
    }
  }
  
  private final class a
    implements l.a
  {
    public a() {}
    
    public final void a(f paramf, boolean paramBoolean)
    {
      AppCompatDelegateImplV7.this.c(paramf);
    }
    
    public final boolean d(f paramf)
    {
      Window.Callback localCallback = AppCompatDelegateImplV7.this.Fe.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramf);
      }
      return true;
    }
  }
  
  final class b
    implements b.a
  {
    private b.a Hk;
    
    public b(b.a parama)
    {
      this.Hk = parama;
    }
    
    public final void a(android.support.v7.view.b paramb)
    {
      this.Hk.a(paramb);
      if (AppCompatDelegateImplV7.this.GR != null) {
        AppCompatDelegateImplV7.this.Fe.getDecorView().removeCallbacks(AppCompatDelegateImplV7.this.GS);
      }
      if (AppCompatDelegateImplV7.this.GQ != null)
      {
        AppCompatDelegateImplV7.this.cX();
        AppCompatDelegateImplV7.this.GT = z.V(AppCompatDelegateImplV7.this.GQ).p(0.0F);
        AppCompatDelegateImplV7.this.GT.a(new an()
        {
          public final void q(View paramAnonymousView)
          {
            AppCompatDelegateImplV7.this.GQ.setVisibility(8);
            if (AppCompatDelegateImplV7.this.GR != null) {
              AppCompatDelegateImplV7.this.GR.dismiss();
            }
            for (;;)
            {
              AppCompatDelegateImplV7.this.GQ.removeAllViews();
              AppCompatDelegateImplV7.this.GT.a(null);
              AppCompatDelegateImplV7.this.GT = null;
              return;
              if ((AppCompatDelegateImplV7.this.GQ.getParent() instanceof View)) {
                z.Z((View)AppCompatDelegateImplV7.this.GQ.getParent());
              }
            }
          }
        });
      }
      AppCompatDelegateImplV7.this.GP = null;
    }
    
    public final boolean a(android.support.v7.view.b paramb, Menu paramMenu)
    {
      return this.Hk.a(paramb, paramMenu);
    }
    
    public final boolean a(android.support.v7.view.b paramb, MenuItem paramMenuItem)
    {
      return this.Hk.a(paramb, paramMenuItem);
    }
    
    public final boolean b(android.support.v7.view.b paramb, Menu paramMenu)
    {
      return this.Hk.b(paramb, paramMenu);
    }
  }
  
  private final class c
    extends ContentFrameLayout
  {
    public c(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImplV7.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if ((i < -5) || (j < -5) || (i > getWidth() + 5) || (j > getHeight() + 5)) {}
        for (i = 1; i != 0; i = 0)
        {
          paramMotionEvent = AppCompatDelegateImplV7.this;
          paramMotionEvent.a(paramMotionEvent.au(0), true);
          return true;
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public final void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(android.support.v7.widget.h.ey().a(getContext(), paramInt, false));
    }
  }
  
  private final class d
    implements l.a
  {
    public d() {}
    
    public final void a(f paramf, boolean paramBoolean)
    {
      f localf = paramf.dC();
      if (localf != paramf) {}
      for (int i = 1;; i = 0)
      {
        AppCompatDelegateImplV7 localAppCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
        if (i != 0) {
          paramf = localf;
        }
        paramf = localAppCompatDelegateImplV7.a(paramf);
        if (paramf != null)
        {
          if (i == 0) {
            break;
          }
          AppCompatDelegateImplV7.this.a(paramf.Hm, paramf, localf);
          AppCompatDelegateImplV7.this.a(paramf, true);
        }
        return;
      }
      AppCompatDelegateImplV7.this.a(paramf, paramBoolean);
    }
    
    public final boolean d(f paramf)
    {
      if ((paramf == null) && (AppCompatDelegateImplV7.this.Gy))
      {
        Window.Callback localCallback = AppCompatDelegateImplV7.this.Fe.getCallback();
        if ((localCallback != null) && (!AppCompatDelegateImplV7.this.GD)) {
          localCallback.onMenuOpened(108, paramf);
        }
      }
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/AppCompatDelegateImplV7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */