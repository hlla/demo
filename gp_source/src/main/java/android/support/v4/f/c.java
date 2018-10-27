package android.support.v4.f;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.support.v4.g.p;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.Locale;

public final class c
{
  public final int a;
  public final int b;
  public final TextPaint c;
  public final TextDirectionHeuristic d;
  private final PrecomputedText.Params e;
  
  public c(PrecomputedText.Params paramParams)
  {
    this.c = paramParams.getTextPaint();
    this.d = paramParams.getTextDirection();
    this.a = paramParams.getBreakStrategy();
    this.b = paramParams.getHyphenationFrequency();
    this.e = paramParams;
  }
  
  public c(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 28) {}
    for (this.e = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();; this.e = null)
    {
      this.c = paramTextPaint;
      this.d = paramTextDirectionHeuristic;
      this.a = paramInt1;
      this.b = paramInt2;
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject != this)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          PrecomputedText.Params localParams = this.e;
          if (localParams == null) {
            break label50;
          }
          bool1 = localParams.equals(((c)paramObject).e);
        }
      }
      label50:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return bool1;
                          if (Build.VERSION.SDK_INT < 23) {
                            break;
                          }
                          bool1 = bool2;
                        } while (this.a != ((c)paramObject).a);
                        bool1 = bool2;
                      } while (this.b != ((c)paramObject).b);
                      if (Build.VERSION.SDK_INT < 18) {
                        break;
                      }
                      bool1 = bool2;
                    } while (this.d != ((c)paramObject).d);
                    bool1 = bool2;
                  } while (this.c.getTextSize() != ((c)paramObject).c.getTextSize());
                  bool1 = bool2;
                } while (this.c.getTextScaleX() != ((c)paramObject).c.getTextScaleX());
                bool1 = bool2;
              } while (this.c.getTextSkewX() != ((c)paramObject).c.getTextSkewX());
              if (Build.VERSION.SDK_INT < 21) {
                break;
              }
              bool1 = bool2;
            } while (this.c.getLetterSpacing() != ((c)paramObject).c.getLetterSpacing());
            bool1 = bool2;
          } while (!TextUtils.equals(this.c.getFontFeatureSettings(), ((c)paramObject).c.getFontFeatureSettings()));
          bool1 = bool2;
        } while (this.c.getFlags() != ((c)paramObject).c.getFlags());
        if (Build.VERSION.SDK_INT < 24) {
          break;
        }
        bool1 = bool2;
      } while (!this.c.getTextLocales().equals(((c)paramObject).c.getTextLocales()));
      while ((Build.VERSION.SDK_INT < 17) || (this.c.getTextLocale().equals(((c)paramObject).c.getTextLocale())))
      {
        if (this.c.getTypeface() != null)
        {
          bool1 = bool2;
          if (!this.c.getTypeface().equals(((c)paramObject).c.getTypeface())) {
            break;
          }
        }
        while (((c)paramObject).c.getTypeface() == null) {
          return true;
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return p.a(new Object[] { Float.valueOf(this.c.getTextSize()), Float.valueOf(this.c.getTextScaleX()), Float.valueOf(this.c.getTextSkewX()), Float.valueOf(this.c.getLetterSpacing()), Integer.valueOf(this.c.getFlags()), this.c.getTextLocales(), this.c.getTypeface(), Boolean.valueOf(this.c.isElegantTextHeight()), this.d, Integer.valueOf(this.a), Integer.valueOf(this.b) });
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return p.a(new Object[] { Float.valueOf(this.c.getTextSize()), Float.valueOf(this.c.getTextScaleX()), Float.valueOf(this.c.getTextSkewX()), Float.valueOf(this.c.getLetterSpacing()), Integer.valueOf(this.c.getFlags()), this.c.getTextLocale(), this.c.getTypeface(), Boolean.valueOf(this.c.isElegantTextHeight()), this.d, Integer.valueOf(this.a), Integer.valueOf(this.b) });
    }
    if (Build.VERSION.SDK_INT >= 18) {
      return p.a(new Object[] { Float.valueOf(this.c.getTextSize()), Float.valueOf(this.c.getTextScaleX()), Float.valueOf(this.c.getTextSkewX()), Integer.valueOf(this.c.getFlags()), this.c.getTextLocale(), this.c.getTypeface(), this.d, Integer.valueOf(this.a), Integer.valueOf(this.b) });
    }
    if (Build.VERSION.SDK_INT >= 17) {
      return p.a(new Object[] { Float.valueOf(this.c.getTextSize()), Float.valueOf(this.c.getTextScaleX()), Float.valueOf(this.c.getTextSkewX()), Integer.valueOf(this.c.getFlags()), this.c.getTextLocale(), this.c.getTypeface(), this.d, Integer.valueOf(this.a), Integer.valueOf(this.b) });
    }
    return p.a(new Object[] { Float.valueOf(this.c.getTextSize()), Float.valueOf(this.c.getTextScaleX()), Float.valueOf(this.c.getTextSkewX()), Integer.valueOf(this.c.getFlags()), this.c.getTypeface(), this.d, Integer.valueOf(this.a), Integer.valueOf(this.b) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("{");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("textSize=");
    localStringBuilder2.append(this.c.getTextSize());
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", textScaleX=");
    localStringBuilder2.append(this.c.getTextScaleX());
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", textSkewX=");
    localStringBuilder2.append(this.c.getTextSkewX());
    localStringBuilder1.append(localStringBuilder2.toString());
    if (Build.VERSION.SDK_INT >= 21)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", letterSpacing=");
      localStringBuilder2.append(this.c.getLetterSpacing());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", elegantTextHeight=");
      localStringBuilder2.append(this.c.isElegantTextHeight());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", textLocale=");
      localStringBuilder2.append(this.c.getTextLocales());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    for (;;)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", typeface=");
      localStringBuilder2.append(this.c.getTypeface());
      localStringBuilder1.append(localStringBuilder2.toString());
      if (Build.VERSION.SDK_INT >= 26)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(", variationSettings=");
        localStringBuilder2.append(this.c.getFontVariationSettings());
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", textDir=");
      localStringBuilder2.append(this.d);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", breakStrategy=");
      localStringBuilder2.append(this.a);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", hyphenationFrequency=");
      localStringBuilder2.append(this.b);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
      if (Build.VERSION.SDK_INT >= 17)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(", textLocale=");
        localStringBuilder2.append(this.c.getTextLocale());
        localStringBuilder1.append(localStringBuilder2.toString());
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */