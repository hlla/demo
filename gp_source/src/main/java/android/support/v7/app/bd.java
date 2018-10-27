package android.support.v7.app;

final class bd
{
  public static bd a;
  public int b;
  public long c;
  public long d;
  
  public final void a(long paramLong, double paramDouble1, double paramDouble2)
  {
    float f1 = (float)(-946728000000L + paramLong) / 8.64E7F;
    float f2 = 0.01720197F * f1 + 6.24006F;
    double d2 = f2;
    double d1 = Math.sin(d2) * 0.03341960161924362D + d2 + Math.sin(f2 + f2) * 3.4906598739326E-4D + Math.sin(f2 * 3.0F) * 5.236000106378924E-6D + 1.796593063D + 3.141592653589793D;
    paramDouble2 = -paramDouble2 / 360.0D;
    paramDouble2 = (float)Math.round(f1 - 9.0E-4F - paramDouble2) + 9.0E-4F + paramDouble2 + Math.sin(d2) * 0.0053D + Math.sin(d1 + d1) * -0.0069D;
    d1 = Math.asin(Math.sin(d1) * Math.sin(0.4092797040939331D));
    double d4 = 0.01745329238474369D * paramDouble1;
    paramDouble1 = Math.sin(-0.10471975803375244D);
    d2 = Math.sin(d4);
    double d3 = Math.sin(d1);
    d4 = Math.cos(d4);
    paramDouble1 = (paramDouble1 - d2 * d3) / (Math.cos(d1) * d4);
    if (paramDouble1 < 1.0D)
    {
      if (paramDouble1 > -1.0D)
      {
        paramDouble1 = (float)(Math.acos(paramDouble1) / 6.283185307179586D);
        this.d = (Math.round((paramDouble2 + paramDouble1) * 8.64E7D) + 946728000000L);
        this.c = (Math.round((paramDouble2 - paramDouble1) * 8.64E7D) + 946728000000L);
        if ((this.c < paramLong) && (this.d > paramLong))
        {
          this.b = 0;
          return;
        }
        this.b = 1;
        return;
      }
      this.b = 0;
      this.d = -1L;
      this.c = -1L;
      return;
    }
    this.b = 1;
    this.d = -1L;
    this.c = -1L;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */