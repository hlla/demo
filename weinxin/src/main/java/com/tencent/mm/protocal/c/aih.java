package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aih
  extends com.tencent.mm.bd.a
{
  public int oSb;
  public int tKG;
  
  public aih()
  {
    GMTrace.i(13583773597696L, 101207);
    GMTrace.o(13583773597696L, 101207);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13583907815424L, 101208);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.oSb);
      paramVarArgs.eO(2, this.tKG);
      GMTrace.o(13583907815424L, 101208);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.oSb);
      int i = a.a.a.a.eL(2, this.tKG);
      GMTrace.o(13583907815424L, 101208);
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
      GMTrace.o(13583907815424L, 101208);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      aih localaih = (aih)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13583907815424L, 101208);
        return -1;
      case 1: 
        localaih.oSb = locala.xky.mL();
        GMTrace.o(13583907815424L, 101208);
        return 0;
      }
      localaih.tKG = locala.xky.mL();
      GMTrace.o(13583907815424L, 101208);
      return 0;
    }
    GMTrace.o(13583907815424L, 101208);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */