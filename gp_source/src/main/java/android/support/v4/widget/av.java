package android.support.v4.widget;

import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.f.b;
import android.support.v4.f.c;
import android.support.v4.f.d;
import android.support.v4.g.u;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode.Callback;
import android.widget.TextView;

public final class av
{
  public static ActionMode.Callback a(TextView paramTextView, ActionMode.Callback paramCallback)
  {
    Object localObject = paramCallback;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject = paramCallback;
      if (Build.VERSION.SDK_INT <= 27)
      {
        localObject = paramCallback;
        if (!(paramCallback instanceof aw)) {
          localObject = new aw(paramCallback, paramTextView);
        }
      }
    }
    return (ActionMode.Callback)localObject;
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramTextView.setTextAppearance(paramInt);
      return;
    }
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
  }
  
  public static void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i = paramTextView.getLayoutDirection();
      if (i == 1) {}
      for (Drawable localDrawable = paramDrawable3;; localDrawable = paramDrawable1)
      {
        if (i != 1) {}
        for (;;)
        {
          paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable3, paramDrawable4);
          return;
          paramDrawable3 = paramDrawable1;
        }
      }
    }
    paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void a(TextView paramTextView, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView.setText(b.a());
      return;
    }
    if (!b(paramTextView).equals(b.b())) {
      throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }
    paramTextView.setText(paramb);
  }
  
  public static Drawable[] a(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramTextView = paramTextView.getCompoundDrawablesRelative();
    }
    int i;
    Drawable[] arrayOfDrawable;
    do
    {
      return paramTextView;
      if (Build.VERSION.SDK_INT < 17) {
        break;
      }
      i = paramTextView.getLayoutDirection();
      arrayOfDrawable = paramTextView.getCompoundDrawables();
      paramTextView = arrayOfDrawable;
    } while (i != 1);
    paramTextView = arrayOfDrawable[2];
    Drawable localDrawable = arrayOfDrawable[0];
    arrayOfDrawable[0] = paramTextView;
    arrayOfDrawable[2] = localDrawable;
    return arrayOfDrawable;
    return paramTextView.getCompoundDrawables();
  }
  
  public static c b(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return new c(paramTextView.getTextMetricsParams());
    }
    d locald = new d(new TextPaint(paramTextView.getPaint()));
    if (Build.VERSION.SDK_INT >= 23)
    {
      locald.a = paramTextView.getBreakStrategy();
      locald.b = paramTextView.getHyphenationFrequency();
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      if (!(paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
        break label114;
      }
      paramTextView = TextDirectionHeuristics.LTR;
    }
    for (;;)
    {
      locald.d = paramTextView;
      return new c(locald.c, locald.d, locald.a, locald.b);
      label114:
      int i;
      if ((Build.VERSION.SDK_INT >= 28) && ((paramTextView.getInputType() & 0xF) == 3))
      {
        i = Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
        if (i == 1) {}
        while (i == 2)
        {
          paramTextView = TextDirectionHeuristics.RTL;
          break;
        }
        paramTextView = TextDirectionHeuristics.LTR;
      }
      else
      {
        i = paramTextView.getLayoutDirection();
        switch (paramTextView.getTextDirection())
        {
        default: 
          if (i != 1) {
            paramTextView = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          } else {
            paramTextView = TextDirectionHeuristics.FIRSTSTRONG_RTL;
          }
          break;
        case 7: 
          paramTextView = TextDirectionHeuristics.FIRSTSTRONG_RTL;
          break;
        case 6: 
          paramTextView = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          break;
        case 5: 
          paramTextView = TextDirectionHeuristics.LOCALE;
          break;
        case 4: 
          paramTextView = TextDirectionHeuristics.RTL;
          break;
        case 3: 
          paramTextView = TextDirectionHeuristics.LTR;
          break;
        case 2: 
          paramTextView = TextDirectionHeuristics.ANYRTL_LTR;
        }
      }
    }
  }
  
  public static void b(TextView paramTextView, int paramInt)
  {
    u.a(paramInt);
    if (Build.VERSION.SDK_INT >= 28) {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
    }
    for (;;)
    {
      return;
      Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
      if (paramTextView.getIncludeFontPadding()) {}
      for (int i = localFontMetricsInt.top; paramInt > Math.abs(i); i = localFontMetricsInt.ascent)
      {
        paramTextView.setPadding(paramTextView.getPaddingLeft(), paramInt - -i, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
        return;
      }
    }
  }
  
  public static void b(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i = paramTextView.getLayoutDirection();
      if (i == 1) {}
      for (Drawable localDrawable = paramDrawable3;; localDrawable = paramDrawable1)
      {
        if (i != 1) {}
        for (;;)
        {
          paramTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, paramDrawable2, paramDrawable3, paramDrawable4);
          return;
          paramDrawable3 = paramDrawable1;
        }
      }
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void c(TextView paramTextView, int paramInt)
  {
    u.a(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if (paramTextView.getIncludeFontPadding()) {}
    for (int i = localFontMetricsInt.bottom;; i = localFontMetricsInt.descent)
    {
      if (paramInt > Math.abs(i)) {
        paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i);
      }
      return;
    }
  }
  
  public static void d(TextView paramTextView, int paramInt)
  {
    u.a(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i) {
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */