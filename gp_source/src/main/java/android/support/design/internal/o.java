package android.support.design.internal;

import android.graphics.PorterDuff.Mode;

public final class o
{
  public static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return paramMode;
    case 16: 
      return PorterDuff.Mode.ADD;
    case 15: 
      return PorterDuff.Mode.SCREEN;
    case 14: 
      return PorterDuff.Mode.MULTIPLY;
    case 9: 
      return PorterDuff.Mode.SRC_ATOP;
    case 5: 
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */