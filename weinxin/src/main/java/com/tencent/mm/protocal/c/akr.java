package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class akr
  extends com.tencent.mm.bd.a
{
  public aks tMP;
  public akq tMQ;
  
  public akr()
  {
    GMTrace.i(13574646792192L, 101139);
    GMTrace.o(13574646792192L, 101139);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13574781009920L, 101140);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tMP == null) {
        throw new b("Not all required fields were included: RsaReqData");
      }
      if (this.tMQ == null) {
        throw new b("Not all required fields were included: AesReqData");
      }
      if (this.tMP != null)
      {
        paramVarArgs.eQ(1, this.tMP.aUd());
        this.tMP.a(paramVarArgs);
      }
      if (this.tMQ != null)
      {
        paramVarArgs.eQ(2, this.tMQ.aUd());
        this.tMQ.a(paramVarArgs);
      }
      GMTrace.o(13574781009920L, 101140);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tMP != null) {
        paramInt = a.a.a.a.eN(1, this.tMP.aUd()) + 0;
      }
      i = paramInt;
      if (this.tMQ != null) {
        i = paramInt + a.a.a.a.eN(2, this.tMQ.aUd());
      }
      GMTrace.o(13574781009920L, 101140);
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
      if (this.tMP == null) {
        throw new b("Not all required fields were included: RsaReqData");
      }
      if (this.tMQ == null) {
        throw new b("Not all required fields were included: AesReqData");
      }
      GMTrace.o(13574781009920L, 101140);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      akr localakr = (akr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13574781009920L, 101140);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aks();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aks)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localakr.tMP = ((aks)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13574781009920L, 101140);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new akq();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((akq)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localakr.tMQ = ((akq)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13574781009920L, 101140);
      return 0;
    }
    GMTrace.o(13574781009920L, 101140);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/akr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */