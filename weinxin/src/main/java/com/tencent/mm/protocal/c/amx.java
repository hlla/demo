package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class amx
  extends com.tencent.mm.bd.a
{
  public double tPT;
  public long tPU;
  public String tfa;
  
  public amx()
  {
    GMTrace.i(3996601286656L, 29777);
    GMTrace.o(3996601286656L, 29777);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3996735504384L, 29778);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tfa == null) {
        throw new b("Not all required fields were included: Username");
      }
      if (this.tfa != null) {
        paramVarArgs.e(1, this.tfa);
      }
      paramVarArgs.a(2, this.tPT);
      paramVarArgs.O(3, this.tPU);
      GMTrace.o(3996735504384L, 29778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tfa == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = a.a.a.b.b.a.f(1, this.tfa) + 0;; paramInt = 0)
    {
      int i = a.a.a.b.b.a.cH(2);
      int j = a.a.a.a.N(3, this.tPU);
      GMTrace.o(3996735504384L, 29778);
      return paramInt + (i + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        if (this.tfa == null) {
          throw new b("Not all required fields were included: Username");
        }
        GMTrace.o(3996735504384L, 29778);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        amx localamx = (amx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3996735504384L, 29778);
          return -1;
        case 1: 
          localamx.tfa = locala.xky.readString();
          GMTrace.o(3996735504384L, 29778);
          return 0;
        case 2: 
          localamx.tPT = locala.xky.readDouble();
          GMTrace.o(3996735504384L, 29778);
          return 0;
        }
        localamx.tPU = locala.xky.mM();
        GMTrace.o(3996735504384L, 29778);
        return 0;
      }
      GMTrace.o(3996735504384L, 29778);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/amx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */