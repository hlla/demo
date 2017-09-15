package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public final class az
{
  public static final Queue<Integer> hmL;
  public static final long[] hmM;
  private static final int[] hmN;
  public static final int[] hmO;
  public static final int[] hmP;
  private static long hmQ;
  public static volatile boolean hmR;
  public static int[] hmS;
  private static long hmT;
  public static volatile boolean hmU;
  
  static
  {
    GMTrace.i(16289871429632L, 121369);
    hmL = new ConcurrentLinkedQueue();
    hmM = new long[] { 5000L, 10000L, 30000L, 60000L, 180000L, 300000L, 600000L, 900000L, 1800000L, 3600000L, 10800000L, 21600000L, 43200000L, 86400000L };
    hmN = new int[] { 0, 1, 2, 3, 11, 12, 13, 4, 5, 6, 7, 8, 9, 10 };
    hmO = new int[] { 0, 1, 2, 3, 7, 8, 9, 10, 11, 12, 13 };
    hmP = new int[] { 4, 5, 6 };
    hmQ = 0L;
    hmR = false;
    hmS = new int[hmM.length];
    hmT = 0L;
    hmU = false;
    zt();
    GMTrace.o(16289871429632L, 121369);
  }
  
  public static void k(String paramString, long paramLong)
  {
    GMTrace.i(18782831509504L, 139943);
    if (paramString == null)
    {
      GMTrace.o(18782831509504L, 139943);
      return;
    }
    if ((paramString.endsWith("@chatroom")) && (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString).gkp == 0))
    {
      GMTrace.o(18782831509504L, 139943);
      return;
    }
    long l1 = zu();
    if (l1 <= 0L)
    {
      v.i("MicroMsg.MsgReporter", "[oneliang]current server time is 0l,then return");
      GMTrace.o(18782831509504L, 139943);
      return;
    }
    long l2 = l1 - paramLong;
    v.i("MicroMsg.MsgReporter", "[oneliang]current svr time:%s, msg svr time:%s, intervalTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong), Long.valueOf(l2) });
    int i = hmM.length - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (l2 >= hmM[i])
        {
          hmL.add(Integer.valueOf(hmN[i]));
          hmS[i] += 1;
        }
      }
      else
      {
        paramLong = l1 - hmQ;
        if ((!hmR) && ((hmL.size() >= 10) || (paramLong >= 900000L)))
        {
          v.i("MicroMsg.MsgReporter", "[oneliang]need to report,size:%s,last time:%s,report interval time:%s", new Object[] { Integer.valueOf(hmL.size()), Long.valueOf(hmQ), Long.valueOf(paramLong) });
          hmR = true;
          com.tencent.mm.sdk.f.e.b(new b(), "msg_delay_idkey_report", 1);
          hmQ = l1;
        }
        paramLong = l1 - hmT;
        if ((!hmU) && (paramLong >= 900000L))
        {
          v.i("MicroMsg.MsgReporter", "[oneliang]need to kv stat and report,last time:%s,report interval time:%s", new Object[] { Long.valueOf(hmT), Long.valueOf(paramLong) });
          hmU = true;
          com.tencent.mm.sdk.f.e.b(new c(l1), "msg_delay_kv_stat_and_report", 1);
          hmT = l1;
        }
        GMTrace.o(18782831509504L, 139943);
        return;
      }
      i -= 1;
    }
  }
  
  public static void zt()
  {
    GMTrace.i(16429592084480L, 122410);
    int i = 0;
    while (i < hmS.length)
    {
      hmS[i] = 0;
      i += 1;
    }
    GMTrace.o(16429592084480L, 122410);
  }
  
  private static long zu()
  {
    long l1 = 0L;
    GMTrace.i(16429726302208L, 122411);
    long l2 = System.currentTimeMillis();
    try
    {
      com.tencent.mm.kernel.h.vJ();
      Object localObject = com.tencent.mm.kernel.h.vI().vr().get(w.a.uFA, null);
      if (localObject == null)
      {
        GMTrace.o(16429726302208L, 122411);
        return 0L;
      }
      long l3 = bf.getLong(localObject.toString(), 0L);
      l1 = l2 - l3;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.MsgReporter", localThrowable, "", new Object[0]);
      }
    }
    GMTrace.o(16429726302208L, 122411);
    return l1;
  }
  
  private static final class a
  {
    long hmV;
    int[] hmW;
    
    a(long paramLong, int[] paramArrayOfInt)
    {
      GMTrace.i(16430665826304L, 122418);
      this.hmV = 0L;
      this.hmW = new int[az.hmM.length];
      int i = 0;
      while (i < this.hmW.length)
      {
        this.hmW[i] = 0;
        i += 1;
      }
      this.hmV = paramLong;
      if (paramArrayOfInt != null) {
        System.arraycopy(paramArrayOfInt, 0, this.hmW, 0, paramArrayOfInt.length);
      }
      GMTrace.o(16430665826304L, 122418);
    }
    
    static a go(String paramString)
    {
      GMTrace.i(16431202697216L, 122422);
      try
      {
        paramString = new JSONObject(paramString);
        boolean bool = paramString.has("firstTime");
        if (!bool)
        {
          GMTrace.o(16431202697216L, 122422);
          return null;
        }
        l = paramString.getLong("firstTime");
        if ((!paramString.has("counter")) || (!(paramString.get("counter") instanceof JSONArray))) {
          break label179;
        }
        JSONArray localJSONArray = paramString.getJSONArray("counter");
        int j = localJSONArray.length();
        int i = az.hmM.length;
        if (j != i)
        {
          GMTrace.o(16431202697216L, 122422);
          return null;
        }
        paramString = new int[j];
        i = 0;
        while (i < j)
        {
          paramString[i] = localJSONArray.getInt(i);
          i += 1;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          long l;
          v.e("MicroMsg.MsgReporter", "error:" + paramString.getMessage());
          paramString = null;
          continue;
          paramString = null;
        }
      }
      paramString = new a(l, paramString);
      GMTrace.o(16431202697216L, 122422);
      return paramString;
    }
    
    final void e(int[] paramArrayOfInt)
    {
      GMTrace.i(16766075928576L, 124917);
      if ((paramArrayOfInt == null) || (this.hmW.length != paramArrayOfInt.length))
      {
        GMTrace.o(16766075928576L, 124917);
        return;
      }
      int i = 0;
      while (i < this.hmW.length)
      {
        int[] arrayOfInt = this.hmW;
        arrayOfInt[i] += paramArrayOfInt[i];
        i += 1;
      }
      GMTrace.o(16766075928576L, 124917);
    }
    
    final String zv()
    {
      GMTrace.i(16430934261760L, 122420);
      Object localObject1 = null;
      try
      {
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("firstTime", this.hmV);
        JSONArray localJSONArray = new JSONArray();
        if (this.hmW != null)
        {
          int i = 0;
          while (i < this.hmW.length)
          {
            localJSONArray.put(this.hmW[i]);
            i += 1;
          }
        }
        ((JSONObject)localObject2).put("counter", localJSONArray);
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.MsgReporter", "error:" + localException.getMessage());
        }
      }
      GMTrace.o(16430934261760L, 122420);
      return (String)localObject1;
    }
    
    public final boolean zw()
    {
      GMTrace.i(16431068479488L, 122421);
      int i = 0;
      while (i < this.hmW.length)
      {
        if (this.hmW[i] > 0)
        {
          GMTrace.o(16431068479488L, 122421);
          return true;
        }
        i += 1;
      }
      GMTrace.o(16431068479488L, 122421);
      return false;
    }
    
    final String zx()
    {
      GMTrace.i(16431336914944L, 122423);
      Object localObject = new StringBuilder();
      try
      {
        ((StringBuilder)localObject).append(0);
        ((StringBuilder)localObject).append(",");
        int i = 0;
        while (i < az.hmO.length)
        {
          ((StringBuilder)localObject).append(this.hmW[az.hmO[i]]);
          ((StringBuilder)localObject).append(",");
          i += 1;
        }
        ((StringBuilder)localObject).append(this.hmV / 1000L);
        ((StringBuilder)localObject).append(",");
        i = 0;
        while (i < az.hmP.length)
        {
          ((StringBuilder)localObject).append(this.hmW[az.hmP[i]]);
          ((StringBuilder)localObject).append(",");
          i += 1;
        }
        ((StringBuilder)localObject).delete(((StringBuilder)localObject).length() - 1, ((StringBuilder)localObject).length());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.MsgReporter", localException, null, new Object[0]);
        }
      }
      localObject = ((StringBuilder)localObject).toString();
      GMTrace.o(16431336914944L, 122423);
      return (String)localObject;
    }
  }
  
  private static final class b
    implements Runnable
  {
    public b()
    {
      GMTrace.i(16430397390848L, 122416);
      GMTrace.o(16430397390848L, 122416);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc2_w 30
      //   3: ldc 32
      //   5: invokestatic 22	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   8: getstatic 36	com/tencent/mm/u/az:hmL	Ljava/util/Queue;
      //   11: invokeinterface 42 1 0
      //   16: ifne +60 -> 76
      //   19: getstatic 36	com/tencent/mm/u/az:hmL	Ljava/util/Queue;
      //   22: invokeinterface 46 1 0
      //   27: checkcast 48	java/lang/Integer
      //   30: invokevirtual 52	java/lang/Integer:intValue	()I
      //   33: istore_1
      //   34: getstatic 58	com/tencent/mm/plugin/report/c:oRz	Lcom/tencent/mm/plugin/report/c;
      //   37: ldc2_w 59
      //   40: iload_1
      //   41: i2l
      //   42: lconst_1
      //   43: iconst_0
      //   44: invokevirtual 64	com/tencent/mm/plugin/report/c:a	(JJJZ)V
      //   47: goto -39 -> 8
      //   50: astore_2
      //   51: ldc 66
      //   53: aload_2
      //   54: ldc 68
      //   56: iconst_0
      //   57: anewarray 4	java/lang/Object
      //   60: invokestatic 74	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   63: iconst_0
      //   64: putstatic 78	com/tencent/mm/u/az:hmR	Z
      //   67: ldc2_w 30
      //   70: ldc 32
      //   72: invokestatic 25	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   75: return
      //   76: iconst_0
      //   77: putstatic 78	com/tencent/mm/u/az:hmR	Z
      //   80: iconst_0
      //   81: putstatic 78	com/tencent/mm/u/az:hmR	Z
      //   84: ldc2_w 30
      //   87: ldc 32
      //   89: invokestatic 25	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   92: return
      //   93: astore_2
      //   94: iconst_0
      //   95: putstatic 78	com/tencent/mm/u/az:hmR	Z
      //   98: aload_2
      //   99: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	100	0	this	b
      //   33	8	1	i	int
      //   50	4	2	localThrowable	Throwable
      //   93	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   8	47	50	java/lang/Throwable
      //   76	80	50	java/lang/Throwable
      //   8	47	93	finally
      //   51	63	93	finally
      //   76	80	93	finally
    }
  }
  
  private static final class c
    implements Runnable
  {
    final long hmX;
    
    c(long paramLong)
    {
      GMTrace.i(16429323649024L, 122408);
      this.hmX = paramLong;
      GMTrace.o(16429323649024L, 122408);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc2_w 35
      //   3: ldc 37
      //   5: invokestatic 25	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   8: invokestatic 43	com/tencent/mm/kernel/h:vJ	()Lcom/tencent/mm/kernel/h;
      //   11: pop
      //   12: invokestatic 47	com/tencent/mm/kernel/h:vI	()Lcom/tencent/mm/kernel/e;
      //   15: invokevirtual 53	com/tencent/mm/kernel/e:vr	()Lcom/tencent/mm/storage/t;
      //   18: getstatic 59	com/tencent/mm/storage/w$a:uFB	Lcom/tencent/mm/storage/w$a;
      //   21: aconst_null
      //   22: invokevirtual 65	com/tencent/mm/storage/t:get	(Lcom/tencent/mm/storage/w$a;Ljava/lang/Object;)Ljava/lang/Object;
      //   25: astore_1
      //   26: aload_1
      //   27: ifnonnull +233 -> 260
      //   30: new 67	com/tencent/mm/u/az$a
      //   33: dup
      //   34: aload_0
      //   35: getfield 27	com/tencent/mm/u/az$c:hmX	J
      //   38: getstatic 71	com/tencent/mm/u/az:hmS	[I
      //   41: invokespecial 74	com/tencent/mm/u/az$a:<init>	(J[I)V
      //   44: astore_1
      //   45: aload_1
      //   46: invokevirtual 78	com/tencent/mm/u/az$a:zv	()Ljava/lang/String;
      //   49: astore_2
      //   50: aload_2
      //   51: ifnonnull +20 -> 71
      //   54: iconst_0
      //   55: putstatic 82	com/tencent/mm/u/az:hmU	Z
      //   58: iconst_0
      //   59: putstatic 82	com/tencent/mm/u/az:hmU	Z
      //   62: ldc2_w 35
      //   65: ldc 37
      //   67: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   70: return
      //   71: ldc 84
      //   73: new 86	java/lang/StringBuilder
      //   76: dup
      //   77: ldc 88
      //   79: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   82: aload_2
      //   83: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   86: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   89: invokestatic 103	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   92: invokestatic 43	com/tencent/mm/kernel/h:vJ	()Lcom/tencent/mm/kernel/h;
      //   95: pop
      //   96: invokestatic 47	com/tencent/mm/kernel/h:vI	()Lcom/tencent/mm/kernel/e;
      //   99: invokevirtual 53	com/tencent/mm/kernel/e:vr	()Lcom/tencent/mm/storage/t;
      //   102: getstatic 59	com/tencent/mm/storage/w$a:uFB	Lcom/tencent/mm/storage/w$a;
      //   105: aload_2
      //   106: invokevirtual 107	com/tencent/mm/storage/t:a	(Lcom/tencent/mm/storage/w$a;Ljava/lang/Object;)V
      //   109: invokestatic 110	com/tencent/mm/u/az:zt	()V
      //   112: aload_1
      //   113: ifnull +130 -> 243
      //   116: aload_1
      //   117: invokevirtual 114	com/tencent/mm/u/az$a:zw	()Z
      //   120: ifeq +123 -> 243
      //   123: aload_0
      //   124: getfield 27	com/tencent/mm/u/az$c:hmX	J
      //   127: aload_1
      //   128: getfield 117	com/tencent/mm/u/az$a:hmV	J
      //   131: lsub
      //   132: ldc2_w 118
      //   135: lcmp
      //   136: iflt +107 -> 243
      //   139: aload_1
      //   140: invokevirtual 122	com/tencent/mm/u/az$a:zx	()Ljava/lang/String;
      //   143: astore_1
      //   144: ldc 84
      //   146: new 86	java/lang/StringBuilder
      //   149: dup
      //   150: ldc 124
      //   152: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   155: aload_1
      //   156: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   159: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   162: invokestatic 103	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   165: new 67	com/tencent/mm/u/az$a
      //   168: dup
      //   169: aload_0
      //   170: getfield 27	com/tencent/mm/u/az$c:hmX	J
      //   173: aconst_null
      //   174: invokespecial 74	com/tencent/mm/u/az$a:<init>	(J[I)V
      //   177: invokevirtual 78	com/tencent/mm/u/az$a:zv	()Ljava/lang/String;
      //   180: astore_2
      //   181: ldc 84
      //   183: new 86	java/lang/StringBuilder
      //   186: dup
      //   187: ldc 126
      //   189: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   192: aload_2
      //   193: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   196: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   199: invokestatic 103	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   202: invokestatic 43	com/tencent/mm/kernel/h:vJ	()Lcom/tencent/mm/kernel/h;
      //   205: pop
      //   206: invokestatic 47	com/tencent/mm/kernel/h:vI	()Lcom/tencent/mm/kernel/e;
      //   209: invokevirtual 53	com/tencent/mm/kernel/e:vr	()Lcom/tencent/mm/storage/t;
      //   212: getstatic 59	com/tencent/mm/storage/w$a:uFB	Lcom/tencent/mm/storage/w$a;
      //   215: aload_2
      //   216: invokevirtual 107	com/tencent/mm/storage/t:a	(Lcom/tencent/mm/storage/w$a;Ljava/lang/Object;)V
      //   219: invokestatic 43	com/tencent/mm/kernel/h:vJ	()Lcom/tencent/mm/kernel/h;
      //   222: pop
      //   223: invokestatic 47	com/tencent/mm/kernel/h:vI	()Lcom/tencent/mm/kernel/e;
      //   226: invokevirtual 53	com/tencent/mm/kernel/e:vr	()Lcom/tencent/mm/storage/t;
      //   229: iconst_1
      //   230: invokevirtual 130	com/tencent/mm/storage/t:jV	(Z)V
      //   233: getstatic 136	com/tencent/mm/plugin/report/c:oRz	Lcom/tencent/mm/plugin/report/c;
      //   236: sipush 14331
      //   239: aload_1
      //   240: invokevirtual 140	com/tencent/mm/plugin/report/c:A	(ILjava/lang/String;)V
      //   243: iconst_0
      //   244: putstatic 82	com/tencent/mm/u/az:hmU	Z
      //   247: iconst_0
      //   248: putstatic 82	com/tencent/mm/u/az:hmU	Z
      //   251: ldc2_w 35
      //   254: ldc 37
      //   256: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   259: return
      //   260: aload_1
      //   261: invokevirtual 141	java/lang/Object:toString	()Ljava/lang/String;
      //   264: invokestatic 145	com/tencent/mm/u/az$a:go	(Ljava/lang/String;)Lcom/tencent/mm/u/az$a;
      //   267: astore_1
      //   268: aload_1
      //   269: ifnonnull +20 -> 289
      //   272: iconst_0
      //   273: putstatic 82	com/tencent/mm/u/az:hmU	Z
      //   276: iconst_0
      //   277: putstatic 82	com/tencent/mm/u/az:hmU	Z
      //   280: ldc2_w 35
      //   283: ldc 37
      //   285: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   288: return
      //   289: aload_1
      //   290: getstatic 71	com/tencent/mm/u/az:hmS	[I
      //   293: invokevirtual 149	com/tencent/mm/u/az$a:e	([I)V
      //   296: aload_1
      //   297: invokevirtual 78	com/tencent/mm/u/az$a:zv	()Ljava/lang/String;
      //   300: astore_2
      //   301: ldc 84
      //   303: new 86	java/lang/StringBuilder
      //   306: dup
      //   307: ldc -105
      //   309: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   312: aload_2
      //   313: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   316: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   319: invokestatic 103	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   322: goto -230 -> 92
      //   325: astore_1
      //   326: ldc 84
      //   328: aload_1
      //   329: ldc -103
      //   331: iconst_0
      //   332: anewarray 4	java/lang/Object
      //   335: invokestatic 157	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   338: iconst_0
      //   339: putstatic 82	com/tencent/mm/u/az:hmU	Z
      //   342: ldc2_w 35
      //   345: ldc 37
      //   347: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   350: return
      //   351: astore_1
      //   352: iconst_0
      //   353: putstatic 82	com/tencent/mm/u/az:hmU	Z
      //   356: aload_1
      //   357: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	358	0	this	c
      //   25	272	1	localObject1	Object
      //   325	4	1	localThrowable	Throwable
      //   351	6	1	localObject2	Object
      //   49	264	2	str	String
      // Exception table:
      //   from	to	target	type
      //   8	26	325	java/lang/Throwable
      //   30	50	325	java/lang/Throwable
      //   54	58	325	java/lang/Throwable
      //   71	92	325	java/lang/Throwable
      //   92	112	325	java/lang/Throwable
      //   116	243	325	java/lang/Throwable
      //   243	247	325	java/lang/Throwable
      //   260	268	325	java/lang/Throwable
      //   272	276	325	java/lang/Throwable
      //   289	322	325	java/lang/Throwable
      //   8	26	351	finally
      //   30	50	351	finally
      //   54	58	351	finally
      //   71	92	351	finally
      //   92	112	351	finally
      //   116	243	351	finally
      //   243	247	351	finally
      //   260	268	351	finally
      //   272	276	351	finally
      //   289	322	351	finally
      //   326	338	351	finally
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */