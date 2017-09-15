package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bhj
  extends ave
{
  public String jLx;
  public int tDl;
  public int tfd;
  public int tfe;
  public avt tqC;
  public String ufk;
  
  public bhj()
  {
    GMTrace.i(3978750328832L, 29644);
    GMTrace.o(3978750328832L, 29644);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3978884546560L, 29645);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tfd);
      paramVarArgs.eO(3, this.tfe);
      paramVarArgs.eO(4, this.tDl);
      if (this.tqC != null)
      {
        paramVarArgs.eQ(5, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      if (this.ufk != null) {
        paramVarArgs.e(6, this.ufk);
      }
      if (this.jLx != null) {
        paramVarArgs.e(7, this.jLx);
      }
      GMTrace.o(3978884546560L, 29645);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tfd) + a.a.a.a.eL(3, this.tfe) + a.a.a.a.eL(4, this.tDl);
      paramInt = i;
      if (this.tqC != null) {
        paramInt = i + a.a.a.a.eN(5, this.tqC.aUd());
      }
      i = paramInt;
      if (this.ufk != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.ufk);
      }
      paramInt = i;
      if (this.jLx != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.jLx);
      }
      GMTrace.o(3978884546560L, 29645);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      GMTrace.o(3978884546560L, 29645);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bhj localbhj = (bhj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3978884546560L, 29645);
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
          localbhj.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3978884546560L, 29645);
        return 0;
      case 2: 
        localbhj.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3978884546560L, 29645);
        return 0;
      case 3: 
        localbhj.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3978884546560L, 29645);
        return 0;
      case 4: 
        localbhj.tDl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3978884546560L, 29645);
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
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhj.tqC = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3978884546560L, 29645);
        return 0;
      case 6: 
        localbhj.ufk = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3978884546560L, 29645);
        return 0;
      }
      localbhj.jLx = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3978884546560L, 29645);
      return 0;
    }
    GMTrace.o(3978884546560L, 29645);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */