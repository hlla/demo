package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.i;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.u;
import android.support.v4.widget.u.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private float eX;
  private int eY;
  public int eZ;
  public int fa;
  public boolean fb;
  public u fc;
  private boolean fd;
  private int fe;
  private boolean ff;
  public int fg;
  public WeakReference<V> fh;
  public WeakReference<View> fi;
  public a fj;
  private VelocityTracker fk;
  public int fl;
  private int fn;
  public boolean fo;
  private final u.a fp = new u.a()
  {
    public final int K()
    {
      if (BottomSheetBehavior.this.fb) {
        return BottomSheetBehavior.this.fg - BottomSheetBehavior.this.eZ;
      }
      return BottomSheetBehavior.this.fa - BottomSheetBehavior.this.eZ;
    }
    
    public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int j = 3;
      int i;
      if (paramAnonymousFloat2 < 0.0F) {
        i = BottomSheetBehavior.this.eZ;
      }
      while (BottomSheetBehavior.this.fc.q(paramAnonymousView.getLeft(), i))
      {
        BottomSheetBehavior.this.h(2);
        z.a(paramAnonymousView, new BottomSheetBehavior.b(BottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if ((BottomSheetBehavior.this.fb) && (BottomSheetBehavior.this.a(paramAnonymousView, paramAnonymousFloat2)))
        {
          i = BottomSheetBehavior.this.fg;
          j = 5;
        }
        else if (paramAnonymousFloat2 == 0.0F)
        {
          i = paramAnonymousView.getTop();
          if (Math.abs(i - BottomSheetBehavior.this.eZ) < Math.abs(i - BottomSheetBehavior.this.fa))
          {
            i = BottomSheetBehavior.this.eZ;
          }
          else
          {
            i = BottomSheetBehavior.this.fa;
            j = 4;
          }
        }
        else
        {
          i = BottomSheetBehavior.this.fa;
          j = 4;
        }
      }
      BottomSheetBehavior.this.h(j);
    }
    
    public final void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      BottomSheetBehavior.this.i(paramAnonymousInt2);
    }
    
    public final boolean b(View paramAnonymousView, int paramAnonymousInt)
    {
      if (BottomSheetBehavior.this.mState == 1) {
        return false;
      }
      if (BottomSheetBehavior.this.fo) {
        return false;
      }
      if ((BottomSheetBehavior.this.mState == 3) && (BottomSheetBehavior.this.fl == paramAnonymousInt))
      {
        View localView = (View)BottomSheetBehavior.this.fi.get();
        if ((localView != null) && (z.h(localView, -1))) {
          return false;
        }
      }
      return (BottomSheetBehavior.this.fh != null) && (BottomSheetBehavior.this.fh.get() == paramAnonymousView);
    }
    
    public final int c(View paramAnonymousView, int paramAnonymousInt)
    {
      int j = BottomSheetBehavior.this.eZ;
      if (BottomSheetBehavior.this.fb) {}
      for (int i = BottomSheetBehavior.this.fg;; i = BottomSheetBehavior.this.fa) {
        return n.b(paramAnonymousInt, j, i);
      }
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousView.getLeft();
    }
    
    public final void j(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 1) {
        BottomSheetBehavior.this.h(1);
      }
    }
  };
  public int mState = 4;
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.bm);
    g(paramAttributeSet.getDimensionPixelSize(a.i.bo, 0));
    this.fb = paramAttributeSet.getBoolean(a.i.bn, false);
    paramAttributeSet.recycle();
    this.eX = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private View h(View paramView)
  {
    if ((paramView instanceof p)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = h(paramView.getChildAt(i));
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static <V extends View> BottomSheetBehavior<V> i(V paramV)
  {
    paramV = paramV.getLayoutParams();
    if (!(paramV instanceof CoordinatorLayout.d)) {
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
    paramV = ((CoordinatorLayout.d)paramV).hu;
    if (!(paramV instanceof BottomSheetBehavior)) {
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    return (BottomSheetBehavior)paramV;
  }
  
  private void reset()
  {
    this.fl = -1;
    if (this.fk != null)
    {
      this.fk.recycle();
      this.fk = null;
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.getSuperState());
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.mState = 4;
      return;
    }
    this.mState = paramParcelable.state;
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
  {
    int j = 3;
    if (paramV.getTop() == this.eZ) {
      h(3);
    }
    while ((paramView != this.fi.get()) || (!this.ff)) {
      return;
    }
    int i;
    if (this.fe > 0)
    {
      i = this.eZ;
      if (!this.fc.e(paramV, paramV.getLeft(), i)) {
        break label215;
      }
      h(2);
      z.a(paramV, new b(paramV, j));
    }
    for (;;)
    {
      this.ff = false;
      return;
      if (this.fb)
      {
        this.fk.computeCurrentVelocity(1000, this.eX);
        if (a(paramV, y.b(this.fk, this.fl)))
        {
          i = this.fg;
          j = 5;
          break;
        }
      }
      if (this.fe == 0)
      {
        i = paramV.getTop();
        if (Math.abs(i - this.eZ) < Math.abs(i - this.fa))
        {
          i = this.eZ;
          break;
        }
        i = this.fa;
        j = 4;
        break;
      }
      i = this.fa;
      j = 4;
      break;
      label215:
      h(j);
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt, int[] paramArrayOfInt)
  {
    if (paramView != (View)this.fi.get()) {
      return;
    }
    int i = paramV.getTop();
    int j = i - paramInt;
    if (paramInt > 0) {
      if (j < this.eZ)
      {
        paramArrayOfInt[1] = (i - this.eZ);
        z.j(paramV, -paramArrayOfInt[1]);
        h(3);
      }
    }
    for (;;)
    {
      i(paramV.getTop());
      this.fe = paramInt;
      this.ff = true;
      return;
      paramArrayOfInt[1] = paramInt;
      z.j(paramV, -paramInt);
      h(1);
      continue;
      if ((paramInt < 0) && (!z.h(paramView, -1))) {
        if ((j <= this.fa) || (this.fb))
        {
          paramArrayOfInt[1] = paramInt;
          z.j(paramV, -paramInt);
          h(1);
        }
        else
        {
          paramArrayOfInt[1] = (i - this.fa);
          z.j(paramV, -paramArrayOfInt[1]);
          h(4);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((this.mState != 1) && (this.mState != 2))
    {
      if ((z.aa(paramCoordinatorLayout)) && (!z.aa(paramV))) {
        z.a(paramV, true);
      }
      paramCoordinatorLayout.e(paramV, paramInt);
    }
    this.fg = paramCoordinatorLayout.getHeight();
    this.eZ = Math.max(0, this.fg - paramV.getHeight());
    this.fa = Math.max(this.fg - this.eY, this.eZ);
    if (this.mState == 3) {
      z.j(paramV, this.eZ);
    }
    for (;;)
    {
      if (this.fc == null) {
        this.fc = u.a(paramCoordinatorLayout, this.fp);
      }
      this.fh = new WeakReference(paramV);
      this.fi = new WeakReference(h(paramV));
      return true;
      if ((this.fb) && (this.mState == 5)) {
        z.j(paramV, this.fg);
      } else if (this.mState == 4) {
        z.j(paramV, this.fa);
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {}
    int i;
    do
    {
      return false;
      i = o.d(paramMotionEvent);
      if (i == 0) {
        reset();
      }
      if (this.fk == null) {
        this.fk = VelocityTracker.obtain();
      }
      this.fk.addMovement(paramMotionEvent);
      switch (i)
      {
      }
      while ((!this.fd) && (this.fc.j(paramMotionEvent)))
      {
        return true;
        this.fo = false;
        this.fl = -1;
        if (this.fd)
        {
          this.fd = false;
          return false;
          int j = (int)paramMotionEvent.getX();
          this.fn = ((int)paramMotionEvent.getY());
          View localView = (View)this.fi.get();
          if ((localView != null) && (paramCoordinatorLayout.b(localView, j, this.fn)))
          {
            this.fl = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            this.fo = true;
          }
          if ((this.fl == -1) && (!paramCoordinatorLayout.b(paramV, j, this.fn))) {}
          for (boolean bool = true;; bool = false)
          {
            this.fd = bool;
            break;
          }
        }
      }
      paramV = (View)this.fi.get();
    } while ((i != 2) || (paramV == null) || (this.fd) || (this.mState == 1) || (paramCoordinatorLayout.b(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) || (Math.abs(this.fn - paramMotionEvent.getY()) <= this.fc.iE));
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.fi.get()) && ((this.mState != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    boolean bool = false;
    this.fe = 0;
    this.ff = false;
    if ((paramInt & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean a(View paramView, float paramFloat)
  {
    if (paramView.getTop() < this.fa) {}
    while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.fa) / this.eY <= 0.5F) {
      return false;
    }
    return true;
  }
  
  public final Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new SavedState(super.b(paramCoordinatorLayout, paramV), this.mState);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!paramV.isShown()) {
      bool1 = false;
    }
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            return bool1;
            i = o.d(paramMotionEvent);
            if (this.mState != 1) {
              break;
            }
            bool1 = bool2;
          } while (i == 0);
          this.fc.k(paramMotionEvent);
          if (i == 0) {
            reset();
          }
          if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
          }
          this.fk.addMovement(paramMotionEvent);
          bool1 = bool2;
        } while (i != 2);
        bool1 = bool2;
      } while (this.fd);
      bool1 = bool2;
    } while (Math.abs(this.fn - paramMotionEvent.getY()) <= this.fc.iE);
    this.fc.n(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    return true;
  }
  
  public final void g(int paramInt)
  {
    this.eY = Math.max(0, paramInt);
    this.fa = (this.fg - paramInt);
  }
  
  public final void h(int paramInt)
  {
    if (this.mState == paramInt) {}
    do
    {
      return;
      this.mState = paramInt;
    } while (((View)this.fh.get() == null) || (this.fj == null));
    this.fj.k(paramInt);
  }
  
  public final void i(int paramInt)
  {
    if (((View)this.fh.get() != null) && (this.fj != null))
    {
      if (paramInt > this.fa) {
        this.fj.d((this.fa - paramInt) / this.eY);
      }
    }
    else {
      return;
    }
    this.fj.d((this.fa - paramInt) / (this.fa - this.eZ));
  }
  
  protected static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    final int state;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.state = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable, int paramInt)
    {
      super();
      this.state = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.state);
    }
  }
  
  public static abstract class a
  {
    public abstract void d(float paramFloat);
    
    public abstract void k(int paramInt);
  }
  
  private final class b
    implements Runnable
  {
    private final int fr;
    private final View mView;
    
    public b(View paramView, int paramInt)
    {
      this.mView = paramView;
      this.fr = paramInt;
    }
    
    public final void run()
    {
      if ((BottomSheetBehavior.this.fc != null) && (BottomSheetBehavior.this.fc.cH()))
      {
        z.a(this.mView, this);
        return;
      }
      BottomSheetBehavior.this.h(this.fr);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/BottomSheetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */