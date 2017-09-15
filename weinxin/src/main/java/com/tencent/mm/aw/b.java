package com.tencent.mm.aw;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bjo;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import com.tencent.mm.y.n;
import com.tencent.mm.y.n.4;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public final class b
  extends a
  implements j
{
  private int fEO;
  private String filename;
  private com.tencent.mm.y.e gUt;
  private int hTs;
  private boolean iaN;
  private int icg;
  g ich;
  private boolean ici;
  private boolean icj;
  private int ick;
  private avu icl;
  private String[] icm;
  private int icn;
  private ad ico;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(14690801418240L, 109455);
    this.fEO = 0;
    this.icg = 120;
    this.iaN = false;
    this.ici = false;
    this.icj = false;
    this.hTs = 0;
    this.ick = 0;
    this.filename = null;
    this.icl = null;
    this.icm = new String[0];
    this.icn = 3960;
    this.ico = new ad(h.vL().nIe.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(4381537730560L, 32645);
        if (paramAnonymousMessage.what != 291)
        {
          GMTrace.o(4381537730560L, 32645);
          return;
        }
        if (b.this.LL()) {
          h.vd().a(b.this, 0);
        }
        GMTrace.o(4381537730560L, 32645);
      }
    };
    this.filename = paramString1;
    this.ich = new g(paramString2);
    this.icl = new avu().OU(paramString3);
    v.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s", new Object[] { paramString1, paramString2, paramString3 });
    GMTrace.o(14690801418240L, 109455);
  }
  
  private void LN()
  {
    GMTrace.i(4398314946560L, 32770);
    v.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.sd());
    if (this.ico != null) {
      this.ico.removeMessages(291);
    }
    this.ici = true;
    GMTrace.o(4398314946560L, 32770);
  }
  
  protected final boolean BK()
  {
    GMTrace.i(4397912293376L, 32767);
    GMTrace.o(4397912293376L, 32767);
    return true;
  }
  
  public final void LH()
  {
    GMTrace.i(4396570116096L, 32757);
    this.iaN = true;
    GMTrace.o(4396570116096L, 32757);
  }
  
  public final String[] LI()
  {
    GMTrace.i(4396704333824L, 32758);
    String[] arrayOfString = this.icm;
    GMTrace.o(4396704333824L, 32758);
    return arrayOfString;
  }
  
  public final long LJ()
  {
    GMTrace.i(4396838551552L, 32759);
    GMTrace.o(4396838551552L, 32759);
    return 0L;
  }
  
  public final Set<String> LK()
  {
    GMTrace.i(4396972769280L, 32760);
    g localg = this.ich;
    HashSet localHashSet = new HashSet();
    localg.icU.readLock().lock();
    Iterator localIterator = localg.icT.values().iterator();
    while (localIterator.hasNext())
    {
      g.a locala = (g.a)localIterator.next();
      if (locala.icX) {
        localHashSet.add(locala.icW);
      }
    }
    localg.icU.readLock().unlock();
    GMTrace.o(4396972769280L, 32760);
    return localHashSet;
  }
  
  public final boolean LL()
  {
    GMTrace.i(4397241204736L, 32762);
    v.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
    this.ico.removeMessages(291);
    if (((this.ich.LY()) && (this.iaN)) || (this.ici))
    {
      v.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
      GMTrace.o(4397241204736L, 32762);
      return false;
    }
    g.a locala = this.ich.gS(this.hTs);
    if (locala != null)
    {
      int i = com.tencent.mm.a.e.aN(this.filename);
      int j = Math.min(i, locala.icZ);
      v.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.icZ), Integer.valueOf(j) });
      if (j <= 0)
      {
        v.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[] { this.filename });
        this.fEO = (com.tencent.mm.compatible.util.g.sb() + 40000);
        this.ick = 0;
        LM();
        this.gUt.a(3, -1, "ReadFileLengthError", null);
        GMTrace.o(4397241204736L, 32762);
        return false;
      }
      this.ick = (j - this.hTs);
      if (this.ick < 0)
      {
        v.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[] { Integer.valueOf(this.ick) });
        this.fEO = (com.tencent.mm.compatible.util.g.sb() + 40000);
        this.ico.sendEmptyMessageDelayed(291, this.icg * 2);
        GMTrace.o(4397241204736L, 32762);
        return false;
      }
      v.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[] { Integer.valueOf(this.ick), Integer.valueOf(locala.ida), Integer.valueOf(this.icg) });
      if ((this.ick < 500) && (locala.ida > 5))
      {
        v.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[] { Integer.valueOf(this.ick) });
        this.ico.sendEmptyMessageDelayed(291, this.icg * 2);
      }
      for (;;)
      {
        GMTrace.o(4397241204736L, 32762);
        return true;
        this.ico.sendEmptyMessageDelayed(291, this.icg);
      }
    }
    this.ico.sendEmptyMessageDelayed(291, this.icg * 2);
    GMTrace.o(4397241204736L, 32762);
    return true;
  }
  
  public final void LM()
  {
    GMTrace.i(4398180728832L, 32769);
    v.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.sd());
    if (this.icj)
    {
      GMTrace.o(4398180728832L, 32769);
      return;
    }
    this.icj = true;
    LN();
    final Object localObject = h.vd();
    int i = hashCode();
    v.j("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", new Object[] { Integer.valueOf(i) });
    ((n)localObject).hsJ.D(new n.4((n)localObject, i));
    localObject = this.ich.gS(this.hTs);
    if (localObject != null)
    {
      this.ick = 0;
      h.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(4391335624704L, 32718);
          v.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", new Object[] { localObject.icW, Integer.valueOf(localObject.icZ), Integer.valueOf(b.this.hashCode()) });
          h.vd().a(b.this, 0);
          GMTrace.o(4391335624704L, 32718);
        }
      });
    }
    GMTrace.o(4398180728832L, 32769);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4397375422464L, 32763);
    this.gUt = parame1;
    parame1 = new b.a();
    parame1.hrV = new bjo();
    parame1.hrW = new bjq();
    parame1.uri = "/cgi-bin/micromsg-bin/voicetrans";
    parame1.hrU = 235;
    parame1.hrX = 381;
    parame1.hrY = 1000000381;
    parame1 = parame1.BE();
    parame1.BG().sXR = false;
    Object localObject1 = (bjo)parame1.hrS.hsa;
    Object localObject2 = this.ich.gS(this.hTs);
    if (localObject2 == null)
    {
      ((bjo)localObject1).tqC = new avt();
      ((bjo)localObject1).tjF = this.hTs;
      ((bjo)localObject1).ufm = "0";
      ((bjo)localObject1).the = 1;
      ((bjo)localObject1).ufo = 2;
      ((bjo)localObject1).tkk = 0;
      ((bjo)localObject1).uhs = this.ich.LW();
      if (((bjo)localObject1).uhs == null) {}
      for (i = 0;; i = ((bjo)localObject1).uhs.size())
      {
        ((bjo)localObject1).uhr = i;
        ((bjo)localObject1).tWY = this.icl;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        localObject1 = ((bjo)localObject1).uhs.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StringBuilder)localObject2).append(((avu)((Iterator)localObject1).next()).tXF).append(", ");
        }
      }
      ((StringBuilder)localObject2).append("]");
      v.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[] { ((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()) });
      i = a(parame, parame1, this);
      GMTrace.o(4397375422464L, 32763);
      return i;
    }
    ((g.a)localObject2).icX = true;
    if (this.icj)
    {
      ((g.a)localObject2).icY = true;
      ((bjo)localObject1).tqC = new avt();
      v.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
      ((bjo)localObject1).tjF = this.hTs;
      ((bjo)localObject1).ufm = ((g.a)localObject2).icW;
      if (!((g.a)localObject2).icY) {
        break label806;
      }
      i = 1;
      label405:
      ((bjo)localObject1).the = i;
      ((bjo)localObject1).ufo = 2;
      i = ((g.a)localObject2).ida + 1;
      ((g.a)localObject2).ida = i;
      ((bjo)localObject1).tkk = i;
      ((bjo)localObject1).uhs = this.ich.LW();
      if (((bjo)localObject1).uhs != null) {
        break label811;
      }
    }
    label806:
    label811:
    for (int i = 0;; i = ((bjo)localObject1).uhs.size())
    {
      ((bjo)localObject1).uhr = i;
      ((bjo)localObject1).tWY = this.icl;
      v.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s", new Object[] { com.tencent.mm.compatible.util.g.sd(), this.filename, Integer.valueOf(((g.a)localObject2).icZ), Integer.valueOf(this.hTs), Integer.valueOf(this.ick), Integer.valueOf(((bjo)localObject1).tqC.tXB), Boolean.valueOf(((g.a)localObject2).icY), Integer.valueOf(((bjo)localObject1).tkk), ((bjo)localObject1).uhs, ((bjo)localObject1).tWY });
      i = this.hTs;
      this.hTs = (((bjo)localObject1).tqC.tXB + i);
      v.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[] { ((g.a)localObject2).icW, Integer.valueOf(this.hTs) });
      if (((g.a)localObject2).ida == 1) {
        v.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      v.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      i = a(parame, parame1, this);
      GMTrace.o(4397375422464L, 32763);
      return i;
      if (this.ick > this.icn) {
        this.ick = this.icn;
      }
      for (((g.a)localObject2).icY = false;; ((g.a)localObject2).icY = true) {
        do
        {
          byte[] arrayOfByte = com.tencent.mm.a.e.c(this.filename, this.hTs, this.ick);
          ((bjo)localObject1).tqC = new avt().bb(arrayOfByte);
          break;
        } while ((this.ick > this.icn) || ((((g.a)localObject2).icZ == Integer.MAX_VALUE) && (!this.iaN)));
      }
      i = 0;
      break label405;
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(4397509640192L, 32764);
    int i = k.b.hsC;
    GMTrace.o(4397509640192L, 32764);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4398046511104L, 32768);
    v.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[] { com.tencent.mm.compatible.util.g.sd(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 3) && (paramInt3 == -1)) {
      v.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[] { bf.bJP(), Long.valueOf(Thread.currentThread().getId()) });
    }
    paramArrayOfByte = (bjo)((com.tencent.mm.y.b)paramp).hrS.hsa;
    paramp = (bjq)((com.tencent.mm.y.b)paramp).hrT.hsa;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.i("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.sd() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[] { this.filename, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      LM();
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4398046511104L, 32768);
      return;
    }
    v.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[] { paramArrayOfByte.ufm, Integer.valueOf(paramArrayOfByte.tkk), Long.valueOf(System.currentTimeMillis()) });
    this.ich.P(paramp.uhw);
    if ((this.ich.LY()) && (this.iaN))
    {
      v.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
      LN();
    }
    this.icm = new String[] { this.ich.LX() };
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    if (paramp.uhx <= 0)
    {
      paramInt1 = this.icn;
      this.icn = paramInt1;
      if (paramp.tVz >= 0) {
        break label413;
      }
    }
    label413:
    for (paramInt1 = 120;; paramInt1 = paramp.tVz)
    {
      this.icg = paramInt1;
      v.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[] { Integer.valueOf(this.icn), Integer.valueOf(this.icg) });
      GMTrace.o(4398046511104L, 32768);
      return;
      paramInt1 = paramp.uhx;
      break;
    }
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(4397778075648L, 32766);
    v.w("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.sd() + " setSecurityCheckError e: %s", new Object[] { parama });
    if (parama == k.a.hsz)
    {
      LM();
      this.gUt.a(3, -1, "SecurityCheckError", this);
    }
    GMTrace.o(4397778075648L, 32766);
  }
  
  public final void gR(int paramInt)
  {
    GMTrace.i(4398583382016L, 32772);
    v.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[] { com.tencent.mm.compatible.util.g.sd(), Integer.valueOf(paramInt) });
    if (paramInt < 0) {
      throw new IllegalStateException();
    }
    this.ich.gR(paramInt);
    GMTrace.o(4398583382016L, 32772);
  }
  
  public final int getType()
  {
    GMTrace.i(4398449164288L, 32771);
    GMTrace.o(4398449164288L, 32771);
    return 235;
  }
  
  protected final int ub()
  {
    GMTrace.i(4397643857920L, 32765);
    GMTrace.o(4397643857920L, 32765);
    return 2000;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aw/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */