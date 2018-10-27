package com.google.android.gms.ads.internal.cache;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public class CacheOffering
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new h();
  public long a;
  public final boolean b;
  public final String c;
  private final String d;
  private final String e;
  private final String f;
  private final Bundle g;
  private final long h;
  
  CacheOffering(String paramString1, long paramLong1, String paramString2, String paramString3, String paramString4, Bundle paramBundle, boolean paramBoolean, long paramLong2)
  {
    this.c = paramString1;
    this.h = paramLong1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.f = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this.e = paramString1;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    this.d = paramString1;
    paramString1 = paramBundle;
    if (paramBundle == null) {
      paramString1 = new Bundle();
    }
    this.g = paramString1;
    this.b = paramBoolean;
    this.a = paramLong2;
  }
  
  /* Error */
  public static CacheOffering a(Uri paramUri)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: ldc 59
    //   4: aload_0
    //   5: invokevirtual 65	android/net/Uri:getScheme	()Ljava/lang/String;
    //   8: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +245 -> 256
    //   14: aload_0
    //   15: invokevirtual 75	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   18: astore 6
    //   20: aload 6
    //   22: invokeinterface 81 1 0
    //   27: iconst_2
    //   28: if_icmpne +188 -> 216
    //   31: aload 6
    //   33: iconst_0
    //   34: invokeinterface 85 2 0
    //   39: checkcast 67	java/lang/String
    //   42: astore 5
    //   44: aload 6
    //   46: iconst_1
    //   47: invokeinterface 85 2 0
    //   52: checkcast 67	java/lang/String
    //   55: astore 6
    //   57: aload_0
    //   58: invokevirtual 88	android/net/Uri:getHost	()Ljava/lang/String;
    //   61: astore 7
    //   63: aload_0
    //   64: ldc 90
    //   66: invokevirtual 94	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 8
    //   71: ldc 96
    //   73: aload_0
    //   74: ldc 98
    //   76: invokevirtual 94	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   79: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: istore 4
    //   84: aload_0
    //   85: ldc 100
    //   87: invokevirtual 94	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 9
    //   92: aload 9
    //   94: ifnull +9 -> 103
    //   97: aload 9
    //   99: invokestatic 106	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   102: lstore_2
    //   103: new 45	android/os/Bundle
    //   106: dup
    //   107: invokespecial 46	android/os/Bundle:<init>	()V
    //   110: astore 9
    //   112: getstatic 112	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   115: getfield 115	com/google/android/gms/ads/internal/bt:g	Lcom/google/android/gms/ads/internal/util/v;
    //   118: aload_0
    //   119: invokevirtual 120	com/google/android/gms/ads/internal/util/v:a	(Landroid/net/Uri;)Ljava/util/Set;
    //   122: invokeinterface 126 1 0
    //   127: astore 10
    //   129: aload 10
    //   131: invokeinterface 132 1 0
    //   136: ifne +25 -> 161
    //   139: new 2	com/google/android/gms/ads/internal/cache/CacheOffering
    //   142: dup
    //   143: aload 8
    //   145: lload_2
    //   146: aload 7
    //   148: aload 5
    //   150: aload 6
    //   152: aload 9
    //   154: iload 4
    //   156: lconst_0
    //   157: invokespecial 134	com/google/android/gms/ads/internal/cache/CacheOffering:<init>	(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;ZJ)V
    //   160: areturn
    //   161: aload 10
    //   163: invokeinterface 138 1 0
    //   168: checkcast 67	java/lang/String
    //   171: astore 11
    //   173: aload 11
    //   175: ldc -116
    //   177: invokevirtual 144	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   180: ifeq -51 -> 129
    //   183: aload 9
    //   185: aload 11
    //   187: ldc -116
    //   189: invokevirtual 147	java/lang/String:length	()I
    //   192: invokevirtual 151	java/lang/String:substring	(I)Ljava/lang/String;
    //   195: aload_0
    //   196: aload 11
    //   198: invokevirtual 94	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   201: invokevirtual 155	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: goto -75 -> 129
    //   207: astore_0
    //   208: ldc -99
    //   210: aload_0
    //   211: invokestatic 162	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   214: aconst_null
    //   215: areturn
    //   216: aload 6
    //   218: invokeinterface 81 1 0
    //   223: istore_1
    //   224: new 164	java/lang/StringBuilder
    //   227: dup
    //   228: bipush 62
    //   230: invokespecial 167	java/lang/StringBuilder:<init>	(I)V
    //   233: astore_0
    //   234: aload_0
    //   235: ldc -87
    //   237: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_0
    //   242: iload_1
    //   243: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_0
    //   248: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 182	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   254: aconst_null
    //   255: areturn
    //   256: aconst_null
    //   257: areturn
    //   258: astore_0
    //   259: goto -51 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramUri	Uri
    //   223	20	1	i	int
    //   1	145	2	l	long
    //   82	73	4	bool	boolean
    //   42	107	5	str1	String
    //   18	199	6	localObject1	Object
    //   61	86	7	str2	String
    //   69	75	8	str3	String
    //   90	94	9	localObject2	Object
    //   127	35	10	localIterator	java.util.Iterator
    //   171	26	11	str4	String
    // Exception table:
    //   from	to	target	type
    //   2	92	207	java/lang/NullPointerException
    //   97	103	207	java/lang/NullPointerException
    //   103	129	207	java/lang/NullPointerException
    //   129	161	207	java/lang/NullPointerException
    //   161	204	207	java/lang/NullPointerException
    //   216	254	207	java/lang/NullPointerException
    //   2	92	258	java/lang/NumberFormatException
    //   97	103	258	java/lang/NumberFormatException
    //   103	129	258	java/lang/NumberFormatException
    //   129	161	258	java/lang/NumberFormatException
    //   161	204	258	java/lang/NumberFormatException
    //   216	254	258	java/lang/NumberFormatException
  }
  
  public static CacheOffering a(String paramString)
  {
    return a(Uri.parse(paramString));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.h);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.f);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.e);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.g);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 9, this.a);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/cache/CacheOffering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */