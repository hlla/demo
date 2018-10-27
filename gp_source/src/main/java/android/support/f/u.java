package android.support.f;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.util.Property;

final class u
{
  static ObjectAnimator a(Object paramObject, Property paramProperty, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ObjectAnimator.ofObject(paramObject, paramProperty, null, paramPath);
    }
    return ObjectAnimator.ofFloat(paramObject, new w(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */