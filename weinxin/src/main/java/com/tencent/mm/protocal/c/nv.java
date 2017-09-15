package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class nv
  extends ave
{
  public String trV;
  
  public nv()
  {
    GMTrace.i(3739976990720L, 27865);
    GMTrace.o(3739976990720L, 27865);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3740111208448L, 27866);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.trV != null) {
        paramVarArgs.e(2, this.trV);
      }
      GMTrace.o(3740111208448L, 27866);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt;
      if (this.trV != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.trV);
      }
      GMTrace.o(3740111208448L, 27866);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3740111208448L, 27866);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      nv localnv = (nv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3740111208448L, 27866);
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
          localnv.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3740111208448L, 27866);
        return 0;
      }
      localnv.trV = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3740111208448L, 27866);
      return 0;
    }
    GMTrace.o(3740111208448L, 27866);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/nv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */