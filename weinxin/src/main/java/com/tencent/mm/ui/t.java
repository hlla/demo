package com.tencent.mm.ui;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;

public final class t
{
  private static t uTU;
  private long timestamp;
  int uTV;
  private SparseIntArray uTW;
  private SparseArray<u.b> uTX;
  private ArrayList<Integer> uTY;
  public SparseArray<u.c> uTZ;
  private boolean uUa;
  
  static
  {
    GMTrace.i(2083193356288L, 15521);
    uTU = null;
    GMTrace.o(2083193356288L, 15521);
  }
  
  public t()
  {
    GMTrace.i(2082522267648L, 15516);
    this.uTV = 0;
    this.uTW = new SparseIntArray();
    this.uTX = new SparseArray();
    this.uTY = new ArrayList();
    this.uTZ = new SparseArray();
    this.timestamp = 0L;
    this.uUa = false;
    GMTrace.o(2082522267648L, 15516);
  }
  
  public static t bQo()
  {
    GMTrace.i(2082656485376L, 15517);
    if (uTU == null) {
      uTU = new t();
    }
    t localt = uTU;
    GMTrace.o(2082656485376L, 15517);
    return localt;
  }
  
  private void bQp()
  {
    GMTrace.i(2083059138560L, 15520);
    this.uTW.clear();
    ap.yY();
    Object localObject = (String)c.vr().get(299010, null);
    if (!bf.mA((String)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      int i = 0;
      while (i < localObject.length)
      {
        String[] arrayOfString = localObject[i].split("\\:");
        if (arrayOfString.length == 2) {
          this.uTW.put(bf.PX(arrayOfString[0]), bf.PX(arrayOfString[1]));
        }
        i += 1;
      }
    }
    this.uUa = true;
    GMTrace.o(2083059138560L, 15520);
  }
  
  /* Error */
  public final void kx(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc2_w 125
    //   3: sipush 15519
    //   6: invokestatic 32	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: iload_1
    //   10: ifne +31 -> 41
    //   13: aload_0
    //   14: getfield 55	com/tencent/mm/ui/t:uTX	Landroid/util/SparseArray;
    //   17: invokevirtual 130	android/util/SparseArray:size	()I
    //   20: ifeq +972 -> 992
    //   23: invokestatic 136	java/lang/System:currentTimeMillis	()J
    //   26: aload_0
    //   27: getfield 64	com/tencent/mm/ui/t:timestamp	J
    //   30: lsub
    //   31: ldc2_w 137
    //   34: lcmp
    //   35: ifle +966 -> 1001
    //   38: goto +954 -> 992
    //   41: invokestatic 136	java/lang/System:currentTimeMillis	()J
    //   44: lstore 6
    //   46: invokestatic 144	com/tencent/mm/i/g:sV	()Lcom/tencent/mm/i/e;
    //   49: ldc -110
    //   51: invokevirtual 152	com/tencent/mm/i/e:dC	(Ljava/lang/String;)Ljava/util/List;
    //   54: astore 8
    //   56: ldc -102
    //   58: ldc -100
    //   60: iconst_1
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload 8
    //   68: invokeinterface 159 1 0
    //   73: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: invokestatic 170	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 55	com/tencent/mm/ui/t:uTX	Landroid/util/SparseArray;
    //   86: invokevirtual 171	android/util/SparseArray:clear	()V
    //   89: aload_0
    //   90: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   93: invokevirtual 172	java/util/ArrayList:clear	()V
    //   96: aload 8
    //   98: invokeinterface 176 1 0
    //   103: astore 8
    //   105: aload 8
    //   107: invokeinterface 182 1 0
    //   112: ifeq +387 -> 499
    //   115: aload 8
    //   117: invokeinterface 186 1 0
    //   122: checkcast 98	java/lang/String
    //   125: ldc -68
    //   127: invokestatic 194	com/tencent/mm/sdk/platformtools/bg:q	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   130: astore 9
    //   132: aload 9
    //   134: ifnull -29 -> 105
    //   137: aload 9
    //   139: invokeinterface 197 1 0
    //   144: ifeq -39 -> 105
    //   147: aload 9
    //   149: ldc -57
    //   151: invokeinterface 202 2 0
    //   156: checkcast 98	java/lang/String
    //   159: invokestatic 116	com/tencent/mm/sdk/platformtools/bf:PX	(Ljava/lang/String;)I
    //   162: istore_3
    //   163: aload 9
    //   165: ldc -52
    //   167: invokeinterface 202 2 0
    //   172: checkcast 98	java/lang/String
    //   175: invokestatic 116	com/tencent/mm/sdk/platformtools/bf:PX	(Ljava/lang/String;)I
    //   178: istore_2
    //   179: aload 9
    //   181: ldc -50
    //   183: invokeinterface 202 2 0
    //   188: checkcast 98	java/lang/String
    //   191: invokestatic 116	com/tencent/mm/sdk/platformtools/bf:PX	(Ljava/lang/String;)I
    //   194: istore 5
    //   196: aload 9
    //   198: ldc -48
    //   200: invokeinterface 202 2 0
    //   205: checkcast 98	java/lang/String
    //   208: invokestatic 116	com/tencent/mm/sdk/platformtools/bf:PX	(Ljava/lang/String;)I
    //   211: istore 4
    //   213: aload_0
    //   214: getfield 55	com/tencent/mm/ui/t:uTX	Landroid/util/SparseArray;
    //   217: iload_3
    //   218: new 210	com/tencent/mm/ui/u$b
    //   221: dup
    //   222: iload_3
    //   223: iload_2
    //   224: iload 5
    //   226: iload 4
    //   228: invokespecial 213	com/tencent/mm/ui/u$b:<init>	(IIII)V
    //   231: invokevirtual 216	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   234: iconst_0
    //   235: istore_2
    //   236: iload_2
    //   237: aload_0
    //   238: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   241: invokevirtual 217	java/util/ArrayList:size	()I
    //   244: if_icmpge +42 -> 286
    //   247: aload_0
    //   248: getfield 55	com/tencent/mm/ui/t:uTX	Landroid/util/SparseArray;
    //   251: aload_0
    //   252: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   255: iload_2
    //   256: invokevirtual 220	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   259: checkcast 161	java/lang/Integer
    //   262: invokevirtual 223	java/lang/Integer:intValue	()I
    //   265: invokevirtual 224	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   268: checkcast 210	com/tencent/mm/ui/u$b
    //   271: getfield 227	com/tencent/mm/ui/u$b:order	I
    //   274: iload 4
    //   276: if_icmpgt +10 -> 286
    //   279: iload_2
    //   280: iconst_1
    //   281: iadd
    //   282: istore_2
    //   283: goto -47 -> 236
    //   286: aload_0
    //   287: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   290: iload_2
    //   291: iload_3
    //   292: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: invokevirtual 230	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   298: goto -193 -> 105
    //   301: astore 8
    //   303: aload_0
    //   304: monitorexit
    //   305: aload 8
    //   307: athrow
    //   308: astore 8
    //   310: ldc -102
    //   312: aload 8
    //   314: ldc -24
    //   316: iconst_0
    //   317: anewarray 4	java/lang/Object
    //   320: invokestatic 236	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   323: aload_0
    //   324: getfield 62	com/tencent/mm/ui/t:uTZ	Landroid/util/SparseArray;
    //   327: invokevirtual 171	android/util/SparseArray:clear	()V
    //   330: aload_0
    //   331: iconst_0
    //   332: putfield 45	com/tencent/mm/ui/t:uTV	I
    //   335: iconst_0
    //   336: istore_3
    //   337: iconst_0
    //   338: istore_2
    //   339: iload_2
    //   340: aload_0
    //   341: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   344: invokevirtual 217	java/util/ArrayList:size	()I
    //   347: if_icmpge +539 -> 886
    //   350: aload_0
    //   351: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   354: iload_2
    //   355: invokevirtual 220	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   358: checkcast 161	java/lang/Integer
    //   361: invokevirtual 223	java/lang/Integer:intValue	()I
    //   364: istore 5
    //   366: aload_0
    //   367: getfield 55	com/tencent/mm/ui/t:uTX	Landroid/util/SparseArray;
    //   370: iload 5
    //   372: invokevirtual 224	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   375: checkcast 210	com/tencent/mm/ui/u$b
    //   378: astore 8
    //   380: iload 5
    //   382: invokestatic 242	com/tencent/mm/ui/u:zr	(I)Lcom/tencent/mm/ui/u$d;
    //   385: astore 9
    //   387: iload_3
    //   388: istore 4
    //   390: aload 9
    //   392: ifnull +97 -> 489
    //   395: new 244	com/tencent/mm/ui/u$c
    //   398: dup
    //   399: aload 9
    //   401: invokespecial 247	com/tencent/mm/ui/u$c:<init>	(Lcom/tencent/mm/ui/u$d;)V
    //   404: astore 9
    //   406: aload_0
    //   407: getfield 62	com/tencent/mm/ui/t:uTZ	Landroid/util/SparseArray;
    //   410: iload_3
    //   411: aload 9
    //   413: invokevirtual 216	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   416: aload_0
    //   417: getfield 50	com/tencent/mm/ui/t:uTW	Landroid/util/SparseIntArray;
    //   420: iload 5
    //   422: invokevirtual 250	android/util/SparseIntArray:get	(I)I
    //   425: istore 4
    //   427: aload 8
    //   429: getfield 253	com/tencent/mm/ui/u$b:uUf	I
    //   432: iconst_1
    //   433: if_icmpne +13 -> 446
    //   436: iload 4
    //   438: aload 8
    //   440: getfield 256	com/tencent/mm/ui/u$b:hTc	I
    //   443: if_icmpne +25 -> 468
    //   446: iload 5
    //   448: bipush 20
    //   450: if_icmpne +34 -> 484
    //   453: invokestatic 262	com/tencent/mm/q/c:uk	()Lcom/tencent/mm/q/a;
    //   456: ldc_w 263
    //   459: ldc_w 264
    //   462: invokevirtual 270	com/tencent/mm/q/a:aD	(II)Z
    //   465: ifeq +19 -> 484
    //   468: aload 9
    //   470: iconst_1
    //   471: putfield 273	com/tencent/mm/ui/u$c:uUh	Z
    //   474: aload_0
    //   475: aload_0
    //   476: getfield 45	com/tencent/mm/ui/t:uTV	I
    //   479: iconst_1
    //   480: iadd
    //   481: putfield 45	com/tencent/mm/ui/t:uTV	I
    //   484: iload_3
    //   485: iconst_1
    //   486: iadd
    //   487: istore 4
    //   489: iload_2
    //   490: iconst_1
    //   491: iadd
    //   492: istore_2
    //   493: iload 4
    //   495: istore_3
    //   496: goto -157 -> 339
    //   499: ldc -102
    //   501: ldc_w 275
    //   504: iconst_1
    //   505: anewarray 4	java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: aload_0
    //   511: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   514: invokevirtual 217	java/util/ArrayList:size	()I
    //   517: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   520: aastore
    //   521: invokestatic 170	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   524: aload_0
    //   525: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   528: invokevirtual 217	java/util/ArrayList:size	()I
    //   531: ifne +59 -> 590
    //   534: aload_0
    //   535: getfield 55	com/tencent/mm/ui/t:uTX	Landroid/util/SparseArray;
    //   538: invokevirtual 171	android/util/SparseArray:clear	()V
    //   541: aload_0
    //   542: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   545: invokevirtual 172	java/util/ArrayList:clear	()V
    //   548: invokestatic 144	com/tencent/mm/i/g:sV	()Lcom/tencent/mm/i/e;
    //   551: ldc_w 277
    //   554: invokevirtual 281	com/tencent/mm/i/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   557: astore 8
    //   559: aload 8
    //   561: invokestatic 104	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   564: ifne +26 -> 590
    //   567: aload 8
    //   569: ldc_w 277
    //   572: invokestatic 194	com/tencent/mm/sdk/platformtools/bg:q	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   575: astore 9
    //   577: aload 9
    //   579: ifnonnull +62 -> 641
    //   582: ldc -102
    //   584: ldc_w 283
    //   587: invokestatic 287	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload_0
    //   591: monitorexit
    //   592: aload_0
    //   593: getfield 55	com/tencent/mm/ui/t:uTX	Landroid/util/SparseArray;
    //   596: invokevirtual 130	android/util/SparseArray:size	()I
    //   599: ifeq +7 -> 606
    //   602: aload_0
    //   603: invokespecial 289	com/tencent/mm/ui/t:bQp	()V
    //   606: aload_0
    //   607: invokestatic 136	java/lang/System:currentTimeMillis	()J
    //   610: putfield 64	com/tencent/mm/ui/t:timestamp	J
    //   613: ldc -102
    //   615: ldc_w 291
    //   618: iconst_1
    //   619: anewarray 4	java/lang/Object
    //   622: dup
    //   623: iconst_0
    //   624: aload_0
    //   625: getfield 64	com/tencent/mm/ui/t:timestamp	J
    //   628: lload 6
    //   630: lsub
    //   631: invokestatic 296	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   634: aastore
    //   635: invokestatic 299	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   638: goto -315 -> 323
    //   641: iconst_0
    //   642: istore_2
    //   643: iload_2
    //   644: bipush 100
    //   646: if_icmpge -56 -> 590
    //   649: new 301	java/lang/StringBuilder
    //   652: dup
    //   653: ldc_w 303
    //   656: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   659: astore 10
    //   661: iload_2
    //   662: ifne +215 -> 877
    //   665: ldc -24
    //   667: astore 8
    //   669: aload 10
    //   671: aload 8
    //   673: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: astore 11
    //   681: aload 9
    //   683: new 301	java/lang/StringBuilder
    //   686: dup
    //   687: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   690: aload 11
    //   692: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: ldc_w 320
    //   698: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokeinterface 202 2 0
    //   709: checkcast 98	java/lang/String
    //   712: astore 8
    //   714: aload 8
    //   716: ifnull -126 -> 590
    //   719: aload 8
    //   721: invokestatic 104	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   724: ifne -134 -> 590
    //   727: aload 9
    //   729: new 301	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   736: aload 11
    //   738: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: ldc_w 322
    //   744: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokeinterface 202 2 0
    //   755: checkcast 98	java/lang/String
    //   758: astore 10
    //   760: aload 9
    //   762: new 301	java/lang/StringBuilder
    //   765: dup
    //   766: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   769: aload 11
    //   771: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: ldc_w 324
    //   777: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: invokeinterface 202 2 0
    //   788: checkcast 98	java/lang/String
    //   791: astore 11
    //   793: ldc -102
    //   795: ldc_w 326
    //   798: iconst_3
    //   799: anewarray 4	java/lang/Object
    //   802: dup
    //   803: iconst_0
    //   804: aload 8
    //   806: aastore
    //   807: dup
    //   808: iconst_1
    //   809: aload 10
    //   811: aastore
    //   812: dup
    //   813: iconst_2
    //   814: aload 11
    //   816: aastore
    //   817: invokestatic 299	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   820: aload_0
    //   821: getfield 55	com/tencent/mm/ui/t:uTX	Landroid/util/SparseArray;
    //   824: aload 8
    //   826: invokestatic 116	com/tencent/mm/sdk/platformtools/bf:PX	(Ljava/lang/String;)I
    //   829: new 210	com/tencent/mm/ui/u$b
    //   832: dup
    //   833: aload 8
    //   835: invokestatic 116	com/tencent/mm/sdk/platformtools/bf:PX	(Ljava/lang/String;)I
    //   838: aload 10
    //   840: invokestatic 116	com/tencent/mm/sdk/platformtools/bf:PX	(Ljava/lang/String;)I
    //   843: aload 11
    //   845: invokestatic 116	com/tencent/mm/sdk/platformtools/bf:PX	(Ljava/lang/String;)I
    //   848: invokespecial 329	com/tencent/mm/ui/u$b:<init>	(III)V
    //   851: invokevirtual 216	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   854: aload_0
    //   855: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   858: aload 8
    //   860: invokestatic 116	com/tencent/mm/sdk/platformtools/bf:PX	(Ljava/lang/String;)I
    //   863: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   866: invokevirtual 332	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   869: pop
    //   870: iload_2
    //   871: iconst_1
    //   872: iadd
    //   873: istore_2
    //   874: goto -231 -> 643
    //   877: iload_2
    //   878: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   881: astore 8
    //   883: goto -214 -> 669
    //   886: ldc -102
    //   888: ldc_w 334
    //   891: iconst_2
    //   892: anewarray 4	java/lang/Object
    //   895: dup
    //   896: iconst_0
    //   897: aload_0
    //   898: getfield 60	com/tencent/mm/ui/t:uTY	Ljava/util/ArrayList;
    //   901: invokevirtual 217	java/util/ArrayList:size	()I
    //   904: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   907: aastore
    //   908: dup
    //   909: iconst_1
    //   910: aload_0
    //   911: getfield 62	com/tencent/mm/ui/t:uTZ	Landroid/util/SparseArray;
    //   914: invokevirtual 130	android/util/SparseArray:size	()I
    //   917: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   920: aastore
    //   921: invokestatic 170	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   924: invokestatic 339	com/tencent/mm/sdk/platformtools/f:bIq	()Z
    //   927: ifne +34 -> 961
    //   930: aload_0
    //   931: getfield 62	com/tencent/mm/ui/t:uTZ	Landroid/util/SparseArray;
    //   934: iload_3
    //   935: new 244	com/tencent/mm/ui/u$c
    //   938: dup
    //   939: ldc_w 340
    //   942: invokestatic 242	com/tencent/mm/ui/u:zr	(I)Lcom/tencent/mm/ui/u$d;
    //   945: invokespecial 247	com/tencent/mm/ui/u$c:<init>	(Lcom/tencent/mm/ui/u$d;)V
    //   948: invokevirtual 216	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   951: ldc2_w 125
    //   954: sipush 15519
    //   957: invokestatic 37	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   960: return
    //   961: aload_0
    //   962: getfield 62	com/tencent/mm/ui/t:uTZ	Landroid/util/SparseArray;
    //   965: iload_3
    //   966: new 244	com/tencent/mm/ui/u$c
    //   969: dup
    //   970: ldc_w 341
    //   973: invokestatic 242	com/tencent/mm/ui/u:zr	(I)Lcom/tencent/mm/ui/u$d;
    //   976: invokespecial 247	com/tencent/mm/ui/u$c:<init>	(Lcom/tencent/mm/ui/u$d;)V
    //   979: invokevirtual 216	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   982: ldc2_w 125
    //   985: sipush 15519
    //   988: invokestatic 37	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   991: return
    //   992: iconst_1
    //   993: istore_2
    //   994: iload_2
    //   995: ifeq -672 -> 323
    //   998: goto -957 -> 41
    //   1001: iconst_0
    //   1002: istore_2
    //   1003: goto -9 -> 994
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	this	t
    //   0	1006	1	paramBoolean	boolean
    //   178	825	2	i	int
    //   162	804	3	j	int
    //   211	283	4	k	int
    //   194	257	5	m	int
    //   44	585	6	l	long
    //   54	62	8	localObject1	Object
    //   301	5	8	localObject2	Object
    //   308	5	8	localException	Exception
    //   378	504	8	localObject3	Object
    //   130	631	9	localObject4	Object
    //   659	180	10	localObject5	Object
    //   679	165	11	str	String
    // Exception table:
    //   from	to	target	type
    //   82	105	301	finally
    //   105	132	301	finally
    //   137	234	301	finally
    //   236	279	301	finally
    //   286	298	301	finally
    //   303	305	301	finally
    //   499	577	301	finally
    //   582	590	301	finally
    //   590	592	301	finally
    //   649	661	301	finally
    //   669	714	301	finally
    //   719	870	301	finally
    //   13	38	308	java/lang/Exception
    //   41	82	308	java/lang/Exception
    //   305	308	308	java/lang/Exception
    //   592	606	308	java/lang/Exception
    //   606	638	308	java/lang/Exception
  }
  
  public final void zq(int paramInt)
  {
    GMTrace.i(2082790703104L, 15518);
    if (this.uTX.size() != 0)
    {
      Object localObject = (u.b)this.uTX.get(paramInt);
      if ((localObject != null) && (((u.b)localObject).uUf == 1))
      {
        this.uTW.put(((u.b)localObject).id, ((u.b)localObject).hTc);
        this.uTV -= 1;
        if (this.uUa)
        {
          localObject = new StringBuffer();
          paramInt = 0;
          while (paramInt < this.uTW.size())
          {
            int i = this.uTW.keyAt(paramInt);
            int j = this.uTW.get(i);
            ((StringBuffer)localObject).append(i);
            ((StringBuffer)localObject).append(":");
            ((StringBuffer)localObject).append(Integer.valueOf(j));
            ((StringBuffer)localObject).append("|");
            paramInt += 1;
          }
          ap.yY();
          c.vr().set(299010, ((StringBuffer)localObject).toString());
        }
      }
    }
    GMTrace.o(2082790703104L, 15518);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */