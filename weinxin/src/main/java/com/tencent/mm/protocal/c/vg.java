package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class vg
  extends avm
{
  public gx tji;
  public asy tjl;
  
  public vg()
  {
    GMTrace.i(3666023022592L, 27314);
    GMTrace.o(3666023022592L, 27314);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3666157240320L, 27315);
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
      if (this.tji != null)
      {
        paramVarArgs.eQ(3, this.tji.aUd());
        this.tji.a(paramVarArgs);
      }
      GMTrace.o(3666157240320L, 27315);
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
      if (this.tji != null) {
        i = paramInt + a.a.a.a.eN(3, this.tji.aUd());
      }
      GMTrace.o(3666157240320L, 27315);
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
      GMTrace.o(3666157240320L, 27315);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      vg localvg = (vg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3666157240320L, 27315);
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
          localvg.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3666157240320L, 27315);
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
          localvg.tjl = ((asy)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3666157240320L, 27315);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new gx();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((gx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localvg.tji = ((gx)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3666157240320L, 27315);
      return 0;
    }
    GMTrace.o(3666157240320L, 27315);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/vg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */