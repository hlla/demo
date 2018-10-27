package com.google.android.finsky.bc;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.av;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.google.android.play.image.x;

public final class s
{
  public final x a;
  
  public s(x paramx)
  {
    this.a = paramx;
  }
  
  static int a(float paramFloat, View paramView)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramView.getResources().getDisplayMetrics());
  }
  
  @TargetApi(17)
  static void a(TextView paramTextView, int paramInt, Bitmap paramBitmap)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawablesRelative();
    if (paramBitmap != null) {
      arrayOfDrawable[paramInt] = new BitmapDrawable(paramTextView.getResources(), paramBitmap);
    }
    for (;;)
    {
      av.b(paramTextView, arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
      arrayOfDrawable[paramInt] = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */