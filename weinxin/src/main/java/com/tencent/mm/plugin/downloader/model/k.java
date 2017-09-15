package com.tencent.mm.plugin.downloader.model;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.fu;
import com.tencent.mm.e.a.fu.b;
import com.tencent.mm.e.a.fv;
import com.tencent.mm.e.a.fw;
import com.tencent.mm.e.a.fw.b;
import com.tencent.mm.e.a.fx;
import com.tencent.mm.e.a.fx.b;
import com.tencent.mm.e.a.fy;
import com.tencent.mm.e.a.fy.b;
import com.tencent.mm.e.a.fz;
import com.tencent.mm.e.a.fz.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;

final class k
  extends i
{
  private c hoB;
  
  public k(b paramb)
  {
    super(paramb);
    GMTrace.i(18605529890816L, 138622);
    this.hoB = new c() {};
    a.uql.b(this.hoB);
    GMTrace.o(18605529890816L, 138622);
  }
  
  public final long a(f paramf)
  {
    GMTrace.i(18605664108544L, 138623);
    fu localfu = new fu();
    localfu.fKH.fKJ = paramf.iyE;
    localfu.fKH.fKK = paramf.kFd;
    localfu.fKH.fileSize = paramf.kFe;
    localfu.fKH.fyw = paramf.mFileName;
    localfu.fKH.fKL = paramf.kFf;
    localfu.fKH.fileType = paramf.kFg;
    localfu.fKH.appId = paramf.ivn;
    localfu.fKH.fKM = paramf.kFh;
    localfu.fKH.fKN = paramf.kFi;
    localfu.fKH.fKO = paramf.kFj;
    localfu.fKH.packageName = paramf.fwP;
    localfu.fKH.fKP = paramf.kFk;
    localfu.fKH.scene = paramf.hOQ;
    a.uql.m(localfu);
    long l = localfu.fKI.fCn;
    GMTrace.o(18605664108544L, 138623);
    return l;
  }
  
  public final int aT(long paramLong)
  {
    GMTrace.i(18605798326272L, 138624);
    fy localfy = new fy();
    localfy.fKZ.fCn = paramLong;
    a.uql.m(localfy);
    int i = localfy.fLa.count;
    GMTrace.o(18605798326272L, 138624);
    return i;
  }
  
  public final FileDownloadTaskInfo aU(long paramLong)
  {
    GMTrace.i(18605932544000L, 138625);
    fx localfx = new fx();
    localfx.fKV.fCn = paramLong;
    a.uql.m(localfx);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = paramLong;
    localFileDownloadTaskInfo.url = localfx.fKW.url;
    localFileDownloadTaskInfo.status = localfx.fKW.status;
    localFileDownloadTaskInfo.path = localfx.fKW.path;
    localFileDownloadTaskInfo.fFN = localfx.fKW.fFN;
    localFileDownloadTaskInfo.fKX = localfx.fKW.fKX;
    localFileDownloadTaskInfo.fKY = localfx.fKW.fKY;
    GMTrace.o(18605932544000L, 138625);
    return localFileDownloadTaskInfo;
  }
  
  public final boolean aV(long paramLong)
  {
    GMTrace.i(18606066761728L, 138626);
    fw localfw = new fw();
    localfw.fKT.fCn = paramLong;
    a.uql.m(localfw);
    boolean bool = localfw.fKU.fDL;
    GMTrace.o(18606066761728L, 138626);
    return bool;
  }
  
  public final boolean aW(long paramLong)
  {
    GMTrace.i(18606200979456L, 138627);
    fz localfz = new fz();
    localfz.fLb.fCn = paramLong;
    a.uql.m(localfz);
    boolean bool = localfz.fLc.fDL;
    GMTrace.o(18606200979456L, 138627);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/model/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */