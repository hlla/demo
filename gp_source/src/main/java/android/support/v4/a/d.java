package android.support.v4.a;

import android.graphics.Path;
import android.util.Log;

public final class d
{
  public float[] a;
  public char b;
  
  d(char paramChar, float[] paramArrayOfFloat)
  {
    this.b = paramChar;
    this.a = paramArrayOfFloat;
  }
  
  d(d paramd)
  {
    this.b = paramd.b;
    paramd = paramd.a;
    this.a = b.a(paramd, paramd.length);
  }
  
  private static void a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
  {
    double d9;
    double d11;
    double d12;
    double d4;
    double d6;
    double d13;
    double d5;
    double d8;
    double d7;
    double d2;
    double d1;
    double d10;
    double d15;
    double d14;
    double d3;
    double d17;
    for (;;)
    {
      d9 = Math.toRadians(paramFloat7);
      d11 = Math.cos(d9);
      d12 = Math.sin(d9);
      d4 = paramFloat1;
      d6 = paramFloat2;
      d13 = paramFloat5;
      d5 = (d4 * d11 + d6 * d12) / d13;
      d8 = paramFloat6;
      d7 = (-paramFloat1 * d12 + d6 * d11) / d8;
      d2 = paramFloat4;
      d1 = (paramFloat3 * d11 + d2 * d12) / d13;
      d10 = (d2 * d11 + -paramFloat3 * d12) / d8;
      d15 = d5 - d1;
      d14 = d7 - d10;
      d3 = (d5 + d1) / 2.0D;
      d2 = (d7 + d10) / 2.0D;
      d16 = d15 * d15 + d14 * d14;
      if (d16 == 0.0D)
      {
        Log.w("PathParser", " Points are coincident");
        return;
      }
      d17 = 1.0D / d16 - 0.25D;
      if (d17 >= 0.0D) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Points are too far apart ");
      localStringBuilder.append(d16);
      Log.w("PathParser", localStringBuilder.toString());
      float f = (float)(Math.sqrt(d16) / 1.99999D);
      paramFloat5 *= f;
      paramFloat6 *= f;
    }
    double d16 = Math.sqrt(d17);
    d15 *= d16;
    d14 *= d16;
    if (paramBoolean1 != paramBoolean2) {
      d3 = d14 + d3;
    }
    for (d2 -= d15;; d2 = d15 + d2)
    {
      d5 = Math.atan2(d7 - d2, d5 - d3);
      d7 = Math.atan2(d10 - d2, d1 - d3) - d5;
      if (d7 < 0.0D) {}
      for (paramBoolean1 = false;; paramBoolean1 = true)
      {
        d1 = d7;
        if (paramBoolean2 != paramBoolean1) {
          if (d7 > 0.0D) {
            break label743;
          }
        }
        label743:
        for (d1 = d7 + 6.283185307179586D;; d1 = d7 - 6.283185307179586D)
        {
          d14 = d3 * d13;
          d15 = d2 * d8;
          int j = (int)Math.ceil(Math.abs(4.0D * d1 / 3.141592653589793D));
          d16 = Math.cos(d9);
          d17 = Math.sin(d9);
          d2 = Math.cos(d5);
          d7 = Math.sin(d5);
          d3 = -d13;
          double d18 = d3 * d16;
          double d19 = d8 * d17;
          double d20 = d3 * d17;
          double d21 = d8 * d16;
          double d22 = d1 / j;
          int i = 0;
          d3 = d6;
          d1 = d18 * d7 - d19 * d2;
          d2 = d2 * d21 + d7 * d20;
          while (i < j)
          {
            d9 = d5 + d22;
            d10 = Math.sin(d9);
            double d23 = Math.cos(d9);
            d7 = d13 * d16 * d23 + (d14 * d11 - d15 * d12) - d19 * d10;
            d8 = d21 * d10 + (d13 * d17 * d23 + (d14 * d12 + d15 * d11));
            d6 = d18 * d10 - d19 * d23;
            d10 = d10 * d20 + d23 * d21;
            d5 = d9 - d5;
            d23 = Math.tan(d5 / 2.0D);
            d5 = Math.sin(d5) * (Math.sqrt(d23 * (3.0D * d23) + 4.0D) - 1.0D) / 3.0D;
            paramPath.rLineTo(0.0F, 0.0F);
            paramPath.cubicTo((float)(d1 * d5 + d4), (float)(d2 * d5 + d3), (float)(d7 - d5 * d6), (float)(d8 - d5 * d10), (float)d7, (float)d8);
            d2 = d10;
            d5 = d9;
            d3 = d8;
            d4 = d7;
            i += 1;
            d1 = d6;
          }
          break;
        }
      }
      d3 -= d14;
    }
  }
  
  public static void a(d[] paramArrayOfd, Path paramPath)
  {
    float[] arrayOfFloat = new float[6];
    int k = 0;
    int j = 109;
    if (k < paramArrayOfd.length)
    {
      Object localObject = paramArrayOfd[k];
      int n = ((d)localObject).b;
      localObject = ((d)localObject).a;
      float f4 = arrayOfFloat[0];
      float f3 = arrayOfFloat[1];
      float f2 = arrayOfFloat[2];
      float f1 = arrayOfFloat[3];
      float f5 = arrayOfFloat[4];
      float f6 = arrayOfFloat[5];
      label248:
      int i;
      switch (n)
      {
      default: 
        i = 2;
      }
      for (;;)
      {
        int i1 = 0;
        float f7 = f6;
        float f8 = f5;
        f6 = f3;
        f5 = f4;
        f4 = f2;
        int m = j;
        f3 = f1;
        f1 = f8;
        f2 = f7;
        j = i1;
        if (j >= localObject.length)
        {
          arrayOfFloat[0] = f5;
          arrayOfFloat[1] = f6;
          arrayOfFloat[2] = f4;
          arrayOfFloat[3] = f3;
          arrayOfFloat[4] = f1;
          arrayOfFloat[5] = f2;
          j = paramArrayOfd[k].b;
          k += 1;
          break;
        }
        label508:
        label759:
        label889:
        boolean bool2;
        switch (n)
        {
        default: 
        case 99: 
        case 118: 
        case 116: 
        case 115: 
        case 113: 
        case 109: 
        case 108: 
        case 104: 
        case 67: 
        case 97: 
        case 86: 
        case 84: 
        case 83: 
        case 81: 
        case 77: 
        case 76: 
        case 72: 
          for (;;)
          {
            f7 = f4;
            f4 = f6;
            f8 = f3;
            f6 = f5;
            f5 = f4;
            f4 = f1;
            f3 = f7;
            f1 = f8;
            for (;;)
            {
              j += i;
              f7 = f4;
              f8 = f6;
              m = n;
              f4 = f3;
              f3 = f1;
              f1 = f7;
              f6 = f5;
              f5 = f8;
              break;
              m = j + 2;
              i1 = j + 3;
              int i2 = j + 4;
              int i3 = j + 5;
              paramPath.rCubicTo(localObject[j], localObject[(j + 1)], localObject[m], localObject[i1], localObject[i2], localObject[i3]);
              f3 = localObject[m];
              f8 = localObject[i1];
              f7 = localObject[i2];
              f4 = localObject[i3];
              f7 = f5 + f7;
              f3 = f5 + f3;
              f5 = f4 + f6;
              f4 = f1;
              f1 = f8 + f6;
              f6 = f7;
              continue;
              paramPath.rLineTo(0.0F, localObject[j]);
              f9 = localObject[j];
              f8 = f1;
              f7 = f5;
              f5 = f9 + f6;
              f1 = f3;
              f3 = f4;
              f4 = f8;
              f6 = f7;
              continue;
              if (m == 113) {
                f4 = f5 - f4;
              }
              for (f3 = f6 - f3;; f3 = 0.0F)
              {
                m = j + 1;
                paramPath.rQuadTo(f4, f3, localObject[j], localObject[m]);
                f7 = localObject[j];
                f9 = localObject[m];
                f7 = f5 + f7;
                f8 = f4 + f5;
                f5 = f9 + f6;
                f4 = f1;
                f1 = f3 + f6;
                f3 = f8;
                f6 = f7;
                break;
                if ((m == 116) || (m == 81) || (m == 84)) {
                  break label759;
                }
                f4 = 0.0F;
              }
              if (m == 99)
              {
                f7 = f5 - f4;
                f4 = f6 - f3;
                f3 = f7;
              }
              for (;;)
              {
                m = j + 1;
                i1 = j + 2;
                i2 = j + 3;
                paramPath.rCubicTo(f3, f4, localObject[j], localObject[m], localObject[i1], localObject[i2]);
                f3 = localObject[j];
                f8 = localObject[m];
                f7 = localObject[i1];
                f4 = localObject[i2];
                f7 = f5 + f7;
                f3 = f5 + f3;
                f5 = f4 + f6;
                f4 = f1;
                f1 = f8 + f6;
                f6 = f7;
                break;
                if ((m == 115) || (m == 67) || (m == 83)) {
                  break label889;
                }
                f3 = 0.0F;
                f4 = 0.0F;
              }
              m = j + 1;
              i1 = j + 2;
              i2 = j + 3;
              paramPath.rQuadTo(localObject[j], localObject[m], localObject[i1], localObject[i2]);
              f3 = localObject[j];
              f8 = localObject[m];
              f7 = localObject[i1];
              f4 = localObject[i2];
              f7 = f5 + f7;
              f3 += f5;
              f5 = f4 + f6;
              f4 = f1;
              f1 = f8 + f6;
              f6 = f7;
              continue;
              f7 = localObject[j];
              f5 += f7;
              f8 = localObject[(j + 1)];
              f6 += f8;
              if (j > 0)
              {
                paramPath.rLineTo(f7, f8);
                f7 = f5;
                f5 = f6;
                f6 = f1;
                f1 = f3;
                f3 = f4;
                f4 = f6;
                f6 = f7;
              }
              else
              {
                paramPath.rMoveTo(f7, f8);
                f7 = f5;
                f8 = f6;
                f1 = f3;
                f2 = f6;
                f3 = f4;
                f4 = f5;
                f5 = f8;
                f6 = f7;
                continue;
                m = j + 1;
                paramPath.rLineTo(localObject[j], localObject[m]);
                f7 = localObject[j];
                f8 = localObject[m];
                f7 = f5 + f7;
                f6 = f8 + f6;
                f5 = f1;
                f1 = f3;
                f3 = f4;
                f4 = f5;
                f5 = f6;
                f6 = f7;
                continue;
                paramPath.rLineTo(localObject[j], 0.0F);
                f5 += localObject[j];
                break label508;
                m = j + 2;
                i1 = j + 3;
                i2 = j + 4;
                i3 = j + 5;
                paramPath.cubicTo(localObject[j], localObject[(j + 1)], localObject[m], localObject[i1], localObject[i2], localObject[i3]);
                f6 = localObject[i2];
                f5 = localObject[i3];
                f3 = localObject[m];
                f7 = localObject[i1];
                f4 = f1;
                f1 = f7;
                continue;
                m = j + 5;
                f3 = localObject[m];
                i1 = j + 6;
                f4 = localObject[i1];
                f7 = localObject[j];
                f8 = localObject[(j + 1)];
                f9 = localObject[(j + 2)];
                if (localObject[(j + 3)] != 0.0F) {}
                for (bool1 = true;; bool1 = false)
                {
                  if (localObject[(j + 4)] != 0.0F) {}
                  for (bool2 = true;; bool2 = false)
                  {
                    a(paramPath, f5, f6, f3 + f5, f4 + f6, f7, f8, f9, bool1, bool2);
                    f3 = f5 + localObject[m];
                    f5 = localObject[i1] + f6;
                    f4 = f5;
                    f6 = f3;
                    f7 = f1;
                    f1 = f4;
                    f4 = f7;
                    break;
                  }
                }
                paramPath.lineTo(f5, localObject[j]);
                f8 = localObject[j];
                f7 = f1;
                f6 = f5;
                f5 = f8;
                f1 = f3;
                f3 = f4;
                f4 = f7;
                continue;
                if (m == 113)
                {
                  label1674:
                  f5 = f5 + f5 - f4;
                  f6 = f6 + f6 - f3;
                }
                for (;;)
                {
                  m = j + 1;
                  paramPath.quadTo(f5, f6, localObject[j], localObject[m]);
                  f4 = localObject[j];
                  f7 = localObject[m];
                  f3 = f6;
                  f6 = f4;
                  f4 = f5;
                  f5 = f7;
                  f7 = f1;
                  f1 = f3;
                  f3 = f4;
                  f4 = f7;
                  break;
                  if ((m == 116) || (m == 81) || (m == 84)) {
                    break label1674;
                  }
                }
                if (m == 99)
                {
                  label1796:
                  f4 = f5 + f5 - f4;
                  f6 = f6 + f6 - f3;
                }
                for (f3 = f4;; f3 = f5)
                {
                  m = j + 1;
                  i1 = j + 2;
                  i2 = j + 3;
                  paramPath.cubicTo(f3, f6, localObject[j], localObject[m], localObject[i1], localObject[i2]);
                  f3 = localObject[j];
                  f7 = localObject[m];
                  f6 = localObject[i1];
                  f5 = localObject[i2];
                  f4 = f1;
                  f1 = f7;
                  break;
                  if ((m == 115) || (m == 67) || (m == 83)) {
                    break label1796;
                  }
                }
                m = j + 1;
                i1 = j + 2;
                i2 = j + 3;
                paramPath.quadTo(localObject[j], localObject[m], localObject[i1], localObject[i2]);
                f3 = localObject[j];
                f7 = localObject[m];
                f6 = localObject[i1];
                f5 = localObject[i2];
                f4 = f1;
                f1 = f7;
                continue;
                f5 = localObject[j];
                f6 = localObject[(j + 1)];
                if (j > 0)
                {
                  paramPath.lineTo(f5, f6);
                  f7 = f5;
                  f5 = f6;
                  f6 = f1;
                  f1 = f3;
                  f3 = f4;
                  f4 = f6;
                  f6 = f7;
                }
                else
                {
                  paramPath.moveTo(f5, f6);
                  f7 = f5;
                  f8 = f6;
                  f1 = f3;
                  f2 = f6;
                  f3 = f4;
                  f4 = f5;
                  f5 = f8;
                  f6 = f7;
                  continue;
                  m = j + 1;
                  paramPath.lineTo(localObject[j], localObject[m]);
                  f6 = localObject[j];
                  f5 = localObject[m];
                  f7 = f1;
                  f1 = f3;
                  f3 = f4;
                  f4 = f7;
                }
              }
            }
            paramPath.lineTo(localObject[j], f6);
            f5 = localObject[j];
          }
        }
        m = j + 5;
        f3 = localObject[m];
        i1 = j + 6;
        f4 = localObject[i1];
        f7 = localObject[j];
        f8 = localObject[(j + 1)];
        float f9 = localObject[(j + 2)];
        if (localObject[(j + 3)] != 0.0F) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          if (localObject[(j + 4)] != 0.0F) {}
          for (bool2 = true;; bool2 = false)
          {
            a(paramPath, f5, f6, f3, f4, f7, f8, f9, bool1, bool2);
            f3 = localObject[m];
            f5 = localObject[i1];
            f4 = f5;
            f6 = f3;
            f7 = f1;
            f1 = f4;
            f4 = f7;
            break;
          }
        }
        i = 7;
        continue;
        paramPath.close();
        paramPath.moveTo(f5, f6);
        f1 = f6;
        f2 = f5;
        f3 = f6;
        f4 = f5;
        break label248;
        i = 6;
        continue;
        i = 4;
        continue;
        i = 2;
        continue;
        i = 1;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */