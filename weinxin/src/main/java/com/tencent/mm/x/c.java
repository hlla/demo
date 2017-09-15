package com.tencent.mm.x;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.e;
import com.tencent.mm.u.m;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class c
  implements com.tencent.mm.y.e
{
  public boolean hqr;
  public Set<String> hqs;
  f<String, c> hqt;
  public Stack<h> hqu;
  private aq hqv;
  private aq hqw;
  public String hqx;
  f<String, String> hqy;
  public ai hqz;
  
  public c()
  {
    GMTrace.i(372185759744L, 2773);
    this.hqr = false;
    this.hqs = new HashSet();
    this.hqt = new f(400);
    this.hqu = new Stack();
    this.hqv = null;
    this.hqw = null;
    this.hqx = null;
    this.hqy = new f(200);
    this.hqz = new ai(Looper.getMainLooper(), new ai.a()
    {
      private long hqC;
      
      public final boolean oQ()
      {
        GMTrace.i(379030863872L, 2824);
        long l = System.currentTimeMillis();
        if ((c.this.hqr) && (l - this.hqC > 60000L))
        {
          v.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", new Object[] { Long.valueOf(l - this.hqC) });
          c.this.hqr = false;
        }
        if (c.this.hqr)
        {
          c.this.hqz.v(1000L, 1000L);
          GMTrace.o(379030863872L, 2824);
          return false;
        }
        this.hqC = l;
        c.this.hqr = true;
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while ((i < 5) && (c.this.hqu.size() > 0))
        {
          com.tencent.mm.plugin.report.service.g.oSF.a(138L, 42L, 1L, true);
          localLinkedList.add(new avu().OU(((h)c.this.hqu.pop()).getUsername()));
          i += 1;
        }
        com.tencent.mm.kernel.h.vd().a(new j(localLinkedList), 0);
        com.tencent.mm.plugin.report.service.g.oSF.a(138L, 44L, 1L, true);
        GMTrace.o(379030863872L, 2824);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.h.vd().a(123, this);
    this.hqr = false;
    this.hqx = m.xL();
    GMTrace.o(372185759744L, 2773);
  }
  
  public static d Bl()
  {
    GMTrace.i(373259501568L, 2781);
    if (com.tencent.mm.kernel.h.vG().uV())
    {
      d locald = n.Bl();
      GMTrace.o(373259501568L, 2781);
      return locald;
    }
    GMTrace.o(373259501568L, 2781);
    return null;
  }
  
  public static i Bm()
  {
    GMTrace.i(16085994700800L, 119850);
    if (com.tencent.mm.kernel.h.vG().uV())
    {
      i locali = n.Bm();
      GMTrace.o(16085994700800L, 119850);
      return locali;
    }
    GMTrace.o(16085994700800L, 119850);
    return null;
  }
  
  static h hh(String paramString)
  {
    GMTrace.i(372722630656L, 2777);
    Object localObject = n.Bm().hs(paramString);
    if ((localObject != null) && (((h)localObject).getUsername().equals(paramString)))
    {
      GMTrace.o(372722630656L, 2777);
      return (h)localObject;
    }
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
    if ((localObject == null) || (!((af)localObject).field_username.equals(paramString)))
    {
      if (localObject == null) {}
      for (boolean bool = true;; bool = false)
      {
        v.d("MicroMsg.AvatarService", "ct == null? :%s", new Object[] { Boolean.valueOf(bool), paramString });
        GMTrace.o(372722630656L, 2777);
        return null;
      }
    }
    if (((af)localObject).gkg == 4)
    {
      b.u(paramString, ((af)localObject).gkg);
      v.d("MicroMsg.AvatarService", "ct imgFlag :%s", new Object[] { Integer.valueOf(((af)localObject).gkg) });
      GMTrace.o(372722630656L, 2777);
      return null;
    }
    localObject = new h();
    ((h)localObject).username = paramString;
    ((h)localObject).gkg = 3;
    byte[] arrayOfByte = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rf(paramString);
    if (bf.bm(arrayOfByte))
    {
      GMTrace.o(372722630656L, 2777);
      return (h)localObject;
    }
    try
    {
      paramString = b.a(paramString, (amb)new amb().aD(arrayOfByte));
      GMTrace.o(372722630656L, 2777);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        v.e("MicroMsg.AvatarService", "exception:%s", new Object[] { bf.g(paramString) });
        paramString = (String)localObject;
      }
    }
  }
  
  public final int a(aq.a parama)
  {
    GMTrace.i(372991066112L, 2779);
    if ((parama instanceof a))
    {
      if (this.hqv == null) {
        this.hqv = new aq(1, "getavatar", 2, com.tencent.mm.kernel.h.vL().nIe.getLooper());
      }
      i = this.hqv.c(parama);
      GMTrace.o(372991066112L, 2779);
      return i;
    }
    if (this.hqw == null) {
      this.hqw = new aq(1, "readsave", 1, com.tencent.mm.kernel.h.vL().nIe.getLooper());
    }
    int i = this.hqw.c(parama);
    GMTrace.o(372991066112L, 2779);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(373125283840L, 2780);
    if (paramk.getType() != 123)
    {
      GMTrace.o(373125283840L, 2780);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.g.oSF.a(138L, 12L, 1L, true);
    }
    com.tencent.mm.plugin.report.service.g.oSF.a(138L, 45L, 1L, true);
    paramk = (j)paramk;
    paramString = new HashSet();
    Object localObject;
    if (paramk.hrp != null)
    {
      localObject = paramk.hrp.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aft localaft = (aft)((Iterator)localObject).next();
        String str = localaft.tJo.tXF;
        if ((localaft.tdB == null) || (localaft.tdB.tXD == null) || (localaft.tdB.tXD.sWU == null))
        {
          com.tencent.mm.plugin.report.service.g.oSF.a(138L, 11L, 1L, true);
        }
        else
        {
          paramString.add(str);
          h localh = new h();
          localh.username = str;
          localh.gkg = 3;
          com.tencent.mm.plugin.report.service.g.oSF.a(138L, 43L, 1L, true);
          a(new d(localh, localaft.tdB.tXD.sWU));
        }
      }
    }
    if (paramk.hro != null)
    {
      paramk = paramk.hro.iterator();
      while (paramk.hasNext())
      {
        localObject = ((avu)paramk.next()).tXF;
        if (!paramString.contains(localObject)) {
          this.hqs.remove(localObject);
        }
      }
    }
    this.hqr = false;
    if (this.hqu.size() > 0) {
      this.hqz.v(0L, 0L);
    }
    GMTrace.o(373125283840L, 2780);
  }
  
  public final Bitmap b(String paramString, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(372319977472L, 2774);
    d locald = Bl();
    Object localObject2;
    if (locald != null) {
      if ((paramInt >= 0) && (paramInt > 5))
      {
        localObject2 = d.hj(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        if (localObject2 != null)
        {
          v.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
          GMTrace.o(372319977472L, 2774);
          return (Bitmap)localObject2;
        }
        v.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
    }
    for (Object localObject1 = d.hj(paramString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (paramInt >= 0)
        {
          localObject2 = localObject1;
          if (paramInt > 5)
          {
            v.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
            localObject2 = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject1, false, paramInt);
            locald.c(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }), (Bitmap)localObject2);
          }
        }
        GMTrace.o(372319977472L, 2774);
        return (Bitmap)localObject2;
      }
      if (paramBoolean)
      {
        GMTrace.o(372319977472L, 2774);
        return null;
      }
      v.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", new Object[] { paramString });
      if (this.hqs.contains(paramString))
      {
        GMTrace.o(372319977472L, 2774);
        return null;
      }
      this.hqs.add(paramString);
      a(new b(paramString));
      GMTrace.o(372319977472L, 2774);
      return null;
      localObject2 = null;
      break;
    }
  }
  
  public final void cancel()
  {
    GMTrace.i(372856848384L, 2778);
    while (this.hqu.size() > 0) {
      this.hqs.remove(this.hqu.pop());
    }
    GMTrace.o(372856848384L, 2778);
  }
  
  public final void hf(String paramString)
  {
    GMTrace.i(372454195200L, 2775);
    a(new b(paramString));
    GMTrace.o(372454195200L, 2775);
  }
  
  public final void hg(final String paramString)
  {
    GMTrace.i(372588412928L, 2776);
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(384265355264L, 2863);
        if (bf.mA(paramString))
        {
          GMTrace.o(384265355264L, 2863);
          return;
        }
        if (paramString.equals(c.this.hqx))
        {
          GMTrace.o(384265355264L, 2863);
          return;
        }
        Object localObject = c.Bm();
        if (localObject == null)
        {
          GMTrace.o(384265355264L, 2863);
          return;
        }
        localObject = ((i)localObject).hs(paramString);
        if ((localObject == null) || (!((h)localObject).getUsername().equals(paramString)))
        {
          GMTrace.o(384265355264L, 2863);
          return;
        }
        if (bf.Nz() - ((h)localObject).hrm * 60L > 86400L) {}
        for (int i = 1; i == 0; i = 0)
        {
          GMTrace.o(384265355264L, 2863);
          return;
        }
        if (bf.mA(((h)localObject).Bt()))
        {
          v.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", new Object[] { paramString });
          GMTrace.o(384265355264L, 2863);
          return;
        }
        if (c.Bl() == null)
        {
          GMTrace.o(384265355264L, 2863);
          return;
        }
        d.s(paramString, false);
        d.s(paramString, true);
        c.this.hf(paramString);
        GMTrace.o(384265355264L, 2863);
      }
      
      public final String toString()
      {
        GMTrace.i(384399572992L, 2864);
        String str = super.toString() + "|checkAvatarExpire";
        GMTrace.o(384399572992L, 2864);
        return str;
      }
    });
    GMTrace.o(372588412928L, 2776);
  }
  
  public final String hi(String paramString)
  {
    GMTrace.i(373393719296L, 2782);
    if (bf.mA(paramString))
    {
      GMTrace.o(373393719296L, 2782);
      return "";
    }
    try
    {
      String str1 = String.format("%s%x_%s", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()), paramString.substring(paramString.length() - 24, paramString.length() - 4) });
      this.hqy.put(str1, paramString);
      GMTrace.o(373393719296L, 2782);
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = String.format("%s%x_", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()) });
      }
    }
  }
  
  private final class a
    implements aq.a
  {
    public h hqD;
    public byte[] hqE;
    
    public a(h paramh)
    {
      GMTrace.i(383728484352L, 2859);
      this.hqD = null;
      this.hqE = null;
      this.hqD = paramh;
      GMTrace.o(383728484352L, 2859);
    }
    
    /* Error */
    public final boolean Bn()
    {
      // Byte code:
      //   0: ldc2_w 49
      //   3: sipush 2860
      //   6: invokestatic 30	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   9: aload_0
      //   10: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   13: ifnonnull +14 -> 27
      //   16: ldc2_w 49
      //   19: sipush 2860
      //   22: invokestatic 37	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   25: iconst_0
      //   26: ireturn
      //   27: aload_0
      //   28: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   31: invokevirtual 56	com/tencent/mm/x/h:Bt	()Ljava/lang/String;
      //   34: astore 10
      //   36: ldc 58
      //   38: astore_3
      //   39: invokestatic 64	com/tencent/mm/kernel/h:vG	()Lcom/tencent/mm/kernel/a;
      //   42: invokevirtual 69	com/tencent/mm/kernel/a:uV	()Z
      //   45: ifeq +61 -> 106
      //   48: getstatic 75	com/tencent/mm/protocal/d:sXh	I
      //   51: istore_1
      //   52: invokestatic 64	com/tencent/mm/kernel/h:vG	()Lcom/tencent/mm/kernel/a;
      //   55: pop
      //   56: ldc 77
      //   58: iconst_4
      //   59: anewarray 4	java/lang/Object
      //   62: dup
      //   63: iconst_0
      //   64: iload_1
      //   65: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   68: aastore
      //   69: dup
      //   70: iconst_1
      //   71: invokestatic 87	com/tencent/mm/kernel/a:uH	()I
      //   74: invokestatic 93	com/tencent/mm/a/o:getString	(I)Ljava/lang/String;
      //   77: aastore
      //   78: dup
      //   79: iconst_2
      //   80: invokestatic 99	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
      //   83: invokestatic 105	com/tencent/mm/sdk/platformtools/al:getNetTypeForStat	(Landroid/content/Context;)I
      //   86: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   89: aastore
      //   90: dup
      //   91: iconst_3
      //   92: invokestatic 99	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
      //   95: invokestatic 108	com/tencent/mm/sdk/platformtools/al:getStrength	(Landroid/content/Context;)I
      //   98: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   101: aastore
      //   102: invokestatic 114	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   105: astore_3
      //   106: ldc 116
      //   108: ldc 118
      //   110: iconst_2
      //   111: anewarray 4	java/lang/Object
      //   114: dup
      //   115: iconst_0
      //   116: aload_0
      //   117: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   120: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   123: aastore
      //   124: dup
      //   125: iconst_1
      //   126: aload_3
      //   127: aastore
      //   128: invokestatic 127	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   131: aload_0
      //   132: aconst_null
      //   133: putfield 34	com/tencent/mm/x/c$a:hqE	[B
      //   136: new 129	java/io/ByteArrayOutputStream
      //   139: dup
      //   140: invokespecial 130	java/io/ByteArrayOutputStream:<init>	()V
      //   143: astore 4
      //   145: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   148: ldc2_w 137
      //   151: ldc2_w 139
      //   154: lconst_1
      //   155: iconst_1
      //   156: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   159: aload 10
      //   161: aconst_null
      //   162: invokestatic 148	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/t;
      //   165: astore 5
      //   167: aload 5
      //   169: ldc -106
      //   171: invokevirtual 156	com/tencent/mm/network/t:setRequestMethod	(Ljava/lang/String;)V
      //   174: aload 5
      //   176: ldc -98
      //   178: aload_3
      //   179: invokevirtual 162	com/tencent/mm/network/t:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   182: aload 5
      //   184: sipush 5000
      //   187: invokevirtual 166	com/tencent/mm/network/t:setConnectTimeout	(I)V
      //   190: aload 5
      //   192: sipush 5000
      //   195: invokevirtual 169	com/tencent/mm/network/t:setReadTimeout	(I)V
      //   198: aload 5
      //   200: invokestatic 172	com/tencent/mm/network/b:a	(Lcom/tencent/mm/network/t;)I
      //   203: ifeq +1454 -> 1657
      //   206: aload 5
      //   208: invokevirtual 175	com/tencent/mm/network/t:getResponseCode	()I
      //   211: istore_1
      //   212: aload 5
      //   214: invokevirtual 179	com/tencent/mm/network/t:getHeaderFields	()Ljava/util/Map;
      //   217: astore_3
      //   218: aload_3
      //   219: ifnull +228 -> 447
      //   222: aload_3
      //   223: ldc -75
      //   225: invokeinterface 187 2 0
      //   230: checkcast 189	java/util/List
      //   233: astore_3
      //   234: aload_3
      //   235: ifnull +217 -> 452
      //   238: aload_3
      //   239: invokeinterface 192 1 0
      //   244: ifle +208 -> 452
      //   247: aload_3
      //   248: iconst_0
      //   249: invokeinterface 195 2 0
      //   254: checkcast 110	java/lang/String
      //   257: astore_3
      //   258: ldc 116
      //   260: ldc -59
      //   262: iconst_3
      //   263: anewarray 4	java/lang/Object
      //   266: dup
      //   267: iconst_0
      //   268: aload 10
      //   270: aastore
      //   271: dup
      //   272: iconst_1
      //   273: iload_1
      //   274: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   277: aastore
      //   278: dup
      //   279: iconst_2
      //   280: aload_3
      //   281: aastore
      //   282: invokestatic 200	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   285: iload_1
      //   286: lookupswitch	default:+2021->2307, 404:+172->458, 502:+500->786, 503:+791->1077, 504:+1082->1368
      //   328: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   331: ldc2_w 137
      //   334: ldc2_w 201
      //   337: lconst_1
      //   338: iconst_1
      //   339: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   342: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   345: sipush 14058
      //   348: bipush 10
      //   350: anewarray 4	java/lang/Object
      //   353: dup
      //   354: iconst_0
      //   355: ldc -53
      //   357: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   360: aastore
      //   361: dup
      //   362: iconst_1
      //   363: iload_1
      //   364: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   367: aastore
      //   368: dup
      //   369: iconst_2
      //   370: ldc 58
      //   372: aastore
      //   373: dup
      //   374: iconst_3
      //   375: iconst_0
      //   376: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   379: aastore
      //   380: dup
      //   381: iconst_4
      //   382: aload_0
      //   383: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   386: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   389: aastore
      //   390: dup
      //   391: iconst_5
      //   392: aload 5
      //   394: getfield 207	com/tencent/mm/network/t:ieG	Ljava/lang/String;
      //   397: aastore
      //   398: dup
      //   399: bipush 6
      //   401: aload 5
      //   403: getfield 210	com/tencent/mm/network/t:idK	I
      //   406: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   409: aastore
      //   410: dup
      //   411: bipush 7
      //   413: aload 5
      //   415: getfield 214	com/tencent/mm/network/t:url	Ljava/net/URL;
      //   418: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
      //   421: aastore
      //   422: dup
      //   423: bipush 8
      //   425: aload 10
      //   427: aastore
      //   428: dup
      //   429: bipush 9
      //   431: aload_3
      //   432: aastore
      //   433: invokevirtual 222	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
      //   436: ldc2_w 49
      //   439: sipush 2860
      //   442: invokestatic 37	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   445: iconst_1
      //   446: ireturn
      //   447: aconst_null
      //   448: astore_3
      //   449: goto -215 -> 234
      //   452: ldc 58
      //   454: astore_3
      //   455: goto -197 -> 258
      //   458: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   461: ldc2_w 137
      //   464: ldc2_w 223
      //   467: lconst_1
      //   468: iconst_1
      //   469: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   472: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   475: sipush 14058
      //   478: bipush 10
      //   480: anewarray 4	java/lang/Object
      //   483: dup
      //   484: iconst_0
      //   485: ldc -53
      //   487: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   490: aastore
      //   491: dup
      //   492: iconst_1
      //   493: iload_1
      //   494: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   497: aastore
      //   498: dup
      //   499: iconst_2
      //   500: ldc 58
      //   502: aastore
      //   503: dup
      //   504: iconst_3
      //   505: iconst_0
      //   506: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   509: aastore
      //   510: dup
      //   511: iconst_4
      //   512: aload_0
      //   513: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   516: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   519: aastore
      //   520: dup
      //   521: iconst_5
      //   522: aload 5
      //   524: getfield 207	com/tencent/mm/network/t:ieG	Ljava/lang/String;
      //   527: aastore
      //   528: dup
      //   529: bipush 6
      //   531: aload 5
      //   533: getfield 210	com/tencent/mm/network/t:idK	I
      //   536: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   539: aastore
      //   540: dup
      //   541: bipush 7
      //   543: aload 5
      //   545: getfield 214	com/tencent/mm/network/t:url	Ljava/net/URL;
      //   548: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
      //   551: aastore
      //   552: dup
      //   553: bipush 8
      //   555: aload 10
      //   557: aastore
      //   558: dup
      //   559: bipush 9
      //   561: aload_3
      //   562: aastore
      //   563: invokevirtual 222	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
      //   566: goto -130 -> 436
      //   569: astore 6
      //   571: aconst_null
      //   572: astore_3
      //   573: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   576: ldc2_w 137
      //   579: lconst_1
      //   580: lconst_1
      //   581: iconst_1
      //   582: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   585: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   588: astore 11
      //   590: aload 6
      //   592: invokevirtual 227	java/net/ProtocolException:getMessage	()Ljava/lang/String;
      //   595: astore 12
      //   597: aload_0
      //   598: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   601: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   604: astore 13
      //   606: aload 5
      //   608: ifnonnull +1316 -> 1924
      //   611: ldc -27
      //   613: astore 7
      //   615: aload 5
      //   617: ifnonnull +1317 -> 1934
      //   620: ldc -27
      //   622: astore 8
      //   624: aload 5
      //   626: ifnonnull +1321 -> 1947
      //   629: ldc -27
      //   631: astore 9
      //   633: aload 11
      //   635: sipush 14058
      //   638: bipush 10
      //   640: anewarray 4	java/lang/Object
      //   643: dup
      //   644: iconst_0
      //   645: ldc -53
      //   647: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   650: aastore
      //   651: dup
      //   652: iconst_1
      //   653: sipush 10001
      //   656: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   659: aastore
      //   660: dup
      //   661: iconst_2
      //   662: aload 12
      //   664: aastore
      //   665: dup
      //   666: iconst_3
      //   667: iconst_0
      //   668: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   671: aastore
      //   672: dup
      //   673: iconst_4
      //   674: aload 13
      //   676: aastore
      //   677: dup
      //   678: iconst_5
      //   679: aload 7
      //   681: aastore
      //   682: dup
      //   683: bipush 6
      //   685: aload 8
      //   687: aastore
      //   688: dup
      //   689: bipush 7
      //   691: aload 9
      //   693: aastore
      //   694: dup
      //   695: bipush 8
      //   697: aload 10
      //   699: aastore
      //   700: dup
      //   701: bipush 9
      //   703: ldc 58
      //   705: aastore
      //   706: invokevirtual 222	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
      //   709: ldc 116
      //   711: ldc -25
      //   713: iconst_3
      //   714: anewarray 4	java/lang/Object
      //   717: dup
      //   718: iconst_0
      //   719: aload 10
      //   721: aastore
      //   722: dup
      //   723: iconst_1
      //   724: aload 6
      //   726: invokevirtual 235	java/lang/Object:getClass	()Ljava/lang/Class;
      //   729: invokevirtual 240	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   732: aastore
      //   733: dup
      //   734: iconst_2
      //   735: aload 6
      //   737: invokevirtual 227	java/net/ProtocolException:getMessage	()Ljava/lang/String;
      //   740: aastore
      //   741: invokestatic 200	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   744: aload 5
      //   746: ifnull +11 -> 757
      //   749: aload 5
      //   751: getfield 244	com/tencent/mm/network/t:ieF	Ljava/net/HttpURLConnection;
      //   754: invokevirtual 249	java/net/HttpURLConnection:disconnect	()V
      //   757: aload_3
      //   758: ifnull +7 -> 765
      //   761: aload_3
      //   762: invokevirtual 254	java/io/InputStream:close	()V
      //   765: aload 4
      //   767: ifnull +8 -> 775
      //   770: aload 4
      //   772: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
      //   775: ldc2_w 49
      //   778: sipush 2860
      //   781: invokestatic 37	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   784: iconst_1
      //   785: ireturn
      //   786: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   789: ldc2_w 137
      //   792: ldc2_w 256
      //   795: lconst_1
      //   796: iconst_1
      //   797: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   800: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   803: sipush 14058
      //   806: bipush 10
      //   808: anewarray 4	java/lang/Object
      //   811: dup
      //   812: iconst_0
      //   813: ldc -53
      //   815: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   818: aastore
      //   819: dup
      //   820: iconst_1
      //   821: iload_1
      //   822: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   825: aastore
      //   826: dup
      //   827: iconst_2
      //   828: ldc 58
      //   830: aastore
      //   831: dup
      //   832: iconst_3
      //   833: iconst_0
      //   834: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   837: aastore
      //   838: dup
      //   839: iconst_4
      //   840: aload_0
      //   841: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   844: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   847: aastore
      //   848: dup
      //   849: iconst_5
      //   850: aload 5
      //   852: getfield 207	com/tencent/mm/network/t:ieG	Ljava/lang/String;
      //   855: aastore
      //   856: dup
      //   857: bipush 6
      //   859: aload 5
      //   861: getfield 210	com/tencent/mm/network/t:idK	I
      //   864: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   867: aastore
      //   868: dup
      //   869: bipush 7
      //   871: aload 5
      //   873: getfield 214	com/tencent/mm/network/t:url	Ljava/net/URL;
      //   876: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
      //   879: aastore
      //   880: dup
      //   881: bipush 8
      //   883: aload 10
      //   885: aastore
      //   886: dup
      //   887: bipush 9
      //   889: aload_3
      //   890: aastore
      //   891: invokevirtual 222	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
      //   894: goto -458 -> 436
      //   897: astore 6
      //   899: aconst_null
      //   900: astore_3
      //   901: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   904: ldc2_w 137
      //   907: ldc2_w 258
      //   910: lconst_1
      //   911: iconst_1
      //   912: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   915: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   918: astore 11
      //   920: aload 6
      //   922: invokevirtual 260	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
      //   925: astore 12
      //   927: aload_0
      //   928: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   931: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   934: astore 13
      //   936: aload 5
      //   938: ifnonnull +1022 -> 1960
      //   941: ldc -27
      //   943: astore 7
      //   945: aload 5
      //   947: ifnonnull +1023 -> 1970
      //   950: ldc -27
      //   952: astore 8
      //   954: aload 5
      //   956: ifnonnull +1027 -> 1983
      //   959: ldc -27
      //   961: astore 9
      //   963: aload 11
      //   965: sipush 14058
      //   968: bipush 10
      //   970: anewarray 4	java/lang/Object
      //   973: dup
      //   974: iconst_0
      //   975: ldc -53
      //   977: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   980: aastore
      //   981: dup
      //   982: iconst_1
      //   983: sipush 10002
      //   986: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   989: aastore
      //   990: dup
      //   991: iconst_2
      //   992: aload 12
      //   994: aastore
      //   995: dup
      //   996: iconst_3
      //   997: iconst_0
      //   998: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1001: aastore
      //   1002: dup
      //   1003: iconst_4
      //   1004: aload 13
      //   1006: aastore
      //   1007: dup
      //   1008: iconst_5
      //   1009: aload 7
      //   1011: aastore
      //   1012: dup
      //   1013: bipush 6
      //   1015: aload 8
      //   1017: aastore
      //   1018: dup
      //   1019: bipush 7
      //   1021: aload 9
      //   1023: aastore
      //   1024: dup
      //   1025: bipush 8
      //   1027: aload 10
      //   1029: aastore
      //   1030: dup
      //   1031: bipush 9
      //   1033: ldc 58
      //   1035: aastore
      //   1036: invokevirtual 222	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
      //   1039: ldc 116
      //   1041: ldc -25
      //   1043: iconst_3
      //   1044: anewarray 4	java/lang/Object
      //   1047: dup
      //   1048: iconst_0
      //   1049: aload 10
      //   1051: aastore
      //   1052: dup
      //   1053: iconst_1
      //   1054: aload 6
      //   1056: invokevirtual 235	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1059: invokevirtual 240	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   1062: aastore
      //   1063: dup
      //   1064: iconst_2
      //   1065: aload 6
      //   1067: invokevirtual 260	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
      //   1070: aastore
      //   1071: invokestatic 200	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1074: goto -330 -> 744
      //   1077: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1080: ldc2_w 137
      //   1083: ldc2_w 261
      //   1086: lconst_1
      //   1087: iconst_1
      //   1088: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   1091: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1094: sipush 14058
      //   1097: bipush 10
      //   1099: anewarray 4	java/lang/Object
      //   1102: dup
      //   1103: iconst_0
      //   1104: ldc -53
      //   1106: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1109: aastore
      //   1110: dup
      //   1111: iconst_1
      //   1112: iload_1
      //   1113: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1116: aastore
      //   1117: dup
      //   1118: iconst_2
      //   1119: ldc 58
      //   1121: aastore
      //   1122: dup
      //   1123: iconst_3
      //   1124: iconst_0
      //   1125: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1128: aastore
      //   1129: dup
      //   1130: iconst_4
      //   1131: aload_0
      //   1132: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   1135: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   1138: aastore
      //   1139: dup
      //   1140: iconst_5
      //   1141: aload 5
      //   1143: getfield 207	com/tencent/mm/network/t:ieG	Ljava/lang/String;
      //   1146: aastore
      //   1147: dup
      //   1148: bipush 6
      //   1150: aload 5
      //   1152: getfield 210	com/tencent/mm/network/t:idK	I
      //   1155: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1158: aastore
      //   1159: dup
      //   1160: bipush 7
      //   1162: aload 5
      //   1164: getfield 214	com/tencent/mm/network/t:url	Ljava/net/URL;
      //   1167: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
      //   1170: aastore
      //   1171: dup
      //   1172: bipush 8
      //   1174: aload 10
      //   1176: aastore
      //   1177: dup
      //   1178: bipush 9
      //   1180: aload_3
      //   1181: aastore
      //   1182: invokevirtual 222	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
      //   1185: goto -749 -> 436
      //   1188: astore 6
      //   1190: aconst_null
      //   1191: astore_3
      //   1192: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1195: ldc2_w 137
      //   1198: ldc2_w 263
      //   1201: lconst_1
      //   1202: iconst_1
      //   1203: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   1206: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1209: astore 11
      //   1211: aload 6
      //   1213: invokevirtual 265	java/io/IOException:getMessage	()Ljava/lang/String;
      //   1216: astore 12
      //   1218: aload_0
      //   1219: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   1222: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   1225: astore 13
      //   1227: aload 5
      //   1229: ifnonnull +767 -> 1996
      //   1232: ldc -27
      //   1234: astore 7
      //   1236: aload 5
      //   1238: ifnonnull +768 -> 2006
      //   1241: ldc -27
      //   1243: astore 8
      //   1245: aload 5
      //   1247: ifnonnull +772 -> 2019
      //   1250: ldc -27
      //   1252: astore 9
      //   1254: aload 11
      //   1256: sipush 14058
      //   1259: bipush 10
      //   1261: anewarray 4	java/lang/Object
      //   1264: dup
      //   1265: iconst_0
      //   1266: ldc -53
      //   1268: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1271: aastore
      //   1272: dup
      //   1273: iconst_1
      //   1274: sipush 10003
      //   1277: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1280: aastore
      //   1281: dup
      //   1282: iconst_2
      //   1283: aload 12
      //   1285: aastore
      //   1286: dup
      //   1287: iconst_3
      //   1288: iconst_0
      //   1289: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1292: aastore
      //   1293: dup
      //   1294: iconst_4
      //   1295: aload 13
      //   1297: aastore
      //   1298: dup
      //   1299: iconst_5
      //   1300: aload 7
      //   1302: aastore
      //   1303: dup
      //   1304: bipush 6
      //   1306: aload 8
      //   1308: aastore
      //   1309: dup
      //   1310: bipush 7
      //   1312: aload 9
      //   1314: aastore
      //   1315: dup
      //   1316: bipush 8
      //   1318: aload 10
      //   1320: aastore
      //   1321: dup
      //   1322: bipush 9
      //   1324: ldc 58
      //   1326: aastore
      //   1327: invokevirtual 222	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
      //   1330: ldc 116
      //   1332: ldc -25
      //   1334: iconst_3
      //   1335: anewarray 4	java/lang/Object
      //   1338: dup
      //   1339: iconst_0
      //   1340: aload 10
      //   1342: aastore
      //   1343: dup
      //   1344: iconst_1
      //   1345: aload 6
      //   1347: invokevirtual 235	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1350: invokevirtual 240	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   1353: aastore
      //   1354: dup
      //   1355: iconst_2
      //   1356: aload 6
      //   1358: invokevirtual 265	java/io/IOException:getMessage	()Ljava/lang/String;
      //   1361: aastore
      //   1362: invokestatic 200	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1365: goto -621 -> 744
      //   1368: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1371: ldc2_w 137
      //   1374: ldc2_w 266
      //   1377: lconst_1
      //   1378: iconst_1
      //   1379: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   1382: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1385: sipush 14058
      //   1388: bipush 10
      //   1390: anewarray 4	java/lang/Object
      //   1393: dup
      //   1394: iconst_0
      //   1395: ldc -53
      //   1397: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1400: aastore
      //   1401: dup
      //   1402: iconst_1
      //   1403: iload_1
      //   1404: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1407: aastore
      //   1408: dup
      //   1409: iconst_2
      //   1410: ldc 58
      //   1412: aastore
      //   1413: dup
      //   1414: iconst_3
      //   1415: iconst_0
      //   1416: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1419: aastore
      //   1420: dup
      //   1421: iconst_4
      //   1422: aload_0
      //   1423: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   1426: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   1429: aastore
      //   1430: dup
      //   1431: iconst_5
      //   1432: aload 5
      //   1434: getfield 207	com/tencent/mm/network/t:ieG	Ljava/lang/String;
      //   1437: aastore
      //   1438: dup
      //   1439: bipush 6
      //   1441: aload 5
      //   1443: getfield 210	com/tencent/mm/network/t:idK	I
      //   1446: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1449: aastore
      //   1450: dup
      //   1451: bipush 7
      //   1453: aload 5
      //   1455: getfield 214	com/tencent/mm/network/t:url	Ljava/net/URL;
      //   1458: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
      //   1461: aastore
      //   1462: dup
      //   1463: bipush 8
      //   1465: aload 10
      //   1467: aastore
      //   1468: dup
      //   1469: bipush 9
      //   1471: aload_3
      //   1472: aastore
      //   1473: invokevirtual 222	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
      //   1476: goto -1040 -> 436
      //   1479: astore 6
      //   1481: aconst_null
      //   1482: astore_3
      //   1483: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1486: ldc2_w 137
      //   1489: lconst_0
      //   1490: lconst_1
      //   1491: iconst_1
      //   1492: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   1495: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1498: astore 11
      //   1500: aload 6
      //   1502: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1505: astore 12
      //   1507: aload_0
      //   1508: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   1511: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   1514: astore 13
      //   1516: aload 5
      //   1518: ifnonnull +514 -> 2032
      //   1521: ldc -27
      //   1523: astore 7
      //   1525: aload 5
      //   1527: ifnonnull +515 -> 2042
      //   1530: ldc -27
      //   1532: astore 8
      //   1534: aload 5
      //   1536: ifnonnull +519 -> 2055
      //   1539: ldc -27
      //   1541: astore 9
      //   1543: aload 11
      //   1545: sipush 14058
      //   1548: bipush 10
      //   1550: anewarray 4	java/lang/Object
      //   1553: dup
      //   1554: iconst_0
      //   1555: ldc -53
      //   1557: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1560: aastore
      //   1561: dup
      //   1562: iconst_1
      //   1563: sipush 10003
      //   1566: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1569: aastore
      //   1570: dup
      //   1571: iconst_2
      //   1572: aload 12
      //   1574: aastore
      //   1575: dup
      //   1576: iconst_3
      //   1577: iconst_0
      //   1578: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1581: aastore
      //   1582: dup
      //   1583: iconst_4
      //   1584: aload 13
      //   1586: aastore
      //   1587: dup
      //   1588: iconst_5
      //   1589: aload 7
      //   1591: aastore
      //   1592: dup
      //   1593: bipush 6
      //   1595: aload 8
      //   1597: aastore
      //   1598: dup
      //   1599: bipush 7
      //   1601: aload 9
      //   1603: aastore
      //   1604: dup
      //   1605: bipush 8
      //   1607: aload 10
      //   1609: aastore
      //   1610: dup
      //   1611: bipush 9
      //   1613: ldc 58
      //   1615: aastore
      //   1616: invokevirtual 222	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
      //   1619: ldc 116
      //   1621: ldc -25
      //   1623: iconst_3
      //   1624: anewarray 4	java/lang/Object
      //   1627: dup
      //   1628: iconst_0
      //   1629: aload 10
      //   1631: aastore
      //   1632: dup
      //   1633: iconst_1
      //   1634: aload 6
      //   1636: invokevirtual 235	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1639: invokevirtual 240	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   1642: aastore
      //   1643: dup
      //   1644: iconst_2
      //   1645: aload 6
      //   1647: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1650: aastore
      //   1651: invokestatic 200	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1654: goto -910 -> 744
      //   1657: aload 5
      //   1659: getfield 244	com/tencent/mm/network/t:ieF	Ljava/net/HttpURLConnection;
      //   1662: invokevirtual 271	java/net/HttpURLConnection:getContentLength	()I
      //   1665: istore_1
      //   1666: aload 5
      //   1668: invokevirtual 275	com/tencent/mm/network/t:getInputStream	()Ljava/io/InputStream;
      //   1671: astore_3
      //   1672: aload_3
      //   1673: ifnonnull +31 -> 1704
      //   1676: ldc 116
      //   1678: ldc_w 277
      //   1681: iconst_1
      //   1682: anewarray 4	java/lang/Object
      //   1685: dup
      //   1686: iconst_0
      //   1687: aload 10
      //   1689: aastore
      //   1690: invokestatic 127	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1693: ldc2_w 49
      //   1696: sipush 2860
      //   1699: invokestatic 37	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   1702: iconst_1
      //   1703: ireturn
      //   1704: sipush 1024
      //   1707: newarray <illegal type>
      //   1709: astore 6
      //   1711: aload_3
      //   1712: aload 6
      //   1714: invokevirtual 281	java/io/InputStream:read	([B)I
      //   1717: istore_2
      //   1718: iload_2
      //   1719: iconst_m1
      //   1720: if_icmpeq +15 -> 1735
      //   1723: aload 4
      //   1725: aload 6
      //   1727: iconst_0
      //   1728: iload_2
      //   1729: invokevirtual 285	java/io/ByteArrayOutputStream:write	([BII)V
      //   1732: goto -21 -> 1711
      //   1735: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1738: ldc2_w 137
      //   1741: ldc2_w 286
      //   1744: lconst_1
      //   1745: iconst_1
      //   1746: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   1749: invokestatic 292	com/tencent/mm/sdk/a/b:bIk	()Z
      //   1752: ifeq +100 -> 1852
      //   1755: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1758: sipush 14058
      //   1761: bipush 10
      //   1763: anewarray 4	java/lang/Object
      //   1766: dup
      //   1767: iconst_0
      //   1768: ldc -53
      //   1770: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1773: aastore
      //   1774: dup
      //   1775: iconst_1
      //   1776: sipush 20000
      //   1779: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1782: aastore
      //   1783: dup
      //   1784: iconst_2
      //   1785: ldc 58
      //   1787: aastore
      //   1788: dup
      //   1789: iconst_3
      //   1790: iload_1
      //   1791: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1794: aastore
      //   1795: dup
      //   1796: iconst_4
      //   1797: aload_0
      //   1798: getfield 32	com/tencent/mm/x/c$a:hqD	Lcom/tencent/mm/x/h;
      //   1801: invokevirtual 121	com/tencent/mm/x/h:getUsername	()Ljava/lang/String;
      //   1804: aastore
      //   1805: dup
      //   1806: iconst_5
      //   1807: aload 5
      //   1809: getfield 207	com/tencent/mm/network/t:ieG	Ljava/lang/String;
      //   1812: aastore
      //   1813: dup
      //   1814: bipush 6
      //   1816: aload 5
      //   1818: getfield 210	com/tencent/mm/network/t:idK	I
      //   1821: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1824: aastore
      //   1825: dup
      //   1826: bipush 7
      //   1828: aload 5
      //   1830: getfield 214	com/tencent/mm/network/t:url	Ljava/net/URL;
      //   1833: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
      //   1836: aastore
      //   1837: dup
      //   1838: bipush 8
      //   1840: aload 10
      //   1842: aastore
      //   1843: dup
      //   1844: bipush 9
      //   1846: ldc 58
      //   1848: aastore
      //   1849: invokevirtual 222	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
      //   1852: aload_0
      //   1853: aload 4
      //   1855: invokevirtual 296	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   1858: putfield 34	com/tencent/mm/x/c$a:hqE	[B
      //   1861: aload 4
      //   1863: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
      //   1866: aload 5
      //   1868: getfield 244	com/tencent/mm/network/t:ieF	Ljava/net/HttpURLConnection;
      //   1871: invokevirtual 249	java/net/HttpURLConnection:disconnect	()V
      //   1874: aload_3
      //   1875: invokevirtual 254	java/io/InputStream:close	()V
      //   1878: iload_1
      //   1879: ifle +34 -> 1913
      //   1882: aload_0
      //   1883: getfield 34	com/tencent/mm/x/c$a:hqE	[B
      //   1886: arraylength
      //   1887: iload_1
      //   1888: if_icmpge +25 -> 1913
      //   1891: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   1894: ldc2_w 137
      //   1897: ldc2_w 297
      //   1900: lconst_1
      //   1901: iconst_1
      //   1902: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   1905: ldc 116
      //   1907: ldc_w 300
      //   1910: invokestatic 302	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   1913: aconst_null
      //   1914: astore 5
      //   1916: aconst_null
      //   1917: astore 4
      //   1919: aconst_null
      //   1920: astore_3
      //   1921: goto -1177 -> 744
      //   1924: aload 5
      //   1926: getfield 207	com/tencent/mm/network/t:ieG	Ljava/lang/String;
      //   1929: astore 7
      //   1931: goto -1316 -> 615
      //   1934: aload 5
      //   1936: getfield 210	com/tencent/mm/network/t:idK	I
      //   1939: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1942: astore 8
      //   1944: goto -1320 -> 624
      //   1947: aload 5
      //   1949: getfield 214	com/tencent/mm/network/t:url	Ljava/net/URL;
      //   1952: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
      //   1955: astore 9
      //   1957: goto -1324 -> 633
      //   1960: aload 5
      //   1962: getfield 207	com/tencent/mm/network/t:ieG	Ljava/lang/String;
      //   1965: astore 7
      //   1967: goto -1022 -> 945
      //   1970: aload 5
      //   1972: getfield 210	com/tencent/mm/network/t:idK	I
      //   1975: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1978: astore 8
      //   1980: goto -1026 -> 954
      //   1983: aload 5
      //   1985: getfield 214	com/tencent/mm/network/t:url	Ljava/net/URL;
      //   1988: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
      //   1991: astore 9
      //   1993: goto -1030 -> 963
      //   1996: aload 5
      //   1998: getfield 207	com/tencent/mm/network/t:ieG	Ljava/lang/String;
      //   2001: astore 7
      //   2003: goto -767 -> 1236
      //   2006: aload 5
      //   2008: getfield 210	com/tencent/mm/network/t:idK	I
      //   2011: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2014: astore 8
      //   2016: goto -771 -> 1245
      //   2019: aload 5
      //   2021: getfield 214	com/tencent/mm/network/t:url	Ljava/net/URL;
      //   2024: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
      //   2027: astore 9
      //   2029: goto -775 -> 1254
      //   2032: aload 5
      //   2034: getfield 207	com/tencent/mm/network/t:ieG	Ljava/lang/String;
      //   2037: astore 7
      //   2039: goto -514 -> 1525
      //   2042: aload 5
      //   2044: getfield 210	com/tencent/mm/network/t:idK	I
      //   2047: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2050: astore 8
      //   2052: goto -518 -> 1534
      //   2055: aload 5
      //   2057: getfield 214	com/tencent/mm/network/t:url	Ljava/net/URL;
      //   2060: invokevirtual 219	java/net/URL:getHost	()Ljava/lang/String;
      //   2063: astore 9
      //   2065: goto -522 -> 1543
      //   2068: astore_3
      //   2069: ldc 116
      //   2071: ldc_w 304
      //   2074: iconst_1
      //   2075: anewarray 4	java/lang/Object
      //   2078: dup
      //   2079: iconst_0
      //   2080: aload_3
      //   2081: invokestatic 310	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   2084: aastore
      //   2085: invokestatic 200	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2088: ldc 116
      //   2090: ldc_w 312
      //   2093: iconst_1
      //   2094: anewarray 4	java/lang/Object
      //   2097: dup
      //   2098: iconst_0
      //   2099: aload_3
      //   2100: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   2103: aastore
      //   2104: invokestatic 200	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2107: getstatic 136	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
      //   2110: ldc2_w 137
      //   2113: ldc2_w 313
      //   2116: lconst_1
      //   2117: iconst_1
      //   2118: invokevirtual 143	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
      //   2121: goto -1346 -> 775
      //   2124: astore 6
      //   2126: aconst_null
      //   2127: astore 5
      //   2129: aconst_null
      //   2130: astore_3
      //   2131: goto -648 -> 1483
      //   2134: astore 6
      //   2136: goto -653 -> 1483
      //   2139: astore 6
      //   2141: aconst_null
      //   2142: astore 4
      //   2144: goto -661 -> 1483
      //   2147: astore 6
      //   2149: aconst_null
      //   2150: astore 5
      //   2152: aconst_null
      //   2153: astore 4
      //   2155: goto -672 -> 1483
      //   2158: astore 6
      //   2160: aconst_null
      //   2161: astore 5
      //   2163: aconst_null
      //   2164: astore 4
      //   2166: aconst_null
      //   2167: astore_3
      //   2168: goto -685 -> 1483
      //   2171: astore 6
      //   2173: aconst_null
      //   2174: astore 5
      //   2176: aconst_null
      //   2177: astore_3
      //   2178: goto -986 -> 1192
      //   2181: astore 6
      //   2183: goto -991 -> 1192
      //   2186: astore 6
      //   2188: aconst_null
      //   2189: astore 4
      //   2191: goto -999 -> 1192
      //   2194: astore 6
      //   2196: aconst_null
      //   2197: astore 5
      //   2199: aconst_null
      //   2200: astore 4
      //   2202: goto -1010 -> 1192
      //   2205: astore 6
      //   2207: aconst_null
      //   2208: astore 5
      //   2210: aconst_null
      //   2211: astore 4
      //   2213: aconst_null
      //   2214: astore_3
      //   2215: goto -1023 -> 1192
      //   2218: astore 6
      //   2220: aconst_null
      //   2221: astore 5
      //   2223: aconst_null
      //   2224: astore_3
      //   2225: goto -1324 -> 901
      //   2228: astore 6
      //   2230: goto -1329 -> 901
      //   2233: astore 6
      //   2235: aconst_null
      //   2236: astore 4
      //   2238: goto -1337 -> 901
      //   2241: astore 6
      //   2243: aconst_null
      //   2244: astore 5
      //   2246: aconst_null
      //   2247: astore 4
      //   2249: goto -1348 -> 901
      //   2252: astore 6
      //   2254: aconst_null
      //   2255: astore 5
      //   2257: aconst_null
      //   2258: astore 4
      //   2260: aconst_null
      //   2261: astore_3
      //   2262: goto -1361 -> 901
      //   2265: astore 6
      //   2267: aconst_null
      //   2268: astore 5
      //   2270: aconst_null
      //   2271: astore_3
      //   2272: goto -1699 -> 573
      //   2275: astore 6
      //   2277: aconst_null
      //   2278: astore 4
      //   2280: goto -1707 -> 573
      //   2283: astore 6
      //   2285: aconst_null
      //   2286: astore 5
      //   2288: aconst_null
      //   2289: astore 4
      //   2291: goto -1718 -> 573
      //   2294: astore 6
      //   2296: aconst_null
      //   2297: astore 5
      //   2299: aconst_null
      //   2300: astore 4
      //   2302: aconst_null
      //   2303: astore_3
      //   2304: goto -1731 -> 573
      //   2307: goto -1979 -> 328
      //   2310: astore 6
      //   2312: goto -1739 -> 573
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2315	0	this	a
      //   51	1838	1	i	int
      //   1717	12	2	j	int
      //   38	1883	3	localObject1	Object
      //   2068	32	3	localException1	Exception
      //   2130	174	3	localObject2	Object
      //   143	2158	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      //   165	2133	5	localt	com.tencent.mm.network.t
      //   569	167	6	localProtocolException1	java.net.ProtocolException
      //   897	169	6	localSocketTimeoutException1	java.net.SocketTimeoutException
      //   1188	169	6	localIOException1	java.io.IOException
      //   1479	167	6	localException2	Exception
      //   1709	17	6	arrayOfByte	byte[]
      //   2124	1	6	localException3	Exception
      //   2134	1	6	localException4	Exception
      //   2139	1	6	localException5	Exception
      //   2147	1	6	localException6	Exception
      //   2158	1	6	localException7	Exception
      //   2171	1	6	localIOException2	java.io.IOException
      //   2181	1	6	localIOException3	java.io.IOException
      //   2186	1	6	localIOException4	java.io.IOException
      //   2194	1	6	localIOException5	java.io.IOException
      //   2205	1	6	localIOException6	java.io.IOException
      //   2218	1	6	localSocketTimeoutException2	java.net.SocketTimeoutException
      //   2228	1	6	localSocketTimeoutException3	java.net.SocketTimeoutException
      //   2233	1	6	localSocketTimeoutException4	java.net.SocketTimeoutException
      //   2241	1	6	localSocketTimeoutException5	java.net.SocketTimeoutException
      //   2252	1	6	localSocketTimeoutException6	java.net.SocketTimeoutException
      //   2265	1	6	localProtocolException2	java.net.ProtocolException
      //   2275	1	6	localProtocolException3	java.net.ProtocolException
      //   2283	1	6	localProtocolException4	java.net.ProtocolException
      //   2294	1	6	localProtocolException5	java.net.ProtocolException
      //   2310	1	6	localProtocolException6	java.net.ProtocolException
      //   613	1425	7	str1	String
      //   622	1429	8	localObject3	Object
      //   631	1433	9	str2	String
      //   34	1807	10	str3	String
      //   588	956	11	localg	com.tencent.mm.plugin.report.service.g
      //   595	978	12	str4	String
      //   604	981	13	str5	String
      // Exception table:
      //   from	to	target	type
      //   167	218	569	java/net/ProtocolException
      //   222	234	569	java/net/ProtocolException
      //   238	258	569	java/net/ProtocolException
      //   258	285	569	java/net/ProtocolException
      //   328	436	569	java/net/ProtocolException
      //   458	566	569	java/net/ProtocolException
      //   786	894	569	java/net/ProtocolException
      //   1077	1185	569	java/net/ProtocolException
      //   1368	1476	569	java/net/ProtocolException
      //   1657	1672	569	java/net/ProtocolException
      //   167	218	897	java/net/SocketTimeoutException
      //   222	234	897	java/net/SocketTimeoutException
      //   238	258	897	java/net/SocketTimeoutException
      //   258	285	897	java/net/SocketTimeoutException
      //   328	436	897	java/net/SocketTimeoutException
      //   458	566	897	java/net/SocketTimeoutException
      //   786	894	897	java/net/SocketTimeoutException
      //   1077	1185	897	java/net/SocketTimeoutException
      //   1368	1476	897	java/net/SocketTimeoutException
      //   1657	1672	897	java/net/SocketTimeoutException
      //   167	218	1188	java/io/IOException
      //   222	234	1188	java/io/IOException
      //   238	258	1188	java/io/IOException
      //   258	285	1188	java/io/IOException
      //   328	436	1188	java/io/IOException
      //   458	566	1188	java/io/IOException
      //   786	894	1188	java/io/IOException
      //   1077	1185	1188	java/io/IOException
      //   1368	1476	1188	java/io/IOException
      //   1657	1672	1188	java/io/IOException
      //   167	218	1479	java/lang/Exception
      //   222	234	1479	java/lang/Exception
      //   238	258	1479	java/lang/Exception
      //   258	285	1479	java/lang/Exception
      //   328	436	1479	java/lang/Exception
      //   458	566	1479	java/lang/Exception
      //   786	894	1479	java/lang/Exception
      //   1077	1185	1479	java/lang/Exception
      //   1368	1476	1479	java/lang/Exception
      //   1657	1672	1479	java/lang/Exception
      //   749	757	2068	java/lang/Exception
      //   761	765	2068	java/lang/Exception
      //   770	775	2068	java/lang/Exception
      //   159	167	2124	java/lang/Exception
      //   1676	1693	2134	java/lang/Exception
      //   1704	1711	2134	java/lang/Exception
      //   1711	1718	2134	java/lang/Exception
      //   1723	1732	2134	java/lang/Exception
      //   1735	1852	2134	java/lang/Exception
      //   1852	1866	2134	java/lang/Exception
      //   1866	1874	2139	java/lang/Exception
      //   1874	1878	2147	java/lang/Exception
      //   1882	1913	2158	java/lang/Exception
      //   159	167	2171	java/io/IOException
      //   1676	1693	2181	java/io/IOException
      //   1704	1711	2181	java/io/IOException
      //   1711	1718	2181	java/io/IOException
      //   1723	1732	2181	java/io/IOException
      //   1735	1852	2181	java/io/IOException
      //   1852	1866	2181	java/io/IOException
      //   1866	1874	2186	java/io/IOException
      //   1874	1878	2194	java/io/IOException
      //   1882	1913	2205	java/io/IOException
      //   159	167	2218	java/net/SocketTimeoutException
      //   1676	1693	2228	java/net/SocketTimeoutException
      //   1704	1711	2228	java/net/SocketTimeoutException
      //   1711	1718	2228	java/net/SocketTimeoutException
      //   1723	1732	2228	java/net/SocketTimeoutException
      //   1735	1852	2228	java/net/SocketTimeoutException
      //   1852	1866	2228	java/net/SocketTimeoutException
      //   1866	1874	2233	java/net/SocketTimeoutException
      //   1874	1878	2241	java/net/SocketTimeoutException
      //   1882	1913	2252	java/net/SocketTimeoutException
      //   159	167	2265	java/net/ProtocolException
      //   1866	1874	2275	java/net/ProtocolException
      //   1874	1878	2283	java/net/ProtocolException
      //   1882	1913	2294	java/net/ProtocolException
      //   1676	1693	2310	java/net/ProtocolException
      //   1704	1711	2310	java/net/ProtocolException
      //   1711	1718	2310	java/net/ProtocolException
      //   1723	1732	2310	java/net/ProtocolException
      //   1735	1852	2310	java/net/ProtocolException
      //   1852	1866	2310	java/net/ProtocolException
    }
    
    public final boolean Bo()
    {
      GMTrace.i(383996919808L, 2861);
      if ((this.hqD == null) || (bf.mA(this.hqD.getUsername())))
      {
        GMTrace.o(383996919808L, 2861);
        return false;
      }
      if (bf.bm(this.hqE))
      {
        c.this.hqs.remove(this.hqD.getUsername());
        com.tencent.mm.plugin.report.service.g.oSF.a(138L, 10L, 1L, true);
        GMTrace.o(383996919808L, 2861);
        return false;
      }
      if (ag.a.hlB != null) {
        ag.a.hlB.aH(this.hqE.length, 0);
      }
      c.this.a(new c.d(c.this, this.hqD, this.hqE));
      GMTrace.o(383996919808L, 2861);
      return false;
    }
  }
  
  private final class b
    implements aq.a
  {
    Bitmap hqF;
    String username;
    
    public b(String paramString)
    {
      GMTrace.i(382520524800L, 2850);
      this.username = null;
      this.hqF = null;
      this.username = paramString;
      GMTrace.o(382520524800L, 2850);
    }
    
    public final boolean Bn()
    {
      Context localContext = null;
      Object localObject1 = null;
      int i = 0;
      GMTrace.i(382654742528L, 2851);
      if (bf.mA(this.username))
      {
        GMTrace.o(382654742528L, 2851);
        return false;
      }
      String str1 = this.username;
      boolean bool;
      String str2;
      Object localObject2;
      if (str1 == null)
      {
        bool = false;
        if (bool)
        {
          str2 = (String)c.this.hqy.get(str1);
          if (!bf.mA(str2))
          {
            localObject2 = n.Bm().hs(str1);
            if ((localObject2 == null) || (!str1.equals(((h)localObject2).getUsername())))
            {
              localObject2 = n.Bm();
              String str3 = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bf.my(str2) + "\"";
              localObject2 = ((i)localObject2).hnp.a(str3, null, 2);
              if (localObject2 != null) {
                break label273;
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (!bf.mA(((h)localObject1).getUsername()))) {
          FileOp.p(b.hd(((h)localObject1).getUsername()), b.hd(str1));
        }
        localObject1 = new h();
        ((h)localObject1).username = str1;
        ((h)localObject1).gkg = 3;
        ((h)localObject1).hrj = str2;
        ((h)localObject1).hrk = str2;
        ((h)localObject1).fRM = 3;
        ((h)localObject1).aV(true);
        ((h)localObject1).fRM = 31;
        n.Bm().a((h)localObject1);
        localObject1 = c.Bl();
        if (localObject1 != null) {
          break label318;
        }
        GMTrace.o(382654742528L, 2851);
        return false;
        bool = str1.startsWith("ammURL_");
        break;
        label273:
        localObject1 = localContext;
        if (((Cursor)localObject2).moveToFirst())
        {
          ((Cursor)localObject2).moveToFirst();
          localObject1 = new h();
          ((h)localObject1).b((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
      }
      label318:
      if (d.hqK.containsKey(this.username)) {
        i = ((Integer)d.hqK.get(this.username)).intValue();
      }
      if (i != 0)
      {
        n.Bx();
        localContext = n.getContext();
        if (localContext != null) {
          ((d)localObject1).d(this.username, com.tencent.mm.compatible.f.a.decodeResource(localContext.getResources(), i));
        }
      }
      this.hqF = d.hk(this.username);
      GMTrace.o(382654742528L, 2851);
      return true;
    }
    
    public final boolean Bo()
    {
      GMTrace.i(382788960256L, 2852);
      if (this.hqF == null)
      {
        c localc = c.this;
        String str = this.username;
        v.d("MicroMsg.AvatarService", "avatar service push: %s", new Object[] { str });
        if (bf.mA(str))
        {
          localObject = null;
          if (localObject != null) {
            break label465;
          }
          localc.hqs.remove(str);
        }
        for (;;)
        {
          GMTrace.o(382788960256L, 2852);
          return false;
          if ((str.equals(localc.hqx + "@bottle")) && (!bf.b((Boolean)com.tencent.mm.kernel.h.vI().vr().get(60, null), false)))
          {
            localObject = null;
            break;
          }
          if ((str.equals(localc.hqx)) && (!bf.b((Boolean)com.tencent.mm.kernel.h.vI().vr().get(59, null), false)))
          {
            localObject = null;
            break;
          }
          long l = bf.Nz();
          c.c localc1 = (c.c)localc.hqt.get(str);
          if ((localc1 != null) && (localc1.hqG >= 5) && (l - localc1.hnB < 600L))
          {
            v.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", new Object[] { str });
            localObject = null;
            break;
          }
          localObject = c.hh(str);
          if (localObject == null)
          {
            v.w("MicroMsg.AvatarService", "checkUser block local no need: %s", new Object[] { str });
            localObject = new c.c();
            ((c.c)localObject).hqG = 5;
            ((c.c)localObject).hnB = l;
            localc.hqt.k(str, localObject);
            localObject = null;
            break;
          }
          if ((localc1 == null) || (l - localc1.hnB > 600L))
          {
            v.d("MicroMsg.AvatarService", "new user: %s", new Object[] { str });
            localc1 = new c.c();
            localc1.hqG = 1;
            localc1.hnB = l;
            localc.hqt.k(str, localc1);
          }
          for (;;)
          {
            break;
            if (localc1.hqG < 5)
            {
              v.d("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", new Object[] { str, Integer.valueOf(localc1.hqG), Long.valueOf(l - localc1.hnB) });
              localc1.hqG += 1;
              localc1.hnB = l;
              localc.hqt.k(str, localc1);
            }
          }
          label465:
          if (!bf.mA(((h)localObject).Bt()))
          {
            localc.a(new c.a(localc, (h)localObject));
          }
          else
          {
            v.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", new Object[] { str, Integer.valueOf(((h)localObject).gkg) });
            if (4 == ((h)localObject).gkg)
            {
              v.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
            }
            else
            {
              localc.hqu.push(localObject);
              if (localc.hqu.size() > 5) {
                localc.hqz.v(0L, 0L);
              } else {
                localc.hqz.v(1000L, 1000L);
              }
            }
          }
        }
      }
      Object localObject = c.Bl();
      if (localObject != null) {
        ((d)localObject).c(this.username, this.hqF);
      }
      c.this.hqs.remove(this.username);
      GMTrace.o(382788960256L, 2852);
      return false;
    }
  }
  
  private static final class c
  {
    public long hnB;
    public int hqG;
    
    public c()
    {
      GMTrace.i(380238823424L, 2833);
      this.hnB = 0L;
      this.hqG = 0;
      GMTrace.o(380238823424L, 2833);
    }
  }
  
  private final class d
    implements aq.a
  {
    Bitmap bitmap;
    byte[] buf;
    h hqH;
    
    public d(h paramh, byte[] paramArrayOfByte)
    {
      GMTrace.i(393392160768L, 2931);
      this.hqH = null;
      this.bitmap = null;
      this.hqH = paramh;
      this.buf = paramArrayOfByte;
      GMTrace.o(393392160768L, 2931);
    }
    
    public final boolean Bn()
    {
      GMTrace.i(393526378496L, 2932);
      if ((this.hqH == null) || (bf.mA(this.hqH.getUsername())))
      {
        v.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
        com.tencent.mm.plugin.report.service.g.oSF.a(138L, 13L, 1L, true);
        GMTrace.o(393526378496L, 2932);
        return false;
      }
      if (c.Bl() != null)
      {
        this.bitmap = d.f(this.hqH.getUsername(), this.buf);
        if (this.bitmap == null) {
          com.tencent.mm.plugin.report.service.g.oSF.a(138L, 14L, 1L, true);
        }
      }
      i locali = c.Bm();
      if (locali != null)
      {
        this.hqH.fRM = -1;
        this.hqH.Bu();
        locali.a(this.hqH);
      }
      GMTrace.o(393526378496L, 2932);
      return true;
    }
    
    public final boolean Bo()
    {
      GMTrace.i(393660596224L, 2933);
      if (bf.mA(this.hqH.getUsername()))
      {
        GMTrace.o(393660596224L, 2933);
        return false;
      }
      d locald = c.Bl();
      if ((locald != null) && (this.bitmap != null)) {
        locald.c(this.hqH.getUsername(), this.bitmap);
      }
      c.this.hqs.remove(this.hqH.getUsername());
      GMTrace.o(393660596224L, 2933);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */