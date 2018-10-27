package android.support.design.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public final class f
{
  public int a = 0;
  public int b = 1;
  private long c = 0L;
  private long d = 300L;
  private TimeInterpolator e = null;
  
  public f(long paramLong1, long paramLong2, TimeInterpolator paramTimeInterpolator)
  {
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramTimeInterpolator;
  }
  
  private final TimeInterpolator a()
  {
    TimeInterpolator localTimeInterpolator2 = this.e;
    TimeInterpolator localTimeInterpolator1 = localTimeInterpolator2;
    if (localTimeInterpolator2 == null) {
      localTimeInterpolator1 = a.c;
    }
    return localTimeInterpolator1;
  }
  
  public final void a(Animator paramAnimator)
  {
    paramAnimator.setStartDelay(this.c);
    paramAnimator.setDuration(this.d);
    paramAnimator.setInterpolator(a());
    if ((paramAnimator instanceof ValueAnimator))
    {
      paramAnimator = (ValueAnimator)paramAnimator;
      paramAnimator.setRepeatCount(this.a);
      paramAnimator.setRepeatMode(this.b);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (this != paramObject)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (getClass() == paramObject.getClass())
        {
          paramObject = (f)paramObject;
          bool1 = bool2;
          if (this.c == ((f)paramObject).c)
          {
            bool1 = bool2;
            if (this.d == ((f)paramObject).d)
            {
              bool1 = bool2;
              if (this.a == ((f)paramObject).a)
              {
                bool1 = bool2;
                if (this.b == ((f)paramObject).b) {
                  bool1 = a().getClass().equals(((f)paramObject).a().getClass());
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    return true;
  }
  
  public final int hashCode()
  {
    long l1 = this.c;
    long l2 = this.d;
    return ((((int)(l1 ^ l1 >>> 32) * 31 + (int)(l2 ^ l2 >>> 32)) * 31 + a().getClass().hashCode()) * 31 + this.a) * 31 + this.b;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" delay: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" duration: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" interpolator: ");
    localStringBuilder.append(a().getClass());
    localStringBuilder.append(" repeatCount: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" repeatMode: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */