package android.support.b.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public final class f
  extends e
{
  static final PorterDuff.Mode mk = PorterDuff.Mode.SRC_IN;
  f ml;
  private PorterDuffColorFilter mm;
  private ColorFilter mn;
  private boolean mo;
  boolean mp = true;
  private Drawable.ConstantState mq;
  private final float[] mr = new float[9];
  private final Matrix ms = new Matrix();
  private final Rect mt = new Rect();
  
  private f()
  {
    this.ml = new f();
  }
  
  private f(f paramf)
  {
    this.ml = paramf;
    this.mm = a(paramf.nk, paramf.nl);
  }
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  public static f a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = new f();
      if (Build.VERSION.SDK_INT >= 21) {}
      for (paramResources = paramResources.getDrawable(paramInt, paramTheme);; paramResources = paramResources.getDrawable(paramInt))
      {
        ((f)localObject).mj = paramResources;
        ((f)localObject).mq = new g(((f)localObject).mj.getConstantState());
        return (f)localObject;
      }
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2) {
        throw new XmlPullParserException("No start tag found");
      }
      paramResources = a(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      return paramResources;
    }
    catch (IOException paramResources) {}catch (XmlPullParserException paramResources) {}
    return null;
  }
  
  public static f a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    f localf = new f();
    localf.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localf;
  }
  
  private void b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    f localf = this.ml;
    e locale = localf.nj;
    int i = 1;
    Stack localStack = new Stack();
    localStack.push(locale.nb);
    int j = paramXmlPullParser.getEventType();
    if (j != 1)
    {
      Object localObject;
      c localc;
      TypedArray localTypedArray;
      if (j == 2)
      {
        localObject = paramXmlPullParser.getName();
        localc = (c)localStack.peek();
        if ("path".equals(localObject))
        {
          localObject = new b();
          localTypedArray = e.a(paramResources, paramTheme, paramAttributeSet, a.lS);
          ((b)localObject).a(localTypedArray, paramXmlPullParser);
          localTypedArray.recycle();
          localc.mI.add(localObject);
          if (((d)localObject).mT != null) {
            locale.ni.put(((d)localObject).mT, localObject);
          }
          i = 0;
          j = localf.ma;
          localf.ma = (((b)localObject).ma | j);
        }
      }
      for (;;)
      {
        j = paramXmlPullParser.next();
        break;
        if ("clip-path".equals(localObject))
        {
          localObject = new a();
          if (d.a(paramXmlPullParser, "pathData"))
          {
            localTypedArray = e.a(paramResources, paramTheme, paramAttributeSet, a.lT);
            ((a)localObject).a(localTypedArray);
            localTypedArray.recycle();
          }
          localc.mI.add(localObject);
          if (((d)localObject).mT != null) {
            locale.ni.put(((d)localObject).mT, localObject);
          }
          localf.ma |= ((a)localObject).ma;
        }
        else
        {
          if ("group".equals(localObject))
          {
            localObject = new c();
            localTypedArray = e.a(paramResources, paramTheme, paramAttributeSet, a.lR);
            ((c)localObject).mu = null;
            ((c)localObject).mJ = d.a(localTypedArray, paramXmlPullParser, "rotation", 5, ((c)localObject).mJ);
            ((c)localObject).mK = localTypedArray.getFloat(1, ((c)localObject).mK);
            ((c)localObject).mL = localTypedArray.getFloat(2, ((c)localObject).mL);
            ((c)localObject).mM = d.a(localTypedArray, paramXmlPullParser, "scaleX", 3, ((c)localObject).mM);
            ((c)localObject).mN = d.a(localTypedArray, paramXmlPullParser, "scaleY", 4, ((c)localObject).mN);
            ((c)localObject).mO = d.a(localTypedArray, paramXmlPullParser, "translateX", 6, ((c)localObject).mO);
            ((c)localObject).mP = d.a(localTypedArray, paramXmlPullParser, "translateY", 7, ((c)localObject).mP);
            String str = localTypedArray.getString(0);
            if (str != null) {
              ((c)localObject).mR = str;
            }
            ((c)localObject).mQ.reset();
            ((c)localObject).mQ.postTranslate(-((c)localObject).mK, -((c)localObject).mL);
            ((c)localObject).mQ.postScale(((c)localObject).mM, ((c)localObject).mN);
            ((c)localObject).mQ.postRotate(((c)localObject).mJ, 0.0F, 0.0F);
            ((c)localObject).mQ.postTranslate(((c)localObject).mO + ((c)localObject).mK, ((c)localObject).mP + ((c)localObject).mL);
            localTypedArray.recycle();
            localc.mI.add(localObject);
            localStack.push(localObject);
            if (((c)localObject).mR != null) {
              locale.ni.put(((c)localObject).mR, localObject);
            }
            localf.ma |= ((c)localObject).ma;
          }
          continue;
          if ((j == 3) && ("group".equals(paramXmlPullParser.getName()))) {
            localStack.pop();
          }
        }
      }
    }
    if (i != 0)
    {
      paramResources = new StringBuffer();
      if (paramResources.length() > 0) {
        paramResources.append(" or ");
      }
      paramResources.append("path");
      throw new XmlPullParserException("no " + paramResources + " defined");
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (this.mj != null) {
      android.support.v4.b.a.a.e(this.mj);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    float f2 = 1.0F;
    if (this.mj != null) {
      this.mj.draw(paramCanvas);
    }
    do
    {
      return;
      copyBounds(this.mt);
    } while ((this.mt.width() <= 0) || (this.mt.height() <= 0));
    Object localObject;
    float f3;
    float f1;
    if (this.mn == null)
    {
      localObject = this.mm;
      paramCanvas.getMatrix(this.ms);
      this.ms.getValues(this.mr);
      f3 = Math.abs(this.mr[0]);
      f1 = Math.abs(this.mr[4]);
      float f4 = Math.abs(this.mr[1]);
      float f5 = Math.abs(this.mr[3]);
      if ((f4 == 0.0F) && (f5 == 0.0F)) {
        break label617;
      }
      f1 = 1.0F;
    }
    for (;;)
    {
      int j = (int)(f2 * this.mt.width());
      int i = (int)(f1 * this.mt.height());
      int k = Math.min(2048, j);
      int m = Math.min(2048, i);
      if ((k <= 0) || (m <= 0)) {
        break;
      }
      j = paramCanvas.save();
      paramCanvas.translate(this.mt.left, this.mt.top);
      this.mt.offsetTo(0, 0);
      f localf = this.ml;
      if (localf.nn != null)
      {
        if ((k != localf.nn.getWidth()) || (m != localf.nn.getHeight())) {
          break label387;
        }
        i = 1;
        label271:
        if (i != 0) {}
      }
      else
      {
        localf.nn = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
        localf.ns = true;
      }
      label315:
      Rect localRect;
      if (!this.mp)
      {
        this.ml.f(k, m);
        localf = this.ml;
        localRect = this.mt;
        if (localf.nj.ng >= 255) {
          break label545;
        }
        i = 1;
        label344:
        if ((i != 0) || (localObject != null)) {
          break label551;
        }
      }
      for (localObject = null;; localObject = localf.nt)
      {
        paramCanvas.drawBitmap(localf.nn, null, localRect, (Paint)localObject);
        paramCanvas.restoreToCount(j);
        return;
        localObject = this.mn;
        break;
        label387:
        i = 0;
        break label271;
        localf = this.ml;
        if ((!localf.ns) && (localf.no == localf.nk) && (localf.np == localf.nl) && (localf.nr == localf.nm) && (localf.nq == localf.nj.ng)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label543;
          }
          this.ml.f(k, m);
          localf = this.ml;
          localf.no = localf.nk;
          localf.np = localf.nl;
          localf.nq = localf.nj.ng;
          localf.nr = localf.nm;
          localf.ns = false;
          break;
        }
        label543:
        break label315;
        label545:
        i = 0;
        break label344;
        label551:
        if (localf.nt == null)
        {
          localf.nt = new Paint();
          localf.nt.setFilterBitmap(true);
        }
        localf.nt.setAlpha(localf.nj.ng);
        localf.nt.setColorFilter((ColorFilter)localObject);
      }
      label617:
      f2 = f3;
    }
  }
  
  public final int getAlpha()
  {
    if (this.mj != null) {
      return android.support.v4.b.a.a.d(this.mj);
    }
    return this.ml.nj.ng;
  }
  
  public final int getChangingConfigurations()
  {
    if (this.mj != null) {
      return this.mj.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.ml.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.mj != null) {
      return new g(this.mj.getConstantState());
    }
    this.ml.ma = getChangingConfigurations();
    return this.ml;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.mj != null) {
      return this.mj.getIntrinsicHeight();
    }
    return (int)this.ml.nj.nd;
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.mj != null) {
      return this.mj.getIntrinsicWidth();
    }
    return (int)this.ml.nj.nc;
  }
  
  public final int getOpacity()
  {
    if (this.mj != null) {
      return this.mj.getOpacity();
    }
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (this.mj != null)
    {
      this.mj.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.mj != null)
    {
      android.support.v4.b.a.a.a(this.mj, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    f localf1 = this.ml;
    localf1.nj = new e();
    TypedArray localTypedArray = a(paramResources, paramTheme, paramAttributeSet, a.lQ);
    f localf2 = this.ml;
    e locale = localf2.nj;
    int i = d.a(localTypedArray, paramXmlPullParser, "tintMode", 6);
    PorterDuff.Mode localMode = PorterDuff.Mode.SRC_IN;
    Object localObject = localMode;
    boolean bool;
    switch (i)
    {
    default: 
      localObject = localMode;
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
      localf2.nl = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        localf2.nk = ((ColorStateList)localObject);
      }
      bool = localf2.nm;
      if (d.a(paramXmlPullParser, "autoMirrored")) {
        break;
      }
    }
    for (;;)
    {
      localf2.nm = bool;
      locale.ne = d.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, locale.ne);
      locale.nf = d.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, locale.nf);
      if (locale.ne > 0.0F) {
        break label356;
      }
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
      localObject = PorterDuff.Mode.SRC_OVER;
      break;
      localObject = PorterDuff.Mode.SRC_IN;
      break;
      localObject = PorterDuff.Mode.SRC_ATOP;
      break;
      localObject = PorterDuff.Mode.MULTIPLY;
      break;
      localObject = PorterDuff.Mode.SCREEN;
      break;
      localObject = PorterDuff.Mode.ADD;
      break;
      bool = localTypedArray.getBoolean(5, bool);
    }
    label356:
    if (locale.nf <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    locale.nc = localTypedArray.getDimension(3, locale.nc);
    locale.nd = localTypedArray.getDimension(2, locale.nd);
    if (locale.nc <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (locale.nd <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    locale.ng = ((int)(d.a(localTypedArray, paramXmlPullParser, "alpha", 4, locale.ng / 255.0F) * 255.0F));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      locale.nh = ((String)localObject);
      locale.ni.put(localObject, locale);
    }
    localTypedArray.recycle();
    localf1.ma = getChangingConfigurations();
    localf1.ns = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.mm = a(localf1.nk, localf1.nl);
  }
  
  public final void invalidateSelf()
  {
    if (this.mj != null)
    {
      this.mj.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isStateful()
  {
    if (this.mj != null) {
      return this.mj.isStateful();
    }
    return (super.isStateful()) || ((this.ml != null) && (this.ml.nk != null) && (this.ml.nk.isStateful()));
  }
  
  public final Drawable mutate()
  {
    if (this.mj != null) {
      this.mj.mutate();
    }
    while ((this.mo) || (super.mutate() != this)) {
      return this;
    }
    this.ml = new f(this.ml);
    this.mo = true;
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.mj != null) {
      this.mj.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mj != null) {
      return this.mj.setState(paramArrayOfInt);
    }
    paramArrayOfInt = this.ml;
    if ((paramArrayOfInt.nk != null) && (paramArrayOfInt.nl != null))
    {
      this.mm = a(paramArrayOfInt.nk, paramArrayOfInt.nl);
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.mj != null)
    {
      this.mj.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.mj != null) {
      this.mj.setAlpha(paramInt);
    }
    while (this.ml.nj.ng == paramInt) {
      return;
    }
    this.ml.nj.ng = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mj != null)
    {
      this.mj.setColorFilter(paramColorFilter);
      return;
    }
    this.mn = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    if (this.mj != null)
    {
      android.support.v4.b.a.a.a(this.mj, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.mj != null) {
      android.support.v4.b.a.a.a(this.mj, paramColorStateList);
    }
    f localf;
    do
    {
      return;
      localf = this.ml;
    } while (localf.nk == paramColorStateList);
    localf.nk = paramColorStateList;
    this.mm = a(paramColorStateList, localf.nl);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mj != null) {
      android.support.v4.b.a.a.a(this.mj, paramMode);
    }
    f localf;
    do
    {
      return;
      localf = this.ml;
    } while (localf.nl == paramMode);
    localf.nl = paramMode;
    this.mm = a(localf.nk, paramMode);
    invalidateSelf();
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mj != null) {
      return this.mj.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.mj != null)
    {
      this.mj.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  private static final class a
    extends f.d
  {
    public a() {}
    
    public a(a parama)
    {
      super();
    }
    
    final void a(TypedArray paramTypedArray)
    {
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.mT = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.mS = c.g(paramTypedArray);
      }
    }
    
    public final boolean aA()
    {
      return true;
    }
  }
  
  private static final class b
    extends f.d
  {
    float mA = 1.0F;
    float mB = 0.0F;
    float mC = 1.0F;
    float mD = 0.0F;
    Paint.Cap mE = Paint.Cap.BUTT;
    Paint.Join mF = Paint.Join.MITER;
    float mG = 4.0F;
    private int[] mu;
    int mv = 0;
    float mw = 0.0F;
    int mx = 0;
    float my = 1.0F;
    int mz;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.mu = paramb.mu;
      this.mv = paramb.mv;
      this.mw = paramb.mw;
      this.my = paramb.my;
      this.mx = paramb.mx;
      this.mz = paramb.mz;
      this.mA = paramb.mA;
      this.mB = paramb.mB;
      this.mC = paramb.mC;
      this.mD = paramb.mD;
      this.mE = paramb.mE;
      this.mF = paramb.mF;
      this.mG = paramb.mG;
    }
    
    final void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.mu = null;
      if (!d.a(paramXmlPullParser, "pathData")) {
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        this.mT = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        this.mS = c.g((String)localObject);
      }
      this.mx = d.a(paramTypedArray, paramXmlPullParser, "fillColor", 1, this.mx);
      this.mA = d.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.mA);
      int i = d.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8);
      localObject = this.mE;
      switch (i)
      {
      default: 
        this.mE = ((Paint.Cap)localObject);
        i = d.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9);
        localObject = this.mF;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        this.mF = ((Paint.Join)localObject);
        this.mG = d.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.mG);
        this.mv = d.a(paramTypedArray, paramXmlPullParser, "strokeColor", 3, this.mv);
        this.my = d.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.my);
        this.mw = d.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.mw);
        this.mC = d.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.mC);
        this.mD = d.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.mD);
        this.mB = d.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.mB);
        return;
        localObject = Paint.Cap.BUTT;
        break;
        localObject = Paint.Cap.ROUND;
        break;
        localObject = Paint.Cap.SQUARE;
        break;
        localObject = Paint.Join.MITER;
        continue;
        localObject = Paint.Join.ROUND;
        continue;
        localObject = Paint.Join.BEVEL;
      }
    }
  }
  
  private static final class c
  {
    public final Matrix mH = new Matrix();
    final ArrayList<Object> mI = new ArrayList();
    public float mJ = 0.0F;
    float mK = 0.0F;
    float mL = 0.0F;
    float mM = 1.0F;
    float mN = 1.0F;
    float mO = 0.0F;
    float mP = 0.0F;
    public final Matrix mQ = new Matrix();
    String mR = null;
    public int ma;
    int[] mu;
    
    public c() {}
    
    public c(c paramc, android.support.v4.e.a<String, Object> parama)
    {
      this.mJ = paramc.mJ;
      this.mK = paramc.mK;
      this.mL = paramc.mL;
      this.mM = paramc.mM;
      this.mN = paramc.mN;
      this.mO = paramc.mO;
      this.mP = paramc.mP;
      this.mu = paramc.mu;
      this.mR = paramc.mR;
      this.ma = paramc.ma;
      if (this.mR != null) {
        parama.put(this.mR, this);
      }
      this.mQ.set(paramc.mQ);
      ArrayList localArrayList = paramc.mI;
      int i = 0;
      while (i < localArrayList.size())
      {
        paramc = localArrayList.get(i);
        if ((paramc instanceof c))
        {
          paramc = (c)paramc;
          this.mI.add(new c(paramc, parama));
          i += 1;
        }
        else
        {
          if ((paramc instanceof f.b)) {}
          for (paramc = new f.b((f.b)paramc);; paramc = new f.a((f.a)paramc))
          {
            this.mI.add(paramc);
            if (paramc.mT == null) {
              break;
            }
            parama.put(paramc.mT, paramc);
            break;
            if (!(paramc instanceof f.a)) {
              break label315;
            }
          }
          label315:
          throw new IllegalStateException("Unknown object in the tree!");
        }
      }
    }
  }
  
  private static class d
  {
    protected c.b[] mS = null;
    String mT;
    int ma;
    
    public d() {}
    
    public d(d paramd)
    {
      this.mT = paramd.mT;
      this.ma = paramd.ma;
      this.mS = c.a(paramd.mS);
    }
    
    public final void a(Path paramPath)
    {
      paramPath.reset();
      c.b[] arrayOfb;
      float[] arrayOfFloat1;
      int k;
      int j;
      float[] arrayOfFloat2;
      float f4;
      float f3;
      float f6;
      float f1;
      float f2;
      int m;
      float f7;
      float f8;
      label290:
      label482:
      float f9;
      if (this.mS != null)
      {
        arrayOfb = this.mS;
        arrayOfFloat1 = new float[6];
        k = 0;
        j = 109;
        if (k < arrayOfb.length)
        {
          int n = arrayOfb[k].mh;
          arrayOfFloat2 = arrayOfb[k].mi;
          f4 = arrayOfFloat1[0];
          f3 = arrayOfFloat1[1];
          f6 = arrayOfFloat1[2];
          f5 = arrayOfFloat1[3];
          f1 = arrayOfFloat1[4];
          f2 = arrayOfFloat1[5];
          int i;
          switch (n)
          {
          default: 
            i = 2;
            m = 0;
            f7 = f3;
            f3 = f4;
            f4 = f7;
            f7 = f6;
            f8 = f5;
            if (m < arrayOfFloat2.length) {
              switch (n)
              {
              default: 
                f5 = f2;
                f2 = f4;
                f4 = f3;
                f3 = f2;
                f2 = f1;
                f6 = f7;
                f1 = f5;
                f5 = f8;
              }
            }
            break;
          case 90: 
          case 122: 
          case 76: 
          case 77: 
          case 84: 
          case 108: 
          case 109: 
          case 116: 
          case 72: 
          case 86: 
          case 104: 
          case 118: 
          case 67: 
          case 99: 
          case 81: 
          case 83: 
          case 113: 
          case 115: 
          case 65: 
          case 97: 
            for (;;)
            {
              m += i;
              f9 = f2;
              float f10 = f4;
              j = n;
              f8 = f5;
              f7 = f6;
              f2 = f1;
              f1 = f9;
              f4 = f3;
              f3 = f10;
              break label290;
              paramPath.close();
              paramPath.moveTo(f1, f2);
              f5 = f2;
              f6 = f1;
              f3 = f2;
              f4 = f1;
              i = 2;
              break;
              i = 2;
              break;
              i = 1;
              break;
              i = 6;
              break;
              i = 4;
              break;
              i = 7;
              break;
              f3 += arrayOfFloat2[(m + 0)];
              f4 += arrayOfFloat2[(m + 1)];
              if (m > 0)
              {
                paramPath.rLineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                f9 = f3;
                f3 = f2;
                f2 = f1;
                f5 = f8;
                f1 = f3;
                f6 = f7;
                f3 = f4;
                f4 = f9;
              }
              else
              {
                paramPath.rMoveTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                f10 = f4;
                f9 = f3;
                f5 = f8;
                f1 = f4;
                f6 = f7;
                f2 = f3;
                f3 = f10;
                f4 = f9;
                continue;
                f3 = arrayOfFloat2[(m + 0)];
                f4 = arrayOfFloat2[(m + 1)];
                if (m > 0)
                {
                  paramPath.lineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                  f9 = f3;
                  f3 = f2;
                  f2 = f1;
                  f5 = f8;
                  f1 = f3;
                  f6 = f7;
                  f3 = f4;
                  f4 = f9;
                }
                else
                {
                  paramPath.moveTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                  f10 = f4;
                  f9 = f3;
                  f5 = f8;
                  f1 = f4;
                  f6 = f7;
                  f2 = f3;
                  f3 = f10;
                  f4 = f9;
                  continue;
                  paramPath.rLineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                  f5 = arrayOfFloat2[(m + 0)];
                  f4 += arrayOfFloat2[(m + 1)];
                  f9 = f3 + f5;
                  f3 = f2;
                  f2 = f1;
                  f5 = f8;
                  f1 = f3;
                  f6 = f7;
                  f3 = f4;
                  f4 = f9;
                  continue;
                  paramPath.lineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                  f4 = arrayOfFloat2[(m + 0)];
                  f9 = arrayOfFloat2[(m + 1)];
                  f3 = f2;
                  f2 = f1;
                  f5 = f8;
                  f1 = f3;
                  f6 = f7;
                  f3 = f9;
                  continue;
                  paramPath.rLineTo(arrayOfFloat2[(m + 0)], 0.0F);
                  f5 = arrayOfFloat2[(m + 0)];
                  f9 = f3 + f5;
                  f3 = f1;
                  f5 = f8;
                  f1 = f2;
                  f6 = f7;
                  f2 = f3;
                  f3 = f4;
                  f4 = f9;
                  continue;
                  paramPath.lineTo(arrayOfFloat2[(m + 0)], f4);
                  f5 = arrayOfFloat2[(m + 0)];
                  f3 = f4;
                  f4 = f5;
                  f9 = f1;
                  f5 = f8;
                  f1 = f2;
                  f6 = f7;
                  f2 = f9;
                  continue;
                  paramPath.rLineTo(0.0F, arrayOfFloat2[(m + 0)]);
                  f5 = arrayOfFloat2[(m + 0)];
                  f9 = f1;
                  f10 = f4 + f5;
                  f4 = f3;
                  f1 = f2;
                  f5 = f8;
                  f6 = f7;
                  f2 = f9;
                  f3 = f10;
                  continue;
                  paramPath.lineTo(f3, arrayOfFloat2[(m + 0)]);
                  f9 = arrayOfFloat2[(m + 0)];
                  f4 = f1;
                  f10 = f3;
                  f1 = f2;
                  f5 = f8;
                  f6 = f7;
                  f2 = f4;
                  f3 = f9;
                  f4 = f10;
                  continue;
                  paramPath.rCubicTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)], arrayOfFloat2[(m + 4)], arrayOfFloat2[(m + 5)]);
                  f6 = f3 + arrayOfFloat2[(m + 2)];
                  f5 = f4 + arrayOfFloat2[(m + 3)];
                  f7 = arrayOfFloat2[(m + 4)];
                  f4 += arrayOfFloat2[(m + 5)];
                  f7 = f3 + f7;
                  f3 = f2;
                  f2 = f1;
                  f1 = f3;
                  f3 = f4;
                  f4 = f7;
                  continue;
                  paramPath.cubicTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)], arrayOfFloat2[(m + 4)], arrayOfFloat2[(m + 5)]);
                  f4 = arrayOfFloat2[(m + 4)];
                  f3 = arrayOfFloat2[(m + 5)];
                  f7 = arrayOfFloat2[(m + 2)];
                  f5 = arrayOfFloat2[(m + 3)];
                  f6 = f2;
                  f2 = f1;
                  f1 = f6;
                  f6 = f7;
                }
              }
            }
            f6 = 0.0F;
            if ((j == 99) || (j == 115) || (j == 67) || (j == 83)) {
              f6 = f4 - f8;
            }
            break;
          }
        }
      }
      for (float f5 = f3 - f7;; f5 = 0.0F)
      {
        paramPath.rCubicTo(f5, f6, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
        f6 = f3 + arrayOfFloat2[(m + 0)];
        f5 = f4 + arrayOfFloat2[(m + 1)];
        f7 = arrayOfFloat2[(m + 2)];
        f4 += arrayOfFloat2[(m + 3)];
        f7 = f3 + f7;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        f3 = f4;
        f4 = f7;
        break label482;
        if ((j == 99) || (j == 115) || (j == 67) || (j == 83))
        {
          f4 = 2.0F * f4 - f8;
          f3 = 2.0F * f3 - f7;
        }
        for (;;)
        {
          paramPath.cubicTo(f3, f4, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
          f6 = arrayOfFloat2[(m + 0)];
          f5 = arrayOfFloat2[(m + 1)];
          f4 = arrayOfFloat2[(m + 2)];
          f7 = arrayOfFloat2[(m + 3)];
          f3 = f2;
          f2 = f1;
          f1 = f3;
          f3 = f7;
          break label482;
          paramPath.rQuadTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
          f6 = f3 + arrayOfFloat2[(m + 0)];
          f5 = f4 + arrayOfFloat2[(m + 1)];
          f7 = arrayOfFloat2[(m + 2)];
          f4 += arrayOfFloat2[(m + 3)];
          f7 = f3 + f7;
          f3 = f2;
          f2 = f1;
          f1 = f3;
          f3 = f4;
          f4 = f7;
          break label482;
          paramPath.quadTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
          f6 = arrayOfFloat2[(m + 0)];
          f5 = arrayOfFloat2[(m + 1)];
          f4 = arrayOfFloat2[(m + 2)];
          f7 = arrayOfFloat2[(m + 3)];
          f3 = f2;
          f2 = f1;
          f1 = f3;
          f3 = f7;
          break label482;
          if ((j == 113) || (j == 116) || (j == 81) || (j == 84)) {
            f5 = f4 - f8;
          }
          for (f6 = f3 - f7;; f6 = 0.0F)
          {
            paramPath.rQuadTo(f6, f5, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
            f6 = f3 + f6;
            f5 = f4 + f5;
            f7 = arrayOfFloat2[(m + 0)];
            f4 += arrayOfFloat2[(m + 1)];
            f7 = f3 + f7;
            f3 = f2;
            f2 = f1;
            f1 = f3;
            f3 = f4;
            f4 = f7;
            break label482;
            if ((j != 113) && (j != 116) && (j != 81))
            {
              f6 = f4;
              f5 = f3;
              if (j != 84) {}
            }
            else
            {
              f5 = 2.0F * f3 - f7;
              f6 = 2.0F * f4 - f8;
            }
            paramPath.quadTo(f5, f6, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
            f4 = arrayOfFloat2[(m + 0)];
            f3 = arrayOfFloat2[(m + 1)];
            f7 = f6;
            f6 = f5;
            f8 = f2;
            f2 = f1;
            f5 = f7;
            f1 = f8;
            break label482;
            f5 = arrayOfFloat2[(m + 5)];
            f6 = arrayOfFloat2[(m + 6)];
            f7 = arrayOfFloat2[(m + 0)];
            f8 = arrayOfFloat2[(m + 1)];
            f9 = arrayOfFloat2[(m + 2)];
            boolean bool1;
            if (arrayOfFloat2[(m + 3)] != 0.0F)
            {
              bool1 = true;
              label2168:
              if (arrayOfFloat2[(m + 4)] == 0.0F) {
                break label2261;
              }
            }
            label2261:
            for (boolean bool2 = true;; bool2 = false)
            {
              c.b.a(paramPath, f3, f4, f5 + f3, f6 + f4, f7, f8, f9, bool1, bool2);
              f6 = f3 + arrayOfFloat2[(m + 5)];
              f5 = f4 + arrayOfFloat2[(m + 6)];
              f7 = f2;
              f2 = f1;
              f3 = f5;
              f4 = f6;
              f1 = f7;
              break;
              bool1 = false;
              break label2168;
            }
            f5 = arrayOfFloat2[(m + 5)];
            f6 = arrayOfFloat2[(m + 6)];
            f7 = arrayOfFloat2[(m + 0)];
            f8 = arrayOfFloat2[(m + 1)];
            f9 = arrayOfFloat2[(m + 2)];
            if (arrayOfFloat2[(m + 3)] != 0.0F)
            {
              bool1 = true;
              label2328:
              if (arrayOfFloat2[(m + 4)] == 0.0F) {
                break label2409;
              }
            }
            label2409:
            for (bool2 = true;; bool2 = false)
            {
              c.b.a(paramPath, f3, f4, f5, f6, f7, f8, f9, bool1, bool2);
              f6 = arrayOfFloat2[(m + 5)];
              f5 = arrayOfFloat2[(m + 6)];
              f7 = f2;
              f2 = f1;
              f3 = f5;
              f4 = f6;
              f1 = f7;
              break;
              bool1 = false;
              break label2328;
            }
            arrayOfFloat1[0] = f3;
            arrayOfFloat1[1] = f4;
            arrayOfFloat1[2] = f7;
            arrayOfFloat1[3] = f8;
            arrayOfFloat1[4] = f1;
            arrayOfFloat1[5] = f2;
            j = arrayOfb[k].mh;
            k += 1;
            break;
            return;
            f5 = 0.0F;
          }
        }
      }
    }
    
    public boolean aA()
    {
      return false;
    }
  }
  
  private static final class e
  {
    private static final Matrix mW = new Matrix();
    private final Path mU;
    private final Path mV;
    private final Matrix mX = new Matrix();
    public Paint mY;
    public Paint mZ;
    private int ma;
    private PathMeasure na;
    public final f.c nb;
    float nc = 0.0F;
    float nd = 0.0F;
    float ne = 0.0F;
    float nf = 0.0F;
    int ng = 255;
    String nh = null;
    final android.support.v4.e.a<String, Object> ni = new android.support.v4.e.a();
    
    public e()
    {
      this.nb = new f.c();
      this.mU = new Path();
      this.mV = new Path();
    }
    
    public e(e parame)
    {
      this.nb = new f.c(parame.nb, this.ni);
      this.mU = new Path(parame.mU);
      this.mV = new Path(parame.mV);
      this.nc = parame.nc;
      this.nd = parame.nd;
      this.ne = parame.ne;
      this.nf = parame.nf;
      this.ma = parame.ma;
      this.ng = parame.ng;
      this.nh = parame.nh;
      if (parame.nh != null) {
        this.ni.put(parame.nh, this);
      }
    }
    
    private void a(f.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramc.mH.set(paramMatrix);
      paramc.mH.preConcat(paramc.mQ);
      int i = 0;
      if (i < paramc.mI.size())
      {
        paramMatrix = paramc.mI.get(i);
        if ((paramMatrix instanceof f.c)) {
          a((f.c)paramMatrix, paramc.mH, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
        float f1;
        float f3;
        float f2;
        Object localObject;
        float f7;
        float f4;
        float f5;
        float f6;
        for (;;)
        {
          i += 1;
          break;
          if ((paramMatrix instanceof f.d))
          {
            paramMatrix = (f.d)paramMatrix;
            f1 = paramInt1 / this.ne;
            f3 = paramInt2 / this.nf;
            f2 = Math.min(f1, f3);
            localObject = paramc.mH;
            this.mX.set((Matrix)localObject);
            this.mX.postScale(f1, f3);
            float[] arrayOfFloat = new float[4];
            float[] tmp155_153 = arrayOfFloat;
            tmp155_153[0] = 0.0F;
            float[] tmp159_155 = tmp155_153;
            tmp159_155[1] = 1.0F;
            float[] tmp163_159 = tmp159_155;
            tmp163_159[2] = 1.0F;
            float[] tmp167_163 = tmp163_159;
            tmp167_163[3] = 0.0F;
            tmp167_163;
            ((Matrix)localObject).mapVectors(arrayOfFloat);
            f1 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
            f7 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
            f3 = arrayOfFloat[0];
            f4 = arrayOfFloat[1];
            f5 = arrayOfFloat[2];
            f6 = arrayOfFloat[3];
            f7 = Math.max(f1, f7);
            f1 = 0.0F;
            if (f7 > 0.0F) {
              f1 = Math.abs(f6 * f3 - f4 * f5) / f7;
            }
            if (f1 != 0.0F)
            {
              paramMatrix.a(this.mU);
              localObject = this.mU;
              this.mV.reset();
              if (!paramMatrix.aA()) {
                break label336;
              }
              this.mV.addPath((Path)localObject, this.mX);
              paramCanvas.clipPath(this.mV, Region.Op.REPLACE);
            }
          }
        }
        label336:
        paramMatrix = (f.b)paramMatrix;
        if ((paramMatrix.mB != 0.0F) || (paramMatrix.mC != 1.0F))
        {
          f6 = paramMatrix.mB;
          f7 = paramMatrix.mD;
          f4 = paramMatrix.mC;
          f5 = paramMatrix.mD;
          if (this.na == null) {
            this.na = new PathMeasure();
          }
          this.na.setPath(this.mU, false);
          f3 = this.na.getLength();
          f6 = (f6 + f7) % 1.0F * f3;
          f4 = (f4 + f5) % 1.0F * f3;
          ((Path)localObject).reset();
          if (f6 <= f4) {
            break label733;
          }
          this.na.getSegment(f6, f3, (Path)localObject, true);
          this.na.getSegment(0.0F, f4, (Path)localObject, true);
        }
        for (;;)
        {
          ((Path)localObject).rLineTo(0.0F, 0.0F);
          this.mV.addPath((Path)localObject, this.mX);
          if (paramMatrix.mx != 0)
          {
            if (this.mZ == null)
            {
              this.mZ = new Paint();
              this.mZ.setStyle(Paint.Style.FILL);
              this.mZ.setAntiAlias(true);
            }
            localObject = this.mZ;
            ((Paint)localObject).setColor(f.b(paramMatrix.mx, paramMatrix.mA));
            ((Paint)localObject).setColorFilter(paramColorFilter);
            paramCanvas.drawPath(this.mV, (Paint)localObject);
          }
          if (paramMatrix.mv == 0) {
            break;
          }
          if (this.mY == null)
          {
            this.mY = new Paint();
            this.mY.setStyle(Paint.Style.STROKE);
            this.mY.setAntiAlias(true);
          }
          localObject = this.mY;
          if (paramMatrix.mF != null) {
            ((Paint)localObject).setStrokeJoin(paramMatrix.mF);
          }
          if (paramMatrix.mE != null) {
            ((Paint)localObject).setStrokeCap(paramMatrix.mE);
          }
          ((Paint)localObject).setStrokeMiter(paramMatrix.mG);
          ((Paint)localObject).setColor(f.b(paramMatrix.mv, paramMatrix.my));
          ((Paint)localObject).setColorFilter(paramColorFilter);
          ((Paint)localObject).setStrokeWidth(f1 * f2 * paramMatrix.mw);
          paramCanvas.drawPath(this.mV, (Paint)localObject);
          break;
          label733:
          this.na.getSegment(f6, f4, (Path)localObject, true);
        }
      }
    }
    
    public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      a(this.nb, mW, paramCanvas, paramInt1, paramInt2, null);
    }
  }
  
  private static final class f
    extends Drawable.ConstantState
  {
    int ma;
    f.e nj;
    ColorStateList nk = null;
    PorterDuff.Mode nl = f.mk;
    boolean nm;
    Bitmap nn;
    ColorStateList no;
    PorterDuff.Mode np;
    int nq;
    boolean nr;
    boolean ns;
    Paint nt;
    
    public f()
    {
      this.nj = new f.e();
    }
    
    public f(f paramf)
    {
      if (paramf != null)
      {
        this.ma = paramf.ma;
        this.nj = new f.e(paramf.nj);
        if (paramf.nj.mZ != null) {
          this.nj.mZ = new Paint(paramf.nj.mZ);
        }
        if (paramf.nj.mY != null) {
          this.nj.mY = new Paint(paramf.nj.mY);
        }
        this.nk = paramf.nk;
        this.nl = paramf.nl;
        this.nm = paramf.nm;
      }
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      this.nn.eraseColor(0);
      Canvas localCanvas = new Canvas(this.nn);
      this.nj.a(localCanvas, paramInt1, paramInt2);
    }
    
    public final int getChangingConfigurations()
    {
      return this.ma;
    }
    
    public final Drawable newDrawable()
    {
      return new f(this, (byte)0);
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new f(this, (byte)0);
    }
  }
  
  private static final class g
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState me;
    
    public g(Drawable.ConstantState paramConstantState)
    {
      this.me = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.me.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.me.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      f localf = new f((byte)0);
      localf.mj = ((VectorDrawable)this.me.newDrawable());
      return localf;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      f localf = new f((byte)0);
      localf.mj = ((VectorDrawable)this.me.newDrawable(paramResources));
      return localf;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      f localf = new f((byte)0);
      localf.mj = ((VectorDrawable)this.me.newDrawable(paramResources, paramTheme));
      return localf;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */