package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class amc
  extends com.tencent.mm.bd.a
{
  public String mqJ;
  public String tPo;
  
  public amc()
  {
    GMTrace.i(3792456122368L, 28256);
    GMTrace.o(3792456122368L, 28256);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3792590340096L, 28257);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tPo != null) {
        paramVarArgs.e(1, this.tPo);
      }
      if (this.mqJ != null) {
        paramVarArgs.e(2, this.mqJ);
      }
      GMTrace.o(3792590340096L, 28257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tPo == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = a.a.a.b.b.a.f(1, this.tPo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mqJ != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.mqJ);
      }
      GMTrace.o(3792590340096L, 28257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3792590340096L, 28257);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        amc localamc = (amc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3792590340096L, 28257);
          return -1;
        case 1: 
          localamc.tPo = locala.xky.readString();
          GMTrace.o(3792590340096L, 28257);
          return 0;
        }
        localamc.mqJ = locala.xky.readString();
        GMTrace.o(3792590340096L, 28257);
        return 0;
      }
      GMTrace.o(3792590340096L, 28257);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/amc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */