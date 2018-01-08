package com.android.launcher2;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import com.samsung.surfacewidget.SurfaceWidgetProviderInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

class WidgetSizes
{
  private static final boolean DEBUGGABLE = ;
  static final String EXTRA_WIDGET_RESIZE_SPANX = "widgetspanx";
  static final String EXTRA_WIDGET_RESIZE_SPANY = "widgetspany";
  static final String EXTRA_WIDGET_RESIZE_WIDGETID = "widgetId";
  private static final String TAG = "Launcher.WidgetSizes";
  static final String WIDGET_RESIZE = "com.sec.android.widgetapp.APPWIDGET_RESIZE";
  static final String WIDGET_SUPPORT_INFO = "com.sec.android.appwidget.widgetinfo";
  private Context mContext;
  private int mMaxXSpan = 1;
  private int mMaxYSpan = 1;
  private int mMinXSpan = 1000;
  private int mMinYSpan = 1000;
  private int mResizeMode = 0;
  private WorkspaceSpanCalculator mSpanCalculator;
  private ArrayList<int[]> mValidSizes = new ArrayList();
  public boolean pureGoogle = false;
  
  public WidgetSizes(Context paramContext)
  {
    this.mContext = paramContext;
    this.mSpanCalculator = WorkspaceSpanCalculator.INSTANCE;
  }
  
  private void add(int paramInt1, int paramInt2)
  {
    this.mValidSizes.add(new int[] { paramInt1, paramInt2 });
    this.mMinXSpan = Math.min(this.mMinXSpan, paramInt1);
    this.mMinYSpan = Math.min(this.mMinYSpan, paramInt2);
    this.mMaxXSpan = Math.max(this.mMaxXSpan, paramInt1);
    this.mMaxYSpan = Math.max(this.mMaxYSpan, paramInt2);
    if (this.mMaxXSpan != this.mMinXSpan) {
      this.mResizeMode |= 0x1;
    }
    if (this.mMaxYSpan != this.mMinYSpan) {
      this.mResizeMode |= 0x2;
    }
  }
  
  private void loadAsPureGoogle(AppWidgetProviderInfo paramAppWidgetProviderInfo)
  {
    this.mResizeMode = paramAppWidgetProviderInfo.resizeMode;
    paramAppWidgetProviderInfo = this.mSpanCalculator.getResizeSpanForWidget(paramAppWidgetProviderInfo, null);
    this.mMinXSpan = paramAppWidgetProviderInfo[0];
    this.mMinYSpan = paramAppWidgetProviderInfo[1];
    this.mMaxXSpan = paramAppWidgetProviderInfo[2];
    this.mMaxYSpan = paramAppWidgetProviderInfo[3];
    this.pureGoogle = true;
  }
  
  public int capHeight(int paramInt)
  {
    if (this.pureGoogle)
    {
      int i = paramInt;
      if (-1 != this.mMaxYSpan) {
        i = Math.min(paramInt, this.mMaxYSpan);
      }
      return i;
    }
    return Math.max(Math.min(paramInt, this.mMaxYSpan), this.mMinYSpan);
  }
  
  public int capWidth(int paramInt)
  {
    if (this.pureGoogle)
    {
      int i = paramInt;
      if (-1 != this.mMaxXSpan) {
        i = Math.min(paramInt, this.mMaxXSpan);
      }
      return i;
    }
    return Math.max(Math.min(paramInt, this.mMaxXSpan), this.mMinXSpan);
  }
  
  public int getAvailableSizeCount()
  {
    if (this.mValidSizes == null) {
      return 0;
    }
    return this.mValidSizes.size();
  }
  
  public int getMinXSpan()
  {
    return this.mMinXSpan;
  }
  
  public int getMinYSpan()
  {
    return this.mMinYSpan;
  }
  
  public boolean isAvailableSize(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if ((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (Launcher.isHomeRemoveMode())) {}
    label64:
    int[] arrayOfInt;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return false;
        if (this.pureGoogle)
        {
          if ((-1 == this.mMaxXSpan) || (paramInt1 <= this.mMaxXSpan))
          {
            bool1 = bool2;
            if (-1 != this.mMaxYSpan) {
              if (paramInt2 > this.mMaxYSpan) {
                break label64;
              }
            }
          }
          for (boolean bool1 = bool2;; bool1 = false) {
            return bool1;
          }
        }
        localIterator = this.mValidSizes.iterator();
      }
      arrayOfInt = (int[])localIterator.next();
    } while ((arrayOfInt[0] != paramInt1) || (arrayOfInt[1] != paramInt2));
    return true;
  }
  
  public void load(AppWidgetProviderInfo paramAppWidgetProviderInfo)
  {
    if ((!(paramAppWidgetProviderInfo instanceof SurfaceWidgetProviderInfo)) && (paramAppWidgetProviderInfo.provider != null))
    {
      Object localObject1 = null;
      try
      {
        localObject2 = this.mContext.createPackageContext(paramAppWidgetProviderInfo.provider.getPackageName(), 3);
        localObject1 = localObject2;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject3;
          localNameNotFoundException.printStackTrace();
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((Context)localObject1).getPackageManager();
        localObject3 = new Intent("com.sec.android.widgetapp.APPWIDGET_RESIZE").setComponent(paramAppWidgetProviderInfo.provider);
        if (DEBUGGABLE) {
          Log.d("Launcher.WidgetSizes", "LOAD: info recieved: " + paramAppWidgetProviderInfo.provider);
        }
        localObject3 = this.mContext.getPackageManager().queryBroadcastReceivers((Intent)localObject3, 128).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject3).next();
          if (localResolveInfo.activityInfo.name.equals(paramAppWidgetProviderInfo.provider.getClassName()))
          {
            localObject2 = localResolveInfo.activityInfo.loadXmlMetaData((PackageManager)localObject2, "com.sec.android.appwidget.widgetinfo");
            if (localObject2 != null)
            {
              try
              {
                do
                {
                  i = ((XmlResourceParser)localObject2).next();
                  if (i == 2) {
                    break;
                  }
                } while (i != 1);
              }
              catch (XmlPullParserException localXmlPullParserException)
              {
                for (;;)
                {
                  int i;
                  int j;
                  localXmlPullParserException.printStackTrace();
                }
              }
              catch (IOException localIOException)
              {
                for (;;)
                {
                  localIOException.printStackTrace();
                }
              }
              i = ((XmlResourceParser)localObject2).getAttributeResourceValue(null, "supportCellSizes", 0);
              if (i > 0)
              {
                localObject1 = ((Context)localObject1).getResources().getStringArray(i);
                if (localObject1 != null)
                {
                  localObject2 = new int[2];
                  this.mSpanCalculator.getSpanForWidget(paramAppWidgetProviderInfo, (int[])localObject2);
                  add(localObject2[0], localObject2[1]);
                  j = localObject1.length;
                  i = 0;
                  while (i < j)
                  {
                    paramAppWidgetProviderInfo = localObject1[i];
                    int m = paramAppWidgetProviderInfo.indexOf('x');
                    int k = Integer.parseInt(paramAppWidgetProviderInfo.substring(0, m));
                    m = Integer.parseInt(paramAppWidgetProviderInfo.substring(m + 1));
                    if ((k != localObject2[0]) || (m != localObject2[1])) {
                      add(k, m);
                    }
                    i += 1;
                  }
                }
              }
            }
          }
        }
      }
    }
    if (paramAppWidgetProviderInfo.provider != null) {
      loadAsPureGoogle(paramAppWidgetProviderInfo);
    }
  }
  
  public int resizeMode()
  {
    return this.mResizeMode;
  }
  
  public void setMinSpan(int paramInt1, int paramInt2)
  {
    this.mMinXSpan = paramInt1;
    this.mMinYSpan = paramInt2;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/WidgetSizes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */