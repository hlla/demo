package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bek
  extends com.tencent.mm.bd.a
{
  public int udA;
  public String udB;
  public String udC;
  
  public bek()
  {
    GMTrace.i(3952712089600L, 29450);
    GMTrace.o(3952712089600L, 29450);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3952846307328L, 29451);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.udA);
      if (this.udB != null) {
        paramVarArgs.e(2, this.udB);
      }
      if (this.udC != null) {
        paramVarArgs.e(3, this.udC);
      }
      GMTrace.o(3952846307328L, 29451);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.udA) + 0;
      paramInt = i;
      if (this.udB != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.udB);
      }
      i = paramInt;
      if (this.udC != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.udC);
      }
      GMTrace.o(3952846307328L, 29451);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3952846307328L, 29451);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bek localbek = (bek)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3952846307328L, 29451);
        return -1;
      case 1: 
        localbek.udA = locala.xky.mL();
        GMTrace.o(3952846307328L, 29451);
        return 0;
      case 2: 
        localbek.udB = locala.xky.readString();
        GMTrace.o(3952846307328L, 29451);
        return 0;
      }
      localbek.udC = locala.xky.readString();
      GMTrace.o(3952846307328L, 29451);
      return 0;
    }
    GMTrace.o(3952846307328L, 29451);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */