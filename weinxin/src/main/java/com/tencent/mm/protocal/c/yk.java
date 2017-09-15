package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class yk
  extends ave
{
  public String jLx;
  public int tDi;
  public int tDj;
  public String tDk;
  public int tDl;
  public int tfd;
  public int tfe;
  
  public yk()
  {
    GMTrace.i(3627099881472L, 27024);
    GMTrace.o(3627099881472L, 27024);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3627234099200L, 27025);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.jLx != null) {
        paramVarArgs.e(2, this.jLx);
      }
      paramVarArgs.eO(3, this.tDi);
      paramVarArgs.eO(4, this.tDj);
      if (this.tDk != null) {
        paramVarArgs.e(5, this.tDk);
      }
      paramVarArgs.eO(6, this.tfd);
      paramVarArgs.eO(7, this.tfe);
      paramVarArgs.eO(8, this.tDl);
      GMTrace.o(3627234099200L, 27025);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt;
      if (this.jLx != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.jLx);
      }
      i = i + a.a.a.a.eL(3, this.tDi) + a.a.a.a.eL(4, this.tDj);
      paramInt = i;
      if (this.tDk != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tDk);
      }
      i = a.a.a.a.eL(6, this.tfd);
      int j = a.a.a.a.eL(7, this.tfe);
      int k = a.a.a.a.eL(8, this.tDl);
      GMTrace.o(3627234099200L, 27025);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3627234099200L, 27025);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      yk localyk = (yk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3627234099200L, 27025);
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
          localyk.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3627234099200L, 27025);
        return 0;
      case 2: 
        localyk.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3627234099200L, 27025);
        return 0;
      case 3: 
        localyk.tDi = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3627234099200L, 27025);
        return 0;
      case 4: 
        localyk.tDj = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3627234099200L, 27025);
        return 0;
      case 5: 
        localyk.tDk = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3627234099200L, 27025);
        return 0;
      case 6: 
        localyk.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3627234099200L, 27025);
        return 0;
      case 7: 
        localyk.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3627234099200L, 27025);
        return 0;
      }
      localyk.tDl = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3627234099200L, 27025);
      return 0;
    }
    GMTrace.o(3627234099200L, 27025);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/yk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */