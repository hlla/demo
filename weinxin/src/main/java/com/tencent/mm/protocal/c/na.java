package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class na
  extends com.tencent.mm.bd.a
{
  public avu trH;
  
  public na()
  {
    GMTrace.i(13342181687296L, 99407);
    GMTrace.o(13342181687296L, 99407);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13342315905024L, 99408);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.trH != null)
      {
        paramVarArgs.eQ(1, this.trH.aUd());
        this.trH.a(paramVarArgs);
      }
      GMTrace.o(13342315905024L, 99408);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.trH != null) {
        paramInt = a.a.a.a.eN(1, this.trH.aUd()) + 0;
      }
      GMTrace.o(13342315905024L, 99408);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      GMTrace.o(13342315905024L, 99408);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      na localna = (na)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13342315905024L, 99408);
        return -1;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avu();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localna.trH = ((avu)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13342315905024L, 99408);
      return 0;
    }
    GMTrace.o(13342315905024L, 99408);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/na.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */