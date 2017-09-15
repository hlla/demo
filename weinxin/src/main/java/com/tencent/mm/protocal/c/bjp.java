package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bjp
  extends com.tencent.mm.bd.a
{
  public int the;
  public int uhq;
  public String uhu;
  
  public bjp()
  {
    GMTrace.i(3825742118912L, 28504);
    GMTrace.o(3825742118912L, 28504);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3825876336640L, 28505);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.uhq);
      paramVarArgs.eO(2, this.the);
      if (this.uhu != null) {
        paramVarArgs.e(3, this.uhu);
      }
      GMTrace.o(3825876336640L, 28505);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.uhq) + 0 + a.a.a.a.eL(2, this.the);
      paramInt = i;
      if (this.uhu != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.uhu);
      }
      GMTrace.o(3825876336640L, 28505);
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
      GMTrace.o(3825876336640L, 28505);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bjp localbjp = (bjp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3825876336640L, 28505);
        return -1;
      case 1: 
        localbjp.uhq = locala.xky.mL();
        GMTrace.o(3825876336640L, 28505);
        return 0;
      case 2: 
        localbjp.the = locala.xky.mL();
        GMTrace.o(3825876336640L, 28505);
        return 0;
      }
      localbjp.uhu = locala.xky.readString();
      GMTrace.o(3825876336640L, 28505);
      return 0;
    }
    GMTrace.o(3825876336640L, 28505);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */