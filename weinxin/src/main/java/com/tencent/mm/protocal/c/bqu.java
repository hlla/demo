package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bqu
  extends ave
{
  public String lda;
  public int mqM;
  public String tfU;
  public String unk;
  
  public bqu()
  {
    GMTrace.i(3663607103488L, 27296);
    GMTrace.o(3663607103488L, 27296);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3663741321216L, 27297);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.lda != null) {
        paramVarArgs.e(2, this.lda);
      }
      if (this.tfU != null) {
        paramVarArgs.e(3, this.tfU);
      }
      if (this.unk != null) {
        paramVarArgs.e(4, this.unk);
      }
      paramVarArgs.eO(5, this.mqM);
      GMTrace.o(3663741321216L, 27297);
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
      if (this.lda != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.lda);
      }
      i = paramInt;
      if (this.tfU != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tfU);
      }
      paramInt = i;
      if (this.unk != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.unk);
      }
      i = a.a.a.a.eL(5, this.mqM);
      GMTrace.o(3663741321216L, 27297);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3663741321216L, 27297);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bqu localbqu = (bqu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3663741321216L, 27297);
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
          localbqu.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3663741321216L, 27297);
        return 0;
      case 2: 
        localbqu.lda = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3663741321216L, 27297);
        return 0;
      case 3: 
        localbqu.tfU = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3663741321216L, 27297);
        return 0;
      case 4: 
        localbqu.unk = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3663741321216L, 27297);
        return 0;
      }
      localbqu.mqM = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3663741321216L, 27297);
      return 0;
    }
    GMTrace.o(3663741321216L, 27297);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */