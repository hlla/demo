package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ok
  extends ave
{
  public long tdE;
  public int tdw;
  public int tfd;
  public int tfe;
  public int tss;
  public int tst;
  
  public ok()
  {
    GMTrace.i(3912446771200L, 29150);
    GMTrace.o(3912446771200L, 29150);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3912580988928L, 29151);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tdw);
      paramVarArgs.eO(3, this.tfd);
      paramVarArgs.eO(4, this.tfe);
      paramVarArgs.eO(5, this.tss);
      paramVarArgs.eO(6, this.tst);
      paramVarArgs.O(7, this.tdE);
      GMTrace.o(3912580988928L, 29151);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.tdw);
      int j = a.a.a.a.eL(3, this.tfd);
      int k = a.a.a.a.eL(4, this.tfe);
      int m = a.a.a.a.eL(5, this.tss);
      int n = a.a.a.a.eL(6, this.tst);
      int i1 = a.a.a.a.N(7, this.tdE);
      GMTrace.o(3912580988928L, 29151);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3912580988928L, 29151);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ok localok = (ok)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3912580988928L, 29151);
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
          localok.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3912580988928L, 29151);
        return 0;
      case 2: 
        localok.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3912580988928L, 29151);
        return 0;
      case 3: 
        localok.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3912580988928L, 29151);
        return 0;
      case 4: 
        localok.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3912580988928L, 29151);
        return 0;
      case 5: 
        localok.tss = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3912580988928L, 29151);
        return 0;
      case 6: 
        localok.tst = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3912580988928L, 29151);
        return 0;
      }
      localok.tdE = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(3912580988928L, 29151);
      return 0;
    }
    GMTrace.o(3912580988928L, 29151);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */