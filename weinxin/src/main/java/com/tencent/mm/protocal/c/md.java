package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class md
  extends com.tencent.mm.bd.a
{
  public String tqJ;
  public LinkedList<Integer> tqK;
  
  public md()
  {
    GMTrace.i(4035390210048L, 30066);
    this.tqK = new LinkedList();
    GMTrace.o(4035390210048L, 30066);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4035524427776L, 30067);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tqJ != null) {
        paramVarArgs.e(1, this.tqJ);
      }
      paramVarArgs.d(2, 2, this.tqK);
      GMTrace.o(4035524427776L, 30067);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tqJ == null) {
        break label309;
      }
    }
    label309:
    for (paramInt = a.a.a.b.b.a.f(1, this.tqJ) + 0;; paramInt = 0)
    {
      int i = a.a.a.a.c(2, 2, this.tqK);
      GMTrace.o(4035524427776L, 30067);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tqK.clear();
        paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(4035524427776L, 30067);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        md localmd = (md)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(4035524427776L, 30067);
          return -1;
        case 1: 
          localmd.tqJ = locala.xky.readString();
          GMTrace.o(4035524427776L, 30067);
          return 0;
        }
        localmd.tqK.add(Integer.valueOf(locala.xky.mL()));
        GMTrace.o(4035524427776L, 30067);
        return 0;
      }
      GMTrace.o(4035524427776L, 30067);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/md.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */