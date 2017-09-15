package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.a.a;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.design.a.i;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public final class Snackbar
{
  public static final Handler ji = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public final boolean handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return false;
      case 0: 
        paramAnonymousMessage = (Snackbar)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.jk.getParent() == null)
        {
          localObject = paramAnonymousMessage.jk.getLayoutParams();
          if ((localObject instanceof CoordinatorLayout.d))
          {
            Snackbar.a locala = new Snackbar.a(paramAnonymousMessage);
            locala.jL = s.l(0.1F);
            locala.jM = s.l(0.6F);
            locala.jJ = 0;
            locala.jG = new Snackbar.3(paramAnonymousMessage);
            ((CoordinatorLayout.d)localObject).a(locala);
          }
          paramAnonymousMessage.jj.addView(paramAnonymousMessage.jk);
        }
        paramAnonymousMessage.jk.ju = new Snackbar.4(paramAnonymousMessage);
        if (z.aj(paramAnonymousMessage.jk)) {
          if (paramAnonymousMessage.aj()) {
            paramAnonymousMessage.ag();
          }
        }
        for (;;)
        {
          return true;
          paramAnonymousMessage.ah();
          continue;
          paramAnonymousMessage.jk.jt = new Snackbar.5(paramAnonymousMessage);
        }
      }
      Object localObject = (Snackbar)paramAnonymousMessage.obj;
      int i = paramAnonymousMessage.arg1;
      if ((((Snackbar)localObject).aj()) && (((Snackbar)localObject).jk.getVisibility() == 0)) {
        if (Build.VERSION.SDK_INT >= 14) {
          z.V(((Snackbar)localObject).jk).r(((Snackbar)localObject).jk.getHeight()).b(a.et).c(250L).a(new Snackbar.8((Snackbar)localObject, i)).start();
        }
      }
      for (;;)
      {
        return true;
        paramAnonymousMessage = AnimationUtils.loadAnimation(((Snackbar)localObject).jk.getContext(), a.a.W);
        paramAnonymousMessage.setInterpolator(a.et);
        paramAnonymousMessage.setDuration(250L);
        paramAnonymousMessage.setAnimationListener(new Snackbar.2((Snackbar)localObject, i));
        ((Snackbar)localObject).jk.startAnimation(paramAnonymousMessage);
        continue;
        ((Snackbar)localObject).ai();
      }
    }
  });
  final ViewGroup jj;
  public final SnackbarLayout jk;
  private final AccessibilityManager jl;
  public final q.a jm;
  
  public final void ag()
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      z.c(this.jk, this.jk.getHeight());
      z.V(this.jk).r(0.0F).b(a.et).c(250L).a(new an()
      {
        public final void p(View paramAnonymousView)
        {
          paramAnonymousView = Snackbar.this.jk;
          z.d(paramAnonymousView.jq, 0.0F);
          z.V(paramAnonymousView.jq).p(1.0F).c(180L).d(70L).start();
          if (paramAnonymousView.jr.getVisibility() == 0)
          {
            z.d(paramAnonymousView.jr, 0.0F);
            z.V(paramAnonymousView.jr).p(1.0F).c(180L).d(70L).start();
          }
        }
        
        public final void q(View paramAnonymousView)
        {
          Snackbar.this.ah();
        }
      }).start();
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.jk.getContext(), a.a.V);
    localAnimation.setInterpolator(a.et);
    localAnimation.setDuration(250L);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        Snackbar.this.ah();
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.jk.startAnimation(localAnimation);
  }
  
  public final void ah()
  {
    q localq = q.am();
    q.a locala = this.jm;
    synchronized (localq.mLock)
    {
      if (localq.d(locala)) {
        localq.b(localq.jw);
      }
      return;
    }
  }
  
  public final void ai()
  {
    q localq = q.am();
    q.a locala = this.jm;
    synchronized (localq.mLock)
    {
      if (localq.d(locala))
      {
        localq.jw = null;
        if ((localq.jx != null) && (localq.jx != null))
        {
          localq.jw = localq.jx;
          localq.jx = null;
          if ((q.a)localq.jw.jz.get() == null) {
            localq.jw = null;
          }
        }
      }
      ??? = this.jk.getParent();
      if ((??? instanceof ViewGroup)) {
        ((ViewGroup)???).removeView(this.jk);
      }
      return;
    }
  }
  
  public final boolean aj()
  {
    return !this.jl.isEnabled();
  }
  
  public static class SnackbarLayout
    extends LinearLayout
  {
    private int iO;
    TextView jq;
    Button jr;
    private int js;
    b jt;
    a ju;
    
    public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.cI);
      this.iO = paramAttributeSet.getDimensionPixelSize(a.i.cJ, -1);
      this.js = paramAttributeSet.getDimensionPixelSize(a.i.cL, -1);
      if (paramAttributeSet.hasValue(a.i.cK)) {
        z.g(this, paramAttributeSet.getDimensionPixelSize(a.i.cK, 0));
      }
      paramAttributeSet.recycle();
      setClickable(true);
      LayoutInflater.from(paramContext).inflate(a.f.ay, this);
      z.O(this);
      z.i(this, 1);
    }
    
    private boolean c(int paramInt1, int paramInt2, int paramInt3)
    {
      boolean bool = false;
      if (paramInt1 != getOrientation())
      {
        setOrientation(paramInt1);
        bool = true;
      }
      TextView localTextView;
      if ((this.jq.getPaddingTop() != paramInt2) || (this.jq.getPaddingBottom() != paramInt3))
      {
        localTextView = this.jq;
        if (!z.ae(localTextView)) {
          break label78;
        }
        z.c(localTextView, z.P(localTextView), paramInt2, z.Q(localTextView), paramInt3);
      }
      for (;;)
      {
        bool = true;
        return bool;
        label78:
        localTextView.setPadding(localTextView.getPaddingLeft(), paramInt2, localTextView.getPaddingRight(), paramInt3);
      }
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (this.ju != null) {
        this.ju.ak();
      }
    }
    
    protected void onFinishInflate()
    {
      super.onFinishInflate();
      this.jq = ((TextView)findViewById(a.e.au));
      this.jr = ((Button)findViewById(a.e.at));
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.jt != null) {
        this.jt.al();
      }
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      int i = paramInt1;
      if (this.iO > 0)
      {
        i = paramInt1;
        if (getMeasuredWidth() > this.iO)
        {
          i = View.MeasureSpec.makeMeasureSpec(this.iO, 1073741824);
          super.onMeasure(i, paramInt2);
        }
      }
      int j = getResources().getDimensionPixelSize(a.d.an);
      int k = getResources().getDimensionPixelSize(a.d.am);
      if (this.jq.getLayout().getLineCount() > 1)
      {
        paramInt1 = 1;
        if ((paramInt1 == 0) || (this.js <= 0) || (this.jr.getMeasuredWidth() <= this.js)) {
          break label142;
        }
        if (!c(1, j, j - k)) {
          break label170;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          super.onMeasure(i, paramInt2);
        }
        return;
        paramInt1 = 0;
        break;
        label142:
        if (paramInt1 != 0) {}
        for (paramInt1 = j;; paramInt1 = k)
        {
          if (!c(0, paramInt1, paramInt1)) {
            break label170;
          }
          paramInt1 = 1;
          break;
        }
        label170:
        paramInt1 = 0;
      }
    }
    
    static abstract interface a
    {
      public abstract void ak();
    }
    
    static abstract interface b
    {
      public abstract void al();
    }
  }
  
  final class a
    extends s<Snackbar.SnackbarLayout>
  {
    a() {}
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, Snackbar.SnackbarLayout paramSnackbarLayout, MotionEvent paramMotionEvent)
    {
      if (paramCoordinatorLayout.b(paramSnackbarLayout, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        return super.a(paramCoordinatorLayout, paramSnackbarLayout, paramMotionEvent);
        q.am().a(Snackbar.this.jm);
        continue;
        q.am().b(Snackbar.this.jm);
      }
    }
    
    public final boolean r(View paramView)
    {
      return paramView instanceof Snackbar.SnackbarLayout;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/Snackbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */