package com.android.launcher2;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class SurfaceWidgetView
  extends TextureView
  implements DynamicShadowMixin.Holder
{
  private static final boolean DEBUG = true;
  private static final int RESTART_AUTOMATICALLY_LIMIT = 3;
  private static final String TAG = "SurfaceWidgetView";
  private static final boolean debugMode = false;
  private static HashMap<View, Boolean> mIsRotating = new HashMap();
  private static boolean mbIsRotationEnabled = false;
  private boolean mDetachedFromWindow = true;
  final int[] mLastTouch = new int[2];
  private boolean mPendingAccessibilityAction = false;
  private int mPendingAction;
  private Bundle mPendingArguments;
  private int mVisibility = 0;
  
  public SurfaceWidgetView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SurfaceWidgetView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    if (getResources().getConfiguration().smallestScreenWidthDp >= 600) {}
    for (boolean bool = true;; bool = false)
    {
      mbIsRotationEnabled = bool;
      return;
    }
  }
  
  public static boolean isRotationEnabled()
  {
    return mbIsRotationEnabled;
  }
  
  private void notifyPositionOffset(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Object localObject = getTag();
    if (((localObject instanceof SurfaceWidgetItem)) && (((SurfaceWidgetItem)localObject).mConnection != null)) {
      ((SurfaceWidgetItem)localObject).mConnection.onPositionOffsetChanged(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  private void restartWidget(SurfaceWidgetItem paramSurfaceWidgetItem, ViewGroup.LayoutParams paramLayoutParams, SurfaceWidgetView paramSurfaceWidgetView)
  {
    Log.d("SurfaceWidgetFlow", "making surface widget for restart");
    paramSurfaceWidgetItem.makeSurfaceWidget(getContext(), paramSurfaceWidgetItem.mInfo, paramSurfaceWidgetView, false);
    if (paramSurfaceWidgetItem.mWidgetView == null) {}
    for (;;)
    {
      return;
      paramSurfaceWidgetItem.setState(SurfaceWidgetItem.SurfaceWidgetState.RUNNING);
      paramSurfaceWidgetItem.mWidgetView.setOnKeyListener(FocusHelper.WORKSPACE_ICON_KEY_LISTENER);
      paramSurfaceWidgetItem.mWidgetView.setHapticFeedbackEnabled(false);
      try
      {
        paramSurfaceWidgetItem.mWidgetView.setOnLongClickListener(((Launcher)getContext()).getHomeView().getWorkspace().mLongClickListener);
        if (paramSurfaceWidgetView == null)
        {
          paramSurfaceWidgetView = (ViewGroup)paramSurfaceWidgetItem.mRestartView.getParent();
          paramSurfaceWidgetView.removeView(paramSurfaceWidgetItem.mRestartView);
          paramSurfaceWidgetView.addView(paramSurfaceWidgetItem.mWidgetView, paramLayoutParams);
          paramSurfaceWidgetItem.mRestartView = null;
        }
        if (!paramSurfaceWidgetItem.mWidgetView.isShown()) {
          continue;
        }
        paramSurfaceWidgetItem.onResume();
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          localNullPointerException.printStackTrace();
        }
      }
    }
  }
  
  public void createHardwareLayerEarly()
  {
    Method localMethod = Reflection.getMethod("android.view.TextureView", "getHardwareLayer", true);
    if (localMethod == null)
    {
      Log.e("SurfaceWidgetView", "getHardwareLayer method not found!");
      return;
    }
    try
    {
      Log.d("SurfaceWidgetView", "getHardwareLayer being called directly");
      localMethod.invoke(this, new Object[0]);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
  }
  
  protected void destroyHardwareResources()
  {
    Log.d("SurfaceWidgetView", "destroyHardwareResources():" + hashCode());
    super.destroyHardwareResources();
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    super.dispatchRestoreInstanceState(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    super.dispatchSaveInstanceState(paramSparseArray);
  }
  
  public void dumpSurfaceWidgetAppInfo()
  {
    Object localObject = getTag();
    if ((localObject instanceof SurfaceWidgetItem)) {
      Log.d("SurfaceWidgetView", "" + (SurfaceWidgetItem)localObject);
    }
  }
  
  public AppWidgetProviderInfo getAppWidgetInfo()
  {
    Object localObject = getTag();
    if ((localObject == null) || (!(localObject instanceof SurfaceWidgetItem)))
    {
      Log.e("SurfaceWidgetView", "SurfaceWidget didn't provide AppWidgetProviderInfo");
      return null;
    }
    return ((SurfaceWidgetItem)localObject).mInfo;
  }
  
  public DynamicShadowMixin getDynamicShadowMixin()
  {
    return null;
  }
  
  public int[] getLastTouchPoint()
  {
    return (int[])this.mLastTouch.clone();
  }
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1;
    Object localObject2;
    if (!isShown())
    {
      localObject1 = Reflection.getField("android.view.View", "mAttachInfo", true);
      localObject2 = Reflection.getField("android.view.View$AttachInfo", "mHardwareRenderer", true);
      localObject1 = Reflection.getFieldValue(Reflection.getFieldValue(this, (Field)localObject1), (Field)localObject2);
      localObject2 = Reflection.getMethod("android.view.HardwareRenderer", "isEnabled", true);
      if (localObject2 == null) {
        Log.w("SurfaceWidgetView", "enabledMethod was not found in the platform");
      }
    }
    else
    {
      return;
    }
    if (!((Boolean)Reflection.invoke(localObject1, (Method)localObject2, new Object[0])).booleanValue())
    {
      Log.d("SurfaceWidgetView", "Hardware renderer was not enabled yet");
      return;
    }
    if (Build.VERSION.SDK_INT <= 19)
    {
      localObject2 = Reflection.getMethod("android.view.HardwareRenderer", "validate", true);
      if (localObject2 == null)
      {
        Log.w("SurfaceWidgetView", "validateMethod was not found in the platform");
        return;
      }
      if (!((Boolean)Reflection.invoke(localObject1, (Method)localObject2, new Object[0])).booleanValue())
      {
        Log.d("SurfaceWidgetView", "Could not acquire hardware rendering context");
        return;
      }
    }
    createHardwareLayerEarly();
  }
  
  public void onAttachedToWindow()
  {
    Log.d("SurfaceWidgetView", "onAttachedToWindow() your surface should be back:" + hashCode());
    super.onAttachedToWindow();
    Object localObject = getTag();
    if (((SurfaceWidgetItem)localObject).mConnection != null) {
      ((SurfaceWidgetItem)localObject).mConnection.updateSurfaceTextureIfNeeded();
    }
  }
  
  public void onDetachedFromWindow()
  {
    Log.d("SurfaceWidgetView", "onDetachedFromWindow() your surface is gone:" + hashCode());
    super.onDetachedFromWindow();
  }
  
  protected void onDetachedFromWindowInternal()
  {
    Log.d("SurfaceWidgetView", "onDetachedFromWindowInternal() your surface is gone:" + hashCode());
    super.onDetachedFromWindowInternal();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((mbIsRotationEnabled) && (!paramBoolean)) {
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onPageScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = getX();
    float f2 = getY();
    float f3 = getWidth();
    float f4 = getHeight();
    notifyPositionOffset((f1 + 0.5F * f3 + ((paramInt2 - paramInt1) * paramInt3 - paramInt4)) / paramInt3, (f2 + 0.5F * f4) / ((View)getParent()).getHeight(), 0.0F);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("SurfaceWidgetView", "onSizeChanged()");
    if ((paramInt3 == 0) && (paramInt4 == 0)) {
      Log.d("SurfaceWidgetView", "onSizeChanged() just added to view heirarchy");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if ((Launcher.isHelpAppRunning) || (Launcher.isMotionDialogLaunching))
    {
      Log.w("SurfaceWidgetView", "I will not send touch event to widget:" + Launcher.isHelpAppRunning + "," + Launcher.isMotionDialogLaunching + " action:" + paramMotionEvent.getAction());
      bool1 = false;
      return bool1;
    }
    boolean bool2 = true;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      bool2 = super.onTouchEvent(paramMotionEvent);
      Object localObject = getTag();
      bool1 = bool2;
      if (!(localObject instanceof SurfaceWidgetItem)) {
        break;
      }
      bool1 = bool2;
      if (((SurfaceWidgetItem)localObject).mConnection == null) {
        break;
      }
      ((SurfaceWidgetItem)localObject).mConnection.onVerticalTouch(paramMotionEvent);
      return bool2;
      this.mLastTouch[0] = ((int)paramMotionEvent.getX());
      this.mLastTouch[1] = ((int)paramMotionEvent.getY());
      localObject = getLayoutParams();
      if ((localObject instanceof CellLayout.LayoutParams))
      {
        localObject = (CellLayout.LayoutParams)localObject;
        bool2 = true & ((CellLayout.LayoutParams)localObject).containsPt(this.mLastTouch[0] + ((CellLayout.LayoutParams)localObject).x, this.mLastTouch[1] + ((CellLayout.LayoutParams)localObject).y);
      }
    }
  }
  
  public void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    this.mVisibility = paramInt;
    if (paramInt == 4)
    {
      paramView = getTag();
      if (((paramView instanceof SurfaceWidgetItem)) && (((SurfaceWidgetItem)paramView).mConnection != null)) {
        ((SurfaceWidgetItem)paramView).mConnection.onVisibilityChanged(false);
      }
    }
    do
    {
      return;
      paramView = getTag();
    } while ((!(paramView instanceof SurfaceWidgetItem)) || (((SurfaceWidgetItem)paramView).mConnection == null));
    ((SurfaceWidgetItem)paramView).mConnection.onVisibilityChanged(true);
  }
  
  public void orientationChange()
  {
    if (!mbIsRotationEnabled) {
      return;
    }
    mIsRotating.put(this, Boolean.valueOf(true));
    int i = getResources().getDimensionPixelSize(2131624155);
    int j = getResources().getDimensionPixelSize(2131624156);
    int k = getResources().getDimensionPixelSize(2131624157);
    int m = getResources().getDimensionPixelSize(2131624158);
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)getLayoutParams();
    localLayoutParams.setup(i, j, k, m);
    measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824));
    layout(0, 0, localLayoutParams.width, localLayoutParams.height);
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 64)
    {
      Object localObject = getTag();
      if (((localObject instanceof SurfaceWidgetItem)) && (((SurfaceWidgetItem)localObject).mConnection != null)) {
        ((SurfaceWidgetItem)localObject).mConnection.updateContentDescription();
      }
      this.mPendingAction = paramInt;
      this.mPendingArguments = paramBundle;
      this.mPendingAccessibilityAction = true;
      return true;
    }
    return super.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public void repositionSurfaceWidget(int paramInt1, int paramInt2)
  {
    setFrame(paramInt1, paramInt2, getWidth() + paramInt1, getHeight() + paramInt2);
  }
  
  public void resizeSurfaceWidgetView(int paramInt1, int paramInt2)
  {
    Log.d("SurfaceWidgetView", "resizing surface widget view w = " + paramInt1 + " height = " + paramInt2);
    int i = (int)getX();
    int j = (int)getY();
    setFrame(i, j, i + paramInt1, j + paramInt2);
  }
  
  public boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1;
    if ((paramInt3 == paramInt1) || (paramInt4 == paramInt2))
    {
      Log.e("SurfaceWidgetView", "setting SurfaceWidgetView to 0 size!?!?...ignoring the call because it is wrong", new IllegalArgumentException());
      bool1 = false;
    }
    boolean bool2;
    View localView;
    do
    {
      return bool1;
      bool2 = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      localView = (View)getParent();
      bool1 = bool2;
    } while (localView == null);
    float f1 = paramInt1;
    float f2 = paramInt3;
    float f3 = paramInt3;
    float f4 = paramInt4;
    notifyPositionOffset((f1 + f2 * 0.5F) / localView.getWidth(), (f3 + f4 * 0.5F) / localView.getHeight(), 0.0F);
    return bool2;
  }
  
  public void setLastTouchPoint(int paramInt1, int paramInt2)
  {
    this.mLastTouch[0] = paramInt1;
    this.mLastTouch[1] = paramInt2;
  }
  
  public void setRotationState(boolean paramBoolean)
  {
    if ((mIsRotating == null) || (mIsRotating.size() < 1) || (mIsRotating.get(this) == null)) {
      return;
    }
    mIsRotating.put(this, Boolean.valueOf(paramBoolean));
  }
  
  public void surfaceWidgetCrashed(final Exception paramException, String paramString)
  {
    paramException = (SurfaceWidgetItem)getTag();
    if ((paramException == null) || (paramException.getState() == SurfaceWidgetItem.SurfaceWidgetState.DESTROYED)) {
      return;
    }
    paramException.setState(SurfaceWidgetItem.SurfaceWidgetState.DESTROYED);
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup == null)
    {
      Log.e("SurfaceWidgetView", "SurfaceWidgetView in error has a null parent? " + hashCode());
      return;
    }
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((paramException.mRestartCount < 3) && (paramString.contains("eglSwapBuffers")))
    {
      paramException.mRestartCount += 1;
      Log.d("SurfaceWidgetView", "auto-restarting widget");
      restartWidget(paramException, localLayoutParams, this);
      return;
    }
    paramString = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130903126, null);
    paramString.layout(getLeft(), getTop(), getRight(), getBottom());
    paramString.setTag(paramException);
    ((Button)paramString.findViewById(2131689682)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramException.mRestartCount = 0;
        SurfaceWidgetView.this.restartWidget(paramException, localLayoutParams, null);
      }
    });
    localViewGroup.removeView(this);
    localViewGroup.addView(paramString, 0, localLayoutParams);
    paramException.mRestartView = paramString;
    paramException.mWidgetView = null;
    paramException.mWidgetId = -1L;
  }
  
  public void surfaceWidgetRestart()
  {
    SurfaceWidgetItem localSurfaceWidgetItem = (SurfaceWidgetItem)getTag();
    if ((localSurfaceWidgetItem == null) || (localSurfaceWidgetItem.getState() == SurfaceWidgetItem.SurfaceWidgetState.DESTROYED)) {
      return;
    }
    localSurfaceWidgetItem.setState(SurfaceWidgetItem.SurfaceWidgetState.DESTROYED);
    if ((ViewGroup)getParent() == null)
    {
      Log.e("SurfaceWidgetView", "SurfaceWidgetView in error has a null parent? " + hashCode());
      return;
    }
    restartWidget(localSurfaceWidgetItem, getLayoutParams(), this);
  }
  
  public void updateContentDescription(String paramString)
  {
    if (this.mPendingAccessibilityAction == true)
    {
      if (!paramString.isEmpty()) {
        setContentDescription(paramString);
      }
      super.performAccessibilityAction(this.mPendingAction, this.mPendingArguments);
    }
    this.mPendingAccessibilityAction = false;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/SurfaceWidgetView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */