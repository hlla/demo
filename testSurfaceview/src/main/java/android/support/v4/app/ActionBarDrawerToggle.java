package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

@Deprecated
public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private static final int BACK_TO_DRAWER = 0;
  private static final int DRAWER_TO_BACK = 1;
  private static final int ID_HOME = 16908332;
  private static final ActionBarDrawerToggleImpl IMPL = new ActionBarDrawerToggleImplBase(null);
  private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334F;
  private final Activity mActivity;
  private final Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  private Drawable mDrawerImage;
  private int[][] mDrawerImageList;
  private final int mDrawerImageResource;
  private boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private int mDrawerState = 0;
  private boolean mHasCustomUpIndicator;
  private Drawable mHomeAsUpIndicator;
  private final int mOpenDrawerContentDescRes;
  private Object mSetIndicatorInfo;
  private SlideDrawable mSlider;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18)
    {
      IMPL = new ActionBarDrawerToggleImplJellybeanMR2(null);
      return;
    }
    if (i >= 11)
    {
      IMPL = new ActionBarDrawerToggleImplHC(null);
      return;
    }
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2, int paramInt3) {}
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mActivity = paramActivity;
    if ((paramActivity instanceof DelegateProvider))
    {
      this.mActivityImpl = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();
      this.mDrawerLayout = paramDrawerLayout;
      this.mDrawerImageResource = paramInt1;
      this.mOpenDrawerContentDescRes = paramInt2;
      this.mCloseDrawerContentDescRes = paramInt3;
      this.mHomeAsUpIndicator = getThemeUpIndicator();
      this.mDrawerImage = ContextCompat.getDrawable(paramActivity, paramInt1);
      this.mSlider = new SlideDrawable(this.mDrawerImage, null);
      paramActivity = this.mSlider;
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (float f = 0.33333334F;; f = 0.0F)
    {
      paramActivity.setOffset(f);
      return;
      this.mActivityImpl = null;
      break;
    }
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, boolean paramBoolean, int[][] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.mActivity = paramActivity;
    if ((paramActivity instanceof DelegateProvider))
    {
      this.mActivityImpl = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();
      this.mDrawerLayout = paramDrawerLayout;
      this.mDrawerImageList = paramArrayOfInt;
      this.mDrawerImageResource = this.mDrawerImageList[0][30];
      this.mOpenDrawerContentDescRes = paramInt1;
      this.mCloseDrawerContentDescRes = paramInt2;
      this.mHomeAsUpIndicator = getThemeUpIndicator();
      this.mDrawerImage = ContextCompat.getDrawable(paramActivity, this.mDrawerImageResource);
      this.mSlider = new SlideDrawable(this.mDrawerImage, null);
      paramActivity = this.mSlider;
      if (!paramBoolean) {
        break label140;
      }
    }
    label140:
    for (float f = 0.33333334F;; f = 0.0F)
    {
      paramActivity.setOffset(f);
      return;
      this.mActivityImpl = null;
      break;
    }
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int[][] paramArrayOfInt, int paramInt1, int paramInt2) {}
  
  private void animateToNavibrationButton(int paramInt, float paramFloat)
  {
    int i = 0;
    Drawable localDrawable;
    if (paramFloat > 0.96666664F)
    {
      i = 29;
      if (i < this.mDrawerImageList[paramInt].length)
      {
        localDrawable = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageList[paramInt][i]);
        if (paramInt != 0) {
          break label416;
        }
      }
    }
    label416:
    for (paramInt = this.mOpenDrawerContentDescRes;; paramInt = this.mCloseDrawerContentDescRes)
    {
      setActionBarUpIndicator(localDrawable, paramInt);
      return;
      if (paramFloat > 0.93333334F)
      {
        i = 28;
        break;
      }
      if (paramFloat > 0.9F)
      {
        i = 27;
        break;
      }
      if (paramFloat > 0.8666667F)
      {
        i = 26;
        break;
      }
      if (paramFloat > 0.8333333F)
      {
        i = 25;
        break;
      }
      if (paramFloat > 0.8F)
      {
        i = 24;
        break;
      }
      if (paramFloat > 0.76666665F)
      {
        i = 23;
        break;
      }
      if (paramFloat > 0.73333335F)
      {
        i = 22;
        break;
      }
      if (paramFloat > 0.7F)
      {
        i = 21;
        break;
      }
      if (paramFloat > 0.6666667F)
      {
        i = 20;
        break;
      }
      if (paramFloat > 0.6333333F)
      {
        i = 19;
        break;
      }
      if (paramFloat > 0.6F)
      {
        i = 18;
        break;
      }
      if (paramFloat > 0.56666666F)
      {
        i = 17;
        break;
      }
      if (paramFloat > 0.53333336F)
      {
        i = 16;
        break;
      }
      if (paramFloat > 0.5F)
      {
        i = 15;
        break;
      }
      if (paramFloat > 0.46666667F)
      {
        i = 14;
        break;
      }
      if (paramFloat > 0.43333334F)
      {
        i = 13;
        break;
      }
      if (paramFloat > 0.4F)
      {
        i = 12;
        break;
      }
      if (paramFloat > 0.36666667F)
      {
        i = 11;
        break;
      }
      if (paramFloat > 0.33333334F)
      {
        i = 10;
        break;
      }
      if (paramFloat > 0.3F)
      {
        i = 9;
        break;
      }
      if (paramFloat > 0.26666668F)
      {
        i = 8;
        break;
      }
      if (paramFloat > 0.23333333F)
      {
        i = 7;
        break;
      }
      if (paramFloat > 0.2F)
      {
        i = 6;
        break;
      }
      if (paramFloat > 0.16666667F)
      {
        i = 5;
        break;
      }
      if (paramFloat > 0.13333334F)
      {
        i = 4;
        break;
      }
      if (paramFloat > 0.1F)
      {
        i = 3;
        break;
      }
      if (paramFloat > 0.06666667F)
      {
        i = 2;
        break;
      }
      if (paramFloat <= 0.033333335F) {
        break;
      }
      i = 1;
      break;
    }
  }
  
  private static boolean assumeMaterial(Context paramContext)
  {
    return (paramContext.getApplicationInfo().targetSdkVersion >= 21) && (Build.VERSION.SDK_INT >= 21);
  }
  
  Drawable getThemeUpIndicator()
  {
    if (this.mActivityImpl != null) {
      return this.mActivityImpl.getThemeUpIndicator();
    }
    return IMPL.getThemeUpIndicator(this.mActivity);
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return this.mDrawerIndicatorEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mHasCustomUpIndicator) {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
    }
    this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    this.mSlider.setPosition(0.0F);
    if (this.mDrawerIndicatorEnabled)
    {
      setActionBarDescription(this.mOpenDrawerContentDescRes);
      if (this.mDrawerImageList != null) {
        setActionBarUpIndicator(ContextCompat.getDrawable(this.mActivity, this.mDrawerImageList[0][30]), this.mOpenDrawerContentDescRes);
      }
    }
    this.mDrawerState = 0;
  }
  
  public void onDrawerOpened(View paramView)
  {
    this.mSlider.setPosition(1.0F);
    if (this.mDrawerIndicatorEnabled)
    {
      setActionBarDescription(this.mCloseDrawerContentDescRes);
      if (this.mDrawerImageList != null) {
        setActionBarUpIndicator(ContextCompat.getDrawable(this.mActivity, this.mDrawerImageList[1][30]), this.mCloseDrawerContentDescRes);
      }
    }
    this.mDrawerState = 1;
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    float f = this.mSlider.getPosition();
    if (paramFloat > 0.5F)
    {
      f = Math.max(f, Math.max(0.0F, paramFloat - 0.5F) * 2.0F);
      if ((this.mDrawerIndicatorEnabled) && (this.mDrawerImageList != null))
      {
        if (this.mDrawerState != 0) {
          break label77;
        }
        animateToNavibrationButton(1, paramFloat);
      }
    }
    for (;;)
    {
      this.mSlider.setPosition(f);
      return;
      f = Math.min(f, paramFloat * 2.0F);
      break;
      label77:
      animateToNavibrationButton(0, 1.0F - paramFloat);
    }
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.mDrawerIndicatorEnabled))
    {
      if (this.mDrawerLayout.isDrawerVisible(8388611)) {
        this.mDrawerLayout.closeDrawer(8388611);
      }
      for (;;)
      {
        return true;
        this.mDrawerLayout.openDrawer(8388611);
      }
    }
    return false;
  }
  
  void setActionBarDescription(int paramInt)
  {
    if (this.mActivityImpl != null)
    {
      this.mActivityImpl.setActionBarDescription(paramInt);
      return;
    }
    this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, paramInt);
  }
  
  void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if (this.mActivityImpl != null)
    {
      this.mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
      return;
    }
    this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, paramDrawable, paramInt);
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != this.mDrawerIndicatorEnabled)
    {
      if (!paramBoolean) {
        break label54;
      }
      SlideDrawable localSlideDrawable = this.mSlider;
      if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
        break label46;
      }
      i = this.mCloseDrawerContentDescRes;
      setActionBarUpIndicator(localSlideDrawable, i);
    }
    for (;;)
    {
      this.mDrawerIndicatorEnabled = paramBoolean;
      return;
      label46:
      i = this.mOpenDrawerContentDescRes;
      break;
      label54:
      setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = ContextCompat.getDrawable(this.mActivity, paramInt);
    }
    setHomeAsUpIndicator(localDrawable);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
    }
    for (this.mHasCustomUpIndicator = false;; this.mHasCustomUpIndicator = true)
    {
      if (!this.mDrawerIndicatorEnabled) {
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
      }
      return;
      this.mHomeAsUpIndicator = paramDrawable;
    }
  }
  
  public void syncState()
  {
    SlideDrawable localSlideDrawable;
    if (this.mDrawerLayout.isDrawerOpen(8388611))
    {
      this.mSlider.setPosition(1.0F);
      if (this.mDrawerIndicatorEnabled)
      {
        localSlideDrawable = this.mSlider;
        if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
          break label67;
        }
      }
    }
    label67:
    for (int i = this.mCloseDrawerContentDescRes;; i = this.mOpenDrawerContentDescRes)
    {
      setActionBarUpIndicator(localSlideDrawable, i);
      return;
      this.mSlider.setPosition(0.0F);
      break;
    }
  }
  
  private static abstract interface ActionBarDrawerToggleImpl
  {
    public abstract Drawable getThemeUpIndicator(Activity paramActivity);
    
    public abstract Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt);
    
    public abstract Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt);
  }
  
  private static class ActionBarDrawerToggleImplBase
    implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl
  {
    public Drawable getThemeUpIndicator(Activity paramActivity)
    {
      return null;
    }
    
    public Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
    {
      return paramObject;
    }
    
    public Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
    {
      return paramObject;
    }
  }
  
  private static class ActionBarDrawerToggleImplHC
    implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl
  {
    public Drawable getThemeUpIndicator(Activity paramActivity)
    {
      return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(paramActivity);
    }
    
    public Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
    {
      return ActionBarDrawerToggleHoneycomb.setActionBarDescription(paramObject, paramActivity, paramInt);
    }
    
    public Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
    {
      return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(paramObject, paramActivity, paramDrawable, paramInt);
    }
  }
  
  private static class ActionBarDrawerToggleImplJellybeanMR2
    implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl
  {
    public Drawable getThemeUpIndicator(Activity paramActivity)
    {
      return ActionBarDrawerToggleJellybeanMR2.getThemeUpIndicator(paramActivity);
    }
    
    public Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
    {
      return ActionBarDrawerToggleJellybeanMR2.setActionBarDescription(paramObject, paramActivity, paramInt);
    }
    
    public Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
    {
      return ActionBarDrawerToggleJellybeanMR2.setActionBarUpIndicator(paramObject, paramActivity, paramDrawable, paramInt);
    }
  }
  
  public static abstract interface Delegate
  {
    @Nullable
    public abstract Drawable getThemeUpIndicator();
    
    public abstract void setActionBarDescription(int paramInt);
    
    public abstract void setActionBarUpIndicator(Drawable paramDrawable, int paramInt);
  }
  
  public static abstract interface DelegateProvider
  {
    @Nullable
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }
  
  private class SlideDrawable
    extends InsetDrawable
    implements Drawable.Callback
  {
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;
    
    private SlideDrawable(Drawable paramDrawable)
    {
      super(0);
      if (Build.VERSION.SDK_INT > 18) {
        bool = true;
      }
      this.mHasMirroring = bool;
      this.mTmpRect = new Rect();
    }
    
    public void draw(Canvas paramCanvas)
    {
      int j = 1;
      copyBounds(this.mTmpRect);
      paramCanvas.save();
      if (ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          j = -1;
        }
        int k = this.mTmpRect.width();
        paramCanvas.translate(-this.mOffset * k * this.mPosition * j, 0.0F);
        if ((i != 0) && (!this.mHasMirroring))
        {
          paramCanvas.translate(k, 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        super.draw(paramCanvas);
        paramCanvas.restore();
        return;
      }
    }
    
    public float getPosition()
    {
      return this.mPosition;
    }
    
    public void setOffset(float paramFloat)
    {
      this.mOffset = paramFloat;
      invalidateSelf();
    }
    
    public void setPosition(float paramFloat)
    {
      this.mPosition = paramFloat;
      invalidateSelf();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/android/support/v4/app/ActionBarDrawerToggle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */