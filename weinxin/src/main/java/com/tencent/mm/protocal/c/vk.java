package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class vk
  extends avm
{
  public gy tBf;
  public asy tjl;
  
  public vk()
  {
    GMTrace.i(3903856836608L, 29086);
    GMTrace.o(3903856836608L, 29086);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3903991054336L, 29087);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tjl == null) {
        throw new b("Not all required fields were included: qy_base_resp");
      }
      if (this.tBf == null) {
        throw new b("Not all required fields were included: attr");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tjl != null)
      {
        paramVarArgs.eQ(2, this.tjl.aUd());
        this.tjl.a(paramVarArgs);
      }
      if (this.tBf != null)
      {
        paramVarArgs.eQ(3, this.tBf.aUd());
        this.tBf.a(paramVarArgs);
      }
      GMTrace.o(3903991054336L, 29087);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXs != null) {
        i = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      paramInt = i;
      if (this.tjl != null) {
        paramInt = i + a.a.a.a.eN(2, this.tjl.aUd());
      }
      i = paramInt;
      if (this.tBf != null) {
        i = paramInt + a.a.a.a.eN(3, this.tBf.aUd());
      }
      GMTrace.o(3903991054336L, 29087);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tjl == null) {
        throw new b("Not all required fields were included: qy_base_resp");
      }
      if (this.tBf == null) {
        throw new b("Not all required fields were included: attr");
      }
      GMTrace.o(3903991054336L, 29087);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      vk localvk = (vk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3903991054336L, 29087);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localvk.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3903991054336L, 29087);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new asy();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((asy)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localvk.tjl = ((asy)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3903991054336L, 29087);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new gy();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((gy)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localvk.tBf = ((gy)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3903991054336L, 29087);
      return 0;
    }
    GMTrace.o(3903991054336L, 29087);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/vk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */