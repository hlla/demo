package com.android.launcher2;

import android.appwidget.AppWidgetProviderInfo;
import android.os.Parcelable;

class HomePendingWidget
  extends HomePendingItem
{
  Parcelable configurationData;
  int[] defSpans = { -1, -1 };
  String mimeType;
  int minWidth;
  int resizeMode;
  int[] resizeSpans = { -1, -1, -1, -1 };
  
  public HomePendingWidget(AppWidgetProviderInfo paramAppWidgetProviderInfo, String paramString, Parcelable paramParcelable)
  {
    super(BaseItem.Type.HOME_WIDGET);
    this.componentName = paramAppWidgetProviderInfo.provider;
    this.mTitle = paramAppWidgetProviderInfo.label;
    this.minWidth = paramAppWidgetProviderInfo.minWidth;
    this.resizeMode = paramAppWidgetProviderInfo.resizeMode;
    if ((paramString != null) && (paramParcelable != null))
    {
      this.mimeType = paramString;
      this.configurationData = paramParcelable;
    }
    paramString = WorkspaceSpanCalculator.INSTANCE;
    this.resizeSpans = paramString.getResizeSpanForWidget(paramAppWidgetProviderInfo, this.resizeSpans);
    this.defSpans = paramString.getSpanForWidget(paramAppWidgetProviderInfo, this.defSpans);
  }
  
  public int[] getDefSpans()
  {
    return this.defSpans;
  }
  
  public int[] getResizeSpans()
  {
    return this.resizeSpans;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomePendingWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */