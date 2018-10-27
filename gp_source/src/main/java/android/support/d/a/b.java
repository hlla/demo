package android.support.d.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.content.a.o;
import android.support.v4.g.v;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class b
  extends k
  implements Animatable
{
  public final Drawable.Callback a = new c(this);
  private d c;
  private ArgbEvaluator d = null;
  private Context e;
  
  b()
  {
    this(null, (byte)0);
  }
  
  private b(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private b(Context paramContext, byte paramByte)
  {
    this.e = paramContext;
    this.c = new d();
  }
  
  public static b a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    paramContext = new b(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  private final void a(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null) {
        break label81;
      }
    }
    for (;;)
    {
      if ((paramAnimator instanceof ObjectAnimator))
      {
        paramAnimator = (ObjectAnimator)paramAnimator;
        localObject = paramAnimator.getPropertyName();
        if (("fillColor".equals(localObject)) || ("strokeColor".equals(localObject)))
        {
          if (this.d == null) {
            this.d = new ArgbEvaluator();
          }
          paramAnimator.setEvaluator(this.d);
        }
      }
      return;
      label81:
      int i = 0;
      while (i < ((List)localObject).size())
      {
        a((Animator)((List)localObject).get(i));
        i += 1;
      }
    }
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      android.support.v4.a.a.a.a(localDrawable, paramTheme);
    }
  }
  
  public final boolean canApplyTheme()
  {
    Drawable localDrawable = this.b;
    if (localDrawable == null) {
      return false;
    }
    return android.support.v4.a.a.a.c(localDrawable);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    do
    {
      return;
      this.c.d.draw(paramCanvas);
    } while (!this.c.a.isStarted());
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return android.support.v4.a.a.a.b(localDrawable);
    }
    return this.c.d.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | 0x0;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.b != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new e(this.b.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return this.c.d.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return this.c.d.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return this.c.d.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
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
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    if (i == 1) {}
    Object localObject2;
    for (;;)
    {
      paramResources = this.c;
      if (paramResources.a == null) {
        paramResources.a = new AnimatorSet();
      }
      paramResources.a.playTogether(paramResources.b);
      return;
      if (paramXmlPullParser.getDepth() >= j + 1) {}
      label212:
      label398:
      while (i != 3)
      {
        if (i == 2)
        {
          localObject1 = paramXmlPullParser.getName();
          if (!"animated-vector".equals(localObject1)) {
            break label212;
          }
          localObject1 = o.a(paramResources, paramTheme, paramAttributeSet, a.a);
          i = ((TypedArray)localObject1).getResourceId(0, 0);
          if (i != 0)
          {
            localObject2 = l.a(paramResources, i, paramTheme);
            ((l)localObject2).c = false;
            ((l)localObject2).setCallback(this.a);
            localObject3 = this.c.d;
            if (localObject3 != null) {
              ((l)localObject3).setCallback(null);
            }
            this.c.d = ((l)localObject2);
          }
          ((TypedArray)localObject1).recycle();
        }
        while (!"target".equals(localObject1))
        {
          i = paramXmlPullParser.next();
          break;
        }
        localObject2 = paramResources.obtainAttributes(paramAttributeSet, a.b);
        Object localObject3 = ((TypedArray)localObject2).getString(0);
        i = ((TypedArray)localObject2).getResourceId(1, 0);
        if (i != 0)
        {
          localObject1 = this.e;
          if (localObject1 == null) {
            break label429;
          }
          if (Build.VERSION.SDK_INT < 24) {
            break label398;
          }
        }
        for (localObject1 = AnimatorInflater.loadAnimator((Context)localObject1, i);; localObject1 = g.a((Context)localObject1, ((Context)localObject1).getResources(), ((Context)localObject1).getTheme(), i))
        {
          ((Animator)localObject1).setTarget(this.c.d.d.l.i.get(localObject3));
          if (Build.VERSION.SDK_INT < 21) {
            a((Animator)localObject1);
          }
          d locald = this.c;
          if (locald.b == null)
          {
            locald.b = new ArrayList();
            this.c.c = new android.support.v4.g.a();
          }
          this.c.b.add(localObject1);
          this.c.c.put(localObject1, localObject3);
          ((TypedArray)localObject2).recycle();
          break;
        }
      }
    }
    label429:
    ((TypedArray)localObject2).recycle();
    throw new IllegalStateException("Context can't be null when inflating animators");
  }
  
  public final boolean isAutoMirrored()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return android.support.v4.a.a.a.a(localDrawable);
    }
    return this.c.d.isAutoMirrored();
  }
  
  public final boolean isRunning()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return ((AnimatedVectorDrawable)localDrawable).isRunning();
    }
    return this.c.a.isRunning();
  }
  
  public final boolean isStateful()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.isStateful();
    }
    return this.c.d.isStateful();
  }
  
  public final Drawable mutate()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.mutate();
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.setBounds(paramRect);
      return;
    }
    this.c.d.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return this.c.d.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    return this.c.d.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.setAlpha(paramInt);
      return;
    }
    this.c.d.setAlpha(paramInt);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      android.support.v4.a.a.a.a(localDrawable, paramBoolean);
      return;
    }
    this.c.d.setAutoMirrored(paramBoolean);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.c.d.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      android.support.v4.a.a.a.a(localDrawable, paramInt);
      return;
    }
    this.c.d.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      android.support.v4.a.a.a.a(localDrawable, paramColorStateList);
      return;
    }
    this.c.d.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      android.support.v4.a.a.a.a(localDrawable, paramMode);
      return;
    }
    this.c.d.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    this.c.d.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      ((AnimatedVectorDrawable)localDrawable).start();
    }
    while (this.c.a.isStarted()) {
      return;
    }
    this.c.a.start();
    invalidateSelf();
  }
  
  public final void stop()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      ((AnimatedVectorDrawable)localDrawable).stop();
      return;
    }
    this.c.a.end();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */