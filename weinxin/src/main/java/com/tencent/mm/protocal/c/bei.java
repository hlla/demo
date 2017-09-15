package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bei
  extends com.tencent.mm.bd.a
{
  public String jLx;
  public int tUT;
  public String tou;
  public int trc;
  
  public bei()
  {
    GMTrace.i(3975260667904L, 29618);
    GMTrace.o(3975260667904L, 29618);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3975394885632L, 29619);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.jLx != null) {
        paramVarArgs.e(1, this.jLx);
      }
      if (this.tou != null) {
        paramVarArgs.e(2, this.tou);
      }
      paramVarArgs.eO(3, this.tUT);
      paramVarArgs.eO(4, this.trc);
      GMTrace.o(3975394885632L, 29619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jLx == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = a.a.a.b.b.a.f(1, this.jLx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tou != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tou);
      }
      paramInt = a.a.a.a.eL(3, this.tUT);
      int j = a.a.a.a.eL(4, this.trc);
      GMTrace.o(3975394885632L, 29619);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3975394885632L, 29619);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bei localbei = (bei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3975394885632L, 29619);
          return -1;
        case 1: 
          localbei.jLx = locala.xky.readString();
          GMTrace.o(3975394885632L, 29619);
          return 0;
        case 2: 
          localbei.tou = locala.xky.readString();
          GMTrace.o(3975394885632L, 29619);
          return 0;
        case 3: 
          localbei.tUT = locala.xky.mL();
          GMTrace.o(3975394885632L, 29619);
          return 0;
        }
        localbei.trc = locala.xky.mL();
        GMTrace.o(3975394885632L, 29619);
        return 0;
      }
      GMTrace.o(3975394885632L, 29619);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */