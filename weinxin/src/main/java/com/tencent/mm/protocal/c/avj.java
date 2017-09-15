package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class avj
  extends com.tencent.mm.bd.a
{
  public int sEc;
  public int tUe;
  public int tXk;
  public int tXm;
  
  public avj()
  {
    GMTrace.i(3755009376256L, 27977);
    GMTrace.o(3755009376256L, 27977);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3755143593984L, 27978);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tUe);
      paramVarArgs.eO(2, this.tXm);
      paramVarArgs.eO(3, this.tXk);
      paramVarArgs.eO(4, this.sEc);
      GMTrace.o(3755143593984L, 27978);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tUe);
      int i = a.a.a.a.eL(2, this.tXm);
      int j = a.a.a.a.eL(3, this.tXk);
      int k = a.a.a.a.eL(4, this.sEc);
      GMTrace.o(3755143593984L, 27978);
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
      GMTrace.o(3755143593984L, 27978);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      avj localavj = (avj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3755143593984L, 27978);
        return -1;
      case 1: 
        localavj.tUe = locala.xky.mL();
        GMTrace.o(3755143593984L, 27978);
        return 0;
      case 2: 
        localavj.tXm = locala.xky.mL();
        GMTrace.o(3755143593984L, 27978);
        return 0;
      case 3: 
        localavj.tXk = locala.xky.mL();
        GMTrace.o(3755143593984L, 27978);
        return 0;
      }
      localavj.sEc = locala.xky.mL();
      GMTrace.o(3755143593984L, 27978);
      return 0;
    }
    GMTrace.o(3755143593984L, 27978);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/avj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */