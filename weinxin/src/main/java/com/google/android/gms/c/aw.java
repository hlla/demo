package com.google.android.gms.c;

public final class aw
{
  int aCo;
  int aCp;
  private int aCq;
  int aCr;
  private int aCs;
  private int aCt = Integer.MAX_VALUE;
  private int aCu;
  private int aCv = 64;
  private int aCw = 67108864;
  final byte[] buffer;
  
  aw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.aCo = 0;
    this.aCp = (paramInt2 + 0);
    this.aCr = 0;
  }
  
  private void ck(int paramInt)
  {
    if (paramInt < 0) {
      throw bd.lA();
    }
    if (this.aCr + paramInt > this.aCt)
    {
      ck(this.aCt - this.aCr);
      throw bd.lz();
    }
    if (paramInt <= this.aCp - this.aCr)
    {
      this.aCr += paramInt;
      return;
    }
    throw bd.lz();
  }
  
  private void lr()
  {
    this.aCp += this.aCq;
    int i = this.aCp;
    if (i > this.aCt)
    {
      this.aCq = (i - this.aCt);
      this.aCp -= this.aCq;
      return;
    }
    this.aCq = 0;
  }
  
  private byte lt()
  {
    if (this.aCr == this.aCp) {
      throw bd.lz();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.aCr;
    this.aCr = (i + 1);
    return arrayOfByte[i];
  }
  
  public final void a(be parambe)
  {
    int i = lo();
    if (this.aCu >= this.aCv) {
      throw bd.lF();
    }
    i = cg(i);
    this.aCu += 1;
    parambe.a(this);
    ce(0);
    this.aCu -= 1;
    ch(i);
  }
  
  public final void ce(int paramInt)
  {
    if (this.aCs != paramInt) {
      throw bd.lD();
    }
  }
  
  public final boolean cf(int paramInt)
  {
    switch (bh.ct(paramInt))
    {
    default: 
      throw bd.lE();
    case 0: 
      lo();
      return true;
    case 1: 
      lq();
      return true;
    case 2: 
      ck(lo());
      return true;
    case 3: 
      int i;
      do
      {
        i = ll();
      } while ((i != 0) && (cf(i)));
      ce(bh.an(bh.cu(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    lp();
    return true;
  }
  
  public final int cg(int paramInt)
  {
    if (paramInt < 0) {
      throw bd.lA();
    }
    paramInt = this.aCr + paramInt;
    int i = this.aCt;
    if (paramInt > i) {
      throw bd.lz();
    }
    this.aCt = paramInt;
    lr();
    return i;
  }
  
  public final void ch(int paramInt)
  {
    this.aCt = paramInt;
    lr();
  }
  
  public final void ci(int paramInt)
  {
    if (paramInt > this.aCr - this.aCo) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.aCr - this.aCo));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.aCr = (this.aCo + paramInt);
  }
  
  public final byte[] cj(int paramInt)
  {
    if (paramInt < 0) {
      throw bd.lA();
    }
    if (this.aCr + paramInt > this.aCt)
    {
      ck(this.aCt - this.aCr);
      throw bd.lz();
    }
    if (paramInt <= this.aCp - this.aCr)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.aCr, arrayOfByte, 0, paramInt);
      this.aCr += paramInt;
      return arrayOfByte;
    }
    throw bd.lz();
  }
  
  public final int getPosition()
  {
    return this.aCr - this.aCo;
  }
  
  public final int ll()
  {
    if (this.aCr == this.aCp) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.aCs = 0;
      return 0;
    }
    this.aCs = lo();
    if (this.aCs == 0) {
      throw bd.lC();
    }
    return this.aCs;
  }
  
  public final long lm()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = lt();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw bd.lB();
  }
  
  public final boolean ln()
  {
    return lo() != 0;
  }
  
  public final int lo()
  {
    int i = lt();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = lt();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = lt();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = lt();
      if (k >= 0) {
        return i | k << 21;
      }
      j = lt();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (lt() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw bd.lB();
  }
  
  public final int lp()
  {
    return lt() & 0xFF | (lt() & 0xFF) << 8 | (lt() & 0xFF) << 16 | (lt() & 0xFF) << 24;
  }
  
  public final long lq()
  {
    int i = lt();
    int j = lt();
    int k = lt();
    int m = lt();
    int n = lt();
    int i1 = lt();
    int i2 = lt();
    int i3 = lt();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public final int ls()
  {
    if (this.aCt == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.aCr;
    return this.aCt - i;
  }
  
  public final String readString()
  {
    int i = lo();
    if ((i <= this.aCp - this.aCr) && (i > 0))
    {
      String str = new String(this.buffer, this.aCr, i, "UTF-8");
      this.aCr = (i + this.aCr);
      return str;
    }
    return new String(cj(i), "UTF-8");
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */