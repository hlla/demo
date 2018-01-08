package com.android.launcher2;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

public class HomeScreenOptionSettings
  extends PreferenceActivity
{
  public static final String KEY_MY_MAGAZINE = "pref_my_magazine";
  public static final String KEY_TRANSITION_EFFECT_CHECKBOX = "pref_transition_effect";
  public static final String KEY_TRANSITION_EFFECT_LIST = "pref_list_transition_effect";
  public static final int RESULT_TRANSITION_EFFECT1 = 1;
  public static final int RESULT_TRANSITION_EFFECT2 = 2;
  public static final int RESULT_TRANSITION_NONE = 0;
  public static String TAG = "HomeScreenSettings";
  CheckBoxPreference magazineEnabled;
  PreferenceScreen ps;
  CheckBoxPreference transitionEffect_checkBox;
  Preference transitionEffect_setting;
  
  private void setEnableHMagazine(boolean paramBoolean)
  {
    Launcher.sIsMagazineHomeEnable = paramBoolean;
  }
  
  private void setEnableMagazine(boolean paramBoolean)
  {
    Launcher localLauncher = Launcher.getInstance();
    if (localLauncher != null) {
      localLauncher.setEnableHeadlines(paramBoolean);
    }
  }
  
  private void setEnableTransitionEffect(int paramInt)
  {
    Object localObject = Launcher.getInstance();
    if (localObject != null) {
      ((Launcher)localObject).setWhichTransitionEffect(paramInt);
    }
    if (this.transitionEffect_setting != null)
    {
      localObject = this.transitionEffect_setting.getSharedPreferences().edit();
      ((SharedPreferences.Editor)localObject).putString("pref_list_transition_effect", Integer.valueOf(paramInt).toString());
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  private void setSummaryTransitionList(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      this.transitionEffect_setting.setSummary(paramInt);
      return;
      paramInt = 2131755086;
      continue;
      paramInt = 2131755087;
      continue;
      paramInt = 2131755088;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d(TAG, "onAcitivityResult()");
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2)) {
      setSummaryTransitionList(paramInt2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getResources().getConfiguration().smallestScreenWidthDp >= 600) {
      setRequestedOrientation(-1);
    }
    for (;;)
    {
      addPreferencesFromResource(2130903077);
      paramBundle = getActionBar();
      if (paramBundle != null)
      {
        paramBundle.setTitle(getResources().getString(2131755084));
        paramBundle.setDisplayHomeAsUpEnabled(true);
      }
      this.ps = ((PreferenceScreen)findPreference("home_screen_settings"));
      this.magazineEnabled = ((CheckBoxPreference)findPreference("pref_my_magazine"));
      this.transitionEffect_checkBox = ((CheckBoxPreference)findPreference("pref_transition_effect"));
      this.transitionEffect_setting = findPreference("pref_list_transition_effect");
      try
      {
        getPackageManager().getPackageInfo("flipboard.boxer.app", 1);
        i = 1;
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          int i = 0;
        }
      }
      if (i == 0)
      {
        this.magazineEnabled.setTitle(getResources().getString(2131755089));
        this.magazineEnabled.setSummary(getResources().getString(2131755090));
      }
      if (this.transitionEffect_setting != null)
      {
        paramBundle = this.transitionEffect_setting.getSharedPreferences();
        if (paramBundle != null) {
          setSummaryTransitionList(Integer.valueOf(paramBundle.getString("pref_list_transition_effect", "1")).intValue());
        }
      }
      if (this.ps != null) {
        this.ps.removePreference(this.transitionEffect_checkBox);
      }
      if ((!LauncherApplication.isOwner()) || (LauncherApplication.getInst().isKnoxMode()) || (LauncherApplication.isTabletLayout()) || ("ALTIUS".equals("HERA")))
      {
        this.magazineEnabled.setChecked(false);
        this.magazineEnabled.setEnabled(false);
        this.ps.removePreference(this.magazineEnabled);
      }
      return;
      setRequestedOrientation(1);
    }
  }
  
  public void onDestroy()
  {
    if (Launcher.getInstance() != null)
    {
      AnimationLayer localAnimationLayer = Launcher.getInstance().getAnimationLayer();
      if (localAnimationLayer != null) {
        localAnimationLayer.setLayoutParams((FrameLayout.LayoutParams)localAnimationLayer.getLayoutParams());
      }
    }
    if ((this.magazineEnabled.isChecked()) && (LauncherApplication.isOwner()) && (!LauncherApplication.getInst().isKnoxMode())) {
      setEnableMagazine(true);
    }
    for (;;)
    {
      super.onDestroy();
      return;
      if (!this.magazineEnabled.isChecked()) {
        setEnableMagazine(false);
      }
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    onBackPressed();
    return true;
  }
  
  public boolean onPreferenceTreeClick(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    if (paramPreference == this.magazineEnabled) {
      if ((this.magazineEnabled.isChecked()) && (LauncherApplication.isOwner()) && (!LauncherApplication.getInst().isKnoxMode())) {
        if (LauncherApplication.sMagazineLauncher) {
          setEnableHMagazine(true);
        }
      }
    }
    for (;;)
    {
      return super.onPreferenceTreeClick(paramPreferenceScreen, paramPreference);
      setEnableMagazine(true);
      continue;
      if (!this.magazineEnabled.isChecked()) {
        if (LauncherApplication.sMagazineLauncher)
        {
          setEnableHMagazine(false);
        }
        else
        {
          setEnableMagazine(false);
          continue;
          if (paramPreference == this.transitionEffect_checkBox)
          {
            if (this.transitionEffect_checkBox.isChecked()) {
              setEnableTransitionEffect(1);
            } else {
              setEnableTransitionEffect(0);
            }
          }
          else if (paramPreference == this.transitionEffect_setting) {
            startActivityForResult(new Intent(this, HomeScreenOptionTransition.class), 1);
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeScreenOptionSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */