package android.support.v4.widget;

final class b
{
  public long a = 0L;
  public int b = 0;
  public int c;
  public int d;
  public int e;
  public long f = Long.MIN_VALUE;
  public long g = -1L;
  public float h;
  public float i;
  public float j;
  
  final float a(long paramLong)
  {
    float f1 = 0.0F;
    long l1 = this.f;
    if (paramLong >= l1)
    {
      long l2 = this.g;
      if ((l2 >= 0L) && (paramLong >= l2))
      {
        f1 = this.h;
        f1 = a.a((float)(paramLong - l2) / this.c, 0.0F, 1.0F) * f1 + (1.0F - f1);
      }
    }
    else
    {
      return f1;
    }
    return a.a((float)(paramLong - l1) / this.e, 0.0F, 1.0F) * 0.5F;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */