package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class vd
  extends ave
{
  public String tiZ;
  public String tjf;
  
  public vd()
  {
    GMTrace.i(4007875575808L, 29861);
    GMTrace.o(4007875575808L, 29861);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4008009793536L, 29862);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tjf != null) {
        paramVarArgs.e(2, this.tjf);
      }
      if (this.tiZ != null) {
        paramVarArgs.e(3, this.tiZ);
      }
      GMTrace.o(4008009793536L, 29862);
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
      if (this.tjf != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tjf);
      }
      i = paramInt;
      if (this.tiZ != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tiZ);
      }
      GMTrace.o(4008009793536L, 29862);
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
      GMTrace.o(4008009793536L, 29862);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      vd localvd = (vd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4008009793536L, 29862);
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
          localvd.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4008009793536L, 29862);
        return 0;
      case 2: 
        localvd.tjf = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4008009793536L, 29862);
        return 0;
      }
      localvd.tiZ = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(4008009793536L, 29862);
      return 0;
    }
    GMTrace.o(4008009793536L, 29862);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/vd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */