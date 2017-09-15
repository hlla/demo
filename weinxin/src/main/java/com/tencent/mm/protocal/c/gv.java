package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class gv
  extends ave
{
  public String fDj;
  public int offset;
  public String tjf;
  
  public gv()
  {
    GMTrace.i(3717428412416L, 27697);
    GMTrace.o(3717428412416L, 27697);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3717562630144L, 27698);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tjf == null) {
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tjf != null) {
        paramVarArgs.e(2, this.tjf);
      }
      if (this.fDj != null) {
        paramVarArgs.e(3, this.fDj);
      }
      paramVarArgs.eO(4, this.offset);
      GMTrace.o(3717562630144L, 27698);
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
      if (this.tjf != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tjf);
      }
      i = paramInt;
      if (this.fDj != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.fDj);
      }
      paramInt = a.a.a.a.eL(4, this.offset);
      GMTrace.o(3717562630144L, 27698);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tjf == null) {
        throw new b("Not all required fields were included: brand_user_name");
      }
      GMTrace.o(3717562630144L, 27698);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      gv localgv = (gv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3717562630144L, 27698);
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
          localgv.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3717562630144L, 27698);
        return 0;
      case 2: 
        localgv.tjf = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3717562630144L, 27698);
        return 0;
      case 3: 
        localgv.fDj = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3717562630144L, 27698);
        return 0;
      }
      localgv.offset = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3717562630144L, 27698);
      return 0;
    }
    GMTrace.o(3717562630144L, 27698);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */