package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bqn
  extends com.tencent.mm.bd.a
{
  public int umU;
  public int umV;
  public String umW;
  public String umX;
  public String umY;
  public int umZ;
  
  public bqn()
  {
    GMTrace.i(14450149031936L, 107662);
    GMTrace.o(14450149031936L, 107662);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(14450283249664L, 107663);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.umU);
      paramVarArgs.eO(2, this.umV);
      if (this.umW != null) {
        paramVarArgs.e(3, this.umW);
      }
      if (this.umX != null) {
        paramVarArgs.e(4, this.umX);
      }
      if (this.umY != null) {
        paramVarArgs.e(5, this.umY);
      }
      paramVarArgs.eO(6, this.umZ);
      GMTrace.o(14450283249664L, 107663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.umU) + 0 + a.a.a.a.eL(2, this.umV);
      paramInt = i;
      if (this.umW != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.umW);
      }
      i = paramInt;
      if (this.umX != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.umX);
      }
      paramInt = i;
      if (this.umY != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.umY);
      }
      i = a.a.a.a.eL(6, this.umZ);
      GMTrace.o(14450283249664L, 107663);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(14450283249664L, 107663);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bqn localbqn = (bqn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(14450283249664L, 107663);
        return -1;
      case 1: 
        localbqn.umU = locala.xky.mL();
        GMTrace.o(14450283249664L, 107663);
        return 0;
      case 2: 
        localbqn.umV = locala.xky.mL();
        GMTrace.o(14450283249664L, 107663);
        return 0;
      case 3: 
        localbqn.umW = locala.xky.readString();
        GMTrace.o(14450283249664L, 107663);
        return 0;
      case 4: 
        localbqn.umX = locala.xky.readString();
        GMTrace.o(14450283249664L, 107663);
        return 0;
      case 5: 
        localbqn.umY = locala.xky.readString();
        GMTrace.o(14450283249664L, 107663);
        return 0;
      }
      localbqn.umZ = locala.xky.mL();
      GMTrace.o(14450283249664L, 107663);
      return 0;
    }
    GMTrace.o(14450283249664L, 107663);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */