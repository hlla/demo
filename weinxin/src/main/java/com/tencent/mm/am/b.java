package com.tencent.mm.am;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.e.a.jb.b;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.sdk.b.a;

public final class b
{
  public static final void HI()
  {
    GMTrace.i(4411602501632L, 32869);
    jb localjb = new jb();
    localjb.fON.action = -1;
    a.uql.m(localjb);
    GMTrace.o(4411602501632L, 32869);
  }
  
  public static final void HJ()
  {
    GMTrace.i(18644184596480L, 138910);
    jb localjb = new jb();
    localjb.fON.action = 11;
    a.uql.m(localjb);
    GMTrace.o(18644184596480L, 138910);
  }
  
  public static boolean HK()
  {
    GMTrace.i(4411870937088L, 32871);
    jb localjb = new jb();
    localjb.fON.action = -3;
    a.uql.m(localjb);
    boolean bool = localjb.fOO.fDL;
    GMTrace.o(4411870937088L, 32871);
    return bool;
  }
  
  public static boolean HL()
  {
    GMTrace.i(4412005154816L, 32872);
    jb localjb = new jb();
    localjb.fON.action = 9;
    a.uql.m(localjb);
    boolean bool = localjb.fOO.fDL;
    GMTrace.o(4412005154816L, 32872);
    return bool;
  }
  
  public static anc HM()
  {
    GMTrace.i(4412139372544L, 32873);
    Object localObject = new jb();
    ((jb)localObject).fON.action = -2;
    a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((jb)localObject).fOO.fOP;
    GMTrace.o(4412139372544L, 32873);
    return (anc)localObject;
  }
  
  public static d HN()
  {
    GMTrace.i(4413213114368L, 32881);
    Object localObject = new jb();
    ((jb)localObject).fON.action = 8;
    a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((jb)localObject).fOO.fOS;
    GMTrace.o(4413213114368L, 32881);
    return (d)localObject;
  }
  
  public static final void a(anc paramanc)
  {
    GMTrace.i(4411736719360L, 32870);
    jb localjb = new jb();
    localjb.fON.action = 6;
    localjb.fON.fOP = paramanc;
    a.uql.m(localjb);
    GMTrace.o(4411736719360L, 32870);
  }
  
  public static void b(anc paramanc)
  {
    GMTrace.i(4412273590272L, 32874);
    jb localjb = new jb();
    localjb.fON.action = 0;
    localjb.fON.fOP = paramanc;
    a.uql.m(localjb);
    GMTrace.o(4412273590272L, 32874);
  }
  
  public static void c(anc paramanc)
  {
    GMTrace.i(4412407808000L, 32875);
    jb localjb = new jb();
    localjb.fON.action = 3;
    localjb.fON.fOP = paramanc;
    a.uql.m(localjb);
    GMTrace.o(4412407808000L, 32875);
  }
  
  public static boolean d(anc paramanc)
  {
    GMTrace.i(4412944678912L, 32879);
    if (paramanc == null)
    {
      GMTrace.o(4412944678912L, 32879);
      return false;
    }
    switch (paramanc.tPV)
    {
    default: 
      GMTrace.o(4412944678912L, 32879);
      return false;
    }
    GMTrace.o(4412944678912L, 32879);
    return true;
  }
  
  public static boolean gi(int paramInt)
  {
    GMTrace.i(4413078896640L, 32880);
    jb localjb = new jb();
    localjb.fON.action = 7;
    localjb.fON.position = paramInt;
    a.uql.m(localjb);
    boolean bool = localjb.fOO.fDL;
    GMTrace.o(4413078896640L, 32880);
    return bool;
  }
  
  public static final void qP()
  {
    GMTrace.i(4411334066176L, 32867);
    jb localjb = new jb();
    localjb.fON.action = 1;
    a.uql.m(localjb);
    GMTrace.o(4411334066176L, 32867);
  }
  
  public static final void qQ()
  {
    GMTrace.i(4411468283904L, 32868);
    jb localjb = new jb();
    localjb.fON.action = 2;
    a.uql.m(localjb);
    GMTrace.o(4411468283904L, 32868);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/am/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */