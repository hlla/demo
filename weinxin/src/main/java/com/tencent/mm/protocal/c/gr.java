package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class gr
  extends com.tencent.mm.bd.a
{
  public String tiZ;
  public String tjf;
  
  public gr()
  {
    GMTrace.i(3714475622400L, 27675);
    GMTrace.o(3714475622400L, 27675);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3714609840128L, 27676);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tjf != null) {
        paramVarArgs.e(2, this.tjf);
      }
      if (this.tiZ != null) {
        paramVarArgs.e(3, this.tiZ);
      }
      GMTrace.o(3714609840128L, 27676);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tjf == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = a.a.a.b.b.a.f(2, this.tjf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tiZ != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tiZ);
      }
      GMTrace.o(3714609840128L, 27676);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3714609840128L, 27676);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        gr localgr = (gr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3714609840128L, 27676);
          return -1;
        case 2: 
          localgr.tjf = locala.xky.readString();
          GMTrace.o(3714609840128L, 27676);
          return 0;
        }
        localgr.tiZ = locala.xky.readString();
        GMTrace.o(3714609840128L, 27676);
        return 0;
      }
      GMTrace.o(3714609840128L, 27676);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */