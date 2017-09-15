package com.tencent.mars.smc;

import com.tencent.mm.protocal.a.a.a;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.d;
import com.tencent.mm.protocal.a.a.e;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.a.a.l;
import com.tencent.mm.protocal.a.a.m;
import com.tencent.mm.protocal.a.a.n;
import com.tencent.mm.protocal.a.a.o;
import com.tencent.mm.protocal.c.afr;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.protocal.c.anp;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.lk;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.protocal.c.lm;
import com.tencent.mm.protocal.c.ww;
import com.tencent.mm.protocal.c.wx;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil
{
  private static o fillStrategyTable(LinkedList<bdo> paramLinkedList)
  {
    o localo = new o();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      bdo localbdo = (bdo)paramLinkedList.get(i);
      m localm = new m();
      localm.sZm = localbdo.udm;
      localm.sZn = localbdo.udn;
      int j = 0;
      while (j < localbdo.udo.size())
      {
        anp localanp = (anp)localbdo.udo.get(j);
        n localn = new n();
        localn.sYG = localanp.tKv;
        localn.sZp = localanp.tRc;
        localn.sZq = localanp.tRa;
        localn.sZr = localanp.tRb;
        localn.sZs = localanp.tRd;
        localn.sZt = localanp.tRe;
        localn.sZu = localanp.tRf;
        localm.sZo.add(localn);
        j += 1;
      }
      localo.sZv.add(localm);
      i += 1;
    }
    return localo;
  }
  
  public static ww toMMGetStrategyReq()
  {
    ww localww = new ww();
    ArrayList localArrayList = SmcLogic.getStrategyVersions();
    if (localArrayList.size() != 6) {
      return null;
    }
    localww.tpY = ((Integer)localArrayList.get(0)).intValue();
    localww.tpZ = ((Integer)localArrayList.get(1)).intValue();
    localww.tqa = ((Integer)localArrayList.get(2)).intValue();
    localww.tBV = ((Integer)localArrayList.get(3)).intValue();
    localww.tBW = ((Integer)localArrayList.get(4)).intValue();
    localww.tBX = ((Integer)localArrayList.get(5)).intValue();
    return localww;
  }
  
  public static ll toMMReportIdkeyReq(g paramg)
  {
    ll localll = new ll();
    localll.tpY = paramg.sYJ;
    localll.tpZ = paramg.sYZ;
    localll.tqa = 0;
    int i = 0;
    while (i < paramg.sZa.size())
    {
      com.tencent.mm.protocal.a.a.b localb = (com.tencent.mm.protocal.a.a.b)paramg.sZa.get(i);
      lk locallk = new lk();
      locallk.lcP = localb.uin;
      locallk.tgV = localb.sYH;
      locallk.tpX = localb.nettype;
      int j = 0;
      while (j < localb.sYI.size())
      {
        a locala = (a)localb.sYI.get(j);
        ahz localahz = new ahz();
        localahz.tKv = locala.sYG;
        localahz.tsi = 0;
        localahz.tKx = 0;
        localahz.jLr = locala.count;
        localahz.tKw = com.tencent.mm.bd.b.aU(Integer.toString(locala.value).getBytes());
        locallk.mtx.add(localahz);
        j += 1;
      }
      localll.tqb.add(locallk);
      i += 1;
    }
    return localll;
  }
  
  public static ll toMMReportKvReq(i parami)
  {
    ll localll = new ll();
    localll.tpY = parami.sYJ;
    localll.tpZ = parami.sYZ;
    localll.tqa = parami.sYX;
    int i = 0;
    while (i < parami.sZa.size())
    {
      e locale = (e)parami.sZa.get(i);
      lk locallk = new lk();
      locallk.lcP = locale.uin;
      locallk.tgV = locale.sYH;
      locallk.tpX = locale.nettype;
      locallk.tjQ = locale.sYT;
      locallk.tjO = locale.sYR;
      locallk.tjP = locale.sYS;
      locallk.tjR = locale.sYU;
      locallk.tjS = locale.sYV;
      locallk.jMu = locale.sYW;
      int j = 0;
      while (j < locale.sYI.size())
      {
        d locald = (d)locale.sYI.get(j);
        ahz localahz = new ahz();
        localahz.tKv = locald.sYG;
        localahz.tKw = locald.sYP;
        localahz.tKx = locald.sYQ;
        localahz.tsi = locald.pnv;
        localahz.jLr = locald.count;
        locallk.mtx.add(localahz);
        j += 1;
      }
      localll.tqb.add(locallk);
      i += 1;
    }
    return localll;
  }
  
  public static afr toMMSelfMonitor(k paramk)
  {
    afr localafr = new afr();
    localafr.tJg = paramk.sZd;
    int i = 0;
    while (i < paramk.sZe.size())
    {
      afs localafs = new afs();
      l locall = (l)paramk.sZe.get(i);
      localafs.tJh = locall.sZf;
      localafs.fDs = locall.action;
      localafs.tJi = locall.sZg;
      localafs.tJj = locall.sZh;
      localafs.tJk = locall.sZi;
      localafs.tJl = locall.sZj;
      localafs.tJm = locall.sZk;
      localafs.tJn = locall.sZl;
      localafr.mtx.add(localafs);
      i += 1;
    }
    return localafr;
  }
  
  public static c toSmcIdkeyStrategyResp(wx paramwx)
  {
    c localc = new c();
    localc.ret = paramwx.tgr;
    localc.sYJ = paramwx.tqe;
    localc.sYK = paramwx.tqf;
    localc.sYN = paramwx.tqk;
    localc.sYO = paramwx.tqm;
    localc.sYL = fillStrategyTable(paramwx.tqh);
    localc.sYM = fillStrategyTable(paramwx.tqi);
    return localc;
  }
  
  public static f toSmcKVStrategyResp(wx paramwx)
  {
    f localf = new f();
    localf.ret = paramwx.tgr;
    localf.sYJ = paramwx.tBV;
    localf.sYK = paramwx.tBW;
    localf.sYX = paramwx.tBX;
    localf.sYN = paramwx.tqk;
    localf.sYO = paramwx.tqm;
    localf.sYL = fillStrategyTable(paramwx.tBY);
    localf.sYM = fillStrategyTable(paramwx.tBZ);
    localf.sYY = fillStrategyTable(paramwx.tCa);
    return localf;
  }
  
  public static h toSmcReportIdkeyResp(lm paramlm)
  {
    h localh = new h();
    localh.ret = paramlm.tgr;
    localh.sYJ = paramlm.tqe;
    localh.sYK = paramlm.tqf;
    localh.sYN = paramlm.tqk;
    localh.sZc = paramlm.tql;
    localh.sYO = paramlm.tqm;
    localh.sYL = fillStrategyTable(paramlm.tqh);
    localh.sYM = fillStrategyTable(paramlm.tqi);
    return localh;
  }
  
  public static j toSmcReportKvResp(lm paramlm)
  {
    j localj = new j();
    localj.ret = paramlm.tgr;
    localj.sYJ = paramlm.tqe;
    localj.sYK = paramlm.tqf;
    localj.sYX = paramlm.tqg;
    localj.sYN = paramlm.tqk;
    localj.sZc = paramlm.tql;
    localj.sYO = paramlm.tqm;
    localj.sYL = fillStrategyTable(paramlm.tqh);
    localj.sYM = fillStrategyTable(paramlm.tqi);
    localj.sYY = fillStrategyTable(paramlm.tqj);
    return localj;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mars/smc/SmcProtoBufUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */