package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class ya
  extends ave
{
  public String extra;
  public b tCV;
  public int taR;
  
  public ya()
  {
    GMTrace.i(3903588401152L, 29084);
    GMTrace.o(3903588401152L, 29084);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3903722618880L, 29085);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.taR);
      if (this.extra != null) {
        paramVarArgs.e(3, this.extra);
      }
      if (this.tCV != null) {
        paramVarArgs.b(4, this.tCV);
      }
      GMTrace.o(3903722618880L, 29085);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.taR);
      paramInt = i;
      if (this.extra != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.extra);
      }
      i = paramInt;
      if (this.tCV != null) {
        i = paramInt + a.a.a.a.a(4, this.tCV);
      }
      GMTrace.o(3903722618880L, 29085);
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
      GMTrace.o(3903722618880L, 29085);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ya localya = (ya)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3903722618880L, 29085);
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
          localya.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3903722618880L, 29085);
        return 0;
      case 2: 
        localya.taR = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3903722618880L, 29085);
        return 0;
      case 3: 
        localya.extra = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3903722618880L, 29085);
        return 0;
      }
      localya.tCV = ((a.a.a.a.a)localObject1).chR();
      GMTrace.o(3903722618880L, 29085);
      return 0;
    }
    GMTrace.o(3903722618880L, 29085);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ya.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */