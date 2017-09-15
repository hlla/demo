package android.support.v4.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class e
  implements c
{
  public final g aB()
  {
    return new a();
  }
  
  public final void v(View paramView) {}
  
  private static final class a
    implements g
  {
    List<b> eE = new ArrayList();
    public long mDuration = 200L;
    public long mStartTime;
    public Runnable nA = new Runnable()
    {
      public final void run()
      {
        float f = (float)(e.a.this.nw.getDrawingTime() - e.a.this.mStartTime) * 1.0F / (float)e.a.this.mDuration;
        if ((f > 1.0F) || (e.a.this.nw.getParent() == null)) {
          f = 1.0F;
        }
        e.a.this.nx = f;
        e.a locala = e.a.this;
        int i = locala.nv.size() - 1;
        while (i >= 0)
        {
          ((d)locala.nv.get(i)).b(locala);
          i -= 1;
        }
        if (e.a.this.nx >= 1.0F)
        {
          e.a.this.aD();
          return;
        }
        e.a.this.nw.postDelayed(e.a.this.nA, 16L);
      }
    };
    List<d> nv = new ArrayList();
    View nw;
    public float nx = 0.0F;
    private boolean ny = false;
    private boolean nz = false;
    
    public final void a(b paramb)
    {
      this.eE.add(paramb);
    }
    
    public final void a(d paramd)
    {
      this.nv.add(paramd);
    }
    
    public final void aD()
    {
      int i = this.eE.size() - 1;
      while (i >= 0)
      {
        ((b)this.eE.get(i)).a(this);
        i -= 1;
      }
    }
    
    public final void cancel()
    {
      if (this.nz) {
        return;
      }
      this.nz = true;
      if (this.ny)
      {
        int i = this.eE.size() - 1;
        while (i >= 0)
        {
          ((b)this.eE.get(i)).aC();
          i -= 1;
        }
      }
      aD();
    }
    
    public final float getAnimatedFraction()
    {
      return this.nx;
    }
    
    public final void setDuration(long paramLong)
    {
      if (!this.ny) {
        this.mDuration = paramLong;
      }
    }
    
    public final void start()
    {
      if (this.ny) {
        return;
      }
      this.ny = true;
      int i = this.eE.size() - 1;
      while (i >= 0)
      {
        this.eE.get(i);
        i -= 1;
      }
      this.nx = 0.0F;
      this.mStartTime = this.nw.getDrawingTime();
      this.nw.postDelayed(this.nA, 16L);
    }
    
    public final void w(View paramView)
    {
      this.nw = paramView;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */