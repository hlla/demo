package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bic
  extends ave
{
  public String tpP;
  public bjk tpQ;
  public bib tpS;
  public avt tqC;
  
  public bic()
  {
    GMTrace.i(3977676587008L, 29636);
    GMTrace.o(3977676587008L, 29636);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3977810804736L, 29637);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tpQ == null) {
        throw new b("Not all required fields were included: VoiceAttr");
      }
      if (this.tpS == null) {
        throw new b("Not all required fields were included: UploadCtx");
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tpP != null) {
        paramVarArgs.e(2, this.tpP);
      }
      if (this.tpQ != null)
      {
        paramVarArgs.eQ(3, this.tpQ.aUd());
        this.tpQ.a(paramVarArgs);
      }
      if (this.tpS != null)
      {
        paramVarArgs.eQ(4, this.tpS.aUd());
        this.tpS.a(paramVarArgs);
      }
      if (this.tqC != null)
      {
        paramVarArgs.eQ(5, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      GMTrace.o(3977810804736L, 29637);
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
      if (this.tpP != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tpP);
      }
      i = paramInt;
      if (this.tpQ != null) {
        i = paramInt + a.a.a.a.eN(3, this.tpQ.aUd());
      }
      paramInt = i;
      if (this.tpS != null) {
        paramInt = i + a.a.a.a.eN(4, this.tpS.aUd());
      }
      i = paramInt;
      if (this.tqC != null) {
        i = paramInt + a.a.a.a.eN(5, this.tqC.aUd());
      }
      GMTrace.o(3977810804736L, 29637);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tpQ == null) {
        throw new b("Not all required fields were included: VoiceAttr");
      }
      if (this.tpS == null) {
        throw new b("Not all required fields were included: UploadCtx");
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      GMTrace.o(3977810804736L, 29637);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bic localbic = (bic)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3977810804736L, 29637);
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
          localbic.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3977810804736L, 29637);
        return 0;
      case 2: 
        localbic.tpP = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3977810804736L, 29637);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjk();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjk)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbic.tpQ = ((bjk)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3977810804736L, 29637);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bib();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bib)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbic.tpS = ((bib)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3977810804736L, 29637);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localbic.tqC = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3977810804736L, 29637);
      return 0;
    }
    GMTrace.o(3977810804736L, 29637);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */