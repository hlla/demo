package com.android.launcher2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersonaManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.launcher2.guide.GuideFragment;
import com.samsung.android.feature.FloatingFeature;
import com.sec.android.app.launcher.R.styleable;
import com.sec.dtl.launcher.Talk;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HomeEditBar
  extends LinearLayout
  implements Animator.AnimatorListener, Workspace.StateAnimatorProvider, View.OnDragListener
{
  private static final String TAG = "HomeEditBar";
  public static boolean isfolderCreated = false;
  private boolean USE_SET_INTEGRATOR_HAPTIC = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_FRAMEWORK_ENABLE_INTEGRATOR_HAPTIC");
  private TextView mAddToPersonal;
  private FrameLayout mAddToPersonalContainer;
  private Drawable mAddToPersonalDrawable;
  private TextView mAppInfo;
  private FrameLayout mAppInfoContainer;
  private Drawable mAppInfoDrawable;
  private TextView mCancel;
  private FrameLayout mCancelContainer;
  private Drawable mCancelDrawable;
  private int mCurrentAnimatorRes;
  private TextView mDelete;
  private FrameLayout mDeleteContainer;
  private Drawable mDeleteDrawable;
  private TextView mDisable;
  private FrameLayout mDisableContainer;
  private Drawable mDisableDrawable;
  private boolean mDropped = false;
  private boolean mEntered = false;
  private int mHideAnimatorRes;
  private TextView mNewFolder;
  private FrameLayout mNewFolderContainer;
  private Drawable mNewFolderDrawable;
  private int mOrientation = 0;
  private PackageManager mPm;
  private int mPosition;
  private int mShowAnimatorRes;
  private boolean mShowPosted = false;
  private TextView mUninstall;
  private FrameLayout mUninstallContainer;
  private Drawable mUninstallDrawable;
  private Workspace mWorkspace;
  
  public HomeEditBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HomeEditBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HomeEditBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.EditDragBar, paramInt, 0);
    this.mPosition = paramContext.getInt(0, 17);
    paramContext.recycle();
  }
  
  private boolean addToPersonal(BaseItem paramBaseItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      doAddToPersonal(paramBaseItem);
      this.mDropped = true;
      if (((Launcher)getContext()).mHomeView != null)
      {
        paramBaseItem = ((Launcher)getContext()).mHomeView.getWorkspace();
        if (paramBaseItem != null) {
          paramBaseItem.onDragEndedWithItem(paramDragState.getItem());
        }
      }
      setStates(this.mAddToPersonalContainer, this.mAddToPersonal, true, true, true);
      if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn()))
      {
        performHapticFeedback(25687, 1);
        continue;
        this.mEntered = false;
        setStates(this.mAddToPersonalContainer, this.mAddToPersonal, true, false, false);
        continue;
        if ((this.mEntered) && (!this.mDropped))
        {
          this.mEntered = false;
          setStates(this.mAddToPersonalContainer, this.mAddToPersonal, true, false, false);
          continue;
          this.mEntered = true;
          this.mDropped = false;
          setStates(this.mAddToPersonalContainer, this.mAddToPersonal, true, true, false);
          Talk.INSTANCE.sayByTalkback(this.mAddToPersonal, getResources().getString(2131755148), true);
          if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn())) {
            performHapticFeedback(22165, 1);
          }
        }
      }
    }
  }
  
  private boolean appInfo(BaseItem paramBaseItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    boolean bool;
    if (paramBaseItem.getPackageName() != null) {
      bool = true;
    }
    switch (paramDragEvent.getAction())
    {
    case 2: 
    case 4: 
    default: 
    case 1: 
    case 5: 
    case 3: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool;
                bool = false;
                break;
                setStates(this.mAppInfoContainer, this.mAppInfo, bool, false, false);
              } while (bool);
              post(new Runnable()
              {
                public void run()
                {
                  HomeEditBar.this.mAppInfoContainer.setVisibility(8);
                }
              });
              return bool;
            } while (!bool);
            setStates(this.mAppInfoContainer, this.mAppInfo, true, true, false);
            Talk.INSTANCE.sayByTalkback(this.mAppInfo, getResources().getString(2131755146), true);
          } while ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn()));
          performHapticFeedback(22165, 1);
          return bool;
          paramBaseItem = paramBaseItem.getPackageName();
        } while (paramBaseItem == null);
        setStates(this.mAppInfoContainer, this.mAppInfo, true, true, true);
        paramBaseItem = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", paramBaseItem, null));
        paramBaseItem.setFlags(276824064);
        ((Activity)getContext()).startActivity(paramBaseItem);
      } while ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn()));
      performHapticFeedback(25687, 1);
      return bool;
    }
    setStates(this.mAppInfoContainer, this.mAppInfo, bool, false, false);
    return bool;
  }
  
  private boolean cancel(BaseItem paramBaseItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.mDropped = true;
      if (((Launcher)getContext()).mHomeView != null)
      {
        paramBaseItem = ((Launcher)getContext()).mHomeView.getWorkspace();
        if (paramBaseItem != null) {
          paramBaseItem.onDragEndedWithItem(paramDragState.getItem());
        }
      }
      setStates(this.mCancelContainer, this.mCancel, true, true, true);
      if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn()))
      {
        performHapticFeedback(25687, 1);
        continue;
        this.mEntered = false;
        setStates(this.mCancelContainer, this.mCancel, true, false, false);
        continue;
        if ((this.mEntered) && (!this.mDropped))
        {
          this.mEntered = false;
          setStates(this.mCancelContainer, this.mCancel, true, false, false);
          continue;
          this.mEntered = true;
          this.mDropped = false;
          setStates(this.mCancelContainer, this.mCancel, true, true, false);
          Talk.INSTANCE.sayByTalkback(this.mCancel, getResources().getString(2131755126), true);
          if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn())) {
            performHapticFeedback(22165, 1);
          }
        }
      }
    }
  }
  
  private boolean delete(BaseItem paramBaseItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.mDropped = true;
      if ((paramBaseItem instanceof HomeItem)) {
        paramDragState.onDelete();
      }
      for (;;)
      {
        if (Utilities.DEBUGGABLE())
        {
          paramDragState = new Date(System.currentTimeMillis());
          paramDragState = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(paramDragState);
          paramDragEvent = (LauncherApplication)((Activity)getContext()).getApplication();
          if (paramBaseItem.getPackageName() != null)
          {
            paramDragEvent = paramDragEvent.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
            paramDragEvent.putString("homeEditBarDelete", paramBaseItem.getPackageName().toString() + ", time : " + paramDragState);
            paramDragEvent.commit();
          }
        }
        setStates(this.mDeleteContainer, this.mDelete, true, true, true);
        if ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn())) {
          break;
        }
        performHapticFeedback(25687, 1);
        break;
        if (((Launcher)getContext()).mHomeView != null)
        {
          paramDragEvent = ((Launcher)getContext()).mHomeView.getWorkspace();
          if (paramDragEvent != null) {
            paramDragEvent.onDragEndedWithItem(paramDragState.getItem());
          }
        }
      }
      this.mEntered = false;
      setStates(this.mDeleteContainer, this.mDelete, true, false, false);
      continue;
      if ((this.mEntered) && (!this.mDropped))
      {
        this.mEntered = false;
        setStates(this.mDeleteContainer, this.mDelete, true, false, false);
        continue;
        this.mEntered = true;
        this.mDropped = false;
        setStates(this.mDeleteContainer, this.mDelete, true, true, false);
        Talk.INSTANCE.sayByTalkback(this.mDelete, getResources().getString(2131755145), true);
        if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn())) {
          performHapticFeedback(22165, 1);
        }
      }
    }
  }
  
  private boolean disable(BaseItem paramBaseItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      showDisableConfirmationDialog(paramBaseItem);
      this.mDropped = true;
      if (((Launcher)getContext()).mHomeView != null)
      {
        paramBaseItem = ((Launcher)getContext()).mHomeView.getWorkspace();
        if (paramBaseItem != null) {
          paramBaseItem.onDragEndedWithItem(paramDragState.getItem());
        }
      }
      setStates(this.mDisableContainer, this.mDisable, true, true, true);
      if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn()))
      {
        performHapticFeedback(25687, 1);
        continue;
        this.mEntered = false;
        setStates(this.mDisableContainer, this.mDisable, true, false, false);
        continue;
        if ((this.mEntered) && (!this.mDropped))
        {
          this.mEntered = false;
          setStates(this.mDisableContainer, this.mDisable, true, false, false);
          continue;
          this.mEntered = true;
          this.mDropped = false;
          setStates(this.mDisableContainer, this.mDisable, true, true, false);
          Talk.INSTANCE.sayByTalkback(this.mDisable, getResources().getString(2131755145), true);
          if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn())) {
            performHapticFeedback(22165, 1);
          }
        }
      }
    }
  }
  
  private void doAddToPersonal(BaseItem paramBaseItem)
  {
    if (paramBaseItem == null) {
      return;
    }
    try
    {
      int i = PersonaManager.getKnoxInfoForApp(getContext()).getInt("userId");
      Intent localIntent = new Intent("android.intent.action.LAUNCH_PERSONA_SHORTCUT");
      localIntent.setData(Uri.parse("persona_shortcut://"));
      Bundle localBundle = new Bundle();
      localBundle.putString("package", paramBaseItem.getPackageName());
      localBundle.putParcelable("component", paramBaseItem.getComponentName());
      localBundle.putString("label", paramBaseItem.mTitle);
      localBundle.putParcelable("iconBitmap", paramBaseItem.mIconBitmap);
      localBundle.putInt("personalId", i);
      localBundle.putString("commandType", "createShortcut");
      localIntent.putExtras(localBundle);
      ((Launcher)getContext()).sendBroadcast(localIntent);
      return;
    }
    catch (NoClassDefFoundError paramBaseItem)
    {
      Log.e("HomeEditBar", "not call android.os.PersonaManager." + paramBaseItem);
      return;
    }
    catch (NoSuchMethodError paramBaseItem)
    {
      Log.e("HomeEditBar", "not call getKnoxInfoForApp." + paramBaseItem);
    }
  }
  
  public static Drawable findFirstDrawable(TextView paramTextView)
  {
    Object localObject = null;
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    int i = 0;
    paramTextView = (TextView)localObject;
    for (;;)
    {
      if (i < arrayOfDrawable.length)
      {
        paramTextView = arrayOfDrawable[i];
        if (paramTextView == null) {}
      }
      else
      {
        return paramTextView;
      }
      i += 1;
    }
  }
  
  private boolean newFolder(BaseItem paramBaseItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    boolean bool;
    if (((!Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) || (!Launcher.sIsEditFromHome)) && ((paramBaseItem.mType == BaseItem.Type.MENU_APP) || ((paramBaseItem.mType == BaseItem.Type.HOME_SHORTCUT) && (paramBaseItem.mIconMovie == null)) || ((paramBaseItem.mType == BaseItem.Type.HOME_APPLICATION) && (paramBaseItem.mIconMovie == null) && (!(paramBaseItem instanceof HomePendingItem)))))
    {
      bool = true;
      switch (paramDragEvent.getAction())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool;
              bool = false;
              break;
              setStates(this.mNewFolderContainer, this.mNewFolder, bool, false, false);
              return bool;
            } while (!bool);
            setStates(this.mNewFolderContainer, this.mNewFolder, true, true, true);
            if (this.mWorkspace.getOpenFolder() != null) {
              this.mWorkspace.closeFolder();
            }
            if (Launcher.isHelpAppRunning) {
              isfolderCreated = true;
            }
            paramDragState.createHomeFolderFromDragItem();
          } while ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn()));
          performHapticFeedback(25687, 1);
          return bool;
        } while (!bool);
        setStates(this.mNewFolderContainer, this.mNewFolder, true, true, false);
        Talk.INSTANCE.sayByTalkback(this.mNewFolder, getResources().getString(2131755143), true);
      } while ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn()));
      performHapticFeedback(22165, 1);
      return bool;
    } while (!bool);
    setStates(this.mNewFolderContainer, this.mNewFolder, true, false, false);
    return bool;
  }
  
  private void setAnimatorsForOrientation()
  {
    switch (this.mPosition & 0x3)
    {
    case 1: 
    default: 
      this.mHideAnimatorRes = 2131034134;
      this.mShowAnimatorRes = 2131034135;
      return;
    case 0: 
      this.mHideAnimatorRes = 2131034126;
      this.mShowAnimatorRes = 2131034127;
      return;
    case 2: 
      this.mHideAnimatorRes = 2131034132;
      this.mShowAnimatorRes = 2131034133;
      return;
    }
    this.mHideAnimatorRes = 2131034112;
    this.mShowAnimatorRes = 2131034113;
  }
  
  private void setDrawableForOrientation(TextView paramTextView, Drawable paramDrawable, Drawable[] paramArrayOfDrawable, int paramInt)
  {
    if ((paramTextView != null) && (paramDrawable != null))
    {
      paramArrayOfDrawable[paramInt] = paramDrawable;
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramArrayOfDrawable[0], paramArrayOfDrawable[1], paramArrayOfDrawable[2], paramArrayOfDrawable[3]);
    }
  }
  
  private void setDrawablesForOrientation()
  {
    Drawable[] arrayOfDrawable = new Drawable[4];
    int i = (this.mPosition & 0x30) >> 4;
    setDrawableForOrientation(this.mAppInfo, this.mAppInfoDrawable, arrayOfDrawable, i);
    setDrawableForOrientation(this.mDelete, this.mDeleteDrawable, arrayOfDrawable, i);
    setDrawableForOrientation(this.mNewFolder, this.mNewFolderDrawable, arrayOfDrawable, i);
    setDrawableForOrientation(this.mDisable, this.mDisableDrawable, arrayOfDrawable, i);
    setDrawableForOrientation(this.mUninstall, this.mUninstallDrawable, arrayOfDrawable, i);
    setDrawableForOrientation(this.mAddToPersonal, this.mAddToPersonalDrawable, arrayOfDrawable, i);
    setDrawableForOrientation(this.mCancel, this.mCancelDrawable, arrayOfDrawable, i);
  }
  
  private void setInitialAnimationParameter()
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(2131820577, R.styleable.EditDragBar);
    this.mPosition = localTypedArray.getInt(0, 17);
    RotateHelper.applyStyle(2131820577, this);
    RotateHelper.applyStyleLayout(2131820577, this);
    localTypedArray.recycle();
    if (this.mAppInfo != null)
    {
      RotateHelper.applyStyle(2131820565, this.mAppInfo);
      RotateHelper.applyStyleLayout(2131820565, this.mAppInfo);
      RotateHelper.applyStyle(2131820579, this.mAppInfoContainer);
      RotateHelper.applyStyleLayout(2131820579, this.mAppInfoContainer);
    }
    if (this.mDelete != null)
    {
      RotateHelper.applyStyle(2131820565, this.mDelete);
      RotateHelper.applyStyleLayout(2131820565, this.mDelete);
      RotateHelper.applyStyle(2131820578, this.mDeleteContainer);
      RotateHelper.applyStyleLayout(2131820578, this.mDeleteContainer);
    }
    if (this.mNewFolder != null)
    {
      RotateHelper.applyStyle(2131820565, this.mNewFolder);
      RotateHelper.applyStyleLayout(2131820565, this.mNewFolder);
      RotateHelper.applyStyle(2131820579, this.mNewFolderContainer);
      RotateHelper.applyStyleLayout(2131820579, this.mNewFolderContainer);
    }
    if (this.mDisable != null)
    {
      RotateHelper.applyStyle(2131820565, this.mDisable);
      RotateHelper.applyStyleLayout(2131820565, this.mDisable);
      RotateHelper.applyStyle(2131820578, this.mDisableContainer);
      RotateHelper.applyStyleLayout(2131820578, this.mDisableContainer);
    }
    if (this.mUninstall != null)
    {
      RotateHelper.applyStyle(2131820565, this.mUninstall);
      RotateHelper.applyStyleLayout(2131820565, this.mUninstall);
      RotateHelper.applyStyle(2131820578, this.mUninstallContainer);
      RotateHelper.applyStyleLayout(2131820578, this.mUninstallContainer);
    }
    if (this.mCancel != null)
    {
      RotateHelper.applyStyle(2131820565, this.mCancel);
      RotateHelper.applyStyleLayout(2131820565, this.mCancel);
      RotateHelper.applyStyle(2131820578, this.mCancelContainer);
      RotateHelper.applyStyleLayout(2131820578, this.mCancelContainer);
    }
  }
  
  private void setStates(FrameLayout paramFrameLayout, TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramFrameLayout.setEnabled(paramBoolean1);
    paramTextView.setEnabled(paramBoolean1);
    paramFrameLayout.setSelected(paramBoolean2);
    paramFrameLayout.setActivated(paramBoolean3);
  }
  
  private void showDisableConfirmationDialog(BaseItem paramBaseItem)
  {
    switch (paramBaseItem.mType)
    {
    default: 
      return;
    }
    ((Launcher)getContext()).callDisableDialog(paramBaseItem);
  }
  
  private boolean uninstall(BaseItem paramBaseItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      UninstallConfirmDialogFragment.createAndShow(paramBaseItem.getPackageName(), paramBaseItem.mTitle, ((Activity)getContext()).getFragmentManager());
      this.mDropped = true;
      if (((Launcher)getContext()).mHomeView != null)
      {
        paramBaseItem = ((Launcher)getContext()).mHomeView.getWorkspace();
        if (paramBaseItem != null) {
          paramBaseItem.onDragEndedWithItem(paramDragState.getItem());
        }
      }
      setStates(this.mUninstallContainer, this.mUninstall, true, true, true);
      if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn()))
      {
        performHapticFeedback(25687, 1);
        continue;
        this.mEntered = false;
        setStates(this.mUninstallContainer, this.mUninstall, true, false, false);
        continue;
        if ((this.mEntered) && (!this.mDropped))
        {
          this.mEntered = false;
          setStates(this.mUninstallContainer, this.mUninstall, true, false, false);
          continue;
          this.mEntered = true;
          this.mDropped = false;
          setStates(this.mUninstallContainer, this.mUninstall, true, true, false);
          Talk.INSTANCE.sayByTalkback(this.mUninstall, getResources().getString(2131755059), true);
          if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn())) {
            performHapticFeedback(22165, 1);
          }
        }
      }
    }
  }
  
  public void collectWorkspaceStateAnimators(Workspace paramWorkspace, Workspace.State paramState1, Workspace.State paramState2, BaseItem paramBaseItem, ArrayList<Animator> paramArrayList)
  {
    this.mWorkspace = paramWorkspace;
    this.mCurrentAnimatorRes = 0;
    int m = 1;
    final boolean bool1;
    int i;
    label89:
    int j;
    label120:
    int k;
    label131:
    final boolean bool2;
    label148:
    final boolean bool3;
    label166:
    final boolean bool4;
    label184:
    final boolean bool5;
    label237:
    label259:
    final boolean bool6;
    if ((paramState2 == Workspace.State.EDIT) && (paramBaseItem != null))
    {
      this.mCurrentAnimatorRes = this.mShowAnimatorRes;
      if (((paramBaseItem instanceof AppItem)) && (paramBaseItem.getPackageName() != null) && (!Launcher.isHelpAppRunning))
      {
        bool1 = true;
        if ((!(paramBaseItem instanceof AppItem)) || (!MenuAppModel.INSTANCE.canDisableable((AppItem)paramBaseItem)) || (Launcher.isHelpAppRunning)) {
          break label528;
        }
        i = 1;
        if ((!(paramBaseItem instanceof AppItem)) || (!MenuAppModel.INSTANCE.canUninstallable((AppItem)paramBaseItem)) || (Launcher.isHelpAppRunning)) {
          break label534;
        }
        j = 1;
        if ((paramBaseItem instanceof FolderItem)) {
          break label540;
        }
        k = 1;
        if ((!(paramBaseItem instanceof AppItem)) || (!Launcher.isSystemAppDisable)) {
          break label546;
        }
        bool2 = true;
        if ((!bool2) || (k == 0) || (i == 0)) {
          break label552;
        }
        bool3 = true;
        if ((!bool2) || (k == 0) || (j == 0)) {
          break label558;
        }
        bool4 = true;
        if (((paramBaseItem.mType != BaseItem.Type.MENU_APP) && ((paramBaseItem.mType != BaseItem.Type.HOME_APPLICATION) || ((paramBaseItem instanceof HomePendingItem)))) || (!LauncherApplication.getInst().isKnoxMode()) || (!LauncherApplication.isPossibleAddToPersonal(paramBaseItem.getPackageName()))) {
          break label564;
        }
        bool5 = true;
        if ((!bool4) || (!Launcher.mNonDisableItems.contains(paramBaseItem.getPackageName().toString()))) {
          break label570;
        }
        i = m;
        if (Launcher.isHelpAppRunning) {
          if ((!GuideFragment.GMode.equals("addapps")) && (!GuideFragment.GMode.equals("add_widgets")) && (!GuideFragment.GMode.equals("remove_items")))
          {
            i = m;
            if (!GuideFragment.GMode.equals("move_app")) {}
          }
          else
          {
            i = 0;
          }
        }
        if (((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (Launcher.sIsEditFromHome)) || ((paramBaseItem.mType != BaseItem.Type.MENU_APP) && (paramBaseItem.mType != BaseItem.Type.HOME_SHORTCUT) && ((paramBaseItem.mType != BaseItem.Type.HOME_APPLICATION) || ((paramBaseItem instanceof HomePendingItem)))) || (i == 0)) {
          break label573;
        }
        bool6 = true;
        label385:
        LauncherApplication.getMaxScreenCount();
        if ((Launcher.isHelpAppRunning) && (!GuideFragment.GMode.equals("addapps")) && (!GuideFragment.GMode.equals("add_widgets")) && (!GuideFragment.GMode.equals("remove_items")) && (!GuideFragment.GMode.equals("create_folder")) && (GuideFragment.GMode.equals("move_app"))) {}
        post(new Runnable()
        {
          public void run()
          {
            int j = 8;
            FrameLayout localFrameLayout;
            if (HomeEditBar.this.mNewFolderContainer != null)
            {
              localFrameLayout = HomeEditBar.this.mNewFolderContainer;
              if (bool6)
              {
                i = 0;
                localFrameLayout.setVisibility(i);
              }
            }
            else
            {
              if (HomeEditBar.this.mAppInfoContainer != null)
              {
                localFrameLayout = HomeEditBar.this.mAppInfoContainer;
                if (!bool1) {
                  break label253;
                }
                i = 0;
                label62:
                localFrameLayout.setVisibility(i);
              }
              if (HomeEditBar.this.mDisableContainer != null)
              {
                localFrameLayout = HomeEditBar.this.mDisableContainer;
                if (!bool3) {
                  break label259;
                }
                i = 0;
                label94:
                localFrameLayout.setVisibility(i);
              }
              if (HomeEditBar.this.mUninstallContainer != null)
              {
                localFrameLayout = HomeEditBar.this.mUninstallContainer;
                if (!bool4) {
                  break label265;
                }
                i = 0;
                label126:
                localFrameLayout.setVisibility(i);
              }
              if (HomeEditBar.this.mAddToPersonalContainer != null)
              {
                localFrameLayout = HomeEditBar.this.mAddToPersonalContainer;
                if (!bool5) {
                  break label271;
                }
                i = 0;
                label158:
                localFrameLayout.setVisibility(i);
              }
              if (HomeEditBar.this.mCancelContainer != null)
              {
                localFrameLayout = HomeEditBar.this.mCancelContainer;
                if (!bool2) {
                  break label277;
                }
              }
            }
            label253:
            label259:
            label265:
            label271:
            label277:
            for (int i = 0;; i = 8)
            {
              localFrameLayout.setVisibility(i);
              if (HomeEditBar.this.mDeleteContainer != null)
              {
                localFrameLayout = HomeEditBar.this.mDeleteContainer;
                i = j;
                if (!bool2) {
                  i = 0;
                }
                localFrameLayout.setVisibility(i);
              }
              HomeEditBar.this.setVisibility(0);
              HomeEditBar.access$702(HomeEditBar.this, false);
              return;
              i = 8;
              break;
              i = 8;
              break label62;
              i = 8;
              break label94;
              i = 8;
              break label126;
              i = 8;
              break label158;
            }
          }
        });
        this.mShowPosted = true;
      }
    }
    for (;;)
    {
      if (this.mCurrentAnimatorRes != 0)
      {
        paramWorkspace = AnimatorInflater.loadAnimator(getContext(), this.mCurrentAnimatorRes);
        paramWorkspace.addListener(this);
        paramWorkspace.setTarget(this);
        paramArrayList.add(paramWorkspace);
      }
      return;
      bool1 = false;
      break;
      label528:
      i = 0;
      break label89;
      label534:
      j = 0;
      break label120;
      label540:
      k = 0;
      break label131;
      label546:
      bool2 = false;
      break label148;
      label552:
      bool3 = false;
      break label166;
      label558:
      bool4 = false;
      break label184;
      label564:
      bool5 = false;
      break label237;
      label570:
      break label259;
      label573:
      bool6 = false;
      break label385;
      if ((getVisibility() == 0) || (this.mShowPosted)) {
        this.mCurrentAnimatorRes = this.mHideAnimatorRes;
      }
    }
  }
  
  public int getBarPosition()
  {
    return this.mPosition & 0x3;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.mCurrentAnimatorRes == this.mHideAnimatorRes)
    {
      setVisibility(8);
      if (paramAnimator.getDuration() > 0L) {
        setLayerType(0, Launcher.sViewLayerPaint);
      }
      if (this.mAppInfo != null)
      {
        setStates(this.mAppInfoContainer, this.mAppInfo, true, false, false);
        this.mAppInfoContainer.setVisibility(0);
      }
      if (this.mDelete != null)
      {
        setStates(this.mDeleteContainer, this.mDelete, true, false, false);
        this.mDeleteContainer.setVisibility(0);
      }
      if (this.mNewFolder != null)
      {
        setStates(this.mNewFolderContainer, this.mNewFolder, true, false, false);
        this.mNewFolderContainer.setVisibility(0);
      }
      if (this.mDisable != null)
      {
        setStates(this.mDisableContainer, this.mDisable, true, false, false);
        this.mDisable.setVisibility(0);
      }
      if (this.mUninstall != null)
      {
        setStates(this.mUninstallContainer, this.mUninstall, true, false, false);
        this.mUninstallContainer.setVisibility(0);
      }
      if (this.mCancel != null)
      {
        setStates(this.mCancelContainer, this.mCancel, true, false, false);
        this.mCancel.setVisibility(0);
      }
      if (this.mAddToPersonal != null)
      {
        setStates(this.mAddToPersonalContainer, this.mAddToPersonal, true, false, false);
        this.mAddToPersonal.setVisibility(0);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.mCurrentAnimatorRes != this.mHideAnimatorRes) && (this.mOrientation != getResources().getConfiguration().orientation))
    {
      this.mOrientation = getResources().getConfiguration().orientation;
      setInitialAnimationParameter();
      setAnimatorsForOrientation();
      setDrawablesForOrientation();
    }
    if (paramAnimator.getDuration() > 0L)
    {
      onAnimationRepeat(null);
      setLayerType(2, Launcher.sViewLayerPaint);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    setInitialAnimationParameter();
    setAnimatorsForOrientation();
    setDrawablesForOrientation();
  }
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if (Launcher.isInValidDragState(paramDragEvent)) {
      return false;
    }
    Object localObject;
    boolean bool2;
    BaseItem localBaseItem;
    if (paramDragEvent.getLocalState() != null)
    {
      localObject = paramDragEvent.getLocalState();
      bool2 = bool3;
      if ((localObject instanceof DragState))
      {
        localObject = (DragState)localObject;
        localBaseItem = ((DragState)localObject).getItem();
        bool2 = bool3;
        if (localBaseItem != null)
        {
          if (paramView != this.mAppInfoContainer) {
            break label136;
          }
          if (!Launcher.isHelpAppRunning) {
            break label123;
          }
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (paramDragEvent.getAction() == 4)
      {
        ((DragState)localObject).onEnd();
        bool2 = bool1;
        if (Launcher.dragstate != null)
        {
          Launcher.dragstate.onEnd();
          bool2 = bool1;
        }
      }
      return bool2;
      localObject = Launcher.dragstate;
      break;
      label123:
      bool1 = appInfo(localBaseItem, (DragState)localObject, paramDragEvent);
      continue;
      label136:
      if (paramView == this.mDeleteContainer)
      {
        if (Launcher.isHelpAppRunning)
        {
          if ((GuideFragment.GMode.equals("addapps")) || (GuideFragment.GMode.equals("add_widgets")) || (GuideFragment.GMode.equals("create_folder")) || (GuideFragment.GMode.equals("resize_widgets")) || (GuideFragment.GMode.equals("move_app"))) {
            bool1 = false;
          } else {
            bool1 = delete(localBaseItem, (DragState)localObject, paramDragEvent);
          }
        }
        else {
          bool1 = delete(localBaseItem, (DragState)localObject, paramDragEvent);
        }
      }
      else if (paramView == this.mNewFolderContainer) {
        bool1 = newFolder(localBaseItem, (DragState)localObject, paramDragEvent);
      } else if (paramView == this.mDisableContainer)
      {
        if (Launcher.isHelpAppRunning) {
          bool1 = false;
        } else {
          bool1 = disable(localBaseItem, (DragState)localObject, paramDragEvent);
        }
      }
      else if (paramView == this.mUninstallContainer) {
        bool1 = uninstall(localBaseItem, (DragState)localObject, paramDragEvent);
      } else if (paramView == this.mCancelContainer)
      {
        if (Launcher.isHelpAppRunning) {
          bool1 = false;
        } else {
          bool1 = cancel(localBaseItem, (DragState)localObject, paramDragEvent);
        }
      }
      else if (paramView == this.mAddToPersonalContainer) {
        bool1 = addToPersonal(localBaseItem, (DragState)localObject, paramDragEvent);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    Object localObject1 = (FrameLayout)findViewById(2131689540);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (TextView)findViewById(2131689541);
      if (localObject2 != null)
      {
        this.mAppInfoContainer = ((FrameLayout)localObject1);
        this.mAppInfo = ((TextView)localObject2);
        this.mAppInfoContainer.setOnDragListener(this);
        this.mAppInfoDrawable = findFirstDrawable(this.mAppInfo);
        if (this.mAppInfoDrawable != null) {
          this.mAppInfoDrawable = new AppInfoDrawable(getContext(), this.mAppInfoDrawable);
        }
      }
    }
    localObject1 = (FrameLayout)findViewById(2131689550);
    if (localObject1 != null)
    {
      localObject2 = (TextView)findViewById(2131689517);
      if (localObject2 != null)
      {
        this.mDeleteContainer = ((FrameLayout)localObject1);
        this.mDelete = ((TextView)localObject2);
        this.mDeleteContainer.setOnDragListener(this);
        this.mDeleteDrawable = findFirstDrawable(this.mDelete);
        if (this.mDeleteDrawable != null)
        {
          localObject1 = getContext().getResources().getDrawable(2130837806);
          localObject2 = getContext().getResources().getDrawable(2130837815);
          this.mDeleteDrawable = new DeleteDrawable(getContext(), this.mDeleteDrawable, (Drawable)localObject1, (Drawable)localObject2, true, null);
        }
      }
    }
    localObject1 = (FrameLayout)findViewById(2131689538);
    if (localObject1 != null)
    {
      localObject2 = (TextView)findViewById(2131689539);
      if (localObject2 != null)
      {
        this.mNewFolderContainer = ((FrameLayout)localObject1);
        this.mNewFolder = ((TextView)localObject2);
        this.mNewFolderContainer.setOnDragListener(this);
        this.mNewFolderDrawable = findFirstDrawable(this.mNewFolder);
        if (this.mNewFolderDrawable != null) {
          this.mNewFolderDrawable = new NewFolderDrawable(getContext(), this.mNewFolderDrawable);
        }
      }
    }
    localObject1 = (FrameLayout)findViewById(2131689542);
    if (localObject1 != null)
    {
      localObject2 = (TextView)findViewById(2131689543);
      if (localObject2 != null)
      {
        this.mDisableContainer = ((FrameLayout)localObject1);
        this.mDisable = ((TextView)localObject2);
        this.mDisableContainer.setOnDragListener(this);
        this.mDisableDrawable = findFirstDrawable(this.mDisable);
        if (this.mDisableDrawable != null)
        {
          localObject1 = getContext().getResources().getDrawable(2130837818);
          localObject2 = getContext().getResources().getDrawable(2130837833);
          this.mDisableDrawable = new DeleteDrawable(getContext(), this.mDisableDrawable, (Drawable)localObject1, (Drawable)localObject2, false, null);
        }
      }
    }
    localObject1 = (FrameLayout)findViewById(2131689544);
    if (localObject1 != null)
    {
      localObject2 = (TextView)findViewById(2131689545);
      if (localObject2 != null)
      {
        this.mUninstallContainer = ((FrameLayout)localObject1);
        this.mUninstall = ((TextView)localObject2);
        this.mUninstallContainer.setOnDragListener(this);
        this.mUninstallDrawable = findFirstDrawable(this.mUninstall);
        if (this.mUninstallDrawable != null)
        {
          localObject1 = getContext().getResources().getDrawable(2130837825);
          localObject2 = getContext().getResources().getDrawable(2130837833);
          this.mUninstallDrawable = new DeleteDrawable(getContext(), this.mUninstallDrawable, (Drawable)localObject1, (Drawable)localObject2, false, null);
        }
      }
    }
    localObject1 = (FrameLayout)findViewById(2131689546);
    if (localObject1 != null)
    {
      localObject2 = (TextView)findViewById(2131689547);
      if (localObject2 != null)
      {
        this.mAddToPersonalContainer = ((FrameLayout)localObject1);
        this.mAddToPersonal = ((TextView)localObject2);
        this.mAddToPersonalContainer.setOnDragListener(this);
        this.mAddToPersonalDrawable = findFirstDrawable(this.mAddToPersonal);
        if (this.mAddToPersonalDrawable != null) {
          this.mAddToPersonalDrawable = new AddToPersonalDrawable(this.mAddToPersonalDrawable);
        }
      }
    }
    localObject1 = (FrameLayout)findViewById(2131689548);
    if (localObject1 != null)
    {
      localObject2 = (TextView)findViewById(2131689549);
      if (localObject2 != null)
      {
        this.mCancelContainer = ((FrameLayout)localObject1);
        this.mCancel = ((TextView)localObject2);
        this.mCancelContainer.setOnDragListener(this);
        this.mCancelDrawable = findFirstDrawable(this.mCancel);
        if (this.mCancelDrawable != null) {
          this.mCancelDrawable = new CancelDrawable(getContext(), this.mCancelDrawable);
        }
      }
    }
    this.mOrientation = getResources().getConfiguration().orientation;
    setAnimatorsForOrientation();
    setDrawablesForOrientation();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeEditBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */