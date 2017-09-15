package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.t;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aby;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.net.HttpURLConnection;

public final class b
  extends c
{
  public String[] fES;
  public byte[] htw;
  public byte[] idE;
  public byte[] idG;
  public int uin;
  private int uoD;
  private final int uoE;
  public int uoF;
  public com.tencent.mm.sandbox.b.a uoG;
  private a uoH;
  private com.tencent.mm.sandbox.b.a uoI;
  
  public b(int paramInt1, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    GMTrace.i(3586968780800L, 26725);
    this.uoD = 0;
    this.uoE = 5;
    this.uoF = 0;
    this.uoH = null;
    this.uoI = new com.tencent.mm.sandbox.b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, avm paramAnonymousavm)
      {
        GMTrace.i(3585626603520L, 26715);
        if ((paramAnonymousInt1 != 200) || (paramAnonymousInt2 != 0) || ((paramAnonymousavm != null) && (paramAnonymousavm.tXs.tgr != 0)))
        {
          if (!b.this.bHD())
          {
            localObject = b.this;
            int i = ((b)localObject).uoF + 1;
            ((b)localObject).uoF = i;
            if (i < b.this.fES.length * 5)
            {
              b.this.a(b.this.uoG);
              GMTrace.o(3585626603520L, 26715);
              return;
            }
          }
          b.this.uoG.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousavm);
          GMTrace.o(3585626603520L, 26715);
          return;
        }
        Object localObject = (abz)paramAnonymousavm;
        v.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + com.tencent.mm.compatible.util.e.hgi);
        v.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + ((abz)localObject).tfd);
        v.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + ((abz)localObject).tfe);
        v.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + ((abz)localObject).tff);
        if ((((abz)localObject).tff <= 0) || (((abz)localObject).tqC == null))
        {
          v.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
          b.this.uoG.a(paramAnonymousInt1, -1, null);
          GMTrace.o(3585626603520L, 26715);
          return;
        }
        if (((abz)localObject).tqC.tXB != ((abz)localObject).tff)
        {
          v.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + ((abz)localObject).tff + " data buf len = " + ((abz)localObject).tqC.tXB);
          b.this.uoG.a(4, -1, null);
          GMTrace.o(3585626603520L, 26715);
          return;
        }
        if ((((abz)localObject).tfe < 0) || (((abz)localObject).tfe + ((abz)localObject).tff > ((abz)localObject).tfd))
        {
          v.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + ((abz)localObject).tfe + " dataLen = " + ((abz)localObject).tff + " totalLen = " + ((abz)localObject).tfd);
          b.this.uoG.a(4, -1, null);
          GMTrace.o(3585626603520L, 26715);
          return;
        }
        if (((abz)localObject).tfd <= 0)
        {
          v.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + ((abz)localObject).tfd);
          b.this.uoG.a(4, -1, null);
          GMTrace.o(3585626603520L, 26715);
          return;
        }
        paramAnonymousInt1 = com.tencent.mm.a.e.a(c.uoj, b.a(b.this), ".temp", ((abz)localObject).tqC.tXD.toByteArray());
        if (paramAnonymousInt1 != 0)
        {
          v.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : " + paramAnonymousInt1);
          b.this.uoG.a(4, -1, null);
          GMTrace.o(3585626603520L, 26715);
          return;
        }
        b.a(b.this, ((abz)localObject).tff + ((abz)localObject).tfe);
        b.b(b.this, ((abz)localObject).tfd);
        b.this.uoG.cx(((abz)localObject).tfd, ((abz)localObject).tfe);
        if (((abz)localObject).tfe + ((abz)localObject).tff >= ((abz)localObject).tfd)
        {
          try
          {
            if (b.c(b.this).equalsIgnoreCase(g.aV(b.b(b.this))))
            {
              com.tencent.mm.a.e.h(c.uoj, b.d(b.this) + ".temp", b.e(b.this) + ".apk");
              b.this.uoG.a(200, 0, paramAnonymousavm);
              GMTrace.o(3585626603520L, 26715);
              return;
            }
          }
          catch (Exception paramAnonymousavm)
          {
            v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", paramAnonymousavm, "", new Object[0]);
            GMTrace.o(3585626603520L, 26715);
            return;
          }
          v.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
          new File(b.f(b.this)).delete();
          b.this.uoG.a(-1, -1, paramAnonymousavm);
          GMTrace.o(3585626603520L, 26715);
          return;
        }
        b.this.a(b.this.uoG);
        GMTrace.o(3585626603520L, 26715);
      }
      
      public final void cx(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(3586029256704L, 26718);
        GMTrace.o(3586029256704L, 26718);
      }
      
      public final void eq(long paramAnonymousLong)
      {
        GMTrace.i(3585760821248L, 26716);
        b.this.uoG.eq(paramAnonymousLong);
        GMTrace.o(3585760821248L, 26716);
      }
      
      public final void er(long paramAnonymousLong)
      {
        GMTrace.i(3585895038976L, 26717);
        b.this.uoG.er(paramAnonymousLong);
        GMTrace.o(3585895038976L, 26717);
      }
    };
    this.fES = paramArrayOfString;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      this.fES = new String[] { "short.weixin.qq.com" };
    }
    this.uin = paramInt3;
    this.idE = paramArrayOfByte1;
    this.htw = paramArrayOfByte2;
    GMTrace.o(3586968780800L, 26725);
  }
  
  public final void a(com.tencent.mm.sandbox.b.a parama)
  {
    GMTrace.i(3587102998528L, 26726);
    this.uoG = parama;
    int i = this.uoD + 1;
    this.uoD = i;
    if (i > 1000)
    {
      v.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
      this.uoG.a(-1, -1, null);
      GMTrace.o(3587102998528L, 26726);
      return;
    }
    if (!f.G(this.uol))
    {
      v.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", new Object[] { Integer.valueOf(this.uol) });
      parama.a(-1, -1, null);
      GMTrace.o(3587102998528L, 26726);
      return;
    }
    parama = new aby();
    Object localObject = new em();
    ((em)localObject).tgV = d.sXh;
    ((em)localObject).tcg = 0;
    ((em)localObject).lcP = this.uin;
    ((em)localObject).tgU = com.tencent.mm.bd.b.aU(p.rB().getBytes());
    if (((em)localObject).tgU.sWU.length >= 16) {
      ((em)localObject).tgU = ((em)localObject).tgU.xQ(16);
    }
    ((em)localObject).tgW = com.tencent.mm.bd.b.aU(d.DEVICE_TYPE.getBytes());
    if (((em)localObject).tgW.sWU.length >= 132) {
      ((em)localObject).tgW = ((em)localObject).tgW.xQ(132);
    }
    ((em)localObject).tgT = com.tencent.mm.bd.b.aU(this.idE);
    if (((em)localObject).tgT.sWU.length >= 36) {
      ((em)localObject).tgT = ((em)localObject).tgT.xQ(36);
    }
    parama.tXb = ((em)localObject);
    parama.tFN = this.uok;
    parama.tfe = this.uom;
    parama.tfd = this.uol;
    localObject = new a(this.fES[(this.uoF / 5)], this.uoI);
    this.uoH = ((a)localObject);
    ((a)localObject).execute(new aby[] { parama });
    GMTrace.o(3587102998528L, 26726);
  }
  
  public final void cancel()
  {
    GMTrace.i(3587237216256L, 26727);
    v.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.uok);
    if ((this.uoH != null) && (!this.uoH.isCancelled())) {
      this.uoH.cancel(true);
    }
    GMTrace.o(3587237216256L, 26727);
  }
  
  private final class a
    extends AsyncTask<aby, Integer, abz>
  {
    private String host;
    private t ozD;
    private com.tencent.mm.sandbox.b.a uoG;
    private int uoK;
    private PInt uoL;
    
    public a(String paramString, com.tencent.mm.sandbox.b.a parama)
    {
      GMTrace.i(3578781499392L, 26664);
      this.ozD = null;
      this.uoK = 200;
      this.uoL = new PInt();
      this.host = null;
      this.uoG = null;
      this.host = paramString;
      this.uoG = parama;
      GMTrace.o(3578781499392L, 26664);
    }
    
    /* Error */
    private abz a(aby... paramVarArgs)
    {
      // Byte code:
      //   0: ldc2_w 58
      //   3: sipush 26665
      //   6: invokestatic 35	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   9: aload_1
      //   10: arraylength
      //   11: ifeq +9 -> 20
      //   14: aload_1
      //   15: iconst_0
      //   16: aaload
      //   17: ifnonnull +19 -> 36
      //   20: aload_0
      //   21: iconst_m1
      //   22: putfield 39	com/tencent/mm/sandbox/updater/b$a:uoK	I
      //   25: ldc2_w 58
      //   28: sipush 26665
      //   31: invokestatic 51	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   34: aconst_null
      //   35: areturn
      //   36: ldc 61
      //   38: new 63	java/lang/StringBuilder
      //   41: dup
      //   42: ldc 65
      //   44: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   47: aload_1
      //   48: iconst_0
      //   49: aaload
      //   50: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   53: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   56: invokestatic 82	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   59: aload_1
      //   60: iconst_0
      //   61: aaload
      //   62: astore_1
      //   63: new 84	com/tencent/mm/pointers/PByteArray
      //   66: dup
      //   67: invokespecial 85	com/tencent/mm/pointers/PByteArray:<init>	()V
      //   70: astore 6
      //   72: bipush 6
      //   74: istore_2
      //   75: getstatic 91	com/tencent/mm/sdk/a/b:foreground	Z
      //   78: ifeq +6 -> 84
      //   81: bipush 7
      //   83: istore_2
      //   84: aload_1
      //   85: invokevirtual 97	com/tencent/mm/protocal/c/aby:toByteArray	()[B
      //   88: astore_1
      //   89: aload_0
      //   90: getfield 24	com/tencent/mm/sandbox/updater/b$a:uoJ	Lcom/tencent/mm/sandbox/updater/b;
      //   93: getfield 101	com/tencent/mm/sandbox/updater/b:idE	[B
      //   96: astore 7
      //   98: aload_0
      //   99: getfield 24	com/tencent/mm/sandbox/updater/b$a:uoJ	Lcom/tencent/mm/sandbox/updater/b;
      //   102: getfield 104	com/tencent/mm/sandbox/updater/b:htw	[B
      //   105: astore 8
      //   107: invokestatic 109	com/tencent/mm/compatible/d/p:rB	()Ljava/lang/String;
      //   110: astore 9
      //   112: aload_0
      //   113: getfield 24	com/tencent/mm/sandbox/updater/b$a:uoJ	Lcom/tencent/mm/sandbox/updater/b;
      //   116: getfield 112	com/tencent/mm/sandbox/updater/b:uin	I
      //   119: istore_3
      //   120: aload_0
      //   121: getfield 24	com/tencent/mm/sandbox/updater/b$a:uoJ	Lcom/tencent/mm/sandbox/updater/b;
      //   124: getfield 115	com/tencent/mm/sandbox/updater/b:idG	[B
      //   127: astore 10
      //   129: aload_1
      //   130: aload 6
      //   132: aload 7
      //   134: aload 8
      //   136: aload 9
      //   138: iload_3
      //   139: bipush 113
      //   141: iconst_0
      //   142: iconst_0
      //   143: newarray <illegal type>
      //   145: iconst_0
      //   146: newarray <illegal type>
      //   148: aload 10
      //   150: iload_2
      //   151: invokestatic 121	com/tencent/mm/protocal/MMProtocalJni:pack	([BLcom/tencent/mm/pointers/PByteArray;[B[BLjava/lang/String;III[B[B[BI)Z
      //   154: pop
      //   155: aconst_null
      //   156: astore 7
      //   158: aload_0
      //   159: new 63	java/lang/StringBuilder
      //   162: dup
      //   163: ldc 123
      //   165: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   168: aload_0
      //   169: getfield 46	com/tencent/mm/sandbox/updater/b$a:host	Ljava/lang/String;
      //   172: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   175: ldc -128
      //   177: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   180: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   183: aconst_null
      //   184: invokestatic 133	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/t;
      //   187: putfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   190: aload_0
      //   191: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   194: ldc -121
      //   196: invokevirtual 140	com/tencent/mm/network/t:setRequestMethod	(Ljava/lang/String;)V
      //   199: aload_0
      //   200: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   203: invokevirtual 143	com/tencent/mm/network/t:MB	()V
      //   206: aload_0
      //   207: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   210: invokevirtual 146	com/tencent/mm/network/t:MC	()V
      //   213: aload_0
      //   214: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   217: iconst_0
      //   218: invokevirtual 150	com/tencent/mm/network/t:setUseCaches	(Z)V
      //   221: aload_0
      //   222: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   225: ldc -104
      //   227: ldc -102
      //   229: invokevirtual 157	com/tencent/mm/network/t:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   232: aload_0
      //   233: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   236: ldc -97
      //   238: ldc -95
      //   240: invokevirtual 157	com/tencent/mm/network/t:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   243: aload_0
      //   244: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   247: ldc -93
      //   249: ldc -91
      //   251: invokevirtual 157	com/tencent/mm/network/t:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   254: aload_0
      //   255: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   258: ldc -89
      //   260: ldc -87
      //   262: invokevirtual 157	com/tencent/mm/network/t:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   265: aload_0
      //   266: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   269: ldc -85
      //   271: ldc -83
      //   273: invokevirtual 157	com/tencent/mm/network/t:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   276: aload_0
      //   277: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   280: ldc -81
      //   282: ldc -79
      //   284: invokevirtual 157	com/tencent/mm/network/t:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   287: aload_0
      //   288: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   291: sipush 15000
      //   294: invokevirtual 181	com/tencent/mm/network/t:setConnectTimeout	(I)V
      //   297: aload_0
      //   298: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   301: invokevirtual 184	com/tencent/mm/network/t:connect	()V
      //   304: aload_0
      //   305: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   308: invokevirtual 188	com/tencent/mm/network/t:getOutputStream	()Ljava/io/OutputStream;
      //   311: astore_1
      //   312: aload_1
      //   313: aload 6
      //   315: getfield 191	com/tencent/mm/pointers/PByteArray:value	[B
      //   318: invokevirtual 197	java/io/OutputStream:write	([B)V
      //   321: aload_1
      //   322: invokevirtual 200	java/io/OutputStream:flush	()V
      //   325: aload_0
      //   326: getfield 48	com/tencent/mm/sandbox/updater/b$a:uoG	Lcom/tencent/mm/sandbox/b$a;
      //   329: ldc2_w 201
      //   332: aload 6
      //   334: getfield 191	com/tencent/mm/pointers/PByteArray:value	[B
      //   337: arraylength
      //   338: i2l
      //   339: ladd
      //   340: invokeinterface 208 3 0
      //   345: aload_0
      //   346: aload_0
      //   347: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   350: invokevirtual 212	com/tencent/mm/network/t:getResponseCode	()I
      //   353: putfield 39	com/tencent/mm/sandbox/updater/b$a:uoK	I
      //   356: aload_0
      //   357: getfield 39	com/tencent/mm/sandbox/updater/b$a:uoK	I
      //   360: istore_2
      //   361: iload_2
      //   362: sipush 200
      //   365: if_icmpeq +102 -> 467
      //   368: aload_1
      //   369: ifnull +7 -> 376
      //   372: aload_1
      //   373: invokevirtual 215	java/io/OutputStream:close	()V
      //   376: aload_0
      //   377: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   380: ifnull +18 -> 398
      //   383: aload_0
      //   384: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   387: getfield 219	com/tencent/mm/network/t:ieF	Ljava/net/HttpURLConnection;
      //   390: invokevirtual 224	java/net/HttpURLConnection:disconnect	()V
      //   393: aload_0
      //   394: aconst_null
      //   395: putfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   398: ldc2_w 58
      //   401: sipush 26665
      //   404: invokestatic 51	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   407: aconst_null
      //   408: areturn
      //   409: astore_1
      //   410: ldc 61
      //   412: ldc -30
      //   414: iconst_1
      //   415: anewarray 228	java/lang/Object
      //   418: dup
      //   419: iconst_0
      //   420: aload_1
      //   421: invokevirtual 231	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   424: aastore
      //   425: invokestatic 235	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   428: ldc 61
      //   430: aload_1
      //   431: ldc -19
      //   433: iconst_0
      //   434: anewarray 228	java/lang/Object
      //   437: invokestatic 241	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   440: ldc2_w 58
      //   443: sipush 26665
      //   446: invokestatic 51	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   449: aconst_null
      //   450: areturn
      //   451: astore_1
      //   452: ldc 61
      //   454: aload_1
      //   455: ldc -19
      //   457: iconst_0
      //   458: anewarray 228	java/lang/Object
      //   461: invokestatic 241	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   464: goto -88 -> 376
      //   467: aload_0
      //   468: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   471: ldc -13
      //   473: invokevirtual 247	com/tencent/mm/network/t:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   476: astore 6
      //   478: aload_0
      //   479: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   482: invokevirtual 251	com/tencent/mm/network/t:getInputStream	()Ljava/io/InputStream;
      //   485: astore 8
      //   487: ldc2_w 201
      //   490: lstore 4
      //   492: aload 6
      //   494: ifnull +591 -> 1085
      //   497: aload 6
      //   499: ldc -3
      //   501: invokevirtual 259	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   504: ifeq +581 -> 1085
      //   507: new 261	java/util/zip/GZIPInputStream
      //   510: dup
      //   511: aload 8
      //   513: invokespecial 264	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
      //   516: astore 6
      //   518: iconst_1
      //   519: istore_2
      //   520: new 266	java/io/ByteArrayOutputStream
      //   523: dup
      //   524: invokespecial 267	java/io/ByteArrayOutputStream:<init>	()V
      //   527: astore 7
      //   529: sipush 1024
      //   532: newarray <illegal type>
      //   534: astore 9
      //   536: aload 6
      //   538: aload 9
      //   540: invokevirtual 273	java/io/InputStream:read	([B)I
      //   543: istore_3
      //   544: iload_3
      //   545: ifle +22 -> 567
      //   548: aload 7
      //   550: aload 9
      //   552: iconst_0
      //   553: iload_3
      //   554: invokevirtual 276	java/io/ByteArrayOutputStream:write	([BII)V
      //   557: lload 4
      //   559: iload_3
      //   560: i2l
      //   561: ladd
      //   562: lstore 4
      //   564: goto -28 -> 536
      //   567: iload_2
      //   568: ifeq +192 -> 760
      //   571: aload 8
      //   573: invokevirtual 280	java/io/InputStream:markSupported	()Z
      //   576: ifeq +184 -> 760
      //   579: aload 8
      //   581: iconst_1
      //   582: invokevirtual 283	java/io/InputStream:mark	(I)V
      //   585: ldc2_w 201
      //   588: lstore 4
      //   590: aload 8
      //   592: aload 9
      //   594: invokevirtual 273	java/io/InputStream:read	([B)I
      //   597: istore_2
      //   598: iload_2
      //   599: ifle +13 -> 612
      //   602: lload 4
      //   604: iload_2
      //   605: i2l
      //   606: ladd
      //   607: lstore 4
      //   609: goto -19 -> 590
      //   612: aload_0
      //   613: getfield 48	com/tencent/mm/sandbox/updater/b$a:uoG	Lcom/tencent/mm/sandbox/b$a;
      //   616: lload 4
      //   618: invokeinterface 286 3 0
      //   623: new 84	com/tencent/mm/pointers/PByteArray
      //   626: dup
      //   627: invokespecial 85	com/tencent/mm/pointers/PByteArray:<init>	()V
      //   630: astore 8
      //   632: new 84	com/tencent/mm/pointers/PByteArray
      //   635: dup
      //   636: invokespecial 85	com/tencent/mm/pointers/PByteArray:<init>	()V
      //   639: astore 9
      //   641: new 41	com/tencent/mm/pointers/PInt
      //   644: dup
      //   645: invokespecial 42	com/tencent/mm/pointers/PInt:<init>	()V
      //   648: astore 10
      //   650: new 41	com/tencent/mm/pointers/PInt
      //   653: dup
      //   654: iconst_0
      //   655: invokespecial 288	com/tencent/mm/pointers/PInt:<init>	(I)V
      //   658: astore 11
      //   660: aload 8
      //   662: aload 7
      //   664: invokevirtual 289	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   667: aload_0
      //   668: getfield 24	com/tencent/mm/sandbox/updater/b$a:uoJ	Lcom/tencent/mm/sandbox/updater/b;
      //   671: getfield 101	com/tencent/mm/sandbox/updater/b:idE	[B
      //   674: aload 9
      //   676: aload_0
      //   677: getfield 44	com/tencent/mm/sandbox/updater/b$a:uoL	Lcom/tencent/mm/pointers/PInt;
      //   680: aload 10
      //   682: aload 11
      //   684: invokestatic 293	com/tencent/mm/protocal/MMProtocalJni:unpack	(Lcom/tencent/mm/pointers/PByteArray;[B[BLcom/tencent/mm/pointers/PByteArray;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
      //   687: pop
      //   688: new 295	com/tencent/mm/protocal/c/abz
      //   691: dup
      //   692: invokespecial 296	com/tencent/mm/protocal/c/abz:<init>	()V
      //   695: aload 8
      //   697: getfield 191	com/tencent/mm/pointers/PByteArray:value	[B
      //   700: invokevirtual 300	com/tencent/mm/protocal/c/abz:aD	([B)Lcom/tencent/mm/bd/a;
      //   703: checkcast 295	com/tencent/mm/protocal/c/abz
      //   706: astore 7
      //   708: aload_1
      //   709: ifnull +7 -> 716
      //   712: aload_1
      //   713: invokevirtual 215	java/io/OutputStream:close	()V
      //   716: aload 6
      //   718: ifnull +8 -> 726
      //   721: aload 6
      //   723: invokevirtual 301	java/io/InputStream:close	()V
      //   726: aload_0
      //   727: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   730: ifnull +18 -> 748
      //   733: aload_0
      //   734: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   737: getfield 219	com/tencent/mm/network/t:ieF	Ljava/net/HttpURLConnection;
      //   740: invokevirtual 224	java/net/HttpURLConnection:disconnect	()V
      //   743: aload_0
      //   744: aconst_null
      //   745: putfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   748: ldc2_w 58
      //   751: sipush 26665
      //   754: invokestatic 51	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   757: aload 7
      //   759: areturn
      //   760: aload_0
      //   761: getfield 48	com/tencent/mm/sandbox/updater/b$a:uoG	Lcom/tencent/mm/sandbox/b$a;
      //   764: lload 4
      //   766: invokeinterface 286 3 0
      //   771: goto -148 -> 623
      //   774: astore 8
      //   776: aload 6
      //   778: astore 7
      //   780: aload_1
      //   781: astore 6
      //   783: aload 7
      //   785: astore_1
      //   786: aload 8
      //   788: astore 7
      //   790: ldc 61
      //   792: ldc_w 303
      //   795: iconst_1
      //   796: anewarray 228	java/lang/Object
      //   799: dup
      //   800: iconst_0
      //   801: aload 7
      //   803: invokevirtual 231	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   806: aastore
      //   807: invokestatic 235	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   810: ldc 61
      //   812: aload 7
      //   814: ldc -19
      //   816: iconst_0
      //   817: anewarray 228	java/lang/Object
      //   820: invokestatic 241	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   823: aload_0
      //   824: iconst_m1
      //   825: putfield 39	com/tencent/mm/sandbox/updater/b$a:uoK	I
      //   828: aload 6
      //   830: ifnull +8 -> 838
      //   833: aload 6
      //   835: invokevirtual 215	java/io/OutputStream:close	()V
      //   838: aload_1
      //   839: ifnull +7 -> 846
      //   842: aload_1
      //   843: invokevirtual 301	java/io/InputStream:close	()V
      //   846: aload_0
      //   847: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   850: ifnull +18 -> 868
      //   853: aload_0
      //   854: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   857: getfield 219	com/tencent/mm/network/t:ieF	Ljava/net/HttpURLConnection;
      //   860: invokevirtual 224	java/net/HttpURLConnection:disconnect	()V
      //   863: aload_0
      //   864: aconst_null
      //   865: putfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   868: ldc2_w 58
      //   871: sipush 26665
      //   874: invokestatic 51	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   877: aconst_null
      //   878: areturn
      //   879: astore_1
      //   880: ldc 61
      //   882: aload_1
      //   883: ldc -19
      //   885: iconst_0
      //   886: anewarray 228	java/lang/Object
      //   889: invokestatic 241	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   892: goto -176 -> 716
      //   895: astore_1
      //   896: ldc 61
      //   898: aload_1
      //   899: ldc -19
      //   901: iconst_0
      //   902: anewarray 228	java/lang/Object
      //   905: invokestatic 241	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   908: goto -182 -> 726
      //   911: astore 6
      //   913: ldc 61
      //   915: aload 6
      //   917: ldc -19
      //   919: iconst_0
      //   920: anewarray 228	java/lang/Object
      //   923: invokestatic 241	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   926: goto -88 -> 838
      //   929: astore_1
      //   930: ldc 61
      //   932: aload_1
      //   933: ldc -19
      //   935: iconst_0
      //   936: anewarray 228	java/lang/Object
      //   939: invokestatic 241	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   942: goto -96 -> 846
      //   945: astore 6
      //   947: aconst_null
      //   948: astore_1
      //   949: aload_1
      //   950: ifnull +7 -> 957
      //   953: aload_1
      //   954: invokevirtual 215	java/io/OutputStream:close	()V
      //   957: aload 7
      //   959: ifnull +8 -> 967
      //   962: aload 7
      //   964: invokevirtual 301	java/io/InputStream:close	()V
      //   967: aload_0
      //   968: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   971: ifnull +18 -> 989
      //   974: aload_0
      //   975: getfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   978: getfield 219	com/tencent/mm/network/t:ieF	Ljava/net/HttpURLConnection;
      //   981: invokevirtual 224	java/net/HttpURLConnection:disconnect	()V
      //   984: aload_0
      //   985: aconst_null
      //   986: putfield 37	com/tencent/mm/sandbox/updater/b$a:ozD	Lcom/tencent/mm/network/t;
      //   989: aload 6
      //   991: athrow
      //   992: astore_1
      //   993: ldc 61
      //   995: aload_1
      //   996: ldc -19
      //   998: iconst_0
      //   999: anewarray 228	java/lang/Object
      //   1002: invokestatic 241	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1005: goto -48 -> 957
      //   1008: astore_1
      //   1009: ldc 61
      //   1011: aload_1
      //   1012: ldc -19
      //   1014: iconst_0
      //   1015: anewarray 228	java/lang/Object
      //   1018: invokestatic 241	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1021: goto -54 -> 967
      //   1024: astore 6
      //   1026: goto -77 -> 949
      //   1029: astore 8
      //   1031: aload 6
      //   1033: astore 7
      //   1035: aload 8
      //   1037: astore 6
      //   1039: goto -90 -> 949
      //   1042: astore 7
      //   1044: aload 6
      //   1046: astore 8
      //   1048: aload 7
      //   1050: astore 6
      //   1052: aload_1
      //   1053: astore 7
      //   1055: aload 8
      //   1057: astore_1
      //   1058: goto -109 -> 949
      //   1061: astore 7
      //   1063: aconst_null
      //   1064: astore_1
      //   1065: aconst_null
      //   1066: astore 6
      //   1068: goto -278 -> 790
      //   1071: astore 7
      //   1073: aconst_null
      //   1074: astore 8
      //   1076: aload_1
      //   1077: astore 6
      //   1079: aload 8
      //   1081: astore_1
      //   1082: goto -292 -> 790
      //   1085: iconst_0
      //   1086: istore_2
      //   1087: aload 8
      //   1089: astore 6
      //   1091: goto -571 -> 520
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1094	0	this	a
      //   0	1094	1	paramVarArgs	aby[]
      //   74	1013	2	i	int
      //   119	441	3	j	int
      //   490	275	4	l	long
      //   70	764	6	localObject1	Object
      //   911	5	6	localIOException	java.io.IOException
      //   945	45	6	localObject2	Object
      //   1024	8	6	localObject3	Object
      //   1037	53	6	localObject4	Object
      //   96	938	7	localObject5	Object
      //   1042	7	7	localObject6	Object
      //   1053	1	7	arrayOfaby	aby[]
      //   1061	1	7	localException1	Exception
      //   1071	1	7	localException2	Exception
      //   105	591	8	localObject7	Object
      //   774	13	8	localException3	Exception
      //   1029	7	8	localObject8	Object
      //   1046	42	8	localObject9	Object
      //   110	565	9	localObject10	Object
      //   127	554	10	localObject11	Object
      //   658	25	11	localPInt	PInt
      // Exception table:
      //   from	to	target	type
      //   84	155	409	java/lang/Exception
      //   372	376	451	java/io/IOException
      //   520	536	774	java/lang/Exception
      //   536	544	774	java/lang/Exception
      //   548	557	774	java/lang/Exception
      //   571	585	774	java/lang/Exception
      //   590	598	774	java/lang/Exception
      //   612	623	774	java/lang/Exception
      //   623	708	774	java/lang/Exception
      //   760	771	774	java/lang/Exception
      //   712	716	879	java/io/IOException
      //   721	726	895	java/io/IOException
      //   833	838	911	java/io/IOException
      //   842	846	929	java/io/IOException
      //   158	312	945	finally
      //   953	957	992	java/io/IOException
      //   962	967	1008	java/io/IOException
      //   312	361	1024	finally
      //   467	487	1024	finally
      //   497	518	1024	finally
      //   520	536	1029	finally
      //   536	544	1029	finally
      //   548	557	1029	finally
      //   571	585	1029	finally
      //   590	598	1029	finally
      //   612	623	1029	finally
      //   623	708	1029	finally
      //   760	771	1029	finally
      //   790	828	1042	finally
      //   158	312	1061	java/lang/Exception
      //   312	361	1071	java/lang/Exception
      //   467	487	1071	java/lang/Exception
      //   497	518	1071	java/lang/Exception
    }
    
    protected final void onCancelled()
    {
      GMTrace.i(3579049934848L, 26666);
      v.d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
      if (this.ozD != null) {
        this.ozD.ieF.disconnect();
      }
      GMTrace.o(3579049934848L, 26666);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/updater/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */