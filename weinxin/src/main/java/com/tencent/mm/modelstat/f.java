package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class f
{
  private final String fTg;
  private a hVK;
  
  public f(String paramString)
  {
    GMTrace.i(1378550284288L, 10271);
    this.hVK = null;
    this.fTg = paramString;
    GMTrace.o(1378550284288L, 10271);
  }
  
  public final a Ka()
  {
    GMTrace.i(1378684502016L, 10272);
    if (this.hVK != null)
    {
      localObject1 = this.hVK;
      GMTrace.o(1378684502016L, 10272);
      return (a)localObject1;
    }
    Object localObject2 = this.fTg + "mobileinfo.ini";
    Object localObject3 = new File((String)localObject2);
    if (!((File)localObject3).exists())
    {
      v.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", new Object[] { localObject2 });
      localObject1 = null;
    }
    Object localObject4;
    for (;;)
    {
      this.hVK = ((a)localObject1);
      if ((this.hVK == null) || (this.hVK.hVM)) {
        break;
      }
      v.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
      localObject1 = this.hVK;
      GMTrace.o(1378684502016L, 10272);
      return (a)localObject1;
      localObject4 = new a((String)localObject2);
      localObject1 = new a();
      ((a)localObject1).hVL = bf.f(((a)localObject4).Qp("ispCode"));
      ((a)localObject1).ispName = ((a)localObject4).getValue("ispName");
      ((a)localObject1).fEt = bf.f(((a)localObject4).Qp("subType"));
      ((a)localObject1).extraInfo = ((a)localObject4).getValue("extraInfo");
      long l2 = ((File)localObject3).lastModified();
      long l1 = l2;
      if (10011 == r.iiC)
      {
        l1 = l2;
        if (r.iiD > 0)
        {
          l1 = bf.NA() - r.iiD;
          v.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", new Object[] { Integer.valueOf(r.iiD), Long.valueOf(l1) });
          r.iiD = 0;
        }
      }
      if ((l1 > 0L) && (bf.aA(l1) > 259200000L))
      {
        v.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", new Object[] { Long.valueOf(bf.aA(l1)), localObject2 });
        ((a)localObject1).hVM = true;
      }
      v.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", new Object[] { Integer.valueOf(((a)localObject1).fEt), Integer.valueOf(((a)localObject1).hVL), ((a)localObject1).ispName, ((a)localObject1).extraInfo, Boolean.valueOf(((a)localObject1).hVM) });
    }
    localObject3 = aa.getContext();
    if (localObject3 == null)
    {
      v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      v.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
      localObject1 = this.hVK;
      GMTrace.o(1378684502016L, 10272);
      return (a)localObject1;
      localObject1 = (ConnectivityManager)((Context)localObject3).getSystemService("connectivity");
      if (localObject1 == null)
      {
        v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
        localObject1 = null;
      }
      else
      {
        localObject4 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject4 == null)
        {
          v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
          localObject1 = null;
        }
        else if (((NetworkInfo)localObject4).getType() == 1)
        {
          v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
          localObject1 = null;
        }
        else
        {
          localObject1 = new a();
          ((a)localObject1).fEt = ((NetworkInfo)localObject4).getSubtype();
          ((a)localObject1).hVL = al.getISPCode((Context)localObject3);
          ((a)localObject1).ispName = al.getISPName((Context)localObject3);
          ((a)localObject1).extraInfo = ((NetworkInfo)localObject4).getExtraInfo();
          v.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", new Object[] { Integer.valueOf(((a)localObject1).fEt), Integer.valueOf(((a)localObject1).hVL), ((a)localObject1).ispName, ((a)localObject1).extraInfo });
        }
      }
    }
    this.hVK = ((a)localObject1);
    Object localObject1 = this.hVK;
    if (localObject1 == null) {
      v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
    }
    for (;;)
    {
      localObject1 = this.hVK;
      GMTrace.o(1378684502016L, 10272);
      return (a)localObject1;
      if (bf.mA((String)localObject2))
      {
        v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
      }
      else
      {
        localObject2 = new a((String)localObject2);
        ((a)localObject2).cC("ispCode", ((a)localObject1).hVL);
        ((a)localObject2).eC("ispName", ((a)localObject1).ispName);
        ((a)localObject2).cC("subType", ((a)localObject1).fEt);
        ((a)localObject2).eC("extraInfo", ((a)localObject1).extraInfo);
      }
    }
  }
  
  public static final class a
  {
    public String extraInfo;
    public int fEt;
    public int hVL;
    boolean hVM;
    public String ispName;
    
    public a()
    {
      GMTrace.i(1403380563968L, 10456);
      this.hVL = 0;
      this.ispName = "";
      this.fEt = 0;
      this.extraInfo = "";
      this.hVM = false;
      GMTrace.o(1403380563968L, 10456);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelstat/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */