package com.android.launcher2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.android.launcher2.guide.AddWidgetsGuider;
import com.android.launcher2.guide.ChangeWallpaperGuider;
import com.android.launcher2.guide.GuideFragment;

public class HomeScreenOptionMenu
  extends LinearLayout
{
  static final int BOTH_WALLPAPER = 2;
  public static final int HOME_OPTION_SETTINGS = 2;
  public static final int HOME_OPTION_THEMES = 3;
  public static final int HOME_OPTION_WALLPAPERS = 0;
  public static final int HOME_OPTION_WIDGETS = 1;
  static final int HOME_SCREEN_WALLPAPER = 0;
  static final int LOCK_SCREEN_WALLPAPER = 1;
  static boolean isWidgetTab = false;
  static boolean mIsActive = false;
  Context c;
  Intent intent_wallpaper;
  private Launcher mLauncher = (Launcher)getContext();
  private View.OnClickListener mOnClickListenerSettings = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      HomeScreenOptionMenu.this.launchOptionSettings();
    }
  };
  private View.OnClickListener mOnClickListenerTheme = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      HomeScreenOptionMenu.this.launchOptionThemes();
    }
  };
  private View.OnClickListener mOnClickListenerWallpaper = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if ((!Launcher.isHelpAppRunning) || (!GuideFragment.GMode.equals("add_widgets"))) {
        HomeScreenOptionMenu.this.launchOptionWallpaper();
      }
    }
  };
  private View.OnClickListener mOnClickListenerWidget = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if ((!Launcher.isHelpAppRunning) || (!GuideFragment.GMode.equals("change_wallpaper"))) {
        HomeScreenOptionMenu.this.launchOptionWidgets();
      }
    }
  };
  private TextView mSetting;
  private HomeScreenOptionSettings mSettingsFragment;
  private TextView mTheme;
  private TextView mWallpaper;
  private TextView mWidget;
  
  public HomeScreenOptionMenu(Context paramContext)
  {
    super(paramContext);
    setup();
    this.c = paramContext;
  }
  
  public HomeScreenOptionMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setup();
    this.c = paramContext;
  }
  
  public HomeScreenOptionMenu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setup();
    this.c = paramContext;
  }
  
  private void setup()
  {
    this.mSettingsFragment = new HomeScreenOptionSettings();
  }
  
  public HomeScreenOptionSettings getHomeScreenOptionSettings()
  {
    return this.mSettingsFragment;
  }
  
  public View getWidgetButton()
  {
    return this.mWidget;
  }
  
  public boolean isActive()
  {
    return mIsActive;
  }
  
  public boolean isSettingVisible()
  {
    if (this.mSettingsFragment == null) {}
    return false;
  }
  
  public void launchOptionSettings()
  {
    if (!Launcher.isHelpAppRunning)
    {
      Intent localIntent = new Intent("sec.android.launcher2.intent.action.HomeScreenOptionSettings");
      this.mLauncher.startActivity(localIntent);
    }
  }
  
  public void launchOptionThemes()
  {
    if (!Launcher.isHelpAppRunning)
    {
      Intent localIntent = new Intent("com.sec.android.intent.action.THEME_CHOOSER");
      this.mLauncher.startActivity(localIntent);
    }
  }
  
  public void launchOptionWallpaper()
  {
    if (LauncherApplication.getInst().isKnoxMode())
    {
      this.mLauncher.getHomeView().startWallpaper(0);
      return;
    }
    ((ChangeWallpaperGuider)new ChangeWallpaperGuider((Activity)getContext())).dismissHelpDialog();
    this.mLauncher.getHomeView().startWallpaper(0);
  }
  
  public void launchOptionWidgets()
  {
    MenuView localMenuView = this.mLauncher.getMenuView();
    if (localMenuView.getMenuWidgets() != null) {
      localMenuView.getMenuWidgets().setDisplayType(MenuWidgets.DisplayType.NORMAL);
    }
    if ((Launcher.isHelpAppRunning) && (GuideFragment.GMode.equals("add_widgets"))) {
      ((AddWidgetsGuider)new AddWidgetsGuider((Activity)getContext())).dismissHelpDialog();
    }
    localMenuView.selectWidgetsTab();
    isWidgetTab = true;
    this.mLauncher.showAllApps();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources();
    int i = paramConfiguration.getDimensionPixelSize(2131624260);
    setPadding(i, 0, i, paramConfiguration.getDimensionPixelSize(2131624262));
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = paramConfiguration.getDimensionPixelSize(2131624259);
    setLayoutParams(localLayoutParams);
    i = paramConfiguration.getDimensionPixelSize(2131624264);
    int j = paramConfiguration.getDimensionPixelSize(2131624063);
    paramConfiguration = (LinearLayout.LayoutParams)this.mWallpaper.getLayoutParams();
    paramConfiguration.setMargins(0, j, i, 0);
    this.mWallpaper.setLayoutParams(paramConfiguration);
    if ((Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) && (!LauncherApplication.getInst().isKnoxMode())) {
      setThemeOptionLayout();
    }
    while (this.mSetting == null) {
      return;
    }
    paramConfiguration = (LinearLayout.LayoutParams)this.mWidget.getLayoutParams();
    paramConfiguration.setMargins(0, j, i, 0);
    this.mWidget.setLayoutParams(paramConfiguration);
  }
  
  protected void onFinishInflate()
  {
    this.mWallpaper = ((TextView)findViewById(2131689560));
    this.mWallpaper.setOnClickListener(this.mOnClickListenerWallpaper);
    this.mWallpaper.setOnKeyListener(FocusHelper.HOME_OPTION_MENU_KEY_LISTENER);
    this.mWidget = ((TextView)findViewById(2131689561));
    this.mWidget.setOnClickListener(this.mOnClickListenerWidget);
    this.mWidget.setOnKeyListener(FocusHelper.HOME_OPTION_MENU_KEY_LISTENER);
    if ((Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) && (!LauncherApplication.getInst().isKnoxMode()))
    {
      this.mTheme = ((TextView)findViewById(2131689563));
      if (this.mTheme != null)
      {
        this.mTheme.setOnClickListener(this.mOnClickListenerTheme);
        this.mTheme.setOnKeyListener(FocusHelper.HOME_OPTION_MENU_KEY_LISTENER);
        this.mTheme.setVisibility(0);
      }
    }
    this.mSetting = ((TextView)findViewById(2131689562));
    if (this.mSetting != null)
    {
      this.mSetting.setOnClickListener(this.mOnClickListenerSettings);
      this.mSetting.setOnKeyListener(FocusHelper.HOME_OPTION_MENU_KEY_LISTENER);
    }
    setOnKeyListener(FocusHelper.HOME_OPTION_MENU_KEY_LISTENER);
    super.onFinishInflate();
    if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) {
      setThemeOptionLayout();
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean) {
      findViewById(2131689560).requestFocus();
    }
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setMakeActive(boolean paramBoolean)
  {
    mIsActive = paramBoolean;
  }
  
  protected void setThemeOptionLayout()
  {
    if ((!Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) || (LauncherApplication.getInst().isKnoxMode())) {}
    int k;
    float f;
    do
    {
      return;
      localObject = getResources();
      int i = ((Resources)localObject).getDimensionPixelSize(2131624076);
      int j = ((Resources)localObject).getDimensionPixelSize(2131624262);
      k = ((Resources)localObject).getDimensionPixelSize(2131624078);
      setPadding(i, 0, i, j);
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.height = ((Resources)localObject).getDimensionPixelSize(2131624259);
      setLayoutParams(localLayoutParams);
      f = ((Resources)localObject).getDisplayMetrics().density;
      f = ((Resources)localObject).getDimension(2131624079) / f;
      if (this.mWallpaper != null)
      {
        localObject = (LinearLayout.LayoutParams)this.mWallpaper.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = k;
        this.mWallpaper.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mWallpaper.setTextSize(1, f);
      }
      if (this.mWidget != null)
      {
        localObject = (LinearLayout.LayoutParams)this.mWidget.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = k;
        this.mWidget.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mWidget.setTextSize(1, f);
      }
      if (this.mSetting != null)
      {
        localObject = (LinearLayout.LayoutParams)this.mSetting.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = k;
        this.mSetting.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mSetting.setTextSize(1, f);
      }
    } while (this.mTheme == null);
    Object localObject = (LinearLayout.LayoutParams)this.mTheme.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = k;
    this.mTheme.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mTheme.setTextSize(1, f);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeScreenOptionMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */