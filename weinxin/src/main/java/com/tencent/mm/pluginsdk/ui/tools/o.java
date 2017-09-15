package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.v;

public final class o
{
  int hSP;
  int hSQ;
  h.d iWr;
  int jWD;
  int jWE;
  int sVS;
  int sVT;
  public boolean sVh;
  
  public o()
  {
    GMTrace.i(17476490362880L, 130210);
    this.iWr = h.d.sHp;
    GMTrace.o(17476490362880L, 130210);
  }
  
  public final void a(h.d paramd)
  {
    GMTrace.i(17476758798336L, 130212);
    v.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.iWr, paramd });
    this.iWr = paramd;
    reset();
    GMTrace.o(17476758798336L, 130212);
  }
  
  final boolean r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(17476893016064L, 130213);
    if ((this.jWD == paramInt1) && (this.jWE == paramInt2) && (this.hSQ == paramInt3) && (this.hSP == paramInt4))
    {
      GMTrace.o(17476893016064L, 130213);
      return true;
    }
    this.jWD = paramInt1;
    this.jWE = paramInt2;
    this.hSQ = paramInt3;
    this.hSP = paramInt4;
    float f1 = this.hSQ * 1.0F / this.hSP;
    float f2 = this.jWD * 1.0F / this.jWE;
    if (this.iWr != h.d.sHp) {
      if (this.iWr == h.d.sHr) {
        if (this.jWD < this.jWE)
        {
          this.sVT = ((int)(this.jWD / f1));
          this.sVS = this.jWD;
          if (this.sVT > this.jWE)
          {
            this.sVS = ((int)(this.jWE * f1));
            this.sVT = this.jWE;
          }
        }
      }
    }
    for (;;)
    {
      v.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.jWD), Integer.valueOf(this.jWE), Integer.valueOf(this.hSQ), Integer.valueOf(this.hSP), Integer.valueOf(this.sVS), Integer.valueOf(this.sVT), Float.valueOf(f2), Float.valueOf(f1) });
      GMTrace.o(17476893016064L, 130213);
      return false;
      this.sVS = ((int)(this.jWE * f1));
      this.sVT = this.jWE;
      if (this.sVS > this.jWD)
      {
        this.sVT = ((int)(this.jWD / f1));
        this.sVS = this.jWD;
        continue;
        if (this.iWr == h.d.sHq)
        {
          this.sVT = this.jWE;
          this.sVS = this.jWD;
        }
        else if (this.iWr == h.d.sHs)
        {
          if (this.jWD > this.jWE)
          {
            this.sVT = ((int)(this.jWD / f1));
            this.sVS = this.jWD;
            if (this.sVT < this.jWE)
            {
              this.sVS = ((int)(this.jWE * f1));
              this.sVT = this.jWE;
            }
          }
          else
          {
            this.sVS = ((int)(this.jWE * f1));
            this.sVT = this.jWE;
            if (this.sVS < this.jWD)
            {
              this.sVT = ((int)(this.jWD / f1));
              this.sVS = this.jWD;
            }
          }
        }
        else if (!this.sVh)
        {
          if (this.jWD < this.jWE)
          {
            this.sVT = ((int)(this.jWD / f1));
            this.sVS = this.jWD;
          }
          else
          {
            this.sVS = ((int)(this.jWE * f1));
            this.sVT = this.jWE;
          }
        }
        else if (Math.abs(f1 - f2) > 0.05D)
        {
          if (this.jWD < this.jWE)
          {
            this.sVT = ((int)(this.jWD / f1));
            this.sVS = this.jWD;
          }
          else
          {
            this.sVS = ((int)(this.jWE * f1));
            this.sVT = this.jWE;
          }
        }
        else if (this.jWD > this.jWE)
        {
          this.sVT = ((int)(this.jWD / f1));
          this.sVS = this.jWD;
        }
        else
        {
          this.sVS = ((int)(this.jWE * f1));
          this.sVT = this.jWE;
        }
      }
    }
  }
  
  final void reset()
  {
    GMTrace.i(17476624580608L, 130211);
    this.jWE = 0;
    this.jWD = 0;
    this.hSP = 0;
    this.hSQ = 0;
    this.sVT = 0;
    this.sVS = 0;
    GMTrace.o(17476624580608L, 130211);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */