package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class dx
  extends com.tencent.mm.bd.a
{
  public avt tgc;
  public or tgd;
  
  public dx()
  {
    GMTrace.i(13582162984960L, 101195);
    GMTrace.o(13582162984960L, 101195);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13582297202688L, 101196);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tgc == null) {
        throw new b("Not all required fields were included: AesEncryptKey");
      }
      if (this.tgc != null)
      {
        paramVarArgs.eQ(2, this.tgc.aUd());
        this.tgc.a(paramVarArgs);
      }
      if (this.tgd != null)
      {
        paramVarArgs.eQ(3, this.tgd.aUd());
        this.tgd.a(paramVarArgs);
      }
      GMTrace.o(13582297202688L, 101196);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tgc != null) {
        paramInt = a.a.a.a.eN(2, this.tgc.aUd()) + 0;
      }
      i = paramInt;
      if (this.tgd != null) {
        i = paramInt + a.a.a.a.eN(3, this.tgd.aUd());
      }
      GMTrace.o(13582297202688L, 101196);
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
      if (this.tgc == null) {
        throw new b("Not all required fields were included: AesEncryptKey");
      }
      GMTrace.o(13582297202688L, 101196);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      dx localdx = (dx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13582297202688L, 101196);
        return -1;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdx.tgc = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13582297202688L, 101196);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new or();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((or)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localdx.tgd = ((or)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13582297202688L, 101196);
      return 0;
    }
    GMTrace.o(13582297202688L, 101196);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */