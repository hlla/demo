package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;

public final class em
  extends com.tencent.mm.bd.a
{
  public int lcP;
  public int tcg;
  public b tgT;
  public b tgU;
  public int tgV;
  public b tgW;
  
  public em()
  {
    GMTrace.i(13584578904064L, 101213);
    GMTrace.o(13584578904064L, 101213);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13584713121792L, 101214);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tgT != null) {
        paramVarArgs.b(1, this.tgT);
      }
      paramVarArgs.eO(2, this.lcP);
      if (this.tgU != null) {
        paramVarArgs.b(3, this.tgU);
      }
      paramVarArgs.eO(4, this.tgV);
      if (this.tgW != null) {
        paramVarArgs.b(5, this.tgW);
      }
      paramVarArgs.eO(6, this.tcg);
      GMTrace.o(13584713121792L, 101214);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tgT == null) {
        break label497;
      }
    }
    label497:
    for (paramInt = a.a.a.a.a(1, this.tgT) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.eL(2, this.lcP);
      paramInt = i;
      if (this.tgU != null) {
        paramInt = i + a.a.a.a.a(3, this.tgU);
      }
      i = paramInt + a.a.a.a.eL(4, this.tgV);
      paramInt = i;
      if (this.tgW != null) {
        paramInt = i + a.a.a.a.a(5, this.tgW);
      }
      i = a.a.a.a.eL(6, this.tcg);
      GMTrace.o(13584713121792L, 101214);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13584713121792L, 101214);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        em localem = (em)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13584713121792L, 101214);
          return -1;
        case 1: 
          localem.tgT = locala.chR();
          GMTrace.o(13584713121792L, 101214);
          return 0;
        case 2: 
          localem.lcP = locala.xky.mL();
          GMTrace.o(13584713121792L, 101214);
          return 0;
        case 3: 
          localem.tgU = locala.chR();
          GMTrace.o(13584713121792L, 101214);
          return 0;
        case 4: 
          localem.tgV = locala.xky.mL();
          GMTrace.o(13584713121792L, 101214);
          return 0;
        case 5: 
          localem.tgW = locala.chR();
          GMTrace.o(13584713121792L, 101214);
          return 0;
        }
        localem.tcg = locala.xky.mL();
        GMTrace.o(13584713121792L, 101214);
        return 0;
      }
      GMTrace.o(13584713121792L, 101214);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */