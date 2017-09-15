package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bd.a
{
  public int sYJ;
  public int sYZ;
  public LinkedList<b> sZa;
  public com.tencent.mm.bd.b sZb;
  
  public g()
  {
    GMTrace.i(13103005696000L, 97625);
    this.sZa = new LinkedList();
    GMTrace.o(13103005696000L, 97625);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13103139913728L, 97626);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.sYJ);
      paramVarArgs.eO(2, this.sYZ);
      paramVarArgs.d(3, 8, this.sZa);
      if (this.sZb != null) {
        paramVarArgs.b(4, this.sZb);
      }
      GMTrace.o(13103139913728L, 97626);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.sYJ) + 0 + a.a.a.a.eL(2, this.sYZ) + a.a.a.a.c(3, 8, this.sZa);
      paramInt = i;
      if (this.sZb != null) {
        paramInt = i + a.a.a.a.a(4, this.sZb);
      }
      GMTrace.o(13103139913728L, 97626);
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
      GMTrace.o(13103139913728L, 97626);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13103139913728L, 97626);
        return -1;
      case 1: 
        localg.sYJ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103139913728L, 97626);
        return 0;
      case 2: 
        localg.sYZ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103139913728L, 97626);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localg.sZa.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13103139913728L, 97626);
        return 0;
      }
      localg.sZb = ((a.a.a.a.a)localObject1).chR();
      GMTrace.o(13103139913728L, 97626);
      return 0;
    }
    GMTrace.o(13103139913728L, 97626);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */