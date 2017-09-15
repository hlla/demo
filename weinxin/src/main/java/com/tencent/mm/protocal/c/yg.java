package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class yg
  extends ave
{
  public String tDc;
  public String tDd;
  
  public yg()
  {
    GMTrace.i(4012975849472L, 29899);
    GMTrace.o(4012975849472L, 29899);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4013110067200L, 29900);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tDc == null) {
        throw new b("Not all required fields were included: FunctionMsgID");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tDc != null) {
        paramVarArgs.e(2, this.tDc);
      }
      if (this.tDd != null) {
        paramVarArgs.e(3, this.tDd);
      }
      GMTrace.o(4013110067200L, 29900);
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
      if (this.tDc != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tDc);
      }
      i = paramInt;
      if (this.tDd != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tDd);
      }
      GMTrace.o(4013110067200L, 29900);
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
      if (this.tDc == null) {
        throw new b("Not all required fields were included: FunctionMsgID");
      }
      GMTrace.o(4013110067200L, 29900);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      yg localyg = (yg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4013110067200L, 29900);
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
          localyg.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4013110067200L, 29900);
        return 0;
      case 2: 
        localyg.tDc = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4013110067200L, 29900);
        return 0;
      }
      localyg.tDd = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(4013110067200L, 29900);
      return 0;
    }
    GMTrace.o(4013110067200L, 29900);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/yg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */