package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ek
  extends com.tencent.mm.bd.a
{
  public avt tfE;
  public avt tfF;
  public String tfK;
  public avt tgM;
  public bmd tgN;
  public bpj tgO;
  public int tgP;
  
  public ek()
  {
    GMTrace.i(13578807541760L, 101170);
    GMTrace.o(13578807541760L, 101170);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13578941759488L, 101171);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tgM != null)
      {
        paramVarArgs.eQ(1, this.tgM.aUd());
        this.tgM.a(paramVarArgs);
      }
      if (this.tgN != null)
      {
        paramVarArgs.eQ(2, this.tgN.aUd());
        this.tgN.a(paramVarArgs);
      }
      if (this.tgO != null)
      {
        paramVarArgs.eQ(3, this.tgO.aUd());
        this.tgO.a(paramVarArgs);
      }
      if (this.tfE != null)
      {
        paramVarArgs.eQ(4, this.tfE.aUd());
        this.tfE.a(paramVarArgs);
      }
      if (this.tfF != null)
      {
        paramVarArgs.eQ(5, this.tfF.aUd());
        this.tfF.a(paramVarArgs);
      }
      paramVarArgs.eO(6, this.tgP);
      if (this.tfK != null) {
        paramVarArgs.e(7, this.tfK);
      }
      GMTrace.o(13578941759488L, 101171);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tgM != null) {
        i = a.a.a.a.eN(1, this.tgM.aUd()) + 0;
      }
      paramInt = i;
      if (this.tgN != null) {
        paramInt = i + a.a.a.a.eN(2, this.tgN.aUd());
      }
      i = paramInt;
      if (this.tgO != null) {
        i = paramInt + a.a.a.a.eN(3, this.tgO.aUd());
      }
      paramInt = i;
      if (this.tfE != null) {
        paramInt = i + a.a.a.a.eN(4, this.tfE.aUd());
      }
      i = paramInt;
      if (this.tfF != null) {
        i = paramInt + a.a.a.a.eN(5, this.tfF.aUd());
      }
      i += a.a.a.a.eL(6, this.tgP);
      paramInt = i;
      if (this.tfK != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.tfK);
      }
      GMTrace.o(13578941759488L, 101171);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13578941759488L, 101171);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ek localek = (ek)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13578941759488L, 101171);
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
          localek.tgM = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13578941759488L, 101171);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmd();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmd)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localek.tgN = ((bmd)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13578941759488L, 101171);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpj();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpj)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localek.tgO = ((bpj)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13578941759488L, 101171);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localek.tfE = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13578941759488L, 101171);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localek.tfF = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13578941759488L, 101171);
        return 0;
      case 6: 
        localek.tgP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13578941759488L, 101171);
        return 0;
      }
      localek.tfK = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(13578941759488L, 101171);
      return 0;
    }
    GMTrace.o(13578941759488L, 101171);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */