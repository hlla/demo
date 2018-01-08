package com.android.launcher2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.samsung.surfacewidget.IRemoteServiceCallback.Stub;
import com.samsung.surfacewidget.ISurfaceWidgetService;
import com.samsung.surfacewidget.ISurfaceWidgetService.Stub;
import com.samsung.surfacewidget.SurfaceWidgetProviderInfo;
import com.sec.dtl.launcher.GyroForShadow;
import com.sec.dtl.launcher.GyroForShadow.VectorListener;
import com.sec.dtl.launcher.Talk;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;

public class SurfaceWidgetConnection
{
  private static final boolean DEBUG = ;
  private static final int LAUNCHER_SURFACE_WIDGET_SERVICE_VERSION = 237392;
  private static final String TAG = "SurfaceWidgetConnection";
  private final Context mContext;
  private final ServiceConn mServiceConn;
  public final int mServiceInstance;
  private final SurfaceInfo mSurfaceInfo;
  
  private SurfaceWidgetConnection(Context paramContext, int paramInt, ServiceConn paramServiceConn, SurfaceInfo paramSurfaceInfo, SurfaceWidgetView paramSurfaceWidgetView)
  {
    this.mContext = paramContext;
    this.mServiceConn = paramServiceConn;
    this.mServiceInstance = paramInt;
    this.mSurfaceInfo = paramSurfaceInfo;
  }
  
  public static SurfaceWidgetConnection bindToService(SurfaceWidgetView paramSurfaceWidgetView, SurfaceWidgetProviderInfo paramSurfaceWidgetProviderInfo, int paramInt)
  {
    Context localContext = paramSurfaceWidgetView.getContext().getApplicationContext();
    ServiceConn localServiceConn = new ServiceConn(new Name(paramSurfaceWidgetProviderInfo.getComponentName(), paramInt), paramSurfaceWidgetView, paramSurfaceWidgetProviderInfo);
    localServiceConn.bind(localContext, new Intent().setComponent(paramSurfaceWidgetProviderInfo.getComponentName()).putExtra("instance", paramInt));
    paramSurfaceWidgetView.setSurfaceTextureListener(localServiceConn.mSurfaceInfo);
    paramSurfaceWidgetProviderInfo = paramSurfaceWidgetView.getSurfaceTexture();
    if (paramSurfaceWidgetProviderInfo != null) {
      localServiceConn.mSurfaceInfo.onSurfaceTextureAvailable(paramSurfaceWidgetProviderInfo, paramSurfaceWidgetView.getWidth(), paramSurfaceWidgetView.getHeight());
    }
    return new SurfaceWidgetConnection(localContext, paramInt, localServiceConn, localServiceConn.mSurfaceInfo, paramSurfaceWidgetView);
  }
  
  public boolean onDestroy(boolean paramBoolean)
  {
    this.mServiceConn.unregisterGyro();
    try
    {
      this.mServiceConn.onDestroy(paramBoolean);
      this.mSurfaceInfo.releaseSurface();
      this.mServiceConn.unbind(this.mContext);
      return false;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      for (;;)
      {
        Log.e("SurfaceWidgetConnection", "onDestroy() has a problem when destroying widget. Ignore and keep going", localDeadObjectException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mServiceConn.onSurfaceWidgetError(localException);
      }
    }
  }
  
  public void onLauncherTiltChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    try
    {
      this.mServiceConn.onLauncherTiltChanged(paramFloat1, paramFloat2, paramFloat3);
      return;
    }
    catch (Exception localException)
    {
      this.mServiceConn.onSurfaceWidgetError(localException);
    }
  }
  
  public boolean onPause()
  {
    this.mServiceConn.unregisterGyro();
    try
    {
      this.mServiceConn.onPause();
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mServiceConn.onSurfaceWidgetError(localException);
      }
    }
  }
  
  public void onPositionOffsetChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.mServiceConn.arePositionUpdatesOn()) {
      return;
    }
    try
    {
      this.mServiceConn.onPositionOffsetChanged(paramFloat1, paramFloat2, paramFloat3);
      return;
    }
    catch (Exception localException)
    {
      this.mServiceConn.onSurfaceWidgetError(localException);
    }
  }
  
  public boolean onResume()
  {
    this.mServiceConn.registerGyro();
    updateSurfaceTextureIfNeeded();
    try
    {
      this.mServiceConn.onResume();
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mServiceConn.onSurfaceWidgetError(localException);
      }
    }
  }
  
  public void onVerticalTouch(MotionEvent paramMotionEvent)
  {
    try
    {
      this.mServiceConn.onVerticalTouch(paramMotionEvent);
      return;
    }
    catch (Exception paramMotionEvent)
    {
      this.mServiceConn.onSurfaceWidgetError(paramMotionEvent);
    }
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mServiceConn.registerGyro();
    }
    for (;;)
    {
      if (paramBoolean) {
        updateSurfaceTextureIfNeeded();
      }
      try
      {
        this.mServiceConn.onVisibilityChanged(paramBoolean);
        return;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        Log.e("SurfaceWidgetConnection", "onVisibilityChanged() came earlier than onServiceDisconnected() so wait for onServiceDisconnected() to restart widget", localDeadObjectException);
        return;
      }
      catch (Exception localException)
      {
        this.mServiceConn.onSurfaceWidgetError(localException);
      }
      this.mServiceConn.unregisterGyro();
    }
  }
  
  public void resumeLater(boolean paramBoolean)
  {
    this.mServiceConn.resumeLater(paramBoolean);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    try
    {
      this.mServiceConn.setFocus(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      this.mServiceConn.onSurfaceWidgetError(localException);
    }
  }
  
  public void setUpdateTime(int paramInt)
  {
    try
    {
      this.mServiceConn.setUpdateTime(paramInt);
      return;
    }
    catch (Exception localException)
    {
      this.mServiceConn.onSurfaceWidgetError(localException);
    }
  }
  
  public void updateContentDescription()
  {
    try
    {
      this.mServiceConn.updateContentDescription();
      return;
    }
    catch (Exception localException)
    {
      this.mServiceConn.onSurfaceWidgetError(localException);
    }
  }
  
  public void updateSurfaceTextureIfNeeded()
  {
    this.mSurfaceInfo.updateSurfaceTextureIfNeeded();
  }
  
  private static final class Name
  {
    public final int inst;
    public final ComponentName name;
    
    public Name(ComponentName paramComponentName, int paramInt)
    {
      this.name = paramComponentName;
      this.inst = paramInt;
    }
    
    public String toString()
    {
      return this.name.getShortClassName() + '#' + this.inst;
    }
  }
  
  private static final class ServiceConn
    implements ServiceConnection
  {
    private final SurfaceWidgetProviderInfo mInfo;
    private boolean mIsBound = false;
    private final SurfaceWidgetConnection.Name mName;
    private ISurfaceWidgetService mService = null;
    private final SurfaceWidgetConnection.SurfaceInfo mSurfaceInfo;
    private final WidgetViewCommunicator mWidgetViewComm;
    private boolean mbResumeLater = false;
    
    public ServiceConn(SurfaceWidgetConnection.Name paramName, SurfaceWidgetView paramSurfaceWidgetView, SurfaceWidgetProviderInfo paramSurfaceWidgetProviderInfo)
    {
      this.mName = paramName;
      this.mInfo = paramSurfaceWidgetProviderInfo;
      this.mWidgetViewComm = new WidgetViewCommunicator(this.mName, paramSurfaceWidgetView, this);
      this.mSurfaceInfo = new SurfaceWidgetConnection.SurfaceInfo(this, paramName, paramSurfaceWidgetView);
    }
    
    public boolean arePositionUpdatesOn()
    {
      return this.mWidgetViewComm.arePositionUpdatesOn();
    }
    
    public void bind(Context paramContext, Intent paramIntent)
    {
      if (!this.mIsBound)
      {
        this.mIsBound = paramContext.bindService(paramIntent, this, 1);
        if (SurfaceWidgetConnection.DEBUG)
        {
          if (!this.mIsBound) {
            break label60;
          }
          Log.d("SurfaceWidgetConnection", this.mName + " has been bound to its service");
        }
      }
      return;
      label60:
      Log.w("SurfaceWidgetConnection", this.mName + " failed to bind to its service");
    }
    
    public void onDestroy(boolean paramBoolean)
      throws RemoteException
    {
      if (this.mService != null)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " is being destroyed by launcher");
        }
        this.mService.onDestroy(this.mName.inst, paramBoolean);
      }
    }
    
    public void onKeyboardCompleted(int paramInt, String paramString)
      throws RemoteException
    {
      if (this.mService != null)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " being sent onEditViewTextChanged by launcher");
        }
        this.mService.onKeyboardCompleted(this.mName.inst, paramInt, paramString);
      }
    }
    
    public void onLauncherTiltChanged(float paramFloat1, float paramFloat2, float paramFloat3)
      throws RemoteException
    {
      if (this.mService != null)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " getting tilt changed from launcher");
        }
        this.mService.onLauncherTiltChanged(this.mName.inst, paramFloat1, paramFloat2, paramFloat3);
      }
    }
    
    public void onPause()
      throws RemoteException
    {
      if (this.mService != null)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " is being paused by launcher");
        }
        this.mService.onPause(this.mName.inst);
      }
    }
    
    public void onPositionOffsetChanged(float paramFloat1, float paramFloat2, float paramFloat3)
      throws RemoteException
    {
      if (this.mService != null) {
        this.mService.onPositionOffsetChanged(this.mName.inst, paramFloat1, paramFloat2, paramFloat3);
      }
    }
    
    public boolean onResume()
      throws RemoteException
    {
      if (this.mService != null)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " is being resumed by launcher");
        }
        this.mService.onResume(this.mName.inst);
        return true;
      }
      return false;
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (SurfaceWidgetConnection.DEBUG) {
        Log.d("SurfaceWidgetConnection", this.mName + " connected to its service");
      }
      this.mService = ISurfaceWidgetService.Stub.asInterface(paramIBinder);
      try
      {
        this.mService.checkVersion(237392);
        this.mService.setProviderInfo(this.mName.inst, this.mInfo);
        this.mService.setCallback(this.mName.inst, this.mWidgetViewComm);
        paramIBinder = this.mSurfaceInfo.getLatestSurfaceState();
        StringBuilder localStringBuilder;
        if (paramIBinder != null) {
          if (SurfaceWidgetConnection.DEBUG)
          {
            localStringBuilder = new StringBuilder().append(this.mName).append("'s surface is ");
            if (!paramIBinder.surface.isValid()) {
              break label339;
            }
          }
        }
        label339:
        for (paramComponentName = "valid";; paramComponentName = "invalid")
        {
          Log.d("SurfaceWidgetConnection", paramComponentName);
          if ((paramIBinder.height > 0) && (paramIBinder.width > 0))
          {
            int i = 0;
            int j = 0;
            paramComponentName = SurfaceWidgetConnection.SurfaceInfo.access$200(this.mSurfaceInfo).getLayoutParams();
            if ((paramComponentName instanceof CellLayout.LayoutParams))
            {
              paramComponentName = (CellLayout.LayoutParams)paramComponentName;
              i = paramComponentName.cellHSpan;
              j = paramComponentName.cellVSpan;
            }
            this.mService.onSurfaceSizeChanged(this.mName.inst, paramIBinder.surface, paramIBinder.width, paramIBinder.height, false, i, j);
            if (SurfaceWidgetConnection.DEBUG) {
              Log.d("SurfaceWidgetConnection", this.mName + " onServiceConnected: " + paramIBinder.width + "x" + paramIBinder.height + ", " + i + "x" + j);
            }
          }
          if (!this.mbResumeLater) {
            break;
          }
          registerGyro();
          onResume();
          this.mbResumeLater = false;
          return;
        }
        return;
      }
      catch (Exception paramComponentName)
      {
        this.mWidgetViewComm.onSurfaceWidgetError(paramComponentName);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (SurfaceWidgetConnection.DEBUG) {
        Log.d("SurfaceWidgetConnection", this.mName + " has been disconnected from its service");
      }
      this.mService = null;
      this.mWidgetViewComm.onSurfaceWidgetDisconnect();
    }
    
    public void onSurfaceDestroyed()
      throws RemoteException
    {
      if (this.mService != null) {
        this.mService.onSurfaceDestroyed(this.mName.inst);
      }
    }
    
    public void onSurfaceSizeChanged(Surface paramSurface, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
      throws RemoteException
    {
      if (this.mService != null) {
        this.mService.onSurfaceSizeChanged(this.mName.inst, paramSurface, paramInt1, paramInt2, paramBoolean, paramInt3, paramInt4);
      }
    }
    
    public void onSurfaceWidgetDisconnect()
    {
      this.mWidgetViewComm.onSurfaceWidgetDisconnect();
    }
    
    public void onSurfaceWidgetError(Exception paramException)
    {
      this.mWidgetViewComm.onSurfaceWidgetError(paramException);
    }
    
    public void onVerticalTouch(MotionEvent paramMotionEvent)
      throws RemoteException
    {
      if (this.mService != null) {
        this.mService.onVerticalTouch(this.mName.inst, paramMotionEvent);
      }
    }
    
    public void onVisibilityChanged(boolean paramBoolean)
      throws RemoteException
    {
      if (this.mService != null) {
        this.mService.onVisibilityChanged(this.mName.inst, paramBoolean);
      }
    }
    
    public void registerGyro()
    {
      this.mWidgetViewComm.registerGyro();
    }
    
    public void resumeLater(boolean paramBoolean)
    {
      this.mbResumeLater = paramBoolean;
    }
    
    public void setFocus(boolean paramBoolean)
      throws RemoteException
    {
      if (this.mService != null)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " being set focused " + paramBoolean + " by launcher");
        }
        this.mService.setFocus(this.mName.inst, paramBoolean);
      }
    }
    
    public void setUpdateTime(int paramInt)
      throws RemoteException
    {
      if (this.mService != null)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " being sent updateTime by launcher");
        }
        this.mService.setUpdateTime(this.mName.inst, paramInt);
      }
    }
    
    public void unbind(Context paramContext)
    {
      StringBuilder localStringBuilder;
      if (this.mIsBound)
      {
        paramContext.unbindService(this);
        this.mIsBound = false;
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " has been unbound from its service");
        }
        boolean bool = paramContext.stopService(new Intent().setComponent(this.mName.name));
        if (SurfaceWidgetConnection.DEBUG)
        {
          localStringBuilder = new StringBuilder().append(this.mName).append("'s service has ");
          if (!bool) {
            break label124;
          }
        }
      }
      label124:
      for (paramContext = "been stopped";; paramContext = "not been stopped")
      {
        Log.d("SurfaceWidgetConnection", paramContext);
        return;
      }
    }
    
    public void unregisterGyro()
    {
      this.mWidgetViewComm.unregisterGyro();
    }
    
    public void updateContentDescription()
      throws RemoteException
    {
      if (this.mService != null)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " requesting fresh content description");
        }
        this.mService.onContentDescriptionRequest(this.mName.inst);
      }
    }
    
    private static final class WidgetViewCommunicator
      extends IRemoteServiceCallback.Stub
    {
      private GyroForShadow.VectorListener mGyroListener = null;
      private final SurfaceWidgetConnection.Name mName;
      private boolean mPositionUpdatesOn = false;
      private final SurfaceWidgetConnection.ServiceConn mServiceConn;
      private final WeakReference<SurfaceWidgetView> mWidgetViewRef;
      
      public WidgetViewCommunicator(SurfaceWidgetConnection.Name paramName, SurfaceWidgetView paramSurfaceWidgetView, SurfaceWidgetConnection.ServiceConn paramServiceConn)
      {
        this.mName = paramName;
        this.mWidgetViewRef = new WeakReference(paramSurfaceWidgetView);
        this.mServiceConn = paramServiceConn;
      }
      
      private static void logWidgetViewUnavailable(String paramString)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.w("SurfaceWidgetConnection", paramString + ": widget view is no longer available");
        }
      }
      
      public void acceptedFocus(boolean paramBoolean)
        throws RemoteException
      {
        StringBuilder localStringBuilder;
        if (SurfaceWidgetConnection.DEBUG)
        {
          localStringBuilder = new StringBuilder().append(this.mName).append("'s service ");
          if (!paramBoolean) {
            break label53;
          }
        }
        label53:
        for (String str = "accepted";; str = "did not accept")
        {
          Log.d("SurfaceWidgetConnection", str + " focus");
          return;
        }
      }
      
      public void acceptedSurfaceSize(int paramInt1, int paramInt2)
        throws RemoteException
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", "acceptedSurfaceSize: " + paramInt1 + "x" + paramInt2);
        }
        SurfaceWidgetView localSurfaceWidgetView = (SurfaceWidgetView)this.mWidgetViewRef.get();
        if (SurfaceWidgetView.isRotationEnabled()) {
          try
          {
            localSurfaceWidgetView.setRotationState(false);
            localSurfaceWidgetView.notifyAll();
            return;
          }
          finally {}
        }
      }
      
      public boolean arePositionUpdatesOn()
      {
        try
        {
          boolean bool = this.mPositionUpdatesOn;
          return bool;
        }
        finally
        {
          localObject = finally;
          throw ((Throwable)localObject);
        }
      }
      
      public void checkVersion(int paramInt)
      {
        if (paramInt != 237392) {
          Log.e("SurfaceWidgetConnection", "Wrong SurfaceWidgetService.jar version does not match the one this Launcher was compiled with!");
        }
      }
      
      public void onSurfaceWidgetDisconnect()
      {
        final SurfaceWidgetView localSurfaceWidgetView = (SurfaceWidgetView)this.mWidgetViewRef.get();
        if (localSurfaceWidgetView == null)
        {
          logWidgetViewUnavailable("onSurfaceWidgetError");
          return;
        }
        localSurfaceWidgetView.post(new Runnable()
        {
          public void run()
          {
            localSurfaceWidgetView.surfaceWidgetRestart();
          }
        });
      }
      
      public void onSurfaceWidgetError(final Exception paramException)
      {
        Log.e("SurfaceWidgetConnection", this.mName + " encountered an error", paramException);
        final SurfaceWidgetView localSurfaceWidgetView = (SurfaceWidgetView)this.mWidgetViewRef.get();
        if (localSurfaceWidgetView == null)
        {
          logWidgetViewUnavailable("onSurfaceWidgetError");
          return;
        }
        localSurfaceWidgetView.post(new Runnable()
        {
          public void run()
          {
            localSurfaceWidgetView.surfaceWidgetCrashed(paramException, paramException.toString());
          }
        });
      }
      
      public void registerGyro()
      {
        if (this.mGyroListener != null) {
          GyroForShadow.registerListener(this.mGyroListener);
        }
      }
      
      public void releaseFocus()
        throws RemoteException
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + "'s service requesting releaseFocus");
        }
        final SurfaceWidgetView localSurfaceWidgetView = (SurfaceWidgetView)this.mWidgetViewRef.get();
        if (localSurfaceWidgetView == null)
        {
          logWidgetViewUnavailable("releaseFocus");
          return;
        }
        localSurfaceWidgetView.post(new Runnable()
        {
          public void run()
          {
            localSurfaceWidgetView.clearFocus();
          }
        });
      }
      
      public void requestDestroy(final String paramString)
        throws RemoteException
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + "'s service requesting destroy: " + paramString);
        }
        final SurfaceWidgetView localSurfaceWidgetView = (SurfaceWidgetView)this.mWidgetViewRef.get();
        if (localSurfaceWidgetView == null)
        {
          logWidgetViewUnavailable("requestDestroy");
          return;
        }
        localSurfaceWidgetView.post(new Runnable()
        {
          public void run()
          {
            localSurfaceWidgetView.surfaceWidgetCrashed(null, paramString);
          }
        });
      }
      
      public void requestKeyboard(final int paramInt, final String paramString)
        throws RemoteException
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + "'s service requesting keyboard for textview=" + paramInt);
        }
        final SurfaceWidgetView localSurfaceWidgetView = (SurfaceWidgetView)this.mWidgetViewRef.get();
        if (localSurfaceWidgetView == null)
        {
          logWidgetViewUnavailable("requestKeyboard");
          return;
        }
        localSurfaceWidgetView.post(new Runnable()
        {
          public void run()
          {
            KeyboardDialog.createAndShow(((Launcher)localSurfaceWidgetView.getContext()).getFragmentManager(), new KeyboardDialog.Listener()
            {
              public void cancelled() {}
              
              public void confirmed(String paramAnonymous2String)
              {
                try
                {
                  SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.this.mServiceConn.onKeyboardCompleted(SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.2.this.val$textviewidentifier, paramAnonymous2String);
                  return;
                }
                catch (Exception paramAnonymous2String)
                {
                  Log.e("SurfaceWidgetConnection", "Error in surface widget", paramAnonymous2String);
                  SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.2.this.val$widgetView.surfaceWidgetCrashed(paramAnonymous2String, paramAnonymous2String.toString());
                }
              }
            }, paramString);
          }
        });
      }
      
      public void requestPositionUpdates(boolean paramBoolean)
        throws RemoteException
      {
        StringBuilder localStringBuilder;
        if (SurfaceWidgetConnection.DEBUG)
        {
          localStringBuilder = new StringBuilder().append(this.mName).append("'s service requesting to turn position updates ");
          if (!paramBoolean) {
            break label57;
          }
        }
        for (String str = "on";; str = "off")
        {
          Log.d("SurfaceWidgetConnection", str);
          label57:
          try
          {
            this.mPositionUpdatesOn = paramBoolean;
            return;
          }
          finally {}
        }
      }
      
      public void requestSizeChange(final int paramInt1, final int paramInt2)
        throws RemoteException
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + "'s service requesting new size w=" + paramInt1 + " h=" + paramInt2);
        }
        final SurfaceWidgetView localSurfaceWidgetView = (SurfaceWidgetView)this.mWidgetViewRef.get();
        if (localSurfaceWidgetView == null)
        {
          logWidgetViewUnavailable("requestSizeChange");
          return;
        }
        localSurfaceWidgetView.post(new Runnable()
        {
          public void run()
          {
            localSurfaceWidgetView.resizeSurfaceWidgetView(paramInt1, paramInt2);
          }
        });
      }
      
      public void requestTalkbackSay(final String paramString)
        throws RemoteException
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + "'s service requesting Talkback");
        }
        SurfaceWidgetView localSurfaceWidgetView = (SurfaceWidgetView)this.mWidgetViewRef.get();
        if (localSurfaceWidgetView == null)
        {
          logWidgetViewUnavailable("requestTalkbackSay");
          return;
        }
        localSurfaceWidgetView.post(new Runnable()
        {
          public void run()
          {
            Talk.INSTANCE.say(paramString);
          }
        });
      }
      
      public void requestTilt(final boolean paramBoolean)
        throws RemoteException
      {
        StringBuilder localStringBuilder;
        if (SurfaceWidgetConnection.DEBUG)
        {
          localStringBuilder = new StringBuilder().append(this.mName).append("'s service is requesting to turn tilt ");
          if (!paramBoolean) {
            break label68;
          }
        }
        label68:
        for (final Object localObject = "on";; localObject = "off")
        {
          Log.d("SurfaceWidgetConnection", (String)localObject);
          localObject = (SurfaceWidgetView)this.mWidgetViewRef.get();
          if (localObject != null) {
            break;
          }
          logWidgetViewUnavailable("requestTilt");
          return;
        }
        ((SurfaceWidgetView)localObject).post(new Runnable()
        {
          public void run()
          {
            if (paramBoolean)
            {
              if (SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.this.mGyroListener == null) {
                SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.access$402(SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.this, new GyroForShadow.VectorListener()
                {
                  public void onVectorChanged(float paramAnonymous2Float1, float paramAnonymous2Float2, float paramAnonymous2Float3, float paramAnonymous2Float4)
                  {
                    try
                    {
                      SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.this.mServiceConn.onLauncherTiltChanged(paramAnonymous2Float1, paramAnonymous2Float2, paramAnonymous2Float3);
                      return;
                    }
                    catch (Exception localException)
                    {
                      Log.e("SurfaceWidgetConnection", "Error in surface widget", localException);
                      SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.3.this.val$widgetView.surfaceWidgetCrashed(localException, localException.toString());
                    }
                  }
                });
              }
              GyroForShadow.registerListener(SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.this.mGyroListener);
              return;
            }
            GyroForShadow.unregisterListener(SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.this.mGyroListener);
            SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.access$402(SurfaceWidgetConnection.ServiceConn.WidgetViewCommunicator.this, null);
          }
        });
      }
      
      public void setOpaqueness(final boolean paramBoolean)
        throws RemoteException
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + "'s service setting complete opaqueness to " + paramBoolean);
        }
        final SurfaceWidgetView localSurfaceWidgetView = (SurfaceWidgetView)this.mWidgetViewRef.get();
        if (localSurfaceWidgetView == null)
        {
          logWidgetViewUnavailable("acceptedFocus");
          return;
        }
        localSurfaceWidgetView.post(new Runnable()
        {
          public void run()
          {
            localSurfaceWidgetView.setOpaque(paramBoolean);
          }
        });
      }
      
      public void startActivity(String paramString)
      {
        if (paramString == null)
        {
          Log.e("SurfaceWidgetConnection", "null Class cannot be launched");
          return;
        }
        try
        {
          paramString = Intent.parseUri(paramString, 0);
          Launcher.getInstance().startActivity(paramString);
          return;
        }
        catch (URISyntaxException paramString)
        {
          paramString.printStackTrace();
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      
      public void unregisterGyro()
      {
        if (this.mGyroListener != null) {
          GyroForShadow.unregisterListener(this.mGyroListener);
        }
      }
      
      public void updateContentDescription(final String paramString)
        throws RemoteException
      {
        final SurfaceWidgetView localSurfaceWidgetView = (SurfaceWidgetView)this.mWidgetViewRef.get();
        if (localSurfaceWidgetView != null) {
          localSurfaceWidgetView.post(new Runnable()
          {
            public void run()
            {
              if (SurfaceWidgetConnection.DEBUG) {
                Log.d("SurfaceWidgetConnection", "Updating content description");
              }
              localSurfaceWidgetView.updateContentDescription(paramString);
            }
          });
        }
      }
    }
  }
  
  private static final class SurfaceInfo
    implements TextureView.SurfaceTextureListener
  {
    private final SurfaceWidgetConnection.Name mName;
    private int mOrientation = 0;
    private SavedSurfaceState mSavedSurfaceState = null;
    private final SurfaceWidgetConnection.ServiceConn mServiceConn;
    private SurfaceTexture mSurfaceTexture = null;
    private final SurfaceWidgetView mSurfaceWidgetView;
    public boolean mWasDestroyed = false;
    
    public SurfaceInfo(SurfaceWidgetConnection.ServiceConn paramServiceConn, SurfaceWidgetConnection.Name paramName, SurfaceWidgetView paramSurfaceWidgetView)
    {
      this.mServiceConn = paramServiceConn;
      this.mName = paramName;
      this.mSurfaceWidgetView = paramSurfaceWidgetView;
      this.mOrientation = paramSurfaceWidgetView.getResources().getConfiguration().orientation;
    }
    
    public SavedSurfaceState getLatestSurfaceState()
    {
      return this.mSavedSurfaceState;
    }
    
    boolean isSameOrientation(int paramInt)
    {
      return this.mOrientation == paramInt;
    }
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      if ((wasTextureDestroyed()) && (this.mSurfaceTexture != null)) {
        updateSurfaceTextureIfNeeded();
      }
      for (;;)
      {
        return;
        releaseSurface();
        this.mSurfaceTexture = paramSurfaceTexture;
        this.mSavedSurfaceState = new SavedSurfaceState(new Surface(paramSurfaceTexture), paramInt1, paramInt2);
        int i = 0;
        int j = 0;
        paramSurfaceTexture = this.mSurfaceWidgetView.getLayoutParams();
        if ((paramSurfaceTexture instanceof CellLayout.LayoutParams))
        {
          paramSurfaceTexture = (CellLayout.LayoutParams)paramSurfaceTexture;
          i = paramSurfaceTexture.cellHSpan;
          j = paramSurfaceTexture.cellVSpan;
        }
        try
        {
          this.mServiceConn.onSurfaceSizeChanged(this.mSavedSurfaceState.surface, paramInt1, paramInt2, false, i, j);
          if (SurfaceWidgetConnection.DEBUG)
          {
            Log.d("SurfaceWidgetConnection", this.mName + " onSurfaceTextureAvailable: " + paramInt1 + "x" + paramInt2 + ", " + i + "x" + j);
            return;
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          this.mServiceConn.onSurfaceWidgetError(paramSurfaceTexture);
        }
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      if (SurfaceWidgetConnection.DEBUG) {
        Log.d("SurfaceWidgetConnection", this.mName + "'s surface texture was destroyed");
      }
      setDestroyed(true);
      return false;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      this.mSavedSurfaceState.width = paramInt1;
      this.mSavedSurfaceState.height = paramInt2;
      this.mOrientation = this.mSurfaceWidgetView.getResources().getConfiguration().orientation;
      int i = 0;
      int j = 0;
      paramSurfaceTexture = this.mSurfaceWidgetView.getLayoutParams();
      if ((paramSurfaceTexture instanceof CellLayout.LayoutParams))
      {
        paramSurfaceTexture = (CellLayout.LayoutParams)paramSurfaceTexture;
        i = paramSurfaceTexture.cellHSpan;
        j = paramSurfaceTexture.cellVSpan;
      }
      try
      {
        this.mServiceConn.onSurfaceSizeChanged(this.mSavedSurfaceState.surface, paramInt1, paramInt2, true, i, j);
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " onSurfaceSizeChanged: " + paramInt1 + "x" + paramInt2 + ", " + i + "x" + j);
        }
        return;
      }
      catch (Exception paramSurfaceTexture)
      {
        this.mServiceConn.onSurfaceWidgetError(paramSurfaceTexture);
      }
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    
    public void releaseSurface()
    {
      if (this.mSavedSurfaceState != null)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + "'s surface is being released");
        }
        this.mSavedSurfaceState.surface.release();
        this.mSavedSurfaceState = null;
      }
      if (this.mSurfaceTexture != null)
      {
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + "'s surface texture is being released");
        }
        this.mSurfaceTexture.release();
        this.mSurfaceTexture = null;
      }
    }
    
    void setDestroyed(boolean paramBoolean)
    {
      this.mWasDestroyed = paramBoolean;
    }
    
    public void updateSurfaceTextureIfNeeded()
    {
      if (SurfaceWidgetConnection.DEBUG) {
        Log.d("SurfaceWidgetConnection", this.mName + " Checking SurfaceTexture if it needs to be updated");
      }
      if ((wasTextureDestroyed()) && (this.mSurfaceTexture != null))
      {
        this.mSurfaceWidgetView.setSurfaceTexture(this.mSurfaceTexture);
        if (SurfaceWidgetConnection.DEBUG) {
          Log.d("SurfaceWidgetConnection", this.mName + " SurfaceTexture was set");
        }
        this.mSurfaceWidgetView.invalidate();
        this.mSurfaceWidgetView.requestLayout();
      }
      setDestroyed(false);
    }
    
    boolean wasTextureDestroyed()
    {
      return this.mWasDestroyed;
    }
    
    public static final class SavedSurfaceState
    {
      public int height;
      public final Surface surface;
      public int width;
      
      public SavedSurfaceState(Surface paramSurface, int paramInt1, int paramInt2)
      {
        this.surface = paramSurface;
        this.width = paramInt1;
        this.height = paramInt2;
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/SurfaceWidgetConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */