package com.tencent.mm.bh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Picture;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public final class a
  extends Resources
{
  private static Method unE;
  private static Method unF;
  private Resources Cu;
  private e unC;
  private c unD;
  
  static
  {
    GMTrace.i(367622356992L, 2739);
    unE = null;
    unF = null;
    GMTrace.o(367622356992L, 2739);
  }
  
  private a(Resources paramResources, e parame, c paramc)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    GMTrace.i(365072220160L, 2720);
    this.unC = parame;
    this.Cu = paramResources;
    this.unD = paramc;
    for (;;)
    {
      try
      {
        paramc = Class.forName("android.content.res.MiuiResources");
        if (paramc == null) {
          continue;
        }
        v.i("MicroMsg.MMResources", "sMiuiThemeEnabled false");
        parame = paramc.getDeclaredField("sMiuiThemeEnabled");
        paramResources = parame;
        if (parame == null) {
          continue;
        }
        parame.setAccessible(true);
        parame.set(null, Boolean.valueOf(false));
      }
      catch (ClassNotFoundException paramResources)
      {
        v.i("MicroMsg.MMResources", "sMiuiThemeEnabled ClassNotFoundException");
        continue;
      }
      catch (NoSuchFieldException paramResources)
      {
        v.i("MicroMsg.MMResources", "sMiuiThemeEnabled NoSuchFieldException");
        continue;
      }
      catch (IllegalAccessException paramResources)
      {
        v.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalAccessException");
        continue;
      }
      catch (IllegalArgumentException paramResources)
      {
        v.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalArgumentException");
        continue;
      }
      paramResources = new com.tencent.mm.compatible.loader.c(getAssets(), "mThemeCookies", null);
      try
      {
        if (paramResources.rS()) {
          paramResources.set(new a());
        }
        GMTrace.o(365072220160L, 2720);
        return;
      }
      catch (NoSuchFieldException paramResources)
      {
        v.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        GMTrace.o(365072220160L, 2720);
        return;
      }
      catch (IllegalAccessException paramResources)
      {
        v.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        GMTrace.o(365072220160L, 2720);
        return;
      }
      catch (IllegalArgumentException paramResources)
      {
        v.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        GMTrace.o(365072220160L, 2720);
      }
      paramResources = null;
      v.e("MicroMsg.MMResources", "some thing wrong. %s %s", new Object[] { paramc, paramResources });
    }
  }
  
  public static Resources a(Resources paramResources, Context paramContext)
  {
    GMTrace.i(365340655616L, 2722);
    paramResources = new a(paramResources, e.dQ(paramContext), new c());
    GMTrace.o(365340655616L, 2722);
    return paramResources;
  }
  
  public static Drawable b(Resources paramResources, int paramInt)
  {
    int i = 1;
    GMTrace.i(367488139264L, 2738);
    Object localObject3 = new TypedValue();
    paramResources.getValue(paramInt, (TypedValue)localObject3, true);
    Object localObject1 = null;
    if ((((TypedValue)localObject3).type >= 28) && (((TypedValue)localObject3).type <= 31)) {}
    for (;;)
    {
      if (i != 0) {
        localObject1 = new ColorDrawable(((TypedValue)localObject3).data);
      }
      if (unE == null) {}
      Object localObject2;
      try
      {
        localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
        unE = (Method)localObject2;
        ((Method)localObject2).setAccessible(true);
        if (unF == null) {}
        localObject1 = ((TypedValue)localObject3).string.toString();
      }
      catch (NoSuchMethodException paramResources)
      {
        try
        {
          localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
          unF = (Method)localObject2;
          ((Method)localObject2).setAccessible(true);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label356;
          }
          if (((TypedValue)localObject3).string != null) {
            break label278;
          }
          throw new Resources.NotFoundException("Resource is not a Drawable (color or path): " + localObject3);
        }
        catch (NoSuchMethodException paramResources)
        {
          v.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          v.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
          GMTrace.o(367488139264L, 2738);
          return null;
        }
        paramResources = paramResources;
        v.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        v.printErrStackTrace("MicroMsg.MMResources", paramResources, "", new Object[0]);
        GMTrace.o(367488139264L, 2738);
        return null;
      }
      label278:
      if (((String)localObject1).endsWith(".xml")) {}
      for (;;)
      {
        try
        {
          localObject3 = (XmlResourceParser)unE.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
          localObject2 = Drawable.createFromXml(paramResources, (XmlPullParser)localObject3);
          ((XmlResourceParser)localObject3).close();
          label356:
          GMTrace.o(367488139264L, 2738);
          return (Drawable)localObject2;
        }
        catch (Exception paramResources)
        {
          localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
          ((Resources.NotFoundException)localObject1).initCause(paramResources);
          throw ((Throwable)localObject1);
        }
        try
        {
          InputStream localInputStream = (InputStream)unF.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
          localObject2 = Drawable.createFromResourceStream(paramResources, (TypedValue)localObject3, localInputStream, (String)localObject1, null);
          localInputStream.close();
        }
        catch (Exception paramResources)
        {
          localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
          ((Resources.NotFoundException)localObject1).initCause(paramResources);
          throw ((Throwable)localObject1);
        }
      }
      i = 0;
    }
  }
  
  private boolean bHv()
  {
    GMTrace.i(365474873344L, 2723);
    if ((this.unC != null) && (e.bHv()))
    {
      GMTrace.o(365474873344L, 2723);
      return true;
    }
    GMTrace.o(365474873344L, 2723);
    return false;
  }
  
  private Drawable d(Drawable paramDrawable, int paramInt)
  {
    GMTrace.i(367353921536L, 2737);
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      v.j("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
    }
    try
    {
      if (this.unD.unK.d(this, paramInt)) {
        v.e("MicroMsg.MMResources", "resources name = %s, this resource %s", new Object[] { getResourceName(paramInt), this });
      }
      localObject = new com.tencent.mm.svg.a.c(new Picture(), 0);
      GMTrace.o(367353921536L, 2737);
      return (Drawable)localObject;
    }
    catch (Exception paramDrawable)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.MMResources", paramDrawable, "WTF", new Object[0]);
      }
    }
  }
  
  public final void bHu()
  {
    GMTrace.i(365206437888L, 2721);
    updateConfiguration(this.Cu.getConfiguration(), this.Cu.getDisplayMetrics());
    GMTrace.o(365206437888L, 2721);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    GMTrace.i(366817050624L, 2733);
    if (paramInt != 0)
    {
      localDrawable = this.unD.c(this.Cu, paramInt);
      if (localDrawable != null)
      {
        GMTrace.o(366817050624L, 2733);
        return localDrawable;
      }
    }
    Drawable localDrawable = d(super.getDrawable(paramInt), paramInt);
    GMTrace.o(366817050624L, 2733);
    return localDrawable;
  }
  
  @TargetApi(21)
  public final Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    GMTrace.i(366951268352L, 2734);
    if (paramInt != 0)
    {
      Drawable localDrawable = this.unD.c(this.Cu, paramInt);
      if (localDrawable != null)
      {
        GMTrace.o(366951268352L, 2734);
        return localDrawable;
      }
    }
    paramTheme = d(super.getDrawable(paramInt, paramTheme), paramInt);
    GMTrace.o(366951268352L, 2734);
    return paramTheme;
  }
  
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    GMTrace.i(367085486080L, 2735);
    if (paramInt1 != 0)
    {
      localDrawable = this.unD.c(this.Cu, paramInt1);
      if (localDrawable != null)
      {
        GMTrace.o(367085486080L, 2735);
        return localDrawable;
      }
    }
    Drawable localDrawable = d(super.getDrawableForDensity(paramInt1, paramInt2), paramInt1);
    GMTrace.o(367085486080L, 2735);
    return localDrawable;
  }
  
  @TargetApi(22)
  public final Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    GMTrace.i(367219703808L, 2736);
    if (paramInt1 != 0)
    {
      Drawable localDrawable = this.unD.c(this.Cu, paramInt1);
      if (localDrawable != null)
      {
        GMTrace.o(367219703808L, 2736);
        return localDrawable;
      }
    }
    paramTheme = d(super.getDrawableForDensity(paramInt1, paramInt2, paramTheme), paramInt1);
    GMTrace.o(367219703808L, 2736);
    return paramTheme;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2)
  {
    GMTrace.i(366011744256L, 2727);
    if (bHv())
    {
      str = e.getQuantityString(paramInt1, paramInt2);
      if (str != null)
      {
        str = str.toString();
        GMTrace.o(366011744256L, 2727);
        return str;
      }
    }
    String str = this.Cu.getQuantityString(paramInt1, paramInt2);
    GMTrace.o(366011744256L, 2727);
    return str;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    GMTrace.i(366145961984L, 2728);
    if (bHv())
    {
      String str = e.getQuantityString(paramInt1, paramInt2, paramVarArgs);
      if (str != null)
      {
        paramVarArgs = str.toString();
        GMTrace.o(366145961984L, 2728);
        return paramVarArgs;
      }
    }
    paramVarArgs = this.Cu.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    GMTrace.o(366145961984L, 2728);
    return paramVarArgs;
  }
  
  public final CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    GMTrace.i(366280179712L, 2729);
    if (bHv())
    {
      str = e.getQuantityString(paramInt1, paramInt2);
      if (str != null)
      {
        str = str.toString();
        GMTrace.o(366280179712L, 2729);
        return str;
      }
    }
    String str = this.Cu.getQuantityString(paramInt1, paramInt2);
    GMTrace.o(366280179712L, 2729);
    return str;
  }
  
  public final String getString(int paramInt)
  {
    GMTrace.i(365877526528L, 2726);
    Object localObject;
    if (bHv())
    {
      localObject = e.getString(paramInt);
      if (localObject != null)
      {
        localObject = e.d(paramInt, ((CharSequence)localObject).toString()).toString();
        GMTrace.o(365877526528L, 2726);
        return (String)localObject;
      }
    }
    try
    {
      localObject = e.d(paramInt, this.Cu.getString(paramInt));
      if (localObject != null)
      {
        localObject = ((CharSequence)localObject).toString();
        GMTrace.o(365877526528L, 2726);
        return (String)localObject;
      }
      localObject = this.Cu.getString(paramInt);
      GMTrace.o(365877526528L, 2726);
      return (String)localObject;
    }
    catch (Exception localException)
    {
      GMTrace.o(365877526528L, 2726);
    }
    return "";
  }
  
  public final String[] getStringArray(int paramInt)
  {
    GMTrace.i(366414397440L, 2730);
    if (bHv())
    {
      arrayOfString = e.getStringArray(paramInt);
      if (arrayOfString != null)
      {
        GMTrace.o(366414397440L, 2730);
        return arrayOfString;
      }
    }
    String[] arrayOfString = super.getStringArray(paramInt);
    GMTrace.o(366414397440L, 2730);
    return arrayOfString;
  }
  
  public final CharSequence getText(int paramInt)
  {
    GMTrace.i(365609091072L, 2724);
    if (bHv())
    {
      localObject = e.d(paramInt, e.getString(paramInt));
      if (localObject != null)
      {
        GMTrace.o(365609091072L, 2724);
        return (CharSequence)localObject;
      }
    }
    Object localObject = e.d(paramInt, this.Cu.getString(paramInt));
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      GMTrace.o(365609091072L, 2724);
      return (CharSequence)localObject;
    }
    localObject = this.Cu.getString(paramInt);
    GMTrace.o(365609091072L, 2724);
    return (CharSequence)localObject;
  }
  
  public final CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    GMTrace.i(365743308800L, 2725);
    if (bHv())
    {
      paramCharSequence = e.d(paramInt, e.getString(paramInt));
      if (paramCharSequence != null)
      {
        GMTrace.o(365743308800L, 2725);
        return paramCharSequence;
      }
    }
    paramCharSequence = e.d(paramInt, this.Cu.getString(paramInt));
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      GMTrace.o(365743308800L, 2725);
      return paramCharSequence;
    }
    paramCharSequence = this.Cu.getString(paramInt);
    GMTrace.o(365743308800L, 2725);
    return paramCharSequence;
  }
  
  public final CharSequence[] getTextArray(int paramInt)
  {
    GMTrace.i(366548615168L, 2731);
    Object localObject = getStringArray(paramInt);
    if (localObject != null)
    {
      GMTrace.o(366548615168L, 2731);
      return (CharSequence[])localObject;
    }
    localObject = super.getTextArray(paramInt);
    GMTrace.o(366548615168L, 2731);
    return (CharSequence[])localObject;
  }
  
  public final TypedArray obtainTypedArray(int paramInt)
  {
    GMTrace.i(366682832896L, 2732);
    TypedArray localTypedArray = this.Cu.obtainTypedArray(paramInt);
    GMTrace.o(366682832896L, 2732);
    return localTypedArray;
  }
  
  public static final class a<E>
    extends ArrayList<E>
  {
    public a()
    {
      GMTrace.i(368830316544L, 2748);
      GMTrace.o(368830316544L, 2748);
    }
    
    public final void add(int paramInt, E paramE)
    {
      GMTrace.i(369098752000L, 2750);
      v.i("InterceptArrayList", "InterceptArrayList.add index object");
      GMTrace.o(369098752000L, 2750);
    }
    
    public final boolean add(E paramE)
    {
      GMTrace.i(368964534272L, 2749);
      v.i("InterceptArrayList", "InterceptArrayList.add");
      GMTrace.o(368964534272L, 2749);
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bh/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */