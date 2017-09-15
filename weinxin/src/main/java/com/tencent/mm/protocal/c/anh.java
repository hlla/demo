package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class anh
  extends com.tencent.mm.bd.a
{
  public int mrC;
  public String mut;
  public String muu;
  public long tdE;
  public int tdw;
  
  public anh()
  {
    GMTrace.i(13336276107264L, 99363);
    GMTrace.o(13336276107264L, 99363);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13336410324992L, 99364);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.muu != null) {
        paramVarArgs.e(1, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.e(2, this.mut);
      }
      paramVarArgs.eO(3, this.tdw);
      paramVarArgs.eO(4, this.mrC);
      paramVarArgs.O(5, this.tdE);
      GMTrace.o(13336410324992L, 99364);
      return 0;
    }
    if (paramInt == 1) {
      if (this.muu == null) {
        break label443;
      }
    }
    label443:
    for (paramInt = a.a.a.b.b.a.f(1, this.muu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mut != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.mut);
      }
      paramInt = a.a.a.a.eL(3, this.tdw);
      int j = a.a.a.a.eL(4, this.mrC);
      int k = a.a.a.a.N(5, this.tdE);
      GMTrace.o(13336410324992L, 99364);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13336410324992L, 99364);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        anh localanh = (anh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13336410324992L, 99364);
          return -1;
        case 1: 
          localanh.muu = locala.xky.readString();
          GMTrace.o(13336410324992L, 99364);
          return 0;
        case 2: 
          localanh.mut = locala.xky.readString();
          GMTrace.o(13336410324992L, 99364);
          return 0;
        case 3: 
          localanh.tdw = locala.xky.mL();
          GMTrace.o(13336410324992L, 99364);
          return 0;
        case 4: 
          localanh.mrC = locala.xky.mL();
          GMTrace.o(13336410324992L, 99364);
          return 0;
        }
        localanh.tdE = locala.xky.mM();
        GMTrace.o(13336410324992L, 99364);
        return 0;
      }
      GMTrace.o(13336410324992L, 99364);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/anh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */