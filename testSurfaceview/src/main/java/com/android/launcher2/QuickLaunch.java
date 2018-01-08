package com.android.launcher2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.sec.android.app.launcher.R.styleable;
import java.util.ArrayList;

public class QuickLaunch
  extends FrameLayout
  implements Animator.AnimatorListener, Workspace.StateAnimatorProvider
{
  private static final int ALLAPPS = 0;
  private static final int BOTH = 2;
  private static final int CAMERA = 1;
  private AllappsIcon mAllappsIcon;
  private LinearLayout mAllappsLayout;
  private View mBackground;
  private AllappsIcon mCameraIcon;
  private LinearLayout mCameraLayout;
  private HomeView mHomeView;
  private int mIconDestination;
  
  public QuickLaunch(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public QuickLaunch(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QuickLaunch(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QuickLaunch, paramInt, 0);
    this.mIconDestination = paramContext.getInt(0, 0);
    paramContext.recycle();
  }
  
  public void collectWorkspaceStateAnimators(Workspace paramWorkspace, Workspace.State paramState1, Workspace.State paramState2, BaseItem paramBaseItem, ArrayList<Animator> paramArrayList)
  {
    paramState1 = getContext();
    int j = 0;
    int k = 0;
    int i;
    if (paramState2 == Workspace.State.RESIZE)
    {
      i = 1;
      if ((i == 0) && (j == 0)) {
        break label230;
      }
      paramWorkspace = AnimatorInflater.loadAnimator(paramState1, 2131034113);
      paramWorkspace.setTarget(this.mBackground);
      paramArrayList.add(paramWorkspace);
      if (this.mAllappsLayout != null)
      {
        paramWorkspace = AnimatorInflater.loadAnimator(paramState1, 2131034124);
        paramWorkspace.setTarget(this.mAllappsLayout);
        paramArrayList.add(paramWorkspace);
      }
      if (this.mCameraLayout != null) {
        if (!isLandscape()) {
          break label220;
        }
      }
    }
    label220:
    for (paramWorkspace = AnimatorInflater.loadAnimator(paramState1, 2131034114);; paramWorkspace = AnimatorInflater.loadAnimator(paramState1, 2131034124))
    {
      paramWorkspace.setTarget(this.mCameraLayout);
      paramArrayList.add(paramWorkspace);
      if (this.mAllappsIcon != null)
      {
        this.mAllappsIcon.setDimmed(true, true);
        this.mAllappsIcon.setEnabled(false);
      }
      if (this.mCameraIcon != null)
      {
        this.mCameraIcon.setDimmed(true, true);
        this.mCameraIcon.setEnabled(false);
      }
      paramWorkspace = AnimatorInflater.loadAnimator(paramState1, 2131034113);
      paramWorkspace.setTarget(this);
      paramWorkspace.addListener(this);
      return;
      i = k;
      if (paramState2 != Workspace.State.EDIT) {
        break;
      }
      if (paramBaseItem != null) {}
      for (i = 1;; i = 0)
      {
        j = i;
        i = k;
        break;
      }
    }
    label230:
    paramWorkspace = AnimatorInflater.loadAnimator(paramState1, 2131034112);
    paramWorkspace.setTarget(this.mBackground);
    paramArrayList.add(paramWorkspace);
    if (this.mAllappsLayout != null)
    {
      paramWorkspace = AnimatorInflater.loadAnimator(paramState1, 2131034125);
      paramWorkspace.setTarget(this.mAllappsLayout);
      paramArrayList.add(paramWorkspace);
    }
    if (this.mCameraLayout != null) {
      if (!isLandscape()) {
        break label368;
      }
    }
    label368:
    for (paramWorkspace = AnimatorInflater.loadAnimator(paramState1, 2131034114);; paramWorkspace = AnimatorInflater.loadAnimator(paramState1, 2131034125))
    {
      paramWorkspace.setTarget(this.mCameraLayout);
      paramArrayList.add(paramWorkspace);
      if (this.mAllappsIcon != null)
      {
        this.mAllappsIcon.setDimmed(false, true);
        this.mAllappsIcon.setEnabled(true);
      }
      if (this.mCameraIcon == null) {
        break;
      }
      this.mCameraIcon.setDimmed(false, true);
      this.mCameraIcon.setEnabled(true);
      break;
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    Utilities.onViewDraw(this, paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  AllappsIcon getAllappsIcon()
  {
    return this.mAllappsIcon;
  }
  
  AllappsIcon getCameraIcon()
  {
    return this.mCameraIcon;
  }
  
  View getCameraLayout()
  {
    return this.mCameraLayout;
  }
  
  public int getIconDestination()
  {
    return this.mIconDestination;
  }
  
  public boolean isLandscape()
  {
    return getContext().getResources().getConfiguration().orientation == 2;
  }
  
  public boolean isVisible()
  {
    return getVisibility() == 0;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.mBackground.setLayerType(0, Launcher.sViewLayerPaint);
    if (this.mAllappsLayout != null) {
      this.mAllappsLayout.setLayerType(0, Launcher.sViewLayerPaint);
    }
    if (this.mCameraLayout != null) {
      this.mCameraLayout.setLayerType(0, Launcher.sViewLayerPaint);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.mBackground.setLayerType(2, Launcher.sViewLayerPaint);
    if (this.mAllappsLayout != null) {
      this.mAllappsLayout.setLayerType(2, Launcher.sViewLayerPaint);
    }
    if (this.mCameraLayout != null) {
      this.mCameraLayout.setLayerType(2, Launcher.sViewLayerPaint);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    switch (this.mIconDestination)
    {
    }
    for (;;)
    {
      this.mBackground = findViewById(2131689557);
      resetLayout();
      return;
      this.mAllappsLayout = ((LinearLayout)findViewById(2131689559));
      continue;
      this.mCameraLayout = ((LinearLayout)findViewById(2131689559));
      continue;
      this.mAllappsLayout = ((LinearLayout)findViewById(2131689559));
      this.mCameraLayout = ((LinearLayout)findViewById(2131689558));
    }
  }
  
  void resetLayout()
  {
    Context localContext = getContext();
    LayoutInflater localLayoutInflater = LayoutInflater.from(localContext);
    if ((this.mIconDestination != 1) && (this.mAllappsLayout != null))
    {
      this.mAllappsLayout.removeAllViewsInLayout();
      this.mAllappsIcon = ((AllappsIcon)localLayoutInflater.inflate(2130903123, this.mAllappsLayout, false));
      if (!Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) {
        break label287;
      }
      ThemeLoader localThemeLoader = LauncherApplication.getInst().getThemeLoader();
      if (localThemeLoader.isUseDefaultTheme()) {
        break label264;
      }
      this.mAllappsIcon.setCompoundDrawablesWithIntrinsicBounds(null, localThemeLoader.loadIconDrawable("all_apps_button_icon"), null, null);
    }
    for (;;)
    {
      this.mAllappsIcon.setText(2131755041);
      this.mAllappsIcon.setContentDescription(localContext.getString(2131755225));
      this.mAllappsIcon.setOnKeyListener(FocusHelper.QUICK_ALLAPPS_ICON_KEY_LISTENER);
      this.mAllappsIcon.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (QuickLaunch.this.mHomeView != null)
          {
            Handler localHandler = QuickLaunch.this.getHandler();
            if (localHandler != null) {
              localHandler.post(new Runnable()
              {
                public void run()
                {
                  Intent localIntent = new Intent();
                  localIntent.setAction("com.sec.android.intent.action.DVFS_BOOSTER");
                  localIntent.putExtra("PACKAGE", QuickLaunch.this.getContext().getPackageName());
                  localIntent.putExtra("DURATION", "1000");
                  QuickLaunch.this.getContext().sendBroadcast(localIntent);
                }
              });
            }
            QuickLaunch.this.mHomeView.onClickAllAppsButton(paramAnonymousView);
          }
        }
      });
      this.mAllappsLayout.addView(this.mAllappsIcon);
      if ((this.mIconDestination != 0) && (this.mCameraLayout != null))
      {
        this.mCameraLayout.removeAllViews();
        this.mCameraIcon = ((AllappsIcon)localLayoutInflater.inflate(2130903123, this.mCameraLayout, false));
        this.mCameraIcon.setCompoundDrawablesWithIntrinsicBounds(null, localContext.getResources().getDrawable(2130837622), null, null);
        this.mCameraIcon.setText(2131755157);
        this.mCameraIcon.setContentDescription(localContext.getString(2131755157));
        this.mCameraIcon.setOnKeyListener(FocusHelper.QUICK_CAMERA_ICON_KEY_LISTENER);
        this.mCameraIcon.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new Intent("android.intent.action.MAIN");
            paramAnonymousView.addCategory("android.intent.category.LAUNCHER");
            paramAnonymousView.setFlags(270532608);
            paramAnonymousView.setClassName("com.sec.android.app.camera", "com.sec.android.app.camera.Camera");
            QuickLaunch.this.getContext().startActivity(paramAnonymousView);
          }
        });
        this.mCameraLayout.addView(this.mCameraIcon);
      }
      return;
      label264:
      this.mAllappsIcon.setCompoundDrawablesWithIntrinsicBounds(null, localContext.getResources().getDrawable(2130837505), null, null);
      continue;
      label287:
      this.mAllappsIcon.setCompoundDrawablesWithIntrinsicBounds(null, localContext.getResources().getDrawable(2130837505), null, null);
    }
  }
  
  public void setIconDestination(int paramInt)
  {
    this.mIconDestination = paramInt;
  }
  
  public void setup(HomeView paramHomeView)
  {
    this.mHomeView = paramHomeView;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/QuickLaunch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */