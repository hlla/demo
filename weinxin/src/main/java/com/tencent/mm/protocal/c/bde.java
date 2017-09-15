package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bde
  extends com.tencent.mm.bd.a
{
  public bdf ucO;
  public bdd ucP;
  public bdc ucQ;
  
  public bde()
  {
    GMTrace.i(3936874397696L, 29332);
    GMTrace.o(3936874397696L, 29332);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3937008615424L, 29333);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.ucO != null)
      {
        paramVarArgs.eQ(1, this.ucO.aUd());
        this.ucO.a(paramVarArgs);
      }
      if (this.ucP != null)
      {
        paramVarArgs.eQ(2, this.ucP.aUd());
        this.ucP.a(paramVarArgs);
      }
      if (this.ucQ != null)
      {
        paramVarArgs.eQ(3, this.ucQ.aUd());
        this.ucQ.a(paramVarArgs);
      }
      GMTrace.o(3937008615424L, 29333);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.ucO != null) {
        i = a.a.a.a.eN(1, this.ucO.aUd()) + 0;
      }
      paramInt = i;
      if (this.ucP != null) {
        paramInt = i + a.a.a.a.eN(2, this.ucP.aUd());
      }
      i = paramInt;
      if (this.ucQ != null) {
        i = paramInt + a.a.a.a.eN(3, this.ucQ.aUd());
      }
      GMTrace.o(3937008615424L, 29333);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3937008615424L, 29333);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bde localbde = (bde)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3937008615424L, 29333);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdf();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdf)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbde.ucO = ((bdf)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3937008615424L, 29333);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdd();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdd)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbde.ucP = ((bdd)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3937008615424L, 29333);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bdc();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bdc)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbde.ucQ = ((bdc)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3937008615424L, 29333);
      return 0;
    }
    GMTrace.o(3937008615424L, 29333);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */