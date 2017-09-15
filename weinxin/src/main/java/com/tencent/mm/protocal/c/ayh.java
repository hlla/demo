package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ayh
  extends ave
{
  public String oog;
  public int tYJ;
  public int tcg;
  public aiv trB;
  
  public ayh()
  {
    GMTrace.i(3634347638784L, 27078);
    GMTrace.o(3634347638784L, 27078);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3634481856512L, 27079);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trB == null) {
        throw new b("Not all required fields were included: Loc");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.trB != null)
      {
        paramVarArgs.eQ(2, this.trB.aUd());
        this.trB.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tYJ);
      paramVarArgs.eO(4, this.tcg);
      if (this.oog != null) {
        paramVarArgs.e(5, this.oog);
      }
      GMTrace.o(3634481856512L, 27079);
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
      if (this.trB != null) {
        i = paramInt + a.a.a.a.eN(2, this.trB.aUd());
      }
      i = i + a.a.a.a.eL(3, this.tYJ) + a.a.a.a.eL(4, this.tcg);
      paramInt = i;
      if (this.oog != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.oog);
      }
      GMTrace.o(3634481856512L, 27079);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.trB == null) {
        throw new b("Not all required fields were included: Loc");
      }
      GMTrace.o(3634481856512L, 27079);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ayh localayh = (ayh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3634481856512L, 27079);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localayh.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3634481856512L, 27079);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aiv();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aiv)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localayh.trB = ((aiv)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3634481856512L, 27079);
        return 0;
      case 3: 
        localayh.tYJ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3634481856512L, 27079);
        return 0;
      case 4: 
        localayh.tcg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3634481856512L, 27079);
        return 0;
      }
      localayh.oog = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3634481856512L, 27079);
      return 0;
    }
    GMTrace.o(3634481856512L, 27079);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ayh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */