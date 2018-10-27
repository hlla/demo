package com.google.android.finsky.dn.a.a;

import android.content.Context;
import android.database.SQLException;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.finsky.dn.a.h;
import com.google.android.finsky.e.d;
import com.google.android.finsky.e.i;
import com.google.android.finsky.e.u;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.gms.phenotype.core.common.PhenotypeException;

abstract class a
  extends AsyncTask
{
  private final String a;
  private final Context b;
  private final byte[] c;
  private final i d;
  private Exception e;
  private final com.google.android.finsky.bo.c f;
  private com.google.android.finsky.dn.f g;
  private final String[] h;
  private final String i;
  private final com.google.android.gms.phenotype.core.common.c j;
  private final p k;
  private final int l;
  
  public a(p paramp, com.google.android.gms.phenotype.core.common.c paramc, Context paramContext, String paramString1, String[] paramArrayOfString, int paramInt, String paramString2, byte[] paramArrayOfByte, i parami, com.google.android.finsky.bo.c paramc1)
  {
    this.k = paramp;
    this.j = paramc;
    this.i = paramString1;
    this.b = paramContext;
    this.h = paramArrayOfString;
    this.l = paramInt;
    this.a = paramString2;
    this.c = paramArrayOfByte;
    this.d = parami;
    this.f = paramc1;
  }
  
  private final int a(com.google.android.gms.phenotype.core.b paramb)
  {
    com.google.android.gms.phenotype.core.b.a.b localb = new com.google.android.gms.phenotype.core.b.a.b(paramb.c, "com.android.vending");
    try
    {
      localb.a(this.b, this.j);
      return b(paramb);
    }
    catch (PhenotypeException paramb)
    {
      a(paramb, "Failed to commit to Phenotype flags for experiment package %s.", new Object[] { this.i });
      return 2;
    }
    catch (SQLException paramb)
    {
      a(paramb);
    }
    return 2;
  }
  
  private final void a(SQLException paramSQLException)
  {
    this.e = paramSQLException;
    FinskyLog.b(paramSQLException, "Error encountered for Phenotype Database operation for experiment package %s.", new Object[] { this.i });
    if (a()) {
      this.d.d(this.a).a(new d(13).b(paramSQLException).a(paramSQLException).a);
    }
  }
  
  private final void a(Exception paramException, String paramString, Object... paramVarArgs)
  {
    this.e = paramException;
    FinskyLog.a(paramException, paramString, paramVarArgs);
  }
  
  private final boolean a()
  {
    return this.f.h(this.a).a(12647981L);
  }
  
  /* Error */
  private final int b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc -120
    //   5: iconst_1
    //   6: anewarray 78	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: getfield 38	com/google/android/finsky/dn/a/a/a:i	Ljava/lang/String;
    //   15: aastore
    //   16: invokestatic 139	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: aload_0
    //   20: getfield 34	com/google/android/finsky/dn/a/a/a:k	Lcom/google/android/finsky/dn/a/a/p;
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 38	com/google/android/finsky/dn/a/a/a:i	Ljava/lang/String;
    //   28: astore_3
    //   29: aload_0
    //   30: getfield 44	com/google/android/finsky/dn/a/a/a:l	I
    //   33: istore_1
    //   34: aload_0
    //   35: getfield 42	com/google/android/finsky/dn/a/a/a:h	[Ljava/lang/String;
    //   38: astore 4
    //   40: aload_0
    //   41: getfield 48	com/google/android/finsky/dn/a/a/a:c	[B
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 46	com/google/android/finsky/dn/a/a/a:a	Ljava/lang/String;
    //   50: astore 6
    //   52: new 141	com/google/android/gms/phenotype/core/b/a/k
    //   55: dup
    //   56: aload_2
    //   57: getfield 146	com/google/android/finsky/dn/a/a/p:a	Lcom/google/android/gms/phenotype/core/c/d;
    //   60: aload_2
    //   61: getfield 149	com/google/android/finsky/dn/a/a/p:b	Lcom/google/android/gms/phenotype/core/b/a/n;
    //   64: aload_3
    //   65: iload_1
    //   66: aload 4
    //   68: aload 5
    //   70: aload 6
    //   72: ldc 66
    //   74: invokespecial 152	com/google/android/gms/phenotype/core/b/a/k:<init>	(Lcom/google/android/gms/phenotype/core/c/d;Lcom/google/android/gms/phenotype/core/b/a/n;Ljava/lang/String;I[Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;)V
    //   77: astore_2
    //   78: aload_0
    //   79: getfield 40	com/google/android/finsky/dn/a/a/a:b	Landroid/content/Context;
    //   82: astore_3
    //   83: aload_0
    //   84: getfield 36	com/google/android/finsky/dn/a/a/a:j	Lcom/google/android/gms/phenotype/core/common/c;
    //   87: astore 4
    //   89: aload_2
    //   90: getfield 154	com/google/android/gms/phenotype/core/b/a/k:f	Ljava/lang/String;
    //   93: astore 5
    //   95: aload 5
    //   97: ifnonnull +40 -> 137
    //   100: new 56	com/google/android/gms/phenotype/core/common/PhenotypeException
    //   103: dup
    //   104: sipush 29500
    //   107: ldc -100
    //   109: invokespecial 159	com/google/android/gms/phenotype/core/common/PhenotypeException:<init>	(ILjava/lang/String;)V
    //   112: athrow
    //   113: astore_2
    //   114: aload_0
    //   115: aload_2
    //   116: ldc -95
    //   118: iconst_1
    //   119: anewarray 78	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_0
    //   125: getfield 38	com/google/android/finsky/dn/a/a/a:i	Ljava/lang/String;
    //   128: aastore
    //   129: invokespecial 81	com/google/android/finsky/dn/a/a/a:a	(Ljava/lang/Exception;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: ldc 2
    //   134: monitorexit
    //   135: iconst_1
    //   136: ireturn
    //   137: aload 5
    //   139: ldc -93
    //   141: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifne +14 -> 158
    //   147: aload_2
    //   148: getfield 154	com/google/android/gms/phenotype/core/b/a/k:f	Ljava/lang/String;
    //   151: aload_3
    //   152: invokestatic 174	com/google/android/gms/phenotype/core/common/p:a	(Ljava/lang/String;Landroid/content/Context;)Z
    //   155: ifeq +216 -> 371
    //   158: aload_2
    //   159: aload_3
    //   160: aload 4
    //   162: aload_2
    //   163: getfield 177	com/google/android/gms/phenotype/core/b/a/k:b	Lcom/google/f/b/c;
    //   166: aload_2
    //   167: getfield 154	com/google/android/gms/phenotype/core/b/a/k:f	Ljava/lang/String;
    //   170: invokestatic 182	com/google/android/gms/phenotype/core/b/a/l:a	(Landroid/content/Context;Lcom/google/android/gms/phenotype/core/common/c;Lcom/google/f/b/c;Ljava/lang/String;)Lcom/google/android/gms/phenotype/core/b/a/m;
    //   173: putfield 185	com/google/android/gms/phenotype/core/b/a/k:a	Lcom/google/android/gms/phenotype/core/b/a/m;
    //   176: aload_2
    //   177: getfield 187	com/google/android/gms/phenotype/core/b/a/k:c	Lcom/google/android/gms/phenotype/core/b/a/n;
    //   180: astore 5
    //   182: aload_2
    //   183: getfield 177	com/google/android/gms/phenotype/core/b/a/k:b	Lcom/google/f/b/c;
    //   186: getfield 191	com/google/f/b/c:d	Ljava/lang/String;
    //   189: astore 6
    //   191: aload 5
    //   193: aload_2
    //   194: getfield 185	com/google/android/gms/phenotype/core/b/a/k:a	Lcom/google/android/gms/phenotype/core/b/a/m;
    //   197: getfield 196	com/google/android/gms/phenotype/core/b/a/m:a	Lcom/google/f/a/s;
    //   200: invokeinterface 201 2 0
    //   205: ifeq +58 -> 263
    //   208: aload_2
    //   209: getstatic 206	com/google/wireless/android/a/b/a/ab:a	Lcom/google/wireless/android/a/b/a/ab;
    //   212: getstatic 211	com/google/protobuf/bh:e	Lcom/google/protobuf/bh;
    //   215: aconst_null
    //   216: invokevirtual 216	com/google/protobuf/bb:a	(Lcom/google/protobuf/bh;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: checkcast 218	com/google/protobuf/bc
    //   222: checkcast 220	com/google/wireless/android/a/b/a/ac
    //   225: putfield 223	com/google/android/gms/phenotype/core/b/a/k:d	Lcom/google/wireless/android/a/b/a/ac;
    //   228: aload_2
    //   229: getfield 225	com/google/android/gms/phenotype/core/b/a/k:e	Lcom/google/android/gms/phenotype/core/c/d;
    //   232: aload_3
    //   233: invokeinterface 230 2 0
    //   238: aload_2
    //   239: getfield 185	com/google/android/gms/phenotype/core/b/a/k:a	Lcom/google/android/gms/phenotype/core/b/a/m;
    //   242: getfield 196	com/google/android/gms/phenotype/core/b/a/m:a	Lcom/google/f/a/s;
    //   245: aload_2
    //   246: getfield 177	com/google/android/gms/phenotype/core/b/a/k:b	Lcom/google/f/b/c;
    //   249: getfield 191	com/google/f/b/c:d	Ljava/lang/String;
    //   252: aload_2
    //   253: getfield 154	com/google/android/gms/phenotype/core/b/a/k:f	Ljava/lang/String;
    //   256: aload_2
    //   257: getfield 223	com/google/android/gms/phenotype/core/b/a/k:d	Lcom/google/wireless/android/a/b/a/ac;
    //   260: invokevirtual 235	com/google/android/gms/phenotype/core/c/b:a	(Lcom/google/f/a/s;Ljava/lang/String;Ljava/lang/String;Lcom/google/wireless/android/a/b/a/ac;)V
    //   263: aload_2
    //   264: getfield 177	com/google/android/gms/phenotype/core/b/a/k:b	Lcom/google/f/b/c;
    //   267: astore 5
    //   269: aload 5
    //   271: getfield 191	com/google/f/b/c:d	Ljava/lang/String;
    //   274: astore 6
    //   276: new 237	com/google/android/gms/phenotype/core/b/a/e
    //   279: dup
    //   280: aload 6
    //   282: aload_2
    //   283: getfield 154	com/google/android/gms/phenotype/core/b/a/k:f	Ljava/lang/String;
    //   286: aconst_null
    //   287: aload 6
    //   289: aload 5
    //   291: getfield 239	com/google/f/b/c:b	Ljava/lang/String;
    //   294: invokespecial 242	com/google/android/gms/phenotype/core/b/a/e:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_3
    //   298: aload 4
    //   300: invokevirtual 245	com/google/android/gms/phenotype/core/b/a/e:a	(Landroid/content/Context;Lcom/google/android/gms/phenotype/core/common/c;)Lcom/google/android/gms/phenotype/core/b;
    //   303: astore_2
    //   304: aload_2
    //   305: getfield 64	com/google/android/gms/phenotype/core/b:c	Ljava/lang/String;
    //   308: aload_0
    //   309: aload_0
    //   310: getfield 46	com/google/android/finsky/dn/a/a/a:a	Ljava/lang/String;
    //   313: invokevirtual 248	com/google/android/finsky/dn/a/a/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   316: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   319: ifne +20 -> 339
    //   322: aload_0
    //   323: aload_2
    //   324: invokespecial 250	com/google/android/finsky/dn/a/a/a:a	(Lcom/google/android/gms/phenotype/core/b;)I
    //   327: istore_1
    //   328: ldc 2
    //   330: monitorexit
    //   331: iload_1
    //   332: ireturn
    //   333: astore_2
    //   334: ldc 2
    //   336: monitorexit
    //   337: aload_2
    //   338: athrow
    //   339: ldc -4
    //   341: iconst_1
    //   342: anewarray 78	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: aload_0
    //   348: getfield 38	com/google/android/finsky/dn/a/a/a:i	Ljava/lang/String;
    //   351: aastore
    //   352: invokestatic 139	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   355: ldc 2
    //   357: monitorexit
    //   358: iconst_0
    //   359: ireturn
    //   360: astore_2
    //   361: aload_0
    //   362: aload_2
    //   363: invokespecial 84	com/google/android/finsky/dn/a/a/a:a	(Landroid/database/SQLException;)V
    //   366: ldc 2
    //   368: monitorexit
    //   369: iconst_1
    //   370: ireturn
    //   371: new 56	com/google/android/gms/phenotype/core/common/PhenotypeException
    //   374: dup
    //   375: sipush 29500
    //   378: ldc -2
    //   380: invokespecial 159	com/google/android/gms/phenotype/core/common/PhenotypeException:<init>	(ILjava/lang/String;)V
    //   383: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	a
    //   33	299	1	m	int
    //   23	67	2	localObject1	Object
    //   113	170	2	localPhenotypeException	PhenotypeException
    //   303	21	2	localb	com.google.android.gms.phenotype.core.b
    //   333	5	2	localObject2	Object
    //   360	3	2	localSQLException	SQLException
    //   28	270	3	localObject3	Object
    //   38	261	4	localObject4	Object
    //   44	246	5	localObject5	Object
    //   50	238	6	str	String
    // Exception table:
    //   from	to	target	type
    //   78	95	113	com/google/android/gms/phenotype/core/common/PhenotypeException
    //   100	113	113	com/google/android/gms/phenotype/core/common/PhenotypeException
    //   137	158	113	com/google/android/gms/phenotype/core/common/PhenotypeException
    //   158	263	113	com/google/android/gms/phenotype/core/common/PhenotypeException
    //   263	304	113	com/google/android/gms/phenotype/core/common/PhenotypeException
    //   371	384	113	com/google/android/gms/phenotype/core/common/PhenotypeException
    //   3	78	333	finally
    //   78	95	333	finally
    //   100	113	333	finally
    //   114	135	333	finally
    //   137	158	333	finally
    //   158	263	333	finally
    //   263	304	333	finally
    //   304	331	333	finally
    //   334	337	333	finally
    //   339	358	333	finally
    //   361	369	333	finally
    //   371	384	333	finally
    //   78	95	360	android/database/SQLException
    //   100	113	360	android/database/SQLException
    //   137	158	360	android/database/SQLException
    //   158	263	360	android/database/SQLException
    //   263	304	360	android/database/SQLException
    //   371	384	360	android/database/SQLException
  }
  
  private final int b(com.google.android.gms.phenotype.core.b paramb)
  {
    Object localObject = new com.google.android.gms.phenotype.core.b.a.g(this.i, "com.android.vending");
    try
    {
      com.google.android.gms.phenotype.core.common.c localc = this.j;
      String str = ((com.google.android.gms.phenotype.core.b.a.g)localObject).a;
      if (((com.google.android.gms.phenotype.core.b.a.g)localObject).b != null)
      {
        localObject = ((com.google.android.gms.phenotype.core.b.a.g)localObject).a(localc);
        if (localObject == null) {
          throw new PhenotypeException(29505, "No config packages for log source, or config package not registered");
        }
      }
    }
    catch (PhenotypeException paramb)
    {
      a(paramb, "Failed to retrieve Phenotype experiment token for package %s.", new Object[] { this.i });
      return 3;
      localObject = ((com.google.android.gms.phenotype.core.c)localObject).a();
      localObject = g.a((com.google.android.gms.phenotype.core.c)localObject, TextUtils.equals(((com.google.android.gms.phenotype.core.c)localObject).i, this.a));
      if (a(new c(paramb), (com.google.android.play.b.a.c)localObject, this.a))
      {
        FinskyLog.a("Successfully applied new configurations for package %s.", new Object[] { this.i });
        return 0;
      }
      paramb = String.format("Failed to apply new configurations for package %s.", new Object[] { this.i });
      a(new Exception(paramb), paramb, new Object[0]);
      return 4;
    }
    catch (SQLException paramb)
    {
      a(paramb);
      return 3;
    }
    throw new PhenotypeException(29500, "No package name or log source");
  }
  
  protected abstract int a(int paramInt);
  
  protected abstract String a(String paramString);
  
  public void a(com.google.android.finsky.dn.f paramf)
  {
    this.g = paramf;
  }
  
  protected abstract boolean a(h paramh, com.google.android.play.b.a.c paramc, String paramString);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */