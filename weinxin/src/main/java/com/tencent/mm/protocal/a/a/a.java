package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;

public final class a
  extends com.tencent.mm.bd.a
{
  public int count;
  public int sYG;
  public int value;
  
  public a()
  {
    GMTrace.i(13100321341440L, 97605);
    GMTrace.o(13100321341440L, 97605);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13100455559168L, 97606);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.sYG);
      paramVarArgs.eO(2, this.value);
      paramVarArgs.eO(3, this.count);
      GMTrace.o(13100455559168L, 97606);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.sYG);
      int i = a.a.a.a.eL(2, this.value);
      int j = a.a.a.a.eL(3, this.count);
      GMTrace.o(13100455559168L, 97606);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13100455559168L, 97606);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13100455559168L, 97606);
        return -1;
      case 1: 
        locala1.sYG = locala.xky.mL();
        GMTrace.o(13100455559168L, 97606);
        return 0;
      case 2: 
        locala1.value = locala.xky.mL();
        GMTrace.o(13100455559168L, 97606);
        return 0;
      }
      locala1.count = locala.xky.mL();
      GMTrace.o(13100455559168L, 97606);
      return 0;
    }
    GMTrace.o(13100455559168L, 97606);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */