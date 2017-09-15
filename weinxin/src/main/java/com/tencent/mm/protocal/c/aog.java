package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aog
  extends com.tencent.mm.bd.a
{
  public int tRJ;
  public String tRK;
  public String tRM;
  public int tkk;
  public int tpX;
  
  public aog()
  {
    GMTrace.i(13340839510016L, 99397);
    GMTrace.o(13340839510016L, 99397);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13340973727744L, 99398);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tkk);
      if (this.tRM != null) {
        paramVarArgs.e(3, this.tRM);
      }
      paramVarArgs.eO(4, this.tRJ);
      paramVarArgs.eO(5, this.tpX);
      if (this.tRK != null) {
        paramVarArgs.e(6, this.tRK);
      }
      GMTrace.o(13340973727744L, 99398);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.tkk) + 0;
      paramInt = i;
      if (this.tRM != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tRM);
      }
      i = paramInt + a.a.a.a.eL(4, this.tRJ) + a.a.a.a.eL(5, this.tpX);
      paramInt = i;
      if (this.tRK != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tRK);
      }
      GMTrace.o(13340973727744L, 99398);
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
      GMTrace.o(13340973727744L, 99398);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      aog localaog = (aog)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        GMTrace.o(13340973727744L, 99398);
        return -1;
      case 1: 
        localaog.tkk = locala.xky.mL();
        GMTrace.o(13340973727744L, 99398);
        return 0;
      case 3: 
        localaog.tRM = locala.xky.readString();
        GMTrace.o(13340973727744L, 99398);
        return 0;
      case 4: 
        localaog.tRJ = locala.xky.mL();
        GMTrace.o(13340973727744L, 99398);
        return 0;
      case 5: 
        localaog.tpX = locala.xky.mL();
        GMTrace.o(13340973727744L, 99398);
        return 0;
      }
      localaog.tRK = locala.xky.readString();
      GMTrace.o(13340973727744L, 99398);
      return 0;
    }
    GMTrace.o(13340973727744L, 99398);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */