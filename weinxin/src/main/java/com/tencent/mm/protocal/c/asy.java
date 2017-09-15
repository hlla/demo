package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class asy
  extends com.tencent.mm.bd.a
{
  public String fIr;
  public int ret;
  
  public asy()
  {
    GMTrace.i(3644548186112L, 27154);
    GMTrace.o(3644548186112L, 27154);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3644682403840L, 27155);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.ret);
      if (this.fIr != null) {
        paramVarArgs.e(2, this.fIr);
      }
      GMTrace.o(3644682403840L, 27155);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.ret) + 0;
      paramInt = i;
      if (this.fIr != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.fIr);
      }
      GMTrace.o(3644682403840L, 27155);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3644682403840L, 27155);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      asy localasy = (asy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3644682403840L, 27155);
        return -1;
      case 1: 
        localasy.ret = locala.xky.mL();
        GMTrace.o(3644682403840L, 27155);
        return 0;
      }
      localasy.fIr = locala.xky.readString();
      GMTrace.o(3644682403840L, 27155);
      return 0;
    }
    GMTrace.o(3644682403840L, 27155);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/asy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */