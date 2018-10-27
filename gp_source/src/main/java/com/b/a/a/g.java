package com.b.a.a;

import com.a.a.e;
import java.nio.ByteBuffer;

public final class g
{
  public static final g a = new g(1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  private static final g b = new g(-1.0D, 0.0D, 0.0D, -1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  private static final g c = new g(0.0D, -1.0D, 1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  private static final g d = new g(0.0D, 1.0D, -1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  private final double e;
  private final double f;
  private final double g;
  private final double h;
  private final double i;
  private final double j;
  private final double k;
  private final double l;
  private final double m;
  
  private g(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
  {
    this.k = paramDouble5;
    this.l = paramDouble6;
    this.m = paramDouble7;
    this.e = paramDouble1;
    this.f = paramDouble2;
    this.g = paramDouble3;
    this.h = paramDouble4;
    this.i = paramDouble8;
    this.j = paramDouble9;
  }
  
  public static g a(ByteBuffer paramByteBuffer)
  {
    double d1 = e.d(paramByteBuffer);
    double d2 = e.d(paramByteBuffer);
    double d3 = e.e(paramByteBuffer);
    double d4 = e.d(paramByteBuffer);
    double d5 = e.d(paramByteBuffer);
    double d6 = e.e(paramByteBuffer);
    double d7 = e.d(paramByteBuffer);
    double d8 = e.d(paramByteBuffer);
    return new g(d1, d2, d4, d5, d3, d6, e.e(paramByteBuffer), d7, d8);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        break label171;
      }
      paramObject = (g)paramObject;
      if (Double.compare(((g)paramObject).e, this.e) != 0) {
        break label169;
      }
      if (Double.compare(((g)paramObject).f, this.f) != 0) {
        break label167;
      }
      if (Double.compare(((g)paramObject).g, this.g) != 0) {
        break label165;
      }
      if (Double.compare(((g)paramObject).h, this.h) != 0) {
        break label163;
      }
      if (Double.compare(((g)paramObject).i, this.i) != 0) {
        break label161;
      }
      if (Double.compare(((g)paramObject).j, this.j) != 0) {
        break label159;
      }
      if (Double.compare(((g)paramObject).k, this.k) != 0) {
        break label157;
      }
      if (Double.compare(((g)paramObject).l, this.l) != 0) {}
    }
    else
    {
      return Double.compare(((g)paramObject).m, this.m) == 0;
    }
    return false;
    label157:
    return false;
    label159:
    return false;
    label161:
    return false;
    label163:
    return false;
    label165:
    return false;
    label167:
    return false;
    label169:
    return false;
    label171:
    return false;
  }
  
  public final int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.k);
    long l2 = Double.doubleToLongBits(this.l);
    long l3 = Double.doubleToLongBits(this.m);
    long l4 = Double.doubleToLongBits(this.e);
    long l5 = Double.doubleToLongBits(this.f);
    long l6 = Double.doubleToLongBits(this.g);
    long l7 = Double.doubleToLongBits(this.h);
    long l8 = Double.doubleToLongBits(this.i);
    long l9 = Double.doubleToLongBits(this.j);
    return ((((((((int)(l1 ^ l1 >>> 32) * 31 + (int)(l2 ^ l2 >>> 32)) * 31 + (int)(l3 >>> 32 ^ l3)) * 31 + (int)(l4 >>> 32 ^ l4)) * 31 + (int)(l5 >>> 32 ^ l5)) * 31 + (int)(l6 >>> 32 ^ l6)) * 31 + (int)(l7 >>> 32 ^ l7)) * 31 + (int)(l8 >>> 32 ^ l8)) * 31 + (int)(l9 >>> 32 ^ l9);
  }
  
  public final String toString()
  {
    if (equals(a)) {
      return "Rotate 0°";
    }
    if (equals(d)) {
      return "Rotate 90°";
    }
    if (equals(b)) {
      return "Rotate 180°";
    }
    if (equals(c)) {
      return "Rotate 270°";
    }
    double d1 = this.k;
    double d2 = this.l;
    double d3 = this.m;
    double d4 = this.e;
    double d5 = this.f;
    double d6 = this.g;
    double d7 = this.h;
    double d8 = this.i;
    double d9 = this.j;
    StringBuilder localStringBuilder = new StringBuilder(260);
    localStringBuilder.append("Matrix{u=");
    localStringBuilder.append(d1);
    localStringBuilder.append(", v=");
    localStringBuilder.append(d2);
    localStringBuilder.append(", w=");
    localStringBuilder.append(d3);
    localStringBuilder.append(", a=");
    localStringBuilder.append(d4);
    localStringBuilder.append(", b=");
    localStringBuilder.append(d5);
    localStringBuilder.append(", c=");
    localStringBuilder.append(d6);
    localStringBuilder.append(", d=");
    localStringBuilder.append(d7);
    localStringBuilder.append(", tx=");
    localStringBuilder.append(d8);
    localStringBuilder.append(", ty=");
    localStringBuilder.append(d9);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/b/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */