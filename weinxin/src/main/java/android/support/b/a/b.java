package android.support.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
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
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
public final class b
  extends e
  implements Animatable
{
  private a lW;
  private ArgbEvaluator lX = null;
  private final Drawable.Callback lY = new Drawable.Callback()
  {
    public final void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      b.this.invalidateSelf();
    }
    
    public final void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
    {
      b.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
    }
    
    public final void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
    {
      b.this.unscheduleSelf(paramAnonymousRunnable);
    }
  };
  private Context mContext;
  
  private b()
  {
    this(null, (byte)0);
  }
  
  private b(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private b(Context paramContext, byte paramByte)
  {
    this.mContext = paramContext;
    this.lW = new a(null, this.lY, null);
  }
  
  public static b a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    paramContext = new b(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  private void b(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          b((Animator)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      localObject = paramAnimator.getPropertyName();
      if (("fillColor".equals(localObject)) || ("strokeColor".equals(localObject)))
      {
        if (this.lX == null) {
          this.lX = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.lX);
      }
    }
  }
  
  private boolean isStarted()
  {
    ArrayList localArrayList = this.lW.mc;
    if (localArrayList == null) {
      return false;
    }
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((Animator)localArrayList.get(i)).isRunning()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    if (this.mj != null) {
      android.support.v4.b.a.a.a(this.mj, paramTheme);
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (this.mj != null) {
      return android.support.v4.b.a.a.e(this.mj);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.mj != null) {
      this.mj.draw(paramCanvas);
    }
    do
    {
      return;
      this.lW.mb.draw(paramCanvas);
    } while (!isStarted());
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    if (this.mj != null) {
      return android.support.v4.b.a.a.d(this.mj);
    }
    return this.lW.mb.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.mj != null) {
      return this.mj.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.lW.ma;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.mj != null) {
      return new b(this.mj.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.mj != null) {
      return this.mj.getIntrinsicHeight();
    }
    return this.lW.mb.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.mj != null) {
      return this.mj.getIntrinsicWidth();
    }
    return this.lW.mb.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    if (this.mj != null) {
      return this.mj.getOpacity();
    }
    return this.lW.mb.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.mj != null)
    {
      android.support.v4.b.a.a.a(this.mj, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    label28:
    Object localObject1;
    label77:
    Object localObject2;
    if (i != 1) {
      if (i == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        if (!"animated-vector".equals(localObject1)) {
          break label177;
        }
        localObject1 = a.lU;
        if (paramTheme != null) {
          break label162;
        }
        localObject1 = paramResources.obtainAttributes(paramAttributeSet, (int[])localObject1);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = f.a(paramResources, i, paramTheme);
          ((f)localObject2).mp = false;
          ((f)localObject2).setCallback(this.lY);
          if (this.lW.mb != null) {
            this.lW.mb.setCallback(null);
          }
          this.lW.mb = ((f)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
    }
    for (;;)
    {
      i = paramXmlPullParser.next();
      break label28;
      break;
      label162:
      localObject1 = paramTheme.obtainStyledAttributes(paramAttributeSet, (int[])localObject1, 0, 0);
      break label77;
      label177:
      if ("target".equals(localObject1))
      {
        localObject1 = paramResources.obtainAttributes(paramAttributeSet, a.lV);
        localObject2 = ((TypedArray)localObject1).getString(0);
        i = ((TypedArray)localObject1).getResourceId(1, 0);
        if (i != 0)
        {
          if (this.mContext == null) {
            break label352;
          }
          Animator localAnimator = AnimatorInflater.loadAnimator(this.mContext, i);
          localAnimator.setTarget(this.lW.mb.ml.nj.ni.get(localObject2));
          if (Build.VERSION.SDK_INT < 21) {
            b(localAnimator);
          }
          if (this.lW.mc == null)
          {
            this.lW.mc = new ArrayList();
            this.lW.md = new android.support.v4.e.a();
          }
          this.lW.mc.add(localAnimator);
          this.lW.md.put(localAnimator, localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
    }
    label352:
    throw new IllegalStateException("Context can't be null when inflating animators");
  }
  
  public final boolean isRunning()
  {
    if (this.mj != null) {
      return ((AnimatedVectorDrawable)this.mj).isRunning();
    }
    ArrayList localArrayList = this.lW.mc;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((Animator)localArrayList.get(i)).isRunning()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final boolean isStateful()
  {
    if (this.mj != null) {
      return this.mj.isStateful();
    }
    return this.lW.mb.isStateful();
  }
  
  public final Drawable mutate()
  {
    if (this.mj != null)
    {
      this.mj.mutate();
      return this;
    }
    throw new IllegalStateException("Mutate() is not supported for older platform");
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.mj != null)
    {
      this.mj.setBounds(paramRect);
      return;
    }
    this.lW.mb.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (this.mj != null) {
      return this.mj.setLevel(paramInt);
    }
    return this.lW.mb.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mj != null) {
      return this.mj.setState(paramArrayOfInt);
    }
    return this.lW.mb.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.mj != null)
    {
      this.mj.setAlpha(paramInt);
      return;
    }
    this.lW.mb.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mj != null)
    {
      this.mj.setColorFilter(paramColorFilter);
      return;
    }
    this.lW.mb.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    if (this.mj != null)
    {
      android.support.v4.b.a.a.a(this.mj, paramInt);
      return;
    }
    this.lW.mb.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.mj != null)
    {
      android.support.v4.b.a.a.a(this.mj, paramColorStateList);
      return;
    }
    this.lW.mb.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mj != null)
    {
      android.support.v4.b.a.a.a(this.mj, paramMode);
      return;
    }
    this.lW.mb.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mj != null) {
      return this.mj.setVisible(paramBoolean1, paramBoolean2);
    }
    this.lW.mb.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    if (this.mj != null) {
      ((AnimatedVectorDrawable)this.mj).start();
    }
    while (isStarted()) {
      return;
    }
    ArrayList localArrayList = this.lW.mc;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((Animator)localArrayList.get(i)).start();
      i += 1;
    }
    invalidateSelf();
  }
  
  public final void stop()
  {
    if (this.mj != null) {
      ((AnimatedVectorDrawable)this.mj).stop();
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = this.lW.mc;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((Animator)localArrayList.get(i)).end();
        i += 1;
      }
    }
  }
  
  private static final class a
    extends Drawable.ConstantState
  {
    int ma;
    f mb;
    ArrayList<Animator> mc;
    android.support.v4.e.a<Animator, String> md;
    
    public a(a parama, Drawable.Callback paramCallback, Resources paramResources) {}
    
    public final int getChangingConfigurations()
    {
      return this.ma;
    }
    
    public final Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 23.");
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 23.");
    }
  }
  
  private static final class b
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState me;
    
    public b(Drawable.ConstantState paramConstantState)
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
      b localb = new b((byte)0);
      localb.mj = this.me.newDrawable();
      localb.mj.setCallback(b.a(localb));
      return localb;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      b localb = new b((byte)0);
      localb.mj = this.me.newDrawable(paramResources);
      localb.mj.setCallback(b.a(localb));
      return localb;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      b localb = new b((byte)0);
      localb.mj = this.me.newDrawable(paramResources, paramTheme);
      localb.mj.setCallback(b.a(localb));
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */