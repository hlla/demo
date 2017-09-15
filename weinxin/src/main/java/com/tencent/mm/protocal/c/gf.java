package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class gf
  extends ave
{
  public avt tgM;
  public String thW;
  public String thX;
  public String tie;
  public int tin;
  public String tio;
  public String tip;
  public String tiq;
  public int tir;
  public avu tis;
  public avt tit;
  public int tiu;
  
  public gf()
  {
    GMTrace.i(3880100298752L, 28909);
    GMTrace.o(3880100298752L, 28909);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3880234516480L, 28910);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tin);
      if (this.tie != null) {
        paramVarArgs.e(3, this.tie);
      }
      if (this.tio != null) {
        paramVarArgs.e(4, this.tio);
      }
      if (this.tip != null) {
        paramVarArgs.e(5, this.tip);
      }
      if (this.tiq != null) {
        paramVarArgs.e(6, this.tiq);
      }
      paramVarArgs.eO(7, this.tir);
      if (this.tis != null)
      {
        paramVarArgs.eQ(8, this.tis.aUd());
        this.tis.a(paramVarArgs);
      }
      if (this.tit != null)
      {
        paramVarArgs.eQ(9, this.tit.aUd());
        this.tit.a(paramVarArgs);
      }
      paramVarArgs.eO(10, this.tiu);
      if (this.thW != null) {
        paramVarArgs.e(11, this.thW);
      }
      if (this.thX != null) {
        paramVarArgs.e(12, this.thX);
      }
      if (this.tgM != null)
      {
        paramVarArgs.eQ(13, this.tgM.aUd());
        this.tgM.a(paramVarArgs);
      }
      GMTrace.o(3880234516480L, 28910);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tin);
      paramInt = i;
      if (this.tie != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tie);
      }
      i = paramInt;
      if (this.tio != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.tio);
      }
      paramInt = i;
      if (this.tip != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tip);
      }
      i = paramInt;
      if (this.tiq != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.tiq);
      }
      i += a.a.a.a.eL(7, this.tir);
      paramInt = i;
      if (this.tis != null) {
        paramInt = i + a.a.a.a.eN(8, this.tis.aUd());
      }
      i = paramInt;
      if (this.tit != null) {
        i = paramInt + a.a.a.a.eN(9, this.tit.aUd());
      }
      i += a.a.a.a.eL(10, this.tiu);
      paramInt = i;
      if (this.thW != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.thW);
      }
      i = paramInt;
      if (this.thX != null) {
        i = paramInt + a.a.a.b.b.a.f(12, this.thX);
      }
      paramInt = i;
      if (this.tgM != null) {
        paramInt = i + a.a.a.a.eN(13, this.tgM.aUd());
      }
      GMTrace.o(3880234516480L, 28910);
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
      GMTrace.o(3880234516480L, 28910);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      gf localgf = (gf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3880234516480L, 28910);
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
          localgf.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 2: 
        localgf.tin = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 3: 
        localgf.tie = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 4: 
        localgf.tio = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 5: 
        localgf.tip = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 6: 
        localgf.tiq = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 7: 
        localgf.tir = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localgf.tis = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localgf.tit = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 10: 
        localgf.tiu = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 11: 
        localgf.thW = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3880234516480L, 28910);
        return 0;
      case 12: 
        localgf.thX = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3880234516480L, 28910);
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
        localgf.tgM = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3880234516480L, 28910);
      return 0;
    }
    GMTrace.o(3880234516480L, 28910);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */