package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.d.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.bjb;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.g;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class n
  extends k
  implements j
{
  public int fJB;
  public final b gUq;
  private com.tencent.mm.y.e gUt;
  public String hDS;
  public List<String> sAP;
  public String sAQ;
  private List<String> sAR;
  
  private n(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    GMTrace.i(764369960960L, 5695);
    this.sAP = null;
    this.fJB = 0;
    this.sAR = null;
    Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
    this.sAP = new LinkedList();
    this.sAP.add(paramString1);
    this.fJB = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new bja();
    ((b.a)localObject).hrW = new bjb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyuser";
    ((b.a)localObject).hrU = 137;
    ((b.a)localObject).hrX = 44;
    ((b.a)localObject).hrY = 1000000044;
    this.gUq = ((b.a)localObject).BE();
    localObject = (bja)this.gUq.hrS.hsa;
    ((bja)localObject).tgi = 3;
    ((bja)localObject).tFy = "";
    LinkedList localLinkedList = new LinkedList();
    biz localbiz = new biz();
    localbiz.oSl = paramString1;
    localbiz.ugV = paramString2;
    localbiz.tAe = a.Pk().xB().QE(paramString1);
    localbiz.tXu = null;
    localLinkedList.add(localbiz);
    ((bja)localObject).uhc = localLinkedList;
    ((bja)localObject).uhb = localLinkedList.size();
    paramString1 = new LinkedList();
    paramString1.add(Integer.valueOf(paramInt2));
    ((bja)localObject).uhe = paramString1;
    ((bja)localObject).uhd = paramString1.size();
    ((bja)localObject).tLq = new avt().bb(d.nYa.aPe());
    v.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s", new Object[] { Integer.valueOf(((bja)localObject).uhc.size()), Integer.valueOf(((bja)localObject).uhe.size()), paramString2, localbiz.tAe });
    GMTrace.o(764369960960L, 5695);
  }
  
  public n(int paramInt, List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2)
  {
    this(paramInt, paramList, paramList1, null, paramString1, paramString2, null, null, "");
    GMTrace.i(764906831872L, 5699);
    GMTrace.o(764906831872L, 5699);
  }
  
  public n(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4)
  {
    GMTrace.i(764504178688L, 5696);
    this.sAP = null;
    this.fJB = 0;
    this.sAR = null;
    boolean bool;
    Object localObject;
    if (paramInt != 3)
    {
      bool = true;
      Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", bool);
      this.fJB = paramInt;
      this.sAP = paramList1;
      if (paramList2 != null)
      {
        localObject = paramList2;
        if (paramList2.size() != 0) {}
      }
      else
      {
        localObject = new LinkedList();
      }
      paramList2 = new b.a();
      paramList2.hrV = new bja();
      paramList2.hrW = new bjb();
      paramList2.uri = "/cgi-bin/micromsg-bin/verifyuser";
      paramList2.hrU = 137;
      paramList2.hrX = 44;
      paramList2.hrY = 1000000044;
      this.gUq = paramList2.BE();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (paramInt != 1) {
          break label313;
        }
        bool = true;
        label175:
        Assert.assertTrue("only when opcode == 1 , antispamticket not null", bool);
        if (((List)localObject).size() == paramList1.size()) {
          break label319;
        }
        v.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(paramList1.size()) });
      }
    }
    for (;;)
    {
      if (paramInt != 2) {
        break label377;
      }
      Assert.assertTrue("only when opcode == 2, antispamticket should null", ((List)localObject).isEmpty());
      int i = 0;
      while (i < paramList1.size())
      {
        ((List)localObject).add(bf.ap(a.Pk().xB().QE((String)paramList1.get(i)), ""));
        i += 1;
      }
      bool = false;
      break;
      label313:
      bool = false;
      break label175;
      label319:
      i = 0;
      while (i < ((List)localObject).size())
      {
        a.Pk().xB().o((String)paramList1.get(i), 2147483633, (String)((List)localObject).get(i));
        i += 1;
      }
    }
    label377:
    bja localbja = (bja)this.gUq.hrS.hsa;
    localbja.tgi = paramInt;
    localbja.tFy = paramString1;
    this.sAQ = paramString1;
    paramString1 = new LinkedList();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      biz localbiz = new biz();
      localbiz.oSl = ((String)paramList1.get(paramInt));
      if (paramString2 == null) {}
      for (paramList2 = "";; paramList2 = paramString2)
      {
        localbiz.ugV = paramList2;
        paramList2 = a.Pk().xB();
        String str = localbiz.oSl;
        ((Integer)paramList.get(paramInt)).intValue();
        localbiz.tAe = bf.ap(paramList2.QE(str), "");
        if ((TextUtils.isEmpty(localbiz.tAe)) && (localObject != null) && (((List)localObject).size() > paramInt)) {
          localbiz.tAe = ((String)((List)localObject).get(paramInt));
        }
        localbiz.tXu = paramString3;
        if ((paramMap != null) && (paramMap.containsKey(localbiz.oSl))) {
          localbiz.ugW = ((Integer)paramMap.get(localbiz.oSl)).intValue();
        }
        localbiz.uha = paramString4;
        v.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s", new Object[] { Integer.valueOf(this.fJB), Integer.valueOf(paramInt), localbiz.oSl, localbiz.tAe, paramString3, paramString4 });
        paramString1.add(localbiz);
        paramInt += 1;
        break;
      }
    }
    localbja.uhc = paramString1;
    localbja.uhb = paramString1.size();
    paramList1 = new LinkedList();
    paramList1.addAll(paramList);
    localbja.uhe = paramList1;
    localbja.uhd = paramList1.size();
    localbja.tLq = new avt().bb(d.nYa.aPe());
    v.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[] { Integer.valueOf(this.fJB), Integer.valueOf(localbja.uhc.size()), Integer.valueOf(localbja.uhe.size()), bf.c((List)localObject, ","), paramString3, bf.bJP() });
    GMTrace.o(764504178688L, 5696);
  }
  
  public n(String paramString1, String paramString2, int paramInt)
  {
    this(3, paramString1, paramString2, paramInt);
    GMTrace.i(764772614144L, 5698);
    GMTrace.o(764772614144L, 5698);
  }
  
  public n(List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3)
  {
    this(2, paramList, paramList1, null, paramString1, paramString2, paramMap, paramString3, "");
    GMTrace.i(764638396416L, 5697);
    GMTrace.o(764638396416L, 5697);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(765309485056L, 5702);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(765309485056L, 5702);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(765577920512L, 5704);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      v.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(765577920512L, 5704);
  }
  
  public final String bCA()
  {
    GMTrace.i(765175267328L, 5701);
    if ((this.gUq != null) && (this.gUq.hrT != null))
    {
      String str = ((bjb)this.gUq.hrT.hsa).jLx;
      GMTrace.o(765175267328L, 5701);
      return str;
    }
    GMTrace.o(765175267328L, 5701);
    return "";
  }
  
  public final void ei(String paramString1, String paramString2)
  {
    GMTrace.i(765041049600L, 5700);
    Iterator localIterator = ((bja)this.gUq.hrS.hsa).uhc.iterator();
    while (localIterator.hasNext())
    {
      biz localbiz = (biz)localIterator.next();
      localbiz.ugX = paramString1;
      localbiz.ugY = paramString2;
    }
    GMTrace.o(765041049600L, 5700);
  }
  
  public final int getType()
  {
    GMTrace.i(765443702784L, 5703);
    GMTrace.o(765443702784L, 5703);
    return 30;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */