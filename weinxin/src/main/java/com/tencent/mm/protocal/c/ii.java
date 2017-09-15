package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ii
  extends avm
{
  public String mut;
  public String muu;
  public int ofk;
  public long tdE;
  public String tlA;
  public String tlE;
  public String tlp;
  
  public ii()
  {
    GMTrace.i(3998748770304L, 29793);
    GMTrace.o(3998748770304L, 29793);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3998882988032L, 29794);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tlp != null) {
        paramVarArgs.e(3, this.tlp);
      }
      if (this.muu != null) {
        paramVarArgs.e(4, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.e(5, this.mut);
      }
      paramVarArgs.eO(9, this.ofk);
      paramVarArgs.O(10, this.tdE);
      if (this.tlA != null) {
        paramVarArgs.e(11, this.tlA);
      }
      if (this.tlE != null) {
        paramVarArgs.e(12, this.tlE);
      }
      GMTrace.o(3998882988032L, 29794);
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
      if (this.tlp != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tlp);
      }
      i = paramInt;
      if (this.muu != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.muu);
      }
      paramInt = i;
      if (this.mut != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.mut);
      }
      i = paramInt + a.a.a.a.eL(9, this.ofk) + a.a.a.a.N(10, this.tdE);
      paramInt = i;
      if (this.tlA != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.tlA);
      }
      i = paramInt;
      if (this.tlE != null) {
        i = paramInt + a.a.a.b.b.a.f(12, this.tlE);
      }
      GMTrace.o(3998882988032L, 29794);
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
      GMTrace.o(3998882988032L, 29794);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ii localii = (ii)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 2: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        GMTrace.o(3998882988032L, 29794);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localii.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3998882988032L, 29794);
        return 0;
      case 3: 
        localii.tlp = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998882988032L, 29794);
        return 0;
      case 4: 
        localii.muu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998882988032L, 29794);
        return 0;
      case 5: 
        localii.mut = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998882988032L, 29794);
        return 0;
      case 9: 
        localii.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3998882988032L, 29794);
        return 0;
      case 10: 
        localii.tdE = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3998882988032L, 29794);
        return 0;
      case 11: 
        localii.tlA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3998882988032L, 29794);
        return 0;
      }
      localii.tlE = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3998882988032L, 29794);
      return 0;
    }
    GMTrace.o(3998882988032L, 29794);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */