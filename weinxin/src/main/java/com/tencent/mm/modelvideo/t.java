package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class t
{
  public static boolean H(String paramString, int paramInt)
  {
    int i = 0;
    GMTrace.i(358092898304L, 2668);
    r localr = lI(paramString);
    if (localr == null)
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + paramString);
      GMTrace.o(358092898304L, 2668);
      return false;
    }
    if (paramInt != localr.hrb)
    {
      v.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localr.hrb) });
      localr.hrb = paramInt;
      i = 32;
    }
    localr.hZP = paramInt;
    localr.hZT = bf.Nz();
    d(localr);
    localr.status = 199;
    localr.fRM = (i | 0x510);
    boolean bool = e(localr);
    v.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localr.hrb + " status:" + localr.status + " netTimes:" + localr.hZX + " update ret: " + bool);
    GMTrace.o(358092898304L, 2668);
    return bool;
  }
  
  public static void I(String paramString, int paramInt)
  {
    GMTrace.i(359971946496L, 2682);
    paramString = lI(paramString);
    if (paramString != null)
    {
      paramString.status = 122;
      paramString.hZU = bf.Nz();
      paramString.hZT = bf.Nz();
      paramString.hzd = paramInt;
      paramString.fRM = 268438784;
      boolean bool = o.KW().b(paramString);
      v.i("MicroMsg.VideoLogic", "set online video Completion ret: " + bool + " status: " + paramString.status);
    }
    GMTrace.o(359971946496L, 2682);
  }
  
  public static boolean J(String paramString, int paramInt)
  {
    GMTrace.i(360240381952L, 2684);
    boolean bool = b(lI(paramString), paramInt);
    GMTrace.o(360240381952L, 2684);
    return bool;
  }
  
  public static long a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    GMTrace.i(356884938752L, 2659);
    if (bf.mA(paramString1))
    {
      v.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", new Object[] { Integer.valueOf(paramInt2) });
      GMTrace.o(356884938752L, 2659);
      return -1L;
    }
    if (bf.mA(paramString2))
    {
      v.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", new Object[] { Integer.valueOf(paramInt2) });
      GMTrace.o(356884938752L, 2659);
      return -1L;
    }
    r localr = new r();
    localr.fyw = paramString1;
    localr.hZV = 1;
    localr.fRV = paramString2;
    localr.hZN = ((String)com.tencent.mm.kernel.h.vI().vr().get(2, ""));
    localr.hZS = bf.Nz();
    localr.hZT = bf.Nz();
    localr.iab = null;
    localr.hXD = paramString3;
    if (!bf.mA(paramString3)) {
      localr.hZZ = 1;
    }
    if (62 == paramInt2)
    {
      localr.hZZ = 0;
      paramInt1 = 3;
    }
    for (;;)
    {
      localr.iac = paramInt1;
      localr.hrb = 0;
      localr.status = 106;
      paramString2 = new au();
      paramString2.cH(localr.Lf());
      paramString2.setType(paramInt2);
      paramString2.dw(1);
      paramString2.cI(paramString1);
      paramString2.dv(8);
      paramString2.z(ay.gk(localr.Lf()));
      long l = ay.i(paramString2);
      localr.hZW = ((int)l);
      if (!o.KW().a(localr)) {
        break;
      }
      GMTrace.o(356884938752L, 2659);
      return l;
      if (localr.hZZ == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = -1;
      }
    }
    GMTrace.o(356884938752L, 2659);
    return -1L;
  }
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3)
  {
    GMTrace.i(356616503296L, 2657);
    boolean bool = a(paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramInt3, null, "");
    GMTrace.o(356616503296L, 2657);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, bdq parambdq, String paramString5)
  {
    GMTrace.i(356750721024L, 2658);
    r localr = new r();
    localr.fyw = paramString1;
    localr.hZV = paramInt1;
    localr.fRV = paramString2;
    localr.hZN = ((String)com.tencent.mm.kernel.h.vI().vr().get(2, ""));
    localr.hZS = bf.Nz();
    localr.hZT = bf.Nz();
    localr.iab = paramString4;
    localr.hXD = paramString3;
    localr.iae = parambdq;
    localr.fUO = paramString5;
    if (!bf.mA(paramString3)) {
      localr.hZZ = 1;
    }
    if (paramInt2 > 0) {
      localr.hZZ = 1;
    }
    if (62 == paramInt3) {
      localr.iac = 3;
    }
    for (;;)
    {
      o.KW();
      paramInt1 = s.ly(s.lw(paramString1));
      if (paramInt1 > 0) {
        break;
      }
      v.e("MicroMsg.VideoLogic", "get Video size failed :" + paramString1);
      GMTrace.o(356750721024L, 2658);
      return false;
      if (paramInt2 > 0) {
        localr.iac = 2;
      } else {
        localr.iac = 1;
      }
    }
    localr.hrb = paramInt1;
    o.KW();
    paramString2 = s.lx(paramString1);
    paramInt1 = s.ly(paramString2);
    if (paramInt1 <= 0)
    {
      v.e("MicroMsg.VideoLogic", "get Thumb size failed :" + paramString2 + " size:" + paramInt1);
      GMTrace.o(356750721024L, 2658);
      return false;
    }
    localr.hZR = paramInt1;
    v.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + localr.hZR + " videosize:" + localr.hrb + " msgType:" + paramInt3);
    localr.status = 102;
    paramString2 = new au();
    paramString2.cH(localr.Lf());
    paramString2.setType(paramInt3);
    paramString2.dw(1);
    paramString2.cI(paramString1);
    paramString2.dv(1);
    paramString2.z(ay.gk(localr.Lf()));
    localr.hZW = ((int)ay.i(paramString2));
    boolean bool = o.KW().a(localr);
    GMTrace.o(356750721024L, 2658);
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: ldc2_w 303
    //   3: sipush 2686
    //   6: invokestatic 14	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: invokestatic 157	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   13: ifeq +22 -> 35
    //   16: ldc 20
    //   18: ldc_w 306
    //   21: invokestatic 308	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc2_w 303
    //   27: sipush 2686
    //   30: invokestatic 52	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   33: iconst_0
    //   34: ireturn
    //   35: new 310	android/media/MediaMetadataRetriever
    //   38: dup
    //   39: invokespecial 311	android/media/MediaMetadataRetriever:<init>	()V
    //   42: astore 4
    //   44: aload 4
    //   46: astore_3
    //   47: aload 4
    //   49: aload_0
    //   50: invokevirtual 314	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   53: aload 4
    //   55: astore_3
    //   56: aload_1
    //   57: aload 4
    //   59: bipush 9
    //   61: invokevirtual 318	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   64: iconst_0
    //   65: invokestatic 322	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   68: i2l
    //   69: invokestatic 326	com/tencent/mm/sdk/platformtools/bf:ex	(J)I
    //   72: putfield 331	com/tencent/mm/pointers/PInt:value	I
    //   75: aload 4
    //   77: astore_3
    //   78: aload_2
    //   79: aload 4
    //   81: bipush 20
    //   83: invokevirtual 318	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   86: iconst_0
    //   87: invokestatic 322	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   90: sipush 1000
    //   93: idiv
    //   94: putfield 331	com/tencent/mm/pointers/PInt:value	I
    //   97: aload 4
    //   99: invokevirtual 334	android/media/MediaMetadataRetriever:release	()V
    //   102: ldc 20
    //   104: ldc_w 336
    //   107: iconst_3
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_2
    //   114: getfield 331	com/tencent/mm/pointers/PInt:value	I
    //   117: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_1
    //   124: getfield 331	com/tencent/mm/pointers/PInt:value	I
    //   127: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aastore
    //   131: dup
    //   132: iconst_2
    //   133: aload_0
    //   134: aastore
    //   135: invokestatic 338	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: ldc2_w 303
    //   141: sipush 2686
    //   144: invokestatic 52	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   147: iconst_1
    //   148: ireturn
    //   149: astore 5
    //   151: aconst_null
    //   152: astore 4
    //   154: aload 4
    //   156: astore_3
    //   157: ldc 20
    //   159: aload 5
    //   161: ldc_w 340
    //   164: iconst_1
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_0
    //   171: aastore
    //   172: invokestatic 344	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload 4
    //   177: ifnull -75 -> 102
    //   180: aload 4
    //   182: invokevirtual 334	android/media/MediaMetadataRetriever:release	()V
    //   185: goto -83 -> 102
    //   188: astore_0
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 334	android/media/MediaMetadataRetriever:release	()V
    //   199: aload_0
    //   200: athrow
    //   201: astore_0
    //   202: goto -11 -> 191
    //   205: astore 5
    //   207: goto -53 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramString	String
    //   0	210	1	paramPInt1	PInt
    //   0	210	2	paramPInt2	PInt
    //   46	150	3	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   42	139	4	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    //   149	11	5	localException1	Exception
    //   205	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   35	44	149	java/lang/Exception
    //   35	44	188	finally
    //   47	53	201	finally
    //   56	75	201	finally
    //   78	97	201	finally
    //   157	175	201	finally
    //   47	53	205	java/lang/Exception
    //   56	75	205	java/lang/Exception
    //   78	97	205	java/lang/Exception
  }
  
  public static int av(long paramLong)
  {
    GMTrace.i(357421809664L, 2663);
    Object localObject = o.KW().au(paramLong).iterator();
    while (((Iterator)localObject).hasNext())
    {
      r localr = (r)((Iterator)localObject).next();
      int i = localr.status;
      localr.status = 200;
      v.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.sd() + "startSend file:" + localr.getFileName() + " status:[" + i + "->" + localr.status + "]");
      localr.hZU = bf.Nz();
      localr.hZT = bf.Nz();
      localr.fRM = 3328;
      if (!e(localr))
      {
        v.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + localr.getFileName());
        i = com.tencent.mm.compatible.util.g.sb();
        GMTrace.o(357421809664L, 2663);
        return 0 - i;
      }
    }
    localObject = o.Lc();
    com.tencent.mm.kernel.h.vL().D(new m.3((m)localObject));
    GMTrace.o(357421809664L, 2663);
    return 0;
  }
  
  public static boolean b(r paramr, int paramInt)
  {
    GMTrace.i(360374599680L, 2685);
    if (paramr != null)
    {
      paramr.hzd = paramInt;
      paramr.fRM = 268435456;
      boolean bool = e(paramr);
      GMTrace.o(360374599680L, 2685);
      return bool;
    }
    GMTrace.o(360374599680L, 2685);
    return false;
  }
  
  public static boolean b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    GMTrace.i(356482285568L, 2656);
    boolean bool = a(paramString1, paramInt, paramString2, paramString3, 0, "", 43);
    GMTrace.o(356482285568L, 2656);
    return bool;
  }
  
  public static void c(r paramr)
  {
    GMTrace.i(357556027392L, 2664);
    if (paramr == null)
    {
      v.e("MicroMsg.VideoLogic", "video info is null");
      GMTrace.o(357556027392L, 2664);
      return;
    }
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramr.hZW);
    int i = localau.field_type;
    v.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      GMTrace.o(357556027392L, 2664);
      return;
    }
    localau.dw(1);
    localau.cH(paramr.Lf());
    localau.y(paramr.fTG);
    localau.dv(2);
    localau.setContent(p.b(paramr.Lg(), paramr.hZV, false));
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramr.hZW, localau);
    v.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localau.field_msgId) });
    GMTrace.o(357556027392L, 2664);
  }
  
  public static void d(String paramString, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(359435075584L, 2678);
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", new Object[] { paramString });
      GMTrace.o(359435075584L, 2678);
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    i /= 1000;
    long l1 = bf.NB();
    w localw;
    ContentValues localContentValues;
    long l2;
    boolean bool;
    if (!o.KZ().lO(paramString))
    {
      localw = o.KZ();
      int j = (int)(bf.NA() / 1000L);
      if (paramBoolean)
      {
        paramInt = 1;
        if (bf.mA(paramString)) {
          break label272;
        }
        localContentValues = new ContentValues();
        localContentValues.put("filename", paramString);
        localContentValues.put("starttime", Integer.valueOf(j));
        localContentValues.put("playduration", Integer.valueOf(i));
        localContentValues.put("downloadway", Integer.valueOf(paramInt));
        l2 = localw.gUp.insert("VideoPlayHistory", "filename", localContentValues);
        v.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : " + l2);
        if (l2 <= 0L) {
          break label272;
        }
        bool = true;
      }
    }
    for (;;)
    {
      v.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean), Long.valueOf(bf.aB(l1)) });
      GMTrace.o(359435075584L, 2678);
      return;
      paramInt = 0;
      break;
      label272:
      bool = false;
      continue;
      localw = o.KZ();
      paramInt = (int)(bf.NA() / 1000L);
      if (!bf.mA(paramString))
      {
        localContentValues = new ContentValues();
        localContentValues.put("starttime", Integer.valueOf(paramInt));
        localContentValues.put("playduration", Integer.valueOf(i));
        l2 = localw.gUp.update("VideoPlayHistory", localContentValues, "filename=?", new String[] { paramString });
        v.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : " + l2);
        if (l2 > 0L)
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
  }
  
  static boolean d(r paramr)
  {
    GMTrace.i(357690245120L, 2665);
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramr.hZW);
    int i = localau.field_type;
    v.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      GMTrace.o(357690245120L, 2665);
      return false;
    }
    localau.y(paramr.fTG);
    localau.setContent(p.b(paramr.Lg(), paramr.hZV, false));
    localau.cH(paramr.Lf());
    v.d("MicroMsg.VideoLogic", "set msg content :" + localau.field_content);
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().b(paramr.fTG, localau);
    v.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localau.field_msgId) });
    if (localau.bMc()) {
      v.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[] { Integer.valueOf(paramr.hrb) });
    }
    GMTrace.o(357690245120L, 2665);
    return true;
  }
  
  public static int e(long paramLong, String paramString)
  {
    GMTrace.i(359837728768L, 2681);
    if (bf.mA(paramString))
    {
      GMTrace.o(359837728768L, 2681);
      return -1;
    }
    try
    {
      paramString = paramString.split("_");
      int i;
      if (paramString != null)
      {
        i = paramString.length;
        if (i == 2) {}
      }
      else
      {
        GMTrace.o(359837728768L, 2681);
        return -1;
      }
      if (bf.getLong(paramString[0], 0L) == paramLong)
      {
        i = bf.getInt(paramString[1], 0);
        GMTrace.o(359837728768L, 2681);
        return i;
      }
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + paramString.toString());
      GMTrace.o(359837728768L, 2681);
    }
    return -1;
  }
  
  public static String e(long paramLong, int paramInt)
  {
    GMTrace.i(359703511040L, 2680);
    String str = paramLong + "_" + paramInt;
    GMTrace.o(359703511040L, 2680);
    return str;
  }
  
  public static boolean e(r paramr)
  {
    GMTrace.i(358629769216L, 2672);
    if (paramr == null)
    {
      GMTrace.o(358629769216L, 2672);
      return false;
    }
    if (((paramr.getFileName() == null) || (paramr.getFileName().length() <= 0)) && (paramr.fRM == -1))
    {
      GMTrace.o(358629769216L, 2672);
      return false;
    }
    boolean bool = o.KW().b(paramr);
    GMTrace.o(358629769216L, 2672);
    return bool;
  }
  
  public static int f(r paramr)
  {
    GMTrace.i(358898204672L, 2674);
    if (paramr.hrb == 0)
    {
      GMTrace.o(358898204672L, 2674);
      return 0;
    }
    v.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + paramr.hZP + " " + paramr.hrb);
    int i = paramr.hZP * 100 / paramr.hrb;
    GMTrace.o(358898204672L, 2674);
    return i;
  }
  
  public static int g(r paramr)
  {
    GMTrace.i(359032422400L, 2675);
    if (paramr.hrb == 0)
    {
      GMTrace.o(359032422400L, 2675);
      return 0;
    }
    v.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + paramr.hYB + " " + paramr.hrb);
    int i = paramr.hYB * 100 / paramr.hrb;
    GMTrace.o(359032422400L, 2675);
    return i;
  }
  
  public static void i(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(357153374208L, 2661);
    r localr = lI(paramString);
    if (localr == null)
    {
      v.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      GMTrace.o(357153374208L, 2661);
      return;
    }
    o.KW();
    int i = s.ly(s.lw(paramString));
    v.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    localr.hrb = i;
    localr.hZV = paramInt1;
    Object localObject = localr.iaf;
    ((akp)localObject).tMF = false;
    localr.iaf = ((akp)localObject);
    localr.status = 102;
    o.KW();
    localr.hZR = s.ly(s.lx(paramString));
    v.i("MicroMsg.VideoLogic", "update prepare:" + paramString + " thumbsize:" + localr.hZR);
    localr.fRM = 4512;
    v.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[] { Boolean.valueOf(e(localr)), Integer.valueOf(paramInt2) });
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(localr.hZW);
    v.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ce)localObject).field_msgId), Long.valueOf(((ce)localObject).field_msgSvrId), ((ce)localObject).field_talker, Integer.valueOf(((ce)localObject).field_type), Integer.valueOf(((ce)localObject).field_isSend), ((ce)localObject).field_imgPath, Integer.valueOf(((ce)localObject).field_status), Long.valueOf(((ce)localObject).field_createTime) });
    ((au)localObject).cH(localr.Lf());
    ((au)localObject).setType(paramInt2);
    ((au)localObject).dw(1);
    ((au)localObject).cI(paramString);
    ((au)localObject).dv(1);
    v.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ce)localObject).field_msgId), Long.valueOf(((ce)localObject).field_msgSvrId), ((ce)localObject).field_talker, Integer.valueOf(((ce)localObject).field_type), Integer.valueOf(((ce)localObject).field_isSend), ((ce)localObject).field_imgPath, Integer.valueOf(((ce)localObject).field_status), Long.valueOf(((ce)localObject).field_createTime) });
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(localr.hZW, (au)localObject);
    GMTrace.o(357153374208L, 2661);
  }
  
  public static boolean lA(String paramString)
  {
    GMTrace.i(355945414656L, 2652);
    if (paramString == null)
    {
      GMTrace.o(355945414656L, 2652);
      return false;
    }
    paramString = lI(paramString);
    if (paramString == null)
    {
      GMTrace.o(355945414656L, 2652);
      return false;
    }
    if (paramString.hZX >= 2500)
    {
      GMTrace.o(355945414656L, 2652);
      return false;
    }
    paramString.hZX += 1;
    paramString.fRM = 16384;
    boolean bool = e(paramString);
    GMTrace.o(355945414656L, 2652);
    return bool;
  }
  
  public static boolean lB(String paramString)
  {
    GMTrace.i(356079632384L, 2653);
    com.tencent.mm.plugin.report.service.g.oSF.a(111L, 218L, 1L, false);
    v.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[] { paramString, bf.bJP() });
    o.Lb().fBb.remove(paramString);
    if (paramString == null)
    {
      GMTrace.o(356079632384L, 2653);
      return false;
    }
    r localr = lI(paramString);
    if (localr == null)
    {
      v.e("MicroMsg.VideoLogic", "Set error failed file:" + paramString);
      GMTrace.o(356079632384L, 2653);
      return false;
    }
    localr.status = 198;
    localr.hZT = (System.currentTimeMillis() / 1000L);
    localr.fRM = 1280;
    akp localakp = localr.iaf;
    localakp.tMH = 0;
    localr.iaf = localakp;
    boolean bool = e(localr);
    v.d("MicroMsg.VideoLogic", "setError file:" + paramString + " msgid:" + localr.hZW + " old stat:" + localr.status);
    if ((localr == null) || (localr.hZW == 0))
    {
      GMTrace.o(356079632384L, 2653);
      return bool;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(localr.hZW);
    int i = paramString.field_type;
    v.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      GMTrace.o(356079632384L, 2653);
      return bool;
    }
    com.tencent.mm.plugin.report.c.oRz.a(111L, 32L, 1L, true);
    paramString.cH(localr.Lf());
    paramString.setContent(p.b(localr.Lg(), -1L, true));
    v.d("MicroMsg.VideoLogic", "[oneliang][setError]");
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramString.field_msgId, paramString);
    GMTrace.o(356079632384L, 2653);
    return bool;
  }
  
  public static boolean lC(String paramString)
  {
    GMTrace.i(356213850112L, 2654);
    paramString = lI(paramString);
    if ((paramString == null) || (paramString.hZW == 0))
    {
      GMTrace.o(356213850112L, 2654);
      return false;
    }
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramString.hZW);
    int i = localau.field_type;
    v.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      GMTrace.o(356213850112L, 2654);
      return false;
    }
    localau.setContent(p.b(paramString.Lg(), paramString.hZV, false));
    localau.dv(2);
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramString.hZW, localau);
    paramString.status = 197;
    paramString.hZT = bf.Nz();
    paramString.fRM = 1280;
    v.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
    boolean bool = e(paramString);
    GMTrace.o(356213850112L, 2654);
    return bool;
  }
  
  public static int lD(String paramString)
  {
    GMTrace.i(357287591936L, 2662);
    r localr = lI(paramString);
    if (localr == null)
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(357287591936L, 2662);
      return 0 - i;
    }
    if ((localr.status != 102) && (localr.status != 105))
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " get status failed: " + paramString + " status:" + localr.status);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(357287591936L, 2662);
      return 0 - i;
    }
    int i = localr.status;
    if ((localr.status != 102) && (localr.hZR == localr.hZQ)) {}
    for (localr.status = 104;; localr.status = 103)
    {
      v.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.sd() + "startSend file:" + paramString + " status:[" + i + "->" + localr.status + "]");
      localr.hZU = bf.Nz();
      localr.hZT = bf.Nz();
      localr.fRM = 3328;
      if (e(localr)) {
        break;
      }
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(357287591936L, 2662);
      return 0 - i;
    }
    o.Lb().run();
    GMTrace.o(357287591936L, 2662);
    return 0;
  }
  
  public static int lE(String paramString)
  {
    GMTrace.i(357824462848L, 2666);
    r localr = lI(paramString);
    int i;
    if (localr == null)
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(357824462848L, 2666);
      return 0 - i;
    }
    if ((localr.status != 111) && (localr.status != 113) && (localr.status != 121) && (localr.status != 122))
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " get status failed: " + paramString + " status:" + localr.status);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(357824462848L, 2666);
      return 0 - i;
    }
    localr.status = 112;
    localr.hZU = bf.Nz();
    localr.hZT = bf.Nz();
    localr.fRM = 3328;
    if (!e(localr))
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(357824462848L, 2666);
      return 0 - i;
    }
    o.Lb().Lu();
    o.Lb().run();
    GMTrace.o(357824462848L, 2666);
    return 0;
  }
  
  public static int lF(String paramString)
  {
    GMTrace.i(357958680576L, 2667);
    r localr = lI(paramString);
    int i;
    if (localr == null)
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(357958680576L, 2667);
      return 0 - i;
    }
    if ((localr.status != 112) && (localr.status != 120) && (localr.status != 122))
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " get status failed: " + paramString + " status:" + localr.status);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(357958680576L, 2667);
      return 0 - i;
    }
    localr.status = 113;
    localr.hZT = bf.Nz();
    localr.fRM = 1280;
    if (!e(localr))
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(357958680576L, 2667);
      return 0 - i;
    }
    GMTrace.o(357958680576L, 2667);
    return 0;
  }
  
  public static boolean lG(String paramString)
  {
    GMTrace.i(358227116032L, 2669);
    v.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : " + paramString);
    r localr = new r();
    localr.status = 112;
    localr.hZT = bf.Nz();
    localr.hZU = bf.Nz();
    localr.fyw = paramString;
    localr.fRM = 3328;
    if (!e(localr))
    {
      GMTrace.o(358227116032L, 2669);
      return false;
    }
    o.Lb().run();
    GMTrace.o(358227116032L, 2669);
    return true;
  }
  
  public static boolean lH(String paramString)
  {
    GMTrace.i(358361333760L, 2670);
    r localr = lI(paramString);
    if (localr == null)
    {
      GMTrace.o(358361333760L, 2670);
      return false;
    }
    v.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[] { paramString });
    paramString = localr.iaf;
    if (paramString != null)
    {
      paramString.tMH = 0;
      localr.iaf = paramString;
    }
    if (localr.hZQ < localr.hZR) {}
    for (localr.status = 103;; localr.status = 104)
    {
      localr.hZS = bf.Nz();
      localr.hZT = bf.Nz();
      localr.hZU = bf.Nz();
      localr.fRM = 536874752;
      if (e(localr)) {
        break;
      }
      GMTrace.o(358361333760L, 2670);
      return false;
    }
    o.Lb().run();
    GMTrace.o(358361333760L, 2670);
    return true;
  }
  
  public static r lI(String paramString)
  {
    GMTrace.i(358495551488L, 2671);
    if (bf.mA(paramString))
    {
      GMTrace.o(358495551488L, 2671);
      return null;
    }
    paramString = o.KW().lt(paramString);
    GMTrace.o(358495551488L, 2671);
    return paramString;
  }
  
  public static String lJ(String paramString)
  {
    GMTrace.i(358763986944L, 2673);
    String str = com.tencent.mm.compatible.util.e.gSp + bf.NA() + ".mp4";
    if (!j.ex(paramString, str))
    {
      GMTrace.o(358763986944L, 2673);
      return null;
    }
    GMTrace.o(358763986944L, 2673);
    return str;
  }
  
  public static boolean lK(String paramString)
  {
    GMTrace.i(359166640128L, 2676);
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
      GMTrace.o(359166640128L, 2676);
      return false;
    }
    v.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: " + paramString);
    Object localObject = lI(paramString);
    if ((localObject != null) && (((r)localObject).status == 199))
    {
      int i = ((r)localObject).hrb;
      o.KW();
      int j = com.tencent.mm.a.e.aN(s.lw(paramString));
      v.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j > 0) && (Math.abs(j - i) > 16))
      {
        v.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramString = ((r)localObject).getFileName();
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 217L, 1L, false);
        paramString = lI(paramString);
        if (paramString != null)
        {
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramString.hZW);
          i = ((ce)localObject).field_type;
          v.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[] { Integer.valueOf(i) });
          if ((43 == i) || (62 == i))
          {
            ((au)localObject).setContent(p.b(paramString.Lg(), paramString.hZV, false));
            ((au)localObject).dv(2);
            ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramString.hZW, (au)localObject);
            paramString.status = 196;
            paramString.hZT = bf.Nz();
            paramString.fRM = 1280;
            v.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
            e(paramString);
          }
        }
        GMTrace.o(359166640128L, 2676);
        return true;
      }
    }
    GMTrace.o(359166640128L, 2676);
    return false;
  }
  
  public static void lL(String paramString)
  {
    boolean bool = true;
    GMTrace.i(359569293312L, 2679);
    if (bf.mA(paramString))
    {
      GMTrace.o(359569293312L, 2679);
      return;
    }
    if (o.KZ().gUp.delete("VideoPlayHistory", "filename= ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      v.d("MicroMsg.VideoLogic", "delete video play history ret : " + bool + " filename : " + paramString);
      GMTrace.o(359569293312L, 2679);
      return;
      bool = false;
    }
  }
  
  public static int lM(String paramString)
  {
    GMTrace.i(360106164224L, 2683);
    r localr = lI(paramString);
    if (localr == null)
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(360106164224L, 2683);
      return 0 - i;
    }
    if ((localr.status != 111) && (localr.status != 113) && (localr.status != 121) && (localr.status != 122))
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " get status failed: " + paramString + " status:" + localr.status);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(360106164224L, 2683);
      return 0 - i;
    }
    int i = 256;
    d.Ev();
    if (d.EA()) {
      localr.status = 122;
    }
    for (;;)
    {
      localr.hZU = bf.Nz();
      localr.hZT = bf.Nz();
      localr.fRM = (i | 0x800 | 0x400);
      if (e(localr)) {
        break;
      }
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(360106164224L, 2683);
      return 0 - i;
      v.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
      localr.status = 112;
      localr.hZP = 0;
      i = 272;
    }
    o.Lb().Lu();
    o.Lb().run();
    GMTrace.o(360106164224L, 2683);
    return 0;
  }
  
  public static int u(int paramInt, String paramString)
  {
    GMTrace.i(359300857856L, 2677);
    long l = bf.NB();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if ((o.KZ().b(paramString, localPInt1, localPInt2)) && (bf.az(localPInt1.value) < 300L)) {}
    for (int i = localPInt2.value;; i = 0)
    {
      int j;
      if (i >= 0)
      {
        j = i;
        if (i < paramInt - 1) {}
      }
      else
      {
        j = 0;
      }
      v.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localPInt1.value), paramString, Long.valueOf(bf.aB(l)) });
      GMTrace.o(359300857856L, 2677);
      return j;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */