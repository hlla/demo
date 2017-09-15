package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aia
  extends ave
{
  public avt tKA;
  public avt tKB;
  public int tKz;
  public avt thY;
  
  public aia()
  {
    GMTrace.i(13098710728704L, 97593);
    GMTrace.o(13098710728704L, 97593);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13098844946432L, 97594);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tKA == null) {
        throw new b("Not all required fields were included: KVBuffer");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tKz);
      if (this.tKA != null)
      {
        paramVarArgs.eQ(3, this.tKA.aUd());
        this.tKA.a(paramVarArgs);
      }
      if (this.thY != null)
      {
        paramVarArgs.eQ(4, this.thY.aUd());
        this.thY.a(paramVarArgs);
      }
      if (this.tKB != null)
      {
        paramVarArgs.eQ(5, this.tKB.aUd());
        this.tKB.a(paramVarArgs);
      }
      GMTrace.o(13098844946432L, 97594);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tKz);
      paramInt = i;
      if (this.tKA != null) {
        paramInt = i + a.a.a.a.eN(3, this.tKA.aUd());
      }
      i = paramInt;
      if (this.thY != null) {
        i = paramInt + a.a.a.a.eN(4, this.thY.aUd());
      }
      paramInt = i;
      if (this.tKB != null) {
        paramInt = i + a.a.a.a.eN(5, this.tKB.aUd());
      }
      GMTrace.o(13098844946432L, 97594);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tKA == null) {
        throw new b("Not all required fields were included: KVBuffer");
      }
      GMTrace.o(13098844946432L, 97594);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aia localaia = (aia)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13098844946432L, 97594);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localaia.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13098844946432L, 97594);
        return 0;
      case 2: 
        localaia.tKz = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13098844946432L, 97594);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localaia.tKA = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13098844946432L, 97594);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localaia.thY = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13098844946432L, 97594);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localaia.tKB = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13098844946432L, 97594);
      return 0;
    }
    GMTrace.o(13098844946432L, 97594);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */