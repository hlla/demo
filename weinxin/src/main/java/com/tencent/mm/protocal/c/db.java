package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class db
  extends com.tencent.mm.bd.a
{
  public String mrA;
  public int tay;
  public int teP;
  public int teQ;
  public dg teR;
  public da teS;
  
  public db()
  {
    GMTrace.i(3821984022528L, 28476);
    GMTrace.o(3821984022528L, 28476);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3822118240256L, 28477);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mrA == null) {
        throw new b("Not all required fields were included: AppId");
      }
      paramVarArgs.eO(1, this.tay);
      if (this.mrA != null) {
        paramVarArgs.e(2, this.mrA);
      }
      paramVarArgs.eO(3, this.teP);
      paramVarArgs.eO(4, this.teQ);
      if (this.teR != null)
      {
        paramVarArgs.eQ(5, this.teR.aUd());
        this.teR.a(paramVarArgs);
      }
      if (this.teS != null)
      {
        paramVarArgs.eQ(6, this.teS.aUd());
        this.teS.a(paramVarArgs);
      }
      GMTrace.o(3822118240256L, 28477);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tay) + 0;
      paramInt = i;
      if (this.mrA != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mrA);
      }
      i = paramInt + a.a.a.a.eL(3, this.teP) + a.a.a.a.eL(4, this.teQ);
      paramInt = i;
      if (this.teR != null) {
        paramInt = i + a.a.a.a.eN(5, this.teR.aUd());
      }
      i = paramInt;
      if (this.teS != null) {
        i = paramInt + a.a.a.a.eN(6, this.teS.aUd());
      }
      GMTrace.o(3822118240256L, 28477);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.mrA == null) {
        throw new b("Not all required fields were included: AppId");
      }
      GMTrace.o(3822118240256L, 28477);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      db localdb = (db)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3822118240256L, 28477);
        return -1;
      case 1: 
        localdb.tay = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3822118240256L, 28477);
        return 0;
      case 2: 
        localdb.mrA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3822118240256L, 28477);
        return 0;
      case 3: 
        localdb.teP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3822118240256L, 28477);
        return 0;
      case 4: 
        localdb.teQ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3822118240256L, 28477);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dg();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dg)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdb.teR = ((dg)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3822118240256L, 28477);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new da();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((da)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localdb.teS = ((da)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3822118240256L, 28477);
      return 0;
    }
    GMTrace.o(3822118240256L, 28477);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */