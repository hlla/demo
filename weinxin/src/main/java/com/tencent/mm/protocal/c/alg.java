package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class alg
  extends com.tencent.mm.bd.a
{
  public float tOm;
  public float tOn;
  public float tOo;
  
  public alg()
  {
    GMTrace.i(3971234136064L, 29588);
    GMTrace.o(3971234136064L, 29588);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3971368353792L, 29589);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.n(1, this.tOm);
      paramVarArgs.n(2, this.tOn);
      paramVarArgs.n(3, this.tOo);
      GMTrace.o(3971368353792L, 29589);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.b.b.a.cH(1);
      int i = a.a.a.b.b.a.cH(2);
      int j = a.a.a.b.b.a.cH(3);
      GMTrace.o(3971368353792L, 29589);
      return paramInt + 4 + 0 + (i + 4) + (j + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3971368353792L, 29589);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      alg localalg = (alg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3971368353792L, 29589);
        return -1;
      case 1: 
        localalg.tOm = locala.xky.readFloat();
        GMTrace.o(3971368353792L, 29589);
        return 0;
      case 2: 
        localalg.tOn = locala.xky.readFloat();
        GMTrace.o(3971368353792L, 29589);
        return 0;
      }
      localalg.tOo = locala.xky.readFloat();
      GMTrace.o(3971368353792L, 29589);
      return 0;
    }
    GMTrace.o(3971368353792L, 29589);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/alg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */