package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public abstract class ez
{
  public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
  public static final int FLAG_CHANGED = 2;
  public static final int FLAG_INVALIDATED = 4;
  public static final int FLAG_MOVED = 2048;
  public static final int FLAG_REMOVED = 8;
  public long mAddDuration = 120L;
  public long mChangeDuration = 250L;
  public ArrayList mFinishedListeners = new ArrayList();
  public fb mListener = null;
  public long mMoveDuration = 250L;
  public long mRemoveDuration = 120L;
  
  static int buildAdapterChangeFlagsForAnimations(fz paramfz)
  {
    int j = paramfz.d & 0xE;
    if (!paramfz.j())
    {
      int i = j;
      if ((j & 0x4) == 0)
      {
        int k = paramfz.i;
        int m = paramfz.d();
        i = j;
        if (k != -1)
        {
          i = j;
          if (m != -1)
          {
            i = j;
            if (k != m) {
              i = j | 0x800;
            }
          }
        }
      }
      return i;
    }
    return 4;
  }
  
  public abstract boolean animateAppearance(fz paramfz, fc paramfc1, fc paramfc2);
  
  public abstract boolean animateChange(fz paramfz1, fz paramfz2, fc paramfc1, fc paramfc2);
  
  public abstract boolean animateDisappearance(fz paramfz, fc paramfc1, fc paramfc2);
  
  public abstract boolean animatePersistence(fz paramfz, fc paramfc1, fc paramfc2);
  
  public boolean canReuseUpdatedViewHolder(fz paramfz)
  {
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(fz paramfz, List paramList)
  {
    return canReuseUpdatedViewHolder(paramfz);
  }
  
  public final void dispatchAnimationFinished(fz paramfz)
  {
    onAnimationFinished(paramfz);
    fb localfb = this.mListener;
    if (localfb != null) {
      localfb.a(paramfz);
    }
  }
  
  public final void dispatchAnimationStarted(fz paramfz)
  {
    onAnimationStarted(paramfz);
  }
  
  public final void dispatchAnimationsFinished()
  {
    int j = this.mFinishedListeners.size();
    int i = 0;
    while (i < j)
    {
      ((fa)this.mFinishedListeners.get(i)).a();
      i += 1;
    }
    this.mFinishedListeners.clear();
  }
  
  public abstract void endAnimation(fz paramfz);
  
  public abstract void endAnimations();
  
  public long getAddDuration()
  {
    return this.mAddDuration;
  }
  
  public long getChangeDuration()
  {
    return this.mChangeDuration;
  }
  
  public long getMoveDuration()
  {
    return this.mMoveDuration;
  }
  
  public long getRemoveDuration()
  {
    return this.mRemoveDuration;
  }
  
  public abstract boolean isRunning();
  
  public final boolean isRunning(fa paramfa)
  {
    boolean bool = isRunning();
    if (paramfa != null)
    {
      if (bool) {
        this.mFinishedListeners.add(paramfa);
      }
    }
    else {
      return bool;
    }
    paramfa.a();
    return bool;
  }
  
  public fc obtainHolderInfo()
  {
    return new fc();
  }
  
  public void onAnimationFinished(fz paramfz) {}
  
  public void onAnimationStarted(fz paramfz) {}
  
  public fc recordPostLayoutInformation(fw paramfw, fz paramfz)
  {
    paramfw = obtainHolderInfo();
    paramfz = paramfz.c;
    paramfw.a = paramfz.getLeft();
    paramfw.b = paramfz.getTop();
    paramfz.getRight();
    paramfz.getBottom();
    return paramfw;
  }
  
  public fc recordPreLayoutInformation(fw paramfw, fz paramfz, int paramInt, List paramList)
  {
    paramfw = obtainHolderInfo();
    paramfz = paramfz.c;
    paramfw.a = paramfz.getLeft();
    paramfw.b = paramfz.getTop();
    paramfz.getRight();
    paramfz.getBottom();
    return paramfw;
  }
  
  public abstract void runPendingAnimations();
  
  public void setAddDuration(long paramLong)
  {
    this.mAddDuration = paramLong;
  }
  
  public void setChangeDuration(long paramLong)
  {
    this.mChangeDuration = paramLong;
  }
  
  void setListener(fb paramfb)
  {
    this.mListener = paramfb;
  }
  
  public void setMoveDuration(long paramLong)
  {
    this.mMoveDuration = paramLong;
  }
  
  public void setRemoveDuration(long paramLong)
  {
    this.mRemoveDuration = paramLong;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */