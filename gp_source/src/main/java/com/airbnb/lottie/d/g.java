package com.airbnb.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.c.b.p;
import com.airbnb.lottie.c.c;
import java.util.List;

public final class g
{
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat3, paramFloat1));
  }
  
  public static int a(float paramFloat1, float paramFloat2)
  {
    int k = (int)paramFloat1;
    int m = (int)paramFloat2;
    int j = k / m;
    int i = j;
    if ((k ^ m) < 0)
    {
      i = j;
      if (j * m != k) {
        i = j - 1;
      }
    }
    return k - i * m;
  }
  
  public static PointF a(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF(paramPointF1.x + paramPointF2.x, paramPointF1.y + paramPointF2.y);
  }
  
  public static void a(p paramp, Path paramPath)
  {
    paramPath.reset();
    PointF localPointF1 = paramp.c;
    paramPath.moveTo(localPointF1.x, localPointF1.y);
    localPointF1 = new PointF(localPointF1.x, localPointF1.y);
    int i = 0;
    if (i >= paramp.b.size())
    {
      if (paramp.a) {
        paramPath.close();
      }
      return;
    }
    Object localObject = (c)paramp.b.get(i);
    PointF localPointF2 = ((c)localObject).a;
    PointF localPointF3 = ((c)localObject).b;
    localObject = ((c)localObject).c;
    if ((localPointF2.equals(localPointF1)) && (localPointF3.equals(localObject))) {
      paramPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
    }
    for (;;)
    {
      localPointF1.set(((PointF)localObject).x, ((PointF)localObject).y);
      i += 1;
      break;
      paramPath.cubicTo(localPointF2.x, localPointF2.y, localPointF3.x, localPointF3.y, ((PointF)localObject).x, ((PointF)localObject).y);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */