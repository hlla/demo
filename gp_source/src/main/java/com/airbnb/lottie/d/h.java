package com.airbnb.lottie.d;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import com.airbnb.lottie.a.a.t;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.d;
import com.airbnb.lottie.i;
import java.io.Closeable;

public final class h
{
  private static final float a = (float)Math.sqrt(2.0D);
  private static final PathMeasure b = new PathMeasure();
  private static final float[] c;
  private static final Path d = new Path();
  private static final Path e = new Path();
  
  static
  {
    c = new float[4];
  }
  
  public static float a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Settings.Global.getFloat(paramContext.getContentResolver(), "animator_duration_scale", 1.0F);
    }
    return Settings.System.getFloat(paramContext.getContentResolver(), "animator_duration_scale", 1.0F);
  }
  
  public static float a(Matrix paramMatrix)
  {
    c[0] = 0.0F;
    c[1] = 0.0F;
    c[2] = a;
    c[3] = a;
    paramMatrix.mapPoints(c);
    return (float)Math.hypot(c[2] - c[0], c[3] - c[1]) / 2.0F;
  }
  
  public static int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 != 0.0F) {}
    for (int j = (int)(527.0F * paramFloat1);; j = 17)
    {
      int i = j;
      if (paramFloat2 != 0.0F) {
        i = (int)(j * 31 * paramFloat2);
      }
      j = i;
      if (paramFloat3 != 0.0F) {
        j = (int)(i * 31 * paramFloat3);
      }
      i = j;
      if (paramFloat4 != 0.0F) {
        i = (int)(j * 31 * paramFloat4);
      }
      return i;
    }
  }
  
  public static Path a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramPointF1.x, paramPointF1.y);
    if (paramPointF3 == null) {}
    while ((paramPointF4 == null) || ((paramPointF3.length() == 0.0F) && (paramPointF4.length() == 0.0F)))
    {
      localPath.lineTo(paramPointF2.x, paramPointF2.y);
      return localPath;
    }
    localPath.cubicTo(paramPointF1.x + paramPointF3.x, paramPointF1.y + paramPointF3.y, paramPointF2.x + paramPointF4.x, paramPointF2.y + paramPointF4.y, paramPointF2.x, paramPointF2.y);
    return localPath;
  }
  
  public static void a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    b.setPath(paramPath, false);
    float f2 = b.getLength();
    if (paramFloat1 != 1.0F) {}
    while (paramFloat2 != 0.0F)
    {
      if ((f2 < 1.0F) || (Math.abs(paramFloat2 - paramFloat1 - 1.0F) < 0.01D))
      {
        d.a();
        return;
      }
      paramFloat1 = f2 * paramFloat1;
      paramFloat2 = f2 * paramFloat2;
      float f1 = paramFloat3 * f2;
      paramFloat3 = Math.min(paramFloat1, paramFloat2) + f1;
      f1 = Math.max(paramFloat1, paramFloat2) + f1;
      if (paramFloat3 < f2)
      {
        paramFloat1 = f1;
        paramFloat2 = paramFloat3;
      }
      for (;;)
      {
        paramFloat3 = paramFloat2;
        if (paramFloat2 < 0.0F) {
          paramFloat3 = g.a(paramFloat2, f2);
        }
        paramFloat2 = paramFloat1;
        if (paramFloat1 < 0.0F) {
          paramFloat2 = g.a(paramFloat1, f2);
        }
        if (paramFloat3 == paramFloat2)
        {
          paramPath.reset();
          d.a();
          return;
        }
        paramFloat1 = paramFloat3;
        if (paramFloat3 >= paramFloat2) {
          paramFloat1 = paramFloat3 - f2;
        }
        d.reset();
        b.getSegment(paramFloat1, paramFloat2, d, true);
        if (paramFloat2 > f2)
        {
          e.reset();
          b.getSegment(0.0F, paramFloat2 % f2, e, true);
          d.addPath(e);
        }
        for (;;)
        {
          paramPath.set(d);
          d.a();
          return;
          if (paramFloat1 < 0.0F)
          {
            e.reset();
            b.getSegment(paramFloat1 + f2, f2, e, true);
            d.addPath(e);
          }
        }
        paramFloat2 = paramFloat3;
        paramFloat1 = f1;
        if (f1 >= f2)
        {
          paramFloat2 = g.a(paramFloat3, f2);
          paramFloat1 = g.a(f1, f2);
        }
      }
    }
    d.a();
  }
  
  public static void a(Path paramPath, t paramt)
  {
    if (paramt != null) {
      a(paramPath, ((Float)paramt.c.a()).floatValue() / 100.0F, ((Float)paramt.a.a()).floatValue() / 100.0F, ((Float)paramt.b.a()).floatValue() / 360.0F);
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static boolean a(i parami, int paramInt)
  {
    int i = parami.i;
    if (i >= 4)
    {
      if (i <= 4)
      {
        i = parami.j;
        if (i < paramInt) {}
      }
      else
      {
        return (i > paramInt) || (parami.k >= 0);
      }
      return false;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */