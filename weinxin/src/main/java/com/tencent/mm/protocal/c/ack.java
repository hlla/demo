package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ack
  extends ave
{
  public avu tGB;
  public avu tGC;
  public avt tGD;
  public avt thY;
  public avu trH;
  
  public ack()
  {
    GMTrace.i(3782658228224L, 28183);
    GMTrace.o(3782658228224L, 28183);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3782792445952L, 28184);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.tGB == null) {
        throw new b("Not all required fields were included: Pwd");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.trH != null)
      {
        paramVarArgs.eQ(2, this.trH.aUd());
        this.trH.a(paramVarArgs);
      }
      if (this.tGB != null)
      {
        paramVarArgs.eQ(3, this.tGB.aUd());
        this.tGB.a(paramVarArgs);
      }
      if (this.tGC != null)
      {
        paramVarArgs.eQ(4, this.tGC.aUd());
        this.tGC.a(paramVarArgs);
      }
      if (this.thY != null)
      {
        paramVarArgs.eQ(5, this.thY.aUd());
        this.thY.a(paramVarArgs);
      }
      if (this.tGD != null)
      {
        paramVarArgs.eQ(6, this.tGD.aUd());
        this.tGD.a(paramVarArgs);
      }
      GMTrace.o(3782792445952L, 28184);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXb != null) {
        i = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      paramInt = i;
      if (this.trH != null) {
        paramInt = i + a.a.a.a.eN(2, this.trH.aUd());
      }
      i = paramInt;
      if (this.tGB != null) {
        i = paramInt + a.a.a.a.eN(3, this.tGB.aUd());
      }
      paramInt = i;
      if (this.tGC != null) {
        paramInt = i + a.a.a.a.eN(4, this.tGC.aUd());
      }
      i = paramInt;
      if (this.thY != null) {
        i = paramInt + a.a.a.a.eN(5, this.thY.aUd());
      }
      paramInt = i;
      if (this.tGD != null) {
        paramInt = i + a.a.a.a.eN(6, this.tGD.aUd());
      }
      GMTrace.o(3782792445952L, 28184);
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
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.tGB == null) {
        throw new b("Not all required fields were included: Pwd");
      }
      GMTrace.o(3782792445952L, 28184);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ack localack = (ack)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3782792445952L, 28184);
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
          localack.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3782792445952L, 28184);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localack.trH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3782792445952L, 28184);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localack.tGB = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3782792445952L, 28184);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localack.tGC = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3782792445952L, 28184);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localack.thY = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3782792445952L, 28184);
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
        localack.tGD = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3782792445952L, 28184);
      return 0;
    }
    GMTrace.o(3782792445952L, 28184);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */