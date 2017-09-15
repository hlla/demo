package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bd.a
{
  public int sYJ;
  public int sYX;
  public int sYZ;
  public LinkedList<e> sZa;
  public b sZb;
  
  public i()
  {
    GMTrace.i(13101395083264L, 97613);
    this.sZa = new LinkedList();
    GMTrace.o(13101395083264L, 97613);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13101529300992L, 97614);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.sYJ);
      paramVarArgs.eO(2, this.sYZ);
      paramVarArgs.eO(3, this.sYX);
      paramVarArgs.d(4, 8, this.sZa);
      if (this.sZb != null) {
        paramVarArgs.b(5, this.sZb);
      }
      GMTrace.o(13101529300992L, 97614);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.sYJ) + 0 + a.a.a.a.eL(2, this.sYZ) + a.a.a.a.eL(3, this.sYX) + a.a.a.a.c(4, 8, this.sZa);
      paramInt = i;
      if (this.sZb != null) {
        paramInt = i + a.a.a.a.a(5, this.sZb);
      }
      GMTrace.o(13101529300992L, 97614);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sZa.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13101529300992L, 97614);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13101529300992L, 97614);
        return -1;
      case 1: 
        locali.sYJ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13101529300992L, 97614);
        return 0;
      case 2: 
        locali.sYZ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13101529300992L, 97614);
        return 0;
      case 3: 
        locali.sYX = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13101529300992L, 97614);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          locali.sZa.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13101529300992L, 97614);
        return 0;
      }
      locali.sZb = ((a.a.a.a.a)localObject1).chR();
      GMTrace.o(13101529300992L, 97614);
      return 0;
    }
    GMTrace.o(13101529300992L, 97614);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */