package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class apa
  extends com.tencent.mm.bd.a
{
  public int tSt;
  public avt tSu;
  public int tSv;
  
  public apa()
  {
    GMTrace.i(13167430205440L, 98105);
    GMTrace.o(13167430205440L, 98105);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13167564423168L, 98106);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tSt);
      if (this.tSu != null)
      {
        paramVarArgs.eQ(2, this.tSu.aUd());
        this.tSu.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tSv);
      GMTrace.o(13167564423168L, 98106);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tSt) + 0;
      paramInt = i;
      if (this.tSu != null) {
        paramInt = i + a.a.a.a.eN(2, this.tSu.aUd());
      }
      i = a.a.a.a.eL(3, this.tSv);
      GMTrace.o(13167564423168L, 98106);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13167564423168L, 98106);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      apa localapa = (apa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13167564423168L, 98106);
        return -1;
      case 1: 
        localapa.tSt = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13167564423168L, 98106);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localapa.tSu = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13167564423168L, 98106);
        return 0;
      }
      localapa.tSv = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13167564423168L, 98106);
      return 0;
    }
    GMTrace.o(13167564423168L, 98106);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/apa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */