package com.tencent.mm.protocal.b.a;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bd.a
{
  public String fEi;
  public int id;
  public LinkedList<a> sZy;
  public String title;
  
  public b()
  {
    GMTrace.i(4079279407104L, 30393);
    this.sZy = new LinkedList();
    GMTrace.o(4079279407104L, 30393);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4079413624832L, 30394);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.id);
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.fEi != null) {
        paramVarArgs.e(3, this.fEi);
      }
      paramVarArgs.d(4, 8, this.sZy);
      GMTrace.o(4079413624832L, 30394);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.id) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.fEi != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.fEi);
      }
      paramInt = a.a.a.a.c(4, 8, this.sZy);
      GMTrace.o(4079413624832L, 30394);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sZy.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4079413624832L, 30394);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4079413624832L, 30394);
        return -1;
      case 1: 
        localb.id = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4079413624832L, 30394);
        return 0;
      case 2: 
        localb.title = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4079413624832L, 30394);
        return 0;
      case 3: 
        localb.fEi = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4079413624832L, 30394);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new a();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((a)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localb.sZy.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(4079413624832L, 30394);
      return 0;
    }
    GMTrace.o(4079413624832L, 30394);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */