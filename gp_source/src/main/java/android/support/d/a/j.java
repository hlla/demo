package android.support.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.a.b;
import android.support.v4.content.a.o;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public final class j
  implements Interpolator
{
  private float[] a;
  private float[] b;
  
  public j(Context paramContext, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    this(paramContext.getResources(), paramContext.getTheme(), paramAttributeSet, paramXmlPullParser);
  }
  
  private j(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    paramResources = o.a(paramResources, paramTheme, paramAttributeSet, a.f);
    if (o.a(paramXmlPullParser, "pathData"))
    {
      paramTheme = o.c(paramResources, paramXmlPullParser, "pathData", 4);
      paramAttributeSet = b.a(paramTheme);
      if (paramAttributeSet == null)
      {
        paramResources = new StringBuilder();
        paramResources.append("The path is null, which is created from ");
        paramResources.append(paramTheme);
        throw new InflateException(paramResources.toString());
      }
      a(paramAttributeSet);
    }
    for (;;)
    {
      paramResources.recycle();
      return;
      if (!o.a(paramXmlPullParser, "controlX1")) {
        throw new InflateException("pathInterpolator requires the controlX1 attribute");
      }
      if (!o.a(paramXmlPullParser, "controlY1")) {
        break;
      }
      float f1 = o.a(paramResources, paramXmlPullParser, "controlX1", 0, 0.0F);
      float f2 = o.a(paramResources, paramXmlPullParser, "controlY1", 1, 0.0F);
      boolean bool = o.a(paramXmlPullParser, "controlX2");
      if (bool != o.a(paramXmlPullParser, "controlY2")) {
        throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
      }
      if (bool)
      {
        float f3 = o.a(paramResources, paramXmlPullParser, "controlX2", 2, 0.0F);
        float f4 = o.a(paramResources, paramXmlPullParser, "controlY2", 3, 0.0F);
        paramTheme = new Path();
        paramTheme.moveTo(0.0F, 0.0F);
        paramTheme.cubicTo(f1, f2, f3, f4, 1.0F, 1.0F);
        a(paramTheme);
      }
      else
      {
        paramTheme = new Path();
        paramTheme.moveTo(0.0F, 0.0F);
        paramTheme.quadTo(f1, f2, 1.0F, 1.0F);
        a(paramTheme);
      }
    }
    throw new InflateException("pathInterpolator requires the controlY1 attribute");
  }
  
  private final void a(Path paramPath)
  {
    int j = 0;
    paramPath = new PathMeasure(paramPath, false);
    float f1 = paramPath.getLength();
    int k = Math.min(3000, (int)(f1 / 0.002F) + 1);
    if (k <= 0)
    {
      paramPath = new StringBuilder();
      paramPath.append("The Path has a invalid length ");
      paramPath.append(f1);
      throw new IllegalArgumentException(paramPath.toString());
    }
    this.a = new float[k];
    this.b = new float[k];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < k)
    {
      paramPath.getPosTan(i * f1 / (k - 1), arrayOfFloat, null);
      this.a[i] = arrayOfFloat[0];
      this.b[i] = arrayOfFloat[1];
      i += 1;
    }
    if ((Math.abs(this.a[0]) <= 1.0E-5D) && (Math.abs(this.b[0]) <= 1.0E-5D))
    {
      i = k - 1;
      if ((Math.abs(this.a[i] - 1.0F) <= 1.0E-5D) && (Math.abs(this.b[i] - 1.0F) <= 1.0E-5D))
      {
        f1 = 0.0F;
        i = 0;
        while (j < k)
        {
          arrayOfFloat = this.a;
          float f2 = arrayOfFloat[i];
          if (f2 < f1)
          {
            paramPath = new StringBuilder();
            paramPath.append("The Path cannot loop back on itself, x :");
            paramPath.append(f2);
            throw new IllegalArgumentException(paramPath.toString());
          }
          arrayOfFloat[j] = f2;
          j += 1;
          f1 = f2;
          i += 1;
        }
        if (!paramPath.nextContour()) {
          return;
        }
        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
      }
    }
    paramPath = new StringBuilder();
    paramPath.append("The Path must start at (0,0) and end at (1,1) start: ");
    paramPath.append(this.a[0]);
    paramPath.append(",");
    paramPath.append(this.b[0]);
    paramPath.append(" end:");
    i = k - 1;
    paramPath.append(this.a[i]);
    paramPath.append(",");
    paramPath.append(this.b[i]);
    throw new IllegalArgumentException(paramPath.toString());
  }
  
  public final float getInterpolation(float paramFloat)
  {
    float f1 = 1.0F;
    if (paramFloat > 0.0F)
    {
      int j;
      int i;
      if (paramFloat < 1.0F)
      {
        j = this.a.length - 1;
        i = 0;
      }
      for (;;)
      {
        if (j - i <= 1)
        {
          float[] arrayOfFloat = this.a;
          float f2 = arrayOfFloat[j];
          f1 = arrayOfFloat[i];
          float f3 = f2 - f1;
          if (f3 == 0.0F)
          {
            f1 = this.b[i];
            return f1;
          }
          arrayOfFloat = this.b;
          f2 = arrayOfFloat[i];
          paramFloat = (paramFloat - f1) / f3;
          return (arrayOfFloat[j] - f2) * paramFloat + f2;
        }
        int k = (i + j) / 2;
        f1 = this.a[k];
        int m = j;
        if (paramFloat < f1) {
          m = k;
        }
        j = m;
        if (paramFloat >= f1)
        {
          i = k;
          j = m;
        }
      }
    }
    return 0.0F;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */