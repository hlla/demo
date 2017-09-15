package com.tencent.mm.c.b;

import com.tencent.gmtrace.GMTrace;

public abstract class f
{
  protected a fAb;
  protected boolean fAx;
  protected int fAy;
  protected int fzK;
  
  public f()
  {
    GMTrace.i(4483006332928L, 33401);
    this.fzK = -123456789;
    this.fAx = false;
    this.fAy = 0;
    GMTrace.o(4483006332928L, 33401);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(4483543203840L, 33405);
    this.fAb = parama;
    GMTrace.o(4483543203840L, 33405);
  }
  
  public abstract void au(boolean paramBoolean);
  
  public final void cZ(int paramInt)
  {
    GMTrace.i(4483677421568L, 33406);
    this.fzK = paramInt;
    GMTrace.o(4483677421568L, 33406);
  }
  
  public abstract void oP();
  
  public abstract boolean pf();
  
  public final int ph()
  {
    GMTrace.i(4483811639296L, 33407);
    int i = this.fAy;
    GMTrace.o(4483811639296L, 33407);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void c(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/c/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */