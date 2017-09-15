package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class y
{
  final a[] ieR;
  
  public y()
  {
    GMTrace.i(13706582818816L, 102122);
    this.ieR = new a[100];
    GMTrace.o(13706582818816L, 102122);
  }
  
  final boolean MD()
  {
    GMTrace.i(13706851254272L, 102124);
    a[] arrayOfa = this.ieR;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.ieR[i] != null) && ((701 == this.ieR[i].ieV.getType()) || (702 == this.ieR[i].ieV.getType())))
        {
          v.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.ieR[i].ieV.getType());
          GMTrace.o(13706851254272L, 102124);
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.ieR[i] = null;
        v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bf.g(localRemoteException), Integer.valueOf(i) });
        break label180;
        GMTrace.o(13706851254272L, 102124);
        return false;
      }
      finally {}
      label180:
      i += 1;
    }
  }
  
  final boolean ME()
  {
    GMTrace.i(13706985472000L, 102125);
    a[] arrayOfa = this.ieR;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.ieR[i] != null) && (1000 == this.ieR[i].ieV.getType()))
        {
          v.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.ieR[i].ieV.getType());
          GMTrace.o(13706985472000L, 102125);
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.ieR[i] = null;
        v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bf.g(localRemoteException), Integer.valueOf(i) });
        break label160;
        GMTrace.o(13706985472000L, 102125);
        return false;
      }
      finally {}
      label160:
      i += 1;
    }
  }
  
  public final int MF()
  {
    GMTrace.i(13707253907456L, 102127);
    int i = 0;
    int k;
    for (int j = 0; i < 100; j = k)
    {
      k = j;
      try
      {
        if (this.ieR[i] != null)
        {
          this.ieR[i].ieV.getType();
          k = j;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bf.g(localRemoteException), Integer.valueOf(i) });
          k = j + 1;
          this.ieR[i] = null;
        }
      }
      i += 1;
    }
    GMTrace.o(13707253907456L, 102127);
    return j;
  }
  
  /* Error */
  final int a(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: ldc2_w 107
    //   3: ldc 109
    //   5: invokestatic 24	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: aload_0
    //   9: getfield 26	com/tencent/mm/network/y:ieR	[Lcom/tencent/mm/network/y$a;
    //   12: astore 6
    //   14: aload 6
    //   16: monitorenter
    //   17: aload_0
    //   18: iload_1
    //   19: invokevirtual 113	com/tencent/mm/network/y:gW	(I)I
    //   22: istore 4
    //   24: iconst_m1
    //   25: iload 4
    //   27: if_icmpne +16 -> 43
    //   30: aload 6
    //   32: monitorexit
    //   33: ldc2_w 107
    //   36: ldc 109
    //   38: invokestatic 29	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   41: iconst_m1
    //   42: ireturn
    //   43: getstatic 119	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_DEFAULT	I
    //   46: istore_1
    //   47: aload_0
    //   48: getfield 26	com/tencent/mm/network/y:ieR	[Lcom/tencent/mm/network/y$a;
    //   51: iload 4
    //   53: aaload
    //   54: getfield 41	com/tencent/mm/network/y$a:ieV	Lcom/tencent/mm/network/q;
    //   57: invokeinterface 123 1 0
    //   62: invokeinterface 129 1 0
    //   67: astore 7
    //   69: aload_0
    //   70: getfield 26	com/tencent/mm/network/y:ieR	[Lcom/tencent/mm/network/y$a;
    //   73: iload 4
    //   75: aaload
    //   76: getfield 41	com/tencent/mm/network/y$a:ieV	Lcom/tencent/mm/network/q;
    //   79: invokeinterface 133 1 0
    //   84: astore 8
    //   86: aload 8
    //   88: aload_0
    //   89: getfield 26	com/tencent/mm/network/y:ieR	[Lcom/tencent/mm/network/y$a;
    //   92: iload 4
    //   94: aaload
    //   95: getfield 41	com/tencent/mm/network/y$a:ieV	Lcom/tencent/mm/network/q;
    //   98: invokeinterface 47 1 0
    //   103: aload_2
    //   104: aload 7
    //   106: invokeinterface 138 4 0
    //   111: ifeq +194 -> 305
    //   114: aload 8
    //   116: invokeinterface 141 1 0
    //   121: ifnull +28 -> 149
    //   124: bipush -13
    //   126: aload 8
    //   128: invokeinterface 144 1 0
    //   133: if_icmpne +16 -> 149
    //   136: invokestatic 150	com/tencent/mm/network/z:MP	()Lcom/tencent/mm/network/s;
    //   139: ifnull +10 -> 149
    //   142: invokestatic 150	com/tencent/mm/network/z:MP	()Lcom/tencent/mm/network/s;
    //   145: invokevirtual 155	com/tencent/mm/network/s:Mw	()Z
    //   148: pop
    //   149: bipush -13
    //   151: aload 8
    //   153: invokeinterface 144 1 0
    //   158: if_icmpne +41 -> 199
    //   161: getstatic 158	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_SESSION_TIMEOUT	I
    //   164: istore 5
    //   166: iload 5
    //   168: istore_1
    //   169: iload 5
    //   171: istore 4
    //   173: aload_3
    //   174: iconst_0
    //   175: aload 8
    //   177: invokeinterface 144 1 0
    //   182: iastore
    //   183: iload 5
    //   185: istore_1
    //   186: aload 6
    //   188: monitorexit
    //   189: ldc2_w 107
    //   192: ldc 109
    //   194: invokestatic 29	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   197: iload_1
    //   198: ireturn
    //   199: sipush 62534
    //   202: aload 8
    //   204: invokeinterface 144 1 0
    //   209: if_icmpeq +16 -> 225
    //   212: sipush 62533
    //   215: aload 8
    //   217: invokeinterface 144 1 0
    //   222: if_icmpne +31 -> 253
    //   225: getstatic 161	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_TASK_END	I
    //   228: istore 5
    //   230: iload 5
    //   232: istore_1
    //   233: iload 5
    //   235: istore 4
    //   237: aload_3
    //   238: iconst_0
    //   239: aload 8
    //   241: invokeinterface 144 1 0
    //   246: iastore
    //   247: iload 5
    //   249: istore_1
    //   250: goto -64 -> 186
    //   253: sipush 62535
    //   256: aload 8
    //   258: invokeinterface 144 1 0
    //   263: if_icmpne +31 -> 294
    //   266: getstatic 158	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_SESSION_TIMEOUT	I
    //   269: istore 5
    //   271: iload 5
    //   273: istore_1
    //   274: iload 5
    //   276: istore 4
    //   278: aload_3
    //   279: iconst_0
    //   280: aload 8
    //   282: invokeinterface 144 1 0
    //   287: iastore
    //   288: iload 5
    //   290: istore_1
    //   291: goto -105 -> 186
    //   294: getstatic 164	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_NORMAL	I
    //   297: istore 4
    //   299: iload 4
    //   301: istore_1
    //   302: goto -116 -> 186
    //   305: getstatic 170	com/tencent/mm/plugin/report/c:oRz	Lcom/tencent/mm/plugin/report/c;
    //   308: ldc2_w 171
    //   311: ldc2_w 173
    //   314: lconst_1
    //   315: iconst_0
    //   316: invokevirtual 177	com/tencent/mm/plugin/report/c:a	(JJJZ)V
    //   319: ldc 49
    //   321: ldc -77
    //   323: invokestatic 181	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: goto -140 -> 186
    //   329: astore_2
    //   330: getstatic 170	com/tencent/mm/plugin/report/c:oRz	Lcom/tencent/mm/plugin/report/c;
    //   333: ldc2_w 171
    //   336: ldc2_w 182
    //   339: lconst_1
    //   340: iconst_0
    //   341: invokevirtual 177	com/tencent/mm/plugin/report/c:a	(JJJZ)V
    //   344: ldc 49
    //   346: ldc -71
    //   348: iconst_1
    //   349: anewarray 4	java/lang/Object
    //   352: dup
    //   353: iconst_0
    //   354: aload_2
    //   355: invokestatic 83	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   358: aastore
    //   359: invokestatic 93	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   362: goto -176 -> 186
    //   365: getstatic 170	com/tencent/mm/plugin/report/c:oRz	Lcom/tencent/mm/plugin/report/c;
    //   368: ldc2_w 171
    //   371: ldc2_w 186
    //   374: lconst_1
    //   375: iconst_0
    //   376: invokevirtual 177	com/tencent/mm/plugin/report/c:a	(JJJZ)V
    //   379: ldc 49
    //   381: ldc -71
    //   383: iconst_1
    //   384: anewarray 4	java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: aload_2
    //   390: invokestatic 83	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   393: aastore
    //   394: invokestatic 93	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   397: goto -211 -> 186
    //   400: astore_2
    //   401: aload 6
    //   403: monitorexit
    //   404: aload_2
    //   405: athrow
    //   406: astore_2
    //   407: goto -42 -> 365
    //   410: astore_2
    //   411: iload 4
    //   413: istore_1
    //   414: goto -84 -> 330
    //   417: astore_2
    //   418: goto -53 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	y
    //   0	421	1	paramInt	int
    //   0	421	2	paramArrayOfByte	byte[]
    //   0	421	3	paramArrayOfInt	int[]
    //   22	390	4	i	int
    //   164	125	5	j	int
    //   12	390	6	arrayOfa	a[]
    //   67	38	7	arrayOfByte	byte[]
    //   84	197	8	localh	h
    // Exception table:
    //   from	to	target	type
    //   47	149	329	android/os/RemoteException
    //   149	166	329	android/os/RemoteException
    //   199	225	329	android/os/RemoteException
    //   225	230	329	android/os/RemoteException
    //   253	271	329	android/os/RemoteException
    //   294	299	329	android/os/RemoteException
    //   305	326	329	android/os/RemoteException
    //   17	24	400	finally
    //   30	33	400	finally
    //   43	47	400	finally
    //   47	149	400	finally
    //   149	166	400	finally
    //   173	183	400	finally
    //   186	189	400	finally
    //   199	225	400	finally
    //   225	230	400	finally
    //   237	247	400	finally
    //   253	271	400	finally
    //   278	288	400	finally
    //   294	299	400	finally
    //   305	326	400	finally
    //   330	362	400	finally
    //   365	397	400	finally
    //   401	404	400	finally
    //   173	183	406	java/lang/Exception
    //   237	247	406	java/lang/Exception
    //   278	288	406	java/lang/Exception
    //   173	183	410	android/os/RemoteException
    //   237	247	410	android/os/RemoteException
    //   278	288	410	android/os/RemoteException
    //   47	149	417	java/lang/Exception
    //   149	166	417	java/lang/Exception
    //   199	225	417	java/lang/Exception
    //   225	230	417	java/lang/Exception
    //   253	271	417	java/lang/Exception
    //   294	299	417	java/lang/Exception
    //   305	326	417	java/lang/Exception
  }
  
  public final int a(q paramq, k paramk, c paramc, int paramInt)
  {
    GMTrace.i(13707388125184L, 102128);
    if (paramq == null)
    {
      v.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
      GMTrace.o(13707388125184L, 102128);
      return -1;
    }
    paramq.hashCode();
    StnLogic.Task localTask = new StnLogic.Task();
    a[] arrayOfa = this.ieR;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      for (;;)
      {
        try
        {
          if (this.ieR[i] != null) {
            break;
          }
          this.ieR[i] = new a();
          this.ieR[i].ieV = paramq;
          this.ieR[i].ieW = paramk;
          this.ieR[i].ieX = paramc;
          this.ieR[i].startTime = bf.NA();
          this.ieR[i].taskId = localTask.taskID;
          localTask.cmdID = paramq.Cm().getCmdId();
          localTask.cgi = paramq.getUri();
          int j = paramq.getType();
          boolean bool;
          if ((paramq.BD() & 0x1) != 1)
          {
            bool = true;
            localTask.needAuthed = bool;
            if ((j == 126) || (j == 701) || (j == 702))
            {
              localTask.needAuthed = false;
              if (j == 701) {
                localTask.retryCount = 1;
              }
            }
            localTask.limitFlow = true;
            if ((j == 149) || (j == 193) || (j == 220) || (j == 323) || (j == 324) || (j == 326) || (j == 327)) {
              localTask.limitFlow = false;
            }
            localTask.channelStrategy = 0;
            if ((j == 233) || (j == 835) || (j == 238)) {
              localTask.channelStrategy = 1;
            }
            localTask.sendOnly = false;
            if ((j == 10) || (j == 268369922)) {
              localTask.sendOnly = true;
            }
            if ((paramq.Cm().Cl()) && (paramq.getUri() != null) && (paramq.getUri().length() > 0)) {
              localTask.channelSelect |= 0x1;
            }
            if (localTask.cmdID != 0) {
              localTask.channelSelect |= 0x2;
            }
            localTask.reportArg = String.valueOf(j);
            if (j == 522)
            {
              localTask.totalTimeout = 300000;
              localTask.priority = 0;
            }
            if (j == 710)
            {
              localTask.totalTimeout = 15000;
              localTask.serverProcessCost = 0;
            }
            v.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(localTask.taskID), Integer.valueOf(paramq.BM()), Integer.valueOf(localTask.channelSelect), localTask.cgi, Boolean.valueOf(localTask.needAuthed) });
            if (-1 != i)
            {
              if (paramInt == 1) {
                localTask.retryCount = 0;
              }
              StnLogic.startTask(localTask);
              v.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=" + i);
              GMTrace.o(13707388125184L, 102128);
              return i;
            }
          }
          else
          {
            bool = false;
            continue;
          }
          v.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        catch (RemoteException localRemoteException)
        {
          v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bf.g(localRemoteException) });
        }
        finally {}
        continue;
        i = -1;
      }
      i += 1;
    }
  }
  
  final boolean a(int paramInt1, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2)
  {
    GMTrace.i(13707924996096L, 102132);
    synchronized (this.ieR)
    {
      paramInt1 = gW(paramInt1);
      if (-1 == paramInt1)
      {
        GMTrace.o(13707924996096L, 102132);
        return false;
      }
      try
      {
        v.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(this.ieR[paramInt1].ieX.Ca()), bf.bo(this.ieR[paramInt1].ieX.BX()) });
        this.ieR[paramInt1].ieV.Cm().B(this.ieR[paramInt1].ieX.vc());
        this.ieR[paramInt1].ieV.Cm().dj(this.ieR[paramInt1].ieX.uH());
        bool = this.ieR[paramInt1].ieV.Cm().a(this.ieR[paramInt1].ieV.getType(), this.ieR[paramInt1].ieX.vc(), this.ieR[paramInt1].ieX.BX(), this.ieR[paramInt1].ieX.BZ(), 0, this.ieR[paramInt1].ieX.Ca());
        if (!bool) {
          break label324;
        }
        paramByteArrayOutputStream.write(this.ieR[paramInt1].ieV.Cm().Cf());
      }
      catch (RemoteException paramByteArrayOutputStream)
      {
        for (;;)
        {
          paramArrayOfInt[0] = 1;
          com.tencent.mm.plugin.report.c.oRz.a(162L, paramArrayOfInt[0], 1L, false);
          v.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", new Object[] { bf.g(paramByteArrayOutputStream) });
          bool = false;
        }
      }
      catch (IOException paramByteArrayOutputStream)
      {
        for (;;)
        {
          paramArrayOfInt[0] = 2;
          com.tencent.mm.plugin.report.c.oRz.a(162L, paramArrayOfInt[0], 1L, false);
          v.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", new Object[] { bf.g(paramByteArrayOutputStream) });
          bool = false;
        }
      }
      catch (Exception paramByteArrayOutputStream)
      {
        for (;;)
        {
          paramArrayOfInt[0] = 3;
          com.tencent.mm.plugin.report.c.oRz.a(162L, paramArrayOfInt[0], 1L, false);
          v.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", new Object[] { bf.g(paramByteArrayOutputStream) });
          boolean bool = false;
        }
      }
      v.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(13707924996096L, 102132);
      return bool;
      label324:
      paramArrayOfInt[0] = 0;
      com.tencent.mm.plugin.report.c.oRz.a(162L, paramArrayOfInt[0], 1L, false);
      v.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
    }
  }
  
  final q bz(boolean paramBoolean)
  {
    GMTrace.i(13707119689728L, 102126);
    a[] arrayOfa = this.ieR;
    int i = 0;
    Object localObject4;
    label257:
    Object localObject2;
    for (Object localObject1 = null;; localObject2 = localObject4)
    {
      if (i < 100)
      {
        try
        {
          a locala = this.ieR[i];
          Object localObject3 = localObject1;
          if (locala == null) {
            break label257;
          }
          if (paramBoolean) {
            localObject3 = localObject1;
          }
          try
          {
            if ((this.ieR[i].ieV instanceof q.a)) {
              break label257;
            }
            if ((!paramBoolean) && (!(this.ieR[i].ieV instanceof q.a)))
            {
              localObject3 = localObject1;
              break label257;
            }
            if ((701 == this.ieR[i].ieV.getType()) || (702 == this.ieR[i].ieV.getType()))
            {
              v.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.ieR[i].ieV.getType());
              GMTrace.o(13707119689728L, 102126);
              return null;
            }
          }
          catch (RemoteException localRemoteException)
          {
            v.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bf.g(localRemoteException) });
            localObject4 = localObject1;
          }
          localObject4 = localq;
        }
        finally {}
        if (localq == null) {
          localObject4 = this.ieR[i].ieV;
        }
      }
      else
      {
        GMTrace.o(13707119689728L, 102126);
        return localq;
      }
      i += 1;
    }
  }
  
  /* Error */
  public final void d(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc2_w 376
    //   3: ldc_w 378
    //   6: invokestatic 24	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: ldc 49
    //   11: new 51	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 380
    //   18: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: iload_1
    //   22: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: ldc_w 382
    //   28: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_2
    //   32: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: ldc_w 384
    //   38: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_3
    //   42: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 386	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: invokestatic 389	com/tencent/mars/stn/StnLogic:clearTask	()V
    //   54: bipush 100
    //   56: anewarray 8	com/tencent/mm/network/y$a
    //   59: astore 5
    //   61: aload_0
    //   62: getfield 26	com/tencent/mm/network/y:ieR	[Lcom/tencent/mm/network/y$a;
    //   65: astore 6
    //   67: aload 6
    //   69: monitorenter
    //   70: iconst_0
    //   71: istore 4
    //   73: iload 4
    //   75: bipush 100
    //   77: if_icmpge +32 -> 109
    //   80: aload 5
    //   82: iload 4
    //   84: aload_0
    //   85: getfield 26	com/tencent/mm/network/y:ieR	[Lcom/tencent/mm/network/y$a;
    //   88: iload 4
    //   90: aaload
    //   91: aastore
    //   92: aload_0
    //   93: getfield 26	com/tencent/mm/network/y:ieR	[Lcom/tencent/mm/network/y$a;
    //   96: iload 4
    //   98: aconst_null
    //   99: aastore
    //   100: iload 4
    //   102: iconst_1
    //   103: iadd
    //   104: istore 4
    //   106: goto -33 -> 73
    //   109: aload 6
    //   111: monitorexit
    //   112: iconst_0
    //   113: istore 4
    //   115: iload 4
    //   117: bipush 100
    //   119: if_icmpge +135 -> 254
    //   122: aload 5
    //   124: iload 4
    //   126: aaload
    //   127: ifnull +88 -> 215
    //   130: ldc 49
    //   132: ldc_w 391
    //   135: iconst_3
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: iload 4
    //   143: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload 5
    //   151: iload 4
    //   153: aaload
    //   154: getfield 41	com/tencent/mm/network/y$a:ieV	Lcom/tencent/mm/network/q;
    //   157: invokeinterface 47 1 0
    //   162: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: dup
    //   167: iconst_2
    //   168: aload 5
    //   170: iload 4
    //   172: aaload
    //   173: getfield 41	com/tencent/mm/network/y$a:ieV	Lcom/tencent/mm/network/q;
    //   176: invokeinterface 287 1 0
    //   181: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokestatic 294	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload 5
    //   190: iload 4
    //   192: aaload
    //   193: getfield 204	com/tencent/mm/network/y$a:ieW	Lcom/tencent/mm/network/k;
    //   196: iload 4
    //   198: iload_1
    //   199: iload_2
    //   200: aload_3
    //   201: aload 5
    //   203: iload 4
    //   205: aaload
    //   206: getfield 41	com/tencent/mm/network/y$a:ieV	Lcom/tencent/mm/network/q;
    //   209: aconst_null
    //   210: invokeinterface 396 7 0
    //   215: iload 4
    //   217: iconst_1
    //   218: iadd
    //   219: istore 4
    //   221: goto -106 -> 115
    //   224: astore_3
    //   225: aload 6
    //   227: monitorexit
    //   228: aload_3
    //   229: athrow
    //   230: astore 6
    //   232: ldc 49
    //   234: ldc -71
    //   236: iconst_1
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload 6
    //   244: invokestatic 83	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   247: aastore
    //   248: invokestatic 93	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: goto -36 -> 215
    //   254: ldc2_w 376
    //   257: ldc_w 378
    //   260: invokestatic 29	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   263: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	y
    //   0	264	1	paramInt1	int
    //   0	264	2	paramInt2	int
    //   0	264	3	paramString	String
    //   71	149	4	i	int
    //   59	143	5	arrayOfa1	a[]
    //   65	161	6	arrayOfa2	a[]
    //   230	13	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   80	100	224	finally
    //   109	112	224	finally
    //   225	228	224	finally
    //   130	215	230	java/lang/Exception
  }
  
  protected final void finalize()
  {
    GMTrace.i(13706717036544L, 102123);
    reset();
    super.finalize();
    GMTrace.o(13706717036544L, 102123);
  }
  
  final int gV(int paramInt)
  {
    GMTrace.i(13707790778368L, 102131);
    synchronized (this.ieR)
    {
      paramInt = gW(paramInt);
      if (-1 == paramInt)
      {
        v.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
        GMTrace.o(13707790778368L, 102131);
        return 0;
      }
      try
      {
        paramInt = this.ieR[paramInt].ieV.Cn().Cq();
        GMTrace.o(13707790778368L, 102131);
        return paramInt;
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bf.g(localException) });
        GMTrace.o(13707790778368L, 102131);
        return 0;
      }
    }
  }
  
  final int gW(int paramInt)
  {
    GMTrace.i(13708193431552L, 102134);
    int i = 0;
    while ((i < 100) && ((this.ieR[i] == null) || (paramInt != this.ieR[i].taskId))) {
      i += 1;
    }
    if (100 <= i)
    {
      GMTrace.o(13708193431552L, 102134);
      return -1;
    }
    GMTrace.o(13708193431552L, 102134);
    return i;
  }
  
  public final void reset()
  {
    GMTrace.i(13707522342912L, 102129);
    v.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
    StnLogic.reset();
    a[] arrayOfa = this.ieR;
    int i = 0;
    while (i < 100) {
      try
      {
        a locala = this.ieR[i];
        if (locala != null) {}
        try
        {
          v.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ieR[i].ieV.getType()), Integer.valueOf(this.ieR[i].ieV.BM()) });
          this.ieR[i] = null;
          i += 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bf.g(localRemoteException) });
          }
        }
      }
      finally {}
    }
    GMTrace.o(13707522342912L, 102129);
  }
  
  private static final class a
  {
    q ieV;
    k ieW;
    c ieX;
    long startTime;
    int taskId;
    
    public a()
    {
      GMTrace.i(13703495811072L, 102099);
      GMTrace.o(13703495811072L, 102099);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */