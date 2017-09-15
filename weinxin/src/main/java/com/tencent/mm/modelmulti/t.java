package com.tencent.mm.modelmulti;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.LinkedList;

public final class t
{
  public static ArrayList<bu> hMv;
  public static ArrayList<x> hMw;
  
  static
  {
    GMTrace.i(396344950784L, 2953);
    hMv = new ArrayList();
    hMw = new ArrayList();
    GMTrace.o(396344950784L, 2953);
  }
  
  public static void HD()
  {
    GMTrace.i(16008953724928L, 119276);
    ap.yY();
    Cursor localCursor = c.wR().d(null, null, new ArrayList());
    while (localCursor.moveToNext())
    {
      x localx = new x();
      localx.b(localCursor);
      hMw.add(localx);
    }
    localCursor.close();
    GMTrace.o(16008953724928L, 119276);
  }
  
  public static void aP(int paramInt1, final int paramInt2)
  {
    GMTrace.i(395673862144L, 2948);
    ap.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(410169376768L, 3056);
        t.HD();
        t.jS(e.hgk + "/testaddmsg.txt");
        if ((t.hMw.size() <= 0) || (t.hMv.size() <= 0))
        {
          v.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[] { Integer.valueOf(t.hMv.size()), Integer.valueOf(t.hMw.size()) });
          GMTrace.o(410169376768L, 3056);
          return;
        }
        new ai(ap.vL().nIe.getLooper(), new ai.a()
        {
          int hMz;
          
          public final boolean oQ()
          {
            GMTrace.i(395002773504L, 2943);
            if (this.hMz <= 0)
            {
              GMTrace.o(395002773504L, 2943);
              return false;
            }
            this.hMz -= 1;
            w.b localb = new w.b();
            localb.sYx.tmy = new lu();
            int j = bf.dM(t.1.this.hMy, 1);
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label355;
              }
              bu localbu = (bu)t.hMv.get(bf.dM(t.hMv.size() - 1, 0));
              localbu.tdx = new avu().OU(((x)t.hMw.get(bf.dM(t.hMw.size() - 1, 0))).field_username);
              localbu.ofk = ((int)bf.Nz());
              localbu.tdE = Math.abs((int)bf.NA() % 10000000);
              try
              {
                Object localObject = new lt();
                ((lt)localObject).tqt = new avt();
                ((lt)localObject).tqt.bb(localbu.toByteArray());
                ((lt)localObject).tqs = 5;
                localb.sYx.tmy.jLs.add(localObject);
                localObject = localb.sYx.tmy;
                ((lu)localObject).jLr += 1;
                v.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[] { Integer.valueOf(this.hMz), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localb.sYx.tmy.jLs.size()), Long.valueOf(localbu.tdE), localbu.tdx.tXF });
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  v.d("MicroMsg.TestSyncAddMsg", localException.getMessage());
                  v.printErrStackTrace("MicroMsg.TestSyncAddMsg", localException, "", new Object[0]);
                }
              }
              i += 1;
            }
            label355:
            localb.sYx.tkt = 0;
            anr localanr = localb.sYx;
            ap.yY();
            localanr.tmv = n.G(bf.PS(bf.mz((String)c.vr().get(8195, new byte[0]))));
            localb.sYx.tgr = 0;
            localb.sYx.jLP = 0;
            q.Hz().a(localb, 0, bf.Nz());
            GMTrace.o(395002773504L, 2943);
            return true;
          }
        }, true).v(3000L, 3000L);
        GMTrace.o(410169376768L, 3056);
      }
    });
    GMTrace.o(395673862144L, 2948);
  }
  
  /* Error */
  public static void jS(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc2_w 99
    //   5: ldc 101
    //   7: invokestatic 23	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   10: new 103	java/io/BufferedReader
    //   13: dup
    //   14: new 105	java/io/InputStreamReader
    //   17: dup
    //   18: new 107	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 112	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   29: invokespecial 115	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   32: astore_3
    //   33: aload_3
    //   34: astore_0
    //   35: aload_3
    //   36: invokevirtual 119	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore 4
    //   41: aload 4
    //   43: ifnull +270 -> 313
    //   46: iload_1
    //   47: iconst_1
    //   48: iadd
    //   49: istore_2
    //   50: aload_3
    //   51: astore_0
    //   52: aload 4
    //   54: ldc 121
    //   56: invokevirtual 127	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnull +12 -> 75
    //   66: aload_3
    //   67: astore_0
    //   68: aload 4
    //   70: arraylength
    //   71: iconst_3
    //   72: if_icmpeq +102 -> 174
    //   75: aload 4
    //   77: ifnonnull +88 -> 165
    //   80: iconst_m1
    //   81: istore_1
    //   82: aload_3
    //   83: astore_0
    //   84: ldc -127
    //   86: ldc -125
    //   88: iconst_2
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: iload_2
    //   95: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload_1
    //   102: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokestatic 143	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: iload_2
    //   110: istore_1
    //   111: goto -78 -> 33
    //   114: astore 4
    //   116: aload_3
    //   117: astore_0
    //   118: ldc -127
    //   120: ldc -111
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload 4
    //   130: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 143	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_3
    //   138: astore_0
    //   139: ldc -127
    //   141: aload 4
    //   143: ldc -106
    //   145: iconst_0
    //   146: anewarray 4	java/lang/Object
    //   149: invokestatic 154	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_3
    //   153: invokevirtual 155	java/io/BufferedReader:close	()V
    //   156: ldc2_w 99
    //   159: ldc 101
    //   161: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   164: return
    //   165: aload_3
    //   166: astore_0
    //   167: aload 4
    //   169: arraylength
    //   170: istore_1
    //   171: goto -89 -> 82
    //   174: aload_3
    //   175: astore_0
    //   176: new 157	com/tencent/mm/protocal/c/bu
    //   179: dup
    //   180: invokespecial 158	com/tencent/mm/protocal/c/bu:<init>	()V
    //   183: astore 5
    //   185: aload_3
    //   186: astore_0
    //   187: aload 5
    //   189: new 160	com/tencent/mm/protocal/c/avu
    //   192: dup
    //   193: invokespecial 161	com/tencent/mm/protocal/c/avu:<init>	()V
    //   196: invokestatic 166	com/tencent/mm/u/m:xL	()Ljava/lang/String;
    //   199: invokevirtual 170	com/tencent/mm/protocal/c/avu:OU	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/avu;
    //   202: putfield 174	com/tencent/mm/protocal/c/bu:tdy	Lcom/tencent/mm/protocal/c/avu;
    //   205: aload_3
    //   206: astore_0
    //   207: aload 5
    //   209: iconst_2
    //   210: putfield 178	com/tencent/mm/protocal/c/bu:jLP	I
    //   213: aload_3
    //   214: astore_0
    //   215: aload 5
    //   217: new 180	com/tencent/mm/protocal/c/avt
    //   220: dup
    //   221: invokespecial 181	com/tencent/mm/protocal/c/avt:<init>	()V
    //   224: iconst_0
    //   225: newarray <illegal type>
    //   227: invokevirtual 185	com/tencent/mm/protocal/c/avt:bb	([B)Lcom/tencent/mm/protocal/c/avt;
    //   230: putfield 189	com/tencent/mm/protocal/c/bu:tdB	Lcom/tencent/mm/protocal/c/avt;
    //   233: aload_3
    //   234: astore_0
    //   235: aload 5
    //   237: aload 4
    //   239: iconst_0
    //   240: aaload
    //   241: iconst_0
    //   242: invokestatic 195	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   245: putfield 198	com/tencent/mm/protocal/c/bu:mrC	I
    //   248: aload_3
    //   249: astore_0
    //   250: aload 5
    //   252: aload 4
    //   254: iconst_1
    //   255: aaload
    //   256: iconst_0
    //   257: invokestatic 195	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   260: putfield 201	com/tencent/mm/protocal/c/bu:tdA	I
    //   263: aload_3
    //   264: astore_0
    //   265: aload 5
    //   267: new 160	com/tencent/mm/protocal/c/avu
    //   270: dup
    //   271: invokespecial 161	com/tencent/mm/protocal/c/avu:<init>	()V
    //   274: aload 4
    //   276: iconst_2
    //   277: aaload
    //   278: invokevirtual 170	com/tencent/mm/protocal/c/avu:OU	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/avu;
    //   281: putfield 204	com/tencent/mm/protocal/c/bu:tdz	Lcom/tencent/mm/protocal/c/avu;
    //   284: aload_3
    //   285: astore_0
    //   286: getstatic 30	com/tencent/mm/modelmulti/t:hMv	Ljava/util/ArrayList;
    //   289: aload 5
    //   291: invokevirtual 75	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   294: pop
    //   295: iload_2
    //   296: istore_1
    //   297: goto -264 -> 33
    //   300: astore 4
    //   302: aload_0
    //   303: astore_3
    //   304: aload 4
    //   306: astore_0
    //   307: aload_3
    //   308: invokevirtual 155	java/io/BufferedReader:close	()V
    //   311: aload_0
    //   312: athrow
    //   313: aload_3
    //   314: invokevirtual 155	java/io/BufferedReader:close	()V
    //   317: ldc2_w 99
    //   320: ldc 101
    //   322: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   325: return
    //   326: astore_0
    //   327: ldc2_w 99
    //   330: ldc 101
    //   332: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   335: return
    //   336: astore_0
    //   337: ldc2_w 99
    //   340: ldc 101
    //   342: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   345: return
    //   346: astore_3
    //   347: goto -36 -> 311
    //   350: astore_0
    //   351: aconst_null
    //   352: astore_3
    //   353: goto -46 -> 307
    //   356: astore 4
    //   358: aconst_null
    //   359: astore_3
    //   360: goto -244 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramString	String
    //   1	296	1	i	int
    //   49	247	2	j	int
    //   32	282	3	localObject1	Object
    //   346	1	3	localException1	Exception
    //   352	8	3	localObject2	Object
    //   39	37	4	localObject3	Object
    //   114	161	4	localException2	Exception
    //   300	5	4	localObject4	Object
    //   356	1	4	localException3	Exception
    //   183	107	5	localbu	bu
    // Exception table:
    //   from	to	target	type
    //   35	41	114	java/lang/Exception
    //   52	61	114	java/lang/Exception
    //   68	75	114	java/lang/Exception
    //   84	109	114	java/lang/Exception
    //   167	171	114	java/lang/Exception
    //   176	185	114	java/lang/Exception
    //   187	205	114	java/lang/Exception
    //   207	213	114	java/lang/Exception
    //   215	233	114	java/lang/Exception
    //   235	248	114	java/lang/Exception
    //   250	263	114	java/lang/Exception
    //   265	284	114	java/lang/Exception
    //   286	295	114	java/lang/Exception
    //   35	41	300	finally
    //   52	61	300	finally
    //   68	75	300	finally
    //   84	109	300	finally
    //   118	137	300	finally
    //   139	152	300	finally
    //   167	171	300	finally
    //   176	185	300	finally
    //   187	205	300	finally
    //   207	213	300	finally
    //   215	233	300	finally
    //   235	248	300	finally
    //   250	263	300	finally
    //   265	284	300	finally
    //   286	295	300	finally
    //   313	317	326	java/lang/Exception
    //   152	156	336	java/lang/Exception
    //   307	311	346	java/lang/Exception
    //   10	33	350	finally
    //   10	33	356	java/lang/Exception
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */