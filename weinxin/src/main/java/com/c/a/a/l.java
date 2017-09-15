package com.c.a.a;

import java.util.Arrays;

final class l
{
  float aLj;
  long aLn;
  private final float[] aLo = new float[3];
  private int aLp;
  private long aLq;
  long aLr;
  
  final void a(float paramFloat, int paramInt, long paramLong)
  {
    long l = paramLong - this.aLq;
    if (l > this.aLn)
    {
      Arrays.fill(this.aLo, 0.0F);
      this.aLp = 0;
      this.aLq = 0L;
      this.aLr = 0L;
      this.aLj = 0.0F;
      this.aLo[0] = this.aLo[1];
      this.aLo[1] = this.aLo[2];
      this.aLo[2] = paramFloat;
      if (this.aLo[2] != 0.0F)
      {
        if (this.aLo[0] == 0.0F) {
          break label196;
        }
        paramFloat = (this.aLo[0] + this.aLo[1] + this.aLo[2]) / 3.0F;
      }
    }
    for (;;)
    {
      float f = y.aPs;
      this.aLj = (paramInt / (paramFloat + this.aLo[2] * 3.0F) * f + y.aPt * (paramInt - this.aLp) / (this.aLp + paramInt + 1));
      this.aLp = paramInt;
      this.aLq = paramLong;
      return;
      this.aLr = (l + this.aLr);
      break;
      label196:
      if (this.aLo[1] != 0.0F) {
        paramFloat = (this.aLo[1] + this.aLo[2]) / 2.0F;
      } else {
        paramFloat = this.aLo[2];
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */