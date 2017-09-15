package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;

public final class ams
  extends com.tencent.mm.bd.a
{
  public int tPC;
  public b tPD;
  public String tPE;
  public int tjL;
  public String tov;
  public String tow;
  
  public ams()
  {
    GMTrace.i(3790308638720L, 28240);
    GMTrace.o(3790308638720L, 28240);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3790442856448L, 28241);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tjL);
      paramVarArgs.eO(2, this.tPC);
      if (this.tPD != null) {
        paramVarArgs.b(3, this.tPD);
      }
      if (this.tPE != null) {
        paramVarArgs.e(4, this.tPE);
      }
      if (this.tov != null) {
        paramVarArgs.e(5, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(6, this.tow);
      }
      GMTrace.o(3790442856448L, 28241);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.tjL) + 0 + a.a.a.a.eL(2, this.tPC);
      paramInt = i;
      if (this.tPD != null) {
        paramInt = i + a.a.a.a.a(3, this.tPD);
      }
      i = paramInt;
      if (this.tPE != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.tPE);
      }
      paramInt = i;
      if (this.tov != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tov);
      }
      i = paramInt;
      if (this.tow != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.tow);
      }
      GMTrace.o(3790442856448L, 28241);
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
      GMTrace.o(3790442856448L, 28241);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ams localams = (ams)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3790442856448L, 28241);
        return -1;
      case 1: 
        localams.tjL = locala.xky.mL();
        GMTrace.o(3790442856448L, 28241);
        return 0;
      case 2: 
        localams.tPC = locala.xky.mL();
        GMTrace.o(3790442856448L, 28241);
        return 0;
      case 3: 
        localams.tPD = locala.chR();
        GMTrace.o(3790442856448L, 28241);
        return 0;
      case 4: 
        localams.tPE = locala.xky.readString();
        GMTrace.o(3790442856448L, 28241);
        return 0;
      case 5: 
        localams.tov = locala.xky.readString();
        GMTrace.o(3790442856448L, 28241);
        return 0;
      }
      localams.tow = locala.xky.readString();
      GMTrace.o(3790442856448L, 28241);
      return 0;
    }
    GMTrace.o(3790442856448L, 28241);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */