package com.tencent.mm.modelsimple;

import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.afb;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.hl;
import com.tencent.mm.protocal.c.mz;
import com.tencent.mm.protocal.c.tm;
import com.tencent.mm.protocal.c.tn;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends k
  implements j
{
  public final b gUq;
  private com.tencent.mm.y.e gUt;
  
  private l()
  {
    GMTrace.i(1340432449536L, 9987);
    this.gUq = kB("");
    tm localtm = (tm)this.gUq.hrS.hsa;
    ap.yY();
    String str1 = bf.mz((String)c.vr().get(46, null));
    localtm.tfH = new avt().bb(bf.PS(str1));
    ap.yY();
    String str2 = bf.mz((String)c.vr().get(72, null));
    localtm.tzQ = new avt().bb(bf.PS(str2));
    v.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + str1 + " newa2=" + str2);
    GMTrace.o(1340432449536L, 9987);
  }
  
  private l(byte paramByte)
  {
    GMTrace.i(16314164838400L, 121550);
    this.gUq = gv(1);
    tm localtm = (tm)this.gUq.hrS.hsa;
    ap.yY();
    String str1 = bf.mz((String)c.vr().get(46, null));
    localtm.tfH = new avt().bb(bf.PS(str1));
    ap.yY();
    String str2 = bf.mz((String)c.vr().get(72, null));
    localtm.tzQ = new avt().bb(bf.PS(str2));
    v.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + str1 + " newa2=" + str2);
    GMTrace.o(16314164838400L, 121550);
  }
  
  public l(int paramInt1, int paramInt2)
  {
    this();
    GMTrace.i(1341506191360L, 9995);
    tm localtm = (tm)this.gUq.hrS.hsa;
    localtm.tay = 3;
    localtm.tcg = 5;
    localtm.tzO = paramInt1;
    localtm.tzW = paramInt2;
    v.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(localtm.tfH.tXB), Integer.valueOf(paramInt2) });
    GMTrace.o(1341506191360L, 9995);
  }
  
  private l(String paramString)
  {
    GMTrace.i(1340566667264L, 9988);
    this.gUq = kB(paramString);
    paramString = (tm)this.gUq.hrS.hsa;
    ap.yY();
    String str1 = bf.mz((String)c.vr().get(46, null));
    paramString.tfH = new avt().bb(bf.PS(str1));
    ap.yY();
    String str2 = bf.mz((String)c.vr().get(72, null));
    paramString.tzQ = new avt().bb(bf.PS(str2));
    v.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + str1 + " newa2=" + str2);
    GMTrace.o(1340566667264L, 9988);
  }
  
  public l(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    this(paramString1);
    GMTrace.i(1341237755904L, 9993);
    tm localtm = (tm)this.gUq.hrS.hsa;
    localtm.tay = 2;
    localtm.tzM = new avu().OU(paramString1);
    localtm.tcg = paramInt1;
    localtm.jLx = null;
    localtm.tzR = 0;
    localtm.tzU = paramInt2;
    localtm.tzV = paramInt3;
    localtm.tzW = paramInt4;
    localtm.tzJ = new avu().OU(paramString2);
    v.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + null + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4);
    GMTrace.o(1341237755904L, 9993);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this(paramString1);
    GMTrace.i(1341103538176L, 9992);
    tm localtm = (tm)this.gUq.hrS.hsa;
    localtm.tay = 2;
    localtm.tzM = new avu().OU(paramString1);
    localtm.tcg = paramInt1;
    localtm.jLx = paramString2;
    localtm.tzR = 0;
    localtm.tzW = paramInt2;
    v.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = 0, requestId = " + paramInt2);
    GMTrace.o(1341103538176L, 9992);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    this(paramString1);
    GMTrace.i(1341371973632L, 9994);
    tm localtm = (tm)this.gUq.hrS.hsa;
    localtm.tay = 2;
    localtm.tzM = new avu().OU(paramString1);
    localtm.tcg = paramInt1;
    localtm.jLx = paramString2;
    localtm.tzR = paramInt2;
    localtm.tdn = paramInt3;
    localtm.tzT = paramString3;
    localtm.tzW = paramInt4;
    v.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Integer.valueOf(paramInt4) });
    GMTrace.o(1341371973632L, 9994);
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this((byte)0);
    GMTrace.i(1340969320448L, 9991);
    tm localtm = (tm)this.gUq.hrS.hsa;
    localtm.tay = 1;
    localtm.tzJ = new avu().OU(paramString1);
    localtm.tzK = new avu().OU(paramString2);
    localtm.tzL = new avu().OU(paramString3);
    localtm.tzW = paramInt;
    v.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    GMTrace.o(1340969320448L, 9991);
  }
  
  private static b gv(int paramInt)
  {
    GMTrace.i(16314299056128L, 121551);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new tm();
    ((b.a)localObject).hrW = new tn();
    switch (paramInt)
    {
    default: 
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/geta8key";
      ((b.a)localObject).hrU = 233;
      ((b.a)localObject).hrX = 155;
      ((b.a)localObject).hrY = 1000000155;
    }
    for (;;)
    {
      localObject = ((b.a)localObject).BE();
      GMTrace.o(16314299056128L, 121551);
      return (b)localObject;
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/geta8key";
      ((b.a)localObject).hrU = 233;
      ((b.a)localObject).hrX = 155;
      ((b.a)localObject).hrY = 1000000155;
      continue;
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mp-geta8key";
      ((b.a)localObject).hrU = 238;
      ((b.a)localObject).hrX = 345;
      ((b.a)localObject).hrY = 1000000345;
      continue;
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pay-geta8key";
      ((b.a)localObject).hrU = 835;
      ((b.a)localObject).hrX = 346;
      ((b.a)localObject).hrY = 1000000346;
    }
  }
  
  private static b kB(String paramString)
  {
    GMTrace.i(1340700884992L, 9989);
    int i = kC(paramString);
    v.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%d", new Object[] { paramString, Integer.valueOf(i) });
    paramString = gv(i);
    GMTrace.o(1340700884992L, 9989);
    return paramString;
  }
  
  private static int kC(String paramString)
  {
    GMTrace.i(1340835102720L, 9990);
    if (bf.mA(paramString))
    {
      v.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
      GMTrace.o(1340835102720L, 9990);
      return 0;
    }
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString == null)
      {
        GMTrace.o(1340835102720L, 9990);
        return 0;
      }
      String str = bf.mz(paramString.getHost()).toLowerCase();
      if (bf.mA(paramString.getFragment())) {}
      for (paramString = "";; paramString = "#" + paramString.getFragment())
      {
        v.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", new Object[] { str, paramString });
        if ((!str.equals("open.weixin.qq.com")) && (!str.equals("mp.weixin.qq.com")))
        {
          bool = str.equals("mp.weixinbridge.com");
          if (!bool) {
            break;
          }
        }
        GMTrace.o(1340835102720L, 9990);
        return 1;
      }
      if ((!str.equals("weixin.qq.com")) && (!str.equals("wx.qq.com")) && (!str.equals("weixin110.qq.com")) && (!str.equals("view.inews.qq.com")))
      {
        bool = str.contains("support.weixin.qq.com");
        if (!bool) {}
      }
      else
      {
        GMTrace.o(1340835102720L, 9990);
        return 0;
      }
      boolean bool = paramString.contains("wechat_pay");
      if (bool)
      {
        GMTrace.o(1340835102720L, 9990);
        return 2;
      }
      GMTrace.o(1340835102720L, 9990);
      return 0;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[] { paramString.getMessage() });
      GMTrace.o(1340835102720L, 9990);
    }
    return 0;
  }
  
  public final String IR()
  {
    GMTrace.i(1342043062272L, 9999);
    String str = ((tn)this.gUq.hrT.hsa).tzX;
    GMTrace.o(1342043062272L, 9999);
    return str;
  }
  
  public final String IS()
  {
    GMTrace.i(1342177280000L, 10000);
    Object localObject = ((tm)this.gUq.hrS.hsa).tzM;
    if (localObject != null)
    {
      localObject = ((avu)localObject).tXF;
      GMTrace.o(1342177280000L, 10000);
      return (String)localObject;
    }
    GMTrace.o(1342177280000L, 10000);
    return null;
  }
  
  public final int IT()
  {
    GMTrace.i(1342579933184L, 10003);
    int i = ((tn)this.gUq.hrT.hsa).taG;
    GMTrace.o(1342579933184L, 10003);
    return i;
  }
  
  public final byte[] IU()
  {
    GMTrace.i(1342714150912L, 10004);
    Object localObject = (tn)this.gUq.hrT.hsa;
    if (((tn)localObject).tAg == null)
    {
      GMTrace.o(1342714150912L, 10004);
      return null;
    }
    try
    {
      localObject = n.a(((tn)localObject).tAg);
      GMTrace.o(1342714150912L, 10004);
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      GMTrace.o(1342714150912L, 10004);
    }
    return null;
  }
  
  public final String IV()
  {
    GMTrace.i(1342848368640L, 10005);
    String str = ((tn)this.gUq.hrT.hsa).tAb;
    GMTrace.o(1342848368640L, 10005);
    return str;
  }
  
  public final ArrayList<byte[]> IW()
  {
    GMTrace.i(1342982586368L, 10006);
    Object localObject = (tn)this.gUq.hrT.hsa;
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((tn)localObject).tAd == null))
    {
      GMTrace.o(1342982586368L, 10006);
      return localArrayList;
    }
    localObject = ((tn)localObject).tAd.iterator();
    while (((Iterator)localObject).hasNext())
    {
      hl localhl = (hl)((Iterator)localObject).next();
      try
      {
        localArrayList.add(localhl.toByteArray());
      }
      catch (IOException localIOException)
      {
        v.e("MicroMsg.NetSceneGetA8Key", "exception:%s", new Object[] { bf.g(localIOException) });
      }
    }
    v.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    GMTrace.o(1342982586368L, 10006);
    return localArrayList;
  }
  
  public final long IX()
  {
    GMTrace.i(1343116804096L, 10007);
    tn localtn = (tn)this.gUq.hrT.hsa;
    if (localtn.tAf != null)
    {
      long l = localtn.tAf.trG;
      GMTrace.o(1343116804096L, 10007);
      return l;
    }
    GMTrace.o(1343116804096L, 10007);
    return -1L;
  }
  
  public final List<afb> IY()
  {
    GMTrace.i(17934843904000L, 133625);
    LinkedList localLinkedList = ((tn)this.gUq.hrT.hsa).tAi;
    GMTrace.o(17934843904000L, 133625);
    return localLinkedList;
  }
  
  public final int IZ()
  {
    GMTrace.i(1343251021824L, 10008);
    int i = ((tm)this.gUq.hrS.hsa).tzW;
    GMTrace.o(1343251021824L, 10008);
    return i;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1341774626816L, 9997);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(1341774626816L, 9997);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1341908844544L, 9998);
    v.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), IR(), ((tn)this.gUq.hrT.hsa).tzY });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1341908844544L, 9998);
  }
  
  public final String getTitle()
  {
    GMTrace.i(1342311497728L, 10001);
    String str = ((tn)this.gUq.hrT.hsa).fDt;
    GMTrace.o(1342311497728L, 10001);
    return str;
  }
  
  public final int getType()
  {
    GMTrace.i(1341640409088L, 9996);
    GMTrace.o(1341640409088L, 9996);
    return 233;
  }
  
  public final String pM()
  {
    GMTrace.i(1342445715456L, 10002);
    String str = ((tn)this.gUq.hrT.hsa).oog;
    GMTrace.o(1342445715456L, 10002);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */