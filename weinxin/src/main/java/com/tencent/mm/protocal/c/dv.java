package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class dv
  extends com.tencent.mm.bd.a
{
  public avt tfY;
  public avt tfZ;
  
  public dv()
  {
    GMTrace.i(13584847339520L, 101215);
    GMTrace.o(13584847339520L, 101215);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13584981557248L, 101216);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tfY == null) {
        throw new b("Not all required fields were included: EncryptKey");
      }
      if (this.tfZ == null) {
        throw new b("Not all required fields were included: Key");
      }
      if (this.tfY != null)
      {
        paramVarArgs.eQ(1, this.tfY.aUd());
        this.tfY.a(paramVarArgs);
      }
      if (this.tfZ != null)
      {
        paramVarArgs.eQ(2, this.tfZ.aUd());
        this.tfZ.a(paramVarArgs);
      }
      GMTrace.o(13584981557248L, 101216);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tfY != null) {
        paramInt = a.a.a.a.eN(1, this.tfY.aUd()) + 0;
      }
      i = paramInt;
      if (this.tfZ != null) {
        i = paramInt + a.a.a.a.eN(2, this.tfZ.aUd());
      }
      GMTrace.o(13584981557248L, 101216);
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
      if (this.tfY == null) {
        throw new b("Not all required fields were included: EncryptKey");
      }
      if (this.tfZ == null) {
        throw new b("Not all required fields were included: Key");
      }
      GMTrace.o(13584981557248L, 101216);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      dv localdv = (dv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13584981557248L, 101216);
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
          localdv.tfY = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584981557248L, 101216);
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
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localdv.tfZ = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13584981557248L, 101216);
      return 0;
    }
    GMTrace.o(13584981557248L, 101216);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */