package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aty
  extends ave
{
  public String oSl;
  public int tKv;
  public String tjO;
  public String tjP;
  public String tjQ;
  public String tjR;
  public String tjS;
  
  public aty()
  {
    GMTrace.i(3617704640512L, 26954);
    GMTrace.o(3617704640512L, 26954);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3617838858240L, 26955);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tjO != null) {
        paramVarArgs.e(2, this.tjO);
      }
      if (this.tjP != null) {
        paramVarArgs.e(3, this.tjP);
      }
      if (this.tjQ != null) {
        paramVarArgs.e(4, this.tjQ);
      }
      if (this.tjR != null) {
        paramVarArgs.e(5, this.tjR);
      }
      if (this.tjS != null) {
        paramVarArgs.e(6, this.tjS);
      }
      paramVarArgs.eO(7, this.tKv);
      if (this.oSl != null) {
        paramVarArgs.e(8, this.oSl);
      }
      GMTrace.o(3617838858240L, 26955);
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
      if (this.tjO != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tjO);
      }
      i = paramInt;
      if (this.tjP != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tjP);
      }
      paramInt = i;
      if (this.tjQ != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tjQ);
      }
      i = paramInt;
      if (this.tjR != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tjR);
      }
      paramInt = i;
      if (this.tjS != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tjS);
      }
      i = paramInt + a.a.a.a.eL(7, this.tKv);
      paramInt = i;
      if (this.oSl != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.oSl);
      }
      GMTrace.o(3617838858240L, 26955);
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
      GMTrace.o(3617838858240L, 26955);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aty localaty = (aty)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3617838858240L, 26955);
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
          localaty.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3617838858240L, 26955);
        return 0;
      case 2: 
        localaty.tjO = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3617838858240L, 26955);
        return 0;
      case 3: 
        localaty.tjP = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3617838858240L, 26955);
        return 0;
      case 4: 
        localaty.tjQ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3617838858240L, 26955);
        return 0;
      case 5: 
        localaty.tjR = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3617838858240L, 26955);
        return 0;
      case 6: 
        localaty.tjS = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3617838858240L, 26955);
        return 0;
      case 7: 
        localaty.tKv = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3617838858240L, 26955);
        return 0;
      }
      localaty.oSl = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3617838858240L, 26955);
      return 0;
    }
    GMTrace.o(3617838858240L, 26955);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */