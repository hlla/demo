package com.tencent.mm.plugin.record.a;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.protocal.c.fq;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.f.a;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.y.k
  implements j
{
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  private int lDB;
  private int lDF;
  String oMD;
  k oME;
  private SparseArray<rl> oMF;
  private SparseBooleanArray oMG;
  
  public a(k paramk)
  {
    GMTrace.i(7499147116544L, 55873);
    this.gUt = null;
    this.oMD = "";
    this.oME = null;
    this.oMF = new SparseArray();
    this.oMG = new SparseBooleanArray();
    this.lDF = 0;
    this.lDB = 0;
    b.a locala = new b.a();
    locala.hrV = new fp();
    locala.hrW = new fq();
    locala.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
    locala.hrU = 632;
    locala.hrX = 0;
    locala.hrY = 0;
    this.gUq = locala.BE();
    this.oME = paramk;
    GMTrace.o(7499147116544L, 55873);
  }
  
  private void aWr()
  {
    GMTrace.i(7499281334272L, 55874);
    this.oMD = f.a.a(m.a(this.oME.field_title, this.oME.field_desc, this.oME.field_dataProto.txF), null, null);
    GMTrace.o(7499281334272L, 55874);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(7499683987456L, 55877);
    this.gUt = parame1;
    parame1 = (fp)this.gUq.hrS.hsa;
    this.oMF.clear();
    this.oMG.clear();
    if (this.oME.field_dataProto.txF.size() == 0)
    {
      v.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
      this.lDF = -100;
      GMTrace.o(7499683987456L, 55877);
      return -100;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.lDB;
    if (i < this.oME.field_dataProto.txF.size())
    {
      rl localrl = (rl)this.oME.field_dataProto.txF.get(i);
      if ((this.oME.field_type == 14) && (localrl.aMw == 3))
      {
        v.w("MicroMsg.NetSceneTransCDN", "match voice type, clear cdn info");
        localrl.NP("");
        localrl.NO("");
        localrl.NN("");
        localrl.NM("");
      }
      do
      {
        i += 1;
        break;
        bfg localbfg;
        if (!bf.mA(localrl.tvA))
        {
          localbfg = new bfg();
          localbfg.tlE = localrl.tvA;
          localbfg.tsK = localrl.tvC;
          localbfg.uej = localrl.aMw;
          localbfg.uek = ((int)localrl.tvV);
          localbfg.uei = bf.ap(localrl.lII, "").hashCode();
          v.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[] { Integer.valueOf(localbfg.uei), localrl.lII, Integer.valueOf(localbfg.uej), localrl.tvA, Long.valueOf(localrl.tvV) });
          localLinkedList.add(localbfg);
          this.oMF.put(localbfg.uei, localrl);
          this.oMG.put(localbfg.uei, false);
        }
        if (!bf.mA(localrl.hho))
        {
          localbfg = new bfg();
          localbfg.tlE = localrl.hho;
          localbfg.tsK = localrl.tvw;
          localbfg.uej = 2;
          localbfg.uek = ((int)localrl.twg);
          localbfg.uei = (bf.ap(localrl.lII, "") + "@thumb").hashCode();
          v.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[] { Integer.valueOf(localbfg.uei), localrl.lII, Integer.valueOf(localbfg.uej), localrl.hho, Long.valueOf(localrl.twg) });
          localLinkedList.add(localbfg);
          this.oMF.put(localbfg.uei, localrl);
          this.oMG.put(localbfg.uei, true);
        }
      } while (localLinkedList.size() < 20);
    }
    this.lDB = (i + 1);
    parame1.jLr = localLinkedList.size();
    parame1.jLs.clear();
    parame1.jLs.addAll(localLinkedList);
    v.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[] { Integer.valueOf(this.oME.field_dataProto.txF.size()), Integer.valueOf(this.oMF.size()), Integer.valueOf(this.lDB) });
    if (parame1.jLr <= 0)
    {
      aWr();
      v.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
      this.lDF = -100;
      GMTrace.o(7499683987456L, 55877);
      return -100;
    }
    i = a(parame, this.gUq, this);
    GMTrace.o(7499683987456L, 55877);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(7499818205184L, 55878);
    int i = k.b.hsC;
    GMTrace.o(7499818205184L, 55878);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(7499415552000L, 55875);
    v.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.lDF), Integer.valueOf(this.lDB), paramString });
    if ((paramInt2 == 3) && (this.lDF == -100))
    {
      aWr();
      this.gUt.a(0, 0, paramString, this);
      GMTrace.o(7499415552000L, 55875);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(7499415552000L, 55875);
      return;
    }
    paramp = ((fq)((b)paramp).hrT.hsa).jLs.iterator();
    while (paramp.hasNext())
    {
      paramArrayOfByte = (bfg)paramp.next();
      rl localrl = (rl)this.oMF.get(paramArrayOfByte.uei);
      if (localrl != null) {
        if (this.oMG.get(paramArrayOfByte.uei))
        {
          v.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.uei), localrl.lII, localrl.hho, paramArrayOfByte.tlE, Long.valueOf(localrl.twg), Long.valueOf(paramArrayOfByte.uek) });
          localrl.NM(paramArrayOfByte.tlE);
          localrl.NN(paramArrayOfByte.tsK);
          if ((!bf.mA(paramArrayOfByte.tlE)) && (!bf.mA(paramArrayOfByte.tsK)) && (paramArrayOfByte.uek > 0L))
          {
            localrl.ek(paramArrayOfByte.uek);
          }
          else
          {
            v.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
        else
        {
          v.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.uei), localrl.lII, localrl.tvA, paramArrayOfByte.tlE, Long.valueOf(localrl.tvV), Long.valueOf(paramArrayOfByte.uek) });
          localrl.NO(paramArrayOfByte.tlE);
          localrl.NP(paramArrayOfByte.tsK);
          if ((!bf.mA(paramArrayOfByte.tlE)) && (!bf.mA(paramArrayOfByte.tsK)) && (paramArrayOfByte.uek > 0L))
          {
            localrl.ej(paramArrayOfByte.uek);
          }
          else
          {
            v.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
      }
    }
    boolean bool;
    if (this.lDB < this.oME.field_dataProto.txF.size())
    {
      bool = true;
      v.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label643;
      }
      if (a(this.hsm, this.gUt) != -100) {
        break label638;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        v.i("MicroMsg.NetSceneTransCDN", "do callback");
        aWr();
        this.gUt.a(paramInt2, paramInt3, paramString, this);
      }
      GMTrace.o(7499415552000L, 55875);
      return;
      bool = false;
      break;
      label638:
      paramInt1 = 0;
      continue;
      label643:
      paramInt1 = 1;
    }
  }
  
  public final int getType()
  {
    GMTrace.i(7499549769728L, 55876);
    GMTrace.o(7499549769728L, 55876);
    return 632;
  }
  
  protected final int ub()
  {
    GMTrace.i(7499952422912L, 55879);
    GMTrace.o(7499952422912L, 55879);
    return 10;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/record/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */