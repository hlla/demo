package com.android.launcher2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.TableMaskFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Debug;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Toast;
import com.samsung.android.telephony.MultiSimManager;
import java.util.HashMap;
import java.util.Random;

public final class Utilities
{
  public static final boolean DEBUG_VIEWS_AND_SIZES = false;
  private static final int PACKAGE_CONTEXT_FLAGS = 3;
  private static final String TAG = "Launcher.Utilities";
  private static final float WIDGET_PREVIEW_ICON_PADDING_PERCENTAGE = 0.25F;
  private static final int XXXHDPI_ICON_REAL_SIZE = 192;
  private static final int XXXHDPI_ICON_SIZE = 212;
  private static HashMap<Integer, Paint> mBgPaint;
  private static Toast mToast = null;
  private static Paint sBlackPaint;
  private static final Paint sBlurPaint;
  private static final Canvas sCanvas;
  static int sColorIndex;
  static int[] sColors;
  private static final Paint sDisabledPaint;
  private static final Paint sGlowColorFocusedPaint;
  private static final Paint sGlowColorPressedPaint;
  private static int sIconHeight;
  private static int sIconNormalHeight;
  private static int sIconNormalWidth;
  private static int sIconWidth = -1;
  private static final Rect sOldBounds;
  
  static
  {
    sIconHeight = -1;
    sIconNormalWidth = -1;
    sIconNormalHeight = -1;
    sBlurPaint = new Paint();
    sGlowColorPressedPaint = new Paint();
    sGlowColorFocusedPaint = new Paint();
    sDisabledPaint = new Paint();
    sOldBounds = new Rect();
    sCanvas = new Canvas();
    mBgPaint = new HashMap();
    sBlackPaint = null;
    sCanvas.setDrawFilter(new PaintFlagsDrawFilter(4, 3));
    sColors = new int[] { -65536, -16711936, -16776961 };
    sColorIndex = 0;
  }
  
  static Bitmap CreateScaledBitmapWithNormalSize(Bitmap paramBitmap, Context paramContext)
  {
    if (sIconNormalWidth == -1) {
      initStatics(paramContext);
    }
    return Bitmap.createScaledBitmap(paramBitmap, sIconNormalWidth, sIconNormalHeight, true);
  }
  
  public static final boolean DEBUGGABLE()
  {
    return Debug.isProductShip() != 1;
  }
  
  static void broadcastStkIntent(Context paramContext)
  {
    Intent localIntent = null;
    if (("1".equals(MultiSimManager.getTelephonyProperty("gsm.sim.screenEvent", 0, "0"))) || ("1".equals(MultiSimManager.getTelephonyProperty("gsm.sim.screenEvent", 1, "0")))) {
      localIntent = new Intent("android.intent.action.stk.event");
    }
    if (localIntent != null)
    {
      new CatEventDownload(5).putExtra(localIntent, "STK EVENT");
      paramContext.sendBroadcast(localIntent);
      Log.v("Launcher.Utilities", "broadcastStkIntent sent");
    }
  }
  
  public static void centerChildInParent(RectF paramRectF, PointF paramPointF1, PointF paramPointF2)
  {
    paramRectF.left = ((paramPointF1.x - paramPointF2.x) / 2.0F);
    paramRectF.top = ((paramPointF1.y - paramPointF2.y) / 2.0F);
    paramRectF.right = (paramRectF.left + paramPointF2.x);
    paramRectF.bottom = (paramRectF.top + paramPointF2.y);
  }
  
  public static void centerChildInParent(RectF paramRectF1, RectF paramRectF2, PointF paramPointF)
  {
    paramRectF2.left += (paramRectF2.width() - paramPointF.x) / 2.0F;
    paramRectF2.top += (paramRectF2.height() - paramPointF.y) / 2.0F;
    paramRectF1.right = (paramRectF1.left + paramPointF.x);
    paramRectF1.bottom = (paramRectF1.top + paramPointF.y);
  }
  
  static Bitmap createIconBitmap(Bitmap paramBitmap, Context paramContext)
  {
    synchronized (sCanvas)
    {
      if ((sIconWidth == -1) && (paramContext != null)) {
        initStatics(paramContext);
      }
      int m = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      float f = 1.0F;
      if (m <= sIconWidth)
      {
        i = k;
        j = m;
        if (k <= sIconHeight) {}
      }
      else
      {
        f = Math.min(sIconWidth / m, sIconHeight / k);
        j = (int)(m * f);
        i = (int)(k * f);
      }
      int j = sIconWidth - j;
      int i = sIconHeight - i;
      if ((f >= 1.0F) && (j <= 0))
      {
        paramContext = paramBitmap;
        if (i <= 0) {}
      }
      else
      {
        paramContext = Bitmap.createBitmap(sIconWidth, sIconHeight, Bitmap.Config.ARGB_8888);
        sCanvas.setMatrix(null);
        sCanvas.setBitmap(paramContext);
        sCanvas.translate(j * 0.5F, i * 0.5F);
        sCanvas.scale(f, f);
        sCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
        sCanvas.setBitmap(null);
      }
      return paramContext;
    }
  }
  
  static Bitmap createIconBitmap(Drawable paramDrawable, Context paramContext)
  {
    for (;;)
    {
      float f2;
      int m;
      int k;
      int j;
      int i;
      float f1;
      synchronized (sCanvas)
      {
        if (sIconWidth == -1) {
          initStatics(paramContext);
        }
        if ((paramDrawable instanceof PaintDrawable))
        {
          paramContext = (PaintDrawable)paramDrawable;
          paramContext.setIntrinsicWidth(sIconWidth);
          paramContext.setIntrinsicHeight(sIconHeight);
          paramDrawable.copyBounds(sOldBounds);
          f2 = 1.0F;
          m = paramDrawable.getIntrinsicWidth();
          k = paramDrawable.getIntrinsicHeight();
          if ((m > 0) && (k > 0)) {
            break label240;
          }
          j = sIconWidth;
          i = sIconHeight;
          paramDrawable.setBounds(0, 0, sIconWidth, sIconHeight);
          f1 = f2;
          k = sIconWidth;
          m = sIconHeight;
          paramContext = Bitmap.createBitmap(sIconWidth, sIconHeight, Bitmap.Config.ARGB_8888);
          sCanvas.setMatrix(null);
          sCanvas.setBitmap(paramContext);
          sCanvas.translate((k - j) * 0.5F, (m - i) * 0.5F);
          sCanvas.scale(f1, f1);
          paramDrawable.draw(sCanvas);
          paramDrawable.setBounds(sOldBounds);
          sCanvas.setBitmap(null);
          return paramContext;
        }
      }
      if ((paramDrawable instanceof BitmapDrawable))
      {
        ??? = (BitmapDrawable)paramDrawable;
        if (((BitmapDrawable)???).getBitmap().getDensity() == 0)
        {
          ((BitmapDrawable)???).setTargetDensity(paramContext.getResources().getDisplayMetrics());
          continue;
          label240:
          paramDrawable.setBounds(0, 0, m, k);
          if ((m > sIconWidth) || (k > sIconHeight))
          {
            f1 = Math.min(sIconWidth / m, sIconHeight / k);
            j = (int)(m * f1);
            i = (int)(k * f1);
          }
          else
          {
            f1 = f2;
            i = k;
            j = m;
            if (sIconWidth == 212)
            {
              f1 = f2;
              i = k;
              j = m;
              if (m == 192)
              {
                f1 = Math.min(sIconWidth / m, sIconHeight / k);
                j = (int)(m * f1);
                i = (int)(k * f1);
              }
            }
          }
        }
      }
    }
  }
  
  static Bitmap createIconBitmap(Drawable paramDrawable, Context paramContext, int paramInt)
  {
    if (sIconWidth == -1) {
      initStatics(paramContext);
    }
    if (paramInt == 0) {
      return createIconBitmap(paramDrawable, paramContext);
    }
    int i = sIconWidth;
    sIconHeight = paramInt;
    sIconWidth = paramInt;
    Log.d("Launcher.Utilities", "createIconBitmapForMenu sIconWidth : " + sIconWidth + " sourceWidth : " + paramDrawable.getIntrinsicWidth());
    paramDrawable = createIconBitmap(paramDrawable, paramContext);
    sIconHeight = i;
    sIconWidth = i;
    return paramDrawable;
  }
  
  static Bitmap drawDisabledBitmap(Bitmap paramBitmap, Context paramContext)
  {
    synchronized (sCanvas)
    {
      if (sIconWidth == -1) {
        initStatics(paramContext);
      }
      paramContext = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      ??? = sCanvas;
      ???.setBitmap(paramContext);
      ???.drawBitmap(paramBitmap, 0.0F, 0.0F, sDisabledPaint);
      ???.setBitmap(null);
      return paramContext;
    }
  }
  
  static void drawSelectedAllAppsBitmap(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean, Bitmap paramBitmap)
  {
    synchronized (sCanvas)
    {
      if (sIconWidth == -1) {
        throw new RuntimeException("Assertion failed: Utilities not initialized");
      }
    }
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    int[] arrayOfInt = new int[2];
    Bitmap localBitmap = paramBitmap.extractAlpha(sBlurPaint, arrayOfInt);
    float f1 = (paramInt1 - paramBitmap.getWidth()) / 2;
    float f2 = (paramInt2 - paramBitmap.getHeight()) / 2;
    float f3 = arrayOfInt[0];
    float f4 = arrayOfInt[1];
    if (paramBoolean) {}
    for (paramBitmap = sGlowColorPressedPaint;; paramBitmap = sGlowColorFocusedPaint)
    {
      paramCanvas.drawBitmap(localBitmap, f1 + f3, f2 + f4, paramBitmap);
      localBitmap.recycle();
      return;
    }
  }
  
  public static void drawVerticalLine(View paramView, Canvas paramCanvas, int paramInt)
  {
    ensureBlackPaint();
    int i = paramView.getScrollX();
    int j = paramView.getScrollY();
    paramCanvas.drawRect(i + paramInt - 1, j, i + paramInt + 1, paramView.getHeight() + j, sBlackPaint);
  }
  
  private static void ensureBlackPaint()
  {
    try
    {
      if (sBlackPaint == null)
      {
        sBlackPaint = new Paint();
        sBlackPaint.setColor(-16777216);
        sBlackPaint.setTextSize(10.0F);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static Paint ensureViewBgPaint(View paramView)
  {
    Integer localInteger = Integer.valueOf(paramView.hashCode());
    Paint localPaint = (Paint)mBgPaint.get(localInteger);
    paramView = localPaint;
    if (localPaint == null)
    {
      paramView = new Paint();
      paramView.setColor(getRandomColor(127, 155, 100));
      mBgPaint.put(localInteger, paramView);
    }
    return paramView;
  }
  
  static int generateRandomId()
  {
    return new Random(System.currentTimeMillis()).nextInt(16777216);
  }
  
  public static int getDeviceRotation(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
  }
  
  public static InputFilter[] getEditTextMaxLengthFilter(final Context paramContext, int paramInt)
  {
    new InputFilter[] { new InputFilter()
    {
      public CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {}
        do
        {
          return null;
          paramAnonymousInt3 = this.val$maxSize - (paramAnonymousSpanned.length() - (paramAnonymousInt4 - paramAnonymousInt3));
          if (paramAnonymousInt3 <= 0)
          {
            Utilities.showToast(paramContext, this.val$maxSize);
            return "";
          }
          if ((paramAnonymousInt3 == 1) && (paramAnonymousInt2 - paramAnonymousInt1 == 2)) {
            return "";
          }
        } while ((paramAnonymousInt3 >= paramAnonymousInt2 - paramAnonymousInt1) || (paramAnonymousInt3 >= paramAnonymousInt2 - paramAnonymousInt1));
        try
        {
          Utilities.showToast(paramContext, this.val$maxSize);
          paramAnonymousCharSequence = paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3);
          return paramAnonymousCharSequence;
        }
        catch (IndexOutOfBoundsException paramAnonymousCharSequence) {}
        return "";
      }
    } };
  }
  
  public static void getLocationWithRespectTo(int[] paramArrayOfInt, ViewParent paramViewParent, View paramView)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2)) {
      throw new IllegalArgumentException("location must be an array of two integers");
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramView.getLeft();
    arrayOfFloat[1] = paramView.getTop();
    for (paramView = paramView.getParent(); ((paramView instanceof View)) && (paramView != paramViewParent); paramView = paramView.getParent())
    {
      paramView = (View)paramView;
      arrayOfFloat[0] -= paramView.getScrollX();
      arrayOfFloat[1] -= paramView.getScrollY();
      Matrix localMatrix = paramView.getMatrix();
      if (!localMatrix.isIdentity()) {
        localMatrix.mapPoints(arrayOfFloat);
      }
      arrayOfFloat[0] += paramView.getLeft();
      arrayOfFloat[1] += paramView.getTop();
    }
    paramArrayOfInt[0] = ((int)(arrayOfFloat[0] + 0.5F));
    paramArrayOfInt[1] = ((int)(arrayOfFloat[1] + 0.5F));
  }
  
  public static int getRandomColor(int paramInt1, int paramInt2, int paramInt3)
  {
    return Color.argb(paramInt1, new Random().nextInt(paramInt3) + paramInt2, new Random().nextInt(paramInt3) + paramInt2, new Random().nextInt(paramInt3) + paramInt2);
  }
  
  public static int getSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = Math.round(paramInt2 / paramInt4);
    paramInt1 = Math.round(paramInt1 / paramInt3);
    if (paramInt2 > paramInt1) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static void getScreenSize(Context paramContext, Point paramPoint)
  {
    paramContext = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = paramContext.getDisplayMetrics();
    paramPoint.x = localDisplayMetrics.widthPixels;
    paramPoint.y = localDisplayMetrics.heightPixels;
    float f;
    if (isCamera())
    {
      f = localDisplayMetrics.density;
      if (LauncherApplication.isScreenLarge()) {
        paramPoint.y += (int)Math.ceil(48.0F * f);
      }
    }
    else
    {
      return;
    }
    switch (paramContext.getConfiguration().orientation)
    {
    default: 
      return;
    case 1: 
      paramPoint.y += (int)Math.ceil(48.0F * f);
      return;
    }
    paramPoint.x += (int)Math.ceil(localDisplayMetrics.density * 42.0F);
  }
  
  public static String hashCode(Object paramObject)
  {
    return Integer.toHexString(System.identityHashCode(paramObject));
  }
  
  private static void initStatics(Context paramContext)
  {
    paramContext = paramContext.getResources();
    float f = paramContext.getDisplayMetrics().density;
    int i = (int)paramContext.getDimension(2131624134);
    sIconHeight = i;
    sIconWidth = i;
    i = (int)paramContext.getDimension(2131623964);
    sIconNormalHeight = i;
    sIconNormalWidth = i;
    sBlurPaint.setMaskFilter(new BlurMaskFilter(5.0F * f, BlurMaskFilter.Blur.NORMAL));
    sGlowColorPressedPaint.setColor(49920);
    sGlowColorPressedPaint.setMaskFilter(TableMaskFilter.CreateClipTable(0, 30));
    sGlowColorFocusedPaint.setColor(36352);
    sGlowColorFocusedPaint.setMaskFilter(TableMaskFilter.CreateClipTable(0, 30));
    paramContext = new ColorMatrix();
    paramContext.setSaturation(0.2F);
    sDisabledPaint.setColorFilter(new ColorMatrixColorFilter(paramContext));
    sDisabledPaint.setAlpha(136);
  }
  
  public static boolean isCamera()
  {
    return false;
  }
  
  public static Bitmap loadBitmapToDesiredDimension(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    int m = 0;
    int n = 0;
    int k;
    label145:
    label161:
    label177:
    int i1;
    label198:
    int i2;
    if (localOptions.inTargetDensity != localOptions.inDensity)
    {
      k = 1;
      int j = m;
      int i = n;
      if (k != 0)
      {
        j = m;
        i = n;
        if (localOptions.inTargetDensity != 0)
        {
          j = m;
          i = n;
          if (localOptions.inDensity != 0)
          {
            float f = localOptions.inTargetDensity / localOptions.inDensity;
            i = (int)(localOptions.outWidth * f);
            j = (int)(localOptions.outHeight * f);
          }
        }
      }
      if (localOptions.inDensity != localOptions.inTargetDensity) {
        break label292;
      }
      k = 1;
      if (localOptions.inDensity <= localOptions.inTargetDensity) {
        break label298;
      }
      m = 1;
      if (localOptions.inDensity >= localOptions.inTargetDensity) {
        break label304;
      }
      n = 1;
      if ((localOptions.outWidth <= paramInt2) && (localOptions.outHeight <= paramInt3)) {
        break label310;
      }
      i1 = 1;
      if ((i <= paramInt2) && (j <= paramInt3)) {
        break label316;
      }
      i2 = 1;
      label213:
      if ((m == 0) || (i2 == 0)) {
        break label322;
      }
      localOptions.inSampleSize = getSampleSize(i, j, paramInt2, paramInt3);
    }
    for (;;)
    {
      localOptions.inDither = true;
      localOptions.inJustDecodeBounds = false;
      localOptions.inPreferQualityOverSpeed = true;
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      if (paramResources == null) {
        break label413;
      }
      paramResources.setDensity(localOptions.inTargetDensity);
      return paramResources;
      k = 0;
      break;
      label292:
      k = 0;
      break label145;
      label298:
      m = 0;
      break label161;
      label304:
      n = 0;
      break label177;
      label310:
      i1 = 0;
      break label198;
      label316:
      i2 = 0;
      break label213;
      label322:
      if ((n != 0) && (i1 != 0))
      {
        localOptions.inScaled = false;
        localOptions.inSampleSize = getSampleSize(localOptions.outWidth, localOptions.outHeight, paramInt2, paramInt3);
      }
      else if ((n != 0) && (i2 != 0))
      {
        localOptions.inScaled = false;
      }
      else if ((k != 0) && (i1 != 0))
      {
        localOptions.inSampleSize = getSampleSize(localOptions.outWidth, localOptions.outHeight, paramInt2, paramInt3);
      }
    }
    label413:
    Log.d("Launcher.Utilities", "loadBitmapToDesiredDimension() failed to decode image stream");
    return paramResources;
  }
  
  public static Bitmap loadSamsungWidgetThemePreview(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
    {
      ThemeLoader localThemeLoader = LauncherApplication.getInst().getThemeLoader();
      localObject1 = localObject2;
      if (!localThemeLoader.isUseDefaultTheme()) {
        localObject1 = scaleBitmapToDesiredDimension(localThemeLoader.loadSamsungWidgetPreviewBitmap(paramString1, paramString2), paramInt3, paramInt4);
      }
    }
    paramString2 = (String)localObject1;
    if (localObject1 == null) {
      paramString2 = loadWidgetPreview(paramContext, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    return paramString2;
  }
  
  public static Bitmap loadWidgetPreview(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramInt1 != 0) {}
    for (;;)
    {
      try
      {
        localObject1 = paramContext.createPackageContext(paramString, 3);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = loadBitmapToDesiredDimension(((Context)localObject1).getResources(), paramInt1, paramInt3, paramInt4);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        int j;
        int k;
        int i;
        int m;
        int n;
        int i1;
        Log.e("Launcher.Utilities", "loadWidgetPreview() : Unable to find package", localNameNotFoundException);
        Object localObject2 = localObject3;
        continue;
        paramInt3 = i + m * 4;
        paramInt1 = paramInt3;
        continue;
        if (n <= i1) {
          continue;
        }
        paramInt1 = Math.min(n, paramInt3);
        paramInt3 = (int)(i1 * (paramInt1 / n));
        float f = Math.min(paramInt3 / (m * 2 + i), 1.0F);
        continue;
        paramInt3 = Math.min(i1, paramInt4);
        paramInt1 = (int)(n * (paramInt3 / i1));
        f = Math.min(paramInt1 / (m * 2 + i), 1.0F);
        continue;
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        j = paramArrayOfInt[0];
        k = paramArrayOfInt[1];
        paramArrayOfInt = paramContext.getResources();
        i = paramArrayOfInt.getDimensionPixelSize(2131624134);
        m = paramArrayOfInt.getDimensionPixelSize(2131624230);
        paramInt1 = paramArrayOfInt.getDimensionPixelSize(2131624231);
        n = m * j;
        i1 = paramInt1 * k;
        m = (int)(i * 0.25F);
        f = 1.0F;
        if (j != k) {
          continue;
        }
        if (j > 1) {
          continue;
        }
        paramInt3 = i + m * 2;
        paramInt1 = paramInt3;
        localObject3 = Bitmap.createBitmap(paramInt1, paramInt3, Bitmap.Config.ARGB_8888);
        if ((j != 1) || (k != 1)) {
          renderDrawableToBitmap(paramArrayOfInt.getDrawable(2130837520), (Bitmap)localObject3, 0, 0, paramInt1, paramInt3);
        }
        paramContext = null;
      }
      try
      {
        paramInt1 = (int)(paramInt1 / 2 - i * f / 2.0F);
        paramInt3 = (int)(paramInt3 / 2 - i * f / 2.0F);
        if (paramInt2 > 0) {
          paramContext = localPackageManager.getDrawable(paramString, paramInt2, null);
        }
        paramString = paramContext;
        if (paramContext == null) {
          paramString = paramArrayOfInt.getDrawable(2130837692);
        }
        renderDrawableToBitmap(paramString, (Bitmap)localObject3, paramInt1, paramInt3, (int)(i * f), (int)(i * f));
        return (Bitmap)localObject3;
      }
      catch (Resources.NotFoundException paramContext) {}
      Log.e("Launcher.Utilities", "loadWidgetPreview() : Unable to find package " + paramString);
      localObject1 = localObject3;
    }
    return (Bitmap)localObject3;
  }
  
  public static Bitmap loadWidgetThemePreview(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
    {
      ThemeLoader localThemeLoader = LauncherApplication.getInst().getThemeLoader();
      localObject1 = localObject2;
      if (!localThemeLoader.isUseDefaultTheme()) {
        localObject1 = scaleBitmapToDesiredDimension(localThemeLoader.loadWidgetPreviewBitmap(paramString), paramInt3, paramInt4);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = loadWidgetPreview(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    return (Bitmap)localObject2;
  }
  
  public static void onDestroy()
  {
    mBgPaint.clear();
  }
  
  public static void onViewDraw(View paramView, Canvas paramCanvas)
  {
    onViewDraw(paramView, paramCanvas, false);
  }
  
  public static void onViewDraw(View paramView, Canvas paramCanvas, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = paramView.getScrollX();
      int j = paramView.getScrollY();
      int k = paramView.getWidth();
      int m = paramView.getHeight();
      Paint localPaint = ensureViewBgPaint(paramView);
      paramCanvas.drawRect(i, j, i + k, j + m, localPaint);
      ensureBlackPaint();
      paramView = paramView.getClass().getSimpleName();
      float f1 = sBlackPaint.ascent();
      float f2 = sBlackPaint.descent();
      float f3 = sBlackPaint.getTextSize();
      float f4 = sBlackPaint.measureText(paramView);
      paramCanvas.drawText(paramView, i + (k - f4) / 2.0F, j + m - (f1 + f2 + f3), sBlackPaint);
    }
  }
  
  public static void printCallStack()
  {
    Log.e("Launcher.Utilities", "printCallStack", new Exception());
  }
  
  public static void renderDrawableToBitmap(Drawable paramDrawable, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    renderDrawableToBitmap(paramDrawable, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, 1.0F, -1);
  }
  
  public static void renderDrawableToBitmap(Drawable paramDrawable, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    renderDrawableToBitmap(paramDrawable, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, -1);
  }
  
  public static void renderDrawableToBitmap(Drawable paramDrawable, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    if (paramBitmap != null)
    {
      paramBitmap = new Canvas(paramBitmap);
      paramBitmap.scale(paramFloat, paramFloat);
      Rect localRect = paramDrawable.copyBounds();
      paramDrawable.setBounds(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      paramDrawable.draw(paramBitmap);
      paramDrawable.setBounds(localRect);
      if (paramInt5 != -1) {
        paramBitmap.drawColor(paramInt5, PorterDuff.Mode.MULTIPLY);
      }
      paramBitmap.setBitmap(null);
    }
  }
  
  static Bitmap resampleIconBitmap(Bitmap paramBitmap, Context paramContext)
  {
    synchronized (sCanvas)
    {
      if (sIconWidth == -1) {
        initStatics(paramContext);
      }
      if (paramBitmap.getWidth() == sIconWidth)
      {
        ??? = paramBitmap;
        if (paramBitmap.getHeight() == sIconHeight) {}
      }
      else
      {
        ??? = createIconBitmap(paramBitmap, paramContext);
      }
      return (Bitmap)???;
    }
  }
  
  static int roundToPow2(int paramInt)
  {
    int m = paramInt >> 1;
    int i = 134217728;
    int k;
    for (;;)
    {
      j = i;
      k = m;
      if (i == 0) {
        break;
      }
      j = i;
      k = m;
      if ((m & i) != 0) {
        break;
      }
      i >>= 1;
    }
    while (j != 0)
    {
      k |= j;
      j >>= 1;
    }
    int j = k + 1;
    i = j;
    if (j != paramInt) {
      i = j << 1;
    }
    return i;
  }
  
  public static Bitmap scaleBitmapToDesiredDimension(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0)) {
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = i / paramInt1;
    float f2 = j / paramInt2;
    if (f2 > f1) {
      f1 = f2;
    }
    while (f1 != 0.0F) {
      return Bitmap.createScaledBitmap(paramBitmap, (int)(i / f1), (int)(j / f1), false);
    }
    return paramBitmap;
  }
  
  public static void showToast(Context paramContext, int paramInt)
  {
    if (mToast == null) {
      mToast = Toast.makeText(paramContext, paramContext.getString(2131755229, new Object[] { Integer.valueOf(paramInt) }), 0);
    }
    for (;;)
    {
      mToast.show();
      return;
      mToast.setText(paramContext.getString(2131755229, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/Utilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */