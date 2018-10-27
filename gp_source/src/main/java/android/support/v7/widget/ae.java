package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.d.a.l;
import android.support.v4.content.d;
import android.support.v4.g.h;
import android.support.v4.g.i;
import android.support.v4.g.v;
import android.support.v4.g.w;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ae
{
  private static final int[] a;
  private static final int[] b;
  private static final int[] c;
  private static final ah d;
  private static final PorterDuff.Mode e = PorterDuff.Mode.SRC_IN;
  private static ae f;
  private static final int[] g = { 2131230778, 2131230783 };
  private static final int[] h;
  private static final int[] i;
  private android.support.v4.g.a j;
  private final WeakHashMap k = new WeakHashMap(0);
  private boolean l;
  private w m;
  private WeakHashMap n;
  private TypedValue o;
  
  static
  {
    d = new ah();
    c = new int[] { 2131230856, 2131230854, 2131230775 };
    h = new int[] { 2131230797, 2131230838, 2131230804, 2131230799, 2131230800, 2131230803, 2131230802 };
    b = new int[] { 2131230853, 2131230855, 2131230790, 2131230846, 2131230847, 2131230849, 2131230851, 2131230848, 2131230850, 2131230852 };
    a = new int[] { 2131230828, 2131230788, 2131230827 };
    i = new int[] { 2131230844, 2131230857 };
  }
  
  private static long a(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  public static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      PorterDuffColorFilter localPorterDuffColorFilter2 = (PorterDuffColorFilter)d.a(Integer.valueOf(ah.a(paramInt, paramMode)));
      PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
      if (localPorterDuffColorFilter2 == null)
      {
        localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
        d.a(Integer.valueOf(ah.a(paramInt, paramMode)), localPorterDuffColorFilter1);
      }
      return localPorterDuffColorFilter1;
    }
    finally {}
  }
  
  private final Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject = b(paramContext, paramInt);
    if (localObject == null)
    {
      if (paramInt == 2131230839)
      {
        localObject = (LayerDrawable)paramDrawable;
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), ha.a(paramContext, 2130968785), e);
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), ha.a(paramContext, 2130968785), e);
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), ha.a(paramContext, 2130968783), e);
        localObject = paramDrawable;
      }
      do
      {
        do
        {
          return (Drawable)localObject;
          if (paramInt == 2131230830) {}
          while ((paramInt == 2131230829) || (paramInt == 2131230831))
          {
            localObject = (LayerDrawable)paramDrawable;
            a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), ha.c(paramContext, 2130968785), e);
            a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), ha.a(paramContext, 2130968783), e);
            a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), ha.a(paramContext, 2130968783), e);
            return paramDrawable;
          }
          localObject = paramDrawable;
        } while (a(paramContext, paramInt, paramDrawable));
        localObject = paramDrawable;
      } while (!paramBoolean);
      return null;
    }
    paramContext = paramDrawable;
    if (bw.c(paramDrawable)) {
      paramContext = paramDrawable.mutate();
    }
    paramDrawable = android.support.v4.a.a.a.f(paramContext);
    android.support.v4.a.a.a.a(paramDrawable, (ColorStateList)localObject);
    if (paramInt == 2131230842) {}
    for (paramContext = PorterDuff.Mode.MULTIPLY;; paramContext = null)
    {
      localObject = paramDrawable;
      if (paramContext == null) {
        break;
      }
      android.support.v4.a.a.a.a(paramDrawable, paramContext);
      return paramDrawable;
    }
  }
  
  /* Error */
  private final Drawable a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 92	android/support/v7/widget/ae:k	Ljava/util/WeakHashMap;
    //   6: aload_1
    //   7: invokevirtual 187	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 189	android/support/v4/g/h
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +60 -> 77
    //   20: aload 4
    //   22: lload_2
    //   23: aconst_null
    //   24: invokevirtual 192	android/support/v4/g/h:a	(JLjava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 194	java/lang/ref/WeakReference
    //   30: astore 5
    //   32: aload 5
    //   34: ifnull +38 -> 72
    //   37: aload 5
    //   39: invokevirtual 197	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   42: checkcast 199	android/graphics/drawable/Drawable$ConstantState
    //   45: astore 5
    //   47: aload 5
    //   49: ifnull +17 -> 66
    //   52: aload 5
    //   54: aload_1
    //   55: invokevirtual 205	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   58: invokevirtual 209	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: aload 4
    //   68: lload_2
    //   69: invokevirtual 212	android/support/v4/g/h:a	(J)V
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -12 -> 62
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -17 -> 62
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	ae
    //   0	87	1	paramContext	Context
    //   0	87	2	paramLong	long
    //   13	54	4	localh	h
    //   30	23	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	82	finally
    //   20	32	82	finally
    //   37	47	82	finally
    //   52	62	82	finally
    //   66	72	82	finally
  }
  
  public static ae a()
  {
    try
    {
      if (f == null)
      {
        localae = new ae();
        f = localae;
        if (Build.VERSION.SDK_INT < 24)
        {
          localae.a("vector", new aj());
          localae.a("animated-vector", new ag());
          localae.a("animated-selector", new af());
        }
      }
      ae localae = f;
      return localae;
    }
    finally {}
  }
  
  private static void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (bw.c(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = e;
    }
    localDrawable.setColorFilter(a(paramInt, paramDrawable));
  }
  
  static void a(Drawable paramDrawable, hd paramhd, int[] paramArrayOfInt)
  {
    Object localObject = null;
    if ((bw.c(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {
      Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }
    label46:
    label57:
    label62:
    label127:
    for (;;)
    {
      return;
      boolean bool = paramhd.a;
      ColorStateList localColorStateList;
      if (bool) {
        if (bool)
        {
          localColorStateList = paramhd.c;
          if (!paramhd.b)
          {
            paramhd = e;
            if (localColorStateList == null) {
              paramDrawable.setColorFilter((ColorFilter)localObject);
            }
          }
        }
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT > 23) {
          break label127;
        }
        paramDrawable.invalidateSelf();
        return;
        if (paramhd == null) {
          break label62;
        }
        localObject = a(localColorStateList.getColorForState(paramArrayOfInt, 0), paramhd);
        break label62;
        paramhd = paramhd.d;
        break label57;
        localColorStateList = null;
        break label46;
        if (paramhd.b) {
          break;
        }
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  private final void a(String paramString, ai paramai)
  {
    if (this.j == null) {
      this.j = new android.support.v4.g.a();
    }
    this.j.put(paramString, paramai);
  }
  
  static boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = e;
    int i2;
    int i1;
    if (a(c, paramInt))
    {
      i2 = 2130968785;
      paramInt = 1;
      i1 = -1;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        Drawable localDrawable = paramDrawable;
        if (bw.c(paramDrawable)) {
          localDrawable = paramDrawable.mutate();
        }
        localDrawable.setColorFilter(a(ha.a(paramContext, i2), localMode));
        if (i1 != -1) {
          localDrawable.setAlpha(i1);
        }
        return true;
      }
      return false;
      if (a(b, paramInt))
      {
        i2 = 2130968783;
        paramInt = 1;
        i1 = -1;
      }
      else if (a(a, paramInt))
      {
        localMode = PorterDuff.Mode.MULTIPLY;
        i1 = -1;
        i2 = 16842801;
        paramInt = 1;
      }
      else if (paramInt == 2131230816)
      {
        i1 = Math.round(40.8F);
        i2 = 16842800;
        paramInt = 1;
      }
      else if (paramInt == 2131230792)
      {
        paramInt = 1;
        i2 = 16842801;
        i1 = -1;
      }
      else
      {
        paramInt = 0;
        i2 = 0;
        i1 = -1;
      }
    }
  }
  
  /* Error */
  private final boolean a(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload 4
    //   4: invokevirtual 310	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   7: astore 7
    //   9: aload 7
    //   11: ifnull +68 -> 79
    //   14: aload_0
    //   15: getfield 92	android/support/v7/widget/ae:k	Ljava/util/WeakHashMap;
    //   18: aload_1
    //   19: invokevirtual 187	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 189	android/support/v4/g/h
    //   25: astore 6
    //   27: aload 6
    //   29: astore 4
    //   31: aload 6
    //   33: ifnonnull +23 -> 56
    //   36: new 189	android/support/v4/g/h
    //   39: dup
    //   40: invokespecial 311	android/support/v4/g/h:<init>	()V
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 92	android/support/v7/widget/ae:k	Ljava/util/WeakHashMap;
    //   49: aload_1
    //   50: aload 4
    //   52: invokevirtual 312	java/util/WeakHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload 4
    //   58: lload_2
    //   59: new 194	java/lang/ref/WeakReference
    //   62: dup
    //   63: aload 7
    //   65: invokespecial 315	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   68: invokevirtual 318	android/support/v4/g/h:b	(JLjava/lang/Object;)V
    //   71: iconst_1
    //   72: istore 5
    //   74: aload_0
    //   75: monitorexit
    //   76: iload 5
    //   78: ireturn
    //   79: iconst_0
    //   80: istore 5
    //   82: goto -8 -> 74
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ae
    //   0	90	1	paramContext	Context
    //   0	90	2	paramLong	long
    //   0	90	4	paramDrawable	Drawable
    //   72	9	5	bool	boolean
    //   25	7	6	localh	h
    //   7	57	7	localConstantState	android.graphics.drawable.Drawable.ConstantState
    // Exception table:
    //   from	to	target	type
    //   2	9	85	finally
    //   14	27	85	finally
    //   36	56	85	finally
    //   56	71	85	finally
  }
  
  private static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int i2 = paramArrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break label34;
      }
      if (paramArrayOfInt[i1] == paramInt) {
        break;
      }
      i1 += 1;
    }
    boolean bool1 = true;
    label34:
    return bool1;
  }
  
  private final Drawable c(Context paramContext, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = this.j;
    Object localObject3 = localObject1;
    TypedValue localTypedValue;
    Object localObject4;
    long l1;
    if (localObject2 != null)
    {
      localObject3 = localObject1;
      if (!((v)localObject2).isEmpty())
      {
        localObject2 = this.m;
        if (localObject2 != null) {
          break label310;
        }
        this.m = new w();
        if (this.o == null) {
          this.o = new TypedValue();
        }
        localTypedValue = this.o;
        localObject4 = paramContext.getResources();
        ((Resources)localObject4).getValue(paramInt, localTypedValue, true);
        l1 = a(localTypedValue);
        localObject2 = a(paramContext, l1);
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (localTypedValue.string != null)
          {
            localObject1 = localObject2;
            if (!localTypedValue.string.toString().endsWith(".xml")) {}
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Resources)localObject4).getXml(paramInt);
        localObject3 = Xml.asAttributeSet((XmlPullParser)localObject1);
        i1 = ((XmlPullParser)localObject1).next();
        if (i1 == 2)
        {
          if (i1 != 2) {
            break label374;
          }
          localObject4 = ((XmlPullParser)localObject1).getName();
          this.m.c(paramInt, localObject4);
          localObject4 = (ai)this.j.get(localObject4);
          if (localObject4 != null)
          {
            localObject1 = ((ai)localObject4).a(paramContext, (XmlPullParser)localObject1, (AttributeSet)localObject3, paramContext.getTheme());
            if (localObject1 == null) {}
          }
        }
      }
      catch (Exception paramContext)
      {
        int i1;
        label310:
        localObject1 = localObject2;
      }
      try
      {
        ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
        a(paramContext, l1, (Drawable)localObject1);
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          this.m.c(paramInt, "appcompat_skip_skip");
          localObject3 = localObject1;
        }
        return (Drawable)localObject3;
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
      continue;
      localObject1 = localObject2;
      continue;
      if (i1 == 1)
      {
        continue;
        localObject2 = (String)((w)localObject2).a(paramInt, null);
        localObject3 = localObject1;
        if (!"appcompat_skip_skip".equals(localObject2))
        {
          if ((localObject2 == null) || (this.j.get(localObject2) != null)) {
            break;
          }
          return null;
          Log.e("AppCompatDrawableManag", "Exception while inflating drawable", paramContext);
        }
      }
    }
    label374:
    throw new XmlPullParserException("No start tag found");
  }
  
  private static ColorStateList d(Context paramContext, int paramInt)
  {
    int i3 = ha.a(paramContext, 2130968784);
    int i1 = ha.c(paramContext, 2130968782);
    paramContext = ha.b;
    int[] arrayOfInt1 = ha.e;
    int i2 = android.support.v4.a.a.a(i3, paramInt);
    int[] arrayOfInt2 = ha.d;
    i3 = android.support.v4.a.a.a(i3, paramInt);
    return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, ha.c }, new int[] { i1, i2, i3, paramInt });
  }
  
  public final Drawable a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = a(paramContext, paramInt, false);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  final Drawable a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!this.l)
      {
        this.l = true;
        localObject1 = a(paramContext, 2131230858);
        if ((localObject1 == null) || ((!(localObject1 instanceof l)) && (!"android.graphics.drawable.VectorDrawable".equals(localObject1.getClass().getName()))))
        {
          this.l = false;
          throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
      }
    }
    finally {}
    Object localObject2 = c(paramContext, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.o == null) {
        this.o = new TypedValue();
      }
      TypedValue localTypedValue = this.o;
      paramContext.getResources().getValue(paramInt, localTypedValue, true);
      long l1 = a(localTypedValue);
      localObject2 = a(paramContext, l1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (paramInt == 2131230789) {
          localObject2 = new LayerDrawable(new Drawable[] { a(paramContext, 2131230788), a(paramContext, 2131230790) });
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((Drawable)localObject2).setChangingConfigurations(localTypedValue.changingConfigurations);
          a(paramContext, l1, (Drawable)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = d.a(paramContext, paramInt);
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = a(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
    }
    if (localObject1 != null) {
      bw.b((Drawable)localObject1);
    }
    return (Drawable)localObject1;
  }
  
  /* Error */
  final Drawable a(Context paramContext, hv paramhv, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_3
    //   5: invokespecial 465	android/support/v7/widget/ae:c	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   8: astore 5
    //   10: aload 5
    //   12: astore 4
    //   14: aload 5
    //   16: ifnonnull +10 -> 26
    //   19: aload_2
    //   20: iload_3
    //   21: invokevirtual 482	android/support/v7/widget/hv:a	(I)Landroid/graphics/drawable/Drawable;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +17 -> 45
    //   31: aload_0
    //   32: aload_1
    //   33: iload_3
    //   34: iconst_0
    //   35: aload 4
    //   37: invokespecial 474	android/support/v7/widget/ae:a	(Landroid/content/Context;IZLandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: aconst_null
    //   46: astore_1
    //   47: goto -6 -> 41
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	ae
    //   0	55	1	paramContext	Context
    //   0	55	2	paramhv	hv
    //   0	55	3	paramInt	int
    //   12	24	4	localDrawable1	Drawable
    //   8	7	5	localDrawable2	Drawable
    // Exception table:
    //   from	to	target	type
    //   2	10	50	finally
    //   19	26	50	finally
    //   31	41	50	finally
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      paramContext = (h)this.k.get(paramContext);
      if (paramContext != null) {
        paramContext.b();
      }
      return;
    }
    finally {}
  }
  
  final ColorStateList b(Context paramContext, int paramInt)
  {
    Object localObject1;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = this.n;
        if (localObject1 == null) {
          break label484;
        }
        localObject1 = (w)((WeakHashMap)localObject1).get(paramContext);
        if (localObject1 == null) {
          break;
        }
        localObject1 = (ColorStateList)((w)localObject1).a(paramInt, null);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          if (paramInt == 2131230793)
          {
            localObject1 = android.support.v7.b.a.a.a(paramContext, 2131099668);
            label56:
            if (localObject1 != null)
            {
              if (this.n == null) {
                this.n = new WeakHashMap();
              }
              localObject3 = (w)this.n.get(paramContext);
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject2 = new w();
                this.n.put(paramContext, localObject2);
              }
              ((w)localObject2).c(paramInt, localObject1);
              return (ColorStateList)localObject1;
            }
            localObject2 = localObject1;
          }
        }
        else
        {
          localObject1 = localObject2;
          continue;
        }
        if (paramInt == 2131230843)
        {
          localObject1 = android.support.v7.b.a.a.a(paramContext, 2131099671);
          continue;
        }
        if (paramInt != 2131230842) {
          break label318;
        }
        localObject1 = new int[3][];
        localObject2 = new int[3];
        Object localObject3 = ha.b(paramContext, 2130968799);
        if ((localObject3 != null) && (((ColorStateList)localObject3).isStateful()))
        {
          localObject1[0] = ha.b;
          localObject2[0] = ((ColorStateList)localObject3).getColorForState(localObject1[0], 0);
          localObject1[1] = ha.a;
          localObject2[1] = ha.a(paramContext, 2130968783);
          localObject1[2] = ha.c;
          localObject2[2] = ((ColorStateList)localObject3).getDefaultColor();
          localObject1 = new ColorStateList((int[][])localObject1, (int[])localObject2);
          continue;
        }
        localObject1[0] = ha.b;
      }
      finally {}
      localObject2[0] = ha.c(paramContext, 2130968799);
      localObject1[1] = ha.a;
      localObject2[1] = ha.a(paramContext, 2130968783);
      localObject1[2] = ha.c;
      localObject2[2] = ha.a(paramContext, 2130968799);
      continue;
      label318:
      if (paramInt == 2131230782)
      {
        localObject1 = d(paramContext, ha.a(paramContext, 2130968782));
      }
      else if (paramInt == 2131230777)
      {
        localObject1 = d(paramContext, 0);
      }
      else
      {
        if (paramInt != 2131230781) {
          break label489;
        }
        localObject1 = d(paramContext, ha.a(paramContext, 2130968780));
      }
    }
    for (;;)
    {
      label377:
      localObject1 = android.support.v7.b.a.a.a(paramContext, 2131099670);
      break label56;
      if (paramInt != 2131230841)
      {
        if (a(h, paramInt))
        {
          localObject1 = ha.b(paramContext, 2130968785);
          break label56;
        }
        if (a(i, paramInt))
        {
          localObject1 = android.support.v7.b.a.a.a(paramContext, 2131099667);
          break label56;
        }
        if (a(g, paramInt))
        {
          localObject1 = android.support.v7.b.a.a.a(paramContext, 2131099666);
          break label56;
        }
        if (paramInt == 2131230837)
        {
          localObject1 = android.support.v7.b.a.a.a(paramContext, 2131099669);
          break label56;
        }
        break label56;
        localObject1 = null;
        break;
        label484:
        localObject1 = null;
        break;
        label489:
        if (paramInt != 2131230840) {
          break label377;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */