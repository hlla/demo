package com.tencent.mm.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.a.g;
import com.tencent.mm.cache.a.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public final class d
{
  private static int hqI;
  private static int hqJ;
  static final Map<String, Integer> hqK;
  private static a hqO;
  private k<a, String> hqL;
  public Vector<WeakReference<a>> hqM;
  private final a hqN;
  
  static
  {
    GMTrace.i(390573588480L, 2910);
    hqI = 150;
    hqJ = 150;
    HashMap localHashMap = new HashMap();
    hqK = localHashMap;
    localHashMap.put("voipapp", Integer.valueOf(a.f.kCm));
    hqK.put("qqmail", Integer.valueOf(a.f.kCh));
    hqK.put("fmessage", Integer.valueOf(a.f.kBZ));
    hqK.put("floatbottle", Integer.valueOf(a.f.kBW));
    hqK.put("lbsapp", Integer.valueOf(a.f.kCd));
    hqK.put("shakeapp", Integer.valueOf(a.f.kCj));
    hqK.put("medianote", Integer.valueOf(a.f.kCc));
    hqK.put("qqfriend", Integer.valueOf(a.f.kCg));
    hqK.put("masssendapp", Integer.valueOf(a.f.kCb));
    hqK.put("feedsapp", Integer.valueOf(a.f.kBY));
    hqK.put("facebookapp", Integer.valueOf(a.f.dwh));
    hqK.put("newsapp", Integer.valueOf(a.f.kCi));
    hqK.put("helper_entry", Integer.valueOf(a.f.kCf));
    hqK.put("voicevoipapp", Integer.valueOf(a.f.kCl));
    hqK.put("voiceinputapp", Integer.valueOf(a.f.kCk));
    hqK.put("officialaccounts", Integer.valueOf(a.f.kBX));
    hqK.put("service_officialaccounts", Integer.valueOf(a.f.dwl));
    hqK.put("linkedinplugin", Integer.valueOf(a.f.kCa));
    hqK.put("notifymessage", Integer.valueOf(a.f.kCe));
    hqK.put("appbrandcustomerservicemsg", Integer.valueOf(a.f.kBV));
    hqO = new a(hqJ);
    GMTrace.o(390573588480L, 2910);
  }
  
  public d()
  {
    GMTrace.i(387620798464L, 2888);
    this.hqL = new k() {};
    this.hqM = new Vector();
    this.hqN = new a()
    {
      public final void ho(String paramAnonymousString)
      {
        GMTrace.i(393257943040L, 2930);
        Vector localVector2 = new Vector();
        v.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", new Object[] { paramAnonymousString, Integer.valueOf(d.this.hqM.size()), Integer.valueOf(d.this.hqM.size()) });
        Vector localVector3 = new Vector();
        Vector localVector1 = d.this.hqM;
        int i = 0;
        for (;;)
        {
          try
          {
            if (i < d.this.hqM.size())
            {
              WeakReference localWeakReference = (WeakReference)d.this.hqM.get(i);
              if (localWeakReference == null) {
                break label221;
              }
              d.a locala = (d.a)localWeakReference.get();
              if (locala != null) {
                localVector3.add(locala);
              } else {
                localVector2.add(localWeakReference);
              }
            }
          }
          finally {}
          d.this.hqM.removeAll(localVector2);
          i = 0;
          while (i < localVector3.size())
          {
            ((d.a)localVector3.get(i)).ho(paramAnonymousString);
            i += 1;
          }
          GMTrace.o(393257943040L, 2930);
          return;
          label221:
          i += 1;
        }
      }
    };
    reset();
    this.hqL.a(this.hqN, null);
    GMTrace.o(387620798464L, 2888);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, int paramInt)
  {
    GMTrace.i(387486580736L, 2887);
    try
    {
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.compatible.f.a.decodeResource(paramContext.getResources(), paramInt), true, 1.0F));
      GMTrace.o(387486580736L, 2887);
      return;
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bf.g(paramContext) });
      GMTrace.o(387486580736L, 2887);
    }
  }
  
  private WeakReference<a> c(a parama)
  {
    GMTrace.i(388023451648L, 2891);
    Vector localVector = this.hqM;
    int i = 0;
    try
    {
      while (i < this.hqM.size())
      {
        WeakReference localWeakReference = (WeakReference)this.hqM.get(i);
        if (localWeakReference != null)
        {
          a locala = (a)localWeakReference.get();
          if ((locala != null) && (locala.equals(parama)))
          {
            GMTrace.o(388023451648L, 2891);
            return localWeakReference;
          }
        }
        i += 1;
      }
      GMTrace.o(388023451648L, 2891);
      return null;
    }
    finally {}
  }
  
  /* Error */
  public static Bitmap f(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc2_w 272
    //   3: sipush 2901
    //   6: invokestatic 40	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_1
    //   10: bipush 96
    //   12: bipush 96
    //   14: iconst_0
    //   15: iconst_2
    //   16: newarray <illegal type>
    //   18: dup
    //   19: iconst_0
    //   20: iconst_0
    //   21: iastore
    //   22: dup
    //   23: iconst_1
    //   24: iconst_1
    //   25: iastore
    //   26: invokestatic 276	com/tencent/mm/sdk/platformtools/d:a	([BIII[I)Landroid/graphics/Bitmap;
    //   29: astore 5
    //   31: aload 5
    //   33: invokestatic 280	com/tencent/mm/x/d:k	(Landroid/graphics/Bitmap;)Z
    //   36: ifne +30 -> 66
    //   39: ldc -26
    //   41: ldc_w 282
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_0
    //   51: aastore
    //   52: invokestatic 244	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: ldc2_w 272
    //   58: sipush 2901
    //   61: invokestatic 175	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   64: aconst_null
    //   65: areturn
    //   66: aload 5
    //   68: invokevirtual 287	android/graphics/Bitmap:getWidth	()I
    //   71: istore_2
    //   72: aload 5
    //   74: invokevirtual 290	android/graphics/Bitmap:getHeight	()I
    //   77: istore_3
    //   78: aload 5
    //   80: astore 4
    //   82: iload_2
    //   83: iload_3
    //   84: if_icmpeq +23 -> 107
    //   87: iload_2
    //   88: iload_3
    //   89: if_icmple +83 -> 172
    //   92: aload 5
    //   94: iload_2
    //   95: iload_3
    //   96: isub
    //   97: iconst_2
    //   98: idiv
    //   99: iconst_0
    //   100: iload_3
    //   101: iload_3
    //   102: invokestatic 294	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   105: astore 4
    //   107: aload_0
    //   108: iconst_0
    //   109: invokestatic 298	com/tencent/mm/x/d:r	(Ljava/lang/String;Z)Ljava/lang/String;
    //   112: astore 5
    //   114: aload 5
    //   116: invokestatic 304	com/tencent/mm/modelsfs/FileOp:gQ	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   119: astore 6
    //   121: aload 6
    //   123: astore 5
    //   125: aload 6
    //   127: aload_1
    //   128: iconst_0
    //   129: aload_1
    //   130: arraylength
    //   131: invokevirtual 310	java/io/OutputStream:write	([BII)V
    //   134: aload 6
    //   136: ifnull +8 -> 144
    //   139: aload 6
    //   141: invokevirtual 313	java/io/OutputStream:close	()V
    //   144: ldc -26
    //   146: ldc_w 315
    //   149: iconst_1
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload_0
    //   156: aastore
    //   157: invokestatic 317	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: ldc2_w 272
    //   163: sipush 2901
    //   166: invokestatic 175	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   169: aload 4
    //   171: areturn
    //   172: aload 5
    //   174: iconst_0
    //   175: iload_3
    //   176: iload_2
    //   177: isub
    //   178: iconst_2
    //   179: idiv
    //   180: iload_2
    //   181: iload_2
    //   182: invokestatic 294	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   185: astore 4
    //   187: goto -80 -> 107
    //   190: astore_1
    //   191: aconst_null
    //   192: astore 6
    //   194: aload 6
    //   196: astore 5
    //   198: ldc -26
    //   200: aload_1
    //   201: ldc_w 319
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload_0
    //   211: aastore
    //   212: invokestatic 323	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: aload 6
    //   217: ifnull +8 -> 225
    //   220: aload 6
    //   222: invokevirtual 313	java/io/OutputStream:close	()V
    //   225: ldc2_w 272
    //   228: sipush 2901
    //   231: invokestatic 175	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_0
    //   237: aconst_null
    //   238: astore 5
    //   240: aload 5
    //   242: ifnull +8 -> 250
    //   245: aload 5
    //   247: invokevirtual 313	java/io/OutputStream:close	()V
    //   250: aload_0
    //   251: athrow
    //   252: astore_1
    //   253: goto -109 -> 144
    //   256: astore_0
    //   257: goto -32 -> 225
    //   260: astore_1
    //   261: goto -11 -> 250
    //   264: astore_0
    //   265: goto -25 -> 240
    //   268: astore_1
    //   269: goto -75 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramString	String
    //   0	272	1	paramArrayOfByte	byte[]
    //   71	111	2	i	int
    //   77	101	3	j	int
    //   80	106	4	localObject1	Object
    //   29	217	5	localObject2	Object
    //   119	102	6	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   114	121	190	java/io/IOException
    //   114	121	236	finally
    //   139	144	252	java/io/IOException
    //   220	225	256	java/io/IOException
    //   245	250	260	java/io/IOException
    //   125	134	264	finally
    //   198	215	264	finally
    //   125	134	268	java/io/IOException
  }
  
  public static Bitmap hj(String paramString)
  {
    GMTrace.i(388560322560L, 2895);
    if (bf.mA(paramString))
    {
      GMTrace.o(388560322560L, 2895);
      return null;
    }
    Object localObject = hqO;
    if (((a)localObject).hqp != null) {}
    for (localObject = (Bitmap)((a)localObject).hqp.get(paramString); localObject == null; localObject = (Bitmap)a.a.x("avatar_cache", paramString))
    {
      GMTrace.o(388560322560L, 2895);
      return null;
    }
    if (((Bitmap)localObject).isRecycled())
    {
      localObject = hqO;
      if (((a)localObject).hqp != null) {
        ((a)localObject).hqp.remove(paramString);
      }
      for (;;)
      {
        GMTrace.o(388560322560L, 2895);
        return null;
        a.a.y("avatar_cache", paramString);
      }
    }
    GMTrace.o(388560322560L, 2895);
    return (Bitmap)localObject;
  }
  
  public static Bitmap hk(String paramString)
  {
    GMTrace.i(389231411200L, 2900);
    paramString = hn(r(paramString, false));
    GMTrace.o(389231411200L, 2900);
    return paramString;
  }
  
  public static Bitmap hl(String paramString)
  {
    GMTrace.i(389902499840L, 2905);
    v.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", new Object[] { paramString });
    if (bf.mA(paramString))
    {
      GMTrace.o(389902499840L, 2905);
      return null;
    }
    paramString = com.tencent.mm.sdk.platformtools.d.a(r(paramString, true), 480, 480, null, 0, new int[] { 0, 1 });
    GMTrace.o(389902499840L, 2905);
    return paramString;
  }
  
  public static Bitmap hm(String paramString)
  {
    GMTrace.i(390036717568L, 2906);
    int i = 0;
    if (hqK.containsKey(paramString)) {
      i = ((Integer)hqK.get(paramString)).intValue();
    }
    if (i != 0) {
      n.Bx();
    }
    for (paramString = com.tencent.mm.compatible.f.a.decodeResource(n.getContext().getResources(), i);; paramString = null)
    {
      paramString = com.tencent.mm.sdk.platformtools.d.a(paramString, true, 1.0F, true);
      GMTrace.o(390036717568L, 2906);
      return paramString;
    }
  }
  
  public static Bitmap hn(String paramString)
  {
    GMTrace.i(390305153024L, 2908);
    if (FileOp.aO(paramString)) {}
    for (Bitmap localBitmap2 = com.tencent.mm.sdk.platformtools.d.a(paramString, null, 0, new int[] { 0, 1 });; localBitmap2 = null)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = b.hq(paramString);
      }
      paramString = localBitmap1;
      int i;
      int j;
      if (k(localBitmap1))
      {
        i = localBitmap1.getWidth();
        j = localBitmap1.getHeight();
        paramString = localBitmap1;
        if (i != j) {
          if (i <= j) {
            break label110;
          }
        }
      }
      label110:
      for (paramString = Bitmap.createBitmap(localBitmap1, (i - j) / 2, 0, j, j); k(paramString); paramString = Bitmap.createBitmap(localBitmap1, 0, (j - i) / 2, i, i))
      {
        GMTrace.o(390305153024L, 2908);
        return paramString;
      }
      GMTrace.o(390305153024L, 2908);
      return null;
    }
  }
  
  private static boolean k(Bitmap paramBitmap)
  {
    GMTrace.i(390170935296L, 2907);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      GMTrace.o(390170935296L, 2907);
      return true;
    }
    GMTrace.o(390170935296L, 2907);
    return false;
  }
  
  public static String r(String paramString, boolean paramBoolean)
  {
    GMTrace.i(388962975744L, 2898);
    if (bf.mA(paramString))
    {
      GMTrace.o(388962975744L, 2898);
      return null;
    }
    String str2 = com.tencent.mm.plugin.g.a.ZQ();
    StringBuilder localStringBuilder = new StringBuilder("user_");
    if (paramBoolean) {}
    for (String str1 = "hd_";; str1 = "")
    {
      paramString = h.a(str2, str1, g.n(paramString.getBytes()), ".png", 1, false);
      if (paramString != null) {
        break;
      }
      GMTrace.o(388962975744L, 2898);
      return null;
    }
    if (FileOp.km(new File(paramString).getParent()))
    {
      GMTrace.o(388962975744L, 2898);
      return paramString;
    }
    GMTrace.o(388962975744L, 2898);
    return null;
  }
  
  public static void reset()
  {
    GMTrace.i(388426104832L, 2894);
    if (hqO == null) {
      hqO = new a(hqJ);
    }
    GMTrace.o(388426104832L, 2894);
  }
  
  public static boolean s(String paramString, boolean paramBoolean)
  {
    GMTrace.i(389097193472L, 2899);
    String str = r(paramString, paramBoolean);
    v.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), str });
    boolean bool2 = FileOp.deleteFile(str);
    boolean bool1 = bool2;
    if (!paramBoolean) {
      bool1 = bool2 | b.dd(str);
    }
    GMTrace.o(389097193472L, 2899);
    return bool1;
  }
  
  public final boolean R(String paramString1, String paramString2)
  {
    GMTrace.i(389634064384L, 2903);
    try
    {
      BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.d.Pd(paramString1);
      int k = localOptions.outWidth;
      int m = localOptions.outHeight;
      int j;
      int i;
      if (m < k)
      {
        j = 96;
        i = k * 96 / m;
      }
      for (;;)
      {
        v.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(1) });
        localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        localOptions.inSampleSize = Math.min(k / i, m / j);
        paramString1 = com.tencent.mm.sdk.platformtools.d.a(paramString1, localOptions, 0, new int[] { 0, 1 });
        paramString1.recycle();
        boolean bool = d(paramString2, paramString1);
        GMTrace.o(389634064384L, 2903);
        return bool;
        i = 96;
        j = m * 96 / k;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      v.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bf.g(paramString1) });
      GMTrace.o(389634064384L, 2903);
    }
  }
  
  public final void a(a parama)
  {
    GMTrace.i(387755016192L, 2889);
    synchronized (this.hqM)
    {
      this.hqM.add(new WeakReference(parama));
      GMTrace.o(387755016192L, 2889);
      return;
    }
  }
  
  public final Bitmap aS(Context paramContext)
  {
    GMTrace.i(388828758016L, 2897);
    paramContext.getResources();
    Bitmap localBitmap = hj("I_AM_NO_SDCARD_USER_NAME");
    paramContext = localBitmap;
    if (!k(localBitmap))
    {
      paramContext = localBitmap;
      if (localBitmap != null)
      {
        v.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", new Object[] { Boolean.valueOf(localBitmap.isRecycled()), "I_AM_NO_SDCARD_USER_NAME" });
        paramContext = com.tencent.mm.sdk.platformtools.d.a(localBitmap, true, 1.0F);
        c("I_AM_NO_SDCARD_USER_NAME", paramContext);
      }
    }
    GMTrace.o(388828758016L, 2897);
    return paramContext;
  }
  
  public final void b(a parama)
  {
    GMTrace.i(387889233920L, 2890);
    synchronized (this.hqM)
    {
      this.hqM.remove(c(parama));
      GMTrace.o(387889233920L, 2890);
      return;
    }
  }
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    GMTrace.i(388694540288L, 2896);
    a locala = hqO;
    if (locala.hqp != null) {
      locala.hqp.k(paramString, paramBitmap);
    }
    for (;;)
    {
      this.hqL.by(paramString);
      this.hqL.doNotify();
      v.d("MicroMsg.AvatarStorage", "setToCache %s", new Object[] { paramString });
      GMTrace.o(388694540288L, 2896);
      return;
      a.a.a("avatar_cache", paramString, paramBitmap);
    }
  }
  
  @Deprecated
  public final void d(a parama)
  {
    GMTrace.i(388157669376L, 2892);
    this.hqL.a(parama, Looper.getMainLooper());
    GMTrace.o(388157669376L, 2892);
  }
  
  /* Error */
  public boolean d(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc2_w 585
    //   3: sipush 2904
    //   6: invokestatic 40	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_2
    //   10: invokestatic 280	com/tencent/mm/x/d:k	(Landroid/graphics/Bitmap;)Z
    //   13: ifne +14 -> 27
    //   16: ldc2_w 585
    //   19: sipush 2904
    //   22: invokestatic 175	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   25: iconst_0
    //   26: ireturn
    //   27: aload_2
    //   28: invokevirtual 287	android/graphics/Bitmap:getWidth	()I
    //   31: bipush 96
    //   33: if_icmpne +108 -> 141
    //   36: aload_2
    //   37: invokevirtual 290	android/graphics/Bitmap:getHeight	()I
    //   40: bipush 96
    //   42: if_icmpne +99 -> 141
    //   45: aload_2
    //   46: astore 5
    //   48: aload_2
    //   49: astore 6
    //   51: aload 5
    //   53: ifnull +39 -> 92
    //   56: aload_2
    //   57: astore 6
    //   59: aload 5
    //   61: aload_2
    //   62: if_acmpeq +30 -> 92
    //   65: ldc -26
    //   67: ldc_w 588
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_2
    //   77: invokevirtual 589	java/lang/Object:toString	()Ljava/lang/String;
    //   80: aastore
    //   81: invokestatic 317	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_2
    //   85: invokevirtual 525	android/graphics/Bitmap:recycle	()V
    //   88: aload 5
    //   90: astore 6
    //   92: aload_1
    //   93: iconst_0
    //   94: invokestatic 298	com/tencent/mm/x/d:r	(Ljava/lang/String;Z)Ljava/lang/String;
    //   97: astore_2
    //   98: aload_2
    //   99: invokestatic 304	com/tencent/mm/modelsfs/FileOp:gQ	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   102: astore_2
    //   103: aload 6
    //   105: getstatic 595	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   108: bipush 100
    //   110: aload_2
    //   111: invokevirtual 599	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   114: pop
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 313	java/io/OutputStream:close	()V
    //   123: aload_0
    //   124: aload_1
    //   125: aload 6
    //   127: invokevirtual 550	com/tencent/mm/x/d:c	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   130: ldc2_w 585
    //   133: sipush 2904
    //   136: invokestatic 175	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   139: iconst_1
    //   140: ireturn
    //   141: aload_2
    //   142: invokevirtual 287	android/graphics/Bitmap:getWidth	()I
    //   145: istore_3
    //   146: aload_2
    //   147: invokevirtual 290	android/graphics/Bitmap:getHeight	()I
    //   150: istore 4
    //   152: iload_3
    //   153: iload 4
    //   155: if_icmpeq +59 -> 214
    //   158: iload_3
    //   159: iload 4
    //   161: if_icmple +35 -> 196
    //   164: aload_2
    //   165: iload_3
    //   166: iload 4
    //   168: isub
    //   169: iconst_2
    //   170: idiv
    //   171: iconst_0
    //   172: iload 4
    //   174: iload 4
    //   176: invokestatic 294	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   179: astore 5
    //   181: aload 5
    //   183: bipush 96
    //   185: bipush 96
    //   187: iconst_1
    //   188: invokestatic 603	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   191: astore 5
    //   193: goto -145 -> 48
    //   196: aload_2
    //   197: iconst_0
    //   198: iload 4
    //   200: iload_3
    //   201: isub
    //   202: iconst_2
    //   203: idiv
    //   204: iload_3
    //   205: iload_3
    //   206: invokestatic 294	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   209: astore 5
    //   211: goto -30 -> 181
    //   214: aload_2
    //   215: bipush 96
    //   217: bipush 96
    //   219: iconst_1
    //   220: invokestatic 603	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   223: astore 5
    //   225: goto -177 -> 48
    //   228: astore 5
    //   230: ldc -26
    //   232: ldc_w 605
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload_1
    //   242: aastore
    //   243: invokestatic 244	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: aload_2
    //   247: invokestatic 280	com/tencent/mm/x/d:k	(Landroid/graphics/Bitmap;)Z
    //   250: ifeq +26 -> 276
    //   253: ldc -26
    //   255: ldc_w 588
    //   258: iconst_1
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload_2
    //   265: invokevirtual 589	java/lang/Object:toString	()Ljava/lang/String;
    //   268: aastore
    //   269: invokestatic 317	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: aload_2
    //   273: invokevirtual 525	android/graphics/Bitmap:recycle	()V
    //   276: ldc2_w 585
    //   279: sipush 2904
    //   282: invokestatic 175	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   285: iconst_0
    //   286: ireturn
    //   287: astore 5
    //   289: aconst_null
    //   290: astore_2
    //   291: ldc -26
    //   293: aload 5
    //   295: ldc_w 319
    //   298: iconst_1
    //   299: anewarray 4	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: aload_1
    //   305: aastore
    //   306: invokestatic 323	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: aload_2
    //   310: ifnull +7 -> 317
    //   313: aload_2
    //   314: invokevirtual 313	java/io/OutputStream:close	()V
    //   317: ldc2_w 585
    //   320: sipush 2904
    //   323: invokestatic 175	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   326: iconst_0
    //   327: ireturn
    //   328: astore_1
    //   329: aconst_null
    //   330: astore_2
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 313	java/io/OutputStream:close	()V
    //   339: aload_1
    //   340: athrow
    //   341: astore_2
    //   342: goto -219 -> 123
    //   345: astore_1
    //   346: goto -29 -> 317
    //   349: astore_2
    //   350: goto -11 -> 339
    //   353: astore_1
    //   354: goto -23 -> 331
    //   357: astore_1
    //   358: goto -27 -> 331
    //   361: astore 5
    //   363: goto -72 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	d
    //   0	366	1	paramString	String
    //   0	366	2	paramBitmap	Bitmap
    //   145	61	3	i	int
    //   150	52	4	j	int
    //   46	178	5	localBitmap1	Bitmap
    //   228	1	5	localOutOfMemoryError	OutOfMemoryError
    //   287	7	5	localIOException1	java.io.IOException
    //   361	1	5	localIOException2	java.io.IOException
    //   49	77	6	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   141	152	228	java/lang/OutOfMemoryError
    //   164	181	228	java/lang/OutOfMemoryError
    //   181	193	228	java/lang/OutOfMemoryError
    //   196	211	228	java/lang/OutOfMemoryError
    //   214	225	228	java/lang/OutOfMemoryError
    //   98	103	287	java/io/IOException
    //   98	103	328	finally
    //   119	123	341	java/io/IOException
    //   313	317	345	java/io/IOException
    //   335	339	349	java/io/IOException
    //   103	115	353	finally
    //   291	309	357	finally
    //   103	115	361	java/io/IOException
  }
  
  @Deprecated
  public final void e(a parama)
  {
    GMTrace.i(388291887104L, 2893);
    this.hqL.remove(parama);
    GMTrace.o(388291887104L, 2893);
  }
  
  public final boolean g(String paramString, byte[] paramArrayOfByte)
  {
    GMTrace.i(389499846656L, 2902);
    paramArrayOfByte = f(paramString, paramArrayOfByte);
    if (!k(paramArrayOfByte))
    {
      GMTrace.o(389499846656L, 2902);
      return false;
    }
    c(paramString, paramArrayOfByte);
    GMTrace.o(389499846656L, 2902);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void ho(String paramString);
  }
  
  public static final class b
  {
    public static boolean dd(String paramString)
    {
      GMTrace.i(374870114304L, 2793);
      FileOp.deleteFile(paramString + ".bm");
      FileOp.deleteFile(paramString);
      GMTrace.o(374870114304L, 2793);
      return true;
    }
    
    /* Error */
    public static boolean hp(String paramString)
    {
      // Byte code:
      //   0: ldc2_w 46
      //   3: sipush 2791
      //   6: invokestatic 17	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   9: aload_0
      //   10: invokestatic 51	com/tencent/mm/x/d$b:hq	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   13: astore 4
      //   15: aload 4
      //   17: ifnull +11 -> 28
      //   20: aload 4
      //   22: invokevirtual 57	android/graphics/Bitmap:isRecycled	()Z
      //   25: ifeq +14 -> 39
      //   28: ldc2_w 46
      //   31: sipush 2791
      //   34: invokestatic 41	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   37: iconst_0
      //   38: ireturn
      //   39: aconst_null
      //   40: astore_2
      //   41: aconst_null
      //   42: astore_1
      //   43: aload_0
      //   44: invokestatic 61	com/tencent/mm/modelsfs/FileOp:gQ	(Ljava/lang/String;)Ljava/io/OutputStream;
      //   47: astore_3
      //   48: aload_3
      //   49: astore_1
      //   50: aload_3
      //   51: astore_2
      //   52: aload 4
      //   54: getstatic 67	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
      //   57: bipush 100
      //   59: aload_3
      //   60: invokevirtual 71	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   63: pop
      //   64: aload_3
      //   65: astore_1
      //   66: aload_3
      //   67: astore_2
      //   68: new 19	java/lang/StringBuilder
      //   71: dup
      //   72: invokespecial 23	java/lang/StringBuilder:<init>	()V
      //   75: aload_0
      //   76: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   79: ldc 29
      //   81: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   84: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   87: invokestatic 38	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
      //   90: pop
      //   91: aload_3
      //   92: ifnull +7 -> 99
      //   95: aload_3
      //   96: invokevirtual 76	java/io/OutputStream:close	()V
      //   99: ldc2_w 46
      //   102: sipush 2791
      //   105: invokestatic 41	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   108: iconst_1
      //   109: ireturn
      //   110: astore_3
      //   111: aload_1
      //   112: astore_2
      //   113: ldc 78
      //   115: aload_3
      //   116: ldc 80
      //   118: iconst_1
      //   119: anewarray 4	java/lang/Object
      //   122: dup
      //   123: iconst_0
      //   124: aload_0
      //   125: aastore
      //   126: invokestatic 86	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   129: aload_1
      //   130: ifnull +7 -> 137
      //   133: aload_1
      //   134: invokevirtual 76	java/io/OutputStream:close	()V
      //   137: ldc2_w 46
      //   140: sipush 2791
      //   143: invokestatic 41	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   146: iconst_0
      //   147: ireturn
      //   148: astore_0
      //   149: aload_2
      //   150: ifnull +7 -> 157
      //   153: aload_2
      //   154: invokevirtual 76	java/io/OutputStream:close	()V
      //   157: aload_0
      //   158: athrow
      //   159: astore_0
      //   160: goto -61 -> 99
      //   163: astore_0
      //   164: goto -27 -> 137
      //   167: astore_1
      //   168: goto -11 -> 157
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	171	0	paramString	String
      //   42	92	1	localObject1	Object
      //   167	1	1	localIOException1	java.io.IOException
      //   40	114	2	localObject2	Object
      //   47	49	3	localOutputStream	java.io.OutputStream
      //   110	6	3	localIOException2	java.io.IOException
      //   13	40	4	localBitmap	Bitmap
      // Exception table:
      //   from	to	target	type
      //   43	48	110	java/io/IOException
      //   52	64	110	java/io/IOException
      //   68	91	110	java/io/IOException
      //   43	48	148	finally
      //   52	64	148	finally
      //   68	91	148	finally
      //   113	129	148	finally
      //   95	99	159	java/io/IOException
      //   133	137	163	java/io/IOException
      //   153	157	167	java/io/IOException
    }
    
    /* Error */
    public static Bitmap hq(String paramString)
    {
      // Byte code:
      //   0: ldc2_w 91
      //   3: sipush 2792
      //   6: invokestatic 17	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   9: new 19	java/lang/StringBuilder
      //   12: dup
      //   13: invokespecial 23	java/lang/StringBuilder:<init>	()V
      //   16: aload_0
      //   17: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   20: ldc 29
      //   22: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   25: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   28: astore 11
      //   30: iconst_1
      //   31: istore_2
      //   32: aconst_null
      //   33: astore 5
      //   35: aconst_null
      //   36: astore 6
      //   38: aconst_null
      //   39: astore 9
      //   41: aconst_null
      //   42: astore 8
      //   44: aconst_null
      //   45: astore 7
      //   47: aload 11
      //   49: invokestatic 95	com/tencent/mm/modelsfs/FileOp:aO	(Ljava/lang/String;)Z
      //   52: ifne +30 -> 82
      //   55: ldc 78
      //   57: ldc 97
      //   59: iconst_1
      //   60: anewarray 4	java/lang/Object
      //   63: dup
      //   64: iconst_0
      //   65: aload 11
      //   67: aastore
      //   68: invokestatic 101	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   71: ldc2_w 91
      //   74: sipush 2792
      //   77: invokestatic 41	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   80: aconst_null
      //   81: areturn
      //   82: aload 11
      //   84: invokestatic 105	com/tencent/mm/modelsfs/FileOp:kj	(Ljava/lang/String;)J
      //   87: l2i
      //   88: istore_1
      //   89: iload_1
      //   90: ifle +15 -> 105
      //   93: iload_1
      //   94: ldc 106
      //   96: if_icmpeq +48 -> 144
      //   99: iload_1
      //   100: ldc 107
      //   102: if_icmpeq +42 -> 144
      //   105: aload_0
      //   106: invokestatic 109	com/tencent/mm/x/d$b:dd	(Ljava/lang/String;)Z
      //   109: pop
      //   110: ldc 78
      //   112: ldc 111
      //   114: iconst_2
      //   115: anewarray 4	java/lang/Object
      //   118: dup
      //   119: iconst_0
      //   120: iload_1
      //   121: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   124: aastore
      //   125: dup
      //   126: iconst_1
      //   127: aload 11
      //   129: aastore
      //   130: invokestatic 120	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   133: ldc2_w 91
      //   136: sipush 2792
      //   139: invokestatic 41	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   142: aconst_null
      //   143: areturn
      //   144: aload 11
      //   146: invokestatic 124	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
      //   149: astore 10
      //   151: aload 10
      //   153: astore 5
      //   155: aload 9
      //   157: astore 6
      //   159: aload 8
      //   161: astore 7
      //   163: aload 5
      //   165: invokestatic 130	java/nio/channels/Channels:newChannel	(Ljava/io/InputStream;)Ljava/nio/channels/ReadableByteChannel;
      //   168: astore 8
      //   170: aload 8
      //   172: astore 6
      //   174: aload 8
      //   176: astore 7
      //   178: ldc 106
      //   180: invokestatic 136	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
      //   183: astore 9
      //   185: aload 8
      //   187: astore 6
      //   189: aload 8
      //   191: astore 7
      //   193: aload 8
      //   195: aload 9
      //   197: invokeinterface 142 2 0
      //   202: pop
      //   203: aload 8
      //   205: astore 6
      //   207: aload 8
      //   209: astore 7
      //   211: aload 9
      //   213: iconst_0
      //   214: invokevirtual 146	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
      //   217: pop
      //   218: iload_1
      //   219: ldc 107
      //   221: if_icmpne +149 -> 370
      //   224: aload 8
      //   226: astore 6
      //   228: aload 8
      //   230: astore 7
      //   232: bipush 16
      //   234: invokestatic 136	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
      //   237: astore 10
      //   239: aload 8
      //   241: astore 6
      //   243: aload 8
      //   245: astore 7
      //   247: aload 8
      //   249: aload 10
      //   251: invokeinterface 142 2 0
      //   256: pop
      //   257: aload 8
      //   259: astore 6
      //   261: aload 8
      //   263: astore 7
      //   265: aload 10
      //   267: iconst_0
      //   268: invokevirtual 150	java/nio/ByteBuffer:getLong	(I)J
      //   271: lstore_3
      //   272: lload_3
      //   273: lconst_1
      //   274: lcmp
      //   275: ifeq +93 -> 368
      //   278: aload 8
      //   280: astore 6
      //   282: aload 8
      //   284: astore 7
      //   286: ldc 78
      //   288: ldc -104
      //   290: iconst_3
      //   291: anewarray 4	java/lang/Object
      //   294: dup
      //   295: iconst_0
      //   296: lload_3
      //   297: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   300: aastore
      //   301: dup
      //   302: iconst_1
      //   303: iload_1
      //   304: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   307: aastore
      //   308: dup
      //   309: iconst_2
      //   310: aload 11
      //   312: aastore
      //   313: invokestatic 120	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   316: aload 8
      //   318: astore 6
      //   320: aload 8
      //   322: astore 7
      //   324: aload 8
      //   326: invokeinterface 158 1 0
      //   331: aload 8
      //   333: astore 6
      //   335: aload 8
      //   337: astore 7
      //   339: aload 5
      //   341: invokevirtual 161	java/io/InputStream:close	()V
      //   344: aload 8
      //   346: astore 6
      //   348: aload 8
      //   350: astore 7
      //   352: aload_0
      //   353: invokestatic 109	com/tencent/mm/x/d$b:dd	(Ljava/lang/String;)Z
      //   356: pop
      //   357: ldc2_w 91
      //   360: sipush 2792
      //   363: invokestatic 41	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   366: aconst_null
      //   367: areturn
      //   368: iconst_0
      //   369: istore_2
      //   370: aload 8
      //   372: astore 6
      //   374: aload 8
      //   376: astore 7
      //   378: ldc 78
      //   380: ldc -93
      //   382: iconst_3
      //   383: anewarray 4	java/lang/Object
      //   386: dup
      //   387: iconst_0
      //   388: iload_1
      //   389: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   392: aastore
      //   393: dup
      //   394: iconst_1
      //   395: iload_2
      //   396: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   399: aastore
      //   400: dup
      //   401: iconst_2
      //   402: aload 11
      //   404: aastore
      //   405: invokestatic 171	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   408: aload 8
      //   410: astore 6
      //   412: aload 8
      //   414: astore 7
      //   416: aload 8
      //   418: invokeinterface 158 1 0
      //   423: aload 5
      //   425: astore 6
      //   427: aload 5
      //   429: invokevirtual 161	java/io/InputStream:close	()V
      //   432: aconst_null
      //   433: astore_0
      //   434: aload_0
      //   435: astore 6
      //   437: bipush 96
      //   439: bipush 96
      //   441: getstatic 177	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
      //   444: invokestatic 181	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
      //   447: astore 5
      //   449: aload_0
      //   450: astore 6
      //   452: aload 5
      //   454: aload 9
      //   456: invokevirtual 185	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
      //   459: iload_2
      //   460: ifeq +63 -> 523
      //   463: aload_0
      //   464: astore 6
      //   466: aload 5
      //   468: bipush 9
      //   470: bipush 9
      //   472: bipush 78
      //   474: bipush 78
      //   476: invokestatic 188	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
      //   479: astore 7
      //   481: aload_0
      //   482: astore 6
      //   484: ldc 78
      //   486: ldc -66
      //   488: iconst_1
      //   489: anewarray 4	java/lang/Object
      //   492: dup
      //   493: iconst_0
      //   494: aload 5
      //   496: invokevirtual 191	java/lang/Object:toString	()Ljava/lang/String;
      //   499: aastore
      //   500: invokestatic 193	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   503: aload_0
      //   504: astore 6
      //   506: aload 5
      //   508: invokevirtual 196	android/graphics/Bitmap:recycle	()V
      //   511: ldc2_w 91
      //   514: sipush 2792
      //   517: invokestatic 41	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   520: aload 7
      //   522: areturn
      //   523: ldc2_w 91
      //   526: sipush 2792
      //   529: invokestatic 41	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   532: aload 5
      //   534: areturn
      //   535: astore 6
      //   537: aload 7
      //   539: astore_0
      //   540: ldc 78
      //   542: ldc -58
      //   544: iconst_2
      //   545: anewarray 4	java/lang/Object
      //   548: dup
      //   549: iconst_0
      //   550: aload 6
      //   552: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   555: aastore
      //   556: dup
      //   557: iconst_1
      //   558: aload 11
      //   560: aastore
      //   561: invokestatic 120	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   564: aload_0
      //   565: ifnull +9 -> 574
      //   568: aload_0
      //   569: invokeinterface 158 1 0
      //   574: aload 5
      //   576: ifnull +8 -> 584
      //   579: aload 5
      //   581: invokevirtual 161	java/io/InputStream:close	()V
      //   584: ldc2_w 91
      //   587: sipush 2792
      //   590: invokestatic 41	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   593: aconst_null
      //   594: areturn
      //   595: astore 7
      //   597: aconst_null
      //   598: astore 5
      //   600: aload 6
      //   602: astore_0
      //   603: ldc 78
      //   605: ldc -53
      //   607: iconst_2
      //   608: anewarray 4	java/lang/Object
      //   611: dup
      //   612: iconst_0
      //   613: aload 7
      //   615: invokevirtual 204	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
      //   618: aastore
      //   619: dup
      //   620: iconst_1
      //   621: aload 11
      //   623: aastore
      //   624: invokestatic 120	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   627: goto -63 -> 564
      //   630: astore_0
      //   631: goto -47 -> 584
      //   634: astore 7
      //   636: aload 6
      //   638: astore_0
      //   639: goto -36 -> 603
      //   642: astore 7
      //   644: aconst_null
      //   645: astore_0
      //   646: aload 6
      //   648: astore 5
      //   650: goto -47 -> 603
      //   653: astore 6
      //   655: aload 7
      //   657: astore_0
      //   658: goto -118 -> 540
      //   661: astore 6
      //   663: aconst_null
      //   664: astore_0
      //   665: goto -125 -> 540
      //   668: astore 6
      //   670: aconst_null
      //   671: astore_0
      //   672: aconst_null
      //   673: astore 5
      //   675: goto -135 -> 540
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	678	0	paramString	String
      //   88	301	1	i	int
      //   31	429	2	bool	boolean
      //   271	26	3	l	long
      //   33	641	5	localObject1	Object
      //   36	469	6	localObject2	Object
      //   535	112	6	localException1	Exception
      //   653	1	6	localException2	Exception
      //   661	1	6	localException3	Exception
      //   668	1	6	localException4	Exception
      //   45	493	7	localObject3	Object
      //   595	19	7	localOutOfMemoryError1	OutOfMemoryError
      //   634	1	7	localOutOfMemoryError2	OutOfMemoryError
      //   642	14	7	localOutOfMemoryError3	OutOfMemoryError
      //   42	375	8	localReadableByteChannel	java.nio.channels.ReadableByteChannel
      //   39	416	9	localByteBuffer	java.nio.ByteBuffer
      //   149	117	10	localObject4	Object
      //   28	594	11	str	String
      // Exception table:
      //   from	to	target	type
      //   47	71	535	java/lang/Exception
      //   82	89	535	java/lang/Exception
      //   105	133	535	java/lang/Exception
      //   144	151	535	java/lang/Exception
      //   47	71	595	java/lang/OutOfMemoryError
      //   82	89	595	java/lang/OutOfMemoryError
      //   105	133	595	java/lang/OutOfMemoryError
      //   144	151	595	java/lang/OutOfMemoryError
      //   568	574	630	java/lang/Exception
      //   579	584	630	java/lang/Exception
      //   163	170	634	java/lang/OutOfMemoryError
      //   178	185	634	java/lang/OutOfMemoryError
      //   193	203	634	java/lang/OutOfMemoryError
      //   211	218	634	java/lang/OutOfMemoryError
      //   232	239	634	java/lang/OutOfMemoryError
      //   247	257	634	java/lang/OutOfMemoryError
      //   265	272	634	java/lang/OutOfMemoryError
      //   286	316	634	java/lang/OutOfMemoryError
      //   324	331	634	java/lang/OutOfMemoryError
      //   339	344	634	java/lang/OutOfMemoryError
      //   352	357	634	java/lang/OutOfMemoryError
      //   378	408	634	java/lang/OutOfMemoryError
      //   416	423	634	java/lang/OutOfMemoryError
      //   427	432	642	java/lang/OutOfMemoryError
      //   437	449	642	java/lang/OutOfMemoryError
      //   452	459	642	java/lang/OutOfMemoryError
      //   466	481	642	java/lang/OutOfMemoryError
      //   484	503	642	java/lang/OutOfMemoryError
      //   506	511	642	java/lang/OutOfMemoryError
      //   163	170	653	java/lang/Exception
      //   178	185	653	java/lang/Exception
      //   193	203	653	java/lang/Exception
      //   211	218	653	java/lang/Exception
      //   232	239	653	java/lang/Exception
      //   247	257	653	java/lang/Exception
      //   265	272	653	java/lang/Exception
      //   286	316	653	java/lang/Exception
      //   324	331	653	java/lang/Exception
      //   339	344	653	java/lang/Exception
      //   352	357	653	java/lang/Exception
      //   378	408	653	java/lang/Exception
      //   416	423	653	java/lang/Exception
      //   427	432	661	java/lang/Exception
      //   437	449	668	java/lang/Exception
      //   452	459	668	java/lang/Exception
      //   466	481	668	java/lang/Exception
      //   484	503	668	java/lang/Exception
      //   506	511	668	java/lang/Exception
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */