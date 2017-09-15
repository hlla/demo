package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ajv
  extends ave
{
  public int aIo;
  public String lang;
  public int offset;
  
  public ajv()
  {
    GMTrace.i(3956470185984L, 29478);
    GMTrace.o(3956470185984L, 29478);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3956604403712L, 29479);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.offset);
      paramVarArgs.eO(3, this.aIo);
      if (this.lang != null) {
        paramVarArgs.e(4, this.lang);
      }
      GMTrace.o(3956604403712L, 29479);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.offset) + a.a.a.a.eL(3, this.aIo);
      paramInt = i;
      if (this.lang != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.lang);
      }
      GMTrace.o(3956604403712L, 29479);
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
      GMTrace.o(3956604403712L, 29479);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ajv localajv = (ajv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3956604403712L, 29479);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localajv.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3956604403712L, 29479);
        return 0;
      case 2: 
        localajv.offset = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3956604403712L, 29479);
        return 0;
      case 3: 
        localajv.aIo = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3956604403712L, 29479);
        return 0;
      }
      localajv.lang = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3956604403712L, 29479);
      return 0;
    }
    GMTrace.o(3956604403712L, 29479);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ajv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */