package com.google.android.hotword.client;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowId;
import android.view.WindowId.FocusObserver;
import com.google.android.hotword.service.IHotwordService;
import com.google.android.hotword.service.IHotwordService.Stub;

@TargetApi(19)
public class HotwordServiceClient
{
  private static final boolean DBG = false;
  private static final String HOTWORD_SERVICE = "com.google.android.googlequicksearchbox.HOTWORD_SERVICE";
  private static final String TAG = "HotwordServiceClient";
  private static final String VEL_PACKAGE = "com.google.android.googlequicksearchbox";
  private final Activity mActivity;
  private final ServiceConnection mConnection;
  private final WindowId.FocusObserver mFocusObserver;
  private IHotwordService mHotwordService;
  private boolean mHotwordStart;
  private boolean mIsAvailable = true;
  private boolean mIsBound;
  private boolean mIsFocused = false;
  private boolean mIsRequested = true;
  
  public HotwordServiceClient(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mConnection = new HotwordServiceConnection(null);
    this.mFocusObserver = new WindowFocusObserver(null);
  }
  
  private void assertMainThread()
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
      throw new IllegalStateException("Must be called on the main thread.");
    }
  }
  
  private void internalBind()
  {
    if ((!this.mIsAvailable) || (this.mIsBound)) {}
    do
    {
      return;
      Intent localIntent = new Intent("com.google.android.googlequicksearchbox.HOTWORD_SERVICE").setPackage("com.google.android.googlequicksearchbox");
      this.mIsAvailable = this.mActivity.bindService(localIntent, this.mConnection, 1);
      this.mIsBound = this.mIsAvailable;
    } while (this.mIsAvailable);
    Log.w("HotwordServiceClient", "Hotword service is not available.");
  }
  
  private void internalRequestHotword()
  {
    boolean bool;
    if ((this.mIsFocused) && (this.mIsRequested))
    {
      bool = true;
      if (this.mHotwordStart != bool) {
        break label30;
      }
    }
    label30:
    do
    {
      return;
      bool = false;
      break;
      try
      {
        this.mHotwordStart = bool;
        if (!this.mIsBound)
        {
          internalBind();
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("HotwordServiceClient", "requestHotwordDetection - remote call failed", localRemoteException);
        return;
      }
    } while (this.mHotwordService == null);
    this.mHotwordService.requestHotwordDetection(this.mActivity.getPackageName(), bool);
  }
  
  private boolean isPreKitKatDevice()
  {
    if (Build.VERSION.SDK_INT < 19)
    {
      Log.w("HotwordServiceClient", "Hotword service isn't usable on pre-Kitkat devices");
      return true;
    }
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    if (isPreKitKatDevice()) {
      return;
    }
    assertMainThread();
    this.mActivity.getWindow().getDecorView().getWindowId().registerFocusObserver(this.mFocusObserver);
    internalBind();
  }
  
  public final void onDetachedFromWindow()
  {
    if (isPreKitKatDevice()) {}
    do
    {
      return;
      assertMainThread();
      this.mActivity.getWindow().getDecorView().getWindowId().unregisterFocusObserver(this.mFocusObserver);
    } while (!this.mIsBound);
    this.mActivity.unbindService(this.mConnection);
    this.mIsBound = false;
  }
  
  public final void requestHotwordDetection(boolean paramBoolean)
  {
    if (isPreKitKatDevice()) {
      return;
    }
    assertMainThread();
    this.mIsRequested = paramBoolean;
    internalRequestHotword();
  }
  
  private class HotwordServiceConnection
    implements ServiceConnection
  {
    private HotwordServiceConnection() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      HotwordServiceClient.access$502(HotwordServiceClient.this, IHotwordService.Stub.asInterface(paramIBinder));
      HotwordServiceClient.this.internalRequestHotword();
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      HotwordServiceClient.access$402(HotwordServiceClient.this, false);
      HotwordServiceClient.access$502(HotwordServiceClient.this, null);
    }
  }
  
  private class WindowFocusObserver
    extends WindowId.FocusObserver
  {
    private WindowFocusObserver() {}
    
    public void onFocusGained(WindowId paramWindowId)
    {
      HotwordServiceClient.access$202(HotwordServiceClient.this, true);
      HotwordServiceClient.this.internalRequestHotword();
    }
    
    public void onFocusLost(WindowId paramWindowId)
    {
      HotwordServiceClient.access$202(HotwordServiceClient.this, false);
      HotwordServiceClient.this.internalRequestHotword();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/google/android/hotword/client/HotwordServiceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */