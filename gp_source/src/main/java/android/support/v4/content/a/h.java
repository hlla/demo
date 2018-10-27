package android.support.v4.content.a;

import android.graphics.Shader.TileMode;

final class h
{
  static Shader.TileMode a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Shader.TileMode.CLAMP;
    case 2: 
      return Shader.TileMode.MIRROR;
    }
    return Shader.TileMode.REPEAT;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */