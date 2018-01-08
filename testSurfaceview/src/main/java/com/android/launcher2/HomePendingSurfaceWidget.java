package com.android.launcher2;

import android.content.ComponentName;
import com.samsung.surfacewidget.SurfaceWidgetProviderInfo;

class HomePendingSurfaceWidget
  extends HomePendingItem
{
  int[] defSpans = { -1, -1 };
  SurfaceWidgetProviderInfo mInfo;
  int[] resizeSpans = { -1, -1, -1, -1 };
  
  public HomePendingSurfaceWidget(SurfaceWidgetProviderInfo paramSurfaceWidgetProviderInfo)
  {
    super(BaseItem.Type.HOME_SURFACE_WIDGET);
    this.mInfo = paramSurfaceWidgetProviderInfo;
    this.componentName = paramSurfaceWidgetProviderInfo.getComponentName();
    this.mTitle = paramSurfaceWidgetProviderInfo.label;
    calcSpans();
  }
  
  private void calcSpans()
  {
    WorkspaceSpanCalculator localWorkspaceSpanCalculator = WorkspaceSpanCalculator.INSTANCE;
    this.resizeSpans = localWorkspaceSpanCalculator.getResizeSpanForWidget(this.mInfo, this.resizeSpans);
    this.defSpans = localWorkspaceSpanCalculator.getSpanForWidget(this.mInfo, this.defSpans);
  }
  
  public ComponentName getComponentName()
  {
    return this.mInfo.getComponentName();
  }
  
  public int[] getDefSpans()
  {
    return this.defSpans;
  }
  
  public String getPackageName()
  {
    return this.mInfo.getComponentName().getPackageName();
  }
  
  public int[] getResizeSpans()
  {
    return this.resizeSpans;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomePendingSurfaceWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */