package com.google.android.finsky.bw;

import android.content.res.ColorStateList;
import android.graphics.Color;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.utils.FinskyLog;

public final class g
{
  public static int a(int paramInt, float paramFloat)
  {
    float f = (1.0F - paramFloat) * 255.0F;
    int i = (int)((paramInt >> 24 & 0xFF) * paramFloat + f);
    int j = (int)((paramInt >> 16 & 0xFF) * paramFloat + f);
    int k = (int)((paramInt >> 8 & 0xFF) * paramFloat + f);
    return (int)(f + (paramInt & 0xFF) * paramFloat) | i << 24 | j << 16 | k << 8;
  }
  
  public static int a(bu parambu, int paramInt)
  {
    return a(parambu.e, paramInt);
  }
  
  public static int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramString.length() > 0) {}
    try
    {
      i = Color.parseColor(paramString.trim());
      return i;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      FinskyLog.b(localIllegalArgumentException, "Bad color: %s", new Object[] { paramString });
    }
    return paramInt;
  }
  
  public static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { { 16842910 }, { -16842910 }, { -16842912 }, { 16842919 } }, new int[] { paramInt1, paramInt2, paramInt1, paramInt1 });
  }
  
  public static boolean a(int paramInt)
  {
    return Color.red(paramInt) * 21 + Color.green(paramInt) * 72 + Color.blue(paramInt) * 7 >= 12800;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return 0xFFFFFF & paramInt1 | paramInt2 << 24;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */