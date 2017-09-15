package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class acs
  extends avm
{
  public String tGI;
  public afa tif;
  public hr tig;
  public ane tih;
  
  public acs()
  {
    GMTrace.i(3655419822080L, 27235);
    GMTrace.o(3655419822080L, 27235);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3655554039808L, 27236);
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
      if (this.tGI != null) {
        paramVarArgs.e(2, this.tGI);
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
      if (this.tih != null)
      {
        paramVarArgs.eQ(5, this.tih.aUd());
        this.tih.a(paramVarArgs);
      }
      GMTrace.o(3655554039808L, 27236);
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
      if (this.tGI != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tGI);
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
      if (this.tih != null) {
        i = paramInt + a.a.a.a.eN(5, this.tih.aUd());
      }
      GMTrace.o(3655554039808L, 27236);
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
      GMTrace.o(3655554039808L, 27236);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      acs localacs = (acs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3655554039808L, 27236);
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
          localacs.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3655554039808L, 27236);
        return 0;
      case 2: 
        localacs.tGI = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3655554039808L, 27236);
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
          localacs.tig = ((hr)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3655554039808L, 27236);
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
          localacs.tif = ((afa)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3655554039808L, 27236);
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
        localacs.tih = ((ane)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3655554039808L, 27236);
      return 0;
    }
    GMTrace.o(3655554039808L, 27236);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/acs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */