package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aln
  extends com.tencent.mm.bd.a
{
  public int jMq;
  public int ofk;
  public String oog;
  public int tOK;
  public String tdC;
  public avu tdy;
  
  public aln()
  {
    GMTrace.i(13337618284544L, 99373);
    GMTrace.o(13337618284544L, 99373);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13337752502272L, 99374);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.tdy != null)
      {
        paramVarArgs.eQ(1, this.tdy.aUd());
        this.tdy.a(paramVarArgs);
      }
      if (this.oog != null) {
        paramVarArgs.e(2, this.oog);
      }
      paramVarArgs.eO(3, this.jMq);
      paramVarArgs.eO(4, this.ofk);
      paramVarArgs.eO(5, this.tOK);
      if (this.tdC != null) {
        paramVarArgs.e(6, this.tdC);
      }
      GMTrace.o(13337752502272L, 99374);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tdy != null) {
        paramInt = a.a.a.a.eN(1, this.tdy.aUd()) + 0;
      }
      i = paramInt;
      if (this.oog != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.oog);
      }
      i = i + a.a.a.a.eL(3, this.jMq) + a.a.a.a.eL(4, this.ofk) + a.a.a.a.eL(5, this.tOK);
      paramInt = i;
      if (this.tdC != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tdC);
      }
      GMTrace.o(13337752502272L, 99374);
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
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      GMTrace.o(13337752502272L, 99374);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aln localaln = (aln)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13337752502272L, 99374);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaln.tdy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13337752502272L, 99374);
        return 0;
      case 2: 
        localaln.oog = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13337752502272L, 99374);
        return 0;
      case 3: 
        localaln.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13337752502272L, 99374);
        return 0;
      case 4: 
        localaln.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13337752502272L, 99374);
        return 0;
      case 5: 
        localaln.tOK = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13337752502272L, 99374);
        return 0;
      }
      localaln.tdC = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(13337752502272L, 99374);
      return 0;
    }
    GMTrace.o(13337752502272L, 99374);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */