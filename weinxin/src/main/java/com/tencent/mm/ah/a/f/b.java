package com.tencent.mm.ah.a.f;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.a.c.a;
import com.tencent.mm.ah.a.c.d;
import com.tencent.mm.ah.a.c.e;
import com.tencent.mm.ah.a.c.f;
import com.tencent.mm.ah.a.c.g;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.ah.a.c.j;
import com.tencent.mm.ah.a.c.k;
import com.tencent.mm.ah.a.c.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class b
  implements Runnable
{
  private final com.tencent.mm.ah.a.a.b hHO;
  private final com.tencent.mm.ah.a.b hIZ;
  public final com.tencent.mm.ah.a.a.c hIg;
  private final l hIh;
  private final a hIi;
  private final com.tencent.mm.ah.a.c.b hIj;
  private final f hIk;
  private final j hIl;
  private final e hIn;
  public final com.tencent.mm.ah.a.c hJb;
  private final ad hJc;
  private final i hJd;
  private final g hJe;
  private final k hJf;
  private final d hJg;
  public final String url;
  
  public b(String paramString, com.tencent.mm.ah.a.c paramc, ad paramad, com.tencent.mm.ah.a.a.c paramc1, i parami, j paramj, com.tencent.mm.ah.a.b paramb, g paramg, e parame, d paramd)
  {
    GMTrace.i(13732621058048L, 102316);
    this.url = paramString;
    this.hJb = paramc;
    this.hJc = paramad;
    this.hIZ = paramb;
    this.hJe = paramg;
    this.hHO = this.hIZ.hHO;
    if (paramc1 == null)
    {
      this.hIg = this.hHO.hIg;
      this.hJd = parami;
      if (paramj != null) {
        break label193;
      }
      this.hIl = this.hHO.hIl;
      label88:
      if (this.hIg.hIj == null) {
        break label202;
      }
      this.hIj = this.hIg.hIj;
      label109:
      this.hIh = this.hHO.hIh;
      this.hIi = this.hHO.hIi;
      this.hIk = this.hHO.hIk;
      this.hJf = this.hHO.hIm;
      if (parame != null) {
        break label216;
      }
    }
    label193:
    label202:
    label216:
    for (this.hIn = this.hHO.hIn;; this.hIn = parame)
    {
      this.hJg = paramd;
      GMTrace.o(13732621058048L, 102316);
      return;
      this.hIg = paramc1;
      break;
      this.hIl = paramj;
      break label88;
      this.hIj = this.hHO.hIj;
      break label109;
    }
  }
  
  private void i(String paramString, Bitmap paramBitmap)
  {
    GMTrace.i(13732889493504L, 102318);
    if (this.hIg.hIr)
    {
      v.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", new Object[] { this.url });
      this.hIh.b(paramString, paramBitmap);
    }
    GMTrace.o(13732889493504L, 102318);
  }
  
  public final void ao(long paramLong)
  {
    GMTrace.i(13733157928960L, 102320);
    if (this.hIl != null) {
      this.hIl.ao(paramLong);
    }
    GMTrace.o(13733157928960L, 102320);
  }
  
  public final String jM(String paramString)
  {
    GMTrace.i(13733023711232L, 102319);
    if ((bf.mA(paramString)) || (this.hIg == null))
    {
      GMTrace.o(13733023711232L, 102319);
      return null;
    }
    String str = paramString;
    if (this.hIg.hIQ) {
      str = paramString + "round" + this.hIg.hIR;
    }
    paramString = str + "size" + this.hIg.hIz + this.hIg.hIA;
    GMTrace.o(13733023711232L, 102319);
    return paramString;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc2_w 190
    //   3: ldc -64
    //   5: invokestatic 52	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: aconst_null
    //   9: astore 12
    //   11: new 194	com/tencent/mm/ah/a/d/b
    //   14: dup
    //   15: invokespecial 195	com/tencent/mm/ah/a/d/b:<init>	()V
    //   18: astore 14
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   25: invokevirtual 197	com/tencent/mm/ah/a/f/b:jM	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 17
    //   30: ldc 116
    //   32: ldc -57
    //   34: iconst_1
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   44: aastore
    //   45: invokestatic 124	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   51: lstore 5
    //   53: aload_0
    //   54: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   57: getfield 208	com/tencent/mm/ah/a/a/c:hIy	I
    //   60: istore_3
    //   61: aload_0
    //   62: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   65: getfield 211	com/tencent/mm/ah/a/a/c:hIB	Z
    //   68: istore 9
    //   70: aload_0
    //   71: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   74: getfield 214	com/tencent/mm/ah/a/a/c:fFN	Ljava/lang/String;
    //   77: astore 18
    //   79: ldc 116
    //   81: new 154	java/lang/StringBuilder
    //   84: dup
    //   85: ldc -40
    //   87: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: iload 9
    //   92: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 225	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: ldc 116
    //   103: ldc -29
    //   105: iconst_1
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: iload_3
    //   112: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: invokestatic 124	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: ldc 116
    //   121: ldc -21
    //   123: iconst_2
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_0
    //   130: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   133: getfield 240	com/tencent/mm/ah/a/c:width	I
    //   136: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: aastore
    //   140: dup
    //   141: iconst_1
    //   142: aload_0
    //   143: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   146: getfield 243	com/tencent/mm/ah/a/c:height	I
    //   149: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: invokestatic 124	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: iload_3
    //   157: tableswitch	default:+2139->2296, 1:+326->483, 2:+1147->1304, 3:+1177->1334, 4:+1229->1386, 5:+792->949
    //   192: ldc 116
    //   194: ldc -11
    //   196: iconst_1
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: iload_3
    //   203: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   206: aastore
    //   207: invokestatic 248	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   213: lstore 7
    //   215: aload 12
    //   217: ifnull +2082 -> 2299
    //   220: aload 12
    //   222: invokevirtual 254	android/graphics/Bitmap:isRecycled	()Z
    //   225: ifeq +1730 -> 1955
    //   228: goto +2071 -> 2299
    //   231: ldc 116
    //   233: ldc_w 256
    //   236: invokestatic 259	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 14
    //   241: astore 13
    //   243: aload 12
    //   245: ifnull +1902 -> 2147
    //   248: aload 12
    //   250: invokevirtual 254	android/graphics/Bitmap:isRecycled	()Z
    //   253: ifne +1894 -> 2147
    //   256: ldc 116
    //   258: ldc_w 261
    //   261: invokestatic 225	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload 12
    //   266: astore 14
    //   268: aload_0
    //   269: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   272: getfield 264	com/tencent/mm/ah/a/a/c:hID	Z
    //   275: ifeq +17 -> 292
    //   278: aload 12
    //   280: aload_0
    //   281: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   284: getfield 267	com/tencent/mm/ah/a/a/c:hIE	I
    //   287: invokestatic 273	com/tencent/mm/sdk/platformtools/d:c	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   290: astore 14
    //   292: new 275	com/tencent/mm/ah/a/f/c
    //   295: dup
    //   296: aload_0
    //   297: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   300: aload_0
    //   301: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   304: aload 14
    //   306: aload_0
    //   307: getfield 60	com/tencent/mm/ah/a/f/b:hIZ	Lcom/tencent/mm/ah/a/b;
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   315: invokevirtual 197	com/tencent/mm/ah/a/f/b:jM	(Ljava/lang/String;)Ljava/lang/String;
    //   318: invokespecial 278	com/tencent/mm/ah/a/f/c:<init>	(Ljava/lang/String;Lcom/tencent/mm/ah/a/c;Landroid/graphics/Bitmap;Lcom/tencent/mm/ah/a/b;Ljava/lang/String;)V
    //   321: astore 12
    //   323: aload_0
    //   324: getfield 58	com/tencent/mm/ah/a/f/b:hJc	Lcom/tencent/mm/sdk/platformtools/ad;
    //   327: ifnull +13 -> 340
    //   330: aload_0
    //   331: getfield 58	com/tencent/mm/ah/a/f/b:hJc	Lcom/tencent/mm/sdk/platformtools/ad;
    //   334: aload 12
    //   336: invokevirtual 284	com/tencent/mm/sdk/platformtools/ad:post	(Ljava/lang/Runnable;)Z
    //   339: pop
    //   340: aload 13
    //   342: aload 14
    //   344: putfield 288	com/tencent/mm/ah/a/d/b:bitmap	Landroid/graphics/Bitmap;
    //   347: aload 14
    //   349: astore 12
    //   351: aload_0
    //   352: getfield 62	com/tencent/mm/ah/a/f/b:hJe	Lcom/tencent/mm/ah/a/c/g;
    //   355: ifnull +37 -> 392
    //   358: aload 13
    //   360: ifnull +32 -> 392
    //   363: aload 13
    //   365: aload 12
    //   367: putfield 288	com/tencent/mm/ah/a/d/b:bitmap	Landroid/graphics/Bitmap;
    //   370: aload_0
    //   371: getfield 62	com/tencent/mm/ah/a/f/b:hJe	Lcom/tencent/mm/ah/a/c/g;
    //   374: aload_0
    //   375: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   378: aload_0
    //   379: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   382: invokevirtual 292	com/tencent/mm/ah/a/c:Bf	()Landroid/widget/ImageView;
    //   385: aload 13
    //   387: invokeinterface 298 4 0
    //   392: aload_0
    //   393: getfield 74	com/tencent/mm/ah/a/f/b:hJd	Lcom/tencent/mm/ah/a/c/i;
    //   396: astore 13
    //   398: aload_0
    //   399: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   402: astore 14
    //   404: aload_0
    //   405: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   408: invokevirtual 292	com/tencent/mm/ah/a/c:Bf	()Landroid/widget/ImageView;
    //   411: pop
    //   412: aload 13
    //   414: aload 14
    //   416: aload 12
    //   418: aload_0
    //   419: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   422: getfield 302	com/tencent/mm/ah/a/a/c:hIU	[Ljava/lang/Object;
    //   425: invokeinterface 307 4 0
    //   430: aload_0
    //   431: getfield 60	com/tencent/mm/ah/a/f/b:hIZ	Lcom/tencent/mm/ah/a/b;
    //   434: astore 12
    //   436: aload 12
    //   438: getfield 311	com/tencent/mm/ah/a/b:hHS	Ljava/util/HashMap;
    //   441: ifnull +33 -> 474
    //   444: aload_0
    //   445: ifnull +29 -> 474
    //   448: aload_0
    //   449: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   452: ifnull +22 -> 474
    //   455: aload 12
    //   457: getfield 311	com/tencent/mm/ah/a/b:hHS	Ljava/util/HashMap;
    //   460: aload_0
    //   461: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   464: invokevirtual 315	com/tencent/mm/ah/a/c:Hf	()I
    //   467: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   470: invokevirtual 321	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   473: pop
    //   474: ldc2_w 190
    //   477: ldc -64
    //   479: invokestatic 104	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   482: return
    //   483: aload_0
    //   484: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   487: getfield 324	com/tencent/mm/ah/a/a/c:fKq	Ljava/lang/String;
    //   490: astore 13
    //   492: aload_0
    //   493: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   496: getfield 327	com/tencent/mm/ah/a/a/c:hIF	Z
    //   499: ifeq +115 -> 614
    //   502: aload 13
    //   504: invokestatic 149	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   507: ifne +107 -> 614
    //   510: aload 13
    //   512: invokestatic 332	com/tencent/mm/a/e:aO	(Ljava/lang/String;)Z
    //   515: ifeq +99 -> 614
    //   518: aload_0
    //   519: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   522: getfield 335	com/tencent/mm/ah/a/a/c:hIS	Z
    //   525: ifeq +61 -> 586
    //   528: aload_0
    //   529: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   532: aload 13
    //   534: aload_0
    //   535: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   538: getfield 178	com/tencent/mm/ah/a/a/c:hIz	I
    //   541: aload_0
    //   542: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   545: getfield 184	com/tencent/mm/ah/a/a/c:hIA	I
    //   548: invokestatic 340	com/tencent/mm/ah/a/g/a:b	(Lcom/tencent/mm/ah/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   551: astore 12
    //   553: aload 12
    //   555: astore 13
    //   557: aload_0
    //   558: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   561: getfield 343	com/tencent/mm/ah/a/a/c:density	I
    //   564: ifle +1729 -> 2293
    //   567: aload 12
    //   569: astore 13
    //   571: aload 12
    //   573: aload_0
    //   574: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   577: getfield 343	com/tencent/mm/ah/a/a/c:density	I
    //   580: invokevirtual 347	android/graphics/Bitmap:setDensity	(I)V
    //   583: goto -373 -> 210
    //   586: aload_0
    //   587: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   590: aload 13
    //   592: aload_0
    //   593: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   596: getfield 178	com/tencent/mm/ah/a/a/c:hIz	I
    //   599: aload_0
    //   600: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   603: getfield 184	com/tencent/mm/ah/a/a/c:hIA	I
    //   606: invokestatic 349	com/tencent/mm/ah/a/g/a:a	(Lcom/tencent/mm/ah/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   609: astore 12
    //   611: goto -58 -> 553
    //   614: aload_0
    //   615: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   618: invokestatic 149	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   621: ifne +317 -> 938
    //   624: aload_0
    //   625: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   628: invokestatic 332	com/tencent/mm/a/e:aO	(Ljava/lang/String;)Z
    //   631: ifeq +222 -> 853
    //   634: iload 9
    //   636: ifeq +21 -> 657
    //   639: aload_0
    //   640: getfield 96	com/tencent/mm/ah/a/f/b:hJf	Lcom/tencent/mm/ah/a/c/k;
    //   643: aload 18
    //   645: aload_0
    //   646: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   649: invokeinterface 355 3 0
    //   654: ifeq +185 -> 839
    //   657: aload_0
    //   658: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   661: getfield 335	com/tencent/mm/ah/a/a/c:hIS	Z
    //   664: ifeq +75 -> 739
    //   667: aload_0
    //   668: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   671: aload_0
    //   672: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   675: aload_0
    //   676: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   679: getfield 178	com/tencent/mm/ah/a/a/c:hIz	I
    //   682: aload_0
    //   683: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   686: getfield 184	com/tencent/mm/ah/a/a/c:hIA	I
    //   689: invokestatic 340	com/tencent/mm/ah/a/g/a:b	(Lcom/tencent/mm/ah/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   692: astore 12
    //   694: aload 12
    //   696: astore 13
    //   698: aload_0
    //   699: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   702: getfield 343	com/tencent/mm/ah/a/a/c:density	I
    //   705: ifle +19 -> 724
    //   708: aload 12
    //   710: astore 13
    //   712: aload 12
    //   714: aload_0
    //   715: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   718: getfield 343	com/tencent/mm/ah/a/a/c:density	I
    //   721: invokevirtual 347	android/graphics/Bitmap:setDensity	(I)V
    //   724: aload 12
    //   726: astore 13
    //   728: ldc 116
    //   730: ldc_w 357
    //   733: invokestatic 225	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   736: goto -526 -> 210
    //   739: aload_0
    //   740: getfield 101	com/tencent/mm/ah/a/f/b:hJg	Lcom/tencent/mm/ah/a/c/d;
    //   743: ifnull +66 -> 809
    //   746: aload_0
    //   747: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   750: aload_0
    //   751: getfield 101	com/tencent/mm/ah/a/f/b:hJg	Lcom/tencent/mm/ah/a/c/d;
    //   754: aload_0
    //   755: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   758: getfield 302	com/tencent/mm/ah/a/a/c:hIU	[Ljava/lang/Object;
    //   761: invokeinterface 362 2 0
    //   766: aload_0
    //   767: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   770: getfield 178	com/tencent/mm/ah/a/a/c:hIz	I
    //   773: aload_0
    //   774: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   777: getfield 184	com/tencent/mm/ah/a/a/c:hIA	I
    //   780: aload_0
    //   781: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   784: getfield 365	com/tencent/mm/ah/a/a/c:hIH	Z
    //   787: aload_0
    //   788: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   791: getfield 368	com/tencent/mm/ah/a/a/c:alpha	F
    //   794: aload_0
    //   795: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   798: getfield 371	com/tencent/mm/ah/a/a/c:hIC	Z
    //   801: invokestatic 374	com/tencent/mm/ah/a/g/a:a	(Lcom/tencent/mm/ah/a/c;[BIIZFZ)Landroid/graphics/Bitmap;
    //   804: astore 12
    //   806: goto -112 -> 694
    //   809: aload_0
    //   810: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   813: aload_0
    //   814: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   817: aload_0
    //   818: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   821: getfield 178	com/tencent/mm/ah/a/a/c:hIz	I
    //   824: aload_0
    //   825: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   828: getfield 184	com/tencent/mm/ah/a/a/c:hIA	I
    //   831: invokestatic 349	com/tencent/mm/ah/a/g/a:a	(Lcom/tencent/mm/ah/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   834: astore 12
    //   836: goto -142 -> 694
    //   839: ldc 116
    //   841: ldc_w 376
    //   844: invokestatic 259	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: aconst_null
    //   848: astore 12
    //   850: goto -640 -> 210
    //   853: aload_0
    //   854: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   857: getfield 379	com/tencent/mm/ah/a/a/c:hIG	Z
    //   860: ifeq +19 -> 879
    //   863: aload_0
    //   864: getfield 99	com/tencent/mm/ah/a/f/b:hIn	Lcom/tencent/mm/ah/a/c/e;
    //   867: aload_0
    //   868: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   871: getfield 302	com/tencent/mm/ah/a/a/c:hIU	[Ljava/lang/Object;
    //   874: invokeinterface 384 2 0
    //   879: ldc 116
    //   881: ldc_w 386
    //   884: invokestatic 259	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   887: goto -677 -> 210
    //   890: astore 15
    //   892: aload 14
    //   894: astore 12
    //   896: aconst_null
    //   897: astore 13
    //   899: aload 15
    //   901: astore 14
    //   903: ldc 116
    //   905: ldc_w 388
    //   908: iconst_1
    //   909: anewarray 4	java/lang/Object
    //   912: dup
    //   913: iconst_0
    //   914: aload 14
    //   916: invokevirtual 389	java/lang/Exception:toString	()Ljava/lang/String;
    //   919: aastore
    //   920: invokestatic 248	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   923: aload 12
    //   925: astore 14
    //   927: aload 13
    //   929: astore 12
    //   931: aload 14
    //   933: astore 13
    //   935: goto -692 -> 243
    //   938: ldc 116
    //   940: ldc_w 391
    //   943: invokestatic 259	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   946: goto -736 -> 210
    //   949: aconst_null
    //   950: astore 15
    //   952: iconst_0
    //   953: istore_2
    //   954: aload_0
    //   955: getfield 88	com/tencent/mm/ah/a/f/b:hIi	Lcom/tencent/mm/ah/a/c/a;
    //   958: aload_0
    //   959: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   962: aload_0
    //   963: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   966: invokeinterface 396 3 0
    //   971: astore 16
    //   973: aload 16
    //   975: ifnull +1312 -> 2287
    //   978: iload 9
    //   980: ifeq +23 -> 1003
    //   983: aload 16
    //   985: astore 15
    //   987: aload_0
    //   988: getfield 96	com/tencent/mm/ah/a/f/b:hJf	Lcom/tencent/mm/ah/a/c/k;
    //   991: aload 18
    //   993: aload 16
    //   995: invokeinterface 399 3 0
    //   1000: ifeq +281 -> 1281
    //   1003: aload 16
    //   1005: astore 15
    //   1007: aload_0
    //   1008: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   1011: astore 12
    //   1013: aload 16
    //   1015: astore 15
    //   1017: aload_0
    //   1018: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1021: getfield 178	com/tencent/mm/ah/a/a/c:hIz	I
    //   1024: istore_2
    //   1025: aload 16
    //   1027: astore 15
    //   1029: aload_0
    //   1030: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1033: getfield 184	com/tencent/mm/ah/a/a/c:hIA	I
    //   1036: istore 4
    //   1038: aload 16
    //   1040: astore 15
    //   1042: aload_0
    //   1043: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1046: getfield 365	com/tencent/mm/ah/a/a/c:hIH	Z
    //   1049: istore 10
    //   1051: aload 16
    //   1053: astore 15
    //   1055: aload_0
    //   1056: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1059: getfield 368	com/tencent/mm/ah/a/a/c:alpha	F
    //   1062: fstore_1
    //   1063: aload 16
    //   1065: astore 15
    //   1067: aload_0
    //   1068: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1071: getfield 371	com/tencent/mm/ah/a/a/c:hIC	Z
    //   1074: istore 11
    //   1076: iload_2
    //   1077: ifle +8 -> 1085
    //   1080: iload 4
    //   1082: ifgt +181 -> 1263
    //   1085: aload 12
    //   1087: ifnull +162 -> 1249
    //   1090: aload 16
    //   1092: astore 15
    //   1094: aload 12
    //   1096: getfield 240	com/tencent/mm/ah/a/c:width	I
    //   1099: ifle +150 -> 1249
    //   1102: aload 16
    //   1104: astore 15
    //   1106: aload 12
    //   1108: getfield 240	com/tencent/mm/ah/a/c:width	I
    //   1111: ifle +138 -> 1249
    //   1114: aload 16
    //   1116: astore 15
    //   1118: aload 16
    //   1120: fconst_0
    //   1121: aload 12
    //   1123: getfield 240	com/tencent/mm/ah/a/c:width	I
    //   1126: aload 12
    //   1128: getfield 243	com/tencent/mm/ah/a/c:height	I
    //   1131: invokestatic 402	com/tencent/mm/sdk/platformtools/d:a	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   1134: astore 12
    //   1136: aload 12
    //   1138: astore 13
    //   1140: iload 10
    //   1142: ifeq +19 -> 1161
    //   1145: aload 16
    //   1147: astore 15
    //   1149: aload 12
    //   1151: iload_2
    //   1152: iload 4
    //   1154: iconst_0
    //   1155: iconst_1
    //   1156: invokestatic 405	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;IIZZ)Landroid/graphics/Bitmap;
    //   1159: astore 13
    //   1161: aload 13
    //   1163: astore 12
    //   1165: fload_1
    //   1166: fconst_0
    //   1167: fcmpl
    //   1168: ifle +15 -> 1183
    //   1171: aload 16
    //   1173: astore 15
    //   1175: aload 13
    //   1177: fload_1
    //   1178: invokestatic 408	com/tencent/mm/sdk/platformtools/d:c	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   1181: astore 12
    //   1183: aload 12
    //   1185: astore 13
    //   1187: iload 11
    //   1189: ifeq +14 -> 1203
    //   1192: aload 16
    //   1194: astore 15
    //   1196: aload 12
    //   1198: invokestatic 412	com/tencent/mm/sdk/platformtools/d:M	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   1201: astore 13
    //   1203: iconst_1
    //   1204: istore_2
    //   1205: aload 16
    //   1207: ifnull +8 -> 1215
    //   1210: aload 16
    //   1212: invokevirtual 417	java/io/InputStream:close	()V
    //   1215: iload_2
    //   1216: ifeq +1064 -> 2280
    //   1219: aload 13
    //   1221: ifnonnull +1059 -> 2280
    //   1224: aload_0
    //   1225: getfield 88	com/tencent/mm/ah/a/f/b:hIi	Lcom/tencent/mm/ah/a/c/a;
    //   1228: aload_0
    //   1229: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   1232: aload_0
    //   1233: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1236: invokeinterface 420 3 0
    //   1241: pop
    //   1242: aload 13
    //   1244: astore 12
    //   1246: goto -1036 -> 210
    //   1249: aload 16
    //   1251: astore 15
    //   1253: aload 16
    //   1255: invokestatic 424	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1258: astore 12
    //   1260: goto -124 -> 1136
    //   1263: aload 16
    //   1265: astore 15
    //   1267: aload 16
    //   1269: fconst_0
    //   1270: iload_2
    //   1271: iload 4
    //   1273: invokestatic 402	com/tencent/mm/sdk/platformtools/d:a	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   1276: astore 12
    //   1278: goto -142 -> 1136
    //   1281: iconst_1
    //   1282: istore_2
    //   1283: aconst_null
    //   1284: astore 13
    //   1286: goto -81 -> 1205
    //   1289: astore 12
    //   1291: aload 15
    //   1293: ifnull +8 -> 1301
    //   1296: aload 15
    //   1298: invokevirtual 417	java/io/InputStream:close	()V
    //   1301: aload 12
    //   1303: athrow
    //   1304: aload_0
    //   1305: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   1308: aload_0
    //   1309: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   1312: aload_0
    //   1313: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1316: getfield 178	com/tencent/mm/ah/a/a/c:hIz	I
    //   1319: aload_0
    //   1320: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1323: getfield 184	com/tencent/mm/ah/a/a/c:hIA	I
    //   1326: invokestatic 426	com/tencent/mm/ah/a/g/a:c	(Lcom/tencent/mm/ah/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   1329: astore 12
    //   1331: goto -1121 -> 210
    //   1334: aload_0
    //   1335: getfield 67	com/tencent/mm/ah/a/f/b:hHO	Lcom/tencent/mm/ah/a/a/b;
    //   1338: getfield 430	com/tencent/mm/ah/a/a/b:hId	Landroid/content/res/Resources;
    //   1341: aload_0
    //   1342: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   1345: ldc_w 432
    //   1348: aload_0
    //   1349: getfield 67	com/tencent/mm/ah/a/f/b:hHO	Lcom/tencent/mm/ah/a/a/b;
    //   1352: getfield 435	com/tencent/mm/ah/a/a/b:packageName	Ljava/lang/String;
    //   1355: invokevirtual 441	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   1358: istore_2
    //   1359: aload_0
    //   1360: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   1363: iload_2
    //   1364: aload_0
    //   1365: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1368: getfield 178	com/tencent/mm/ah/a/a/c:hIz	I
    //   1371: aload_0
    //   1372: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1375: getfield 184	com/tencent/mm/ah/a/a/c:hIA	I
    //   1378: invokestatic 444	com/tencent/mm/ah/a/g/a:a	(Lcom/tencent/mm/ah/a/c;III)Landroid/graphics/Bitmap;
    //   1381: astore 12
    //   1383: goto -1173 -> 210
    //   1386: aload_0
    //   1387: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   1390: invokestatic 447	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1393: invokevirtual 450	java/lang/Integer:intValue	()I
    //   1396: istore_2
    //   1397: aload_0
    //   1398: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   1401: iload_2
    //   1402: aload_0
    //   1403: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1406: getfield 178	com/tencent/mm/ah/a/a/c:hIz	I
    //   1409: aload_0
    //   1410: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1413: getfield 184	com/tencent/mm/ah/a/a/c:hIA	I
    //   1416: invokestatic 444	com/tencent/mm/ah/a/g/a:a	(Lcom/tencent/mm/ah/a/c;III)Landroid/graphics/Bitmap;
    //   1419: astore 12
    //   1421: goto -1211 -> 210
    //   1424: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   1427: lstore 5
    //   1429: ldc 116
    //   1431: ldc_w 452
    //   1434: invokestatic 225	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1437: aload_0
    //   1438: getfield 62	com/tencent/mm/ah/a/f/b:hJe	Lcom/tencent/mm/ah/a/c/g;
    //   1441: ifnull +32 -> 1473
    //   1444: aload_0
    //   1445: getfield 62	com/tencent/mm/ah/a/f/b:hJe	Lcom/tencent/mm/ah/a/c/g;
    //   1448: astore 13
    //   1450: aload_0
    //   1451: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   1454: astore 15
    //   1456: aload_0
    //   1457: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   1460: invokevirtual 292	com/tencent/mm/ah/a/c:Bf	()Landroid/widget/ImageView;
    //   1463: pop
    //   1464: aload 13
    //   1466: aload 15
    //   1468: invokeinterface 455 2 0
    //   1473: aload_0
    //   1474: getfield 82	com/tencent/mm/ah/a/f/b:hIj	Lcom/tencent/mm/ah/a/c/b;
    //   1477: aload_0
    //   1478: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   1481: invokeinterface 461 2 0
    //   1486: astore 13
    //   1488: aload 13
    //   1490: ifnonnull +787 -> 2277
    //   1493: new 194	com/tencent/mm/ah/a/d/b
    //   1496: dup
    //   1497: aconst_null
    //   1498: aconst_null
    //   1499: invokespecial 464	com/tencent/mm/ah/a/d/b:<init>	([BLjava/lang/String;)V
    //   1502: astore 14
    //   1504: aload 14
    //   1506: astore 13
    //   1508: aload 13
    //   1510: getfield 468	com/tencent/mm/ah/a/d/b:data	[B
    //   1513: ifnonnull +12 -> 1525
    //   1516: aload 13
    //   1518: iconst_1
    //   1519: putfield 471	com/tencent/mm/ah/a/d/b:status	I
    //   1522: goto -1279 -> 243
    //   1525: iload 9
    //   1527: ifeq +22 -> 1549
    //   1530: aload_0
    //   1531: getfield 96	com/tencent/mm/ah/a/f/b:hJf	Lcom/tencent/mm/ah/a/c/k;
    //   1534: aload 18
    //   1536: aload 13
    //   1538: getfield 468	com/tencent/mm/ah/a/d/b:data	[B
    //   1541: invokeinterface 475 3 0
    //   1546: ifeq +374 -> 1920
    //   1549: ldc 116
    //   1551: ldc_w 477
    //   1554: invokestatic 225	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1557: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   1560: lstore 7
    //   1562: aload_0
    //   1563: getfield 56	com/tencent/mm/ah/a/f/b:hJb	Lcom/tencent/mm/ah/a/c;
    //   1566: aload 13
    //   1568: getfield 468	com/tencent/mm/ah/a/d/b:data	[B
    //   1571: aload_0
    //   1572: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1575: getfield 178	com/tencent/mm/ah/a/a/c:hIz	I
    //   1578: aload_0
    //   1579: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1582: getfield 184	com/tencent/mm/ah/a/a/c:hIA	I
    //   1585: aload_0
    //   1586: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1589: getfield 365	com/tencent/mm/ah/a/a/c:hIH	Z
    //   1592: aload_0
    //   1593: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1596: getfield 368	com/tencent/mm/ah/a/a/c:alpha	F
    //   1599: aload_0
    //   1600: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1603: getfield 371	com/tencent/mm/ah/a/a/c:hIC	Z
    //   1606: invokestatic 374	com/tencent/mm/ah/a/g/a:a	(Lcom/tencent/mm/ah/a/c;[BIIZFZ)Landroid/graphics/Bitmap;
    //   1609: astore 15
    //   1611: aload 15
    //   1613: ifnonnull +20 -> 1633
    //   1616: aload 15
    //   1618: astore 14
    //   1620: aload 13
    //   1622: iconst_3
    //   1623: putfield 471	com/tencent/mm/ah/a/d/b:status	I
    //   1626: aload 15
    //   1628: astore 12
    //   1630: goto -1387 -> 243
    //   1633: aload 15
    //   1635: astore 14
    //   1637: aload 13
    //   1639: getfield 468	com/tencent/mm/ah/a/d/b:data	[B
    //   1642: astore 12
    //   1644: aload 15
    //   1646: astore 14
    //   1648: aload_0
    //   1649: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1652: getfield 480	com/tencent/mm/ah/a/a/c:hIt	Z
    //   1655: ifeq +27 -> 1682
    //   1658: aload 15
    //   1660: astore 14
    //   1662: aload_0
    //   1663: getfield 88	com/tencent/mm/ah/a/f/b:hIi	Lcom/tencent/mm/ah/a/c/a;
    //   1666: aload_0
    //   1667: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   1670: aload 12
    //   1672: aload_0
    //   1673: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1676: invokeinterface 483 4 0
    //   1681: pop
    //   1682: aload 15
    //   1684: astore 14
    //   1686: aload_0
    //   1687: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1690: getfield 486	com/tencent/mm/ah/a/a/c:hIs	Z
    //   1693: ifeq +27 -> 1720
    //   1696: aload 15
    //   1698: astore 14
    //   1700: aload_0
    //   1701: getfield 88	com/tencent/mm/ah/a/f/b:hIi	Lcom/tencent/mm/ah/a/c/a;
    //   1704: aload_0
    //   1705: getfield 54	com/tencent/mm/ah/a/f/b:url	Ljava/lang/String;
    //   1708: aload 12
    //   1710: aload_0
    //   1711: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1714: invokeinterface 483 4 0
    //   1719: pop
    //   1720: aload 15
    //   1722: astore 12
    //   1724: aload 15
    //   1726: astore 14
    //   1728: aload_0
    //   1729: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1732: getfield 152	com/tencent/mm/ah/a/a/c:hIQ	Z
    //   1735: ifeq +56 -> 1791
    //   1738: aload 15
    //   1740: astore 14
    //   1742: aload_0
    //   1743: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1746: getfield 165	com/tencent/mm/ah/a/a/c:hIR	F
    //   1749: fconst_0
    //   1750: fcmpl
    //   1751: ifne +147 -> 1898
    //   1754: aload 15
    //   1756: astore 14
    //   1758: aload 15
    //   1760: invokevirtual 489	android/graphics/Bitmap:getWidth	()I
    //   1763: aload 15
    //   1765: invokevirtual 492	android/graphics/Bitmap:getHeight	()I
    //   1768: if_icmpne +51 -> 1819
    //   1771: aload 15
    //   1773: astore 14
    //   1775: aload 15
    //   1777: iconst_0
    //   1778: aload 15
    //   1780: invokevirtual 489	android/graphics/Bitmap:getWidth	()I
    //   1783: iconst_2
    //   1784: idiv
    //   1785: i2f
    //   1786: invokestatic 495	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   1789: astore 12
    //   1791: aload 12
    //   1793: astore 14
    //   1795: aload_0
    //   1796: aload 17
    //   1798: aload 12
    //   1800: invokespecial 497	com/tencent/mm/ah/a/f/b:i	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   1803: aload 12
    //   1805: astore 14
    //   1807: aload_0
    //   1808: lload 7
    //   1810: lload 5
    //   1812: lsub
    //   1813: invokevirtual 498	com/tencent/mm/ah/a/f/b:ao	(J)V
    //   1816: goto -1573 -> 243
    //   1819: aload 15
    //   1821: astore 14
    //   1823: aload 15
    //   1825: invokevirtual 489	android/graphics/Bitmap:getWidth	()I
    //   1828: aload 15
    //   1830: invokevirtual 492	android/graphics/Bitmap:getHeight	()I
    //   1833: invokestatic 504	java/lang/Math:min	(II)I
    //   1836: istore_3
    //   1837: iload_3
    //   1838: istore_2
    //   1839: iload_3
    //   1840: ifgt +21 -> 1861
    //   1843: aload 15
    //   1845: astore 14
    //   1847: aload 15
    //   1849: invokevirtual 489	android/graphics/Bitmap:getWidth	()I
    //   1852: aload 15
    //   1854: invokevirtual 492	android/graphics/Bitmap:getHeight	()I
    //   1857: invokestatic 507	java/lang/Math:max	(II)I
    //   1860: istore_2
    //   1861: aload 15
    //   1863: astore 14
    //   1865: aload 15
    //   1867: iload_2
    //   1868: iload_2
    //   1869: iconst_1
    //   1870: invokestatic 510	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   1873: astore 12
    //   1875: aload 12
    //   1877: astore 14
    //   1879: aload 12
    //   1881: iconst_0
    //   1882: aload 12
    //   1884: invokevirtual 489	android/graphics/Bitmap:getWidth	()I
    //   1887: iconst_2
    //   1888: idiv
    //   1889: i2f
    //   1890: invokestatic 495	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   1893: astore 12
    //   1895: goto -104 -> 1791
    //   1898: aload 15
    //   1900: astore 14
    //   1902: aload 15
    //   1904: iconst_0
    //   1905: aload_0
    //   1906: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1909: getfield 165	com/tencent/mm/ah/a/a/c:hIR	F
    //   1912: invokestatic 495	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   1915: astore 12
    //   1917: goto -126 -> 1791
    //   1920: aload 13
    //   1922: iconst_2
    //   1923: putfield 471	com/tencent/mm/ah/a/d/b:status	I
    //   1926: ldc 116
    //   1928: ldc_w 512
    //   1931: invokestatic 259	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1934: aconst_null
    //   1935: astore 12
    //   1937: goto -1694 -> 243
    //   1940: ldc 116
    //   1942: ldc_w 514
    //   1945: invokestatic 259	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1948: aload 14
    //   1950: astore 13
    //   1952: goto -1709 -> 243
    //   1955: aload_0
    //   1956: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1959: getfield 152	com/tencent/mm/ah/a/a/c:hIQ	Z
    //   1962: ifeq +312 -> 2274
    //   1965: aload_0
    //   1966: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   1969: getfield 165	com/tencent/mm/ah/a/a/c:hIR	F
    //   1972: fconst_0
    //   1973: fcmpl
    //   1974: ifne +151 -> 2125
    //   1977: aload 12
    //   1979: invokevirtual 489	android/graphics/Bitmap:getWidth	()I
    //   1982: aload 12
    //   1984: invokevirtual 492	android/graphics/Bitmap:getHeight	()I
    //   1987: if_icmpne +67 -> 2054
    //   1990: aload 12
    //   1992: iconst_0
    //   1993: aload 12
    //   1995: invokevirtual 489	android/graphics/Bitmap:getWidth	()I
    //   1998: iconst_2
    //   1999: idiv
    //   2000: i2f
    //   2001: invokestatic 495	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2004: astore 13
    //   2006: aload 13
    //   2008: astore 12
    //   2010: aload 12
    //   2012: astore 13
    //   2014: aload_0
    //   2015: aload 17
    //   2017: aload 12
    //   2019: invokespecial 497	com/tencent/mm/ah/a/f/b:i	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   2022: aload 12
    //   2024: astore 13
    //   2026: aload_0
    //   2027: lload 7
    //   2029: lload 5
    //   2031: lsub
    //   2032: invokevirtual 498	com/tencent/mm/ah/a/f/b:ao	(J)V
    //   2035: aload 12
    //   2037: astore 13
    //   2039: ldc 116
    //   2041: ldc_w 516
    //   2044: invokestatic 225	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2047: aload 14
    //   2049: astore 13
    //   2051: goto -1808 -> 243
    //   2054: aload 12
    //   2056: invokevirtual 489	android/graphics/Bitmap:getWidth	()I
    //   2059: aload 12
    //   2061: invokevirtual 492	android/graphics/Bitmap:getHeight	()I
    //   2064: invokestatic 504	java/lang/Math:min	(II)I
    //   2067: istore_3
    //   2068: iload_3
    //   2069: istore_2
    //   2070: iload_3
    //   2071: ifgt +17 -> 2088
    //   2074: aload 12
    //   2076: invokevirtual 489	android/graphics/Bitmap:getWidth	()I
    //   2079: aload 12
    //   2081: invokevirtual 492	android/graphics/Bitmap:getHeight	()I
    //   2084: invokestatic 507	java/lang/Math:max	(II)I
    //   2087: istore_2
    //   2088: aload 12
    //   2090: iload_2
    //   2091: iload_2
    //   2092: iconst_1
    //   2093: invokestatic 510	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   2096: astore 13
    //   2098: aload 13
    //   2100: astore 12
    //   2102: aload 12
    //   2104: astore 13
    //   2106: aload 12
    //   2108: iconst_0
    //   2109: aload 12
    //   2111: invokevirtual 489	android/graphics/Bitmap:getWidth	()I
    //   2114: iconst_2
    //   2115: idiv
    //   2116: i2f
    //   2117: invokestatic 495	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2120: astore 12
    //   2122: goto -112 -> 2010
    //   2125: aload 12
    //   2127: iconst_0
    //   2128: aload_0
    //   2129: getfield 72	com/tencent/mm/ah/a/f/b:hIg	Lcom/tencent/mm/ah/a/a/c;
    //   2132: getfield 165	com/tencent/mm/ah/a/a/c:hIR	F
    //   2135: invokestatic 495	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2138: astore 13
    //   2140: aload 13
    //   2142: astore 12
    //   2144: goto -134 -> 2010
    //   2147: ldc 116
    //   2149: ldc_w 518
    //   2152: invokestatic 259	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2155: goto -1804 -> 351
    //   2158: astore 12
    //   2160: goto -945 -> 1215
    //   2163: astore 13
    //   2165: goto -864 -> 1301
    //   2168: astore 15
    //   2170: aload 14
    //   2172: astore 12
    //   2174: aload 15
    //   2176: astore 14
    //   2178: goto -1275 -> 903
    //   2181: astore 15
    //   2183: aload 14
    //   2185: astore 12
    //   2187: aload 15
    //   2189: astore 14
    //   2191: goto -1288 -> 903
    //   2194: astore 16
    //   2196: aload 14
    //   2198: astore 13
    //   2200: aload 12
    //   2202: astore 15
    //   2204: aload 16
    //   2206: astore 14
    //   2208: aload 13
    //   2210: astore 12
    //   2212: aload 15
    //   2214: astore 13
    //   2216: goto -1313 -> 903
    //   2219: astore 14
    //   2221: aload 12
    //   2223: astore 15
    //   2225: aload 13
    //   2227: astore 12
    //   2229: aload 15
    //   2231: astore 13
    //   2233: goto -1330 -> 903
    //   2236: astore 14
    //   2238: aload 12
    //   2240: astore 15
    //   2242: aload 13
    //   2244: astore 12
    //   2246: aload 15
    //   2248: astore 13
    //   2250: goto -1347 -> 903
    //   2253: astore 16
    //   2255: aload 14
    //   2257: astore 15
    //   2259: aload 13
    //   2261: astore 12
    //   2263: aload 16
    //   2265: astore 14
    //   2267: aload 15
    //   2269: astore 13
    //   2271: goto -1368 -> 903
    //   2274: goto -264 -> 2010
    //   2277: goto -769 -> 1508
    //   2280: aload 13
    //   2282: astore 12
    //   2284: goto -2074 -> 210
    //   2287: aconst_null
    //   2288: astore 13
    //   2290: goto -1085 -> 1205
    //   2293: goto -2083 -> 210
    //   2296: goto -2104 -> 192
    //   2299: iload_3
    //   2300: tableswitch	default:+36->2336, 1:+-360->1940, 2:+-360->1940, 3:+-360->1940, 4:+-360->1940, 5:+-876->1424
    //   2336: goto -2105 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2339	0	this	b
    //   1062	116	1	f	float
    //   953	1139	2	i	int
    //   60	2240	3	j	int
    //   1036	236	4	k	int
    //   51	1979	5	l1	long
    //   213	1815	7	l2	long
    //   68	1458	9	bool1	boolean
    //   1049	92	10	bool2	boolean
    //   1074	114	11	bool3	boolean
    //   9	1268	12	localObject1	Object
    //   1289	13	12	localObject2	Object
    //   1329	814	12	localObject3	Object
    //   2158	1	12	localIOException1	java.io.IOException
    //   2172	111	12	localObject4	Object
    //   241	1900	13	localObject5	Object
    //   2163	1	13	localIOException2	java.io.IOException
    //   2198	91	13	localObject6	Object
    //   18	2189	14	localObject7	Object
    //   2219	1	14	localException1	Exception
    //   2236	20	14	localException2	Exception
    //   2265	1	14	localObject8	Object
    //   890	10	15	localException3	Exception
    //   950	953	15	localObject9	Object
    //   2168	7	15	localException4	Exception
    //   2181	7	15	localException5	Exception
    //   2202	66	15	localObject10	Object
    //   971	297	16	localInputStream	java.io.InputStream
    //   2194	11	16	localException6	Exception
    //   2253	11	16	localException7	Exception
    //   28	1988	17	str1	String
    //   77	1458	18	str2	String
    // Exception table:
    //   from	to	target	type
    //   20	156	890	java/lang/Exception
    //   192	210	890	java/lang/Exception
    //   483	553	890	java/lang/Exception
    //   586	611	890	java/lang/Exception
    //   614	634	890	java/lang/Exception
    //   639	657	890	java/lang/Exception
    //   657	694	890	java/lang/Exception
    //   739	806	890	java/lang/Exception
    //   809	836	890	java/lang/Exception
    //   839	847	890	java/lang/Exception
    //   853	879	890	java/lang/Exception
    //   879	887	890	java/lang/Exception
    //   938	946	890	java/lang/Exception
    //   1296	1301	890	java/lang/Exception
    //   1301	1304	890	java/lang/Exception
    //   1304	1331	890	java/lang/Exception
    //   1334	1383	890	java/lang/Exception
    //   1386	1421	890	java/lang/Exception
    //   954	973	1289	finally
    //   987	1003	1289	finally
    //   1007	1013	1289	finally
    //   1017	1025	1289	finally
    //   1029	1038	1289	finally
    //   1042	1051	1289	finally
    //   1055	1063	1289	finally
    //   1067	1076	1289	finally
    //   1094	1102	1289	finally
    //   1106	1114	1289	finally
    //   1118	1136	1289	finally
    //   1149	1161	1289	finally
    //   1175	1183	1289	finally
    //   1196	1203	1289	finally
    //   1253	1260	1289	finally
    //   1267	1278	1289	finally
    //   1210	1215	2158	java/io/IOException
    //   1296	1301	2163	java/io/IOException
    //   557	567	2168	java/lang/Exception
    //   571	583	2168	java/lang/Exception
    //   698	708	2168	java/lang/Exception
    //   712	724	2168	java/lang/Exception
    //   728	736	2168	java/lang/Exception
    //   2014	2022	2168	java/lang/Exception
    //   2026	2035	2168	java/lang/Exception
    //   2039	2047	2168	java/lang/Exception
    //   2106	2122	2168	java/lang/Exception
    //   1210	1215	2181	java/lang/Exception
    //   1224	1242	2181	java/lang/Exception
    //   210	215	2194	java/lang/Exception
    //   220	228	2194	java/lang/Exception
    //   231	239	2194	java/lang/Exception
    //   1424	1473	2194	java/lang/Exception
    //   1473	1488	2194	java/lang/Exception
    //   1940	1948	2194	java/lang/Exception
    //   1955	2006	2194	java/lang/Exception
    //   2054	2068	2194	java/lang/Exception
    //   2074	2088	2194	java/lang/Exception
    //   2088	2098	2194	java/lang/Exception
    //   2125	2140	2194	java/lang/Exception
    //   1493	1504	2219	java/lang/Exception
    //   1508	1522	2236	java/lang/Exception
    //   1530	1549	2236	java/lang/Exception
    //   1549	1611	2236	java/lang/Exception
    //   1920	1934	2236	java/lang/Exception
    //   1620	1626	2253	java/lang/Exception
    //   1637	1644	2253	java/lang/Exception
    //   1648	1658	2253	java/lang/Exception
    //   1662	1682	2253	java/lang/Exception
    //   1686	1696	2253	java/lang/Exception
    //   1700	1720	2253	java/lang/Exception
    //   1728	1738	2253	java/lang/Exception
    //   1742	1754	2253	java/lang/Exception
    //   1758	1771	2253	java/lang/Exception
    //   1775	1791	2253	java/lang/Exception
    //   1795	1803	2253	java/lang/Exception
    //   1807	1816	2253	java/lang/Exception
    //   1823	1837	2253	java/lang/Exception
    //   1847	1861	2253	java/lang/Exception
    //   1865	1875	2253	java/lang/Exception
    //   1879	1895	2253	java/lang/Exception
    //   1902	1917	2253	java/lang/Exception
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */