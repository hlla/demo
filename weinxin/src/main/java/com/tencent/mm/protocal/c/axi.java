package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class axi
  extends com.tencent.mm.bd.a
{
  public int tYl;
  public int tYm;
  public int tYn;
  public int tYo;
  public int tYp;
  public int tYq;
  public int tYr;
  public com.tencent.mm.bd.b tsy;
  
  public axi()
  {
    GMTrace.i(4049617289216L, 30172);
    GMTrace.o(4049617289216L, 30172);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4049751506944L, 30173);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tsy == null) {
        throw new a.a.a.b("Not all required fields were included: data");
      }
      paramVarArgs.eO(1, this.tYl);
      paramVarArgs.eO(2, this.tYm);
      paramVarArgs.eO(3, this.tYn);
      paramVarArgs.eO(4, this.tYo);
      paramVarArgs.eO(5, this.tYp);
      paramVarArgs.eO(6, this.tYq);
      paramVarArgs.eO(7, this.tYr);
      if (this.tsy != null) {
        paramVarArgs.b(8, this.tsy);
      }
      GMTrace.o(4049751506944L, 30173);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.tYl) + 0 + a.a.a.a.eL(2, this.tYm) + a.a.a.a.eL(3, this.tYn) + a.a.a.a.eL(4, this.tYo) + a.a.a.a.eL(5, this.tYp) + a.a.a.a.eL(6, this.tYq) + a.a.a.a.eL(7, this.tYr);
      paramInt = i;
      if (this.tsy != null) {
        paramInt = i + a.a.a.a.a(8, this.tsy);
      }
      GMTrace.o(4049751506944L, 30173);
      return paramInt;
    }
    a.a.a.a.a locala;
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      locala = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(locala); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(locala)) {
        if (!super.a(locala, this, paramInt)) {
          locala.chS();
        }
      }
      if (paramVarArgs == null) {
        throw new a.a.a.b("Not all required fields were included: data");
      }
      GMTrace.o(4049751506944L, 30173);
      return 0;
    }
    if (paramInt == 3)
    {
      locala = (a.a.a.a.a)paramVarArgs[0];
      axi localaxi = (axi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(4049751506944L, 30173);
        return -1;
      case 1: 
        localaxi.tYl = locala.xky.mL();
        GMTrace.o(4049751506944L, 30173);
        return 0;
      case 2: 
        localaxi.tYm = locala.xky.mL();
        GMTrace.o(4049751506944L, 30173);
        return 0;
      case 3: 
        localaxi.tYn = locala.xky.mL();
        GMTrace.o(4049751506944L, 30173);
        return 0;
      case 4: 
        localaxi.tYo = locala.xky.mL();
        GMTrace.o(4049751506944L, 30173);
        return 0;
      case 5: 
        localaxi.tYp = locala.xky.mL();
        GMTrace.o(4049751506944L, 30173);
        return 0;
      case 6: 
        localaxi.tYq = locala.xky.mL();
        GMTrace.o(4049751506944L, 30173);
        return 0;
      case 7: 
        localaxi.tYr = locala.xky.mL();
        GMTrace.o(4049751506944L, 30173);
        return 0;
      }
      localaxi.tsy = locala.chR();
      GMTrace.o(4049751506944L, 30173);
      return 0;
    }
    GMTrace.o(4049751506944L, 30173);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/axi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */