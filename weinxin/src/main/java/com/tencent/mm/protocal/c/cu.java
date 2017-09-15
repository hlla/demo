package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class cu
  extends com.tencent.mm.bd.a
{
  public int jMq;
  public String mrA;
  public String mut;
  public String muu;
  public int ofk;
  public String oog;
  public String tdC;
  public int ten;
  public String teo;
  public avt tep;
  public int teq;
  public int ter;
  public String tes;
  public String tet;
  public String teu;
  
  public cu()
  {
    GMTrace.i(4009754624000L, 29875);
    GMTrace.o(4009754624000L, 29875);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4009888841728L, 29876);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.muu != null) {
        paramVarArgs.e(1, this.muu);
      }
      if (this.mrA != null) {
        paramVarArgs.e(2, this.mrA);
      }
      paramVarArgs.eO(3, this.ten);
      if (this.mut != null) {
        paramVarArgs.e(4, this.mut);
      }
      paramVarArgs.eO(5, this.jMq);
      if (this.oog != null) {
        paramVarArgs.e(6, this.oog);
      }
      paramVarArgs.eO(7, this.ofk);
      if (this.teo != null) {
        paramVarArgs.e(8, this.teo);
      }
      if (this.tep != null)
      {
        paramVarArgs.eQ(9, this.tep.aUd());
        this.tep.a(paramVarArgs);
      }
      paramVarArgs.eO(10, this.teq);
      paramVarArgs.eO(11, this.ter);
      if (this.tdC != null) {
        paramVarArgs.e(12, this.tdC);
      }
      if (this.tes != null) {
        paramVarArgs.e(13, this.tes);
      }
      if (this.tet != null) {
        paramVarArgs.e(14, this.tet);
      }
      if (this.teu != null) {
        paramVarArgs.e(15, this.teu);
      }
      GMTrace.o(4009888841728L, 29876);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.muu != null) {
        paramInt = a.a.a.b.b.a.f(1, this.muu) + 0;
      }
      i = paramInt;
      if (this.mrA != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.mrA);
      }
      i += a.a.a.a.eL(3, this.ten);
      paramInt = i;
      if (this.mut != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.mut);
      }
      i = paramInt + a.a.a.a.eL(5, this.jMq);
      paramInt = i;
      if (this.oog != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.oog);
      }
      i = paramInt + a.a.a.a.eL(7, this.ofk);
      paramInt = i;
      if (this.teo != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.teo);
      }
      i = paramInt;
      if (this.tep != null) {
        i = paramInt + a.a.a.a.eN(9, this.tep.aUd());
      }
      i = i + a.a.a.a.eL(10, this.teq) + a.a.a.a.eL(11, this.ter);
      paramInt = i;
      if (this.tdC != null) {
        paramInt = i + a.a.a.b.b.a.f(12, this.tdC);
      }
      i = paramInt;
      if (this.tes != null) {
        i = paramInt + a.a.a.b.b.a.f(13, this.tes);
      }
      paramInt = i;
      if (this.tet != null) {
        paramInt = i + a.a.a.b.b.a.f(14, this.tet);
      }
      i = paramInt;
      if (this.teu != null) {
        i = paramInt + a.a.a.b.b.a.f(15, this.teu);
      }
      GMTrace.o(4009888841728L, 29876);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4009888841728L, 29876);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      cu localcu = (cu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4009888841728L, 29876);
        return -1;
      case 1: 
        localcu.muu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 2: 
        localcu.mrA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 3: 
        localcu.ten = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 4: 
        localcu.mut = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 5: 
        localcu.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 6: 
        localcu.oog = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 7: 
        localcu.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 8: 
        localcu.teo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localcu.tep = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 10: 
        localcu.teq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 11: 
        localcu.ter = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 12: 
        localcu.tdC = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 13: 
        localcu.tes = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      case 14: 
        localcu.tet = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4009888841728L, 29876);
        return 0;
      }
      localcu.teu = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(4009888841728L, 29876);
      return 0;
    }
    GMTrace.o(4009888841728L, 29876);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */