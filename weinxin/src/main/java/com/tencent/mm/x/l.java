package com.tencent.mm.x;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bhj;
import com.tencent.mm.protocal.c.bhk;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;

public final class l
  extends k
  implements j
{
  private String fNR;
  private com.tencent.mm.y.e gUt;
  private int hrb;
  private int hrc;
  private int hrd;
  private String hrt;
  private String hru;
  private String hrv;
  
  public l(int paramInt, String paramString)
  {
    GMTrace.i(375138549760L, 2795);
    this.hrv = m.xL();
    if (paramInt == 2) {
      this.hrv = x.QQ(this.hrv);
    }
    n.Bl();
    this.hrt = d.r(this.hrv, true);
    String str = this.hrt + ".tmp";
    if (T(paramString, str) == 0)
    {
      this.fNR = str;
      this.hrd = paramInt;
      n.Bl();
      this.hru = g.n(FileOp.c(d.r(this.hrv, true), 0, -1));
      this.hrb = 0;
      this.hrc = 0;
    }
    GMTrace.o(375138549760L, 2795);
  }
  
  /* Error */
  private static int T(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc2_w 105
    //   3: sipush 2794
    //   6: invokestatic 30	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: invokestatic 112	com/tencent/mm/sdk/platformtools/d:Pd	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   13: astore_3
    //   14: aload_3
    //   15: getfield 117	android/graphics/BitmapFactory$Options:outHeight	I
    //   18: sipush 640
    //   21: if_icmpge +61 -> 82
    //   24: aload_3
    //   25: getfield 120	android/graphics/BitmapFactory$Options:outWidth	I
    //   28: sipush 640
    //   31: if_icmpge +51 -> 82
    //   34: aload_0
    //   35: aload_1
    //   36: invokestatic 124	com/tencent/mm/modelsfs/FileOp:p	(Ljava/lang/String;Ljava/lang/String;)J
    //   39: pop2
    //   40: ldc 126
    //   42: ldc -128
    //   44: iconst_2
    //   45: anewarray 130	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_3
    //   51: getfield 117	android/graphics/BitmapFactory$Options:outHeight	I
    //   54: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: aload_3
    //   61: getfield 120	android/graphics/BitmapFactory$Options:outWidth	I
    //   64: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: invokestatic 142	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: ldc2_w 105
    //   74: sipush 2794
    //   77: invokestatic 99	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_3
    //   83: getfield 120	android/graphics/BitmapFactory$Options:outWidth	I
    //   86: sipush 640
    //   89: idiv
    //   90: aload_3
    //   91: getfield 117	android/graphics/BitmapFactory$Options:outHeight	I
    //   94: sipush 640
    //   97: idiv
    //   98: invokestatic 148	java/lang/Math:max	(II)I
    //   101: istore_2
    //   102: ldc 126
    //   104: ldc -106
    //   106: iconst_3
    //   107: anewarray 130	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_3
    //   113: getfield 120	android/graphics/BitmapFactory$Options:outWidth	I
    //   116: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: aload_3
    //   123: getfield 117	android/graphics/BitmapFactory$Options:outHeight	I
    //   126: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aastore
    //   130: dup
    //   131: iconst_2
    //   132: iload_2
    //   133: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: aastore
    //   137: invokestatic 153	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: new 114	android/graphics/BitmapFactory$Options
    //   143: dup
    //   144: invokespecial 154	android/graphics/BitmapFactory$Options:<init>	()V
    //   147: astore_3
    //   148: aload_3
    //   149: getstatic 160	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   152: putfield 163	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   155: aload_3
    //   156: iload_2
    //   157: putfield 166	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   160: aload_0
    //   161: aload_3
    //   162: invokestatic 170	com/tencent/mm/sdk/platformtools/d:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   165: astore_0
    //   166: aload_0
    //   167: ifnonnull +38 -> 205
    //   170: ldc 126
    //   172: ldc -84
    //   174: iconst_1
    //   175: anewarray 130	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: iload_2
    //   181: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokestatic 175	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: invokestatic 181	com/tencent/mm/compatible/util/g:sb	()I
    //   191: istore_2
    //   192: ldc2_w 105
    //   195: sipush 2794
    //   198: invokestatic 99	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   201: iconst_0
    //   202: iload_2
    //   203: isub
    //   204: ireturn
    //   205: ldc 126
    //   207: ldc -73
    //   209: iconst_2
    //   210: anewarray 130	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_0
    //   216: invokevirtual 188	android/graphics/Bitmap:getWidth	()I
    //   219: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: aload_0
    //   226: invokevirtual 191	android/graphics/Bitmap:getHeight	()I
    //   229: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: invokestatic 153	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: aload_0
    //   237: sipush 640
    //   240: sipush 640
    //   243: iconst_1
    //   244: invokestatic 195	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   247: astore 4
    //   249: aload_0
    //   250: aload 4
    //   252: if_acmpeq +25 -> 277
    //   255: ldc 126
    //   257: ldc -59
    //   259: iconst_1
    //   260: anewarray 130	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: aload_0
    //   266: invokevirtual 198	java/lang/Object:toString	()Ljava/lang/String;
    //   269: aastore
    //   270: invokestatic 200	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: aload_0
    //   274: invokevirtual 203	android/graphics/Bitmap:recycle	()V
    //   277: aload 4
    //   279: ifnonnull +27 -> 306
    //   282: ldc 126
    //   284: ldc -51
    //   286: invokestatic 208	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: invokestatic 181	com/tencent/mm/compatible/util/g:sb	()I
    //   292: istore_2
    //   293: ldc2_w 105
    //   296: sipush 2794
    //   299: invokestatic 99	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   302: iconst_0
    //   303: iload_2
    //   304: isub
    //   305: ireturn
    //   306: aconst_null
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_0
    //   310: aload_1
    //   311: invokestatic 212	com/tencent/mm/modelsfs/FileOp:gQ	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   314: astore_1
    //   315: aload_1
    //   316: astore_0
    //   317: aload_1
    //   318: astore_3
    //   319: aload 4
    //   321: getstatic 218	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   324: bipush 40
    //   326: aload_1
    //   327: invokevirtual 222	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   330: pop
    //   331: aload_1
    //   332: ifnull +7 -> 339
    //   335: aload_1
    //   336: invokevirtual 227	java/io/OutputStream:close	()V
    //   339: ldc 126
    //   341: ldc -59
    //   343: iconst_1
    //   344: anewarray 130	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: aload 4
    //   351: invokevirtual 198	java/lang/Object:toString	()Ljava/lang/String;
    //   354: aastore
    //   355: invokestatic 200	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   358: aload 4
    //   360: invokevirtual 203	android/graphics/Bitmap:recycle	()V
    //   363: ldc2_w 105
    //   366: sipush 2794
    //   369: invokestatic 99	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   372: iconst_0
    //   373: ireturn
    //   374: astore_1
    //   375: aload_0
    //   376: astore_3
    //   377: ldc 126
    //   379: ldc -27
    //   381: invokestatic 208	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: aload_0
    //   385: astore_3
    //   386: ldc 126
    //   388: ldc -25
    //   390: iconst_1
    //   391: anewarray 130	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload_1
    //   397: invokestatic 237	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   400: aastore
    //   401: invokestatic 175	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: aload_0
    //   405: astore_3
    //   406: ldc 126
    //   408: ldc -59
    //   410: iconst_1
    //   411: anewarray 130	java/lang/Object
    //   414: dup
    //   415: iconst_0
    //   416: aload 4
    //   418: invokevirtual 198	java/lang/Object:toString	()Ljava/lang/String;
    //   421: aastore
    //   422: invokestatic 200	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: aload_0
    //   426: astore_3
    //   427: aload 4
    //   429: invokevirtual 203	android/graphics/Bitmap:recycle	()V
    //   432: aload_0
    //   433: astore_3
    //   434: invokestatic 181	com/tencent/mm/compatible/util/g:sb	()I
    //   437: istore_2
    //   438: aload_0
    //   439: ifnull +7 -> 446
    //   442: aload_0
    //   443: invokevirtual 227	java/io/OutputStream:close	()V
    //   446: ldc2_w 105
    //   449: sipush 2794
    //   452: invokestatic 99	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   455: iconst_0
    //   456: iload_2
    //   457: isub
    //   458: ireturn
    //   459: astore_0
    //   460: aload_3
    //   461: ifnull +7 -> 468
    //   464: aload_3
    //   465: invokevirtual 227	java/io/OutputStream:close	()V
    //   468: aload_0
    //   469: athrow
    //   470: astore_0
    //   471: goto -132 -> 339
    //   474: astore_0
    //   475: goto -29 -> 446
    //   478: astore_1
    //   479: goto -11 -> 468
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	paramString1	String
    //   0	482	1	paramString2	String
    //   101	357	2	i	int
    //   13	452	3	localObject	Object
    //   247	181	4	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   310	315	374	java/lang/Exception
    //   319	331	374	java/lang/Exception
    //   310	315	459	finally
    //   319	331	459	finally
    //   377	384	459	finally
    //   386	404	459	finally
    //   406	425	459	finally
    //   427	432	459	finally
    //   434	438	459	finally
    //   335	339	470	java/io/IOException
    //   442	446	474	java/io/IOException
    //   464	468	478	java/io/IOException
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(375272767488L, 2796);
    this.gUt = parame1;
    if ((this.fNR == null) || (this.fNR.length() == 0))
    {
      v.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
      GMTrace.o(375272767488L, 2796);
      return -1;
    }
    if (!FileOp.aO(this.fNR))
    {
      v.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.fNR);
      GMTrace.o(375272767488L, 2796);
      return -1;
    }
    if (this.hrb == 0) {
      this.hrb = ((int)FileOp.kj(this.fNR));
    }
    int i = Math.min(this.hrb - this.hrc, 8192);
    parame1 = FileOp.c(this.fNR, this.hrc, i);
    if (parame1 == null)
    {
      v.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
      GMTrace.o(375272767488L, 2796);
      return -1;
    }
    v.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(parame1.length), Integer.valueOf(this.hrb) });
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new bhj();
    ((b.a)localObject).hrW = new bhk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
    ((b.a)localObject).hrU = 157;
    ((b.a)localObject).hrX = 46;
    ((b.a)localObject).hrY = 1000000046;
    localObject = ((b.a)localObject).BE();
    bhj localbhj = (bhj)((b)localObject).hrS.hsa;
    localbhj.tfd = this.hrb;
    localbhj.tfe = this.hrc;
    localbhj.tDl = this.hrd;
    localbhj.tqC = new avt().bb(parame1);
    localbhj.ufk = this.hru;
    i = a(parame, (p)localObject, this);
    GMTrace.o(375272767488L, 2796);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(375406985216L, 2797);
    if ((this.fNR == null) || (this.fNR.length() == 0))
    {
      i = k.b.hsD;
      GMTrace.o(375406985216L, 2797);
      return i;
    }
    int i = k.b.hsC;
    GMTrace.o(375406985216L, 2797);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(375675420672L, 2799);
    paramArrayOfByte = (bhk)((b)paramp).hrT.hsa;
    v.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(375675420672L, 2799);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      v.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:" + paramInt2);
      GMTrace.o(375675420672L, 2799);
      return;
    }
    paramInt1 = paramp.zg().sXW;
    if (paramInt1 == -4) {
      v.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      v.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(375675420672L, 2799);
      return;
    }
    this.hrc = paramArrayOfByte.tfe;
    if (this.hrc < this.hrb)
    {
      if (a(this.hsm, this.gUt) < 0)
      {
        v.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
        this.gUt.a(3, -1, "", this);
      }
      v.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
      GMTrace.o(375675420672L, 2799);
      return;
    }
    try
    {
      FileOp.aj(this.fNR, this.hrt);
      com.tencent.mm.kernel.h.vI().vr().set(12297, paramArrayOfByte.ufl);
      n.Bl().d(this.hrv, com.tencent.mm.sdk.platformtools.d.Pf(this.hrt));
      paramp = m.xL();
      if (!bf.mA(paramp))
      {
        paramArrayOfByte = new h();
        paramArrayOfByte.username = paramp;
        paramArrayOfByte.aV(true);
        paramArrayOfByte.fRM = 32;
        paramArrayOfByte.gkg = 3;
        paramArrayOfByte.fRM = 34;
        n.Bm().a(paramArrayOfByte);
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(375675420672L, 2799);
      return;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + paramString.getMessage());
      this.gUt.a(3, -1, "", this);
      GMTrace.o(375675420672L, 2799);
    }
  }
  
  protected final void cancel()
  {
    GMTrace.i(375809638400L, 2800);
    super.cancel();
    GMTrace.o(375809638400L, 2800);
  }
  
  public final int getType()
  {
    GMTrace.i(375943856128L, 2801);
    GMTrace.o(375943856128L, 2801);
    return 157;
  }
  
  protected final int ub()
  {
    GMTrace.i(375541202944L, 2798);
    GMTrace.o(375541202944L, 2798);
    return 200;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */