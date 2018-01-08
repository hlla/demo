package com.android.launcher2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.VideoView;
import java.util.ArrayList;

public class HomeScreenOptionTransition
  extends Activity
  implements AdapterView.OnItemClickListener
{
  ArrayAdapter<String> mAdapter;
  ArrayList<String> mItems;
  ListView mListView;
  Uri mTransitionEffectPreviewEffect1 = Uri.parse("android.resource://com.sec.android.app.launcher/2131230720");
  Uri mTransitionEffectPreviewEffect2 = Uri.parse("android.resource://com.sec.android.app.launcher/2131230722");
  Uri mTransitionEffectPreviewNone = Uri.parse("android.resource://com.sec.android.app.launcher/2131230721");
  VideoView mVideoView;
  
  private void playVideo()
  {
    this.mVideoView.setFocusable(false);
    this.mVideoView.setFocusableInTouchMode(false);
    if (this.mVideoView != null) {
      this.mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
      {
        public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
        {
          HomeScreenOptionTransition.this.mVideoView.postDelayed(new Runnable()
          {
            public void run()
            {
              HomeScreenOptionTransition.this.mVideoView.setBackground(null);
            }
          }, 10L);
          HomeScreenOptionTransition.this.mVideoView.start();
        }
      });
    }
  }
  
  public void onBackPressed()
  {
    setResult(this.mListView.getCheckedItemPosition());
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    setContentView(2130903078);
    paramConfiguration = getActionBar();
    if (paramConfiguration != null)
    {
      paramConfiguration.setTitle(getResources().getString(2131755085));
      paramConfiguration.setDisplayHomeAsUpEnabled(true);
    }
    paramConfiguration = getResources();
    this.mListView = ((ListView)findViewById(2131689565));
    this.mVideoView = ((VideoView)findViewById(2131689564));
    this.mVideoView.setStopMusic(false);
    this.mVideoView.setBackgroundResource(2130837835);
    this.mItems = new ArrayList();
    this.mItems.add(paramConfiguration.getText(2131755086).toString());
    this.mItems.add(paramConfiguration.getText(2131755087).toString());
    this.mItems.add(paramConfiguration.getText(2131755088).toString());
    this.mAdapter = new ArrayAdapter(this, 2130903084, this.mItems);
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setChoiceMode(1);
    this.mListView.setItemChecked(Launcher.sWhichTransitionEffect, true);
    this.mListView.setOnItemClickListener(this);
    switch (Launcher.sWhichTransitionEffect)
    {
    }
    for (;;)
    {
      playVideo();
      return;
      this.mVideoView.setVideoURI(this.mTransitionEffectPreviewNone);
      continue;
      this.mVideoView.setVideoURI(this.mTransitionEffectPreviewEffect1);
      continue;
      this.mVideoView.setVideoURI(this.mTransitionEffectPreviewEffect2);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getResources().getConfiguration().smallestScreenWidthDp >= 600)
    {
      setRequestedOrientation(-1);
      setContentView(2130903078);
      paramBundle = getActionBar();
      if (paramBundle != null)
      {
        paramBundle.setTitle(getResources().getString(2131755085));
        paramBundle.setDisplayHomeAsUpEnabled(true);
      }
      paramBundle = getResources();
      this.mListView = ((ListView)findViewById(2131689565));
      this.mVideoView = ((VideoView)findViewById(2131689564));
      this.mVideoView.setStopMusic(false);
      this.mVideoView.setBackgroundResource(2130837835);
      this.mItems = new ArrayList();
      this.mItems.add(paramBundle.getText(2131755086).toString());
      this.mItems.add(paramBundle.getText(2131755087).toString());
      this.mItems.add(paramBundle.getText(2131755088).toString());
      this.mAdapter = new ArrayAdapter(this, 2130903084, this.mItems);
      this.mListView.setAdapter(this.mAdapter);
      this.mListView.setChoiceMode(1);
      this.mListView.setItemChecked(Launcher.sWhichTransitionEffect, true);
      this.mListView.setOnItemClickListener(this);
      switch (Launcher.sWhichTransitionEffect)
      {
      }
    }
    for (;;)
    {
      playVideo();
      return;
      setRequestedOrientation(1);
      break;
      this.mVideoView.setVideoURI(this.mTransitionEffectPreviewNone);
      continue;
      this.mVideoView.setVideoURI(this.mTransitionEffectPreviewEffect1);
      continue;
      this.mVideoView.setVideoURI(this.mTransitionEffectPreviewEffect2);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      playVideo();
      setTransitionEffect(paramInt);
      return;
      this.mVideoView.setVideoURI(this.mTransitionEffectPreviewNone);
      continue;
      this.mVideoView.setVideoURI(this.mTransitionEffectPreviewEffect1);
      continue;
      this.mVideoView.setVideoURI(this.mTransitionEffectPreviewEffect2);
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
  
  protected void onPause()
  {
    super.onPause();
    try
    {
      if (this.mVideoView != null) {
        this.mVideoView.pause();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      if (this.mVideoView != null) {
        this.mVideoView.start();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setTransitionEffect(int paramInt)
  {
    if (paramInt == Launcher.sWhichTransitionEffect) {}
    Object localObject;
    do
    {
      return;
      localObject = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
      ((SharedPreferences.Editor)localObject).putString("pref_list_transition_effect", Integer.valueOf(paramInt).toString());
      ((SharedPreferences.Editor)localObject).commit();
      localObject = Launcher.getInstance();
    } while (localObject == null);
    ((Launcher)localObject).setWhichTransitionEffect(paramInt);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeScreenOptionTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */