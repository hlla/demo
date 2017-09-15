package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class rq
  extends com.tencent.mm.bd.a
{
  public String appId;
  public String desc;
  public String fCA;
  public String fOl;
  public ru fSY;
  public String title;
  public String txt;
  public LinkedList<String> txu;
  public int type;
  
  public rq()
  {
    GMTrace.i(3626563010560L, 27020);
    this.txu = new LinkedList();
    GMTrace.o(3626563010560L, 27020);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3626697228288L, 27021);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.fOl != null) {
        paramVarArgs.e(3, this.fOl);
      }
      if (this.txt != null) {
        paramVarArgs.e(4, this.txt);
      }
      if (this.appId != null) {
        paramVarArgs.e(5, this.appId);
      }
      if (this.fCA != null) {
        paramVarArgs.e(6, this.fCA);
      }
      paramVarArgs.d(7, 1, this.txu);
      paramVarArgs.eO(8, this.type);
      if (this.fSY != null)
      {
        paramVarArgs.eQ(9, this.fSY.aUd());
        this.fSY.a(paramVarArgs);
      }
      GMTrace.o(3626697228288L, 27021);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.title != null) {
        i = a.a.a.b.b.a.f(1, this.title) + 0;
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.fOl != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.fOl);
      }
      paramInt = i;
      if (this.txt != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.txt);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.appId);
      }
      paramInt = i;
      if (this.fCA != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.fCA);
      }
      i = paramInt + a.a.a.a.c(7, 1, this.txu) + a.a.a.a.eL(8, this.type);
      paramInt = i;
      if (this.fSY != null) {
        paramInt = i + a.a.a.a.eN(9, this.fSY.aUd());
      }
      GMTrace.o(3626697228288L, 27021);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.txu.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3626697228288L, 27021);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      rq localrq = (rq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3626697228288L, 27021);
        return -1;
      case 1: 
        localrq.title = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3626697228288L, 27021);
        return 0;
      case 2: 
        localrq.desc = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3626697228288L, 27021);
        return 0;
      case 3: 
        localrq.fOl = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3626697228288L, 27021);
        return 0;
      case 4: 
        localrq.txt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3626697228288L, 27021);
        return 0;
      case 5: 
        localrq.appId = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3626697228288L, 27021);
        return 0;
      case 6: 
        localrq.fCA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3626697228288L, 27021);
        return 0;
      case 7: 
        localrq.txu.add(((a.a.a.a.a)localObject1).xky.readString());
        GMTrace.o(3626697228288L, 27021);
        return 0;
      case 8: 
        localrq.type = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3626697228288L, 27021);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ru();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ru)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localrq.fSY = ((ru)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3626697228288L, 27021);
      return 0;
    }
    GMTrace.o(3626697228288L, 27021);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/rq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */