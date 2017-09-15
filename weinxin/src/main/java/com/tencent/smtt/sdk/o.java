package com.tencent.smtt.sdk;

import android.text.TextUtils;
import java.util.Map;

final class o
{
  public boolean wSS = false;
  public boolean wST = false;
  private Map<String, String> wSU = null;
  
  public final void a(String paramString, byte paramByte)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        str = "";
        if (paramByte == 1)
        {
          str = "_begin";
          this.wSU.put(paramString + str, String.valueOf(System.currentTimeMillis()));
          continue;
        }
        if (paramByte != 2) {
          continue;
        }
      }
      finally {}
      String str = "_end";
    }
  }
  
  /* Error */
  public final boolean aK(int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 75	com/tencent/smtt/sdk/ac:ceR	()Lcom/tencent/smtt/sdk/ac;
    //   8: astore 6
    //   10: aload 6
    //   12: invokevirtual 79	com/tencent/smtt/sdk/ac:ceS	()Z
    //   15: istore 5
    //   17: iload 4
    //   19: istore_3
    //   20: iload 5
    //   22: ifeq +10 -> 32
    //   25: aload_2
    //   26: ifnonnull +10 -> 36
    //   29: iload 4
    //   31: istore_3
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_3
    //   35: ireturn
    //   36: iload 4
    //   38: istore_3
    //   39: aload_2
    //   40: ldc 81
    //   42: invokevirtual 85	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   45: ifeq -13 -> 32
    //   48: aload_0
    //   49: getfield 18	com/tencent/smtt/sdk/o:wST	Z
    //   52: ifeq +10 -> 62
    //   55: aload_0
    //   56: getfield 16	com/tencent/smtt/sdk/o:wSS	Z
    //   59: ifne +20 -> 79
    //   62: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   65: ldc2_w 86
    //   68: lrem
    //   69: lconst_0
    //   70: lcmp
    //   71: ifeq +8 -> 79
    //   74: iconst_1
    //   75: istore_3
    //   76: goto -44 -> 32
    //   79: aload_0
    //   80: iconst_1
    //   81: putfield 18	com/tencent/smtt/sdk/o:wST	Z
    //   84: aload_0
    //   85: iconst_1
    //   86: putfield 16	com/tencent/smtt/sdk/o:wSS	Z
    //   89: aload_0
    //   90: getfield 20	com/tencent/smtt/sdk/o:wSU	Ljava/util/Map;
    //   93: ldc 89
    //   95: aload_0
    //   96: getfield 18	com/tencent/smtt/sdk/o:wST	Z
    //   99: invokestatic 92	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   102: invokeinterface 65 3 0
    //   107: pop
    //   108: aload_0
    //   109: getfield 20	com/tencent/smtt/sdk/o:wSU	Ljava/util/Map;
    //   112: ldc 94
    //   114: aload_0
    //   115: getfield 16	com/tencent/smtt/sdk/o:wSS	Z
    //   118: invokestatic 92	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   121: invokeinterface 65 3 0
    //   126: pop
    //   127: aload_0
    //   128: getfield 20	com/tencent/smtt/sdk/o:wSU	Ljava/util/Map;
    //   131: ldc 96
    //   133: iload_1
    //   134: invokestatic 101	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   137: invokeinterface 65 3 0
    //   142: pop
    //   143: aload_0
    //   144: getfield 20	com/tencent/smtt/sdk/o:wSU	Ljava/util/Map;
    //   147: ldc 103
    //   149: aload_2
    //   150: invokeinterface 65 3 0
    //   155: pop
    //   156: getstatic 108	com/tencent/smtt/sdk/QbSdk:wRu	Ljava/util/Map;
    //   159: ifnull +51 -> 210
    //   162: getstatic 108	com/tencent/smtt/sdk/QbSdk:wRu	Ljava/util/Map;
    //   165: ldc 110
    //   167: invokeinterface 114 2 0
    //   172: ifeq +38 -> 210
    //   175: aload_0
    //   176: getfield 20	com/tencent/smtt/sdk/o:wSU	Ljava/util/Map;
    //   179: ldc 110
    //   181: new 38	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   188: getstatic 108	com/tencent/smtt/sdk/QbSdk:wRu	Ljava/util/Map;
    //   191: ldc 110
    //   193: invokeinterface 118 2 0
    //   198: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokeinterface 65 3 0
    //   209: pop
    //   210: aload 6
    //   212: invokevirtual 125	com/tencent/smtt/sdk/ac:ceT	()Lcom/tencent/smtt/sdk/ad;
    //   215: getfield 131	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   218: astore_2
    //   219: getstatic 135	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   222: astore 6
    //   224: aload_0
    //   225: getfield 20	com/tencent/smtt/sdk/o:wSU	Ljava/util/Map;
    //   228: astore 7
    //   230: aload_2
    //   231: ldc -119
    //   233: ldc -117
    //   235: iconst_2
    //   236: anewarray 141	java/lang/Class
    //   239: dup
    //   240: iconst_0
    //   241: aload 6
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: ldc 61
    //   248: aastore
    //   249: iconst_2
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: iload_1
    //   256: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: aastore
    //   260: dup
    //   261: iconst_1
    //   262: aload 7
    //   264: aastore
    //   265: invokevirtual 150	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   268: pop
    //   269: iconst_1
    //   270: istore_3
    //   271: goto -239 -> 32
    //   274: astore_2
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_2
    //   278: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	o
    //   0	279	1	paramInt	int
    //   0	279	2	paramString	String
    //   19	252	3	bool1	boolean
    //   1	36	4	bool2	boolean
    //   15	6	5	bool3	boolean
    //   8	234	6	localObject	Object
    //   228	35	7	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   5	17	274	finally
    //   39	62	274	finally
    //   62	74	274	finally
    //   79	210	274	finally
    //   210	269	274	finally
  }
  
  /* Error */
  public final void al(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 20	com/tencent/smtt/sdk/o:wSU	Ljava/util/Map;
    //   20: aload_1
    //   21: lload_2
    //   22: invokestatic 59	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   25: invokeinterface 65 3 0
    //   30: pop
    //   31: goto -18 -> 13
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	o
    //   0	39	1	paramString	String
    //   0	39	2	paramLong	long
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	34	finally
    //   16	31	34	finally
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */