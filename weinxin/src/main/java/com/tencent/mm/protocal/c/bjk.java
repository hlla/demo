package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bjk
  extends com.tencent.mm.bd.a
{
  public int tfg;
  public int tfh;
  public int tfi;
  public int tfj;
  
  public bjk()
  {
    GMTrace.i(3839566544896L, 28607);
    GMTrace.o(3839566544896L, 28607);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3839700762624L, 28608);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tfg);
      paramVarArgs.eO(2, this.tfh);
      paramVarArgs.eO(3, this.tfi);
      paramVarArgs.eO(4, this.tfj);
      GMTrace.o(3839700762624L, 28608);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tfg);
      int i = a.a.a.a.eL(2, this.tfh);
      int j = a.a.a.a.eL(3, this.tfi);
      int k = a.a.a.a.eL(4, this.tfj);
      GMTrace.o(3839700762624L, 28608);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3839700762624L, 28608);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bjk localbjk = (bjk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3839700762624L, 28608);
        return -1;
      case 1: 
        localbjk.tfg = locala.xky.mL();
        GMTrace.o(3839700762624L, 28608);
        return 0;
      case 2: 
        localbjk.tfh = locala.xky.mL();
        GMTrace.o(3839700762624L, 28608);
        return 0;
      case 3: 
        localbjk.tfi = locala.xky.mL();
        GMTrace.o(3839700762624L, 28608);
        return 0;
      }
      localbjk.tfj = locala.xky.mL();
      GMTrace.o(3839700762624L, 28608);
      return 0;
    }
    GMTrace.o(3839700762624L, 28608);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */