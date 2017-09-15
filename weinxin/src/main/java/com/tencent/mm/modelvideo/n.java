package com.tencent.mm.modelvideo;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.iu;
import com.tencent.mm.e.a.iu.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import java.util.HashMap;

public class n
  implements am
{
  public HashMap<String, a> hZh;
  private c<iu> hZi;
  
  public n()
  {
    GMTrace.i(352321536000L, 2625);
    this.hZi = new c()
    {
      private boolean a(iu paramAnonymousiu)
      {
        GMTrace.i(364803784704L, 2718);
        v.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
        if (paramAnonymousiu == null)
        {
          GMTrace.o(364803784704L, 2718);
          return false;
        }
        String str1 = paramAnonymousiu.fOk.path;
        Object localObject2 = str1;
        Object localObject1 = str1;
        try
        {
          if (str1.endsWith(".tmp"))
          {
            localObject1 = str1;
            localObject2 = str1.substring(0, str1.lastIndexOf(".tmp"));
            localObject1 = localObject2;
            v.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[] { localObject2, paramAnonymousiu.fOk.path });
          }
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          String str2;
          int i;
          String str3;
          String str4;
          long l1;
          long l2;
          String[] arrayOfString;
          int j;
          int k;
          for (;;) {}
        }
        localObject2 = n.this;
        str1 = paramAnonymousiu.fOk.fOl;
        str2 = paramAnonymousiu.fOk.fOm;
        i = paramAnonymousiu.fOk.fOn;
        str3 = paramAnonymousiu.fOk.fOo;
        str4 = paramAnonymousiu.fOk.fOq;
        l1 = paramAnonymousiu.fOk.startTime;
        l2 = paramAnonymousiu.fOk.endTime;
        arrayOfString = paramAnonymousiu.fOk.fOp;
        j = paramAnonymousiu.fOk.fOr;
        k = paramAnonymousiu.fOk.fOs;
        h.vL().D(new n.2((n)localObject2, (String)localObject1, arrayOfString, str1, str2, i, str3, str4, l1, l2, j, k));
        GMTrace.o(364803784704L, 2718);
        return false;
      }
    };
    this.hZh = new HashMap();
    com.tencent.mm.sdk.b.a.uql.b(this.hZi);
    GMTrace.o(352321536000L, 2625);
  }
  
  public static n KU()
  {
    GMTrace.i(352455753728L, 2626);
    n localn = (n)l.o(n.class);
    GMTrace.o(352455753728L, 2626);
    return localn;
  }
  
  public static void bc(int paramInt1, int paramInt2)
  {
    GMTrace.i(16008685289472L, 119274);
    int j;
    int i;
    switch (paramInt2)
    {
    case 3: 
    default: 
      GMTrace.o(16008685289472L, 119274);
      return;
    case 1: 
      j = 101;
      i = 107;
    }
    for (;;)
    {
      i = bf.f((Integer)com.tencent.mm.plugin.report.service.g.a(paramInt1 / 1000, new int[] { 350, 544, 800, 1200, 1600, 2000 }, j, i));
      com.tencent.mm.plugin.report.service.g.oSF.a(422L, i, 1L, false);
      v.i("MicroMsg.SubCoreMediaRpt", "rptIdkey [%d] bitrate [%d] sendScene [%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      GMTrace.o(16008685289472L, 119274);
      return;
      j = 111;
      i = 117;
      continue;
      j = 121;
      i = 127;
      continue;
      j = 131;
      i = 137;
    }
  }
  
  public final void a(final keep_SceneResult paramkeep_SceneResult, final String paramString)
  {
    GMTrace.i(352724189184L, 2628);
    if ((paramkeep_SceneResult == null) || (bf.mA(paramString)))
    {
      GMTrace.o(352724189184L, 2628);
      return;
    }
    h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(362790518784L, 2703);
        n.a locala = (n.a)n.this.hZh.remove(paramString);
        if (locala == null)
        {
          GMTrace.o(362790518784L, 2703);
          return;
        }
        int k = e.aN(locala.hZv);
        com.tencent.mm.plugin.sight.base.a locala2 = d.Ep(locala.hZv);
        com.tencent.mm.plugin.sight.base.a locala1;
        int i;
        if (!bf.mA(locala.hZu))
        {
          locala1 = d.Ep(locala.hZu);
          i = e.aN(locala.hZu);
        }
        while ((locala1 == null) || (locala2 == null))
        {
          v.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[] { locala.hZv });
          GMTrace.o(362790518784L, 2703);
          return;
          i = k;
          locala1 = locala2;
        }
        int m = al.eg(aa.getContext());
        long l1;
        if (paramkeep_SceneResult.field_startTime != 0L)
        {
          l1 = paramkeep_SceneResult.field_startTime;
          if (paramkeep_SceneResult.field_endTime == 0L) {
            break label266;
          }
        }
        label266:
        for (long l2 = paramkeep_SceneResult.field_endTime;; l2 = bf.NA())
        {
          localObject1 = null;
          if (paramkeep_SceneResult.field_usedSvrIps == null) {
            break label281;
          }
          localObject1 = new StringBuffer();
          localObject2 = paramkeep_SceneResult.field_usedSvrIps;
          int n = localObject2.length;
          int j = 0;
          while (j < n)
          {
            ((StringBuffer)localObject1).append(localObject2[j]).append("|");
            j += 1;
          }
          l1 = locala.startTime;
          break;
        }
        Object localObject1 = ((StringBuffer)localObject1).toString();
        label281:
        Object localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append(locala.toUser).append(",").append(locala.gxv).append(",");
        ((StringBuffer)localObject2).append(m).append(",").append(paramkeep_SceneResult.field_fileId).append(",");
        ((StringBuffer)localObject2).append(paramkeep_SceneResult.field_mp4identifymd5).append(",").append(locala.hZw).append(",");
        ((StringBuffer)localObject2).append(l1).append(",").append(l2).append(",");
        ((StringBuffer)localObject2).append(i).append(",").append(locala1.lKu).append(",");
        ((StringBuffer)localObject2).append(locala1.hzG / 1000).append(",").append(locala1.hzt / 1000).append(",");
        ((StringBuffer)localObject2).append(locala1.nEx).append(",").append(locala1.width).append(",");
        ((StringBuffer)localObject2).append(locala1.height).append(",").append(locala.hZx).append(",");
        ((StringBuffer)localObject2).append(k).append(",").append(locala2.lKu).append(",");
        ((StringBuffer)localObject2).append(locala2.hzG / 1000).append(",").append(locala2.hzt / 1000).append(",");
        ((StringBuffer)localObject2).append(locala2.nEx).append(",").append(locala2.width).append(",");
        ((StringBuffer)localObject2).append(locala2.height).append(",").append(locala.hZy).append(",");
        ((StringBuffer)localObject2).append((String)localObject1).append(",").append(locala1.prU).append(",").append(paramkeep_SceneResult.field_fileUrl);
        v.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[] { ((StringBuffer)localObject2).toString() });
        com.tencent.mm.plugin.report.service.g.oSF.A(13794, ((StringBuffer)localObject2).toString());
        n.bc(locala2.hzG, locala.hZy);
        GMTrace.o(362790518784L, 2703);
      }
    });
    GMTrace.o(352724189184L, 2628);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    GMTrace.i(352589971456L, 2627);
    a locala2 = (a)this.hZh.get(paramString2);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.hZu = paramString1;
    locala1.hZv = paramString2;
    locala1.toUser = paramString3;
    locala1.gxv = paramString4;
    locala1.hZw = paramString5;
    locala1.hZy = paramInt1;
    locala1.hZx = paramInt2;
    locala1.startTime = bf.NA();
    this.hZh.put(paramString2, locala1);
    v.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    GMTrace.o(352589971456L, 2627);
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(353126842368L, 2631);
    GMTrace.o(353126842368L, 2631);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(353261060096L, 2632);
    GMTrace.o(353261060096L, 2632);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(352992624640L, 2630);
    GMTrace.o(352992624640L, 2630);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(353395277824L, 2633);
    GMTrace.o(353395277824L, 2633);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(352858406912L, 2629);
    GMTrace.o(352858406912L, 2629);
    return null;
  }
  
  public final class a
  {
    public String fOq;
    public String gxv;
    public keep_SceneResult hYL;
    public String hZu;
    public String hZv;
    public String hZw;
    public int hZx;
    public int hZy;
    public long startTime;
    public String toUser;
    
    public a()
    {
      GMTrace.i(341449900032L, 2544);
      GMTrace.o(341449900032L, 2544);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */