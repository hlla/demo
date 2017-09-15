package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class afz
  extends ave
{
  public int krk;
  public int tJw;
  public String tJx;
  public LinkedList<ali> tde;
  public avu tdf;
  
  public afz()
  {
    GMTrace.i(3691927044096L, 27507);
    this.tde = new LinkedList();
    GMTrace.o(3691927044096L, 27507);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3692061261824L, 27508);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tdf == null) {
        throw new b("Not all required fields were included: ChatRoomName");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.krk);
      paramVarArgs.d(3, 8, this.tde);
      if (this.tdf != null)
      {
        paramVarArgs.eQ(4, this.tdf.aUd());
        this.tdf.a(paramVarArgs);
      }
      paramVarArgs.eO(5, this.tJw);
      if (this.tJx != null) {
        paramVarArgs.e(6, this.tJx);
      }
      GMTrace.o(3692061261824L, 27508);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.krk) + a.a.a.a.c(3, 8, this.tde);
      paramInt = i;
      if (this.tdf != null) {
        paramInt = i + a.a.a.a.eN(4, this.tdf.aUd());
      }
      i = paramInt + a.a.a.a.eL(5, this.tJw);
      paramInt = i;
      if (this.tJx != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tJx);
      }
      GMTrace.o(3692061261824L, 27508);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tde.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tdf == null) {
        throw new b("Not all required fields were included: ChatRoomName");
      }
      GMTrace.o(3692061261824L, 27508);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      afz localafz = (afz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3692061261824L, 27508);
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
          localafz.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3692061261824L, 27508);
        return 0;
      case 2: 
        localafz.krk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3692061261824L, 27508);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ali();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ali)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localafz.tde.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3692061261824L, 27508);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localafz.tdf = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3692061261824L, 27508);
        return 0;
      case 5: 
        localafz.tJw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3692061261824L, 27508);
        return 0;
      }
      localafz.tJx = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3692061261824L, 27508);
      return 0;
    }
    GMTrace.o(3692061261824L, 27508);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/afz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */