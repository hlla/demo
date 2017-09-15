package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class jy
  extends com.tencent.mm.bd.a
{
  public int krk;
  public LinkedList<jz> tor;
  public int tos;
  public avu tot;
  
  public jy()
  {
    GMTrace.i(13339228897280L, 99385);
    this.tor = new LinkedList();
    GMTrace.o(13339228897280L, 99385);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13339363115008L, 99386);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.krk);
      paramVarArgs.d(2, 8, this.tor);
      paramVarArgs.eO(3, this.tos);
      if (this.tot != null)
      {
        paramVarArgs.eQ(4, this.tot.aUd());
        this.tot.a(paramVarArgs);
      }
      GMTrace.o(13339363115008L, 99386);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.krk) + 0 + a.a.a.a.c(2, 8, this.tor) + a.a.a.a.eL(3, this.tos);
      paramInt = i;
      if (this.tot != null) {
        paramInt = i + a.a.a.a.eN(4, this.tot.aUd());
      }
      GMTrace.o(13339363115008L, 99386);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tor.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13339363115008L, 99386);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      jy localjy = (jy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13339363115008L, 99386);
        return -1;
      case 1: 
        localjy.krk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13339363115008L, 99386);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new jz();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((jz)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localjy.tor.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13339363115008L, 99386);
        return 0;
      case 3: 
        localjy.tos = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13339363115008L, 99386);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avu();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localjy.tot = ((avu)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13339363115008L, 99386);
      return 0;
    }
    GMTrace.o(13339363115008L, 99386);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/jy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */