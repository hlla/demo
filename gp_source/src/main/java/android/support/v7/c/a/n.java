package android.support.v7.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class n
  extends h
{
  private boolean b;
  private o c;
  
  n()
  {
    this(null, null);
  }
  
  n(byte paramByte) {}
  
  n(o paramo, Resources paramResources)
  {
    a(new o(paramo, this, paramResources));
    onStateChange(getState());
  }
  
  static int[] a(AttributeSet paramAttributeSet)
  {
    int n = paramAttributeSet.getAttributeCount();
    int[] arrayOfInt = new int[n];
    int j = 0;
    int i = 0;
    if (j < n)
    {
      int m = paramAttributeSet.getAttributeNameResource(j);
      switch (m)
      {
      default: 
        int k = m;
        if (!paramAttributeSet.getAttributeBooleanValue(j, false)) {
          k = -m;
        }
        arrayOfInt[i] = k;
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
      }
    }
    return StateSet.trimStateSet(arrayOfInt, i);
  }
  
  o a()
  {
    return new o(this.c, this, null);
  }
  
  protected void a(k paramk)
  {
    super.a(paramk);
    if ((paramk instanceof o)) {
      this.c = ((o)paramk);
    }
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    super.applyTheme(paramTheme);
    onStateChange(getState());
  }
  
  public void b(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject1 = android.support.v4.content.a.o.a(paramResources, paramTheme, paramAttributeSet, android.support.v7.a.a.cC);
    setVisible(((TypedArray)localObject1).getBoolean(android.support.v7.a.a.cK, true), true);
    Object localObject2 = this.c;
    if (Build.VERSION.SDK_INT >= 21) {
      ((o)localObject2).c |= ((TypedArray)localObject1).getChangingConfigurations();
    }
    ((o)localObject2).C = ((TypedArray)localObject1).getBoolean(android.support.v7.a.a.cJ, ((o)localObject2).C);
    ((o)localObject2).n = ((TypedArray)localObject1).getBoolean(android.support.v7.a.a.cF, ((o)localObject2).n);
    ((o)localObject2).r = ((TypedArray)localObject1).getInt(android.support.v7.a.a.cH, ((o)localObject2).r);
    ((o)localObject2).s = ((TypedArray)localObject1).getInt(android.support.v7.a.a.cI, ((o)localObject2).s);
    ((o)localObject2).p = ((TypedArray)localObject1).getBoolean(android.support.v7.a.a.cG, ((o)localObject2).p);
    a(paramResources);
    ((TypedArray)localObject1).recycle();
    o localo = this.c;
    int i = paramXmlPullParser.getDepth() + 1;
    int j;
    label385:
    do
    {
      int k;
      while ((j != 2) || (k > i) || (!paramXmlPullParser.getName().equals("item")))
      {
        j = paramXmlPullParser.next();
        if (j == 1) {
          break label409;
        }
        k = paramXmlPullParser.getDepth();
        if (k < i) {
          break;
        }
      }
      localObject2 = android.support.v4.content.a.o.a(paramResources, paramTheme, paramAttributeSet, android.support.v7.a.a.cD);
      j = ((TypedArray)localObject2).getResourceId(android.support.v7.a.a.cE, -1);
      if (j > 0) {}
      for (localObject1 = android.support.v7.b.a.a.b(paramContext, j);; localObject1 = null)
      {
        ((TypedArray)localObject2).recycle();
        int[] arrayOfInt = a(paramAttributeSet);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          do
          {
            j = paramXmlPullParser.next();
          } while (j == 4);
          if (j != 2)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramXmlPullParser.getPositionDescription());
            paramContext.append(": <item> tag requires a 'drawable' attribute or ");
            paramContext.append("child tag defining a drawable");
            throw new XmlPullParserException(paramContext.toString());
          }
          if (Build.VERSION.SDK_INT < 21) {
            break label385;
          }
        }
        for (localObject2 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);; localObject2 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet))
        {
          localo.a(arrayOfInt, (Drawable)localObject2);
          break;
        }
      }
    } while (j != 3);
    label409:
    onStateChange(getState());
  }
  
  public boolean isStateful()
  {
    return true;
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
    boolean bool = super.onStateChange(paramArrayOfInt);
    int j = this.c.b(paramArrayOfInt);
    int i = j;
    if (j < 0) {
      i = this.c.b(StateSet.WILD_CARD);
    }
    if (a(i)) {}
    while (bool) {
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/c/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */