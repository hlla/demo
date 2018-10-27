package android.support.v4.d;

public final class a
{
  public static float a(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      if (paramFloat <= 1.0F) {
        return paramFloat;
      }
      return 1.0F;
    }
    return 0.0F;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= paramInt2)
    {
      if (paramInt1 <= paramInt3) {
        return paramInt1;
      }
      return paramInt3;
    }
    return paramInt2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */