package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aft
  extends com.tencent.mm.bd.a
{
  public avu tJo;
  public avt tdB;
  
  public aft()
  {
    GMTrace.i(3651661725696L, 27207);
    GMTrace.o(3651661725696L, 27207);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3651795943424L, 27208);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tJo == null) {
        throw new b("Not all required fields were included: Username");
      }
      if (this.tdB != null)
      {
        paramVarArgs.eQ(1, this.tdB.aUd());
        this.tdB.a(paramVarArgs);
      }
      if (this.tJo != null)
      {
        paramVarArgs.eQ(2, this.tJo.aUd());
        this.tJo.a(paramVarArgs);
      }
      GMTrace.o(3651795943424L, 27208);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tdB != null) {
        paramInt = a.a.a.a.eN(1, this.tdB.aUd()) + 0;
      }
      i = paramInt;
      if (this.tJo != null) {
        i = paramInt + a.a.a.a.eN(2, this.tJo.aUd());
      }
      GMTrace.o(3651795943424L, 27208);
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
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tJo == null) {
        throw new b("Not all required fields were included: Username");
      }
      GMTrace.o(3651795943424L, 27208);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aft localaft = (aft)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3651795943424L, 27208);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaft.tdB = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3651795943424L, 27208);
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
        localaft.tJo = ((avu)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3651795943424L, 27208);
      return 0;
    }
    GMTrace.o(3651795943424L, 27208);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */