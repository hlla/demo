package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ho
  extends com.tencent.mm.bd.a
{
  public String fTE;
  public int tkc;
  public int tkd;
  public String tke;
  
  public ho()
  {
    GMTrace.i(17826798632960L, 132820);
    GMTrace.o(17826798632960L, 132820);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17826932850688L, 132821);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.fTE != null) {
        paramVarArgs.e(1, this.fTE);
      }
      paramVarArgs.eO(2, this.tkc);
      paramVarArgs.eO(3, this.tkd);
      if (this.tke != null) {
        paramVarArgs.e(4, this.tke);
      }
      GMTrace.o(17826932850688L, 132821);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fTE == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = a.a.a.b.b.a.f(1, this.fTE) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.eL(2, this.tkc) + a.a.a.a.eL(3, this.tkd);
      paramInt = i;
      if (this.tke != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tke);
      }
      GMTrace.o(17826932850688L, 132821);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(17826932850688L, 132821);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ho localho = (ho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(17826932850688L, 132821);
          return -1;
        case 1: 
          localho.fTE = locala.xky.readString();
          GMTrace.o(17826932850688L, 132821);
          return 0;
        case 2: 
          localho.tkc = locala.xky.mL();
          GMTrace.o(17826932850688L, 132821);
          return 0;
        case 3: 
          localho.tkd = locala.xky.mL();
          GMTrace.o(17826932850688L, 132821);
          return 0;
        }
        localho.tke = locala.xky.readString();
        GMTrace.o(17826932850688L, 132821);
        return 0;
      }
      GMTrace.o(17826932850688L, 132821);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */