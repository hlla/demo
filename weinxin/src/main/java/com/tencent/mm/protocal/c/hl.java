package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class hl
  extends com.tencent.mm.bd.a
{
  public String tjU;
  public int tjV;
  public String tjW;
  public int tjX;
  public LinkedList<gl> tjY;
  
  public hl()
  {
    GMTrace.i(3772457680896L, 28107);
    this.tjY = new LinkedList();
    GMTrace.o(3772457680896L, 28107);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3772591898624L, 28108);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tjU != null) {
        paramVarArgs.e(1, this.tjU);
      }
      paramVarArgs.eO(2, this.tjV);
      if (this.tjW != null) {
        paramVarArgs.e(3, this.tjW);
      }
      paramVarArgs.eO(4, this.tjX);
      paramVarArgs.d(5, 8, this.tjY);
      GMTrace.o(3772591898624L, 28108);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tjU != null) {
        paramInt = a.a.a.b.b.a.f(1, this.tjU) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tjV);
      paramInt = i;
      if (this.tjW != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tjW);
      }
      i = a.a.a.a.eL(4, this.tjX);
      int j = a.a.a.a.c(5, 8, this.tjY);
      GMTrace.o(3772591898624L, 28108);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tjY.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3772591898624L, 28108);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      hl localhl = (hl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3772591898624L, 28108);
        return -1;
      case 1: 
        localhl.tjU = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3772591898624L, 28108);
        return 0;
      case 2: 
        localhl.tjV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3772591898624L, 28108);
        return 0;
      case 3: 
        localhl.tjW = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3772591898624L, 28108);
        return 0;
      case 4: 
        localhl.tjX = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3772591898624L, 28108);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new gl();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((gl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localhl.tjY.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3772591898624L, 28108);
      return 0;
    }
    GMTrace.o(3772591898624L, 28108);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/hl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */