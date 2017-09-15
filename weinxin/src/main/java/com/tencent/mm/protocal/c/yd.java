package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class yd
  extends avm
{
  public LinkedList<String> tCY;
  public asy tjl;
  
  public yd()
  {
    GMTrace.i(3761183391744L, 28023);
    this.tCY = new LinkedList();
    GMTrace.o(3761183391744L, 28023);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3761317609472L, 28024);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tjl == null) {
        throw new b("Not all required fields were included: qy_base_resp");
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
      paramVarArgs.d(3, 1, this.tCY);
      GMTrace.o(3761317609472L, 28024);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt;
      if (this.tjl != null) {
        i = paramInt + a.a.a.a.eN(2, this.tjl.aUd());
      }
      paramInt = a.a.a.a.c(3, 1, this.tCY);
      GMTrace.o(3761317609472L, 28024);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tCY.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
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
      GMTrace.o(3761317609472L, 28024);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      yd localyd = (yd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3761317609472L, 28024);
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
          localyd.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3761317609472L, 28024);
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
          localyd.tjl = ((asy)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3761317609472L, 28024);
        return 0;
      }
      localyd.tCY.add(((a.a.a.a.a)localObject1).xky.readString());
      GMTrace.o(3761317609472L, 28024);
      return 0;
    }
    GMTrace.o(3761317609472L, 28024);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/yd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */