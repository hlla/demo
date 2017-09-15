package com.tencent.mm.y;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.bc;
import junit.framework.Assert;

public abstract class k
{
  public int aIo;
  public com.tencent.mm.network.e hsm;
  public long hsn;
  public int hso;
  public boolean hsp;
  private q hsq;
  e hsr;
  public boolean hss;
  public p hst;
  int priority;
  
  public k()
  {
    GMTrace.i(13417746268160L, 99970);
    this.priority = 0;
    this.hsn = bf.NB();
    this.hso = -1;
    this.aIo = -99;
    this.hsp = false;
    GMTrace.o(13417746268160L, 99970);
  }
  
  public boolean BI()
  {
    GMTrace.i(13418148921344L, 99973);
    GMTrace.o(13418148921344L, 99973);
    return false;
  }
  
  public boolean BJ()
  {
    GMTrace.i(13418417356800L, 99975);
    if (this.aIo <= 0)
    {
      GMTrace.o(13418417356800L, 99975);
      return true;
    }
    GMTrace.o(13418417356800L, 99975);
    return false;
  }
  
  public boolean BK()
  {
    GMTrace.i(13418551574528L, 99976);
    GMTrace.o(13418551574528L, 99976);
    return false;
  }
  
  public boolean BL()
  {
    GMTrace.i(13419088445440L, 99980);
    if (ub() == 1)
    {
      GMTrace.o(13419088445440L, 99980);
      return true;
    }
    GMTrace.o(13419088445440L, 99980);
    return false;
  }
  
  public final int BM()
  {
    GMTrace.i(13419491098624L, 99983);
    if (this.hst == null)
    {
      GMTrace.o(13419491098624L, 99983);
      return 0;
    }
    int i = this.hst.hashCode();
    GMTrace.o(13419491098624L, 99983);
    return i;
  }
  
  public int a(com.tencent.mm.network.e parame, final p paramp, final j paramj)
  {
    GMTrace.i(13419222663168L, 99981);
    c(parame);
    this.hst = paramp;
    paramj = bc.a(paramj);
    if (this.aIo == -99)
    {
      this.aIo = ub();
      v.i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.aIo);
    }
    if (ub() > 1) {
      switch (2.hsx[(a(paramp) - 1)])
      {
      default: 
        Assert.assertTrue("invalid security verification status", false);
      }
    }
    while (BJ())
    {
      v.e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + ub());
      a(a.hsz);
      this.hso = -1;
      i = this.hso;
      GMTrace.o(13419222663168L, 99981);
      return i;
      Assert.assertTrue("scene security verification not passed, type=" + paramp.getType() + ", uri=" + paramp.getUri() + ", CHECK NOW", false);
      continue;
      v.e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + paramp.getType() + ", uri=" + paramp.getUri());
      this.aIo -= 1;
      a(a.hsy);
      this.hso = -1;
      i = this.hso;
      GMTrace.o(13419222663168L, 99981);
      return i;
    }
    this.aIo -= 1;
    s locals = new s(paramp);
    if ((this.hsq != null) && (!BK())) {
      this.hsq.cancel();
    }
    this.hsq = new q(paramp, paramj, this, this.hsr, parame);
    this.hso = parame.a(locals, this.hsq);
    v.i("MicroMsg.NetSceneBase", "dispatcher send, %s", new Object[] { Integer.valueOf(this.hso) });
    if (this.hso < 0)
    {
      v.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(this.hso), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramp.getType()) });
      new ad().post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13420564840448L, 99991);
          v.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(k.this.hso), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramp.getType()) });
          paramj.a(-1, 3, -1, "send to network failed", paramp, null);
          v.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(k.this.hso), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramp.getType()) });
          GMTrace.o(13420564840448L, 99991);
        }
      });
      GMTrace.o(13419222663168L, 99981);
      return 99999999;
    }
    parame = this.hsq;
    parame.handler.postDelayed(parame.htg, 330000L);
    int i = this.hso;
    GMTrace.o(13419222663168L, 99981);
    return i;
  }
  
  public abstract int a(com.tencent.mm.network.e parame, e parame1);
  
  public int a(p paramp)
  {
    GMTrace.i(13418014703616L, 99972);
    int i = b.hsB;
    GMTrace.o(13418014703616L, 99972);
    return i;
  }
  
  public void a(a parama)
  {
    GMTrace.i(13417880485888L, 99971);
    GMTrace.o(13417880485888L, 99971);
  }
  
  public boolean a(k paramk)
  {
    GMTrace.i(13419759534080L, 99985);
    GMTrace.o(13419759534080L, 99985);
    return false;
  }
  
  public boolean b(k paramk)
  {
    GMTrace.i(13419893751808L, 99986);
    GMTrace.o(13419893751808L, 99986);
    return false;
  }
  
  public final void c(com.tencent.mm.network.e parame)
  {
    GMTrace.i(13418954227712L, 99979);
    this.hsn = bf.NB();
    this.hsm = parame;
    GMTrace.o(13418954227712L, 99979);
  }
  
  public void cancel()
  {
    GMTrace.i(13419625316352L, 99984);
    v.i("MicroMsg.NetSceneBase", "cancel: %d, hash:%d, type:%d", new Object[] { Integer.valueOf(this.hso), Integer.valueOf(hashCode()), Integer.valueOf(getType()) });
    this.hsp = true;
    if (this.hsq != null) {
      this.hsq.cancel();
    }
    if ((this.hso != -1) && (this.hsm != null))
    {
      int i = this.hso;
      this.hso = -1;
      this.hsm.cancel(i);
    }
    GMTrace.o(13419625316352L, 99984);
  }
  
  public String getInfo()
  {
    GMTrace.i(13420027969536L, 99987);
    GMTrace.o(13420027969536L, 99987);
    return "";
  }
  
  public abstract int getType();
  
  public int ub()
  {
    GMTrace.i(13418283139072L, 99974);
    GMTrace.o(13418283139072L, 99974);
    return 1;
  }
  
  protected static enum a
  {
    static
    {
      GMTrace.i(13390365851648L, 99766);
      hsy = new a("EStatusCheckFailed", 0);
      hsz = new a("EReachMaxLimit", 1);
      hsA = new a[] { hsy, hsz };
      GMTrace.o(13390365851648L, 99766);
    }
    
    private a()
    {
      GMTrace.i(13390231633920L, 99765);
      GMTrace.o(13390231633920L, 99765);
    }
  }
  
  protected static enum b
  {
    static
    {
      GMTrace.i(13425665114112L, 100029);
      hsB = 1;
      hsC = 2;
      hsD = 3;
      hsE = new int[] { hsB, hsC, hsD };
      GMTrace.o(13425665114112L, 100029);
    }
    
    public static int[] BN()
    {
      GMTrace.i(13425530896384L, 100028);
      int[] arrayOfInt = (int[])hsE.clone();
      GMTrace.o(13425530896384L, 100028);
      return arrayOfInt;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */