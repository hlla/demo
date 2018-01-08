package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import java.util.Iterator;
import java.util.List;

public class AppFolderRemoveDialog
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private static List<AppItem> mFolders;
  private static boolean mFromDrag = true;
  private static final String sFragmentTag = "AppFolderRemoveDialog";
  
  private void animateInItem(final BaseItem paramBaseItem, final CellLayout paramCellLayout, int paramInt)
  {
    if (!mFromDrag) {}
    do
    {
      return;
      paramBaseItem = (AppIconView)paramCellLayout.getChildrenLayout().getChildAt(paramBaseItem);
    } while (paramBaseItem == null);
    paramBaseItem.setVisibility(4);
    paramBaseItem.postDelayed(new Runnable()
    {
      public void run()
      {
        final AnimationLayer.Anim localAnim = this.val$al.buildBasicAnim(0, null, paramBaseItem, paramBaseItem.getIcon(), -1);
        int[] arrayOfInt = this.val$al.getLocationOfView(paramBaseItem, paramBaseItem.getIcon());
        localAnim.getIcon().setTranslationX(arrayOfInt[0]);
        localAnim.getIcon().setTranslationY(arrayOfInt[1]);
        localAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
            localAnim.mAnimIcon.setAlpha(f);
            f = AppFolderRemoveDialog.1.this.val$cellLayout.getScaleX() * f;
            localAnim.mAnimIcon.setScaleX(f);
            localAnim.mAnimIcon.setScaleY(f);
          }
        }, true);
        localAnim.getAnimator().addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppFolderRemoveDialog.1.this.val$v.setVisibility(0);
            AppFolderRemoveDialog.1.this.val$v.startFadeShadow();
            AppFolderRemoveDialog.1.this.val$v.mDrawIcon = true;
          }
        });
        localAnim.getAnimator().setDuration(300L);
        localAnim.getAnimator().start();
      }
    }, paramInt);
  }
  
  private void cancelDeletes()
  {
    mFolders.clear();
    mFolders = null;
    MenuAppModel.INSTANCE.setFolderToDelete(null);
    Object localObject = (Launcher)getActivity();
    if ((localObject == null) || (((Launcher)localObject).getMenuView() == null)) {
      return;
    }
    localObject = ((Launcher)localObject).getMenuView().getMenuAppsGrid();
    if (localObject != null)
    {
      ((MenuAppsGrid)localObject).syncPages();
      ((MenuAppsGrid)localObject).getMenuAppsGridFragment().changeState(MenuAppsGrid.State.NORMAL);
    }
    MenuAppModel.INSTANCE.editCommit();
  }
  
  static void createAndShow(AppFolderItem paramAppFolderItem, FragmentManager paramFragmentManager)
  {
    if (isActive(paramFragmentManager)) {
      return;
    }
    MenuAppModel.INSTANCE.setFolderToDelete(paramAppFolderItem);
    new AppFolderRemoveDialog().show(paramFragmentManager, "AppFolderRemoveDialog");
  }
  
  static void createAndShow(AppFolderItem paramAppFolderItem, FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    mFromDrag = false;
    createAndShow(paramAppFolderItem, paramFragmentManager);
  }
  
  static void createAndShow(List<AppItem> paramList, FragmentManager paramFragmentManager)
  {
    mFromDrag = false;
    if (isActive(paramFragmentManager)) {
      return;
    }
    mFolders = paramList;
    new AppFolderRemoveDialog().show(paramFragmentManager, "AppFolderRemoveDialog");
    MenuAppModel.INSTANCE.editBegin();
  }
  
  static void dismiss(FragmentTransaction paramFragmentTransaction, FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("AppFolderRemoveDialog");
    if (paramFragmentManager != null)
    {
      paramFragmentManager.dismiss();
      paramFragmentTransaction.remove(paramFragmentManager);
    }
  }
  
  static AppFolderRemoveDialog getCurrentInstance(FragmentManager paramFragmentManager)
  {
    return (AppFolderRemoveDialog)paramFragmentManager.findFragmentByTag("AppFolderRemoveDialog");
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return paramFragmentManager.findFragmentByTag("AppFolderRemoveDialog") != null;
  }
  
  private void removeFolder()
  {
    Object localObject2 = MenuAppModel.INSTANCE.getFolderToDelete();
    Object localObject3 = ((Launcher)getActivity()).getMenuView();
    Object localObject1 = ((MenuView)localObject3).getMenuAppsGrid();
    localObject2 = ((AppFolderItem)localObject2).getAllItems();
    MenuAppModel.INSTANCE.editRemoveFolder();
    ((MenuView)localObject3).appModelUpdated();
    int i;
    int j;
    if ((!((List)localObject2).isEmpty()) && (localObject1 != null))
    {
      ((MenuAppsGrid)localObject1).getCurrentPage();
      localObject3 = ((MenuView)localObject3).getViewType();
      if (MenuView.ViewType.ALPHABETIC_GRID != localObject3) {
        break label203;
      }
      i = ((MenuAppsGrid)localObject1).getPageIndexForItemId(((AppItem)((List)localObject2).get(0)).mId);
      j = 0;
      if (((MenuAppsGrid)localObject1).getCurrentPage() != i)
      {
        ((MenuAppsGrid)localObject1).snapToPage(i);
        j = ((MenuAppsGrid)localObject1).PAGE_SNAP_ANIMATION_DURATION + 10;
      }
      localObject1 = (CellLayout)((MenuAppsGrid)localObject1).getPageAt(i);
      if (localObject1 != null) {
        break label213;
      }
      Log.e("AppFolderRemoveDialog", "cellLayout is null. index : " + i + ", item 0 :" + ((AppItem)((List)localObject2).get(0)).mId + "/" + ((AppItem)((List)localObject2).get(0)).mTitle);
    }
    for (;;)
    {
      return;
      label203:
      i = ((MenuAppsGrid)localObject1).getPageCount() - 1;
      break;
      label213:
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        animateInItem((AppItem)((Iterator)localObject2).next(), (CellLayout)localObject1, j);
      }
    }
  }
  
  private void removeFolders()
  {
    Iterator localIterator = mFolders.iterator();
    while (localIterator.hasNext())
    {
      AppItem localAppItem = (AppItem)localIterator.next();
      MenuAppModel.INSTANCE.setFolderToDelete((AppFolderItem)localAppItem);
      MenuAppModel.INSTANCE.editRemoveFolder();
    }
    ((Launcher)getActivity()).getMenuView().appModelUpdated();
  }
  
  public void cancelDelete()
  {
    AppFolderItem localAppFolderItem = MenuAppModel.INSTANCE.getFolderToDelete();
    if (localAppFolderItem == null) {}
    Object localObject;
    CellLayout localCellLayout;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (Launcher)getActivity();
        } while ((localObject == null) || (((Launcher)localObject).getMenuView() == null));
        localObject = ((Launcher)localObject).getMenuView().getMenuAppsGrid();
        MenuAppModel.INSTANCE.setFolderToDelete(null);
      } while (localObject == null);
      if (!((MenuAppsGrid)localObject).allowCustomOrdering()) {
        break;
      }
      localCellLayout = (CellLayout)((MenuAppsGrid)localObject).getPageAt(localAppFolderItem.mScreen);
      localCellLayout.addItem(localAppFolderItem);
    } while (((MenuAppsGrid)localObject).getCurrentPage() != localAppFolderItem.mScreen);
    animateInItem(localAppFolderItem, localCellLayout, 0);
    return;
    ((MenuAppsGrid)localObject).syncPages();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      if (mFolders == null) {
        removeFolder();
      }
    }
    else {
      return;
    }
    removeFolders();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new AlertDialog.Builder(getActivity()).setTitle(2131755019).setMessage(2131755020).setPositiveButton(2131755021, this).setNegativeButton(2131755022, this).create();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (mFolders == null) {
      cancelDelete();
    }
    for (;;)
    {
      super.onDismiss(paramDialogInterface);
      return;
      cancelDeletes();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AppFolderRemoveDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */