package com.tencent.mm.aw.a;

import com.tencent.gmtrace.GMTrace;

public final class a
{
  int ide;
  int idf;
  int idg;
  short[] idh;
  
  public a(int paramInt)
  {
    GMTrace.i(4383685214208L, 32661);
    this.ide = 0;
    this.idf = 0;
    this.idg = 0;
    int i = paramInt;
    if (paramInt <= 1) {
      i = 512;
    }
    this.idh = new short[i];
    GMTrace.o(4383685214208L, 32661);
  }
  
  final int b(short[] paramArrayOfShort, int paramInt)
  {
    GMTrace.i(4383819431936L, 32662);
    if (paramInt > paramArrayOfShort.length) {
      paramInt = paramArrayOfShort.length;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        GMTrace.o(4383819431936L, 32662);
        return 0;
      }
      int i = this.idh.length;
      if (paramInt < this.idg)
      {
        if (paramInt > i - this.ide) {
          break label123;
        }
        System.arraycopy(this.idh, this.ide, paramArrayOfShort, 0, paramInt);
        this.ide += paramInt;
        if (this.ide < i) {}
      }
      label123:
      int j;
      for (this.ide = 0;; this.ide = j)
      {
        this.idg -= paramInt;
        GMTrace.o(4383819431936L, 32662);
        return paramInt;
        paramInt = this.idg;
        break;
        i -= this.ide;
        System.arraycopy(this.idh, this.ide, paramArrayOfShort, 0, i);
        j = paramInt - i;
        System.arraycopy(this.idh, 0, paramArrayOfShort, i, j);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aw/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */