package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class afb
  extends com.tencent.mm.bd.a
{
  public String oSl;
  public String tiY;
  
  public afb()
  {
    GMTrace.i(3993916932096L, 29757);
    GMTrace.o(3993916932096L, 29757);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3994051149824L, 29758);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tiY != null) {
        paramVarArgs.e(1, this.tiY);
      }
      if (this.oSl != null) {
        paramVarArgs.e(2, this.oSl);
      }
      GMTrace.o(3994051149824L, 29758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tiY == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = a.a.a.b.b.a.f(1, this.tiY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oSl != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.oSl);
      }
      GMTrace.o(3994051149824L, 29758);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3994051149824L, 29758);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        afb localafb = (afb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3994051149824L, 29758);
          return -1;
        case 1: 
          localafb.tiY = locala.xky.readString();
          GMTrace.o(3994051149824L, 29758);
          return 0;
        }
        localafb.oSl = locala.xky.readString();
        GMTrace.o(3994051149824L, 29758);
        return 0;
      }
      GMTrace.o(3994051149824L, 29758);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/afb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */