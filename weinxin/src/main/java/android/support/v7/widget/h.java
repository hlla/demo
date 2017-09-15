package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.e.e;
import android.support.v7.a.a.a;
import android.support.v7.a.a.e;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class h
{
  private static h UA;
  private static final b UB = new b();
  private static final int[] UC = { a.e.JJ, a.e.JH, a.e.IW };
  private static final int[] UD = { a.e.Jg, a.e.Jj, a.e.Jq, a.e.Ji, a.e.Jh, a.e.Jp, a.e.Jk, a.e.Jl, a.e.Jo, a.e.Jn, a.e.Jm, a.e.Jr };
  private static final int[] UE = { a.e.JG, a.e.JI, a.e.Je, a.e.JF };
  private static final int[] UF = { a.e.Ju, a.e.Jc, a.e.Jt };
  private static final int[] UG = { a.e.Jf, a.e.JE, a.e.JK, a.e.JA, a.e.JB, a.e.Jv, a.e.JD, a.e.JC, a.e.Ja, a.e.IX };
  private static final int[] UH = { a.e.IY, a.e.Jb };
  private static final PorterDuff.Mode Uz = PorterDuff.Mode.SRC_IN;
  private WeakHashMap<Context, SparseArray<ColorStateList>> UI;
  private android.support.v4.e.a<String, c> UJ;
  private SparseArray<String> UK;
  private final Object UL = new Object();
  private final WeakHashMap<Context, e<WeakReference<Drawable.ConstantState>>> UM = new WeakHashMap(0);
  private TypedValue UN;
  
  private static long a(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  public static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    PorterDuffColorFilter localPorterDuffColorFilter2 = (PorterDuffColorFilter)UB.get(Integer.valueOf(b.b(paramInt, paramMode)));
    PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
    if (localPorterDuffColorFilter2 == null)
    {
      localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
      UB.put(Integer.valueOf(b.b(paramInt, paramMode)), localPorterDuffColorFilter1);
    }
    return localPorterDuffColorFilter1;
  }
  
  private Drawable a(Context paramContext, long paramLong)
  {
    e locale;
    synchronized (this.UL)
    {
      locale = (e)this.UM.get(paramContext);
      if (locale == null) {
        return null;
      }
      Object localObject2 = (WeakReference)locale.get(paramLong);
      if (localObject2 == null) {
        break label136;
      }
      localObject2 = (Drawable.ConstantState)((WeakReference)localObject2).get();
      if (localObject2 != null)
      {
        paramContext = ((Drawable.ConstantState)localObject2).newDrawable(paramContext.getResources());
        return paramContext;
      }
    }
    int i = android.support.v4.e.b.a(locale.vV, locale.hP, paramLong);
    if ((i >= 0) && (locale.vW[i] != e.vT))
    {
      locale.vW[i] = e.vT;
      locale.vU = true;
    }
    label136:
    return null;
  }
  
  private static void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (w.o(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = Uz;
    }
    localDrawable.setColorFilter(a(paramInt, paramDrawable));
  }
  
  public static void a(Drawable paramDrawable, an paraman, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    if ((w.o(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {}
    label57:
    label73:
    label97:
    label104:
    label124:
    for (;;)
    {
      return;
      ColorStateList localColorStateList;
      Object localObject1;
      if ((paraman.aeE) || (paraman.aeD)) {
        if (paraman.aeE)
        {
          localColorStateList = paraman.aeC;
          if (!paraman.aeD) {
            break label97;
          }
          paraman = paraman.nl;
          localObject1 = localObject2;
          if (localColorStateList != null)
          {
            if (paraman != null) {
              break label104;
            }
            localObject1 = localObject2;
          }
          paramDrawable.setColorFilter((ColorFilter)localObject1);
        }
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT > 23) {
          break label124;
        }
        paramDrawable.invalidateSelf();
        return;
        localColorStateList = null;
        break;
        paraman = Uz;
        break label57;
        localObject1 = a(localColorStateList.getColorForState(paramArrayOfInt, 0), paraman);
        break label73;
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  private void a(String paramString, c paramc)
  {
    if (this.UJ == null) {
      this.UJ = new android.support.v4.e.a();
    }
    this.UJ.put(paramString, paramc);
  }
  
  static boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = Uz;
    int i;
    int j;
    if (a(UC, paramInt))
    {
      i = a.a.colorControlNormal;
      j = 1;
      paramInt = -1;
    }
    for (;;)
    {
      if (j != 0)
      {
        Drawable localDrawable = paramDrawable;
        if (w.o(paramDrawable)) {
          localDrawable = paramDrawable.mutate();
        }
        localDrawable.setColorFilter(a(al.h(paramContext, i), localMode));
        if (paramInt != -1) {
          localDrawable.setAlpha(paramInt);
        }
        return true;
        if (a(UE, paramInt))
        {
          i = a.a.colorControlActivated;
          j = 1;
          paramInt = -1;
          continue;
        }
        if (a(UF, paramInt))
        {
          localMode = PorterDuff.Mode.MULTIPLY;
          j = 1;
          i = 16842801;
          paramInt = -1;
          continue;
        }
        if (paramInt == a.e.Js)
        {
          i = 16842800;
          paramInt = Math.round(40.8F);
          j = 1;
        }
      }
      else
      {
        return false;
      }
      paramInt = -1;
      i = 0;
      j = 0;
    }
  }
  
  private boolean a(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
    if (localConstantState != null) {
      synchronized (this.UL)
      {
        e locale = (e)this.UM.get(paramContext);
        paramDrawable = locale;
        if (locale == null)
        {
          paramDrawable = new e();
          this.UM.put(paramContext, paramDrawable);
        }
        paramDrawable.put(paramLong, new WeakReference(localConstantState));
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static h ey()
  {
    if (UA == null)
    {
      h localh = new h();
      UA = localh;
      int i = Build.VERSION.SDK_INT;
      if (i < 23)
      {
        localh.a("vector", new d());
        if (i >= 11) {
          localh.a("animated-vector", new a());
        }
      }
    }
    return UA;
  }
  
  private static ColorStateList f(Context paramContext, int paramInt)
  {
    int k = al.h(paramContext, a.a.colorControlHighlight);
    int[] arrayOfInt1 = al.iK;
    int i = al.j(paramContext, a.a.colorButtonNormal);
    paramContext = al.PRESSED_STATE_SET;
    int j = android.support.v4.b.b.i(k, paramInt);
    int[] arrayOfInt2 = al.FOCUSED_STATE_SET;
    k = android.support.v4.b.b.i(k, paramInt);
    return new ColorStateList(new int[][] { arrayOfInt1, paramContext, arrayOfInt2, al.EMPTY_STATE_SET }, new int[] { i, j, k, paramInt });
  }
  
  public final Drawable a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = d(paramContext, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.UN == null) {
        this.UN = new TypedValue();
      }
      TypedValue localTypedValue = this.UN;
      paramContext.getResources().getValue(paramInt, localTypedValue, true);
      long l = a(localTypedValue);
      localObject2 = a(paramContext, l);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (paramInt == a.e.Jd) {
          localObject2 = new LayerDrawable(new Drawable[] { a(paramContext, a.e.Jc, false), a(paramContext, a.e.Je, false) });
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((Drawable)localObject2).setChangingConfigurations(localTypedValue.changingConfigurations);
          a(paramContext, l, (Drawable)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = android.support.v4.content.a.a(paramContext, paramInt);
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = a(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
    }
    if (localObject1 != null) {
      w.n((Drawable)localObject1);
    }
    return (Drawable)localObject1;
  }
  
  final Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject = null;
    ColorStateList localColorStateList = e(paramContext, paramInt);
    if (localColorStateList != null)
    {
      paramContext = paramDrawable;
      if (w.o(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramDrawable = android.support.v4.b.a.a.g(paramContext);
      android.support.v4.b.a.a.a(paramDrawable, localColorStateList);
      paramContext = (Context)localObject;
      if (paramInt == a.e.JC) {
        paramContext = PorterDuff.Mode.MULTIPLY;
      }
      localObject = paramDrawable;
      if (paramContext != null)
      {
        android.support.v4.b.a.a.a(paramDrawable, paramContext);
        localObject = paramDrawable;
      }
    }
    do
    {
      do
      {
        return (Drawable)localObject;
        if (paramInt == a.e.Jz)
        {
          localObject = (LayerDrawable)paramDrawable;
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), al.h(paramContext, a.a.colorControlNormal), Uz);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), al.h(paramContext, a.a.colorControlNormal), Uz);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), al.h(paramContext, a.a.colorControlActivated), Uz);
          return paramDrawable;
        }
        if ((paramInt == a.e.Jw) || (paramInt == a.e.Jx))
        {
          localObject = (LayerDrawable)paramDrawable;
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), al.j(paramContext, a.a.colorControlNormal), Uz);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), al.h(paramContext, a.a.colorControlActivated), Uz);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), al.h(paramContext, a.a.colorControlActivated), Uz);
          return paramDrawable;
        }
        localObject = paramDrawable;
      } while (a(paramContext, paramInt, paramDrawable));
      localObject = paramDrawable;
    } while (!paramBoolean);
    return null;
  }
  
  final Drawable d(Context paramContext, int paramInt)
  {
    if ((this.UJ != null) && (!this.UJ.isEmpty()))
    {
      if (this.UK != null)
      {
        localObject1 = (String)this.UK.get(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.UJ.get(localObject1) == null)))
        {
          localObject1 = null;
          return (Drawable)localObject1;
        }
      }
      else
      {
        this.UK = new SparseArray();
      }
      if (this.UN == null) {
        this.UN = new TypedValue();
      }
      TypedValue localTypedValue = this.UN;
      Object localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l = a(localTypedValue);
      Drawable localDrawable = a(paramContext, l);
      if (localDrawable != null) {
        return localDrawable;
      }
      Object localObject2 = localDrawable;
      XmlResourceParser localXmlResourceParser;
      AttributeSet localAttributeSet;
      if (localTypedValue.string != null)
      {
        localObject2 = localDrawable;
        if (localTypedValue.string.toString().endsWith(".xml"))
        {
          localObject2 = localDrawable;
          try
          {
            localXmlResourceParser = ((Resources)localObject1).getXml(paramInt);
            localObject2 = localDrawable;
            localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
            int i;
            do
            {
              localObject2 = localDrawable;
              i = localXmlResourceParser.next();
            } while ((i != 2) && (i != 1));
            if (i != 2)
            {
              localObject2 = localDrawable;
              throw new XmlPullParserException("No start tag found");
            }
          }
          catch (Exception paramContext) {}
        }
      }
      for (paramContext = (Context)localObject2;; paramContext = (Context)localObject1)
      {
        localObject1 = paramContext;
        if (paramContext != null) {
          break;
        }
        this.UK.append(paramInt, "appcompat_skip_skip");
        return paramContext;
        localObject2 = localDrawable;
        localObject1 = localXmlResourceParser.getName();
        localObject2 = localDrawable;
        this.UK.append(paramInt, localObject1);
        localObject2 = localDrawable;
        c localc = (c)this.UJ.get(localObject1);
        localObject1 = localDrawable;
        if (localc != null)
        {
          localObject2 = localDrawable;
          localObject1 = localc.a(paramContext, localXmlResourceParser, localAttributeSet, paramContext.getTheme());
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
          localObject2 = localObject1;
          a(paramContext, l, (Drawable)localObject1);
        }
      }
    }
    return null;
  }
  
  public final ColorStateList e(Context paramContext, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    int i;
    int j;
    Object localObject3;
    int k;
    if (this.UI != null)
    {
      localObject1 = (SparseArray)this.UI.get(paramContext);
      if (localObject1 != null)
      {
        localObject1 = (ColorStateList)((SparseArray)localObject1).get(paramInt);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          if (paramInt != a.e.Jf) {
            break label230;
          }
          localObject1 = al.iK;
          i = al.j(paramContext, a.a.colorControlNormal);
          localObject2 = al.aez;
          j = al.h(paramContext, a.a.colorControlNormal);
          localObject3 = al.EMPTY_STATE_SET;
          k = al.h(paramContext, a.a.colorControlActivated);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i, j, k });
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (this.UI == null) {
          this.UI = new WeakHashMap();
        }
        localObject3 = (SparseArray)this.UI.get(paramContext);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new SparseArray();
          this.UI.put(paramContext, localObject2);
        }
        ((SparseArray)localObject2).append(paramInt, localObject1);
      }
      localObject2 = localObject1;
      return (ColorStateList)localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
      label230:
      if (paramInt == a.e.JD)
      {
        localObject1 = al.iK;
        i = al.a(paramContext, 16842800, 0.1F);
        localObject2 = al.dN;
        j = al.a(paramContext, a.a.colorControlActivated, 0.3F);
        localObject3 = al.EMPTY_STATE_SET;
        k = al.a(paramContext, 16842800, 0.3F);
        localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i, j, k });
      }
      else
      {
        if (paramInt == a.e.JC)
        {
          localObject1 = new int[3][];
          localObject2 = new int[3];
          localObject3 = al.i(paramContext, a.a.IH);
          if ((localObject3 != null) && (((ColorStateList)localObject3).isStateful()))
          {
            localObject1[0] = al.iK;
            localObject2[0] = ((ColorStateList)localObject3).getColorForState(localObject1[0], 0);
            localObject1[1] = al.dN;
            localObject2[1] = al.h(paramContext, a.a.colorControlActivated);
            localObject1[2] = al.EMPTY_STATE_SET;
            localObject2[2] = ((ColorStateList)localObject3).getDefaultColor();
          }
          for (;;)
          {
            localObject1 = new ColorStateList((int[][])localObject1, (int[])localObject2);
            break;
            localObject1[0] = al.iK;
            localObject2[0] = al.j(paramContext, a.a.IH);
            localObject1[1] = al.dN;
            localObject2[1] = al.h(paramContext, a.a.colorControlActivated);
            localObject1[2] = al.EMPTY_STATE_SET;
            localObject2[2] = al.h(paramContext, a.a.IH);
          }
        }
        if (paramInt == a.e.Ja)
        {
          localObject1 = f(paramContext, al.h(paramContext, a.a.colorButtonNormal));
        }
        else if (paramInt == a.e.IX)
        {
          localObject1 = f(paramContext, 0);
        }
        else if (paramInt == a.e.IZ)
        {
          localObject1 = f(paramContext, al.h(paramContext, a.a.colorAccent));
        }
        else if ((paramInt == a.e.JA) || (paramInt == a.e.JB))
        {
          localObject1 = al.iK;
          i = al.j(paramContext, a.a.colorControlNormal);
          localObject2 = al.aez;
          j = al.h(paramContext, a.a.colorControlNormal);
          localObject3 = al.EMPTY_STATE_SET;
          k = al.h(paramContext, a.a.colorControlActivated);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i, j, k });
        }
        else if (a(UD, paramInt))
        {
          localObject1 = al.i(paramContext, a.a.colorControlNormal);
        }
        else if (a(UG, paramInt))
        {
          i = al.h(paramContext, a.a.colorControlNormal);
          j = al.h(paramContext, a.a.colorControlActivated);
          localObject1 = al.iK;
          k = al.j(paramContext, a.a.colorControlNormal);
          localObject1 = new ColorStateList(new int[][] { localObject1, al.FOCUSED_STATE_SET, al.aey, al.PRESSED_STATE_SET, al.dN, al.SELECTED_STATE_SET, al.EMPTY_STATE_SET }, new int[] { k, j, j, j, j, j, i });
        }
        else if (a(UH, paramInt))
        {
          localObject1 = al.iK;
          i = al.j(paramContext, a.a.colorControlNormal);
          localObject2 = al.dN;
          j = al.h(paramContext, a.a.colorControlActivated);
          localObject3 = al.EMPTY_STATE_SET;
          k = al.h(paramContext, a.a.colorControlNormal);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i, j, k });
        }
        else if (paramInt == a.e.Jy)
        {
          localObject1 = al.iK;
          i = al.j(paramContext, a.a.colorControlActivated);
          localObject2 = al.EMPTY_STATE_SET;
          j = al.h(paramContext, a.a.colorControlActivated);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2 }, new int[] { i, j });
        }
      }
    }
  }
  
  private static final class a
    implements h.c
  {
    public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = android.support.b.a.b.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext) {}
      return null;
    }
  }
  
  private static final class b
    extends android.support.v4.e.f<Integer, PorterDuffColorFilter>
  {
    public b()
    {
      super();
    }
    
    static int b(int paramInt, PorterDuff.Mode paramMode)
    {
      return (paramInt + 31) * 31 + paramMode.hashCode();
    }
  }
  
  private static abstract interface c
  {
    public abstract Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
  }
  
  private static final class d
    implements h.c
  {
    public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = android.support.b.a.f.a(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext) {}
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */