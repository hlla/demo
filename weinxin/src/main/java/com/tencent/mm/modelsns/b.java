package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.bdb;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static boolean hQG;
  private static AtomicInteger hTj;
  public Object hSZ;
  public int hTa;
  public long hTb;
  public int hTc;
  public int hTd;
  public int hTe;
  public StringBuffer hTf;
  public StringBuffer hTg;
  public StringBuffer hTh;
  public StringBuffer hTi;
  public int opType;
  
  static
  {
    GMTrace.i(4462739456000L, 33250);
    hQG = false;
    hTj = new AtomicInteger(0);
    GMTrace.o(4462739456000L, 33250);
  }
  
  public b(int paramInt1, int paramInt2)
  {
    GMTrace.i(4460055101440L, 33230);
    this.hSZ = null;
    this.hTa = 1;
    this.opType = 0;
    this.hTf = new StringBuffer();
    this.hTg = new StringBuffer();
    this.hTh = new StringBuffer();
    this.hTi = new StringBuffer();
    this.opType = paramInt1;
    this.hTe = paramInt2;
    if (!JB())
    {
      GMTrace.o(4460055101440L, 33230);
      return;
    }
    this.hTb = System.currentTimeMillis();
    if (al.isWifi(aa.getContext())) {
      this.hTd = 4;
    }
    for (;;)
    {
      this.hTc = hTj.incrementAndGet();
      GMTrace.o(4460055101440L, 33230);
      return;
      if (al.is4G(aa.getContext())) {
        this.hTd = 3;
      } else if (al.is3G(aa.getContext())) {
        this.hTd = 2;
      } else if (al.is2G(aa.getContext())) {
        this.hTd = 1;
      } else {
        this.hTd = 0;
      }
    }
  }
  
  private static b C(byte[] paramArrayOfByte)
  {
    GMTrace.i(4462471020544L, 33248);
    if (paramArrayOfByte == null)
    {
      GMTrace.o(4462471020544L, 33248);
      return null;
    }
    bdb localbdb = new bdb();
    try
    {
      localbdb.aD(paramArrayOfByte);
      paramArrayOfByte = new b(localbdb.opType, localbdb.hTe);
      paramArrayOfByte.hTa = localbdb.hTa;
      paramArrayOfByte.hTb = localbdb.hTb;
      paramArrayOfByte.hTc = localbdb.hTc;
      paramArrayOfByte.hTd = localbdb.hTd;
      paramArrayOfByte.hTf = new StringBuffer(localbdb.ucJ);
      paramArrayOfByte.hTi = new StringBuffer(localbdb.ucK);
      paramArrayOfByte.hTg = new StringBuffer(localbdb.ucL);
      paramArrayOfByte.hTh = new StringBuffer(localbdb.ucM);
      GMTrace.o(4462471020544L, 33248);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      v.e("MicroMsg.StatisticsOplog", "putIntent " + paramArrayOfByte.getMessage());
      GMTrace.o(4462471020544L, 33248);
    }
    return null;
  }
  
  public static void JE()
  {
    GMTrace.i(4461531496448L, 33241);
    v.i("MicroMsg.StatisticsOplog", "wait op");
    GMTrace.o(4461531496448L, 33241);
  }
  
  public static b c(Intent paramIntent, String paramString)
  {
    GMTrace.i(4462336802816L, 33247);
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null)
    {
      GMTrace.o(4462336802816L, 33247);
      return null;
    }
    paramIntent = C(paramIntent);
    GMTrace.o(4462336802816L, 33247);
    return paramIntent;
  }
  
  public static b gy(int paramInt)
  {
    GMTrace.i(4459652448256L, 33227);
    b localb = new b(paramInt, 1);
    GMTrace.o(4459652448256L, 33227);
    return localb;
  }
  
  public static b gz(int paramInt)
  {
    GMTrace.i(4459786665984L, 33228);
    b localb = new b(paramInt, 4);
    GMTrace.o(4459786665984L, 33228);
    return localb;
  }
  
  public static b o(Intent paramIntent)
  {
    GMTrace.i(4462202585088L, 33246);
    paramIntent = c(paramIntent, "intent_key_StatisticsOplog");
    GMTrace.o(4462202585088L, 33246);
    return paramIntent;
  }
  
  public static b p(Bundle paramBundle)
  {
    GMTrace.i(4462068367360L, 33245);
    paramBundle = paramBundle.getByteArray("intent_key_StatisticsOplog");
    if (paramBundle == null)
    {
      GMTrace.o(4462068367360L, 33245);
      return null;
    }
    paramBundle = C(paramBundle);
    GMTrace.o(4462068367360L, 33245);
    return paramBundle;
  }
  
  public final byte[] Cf()
  {
    GMTrace.i(4461799931904L, 33243);
    Object localObject = new bdb();
    ((bdb)localObject).opType = this.opType;
    ((bdb)localObject).hTe = this.hTe;
    ((bdb)localObject).hTa = this.hTa;
    ((bdb)localObject).hTb = this.hTb;
    ((bdb)localObject).hTc = this.hTc;
    ((bdb)localObject).hTd = this.hTd;
    ((bdb)localObject).ucJ = this.hTf.toString();
    ((bdb)localObject).ucK = this.hTi.toString();
    ((bdb)localObject).ucL = this.hTg.toString();
    ((bdb)localObject).ucM = this.hTh.toString();
    try
    {
      localObject = ((bdb)localObject).toByteArray();
      GMTrace.o(4461799931904L, 33243);
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.StatisticsOplog", "putIntent " + localException.getMessage());
      GMTrace.o(4461799931904L, 33243);
    }
    return null;
  }
  
  public final boolean JB()
  {
    GMTrace.i(4459920883712L, 33229);
    int i = c.hTl;
    if (i == 0)
    {
      GMTrace.o(4459920883712L, 33229);
      return false;
    }
    if (i == 1)
    {
      if ((this.opType >= 501) && (this.opType <= 700))
      {
        GMTrace.o(4459920883712L, 33229);
        return true;
      }
      if ((this.opType >= 701) && (this.opType <= 1000))
      {
        GMTrace.o(4459920883712L, 33229);
        return true;
      }
    }
    if ((i == 2) && (this.opType >= 701) && (this.opType <= 1000))
    {
      GMTrace.o(4459920883712L, 33229);
      return true;
    }
    if ((i == 3) && (this.opType >= 501) && (this.opType <= 700))
    {
      GMTrace.o(4459920883712L, 33229);
      return true;
    }
    if (i == 4)
    {
      if ((this.opType >= 701) && (this.opType <= 1000))
      {
        GMTrace.o(4459920883712L, 33229);
        return true;
      }
      if ((this.opType >= 501) && (this.opType <= 700))
      {
        GMTrace.o(4459920883712L, 33229);
        return true;
      }
    }
    GMTrace.o(4459920883712L, 33229);
    return false;
  }
  
  public final b JC()
  {
    GMTrace.i(4460860407808L, 33236);
    this.hTg = new StringBuffer();
    GMTrace.o(4460860407808L, 33236);
    return this;
  }
  
  public final b JD()
  {
    GMTrace.i(4460994625536L, 33237);
    this.hTf = new StringBuffer();
    GMTrace.o(4460994625536L, 33237);
    return this;
  }
  
  public final boolean JF()
  {
    GMTrace.i(4461665714176L, 33242);
    if (!JB())
    {
      GMTrace.o(4461665714176L, 33242);
      return false;
    }
    e.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(4463947415552L, 33259);
        Object localObject = b.this;
        d locald = new d();
        locald.n("\n\nmodel", ((b)localObject).hTa + ",");
        locald.n("opType", ((b)localObject).opType + ",");
        locald.n("timeStamp", ((b)localObject).hTb + ",");
        locald.n("seq", ((b)localObject).hTc + ",");
        locald.n("netWork", ((b)localObject).hTd + ",");
        locald.n("page", ((b)localObject).hTe + ",");
        locald.n("StatusDesc1", ((b)localObject).hTf.toString() + ",");
        locald.n("DataFlowSourceInfo", ((b)localObject).hTg.toString() + ",");
        locald.n("DataFlowResultInfo", ((b)localObject).hTh.toString() + ",");
        locald.n("StatusDesc2", ((b)localObject).hTi.toString() + ", ");
        localObject = "bindkey: " + ((b)localObject).hSZ;
        locald.hTn.append((String)localObject);
        v.d("MicroMsg.StatisticsOplog", "report logbuffer: " + locald.JH());
        com.tencent.mm.plugin.report.c.oRz.i(12645, new Object[] { locald });
        GMTrace.o(4463947415552L, 33259);
      }
    }, "StatisticsOplog");
    GMTrace.o(4461665714176L, 33242);
    return true;
  }
  
  public final void b(Intent paramIntent, String paramString)
  {
    GMTrace.i(4461934149632L, 33244);
    byte[] arrayOfByte = Cf();
    if (arrayOfByte == null)
    {
      GMTrace.o(4461934149632L, 33244);
      return;
    }
    paramIntent.putExtra(paramString, arrayOfByte);
    GMTrace.o(4461934149632L, 33244);
  }
  
  public final b bp(boolean paramBoolean)
  {
    GMTrace.i(4461263060992L, 33239);
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = kH((String)localObject);
      GMTrace.o(4461263060992L, 33239);
      return (b)localObject;
    }
  }
  
  public final boolean gA(int paramInt)
  {
    GMTrace.i(4460189319168L, 33231);
    this.hSZ = Integer.valueOf(paramInt);
    GMTrace.o(4460189319168L, 33231);
    return true;
  }
  
  public final b gB(int paramInt)
  {
    GMTrace.i(4460591972352L, 33234);
    b localb = kH(String.valueOf(paramInt));
    GMTrace.o(4460591972352L, 33234);
    return localb;
  }
  
  public final b gC(int paramInt)
  {
    GMTrace.i(4461397278720L, 33240);
    if (!JB())
    {
      GMTrace.o(4461397278720L, 33240);
      return this;
    }
    if (this.hTg.length() == 0) {
      this.hTg.append(paramInt);
    }
    for (;;)
    {
      GMTrace.o(4461397278720L, 33240);
      return this;
      this.hTg.append("||" + paramInt);
    }
  }
  
  public final b kH(String paramString)
  {
    GMTrace.i(4460457754624L, 33233);
    if (!JB())
    {
      GMTrace.o(4460457754624L, 33233);
      return this;
    }
    if (this.hTf.length() == 0) {
      if (bf.mA(paramString)) {
        this.hTf.append(" ");
      }
    }
    for (;;)
    {
      GMTrace.o(4460457754624L, 33233);
      return this;
      this.hTf.append(paramString);
      continue;
      this.hTf.append("||" + paramString);
    }
  }
  
  public final b kI(String paramString)
  {
    GMTrace.i(4460726190080L, 33235);
    if (!JB())
    {
      GMTrace.o(4460726190080L, 33235);
      return this;
    }
    if (this.hTg.length() == 0) {
      this.hTg.append(paramString);
    }
    for (;;)
    {
      GMTrace.o(4460726190080L, 33235);
      return this;
      this.hTg.append("||" + paramString);
    }
  }
  
  public final b kJ(String paramString)
  {
    GMTrace.i(4461128843264L, 33238);
    if (!JB())
    {
      GMTrace.o(4461128843264L, 33238);
      return this;
    }
    if (this.hTh.length() == 0) {
      this.hTh.append(paramString);
    }
    for (;;)
    {
      GMTrace.o(4461128843264L, 33238);
      return this;
      this.hTh.append("||" + paramString);
    }
  }
  
  public final void update()
  {
    GMTrace.i(4460323536896L, 33232);
    if (!JB())
    {
      GMTrace.o(4460323536896L, 33232);
      return;
    }
    this.hTb = System.currentTimeMillis();
    this.hTc = hTj.incrementAndGet();
    GMTrace.o(4460323536896L, 33232);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsns/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */