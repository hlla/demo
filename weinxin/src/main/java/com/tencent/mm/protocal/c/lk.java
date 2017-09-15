package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class lk
  extends com.tencent.mm.bd.a
{
  public int jMu;
  public int lcP;
  public LinkedList<ahz> mtx;
  public int tgV;
  public String tjO;
  public String tjP;
  public String tjQ;
  public String tjR;
  public String tjS;
  public int tpX;
  
  public lk()
  {
    GMTrace.i(13098979164160L, 97595);
    this.mtx = new LinkedList();
    GMTrace.o(13098979164160L, 97595);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13099113381888L, 97596);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.lcP);
      if (this.tjQ != null) {
        paramVarArgs.e(7, this.tjQ);
      }
      paramVarArgs.eO(2, this.tgV);
      paramVarArgs.eO(3, this.tpX);
      paramVarArgs.d(4, 8, this.mtx);
      if (this.tjO != null) {
        paramVarArgs.e(5, this.tjO);
      }
      if (this.tjP != null) {
        paramVarArgs.e(6, this.tjP);
      }
      if (this.tjR != null) {
        paramVarArgs.e(8, this.tjR);
      }
      if (this.tjS != null) {
        paramVarArgs.e(9, this.tjS);
      }
      paramVarArgs.eO(10, this.jMu);
      GMTrace.o(13099113381888L, 97596);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.lcP) + 0;
      paramInt = i;
      if (this.tjQ != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.tjQ);
      }
      i = paramInt + a.a.a.a.eL(2, this.tgV) + a.a.a.a.eL(3, this.tpX) + a.a.a.a.c(4, 8, this.mtx);
      paramInt = i;
      if (this.tjO != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tjO);
      }
      i = paramInt;
      if (this.tjP != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.tjP);
      }
      paramInt = i;
      if (this.tjR != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tjR);
      }
      i = paramInt;
      if (this.tjS != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.tjS);
      }
      paramInt = a.a.a.a.eL(10, this.jMu);
      GMTrace.o(13099113381888L, 97596);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.mtx.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13099113381888L, 97596);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      lk locallk = (lk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13099113381888L, 97596);
        return -1;
      case 1: 
        locallk.lcP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13099113381888L, 97596);
        return 0;
      case 7: 
        locallk.tjQ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13099113381888L, 97596);
        return 0;
      case 2: 
        locallk.tgV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13099113381888L, 97596);
        return 0;
      case 3: 
        locallk.tpX = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13099113381888L, 97596);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahz();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahz)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          locallk.mtx.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13099113381888L, 97596);
        return 0;
      case 5: 
        locallk.tjO = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13099113381888L, 97596);
        return 0;
      case 6: 
        locallk.tjP = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13099113381888L, 97596);
        return 0;
      case 8: 
        locallk.tjR = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13099113381888L, 97596);
        return 0;
      case 9: 
        locallk.tjS = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13099113381888L, 97596);
        return 0;
      }
      locallk.jMu = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13099113381888L, 97596);
      return 0;
    }
    GMTrace.o(13099113381888L, 97596);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/lk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */