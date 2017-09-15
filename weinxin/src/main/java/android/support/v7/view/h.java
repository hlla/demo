package android.support.v7.view;

import android.support.v4.view.ai;
import android.support.v4.view.ai.g;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  public am Pr;
  boolean Ps;
  private final an Pt = new an()
  {
    private boolean Pu = false;
    private int Pv = 0;
    
    public final void p(View paramAnonymousView)
    {
      if (this.Pu) {}
      do
      {
        return;
        this.Pu = true;
      } while (h.this.Pr == null);
      h.this.Pr.p(null);
    }
    
    public final void q(View paramAnonymousView)
    {
      int i = this.Pv + 1;
      this.Pv = i;
      if (i == h.this.mc.size())
      {
        if (h.this.Pr != null) {
          h.this.Pr.q(null);
        }
        this.Pv = 0;
        this.Pu = false;
        h.this.Ps = false;
      }
    }
  };
  private long mDuration = -1L;
  private Interpolator mInterpolator;
  public final ArrayList<ai> mc = new ArrayList();
  
  public final h a(ai paramai)
  {
    if (!this.Ps) {
      this.mc.add(paramai);
    }
    return this;
  }
  
  public final h a(ai paramai1, ai paramai2)
  {
    this.mc.add(paramai1);
    paramai1 = (View)paramai1.zv.get();
    if (paramai1 != null) {}
    for (long l = ai.zz.ar(paramai1);; l = 0L)
    {
      paramai2.d(l);
      this.mc.add(paramai2);
      return this;
    }
  }
  
  public final h b(am paramam)
  {
    if (!this.Ps) {
      this.Pr = paramam;
    }
    return this;
  }
  
  public final h c(Interpolator paramInterpolator)
  {
    if (!this.Ps) {
      this.mInterpolator = paramInterpolator;
    }
    return this;
  }
  
  public final void cancel()
  {
    if (!this.Ps) {
      return;
    }
    Iterator localIterator = this.mc.iterator();
    while (localIterator.hasNext()) {
      ((ai)localIterator.next()).cancel();
    }
    this.Ps = false;
  }
  
  public final h dk()
  {
    if (!this.Ps) {
      this.mDuration = 250L;
    }
    return this;
  }
  
  public final void start()
  {
    if (this.Ps) {
      return;
    }
    Iterator localIterator = this.mc.iterator();
    while (localIterator.hasNext())
    {
      ai localai = (ai)localIterator.next();
      if (this.mDuration >= 0L) {
        localai.c(this.mDuration);
      }
      if (this.mInterpolator != null) {
        localai.b(this.mInterpolator);
      }
      if (this.Pr != null) {
        localai.a(this.Pt);
      }
      localai.start();
    }
    this.Ps = true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */