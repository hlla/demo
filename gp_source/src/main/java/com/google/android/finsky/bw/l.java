package com.google.android.finsky.bw;

import android.view.ViewGroup.LayoutParams;
import com.google.android.finsky.ds.a.bu;
import com.google.android.play.image.FifeImageView;
import com.google.android.play.image.x;

public final class l
{
  private final x a;
  
  public l(x paramx)
  {
    this.a = paramx;
  }
  
  public final void a(FifeImageView paramFifeImageView, bu parambu, int paramInt)
  {
    if (parambu != null)
    {
      if (paramInt != -1)
      {
        float f = s.a(paramInt);
        if (paramFifeImageView.getLayoutParams().width > 0)
        {
          ViewGroup.LayoutParams localLayoutParams = paramFifeImageView.getLayoutParams();
          localLayoutParams.height = ((int)(f * localLayoutParams.width));
        }
      }
      a(paramFifeImageView, parambu.g, parambu.h);
      paramFifeImageView.setVisibility(0);
    }
  }
  
  public final void a(FifeImageView paramFifeImageView, String paramString, boolean paramBoolean)
  {
    paramFifeImageView.a(paramString, paramBoolean, this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */