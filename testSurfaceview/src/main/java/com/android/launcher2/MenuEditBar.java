package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.feature.FloatingFeature;
import com.sec.android.app.launcher.R.styleable;
import com.sec.dtl.launcher.Talk;
import java.util.List;

public class MenuEditBar
  extends LinearLayout
  implements View.OnDragListener
{
  private static final String TAG = "MenuEditBar";
  private boolean USE_SET_INTEGRATOR_HAPTIC = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_FRAMEWORK_ENABLE_INTEGRATOR_HAPTIC");
  private TextView mAppInfo;
  private FrameLayout mAppInfoContainer;
  private Drawable mAppInfoDrawable;
  private Animator mCurrentAnimator;
  private TextView mDelete;
  private FrameLayout mDeleteContainer;
  private Drawable mDeleteDrawable;
  private String mDeleteText;
  private Drawable mDiableDrawable;
  private TextView mDisable;
  private FrameLayout mDisableContainer;
  private Animator mHideAnimator;
  private MenuAppsGrid mMenuAppsGrid;
  private TextView mNewFolder;
  private FrameLayout mNewFolderContainer;
  private Drawable mNewFolderDrawable;
  private TextView mNewPage;
  private boolean mNewPageAllowed;
  private FrameLayout mNewPageContainer;
  private Drawable mNewPageDrawable;
  private int mPosition;
  private Resources mRes;
  private Animator mShowAnimator;
  private String mUninstallText;
  
  public MenuEditBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MenuEditBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MenuEditBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mRes = paramContext.getResources();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.EditDragBar, paramInt, 0);
    this.mPosition = paramContext.getInt(0, 17);
    paramContext.recycle();
    this.mDeleteText = this.mRes.getString(2131755145);
    this.mUninstallText = this.mRes.getString(2131755059);
  }
  
  private boolean appInfo(BaseItem paramBaseItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    boolean bool;
    if (paramBaseItem.getPackageName() != null)
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
              setStates(this.mAppInfoContainer, this.mAppInfo, bool, false, false);
              return bool;
            } while (!bool);
            setStates(this.mAppInfoContainer, this.mAppInfo, true, true, false);
            Talk.INSTANCE.sayByTalkback(this.mAppInfo, getResources().getString(2131755146), true);
          } while ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn()));
          performHapticFeedback(22165, 1);
          return bool;
          paramBaseItem = paramBaseItem.getPackageName();
        } while (paramBaseItem == null);
        paramBaseItem = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", paramBaseItem, null));
        paramBaseItem.setFlags(276824064);
        ((Activity)getContext()).startActivity(paramBaseItem);
        setStates(this.mAppInfoContainer, this.mAppInfo, true, true, true);
      } while ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn()));
      performHapticFeedback(25687, 1);
      return bool;
      paramDragState.onEnd();
    } while (!bool);
    setStates(this.mAppInfoContainer, this.mAppInfo, true, false, false);
    return bool;
  }
  
  private boolean delete(final AppItem paramAppItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    boolean bool;
    if ((paramAppItem.mType == BaseItem.Type.MENU_FOLDER) || ((paramAppItem.mType == BaseItem.Type.MENU_APP) && (!paramAppItem.mSystemApp)))
    {
      bool = true;
      switch (paramDragEvent.getAction())
      {
      }
    }
    label143:
    label199:
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
            setStates(this.mDeleteContainer, this.mDelete, bool, false, false);
            return bool;
          } while (!bool);
          setStates(this.mDeleteContainer, this.mDelete, true, true, true);
          int i;
          if ((paramAppItem.mType == BaseItem.Type.MENU_FOLDER) && (((AppFolderItem)paramAppItem).getItemCount() == 0))
          {
            i = 1;
            if (i == 0) {
              break label199;
            }
            paramDragState.onDropSetEndRunnable(new Runnable()
            {
              public void run()
              {
                MenuAppModel.INSTANCE.setFolderToDelete((AppFolderItem)paramAppItem);
                MenuAppModel.INSTANCE.editRemoveFolder();
                ((Launcher)MenuEditBar.this.getContext()).getMenuView().appModelUpdated();
              }
            });
          }
          while ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn()))
          {
            performHapticFeedback(25687, 1);
            return bool;
            i = 0;
            break label143;
            showDeleteConfirmationDialog(paramAppItem);
            if (paramAppItem.mType == BaseItem.Type.MENU_FOLDER) {
              paramDragState.onDrop();
            }
          }
        } while (!bool);
        setStates(this.mDeleteContainer, this.mDelete, true, true, false);
        Talk.INSTANCE.sayByTalkback(this.mDelete, getResources().getString(2131755145), true);
      } while ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn()));
      performHapticFeedback(22165, 1);
      return bool;
      paramDragState.onEnd();
    } while (!bool);
    setStates(this.mDeleteContainer, this.mDelete, true, false, false);
    return bool;
  }
  
  private boolean disableApp(final AppItem paramAppItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    boolean bool;
    if ((paramAppItem.mType == BaseItem.Type.MENU_FOLDER) || ((paramAppItem.mType == BaseItem.Type.MENU_APP) && (paramAppItem.mSystemApp)))
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
            return bool;
            bool = false;
            break;
            setStates(this.mDisableContainer, this.mDisable, bool, false, false);
            return bool;
          } while (!bool);
          setStates(this.mDisableContainer, this.mDisable, true, true, true);
          if ((paramAppItem.mType == BaseItem.Type.MENU_FOLDER) && (((AppFolderItem)paramAppItem).getItemCount() == 0)) {}
          for (int i = 1; i != 0; i = 0)
          {
            paramDragState.onDropSetEndRunnable(new Runnable()
            {
              public void run()
              {
                MenuAppModel.INSTANCE.setFolderToDelete((AppFolderItem)paramAppItem);
                MenuAppModel.INSTANCE.editRemoveFolder();
                ((Launcher)MenuEditBar.this.getContext()).getMenuView().appModelUpdated();
              }
            });
            return bool;
          }
          showDisableConfirmationDialog(paramAppItem);
        } while (paramAppItem.mType != BaseItem.Type.MENU_FOLDER);
        paramDragState.onDrop();
        return bool;
      } while (!bool);
      setStates(this.mDisableContainer, this.mDisable, true, true, false);
      Talk.INSTANCE.sayByTalkback(this.mDisable, getResources().getString(2131755145), true);
      return bool;
      paramDragState.onEnd();
    } while (!bool);
    setStates(this.mDisableContainer, this.mDisable, true, false, false);
    return bool;
  }
  
  private void hide()
  {
    if ((getVisibility() != 8) && ((this.mCurrentAnimator != this.mHideAnimator) || (!this.mHideAnimator.isStarted())))
    {
      this.mCurrentAnimator = this.mHideAnimator;
      ((Launcher)getContext()).getMenuView().getMenuAppsGrid().hideEditBar(this.mHideAnimator);
    }
  }
  
  private boolean newFolder(AppItem paramAppItem, DragState paramDragState, DragEvent paramDragEvent)
  {
    boolean bool;
    if (paramAppItem.mType == BaseItem.Type.MENU_APP)
    {
      bool = true;
      switch (paramDragEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      break;
      setStates(this.mNewFolderContainer, this.mNewFolder, bool, false, false);
      return bool;
      if (bool)
      {
        this.mMenuAppsGrid.closeFolder(true, false);
        setStates(this.mNewFolderContainer, this.mNewFolder, true, true, true);
        paramDragState.mRevertDrag = true;
        label135:
        int j;
        int k;
        if (this.mMenuAppsGrid.getViewType() == MenuView.ViewType.ALPHABETIC_GRID)
        {
          i = 1;
          j = paramDragState.mOriginalScreen;
          k = paramDragState.mOriginalCell;
          if (i == 0) {
            break label259;
          }
          j = ((AppItem)paramDragState.mItem).getSavedScreen();
          label164:
          if (i == 0) {
            break label262;
          }
        }
        label259:
        label262:
        for (int i = ((AppItem)paramDragState.mItem).getSavedCell();; i = k)
        {
          paramDragEvent = paramDragState.getFolderParent();
          this.mMenuAppsGrid.setPrevFolderOnCreateFolder(paramDragEvent);
          CreateFolderDialog.createAndShow(((Launcher)getContext()).getFragmentManager(), paramAppItem, paramDragState.getContainerType(), -102L, false, false, j, i);
          if ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn())) {
            break;
          }
          performHapticFeedback(25687, 1);
          return bool;
          i = 0;
          break label135;
          break label164;
        }
        if (bool)
        {
          setStates(this.mNewFolderContainer, this.mNewFolder, true, true, false);
          Talk.INSTANCE.sayByTalkback(this.mNewFolder, getResources().getString(2131755143), true);
          if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn()))
          {
            performHapticFeedback(22165, 1);
            return bool;
            if (paramDragEvent.getLocalState() != null) {
              ((DragState)paramDragEvent.getLocalState()).onEnd();
            }
            while (bool)
            {
              setStates(this.mNewFolderContainer, this.mNewFolder, true, false, false);
              return bool;
              if (Launcher.dragstate != null) {
                Launcher.dragstate.onEnd();
              }
            }
          }
        }
      }
    }
  }
  
  private boolean newPage(final AppItem paramAppItem, DragState paramDragState, final DragEvent paramDragEvent)
  {
    if (this.mNewPageAllowed) {
      switch (paramDragEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return this.mNewPageAllowed;
      setStates(this.mNewPageContainer, this.mNewPage, true, true, true);
      paramAppItem.removeFromFolder();
      paramDragEvent = ((Launcher)getContext()).getMenuView();
      int i = paramAppItem.mScreen + 1;
      paramAppItem.mScreen = i;
      MenuAppModel.INSTANCE.editInsertItemOnNewScreen(paramAppItem, i);
      paramDragState.onDropSetEndRunnable(new Runnable()
      {
        public void run()
        {
          Log.d("MenuEditBar", "newPage appModelUpdated");
          paramDragEvent.appModelUpdated();
          MenuAppsGrid localMenuAppsGrid = paramDragEvent.getMenuAppsGrid();
          if (localMenuAppsGrid != null) {
            localMenuAppsGrid.snapToPage(paramAppItem.mScreen);
          }
        }
      });
      if (this.mRes.getBoolean(2131427351)) {
        Toast.makeText(getContext(), getContext().getString(2131755098), 0).show();
      }
      if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn()))
      {
        performHapticFeedback(25687, 1);
        continue;
        setStates(this.mNewPageContainer, this.mNewPage, true, true, false);
        Talk.INSTANCE.sayByTalkback(this.mNewPage, getResources().getString(2131755144), true);
        if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn()))
        {
          performHapticFeedback(22165, 1);
          continue;
          paramDragState.onEnd();
          setStates(this.mNewPageContainer, this.mNewPage, true, false, false);
        }
      }
    }
  }
  
  private void setAnimatorsForOrientation()
  {
    int i;
    int j;
    switch (this.mPosition & 0x3)
    {
    case 1: 
    default: 
      i = 2131034134;
      j = 2131034135;
    }
    for (;;)
    {
      this.mHideAnimator = AnimatorInflater.loadAnimator(getContext(), i);
      this.mHideAnimator.setTarget(this);
      this.mHideAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          MenuEditBar.this.setLayerType(0, Launcher.sViewLayerPaint);
          MenuEditBar.this.setVisibility(8);
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          MenuEditBar.this.setLayerType(2, Launcher.sViewLayerPaint);
        }
      });
      this.mShowAnimator = AnimatorInflater.loadAnimator(getContext(), j);
      this.mShowAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          MenuEditBar.this.setLayerType(0, Launcher.sViewLayerPaint);
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          MenuEditBar.this.setLayerType(2, Launcher.sViewLayerPaint);
        }
      });
      this.mShowAnimator.setTarget(this);
      return;
      i = 2131034126;
      j = 2131034127;
      continue;
      i = 2131034132;
      j = 2131034133;
      continue;
      i = 2131034112;
      j = 2131034113;
    }
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
    setDrawableForOrientation(this.mNewPage, this.mNewPageDrawable, arrayOfDrawable, i);
    setDrawableForOrientation(this.mDisable, this.mDiableDrawable, arrayOfDrawable, i);
  }
  
  private void setStates(FrameLayout paramFrameLayout, TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramFrameLayout.setEnabled(paramBoolean1);
    paramTextView.setEnabled(paramBoolean1);
    paramFrameLayout.setSelected(paramBoolean2);
    paramFrameLayout.setActivated(paramBoolean3);
  }
  
  private void showDeleteConfirmationDialog(AppItem paramAppItem)
  {
    switch (paramAppItem.mType)
    {
    default: 
      return;
    case ???: 
      UninstallConfirmDialogFragment.createAndShow(paramAppItem.mComponentName.getPackageName(), paramAppItem.mTitle, ((Activity)getContext()).getFragmentManager());
      return;
    }
    AppFolderRemoveDialog.createAndShow((AppFolderItem)paramAppItem, ((Activity)getContext()).getFragmentManager());
  }
  
  private void showDisableConfirmationDialog(AppItem paramAppItem)
  {
    switch (paramAppItem.mType)
    {
    default: 
      return;
    }
    ((Launcher)getContext()).callDisableDialog(paramAppItem);
  }
  
  public int getBarPosition()
  {
    return this.mPosition & 0x3;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext().obtainStyledAttributes(2131820580, R.styleable.EditDragBar);
    this.mPosition = paramConfiguration.getInt(0, 17);
    RotateHelper.applyStyle(2131820580, this);
    RotateHelper.applyStyleLayout(2131820580, this);
    paramConfiguration.recycle();
    if (this.mAppInfo != null)
    {
      RotateHelper.applyStyle(2131820571, this.mAppInfo);
      RotateHelper.applyStyleLayout(2131820571, this.mAppInfo);
      RotateHelper.applyStyle(2131820582, this.mAppInfoContainer);
      RotateHelper.applyStyleLayout(2131820582, this.mAppInfoContainer);
    }
    if (this.mDelete != null)
    {
      RotateHelper.applyStyle(2131820571, this.mDelete);
      RotateHelper.applyStyleLayout(2131820571, this.mDelete);
      RotateHelper.applyStyle(2131820581, this.mDeleteContainer);
      RotateHelper.applyStyleLayout(2131820581, this.mDeleteContainer);
    }
    if (this.mNewFolder != null)
    {
      RotateHelper.applyStyle(2131820571, this.mNewFolder);
      RotateHelper.applyStyleLayout(2131820571, this.mNewFolder);
    }
    if (this.mNewPage != null)
    {
      RotateHelper.applyStyle(2131820571, this.mNewPage);
      RotateHelper.applyStyleLayout(2131820571, this.mNewPage);
      RotateHelper.applyStyle(2131820582, this.mNewPageContainer);
      RotateHelper.applyStyleLayout(2131820582, this.mNewPageContainer);
    }
    if (this.mDisable != null)
    {
      RotateHelper.applyStyle(2131820571, this.mDisable);
      RotateHelper.applyStyleLayout(2131820571, this.mDisable);
      RotateHelper.applyStyle(2131820581, this.mDisableContainer);
      RotateHelper.applyStyleLayout(2131820581, this.mDisableContainer);
    }
    setDrawablesForOrientation();
  }
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    Object localObject1;
    int i;
    Object localObject2;
    if (paramDragEvent.getLocalState() != null)
    {
      localObject1 = paramDragEvent.getLocalState();
      if ((localObject1 instanceof DragState))
      {
        localObject1 = (DragState)localObject1;
        i = paramDragEvent.getAction();
        localObject2 = ((DragState)localObject1).getItem();
        if ((localObject2 instanceof AppItem))
        {
          localObject2 = (AppItem)localObject2;
          if (paramView != this.mAppInfoContainer) {
            break label159;
          }
          bool1 = appInfo((BaseItem)localObject2, (DragState)localObject1, paramDragEvent);
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (i == 4)
      {
        ((DragState)localObject1).onEnd();
        if (Launcher.dragstate != null) {
          Launcher.dragstate.onEnd();
        }
        hide();
        bool2 = bool1;
      }
      bool1 = bool2;
      if (i == 5)
      {
        paramView = ((DragState)localObject1).getFolderParent();
        bool1 = bool2;
        if (paramView != null)
        {
          paramView.parentLayoutEntered();
          bool1 = bool2;
        }
      }
      return bool1;
      localObject1 = Launcher.dragstate;
      break;
      label159:
      if (paramView == this.mDeleteContainer)
      {
        bool1 = delete((AppItem)localObject2, (DragState)localObject1, paramDragEvent);
      }
      else if (paramView == this.mNewFolderContainer)
      {
        bool1 = newFolder((AppItem)localObject2, (DragState)localObject1, paramDragEvent);
      }
      else if (paramView == this.mNewPageContainer)
      {
        bool1 = newPage((AppItem)localObject2, (DragState)localObject1, paramDragEvent);
      }
      else
      {
        bool1 = bool3;
        if (paramView == this.mDisableContainer) {
          bool1 = disableApp((AppItem)localObject2, (DragState)localObject1, paramDragEvent);
        }
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
        this.mAppInfoDrawable = HomeEditBar.findFirstDrawable(this.mAppInfo);
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
        this.mDeleteDrawable = HomeEditBar.findFirstDrawable(this.mDelete);
        if (this.mDeleteDrawable != null)
        {
          localObject1 = getContext().getResources().getDrawable(2130837825);
          localObject2 = getContext().getResources().getDrawable(2130837833);
          this.mDeleteDrawable = new DeleteDrawable(getContext(), this.mDeleteDrawable, (Drawable)localObject1, (Drawable)localObject2, false, null);
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
        this.mNewFolderDrawable = HomeEditBar.findFirstDrawable(this.mNewFolder);
        if (this.mNewFolderDrawable != null) {
          this.mNewFolderDrawable = new NewFolderDrawable(getContext(), this.mNewFolderDrawable);
        }
      }
    }
    localObject1 = (FrameLayout)findViewById(2131689637);
    if (localObject1 != null)
    {
      localObject2 = (TextView)findViewById(2131689638);
      if (localObject2 != null)
      {
        this.mNewPageContainer = ((FrameLayout)localObject1);
        this.mNewPage = ((TextView)localObject2);
        this.mNewPageContainer.setOnDragListener(this);
        this.mNewPageDrawable = HomeEditBar.findFirstDrawable(this.mNewPage);
        if (this.mNewPageDrawable != null) {
          this.mNewPageDrawable = new NewPageDrawable(getContext(), this.mNewPageDrawable);
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
        this.mDiableDrawable = HomeEditBar.findFirstDrawable(this.mDisable);
      }
      if (this.mDiableDrawable != null)
      {
        localObject1 = getContext().getResources().getDrawable(2130837818);
        localObject2 = getContext().getResources().getDrawable(2130837815);
        this.mDiableDrawable = new DeleteDrawable(getContext(), this.mDiableDrawable, (Drawable)localObject1, (Drawable)localObject2, false, null);
      }
    }
    setAnimatorsForOrientation();
    setDrawablesForOrientation();
  }
  
  public void show(MenuAppsGrid paramMenuAppsGrid, List<Animator> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (getVisibility() != 0)
    {
      this.mMenuAppsGrid = paramMenuAppsGrid;
      this.mNewPageAllowed = paramBoolean3;
      if (this.mAppInfo != null)
      {
        setStates(this.mAppInfoContainer, this.mAppInfo, paramBoolean1, false, false);
        paramMenuAppsGrid = this.mAppInfoContainer;
        if (!paramBoolean1) {
          break label313;
        }
        i = 0;
        paramMenuAppsGrid.setVisibility(i);
      }
      if (this.mDelete != null)
      {
        TextView localTextView = this.mDelete;
        if (!paramBoolean4) {
          break label320;
        }
        paramMenuAppsGrid = this.mDeleteText;
        label81:
        localTextView.setText(paramMenuAppsGrid);
        paramMenuAppsGrid = this.mDeleteContainer;
        localTextView = this.mDelete;
        if (paramBoolean2) {
          break label328;
        }
        paramBoolean4 = true;
        label106:
        setStates(paramMenuAppsGrid, localTextView, paramBoolean4, false, true);
        paramMenuAppsGrid = this.mDeleteContainer;
        if (!paramBoolean2) {
          break label334;
        }
        i = 8;
        label131:
        paramMenuAppsGrid.setVisibility(i);
      }
      if (this.mNewFolder != null)
      {
        setStates(this.mNewFolderContainer, this.mNewFolder, paramBoolean1, false, false);
        paramMenuAppsGrid = this.mNewFolderContainer;
        if (!paramBoolean1) {
          break label340;
        }
        i = 0;
        label171:
        paramMenuAppsGrid.setVisibility(i);
      }
      if (this.mNewPage != null)
      {
        setStates(this.mNewPageContainer, this.mNewPage, paramBoolean3, false, false);
        paramMenuAppsGrid = this.mNewPageContainer;
        if (!paramBoolean3) {
          break label347;
        }
        i = 0;
        label213:
        paramMenuAppsGrid.setVisibility(i);
      }
      if (this.mDisable != null)
      {
        setStates(this.mDisableContainer, this.mDisable, paramBoolean2, false, true);
        paramMenuAppsGrid = this.mDisableContainer;
        if ((paramBoolean2) || (!Launcher.isSystemAppDisable)) {
          break label354;
        }
      }
    }
    label313:
    label320:
    label328:
    label334:
    label340:
    label347:
    label354:
    for (int i = 8;; i = 0)
    {
      paramMenuAppsGrid.setVisibility(i);
      if ((!Launcher.isSystemAppDisable) || (!paramBoolean5)) {
        this.mDisableContainer.setVisibility(8);
      }
      setVisibility(0);
      this.mCurrentAnimator = this.mShowAnimator;
      paramList.add(this.mShowAnimator);
      return;
      i = 8;
      break;
      paramMenuAppsGrid = this.mUninstallText;
      break label81;
      paramBoolean4 = false;
      break label106;
      i = 0;
      break label131;
      i = 8;
      break label171;
      i = 8;
      break label213;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MenuEditBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */