package com.sec.dtl.launcher;

import android.app.Application;
import android.content.ContentResolver;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.provider.Settings.Secure;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.android.launcher2.LauncherApplication;
import java.util.List;
import java.util.Locale;

public enum Talk
{
  INSTANCE(LauncherApplication.getInst());
  
  private static final String TAG = "Talk";
  private final AccessibilityManager mAccessibilityMgr;
  private final Application mApplication;
  private boolean mIsTalkbackEnabled = false;
  private final Resources mResources;
  private TextToSpeech mTextToSpeech;
  private String mTextToSpeechEngine;
  
  private Talk(Application paramApplication)
  {
    this.mAccessibilityMgr = ((AccessibilityManager)paramApplication.getSystemService("accessibility"));
    this.mApplication = paramApplication;
    this.mResources = paramApplication.getResources();
  }
  
  private boolean isTouchExplorationEnabled()
  {
    return (this.mAccessibilityMgr != null) && (this.mAccessibilityMgr.isTouchExplorationEnabled());
  }
  
  private void setTextToSpeechLanguage(Locale paramLocale)
  {
    switch (this.mTextToSpeech.setLanguage(paramLocale))
    {
    default: 
      return;
    }
    Log.e("Talk", "Language is not available defaulting to US English");
    switch (this.mTextToSpeech.setLanguage(Locale.US))
    {
    default: 
      return;
    }
    Log.e("Talk", "Could not initialize TextToSpeech US language");
  }
  
  public boolean checkTalkbackEnabled()
  {
    ContentResolver localContentResolver = this.mApplication.getContentResolver();
    boolean bool1 = this.mIsTalkbackEnabled;
    try
    {
      if (Settings.Secure.getInt(localContentResolver, "accessibility_enabled", 0) == 1)
      {
        boolean bool2 = Settings.Secure.getString(localContentResolver, "enabled_accessibility_services").matches("(?i).*talkback.*");
        if (bool2) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return bool1;
  }
  
  public TextToSpeech getTextToSpeech()
  {
    if (isTalkbackSuspend()) {
      return null;
    }
    return this.mTextToSpeech;
  }
  
  public boolean isTalkbackEnabled()
  {
    return (this.mAccessibilityMgr != null) && (this.mIsTalkbackEnabled);
  }
  
  public boolean isTalkbackSuspend()
  {
    if (this.mAccessibilityMgr != null)
    {
      List localList = this.mAccessibilityMgr.getEnabledAccessibilityServiceList(1);
      if ((localList != null) && (localList.isEmpty())) {
        return true;
      }
    }
    return false;
  }
  
  public void onResume()
  {
    this.mApplication.getContentResolver();
    int i = 0;
    if (checkTalkbackEnabled()) {
      i = 1;
    }
    if (i != 0)
    {
      if ((this.mTextToSpeech != null) && (!this.mTextToSpeech.getDefaultEngine().equals(this.mTextToSpeechEngine))) {
        shutdown();
      }
      if (this.mTextToSpeech == null)
      {
        this.mTextToSpeech = new TextToSpeech(this.mApplication, new TextToSpeech.OnInitListener()
        {
          public void onInit(int paramAnonymousInt)
          {
            if (Talk.this.mTextToSpeech != null)
            {
              if (paramAnonymousInt == 0) {
                Talk.this.setTextToSpeechLanguage(Talk.this.mResources.getConfiguration().locale);
              }
            }
            else {
              return;
            }
            Log.e("Talk", "Could not initialize TextToSpeech");
          }
        });
        this.mTextToSpeechEngine = this.mTextToSpeech.getDefaultEngine();
        this.mIsTalkbackEnabled = true;
      }
      return;
    }
    shutdown();
  }
  
  public void say(int paramInt)
  {
    if ((this.mTextToSpeech != null) && (isTouchExplorationEnabled())) {
      say(this.mResources.getString(paramInt));
    }
  }
  
  public void say(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mTextToSpeech != null) && (isTouchExplorationEnabled())) {
      say(String.format(this.mResources.getString(paramInt1), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
  }
  
  public void say(String paramString)
  {
    if ((getTextToSpeech() != null) && (isTouchExplorationEnabled()))
    {
      if (paramString == null) {
        throw new IllegalArgumentException("Must provide a valid string to speak");
      }
      setTextToSpeechLanguage(this.mTextToSpeech.getLanguage());
      this.mTextToSpeech.speak(paramString, 0, null);
    }
  }
  
  public void sayByTalkback(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((!isTalkbackEnabled()) || ((paramBoolean) && (!isTouchExplorationEnabled()))) {}
    AccessibilityEvent localAccessibilityEvent;
    do
    {
      return;
      localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
      localAccessibilityEvent.setClassName(this.mApplication.getClass().getName());
      localAccessibilityEvent.setPackageName(this.mApplication.getPackageName());
      localAccessibilityEvent.setEnabled(true);
      localAccessibilityEvent.setBeforeText("");
      localAccessibilityEvent.getText().add(paramString);
    } while ((this.mAccessibilityMgr == null) || (!this.mAccessibilityMgr.isEnabled()));
    this.mAccessibilityMgr.sendAccessibilityEvent(localAccessibilityEvent);
  }
  
  public void sayByTalkback(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    sayByTalkback(paramView, String.format(this.mResources.getString(paramInt1), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }), paramBoolean);
  }
  
  public void sayByTalkback(View paramView, String paramString, boolean paramBoolean)
  {
    if ((!isTalkbackEnabled()) || ((paramBoolean) && (!isTouchExplorationEnabled()))) {
      return;
    }
    paramView.announceForAccessibility(paramString);
  }
  
  public void shutdown()
  {
    if (this.mTextToSpeech != null)
    {
      this.mTextToSpeech.shutdown();
      this.mTextToSpeech = null;
      this.mTextToSpeechEngine = null;
    }
    this.mIsTalkbackEnabled = false;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/sec/dtl/launcher/Talk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */