package android.support.design.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.g.v;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.List;

public final class e
{
  private final v a = new v();
  
  public static e a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if ((paramContext instanceof AnimatorSet)) {
        return a(((AnimatorSet)paramContext).getChildAnimations());
      }
      if (paramContext != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramContext);
        paramContext = a(localArrayList);
        return paramContext;
      }
      return null;
    }
    catch (Exception localException)
    {
      paramContext = String.valueOf(Integer.toHexString(paramInt));
      if (paramContext.length() != 0) {}
    }
    for (paramContext = new String("Can't load animation resource ID #0x");; paramContext = "Can't load animation resource ID #0x".concat(paramContext))
    {
      Log.w("MotionSpec", paramContext, localException);
      return null;
    }
  }
  
  public static e a(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0) {}
    }
    else
    {
      return null;
    }
    return a(paramContext, paramInt);
  }
  
  private static e a(List paramList)
  {
    e locale = new e();
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (Animator)paramList.get(i);
      if ((localObject instanceof ObjectAnimator))
      {
        ObjectAnimator localObjectAnimator = (ObjectAnimator)localObject;
        String str = localObjectAnimator.getPropertyName();
        long l1 = localObjectAnimator.getStartDelay();
        long l2 = localObjectAnimator.getDuration();
        TimeInterpolator localTimeInterpolator = localObjectAnimator.getInterpolator();
        if ((localTimeInterpolator instanceof AccelerateDecelerateInterpolator)) {
          label85:
          localObject = a.c;
        }
        for (;;)
        {
          localObject = new f(l1, l2, (TimeInterpolator)localObject);
          ((f)localObject).a = localObjectAnimator.getRepeatCount();
          ((f)localObject).b = localObjectAnimator.getRepeatMode();
          locale.a.put(str, localObject);
          i += 1;
          break;
          if (localTimeInterpolator == null) {
            break label85;
          }
          if ((localTimeInterpolator instanceof AccelerateInterpolator))
          {
            localObject = a.b;
          }
          else
          {
            localObject = localTimeInterpolator;
            if ((localTimeInterpolator instanceof DecelerateInterpolator)) {
              localObject = a.e;
            }
          }
        }
      }
      paramList = String.valueOf(localObject);
      localObject = new StringBuilder(String.valueOf(paramList).length() + 36);
      ((StringBuilder)localObject).append("Animator must be an ObjectAnimator: ");
      ((StringBuilder)localObject).append(paramList);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return locale;
  }
  
  public final f a(String paramString)
  {
    if (this.a.get(paramString) == null) {
      throw new IllegalArgumentException();
    }
    return (f)this.a.get(paramString);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (e)paramObject;
      return this.a.equals(((e)paramObject).a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" timings: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */