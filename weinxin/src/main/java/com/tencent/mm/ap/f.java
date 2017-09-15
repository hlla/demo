package com.tencent.mm.ap;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bd.a
{
  public LinkedList<d> hNM;
  public double hNN;
  
  public f()
  {
    GMTrace.i(12943957688320L, 96440);
    this.hNM = new LinkedList();
    GMTrace.o(12943957688320L, 96440);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(12944091906048L, 96441);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.hNM);
      paramVarArgs.a(2, this.hNN);
      GMTrace.o(12944091906048L, 96441);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.c(1, 8, this.hNM);
      i = a.a.a.b.b.a.cH(2);
      GMTrace.o(12944091906048L, 96441);
      return paramInt + 0 + (i + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hNM.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(12944091906048L, 96441);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(12944091906048L, 96441);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localf.hNM.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(12944091906048L, 96441);
        return 0;
      }
      localf.hNN = ((a.a.a.a.a)localObject1).xky.readDouble();
      GMTrace.o(12944091906048L, 96441);
      return 0;
    }
    GMTrace.o(12944091906048L, 96441);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */