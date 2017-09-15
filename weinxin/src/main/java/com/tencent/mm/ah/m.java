package com.tencent.mm.ah;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.b;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.h.a.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.report.service.f.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ba;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import junit.framework.Assert;

public class m
{
  public static m hGP;
  ConcurrentHashMap<Long, d> hGN;
  public c hGO;
  public ConcurrentHashMap<Long, e> hGQ;
  private ArrayList<Long> hGR;
  ArrayList<e> hGS;
  
  public m()
  {
    GMTrace.i(3514893860864L, 26188);
    this.hGN = new ConcurrentHashMap();
    this.hGQ = new ConcurrentHashMap();
    this.hGR = new ArrayList();
    this.hGS = new ArrayList();
    this.hGO = new c();
    GMTrace.o(3514893860864L, 26188);
  }
  
  public static m GK()
  {
    GMTrace.i(3515028078592L, 26189);
    if (hGP == null) {}
    try
    {
      if (hGP == null) {
        hGP = new m();
      }
      m localm = hGP;
      GMTrace.o(3515028078592L, 26189);
      return localm;
    }
    finally {}
  }
  
  private boolean GL()
  {
    GMTrace.i(3515699167232L, 26194);
    if ((this.hGS.size() > 0) && (f.a.aXC().oSB <= 2))
    {
      v.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
      GMTrace.o(3515699167232L, 26194);
      return false;
    }
    GMTrace.o(3515699167232L, 26194);
    return true;
  }
  
  private static int b(String paramString1, String paramString2, boolean paramBoolean)
  {
    GMTrace.i(3515967602688L, 26196);
    if (com.tencent.mm.u.m.a(paramString1, paramString2, paramBoolean))
    {
      GMTrace.o(3515967602688L, 26196);
      return 1;
    }
    GMTrace.o(3515967602688L, 26196);
    return 0;
  }
  
  private boolean jz(String paramString)
  {
    GMTrace.i(3515564949504L, 26193);
    Iterator localIterator = this.hGS.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).hHg.equals(paramString))
      {
        GMTrace.o(3515564949504L, 26193);
        return true;
      }
    }
    GMTrace.o(3515564949504L, 26193);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean, int paramInt3)
  {
    GMTrace.i(3515833384960L, 26195);
    if (jz(paramString1))
    {
      GMTrace.o(3515833384960L, 26195);
      return;
    }
    int i = b(paramString1, paramString2, paramBoolean);
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    Object localObject2;
    Object localObject1;
    b localb2;
    b localb1;
    String str1;
    if (GL())
    {
      localObject2 = this.hGO.ga(1);
      localObject1 = this.hGO.ga(2);
      localb2 = ((b)localObject2).hHa;
      localb1 = ((b)localObject1).hHa;
      localObject1 = ((b)localObject1).hHb;
      str1 = ((b)localObject2).hHb;
    }
    for (;;)
    {
      f localf = n.GT();
      if (!FileOp.aO(paramString1))
      {
        v.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString1 });
        localObject2 = new e();
        ((e)localObject2).hHg = paramString1;
        ((e)localObject2).hEK = i;
        ((e)localObject2).cFR = paramInt1;
        ((e)localObject2).fNs = paramInt2;
        ((e)localObject2).hHh = ((String)localObject1);
        ((e)localObject2).hHk = localPString;
        ((e)localObject2).hHm = localPInt2;
        ((e)localObject2).hHl = localPInt1;
        ((e)localObject2).hHi = str1;
        ((e)localObject2).hHo = localb1;
        ((e)localObject2).hHn = localb2;
        if (hGP.GL()) {
          a.a((e)localObject2);
        }
        ((e)localObject2).toUserName = paramString2;
        this.hGS.add(localObject2);
        v.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[] { paramString1, paramString2 });
        GMTrace.o(3515833384960L, 26195);
        return;
      }
      if (bf.mA((String)localObject1)) {}
      for (localObject2 = f.GF();; localObject2 = localObject1)
      {
        localObject2 = "THUMBNAIL_DIRPATH://th_" + (String)localObject2;
        String str2 = localf.a((String)localObject2, "th_", "", false);
        localPString.value = ((String)localObject2);
        long l = bf.NB();
        Bitmap localBitmap = localf.a(paramString1, i, paramInt2, localPInt1, localPInt2, false, null, null);
        localObject2 = (String)localf.hFo.get(paramString1);
        if (localObject2 != null) {}
        for (localObject2 = (Bitmap)localf.hFn.get(localObject2);; localObject2 = null)
        {
          Object localObject3;
          if (localObject2 != null)
          {
            localObject3 = localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            localObject3 = localf.a(paramString1, true, com.tencent.mm.bg.a.getDensity(aa.getContext()), false, false, true, paramInt3, true, localBitmap);
            localf.hFo.put(paramString1, str2);
          }
          if (localObject3 != null) {
            localf.hFn.k(str2, localObject3);
          }
          v.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[] { Long.valueOf(bf.aB(l)) });
          break;
        }
      }
      str1 = null;
      localObject1 = null;
      localb1 = null;
      localb2 = null;
    }
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    GMTrace.i(3515430731776L, 26192);
    v.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString });
    Object localObject1 = this.hGS.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if ((!paramArrayList.contains(((e)localObject2).hHg)) || ((!bf.mA(((e)localObject2).toUserName)) && (!((e)localObject2).toUserName.equalsIgnoreCase(paramString))) || ((!bf.mA(paramString)) && (!paramString.equalsIgnoreCase(((e)localObject2).toUserName)))) {
        ((Iterator)localObject1).remove();
      } else {
        ((e)localObject2).hEK = b(((e)localObject2).hHg, paramString, paramBoolean);
      }
    }
    localObject1 = new ArrayList();
    if (paramArrayList.size() == 9)
    {
      com.tencent.mm.plugin.report.service.f.rU(18);
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label376;
      }
      localObject2 = (String)paramArrayList.next();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (!com.tencent.mm.a.e.aO((String)localObject2)))
      {
        v.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
        continue;
        if (paramArrayList.size() == 1)
        {
          boolean bool = al.isWifi(aa.getContext());
          com.tencent.mm.plugin.report.service.f.rU(25);
          if (!bool) {
            break;
          }
          if (com.tencent.mm.u.m.a((String)paramArrayList.get(0), paramString, paramBoolean))
          {
            com.tencent.mm.plugin.report.service.f.rU(23);
            break;
          }
          com.tencent.mm.plugin.report.service.f.rU(21);
          break;
        }
        com.tencent.mm.plugin.report.service.f.rU(24);
        break;
      }
      if (com.tencent.mm.sdk.platformtools.o.Pi((String)localObject2)) {
        v.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[] { localObject2, Integer.valueOf(com.tencent.mm.a.e.aN((String)localObject2)) });
      } else if (!jz((String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    label376:
    paramArrayList = ((ArrayList)localObject1).iterator();
    while (paramArrayList.hasNext()) {
      a(paramInt1, paramInt2, (String)paramArrayList.next(), paramString, paramBoolean, paramInt3);
    }
    paramArrayList = new ArrayList();
    long l1 = com.tencent.mm.kernel.h.vI().gXW.cs(Thread.currentThread().getId());
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ac("SendImgSpeeder");
    paramInt1 = 1;
    paramInt2 = 0;
    while (paramInt2 < this.hGS.size())
    {
      localObject1 = (e)this.hGS.get(paramInt2);
      if (com.tencent.mm.sdk.platformtools.o.Pi(((e)localObject1).hHg))
      {
        v.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
        paramInt2 += 1;
      }
      else
      {
        localObject2 = new au();
        ((au)localObject2).setType(com.tencent.mm.u.o.fH(paramString));
        ((au)localObject2).cH(paramString);
        ((au)localObject2).dw(1);
        ((au)localObject2).dv(1);
        ((au)localObject2).cI(((e)localObject1).hHk.value);
        ((au)localObject2).dH(((e)localObject1).hHl.value);
        ((au)localObject2).dI(((e)localObject1).hHm.value);
        String str = ba.zz();
        if (((str != null) && (!str.equals(((ce)localObject2).gxv))) || ((str == null) && (((ce)localObject2).gxv != null))) {
          ((au)localObject2).cN(str);
        }
        a.a.qB().b((au)localObject2);
        ((au)localObject2).z(ay.gk(((ce)localObject2).field_talker));
        paramArrayList.add(localObject2);
        long l2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().L((au)localObject2);
        if (l2 >= 0L) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          Assert.assertTrue(paramBoolean);
          ((e)localObject1).fGD = l2;
          this.hGQ.put(Long.valueOf(((e)localObject1).fGD), localObject1);
          this.hGR.add(Long.valueOf(((e)localObject1).fGD));
          paramInt1 = 0;
          break;
        }
      }
    }
    this.hGS.clear();
    if (l1 > 0L) {
      com.tencent.mm.kernel.h.vI().gXW.aD(l1);
    }
    if (paramInt1 != 0) {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ad("SendImgSpeeder");
    }
    GMTrace.o(3515430731776L, 26192);
  }
  
  public final boolean am(long paramLong)
  {
    GMTrace.i(3515162296320L, 26190);
    boolean bool = this.hGN.containsKey(Long.valueOf(paramLong));
    GMTrace.o(3515162296320L, 26190);
    return bool;
  }
  
  public final d an(long paramLong)
  {
    GMTrace.i(3515296514048L, 26191);
    d locald = (d)this.hGN.get(Long.valueOf(paramLong));
    GMTrace.o(3515296514048L, 26191);
    return locald;
  }
  
  public final ArrayList<Integer> jy(String paramString)
  {
    GMTrace.i(17503736561664L, 130413);
    Object localObject1 = this.hGQ.values();
    Object localObject2 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      PString localPString = new PString();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      locale.hHj = n.GT().a(locale.hHg, locale.hEK, locale.cFR, locale.fNs, localPString, localPInt1, localPInt2, locale.hHh, locale.hHi, locale.fGD, locale.hHn, locale.hHo, locale.hHp);
      au localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(locale.fGD);
      if (bf.mA(localau.field_imgPath))
      {
        localau.cI(localPString.value);
        localau.dH(localPInt1.value);
        localau.dI(localPInt2.value);
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(locale.fGD, localau);
      }
    }
    if (!bf.mA(paramString))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        if (!paramString.equals(((e)localObject2).toUserName))
        {
          this.hGQ.remove(Long.valueOf(((e)localObject2).fGD));
          this.hGR.remove(Long.valueOf(((e)localObject2).fGD));
          v.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString, ((e)localObject2).toUserName });
        }
      }
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < this.hGR.size())
    {
      paramString.add(Integer.valueOf((int)((e)this.hGQ.get(this.hGR.get(i))).hHj));
      i += 1;
    }
    this.hGQ.clear();
    this.hGR.clear();
    v.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[] { Integer.valueOf(paramString.size()) });
    GMTrace.o(17503736561664L, 130413);
    return paramString;
  }
  
  public static class a
  {
    static ad fuB;
    public Condition fuA;
    public ReentrantLock fuz;
    int hEK;
    a hGT;
    
    public a()
    {
      GMTrace.i(3516772909056L, 26202);
      this.fuz = new ReentrantLock();
      this.fuA = this.fuz.newCondition();
      GMTrace.o(3516772909056L, 26202);
    }
    
    public static a a(final m.e parame)
    {
      GMTrace.i(3516907126784L, 26203);
      try
      {
        if (fuB == null)
        {
          localObject = new HandlerThread("big file gen Worker");
          ((HandlerThread)localObject).start();
          fuB = new ad(((HandlerThread)localObject).getLooper());
        }
        Object localObject = new a();
        parame.hHp = ((a)localObject);
        a locala = parame.hHp;
        fuB.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(3512477941760L, 26170);
            long l = System.currentTimeMillis();
            m.a.a locala = new m.a.a();
            locala.hGW = new PString();
            locala.hGX = new PString();
            locala.hGY = new PString();
            locala.hGZ = new PString();
            String str = FileOp.kp(parame.hHg);
            locala.hER = n.GT().a(parame.hHg, str, parame.hEK, true, locala.hGW, locala.hGX, locala.hGY, locala.hGZ, parame.hHi, parame.hHn);
            m.a.this.fuz.lock();
            try
            {
              m.a.this.hGT = locala;
              m.a.this.fuA.signal();
              v.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[] { parame.hHg, Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
              m.a.this.fuz.unlock();
              GMTrace.o(3512477941760L, 26170);
              return;
            }
            finally
            {
              m.a.this.fuz.unlock();
            }
          }
        });
        ((a)localObject).hEK = parame.hEK;
        GMTrace.o(3516907126784L, 26203);
        return (a)localObject;
      }
      finally {}
    }
    
    /* Error */
    public final a GM()
    {
      // Byte code:
      //   0: ldc2_w 94
      //   3: sipush 26204
      //   6: invokestatic 33	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   9: aload_0
      //   10: getfield 38	com/tencent/mm/ah/m$a:fuz	Ljava/util/concurrent/locks/ReentrantLock;
      //   13: invokevirtual 98	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   16: aload_0
      //   17: getfield 100	com/tencent/mm/ah/m$a:hGT	Lcom/tencent/mm/ah/m$a$a;
      //   20: ifnonnull +46 -> 66
      //   23: ldc 102
      //   25: ldc 104
      //   27: invokestatic 109	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   30: aload_0
      //   31: getfield 44	com/tencent/mm/ah/m$a:fuA	Ljava/util/concurrent/locks/Condition;
      //   34: invokeinterface 114 1 0
      //   39: goto -23 -> 16
      //   42: astore_1
      //   43: aload_0
      //   44: getfield 38	com/tencent/mm/ah/m$a:fuz	Ljava/util/concurrent/locks/ReentrantLock;
      //   47: invokevirtual 117	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   50: aload_0
      //   51: getfield 100	com/tencent/mm/ah/m$a:hGT	Lcom/tencent/mm/ah/m$a$a;
      //   54: astore_1
      //   55: ldc2_w 94
      //   58: sipush 26204
      //   61: invokestatic 47	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   64: aload_1
      //   65: areturn
      //   66: aload_0
      //   67: getfield 38	com/tencent/mm/ah/m$a:fuz	Ljava/util/concurrent/locks/ReentrantLock;
      //   70: invokevirtual 117	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   73: goto -23 -> 50
      //   76: astore_1
      //   77: aload_0
      //   78: getfield 38	com/tencent/mm/ah/m$a:fuz	Ljava/util/concurrent/locks/ReentrantLock;
      //   81: invokevirtual 117	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   84: aload_1
      //   85: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	86	0	this	a
      //   42	1	1	localException	Exception
      //   54	11	1	locala	a
      //   76	9	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   16	39	42	java/lang/Exception
      //   16	39	76	finally
    }
    
    public static final class a
    {
      String hER;
      PString hGW;
      PString hGX;
      PString hGY;
      PString hGZ;
      
      public a()
      {
        GMTrace.i(3534892302336L, 26337);
        GMTrace.o(3534892302336L, 26337);
      }
    }
  }
  
  private static final class b
  {
    b hHa;
    String hHb;
    
    public b()
    {
      GMTrace.i(3516101820416L, 26197);
      GMTrace.o(3516101820416L, 26197);
    }
  }
  
  public static final class c
  {
    public LinkedList<m.b> hHc;
    public LinkedList<m.b> hHd;
    
    public c()
    {
      GMTrace.i(3513820119040L, 26180);
      this.hHc = new LinkedList();
      this.hHd = new LinkedList();
      GMTrace.o(3513820119040L, 26180);
    }
    
    private void GO()
    {
      for (;;)
      {
        int i;
        try
        {
          GMTrace.i(3514625425408L, 26186);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.hHc.size())
          {
            localStringBuilder.append(((m.b)this.hHc.get(i)).hHb);
            if (i != this.hHc.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            v.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.h.vI().vr().set(348176, localStringBuilder.toString());
            GMTrace.o(3514625425408L, 26186);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private void GP()
    {
      for (;;)
      {
        int i;
        try
        {
          GMTrace.i(3514759643136L, 26187);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.hHd.size())
          {
            localStringBuilder.append(((m.b)this.hHd.get(i)).hHb);
            if (i != this.hHd.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            v.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.h.vI().vr().set(348177, localStringBuilder.toString());
            GMTrace.o(3514759643136L, 26187);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    public static m.b jA(String paramString)
    {
      GMTrace.i(3514088554496L, 26182);
      m.b localb = new m.b();
      if (bf.mA(paramString)) {}
      for (localb.hHb = f.GF();; localb.hHb = paramString)
      {
        paramString = n.GT().a(localb.hHb, "", ".jpg", false);
        if (jC(paramString)) {
          break;
        }
        GMTrace.o(3514088554496L, 26182);
        return null;
      }
      localb.hHa = new b(paramString);
      GMTrace.o(3514088554496L, 26182);
      return localb;
    }
    
    public static m.b jB(String paramString)
    {
      GMTrace.i(3514222772224L, 26183);
      m.b localb = new m.b();
      if (bf.mA(paramString)) {}
      for (localb.hHb = f.GF();; localb.hHb = paramString)
      {
        paramString = n.GT();
        String str = localb.hHb;
        paramString = paramString.a("THUMBNAIL_DIRPATH://th_" + str, "th_", "", false);
        if (jC(paramString)) {
          break;
        }
        GMTrace.o(3514222772224L, 26183);
        return null;
      }
      localb.hHa = new b(paramString);
      GMTrace.o(3514222772224L, 26183);
      return localb;
    }
    
    private static boolean jC(String paramString)
    {
      GMTrace.i(3514356989952L, 26184);
      if (FileOp.kj(paramString) > 0L)
      {
        v.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[] { paramString });
        GMTrace.o(3514356989952L, 26184);
        return false;
      }
      GMTrace.o(3514356989952L, 26184);
      return true;
    }
    
    public final void GN()
    {
      int j = 0;
      try
      {
        GMTrace.i(3513954336768L, 26181);
        int i = this.hHc.size();
        int k;
        m.b localb;
        if (i <= 0)
        {
          k = 5 - i;
          i = 0;
          while (i < k)
          {
            localb = jA(null);
            this.hHc.add(localb);
            i += 1;
          }
          v.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.hHc.size()) });
          GO();
        }
        i = this.hHd.size();
        if (i <= 0)
        {
          k = 5 - i;
          i = j;
          while (i < k)
          {
            localb = jB(null);
            this.hHd.add(localb);
            i += 1;
          }
          GP();
          v.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.hHd.size()) });
        }
        GMTrace.o(3513954336768L, 26181);
        return;
      }
      finally {}
    }
    
    public final m.b ga(int paramInt)
    {
      m.b localb1 = null;
      for (;;)
      {
        try
        {
          GMTrace.i(3514491207680L, 26185);
          if (paramInt == 1)
          {
            if (this.hHc.size() > 0)
            {
              localb1 = (m.b)this.hHc.remove();
              GO();
              GN();
              GMTrace.o(3514491207680L, 26185);
              return localb1;
            }
            localb1 = jA(null);
            continue;
          }
          if (paramInt == 2) {
            if (this.hHd.size() > 0)
            {
              localb1 = (m.b)this.hHd.remove();
              GP();
            }
            else
            {
              m.b localb2 = jB(null);
            }
          }
        }
        finally {}
      }
    }
  }
  
  public static final class d
  {
    public long hHe;
    public long hHf;
    
    public d()
    {
      GMTrace.i(3541871624192L, 26389);
      GMTrace.o(3541871624192L, 26389);
    }
  }
  
  public static final class e
  {
    int cFR;
    long fGD;
    int fNs;
    int hEK;
    public String hHg;
    String hHh;
    String hHi;
    long hHj;
    PString hHk;
    PInt hHl;
    PInt hHm;
    b hHn;
    b hHo;
    m.a hHp;
    public String toUserName;
    
    public e()
    {
      GMTrace.i(3512612159488L, 26171);
      GMTrace.o(3512612159488L, 26171);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */