package android.support.d.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.a.b;
import android.support.v4.g.v;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class l
  extends k
{
  public static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  public boolean c = true;
  public s d;
  private ColorFilter e;
  private boolean f;
  private PorterDuffColorFilter g;
  private final Rect h = new Rect();
  private final float[] i = new float[9];
  private final Matrix j = new Matrix();
  
  l()
  {
    this.d = new s();
  }
  
  l(s params)
  {
    this.d = params;
    this.g = a(params.j, params.k);
  }
  
  static int a(int paramInt, float paramFloat)
  {
    return 0xFFFFFF & paramInt | (int)(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  private final PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  public static l a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new l();
      ((l)localObject).b = android.support.v4.content.a.k.a(paramResources, paramInt, paramTheme);
      new t(((l)localObject).b.getConstantState());
      return (l)localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2)
      {
        paramResources = a(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
        return paramResources;
      }
    }
    catch (XmlPullParserException paramResources)
    {
      Log.e("VectorDrawableCompat", "parser error", paramResources);
      return null;
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        Log.e("VectorDrawableCompat", "parser error", paramResources);
      }
      throw new XmlPullParserException("No start tag found");
    }
  }
  
  public static l a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    l locall = new l();
    locall.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return locall;
  }
  
  public final boolean canApplyTheme()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      android.support.v4.a.a.a.c(localDrawable);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      ((Drawable)localObject1).draw(paramCanvas);
    }
    do
    {
      return;
      copyBounds(this.h);
    } while ((this.h.width() <= 0) || (this.h.height() <= 0));
    Object localObject2 = this.e;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.g;
    }
    paramCanvas.getMatrix(this.j);
    this.j.getValues(this.i);
    float f2 = Math.abs(this.i[0]);
    float f1 = Math.abs(this.i[4]);
    float f4 = Math.abs(this.i[1]);
    float f3 = Math.abs(this.i[3]);
    if (f4 != 0.0F)
    {
      f1 = 1.0F;
      f2 = 1.0F;
    }
    for (;;)
    {
      int k = this.h.width();
      int m = this.h.height();
      k = Math.min(2048, (int)(f2 * k));
      m = Math.min(2048, (int)(f1 * m));
      if ((k <= 0) || (m <= 0)) {
        break;
      }
      int n = paramCanvas.save();
      paramCanvas.translate(this.h.left, this.h.top);
      if ((Build.VERSION.SDK_INT < 17) || (!isAutoMirrored()) || (android.support.v4.a.a.a.g(this) != 1)) {}
      for (;;)
      {
        this.h.offsetTo(0, 0);
        localObject2 = this.d;
        Object localObject3 = ((s)localObject2).d;
        if (localObject3 == null) {}
        for (;;)
        {
          ((s)localObject2).d = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
          ((s)localObject2).b = true;
          do
          {
            if (!this.c) {
              this.d.a(k, m);
            }
            for (;;)
            {
              localObject2 = this.d;
              localObject3 = this.h;
              if (((s)localObject2).l.getRootAlpha() < 255)
              {
                if (((s)localObject2).i == null)
                {
                  ((s)localObject2).i = new Paint();
                  ((s)localObject2).i.setFilterBitmap(true);
                }
                ((s)localObject2).i.setAlpha(((s)localObject2).l.getRootAlpha());
                ((s)localObject2).i.setColorFilter((ColorFilter)localObject1);
              }
              for (localObject1 = ((s)localObject2).i;; localObject1 = null)
              {
                paramCanvas.drawBitmap(((s)localObject2).d, null, (Rect)localObject3, (Paint)localObject1);
                paramCanvas.restoreToCount(n);
                return;
                if (localObject1 != null) {
                  break;
                }
              }
              localObject2 = this.d;
              if ((((s)localObject2).b) || (((s)localObject2).f != ((s)localObject2).j) || (((s)localObject2).g != ((s)localObject2).k) || (((s)localObject2).c != ((s)localObject2).a) || (((s)localObject2).e != ((s)localObject2).l.getRootAlpha()))
              {
                this.d.a(k, m);
                localObject2 = this.d;
                ((s)localObject2).f = ((s)localObject2).j;
                ((s)localObject2).g = ((s)localObject2).k;
                ((s)localObject2).e = ((s)localObject2).l.getRootAlpha();
                ((s)localObject2).c = ((s)localObject2).a;
                ((s)localObject2).b = false;
              }
            }
            if (k != ((Bitmap)localObject3).getWidth()) {
              break;
            }
          } while (m == ((s)localObject2).d.getHeight());
        }
        paramCanvas.translate(this.h.width(), 0.0F);
        paramCanvas.scale(-1.0F, 1.0F);
      }
      if (f3 != 0.0F)
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
    }
  }
  
  public final int getAlpha()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return android.support.v4.a.a.a.b(localDrawable);
    }
    return this.d.l.getRootAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.d.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.b != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new t(this.b.getConstantState());
    }
    this.d.h = getChangingConfigurations();
    return this.d;
  }
  
  public final int getIntrinsicHeight()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return (int)this.d.l.b;
  }
  
  public final int getIntrinsicWidth()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return (int)this.d.l.c;
  }
  
  public final int getOpacity()
  {
    Drawable localDrawable = this.b;
    if (localDrawable == null) {
      return -3;
    }
    return localDrawable.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      android.support.v4.a.a.a.a((Drawable)localObject1, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    s locals = this.d;
    locals.l = new r();
    Object localObject3 = android.support.v4.content.a.o.a(paramResources, paramTheme, paramAttributeSet, a.l);
    Object localObject5 = this.d;
    Object localObject4 = ((s)localObject5).l;
    int k = android.support.v4.content.a.o.a((TypedArray)localObject3, paramXmlPullParser, "tintMode", 6, -1);
    Object localObject2 = PorterDuff.Mode.SRC_IN;
    localObject1 = localObject2;
    switch (k)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((s)localObject5).k = ((PorterDuff.Mode)localObject1);
      localObject1 = ((TypedArray)localObject3).getColorStateList(1);
      if (localObject1 != null) {
        ((s)localObject5).j = ((ColorStateList)localObject1);
      }
      boolean bool2 = ((s)localObject5).a;
      boolean bool1 = bool2;
      if (android.support.v4.content.a.o.a(paramXmlPullParser, "autoMirrored")) {
        bool1 = ((TypedArray)localObject3).getBoolean(5, bool2);
      }
      ((s)localObject5).a = bool1;
      ((r)localObject4).k = android.support.v4.content.a.o.a((TypedArray)localObject3, paramXmlPullParser, "viewportWidth", 7, ((r)localObject4).k);
      ((r)localObject4).j = android.support.v4.content.a.o.a((TypedArray)localObject3, paramXmlPullParser, "viewportHeight", 8, ((r)localObject4).j);
      if (((r)localObject4).k <= 0.0F)
      {
        paramResources = new StringBuilder();
        paramResources.append(((TypedArray)localObject3).getPositionDescription());
        paramResources.append("<vector> tag requires viewportWidth > 0");
        throw new XmlPullParserException(paramResources.toString());
      }
      if (((r)localObject4).j <= 0.0F)
      {
        paramResources = new StringBuilder();
        paramResources.append(((TypedArray)localObject3).getPositionDescription());
        paramResources.append("<vector> tag requires viewportHeight > 0");
        throw new XmlPullParserException(paramResources.toString());
      }
      ((r)localObject4).c = ((TypedArray)localObject3).getDimension(3, ((r)localObject4).c);
      ((r)localObject4).b = ((TypedArray)localObject3).getDimension(2, ((r)localObject4).b);
      if (((r)localObject4).c <= 0.0F)
      {
        paramResources = new StringBuilder();
        paramResources.append(((TypedArray)localObject3).getPositionDescription());
        paramResources.append("<vector> tag requires width > 0");
        throw new XmlPullParserException(paramResources.toString());
      }
      if (((r)localObject4).b <= 0.0F)
      {
        paramResources = new StringBuilder();
        paramResources.append(((TypedArray)localObject3).getPositionDescription());
        paramResources.append("<vector> tag requires height > 0");
        throw new XmlPullParserException(paramResources.toString());
      }
      ((r)localObject4).setAlpha(android.support.v4.content.a.o.a((TypedArray)localObject3, paramXmlPullParser, "alpha", 4, ((r)localObject4).getAlpha()));
      localObject1 = ((TypedArray)localObject3).getString(0);
      if (localObject1 != null)
      {
        ((r)localObject4).g = ((String)localObject1);
        ((r)localObject4).i.put(localObject1, localObject4);
      }
      ((TypedArray)localObject3).recycle();
      locals.h = getChangingConfigurations();
      locals.b = true;
      localObject2 = this.d;
      localObject3 = ((s)localObject2).l;
      localObject4 = new ArrayDeque();
      ((ArrayDeque)localObject4).push(((r)localObject3).f);
      int m = paramXmlPullParser.getEventType();
      int n = paramXmlPullParser.getDepth();
      k = 1;
      if (m != 1)
      {
        if (paramXmlPullParser.getDepth() >= n + 1) {}
        label743:
        label832:
        label888:
        while (m != 3)
        {
          Object localObject6;
          Object localObject7;
          if (m == 2)
          {
            localObject1 = paramXmlPullParser.getName();
            localObject5 = (o)((ArrayDeque)localObject4).peek();
            if ("path".equals(localObject1))
            {
              localObject6 = new n();
              localObject7 = android.support.v4.content.a.o.a(paramResources, paramTheme, paramAttributeSet, a.k);
              ((n)localObject6).j = null;
              if (android.support.v4.content.a.o.a(paramXmlPullParser, "pathData"))
              {
                localObject1 = ((TypedArray)localObject7).getString(0);
                if (localObject1 != null) {
                  ((n)localObject6).p = ((String)localObject1);
                }
                localObject1 = ((TypedArray)localObject7).getString(2);
                if (localObject1 == null)
                {
                  ((n)localObject6).b = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, paramTheme, "fillColor", 1);
                  ((n)localObject6).a = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, "fillAlpha", 12, ((n)localObject6).a);
                  k = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, "strokeLineCap", 8, -1);
                  localObject1 = ((n)localObject6).f;
                }
              }
              else
              {
                switch (k)
                {
                default: 
                  ((n)localObject6).f = ((Paint.Cap)localObject1);
                  k = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, "strokeLineJoin", 9, -1);
                  localObject1 = ((n)localObject6).g;
                  switch (k)
                  {
                  default: 
                    ((n)localObject6).g = ((Paint.Join)localObject1);
                    ((n)localObject6).h = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, "strokeMiterLimit", 10, ((n)localObject6).h);
                    ((n)localObject6).e = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, paramTheme, "strokeColor", 3);
                    ((n)localObject6).d = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, "strokeAlpha", 11, ((n)localObject6).d);
                    ((n)localObject6).i = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, "strokeWidth", 4, ((n)localObject6).i);
                    ((n)localObject6).k = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, "trimPathEnd", 6, ((n)localObject6).k);
                    ((n)localObject6).l = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, "trimPathOffset", 7, ((n)localObject6).l);
                    ((n)localObject6).m = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, "trimPathStart", 5, ((n)localObject6).m);
                    ((n)localObject6).c = android.support.v4.content.a.o.a((TypedArray)localObject7, paramXmlPullParser, "fillType", 13, ((n)localObject6).c);
                    ((TypedArray)localObject7).recycle();
                    ((o)localObject5).b.add(localObject6);
                    if (((q)localObject6).getPathName() != null) {
                      ((r)localObject3).i.put(((q)localObject6).getPathName(), localObject6);
                    }
                    ((s)localObject2).h |= ((n)localObject6).n;
                    k = 0;
                  }
                  break;
                }
              }
            }
          }
          for (;;)
          {
            m = paramXmlPullParser.next();
            break;
            localObject1 = Paint.Join.BEVEL;
            break label888;
            localObject1 = Paint.Join.ROUND;
            break label888;
            localObject1 = Paint.Join.MITER;
            break label888;
            localObject1 = Paint.Cap.SQUARE;
            break label832;
            localObject1 = Paint.Cap.ROUND;
            break label832;
            localObject1 = Paint.Cap.BUTT;
            break label832;
            ((n)localObject6).o = b.b((String)localObject1);
            break label743;
            if ("clip-path".equals(localObject1))
            {
              localObject1 = new m();
              if (android.support.v4.content.a.o.a(paramXmlPullParser, "pathData"))
              {
                localObject6 = android.support.v4.content.a.o.a(paramResources, paramTheme, paramAttributeSet, a.i);
                localObject7 = ((TypedArray)localObject6).getString(0);
                if (localObject7 != null) {
                  ((m)localObject1).p = ((String)localObject7);
                }
                localObject7 = ((TypedArray)localObject6).getString(1);
                if (localObject7 != null) {
                  ((m)localObject1).o = b.b((String)localObject7);
                }
                ((TypedArray)localObject6).recycle();
              }
              ((o)localObject5).b.add(localObject1);
              if (((q)localObject1).getPathName() != null) {
                ((r)localObject3).i.put(((q)localObject1).getPathName(), localObject1);
              }
              ((s)localObject2).h |= ((m)localObject1).n;
            }
            else if ("group".equals(localObject1))
            {
              localObject1 = new o();
              localObject6 = android.support.v4.content.a.o.a(paramResources, paramTheme, paramAttributeSet, a.j);
              ((o)localObject1).k = null;
              ((o)localObject1).g = android.support.v4.content.a.o.a((TypedArray)localObject6, paramXmlPullParser, "rotation", 5, ((o)localObject1).g);
              ((o)localObject1).e = ((TypedArray)localObject6).getFloat(1, ((o)localObject1).e);
              ((o)localObject1).f = ((TypedArray)localObject6).getFloat(2, ((o)localObject1).f);
              ((o)localObject1).h = android.support.v4.content.a.o.a((TypedArray)localObject6, paramXmlPullParser, "scaleX", 3, ((o)localObject1).h);
              ((o)localObject1).i = android.support.v4.content.a.o.a((TypedArray)localObject6, paramXmlPullParser, "scaleY", 4, ((o)localObject1).i);
              ((o)localObject1).l = android.support.v4.content.a.o.a((TypedArray)localObject6, paramXmlPullParser, "translateX", 6, ((o)localObject1).l);
              ((o)localObject1).m = android.support.v4.content.a.o.a((TypedArray)localObject6, paramXmlPullParser, "translateY", 7, ((o)localObject1).m);
              localObject7 = ((TypedArray)localObject6).getString(0);
              if (localObject7 != null) {
                ((o)localObject1).c = ((String)localObject7);
              }
              ((o)localObject1).a();
              ((TypedArray)localObject6).recycle();
              ((o)localObject5).b.add(localObject1);
              ((ArrayDeque)localObject4).push(localObject1);
              if (((o)localObject1).getGroupName() != null) {
                ((r)localObject3).i.put(((o)localObject1).getGroupName(), localObject1);
              }
              ((s)localObject2).h |= ((o)localObject1).a;
            }
            else
            {
              continue;
              if (m == 3) {
                if ("group".equals(paramXmlPullParser.getName())) {
                  ((ArrayDeque)localObject4).pop();
                } else {}
              }
            }
          }
        }
      }
      if (k != 0) {
        throw new XmlPullParserException("no path defined");
      }
      this.g = a(locals.j, locals.k);
      return;
      localObject1 = PorterDuff.Mode.ADD;
      continue;
      localObject1 = PorterDuff.Mode.SCREEN;
      continue;
      localObject1 = PorterDuff.Mode.MULTIPLY;
      continue;
      localObject1 = PorterDuff.Mode.SRC_ATOP;
      continue;
      localObject1 = PorterDuff.Mode.SRC_IN;
      continue;
      localObject1 = PorterDuff.Mode.SRC_OVER;
    }
  }
  
  public final void invalidateSelf()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isAutoMirrored()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return android.support.v4.a.a.a.a(localDrawable);
    }
    return this.d.a;
  }
  
  public final boolean isStateful()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    Object localObject = this.b;
    if (localObject != null) {
      bool1 = ((Drawable)localObject).isStateful();
    }
    do
    {
      return bool1;
      bool1 = bool2;
      if (super.isStateful()) {
        break;
      }
      localObject = this.d;
      if (localObject == null) {
        break label120;
      }
      localObject = ((s)localObject).l;
      if (((r)localObject).e == null) {
        ((r)localObject).e = Boolean.valueOf(((r)localObject).f.b());
      }
      bool1 = bool2;
      if (((r)localObject).e.booleanValue()) {
        break;
      }
      localObject = this.d.j;
      if (localObject == null) {
        break label115;
      }
      bool1 = bool3;
    } while (!((ColorStateList)localObject).isStateful());
    boolean bool1 = bool2;
    for (;;)
    {
      return bool1;
      label115:
      bool1 = false;
      continue;
      label120:
      bool1 = false;
    }
  }
  
  public final Drawable mutate()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.mutate();
    }
    while ((this.f) || (super.mutate() != this)) {
      return this;
    }
    this.d = new s(this.d);
    this.f = true;
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    Object localObject1 = this.b;
    if (localObject1 != null) {
      return ((Drawable)localObject1).setState(paramArrayOfInt);
    }
    localObject1 = this.d;
    Object localObject2 = ((s)localObject1).j;
    boolean bool1 = bool2;
    if (localObject2 != null)
    {
      PorterDuff.Mode localMode = ((s)localObject1).k;
      bool1 = bool2;
      if (localMode != null)
      {
        this.g = a((ColorStateList)localObject2, localMode);
        invalidateSelf();
        bool1 = true;
      }
    }
    localObject2 = ((s)localObject1).l;
    if (((r)localObject2).e == null) {
      ((r)localObject2).e = Boolean.valueOf(((r)localObject2).f.b());
    }
    if (((r)localObject2).e.booleanValue())
    {
      bool2 = ((s)localObject1).l.f.a(paramArrayOfInt);
      ((s)localObject1).b |= bool2;
      if (bool2)
      {
        invalidateSelf();
        return true;
      }
    }
    return bool1;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.setAlpha(paramInt);
    }
    while (this.d.l.getRootAlpha() == paramInt) {
      return;
    }
    this.d.l.setRootAlpha(paramInt);
    invalidateSelf();
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      android.support.v4.a.a.a.a(localDrawable, paramBoolean);
      return;
    }
    this.d.a = paramBoolean;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.e = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      android.support.v4.a.a.a.a(localDrawable, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    Object localObject = this.b;
    if (localObject != null) {
      android.support.v4.a.a.a.a((Drawable)localObject, paramColorStateList);
    }
    do
    {
      return;
      localObject = this.d;
    } while (((s)localObject).j == paramColorStateList);
    ((s)localObject).j = paramColorStateList;
    this.g = a(paramColorStateList, ((s)localObject).k);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    Object localObject = this.b;
    if (localObject != null) {
      android.support.v4.a.a.a.a((Drawable)localObject, paramMode);
    }
    do
    {
      return;
      localObject = this.d;
    } while (((s)localObject).k == paramMode);
    ((s)localObject).k = paramMode;
    this.g = a(((s)localObject).j, paramMode);
    invalidateSelf();
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */