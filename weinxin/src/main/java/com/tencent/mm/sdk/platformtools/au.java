package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.gmtrace.GMTrace;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class au
{
  static String[] utA;
  static String[] utB;
  static String[] utC;
  static String[] utD;
  
  static
  {
    GMTrace.i(13924686626816L, 103747);
    utA = new String[] { "sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs" };
    utB = new String[] { "vfat", "exfat", "fuse", "sdcardfs" };
    utC = new String[] { "/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/" };
    utD = new String[] { "/dev/block/vold" };
    GMTrace.o(13924686626816L, 103747);
  }
  
  public static String PD(String paramString)
  {
    GMTrace.i(13924552409088L, 103746);
    Object localObject2 = "";
    if (bf.mA(paramString))
    {
      GMTrace.o(13924552409088L, 103746);
      return "";
    }
    Object localObject3 = bJp();
    Object localObject4 = ((ArrayList)localObject3).iterator();
    do
    {
      localObject1 = localObject2;
      if (!((Iterator)localObject4).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject4).next();
    } while (!paramString.equals(((a)localObject1).utF));
    Object localObject1 = ((a)localObject1).utG;
    v.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", new Object[] { paramString, localObject1 });
    localObject2 = localObject1;
    if (bf.mA((String)localObject1))
    {
      localObject2 = localObject1;
      if (paramString.contains("emulated"))
      {
        localObject4 = paramString.substring(paramString.lastIndexOf('/') + 1);
        int i = bf.getInt((String)localObject4, -1);
        v.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", new Object[] { localObject4, Integer.valueOf(i) });
        localObject2 = localObject1;
        if (i != -1)
        {
          localObject4 = paramString.substring(0, paramString.length() - ((String)localObject4).length() - 1);
          localObject2 = localObject1;
          if (!bf.mA((String)localObject4))
          {
            localObject3 = ((ArrayList)localObject3).iterator();
            do
            {
              localObject2 = localObject1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject2 = (a)((Iterator)localObject3).next();
            } while (!((String)localObject4).equals(((a)localObject2).utF));
            localObject2 = ((a)localObject2).utG;
            v.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", new Object[] { paramString, localObject4, localObject2 });
          }
        }
      }
    }
    GMTrace.o(13924552409088L, 103746);
    return (String)localObject2;
  }
  
  private static void a(a parama)
  {
    GMTrace.i(13923478667264L, 103738);
    try
    {
      StatFs localStatFs = new StatFs(parama.utF);
      parama.utK = localStatFs.getBlockSize();
      parama.utJ = localStatFs.getAvailableBlocks();
      parama.utH = localStatFs.getBlockCount();
      parama.utI = localStatFs.getFreeBlocks();
      GMTrace.o(13923478667264L, 103738);
      return;
    }
    catch (IllegalArgumentException parama)
    {
      v.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", new Object[] { parama });
      GMTrace.o(13923478667264L, 103738);
    }
  }
  
  /* Error */
  private static boolean b(a parama)
  {
    // Byte code:
    //   0: ldc2_w 226
    //   3: ldc -28
    //   5: invokestatic 23	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: new 230	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: getfield 128	com/tencent/mm/sdk/platformtools/au$a:utF	Ljava/lang/String;
    //   16: ldc -24
    //   18: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore 4
    //   23: aload 4
    //   25: invokevirtual 238	java/io/File:createNewFile	()Z
    //   28: pop
    //   29: new 240	java/io/FileOutputStream
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 243	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   38: astore_3
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: ldc -11
    //   44: invokevirtual 249	java/lang/String:getBytes	()[B
    //   47: invokevirtual 253	java/io/FileOutputStream:write	([B)V
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: invokevirtual 256	java/io/FileOutputStream:flush	()V
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   62: aload_3
    //   63: astore_2
    //   64: aload 4
    //   66: invokevirtual 262	java/io/File:delete	()Z
    //   69: istore_1
    //   70: aload_3
    //   71: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   74: aload_0
    //   75: iload_1
    //   76: putfield 266	com/tencent/mm/sdk/platformtools/au$a:aQD	Z
    //   79: ldc2_w 226
    //   82: ldc -28
    //   84: invokestatic 90	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   87: iload_1
    //   88: ireturn
    //   89: astore_2
    //   90: ldc -119
    //   92: aload_2
    //   93: ldc 98
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 270	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: goto -28 -> 74
    //   105: astore 4
    //   107: aconst_null
    //   108: astore_3
    //   109: aload_3
    //   110: astore_2
    //   111: ldc -119
    //   113: new 272	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 274
    //   120: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload 4
    //   125: invokevirtual 279	java/io/IOException:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 285
    //   134: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: getfield 128	com/tencent/mm/sdk/platformtools/au$a:utF	Ljava/lang/String;
    //   141: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 290	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_3
    //   151: ifnull +68 -> 219
    //   154: aload_3
    //   155: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   158: iconst_0
    //   159: istore_1
    //   160: goto -86 -> 74
    //   163: astore_2
    //   164: ldc -119
    //   166: aload_2
    //   167: ldc 98
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 270	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_0
    //   177: istore_1
    //   178: goto -104 -> 74
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_2
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   192: aload_0
    //   193: athrow
    //   194: astore_2
    //   195: ldc -119
    //   197: aload_2
    //   198: ldc 98
    //   200: iconst_0
    //   201: anewarray 4	java/lang/Object
    //   204: invokestatic 270	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: goto -15 -> 192
    //   210: astore_0
    //   211: goto -27 -> 184
    //   214: astore 4
    //   216: goto -107 -> 109
    //   219: iconst_0
    //   220: istore_1
    //   221: goto -147 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	parama	a
    //   69	152	1	bool	boolean
    //   40	24	2	localFileOutputStream1	java.io.FileOutputStream
    //   89	4	2	localIOException1	java.io.IOException
    //   110	1	2	localFileOutputStream2	java.io.FileOutputStream
    //   163	4	2	localIOException2	java.io.IOException
    //   183	6	2	localObject	Object
    //   194	4	2	localIOException3	java.io.IOException
    //   38	117	3	localFileOutputStream3	java.io.FileOutputStream
    //   21	44	4	localFile	File
    //   105	19	4	localIOException4	java.io.IOException
    //   214	1	4	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   70	74	89	java/io/IOException
    //   23	39	105	java/io/IOException
    //   154	158	163	java/io/IOException
    //   23	39	181	finally
    //   188	192	194	java/io/IOException
    //   41	50	210	finally
    //   52	56	210	finally
    //   58	62	210	finally
    //   64	70	210	finally
    //   111	150	210	finally
    //   41	50	214	java/io/IOException
    //   52	56	214	java/io/IOException
    //   58	62	214	java/io/IOException
    //   64	70	214	java/io/IOException
  }
  
  /* Error */
  private static ArrayList<a> bJp()
  {
    // Byte code:
    //   0: ldc2_w 293
    //   3: ldc_w 295
    //   6: invokestatic 23	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 110	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 297	java/util/ArrayList:<init>	()V
    //   16: astore_3
    //   17: new 299	java/io/BufferedReader
    //   20: dup
    //   21: new 301	java/io/FileReader
    //   24: dup
    //   25: ldc_w 303
    //   28: invokespecial 304	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 307	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokevirtual 310	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +160 -> 205
    //   48: aload_1
    //   49: astore_0
    //   50: aload 4
    //   52: ldc_w 312
    //   55: invokevirtual 316	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +11 -> 71
    //   63: aload_1
    //   64: astore_0
    //   65: aload_2
    //   66: arraylength
    //   67: iconst_3
    //   68: if_icmpge +69 -> 137
    //   71: aload_1
    //   72: astore_0
    //   73: ldc -119
    //   75: new 272	java/lang/StringBuilder
    //   78: dup
    //   79: ldc_w 318
    //   82: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload 4
    //   87: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 290	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: goto -61 -> 35
    //   99: astore_2
    //   100: aload_1
    //   101: astore_0
    //   102: ldc -119
    //   104: ldc_w 320
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_2
    //   114: aastore
    //   115: invokestatic 221	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 321	java/io/BufferedReader:close	()V
    //   126: ldc2_w 293
    //   129: ldc_w 295
    //   132: invokestatic 90	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   135: aload_3
    //   136: areturn
    //   137: aload_1
    //   138: astore_0
    //   139: new 6	com/tencent/mm/sdk/platformtools/au$a
    //   142: dup
    //   143: invokespecial 322	com/tencent/mm/sdk/platformtools/au$a:<init>	()V
    //   146: astore 4
    //   148: aload_1
    //   149: astore_0
    //   150: aload 4
    //   152: aload_2
    //   153: iconst_0
    //   154: aaload
    //   155: putfield 325	com/tencent/mm/sdk/platformtools/au$a:utE	Ljava/lang/String;
    //   158: aload_1
    //   159: astore_0
    //   160: aload 4
    //   162: aload_2
    //   163: iconst_1
    //   164: aaload
    //   165: putfield 128	com/tencent/mm/sdk/platformtools/au$a:utF	Ljava/lang/String;
    //   168: aload_1
    //   169: astore_0
    //   170: aload 4
    //   172: aload_2
    //   173: iconst_2
    //   174: aaload
    //   175: putfield 135	com/tencent/mm/sdk/platformtools/au$a:utG	Ljava/lang/String;
    //   178: aload_1
    //   179: astore_0
    //   180: aload_3
    //   181: aload 4
    //   183: invokevirtual 328	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   186: pop
    //   187: goto -152 -> 35
    //   190: astore_2
    //   191: aload_0
    //   192: astore_1
    //   193: aload_2
    //   194: astore_0
    //   195: aload_1
    //   196: ifnull +7 -> 203
    //   199: aload_1
    //   200: invokevirtual 321	java/io/BufferedReader:close	()V
    //   203: aload_0
    //   204: athrow
    //   205: aload_1
    //   206: invokevirtual 321	java/io/BufferedReader:close	()V
    //   209: goto -83 -> 126
    //   212: astore_0
    //   213: ldc -119
    //   215: aload_0
    //   216: ldc 98
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 270	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: goto -99 -> 126
    //   228: astore_0
    //   229: ldc -119
    //   231: aload_0
    //   232: ldc 98
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 270	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: goto -115 -> 126
    //   244: astore_1
    //   245: ldc -119
    //   247: aload_1
    //   248: ldc 98
    //   250: iconst_0
    //   251: anewarray 4	java/lang/Object
    //   254: invokestatic 270	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: goto -54 -> 203
    //   260: astore_0
    //   261: aconst_null
    //   262: astore_1
    //   263: goto -68 -> 195
    //   266: astore_2
    //   267: aconst_null
    //   268: astore_1
    //   269: goto -169 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	168	0	localObject1	Object
    //   212	4	0	localIOException1	java.io.IOException
    //   228	4	0	localIOException2	java.io.IOException
    //   260	1	0	localObject2	Object
    //   34	172	1	localObject3	Object
    //   244	4	1	localIOException3	java.io.IOException
    //   262	7	1	localObject4	Object
    //   58	8	2	arrayOfString	String[]
    //   99	74	2	localException1	Exception
    //   190	4	2	localObject5	Object
    //   266	1	2	localException2	Exception
    //   16	165	3	localArrayList	ArrayList
    //   41	141	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   37	43	99	java/lang/Exception
    //   50	59	99	java/lang/Exception
    //   65	71	99	java/lang/Exception
    //   73	96	99	java/lang/Exception
    //   139	148	99	java/lang/Exception
    //   150	158	99	java/lang/Exception
    //   160	168	99	java/lang/Exception
    //   170	178	99	java/lang/Exception
    //   180	187	99	java/lang/Exception
    //   37	43	190	finally
    //   50	59	190	finally
    //   65	71	190	finally
    //   73	96	190	finally
    //   102	118	190	finally
    //   139	148	190	finally
    //   150	158	190	finally
    //   160	168	190	finally
    //   170	178	190	finally
    //   180	187	190	finally
    //   205	209	212	java/io/IOException
    //   122	126	228	java/io/IOException
    //   199	203	244	java/io/IOException
    //   17	35	260	finally
    //   17	35	266	java/lang/Exception
  }
  
  private static a bJq()
  {
    GMTrace.i(13923747102720L, 103740);
    Object localObject1 = bJp();
    String str = Environment.getDataDirectory().getAbsolutePath();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject2).next();
    } while (!((a)localObject1).utF.equals(str));
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new a();
        ((a)localObject2).utF = str;
        ((a)localObject2).utE = "Unknown";
        ((a)localObject2).utG = "Unknown";
      }
      a((a)localObject2);
      GMTrace.o(13923747102720L, 103740);
      return (a)localObject2;
      localObject1 = null;
    }
  }
  
  private static a bJr()
  {
    GMTrace.i(13923881320448L, 103741);
    Object localObject1 = bJp();
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject2).next();
    } while (!((a)localObject1).utF.equals(str));
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new a();
        ((a)localObject2).utF = str;
        ((a)localObject2).utE = "Unknown";
        ((a)localObject2).utG = "Unknown";
      }
      a((a)localObject2);
      GMTrace.o(13923881320448L, 103741);
      return (a)localObject2;
      localObject1 = null;
    }
  }
  
  public static ArrayList<a> bJs()
  {
    GMTrace.i(13924015538176L, 103742);
    ArrayList localArrayList = bJp();
    int i = localArrayList.size();
    Object localObject1 = Arrays.asList(utB);
    Object localObject2 = Arrays.asList(utC);
    Object localObject3 = Arrays.asList(utD);
    i -= 1;
    if (i >= 0)
    {
      a locala = (a)localArrayList.get(i);
      if (!((List)localObject1).contains(locala.utG))
      {
        localArrayList.remove(i);
        v.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + locala.utG);
      }
      for (;;)
      {
        i -= 1;
        break;
        Iterator localIterator = ((List)localObject2).iterator();
        String str;
        for (boolean bool = false; localIterator.hasNext(); bool = locala.utF.startsWith(str) | bool) {
          str = (String)localIterator.next();
        }
        if (bool)
        {
          localArrayList.remove(i);
          v.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + locala.utF);
        }
        else if ((locala.utG.equals("fuse")) || (locala.utG.equals("sdcardfs")))
        {
          if (locala.utE.startsWith("/data/"))
          {
            localArrayList.remove(i);
            v.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + locala.utE);
          }
        }
        else if ((!locala.utG.equals("fuse")) && (!locala.utG.equals("sdcardfs")))
        {
          localIterator = ((List)localObject3).iterator();
          for (bool = false; localIterator.hasNext(); bool = locala.utE.startsWith(str) | bool) {
            str = (String)localIterator.next();
          }
          if (!bool)
          {
            localArrayList.remove(i);
            v.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + locala.utE);
          }
        }
      }
    }
    localObject1 = Environment.getExternalStorageDirectory().getPath();
    i = localArrayList.size() - 1;
    if (i >= 0)
    {
      localObject2 = (a)localArrayList.get(i);
      if (((a)localObject2).utF.equals(localObject1))
      {
        localArrayList.remove(i);
        localArrayList.add(0, localObject2);
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = new a();
        ((a)localObject2).utF = ((String)localObject1);
        ((a)localObject2).utG = "unknown";
        ((a)localObject2).utE = "unknown";
        localArrayList.add(0, localObject2);
      }
      i = localArrayList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          localObject1 = (a)localArrayList.get(i);
          localObject2 = new File(((a)localObject1).utF);
          if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory()))
          {
            v.d("MicroMsg.SdcardUtil", "Directory verify failed: " + localObject1);
            localArrayList.remove(i);
          }
          i -= 1;
          continue;
          i -= 1;
          break;
        }
      }
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        localObject1 = (a)localArrayList.get(i);
        if (!b((a)localObject1))
        {
          v.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: " + localObject1);
          localArrayList.remove(i);
        }
        i -= 1;
      }
      localObject3 = new ArrayList();
      if (!localArrayList.isEmpty())
      {
        localObject1 = (a)localArrayList.remove(0);
        i = localArrayList.size() - 1;
        label678:
        if (i >= 0)
        {
          localObject2 = (a)localArrayList.get(i);
          if (!((a)localObject1).utE.equals(((a)localObject2).utE)) {
            break label933;
          }
          localArrayList.remove(i);
          v.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + ((a)localObject1).utE);
          if ((((a)localObject1).aQD) || (!((a)localObject2).aQD)) {
            break label933;
          }
          v.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
          localObject1 = localObject2;
        }
      }
      label933:
      for (;;)
      {
        i -= 1;
        break label678;
        ((ArrayList)localObject3).add(localObject1);
        break;
        localObject1 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a((a)((Iterator)localObject1).next());
        }
        localArrayList.clear();
        while (!((ArrayList)localObject3).isEmpty())
        {
          localObject1 = (a)((ArrayList)localObject3).remove(0);
          localArrayList.add(localObject1);
          i = ((ArrayList)localObject3).size() - 1;
          while (i >= 0)
          {
            localObject2 = (a)((ArrayList)localObject3).get(i);
            if (((a)localObject1).equals(localObject2))
            {
              v.d("MicroMsg.SdcardUtil", "Duplicate:" + ((a)localObject1).toString() + "---" + ((a)localObject2).toString());
              ((ArrayList)localObject3).remove(i);
            }
            i -= 1;
          }
        }
        GMTrace.o(13924015538176L, 103742);
        return localArrayList;
      }
    }
  }
  
  public static long bJt()
  {
    GMTrace.i(13924149755904L, 103743);
    a locala = bJq();
    long l1 = locala.utJ;
    long l2 = locala.utK;
    GMTrace.o(13924149755904L, 103743);
    return l2 * l1;
  }
  
  public static long bJu()
  {
    GMTrace.i(13924283973632L, 103744);
    a locala = bJr();
    long l1 = locala.utJ;
    long l2 = locala.utK;
    GMTrace.o(13924283973632L, 103744);
    return l2 * l1;
  }
  
  public static boolean bJv()
  {
    GMTrace.i(13924418191360L, 103745);
    long l = System.currentTimeMillis();
    Object localObject5 = bJp();
    String str2 = Environment.getDataDirectory().getAbsolutePath();
    String str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    Object localObject1 = null;
    Iterator localIterator = ((ArrayList)localObject5).iterator();
    Object localObject3 = null;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      localObject4 = localObject3;
      if (!localIterator.hasNext()) {
        break label141;
      }
      localObject2 = (a)localIterator.next();
      if ((localObject3 == null) && (((a)localObject2).utF.equals(str2)))
      {
        if (localObject1 != null) {
          break label498;
        }
        localObject3 = localObject2;
      }
      else
      {
        if ((localObject1 != null) || (!((a)localObject2).utF.equals(str1))) {
          break label491;
        }
        if (localObject3 != null) {
          break;
        }
        localObject1 = localObject2;
      }
    }
    Object localObject4 = localObject3;
    for (;;)
    {
      label141:
      if ((localObject4 != null) && (localObject2 == null) && (!bf.mA(str1)) && (str1.contains("emulated")))
      {
        localObject1 = str1.substring(str1.lastIndexOf('/') + 1);
        int i = bf.getInt((String)localObject1, -1);
        v.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", new Object[] { localObject1, Integer.valueOf(i) });
        if (i != -1)
        {
          localObject3 = str1.substring(0, str1.length() - ((String)localObject1).length() - 1);
          if (!bf.mA((String)localObject3))
          {
            localObject5 = ((ArrayList)localObject5).iterator();
            do
            {
              if (!((Iterator)localObject5).hasNext()) {
                break;
              }
              localObject1 = (a)((Iterator)localObject5).next();
            } while (!((a)localObject1).utF.equals(localObject3));
          }
        }
      }
      for (;;)
      {
        if ((localObject4 != null) && (localObject1 != null))
        {
          a((a)localObject4);
          a((a)localObject1);
          v.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", new Object[] { localObject4, localObject1 });
          if (((!((a)localObject1).utG.equals("fuse")) && (!((a)localObject1).utG.equals("sdcardfs")) && (!((a)localObject1).utG.equals("esdfs"))) || (((a)localObject4).utH < ((a)localObject1).utH) || (((a)localObject1).utH <= 0L) || (((a)localObject4).utK < ((a)localObject1).utK) || (((a)localObject1).utK <= 0L) || (((a)localObject4).utJ < ((a)localObject1).utJ)) {}
        }
        for (boolean bool = true;; bool = false)
        {
          v.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          GMTrace.o(13924418191360L, 103745);
          return bool;
        }
        localObject1 = localObject2;
      }
      label491:
      localObject2 = localObject1;
      break;
      label498:
      localObject4 = localObject2;
      localObject2 = localObject1;
    }
  }
  
  public static final class a
  {
    public boolean aQD;
    public String utE;
    public String utF;
    public String utG;
    public long utH;
    public long utI;
    public long utJ;
    public long utK;
    a utL;
    
    public a()
    {
      GMTrace.i(13881200082944L, 103423);
      GMTrace.o(13881200082944L, 103423);
    }
    
    public final boolean equals(Object paramObject)
    {
      GMTrace.i(13881468518400L, 103425);
      paramObject = (a)paramObject;
      if (this.utK != ((a)paramObject).utK)
      {
        GMTrace.o(13881468518400L, 103425);
        return false;
      }
      long l1 = this.utH - ((a)paramObject).utH;
      long l2 = this.utI - ((a)paramObject).utI;
      long l3 = this.utJ - ((a)paramObject).utJ;
      if ((Math.abs(l1 - l2) <= 4L) && (Math.abs(l1 - l3) <= 4L) && (Math.abs(l2 - l3) <= 4L))
      {
        GMTrace.o(13881468518400L, 103425);
        return true;
      }
      GMTrace.o(13881468518400L, 103425);
      return false;
    }
    
    public final String toString()
    {
      GMTrace.i(13881334300672L, 103424);
      Object localObject = new StringBuilder("{DevName=").append(this.utE).append(", MountDir=").append(this.utF).append(", FileSystem=").append(this.utG).append(", TotalBlocks=").append(this.utH).append(", FreeBlocks=").append(this.utI).append(", AvailableBlocks=").append(this.utJ).append(", BlockSize=").append(this.utK).append(", Shared=");
      if (this.utL != null) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = bool + "}";
        GMTrace.o(13881334300672L, 103424);
        return (String)localObject;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */