package com.google.android.finsky.bg;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.finsky.utils.i;

final class c
  implements AnimatorUpdateListener
{
  c(e parame, ProgressBar paramProgressBar, CharSequence paramCharSequence1, TextView paramTextView1, CharSequence paramCharSequence2, Context paramContext, long paramLong, TextView paramTextView2) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    if (!paramValueAnimator.o) {}
    for (;;)
    {
      long l1 = i.a();
      paramValueAnimator = this.a;
      if (paramValueAnimator.p) {
        if (paramValueAnimator.g) {
          break label194;
        }
      }
      for (;;)
      {
        paramValueAnimator.g = true;
        paramValueAnimator.k = l1;
        i = paramValueAnimator.m;
        i -= (int)((i - paramValueAnimator.n) * f1);
        paramValueAnimator = this.e;
        this.g.setText(TextUtils.expandTemplate(paramValueAnimator, new CharSequence[] { Integer.toString(i) }));
        paramValueAnimator = this.a;
        paramValueAnimator.i = i;
        l1 = paramValueAnimator.d;
        l1 -= (f1 * (float)(l1 - paramValueAnimator.e));
        paramValueAnimator.h = l1;
        paramValueAnimator = this.d;
        Context localContext = this.c;
        long l2 = this.b;
        this.f.setText(TextUtils.expandTemplate(paramValueAnimator, new CharSequence[] { Formatter.formatFileSize(localContext, l1), Formatter.formatFileSize(localContext, l2) }));
        return;
        label194:
        if (f1 > 0.0F) {
          if (l1 - paramValueAnimator.k < 100L) {
            break;
          }
        }
      }
      int i = paramValueAnimator.f;
      paramValueAnimator.j = (i - (int)((i - paramValueAnimator.q) * f1));
      this.h.setProgress(paramValueAnimator.j);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bg/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */