package com.tencent.mm.plugin.report.service;

import com.tencent.gmtrace.GMTrace;

public final class b
  extends com.tencent.mm.bd.a
{
  public int fxf;
  public int oSb;
  public int oSc;
  public boolean oSd;
  
  public b()
  {
    GMTrace.i(13126896451584L, 97803);
    GMTrace.o(13126896451584L, 97803);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13127030669312L, 97804);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.fxf);
      paramVarArgs.eO(2, this.oSb);
      paramVarArgs.eO(3, this.oSc);
      paramVarArgs.an(4, this.oSd);
      GMTrace.o(13127030669312L, 97804);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.fxf);
      int i = a.a.a.a.eL(2, this.oSb);
      int j = a.a.a.a.eL(3, this.oSc);
      int k = a.a.a.b.b.a.cH(4);
      GMTrace.o(13127030669312L, 97804);
      return paramInt + 0 + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13127030669312L, 97804);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13127030669312L, 97804);
        return -1;
      case 1: 
        localb.fxf = locala.xky.mL();
        GMTrace.o(13127030669312L, 97804);
        return 0;
      case 2: 
        localb.oSb = locala.xky.mL();
        GMTrace.o(13127030669312L, 97804);
        return 0;
      case 3: 
        localb.oSc = locala.xky.mL();
        GMTrace.o(13127030669312L, 97804);
        return 0;
      }
      localb.oSd = locala.chQ();
      GMTrace.o(13127030669312L, 97804);
      return 0;
    }
    GMTrace.o(13127030669312L, 97804);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */