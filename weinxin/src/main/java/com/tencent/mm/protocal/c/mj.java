package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class mj
  extends com.tencent.mm.bd.a
{
  public String fDt;
  public String mqJ;
  public String mrm;
  public int trf;
  public LinkedList<ale> trg;
  public int trh;
  
  public mj()
  {
    GMTrace.i(3744003522560L, 27895);
    this.trg = new LinkedList();
    GMTrace.o(3744003522560L, 27895);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3744137740288L, 27896);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mqJ != null) {
        paramVarArgs.e(1, this.mqJ);
      }
      paramVarArgs.eO(2, this.trf);
      if (this.fDt != null) {
        paramVarArgs.e(3, this.fDt);
      }
      if (this.mrm != null) {
        paramVarArgs.e(4, this.mrm);
      }
      paramVarArgs.d(5, 8, this.trg);
      paramVarArgs.eO(6, this.trh);
      GMTrace.o(3744137740288L, 27896);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.mqJ != null) {
        paramInt = a.a.a.b.b.a.f(1, this.mqJ) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.trf);
      paramInt = i;
      if (this.fDt != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.fDt);
      }
      i = paramInt;
      if (this.mrm != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.mrm);
      }
      paramInt = a.a.a.a.c(5, 8, this.trg);
      int j = a.a.a.a.eL(6, this.trh);
      GMTrace.o(3744137740288L, 27896);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.trg.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3744137740288L, 27896);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      mj localmj = (mj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3744137740288L, 27896);
        return -1;
      case 1: 
        localmj.mqJ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3744137740288L, 27896);
        return 0;
      case 2: 
        localmj.trf = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3744137740288L, 27896);
        return 0;
      case 3: 
        localmj.fDt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3744137740288L, 27896);
        return 0;
      case 4: 
        localmj.mrm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3744137740288L, 27896);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ale();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ale)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localmj.trg.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3744137740288L, 27896);
        return 0;
      }
      localmj.trh = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3744137740288L, 27896);
      return 0;
    }
    GMTrace.o(3744137740288L, 27896);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/mj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */