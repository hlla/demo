package com.android.launcher2;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

class SamsungWidgetItem
  extends HomeItem
{
  private static final boolean DEBUGGABLE = ;
  static final String EXTRA_SAMSUNGWIDGET_ID = "exta_samsung_widget_id";
  public static final String SAMSUNG_WIDGET_THEMENAME = "com.samsung.sec.android.SAMSUNG_WIDGET.themename";
  private static final String TAG = "SamsungWidgetItem";
  static final int WIDGET_STATE_NONE = 0;
  static final int WIDGET_STATE_PAUSED = 2;
  static final int WIDGET_STATE_RESUMED = 1;
  Intent intent;
  SamsungWidgetProviderInfo mItem;
  SamsungWidgetView mWidgetView = null;
  int state = 0;
  long widgetId = -1L;
  
  public SamsungWidgetItem()
  {
    super(BaseItem.Type.HOME_SAMSUNG_WIDGET);
  }
  
  static SamsungWidgetItem makeSamsungWidget(Context paramContext, SamsungWidgetProviderInfo paramSamsungWidgetProviderInfo, long paramLong)
  {
    return makeSamsungWidget(paramContext, paramSamsungWidgetProviderInfo, paramLong, null);
  }
  
  static SamsungWidgetItem makeSamsungWidget(Context paramContext, SamsungWidgetProviderInfo paramSamsungWidgetProviderInfo, long paramLong, SamsungWidgetItem paramSamsungWidgetItem)
  {
    if (DEBUGGABLE) {
      Log.d("SamsungWidgetItem", "makeSamsungWidget()  item: " + paramSamsungWidgetProviderInfo + "  widgtInfo: " + paramSamsungWidgetItem + "  widgetId: " + paramLong);
    }
    Object localObject7;
    if (paramSamsungWidgetItem == null)
    {
      localObject7 = new SamsungWidgetItem();
      ((SamsungWidgetItem)localObject7).widgetId = paramLong;
    }
    for (;;)
    {
      Object localObject1 = null;
      int m = 0;
      k = 0;
      j = 0;
      Object localObject5 = localObject1;
      int i = m;
      if ((paramContext instanceof ActivityGroup))
      {
        localObject5 = localObject1;
        i = m;
        if (paramSamsungWidgetProviderInfo.mPackageName != null)
        {
          localObject5 = localObject1;
          i = m;
          if (paramSamsungWidgetProviderInfo.mClassName != null)
          {
            localObject5 = ((ActivityGroup)paramContext).getLocalActivityManager();
            localObject1 = null;
          }
        }
      }
      try
      {
        localObject3 = paramContext.createPackageContext(paramSamsungWidgetProviderInfo.mPackageName, 3);
        localObject1 = localObject3;
        label154:
        i = j;
        if (localObject1 != null)
        {
          i = j;
          j = k;
        }
      }
      catch (PackageManager.NameNotFoundException localException1)
      {
        try
        {
          if ((paramContext instanceof Launcher))
          {
            j = k;
            k = paramContext.getResources().getConfiguration().orientation;
            j = k;
            localObject3 = ((Context)localObject1).getResources().getConfiguration();
            i = k;
            j = k;
            if (((Configuration)localObject3).orientation != k)
            {
              j = k;
              if (DEBUGGABLE)
              {
                j = k;
                Log.d("SamsungWidgetItem", "Widget: " + paramSamsungWidgetProviderInfo.mPackageName + " orientation " + ((Configuration)localObject3).orientation + " --> " + k);
              }
              j = k;
              ((Configuration)localObject3).orientation = k;
              j = k;
              ((Context)localObject1).getResources().updateConfiguration((Configuration)localObject3, ((Context)localObject1).getResources().getDisplayMetrics());
              i = k;
            }
          }
          label328:
          localObject1 = new Intent();
          ((Intent)localObject1).setClassName(paramSamsungWidgetProviderInfo.mPackageName, paramSamsungWidgetProviderInfo.mClassName);
          ((Intent)localObject1).putExtra("com.samsung.sec.android.SAMSUNG_WIDGET.themename", paramSamsungWidgetProviderInfo.mThemeName);
          ((Intent)localObject1).putExtra("exta_samsung_widget_id", (int)((SamsungWidgetItem)localObject7).widgetId);
          localObject3 = null;
          k = 0;
          j = k;
          if ((paramContext instanceof Launcher)) {}
          try
          {
            boolean bool = ((Launcher)paramContext).getHomeView().getWorkspace().getWidgetRotateSkipList().contains(paramSamsungWidgetProviderInfo.getComponentName());
            j = k;
            if (bool) {
              j = 1;
            }
          }
          catch (NullPointerException localNullPointerException)
          {
            for (;;)
            {
              Activity localActivity;
              View localView;
              Object localObject2;
              Object localObject4;
              Object localObject6;
              j = k;
            }
          }
          localActivity = ((LocalActivityManager)localObject5).getActivity(Long.toString(((SamsungWidgetItem)localObject7).widgetId));
          if (j != 0) {
            if (localActivity != null) {}
          }
        }
        catch (Exception localException1)
        {
          try
          {
            Object localObject3;
            localObject1 = ((LocalActivityManager)localObject5).startActivity(Long.toString(((SamsungWidgetItem)localObject7).widgetId), (Intent)localObject1);
            for (;;)
            {
              if (localObject1 == null) {
                break label778;
              }
              localView = ((Window)localObject1).findViewById(16908290);
              if (localView == null) {
                break label784;
              }
              localObject3 = ((ViewGroup)localView).getChildAt(0);
              if (localObject3 == null) {
                break label790;
              }
              ((ViewGroup)localView).removeView((View)localObject3);
              localObject5 = localObject3;
              if (localObject1 != null) {
                break label919;
              }
              Log.e("SamsungWidgetItem", "w is null");
              ((SamsungWidgetItem)localObject7).setIntent(paramSamsungWidgetProviderInfo.mPackageName, paramSamsungWidgetProviderInfo.mClassName, paramSamsungWidgetProviderInfo.mThemeName);
              paramContext = new SamsungWidgetView(paramContext);
              localObject1 = new FrameLayout.LayoutParams(paramSamsungWidgetProviderInfo.getWidth(i), paramSamsungWidgetProviderInfo.getHeight(i));
              ((FrameLayout.LayoutParams)localObject1).gravity = 17;
              if (localObject5 == null) {
                break label953;
              }
              paramContext.addView((View)localObject5, (ViewGroup.LayoutParams)localObject1);
              ((SamsungWidgetItem)localObject7).mWidgetView = paramContext;
              ((SamsungWidgetItem)localObject7).mItem = paramSamsungWidgetProviderInfo;
              return (SamsungWidgetItem)localObject7;
              localObject1 = paramSamsungWidgetItem;
              localObject7 = localObject1;
              if (((SamsungWidgetItem)localObject1).widgetId != -1L) {
                break;
              }
              ((SamsungWidgetItem)localObject1).widgetId = paramLong;
              localObject7 = localObject1;
              break;
              localNameNotFoundException = localNameNotFoundException;
              localNameNotFoundException.printStackTrace();
              break label154;
              localException1 = localException1;
              localException1.printStackTrace();
              i = j;
              break label328;
              localObject2 = localActivity.getWindow();
              continue;
              if (localActivity != null) {
                ((LocalActivityManager)localObject5).destroyActivity(Long.toString(((SamsungWidgetItem)localObject7).widgetId), true);
              }
              localObject2 = ((LocalActivityManager)localObject5).startActivity(Long.toString(((SamsungWidgetItem)localObject7).widgetId), (Intent)localObject2);
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localObject2 = localNameNotFoundException;
              if (DEBUGGABLE)
              {
                Log.e("SamsungWidgetItem", "failed startActivity(" + localException2 + ")");
                localException2.printStackTrace();
                localObject2 = localNameNotFoundException;
                continue;
                label778:
                localView = null;
                continue;
                label784:
                localObject4 = null;
                continue;
                label790:
                localObject6 = localObject4;
                if (j != 0) {
                  if (localActivity != null)
                  {
                    localActivity.onConfigurationChanged(paramContext.getResources().getConfiguration());
                    if (localView != null) {}
                    for (localObject6 = ((ViewGroup)localView).getChildAt(0);; localObject6 = null)
                    {
                      if (localObject6 == null) {
                        break label856;
                      }
                      ((ViewGroup)localView).removeView((View)localObject6);
                      break;
                    }
                    label856:
                    Log.e("SamsungWidgetItem", "[makeSamsungWidget] failed get widget view(" + localView + ", " + localObject6 + ")");
                  }
                  else
                  {
                    Log.e("SamsungWidgetItem", "[makeSamsungWidget] activity is still null.");
                    localObject6 = localObject4;
                    continue;
                    label919:
                    if (localView == null)
                    {
                      Log.e("SamsungWidgetItem", "mainView is null");
                    }
                    else if (localObject6 == null)
                    {
                      Log.e("SamsungWidgetItem", "contentView is null");
                      continue;
                      label953:
                      if (DEBUGGABLE) {
                        Log.e("SamsungWidgetItem", "Adding widget error view for widget  item: " + paramSamsungWidgetProviderInfo + "  widgtInfo: " + paramSamsungWidgetItem + "  widgetId: " + paramLong);
                      }
                      paramContext.addView(paramContext.getErrorView(), (ViewGroup.LayoutParams)localObject2);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void fireOnPause(Context paramContext)
  {
    if (this.state != 1) {
      break label8;
    }
    for (;;)
    {
      label8:
      return;
      if ((paramContext != null) && ((paramContext instanceof ActivityGroup)) && (this.widgetId != -1L))
      {
        Activity localActivity = ((ActivityGroup)paramContext).getLocalActivityManager().getActivity(Long.toString(this.widgetId));
        if (localActivity == null) {
          break;
        }
        Class[] arrayOfClass = localActivity.getClass().getInterfaces();
        paramContext = null;
        int i = 0;
        while (i < arrayOfClass.length)
        {
          if (arrayOfClass[i].toString().equals("IWidgetObserver")) {
            paramContext = arrayOfClass[i];
          }
          i += 1;
        }
        if (paramContext == null) {
          break;
        }
        try
        {
          paramContext = paramContext.getMethod("fireOnPause", new Class[0]);
          if (paramContext != null)
          {
            this.state = 2;
            paramContext.invoke(localActivity, new Object[0]);
            return;
          }
        }
        catch (SecurityException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (NoSuchMethodException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (IllegalArgumentException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (IllegalAccessException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (InvocationTargetException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public void fireOnResume(Context paramContext)
  {
    if (this.state == 1) {
      break label8;
    }
    for (;;)
    {
      label8:
      return;
      if ((paramContext != null) && ((paramContext instanceof ActivityGroup)) && (this.widgetId != -1L))
      {
        Activity localActivity = ((ActivityGroup)paramContext).getLocalActivityManager().getActivity(Long.toString(this.widgetId));
        if (localActivity == null) {
          break;
        }
        Class[] arrayOfClass = localActivity.getClass().getInterfaces();
        paramContext = null;
        int i = 0;
        while (i < arrayOfClass.length)
        {
          if (arrayOfClass[i].toString().equals("IWidgetObserver")) {
            paramContext = arrayOfClass[i];
          }
          i += 1;
        }
        if (paramContext == null) {
          break;
        }
        try
        {
          paramContext = paramContext.getMethod("fireOnResume", new Class[0]);
          if (paramContext != null)
          {
            paramContext.invoke(localActivity, new Object[0]);
            this.state = 1;
            return;
          }
        }
        catch (SecurityException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (NoSuchMethodException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (IllegalArgumentException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (IllegalAccessException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (InvocationTargetException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public ComponentName getComponentName()
  {
    ComponentName localComponentName = null;
    if (this.mItem != null) {
      localComponentName = this.mItem.getComponentName();
    }
    return localComponentName;
  }
  
  public String getPackageName()
  {
    String str = null;
    if (this.mItem != null) {
      str = this.mItem.mPackageName;
    }
    return str;
  }
  
  void onAddToDatabase(ContentValues paramContentValues)
  {
    super.onAddToDatabase(paramContentValues);
    if (this.intent != null) {}
    for (String str = this.intent.toUri(0);; str = null)
    {
      paramContentValues.put("intent", str);
      paramContentValues.put("appWidgetId", Long.valueOf(this.widgetId));
      return;
    }
  }
  
  final void setIntent(String paramString1, String paramString2, String paramString3)
  {
    this.intent = new Intent();
    this.intent.setClassName(paramString1, paramString2);
    this.intent.putExtra("com.samsung.sec.android.SAMSUNG_WIDGET.themename", paramString3);
  }
  
  public String toString()
  {
    return Long.toString(this.widgetId);
  }
  
  public void unbind()
  {
    super.unbind();
    this.mWidgetView = null;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/SamsungWidgetItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */