package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class r
{
  static final f EF = new b();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      EF = new a();
      return;
    }
    if (i >= 18)
    {
      EF = new d();
      return;
    }
    if (i >= 17)
    {
      EF = new c();
      return;
    }
    if (i >= 16)
    {
      EF = new e();
      return;
    }
  }
  
  public static void a(TextView paramTextView, Drawable paramDrawable)
  {
    EF.a(paramTextView, paramDrawable, null, null, null);
  }
  
  public static int c(TextView paramTextView)
  {
    return EF.c(paramTextView);
  }
  
  static final class a
    extends r.d
  {}
  
  static class b
    implements r.f
  {
    public void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
    {
      paramTextView.setCompoundDrawables(paramDrawable1, null, null, null);
    }
    
    public int c(TextView paramTextView)
    {
      if (!s.EJ)
      {
        s.EI = s.n("mMaxMode");
        s.EJ = true;
      }
      if ((s.EI != null) && (s.a(s.EI, paramTextView) == 1))
      {
        if (!s.EH)
        {
          s.EG = s.n("mMaximum");
          s.EH = true;
        }
        if (s.EG != null) {
          return s.a(s.EG, paramTextView);
        }
      }
      return -1;
    }
  }
  
  static class c
    extends r.e
  {
    public void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
    {
      int i;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label38;
        }
        paramDrawable2 = null;
        label18:
        if (i == 0) {
          break label43;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawables(paramDrawable2, null, paramDrawable1, null);
        return;
        i = 0;
        break;
        label38:
        paramDrawable2 = paramDrawable1;
        break label18;
        label43:
        paramDrawable1 = null;
      }
    }
  }
  
  static class d
    extends r.c
  {
    public final void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, null, null, null);
    }
  }
  
  static class e
    extends r.b
  {
    public final int c(TextView paramTextView)
    {
      return paramTextView.getMaxLines();
    }
  }
  
  static abstract interface f
  {
    public abstract void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4);
    
    public abstract int c(TextView paramTextView);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */