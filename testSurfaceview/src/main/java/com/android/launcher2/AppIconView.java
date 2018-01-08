package com.android.launcher2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import com.sec.android.app.launcher.R.styleable;
import com.sec.dtl.launcher.Talk;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.MissingResourceException;

public class AppIconView
  extends TextView
  implements Checkable, DynamicShadowMixin.Holder
{
  private static final boolean DEBUGGABLE = Utilities.DEBUGGABLE();
  private static final int HOME = 0;
  private static final int MENU = 1;
  static final float PADDING_V = 3.0F;
  private static final float PRESS_ALPHA = 0.4F;
  static int SHADOW_LARGE_COLOUR = 0;
  static float SHADOW_LARGE_RADIUS = 4.0F;
  static int SHADOW_SMALL_COLOUR = 0;
  static float SHADOW_SMALL_RADIUS = 1.0F;
  static float SHADOW_Y_OFFSET = 2.0F;
  private static final String TAG = "AppIconView";
  private static Drawable sBadgeDrawable;
  private static int sFontSizeDefault;
  private static int sFontSizeSmall;
  private static int sIconCenterXOffset;
  static int sIconTopToTopOffset;
  static boolean sIsDragState = false;
  private String callIntentAction = "android.intent.action.CALL";
  private String dialIntentAction = "android.intent.action.CALL_PRIVILEGED";
  private Rect mBoundsRect = new Rect();
  private Drawable mCheckedOverlay;
  private boolean mDidInvalidateForPressedState;
  private float mDimAmount = 0.55F;
  protected boolean mDrawIcon = true;
  protected boolean mDrawShadow = true;
  private int mHotseatIconSize;
  private Bitmap mIconBitmap;
  private int mIconDestination = 1;
  protected Drawable mIconShadowDrawable;
  private int mIconSize;
  protected boolean mIsAttachedHotseat = false;
  private boolean mIsChecked;
  private boolean mIsCheckingEnabled = false;
  private boolean mIsDimmed = false;
  private final int[] mLastTouch = new int[2];
  private MovieDrawable mMovieDrawable;
  private Drawable mMoviePhoneIconDrawable;
  private HolographicOutlineHelper mOutlineHelper;
  private Drawable mOverlay = null;
  private Paint mPaint;
  private PkgResCache mPkgResCache;
  private int mPressedGlowColor;
  private Bitmap mPressedOrFocusedBackground;
  private int mPressedOutlineColor;
  final ScalarAnimator mShadowAlpha = new ScalarAnimator(100L, 1.0F);
  private boolean mStayPressed;
  private final Canvas mTempCanvas = new Canvas();
  private final Rect mTempRect = new Rect();
  final ScalarAnimator mTextShadowAlpha = new ScalarAnimator(100L, 1.0F);
  protected boolean mTextVisible = true;
  private Drawable mUncheckedOverlay;
  private String messageIntentAction = "android.intent.action.SENDTO";
  private String quickContactIntentAction = "com.android.contacts.action.QUICK_CONTACT";
  int sMovieIconSize;
  int sMovieIconSizeHeight;
  int sMovieLeftX;
  int sMovieLeftY;
  int sMovieRightX;
  int sMovieRightY;
  int sThumbnailSize;
  
  static
  {
    SHADOW_LARGE_COLOUR = -587202560;
    SHADOW_SMALL_COLOUR = -872415232;
  }
  
  public AppIconView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public AppIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppIconView, paramInt, 0);
    this.mIconDestination = paramContext.getInt(0, -1);
    paramContext.recycle();
    if (this.mIconDestination == -1) {
      throw new MissingResourceException("AppIconView must have the attribute launcher:destination set to either 'home' or 'menu' set", "launcher:destination", "value of either 'home' or 'menu'");
    }
    initBadgeValue();
    initMovieIconValue();
    paramContext = getResources();
    this.mIconSize = paramContext.getDimensionPixelSize(2131624134);
    this.mHotseatIconSize = paramContext.getDimensionPixelSize(2131623964);
    sBadgeDrawable = paramContext.getDrawable(2130837685);
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTextSize(sFontSizeDefault);
    this.mPaint.setColor(-1);
    this.mPaint.setTextAlign(Paint.Align.CENTER);
    SHADOW_LARGE_RADIUS = getShadowRadius();
    SHADOW_Y_OFFSET = getShadowDy();
    SHADOW_LARGE_COLOUR = getShadowColor();
    setShadowLayer(SHADOW_LARGE_RADIUS, 0.0F, SHADOW_Y_OFFSET, SHADOW_LARGE_COLOUR);
    setHoverPopupType(0);
    init();
  }
  
  static ColorFilter createDarkenColorFilter(float paramFloat)
  {
    int i = 255 - (int)(255.0F * Math.min(1.0F, Math.max(0.0F, paramFloat)));
    return new LightingColorFilter(Color.argb(255, i, i, i), 0);
  }
  
  private Bitmap createGlowingOutline(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i = HolographicOutlineHelper.MAX_OUTER_BLUR_RADIUS;
    Bitmap localBitmap = Bitmap.createBitmap(getWidth() + i, getHeight() + i, Bitmap.Config.ARGB_8888);
    paramCanvas.setBitmap(localBitmap);
    drawWithPadding(paramCanvas, i);
    this.mOutlineHelper.applyThickExpensiveOutlineWithBlur(localBitmap, paramCanvas, paramInt2, paramInt1);
    paramCanvas.setBitmap(null);
    return localBitmap;
  }
  
  private void drawWithPadding(Canvas paramCanvas, int paramInt)
  {
    Rect localRect = this.mTempRect;
    getDrawingRect(localRect);
    localRect.bottom = (getExtendedPaddingTop() - 3 + getLayout().getLineTop(0));
    if (localRect.bottom < this.mIconSize) {
      localRect.bottom = (this.mIconSize + getPaddingTop() + 3);
    }
    paramCanvas.save();
    paramCanvas.scale(getScaleX(), getScaleY(), (getWidth() + paramInt) / 2.0F, (getHeight() + paramInt) / 2.0F);
    paramCanvas.translate(-getScrollX() + paramInt / 2, -getScrollY() + paramInt / 2);
    paramCanvas.clipRect(localRect, Region.Op.REPLACE);
    draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public static int getHomeIconLayout(BaseItem paramBaseItem)
  {
    if (paramBaseItem.mIconMovie == null) {
      return 2130903071;
    }
    return 2130903073;
  }
  
  public static TypedArray getTextViewStyle(Context paramContext, int paramInt)
  {
    return paramContext.obtainStyledAttributes(paramInt, ShadowStyleable.TextView);
  }
  
  public static TypedArray getViewStyle(Context paramContext, int paramInt)
  {
    return paramContext.obtainStyledAttributes(paramInt, ShadowStyleable.View);
  }
  
  private void init()
  {
    this.mOutlineHelper = HolographicOutlineHelper.obtain();
    int i = getContext().getResources().getColor(2131361832);
    this.mPressedGlowColor = i;
    this.mPressedOutlineColor = i;
  }
  
  private boolean isHotseatItem(BaseItem paramBaseItem)
  {
    return ((paramBaseItem instanceof HomeItem)) && (((HomeItem)paramBaseItem).container == -101L);
  }
  
  private void playCheckStatus(boolean paramBoolean)
  {
    Talk localTalk = Talk.INSTANCE;
    if (paramBoolean) {}
    for (int i = 2131755121;; i = 2131755122)
    {
      localTalk.say(i);
      return;
    }
  }
  
  public static void recycleViewStyles(TypedArray paramTypedArray1, TypedArray paramTypedArray2)
  {
    paramTypedArray1.recycle();
    paramTypedArray2.recycle();
  }
  
  static void setDarkenPaintMultiplier(float paramFloat, Paint paramPaint)
  {
    paramPaint.setColorFilter(createDarkenColorFilter(paramFloat));
  }
  
  private void updateCheckingOverlay()
  {
    if (this.mIsCheckingEnabled)
    {
      if (this.mCheckedOverlay == null) {
        this.mCheckedOverlay = getContext().getResources().getDrawable(2130837729);
      }
      if (this.mUncheckedOverlay == null) {
        this.mUncheckedOverlay = getContext().getResources().getDrawable(2130837728);
      }
      if (isChecked())
      {
        setOverlay(this.mCheckedOverlay);
        return;
      }
      setOverlay(this.mUncheckedOverlay);
      return;
    }
    setOverlay(null);
  }
  
  public void applyBaseItem(BaseItem paramBaseItem)
  {
    applyBaseItem(paramBaseItem, paramBaseItem.mIconBitmap);
  }
  
  protected void applyBaseItem(BaseItem paramBaseItem, Bitmap paramBitmap)
  {
    setTag(paramBaseItem);
    Object localObject2 = paramBaseItem.mTitle;
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    this.mIsAttachedHotseat = isHotseatItem(paramBaseItem);
    if (this.mTextVisible) {
      setText((CharSequence)localObject1);
    }
    if (paramBaseItem.mType != BaseItem.Type.MENU_FOLDER)
    {
      localObject2 = localObject1;
      if (paramBaseItem.mType != BaseItem.Type.HOME_FOLDER) {}
    }
    else
    {
      if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
        break label624;
      }
      localObject2 = getResources().getString(2131755113);
    }
    label143:
    label163:
    Object localObject3;
    label339:
    int i;
    Object localObject4;
    if (BaseItem.isItemInFolder(paramBaseItem))
    {
      setContentDescription((String)localObject2 + ", " + getResources().getString(2131755209));
      localObject1 = paramBitmap;
      if (paramBitmap == null) {
        try
        {
          if (getClass() != FolderIconView.class) {
            break label905;
          }
          bool = true;
          throw new NullPointerException("Trying to create a FastBitmapDrawable with a null bitmap. See attached item info: isFolder= " + bool + " " + paramBaseItem);
        }
        catch (NullPointerException paramBitmap)
        {
          localObject1 = Utilities.createIconBitmap(getResources().getDrawableForDensity(17629184, getResources().getDisplayMetrics().densityDpi), getContext());
          System.out.println(paramBitmap);
          paramBitmap.printStackTrace();
        }
      }
      localObject2 = localObject1;
      if ((paramBaseItem instanceof HomeShortcutItem))
      {
        localObject2 = localObject1;
        if (paramBaseItem.getComponentName() != null)
        {
          localObject2 = localObject1;
          if (paramBaseItem.getComponentName().getClassName().equalsIgnoreCase("com.android.dialer.DialtactsActivity"))
          {
            if (DEBUGGABLE) {
              Log.d("AppIconView", "applyBaseItem: Phone icon is loaded");
            }
            localObject2 = getContext().getPackageManager();
            localObject3 = ((PackageManager)localObject2).resolveActivity(((HomeShortcutItem)paramBaseItem).intent, 0);
            if (((ResolveInfo)localObject3).activityInfo != null) {
              break label911;
            }
            localObject1 = ((ResolveInfo)localObject3).serviceInfo;
            i = ((ResolveInfo)localObject3).getIconResource();
            paramBaseItem.mIconResId = i;
            localObject4 = ((ComponentInfo)localObject1).applicationInfo;
            paramBitmap = null;
            if (localObject4 != null) {
              break label921;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getResourcesForApplication(paramBaseItem.getPackageName());
        paramBitmap = (Bitmap)localObject2;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        label624:
        int j;
        label905:
        label911:
        label921:
        localNameNotFoundException.printStackTrace();
        continue;
        localObject1 = ((ComponentInfo)localObject1).packageName;
        continue;
        continue;
        bool = false;
        continue;
        if (!((HomeShortcutItem)paramBaseItem).getIntent().getAction().equals(this.messageIntentAction)) {
          continue;
        }
        paramBitmap = BitmapFactory.decodeResource(getContext().getResources(), 2130837517);
        continue;
        paramBitmap = null;
        continue;
      }
      this.mPkgResCache = LauncherApplication.getInst().getPkgResCache();
      localObject2 = this.mPkgResCache;
      if (((ComponentInfo)localObject1).icon == 0) {
        continue;
      }
      localObject1 = ((ComponentInfo)localObject1).name;
      localObject1 = ((PkgResCache)localObject2).loadBitmap(paramBitmap, i, (String)localObject1);
      paramBitmap = (Bitmap)localObject1;
      if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
      {
        localObject4 = LauncherApplication.getInst().getThemeLoader();
        paramBitmap = (Bitmap)localObject1;
        if (!((ThemeLoader)localObject4).isUseDefaultTheme())
        {
          localObject2 = ((ThemeLoader)localObject4).loadAppIconBitmap(((ResolveInfo)localObject3).activityInfo.name);
          paramBitmap = (Bitmap)localObject2;
          if (localObject2 == null) {
            paramBitmap = ((ThemeLoader)localObject4).load3rdAppIconBitmap((Bitmap)localObject1);
          }
          if (paramBitmap != null) {
            continue;
          }
          paramBitmap = (Bitmap)localObject1;
        }
      }
      localObject2 = paramBitmap;
      if (paramBitmap == null)
      {
        if (DEBUGGABLE) {
          Log.e("AppIconView", "applyBaseItem: phone icon set to system default app icon");
        }
        localObject2 = Utilities.createIconBitmap(getResources().getDrawableForDensity(17629184, getResources().getDisplayMetrics().densityDpi), getContext());
      }
      if ((!this.mIsAttachedHotseat) || ((paramBaseItem instanceof FolderItem))) {
        continue;
      }
      bool = true;
      setIcon((Bitmap)localObject2, bool);
      if (paramBaseItem.mIconMovie != null)
      {
        if (!((HomeShortcutItem)paramBaseItem).getIntent().getAction().equals(this.dialIntentAction)) {
          continue;
        }
        paramBitmap = BitmapFactory.decodeResource(getContext().getResources(), 2130837516);
        setIconMovie(paramBaseItem.mIconMovie, paramBitmap);
      }
      if (!BaseItem.isItemInFolder(paramBaseItem)) {
        resetShadow();
      }
      return;
      localObject3 = getResources().getString(2131755114);
      i = ((String)localObject3).length();
      j = ((String)localObject1).length();
      if (j >= i)
      {
        localObject2 = localObject1;
        if (((String)localObject1).substring(j - i).equalsIgnoreCase((String)localObject3)) {
          break;
        }
      }
      localObject2 = ((String)localObject1).concat(" " + (String)localObject3);
      break;
      if ((paramBaseItem instanceof HomeShortcutItem))
      {
        localObject3 = "";
        localObject4 = ((HomeShortcutItem)paramBaseItem).getIntent().getAction();
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject1 = localObject3;
          if (!((String)localObject4).isEmpty())
          {
            if ((!((String)localObject4).equals(this.dialIntentAction)) && (!((String)localObject4).equals(this.callIntentAction))) {
              continue;
            }
            localObject1 = getResources().getString(2131755221);
          }
        }
        if (((String)localObject1).length() > 0)
        {
          setContentDescription((String)localObject2 + " " + (String)localObject1);
          break label143;
          if (((String)localObject4).equals(this.messageIntentAction))
          {
            localObject1 = getResources().getString(2131755222);
            continue;
          }
          localObject1 = localObject3;
          if (!((String)localObject4).equals(this.quickContactIntentAction)) {
            continue;
          }
          localObject1 = getResources().getString(2131755223);
          continue;
        }
        setContentDescription((CharSequence)localObject2);
        break label143;
      }
      setContentDescription((CharSequence)localObject2);
      break label143;
      bool = false;
      break label163;
      localObject1 = ((ResolveInfo)localObject3).activityInfo;
      break label339;
      localObject2 = ((PackageManager)localObject2).getResourcesForApplication((ApplicationInfo)localObject4);
      paramBitmap = (Bitmap)localObject2;
    }
  }
  
  public void applyStyle(int paramInt)
  {
    Object localObject = getContext();
    TypedArray localTypedArray = getViewStyle((Context)localObject, paramInt);
    localObject = getTextViewStyle((Context)localObject, paramInt);
    applyStyle(localTypedArray, (TypedArray)localObject);
    recycleViewStyles(localTypedArray, (TypedArray)localObject);
  }
  
  public void applyStyle(TypedArray paramTypedArray1, TypedArray paramTypedArray2)
  {
    RotateHelper.setViewAttributes(paramTypedArray1, this);
    RotateHelper.setTextViewAttributes(paramTypedArray2, this);
    paramTypedArray1 = (BaseItem)getTag();
    if (paramTypedArray1 != null)
    {
      paramTypedArray1 = paramTypedArray1.mIconMovie;
      if (paramTypedArray1 != null) {
        setIconMovie(paramTypedArray1);
      }
    }
  }
  
  public Drawable createBadgeDrawable(int paramInt)
  {
    if (paramInt == 0) {
      return null;
    }
    if (paramInt >= 1000) {
      this.mPaint.setTextSize(sFontSizeSmall);
    }
    for (;;)
    {
      sBadgeDrawable.getPadding(this.mBoundsRect);
      int i1 = this.mBoundsRect.left;
      int m = this.mBoundsRect.top;
      int i3 = i1 + this.mBoundsRect.right;
      int i2 = m + this.mBoundsRect.bottom;
      int i = sBadgeDrawable.getIntrinsicWidth() - i3;
      int k = sBadgeDrawable.getIntrinsicHeight() - i2;
      String str = String.format("%d", new Object[] { Integer.valueOf(paramInt) });
      Rect localRect = this.mBoundsRect;
      this.mPaint.getTextBounds(str, 0, str.length(), localRect);
      int j = localRect.width() + getResources().getDimensionPixelSize(2131624056);
      int n = localRect.height();
      paramInt = j;
      if (j < i) {
        paramInt = i;
      }
      j = n;
      i = m;
      if (n < k)
      {
        i = m + (k - n) / 2;
        j = k;
      }
      k = paramInt + i3;
      j += i2;
      Bitmap localBitmap = Bitmap.createBitmap(k, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      sBadgeDrawable.setBounds(0, 0, k, j);
      sBadgeDrawable.draw(localCanvas);
      localCanvas.drawText(str, paramInt / 2 + i1, i - localRect.top, this.mPaint);
      return new FastBitmapDrawable(localBitmap);
      this.mPaint.setTextSize(sFontSizeDefault);
    }
  }
  
  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    if (Launcher.isHelpAppRunning) {}
    while (Launcher.isInValidDragState(paramDragEvent)) {
      return false;
    }
    if (paramDragEvent.getAction() == 1) {
      sIsDragState = true;
    }
    for (;;)
    {
      return super.dispatchDragEvent(paramDragEvent);
      if (paramDragEvent.getAction() == 4) {
        sIsDragState = false;
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Utilities.onViewDraw(this, paramCanvas);
    drawShadow(paramCanvas);
    drawIconOrText(paramCanvas);
  }
  
  public void drawIconOrText(Canvas paramCanvas)
  {
    int i = getScrollX();
    int j = getScrollY();
    int k = (int)(this.mTextShadowAlpha.get() * 255.0F);
    setTextColor(getCurrentTextColor() & 0xFFFFFF | k << 24);
    int m = SHADOW_LARGE_COLOUR;
    getPaint().setShadowLayer(SHADOW_LARGE_RADIUS, 0.0F, SHADOW_Y_OFFSET, m & 0xFFFFFF | k << 24);
    Drawable localDrawable;
    if (!this.mDrawIcon)
    {
      paramCanvas.save(2);
      paramCanvas.clipRect(i, getExtendedPaddingTop() + j, getWidth() + i, getHeight() + j, Region.Op.INTERSECT);
      super.draw(paramCanvas);
      paramCanvas.restore();
      if (this.mTextShadowAlpha.isAnimating()) {
        invalidate();
      }
      paramCanvas.save(2);
      paramCanvas.clipRect(i, getExtendedPaddingTop() + j, getWidth() + i, getHeight() + j, Region.Op.INTERSECT);
      super.draw(paramCanvas);
      paramCanvas.restore();
      localDrawable = this.mOverlay;
      if ((localDrawable != null) && (localDrawable.isVisible()) && (this.mDrawIcon))
      {
        localDrawable.setState(getDrawableState());
        if (this.mIsCheckingEnabled) {
          if (isClickable()) {
            break label418;
          }
        }
      }
    }
    label418:
    for (float f = this.mDimAmount;; f = 0.0F)
    {
      localDrawable.setColorFilter(createDarkenColorFilter(f));
      i = 1;
      if ((this instanceof FolderIconView)) {
        i = getResources().getDimensionPixelSize(2131624341);
      }
      k = getPaddingTop() + sIconTopToTopOffset + i;
      m = getWidth();
      int n = localDrawable.getIntrinsicWidth();
      j = m / 2 + sIconCenterXOffset;
      i = j;
      if (j + n > m) {
        i = j - (j + n - m);
      }
      i += getScrollX();
      localDrawable.setBounds(i, k, localDrawable.getIntrinsicWidth() + i, localDrawable.getIntrinsicHeight() + k);
      localDrawable.draw(paramCanvas);
      return;
      paramCanvas.save(2);
      paramCanvas.clipRect(i, j, getWidth() + i, getExtendedPaddingTop() + j, Region.Op.INTERSECT);
      super.draw(paramCanvas);
      paramCanvas.restore();
      break;
    }
  }
  
  protected void drawShadow(Canvas paramCanvas)
  {
    if ((this.mIconShadowDrawable != null) && (this.mDrawShadow))
    {
      paramCanvas.save();
      int i = getWidth();
      int j = this.mIconShadowDrawable.getIntrinsicWidth();
      int k = this.mIconBitmap.getHeight();
      int m = this.mIconShadowDrawable.getIntrinsicHeight();
      paramCanvas.translate((i - j) / 2.0F, getPaddingTop() + (k - m) / 2.0F);
      i = (int)(this.mShadowAlpha.get() * getAlpha() * 255.0F);
      this.mIconShadowDrawable.setAlpha(i);
      this.mIconShadowDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  protected void drawableStateChanged()
  {
    if (isPressed()) {
      if (!this.mDidInvalidateForPressedState) {
        setCellLayoutPressedOrFocusedIcon();
      }
    }
    label61:
    label130:
    label133:
    for (;;)
    {
      super.drawableStateChanged();
      Drawable localDrawable = this.mOverlay;
      if ((localDrawable != null) && (localDrawable.isVisible()))
      {
        localDrawable.setState(getDrawableState());
        invalidate();
      }
      return;
      int i;
      if (this.mPressedOrFocusedBackground == null)
      {
        i = 1;
        if (!this.mStayPressed) {
          this.mPressedOrFocusedBackground = null;
        }
        if (isFocused())
        {
          if (getLayout() == null) {
            this.mPressedOrFocusedBackground = null;
          }
          this.mStayPressed = false;
          setCellLayoutPressedOrFocusedIcon();
        }
        if (this.mPressedOrFocusedBackground != null) {
          break label130;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j == 0)) {
          break label133;
        }
        setCellLayoutPressedOrFocusedIcon();
        break;
        i = 0;
        break label61;
      }
    }
  }
  
  protected void generateShadowIfNeeded()
  {
    if ((shouldHaveIconShadow()) && (this.mIconShadowDrawable == null) && (this.mIconBitmap != null))
    {
      localBaseItem = (BaseItem)getTag();
      if (localBaseItem != null)
      {
        if (localBaseItem.mIconShadowBitmap == null) {
          break label49;
        }
        setIconShadow(localBaseItem.mIconShadowBitmap);
      }
    }
    label49:
    while (shouldHaveIconShadow())
    {
      BaseItem localBaseItem;
      return;
      Bitmap localBitmap = this.mIconBitmap;
      if (this.mIsAttachedHotseat) {
        localBitmap = Bitmap.createScaledBitmap(this.mIconBitmap, this.mIconSize, this.mIconSize, true);
      }
      ShadowGen.getInstance().queueBitmap(localBitmap, new ShadowReadyCallback(this, localBaseItem), getHandler(), getContext().getResources(), false);
      return;
    }
  }
  
  public int getAnimGroup()
  {
    int i = 0;
    if (this.mIsAttachedHotseat) {
      i = 1;
    }
    return i;
  }
  
  public float getDimAmount()
  {
    return this.mDimAmount;
  }
  
  public Bitmap getDragIcon()
  {
    return getIcon();
  }
  
  public DynamicShadowMixin getDynamicShadowMixin()
  {
    return null;
  }
  
  protected float getHotseatScaleFactor()
  {
    float f = 1.0F;
    if (this.mIsAttachedHotseat) {
      f = 1.0F * this.mHotseatIconSize / this.mIconSize;
    }
    return f;
  }
  
  public Bitmap getIcon()
  {
    return this.mIconBitmap;
  }
  
  public long getItemId()
  {
    return ((BaseItem)getTag()).mId;
  }
  
  public int[] getLastTouchPoint()
  {
    return (int[])this.mLastTouch.clone();
  }
  
  public MovieDrawable getMovieDrawable()
  {
    return this.mMovieDrawable;
  }
  
  Bitmap getPressedOrFocusedBackground()
  {
    return this.mPressedOrFocusedBackground;
  }
  
  int getPressedOrFocusedBackgroundPadding()
  {
    return HolographicOutlineHelper.MAX_OUTER_BLUR_RADIUS / 2;
  }
  
  public boolean getTextVisible()
  {
    return this.mTextVisible;
  }
  
  public void hideBadge()
  {
    setOverlay(null);
    Object localObject = getTag();
    if ((localObject != null) && ((localObject instanceof BaseItem)))
    {
      localObject = (BaseItem)localObject;
      if ((((BaseItem)localObject).mType == BaseItem.Type.HOME_APPLICATION) || (((BaseItem)localObject).mType == BaseItem.Type.MENU_APP)) {
        setContentDescription(((BaseItem)localObject).mTitle);
      }
    }
  }
  
  protected void initBadgeValue()
  {
    Resources localResources = getResources();
    sIconCenterXOffset = localResources.getDimensionPixelSize(2131624339);
    sIconTopToTopOffset = localResources.getDimensionPixelSize(2131624340);
    this.sThumbnailSize = localResources.getDimensionPixelSize(2131624137);
    sFontSizeDefault = localResources.getDimensionPixelSize(2131624337);
    sFontSizeSmall = localResources.getDimensionPixelSize(2131624338);
  }
  
  protected void initMovieIconValue()
  {
    Resources localResources = getResources();
    this.sMovieIconSize = localResources.getDimensionPixelSize(2131624135);
    this.sMovieIconSizeHeight = localResources.getDimensionPixelSize(2131624136);
    this.sMovieLeftX = localResources.getDimensionPixelSize(2131624138);
    this.sMovieLeftY = localResources.getDimensionPixelSize(2131624139);
    this.sMovieRightX = localResources.getDimensionPixelSize(2131624140);
    this.sMovieRightY = localResources.getDimensionPixelSize(2131624141);
  }
  
  public boolean isChecked()
  {
    return (this.mIsCheckingEnabled) && (this.mIsChecked);
  }
  
  public boolean isDimmed()
  {
    return this.mIsDimmed;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mMovieDrawable != null) {
      invalidate();
    }
  }
  
  public void onDrop()
  {
    this.mDrawIcon = true;
    this.mDrawShadow = true;
    invalidate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    Object localObject = getTag();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool;
            this.mLastTouch[0] = ((int)paramMotionEvent.getX());
            this.mLastTouch[1] = ((int)paramMotionEvent.getY());
            if (!(localObject instanceof AppItem))
            {
              if (this.mPressedOrFocusedBackground == null) {
                this.mPressedOrFocusedBackground = createGlowingOutline(this.mTempCanvas, this.mPressedGlowColor, this.mPressedOutlineColor);
              }
              if (isPressed())
              {
                this.mDidInvalidateForPressedState = true;
                setCellLayoutPressedOrFocusedIcon();
                return bool;
              }
              this.mDidInvalidateForPressedState = false;
              return bool;
            }
          } while ((!(localObject instanceof AppItem)) || ((Launcher)getContext() == null) || (((Launcher)getContext()).getMenuView() == null) || (((Launcher)getContext()).getMenuView().getMenuAppsGrid() == null) || (((Launcher)getContext()).getMenuView().getMenuAppsGrid().getState() != MenuAppsGrid.State.NORMAL));
          setAlpha(0.4F);
          return bool;
        } while ((!(localObject instanceof AppItem)) || ((Launcher)getContext() == null) || (((Launcher)getContext()).getMenuView() == null) || (((Launcher)getContext()).getMenuView().getMenuAppsGrid() == null) || (((Launcher)getContext()).getMenuView().getMenuAppsGrid().getState() != MenuAppsGrid.State.NORMAL));
        setAlpha(1.0F);
        return bool;
      } while (!(localObject instanceof AppItem));
      setAlpha(1.0F);
      return bool;
    } while ((paramMotionEvent.getPointerCount() != 2) || (!(localObject instanceof AppItem)) || (((Launcher)getContext()).getMenuView().getMenuAppsGrid().getState() != MenuAppsGrid.State.NORMAL));
    setAlpha(1.0F);
    return bool;
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt != 0) {}
    Object localObject;
    do
    {
      return;
      localObject = getTag();
    } while ((localObject == null) || (!(localObject instanceof BaseItem)) || (BaseItem.isItemInFolder((BaseItem)localObject)));
    generateShadowIfNeeded();
  }
  
  public void refreshBadge()
  {
    showBadge();
  }
  
  public void resetShadow()
  {
    this.mIconShadowDrawable = null;
    generateShadowIfNeeded();
  }
  
  void setCellLayoutPressedOrFocusedIcon()
  {
    Object localObject = (ViewGroup)getParent();
    CellLayout localCellLayout;
    if ((localObject != null) && ((((ViewGroup)localObject).getParent() instanceof CellLayout)))
    {
      localCellLayout = (CellLayout)((ViewGroup)localObject).getParent();
      if (this.mPressedOrFocusedBackground == null) {
        break label45;
      }
    }
    label45:
    for (localObject = this;; localObject = null)
    {
      localCellLayout.setPressedOrFocusedIcon((AppIconView)localObject);
      return;
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.mIsChecked = paramBoolean;
    updateCheckingOverlay();
    if (!MenuAppsGrid.mExitingSelectableState) {
      playCheckStatus(this.mIsChecked);
    }
    MenuAppsGrid.mExitingSelectableState = false;
    invalidate();
  }
  
  public void setCheckingEnabled(boolean paramBoolean)
  {
    this.mIsCheckingEnabled = paramBoolean;
    updateCheckingOverlay();
    invalidate();
  }
  
  public void setDimAmount(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F)) {
      return;
    }
    this.mDimAmount = paramFloat;
  }
  
  public void setDimmed(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mIsDimmed == paramBoolean1) {}
    do
    {
      return;
      this.mIsDimmed = paramBoolean1;
      if (paramBoolean1) {}
      ColorFilter localColorFilter;
      for (float f = this.mDimAmount;; f = 0.0F)
      {
        setDarkenPaintMultiplier(f, getPaint());
        Drawable[] arrayOfDrawable = getCompoundDrawables();
        localColorFilter = createDarkenColorFilter(f);
        int i = 0;
        while (i < arrayOfDrawable.length)
        {
          if ((arrayOfDrawable[i] != null) && ((!(this instanceof FolderIconView)) || (!CellLayout.isItemApp()) || (!sIsDragState))) {
            arrayOfDrawable[i].setColorFilter(localColorFilter);
          }
          i += 1;
        }
      }
      setDimmedBadge(paramBoolean1, paramBoolean2, localColorFilter);
    } while (!paramBoolean2);
    invalidate();
  }
  
  public void setDimmedBadge(boolean paramBoolean1, boolean paramBoolean2, ColorFilter paramColorFilter)
  {
    Object localObject = getTag();
    if ((localObject == null) || (!(localObject instanceof BaseItem)) || (((BaseItem)localObject).mBadgeCount == 0)) {}
    for (localObject = null;; localObject = createBadgeDrawable(((BaseItem)localObject).mBadgeCount))
    {
      if (localObject != null) {
        ((Drawable)localObject).setColorFilter(paramColorFilter);
      }
      setOverlay((Drawable)localObject);
      return;
    }
  }
  
  void setDrawShadow(boolean paramBoolean)
  {
    this.mDrawShadow = paramBoolean;
  }
  
  public void setHotseatText(HomeItem paramHomeItem)
  {
    if (this.mIsAttachedHotseat)
    {
      paramHomeItem = getContext().getResources();
      if (Utilities.isCamera()) {
        break label48;
      }
    }
    label48:
    for (int i = 2131427347;; i = 2131427346)
    {
      if (!paramHomeItem.getBoolean(i))
      {
        Log.i("AppIconView", "setTextVisible to false");
        setTextVisible(false);
      }
      return;
    }
  }
  
  public void setIcon(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (this.mIconBitmap = paramBitmap;; this.mIconBitmap = Utilities.CreateScaledBitmapWithNormalSize(paramBitmap, getContext()))
    {
      paramBitmap = new FastBitmapDrawable(this.mIconBitmap);
      if ((isDimmed()) && (!CellLayout.isItemApp()))
      {
        ColorFilter localColorFilter = createDarkenColorFilter(this.mDimAmount);
        if (paramBitmap != null) {
          paramBitmap.setColorFilter(localColorFilter);
        }
      }
      setCompoundDrawablesWithIntrinsicBounds(null, paramBitmap, null, null);
      destroyDrawingCache();
      return;
    }
  }
  
  public void setIconMovie(Movie paramMovie)
  {
    this.mMovieDrawable = new MovieDrawable(paramMovie, this.sMovieIconSize, this.sMovieIconSizeHeight);
    this.mIconBitmap = Bitmap.createBitmap(this.sMovieIconSize, this.sMovieIconSize, Bitmap.Config.ARGB_8888);
    paramMovie.draw(new Canvas(this.mIconBitmap), 0.0F, 0.0F);
    if (this.mMoviePhoneIconDrawable != null)
    {
      setCompoundDrawablesRelativeWithIntrinsicBounds(null, this.mMovieDrawable, this.mMoviePhoneIconDrawable, null);
      getCompoundDrawables()[1].setBounds(this.sMovieLeftX, this.sMovieLeftY, this.sMovieRightX, this.sMovieRightY);
      return;
    }
    setCompoundDrawablesWithIntrinsicBounds(null, this.mMovieDrawable, null, null);
  }
  
  public void setIconMovie(Movie paramMovie, Bitmap paramBitmap)
  {
    this.mMovieDrawable = new MovieDrawable(paramMovie, this.sMovieIconSize, this.sMovieIconSizeHeight);
    this.mIconBitmap = Bitmap.createBitmap(this.sMovieIconSize, this.sMovieIconSize, Bitmap.Config.ARGB_8888);
    paramMovie.draw(new Canvas(this.mIconBitmap), 0.0F, 0.0F);
    if (paramBitmap != null)
    {
      paramMovie = Bitmap.createScaledBitmap(paramBitmap, this.sThumbnailSize + 5, this.sThumbnailSize + 3, true);
      this.mMoviePhoneIconDrawable = new BitmapDrawable(getResources(), paramMovie);
      setCompoundDrawablesRelativeWithIntrinsicBounds(null, this.mMovieDrawable, this.mMoviePhoneIconDrawable, null);
      getCompoundDrawables()[1].setBounds(this.sMovieLeftX, this.sMovieLeftY, this.sMovieRightX, this.sMovieRightY);
    }
    for (;;)
    {
      setTextColor(-16777216);
      return;
      setCompoundDrawablesRelativeWithIntrinsicBounds(null, this.mMovieDrawable, null, null);
    }
  }
  
  protected void setIconShadow(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (this.mIsAttachedHotseat)
    {
      float f = 1.0F * this.mHotseatIconSize / this.mIconSize;
      localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * f), (int)(paramBitmap.getHeight() * f), true);
    }
    setIconShadow(new FastBitmapDrawable(localBitmap));
  }
  
  void setIconShadow(Drawable paramDrawable)
  {
    this.mIconShadowDrawable = paramDrawable;
    invalidate();
  }
  
  public void setLastTouchPoint(int paramInt1, int paramInt2)
  {
    this.mLastTouch[0] = paramInt1;
    this.mLastTouch[1] = paramInt2;
  }
  
  public void setOverlay(Drawable paramDrawable)
  {
    if (this.mOverlay != paramDrawable)
    {
      this.mOverlay = paramDrawable;
      invalidate();
    }
  }
  
  public void setTextAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setTextVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = getTag();
      if ((localObject != null) && ((localObject instanceof BaseItem)) && (!this.mTextVisible))
      {
        setText(((BaseItem)localObject).mTitle);
        this.mTextVisible = true;
      }
      return;
    }
    setText("");
    this.mTextVisible = false;
  }
  
  protected boolean shouldHaveIconShadow()
  {
    return false;
  }
  
  public void showBadge()
  {
    Object localObject2 = getTag();
    Object localObject1;
    BaseItem localBaseItem;
    if ((localObject2 == null) || (!(localObject2 instanceof BaseItem)) || (((BaseItem)localObject2).mBadgeCount == 0))
    {
      localObject1 = null;
      setOverlay((Drawable)localObject1);
      if ((localObject2 != null) && ((localObject2 instanceof BaseItem)))
      {
        localBaseItem = (BaseItem)localObject2;
        if ((localBaseItem.mType == BaseItem.Type.HOME_APPLICATION) || (localBaseItem.mType == BaseItem.Type.MENU_APP))
        {
          if (localBaseItem.mBadgeCount <= 1) {
            break label195;
          }
          localObject1 = localBaseItem.mTitle + ", " + String.format(getResources().getString(2131755217), new Object[] { Integer.valueOf(localBaseItem.mBadgeCount) });
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (BaseItem.isItemInFolder(localBaseItem)) {
        localObject2 = (String)localObject1 + ", " + getResources().getString(2131755209);
      }
      setContentDescription((CharSequence)localObject2);
      return;
      localObject1 = createBadgeDrawable(((BaseItem)localObject2).mBadgeCount);
      break;
      label195:
      if (localBaseItem.mBadgeCount == 1) {
        localObject1 = localBaseItem.mTitle + ", " + String.format(getResources().getString(2131755218), new Object[0]);
      } else {
        localObject1 = localBaseItem.mTitle;
      }
    }
  }
  
  public void startFadeShadow()
  {
    this.mShadowAlpha.start(0.0F, 1.0F);
    this.mTextShadowAlpha.start(0.0F, 1.0F);
    this.mDrawIcon = false;
    this.mDrawShadow = true;
    invalidate();
  }
  
  public void toggle()
  {
    if (!this.mIsChecked) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  public void updateMovieValues()
  {
    Resources localResources = getResources();
    this.sMovieIconSize = localResources.getDimensionPixelSize(2131624135);
    this.sMovieIconSizeHeight = localResources.getDimensionPixelSize(2131624136);
    this.sThumbnailSize = localResources.getDimensionPixelSize(2131624137);
    this.sMovieLeftX = localResources.getDimensionPixelSize(2131624138);
    this.sMovieLeftY = localResources.getDimensionPixelSize(2131624139);
    this.sMovieRightX = localResources.getDimensionPixelSize(2131624140);
    this.sMovieRightY = localResources.getDimensionPixelSize(2131624141);
  }
  
  protected static class ShadowReadyCallback
    implements ShadowGen.GeneratedCallback
  {
    private WeakReference<BaseItem> mItemRef;
    private WeakReference<AppIconView> mViewRef;
    
    public ShadowReadyCallback(AppIconView paramAppIconView, BaseItem paramBaseItem)
    {
      this.mViewRef = new WeakReference(paramAppIconView);
      this.mItemRef = new WeakReference(paramBaseItem);
    }
    
    public void onShadowGenerated(Bitmap paramBitmap)
    {
      BaseItem localBaseItem = (BaseItem)this.mItemRef.get();
      AppIconView localAppIconView = (AppIconView)this.mViewRef.get();
      if (localBaseItem != null)
      {
        localBaseItem.mIconShadowBitmap = paramBitmap;
        if (localAppIconView != null) {
          localAppIconView.generateShadowIfNeeded();
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AppIconView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */