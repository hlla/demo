package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ahu
  extends ave
{
  public String tKr;
  public String tKs;
  
  public ahu()
  {
    GMTrace.i(3969623523328L, 29576);
    GMTrace.o(3969623523328L, 29576);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3969757741056L, 29577);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tKr != null) {
        paramVarArgs.e(2, this.tKr);
      }
      if (this.tKs != null) {
        paramVarArgs.e(3, this.tKs);
      }
      GMTrace.o(3969757741056L, 29577);
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
      if (this.tKr != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tKr);
      }
      i = paramInt;
      if (this.tKs != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tKs);
      }
      GMTrace.o(3969757741056L, 29577);
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
      GMTrace.o(3969757741056L, 29577);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ahu localahu = (ahu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3969757741056L, 29577);
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
          localahu.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3969757741056L, 29577);
        return 0;
      case 2: 
        localahu.tKr = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3969757741056L, 29577);
        return 0;
      }
      localahu.tKs = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3969757741056L, 29577);
      return 0;
    }
    GMTrace.o(3969757741056L, 29577);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ahu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */