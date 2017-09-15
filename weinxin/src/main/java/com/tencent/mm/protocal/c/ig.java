package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class ig
  extends com.tencent.mm.bd.a
{
  public int tln;
  public LinkedList<Integer> tlo;
  
  public ig()
  {
    GMTrace.i(13583236726784L, 101203);
    this.tlo = new LinkedList();
    GMTrace.o(13583236726784L, 101203);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13583370944512L, 101204);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tln);
      paramVarArgs.c(2, this.tlo);
      GMTrace.o(13583370944512L, 101204);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tln);
      int i = a.a.a.a.b(2, this.tlo);
      GMTrace.o(13583370944512L, 101204);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tlo.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13583370944512L, 101204);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ig localig = (ig)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13583370944512L, 101204);
        return -1;
      case 1: 
        localig.tln = locala.xky.mL();
        GMTrace.o(13583370944512L, 101204);
        return 0;
      }
      localig.tlo = new a.a.a.a.a(locala.chR().sWU, unknownTagHandler).chO();
      GMTrace.o(13583370944512L, 101204);
      return 0;
    }
    GMTrace.o(13583370944512L, 101204);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */