package com.android.launcher2;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentValues;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

class HomeWidgetItem
  extends HomeItem
{
  public int appWidgetId;
  AppWidgetHostView hostView = null;
  public final ComponentName mComponentName;
  private WidgetSizes mSupportWidgetSizes = null;
  public int resizeMode;
  public int[] resizeSpans = { -1, -1, -1, -1 };
  
  HomeWidgetItem(AppWidgetProviderInfo paramAppWidgetProviderInfo, int paramInt)
  {
    this(paramAppWidgetProviderInfo, paramInt, true);
  }
  
  HomeWidgetItem(AppWidgetProviderInfo paramAppWidgetProviderInfo, int paramInt, boolean paramBoolean)
  {
    super(BaseItem.Type.HOME_WIDGET);
    this.appWidgetId = paramInt;
    this.mComponentName = paramAppWidgetProviderInfo.provider;
    this.resizeMode = paramAppWidgetProviderInfo.resizeMode;
    if (paramBoolean) {
      calcResizeSpan(paramAppWidgetProviderInfo);
    }
  }
  
  @Deprecated
  HomeWidgetItem(ComponentName paramComponentName, int paramInt)
  {
    super(BaseItem.Type.HOME_WIDGET);
    this.appWidgetId = paramInt;
    this.mComponentName = paramComponentName;
    this.resizeMode = 0;
  }
  
  public void calcResizeSpan(AppWidgetProviderInfo paramAppWidgetProviderInfo)
  {
    this.resizeSpans = WorkspaceSpanCalculator.INSTANCE.getResizeSpanForWidget(paramAppWidgetProviderInfo, this.resizeSpans);
  }
  
  public ComponentName getComponentName()
  {
    return this.mComponentName;
  }
  
  public View getHostView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    AppWidgetHostView localAppWidgetHostView;
    if (this.hostView != null) {
      localAppWidgetHostView = this.hostView;
    }
    do
    {
      return localAppWidgetHostView;
      localAppWidgetHostView = null;
    } while (paramLayoutInflater == null);
    return paramLayoutInflater.inflate(2130903044, paramViewGroup, false);
  }
  
  public String getPackageName()
  {
    String str = null;
    if (this.mComponentName != null) {
      str = this.mComponentName.getPackageName();
    }
    return str;
  }
  
  public int[] getResizeSpans()
  {
    return this.resizeSpans;
  }
  
  public WidgetSizes getSupportWidgetSizes()
  {
    return this.mSupportWidgetSizes;
  }
  
  void onAddToDatabase(ContentValues paramContentValues)
  {
    super.onAddToDatabase(paramContentValues);
    paramContentValues.put("appWidgetId", Integer.valueOf(this.appWidgetId));
  }
  
  public String toString()
  {
    return "AppWidget(id=" + Integer.toString(this.appWidgetId) + ")";
  }
  
  public void unbind()
  {
    super.unbind();
    this.hostView = null;
  }
  
  public void updateSupportWidgetSize()
  {
    if (this.mSupportWidgetSizes != null) {}
    do
    {
      return;
      this.mSupportWidgetSizes = new WidgetSizes(LauncherApplication.getInst().getApplicationContext());
    } while ((this.hostView == null) || (this.hostView.getAppWidgetInfo() == null));
    this.mSupportWidgetSizes.load(this.hostView.getAppWidgetInfo());
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeWidgetItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */