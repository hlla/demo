package android.support.v7.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.d.a.l;
import android.support.v4.content.a.o;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a
  extends n
{
  private boolean b;
  private c c;
  private g d;
  private int e = -1;
  private int f = -1;
  
  static
  {
    a.class.getSimpleName();
  }
  
  public a()
  {
    this(null, null);
  }
  
  a(c paramc, Resources paramResources)
  {
    super((byte)0);
    a(new c(paramc, this, paramResources));
    onStateChange(getState());
    jumpToCurrentState();
  }
  
  public static a a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject = paramXmlPullParser.getName();
    if (!((String)localObject).equals("animated-selector"))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramXmlPullParser.getPositionDescription());
      paramContext.append(": invalid animated-selector tag ");
      paramContext.append((String)localObject);
      throw new XmlPullParserException(paramContext.toString());
    }
    localObject = new a();
    ((n)localObject).b(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return (a)localObject;
  }
  
  private final c c()
  {
    return new c(this.c, this, null);
  }
  
  protected final void a(k paramk)
  {
    super.a(paramk);
    if ((paramk instanceof c)) {
      this.c = ((c)paramk);
    }
  }
  
  public final void b(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject1 = o.a(paramResources, paramTheme, paramAttributeSet, android.support.v7.a.a.M);
    setVisible(((TypedArray)localObject1).getBoolean(android.support.v7.a.a.S, true), true);
    Object localObject2 = this.c;
    if (Build.VERSION.SDK_INT >= 21) {
      ((c)localObject2).c |= ((TypedArray)localObject1).getChangingConfigurations();
    }
    ((k)localObject2).C = ((TypedArray)localObject1).getBoolean(android.support.v7.a.a.R, ((c)localObject2).C);
    ((k)localObject2).n = ((TypedArray)localObject1).getBoolean(android.support.v7.a.a.N, ((c)localObject2).n);
    ((k)localObject2).r = ((TypedArray)localObject1).getInt(android.support.v7.a.a.P, ((c)localObject2).r);
    ((k)localObject2).s = ((TypedArray)localObject1).getInt(android.support.v7.a.a.Q, ((c)localObject2).s);
    setDither(((TypedArray)localObject1).getBoolean(android.support.v7.a.a.O, ((c)localObject2).p));
    a(paramResources);
    ((TypedArray)localObject1).recycle();
    int i = paramXmlPullParser.getDepth() + 1;
    int j;
    label517:
    label772:
    do
    {
      do
      {
        do
        {
          j = paramXmlPullParser.next();
          if (j == 1) {
            break label818;
          }
          k = paramXmlPullParser.getDepth();
          if (k < i) {
            break;
          }
        } while ((j != 2) || (k > i));
        if (paramXmlPullParser.getName().equals("item")) {
          break;
        }
      } while (!paramXmlPullParser.getName().equals("transition"));
      localObject1 = o.a(paramResources, paramTheme, paramAttributeSet, android.support.v7.a.a.W);
      j = ((TypedArray)localObject1).getResourceId(android.support.v7.a.a.Y, -1);
      int k = ((TypedArray)localObject1).getResourceId(android.support.v7.a.a.aa, -1);
      int m = ((TypedArray)localObject1).getResourceId(android.support.v7.a.a.X, -1);
      if (m > 0) {}
      for (localObject2 = android.support.v7.b.a.a.b(paramContext, m);; localObject2 = null)
      {
        boolean bool = ((TypedArray)localObject1).getBoolean(android.support.v7.a.a.Z, false);
        ((TypedArray)localObject1).recycle();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          do
          {
            m = paramXmlPullParser.next();
          } while (m == 4);
          if (m != 2)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramXmlPullParser.getPositionDescription());
            paramContext.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            throw new XmlPullParserException(paramContext.toString());
          }
          if (!paramXmlPullParser.getName().equals("animated-vector")) {
            break label517;
          }
          localObject1 = android.support.d.a.b.a(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramXmlPullParser.getPositionDescription());
            paramContext.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            throw new XmlPullParserException(paramContext.toString());
          }
          if ((j == -1) || (k == -1))
          {
            paramContext = new StringBuilder();
            paramContext.append(paramXmlPullParser.getPositionDescription());
            paramContext.append(": <transition> tag requires 'fromId' & 'toId' attributes");
            throw new XmlPullParserException(paramContext.toString());
          }
          this.c.a(j, k, (Drawable)localObject1, bool);
          break;
          if (Build.VERSION.SDK_INT >= 21) {
            localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
          } else {
            localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
          }
        }
      }
      localObject1 = o.a(paramResources, paramTheme, paramAttributeSet, android.support.v7.a.a.T);
      j = ((TypedArray)localObject1).getResourceId(android.support.v7.a.a.V, 0);
      k = ((TypedArray)localObject1).getResourceId(android.support.v7.a.a.U, -1);
      if (k > 0) {}
      for (localObject2 = android.support.v7.b.a.a.b(paramContext, k);; localObject2 = null)
      {
        ((TypedArray)localObject1).recycle();
        int[] arrayOfInt = a(paramAttributeSet);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          do
          {
            k = paramXmlPullParser.next();
          } while (k == 4);
          if (k != 2)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramXmlPullParser.getPositionDescription());
            paramContext.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            throw new XmlPullParserException(paramContext.toString());
          }
          if (!paramXmlPullParser.getName().equals("vector")) {
            break label772;
          }
          localObject1 = l.a(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramXmlPullParser.getPositionDescription());
            paramContext.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            throw new XmlPullParserException(paramContext.toString());
          }
          this.c.a(arrayOfInt, (Drawable)localObject1, j);
          break;
          if (Build.VERSION.SDK_INT >= 21) {
            localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
          } else {
            localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
          }
        }
      }
    } while (j != 3);
    label818:
    onStateChange(getState());
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.c;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public void jumpToCurrentState()
  {
    super.jumpToCurrentState();
    g localg = this.d;
    if (localg != null)
    {
      localg.b();
      this.d = null;
      a(this.f);
      this.f = -1;
      this.e = -1;
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.b) && (super.mutate() == this))
    {
      this.c.a();
      this.b = true;
    }
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int j = this.c.a(paramArrayOfInt);
    int i = this.a;
    Object localObject1;
    boolean bool1;
    if (j != i)
    {
      localObject1 = this.d;
      if (localObject1 != null) {
        if (j != this.f) {
          if ((j == this.e) && (((g)localObject1).c()))
          {
            ((g)localObject1).d();
            this.f = this.e;
            this.e = j;
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = getCurrent();
      boolean bool2 = bool1;
      if (localObject1 != null) {
        bool2 = bool1 | ((Drawable)localObject1).setState(paramArrayOfInt);
      }
      return bool2;
      i = this.f;
      ((g)localObject1).b();
      for (;;)
      {
        this.d = null;
        this.e = -1;
        this.f = -1;
        localObject1 = this.c;
        int k = ((c)localObject1).a(i);
        int m = ((c)localObject1).a(j);
        if (m == 0) {}
        label156:
        Object localObject2;
        Long localLong;
        int n;
        do
        {
          do
          {
            if (a(j))
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          } while (k == 0);
          l = c.a(k, m);
          localObject2 = ((c)localObject1).a;
          localLong = Long.valueOf(-1L);
          n = (int)((Long)((android.support.v4.g.h)localObject2).a(l, localLong)).longValue();
        } while (n < 0);
        long l = c.a(k, m);
        if ((((Long)((c)localObject1).a.a(l, localLong)).longValue() & 0x200000000) != 0L) {}
        for (bool1 = true;; bool1 = false)
        {
          a(n);
          localObject2 = getCurrent();
          if (!(localObject2 instanceof AnimationDrawable))
          {
            if ((localObject2 instanceof android.support.d.a.b)) {}
            for (localObject1 = new d((android.support.d.a.b)localObject2);; localObject1 = new b((Animatable)localObject2))
            {
              ((g)localObject1).a();
              this.d = ((g)localObject1);
              this.e = i;
              this.f = j;
              bool1 = true;
              break;
              if (!(localObject2 instanceof Animatable)) {
                break label156;
              }
            }
          }
          l = c.a(k, m);
          if ((((Long)((c)localObject1).a.a(l, localLong)).longValue() & 0x100000000) != 0L) {}
          for (bool2 = true;; bool2 = false)
          {
            localObject1 = new e((AnimationDrawable)localObject2, bool2, bool1);
            break;
          }
        }
        bool1 = true;
        break;
      }
      bool1 = false;
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    g localg = this.d;
    if (localg != null) {
      if (!bool) {
        break label39;
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        jumpToCurrentState();
      }
      label39:
      do
      {
        return bool;
        localg.a();
        return bool;
      } while (!paramBoolean2);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */