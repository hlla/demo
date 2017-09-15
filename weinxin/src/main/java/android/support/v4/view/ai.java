package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ai
{
  public static final g zz = new a();
  public WeakReference<View> zv;
  public Runnable zw = null;
  public Runnable zx = null;
  public int zy = -1;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      zz = new f();
      return;
    }
    if (i >= 19)
    {
      zz = new e();
      return;
    }
    if (i >= 18)
    {
      zz = new c();
      return;
    }
    if (i >= 16)
    {
      zz = new d();
      return;
    }
    if (i >= 14)
    {
      zz = new b();
      return;
    }
  }
  
  ai(View paramView)
  {
    this.zv = new WeakReference(paramView);
  }
  
  public final ai a(am paramam)
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.a(this, localView, paramam);
    }
    return this;
  }
  
  public final ai a(ao paramao)
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.a(localView, paramao);
    }
    return this;
  }
  
  public final ai b(Interpolator paramInterpolator)
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.a(localView, paramInterpolator);
    }
    return this;
  }
  
  public final ai c(long paramLong)
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.a(localView, paramLong);
    }
    return this;
  }
  
  public final void cancel()
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.a(this, localView);
    }
  }
  
  public final ai d(long paramLong)
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.b(localView, paramLong);
    }
    return this;
  }
  
  public final ai p(float paramFloat)
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.a(this, localView, paramFloat);
    }
    return this;
  }
  
  public final ai q(float paramFloat)
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.b(this, localView, paramFloat);
    }
    return this;
  }
  
  public final ai r(float paramFloat)
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.c(this, localView, paramFloat);
    }
    return this;
  }
  
  public final ai s(float paramFloat)
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.d(this, localView, paramFloat);
    }
    return this;
  }
  
  public final void start()
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.b(this, localView);
    }
  }
  
  public final ai t(float paramFloat)
  {
    View localView = (View)this.zv.get();
    if (localView != null) {
      zz.e(this, localView, paramFloat);
    }
    return this;
  }
  
  static class a
    implements ai.g
  {
    WeakHashMap<View, Runnable> zA = null;
    
    private void d(ai paramai, View paramView)
    {
      Runnable localRunnable = null;
      if (this.zA != null) {
        localRunnable = (Runnable)this.zA.get(paramView);
      }
      Object localObject = localRunnable;
      if (localRunnable == null)
      {
        localObject = new a(paramai, paramView);
        if (this.zA == null) {
          this.zA = new WeakHashMap();
        }
        this.zA.put(paramView, localObject);
      }
      paramView.removeCallbacks((Runnable)localObject);
      paramView.post((Runnable)localObject);
    }
    
    public void a(ai paramai, View paramView)
    {
      d(paramai, paramView);
    }
    
    public void a(ai paramai, View paramView, float paramFloat)
    {
      d(paramai, paramView);
    }
    
    public void a(ai paramai, View paramView, am paramam)
    {
      paramView.setTag(2113929216, paramam);
    }
    
    public void a(View paramView, long paramLong) {}
    
    public void a(View paramView, ao paramao) {}
    
    public void a(View paramView, Interpolator paramInterpolator) {}
    
    public long ar(View paramView)
    {
      return 0L;
    }
    
    public void b(ai paramai, View paramView)
    {
      if (this.zA != null)
      {
        Runnable localRunnable = (Runnable)this.zA.get(paramView);
        if (localRunnable != null) {
          paramView.removeCallbacks(localRunnable);
        }
      }
      c(paramai, paramView);
    }
    
    public void b(ai paramai, View paramView, float paramFloat)
    {
      d(paramai, paramView);
    }
    
    public void b(View paramView, long paramLong) {}
    
    public final void c(ai paramai, View paramView)
    {
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof am)) {}
      for (localObject = (am)localObject;; localObject = null)
      {
        Runnable localRunnable1 = paramai.zw;
        Runnable localRunnable2 = paramai.zx;
        paramai.zw = null;
        paramai.zx = null;
        if (localRunnable1 != null) {
          localRunnable1.run();
        }
        if (localObject != null)
        {
          ((am)localObject).p(paramView);
          ((am)localObject).q(paramView);
        }
        if (localRunnable2 != null) {
          localRunnable2.run();
        }
        if (this.zA != null) {
          this.zA.remove(paramView);
        }
        return;
      }
    }
    
    public void c(ai paramai, View paramView, float paramFloat)
    {
      d(paramai, paramView);
    }
    
    public void d(ai paramai, View paramView, float paramFloat)
    {
      d(paramai, paramView);
    }
    
    public void e(ai paramai, View paramView, float paramFloat)
    {
      d(paramai, paramView);
    }
    
    final class a
      implements Runnable
    {
      WeakReference<View> fh;
      ai zB;
      
      public a(ai paramai, View paramView)
      {
        this.fh = new WeakReference(paramView);
        this.zB = paramai;
      }
      
      public final void run()
      {
        View localView = (View)this.fh.get();
        if (localView != null) {
          ai.a.this.c(this.zB, localView);
        }
      }
    }
  }
  
  static class b
    extends ai.a
  {
    WeakHashMap<View, Integer> zD = null;
    
    public final void a(ai paramai, View paramView)
    {
      paramView.animate().cancel();
    }
    
    public final void a(ai paramai, View paramView, float paramFloat)
    {
      paramView.animate().alpha(paramFloat);
    }
    
    public void a(ai paramai, View paramView, am paramam)
    {
      paramView.setTag(2113929216, paramam);
      paramai = new a(paramai);
      paramView.animate().setListener(new aj.1(paramai, paramView));
    }
    
    public final void a(View paramView, long paramLong)
    {
      paramView.animate().setDuration(paramLong);
    }
    
    public final void a(View paramView, Interpolator paramInterpolator)
    {
      paramView.animate().setInterpolator(paramInterpolator);
    }
    
    public final long ar(View paramView)
    {
      return paramView.animate().getDuration();
    }
    
    public final void b(ai paramai, View paramView)
    {
      paramView.animate().start();
    }
    
    public final void b(ai paramai, View paramView, float paramFloat)
    {
      paramView.animate().translationX(paramFloat);
    }
    
    public final void b(View paramView, long paramLong)
    {
      paramView.animate().setStartDelay(paramLong);
    }
    
    public final void c(ai paramai, View paramView, float paramFloat)
    {
      paramView.animate().translationY(paramFloat);
    }
    
    public final void d(ai paramai, View paramView, float paramFloat)
    {
      paramView.animate().scaleX(paramFloat);
    }
    
    public final void e(ai paramai, View paramView, float paramFloat)
    {
      paramView.animate().scaleY(paramFloat);
    }
    
    static final class a
      implements am
    {
      ai zB;
      boolean zE;
      
      a(ai paramai)
      {
        this.zB = paramai;
      }
      
      public final void as(View paramView)
      {
        Object localObject = paramView.getTag(2113929216);
        if ((localObject instanceof am)) {}
        for (localObject = (am)localObject;; localObject = null)
        {
          if (localObject != null) {
            ((am)localObject).as(paramView);
          }
          return;
        }
      }
      
      public final void p(View paramView)
      {
        this.zE = false;
        if (this.zB.zy >= 0) {
          z.a(paramView, 2, null);
        }
        if (this.zB.zw != null)
        {
          localObject = this.zB.zw;
          this.zB.zw = null;
          ((Runnable)localObject).run();
        }
        Object localObject = paramView.getTag(2113929216);
        if ((localObject instanceof am)) {}
        for (localObject = (am)localObject;; localObject = null)
        {
          if (localObject != null) {
            ((am)localObject).p(paramView);
          }
          return;
        }
      }
      
      public final void q(View paramView)
      {
        if (this.zB.zy >= 0)
        {
          z.a(paramView, this.zB.zy, null);
          this.zB.zy = -1;
        }
        if ((Build.VERSION.SDK_INT >= 16) || (!this.zE))
        {
          if (this.zB.zx != null)
          {
            localObject = this.zB.zx;
            this.zB.zx = null;
            ((Runnable)localObject).run();
          }
          localObject = paramView.getTag(2113929216);
          if (!(localObject instanceof am)) {
            break label113;
          }
        }
        label113:
        for (Object localObject = (am)localObject;; localObject = null)
        {
          if (localObject != null) {
            ((am)localObject).q(paramView);
          }
          this.zE = true;
          return;
        }
      }
    }
  }
  
  static class c
    extends ai.d
  {}
  
  static class d
    extends ai.b
  {
    public final void a(ai paramai, View paramView, am paramam)
    {
      if (paramam != null)
      {
        paramView.animate().setListener(new ak.1(paramam, paramView));
        return;
      }
      paramView.animate().setListener(null);
    }
  }
  
  static class e
    extends ai.c
  {
    public final void a(View paramView, ao paramao)
    {
      al.1 local1 = null;
      if (paramao != null) {
        local1 = new al.1(paramao, paramView);
      }
      paramView.animate().setUpdateListener(local1);
    }
  }
  
  static final class f
    extends ai.e
  {}
  
  public static abstract interface g
  {
    public abstract void a(ai paramai, View paramView);
    
    public abstract void a(ai paramai, View paramView, float paramFloat);
    
    public abstract void a(ai paramai, View paramView, am paramam);
    
    public abstract void a(View paramView, long paramLong);
    
    public abstract void a(View paramView, ao paramao);
    
    public abstract void a(View paramView, Interpolator paramInterpolator);
    
    public abstract long ar(View paramView);
    
    public abstract void b(ai paramai, View paramView);
    
    public abstract void b(ai paramai, View paramView, float paramFloat);
    
    public abstract void b(View paramView, long paramLong);
    
    public abstract void c(ai paramai, View paramView, float paramFloat);
    
    public abstract void d(ai paramai, View paramView, float paramFloat);
    
    public abstract void e(ai paramai, View paramView, float paramFloat);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */