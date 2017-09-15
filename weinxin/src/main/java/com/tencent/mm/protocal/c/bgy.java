package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bgy
  extends avm
{
  public String jLx;
  public String mrA;
  public int ofk;
  public int tfd;
  public int tfe;
  public int tff;
  public String tso;
  public String ueY;
  
  public bgy()
  {
    GMTrace.i(3990695706624L, 29733);
    GMTrace.o(3990695706624L, 29733);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3990829924352L, 29734);
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
      if (this.mrA != null) {
        paramVarArgs.e(2, this.mrA);
      }
      if (this.tso != null) {
        paramVarArgs.e(3, this.tso);
      }
      if (this.ueY != null) {
        paramVarArgs.e(4, this.ueY);
      }
      if (this.jLx != null) {
        paramVarArgs.e(5, this.jLx);
      }
      paramVarArgs.eO(6, this.tfd);
      paramVarArgs.eO(7, this.tfe);
      paramVarArgs.eO(8, this.tff);
      paramVarArgs.eO(9, this.ofk);
      GMTrace.o(3990829924352L, 29734);
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
      if (this.mrA != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mrA);
      }
      i = paramInt;
      if (this.tso != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tso);
      }
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.ueY);
      }
      i = paramInt;
      if (this.jLx != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.jLx);
      }
      paramInt = a.a.a.a.eL(6, this.tfd);
      int j = a.a.a.a.eL(7, this.tfe);
      int k = a.a.a.a.eL(8, this.tff);
      int m = a.a.a.a.eL(9, this.ofk);
      GMTrace.o(3990829924352L, 29734);
      return i + paramInt + j + k + m;
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
      GMTrace.o(3990829924352L, 29734);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bgy localbgy = (bgy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3990829924352L, 29734);
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
          localbgy.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3990829924352L, 29734);
        return 0;
      case 2: 
        localbgy.mrA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3990829924352L, 29734);
        return 0;
      case 3: 
        localbgy.tso = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3990829924352L, 29734);
        return 0;
      case 4: 
        localbgy.ueY = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3990829924352L, 29734);
        return 0;
      case 5: 
        localbgy.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3990829924352L, 29734);
        return 0;
      case 6: 
        localbgy.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3990829924352L, 29734);
        return 0;
      case 7: 
        localbgy.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3990829924352L, 29734);
        return 0;
      case 8: 
        localbgy.tff = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3990829924352L, 29734);
        return 0;
      }
      localbgy.ofk = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3990829924352L, 29734);
      return 0;
    }
    GMTrace.o(3990829924352L, 29734);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */