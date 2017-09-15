package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bdf
  extends com.tencent.mm.bd.a
{
  public int cFR;
  public int hSX;
  public String qly;
  public String ucR;
  public String ucS;
  public int ucT;
  
  public bdf()
  {
    GMTrace.i(3675149828096L, 27382);
    GMTrace.o(3675149828096L, 27382);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3675284045824L, 27383);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.hSX);
      if (this.ucR != null) {
        paramVarArgs.e(2, this.ucR);
      }
      if (this.ucS != null) {
        paramVarArgs.e(3, this.ucS);
      }
      paramVarArgs.eO(4, this.cFR);
      if (this.qly != null) {
        paramVarArgs.e(5, this.qly);
      }
      paramVarArgs.eO(6, this.ucT);
      GMTrace.o(3675284045824L, 27383);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.hSX) + 0;
      paramInt = i;
      if (this.ucR != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.ucR);
      }
      i = paramInt;
      if (this.ucS != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.ucS);
      }
      i += a.a.a.a.eL(4, this.cFR);
      paramInt = i;
      if (this.qly != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.qly);
      }
      i = a.a.a.a.eL(6, this.ucT);
      GMTrace.o(3675284045824L, 27383);
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
      GMTrace.o(3675284045824L, 27383);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bdf localbdf = (bdf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3675284045824L, 27383);
        return -1;
      case 1: 
        localbdf.hSX = locala.xky.mL();
        GMTrace.o(3675284045824L, 27383);
        return 0;
      case 2: 
        localbdf.ucR = locala.xky.readString();
        GMTrace.o(3675284045824L, 27383);
        return 0;
      case 3: 
        localbdf.ucS = locala.xky.readString();
        GMTrace.o(3675284045824L, 27383);
        return 0;
      case 4: 
        localbdf.cFR = locala.xky.mL();
        GMTrace.o(3675284045824L, 27383);
        return 0;
      case 5: 
        localbdf.qly = locala.xky.readString();
        GMTrace.o(3675284045824L, 27383);
        return 0;
      }
      localbdf.ucT = locala.xky.mL();
      GMTrace.o(3675284045824L, 27383);
      return 0;
    }
    GMTrace.o(3675284045824L, 27383);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */