package com.airbnb.lottie.c;

public final class d
{
  public int a;
  public String b;
  public int c;
  public int d;
  public boolean e;
  public int f;
  public String g;
  public int h;
  private int i;
  private double j;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    this.g = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.i = paramInt2;
    this.h = paramInt3;
    this.j = paramDouble;
    this.a = paramInt4;
    this.d = paramInt5;
    this.f = paramInt6;
    this.e = paramBoolean;
  }
  
  public final int hashCode()
  {
    int k = this.g.hashCode();
    int m = this.b.hashCode();
    int n = this.c;
    int i1 = this.i;
    int i2 = this.h;
    long l = Double.doubleToLongBits(this.j);
    return (((((k * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + (int)(l >>> 32 ^ l)) * 31 + this.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */