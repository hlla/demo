package com.android.launcher2;

import android.graphics.Rect;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class AnimateEngine
{
  private static final boolean DEBUG = false;
  private static final Interpolator DEFAULT_INTERPOLATOR = new DecelerateInterpolator();
  private static final String LOG_TAG = "AnimateEngine";
  private Interpolator mInterpolator = DEFAULT_INTERPOLATOR;
  
  public Rect[] getRect(Rect[] paramArrayOfRect1, Rect[] paramArrayOfRect2, Rect[] paramArrayOfRect3, float paramFloat)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfRect1 != null)
    {
      if (paramArrayOfRect2 != null) {
        break label22;
      }
      localObject1 = localObject2;
    }
    label22:
    do
    {
      return (Rect[])localObject1;
      localObject1 = localObject2;
    } while (paramArrayOfRect1.length != paramArrayOfRect2.length);
    paramFloat = Math.max(0.0F, Math.min(1.0F, paramFloat));
    int j = paramArrayOfRect1.length;
    if ((paramArrayOfRect3 == null) || (paramArrayOfRect3.length != j)) {
      paramArrayOfRect3 = new Rect[j];
    }
    for (;;)
    {
      paramFloat = this.mInterpolator.getInterpolation(paramFloat);
      int i = 0;
      for (;;)
      {
        localObject1 = paramArrayOfRect3;
        if (i >= j) {
          break;
        }
        if (paramArrayOfRect3[i] == null) {
          paramArrayOfRect3[i] = new Rect();
        }
        paramArrayOfRect1[i].left += (int)((paramArrayOfRect2[i].left - paramArrayOfRect1[i].left) * paramFloat);
        paramArrayOfRect1[i].right += (int)((paramArrayOfRect2[i].right - paramArrayOfRect1[i].right) * paramFloat);
        paramArrayOfRect1[i].top += (int)((paramArrayOfRect2[i].top - paramArrayOfRect1[i].top) * paramFloat);
        paramArrayOfRect1[i].bottom += (int)((paramArrayOfRect2[i].bottom - paramArrayOfRect1[i].bottom) * paramFloat);
        i += 1;
      }
    }
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    Interpolator localInterpolator = paramInterpolator;
    if (paramInterpolator == null) {
      localInterpolator = DEFAULT_INTERPOLATOR;
    }
    this.mInterpolator = localInterpolator;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AnimateEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */