package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import junit.framework.Assert;

public final class bo
{
  private a hnO;
  private long hnP;
  private long hnQ;
  private String hnR;
  private int hnS;
  
  public bo(a parama)
  {
    GMTrace.i(13473580843008L, 100386);
    this.hnO = null;
    this.hnP = 0L;
    this.hnQ = 0L;
    this.hnR = "";
    this.hnS = 1;
    Assert.assertTrue(true);
    this.hnO = parama;
    zT();
    GMTrace.o(13473580843008L, 100386);
  }
  
  private void zT()
  {
    GMTrace.i(13473715060736L, 100387);
    this.hnS = 1;
    this.hnP = 0L;
    this.hnQ = 0L;
    this.hnR = "";
    GMTrace.o(13473715060736L, 100387);
  }
  
  private void zW()
  {
    try
    {
      GMTrace.i(13474251931648L, 100391);
      if ((this.hnS != 1) && (this.hnP + this.hnQ < bf.NA())) {
        zU();
      }
      GMTrace.o(13474251931648L, 100391);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean O(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc2_w 74
    //   8: ldc 76
    //   10: invokestatic 30	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   13: invokestatic 68	com/tencent/mm/sdk/platformtools/bf:NA	()J
    //   16: lstore 5
    //   18: aload_0
    //   19: invokestatic 80	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
    //   22: invokevirtual 86	com/tencent/mm/sdk/platformtools/ag:toString	()Ljava/lang/String;
    //   25: putfield 40	com/tencent/mm/u/bo:hnR	Ljava/lang/String;
    //   28: aload_0
    //   29: getfield 42	com/tencent/mm/u/bo:hnS	I
    //   32: iconst_1
    //   33: if_icmpne +73 -> 106
    //   36: aload_0
    //   37: lload 5
    //   39: putfield 36	com/tencent/mm/u/bo:hnQ	J
    //   42: aload_0
    //   43: lload_1
    //   44: putfield 34	com/tencent/mm/u/bo:hnP	J
    //   47: ldc 88
    //   49: ldc 90
    //   51: iconst_2
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: lload_1
    //   58: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_0
    //   65: getfield 40	com/tencent/mm/u/bo:hnR	Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 101	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: iconst_2
    //   74: putfield 42	com/tencent/mm/u/bo:hnS	I
    //   77: aload_0
    //   78: getfield 32	com/tencent/mm/u/bo:hnO	Lcom/tencent/mm/u/bo$a;
    //   81: invokeinterface 105 1 0
    //   86: ifeq +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 108	com/tencent/mm/u/bo:zV	()V
    //   93: ldc2_w 74
    //   96: ldc 76
    //   98: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   101: aload_0
    //   102: monitorexit
    //   103: iload 7
    //   105: ireturn
    //   106: aload_0
    //   107: getfield 36	com/tencent/mm/u/bo:hnQ	J
    //   110: aload_0
    //   111: getfield 34	com/tencent/mm/u/bo:hnP	J
    //   114: ladd
    //   115: lstore_3
    //   116: lload 5
    //   118: lload_1
    //   119: ladd
    //   120: lstore 5
    //   122: lload 5
    //   124: lload_3
    //   125: lcmp
    //   126: ifle +16 -> 142
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 34	com/tencent/mm/u/bo:hnP	J
    //   134: lload 5
    //   136: lload_3
    //   137: lsub
    //   138: ladd
    //   139: putfield 34	com/tencent/mm/u/bo:hnP	J
    //   142: ldc 88
    //   144: ldc 110
    //   146: iconst_5
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_0
    //   153: getfield 42	com/tencent/mm/u/bo:hnS	I
    //   156: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: lload_1
    //   163: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: lload 5
    //   171: lload_3
    //   172: lsub
    //   173: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: aastore
    //   177: dup
    //   178: iconst_3
    //   179: aload_0
    //   180: getfield 34	com/tencent/mm/u/bo:hnP	J
    //   183: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: dup
    //   188: iconst_4
    //   189: aload_0
    //   190: getfield 40	com/tencent/mm/u/bo:hnR	Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 101	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc2_w 74
    //   200: ldc 76
    //   202: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   205: iconst_0
    //   206: istore 7
    //   208: goto -107 -> 101
    //   211: astore 8
    //   213: aload_0
    //   214: monitorexit
    //   215: aload 8
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	bo
    //   0	218	1	paramLong	long
    //   115	57	3	l1	long
    //   16	154	5	l2	long
    //   1	206	7	bool	boolean
    //   211	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	93	211	finally
    //   93	101	211	finally
    //   106	116	211	finally
    //   129	142	211	finally
    //   142	205	211	finally
  }
  
  /* Error */
  public final void zU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 116
    //   5: ldc 118
    //   7: invokestatic 30	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   10: ldc 88
    //   12: ldc 120
    //   14: iconst_2
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: getfield 42	com/tencent/mm/u/bo:hnS	I
    //   24: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: invokestatic 80	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
    //   33: aastore
    //   34: invokestatic 123	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: aload_0
    //   38: getfield 42	com/tencent/mm/u/bo:hnS	I
    //   41: iconst_1
    //   42: if_icmpne +31 -> 73
    //   45: ldc 88
    //   47: ldc 125
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: invokestatic 80	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
    //   58: aastore
    //   59: invokestatic 123	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: ldc2_w 116
    //   65: ldc 118
    //   67: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: aload_0
    //   74: invokespecial 51	com/tencent/mm/u/bo:zT	()V
    //   77: new 127	com/tencent/mm/e/a/qg
    //   80: dup
    //   81: invokespecial 128	com/tencent/mm/e/a/qg:<init>	()V
    //   84: astore_1
    //   85: aload_1
    //   86: getfield 132	com/tencent/mm/e/a/qg:fXc	Lcom/tencent/mm/e/a/qg$a;
    //   89: iconst_1
    //   90: putfield 137	com/tencent/mm/e/a/qg$a:status	I
    //   93: getstatic 143	com/tencent/mm/sdk/b/a:uql	Lcom/tencent/mm/sdk/b/a;
    //   96: aload_1
    //   97: invokevirtual 147	com/tencent/mm/sdk/b/a:m	(Lcom/tencent/mm/sdk/b/b;)Z
    //   100: pop
    //   101: ldc2_w 116
    //   104: ldc 118
    //   106: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   109: goto -39 -> 70
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	bo
    //   84	13	1	localqg	com.tencent.mm.e.a.qg
    //   112	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	70	112	finally
    //   73	109	112	finally
  }
  
  /* Error */
  public final void zV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 148
    //   5: ldc -106
    //   7: invokestatic 30	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   10: aload_0
    //   11: getfield 42	com/tencent/mm/u/bo:hnS	I
    //   14: iconst_2
    //   15: if_icmpeq +41 -> 56
    //   18: ldc 88
    //   20: ldc -104
    //   22: iconst_2
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: getfield 42	com/tencent/mm/u/bo:hnS	I
    //   32: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: invokestatic 80	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
    //   41: aastore
    //   42: invokestatic 155	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: ldc2_w 148
    //   48: ldc -106
    //   50: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: ldc 88
    //   58: ldc -99
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_0
    //   67: getfield 36	com/tencent/mm/u/bo:hnQ	J
    //   70: invokestatic 161	com/tencent/mm/sdk/platformtools/bf:aA	(J)J
    //   73: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: invokestatic 80	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
    //   82: aastore
    //   83: invokestatic 123	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_0
    //   87: iconst_3
    //   88: putfield 42	com/tencent/mm/u/bo:hnS	I
    //   91: new 127	com/tencent/mm/e/a/qg
    //   94: dup
    //   95: invokespecial 128	com/tencent/mm/e/a/qg:<init>	()V
    //   98: astore_1
    //   99: aload_1
    //   100: getfield 132	com/tencent/mm/e/a/qg:fXc	Lcom/tencent/mm/e/a/qg$a;
    //   103: iconst_3
    //   104: putfield 137	com/tencent/mm/e/a/qg$a:status	I
    //   107: getstatic 143	com/tencent/mm/sdk/b/a:uql	Lcom/tencent/mm/sdk/b/a;
    //   110: aload_1
    //   111: invokevirtual 147	com/tencent/mm/sdk/b/a:m	(Lcom/tencent/mm/sdk/b/b;)Z
    //   114: pop
    //   115: ldc2_w 148
    //   118: ldc -106
    //   120: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   123: goto -70 -> 53
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	bo
    //   98	13	1	localqg	com.tencent.mm.e.a.qg
    //   126	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	126	finally
    //   56	123	126	finally
  }
  
  /* Error */
  public final boolean zX()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 163
    //   5: ldc -91
    //   7: invokestatic 30	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   10: aload_0
    //   11: invokespecial 167	com/tencent/mm/u/bo:zW	()V
    //   14: aload_0
    //   15: getfield 42	com/tencent/mm/u/bo:hnS	I
    //   18: iconst_2
    //   19: if_icmpne +17 -> 36
    //   22: iconst_1
    //   23: istore_1
    //   24: ldc2_w 163
    //   27: ldc -91
    //   29: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_1
    //   35: ireturn
    //   36: iconst_0
    //   37: istore_1
    //   38: ldc2_w 163
    //   41: ldc -91
    //   43: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   46: goto -14 -> 32
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	bo
    //   23	15	1	bool	boolean
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	49	finally
    //   24	32	49	finally
    //   38	46	49	finally
  }
  
  /* Error */
  public final boolean zY()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 169
    //   5: ldc -85
    //   7: invokestatic 30	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   10: aload_0
    //   11: invokespecial 167	com/tencent/mm/u/bo:zW	()V
    //   14: aload_0
    //   15: getfield 42	com/tencent/mm/u/bo:hnS	I
    //   18: iconst_3
    //   19: if_icmpne +17 -> 36
    //   22: iconst_1
    //   23: istore_1
    //   24: ldc2_w 169
    //   27: ldc -85
    //   29: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_1
    //   35: ireturn
    //   36: iconst_0
    //   37: istore_1
    //   38: ldc2_w 169
    //   41: ldc -85
    //   43: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   46: goto -14 -> 32
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	bo
    //   23	15	1	bool	boolean
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	49	finally
    //   24	32	49	finally
    //   38	46	49	finally
  }
  
  public static abstract interface a
  {
    public abstract boolean zZ();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */