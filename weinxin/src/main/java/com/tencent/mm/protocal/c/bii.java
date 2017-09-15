package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bii
  extends com.tencent.mm.bd.a
{
  public String jLx;
  public String ugE;
  
  public bii()
  {
    GMTrace.i(3702664462336L, 27587);
    GMTrace.o(3702664462336L, 27587);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3702798680064L, 27588);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.jLx != null) {
        paramVarArgs.e(1, this.jLx);
      }
      if (this.ugE != null) {
        paramVarArgs.e(2, this.ugE);
      }
      GMTrace.o(3702798680064L, 27588);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jLx == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = a.a.a.b.b.a.f(1, this.jLx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ugE != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.ugE);
      }
      GMTrace.o(3702798680064L, 27588);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3702798680064L, 27588);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bii localbii = (bii)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3702798680064L, 27588);
          return -1;
        case 1: 
          localbii.jLx = locala.xky.readString();
          GMTrace.o(3702798680064L, 27588);
          return 0;
        }
        localbii.ugE = locala.xky.readString();
        GMTrace.o(3702798680064L, 27588);
        return 0;
      }
      GMTrace.o(3702798680064L, 27588);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */