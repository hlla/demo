package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class avh
  extends com.tencent.mm.bd.a
{
  public int tXk;
  public String tXl;
  
  public avh()
  {
    GMTrace.i(3941169364992L, 29364);
    GMTrace.o(3941169364992L, 29364);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3941303582720L, 29365);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXl == null) {
        throw new b("Not all required fields were included: ResKey");
      }
      paramVarArgs.eO(1, this.tXk);
      if (this.tXl != null) {
        paramVarArgs.e(2, this.tXl);
      }
      GMTrace.o(3941303582720L, 29365);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.tXk) + 0;
      paramInt = i;
      if (this.tXl != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tXl);
      }
      GMTrace.o(3941303582720L, 29365);
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
      if (this.tXl == null) {
        throw new b("Not all required fields were included: ResKey");
      }
      GMTrace.o(3941303582720L, 29365);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      avh localavh = (avh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3941303582720L, 29365);
        return -1;
      case 1: 
        localavh.tXk = locala.xky.mL();
        GMTrace.o(3941303582720L, 29365);
        return 0;
      }
      localavh.tXl = locala.xky.readString();
      GMTrace.o(3941303582720L, 29365);
      return 0;
    }
    GMTrace.o(3941303582720L, 29365);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/avh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */