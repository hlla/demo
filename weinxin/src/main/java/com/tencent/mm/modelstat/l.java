package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.as.b;
import com.tencent.mm.sdk.platformtools.as.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import junit.framework.Assert;

public final class l
  extends com.tencent.mm.sdk.e.j
  implements as.c<Integer, j>
{
  public static final String[] gUn;
  private static final String[] hWH;
  private long hWE;
  public as<Integer, j> hWF;
  private long hWG;
  public g hnp;
  
  static
  {
    GMTrace.i(1389690355712L, 10354);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) " };
    hWH = new String[] { "realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut" };
    GMTrace.o(1389690355712L, 10354);
  }
  
  public l(g paramg)
  {
    GMTrace.i(1388482396160L, 10345);
    this.hnp = paramg;
    this.hWF = new as(this, h.vL().nIe.getLooper(), 30, 2, 300000L, 1000L);
    paramg = new HashSet();
    Object localObject1 = hWH;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      paramg.add(localObject1[i]);
      i += 1;
    }
    localObject1 = this.hnp.a("PRAGMA table_info(netstat);", null, 2);
    i = ((Cursor)localObject1).getColumnIndex("name");
    while (((Cursor)localObject1).moveToNext()) {
      paramg.remove(((Cursor)localObject1).getString(i));
    }
    ((Cursor)localObject1).close();
    localObject1 = hWH;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramg.contains(localObject2))
      {
        localObject2 = "ALTER TABLE netstat ADD COLUMN " + (String)localObject2 + " INT;";
        this.hnp.eE("netstat", (String)localObject2);
      }
      i += 1;
    }
    this.hWG = System.currentTimeMillis();
    GMTrace.o(1388482396160L, 10345);
  }
  
  public final long Kc()
  {
    GMTrace.i(1389019267072L, 10349);
    this.hWF.jS(true);
    int j = (int)((bf.NA() - 1296000000L) / 86400000L);
    int i = (int)(bf.bJJ() / 86400000L);
    Object localObject = "SELECT peroid FROM netstat  WHERE peroid > " + j + " order by peroid limit 1";
    localObject = this.hnp.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("peroid"));
    }
    ((Cursor)localObject).close();
    long l = i;
    GMTrace.o(1389019267072L, 10349);
    return l * 86400000L;
  }
  
  public final boolean Kd()
  {
    GMTrace.i(1389287702528L, 10351);
    if (this.hnp.inTransaction())
    {
      v.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
      GMTrace.o(1389287702528L, 10351);
      return false;
    }
    this.hWE = this.hnp.cs(Thread.currentThread().getId());
    if (this.hWE <= 0L)
    {
      v.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.hWE + " return false");
      GMTrace.o(1389287702528L, 10351);
      return false;
    }
    GMTrace.o(1389287702528L, 10351);
    return true;
  }
  
  public final void Ke()
  {
    GMTrace.i(1389556137984L, 10353);
    if (this.hWE > 0L) {
      this.hnp.aD(this.hWE);
    }
    GMTrace.o(1389556137984L, 10353);
  }
  
  public final void a(j paramj)
  {
    GMTrace.i(1388750831616L, 10347);
    Assert.assertNotNull(paramj);
    long l = System.currentTimeMillis();
    if (paramj.hVR <= 0) {
      paramj.hVR = ((int)(l / 86400000L));
    }
    if (paramj.hVR <= 0)
    {
      GMTrace.o(1388750831616L, 10347);
      return;
    }
    j localj = gD(paramj.hVR);
    if ((localj != null) && (paramj.hVR == localj.hVR))
    {
      localj.fRM |= 0x1;
      paramj.hVS += localj.hVT;
      paramj.hVT += localj.hVT;
      paramj.hVU += localj.hVV;
      paramj.hVV += localj.hVV;
      paramj.hVW += localj.hVW;
      paramj.hVX += localj.hVX;
      paramj.hVY += localj.hVY;
      paramj.hVZ += localj.hVZ;
      paramj.hWa += localj.hWa;
      paramj.hWb += localj.hWb;
      paramj.hWc += localj.hWc;
      paramj.hWd += localj.hWd;
      paramj.hWe += localj.hWf;
      paramj.hWf += localj.hWf;
      paramj.hWg += localj.hWh;
      paramj.hWh += localj.hWh;
      paramj.hWi += localj.hWi;
      paramj.hWj += localj.hWj;
      paramj.hWk += localj.hWk;
      paramj.hWl += localj.hWl;
      paramj.hWm += localj.hWm;
      paramj.hWn += localj.hWn;
      paramj.hWo += localj.hWo;
      paramj.hWp += localj.hWp;
      paramj.hWq += localj.hWq;
      paramj.hWr += localj.hWr;
      paramj.hWs += localj.hWs;
      paramj.hWt += localj.hWt;
      if ((paramj.hWa <= 4096) && (paramj.hWb <= 4096) && (paramj.hWm <= 4096)) {
        int i = paramj.hWn;
      }
      paramj.id = localj.id;
      if (l - this.hWG > 300000L) {
        v.i("MicroMsg.NetStat", paramj.toString());
      }
    }
    for (;;)
    {
      this.hWG = l;
      b(paramj);
      GMTrace.o(1388750831616L, 10347);
      return;
      paramj.fRM |= 0x2;
      paramj.id = -1;
      if (localj != null) {
        v.i("MicroMsg.NetStat", localj.toString());
      } else {
        v.i("MicroMsg.NetStat", "NetStat started.");
      }
    }
  }
  
  public final void a(as<Integer, j> paramas, as.b<Integer, j> paramb)
  {
    GMTrace.i(1389421920256L, 10352);
    int i = paramb.utu;
    paramas = (j)paramb.values;
    if ((paramas != null) && (i == 1))
    {
      i = paramas.hVR;
      int j = paramas.id;
      if (i > 0)
      {
        paramb = new ContentValues();
        if ((paramas.fRM & 0x2) != 0) {
          paramb.put("peroid", Integer.valueOf(paramas.hVR));
        }
        if ((paramas.fRM & 0x4) != 0) {
          paramb.put("textCountIn", Integer.valueOf(paramas.hVS));
        }
        if ((paramas.fRM & 0x8) != 0) {
          paramb.put("textBytesIn", Integer.valueOf(paramas.hVT));
        }
        if ((paramas.fRM & 0x10) != 0) {
          paramb.put("imageCountIn", Integer.valueOf(paramas.hVU));
        }
        if ((paramas.fRM & 0x20) != 0) {
          paramb.put("imageBytesIn", Integer.valueOf(paramas.hVV));
        }
        if ((paramas.fRM & 0x40) != 0) {
          paramb.put("voiceCountIn", Integer.valueOf(paramas.hVW));
        }
        if ((paramas.fRM & 0x80) != 0) {
          paramb.put("voiceBytesIn", Integer.valueOf(paramas.hVX));
        }
        if ((paramas.fRM & 0x100) != 0) {
          paramb.put("videoCountIn", Integer.valueOf(paramas.hVY));
        }
        if ((paramas.fRM & 0x200) != 0) {
          paramb.put("videoBytesIn", Integer.valueOf(paramas.hVZ));
        }
        if ((paramas.fRM & 0x400) != 0) {
          paramb.put("mobileBytesIn", Integer.valueOf(paramas.hWa));
        }
        if ((paramas.fRM & 0x800) != 0) {
          paramb.put("wifiBytesIn", Integer.valueOf(paramas.hWb));
        }
        if ((paramas.fRM & 0x1000) != 0) {
          paramb.put("sysMobileBytesIn", Integer.valueOf(paramas.hWc));
        }
        if ((paramas.fRM & 0x2000) != 0) {
          paramb.put("sysWifiBytesIn", Integer.valueOf(paramas.hWd));
        }
        if ((paramas.fRM & 0x4000) != 0) {
          paramb.put("textCountOut", Integer.valueOf(paramas.hWe));
        }
        if ((paramas.fRM & 0x8000) != 0) {
          paramb.put("textBytesOut", Integer.valueOf(paramas.hWf));
        }
        if ((paramas.fRM & 0x10000) != 0) {
          paramb.put("imageCountOut", Integer.valueOf(paramas.hWg));
        }
        if ((paramas.fRM & 0x20000) != 0) {
          paramb.put("imageBytesOut", Integer.valueOf(paramas.hWh));
        }
        if ((paramas.fRM & 0x40000) != 0) {
          paramb.put("voiceCountOut", Integer.valueOf(paramas.hWi));
        }
        if ((paramas.fRM & 0x80000) != 0) {
          paramb.put("voiceBytesOut", Integer.valueOf(paramas.hWj));
        }
        if ((paramas.fRM & 0x100000) != 0) {
          paramb.put("videoCountOut", Integer.valueOf(paramas.hWk));
        }
        if ((paramas.fRM & 0x200000) != 0) {
          paramb.put("videoBytesOut", Integer.valueOf(paramas.hWl));
        }
        if ((paramas.fRM & 0x400000) != 0) {
          paramb.put("mobileBytesOut", Integer.valueOf(paramas.hWm));
        }
        if ((paramas.fRM & 0x800000) != 0) {
          paramb.put("wifiBytesOut", Integer.valueOf(paramas.hWn));
        }
        if ((paramas.fRM & 0x1000000) != 0) {
          paramb.put("sysMobileBytesOut", Integer.valueOf(paramas.hWo));
        }
        if ((paramas.fRM & 0x2000000) != 0) {
          paramb.put("sysWifiBytesOut", Integer.valueOf(paramas.hWp));
        }
        if ((paramas.fRM & 0x4000000) != 0) {
          paramb.put("realMobileBytesIn", Integer.valueOf(paramas.hWq));
        }
        if ((paramas.fRM & 0x8000000) != 0) {
          paramb.put("realWifiBytesIn", Integer.valueOf(paramas.hWr));
        }
        if ((paramas.fRM & 0x10000000) != 0) {
          paramb.put("realMobileBytesOut", Integer.valueOf(paramas.hWs));
        }
        if ((paramas.fRM & 0x20000000) != 0) {
          paramb.put("realWifiBytesOut", Integer.valueOf(paramas.hWt));
        }
        if (j < 0)
        {
          paramas.id = ((int)this.hnp.insert("netstat", "id", paramb));
          GMTrace.o(1389421920256L, 10352);
          return;
        }
        this.hnp.update("netstat", paramb, "peroid=" + i, null);
      }
    }
    GMTrace.o(1389421920256L, 10352);
  }
  
  public final boolean b(j paramj)
  {
    GMTrace.i(1388885049344L, 10348);
    Assert.assertNotNull(paramj);
    if (paramj.hVR > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bool = this.hWF.q(Integer.valueOf(paramj.hVR), paramj);
      GMTrace.o(1388885049344L, 10348);
      return bool;
    }
  }
  
  public final j gD(int paramInt)
  {
    GMTrace.i(1388616613888L, 10346);
    Object localObject2 = (j)this.hWF.get(Integer.valueOf(paramInt));
    Object localObject3;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject3 = this.hnp.a("netstat", null, "peroid = " + paramInt, null, null, null, null, 2);
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new j();
        ((j)localObject1).b((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
      if (localObject1 != null) {
        this.hWF.q(Integer.valueOf(paramInt), localObject1);
      }
    }
    for (;;)
    {
      GMTrace.o(1388616613888L, 10346);
      return (j)localObject1;
      localObject2 = this.hWF;
      localObject3 = new j();
      ((j)localObject3).fRM = 0;
      ((j)localObject3).id = 0;
      ((j)localObject3).hVR = 0;
      ((j)localObject3).hVS = 0;
      ((j)localObject3).hVT = 0;
      ((j)localObject3).hVU = 0;
      ((j)localObject3).hVV = 0;
      ((j)localObject3).hVW = 0;
      ((j)localObject3).hVX = 0;
      ((j)localObject3).hVY = 0;
      ((j)localObject3).hVZ = 0;
      ((j)localObject3).hWa = 0;
      ((j)localObject3).hWb = 0;
      ((j)localObject3).hWc = 0;
      ((j)localObject3).hWd = 0;
      ((j)localObject3).hWe = 0;
      ((j)localObject3).hWf = 0;
      ((j)localObject3).hWg = 0;
      ((j)localObject3).hWh = 0;
      ((j)localObject3).hWi = 0;
      ((j)localObject3).hWj = 0;
      ((j)localObject3).hWk = 0;
      ((j)localObject3).hWl = 0;
      ((j)localObject3).hWm = 0;
      ((j)localObject3).hWn = 0;
      ((j)localObject3).hWo = 0;
      ((j)localObject3).hWp = 0;
      ((j)localObject3).hWq = 0;
      ((j)localObject3).hWr = 0;
      ((j)localObject3).hWs = 0;
      ((j)localObject3).hWt = 0;
      ((as)localObject2).q(Integer.valueOf(paramInt), localObject3);
      continue;
      localObject1 = localObject2;
      if (((j)localObject2).hVR != paramInt) {
        localObject1 = null;
      }
    }
  }
  
  public final j gE(int paramInt)
  {
    j localj = null;
    GMTrace.i(1389153484800L, 10350);
    this.hWF.jS(true);
    Object localObject = "SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= " + paramInt;
    localObject = this.hnp.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localj = new j();
      localj.b((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    GMTrace.o(1389153484800L, 10350);
    return localj;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelstat/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */