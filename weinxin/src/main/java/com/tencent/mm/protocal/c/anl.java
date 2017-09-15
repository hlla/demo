package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class anl
  extends avm
{
  public avt tQE;
  public avt tQF;
  public int tQG;
  public int tQH;
  public LinkedList<lt> tQI;
  public int tba;
  public int tkt;
  
  public anl()
  {
    GMTrace.i(13579747065856L, 101177);
    this.tQI = new LinkedList();
    GMTrace.o(13579747065856L, 101177);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13579881283584L, 101178);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tQE == null) {
        throw new b("Not all required fields were included: CurrentSynckey");
      }
      if (this.tQF == null) {
        throw new b("Not all required fields were included: MaxSynckey");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tQE != null)
      {
        paramVarArgs.eQ(2, this.tQE.aUd());
        this.tQE.a(paramVarArgs);
      }
      if (this.tQF != null)
      {
        paramVarArgs.eQ(3, this.tQF.aUd());
        this.tQF.a(paramVarArgs);
      }
      paramVarArgs.eO(4, this.tkt);
      paramVarArgs.eO(5, this.tQG);
      paramVarArgs.eO(6, this.tQH);
      paramVarArgs.d(7, 8, this.tQI);
      paramVarArgs.eO(8, this.tba);
      GMTrace.o(13579881283584L, 101178);
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
      if (this.tQE != null) {
        paramInt = i + a.a.a.a.eN(2, this.tQE.aUd());
      }
      i = paramInt;
      if (this.tQF != null) {
        i = paramInt + a.a.a.a.eN(3, this.tQF.aUd());
      }
      paramInt = a.a.a.a.eL(4, this.tkt);
      int j = a.a.a.a.eL(5, this.tQG);
      int k = a.a.a.a.eL(6, this.tQH);
      int m = a.a.a.a.c(7, 8, this.tQI);
      int n = a.a.a.a.eL(8, this.tba);
      GMTrace.o(13579881283584L, 101178);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tQI.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tQE == null) {
        throw new b("Not all required fields were included: CurrentSynckey");
      }
      if (this.tQF == null) {
        throw new b("Not all required fields were included: MaxSynckey");
      }
      GMTrace.o(13579881283584L, 101178);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      anl localanl = (anl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13579881283584L, 101178);
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
          localanl.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13579881283584L, 101178);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localanl.tQE = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13579881283584L, 101178);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localanl.tQF = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13579881283584L, 101178);
        return 0;
      case 4: 
        localanl.tkt = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13579881283584L, 101178);
        return 0;
      case 5: 
        localanl.tQG = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13579881283584L, 101178);
        return 0;
      case 6: 
        localanl.tQH = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13579881283584L, 101178);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localanl.tQI.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13579881283584L, 101178);
        return 0;
      }
      localanl.tba = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13579881283584L, 101178);
      return 0;
    }
    GMTrace.o(13579881283584L, 101178);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/anl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */