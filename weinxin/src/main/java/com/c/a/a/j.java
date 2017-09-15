package com.c.a.a;

import java.lang.reflect.Array;

final class j
{
  private double[] aJZ = new double[4];
  final b aKa = new b();
  private final b aKb = new b();
  
  private void a(double paramDouble, boolean paramBoolean)
  {
    double d3 = paramDouble - this.aKa.aKc;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.aKa.aKM[2][2] = this.aKa.aKG;
      this.aKa.aKM[2][3] = 0L;
      this.aKa.aKM[3][2] = 0L;
      this.aKa.aKM[3][3] = this.aKa.aKG;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label500;
        }
        localObject = this.aKa;
        ((b)localObject).aKO = (d2 * ((b)localObject).aKO);
      }
      this.aKa.aKL[0] += this.aKa.aKL[2] * d3;
      this.aKa.aKL[1] += this.aKa.aKL[3] * d3;
      if (!this.aKa.aKQ) {
        break label521;
      }
      this.aKa.aKM[0][0] += this.aKa.aKM[2][2] * d4;
      this.aKa.aKM[0][1] += this.aKa.aKM[2][3] * d4;
      this.aKa.aKM[1][0] += this.aKa.aKM[3][2] * d4;
      this.aKa.aKM[1][1] += this.aKa.aKM[3][3] * d4;
    }
    for (;;)
    {
      this.aKa.aKc = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {
        d2 = 0.0D;
      }
      for (;;)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.aKa.aKM[2];
          localObject[2] *= d2;
          localObject = this.aKa.aKM[2];
          localObject[3] *= d2;
          localObject = this.aKa.aKM[3];
          localObject[2] *= d2;
          localObject = this.aKa.aKM[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        double d5 = this.aKa.aKp;
        d2 = 1.0D + d2;
        d1 = d5 * d1;
      }
      label500:
      d2 *= this.aKa.aKP;
      d1 += 1.0D;
      break label97;
      label521:
      this.aKa.aKM[0][0] = (this.aKa.aKM[0][0] + (this.aKa.aKM[0][2] + this.aKa.aKM[2][0]) * d3 + this.aKa.aKM[2][2] * d4);
      this.aKa.aKM[1][1] = (this.aKa.aKM[1][1] + (this.aKa.aKM[1][3] + this.aKa.aKM[3][1]) * d3 + this.aKa.aKM[3][3] * d4);
      this.aKa.aKM[0][2] += this.aKa.aKM[2][2] * d3;
      this.aKa.aKM[2][0] += this.aKa.aKM[2][2] * d3;
      this.aKa.aKM[1][3] += this.aKa.aKM[3][3] * d3;
      this.aKa.aKM[3][1] += this.aKa.aKM[3][3] * d3;
    }
  }
  
  private void a(double[] paramArrayOfDouble)
  {
    double d3;
    double d1;
    double d4;
    int i;
    if ((this.aKa.aKJ) && (this.aKa.aKt))
    {
      Object localObject = new double[2];
      double[] arrayOfDouble = new double[2];
      double d5 = this.aKa.aKV;
      localObject[0] = (this.aKa.aKL[0] - this.aKa.aKu[0]);
      localObject[1] = (this.aKa.aKL[1] - this.aKa.aKu[1]);
      paramArrayOfDouble[0] -= this.aKa.aKu[0];
      paramArrayOfDouble[1] -= this.aKa.aKu[1];
      double d2 = Math.sqrt(localObject[0] * localObject[0] + localObject[1] * localObject[1]);
      d3 = Math.sqrt(arrayOfDouble[0] * arrayOfDouble[0] + arrayOfDouble[1] * arrayOfDouble[1]);
      if ((d2 > this.aKa.aKB) && (d3 > this.aKa.aKB))
      {
        d1 = Math.atan2(localObject[1], localObject[0]);
        d4 = Math.atan2(arrayOfDouble[1], arrayOfDouble[0]) - d1;
        if (d4 <= 3.141592653589793D) {
          break label370;
        }
        d1 = d4 - 6.283185307179586D;
        localObject = this.aKa;
        ((b)localObject).aKN = (d5 * d1 + ((b)localObject).aKN);
        if (d1 * d1 <= 4.0D * this.aKa.aKO) {
          break label392;
        }
        i = 1;
        label278:
        d4 = Math.sqrt(this.aKa.aKM[0][0] + this.aKa.aKM[1][1]);
        if (d2 >= d3) {
          break label398;
        }
        d1 = d2;
        label317:
        d1 = d4 / d1;
        if (i == 0) {
          break label404;
        }
      }
    }
    label370:
    label392:
    label398:
    label404:
    for (this.aKa.aKO = (d1 * d1);; this.aKa.aKO = (1.0D / (1.0D / (d1 * d1) + 1.0D / this.aKa.aKO)))
    {
      this.aKa.aKu[0] = paramArrayOfDouble[0];
      this.aKa.aKu[1] = paramArrayOfDouble[1];
      this.aKa.aKt = true;
      return;
      d1 = d4;
      if (d4 >= -3.141592653589793D) {
        break;
      }
      d1 = d4 + 6.283185307179586D;
      break;
      i = 0;
      break label278;
      d1 = d3;
      break label317;
    }
  }
  
  private static void a(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double d = 1.0D / (paramArrayOfDouble1[0] * paramArrayOfDouble1[3] - paramArrayOfDouble1[1] * paramArrayOfDouble1[2]);
    paramArrayOfDouble2[0] = (paramArrayOfDouble1[3] * d);
    paramArrayOfDouble2[3] = (paramArrayOfDouble1[0] * d);
    paramArrayOfDouble2[1] = (-paramArrayOfDouble1[1] * d);
    paramArrayOfDouble2[2] = (d * -paramArrayOfDouble1[2]);
  }
  
  private static boolean a(double[][] paramArrayOfDouble1, double[][] paramArrayOfDouble2)
  {
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
    arrayOfDouble[0][0] = (paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[2][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[2][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[3][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[3][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[1][0] = (-paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[2][0] = (paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[3][0] = (-paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[0][1] = (-paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[1][1] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[2][1] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[3][1] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[0][2] = (paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] - paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[1][2] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[2][2] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][1]);
    arrayOfDouble[3][2] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][1]);
    arrayOfDouble[0][3] = (-paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] + paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[1][3] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[2][3] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][1] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][1] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][1]);
    arrayOfDouble[3][3] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][1] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][1] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][1]);
    double d = paramArrayOfDouble1[0][0] * arrayOfDouble[0][0] + paramArrayOfDouble1[0][1] * arrayOfDouble[1][0] + paramArrayOfDouble1[0][2] * arrayOfDouble[2][0] + paramArrayOfDouble1[0][3] * arrayOfDouble[3][0];
    if (d == 0.0D) {
      return false;
    }
    d = 1.0D / d;
    int i = 0;
    if (i >= 4) {
      return true;
    }
    int j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      arrayOfDouble[i][j] *= d;
      j += 1;
    }
  }
  
  private void b(double paramDouble, boolean paramBoolean)
  {
    double d3 = paramDouble - this.aKb.aKc;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.aKb.aKM[2][2] = this.aKb.aKG;
      this.aKb.aKM[2][3] = 0L;
      this.aKb.aKM[3][2] = 0L;
      this.aKb.aKM[3][3] = this.aKb.aKG;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label500;
        }
        localObject = this.aKb;
        ((b)localObject).aKO = (d2 * ((b)localObject).aKO);
      }
      this.aKb.aKL[0] += this.aKb.aKL[2] * d3;
      this.aKb.aKL[1] += this.aKb.aKL[3] * d3;
      if (!this.aKb.aKQ) {
        break label521;
      }
      this.aKb.aKM[0][0] += this.aKb.aKM[2][2] * d4;
      this.aKb.aKM[0][1] += this.aKb.aKM[2][3] * d4;
      this.aKb.aKM[1][0] += this.aKb.aKM[3][2] * d4;
      this.aKb.aKM[1][1] += this.aKb.aKM[3][3] * d4;
    }
    for (;;)
    {
      this.aKb.aKc = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {
        d2 = 0.0D;
      }
      for (;;)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.aKb.aKM[2];
          localObject[2] *= d2;
          localObject = this.aKb.aKM[2];
          localObject[3] *= d2;
          localObject = this.aKb.aKM[3];
          localObject[2] *= d2;
          localObject = this.aKb.aKM[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        double d5 = this.aKb.aKp;
        d2 = 1.0D + d2;
        d1 = d5 * d1;
      }
      label500:
      d2 *= this.aKb.aKP;
      d1 += 1.0D;
      break label97;
      label521:
      this.aKb.aKM[0][0] = (this.aKb.aKM[0][0] + (this.aKb.aKM[0][2] + this.aKb.aKM[2][0]) * d3 + this.aKb.aKM[2][2] * d4);
      this.aKb.aKM[1][1] = (this.aKb.aKM[1][1] + (this.aKb.aKM[1][3] + this.aKb.aKM[3][1]) * d3 + this.aKb.aKM[3][3] * d4);
      this.aKb.aKM[0][2] += this.aKb.aKM[2][2] * d3;
      this.aKb.aKM[2][0] += this.aKb.aKM[2][2] * d3;
      this.aKb.aKM[1][3] += this.aKb.aKM[3][3] * d3;
      this.aKb.aKM[3][1] += this.aKb.aKM[3][3] * d3;
    }
  }
  
  void a(int paramInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramArrayOfDouble2[0] = ((paramArrayOfDouble1[1] - this.aKa.aKH[1]) * 6378137.0D * Math.cos(this.aKa.aKH[0]));
      paramArrayOfDouble2[1] = ((paramArrayOfDouble1[0] - this.aKa.aKH[0]) * 6378137.0D);
      return;
    }
    paramArrayOfDouble2[0] = (paramArrayOfDouble1[1] / 6378137.0D + this.aKa.aKH[0]);
    paramArrayOfDouble2[1] = (paramArrayOfDouble1[0] / (Math.cos(this.aKa.aKH[0]) * 6378137.0D) + this.aKa.aKH[1]);
  }
  
  protected final void a(long paramLong, double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    double d1 = paramLong;
    double d2 = paramFloat * paramFloat;
    double[] arrayOfDouble1 = new double[2];
    double[] tmp19_17 = arrayOfDouble1;
    tmp19_17[0] = 0.0D;
    double[] tmp23_19 = tmp19_17;
    tmp23_19[1] = 0.0D;
    tmp23_19;
    if (paramBoolean1) {}
    for (int i = 3;; i = 5)
    {
      double[] arrayOfDouble2 = new double[2];
      arrayOfDouble2[0] = paramDouble1;
      arrayOfDouble2[1] = paramDouble2;
      this.aKa.aKQ = true;
      this.aKa.aKX[0] = 3.0D;
      this.aKa.aKX[1] = 1.2D;
      this.aKa.aKV = 0.5D;
      this.aKa.aKp = 1.2D;
      this.aKa.aKv = 4.0D;
      this.aKa.aKw = 0;
      this.aKa.aKy = true;
      this.aKa.aKx = i;
      this.aKa.aKq = false;
      this.aKa.aKt = false;
      this.aKa.aKE = 40.0D;
      this.aKa.aKF = 0.15707963267948966D;
      this.aKa.aKG = 1.0D;
      this.aKa.aKW[0] = 400.0D;
      this.aKa.aKW[1] = 1.0D;
      this.aKa.aKJ = paramBoolean2;
      this.aKa.aKK = false;
      this.aKa.aKz = true;
      this.aKa.aKA = 0.3333333333333333D;
      this.aKa.aKB = 5.0D;
      this.aKa.aKC = 0.5D;
      this.aKa.aKD = 1.0D;
      this.aKa.aKR = 0.5D;
      this.aKa.aKS = 1.0D;
      this.aKa.aKT = 0;
      this.aKa.aKU = 2;
      this.aKa.aKY = false;
      this.aKa.aKH[0] = arrayOfDouble2[0];
      this.aKa.aKH[1] = arrayOfDouble2[1];
      arrayOfDouble2 = new double[2];
      a(0, new double[] { paramDouble1, paramDouble2 }, arrayOfDouble2);
      this.aKa.aKc = d1;
      this.aKa.aKL[0] = arrayOfDouble2[0];
      this.aKa.aKL[1] = arrayOfDouble2[1];
      this.aKa.aKL[2] = arrayOfDouble1[0];
      this.aKa.aKL[3] = arrayOfDouble1[1];
      this.aKa.aKN = 0.0D;
      this.aKa.aKO = 1.0D;
      this.aKa.aKP = 1.005D;
      this.aKa.aKM[0][0] = tmp19_17;
      this.aKa.aKM[0][1] = 0L;
      this.aKa.aKM[0][2] = 0L;
      this.aKa.aKM[0][3] = 0L;
      this.aKa.aKM[1][0] = 0L;
      this.aKa.aKM[1][1] = tmp19_17;
      this.aKa.aKM[1][2] = 0L;
      this.aKa.aKM[1][3] = 0L;
      this.aKa.aKM[2][0] = 0L;
      this.aKa.aKM[2][1] = 0L;
      this.aKa.aKM[2][2] = 4607182418800017408L;
      this.aKa.aKM[2][3] = 0L;
      this.aKa.aKM[3][0] = 0L;
      this.aKa.aKM[3][1] = 0L;
      this.aKa.aKM[3][2] = 0L;
      this.aKa.aKM[3][3] = 4607182418800017408L;
      ai(paramBoolean1);
      return;
    }
  }
  
  protected final void a(a parama)
  {
    if (parama.aKh <= 0.0D) {}
    double[] arrayOfDouble1;
    Object localObject1;
    label1101:
    label1155:
    label1163:
    label1171:
    int i;
    for (;;)
    {
      return;
      if (this.aKa.aKq)
      {
        d1 = parama.aKc - this.aKa.aKs;
        if (d1 < -10.0D) {
          continue;
        }
        if (d1 <= 0.0D) {
          parama.aKc = (this.aKa.aKs + 0.5D);
        }
      }
      arrayOfDouble1 = new double[2];
      a(0, new double[] { parama.aKd, parama.aKe }, arrayOfDouble1);
      parama.aKf[0] = arrayOfDouble1[0];
      parama.aKf[1] = arrayOfDouble1[1];
      if (this.aKa.aKQ)
      {
        double d5;
        if ((parama.mType != 3) || (this.aKa.aKq))
        {
          if (parama.mType != 3) {
            break label1171;
          }
          d5 = parama.aKc - this.aKa.aKs;
          if (d5 > 0.0D)
          {
            localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
            localObject1 = new double[2];
            d4 = arrayOfDouble1[0] - this.aKa.aKr[0];
            d3 = arrayOfDouble1[1] - this.aKa.aKr[1];
            d1 = d3;
            d2 = d4;
            if (this.aKa.aKJ)
            {
              d2 = d4 * Math.cos(this.aKa.aKN) - Math.sin(this.aKa.aKN) * d3;
              d1 = Math.sin(this.aKa.aKN);
              d1 = d3 * Math.cos(this.aKa.aKN) + d1 * d2;
            }
            d4 = Math.sqrt(d2 * d2 + d1 * d1);
            d3 = d4 / this.aKa.aKE;
            d3 *= d3;
            if (d3 <= 0.0625D) {
              break label1155;
            }
            d4 *= this.aKa.aKF;
            d4 *= d4;
            if (d4 <= 0.0625D) {
              break label1163;
            }
          }
        }
        for (;;)
        {
          d3 = (d3 + d4) / d5;
          d4 = this.aKa.aKM[2][2];
          double d6 = this.aKa.aKM[2][3];
          double d7 = this.aKa.aKM[3][2];
          double d8 = this.aKa.aKM[3][3];
          localObject3 = this.aJZ;
          a(new double[] { d4, d6, d7, d8 }, (double[])localObject3);
          localObject2[0][0] = this.aJZ[0];
          localObject2[0][1] = this.aJZ[1];
          localObject2[1][0] = this.aJZ[2];
          localObject2[1][1] = this.aJZ[3];
          d4 = d2 / d5 - this.aKa.aKL[2];
          d6 = d1 / d5 - this.aKa.aKL[3];
          d7 = localObject2[0][0];
          d8 = localObject2[0][1];
          if (Math.sqrt(d4 * d6 * localObject2[1][0] + (d4 * d4 * d7 + d4 * d6 * d8) + d6 * d6 * localObject2[1][1]) > 2.0D)
          {
            this.aKa.aKM[2][2] = this.aKa.aKG;
            this.aKa.aKM[2][3] = 0L;
            this.aKa.aKM[3][2] = 0L;
            this.aKa.aKM[3][3] = this.aKa.aKG;
            localObject2[0][0] = (1.0D / this.aKa.aKG);
            localObject2[0][1] = 0L;
            localObject2[1][0] = 0L;
            localObject2[1][1] = (1.0D / this.aKa.aKG);
          }
          localObject1[0] = (localObject2[0][0] * this.aKa.aKL[2] + localObject2[0][1] * this.aKa.aKL[3]);
          localObject1[1] = (localObject2[1][0] * this.aKa.aKL[2] + localObject2[1][1] * this.aKa.aKL[3]);
          localObject3 = localObject2[0];
          localObject3[0] += 1.0D / d3;
          localObject3 = localObject2[1];
          localObject3[1] += 1.0D / d3;
          d4 = localObject1[0];
          localObject1[0] = (d2 / (d5 * d3) + d4);
          d2 = localObject1[1];
          localObject1[1] = (d1 / (d3 * d5) + d2);
          d1 = localObject2[0][0];
          d2 = localObject2[0][1];
          d3 = localObject2[1][0];
          d4 = localObject2[1][1];
          localObject2 = this.aJZ;
          a(new double[] { d1, d2, d3, d4 }, (double[])localObject2);
          this.aKa.aKM[2][2] = this.aJZ[0];
          this.aKa.aKM[2][3] = this.aJZ[1];
          this.aKa.aKM[3][2] = this.aJZ[2];
          this.aKa.aKM[3][3] = this.aJZ[3];
          this.aKa.aKL[2] = (this.aKa.aKM[2][2] * localObject1[0] + this.aKa.aKM[2][3] * localObject1[1]);
          this.aKa.aKL[3] = (this.aKa.aKM[3][2] * localObject1[0] + this.aKa.aKM[3][3] * localObject1[1]);
          a(parama.aKc, false);
          if (parama.mType != 3) {
            break label2484;
          }
          this.aKa.aKr[0] = arrayOfDouble1[0];
          this.aKa.aKr[1] = arrayOfDouble1[1];
          this.aKa.aKs = parama.aKc;
          this.aKa.aKq = true;
          return;
          d3 = 0.0625D;
          break;
          d4 = 0.0625D;
        }
        localObject2 = new double[2];
        localObject1 = new double[2];
        a(parama.aKc, false);
        if (this.aKa.aKz)
        {
          if (!this.aKa.aKt)
          {
            j = 1;
            d1 = 0.0D;
            i = 1;
            d2 = 0.0D;
            label1221:
            if (i == 0) {
              break label2056;
            }
            if (this.aKa.aKt)
            {
              if (d2 >= d1) {
                break label2058;
              }
              d3 = this.aKa.aKC;
              label1252:
              d1 = d3 + d1 / d2 * (1.0D - d3);
              arrayOfDouble1[0] = (this.aKa.aKu[0] + localObject1[0] * d1);
              d2 = this.aKa.aKu[1];
              arrayOfDouble1[1] = (d1 * localObject1[1] + d2);
            }
            if (j == 0) {
              break label2070;
            }
            a(arrayOfDouble1);
          }
          for (;;)
          {
            this.aKa.aKL[0] = arrayOfDouble1[0];
            this.aKa.aKL[1] = arrayOfDouble1[1];
            this.aKa.aKM[0][0] = (parama.aKh * parama.aKh);
            this.aKa.aKM[0][1] = 0L;
            this.aKa.aKM[1][0] = 0L;
            this.aKa.aKM[1][1] = (parama.aKh * parama.aKh);
            break;
            localObject2[0] = (this.aKa.aKL[0] - this.aKa.aKu[0]);
            localObject2[1] = (this.aKa.aKL[1] - this.aKa.aKu[1]);
            arrayOfDouble1[0] -= this.aKa.aKu[0];
            arrayOfDouble1[1] -= this.aKa.aKu[1];
            d2 = Math.sqrt(localObject2[0] * localObject2[0] + localObject2[1] * localObject2[1]);
            d1 = Math.sqrt(localObject1[0] * localObject1[0] + localObject1[1] * localObject1[1]);
            if ((d1 > this.aKa.aKB) && (d2 > this.aKa.aKB))
            {
              d3 = d1 / d2;
              d4 = d1 - d2;
              d5 = Math.sqrt(this.aKa.aKM[0][0] + this.aKa.aKM[1][1]);
              if (d2 > 3.0D * this.aKa.aKB)
              {
                d3 = d4;
                if (d4 < 0.0D) {
                  d3 = -d4;
                }
                d5 = d3 / d5;
                d3 = Math.atan2(localObject2[1], localObject2[0]);
                d4 = Math.atan2(localObject1[1], localObject1[0]) - d3;
                if (d4 > 3.141592653589793D)
                {
                  d3 = d4 - 6.283185307179586D;
                  label1693:
                  d4 = d3;
                  if (d3 < 0.0D) {
                    d4 = -d3;
                  }
                  d3 = d4 / Math.sqrt(this.aKa.aKO);
                  d4 = Math.sqrt(d3 * d3 + d5 * d5);
                  if (d4 >= this.aKa.aKv) {
                    break label1821;
                  }
                  this.aKa.aKT = 0;
                  d3 = d4;
                }
                for (;;)
                {
                  if (d3 <= this.aKa.aKv) {
                    break label1891;
                  }
                  d3 = d1;
                  j = 0;
                  i = 0;
                  d1 = d2;
                  d2 = d3;
                  break;
                  d3 = d4;
                  if (d4 >= -3.141592653589793D) {
                    break label1693;
                  }
                  d3 = d4 + 6.283185307179586D;
                  break label1693;
                  label1821:
                  d3 = d4;
                  if (d5 < this.aKa.aKv)
                  {
                    localObject2 = this.aKa;
                    i = ((b)localObject2).aKT + 1;
                    ((b)localObject2).aKT = i;
                    d3 = d4;
                    if (i >= this.aKa.aKU)
                    {
                      this.aKa.aKT = 0;
                      d3 = d5;
                    }
                  }
                }
                label1891:
                d3 = d1;
                j = 1;
                i = 1;
                d1 = d2;
                d2 = d3;
                break label1221;
              }
              if ((d3 < this.aKa.aKA) || (1.0D / d3 < this.aKa.aKA))
              {
                d3 = d1;
                j = 0;
                i = 0;
                d1 = d2;
                d2 = d3;
                break label1221;
              }
              d3 = d1;
              j = 0;
              i = 1;
              d1 = d2;
              d2 = d3;
              break label1221;
            }
            if (((d1 < this.aKa.aKB) && (parama.mType == 2)) || ((d1 < this.aKa.aKB * 0.5D) && (parama.mType == 1)))
            {
              d3 = d1;
              j = 0;
              i = 0;
              d1 = d2;
              d2 = d3;
              break label1221;
            }
            d3 = d1;
            j = 0;
            i = 1;
            d1 = d2;
            d2 = d3;
            break label1221;
            label2056:
            break;
            label2058:
            d3 = this.aKa.aKD;
            break label1252;
            label2070:
            this.aKa.aKu[0] = arrayOfDouble1[0];
            this.aKa.aKu[1] = arrayOfDouble1[1];
          }
        }
        this.aKb.a(this.aKa);
        b(parama.aKc, false);
        if (this.aKb.aKy) {
          if (!this.aKa.aKt)
          {
            d1 = 0.0D;
            label2141:
            if (d1 <= this.aKa.aKv) {
              break label3184;
            }
            this.aKb.a(this.aKa);
            b(parama.aKc, true);
            if (!this.aKa.aKy) {
              break label2894;
            }
            d3 = this.aKa.aKu[0] - this.aKb.aKL[0];
            d4 = this.aKa.aKu[1] - this.aKb.aKL[1];
            d1 = this.aKa.aKu[0] - arrayOfDouble1[0];
            d2 = this.aKa.aKu[1] - arrayOfDouble1[1];
            d3 = Math.sqrt(d3 * d3 + d4 * d4);
            d1 = Math.sqrt(d1 * d1 + d2 * d2);
            d2 = Math.sqrt(this.aKb.aKM[0][0] * this.aKb.aKM[0][0] + this.aKb.aKM[1][1] * this.aKb.aKM[1][1]);
            d1 = Math.abs(d3 - d1) / d2;
            label2348:
            if (d1 <= this.aKb.aKv) {
              break label3156;
            }
            if (this.aKa.aKw >= this.aKa.aKx) {
              break label3134;
            }
            this.aKa.aKw += 1;
          }
        }
        for (;;)
        {
          this.aKa.aKL[0] = arrayOfDouble1[0];
          this.aKa.aKL[1] = arrayOfDouble1[1];
          this.aKa.aKM[0][0] = (parama.aKh * parama.aKh);
          this.aKa.aKM[0][1] = 0L;
          this.aKa.aKM[1][0] = 0L;
          this.aKa.aKM[1][1] = (parama.aKh * parama.aKh);
          break label1101;
          label2484:
          break;
          d3 = this.aKa.aKu[0] - this.aKb.aKL[0];
          d4 = this.aKa.aKu[1] - this.aKb.aKL[1];
          d1 = this.aKa.aKu[0] - arrayOfDouble1[0];
          d2 = this.aKa.aKu[1] - arrayOfDouble1[1];
          d3 = Math.sqrt(d3 * d3 + d4 * d4);
          d1 = Math.sqrt(d1 * d1 + d2 * d2);
          d2 = Math.sqrt(this.aKa.aKM[0][0] * this.aKa.aKM[0][0] + this.aKa.aKM[1][1] * this.aKa.aKM[1][1]);
          d1 = Math.abs(d3 - d1) / d2;
          break label2141;
          d1 = arrayOfDouble1[0] - this.aKb.aKL[0];
          d2 = arrayOfDouble1[1] - this.aKb.aKL[1];
          localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          d3 = 1.0D / (this.aKb.aKM[0][0] * this.aKb.aKM[1][1] - this.aKb.aKM[0][1] * this.aKb.aKM[1][0]);
          localObject1[0][0] = (this.aKb.aKM[1][1] * d3);
          localObject1[1][1] = (this.aKb.aKM[0][0] * d3);
          localObject1[0][1] = (-this.aKb.aKM[0][1] * d3);
          localObject1[1][0] = (d3 * -this.aKb.aKM[1][0]);
          d3 = localObject1[0][0];
          d4 = localObject1[1][0];
          d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
          break label2141;
          label2894:
          d1 = arrayOfDouble1[0] - this.aKb.aKL[0];
          d2 = arrayOfDouble1[1] - this.aKb.aKL[1];
          localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          d3 = 1.0D / (this.aKb.aKM[0][0] * this.aKb.aKM[1][1] - this.aKb.aKM[0][1] * this.aKb.aKM[1][0]);
          localObject1[0][0] = (this.aKb.aKM[1][1] * d3);
          localObject1[1][1] = (this.aKb.aKM[0][0] * d3);
          localObject1[0][1] = (-this.aKb.aKM[0][1] * d3);
          localObject1[1][0] = (d3 * -this.aKb.aKM[1][0]);
          d3 = localObject1[0][0];
          d4 = localObject1[1][0];
          d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
          break label2348;
          label3134:
          this.aKa.a(this.aKb);
          this.aKa.aKw = 0;
          continue;
          label3156:
          this.aKa.a(this.aKb);
          this.aKa.aKw = 0;
          a(arrayOfDouble1);
          continue;
          label3184:
          this.aKa.a(this.aKb);
          this.aKa.aKw = 0;
          a(arrayOfDouble1);
        }
      }
      if (parama.mType != 3)
      {
        localObject2 = new double[2];
        localObject1 = new double[2];
        arrayOfDouble1 = new double[2];
        a(parama.aKc, false);
        if (!this.aKa.aKt)
        {
          j = 1;
          i = 0;
          this.aKa.aKw = 0;
        }
        while (j != 0)
        {
          if (i != 0) {
            break label3928;
          }
          this.aKa.aKL[0] = parama.aKf[0];
          this.aKa.aKL[1] = parama.aKf[1];
          this.aKa.aKL[2] = 0.0D;
          this.aKa.aKL[3] = 0.0D;
          this.aKa.aKM[0][0] = (parama.aKh * parama.aKh);
          this.aKa.aKM[0][1] = 0L;
          this.aKa.aKM[0][2] = 0L;
          this.aKa.aKM[0][3] = 0L;
          this.aKa.aKM[1][0] = 0L;
          this.aKa.aKM[1][1] = this.aKa.aKM[0][0];
          this.aKa.aKM[1][2] = 0L;
          this.aKa.aKM[1][2] = 0L;
          this.aKa.aKM[2][0] = 0L;
          this.aKa.aKM[2][1] = 0L;
          this.aKa.aKM[2][2] = this.aKa.aKG;
          this.aKa.aKM[2][3] = 0L;
          this.aKa.aKM[3][0] = 0L;
          this.aKa.aKM[3][1] = 0L;
          this.aKa.aKM[3][2] = 0L;
          this.aKa.aKM[3][3] = this.aKa.aKG;
          this.aKa.aKu[0] = parama.aKf[0];
          this.aKa.aKu[1] = parama.aKf[1];
          this.aKa.aKt = true;
          return;
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject2[0] = (parama.aKf[0] - this.aKa.aKL[0]);
          localObject2[1] = (parama.aKf[1] - this.aKa.aKL[1]);
          d1 = this.aKa.aKM[0][0];
          d2 = this.aKa.aKM[0][1];
          d3 = this.aKa.aKM[1][0];
          d4 = this.aKa.aKM[1][1];
          double[] arrayOfDouble2 = this.aJZ;
          a(new double[] { d1, d2, d3, d4 }, arrayOfDouble2);
          localObject3[0][0] = this.aJZ[0];
          localObject3[0][1] = this.aJZ[1];
          localObject3[1][0] = this.aJZ[2];
          localObject3[1][1] = this.aJZ[3];
          if (Math.sqrt(localObject2[0] * localObject2[0] * localObject3[0][0] + 2.0D * localObject2[0] * localObject2[1] * localObject3[1][0] + localObject2[1] * localObject2[1] * localObject3[1][1]) > this.aKa.aKv)
          {
            localObject2 = this.aKa;
            i = ((b)localObject2).aKw + 1;
            ((b)localObject2).aKw = i;
            if (i >= this.aKa.aKx)
            {
              j = 1;
              i = 0;
              this.aKa.aKw = 0;
            }
            else
            {
              j = 0;
              i = 0;
            }
          }
          else
          {
            this.aKa.aKw = 0;
            j = 1;
            i = 1;
          }
        }
      }
    }
    label3928:
    Object localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
    Object localObject2 = new double[2];
    localObject1[0] = (this.aKa.aKL[0] - this.aKa.aKu[0]);
    localObject1[1] = (this.aKa.aKL[1] - this.aKa.aKu[1]);
    arrayOfDouble1[0] = (parama.aKf[0] - this.aKa.aKu[0]);
    arrayOfDouble1[1] = (parama.aKf[1] - this.aKa.aKu[1]);
    double d2 = Math.sqrt(arrayOfDouble1[0] * arrayOfDouble1[0] + arrayOfDouble1[1] * arrayOfDouble1[1]);
    double d1 = localObject1[0];
    double d3 = localObject1[0];
    double d4 = localObject1[1];
    d4 = Math.sqrt(localObject1[1] * d4 + d1 * d3);
    if (d2 < d4)
    {
      d1 = this.aKa.aKR;
      label4115:
      if (!a(this.aKa.aKM, (double[][])localObject3)) {
        break label4343;
      }
      d3 = 1.0D / (parama.aKh * parama.aKh);
      localObject1 = new double[4];
      if (!this.aKa.aKY) {
        break label4345;
      }
      d1 += d4 / d2 * (1.0D - d1);
      localObject2[0] = (this.aKa.aKu[0] + arrayOfDouble1[0] * d1);
      d2 = this.aKa.aKu[1];
      localObject2[1] = (d1 * arrayOfDouble1[1] + d2);
    }
    for (;;)
    {
      i = 0;
      if (i < 4) {
        break label4404;
      }
      parama = localObject3[0];
      parama[0] += d3;
      parama = localObject3[1];
      parama[1] += d3;
      if (!a((double[][])localObject3, this.aKa.aKM)) {
        break;
      }
      localObject1[0] += localObject2[0] * d3;
      localObject1[1] += localObject2[1] * d3;
      i = 0;
      if (i < 4) {
        break label4467;
      }
      this.aKa.aKu[0] = localObject2[0];
      this.aKa.aKu[1] = localObject2[1];
      return;
      d1 = this.aKa.aKS;
      break label4115;
      label4343:
      break;
      label4345:
      localObject2[0] = (this.aKa.aKL[0] * (1.0D - d1) + parama.aKf[0] * d1);
      d2 = this.aKa.aKL[1];
      localObject2[1] = (d1 * parama.aKf[1] + d2 * (1.0D - d1));
    }
    label4404:
    localObject1[i] = 0.0D;
    int j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      localObject1[i] += localObject3[i][j] * this.aKa.aKL[j];
      j += 1;
    }
    label4467:
    this.aKa.aKL[i] = 0.0D;
    j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      parama = this.aKa.aKL;
      parama[i] += this.aKa.aKM[i][j] * localObject1[j];
      j += 1;
    }
  }
  
  protected final void ai(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      if (this.aKa.aKQ != paramBoolean)
      {
        this.aKa.aKQ = paramBoolean;
        if (!paramBoolean) {
          break;
        }
        this.aKa.aKp = this.aKa.aKX[1];
        this.aKa.aKG = this.aKa.aKW[1];
        a(this.aKa.aKc, true);
      }
      return;
    }
    this.aKa.aKp = this.aKa.aKX[0];
    this.aKa.aKG = this.aKa.aKW[0];
    a(this.aKa.aKc, true);
  }
  
  protected static final class a
  {
    double aKc;
    double aKd;
    double aKe;
    double[] aKf = new double[2];
    double aKg;
    double aKh;
    int aKi;
    double aKj;
    double aKk;
    int aKl;
    double aKm;
    double aKn;
    double aKo;
    int mType;
    
    protected a(int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt2, double paramDouble6, int paramInt3, double paramDouble7, double paramDouble8)
    {
      this.mType = paramInt1;
      this.aKc = paramDouble1;
      this.aKd = paramDouble2;
      this.aKe = paramDouble3;
      this.aKg = paramDouble4;
      this.aKh = paramDouble5;
      this.aKi = paramInt2;
      this.aKj = paramDouble6;
      this.aKk = 0.0D;
      this.aKl = paramInt3;
      this.aKm = 0.0D;
      this.aKn = paramDouble7;
      this.aKo = paramDouble8;
    }
    
    public final String toString()
    {
      return String.valueOf(this.mType) + ',' + this.aKc + ',' + this.aKd + ',' + this.aKe + ',' + this.aKg + ',' + this.aKh + ',' + this.aKi + ',' + this.aKj + ',' + this.aKk + ',' + this.aKl + ',' + this.aKn + ',' + this.aKo;
    }
  }
  
  private static final class b
  {
    public double aKA;
    public double aKB;
    public double aKC;
    public double aKD;
    public double aKE;
    public double aKF;
    public double aKG;
    public double[] aKH = new double[2];
    private boolean aKI;
    public boolean aKJ;
    public boolean aKK;
    public double[] aKL = new double[4];
    public double[][] aKM = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
    public double aKN;
    public double aKO;
    public double aKP;
    public boolean aKQ;
    public double aKR;
    public double aKS;
    public int aKT;
    public int aKU;
    public double aKV;
    public double[] aKW = new double[2];
    public double[] aKX = new double[2];
    public boolean aKY;
    public double aKc;
    public double aKp;
    public boolean aKq;
    public double[] aKr = new double[2];
    public double aKs;
    public boolean aKt;
    public double[] aKu = new double[2];
    public double aKv;
    public int aKw;
    public int aKx;
    public boolean aKy;
    public boolean aKz;
    
    public final void a(b paramb)
    {
      this.aKp = paramb.aKp;
      this.aKq = paramb.aKq;
      this.aKr = ((double[])paramb.aKr.clone());
      this.aKs = paramb.aKs;
      this.aKt = paramb.aKt;
      this.aKu = ((double[])paramb.aKu.clone());
      this.aKv = paramb.aKv;
      this.aKw = paramb.aKw;
      this.aKx = paramb.aKx;
      this.aKy = paramb.aKy;
      this.aKz = paramb.aKz;
      this.aKA = paramb.aKA;
      this.aKB = paramb.aKB;
      this.aKC = paramb.aKC;
      this.aKD = paramb.aKD;
      this.aKE = paramb.aKE;
      this.aKF = paramb.aKF;
      this.aKG = paramb.aKG;
      this.aKH = ((double[])paramb.aKH.clone());
      this.aKI = paramb.aKI;
      this.aKJ = paramb.aKJ;
      this.aKK = paramb.aKK;
      this.aKc = paramb.aKc;
      this.aKL = ((double[])paramb.aKL.clone());
      this.aKM[0] = ((double[])paramb.aKM[0].clone());
      this.aKM[1] = ((double[])paramb.aKM[1].clone());
      this.aKM[2] = ((double[])paramb.aKM[2].clone());
      this.aKM[3] = ((double[])paramb.aKM[3].clone());
      this.aKN = paramb.aKN;
      this.aKO = paramb.aKO;
      this.aKP = paramb.aKP;
      this.aKQ = paramb.aKQ;
      this.aKR = paramb.aKR;
      this.aKS = paramb.aKS;
      this.aKT = paramb.aKT;
      this.aKU = paramb.aKU;
      this.aKV = paramb.aKV;
      this.aKW = ((double[])paramb.aKW.clone());
      this.aKX = ((double[])paramb.aKX.clone());
      this.aKY = paramb.aKY;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */