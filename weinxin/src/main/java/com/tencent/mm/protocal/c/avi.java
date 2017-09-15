package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class avi
  extends com.tencent.mm.bd.a
{
  public String mrm;
  public int tXm;
  public int tXn;
  public LinkedList<bab> tXo;
  public String tXp;
  public int trj;
  public String tsQ;
  public com.tencent.mm.bd.b tsy;
  
  public avi()
  {
    GMTrace.i(4008949317632L, 29869);
    this.tXo = new LinkedList();
    GMTrace.o(4008949317632L, 29869);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4009083535360L, 29870);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tsQ == null) {
        throw new a.a.a.b("Not all required fields were included: MD5");
      }
      if (this.mrm == null) {
        throw new a.a.a.b("Not all required fields were included: Url");
      }
      if (this.tXp == null) {
        throw new a.a.a.b("Not all required fields were included: OriginalMD5");
      }
      if (this.tsQ != null) {
        paramVarArgs.e(1, this.tsQ);
      }
      paramVarArgs.eO(2, this.tXm);
      if (this.mrm != null) {
        paramVarArgs.e(3, this.mrm);
      }
      paramVarArgs.eO(4, this.tXn);
      paramVarArgs.d(5, 8, this.tXo);
      if (this.tsy != null) {
        paramVarArgs.b(6, this.tsy);
      }
      if (this.tXp != null) {
        paramVarArgs.e(7, this.tXp);
      }
      paramVarArgs.eO(8, this.trj);
      GMTrace.o(4009083535360L, 29870);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tsQ != null) {
        paramInt = a.a.a.b.b.a.f(1, this.tsQ) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tXm);
      paramInt = i;
      if (this.mrm != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.mrm);
      }
      i = paramInt + a.a.a.a.eL(4, this.tXn) + a.a.a.a.c(5, 8, this.tXo);
      paramInt = i;
      if (this.tsy != null) {
        paramInt = i + a.a.a.a.a(6, this.tsy);
      }
      i = paramInt;
      if (this.tXp != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.tXp);
      }
      paramInt = a.a.a.a.eL(8, this.trj);
      GMTrace.o(4009083535360L, 29870);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tXo.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tsQ == null) {
        throw new a.a.a.b("Not all required fields were included: MD5");
      }
      if (this.mrm == null) {
        throw new a.a.a.b("Not all required fields were included: Url");
      }
      if (this.tXp == null) {
        throw new a.a.a.b("Not all required fields were included: OriginalMD5");
      }
      GMTrace.o(4009083535360L, 29870);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      avi localavi = (avi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4009083535360L, 29870);
        return -1;
      case 1: 
        localavi.tsQ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009083535360L, 29870);
        return 0;
      case 2: 
        localavi.tXm = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4009083535360L, 29870);
        return 0;
      case 3: 
        localavi.mrm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009083535360L, 29870);
        return 0;
      case 4: 
        localavi.tXn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4009083535360L, 29870);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bab();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bab)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localavi.tXo.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(4009083535360L, 29870);
        return 0;
      case 6: 
        localavi.tsy = ((a.a.a.a.a)localObject1).chR();
        GMTrace.o(4009083535360L, 29870);
        return 0;
      case 7: 
        localavi.tXp = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009083535360L, 29870);
        return 0;
      }
      localavi.trj = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(4009083535360L, 29870);
      return 0;
    }
    GMTrace.o(4009083535360L, 29870);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/avi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */