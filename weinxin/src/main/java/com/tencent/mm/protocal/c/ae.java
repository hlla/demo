package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ae
  extends com.tencent.mm.bd.a
{
  public int tbc;
  public int tbd;
  
  public ae()
  {
    GMTrace.i(18919733592064L, 140963);
    GMTrace.o(18919733592064L, 140963);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(18919867809792L, 140964);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tbc);
      paramVarArgs.eO(2, this.tbd);
      GMTrace.o(18919867809792L, 140964);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tbc);
      int i = a.a.a.a.eL(2, this.tbd);
      GMTrace.o(18919867809792L, 140964);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(18919867809792L, 140964);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ae localae = (ae)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(18919867809792L, 140964);
        return -1;
      case 1: 
        localae.tbc = locala.xky.mL();
        GMTrace.o(18919867809792L, 140964);
        return 0;
      }
      localae.tbd = locala.xky.mL();
      GMTrace.o(18919867809792L, 140964);
      return 0;
    }
    GMTrace.o(18919867809792L, 140964);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */