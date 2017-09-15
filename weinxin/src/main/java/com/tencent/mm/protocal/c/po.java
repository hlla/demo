package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class po
  extends com.tencent.mm.bd.a
{
  public pp tua;
  public pn tub;
  
  public po()
  {
    GMTrace.i(3908688674816L, 29122);
    GMTrace.o(3908688674816L, 29122);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3908822892544L, 29123);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tua == null) {
        throw new b("Not all required fields were included: RsaReqData");
      }
      if (this.tub == null) {
        throw new b("Not all required fields were included: AesReqData");
      }
      if (this.tua != null)
      {
        paramVarArgs.eQ(1, this.tua.aUd());
        this.tua.a(paramVarArgs);
      }
      if (this.tub != null)
      {
        paramVarArgs.eQ(2, this.tub.aUd());
        this.tub.a(paramVarArgs);
      }
      GMTrace.o(3908822892544L, 29123);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tua != null) {
        paramInt = a.a.a.a.eN(1, this.tua.aUd()) + 0;
      }
      i = paramInt;
      if (this.tub != null) {
        i = paramInt + a.a.a.a.eN(2, this.tub.aUd());
      }
      GMTrace.o(3908822892544L, 29123);
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
      if (this.tua == null) {
        throw new b("Not all required fields were included: RsaReqData");
      }
      if (this.tub == null) {
        throw new b("Not all required fields were included: AesReqData");
      }
      GMTrace.o(3908822892544L, 29123);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      po localpo = (po)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3908822892544L, 29123);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pp();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pp)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localpo.tua = ((pp)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3908822892544L, 29123);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new pn();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((pn)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localpo.tub = ((pn)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3908822892544L, 29123);
      return 0;
    }
    GMTrace.o(3908822892544L, 29123);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/po.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */