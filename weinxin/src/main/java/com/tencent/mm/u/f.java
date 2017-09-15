package com.tencent.mm.u;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.ic;
import com.tencent.mm.e.a.lr;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.p.i;
import com.tencent.mm.platformtools.v.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import com.tencent.mm.y.d.c;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class f
  implements l
{
  private long hkO;
  public a hkP;
  
  public f()
  {
    GMTrace.i(14456054611968L, 107706);
    this.hkO = -1L;
    GMTrace.o(14456054611968L, 107706);
  }
  
  /* Error */
  private static String c(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc2_w 43
    //   3: ldc 45
    //   5: invokestatic 28	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: aload_0
    //   9: ldc 47
    //   11: invokevirtual 53	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14: ifeq +70 -> 84
    //   17: new 55	java/util/zip/ZipFile
    //   20: dup
    //   21: invokestatic 61	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   24: invokevirtual 67	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   27: getfield 73	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   30: invokespecial 76	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   33: astore 9
    //   35: aload 9
    //   37: aload 9
    //   39: aload_0
    //   40: iconst_1
    //   41: invokevirtual 80	java/lang/String:substring	(I)Ljava/lang/String;
    //   44: invokevirtual 84	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   47: invokevirtual 88	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   50: astore 8
    //   52: aload 9
    //   54: astore_0
    //   55: lload_1
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle +37 -> 95
    //   61: aload_0
    //   62: astore 10
    //   64: aload 8
    //   66: astore 9
    //   68: aload 8
    //   70: lload_1
    //   71: invokevirtual 94	java/io/InputStream:skip	(J)J
    //   74: lstore 6
    //   76: lload_1
    //   77: lload 6
    //   79: lsub
    //   80: lstore_1
    //   81: goto -26 -> 55
    //   84: aload_0
    //   85: invokestatic 100	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   88: astore 8
    //   90: aconst_null
    //   91: astore_0
    //   92: goto -37 -> 55
    //   95: aload_0
    //   96: astore 10
    //   98: aload 8
    //   100: astore 9
    //   102: ldc 102
    //   104: invokestatic 108	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   107: astore 11
    //   109: aload_0
    //   110: astore 10
    //   112: aload 8
    //   114: astore 9
    //   116: sipush 2048
    //   119: newarray <illegal type>
    //   121: astore 12
    //   123: lload_3
    //   124: lconst_0
    //   125: lcmp
    //   126: ifle +60 -> 186
    //   129: aload_0
    //   130: astore 10
    //   132: aload 8
    //   134: astore 9
    //   136: aload 8
    //   138: aload 12
    //   140: iconst_0
    //   141: ldc2_w 109
    //   144: lload_3
    //   145: invokestatic 116	java/lang/Math:min	(JJ)J
    //   148: l2i
    //   149: invokevirtual 120	java/io/InputStream:read	([BII)I
    //   152: istore 5
    //   154: iload 5
    //   156: iconst_m1
    //   157: if_icmpeq +29 -> 186
    //   160: aload_0
    //   161: astore 10
    //   163: aload 8
    //   165: astore 9
    //   167: aload 11
    //   169: aload 12
    //   171: iconst_0
    //   172: iload 5
    //   174: invokevirtual 124	java/security/MessageDigest:update	([BII)V
    //   177: lload_3
    //   178: iload 5
    //   180: i2l
    //   181: lsub
    //   182: lstore_3
    //   183: goto -60 -> 123
    //   186: aload_0
    //   187: astore 10
    //   189: aload 8
    //   191: astore 9
    //   193: aload 11
    //   195: invokevirtual 128	java/security/MessageDigest:digest	()[B
    //   198: invokestatic 134	com/tencent/mm/sdk/platformtools/bf:bo	([B)Ljava/lang/String;
    //   201: astore 11
    //   203: aload 8
    //   205: ifnull +8 -> 213
    //   208: aload 8
    //   210: invokevirtual 137	java/io/InputStream:close	()V
    //   213: aload_0
    //   214: ifnull +7 -> 221
    //   217: aload_0
    //   218: invokevirtual 138	java/util/zip/ZipFile:close	()V
    //   221: ldc2_w 43
    //   224: ldc 45
    //   226: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   229: aload 11
    //   231: areturn
    //   232: astore 11
    //   234: aconst_null
    //   235: astore_0
    //   236: aconst_null
    //   237: astore 8
    //   239: aload_0
    //   240: astore 10
    //   242: aload 8
    //   244: astore 9
    //   246: ldc -116
    //   248: aload 11
    //   250: ldc -114
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 148	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: aload 8
    //   261: ifnull +8 -> 269
    //   264: aload 8
    //   266: invokevirtual 137	java/io/InputStream:close	()V
    //   269: aload_0
    //   270: ifnull +7 -> 277
    //   273: aload_0
    //   274: invokevirtual 138	java/util/zip/ZipFile:close	()V
    //   277: ldc2_w 43
    //   280: ldc 45
    //   282: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   285: ldc -114
    //   287: areturn
    //   288: astore_0
    //   289: aconst_null
    //   290: astore 10
    //   292: aconst_null
    //   293: astore 9
    //   295: aload 9
    //   297: ifnull +8 -> 305
    //   300: aload 9
    //   302: invokevirtual 137	java/io/InputStream:close	()V
    //   305: aload 10
    //   307: ifnull +8 -> 315
    //   310: aload 10
    //   312: invokevirtual 138	java/util/zip/ZipFile:close	()V
    //   315: aload_0
    //   316: athrow
    //   317: astore 8
    //   319: goto -106 -> 213
    //   322: astore_0
    //   323: goto -102 -> 221
    //   326: astore 8
    //   328: goto -59 -> 269
    //   331: astore_0
    //   332: goto -55 -> 277
    //   335: astore 8
    //   337: goto -32 -> 305
    //   340: astore 8
    //   342: goto -27 -> 315
    //   345: astore_0
    //   346: aconst_null
    //   347: astore 8
    //   349: aload 9
    //   351: astore 10
    //   353: aload 8
    //   355: astore 9
    //   357: goto -62 -> 295
    //   360: astore_0
    //   361: goto -66 -> 295
    //   364: astore 11
    //   366: aconst_null
    //   367: astore 8
    //   369: aload 9
    //   371: astore_0
    //   372: goto -133 -> 239
    //   375: astore 11
    //   377: goto -138 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramString	String
    //   0	380	1	paramLong1	long
    //   0	380	3	paramLong2	long
    //   152	27	5	i	int
    //   74	4	6	l	long
    //   50	215	8	localInputStream	java.io.InputStream
    //   317	1	8	localIOException1	java.io.IOException
    //   326	1	8	localIOException2	java.io.IOException
    //   335	1	8	localIOException3	java.io.IOException
    //   340	1	8	localIOException4	java.io.IOException
    //   347	21	8	localObject1	Object
    //   33	337	9	localObject2	Object
    //   62	290	10	localObject3	Object
    //   107	123	11	localObject4	Object
    //   232	17	11	localException1	Exception
    //   364	1	11	localException2	Exception
    //   375	1	11	localException3	Exception
    //   121	49	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	35	232	java/lang/Exception
    //   84	90	232	java/lang/Exception
    //   8	35	288	finally
    //   84	90	288	finally
    //   208	213	317	java/io/IOException
    //   217	221	322	java/io/IOException
    //   264	269	326	java/io/IOException
    //   273	277	331	java/io/IOException
    //   300	305	335	java/io/IOException
    //   310	315	340	java/io/IOException
    //   35	52	345	finally
    //   68	76	360	finally
    //   102	109	360	finally
    //   116	123	360	finally
    //   136	154	360	finally
    //   167	177	360	finally
    //   193	203	360	finally
    //   246	259	360	finally
    //   35	52	364	java/lang/Exception
    //   68	76	375	java/lang/Exception
    //   102	109	375	java/lang/Exception
    //   116	123	375	java/lang/Exception
    //   136	154	375	java/lang/Exception
    //   167	177	375	java/lang/Exception
    //   193	203	375	java/lang/Exception
  }
  
  private static String c(Object... paramVarArgs)
  {
    GMTrace.i(17443607019520L, 129965);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        int m = paramVarArgs.length;
        i = 0;
        if (i >= m) {
          break label242;
        }
        localObject = paramVarArgs[i];
        if ((localObject instanceof String))
        {
          localByteArrayOutputStream.write(((String)localObject).getBytes());
        }
        else if ((localObject instanceof Integer))
        {
          int k = ((Integer)localObject).intValue();
          j = 0;
          if (j < 4)
          {
            localByteArrayOutputStream.write(k & 0xFF);
            k >>= 8;
            j += 1;
            continue;
          }
        }
        else if ((localObject instanceof Long))
        {
          long l = ((Long)localObject).longValue();
          j = 0;
          if (j < 8)
          {
            localByteArrayOutputStream.write((int)(0xFF & l));
            l >>= 8;
            j += 1;
            continue;
          }
        }
        else if ((localObject instanceof Boolean))
        {
          if (((Boolean)localObject).booleanValue())
          {
            j = 1;
            localByteArrayOutputStream.write(j);
          }
        }
      }
      catch (Exception paramVarArgs)
      {
        com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramVarArgs, "", new Object[0]);
        GMTrace.o(17443607019520L, 129965);
        return "";
      }
      int j = 0;
      continue;
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", new Object[] { localObject });
      GMTrace.o(17443607019520L, 129965);
      return "";
      label242:
      paramVarArgs = bf.bo(MessageDigest.getInstance("MD5").digest(localByteArrayOutputStream.toByteArray()));
      GMTrace.o(17443607019520L, 129965);
      return paramVarArgs;
      i += 1;
    }
  }
  
  /* Error */
  private static long ep(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 200
    //   3: ldc -54
    //   5: invokestatic 28	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: aload_0
    //   9: ldc 47
    //   11: invokevirtual 53	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14: ifeq +131 -> 145
    //   17: new 55	java/util/zip/ZipFile
    //   20: dup
    //   21: invokestatic 61	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   24: invokevirtual 67	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   27: getfield 73	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   30: invokespecial 76	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: astore_3
    //   38: aload 4
    //   40: aload_0
    //   41: iconst_1
    //   42: invokevirtual 80	java/lang/String:substring	(I)Ljava/lang/String;
    //   45: invokevirtual 84	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   48: astore_0
    //   49: aload_0
    //   50: ifnonnull +20 -> 70
    //   53: aload 4
    //   55: invokevirtual 138	java/util/zip/ZipFile:close	()V
    //   58: ldc2_w 200
    //   61: ldc -54
    //   63: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   66: ldc2_w 29
    //   69: lreturn
    //   70: aload 4
    //   72: astore_3
    //   73: aload_0
    //   74: invokevirtual 207	java/util/zip/ZipEntry:getSize	()J
    //   77: lstore_1
    //   78: aload 4
    //   80: invokevirtual 138	java/util/zip/ZipFile:close	()V
    //   83: ldc2_w 200
    //   86: ldc -54
    //   88: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   91: lload_1
    //   92: lreturn
    //   93: astore 5
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: astore_3
    //   99: ldc -116
    //   101: aload 5
    //   103: ldc -114
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 148	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 138	java/util/zip/ZipFile:close	()V
    //   120: ldc2_w 200
    //   123: ldc -54
    //   125: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   128: ldc2_w 29
    //   131: lreturn
    //   132: astore_0
    //   133: aconst_null
    //   134: astore_3
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 138	java/util/zip/ZipFile:close	()V
    //   143: aload_0
    //   144: athrow
    //   145: aload_0
    //   146: invokestatic 210	com/tencent/mm/modelsfs/FileOp:kj	(Ljava/lang/String;)J
    //   149: lstore_1
    //   150: ldc2_w 200
    //   153: ldc -54
    //   155: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   158: lload_1
    //   159: lreturn
    //   160: astore_0
    //   161: goto -103 -> 58
    //   164: astore_0
    //   165: goto -82 -> 83
    //   168: astore_0
    //   169: goto -49 -> 120
    //   172: astore_3
    //   173: goto -30 -> 143
    //   176: astore_0
    //   177: goto -42 -> 135
    //   180: astore 5
    //   182: aload 4
    //   184: astore_0
    //   185: goto -88 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramString	String
    //   77	82	1	l	long
    //   37	103	3	localObject	Object
    //   172	1	3	localIOException1	java.io.IOException
    //   33	150	4	localZipFile	java.util.zip.ZipFile
    //   93	9	5	localIOException2	java.io.IOException
    //   180	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   17	35	93	java/io/IOException
    //   17	35	132	finally
    //   53	58	160	java/io/IOException
    //   78	83	164	java/io/IOException
    //   116	120	168	java/io/IOException
    //   139	143	172	java/io/IOException
    //   38	49	176	finally
    //   73	78	176	finally
    //   99	112	176	finally
    //   38	49	180	java/io/IOException
    //   73	78	180	java/io/IOException
  }
  
  public final d.b a(String paramString, Map<String, String> paramMap, d.a parama)
  {
    GMTrace.i(14456188829696L, 107707);
    Object localObject6 = parama.hsc;
    Object localObject5 = com.tencent.mm.platformtools.n.a(((bu)localObject6).tdz);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.equals("addcontact"))
      {
        ((bu)localObject6).tdz = com.tencent.mm.platformtools.n.mw((String)paramMap.get(".sysmsg.addcontact.content"));
        ((bu)localObject6).mrC = 1;
        localObject1 = d.c.aB(Integer.valueOf(1));
        if (localObject1 != null) {
          break label1118;
        }
        localObject1 = null;
      }
    }
    int i;
    if ((paramString != null) && (paramString.equals("dynacfg")))
    {
      com.tencent.mm.i.g.sV().a((String)localObject5, paramMap, false);
      com.tencent.mm.i.g.sW();
      if (com.tencent.mm.i.c.sF() == 2) {
        com.tencent.mm.plugin.report.service.g.oSF.A(10879, "");
      }
      i = bf.getInt(com.tencent.mm.i.g.sV().getValue("MuteRoomDisable"), 0);
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(i));
    }
    if ((paramString != null) && (paramString.equals("dynacfg_split"))) {
      com.tencent.mm.i.g.sV().a((String)localObject5, paramMap, true);
    }
    final Object localObject7;
    Object localObject8;
    if ((paramString != null) && (paramString.equals("banner")))
    {
      localObject2 = (String)paramMap.get(".sysmsg.mainframebanner.$type");
      localObject7 = (String)paramMap.get(".sysmsg.mainframebanner.showtype");
      localObject8 = (String)paramMap.get(".sysmsg.mainframebanner.data");
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {}
    }
    for (;;)
    {
      long l1;
      try
      {
        ax.zj().a(new aw(Integer.valueOf((String)localObject2).intValue(), Integer.valueOf((String)localObject7).intValue(), (String)localObject8));
        localObject2 = (String)paramMap.get(".sysmsg.friendrecommand.fromuser");
        localObject7 = (String)paramMap.get(".sysmsg.friendrecommand.touser");
        if ((localObject2 == null) || (localObject7 == null)) {}
      }
      catch (Exception localException3)
      {
        try
        {
          ap.yY().xy().a((String)localObject7, true, null);
          localObject2 = (String)paramMap.get(".sysmsg.banner.securitybanner.chatname");
          localObject7 = (String)paramMap.get(".sysmsg.banner.securitybanner.wording");
          localObject8 = (String)paramMap.get(".sysmsg.banner.securitybanner.showtype");
          if ((bf.mA((String)localObject2)) || (bf.mA((String)localObject8))) {}
        }
        catch (Exception localException3)
        {
          try
          {
            if (!((String)localObject8).equals("1")) {
              break label7032;
            }
            bool1 = true;
            ap.yY().xz().a((String)localObject2, bool1, new String[] { localObject7 });
            ap.yY().xA().k(paramMap);
            if ((!bf.mA(paramString)) && (paramString.equals("midinfo")))
            {
              localObject2 = (String)paramMap.get(".sysmsg.midinfo.json_buffer");
              localObject7 = (String)paramMap.get(".sysmsg.midinfo.time_interval");
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", new Object[] { localObject7, localObject2, localObject5 });
              i = bf.getInt((String)localObject7, 0);
              if ((i > 86400L) && (i < 864000L))
              {
                ap.yY();
                c.vr().set(331777, Long.valueOf(bf.Nz() + i));
              }
              if (!bf.mA((String)localObject2)) {
                com.tencent.mm.plugin.report.b.d.Dx((String)localObject2);
              }
            }
            if ((paramString != null) && (paramString.equals("revokemsg")))
            {
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
              localObject1 = (String)paramMap.get(".sysmsg.revokemsg.session");
              localObject2 = (String)paramMap.get(".sysmsg.revokemsg.newmsgid");
              paramString = (String)paramMap.get(".sysmsg.revokemsg.replacemsg");
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject2, paramString });
              l1 = 0L;
            }
          }
          catch (Exception localException3)
          {
            try
            {
              long l2 = bf.getLong((String)localObject2, 0L);
              l1 = l2;
              ap.yY();
              l1 = l2;
              paramMap = c.wT().x((String)localObject1, l2);
              l1 = l2;
              localObject1 = au.Y(paramMap);
              l1 = l2;
              paramMap.setContent(paramString);
              l1 = l2;
              paramMap.setType(10000);
              l1 = l2;
              ay.a(paramMap, parama);
              l1 = l2;
              ap.yY();
              l1 = l2;
              c.wT().a(paramMap.field_msgId, paramMap);
              l1 = l2;
              ap.yY();
              l1 = l2;
              localObject2 = c.wW().Rl(paramMap.field_talker);
              if (localObject2 != null)
              {
                l1 = l2;
                if (((aj)localObject2).field_unReadCount > 0)
                {
                  l1 = l2;
                  ap.yY();
                  l1 = l2;
                  i = c.wT().K(paramMap);
                  l1 = l2;
                  if (((aj)localObject2).field_unReadCount >= i)
                  {
                    l1 = l2;
                    ((ae)localObject2).dt(((aj)localObject2).field_unReadCount - 1);
                    l1 = l2;
                    ap.yY();
                    l1 = l2;
                    c.wW().a((ae)localObject2, ((aj)localObject2).field_username);
                  }
                }
              }
              if (parama != null)
              {
                l1 = l2;
                if (parama.hsd)
                {
                  l1 = l2;
                  localObject2 = new ao();
                  l1 = l2;
                  ((ao)localObject2).field_originSvrId = l2;
                  l1 = l2;
                  if (paramMap.field_msgId == 0L)
                  {
                    l1 = l2;
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", new Object[] { Long.valueOf(l2) });
                    l1 = l2;
                    ((ao)localObject2).field_content = ((String)localObject5);
                    l1 = l2;
                    ((ao)localObject2).field_createTime = ((bu)localObject6).ofk;
                    l1 = l2;
                    ((ao)localObject2).field_flag = ay.c(parama);
                    l1 = l2;
                    ((ao)localObject2).field_fromUserName = com.tencent.mm.platformtools.n.a(((bu)localObject6).tdx);
                    l1 = l2;
                    ((ao)localObject2).field_toUserName = com.tencent.mm.platformtools.n.a(((bu)localObject6).tdy);
                    l1 = l2;
                    ((ao)localObject2).field_newMsgId = ((bu)localObject6).tdE;
                    l1 = l2;
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", new Object[] { Boolean.valueOf(ap.yY().xD().b((com.tencent.mm.sdk.e.c)localObject2)), Long.valueOf(((ao)localObject2).uvp) });
                    GMTrace.o(14456188829696L, 107707);
                    return null;
                    label1118:
                    localObject1 = ((com.tencent.mm.y.d)localObject1).b(parama);
                    break;
                    localException1 = localException1;
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BigBallSysCmdMsgConsumer", localException1.toString());
                    continue;
                    localException2 = localException2;
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BigBallSysCmdMsgConsumer", localException2.toString());
                    continue;
                    localException3 = localException3;
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + localException3.toString());
                    continue;
                  }
                  l1 = l2;
                  com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info,  originSvrId[%d]", new Object[] { Long.valueOf(l2) });
                  l1 = l2;
                  ap.yY().xD().b(localException3, true, new String[0]);
                  l1 = l2;
                  ap.yY();
                  l1 = l2;
                  c.wT().cE(l2);
                }
              }
              l1 = l2;
              if (paramMap.field_msgId == 0L) {
                if (parama != null)
                {
                  l1 = l2;
                  if (parama.hsd) {}
                }
                else
                {
                  l1 = l2;
                  com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summer revoke msg id is 0 and svrid[%d]", new Object[] { Long.valueOf(l2) });
                  l1 = l2;
                  ap.yY();
                  l1 = l2;
                  c.wT().cE(l2);
                }
              }
              l1 = l2;
              parama = new nd();
              l1 = l2;
              parama.fUc.fGD = paramMap.field_msgId;
              l1 = l2;
              parama.fUc.fUd = paramString;
              l1 = l2;
              parama.fUc.fTa = paramMap;
              l1 = l2;
              parama.fUc.fUe = ((au)localObject1);
              l1 = l2;
              parama.fUc.fUf = l2;
              l1 = l2;
              com.tencent.mm.sdk.b.a.uql.m(parama);
            }
            catch (Exception paramString)
            {
              com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[oneliang][revokeMsg] msgId:%d,error:%s", new Object[] { Long.valueOf(l1), paramString.toString() });
              continue;
            }
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
        }
      }
      int j;
      if ((paramString != null) && (paramString.equals("clouddelmsg")))
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
        localObject3 = (String)paramMap.get(".sysmsg.clouddelmsg.delcommand");
        localObject1 = (String)paramMap.get(".sysmsg.clouddelmsg.msgid");
        paramMap = (String)paramMap.get(".sysmsg.clouddelmsg.fromuser");
        i = ((String)localObject5).indexOf("<msg>");
        j = ((String)localObject5).indexOf("</msg>");
        if ((i == -1) || (j == -1))
        {
          paramString = "";
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", new Object[] { localObject3, localObject1, paramMap, paramString });
        }
        for (;;)
        {
          try
          {
            ap.yY();
            paramMap = c.wT().cQ(paramMap, (String)localObject1);
            if ((paramMap == null) || (paramMap.size() <= 0))
            {
              com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
              GMTrace.o(14456188829696L, 107707);
              return null;
              paramString = av.ae(bg.q(((String)localObject5).substring(i, j + 6), "msg"));
              break;
            }
            paramMap = paramMap.iterator();
            if (paramMap.hasNext())
            {
              localObject5 = (au)paramMap.next();
              if (localObject5 != null) {
                break label1739;
              }
              com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
            }
            if (((ce)localObject5).field_msgSvrId >= 0L) {
              break label1786;
            }
          }
          catch (Exception paramString)
          {
            com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", new Object[] { localObject1, paramString.toString() });
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
          label1739:
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((ce)localObject5).field_msgId), Long.valueOf(((ce)localObject5).field_msgSvrId) });
        }
        label1786:
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((ce)localObject5).field_msgId), Long.valueOf(((ce)localObject5).field_msgSvrId) });
        i = bf.getInt((String)localObject3, 0);
        if (i == 1)
        {
          ap.yY();
          c.wT().E(((ce)localObject5).field_talker, ((ce)localObject5).field_msgSvrId);
        }
        for (;;)
        {
          localObject6 = new nd();
          ((nd)localObject6).fUc.fGD = ((ce)localObject5).field_msgId;
          ((nd)localObject6).fUc.fUd = paramString;
          ((nd)localObject6).fUc.fTa = ((au)localObject5);
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject6);
          break;
          if ((i == 2) && ((((au)localObject5).bLN()) || (((au)localObject5).bLO())))
          {
            ((au)localObject5).setContent(paramString);
            ay.a((au)localObject5, parama);
            ap.yY();
            c.wT().b(((ce)localObject5).field_msgSvrId, (au)localObject5);
            ap.yY();
            localObject6 = c.wW().Rl(((ce)localObject5).field_talker);
            if ((localObject6 != null) && (((aj)localObject6).field_unReadCount > 0))
            {
              ap.yY();
              i = c.wT().K((au)localObject5);
              if (((aj)localObject6).field_unReadCount >= i)
              {
                ((ae)localObject6).dt(((aj)localObject6).field_unReadCount - 1);
                ap.yY();
                c.wW().a((ae)localObject6, ((aj)localObject6).field_username);
              }
            }
          }
        }
      }
      Object localObject3 = localObject1;
      if (paramString != null)
      {
        localObject3 = localObject1;
        if (paramString.equals("updatepackage"))
        {
          localObject1 = d.c.aB(Integer.valueOf(-1879048175));
          if (localObject1 != null) {
            break label2979;
          }
          localObject3 = null;
        }
      }
      label2138:
      label2298:
      label2509:
      Object localObject9;
      for (;;)
      {
        localObject1 = localObject3;
        if (paramString != null)
        {
          localObject1 = localObject3;
          if (paramString.equals("deletepackage"))
          {
            localObject1 = d.c.aB(Integer.valueOf(-1879048174));
            if (localObject1 != null) {
              break label2992;
            }
            localObject1 = null;
          }
        }
        label2545:
        Object localObject11;
        if ((paramString != null) && (paramString.equals("delchatroommember")))
        {
          localObject3 = com.tencent.mm.platformtools.n.a(((bu)localObject6).tdx);
          ap.yY();
          localObject7 = c.wT().x((String)localObject3, ((bu)localObject6).tdE);
          i = 0;
          if (((ce)localObject7).field_msgId > 0L) {
            i = 1;
          }
          ((au)localObject7).y(((bu)localObject6).tdE);
          if ((parama == null) || (!parama.hsd) || (!parama.hsf)) {
            ((au)localObject7).z(ay.i((String)localObject3, ((bu)localObject6).ofk));
          }
          ((au)localObject7).setType(10002);
          ((au)localObject7).setContent((String)localObject5);
          ((au)localObject7).dw(0);
          ((au)localObject7).cH((String)localObject3);
          ((au)localObject7).cN(((bu)localObject6).tdC);
          ay.a((au)localObject7, parama);
          if (i == 0) {
            ay.i((au)localObject7);
          }
        }
        else
        {
          localObject3 = localObject1;
          if (paramString != null)
          {
            localObject3 = localObject1;
            if (paramString.equals("WakenPush"))
            {
              localObject3 = localObject1;
              if (this.hkO != ((bu)localObject6).tdE)
              {
                this.hkO = ((bu)localObject6).tdE;
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                localObject3 = new bv(paramMap);
                localObject5 = (String)((bv)localObject3).hjP.get(".sysmsg.WakenPush.PushContent");
                localObject7 = (String)((bv)localObject3).hjP.get(".sysmsg.WakenPush.Jump");
                localObject1 = (String)((bv)localObject3).hjP.get(".sysmsg.WakenPush.ExpiredTime");
                localObject8 = (String)((bv)localObject3).hjP.get(".sysmsg.WakenPush.Username");
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[] { localObject5, localObject7, localObject1 });
                localObject1 = com.tencent.mm.i.g.sV().getValue("WakenPushDeepLinkBitSet");
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[] { localObject1 });
                if (bf.mA((String)localObject1)) {
                  break label3027;
                }
                l1 = bf.getLong((String)localObject1, 0L);
                localObject9 = com.tencent.mm.x.b.a((String)localObject8, false, -1);
                localObject10 = ap.getNotification();
                if (!bf.mA((String)localObject7)) {
                  break label3033;
                }
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                localObject1 = "com.tencent.mm.ui.LauncherUI";
                localObject11 = new Intent();
                ((Intent)localObject11).setClassName(aa.getContext(), (String)localObject1);
                ((Intent)localObject11).setFlags(536870912);
                ((Intent)localObject11).putExtra("LauncherUI.Show.Update.DialogMsg", (String)((bv)localObject3).hjP.get(".sysmsg.WakenPush.PushContent"));
                if (!((String)localObject7).equals("weixin://dl/update_newest_version")) {
                  ((Intent)localObject11).putExtra("LauncherUI.Show.Update.Url", (String)((bv)localObject3).hjP.get(".sysmsg.WakenPush.Jump"));
                }
                com.tencent.mm.plugin.report.service.g.oSF.a(405L, 32L, 1L, true);
                localObject1 = ((af)localObject10).a(PendingIntent.getActivity(aa.getContext(), UUID.randomUUID().hashCode(), (Intent)localObject11, 134217728), aa.getContext().getString(R.l.bpC), (String)localObject5, (String)localObject5, (Bitmap)localObject9, (String)localObject8);
                ((Notification)localObject1).flags |= 0x10;
                ap.getNotification().a((Notification)localObject1, false);
                com.tencent.mm.plugin.report.service.g.oSF.a(405L, 31L, 1L, true);
                localObject3 = null;
              }
            }
          }
          localObject1 = localObject3;
          if (paramString == null) {
            break label3295;
          }
          localObject1 = localObject3;
          if (!paramString.equals("DisasterNotice")) {
            break label3295;
          }
          localObject7 = (String)paramMap.get(".sysmsg.NoticeId");
          localObject8 = (String)paramMap.get(".sysmsg.Content");
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[] { localObject7, localObject8 });
          localObject9 = aa.getContext().getSharedPreferences("disaster_pref", 4);
          localObject5 = ((SharedPreferences)localObject9).getString("disaster_noticeid_list_key", "");
          if (((String)localObject5).contains((CharSequence)localObject7)) {
            break label3238;
          }
          Object localObject10 = ((String)localObject5).split(";");
          if ((localObject10 == null) || (localObject10.length <= 10)) {
            break label3149;
          }
          j = localObject10.length;
          i = 0;
          localObject1 = "";
          label2877:
          localObject3 = localObject1;
          if (i >= j) {
            break label3153;
          }
          localObject11 = localObject10[i].split(",");
          localObject3 = localObject1;
        }
        try
        {
          if (bf.az(bf.getLong(localObject11[0], 0L)) < 1296000L) {
            localObject3 = (String)localObject1 + localObject11[0] + "," + localObject11[1] + ";";
          }
          i += 1;
          localObject1 = localObject3;
          break label2877;
          label2979:
          localObject3 = ((com.tencent.mm.y.d)localObject1).b(parama);
          continue;
          label2992:
          localObject1 = ((com.tencent.mm.y.d)localObject1).b(parama);
          break label2138;
          ap.yY();
          c.wT().b(((bu)localObject6).tdE, (au)localObject7);
          break label2298;
          label3027:
          l1 = 0L;
          break label2509;
          label3033:
          if (((0x4 & l1) == 4L) && (((String)localObject7).startsWith("weixin://dl/moments")))
          {
            localObject1 = "com.tencent.mm.plugin.sns.ui.En_424b8e16";
            break label2545;
          }
          if (((l1 & 0x40000) == 262144L) && (((String)localObject7).startsWith("weixin://dl/recommendation")))
          {
            localObject1 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
            break label2545;
          }
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[] { localObject7 });
          localObject1 = "com.tencent.mm.ui.LauncherUI";
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[] { localException4 });
            localObject4 = localObject1;
          }
        }
      }
      label3149:
      Object localObject4 = localObject5;
      label3153:
      localObject1 = (String)localObject4 + bf.Nz() + "," + (String)localObject7 + ";";
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[] { localObject5, localObject1 });
      ((SharedPreferences)localObject9).edit().putString("disaster_noticeid_list_key", (String)localObject1).commit();
      label3238:
      new ad(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14455517741056L, 107702);
          if (f.this.hkP != null) {
            f.this.hkP.br(localObject7);
          }
          GMTrace.o(14455517741056L, 107702);
        }
      });
      ((bu)localObject6).tdz = com.tencent.mm.platformtools.n.mw((String)localObject8);
      ((bu)localObject6).mrC = 1;
      localObject1 = d.c.aB(Integer.valueOf(1));
      if (localObject1 == null)
      {
        localObject1 = null;
        label3295:
        if ((paramString == null) || (!paramString.equals("EmotionKv"))) {
          break label3784;
        }
        paramString = (String)paramMap.get(".sysmsg.EmotionKv.K");
        localObject1 = (String)paramMap.get(".sysmsg.EmotionKv.I");
        if (paramString != null) {
          break label7029;
        }
        paramString = "";
      }
      label3516:
      label3531:
      label3539:
      label3546:
      label3590:
      label3625:
      label3725:
      label3733:
      label3741:
      label3768:
      label3777:
      label3784:
      label4935:
      label5339:
      label6027:
      label6364:
      label6976:
      label6988:
      label7029:
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[] { Integer.valueOf(paramString.length()), paramString, localObject1 });
        localObject4 = ac.bHi().sYE.getBytes();
        localObject5 = ac.bHi().sYF.getBytes();
        paramMap = null;
        try
        {
          parama = ap.vd().hsI.Cc().BZ();
          paramMap = parama;
        }
        catch (Exception parama)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[] { bf.g(parama) });
          }
          parama = new PByteArray();
          if (bf.mA(paramString)) {
            break label3516;
          }
        }
        if (bf.bm(paramMap))
        {
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
          GMTrace.o(14456188829696L, 107707);
          return null;
          localObject1 = ((com.tencent.mm.y.d)localObject1).b(parama);
          break;
        }
        int k;
        int m;
        if ((bf.bm((byte[])localObject5)) || (bf.bm((byte[])localObject4)) || (bf.bm(paramMap))) {
          if (paramString == null)
          {
            i = -1;
            if (localObject5 != null) {
              break label3725;
            }
            j = -1;
            if (localObject4 != null) {
              break label3733;
            }
            k = -1;
            if (paramMap != null) {
              break label3741;
            }
            m = -1;
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
            paramString = parama.value;
            paramMap = new aig();
            if (parama.value == null) {
              break label3768;
            }
            paramMap.oSl = new String(parama.value);
            if (paramString != null) {
              break label3777;
            }
          }
        }
        for (i = -1;; i = paramString.length)
        {
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv res len:%d val len:%d, content[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramMap.oSl.length()), com.tencent.mm.a.g.n(paramMap.oSl.getBytes()) });
          paramMap.tKF = ((String)localObject1);
          ap.yY();
          c.wQ().b(new e.a(59, paramMap));
          GMTrace.o(14456188829696L, 107707);
          return null;
          i = paramString.length();
          break;
          j = localObject5.length;
          break label3531;
          k = localObject4.length;
          break label3539;
          m = paramMap.length;
          break label3546;
          ap.yY();
          MMProtocalJni.genClientCheckKVRes(c.uH(), paramString, (byte[])localObject4, (byte[])localObject5, paramMap, parama);
          break label3590;
          paramMap.oSl = "";
          break label3625;
        }
        if ((paramString != null) && (paramString.equals("globalalert")))
        {
          paramString = (String)paramMap.get(".sysmsg.uuid");
          i = bf.getInt((String)paramMap.get(".sysmsg.id"), -1);
          j = bf.getInt((String)paramMap.get(".sysmsg.important"), -1);
          if ((bf.mA(paramString)) || (i < 0) || (j < 0))
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
          parama = (String)paramMap.get(".sysmsg.title");
          localObject1 = (String)paramMap.get(".sysmsg.msg");
          if ((bf.mA(parama)) && (bf.mA((String)localObject1)))
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[] { parama, localObject1 });
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
          localObject5 = (String)paramMap.get(".sysmsg.btnlist.btn.$title");
          k = bf.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$id"), -1);
          m = bf.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$actiontype"), -1);
          localObject6 = (String)paramMap.get(".sysmsg.btnlist.btn");
          if ((bf.mA((String)localObject5)) || (k < 0) || (m < 0))
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[] { localObject5, Integer.valueOf(k), Integer.valueOf(m) });
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
          localObject4 = (String)paramMap.get(".sysmsg.btnlist.btn1.$title");
          int n = bf.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$id"), -1);
          int i1 = bf.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
          paramMap = (String)paramMap.get(".sysmsg.btnlist.btn1");
          bool1 = true;
          if ((bf.mA((String)localObject4)) || (n < 0) || (i1 < 0))
          {
            bool1 = false;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[] { localObject5, Integer.valueOf(k), Integer.valueOf(m) });
          }
          localObject7 = new hr();
          localObject8 = new com.tencent.mm.protocal.b.a.b();
          ((hr)localObject7).fMZ.fNa = ((com.tencent.mm.protocal.b.a.b)localObject8);
          ((com.tencent.mm.protocal.b.a.b)localObject8).id = i;
          ((com.tencent.mm.protocal.b.a.b)localObject8).title = parama;
          ((com.tencent.mm.protocal.b.a.b)localObject8).fEi = ((String)localObject1);
          ((com.tencent.mm.protocal.b.a.b)localObject8).sZy = new LinkedList();
          localObject9 = new com.tencent.mm.protocal.b.a.a();
          ((com.tencent.mm.protocal.b.a.a)localObject9).id = k;
          ((com.tencent.mm.protocal.b.a.a)localObject9).actionType = m;
          ((com.tencent.mm.protocal.b.a.a)localObject9).sZw = ((String)localObject5);
          ((com.tencent.mm.protocal.b.a.a)localObject9).sZx = ((String)localObject6);
          ((com.tencent.mm.protocal.b.a.b)localObject8).sZy.add(localObject9);
          if (bool1)
          {
            localObject5 = new com.tencent.mm.protocal.b.a.a();
            ((com.tencent.mm.protocal.b.a.a)localObject5).id = n;
            ((com.tencent.mm.protocal.b.a.a)localObject5).actionType = i1;
            ((com.tencent.mm.protocal.b.a.a)localObject5).sZw = ((String)localObject4);
            ((com.tencent.mm.protocal.b.a.a)localObject5).sZx = paramMap;
            ((com.tencent.mm.protocal.b.a.b)localObject8).sZy.add(localObject5);
          }
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), parama, localObject1, Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject7)) });
          GMTrace.o(14456188829696L, 107707);
          return null;
        }
        if ((paramString != null) && (paramString.equals("yybsigcheck")))
        {
          com.tencent.mm.plugin.report.service.g.oSF.a(322L, 14L, 1L, false);
          l1 = System.currentTimeMillis();
          paramString = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
          parama = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.wording");
          paramMap = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.url");
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[] { paramString, parama, paramMap });
          com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4014), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
          if (bf.mA(paramString))
          {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
            com.tencent.mm.plugin.report.service.g.oSF.a(322L, 15L, 1L, false);
            com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4015), String.format("%s|%s", new Object[] { parama, paramMap }) });
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
          localObject1 = paramString.split(";");
          if (localObject1 == null) {}
          for (i = -1;; i = localObject1.length)
          {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStrs len is %d", new Object[] { Integer.valueOf(i) });
            if ((localObject1 != null) && (localObject1.length != 0)) {
              break;
            }
            com.tencent.mm.plugin.report.service.g.oSF.a(322L, 16L, 1L, false);
            com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4016), paramString });
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
          localObject4 = new ArrayList();
          i = 0;
          if (i < localObject1.length)
          {
            localObject5 = localObject1[i];
            if (bf.mA((String)localObject5)) {
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[] { Integer.valueOf(i) });
            }
            for (;;)
            {
              i += 1;
              break;
              localObject6 = ((String)localObject5).split(",");
              if (localObject6 == null) {}
              for (j = -1;; j = localObject6.length)
              {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is %d", new Object[] { Integer.valueOf(j) });
                if ((localObject6 != null) && (localObject6.length == 3)) {
                  break label4935;
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[] { Integer.valueOf(i) });
                break;
              }
              try
              {
                ((ArrayList)localObject4).add(new v.c(localObject6[0], Integer.valueOf(localObject6[1]).intValue(), localObject6[2]));
              }
              catch (Exception localException5)
              {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[] { Integer.valueOf(i), localException5.getMessage() });
                com.tencent.mm.plugin.report.service.g.oSF.a(322L, 17L, 1L, false);
                com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4017), localObject5 });
              }
            }
          }
          if (((ArrayList)localObject4).size() == 0)
          {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
            com.tencent.mm.plugin.report.service.g.oSF.a(322L, 18L, 1L, false);
            com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4018), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
          if (bf.getInt(com.tencent.mm.i.g.sV().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)
          {
            bool1 = true;
            boolean bool2 = com.tencent.mm.platformtools.v.a(aa.getContext(), (ArrayList)localObject4, bool1);
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[] { Integer.valueOf(((ArrayList)localObject4).size()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l1) });
            if (bool2) {
              break label5339;
            }
            ap.yW().setInt(46, 4);
            localObject1 = new ic();
            ((ic)localObject1).fNw.fNx = parama;
            ((ic)localObject1).fNw.url = paramMap;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            com.tencent.mm.plugin.report.service.g.oSF.a(322L, 20L, 1L, true);
            com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4020), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
          }
          for (;;)
          {
            GMTrace.o(14456188829696L, 107707);
            return null;
            bool1 = false;
            break;
            ap.yW().setInt(46, 0);
            com.tencent.mm.plugin.report.service.g.oSF.a(322L, 19L, 1L, true);
            com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4019), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
          }
        }
        if ((paramString != null) && (paramString.equals("qy_status_notify")))
        {
          parama = (String)paramMap.get(".sysmsg.chat_id");
          paramMap.get(".sysmsg.last_create_time");
          paramString = (String)paramMap.get(".sysmsg.brand_username");
          l1 = com.tencent.mm.modelbiz.a.e.iz(parama);
          if (l1 == -1L)
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[] { parama });
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
          i = w.DK().U(l1).field_newUnReadCount;
          w.DK().W(l1);
          paramMap = w.DJ().aa(l1);
          ap.yY();
          parama = c.wW().Rl(paramString);
          if (parama == null)
          {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[] { paramString });
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
          if (paramMap.fu(1))
          {
            if (parama.field_unReadMuteCount <= i)
            {
              parama.dA(0);
              ap.yY();
              c.wW().a(parama, paramString);
              ap.getNotification().cancelNotification(paramString);
            }
            for (;;)
            {
              GMTrace.o(14456188829696L, 107707);
              return null;
              parama.dA(parama.field_unReadMuteCount - i);
              ap.yY();
              c.wW().a(parama, paramString);
            }
          }
          if (parama.field_unReadCount <= i)
          {
            ap.yY();
            c.wW().Rn(paramString);
            ap.getNotification().cancelNotification(paramString);
          }
          for (;;)
          {
            GMTrace.o(14456188829696L, 107707);
            return null;
            parama.dz(0);
            parama.dC(0);
            parama.dt(parama.field_unReadCount - i);
            ap.yY();
            c.wW().a(parama, paramString);
          }
        }
        if ((paramString != null) && (paramString.equals("qy_chat_update")))
        {
          parama = (String)paramMap.get(".sysmsg.chat_id");
          localObject4 = (String)paramMap.get(".sysmsg.ver");
          com.tencent.mm.modelbiz.a.e.l((String)paramMap.get(".sysmsg.brand_username"), parama, (String)localObject4);
        }
        if ((paramString != null) && (paramString.equals("bindmobiletip")))
        {
          i = bf.getInt((String)paramMap.get(".sysmsg.bindmobiletip.forcebind"), 0);
          parama = bf.mz((String)paramMap.get(".sysmsg.bindmobiletip.deviceid"));
          paramString = bf.mz((String)paramMap.get(".sysmsg.bindmobiletip.wording"));
          paramMap = new String(Base64.decode(parama.getBytes(), 0));
          parama = new String(com.tencent.mm.bd.b.aU(p.rB().getBytes()).xQ(16).sWU);
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[] { Integer.valueOf(i), paramMap, parama, paramString });
          if ((bf.mA(paramMap)) || (paramMap.equals(parama)))
          {
            ap.yY();
            c.vr().a(w.a.uzC, Boolean.valueOf(true));
            ap.yY();
            paramMap = c.vr();
            parama = w.a.uzD;
            if (i != 1) {
              break label6027;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            paramMap.a(parama, Boolean.valueOf(bool1));
            ap.yY();
            c.vr().a(w.a.uzE, paramString);
            GMTrace.o(14456188829696L, 107707);
            return null;
          }
        }
        if ((paramString != null) && (paramString.equals("ClientCheckConsistency")))
        {
          parama = new aoe();
          parama.hNH = ((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename"));
          parama.tRG = bf.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
          parama.tRH = bf.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
          parama.tkk = bf.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
          parama.tRI = c(parama.hNH, parama.tRG, parama.tRH);
          parama.trj = ((int)ep(parama.hNH));
          if (!com.tencent.mm.plugin.normsg.a.d.nYa.aPd()) {
            break label6976;
          }
          i = 1;
        }
        for (;;)
        {
          parama.tRJ = i;
          parama.tpX = com.tencent.mm.compatible.d.v.rR();
          parama.tRK = c(new Object[] { parama.hNH, Integer.valueOf(parama.tRG), Integer.valueOf(parama.tRH), Integer.valueOf(parama.tkk), parama.tRI, Integer.valueOf(parama.trj), Integer.valueOf(parama.tRJ), Integer.valueOf(parama.tpX) });
          ap.yY();
          c.wQ().b(new e.a(61, parama));
          if ((paramString != null) && (paramString.equals("ClientCheckHook")))
          {
            parama = new aog();
            parama.tkk = bf.getInt((String)paramMap.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
            parama.tRM = com.tencent.mm.plugin.normsg.a.d.nYa.ga(false);
            if (com.tencent.mm.plugin.normsg.a.d.nYa.aPd())
            {
              i = 1;
              parama.tRJ = i;
              parama.tpX = com.tencent.mm.compatible.d.v.rR();
              parama.tRK = c(new Object[] { Integer.valueOf(parama.tkk), parama.tRM, Integer.valueOf(parama.tRJ), Integer.valueOf(parama.tpX) });
              ap.yY();
              c.wQ().b(new e.a(62, parama));
            }
          }
          else
          {
            if ((paramString != null) && (paramString.equals("ClientCheckGetAppList")))
            {
              parama = new aof();
              parama.tkk = bf.getInt((String)paramMap.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
              parama.tRL = com.tencent.mm.plugin.normsg.a.d.nYa.aPc();
              if (!com.tencent.mm.plugin.normsg.a.d.nYa.aPd()) {
                break label6988;
              }
              i = 1;
              parama.tRJ = i;
              parama.tpX = com.tencent.mm.compatible.d.v.rR();
              parama.tRK = c(new Object[] { Integer.valueOf(parama.tkk), parama.tRL, Integer.valueOf(parama.tRJ), Integer.valueOf(parama.tpX) });
              ap.yY();
              c.wQ().b(new e.a(63, parama));
            }
            if ((paramString != null) && (paramString.equals("ClientCheckGetExtInfo")))
            {
              i = bf.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
              parama = com.tencent.mm.plugin.normsg.a.d.nYa.fZ(true);
              com.tencent.mm.plugin.secinforeport.a.b.pgg.bC(parama, i);
            }
            if ((!bf.mA(paramString)) && (paramString.equals("functionmsg")))
            {
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
              parama = i.ug();
              com.tencent.mm.sdk.platformtools.v.j("MicroMsg.FunctionMsgFetcher", "fetchFromNewXml, newXmlMsgQueue.size: %s, addMsg.createTime: %s", new Object[] { Integer.valueOf(parama.gUl.size()), Integer.valueOf(localException5.ofk) });
              paramMap.put("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY", String.valueOf(localException5.ofk));
              parama.gUl.add(paramMap);
              parama.tW();
            }
            if ((!bf.mA(paramString)) && (paramString.equals("paymsg")))
            {
              i = bf.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
              localObject4 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
              paramString = (String)paramMap.get(".sysmsg.paymsg.fromusername");
              parama = (String)paramMap.get(".sysmsg.paymsg.tousername");
              paramMap = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[] { Integer.valueOf(i), Long.valueOf(localException5.tdE), paramString, parama, paramMap, localObject4 });
            }
          }
          try
          {
            localObject4 = URLDecoder.decode((String)localObject4, "UTF-8");
            if (!bf.mA((String)localObject4))
            {
              localObject5 = new lr();
              ((lr)localObject5).fSF.type = i;
              ((lr)localObject5).fSF.content = ((String)localObject4);
              ((lr)localObject5).fSF.fOl = paramString;
              ((lr)localObject5).fSF.toUser = parama;
              ((lr)localObject5).fSF.fSG = paramMap;
              com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject5);
            }
            GMTrace.o(14456188829696L, 107707);
            return (d.b)localObject1;
            i = 0;
            continue;
            i = 0;
            break label6364;
            i = 0;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "", new Object[0]);
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", new Object[] { paramString.getMessage() });
            }
          }
        }
      }
      label7032:
      boolean bool1 = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void br(String paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */