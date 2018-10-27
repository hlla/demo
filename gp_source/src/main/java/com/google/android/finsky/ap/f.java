package com.google.android.finsky.ap;

import android.annotation.TargetApi;
import android.app.usage.NetworkStats.Bucket;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.d;
import android.telephony.TelephonyManager;

@TargetApi(23)
public final class f
  implements g
{
  private final Context a;
  private final NetworkStatsManager b;
  private final PackageManager c;
  private final TelephonyManager d;
  
  public f(Context paramContext, NetworkStatsManager paramNetworkStatsManager, TelephonyManager paramTelephonyManager, PackageManager paramPackageManager)
  {
    this.a = paramContext;
    this.b = paramNetworkStatsManager;
    this.d = paramTelephonyManager;
    this.c = paramPackageManager;
  }
  
  /* Error */
  private final e a(String paramString, NetworkStats.Bucket paramBucket)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/google/android/finsky/ap/f:c	Landroid/content/pm/PackageManager;
    //   4: aload_1
    //   5: iconst_0
    //   6: invokevirtual 42	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   9: getfield 48	android/content/pm/ApplicationInfo:uid	I
    //   12: istore_3
    //   13: invokestatic 53	com/google/android/finsky/utils/i:a	()J
    //   16: lstore 6
    //   18: aload_0
    //   19: getfield 26	com/google/android/finsky/ap/f:b	Landroid/app/usage/NetworkStatsManager;
    //   22: iconst_0
    //   23: aload_0
    //   24: getfield 28	com/google/android/finsky/ap/f:d	Landroid/telephony/TelephonyManager;
    //   27: invokevirtual 59	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   30: lload 6
    //   32: getstatic 65	com/google/android/finsky/ag/d:x	Lcom/google/android/play/utils/b/a;
    //   35: invokevirtual 70	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   38: checkcast 72	java/lang/Long
    //   41: invokevirtual 75	java/lang/Long:longValue	()J
    //   44: lsub
    //   45: lload 6
    //   47: iload_3
    //   48: invokevirtual 81	android/app/usage/NetworkStatsManager:queryDetailsForUid	(ILjava/lang/String;JJI)Landroid/app/usage/NetworkStats;
    //   51: astore 8
    //   53: aload 8
    //   55: ifnull +85 -> 140
    //   58: lconst_0
    //   59: lstore 4
    //   61: aload 8
    //   63: invokevirtual 87	android/app/usage/NetworkStats:hasNextBucket	()Z
    //   66: ifeq +56 -> 122
    //   69: aload 8
    //   71: aload_2
    //   72: invokevirtual 91	android/app/usage/NetworkStats:getNextBucket	(Landroid/app/usage/NetworkStats$Bucket;)Z
    //   75: pop
    //   76: aload_2
    //   77: invokevirtual 97	android/app/usage/NetworkStats$Bucket:getState	()I
    //   80: iconst_m1
    //   81: if_icmpne +20 -> 101
    //   84: lload 4
    //   86: aload_2
    //   87: invokevirtual 100	android/app/usage/NetworkStats$Bucket:getRxBytes	()J
    //   90: aload_2
    //   91: invokevirtual 103	android/app/usage/NetworkStats$Bucket:getTxBytes	()J
    //   94: ladd
    //   95: ladd
    //   96: lstore 4
    //   98: goto -37 -> 61
    //   101: aload_2
    //   102: invokevirtual 97	android/app/usage/NetworkStats$Bucket:getState	()I
    //   105: iconst_2
    //   106: if_icmpne -45 -> 61
    //   109: aload_2
    //   110: invokevirtual 100	android/app/usage/NetworkStats$Bucket:getRxBytes	()J
    //   113: pop2
    //   114: aload_2
    //   115: invokevirtual 103	android/app/usage/NetworkStats$Bucket:getTxBytes	()J
    //   118: pop2
    //   119: goto -58 -> 61
    //   122: aload 8
    //   124: invokevirtual 106	android/app/usage/NetworkStats:close	()V
    //   127: new 108	com/google/android/finsky/ap/e
    //   130: dup
    //   131: aload_1
    //   132: lload 4
    //   134: lload 6
    //   136: invokespecial 111	com/google/android/finsky/ap/e:<init>	(Ljava/lang/String;JJ)V
    //   139: areturn
    //   140: aconst_null
    //   141: areturn
    //   142: astore_2
    //   143: ldc 113
    //   145: iconst_2
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_1
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: aload_2
    //   156: aastore
    //   157: invokestatic 118	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aconst_null
    //   161: areturn
    //   162: astore 8
    //   164: ldc 113
    //   166: iconst_2
    //   167: anewarray 4	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_1
    //   173: aastore
    //   174: dup
    //   175: iconst_1
    //   176: aload 8
    //   178: aastore
    //   179: invokestatic 118	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aconst_null
    //   183: astore 8
    //   185: goto -132 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	f
    //   0	188	1	paramString	String
    //   0	188	2	paramBucket	NetworkStats.Bucket
    //   12	36	3	i	int
    //   59	74	4	l1	long
    //   16	119	6	l2	long
    //   51	72	8	localNetworkStats	android.app.usage.NetworkStats
    //   162	15	8	localSecurityException	SecurityException
    //   183	1	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	13	142	android/content/pm/PackageManager$NameNotFoundException
    //   18	53	162	java/lang/SecurityException
  }
  
  public final e a(String paramString)
  {
    if (d.a(this.a, "android.permission.PACKAGE_USAGE_STATS") == 0) {
      return a(paramString, new NetworkStats.Bucket());
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ap/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */