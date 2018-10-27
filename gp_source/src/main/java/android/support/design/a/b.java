package android.support.design.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

public final class b
{
  public static void a(AnimatorSet paramAnimatorSet, List paramList)
  {
    int j = paramList.size();
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      localObject = (Animator)paramList.get(i);
      l = Math.max(l, ((Animator)localObject).getStartDelay() + ((Animator)localObject).getDuration());
      i += 1;
    }
    Object localObject = ValueAnimator.ofInt(new int[] { 0, 0 });
    ((Animator)localObject).setDuration(l);
    paramList.add(0, localObject);
    paramAnimatorSet.playTogether(paramList);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */