package android.support.v7.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.m;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.i;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class g
  extends MenuInflater
{
  private static final Class<?>[] OJ;
  private static final Class<?>[] OK;
  private final Object[] OL;
  private final Object[] OM;
  private Object OO;
  private Context mContext;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    OJ = arrayOfClass;
    OK = arrayOfClass;
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.OL = new Object[] { paramContext };
    this.OM = this.OL;
  }
  
  private void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    b localb = new b(paramMenu);
    int i = paramXmlPullParser.getEventType();
    int j = 0;
    paramMenu = null;
    Object localObject;
    int k;
    if (i == 2)
    {
      localObject = paramXmlPullParser.getName();
      if (((String)localObject).equals("menu"))
      {
        k = paramXmlPullParser.next();
        label56:
        i = 0;
        label59:
        if (i != 0) {
          return;
        }
      }
    }
    switch (k)
    {
    default: 
    case 2: 
    case 3: 
      for (;;)
      {
        k = paramXmlPullParser.next();
        break label59;
        throw new RuntimeException("Expecting menu, got " + (String)localObject);
        k = paramXmlPullParser.next();
        i = k;
        if (k != 1) {
          break;
        }
        break label56;
        if (j == 0)
        {
          localObject = paramXmlPullParser.getName();
          if (((String)localObject).equals("group"))
          {
            localObject = localb.Pq.mContext.obtainStyledAttributes(paramAttributeSet, a.k.cl);
            localb.OS = ((TypedArray)localObject).getResourceId(a.k.Mm, 0);
            localb.OT = ((TypedArray)localObject).getInt(a.k.Mn, 0);
            localb.OU = ((TypedArray)localObject).getInt(a.k.Mo, 0);
            localb.OV = ((TypedArray)localObject).getInt(a.k.Mk, 0);
            localb.OW = ((TypedArray)localObject).getBoolean(a.k.Mp, true);
            localb.OX = ((TypedArray)localObject).getBoolean(a.k.Ml, true);
            ((TypedArray)localObject).recycle();
          }
          else
          {
            if (((String)localObject).equals("item"))
            {
              localObject = localb.Pq.mContext.obtainStyledAttributes(paramAttributeSet, a.k.cm);
              localb.OZ = ((TypedArray)localObject).getResourceId(a.k.My, 0);
              localb.Pa = (((TypedArray)localObject).getInt(a.k.Mz, localb.OT) & 0xFFFF0000 | ((TypedArray)localObject).getInt(a.k.MC, localb.OU) & 0xFFFF);
              localb.Pb = ((TypedArray)localObject).getText(a.k.MD);
              localb.Pc = ((TypedArray)localObject).getText(a.k.ME);
              localb.Pd = ((TypedArray)localObject).getResourceId(a.k.Mx, 0);
              localb.Pe = b.p(((TypedArray)localObject).getString(a.k.Mt));
              localb.Pf = b.p(((TypedArray)localObject).getString(a.k.MA));
              if (((TypedArray)localObject).hasValue(a.k.Mu)) {
                if (((TypedArray)localObject).getBoolean(a.k.Mu, false))
                {
                  k = 1;
                  label458:
                  localb.Pg = k;
                  label465:
                  localb.Ph = ((TypedArray)localObject).getBoolean(a.k.Mv, false);
                  localb.Pi = ((TypedArray)localObject).getBoolean(a.k.MF, localb.OW);
                  localb.Pj = ((TypedArray)localObject).getBoolean(a.k.Mw, localb.OX);
                  localb.Pk = ((TypedArray)localObject).getInt(a.k.MG, -1);
                  localb.Po = ((TypedArray)localObject).getString(a.k.MB);
                  localb.Pl = ((TypedArray)localObject).getResourceId(a.k.Mq, 0);
                  localb.Pm = ((TypedArray)localObject).getString(a.k.Ms);
                  localb.Pn = ((TypedArray)localObject).getString(a.k.Mr);
                  if (localb.Pn == null) {
                    break label676;
                  }
                  k = 1;
                  label593:
                  if ((k == 0) || (localb.Pl != 0) || (localb.Pm != null)) {
                    break label682;
                  }
                }
              }
              label676:
              label682:
              for (localb.Pp = ((d)localb.newInstance(localb.Pn, OK, localb.Pq.OM));; localb.Pp = null)
              {
                ((TypedArray)localObject).recycle();
                localb.OY = false;
                break;
                k = 0;
                break label458;
                localb.Pg = localb.OV;
                break label465;
                k = 0;
                break label593;
              }
            }
            if (((String)localObject).equals("menu"))
            {
              a(paramXmlPullParser, paramAttributeSet, localb.dj());
            }
            else
            {
              j = 1;
              paramMenu = (Menu)localObject;
              continue;
              localObject = paramXmlPullParser.getName();
              if ((j != 0) && (((String)localObject).equals(paramMenu)))
              {
                j = 0;
                paramMenu = null;
              }
              else if (((String)localObject).equals("group"))
              {
                localb.di();
              }
              else if (((String)localObject).equals("item"))
              {
                if (!localb.OY) {
                  if ((localb.Pp != null) && (localb.Pp.hasSubMenu()))
                  {
                    localb.dj();
                  }
                  else
                  {
                    localb.OY = true;
                    localb.e(localb.OR.add(localb.OS, localb.OZ, localb.Pa, localb.Pb));
                  }
                }
              }
              else if (((String)localObject).equals("menu"))
              {
                i = 1;
              }
            }
          }
        }
      }
    }
    throw new RuntimeException("Unexpected end of document");
  }
  
  /* Error */
  public final void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 347
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 349	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 38	android/support/v7/view/g:mContext	Landroid/content/Context;
    //   26: invokevirtual 353	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 359	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore 4
    //   39: aload 6
    //   41: astore_3
    //   42: aload 6
    //   44: astore 5
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 365	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 301	android/support/v7/view/g:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull -47 -> 13
    //   63: aload 6
    //   65: invokeinterface 370 1 0
    //   70: return
    //   71: astore_2
    //   72: aload 4
    //   74: astore_3
    //   75: new 372	android/view/InflateException
    //   78: dup
    //   79: ldc_w 374
    //   82: aload_2
    //   83: invokespecial 377	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore_2
    //   88: aload_3
    //   89: ifnull +9 -> 98
    //   92: aload_3
    //   93: invokeinterface 370 1 0
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: aload 5
    //   103: astore_3
    //   104: new 372	android/view/InflateException
    //   107: dup
    //   108: ldc_w 374
    //   111: aload_2
    //   112: invokespecial 377	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	g
    //   0	116	1	paramInt	int
    //   0	116	2	paramMenu	Menu
    //   15	89	3	localObject1	Object
    //   20	53	4	localObject2	Object
    //   17	85	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	71	org/xmlpull/v1/XmlPullParserException
    //   46	58	71	org/xmlpull/v1/XmlPullParserException
    //   22	35	87	finally
    //   46	58	87	finally
    //   75	87	87	finally
    //   104	116	87	finally
    //   22	35	100	java/io/IOException
    //   46	58	100	java/io/IOException
  }
  
  private static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] OP = { MenuItem.class };
    private Object OO;
    private Method OQ;
    
    public a(Object paramObject, String paramString)
    {
      this.OO = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.OQ = localClass.getMethod(paramString, OP);
        return;
      }
      catch (Exception paramObject)
      {
        paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
        paramString.initCause((Throwable)paramObject);
        throw paramString;
      }
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (this.OQ.getReturnType() == Boolean.TYPE) {
          return ((Boolean)this.OQ.invoke(this.OO, new Object[] { paramMenuItem })).booleanValue();
        }
        this.OQ.invoke(this.OO, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  private final class b
  {
    Menu OR;
    int OS;
    int OT;
    int OU;
    int OV;
    boolean OW;
    boolean OX;
    boolean OY;
    int OZ;
    int Pa;
    CharSequence Pb;
    CharSequence Pc;
    int Pd;
    char Pe;
    char Pf;
    int Pg;
    boolean Ph;
    boolean Pi;
    boolean Pj;
    int Pk;
    int Pl;
    String Pm;
    String Pn;
    String Po;
    public d Pp;
    
    public b(Menu paramMenu)
    {
      this.OR = paramMenu;
      di();
    }
    
    static char p(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    public final void di()
    {
      this.OS = 0;
      this.OT = 0;
      this.OU = 0;
      this.OV = 0;
      this.OW = true;
      this.OX = true;
    }
    
    public final SubMenu dj()
    {
      this.OY = true;
      SubMenu localSubMenu = this.OR.addSubMenu(this.OS, this.OZ, this.Pa, this.Pb);
      e(localSubMenu.getItem());
      return localSubMenu;
    }
    
    final void e(MenuItem paramMenuItem)
    {
      int i = 1;
      Object localObject = paramMenuItem.setChecked(this.Ph).setVisible(this.Pi).setEnabled(this.Pj);
      if (this.Pg > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.Pc).setIcon(this.Pd).setAlphabeticShortcut(this.Pe).setNumericShortcut(this.Pf);
        if (this.Pk >= 0) {
          m.a(paramMenuItem, this.Pk);
        }
        if (this.Po == null) {
          break label161;
        }
        if (!g.a(g.this).isRestricted()) {
          break;
        }
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
      paramMenuItem.setOnMenuItemClickListener(new g.a(g.b(g.this), this.Po));
      label161:
      if (this.Pg >= 2)
      {
        if ((paramMenuItem instanceof h)) {
          ((h)paramMenuItem).E(true);
        }
      }
      else
      {
        if (this.Pm == null) {
          break label339;
        }
        m.a(paramMenuItem, (View)newInstance(this.Pm, g.dh(), g.c(g.this)));
      }
      for (;;)
      {
        if ((this.Pl > 0) && (i == 0)) {
          m.b(paramMenuItem, this.Pl);
        }
        if (this.Pp != null) {
          m.a(paramMenuItem, this.Pp);
        }
        return;
        if (!(paramMenuItem instanceof i)) {
          break;
        }
        localObject = (i)paramMenuItem;
        try
        {
          if (((i)localObject).Ra == null) {
            ((i)localObject).Ra = ((b)((i)localObject).PY).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
          }
          ((i)localObject).Ra.invoke(((i)localObject).PY, new Object[] { Boolean.valueOf(true) });
        }
        catch (Exception localException) {}
        break;
        label339:
        i = 0;
      }
    }
    
    final <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramString = g.a(g.this).getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
        paramString.setAccessible(true);
        paramString = paramString.newInstance(paramArrayOfObject);
        return paramString;
      }
      catch (Exception paramString) {}
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */