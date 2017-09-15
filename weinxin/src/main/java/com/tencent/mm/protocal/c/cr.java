package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class cr
  extends com.tencent.mm.bd.a
{
  public String jMd;
  public String mPx;
  public String mtr;
  public String tef;
  public String teg;
  public int teh;
  
  public cr()
  {
    GMTrace.i(3887213838336L, 28962);
    GMTrace.o(3887213838336L, 28962);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3887348056064L, 28963);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mPx != null) {
        paramVarArgs.e(1, this.mPx);
      }
      if (this.jMd != null) {
        paramVarArgs.e(2, this.jMd);
      }
      if (this.mtr != null) {
        paramVarArgs.e(3, this.mtr);
      }
      if (this.tef != null) {
        paramVarArgs.e(4, this.tef);
      }
      if (this.teg != null) {
        paramVarArgs.e(5, this.teg);
      }
      paramVarArgs.eO(6, this.teh);
      GMTrace.o(3887348056064L, 28963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mPx == null) {
        break label550;
      }
    }
    label550:
    for (int i = a.a.a.b.b.a.f(1, this.mPx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jMd != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.jMd);
      }
      i = paramInt;
      if (this.mtr != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.mtr);
      }
      paramInt = i;
      if (this.tef != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tef);
      }
      i = paramInt;
      if (this.teg != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.teg);
      }
      paramInt = a.a.a.a.eL(6, this.teh);
      GMTrace.o(3887348056064L, 28963);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3887348056064L, 28963);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        cr localcr = (cr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3887348056064L, 28963);
          return -1;
        case 1: 
          localcr.mPx = locala.xky.readString();
          GMTrace.o(3887348056064L, 28963);
          return 0;
        case 2: 
          localcr.jMd = locala.xky.readString();
          GMTrace.o(3887348056064L, 28963);
          return 0;
        case 3: 
          localcr.mtr = locala.xky.readString();
          GMTrace.o(3887348056064L, 28963);
          return 0;
        case 4: 
          localcr.tef = locala.xky.readString();
          GMTrace.o(3887348056064L, 28963);
          return 0;
        case 5: 
          localcr.teg = locala.xky.readString();
          GMTrace.o(3887348056064L, 28963);
          return 0;
        }
        localcr.teh = locala.xky.mL();
        GMTrace.o(3887348056064L, 28963);
        return 0;
      }
      GMTrace.o(3887348056064L, 28963);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */