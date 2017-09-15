package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.svg.b.b;
import com.tencent.mm.svg.b.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
{
  private static Class<?> fwO;
  private static c<Drawable.ConstantState> uLA;
  private static c<Drawable.ConstantState> uLB;
  protected static Application uLC;
  protected static String uLD;
  protected static Class<d> uLE;
  public static boolean uLw;
  private static a uLx;
  private static LongSparseArray<Drawable.ConstantState>[] uLy;
  private static LongSparseArray<Drawable.ConstantState> uLz;
  
  static
  {
    GMTrace.i(3489124057088L, 25996);
    uLw = false;
    fwO = null;
    GMTrace.o(3489124057088L, 25996);
  }
  
  @TargetApi(16)
  public static void a(Application paramApplication, Resources paramResources, int paramInt, TypedValue paramTypedValue)
  {
    GMTrace.i(16088947490816L, 119872);
    if (paramInt == 0)
    {
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "preloadDrawable Why this id is %d. TypedValue %s", new Object[] { Integer.valueOf(paramInt), paramTypedValue });
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
    }
    paramResources.getValue(paramInt, paramTypedValue, true);
    long l1 = paramTypedValue.assetCookie;
    long l2 = paramTypedValue.data;
    paramApplication = new b(paramInt, paramApplication.getResources());
    uLz.put(l1 << 32 | l2, paramApplication);
    GMTrace.o(16088947490816L, 119872);
  }
  
  private static void a(Application paramApplication, Class<d> paramClass)
  {
    GMTrace.i(3488318750720L, 25990);
    uLC = paramApplication;
    uLE = paramClass;
    try
    {
      Class localClass = uLE;
      if (localClass == null)
      {
        GMTrace.o(3488318750720L, 25990);
        return;
      }
      ((d)paramClass.newInstance()).load(e(paramApplication));
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVGCode wrapper size %s", new Object[] { Integer.valueOf(e(paramApplication).uLh.size()) });
      uLw = true;
      GMTrace.o(3488318750720L, 25990);
      return;
    }
    catch (Resources.NotFoundException paramApplication)
    {
      com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramApplication, "We found one NotFoundException.", new Object[0]);
      uLw = false;
      GMTrace.o(3488318750720L, 25990);
    }
  }
  
  @TargetApi(16)
  private static void a(Context paramContext, Object paramObject)
  {
    GMTrace.i(3488184532992L, 25989);
    paramObject = new com.tencent.mm.svg.b.a(paramObject, "sPreloadedDrawables").get();
    if (paramObject != null)
    {
      int i;
      long l;
      if ((paramObject instanceof LongSparseArray[]))
      {
        uLy = (LongSparseArray[])paramObject;
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", new Object[] { uLy[0] });
        i = 0;
        while (i < uLy[0].size())
        {
          l = uLy[0].keyAt(i);
          uLA.put(l, uLy[0].get(l));
          i += 1;
        }
        i = 0;
        while (i < uLy[1].size())
        {
          l = uLy[1].keyAt(i);
          uLB.put(l, uLy[1].get(l));
          i += 1;
        }
        uLy[0] = uLA;
        uLy[1] = uLB;
        GMTrace.o(3488184532992L, 25989);
        return;
      }
      if ((paramObject instanceof LongSparseArray))
      {
        paramContext = new com.tencent.mm.svg.b.a(paramContext.getResources(), "sPreloadedDrawables");
        paramObject = (LongSparseArray)paramContext.get();
        i = 0;
        while (i < ((LongSparseArray)paramObject).size())
        {
          l = ((LongSparseArray)paramObject).keyAt(i);
          uLA.put(l, ((LongSparseArray)paramObject).get(l));
          i += 1;
        }
        paramObject = uLA;
        paramContext.prepare();
        if (paramContext.gRL == null) {
          throw new NoSuchFieldException();
        }
        paramContext.gRL.set(paramContext.obj, paramObject);
        if (paramContext.get() == null) {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
        }
        GMTrace.o(3488184532992L, 25989);
        return;
      }
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
      GMTrace.o(3488184532992L, 25989);
      return;
    }
    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
    GMTrace.o(3488184532992L, 25989);
  }
  
  public static void a(c.a parama)
  {
    GMTrace.i(3487647662080L, 25985);
    com.tencent.mm.svg.b.c.b(parama);
    GMTrace.o(3487647662080L, 25985);
  }
  
  /* Error */
  public static void b(Application paramApplication, String paramString)
  {
    // Byte code:
    //   0: ldc2_w 243
    //   3: ldc -11
    //   5: invokestatic 46	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: iconst_0
    //   9: istore 7
    //   11: iconst_0
    //   12: istore 8
    //   14: iconst_0
    //   15: istore 9
    //   17: iconst_0
    //   18: istore 6
    //   20: aload_1
    //   21: putstatic 247	com/tencent/mm/svg/a/e:uLD	Ljava/lang/String;
    //   24: aload_1
    //   25: invokestatic 253	com/tencent/mm/svg/a/a:bl	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokestatic 256	com/tencent/mm/svg/b/b:bl	(Ljava/lang/String;)V
    //   32: new 258	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   39: aload_1
    //   40: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 265
    //   46: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_0
    //   54: putstatic 130	com/tencent/mm/svg/a/e:uLC	Landroid/app/Application;
    //   57: iload 6
    //   59: istore_3
    //   60: iload 7
    //   62: istore 4
    //   64: iload 8
    //   66: istore 5
    //   68: iload 9
    //   70: istore_2
    //   71: ldc 63
    //   73: ldc_w 271
    //   76: iconst_0
    //   77: anewarray 4	java/lang/Object
    //   80: invokestatic 90	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: iload 6
    //   85: istore_3
    //   86: iload 7
    //   88: istore 4
    //   90: iload 8
    //   92: istore 5
    //   94: iload 9
    //   96: istore_2
    //   97: aload_1
    //   98: invokestatic 275	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   101: astore 12
    //   103: iload 6
    //   105: istore_3
    //   106: iload 7
    //   108: istore 4
    //   110: iload 8
    //   112: istore 5
    //   114: iload 9
    //   116: istore_2
    //   117: invokestatic 281	java/lang/System:nanoTime	()J
    //   120: lstore 10
    //   122: iload 6
    //   124: istore_3
    //   125: iload 7
    //   127: istore 4
    //   129: iload 8
    //   131: istore 5
    //   133: iload 9
    //   135: istore_2
    //   136: aload_0
    //   137: invokestatic 285	com/tencent/mm/svg/a/e:ey	(Landroid/content/Context;)V
    //   140: iload 6
    //   142: istore_3
    //   143: iload 7
    //   145: istore 4
    //   147: iload 8
    //   149: istore 5
    //   151: iload 9
    //   153: istore_2
    //   154: aload_0
    //   155: aload 12
    //   157: invokestatic 287	com/tencent/mm/svg/a/e:a	(Landroid/app/Application;Ljava/lang/Class;)V
    //   160: iconst_1
    //   161: istore 4
    //   163: iconst_1
    //   164: istore 5
    //   166: iconst_1
    //   167: istore_2
    //   168: iconst_1
    //   169: istore_3
    //   170: ldc 63
    //   172: ldc_w 289
    //   175: iconst_1
    //   176: anewarray 4	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: invokestatic 281	java/lang/System:nanoTime	()J
    //   184: lload 10
    //   186: lsub
    //   187: ldc2_w 290
    //   190: ldiv
    //   191: invokestatic 296	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: aastore
    //   195: invokestatic 90	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: ldc2_w 243
    //   201: ldc -11
    //   203: invokestatic 53	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   206: return
    //   207: astore 12
    //   209: iload_3
    //   210: istore_2
    //   211: ldc 63
    //   213: ldc_w 298
    //   216: iconst_1
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_1
    //   223: aastore
    //   224: invokestatic 77	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: iload_3
    //   228: ifne +301 -> 529
    //   231: ldc 63
    //   233: ldc_w 300
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 90	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: invokestatic 281	java/lang/System:nanoTime	()J
    //   246: lstore 10
    //   248: aload_0
    //   249: invokestatic 285	com/tencent/mm/svg/a/e:ey	(Landroid/content/Context;)V
    //   252: aload_0
    //   253: invokestatic 304	com/tencent/mm/svg/a/e:f	(Landroid/app/Application;)V
    //   256: ldc 63
    //   258: ldc_w 306
    //   261: iconst_1
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: invokestatic 281	java/lang/System:nanoTime	()J
    //   270: lload 10
    //   272: lsub
    //   273: ldc2_w 290
    //   276: ldiv
    //   277: invokestatic 296	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   280: aastore
    //   281: invokestatic 90	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: ldc2_w 243
    //   287: ldc -11
    //   289: invokestatic 53	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   292: return
    //   293: astore 12
    //   295: iload 4
    //   297: istore_2
    //   298: ldc 63
    //   300: ldc_w 308
    //   303: iconst_1
    //   304: anewarray 4	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: aload_1
    //   310: aastore
    //   311: invokestatic 77	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: iload 4
    //   316: ifne +213 -> 529
    //   319: ldc 63
    //   321: ldc_w 300
    //   324: iconst_0
    //   325: anewarray 4	java/lang/Object
    //   328: invokestatic 90	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: invokestatic 281	java/lang/System:nanoTime	()J
    //   334: lstore 10
    //   336: aload_0
    //   337: invokestatic 285	com/tencent/mm/svg/a/e:ey	(Landroid/content/Context;)V
    //   340: aload_0
    //   341: invokestatic 304	com/tencent/mm/svg/a/e:f	(Landroid/app/Application;)V
    //   344: ldc 63
    //   346: ldc_w 306
    //   349: iconst_1
    //   350: anewarray 4	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: invokestatic 281	java/lang/System:nanoTime	()J
    //   358: lload 10
    //   360: lsub
    //   361: ldc2_w 290
    //   364: ldiv
    //   365: invokestatic 296	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: invokestatic 90	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   372: ldc2_w 243
    //   375: ldc -11
    //   377: invokestatic 53	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   380: return
    //   381: astore 12
    //   383: iload 5
    //   385: istore_2
    //   386: ldc 63
    //   388: ldc_w 310
    //   391: iconst_1
    //   392: anewarray 4	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: aload_1
    //   398: aastore
    //   399: invokestatic 77	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: iload 5
    //   404: ifne +125 -> 529
    //   407: ldc 63
    //   409: ldc_w 300
    //   412: iconst_0
    //   413: anewarray 4	java/lang/Object
    //   416: invokestatic 90	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: invokestatic 281	java/lang/System:nanoTime	()J
    //   422: lstore 10
    //   424: aload_0
    //   425: invokestatic 285	com/tencent/mm/svg/a/e:ey	(Landroid/content/Context;)V
    //   428: aload_0
    //   429: invokestatic 304	com/tencent/mm/svg/a/e:f	(Landroid/app/Application;)V
    //   432: ldc 63
    //   434: ldc_w 306
    //   437: iconst_1
    //   438: anewarray 4	java/lang/Object
    //   441: dup
    //   442: iconst_0
    //   443: invokestatic 281	java/lang/System:nanoTime	()J
    //   446: lload 10
    //   448: lsub
    //   449: ldc2_w 290
    //   452: ldiv
    //   453: invokestatic 296	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   456: aastore
    //   457: invokestatic 90	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   460: ldc2_w 243
    //   463: ldc -11
    //   465: invokestatic 53	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   468: return
    //   469: astore_1
    //   470: iload_2
    //   471: ifne +56 -> 527
    //   474: ldc 63
    //   476: ldc_w 300
    //   479: iconst_0
    //   480: anewarray 4	java/lang/Object
    //   483: invokestatic 90	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   486: invokestatic 281	java/lang/System:nanoTime	()J
    //   489: lstore 10
    //   491: aload_0
    //   492: invokestatic 285	com/tencent/mm/svg/a/e:ey	(Landroid/content/Context;)V
    //   495: aload_0
    //   496: invokestatic 304	com/tencent/mm/svg/a/e:f	(Landroid/app/Application;)V
    //   499: ldc 63
    //   501: ldc_w 306
    //   504: iconst_1
    //   505: anewarray 4	java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: invokestatic 281	java/lang/System:nanoTime	()J
    //   513: lload 10
    //   515: lsub
    //   516: ldc2_w 290
    //   519: ldiv
    //   520: invokestatic 296	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   523: aastore
    //   524: invokestatic 90	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   527: aload_1
    //   528: athrow
    //   529: ldc2_w 243
    //   532: ldc -11
    //   534: invokestatic 53	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   537: return
    //   538: astore_0
    //   539: goto -283 -> 256
    //   542: astore_0
    //   543: goto -199 -> 344
    //   546: astore_0
    //   547: goto -115 -> 432
    //   550: astore_0
    //   551: goto -52 -> 499
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	paramApplication	Application
    //   0	554	1	paramString	String
    //   70	401	2	i	int
    //   59	169	3	j	int
    //   62	253	4	k	int
    //   66	337	5	m	int
    //   18	123	6	n	int
    //   9	135	7	i1	int
    //   12	136	8	i2	int
    //   15	137	9	i3	int
    //   120	394	10	l	long
    //   101	55	12	localClass	Class
    //   207	1	12	localClassNotFoundException	ClassNotFoundException
    //   293	1	12	localInstantiationException	InstantiationException
    //   381	1	12	localIllegalAccessException	IllegalAccessException
    // Exception table:
    //   from	to	target	type
    //   71	83	207	java/lang/ClassNotFoundException
    //   97	103	207	java/lang/ClassNotFoundException
    //   117	122	207	java/lang/ClassNotFoundException
    //   136	140	207	java/lang/ClassNotFoundException
    //   154	160	207	java/lang/ClassNotFoundException
    //   170	198	207	java/lang/ClassNotFoundException
    //   71	83	293	java/lang/InstantiationException
    //   97	103	293	java/lang/InstantiationException
    //   117	122	293	java/lang/InstantiationException
    //   136	140	293	java/lang/InstantiationException
    //   154	160	293	java/lang/InstantiationException
    //   170	198	293	java/lang/InstantiationException
    //   71	83	381	java/lang/IllegalAccessException
    //   97	103	381	java/lang/IllegalAccessException
    //   117	122	381	java/lang/IllegalAccessException
    //   136	140	381	java/lang/IllegalAccessException
    //   154	160	381	java/lang/IllegalAccessException
    //   170	198	381	java/lang/IllegalAccessException
    //   71	83	469	finally
    //   97	103	469	finally
    //   117	122	469	finally
    //   136	140	469	finally
    //   154	160	469	finally
    //   170	198	469	finally
    //   211	227	469	finally
    //   298	314	469	finally
    //   386	402	469	finally
    //   252	256	538	java/lang/ClassNotFoundException
    //   340	344	542	java/lang/ClassNotFoundException
    //   428	432	546	java/lang/ClassNotFoundException
    //   495	499	550	java/lang/ClassNotFoundException
  }
  
  private static Class<?> bNN()
  {
    GMTrace.i(3488452968448L, 25991);
    Class localClass1;
    if (fwO != null)
    {
      localClass1 = fwO;
      GMTrace.o(3488452968448L, 25991);
      return localClass1;
    }
    try
    {
      localClass1 = Class.forName(uLD + ".R$raw");
      if (localClass1 != null)
      {
        GMTrace.o(3488452968448L, 25991);
        return localClass1;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass2 = b.bNR();
      if (localClass2 != null)
      {
        GMTrace.o(3488452968448L, 25991);
        return localClass2;
      }
      GMTrace.o(3488452968448L, 25991);
    }
    return null;
  }
  
  public static void bNO()
  {
    GMTrace.i(16089081708544L, 119873);
    try
    {
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Reach here, why?", new Object[0]);
      if (uLE == null)
      {
        f(uLC);
        GMTrace.o(16089081708544L, 119873);
        return;
      }
      a(uLC, uLE);
      GMTrace.o(16089081708544L, 119873);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", localClassNotFoundException, "", new Object[0]);
      GMTrace.o(16089081708544L, 119873);
      return;
    }
    catch (InstantiationException localInstantiationException)
    {
      com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", localInstantiationException, "", new Object[0]);
      GMTrace.o(16089081708544L, 119873);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", localIllegalAccessException, "", new Object[0]);
      GMTrace.o(16089081708544L, 119873);
    }
  }
  
  public static void d(Class<?> paramClass)
  {
    GMTrace.i(3487513444352L, 25984);
    fwO = paramClass;
    GMTrace.o(3487513444352L, 25984);
  }
  
  private static a e(Application paramApplication)
  {
    GMTrace.i(3487916097536L, 25987);
    if (uLx == null) {
      uLx = new a(a.bNJ(), paramApplication);
    }
    paramApplication = uLx;
    GMTrace.o(3487916097536L, 25987);
    return paramApplication;
  }
  
  @TargetApi(16)
  private static void ey(Context paramContext)
  {
    int i = 1;
    GMTrace.i(3488050315264L, 25988);
    if (uLA == null) {
      try
      {
        uLz = new LongSparseArray();
        Object localObject = new c();
        uLA = (c)localObject;
        ((c)localObject).uLz = uLz;
        localObject = new c();
        uLB = (c)localObject;
        ((c)localObject).uLz = uLz;
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = new com.tencent.mm.svg.b.a(paramContext.getResources(), "mResourcesImpl");
          ((com.tencent.mm.svg.b.a)localObject).prepare();
          if (((com.tencent.mm.svg.b.a)localObject).gRL != null)
          {
            if (i == 0) {
              break label147;
            }
            localObject = ((com.tencent.mm.svg.b.a)localObject).get();
          }
        }
        for (;;)
        {
          a(paramContext, localObject);
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG this resources %s", new Object[] { paramContext.getResources() });
          GMTrace.o(3488050315264L, 25988);
          return;
          i = 0;
          break;
          label147:
          localObject = paramContext.getResources();
          continue;
          localObject = paramContext.getResources();
        }
        GMTrace.o(3488050315264L, 25988);
      }
      catch (NoSuchFieldException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
        GMTrace.o(3488050315264L, 25988);
        return;
      }
      catch (IllegalAccessException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
        GMTrace.o(3488050315264L, 25988);
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : IllegalArgumentException.", new Object[0]);
      }
    }
  }
  
  private static void f(Application paramApplication)
  {
    GMTrace.i(3488587186176L, 25992);
    Object localObject = bNN();
    if (localObject == null)
    {
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
      GMTrace.o(3488587186176L, 25992);
      return;
    }
    localObject = ((Class)localObject).getDeclaredFields();
    a locala = e(paramApplication);
    try
    {
      a locala1 = new a();
      int i = 0;
      while (i < localObject.length)
      {
        int j = localObject[i].getInt(null);
        if (locala1.d(paramApplication.getResources(), j)) {
          a(locala.uLF, locala.Cu, j, locala.uLc);
        }
        i += 1;
      }
      uLw = true;
    }
    catch (IllegalAccessException paramApplication)
    {
      uLw = false;
      GMTrace.o(3488587186176L, 25992);
      return;
    }
    catch (IllegalArgumentException paramApplication)
    {
      uLw = false;
      GMTrace.o(3488587186176L, 25992);
      return;
    }
    GMTrace.o(3488587186176L, 25992);
  }
  
  public static final class a
  {
    Resources Cu;
    Application uLF;
    TypedValue uLc;
    Map<Integer, com.tencent.mm.svg.c> uLh;
    
    public a(Map<Integer, com.tencent.mm.svg.c> paramMap, Application paramApplication)
    {
      GMTrace.i(3484292218880L, 25960);
      this.uLc = new TypedValue();
      this.uLh = paramMap;
      this.uLF = paramApplication;
      this.Cu = paramApplication.getResources();
      GMTrace.o(3484292218880L, 25960);
    }
    
    public final void a(Integer paramInteger, com.tencent.mm.svg.c paramc)
    {
      GMTrace.i(15699716079616L, 116972);
      this.uLh.put(paramInteger, paramc);
      e.a(this.uLF, this.Cu, paramInteger.intValue(), this.uLc);
      GMTrace.o(15699716079616L, 116972);
    }
  }
  
  protected static final class b
    extends Drawable.ConstantState
  {
    private Resources Cu;
    private int rba;
    
    public b(int paramInt, Resources paramResources)
    {
      GMTrace.i(3484560654336L, 25962);
      this.rba = 0;
      if (paramInt == 0)
      {
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", new Object[] { Integer.valueOf(paramInt) });
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
      }
      this.rba = paramInt;
      this.Cu = paramResources;
      GMTrace.o(3484560654336L, 25962);
    }
    
    public final int getChangingConfigurations()
    {
      GMTrace.i(3484829089792L, 25964);
      GMTrace.o(3484829089792L, 25964);
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      GMTrace.i(3484694872064L, 25963);
      Drawable localDrawable = a.c(this.Cu, this.rba);
      GMTrace.o(3484694872064L, 25963);
      return localDrawable;
    }
  }
  
  @TargetApi(16)
  public static final class c<T>
    extends LongSparseArray<T>
  {
    public static boolean uLG;
    LongSparseArray<T> uLz;
    
    static
    {
      GMTrace.i(3485634396160L, 25970);
      uLG = false;
      GMTrace.o(3485634396160L, 25970);
    }
    
    public c()
    {
      GMTrace.i(3484963307520L, 25965);
      this.uLz = null;
      GMTrace.o(3484963307520L, 25965);
    }
    
    public final void clear()
    {
      GMTrace.i(3485500178432L, 25969);
      super.clear();
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
      GMTrace.o(3485500178432L, 25969);
    }
    
    public final void delete(long paramLong)
    {
      GMTrace.i(3485231742976L, 25967);
      super.delete(paramLong);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", new Object[] { Long.valueOf(paramLong) });
      GMTrace.o(3485231742976L, 25967);
    }
    
    public final T get(long paramLong, T paramT)
    {
      GMTrace.i(3485097525248L, 25966);
      if (this.uLz.indexOfKey(paramLong) >= 0)
      {
        if (!e.uLw) {
          e.bNO();
        }
        paramT = this.uLz.get(paramLong, paramT);
        GMTrace.o(3485097525248L, 25966);
        return paramT;
      }
      paramT = super.get(paramLong, paramT);
      GMTrace.o(3485097525248L, 25966);
      return paramT;
    }
    
    public final void remove(long paramLong)
    {
      GMTrace.i(3485365960704L, 25968);
      super.remove(paramLong);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", new Object[] { Long.valueOf(paramLong) });
      GMTrace.o(3485365960704L, 25968);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/svg/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */