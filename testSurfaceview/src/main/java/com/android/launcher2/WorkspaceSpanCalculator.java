package com.android.launcher2;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.android.launcher2.guide.GuideFragment;
import com.samsung.surfacewidget.SurfaceWidgetProviderInfo;

public enum WorkspaceSpanCalculator
{
  INSTANCE;
  
  private int mCellCountX;
  private int mCellCountY;
  private float mDensity;
  private int mLandCellGapX;
  private int mLandCellGapY;
  private int mLandCellSizeX;
  private int mLandCellSizeY;
  private Padding mPaddingDimens;
  private Padding mPaddingZero = new Padding(0, 0, 0, 0);
  private PackageManager mPkgMgr;
  private int mPortCellGapX;
  private int mPortCellGapY;
  private int mPortCellSizeX;
  private int mPortCellSizeY;
  private Resources mResources;
  private SpanCountCalculatorRoundDown mSpanCalcRoundDown = new SpanCountCalculatorRoundDown(null);
  private SpanCountCalculatorRoundUp mSpanCalcRoundUp = new SpanCountCalculatorRoundUp(null);
  
  private WorkspaceSpanCalculator() {}
  
  private int[] getSpanForWidget(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, SpanCountCalculator paramSpanCountCalculator, boolean paramBoolean)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt != null)
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= 2) {}
    }
    else
    {
      arrayOfInt = new int[2];
    }
    if (paramBoolean)
    {
      paramInt3 = Math.min(this.mResources.getDimensionPixelSize(2131624132), this.mResources.getDimensionPixelSize(2131624133));
      paramInt1 = paramSpanCountCalculator.getSpanCount(paramInt1, paramInt3, 0);
      paramInt2 = paramSpanCountCalculator.getSpanCount(paramInt2, paramInt3, 0);
      arrayOfInt[0] = Math.min(this.mCellCountX, paramInt1);
      arrayOfInt[1] = Math.min(this.mCellCountY, paramInt2);
      return arrayOfInt;
    }
    paramInt1 = paramSpanCountCalculator.getSpanCount(paramInt1, this.mPortCellSizeX, this.mPortCellGapX);
    paramInt2 = paramSpanCountCalculator.getSpanCount(paramInt2, this.mPortCellSizeY, this.mPortCellGapY);
    paramInt3 = paramSpanCountCalculator.getSpanCount(paramInt3, this.mLandCellSizeX, this.mLandCellGapX);
    paramInt4 = paramSpanCountCalculator.getSpanCount(paramInt4, this.mLandCellSizeY, this.mLandCellGapY);
    if (this.mResources.getConfiguration().smallestScreenWidthDp >= 600)
    {
      arrayOfInt[0] = Math.min(this.mCellCountX, Math.max(paramInt1, paramInt3));
      arrayOfInt[1] = Math.min(this.mCellCountY, Math.max(paramInt2, paramInt4));
      return arrayOfInt;
    }
    arrayOfInt[0] = Math.min(this.mCellCountX, paramInt1);
    arrayOfInt[1] = Math.min(this.mCellCountY, paramInt2);
    return arrayOfInt;
  }
  
  private boolean useGEDMode(AppWidgetProviderInfo paramAppWidgetProviderInfo)
  {
    return !(paramAppWidgetProviderInfo instanceof SurfaceWidgetProviderInfo);
  }
  
  public Padding getPaddingForWidget(ComponentName paramComponentName)
  {
    Padding localPadding = this.mPaddingZero;
    try
    {
      ApplicationInfo localApplicationInfo = this.mPkgMgr.getApplicationInfo(paramComponentName.getPackageName(), 0);
      paramComponentName = localPadding;
      if (localApplicationInfo.targetSdkVersion >= 14) {
        paramComponentName = this.mPaddingDimens;
      }
      return paramComponentName;
    }
    catch (Exception paramComponentName) {}
    return localPadding;
  }
  
  public int[] getResizeSpanForWidget(AppWidgetProviderInfo paramAppWidgetProviderInfo, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= 4) {}
    }
    else
    {
      arrayOfInt = new int[4];
    }
    paramArrayOfInt = getPaddingForWidget(paramAppWidgetProviderInfo.provider);
    int i = paramAppWidgetProviderInfo.minResizeWidth + paramArrayOfInt.left + paramArrayOfInt.right;
    int j = paramAppWidgetProviderInfo.minResizeHeight + paramArrayOfInt.top + paramArrayOfInt.bottom;
    boolean bool = useGEDMode(paramAppWidgetProviderInfo);
    int[] arrayOfInt = getSpanForWidget(i, j, i, j, arrayOfInt, this.mSpanCalcRoundUp, bool);
    arrayOfInt[2] = -1;
    arrayOfInt[3] = -1;
    if ((paramAppWidgetProviderInfo instanceof SurfaceWidgetProviderInfo))
    {
      paramAppWidgetProviderInfo = (SurfaceWidgetProviderInfo)paramAppWidgetProviderInfo;
      i = paramAppWidgetProviderInfo.getMaxResizeWidth();
      j = paramAppWidgetProviderInfo.getMaxResizeHeight();
      int k = i - (paramArrayOfInt.left + paramArrayOfInt.right);
      int m = j - (paramArrayOfInt.top + paramArrayOfInt.bottom);
      paramAppWidgetProviderInfo = getSpanForWidget(k, m, k, m, null, this.mSpanCalcRoundDown, bool);
      if ((i > 0) && (i < Integer.MAX_VALUE)) {
        arrayOfInt[2] = Math.max(arrayOfInt[0], Math.min(this.mCellCountX, paramAppWidgetProviderInfo[0]));
      }
      if ((j > 0) && (j < Integer.MAX_VALUE)) {
        arrayOfInt[3] = Math.max(arrayOfInt[1], Math.min(this.mCellCountY, paramAppWidgetProviderInfo[1]));
      }
    }
    return arrayOfInt;
  }
  
  public int[] getSpanForAppWidget(AppWidgetProviderInfo paramAppWidgetProviderInfo, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    boolean bool = useGEDMode(paramAppWidgetProviderInfo);
    return getSpanForWidget(paramInt1, paramInt2, paramInt1, paramInt2, paramArrayOfInt, this.mSpanCalcRoundUp, bool);
  }
  
  public int[] getSpanForSamsungWidget(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getSpanForWidget(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, this.mSpanCalcRoundUp, false);
  }
  
  public int[] getSpanForSurfaceWidget(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    return getSpanForWidget(paramInt1, paramInt2, paramInt1, paramInt2, paramArrayOfInt, this.mSpanCalcRoundUp, false);
  }
  
  public int[] getSpanForWidget(AppWidgetProviderInfo paramAppWidgetProviderInfo, int[] paramArrayOfInt)
  {
    Padding localPadding = getPaddingForWidget(paramAppWidgetProviderInfo.provider);
    int i = paramAppWidgetProviderInfo.minWidth + localPadding.left + localPadding.right;
    int j = paramAppWidgetProviderInfo.minHeight + localPadding.top + localPadding.bottom;
    boolean bool = useGEDMode(paramAppWidgetProviderInfo);
    paramArrayOfInt = getSpanForWidget(i, j, i, j, paramArrayOfInt, this.mSpanCalcRoundUp, bool);
    i = paramAppWidgetProviderInfo.resizeMode;
    if (i != 0)
    {
      paramAppWidgetProviderInfo = getResizeSpanForWidget(paramAppWidgetProviderInfo, null);
      if ((i & 0x1) == 1)
      {
        paramArrayOfInt[0] = Math.max(paramArrayOfInt[0], paramAppWidgetProviderInfo[0]);
        if (-1 != paramAppWidgetProviderInfo[2]) {
          paramArrayOfInt[0] = Math.min(paramArrayOfInt[0], paramAppWidgetProviderInfo[2]);
        }
      }
      if ((i & 0x2) == 2)
      {
        paramArrayOfInt[1] = Math.max(paramArrayOfInt[1], paramAppWidgetProviderInfo[1]);
        if (-1 != paramAppWidgetProviderInfo[3]) {
          paramArrayOfInt[1] = Math.min(paramArrayOfInt[1], paramAppWidgetProviderInfo[3]);
        }
      }
    }
    return paramArrayOfInt;
  }
  
  public void setLauncherApplication(LauncherApplication paramLauncherApplication)
  {
    this.mResources = paramLauncherApplication.getResources();
    this.mPkgMgr = paramLauncherApplication.getPackageManager();
    this.mPaddingDimens = new Padding(this.mResources.getDimensionPixelSize(2131624268), this.mResources.getDimensionPixelSize(2131624270), this.mResources.getDimensionPixelSize(2131624269), this.mResources.getDimensionPixelSize(2131624271));
    this.mCellCountX = this.mResources.getInteger(2131492897);
    this.mCellCountY = this.mResources.getInteger(2131492898);
    this.mPortCellSizeX = this.mResources.getDimensionPixelSize(2131624146);
    this.mPortCellSizeY = this.mResources.getDimensionPixelSize(2131624147);
    this.mLandCellSizeX = this.mResources.getDimensionPixelSize(2131624142);
    this.mLandCellSizeY = this.mResources.getDimensionPixelSize(2131624143);
    this.mPortCellGapX = this.mResources.getDimensionPixelSize(2131624148);
    this.mPortCellGapY = this.mResources.getDimensionPixelSize(2131624149);
    this.mLandCellGapX = this.mResources.getDimensionPixelSize(2131624144);
    this.mLandCellGapY = this.mResources.getDimensionPixelSize(2131624145);
    this.mDensity = this.mResources.getDisplayMetrics().density;
  }
  
  public void updateWidgetSizeRanges(AppWidgetHostView paramAppWidgetHostView, Launcher paramLauncher, int paramInt1, int paramInt2)
  {
    if ((Launcher.isHelpAppRunning) && ("resize_widgets".equals(GuideFragment.GMode))) {
      Workspace.widgetSizeChanged = true;
    }
    int i = this.mLandCellSizeX;
    int j = this.mLandCellSizeY;
    int m = this.mLandCellGapX;
    int k = this.mLandCellGapY;
    i = (int)((paramInt1 * i + (paramInt1 - 1) * m) / this.mDensity);
    j = (int)((paramInt2 * j + (paramInt2 - 1) * k) / this.mDensity);
    k = this.mPortCellSizeX;
    m = this.mPortCellSizeY;
    int n = this.mPortCellGapX;
    int i1 = this.mPortCellGapY;
    paramAppWidgetHostView.updateAppWidgetSize(null, (int)((paramInt1 * k + (paramInt1 - 1) * n) / this.mDensity), j, i, (int)((paramInt2 * m + (paramInt2 - 1) * i1) / this.mDensity));
  }
  
  public static class Padding
  {
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;
    
    public Padding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.left = paramInt1;
      this.top = paramInt2;
      this.right = paramInt3;
      this.bottom = paramInt4;
    }
  }
  
  private static abstract interface SpanCountCalculator
  {
    public abstract int getSpanCount(int paramInt1, int paramInt2, int paramInt3);
  }
  
  private static class SpanCountCalculatorRoundDown
    implements WorkspaceSpanCalculator.SpanCountCalculator
  {
    public int getSpanCount(int paramInt1, int paramInt2, int paramInt3)
    {
      return Math.max(1, (paramInt1 + paramInt3) / (paramInt2 + paramInt3));
    }
  }
  
  private static class SpanCountCalculatorRoundUp
    implements WorkspaceSpanCalculator.SpanCountCalculator
  {
    public int getSpanCount(int paramInt1, int paramInt2, int paramInt3)
    {
      paramInt2 += paramInt3;
      return Math.max(1, (paramInt1 + paramInt3 + paramInt2 - 1) / paramInt2);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/WorkspaceSpanCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */