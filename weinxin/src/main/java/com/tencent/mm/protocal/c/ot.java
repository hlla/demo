package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ot
  extends avm
{
  public azz tfJ;
  public afa tif;
  public hr tig;
  public ane tih;
  public String tsG;
  
  public ot()
  {
    GMTrace.i(3848961785856L, 28677);
    GMTrace.o(3848961785856L, 28677);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3849096003584L, 28678);
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
      if (this.tsG != null) {
        paramVarArgs.e(2, this.tsG);
      }
      if (this.tig != null)
      {
        paramVarArgs.eQ(3, this.tig.aUd());
        this.tig.a(paramVarArgs);
      }
      if (this.tif != null)
      {
        paramVarArgs.eQ(4, this.tif.aUd());
        this.tif.a(paramVarArgs);
      }
      if (this.tfJ != null)
      {
        paramVarArgs.eQ(5, this.tfJ.aUd());
        this.tfJ.a(paramVarArgs);
      }
      if (this.tih != null)
      {
        paramVarArgs.eQ(6, this.tih.aUd());
        this.tih.a(paramVarArgs);
      }
      GMTrace.o(3849096003584L, 28678);
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
      if (this.tsG != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tsG);
      }
      i = paramInt;
      if (this.tig != null) {
        i = paramInt + a.a.a.a.eN(3, this.tig.aUd());
      }
      paramInt = i;
      if (this.tif != null) {
        paramInt = i + a.a.a.a.eN(4, this.tif.aUd());
      }
      i = paramInt;
      if (this.tfJ != null) {
        i = paramInt + a.a.a.a.eN(5, this.tfJ.aUd());
      }
      paramInt = i;
      if (this.tih != null) {
        paramInt = i + a.a.a.a.eN(6, this.tih.aUd());
      }
      GMTrace.o(3849096003584L, 28678);
      return paramInt;
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
      GMTrace.o(3849096003584L, 28678);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ot localot = (ot)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3849096003584L, 28678);
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
          localot.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3849096003584L, 28678);
        return 0;
      case 2: 
        localot.tsG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3849096003584L, 28678);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hr();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hr)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localot.tig = ((hr)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3849096003584L, 28678);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afa();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afa)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localot.tif = ((afa)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3849096003584L, 28678);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azz();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azz)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localot.tfJ = ((azz)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3849096003584L, 28678);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ane();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ane)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localot.tih = ((ane)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3849096003584L, 28678);
      return 0;
    }
    GMTrace.o(3849096003584L, 28678);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */