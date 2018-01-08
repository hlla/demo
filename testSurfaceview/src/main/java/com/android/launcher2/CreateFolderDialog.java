package com.android.launcher2;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.HoverPopupWindow;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.android.launcher2.guide.GuideFragment;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CreateFolderDialog
  extends DialogFragment
  implements DialogInterface.OnClickListener, DialogInterface.OnKeyListener
{
  private static final String FIND_NEW_POS_KEY = "FIND_NEW_POSITION";
  private static final String FOLDER_TITLE_KEY = "FOLDER_TITLE";
  private static final String ITEM_DESTINATION_CONTAINER_ID_KEY = "ITEM_DESTINATION_CONTAINER_ID";
  private static final String ITEM_ID_KEY = "ITEM_ID";
  private static final String ITEM_ORIGIN_CONTAINER_ID_KEY = "ITEM_ORIGIN_CONTAINER_ID";
  private static final String ORIGINAL_CONTAINER_CELL_KEY = "ORIGINAL_CONTAINER_CELL";
  private static final String ORIGINAL_CONTAINER_SCREEN_KEY = "ORIGINAL_CONTAINER_SCREEN";
  private static final String REMOVE_ITEM_KEY = "REMOVE_ITEM";
  static boolean okButtonSelected = false;
  private static final String sFragmentTag = "CreateFolderDialog";
  private Folder.FolderColor color = Folder.FolderColor.FOLDER_DEFAULT;
  Dialog dialog;
  private int mCreateFolderColor = 0;
  LinearLayout mCreateFolderDialog;
  private long mDestinationContainerId = -1L;
  private boolean mDismissDialog = false;
  private boolean mFindNewPosition = false;
  ImageView mFolderAddButton;
  ImageView mFolderAddButtonDivider;
  private BaseItem mFolderChildItem;
  HashMap<Folder.FolderColor, Drawable> mFolderColorDrawables;
  HashMap<Folder.FolderColor, ImageView> mFolderColorViews;
  ImageView mFolderOptionButton;
  LinearLayout mFolderOptionView;
  HashMap<Folder.FolderColor, ColorStateList> mFolderTextColors;
  private EditText mFolderTitle = null;
  private View.OnTouchListener mForlderTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      boolean bool = false;
      if ((4 == paramAnonymousMotionEvent.getAction()) || (paramAnonymousMotionEvent.getActionMasked() == 0)) {
        bool = CreateFolderDialog.this.closeFolderOption((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY(), false);
      }
      return bool;
    }
  };
  private long mItemId = -1L;
  View.OnClickListener mOnColorViewClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      CreateFolderDialog.access$002(CreateFolderDialog.this, CreateFolderDialog.this.getFolderColorByView(paramAnonymousView));
      CreateFolderDialog.this.setFolderColor(CreateFolderDialog.this.color, true);
    }
  };
  private long mOriginContainerId = -1L;
  private int mOriginalContainerCell;
  private int mOriginalContainerScreen;
  private boolean mRemoveItem = false;
  
  private boolean closeFolderOption(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.mFolderOptionView != null) && (this.mFolderOptionView.getVisibility() == 0))
    {
      Point localPoint = new Point(paramInt1, paramInt2);
      Rect localRect = new Rect();
      this.mFolderOptionView.getHitRect(localRect);
      if ((paramBoolean) || (!localRect.contains(localPoint.x, localPoint.y))) {}
    }
    else
    {
      return false;
    }
    this.mFolderTitle.setEnabled(true);
    this.mFolderTitle.setVisibility(0);
    this.mFolderAddButtonDivider.setVisibility(0);
    this.mFolderAddButton.setVisibility(0);
    this.mFolderOptionView.setVisibility(8);
    ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(this.mFolderTitle, 1);
    return true;
  }
  
  static void createAndShow(FragmentManager paramFragmentManager, BaseItem paramBaseItem, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if ((paramFragmentManager == null) || (isActive(paramFragmentManager))) {
      return;
    }
    CreateFolderDialog localCreateFolderDialog = new CreateFolderDialog();
    localCreateFolderDialog.init(paramBaseItem, paramLong1, paramLong2, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
    localCreateFolderDialog.show(paramFragmentManager, "CreateFolderDialog");
  }
  
  static void dismiss(FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("CreateFolderDialog");
    if (paramFragmentManager != null)
    {
      if (paramBoolean) {
        ((CreateFolderDialog)paramFragmentManager).doCreateFolder(paramFragmentManager.getDialog());
      }
    }
    else {
      return;
    }
    paramFragmentManager.dismissAllowingStateLoss();
  }
  
  private void doAddMoreApps(Dialog paramDialog)
  {
    Launcher localLauncher = (Launcher)getActivity();
    if (localLauncher.getHomeView().getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      MenuAppsGrid localMenuAppsGrid = localLauncher.getMenuView().getMenuAppsGrid();
      if (localMenuAppsGrid != null)
      {
        String str = this.mFolderTitle.getText().toString();
        localMenuAppsGrid.setCreateFolderAddButtonFromHomeView(bool);
        localMenuAppsGrid.setFolderTitletoAddButton(str);
        localMenuAppsGrid.setFolderColorToAddButton(this.color.ordinal());
        if (localMenuAppsGrid.getState() == MenuAppsGrid.State.FOLDER_SELECT) {
          localMenuAppsGrid.handleStateChange(MenuAppsGrid.State.NORMAL, MenuAppsGrid.State.FOLDER_SELECT);
        }
        localMenuAppsGrid.resetPreCheckedItems();
        localMenuAppsGrid.setCreateFolderAddButtonState(this.mFolderChildItem);
      }
      if (bool)
      {
        doCreateFolder(paramDialog);
        localLauncher.getMenuView().selectAppsTab();
        localLauncher.showAllApps();
      }
      dismiss();
      return;
    }
  }
  
  private void doCreateFolder(Dialog paramDialog)
  {
    Object localObject4 = (Launcher)getActivity();
    String str = this.mFolderTitle.getText().toString();
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1;
    if (this.mFolderChildItem != null)
    {
      localObject1 = this.mFolderChildItem;
      if ((this.mDestinationContainerId != -100L) && (this.mDestinationContainerId != -101L)) {
        break label372;
      }
      localObject2 = localObject3;
      if (localObject4 != null) {
        localObject2 = ((Launcher)localObject4).mHomeView;
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        if (this.color.toString().equals("FOLDER_DEFAULT")) {
          this.mCreateFolderColor = 0;
        }
        if (this.color.toString().equals("FOLDER_GRAY")) {
          this.mCreateFolderColor = 1;
        }
        if (this.color.toString().equals("FOLDER_RED")) {
          this.mCreateFolderColor = 2;
        }
        if (this.color.toString().equals("FOLDER_YELLOW")) {
          this.mCreateFolderColor = 3;
        }
        if (this.color.toString().equals("FOLDER_GREEN")) {
          this.mCreateFolderColor = 4;
        }
        ((CreateFolderInterface)localObject2).getCreateFolderColor(this.mCreateFolderColor);
        ((CreateFolderInterface)localObject2).onFolderCreated((BaseItem)localObject1, str, this.mDestinationContainerId, this.mRemoveItem, this.mFindNewPosition, this.mOriginalContainerScreen, this.mOriginalContainerCell);
      }
      if (paramDialog != null) {
        paramDialog.dismiss();
      }
      return;
      localObject1 = localObject2;
      if (this.mItemId == -1L) {
        break;
      }
      if ((this.mOriginContainerId == -100L) || (this.mOriginContainerId == -101L))
      {
        localObject1 = ((Launcher)localObject4).mHomeView.findItemById(this.mItemId);
        break;
      }
      if (this.mOriginContainerId == -102L)
      {
        localObject1 = MenuAppModel.INSTANCE.findItemById(this.mItemId);
        break;
      }
      if ((this.mDestinationContainerId == -100L) || (this.mDestinationContainerId == -101L))
      {
        localObject1 = ((Launcher)localObject4).mHomeView.findItemById(this.mItemId);
        break;
      }
      localObject1 = localObject2;
      if (this.mDestinationContainerId != -102L) {
        break;
      }
      localObject1 = MenuAppModel.INSTANCE.findItemById(this.mItemId);
      break;
      label372:
      localObject2 = localObject3;
      if (this.mDestinationContainerId == -102L)
      {
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((Launcher)localObject4).getMenuView();
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = ((MenuView)localObject4).getMenuAppsGrid();
          }
        }
      }
    }
  }
  
  private void init(BaseItem paramBaseItem, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    this.mFolderChildItem = paramBaseItem;
    this.mOriginContainerId = paramLong1;
    if (paramBaseItem != null) {
      this.mItemId = paramBaseItem.mId;
    }
    this.mOriginalContainerScreen = paramInt1;
    this.mOriginalContainerCell = paramInt2;
    this.mDestinationContainerId = paramLong2;
    this.mRemoveItem = paramBoolean1;
    this.mFindNewPosition = paramBoolean2;
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return (paramFragmentManager != null) && (paramFragmentManager.findFragmentByTag("CreateFolderDialog") != null);
  }
  
  private boolean isColorViewFocussed()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (LauncherApplication.sIsFolderColorSupport)
    {
      bool1 = bool2;
      if (this.mFolderColorViews != null)
      {
        Iterator localIterator = this.mFolderColorViews.values().iterator();
        ImageView localImageView;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localImageView = (ImageView)localIterator.next();
        } while ((localImageView == null) || (!localImageView.isFocused()));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void dismissAllowingStateLoss()
  {
    if ((Launcher.isHelpAppRunning) && (!this.mDismissDialog)) {
      return;
    }
    this.mDismissDialog = false;
    super.dismissAllowingStateLoss();
  }
  
  Folder.FolderColor getFolderColorByView(View paramView)
  {
    Folder.FolderColor[] arrayOfFolderColor = Folder.FolderColor.values();
    int j = arrayOfFolderColor.length;
    int i = 0;
    while (i < j)
    {
      Folder.FolderColor localFolderColor = arrayOfFolderColor[i];
      if (((ImageView)this.mFolderColorViews.get(localFolderColor)).equals(paramView)) {
        return localFolderColor;
      }
      i += 1;
    }
    return Folder.FolderColor.FOLDER_DEFAULT;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject4 = (Launcher)getActivity();
    String str;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (paramInt == -1)
    {
      okButtonSelected = true;
      str = this.mFolderTitle.getText().toString();
      localObject2 = null;
      localObject3 = null;
      if (this.mFolderChildItem == null) {
        break label128;
      }
      localObject1 = this.mFolderChildItem;
      if ((this.mDestinationContainerId != -100L) && (this.mDestinationContainerId != -101L)) {
        break label271;
      }
      localObject2 = localObject3;
      if (localObject4 != null) {
        localObject2 = ((Launcher)localObject4).mHomeView;
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        ((CreateFolderInterface)localObject2).onFolderCreated((BaseItem)localObject1, str, this.mDestinationContainerId, this.mRemoveItem, this.mFindNewPosition, this.mOriginalContainerScreen, this.mOriginalContainerCell);
      }
      paramDialogInterface.dismiss();
      return;
      label128:
      localObject1 = localObject2;
      if (this.mItemId == -1L) {
        break;
      }
      if ((this.mOriginContainerId == -100L) || (this.mOriginContainerId == -101L))
      {
        localObject1 = ((Launcher)localObject4).mHomeView.findItemById(this.mItemId);
        break;
      }
      if (this.mOriginContainerId == -102L)
      {
        localObject1 = MenuAppModel.INSTANCE.findItemById(this.mItemId);
        break;
      }
      if ((this.mDestinationContainerId == -100L) || (this.mDestinationContainerId == -101L))
      {
        localObject1 = ((Launcher)localObject4).mHomeView.findItemById(this.mItemId);
        break;
      }
      localObject1 = localObject2;
      if (this.mDestinationContainerId != -102L) {
        break;
      }
      localObject1 = MenuAppModel.INSTANCE.findItemById(this.mItemId);
      break;
      label271:
      localObject2 = localObject3;
      if (this.mDestinationContainerId == -102L)
      {
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((Launcher)localObject4).getMenuView();
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = ((MenuView)localObject4).getMenuAppsGrid();
          }
        }
      }
    }
  }
  
  public Dialog onCreateDialog(final Bundle paramBundle)
  {
    okButtonSelected = false;
    this.dialog = new Dialog(getActivity(), 2131820552);
    this.dialog.setContentView(2130903046);
    final Object localObject3 = this.dialog;
    this.dialog.setCanceledOnTouchOutside(false);
    this.mCreateFolderDialog = ((LinearLayout)((Dialog)localObject3).findViewById(2131689508));
    this.mCreateFolderDialog.setOnTouchListener(this.mForlderTouchListener);
    this.mFolderTitle = ((EditText)((Dialog)localObject3).findViewById(2131689507));
    this.mFolderTitle.setHint(getResources().getString(2131755156));
    this.mFolderTitle.setFilters(Utilities.getEditTextMaxLengthFilter(getActivity(), 30));
    int j = 0;
    int i = j;
    if (paramBundle != null)
    {
      this.mItemId = paramBundle.getLong("ITEM_ID", -1L);
      this.mOriginContainerId = paramBundle.getLong("ITEM_ORIGIN_CONTAINER_ID", -1L);
      this.mDestinationContainerId = paramBundle.getLong("ITEM_DESTINATION_CONTAINER_ID", -1L);
      this.mRemoveItem = paramBundle.getBoolean("REMOVE_ITEM", false);
      this.mFindNewPosition = paramBundle.getBoolean("FIND_NEW_POSITION", true);
      this.mOriginalContainerScreen = paramBundle.getInt("ORIGINAL_CONTAINER_SCREEN");
      this.mOriginalContainerCell = paramBundle.getInt("ORIGINAL_CONTAINER_CELL");
      paramBundle = paramBundle.getString("FOLDER_TITLE", "");
      this.mFolderTitle.setText(paramBundle);
      i = j;
      if (this.mFolderChildItem == null) {
        i = 1;
      }
    }
    paramBundle = ((Dialog)localObject3).findViewById(2131689514);
    Object localObject2;
    label322:
    final Object localObject1;
    if (paramBundle != null)
    {
      if (this.mFolderChildItem != null)
      {
        ((ImageView)((Dialog)localObject3).findViewById(2131689515)).setImageBitmap(this.mFolderChildItem.mIconBitmap);
        ((TextView)((Dialog)localObject3).findViewById(2131689516)).setText(this.mFolderChildItem.mTitle);
        paramBundle.setVisibility(0);
      }
    }
    else
    {
      localObject2 = ((Dialog)localObject3).findViewById(2131689509);
      if (localObject2 != null) {
        break label708;
      }
      paramBundle = null;
      localObject1 = localObject2;
      if (Launcher.getInstance().isFolderCreatedFromMenuButton)
      {
        ((View)localObject2).setVisibility(8);
        localObject1 = null;
        Launcher.getInstance().isFolderCreatedFromMenuButton = false;
      }
      if (localObject1 != null)
      {
        localObject2 = MenuAppModel.INSTANCE.getTopLevelItems();
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label720;
        }
        ((View)localObject1).setVisibility(0);
        if ((paramBundle != null) && (!Launcher.isHelpAppRunning))
        {
          paramBundle.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              CreateFolderDialog.this.doAddMoreApps(CreateFolderDialog.this.dialog);
            }
          });
          paramBundle.setOnKeyListener(new View.OnKeyListener()
          {
            public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              if (paramAnonymousKeyEvent.getKeyCode() == 66)
              {
                CreateFolderDialog.this.doAddMoreApps(CreateFolderDialog.this.dialog);
                return true;
              }
              return false;
            }
          });
        }
      }
    }
    for (;;)
    {
      localObject1 = getResources();
      this.mFolderAddButton = ((ImageView)((Dialog)localObject3).findViewById(2131689510));
      this.mFolderOptionButton = ((ImageView)((Dialog)localObject3).findViewById(2131689512));
      this.mFolderOptionView = ((LinearLayout)((Dialog)localObject3).findViewById(2131689513));
      this.mFolderAddButtonDivider = ((ImageView)((Dialog)localObject3).findViewById(2131689511));
      if (this.mFolderAddButton != null)
      {
        localObject2 = getResources().getString(2131755117);
        localObject3 = Toast.makeText(getActivity(), (CharSequence)localObject2, 0);
        this.mFolderAddButton.setOnLongClickListener(new View.OnLongClickListener()
        {
          public boolean onLongClick(View paramAnonymousView)
          {
            int[] arrayOfInt = new int[2];
            paramAnonymousView.getLocationOnScreen(arrayOfInt);
            int i;
            int j;
            if (localObject1.getConfiguration().orientation == 2)
            {
              i = CreateFolderDialog.this.mCreateFolderDialog.getWidth() / 3;
              j = (int)(arrayOfInt[1] + paramAnonymousView.getHeight() / 2 + CreateFolderDialog.this.getResources().getDimension(2131624055));
              paramAnonymousView = ((Launcher)CreateFolderDialog.this.getActivity()).getMenuView();
              if ((paramAnonymousView == null) || (!paramAnonymousView.isVisible())) {
                break label121;
              }
              localObject3.setGravity(51, i, j);
            }
            for (;;)
            {
              localObject3.show();
              return true;
              i = arrayOfInt[0];
              break;
              label121:
              localObject3.setGravity(53, i, j);
            }
          }
        });
        if (this.mFolderAddButton.getHoverPopupWindow() != null)
        {
          this.mFolderAddButton.setHoverPopupType(1);
          this.mFolderAddButton.getHoverPopupWindow().setContent((CharSequence)localObject2);
          this.mFolderAddButton.getHoverPopupWindow().setPopupGravity(12341);
          this.mFolderAddButton.getHoverPopupWindow().setPopupPosOffset(((Resources)localObject1).getDimensionPixelOffset(2131623962), 25);
          this.mFolderAddButton.getHoverPopupWindow().setFHAnimationEnabled(false);
        }
      }
      if ((Launcher.isHelpAppRunning) && (GuideFragment.GMode.equals("create_folder"))) {
        this.dialog.setOnShowListener(new DialogInterface.OnShowListener()
        {
          public void onShow(DialogInterface paramAnonymousDialogInterface) {}
        });
      }
      this.dialog.getWindow().setSoftInputMode(37);
      this.mFolderTitle.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if (6 == paramAnonymousInt)
          {
            CreateFolderDialog.okButtonSelected = true;
            CreateFolderDialog.this.doCreateFolder(CreateFolderDialog.this.dialog);
            return true;
          }
          return false;
        }
      });
      this.dialog.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if (paramAnonymousKeyEvent.getAction() == 0) {
            switch (paramAnonymousKeyEvent.getKeyCode())
            {
            }
          }
          for (;;)
          {
            return false;
            if (((paramBundle == null) || (!paramBundle.isFocused())) && ((CreateFolderDialog.this.mFolderOptionButton == null) || (!CreateFolderDialog.this.mFolderOptionButton.isFocused())) && (!CreateFolderDialog.this.isColorViewFocussed()))
            {
              CreateFolderDialog.okButtonSelected = true;
              CreateFolderDialog.this.doCreateFolder((Dialog)paramAnonymousDialogInterface);
            }
          }
        }
      });
      if (i != 0) {
        dismiss();
      }
      return this.dialog;
      paramBundle.setVisibility(8);
      break;
      label708:
      paramBundle = ((View)localObject2).findViewById(2131689510);
      break label322;
      label720:
      ((View)localObject1).setVisibility(4);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((Launcher.isHelpAppRunning) && (okButtonSelected)) {
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if ((Launcher)CreateFolderDialog.this.getActivity() != null) {
            ((Launcher)CreateFolderDialog.this.getActivity()).onBackPressed();
          }
        }
      }, 2000L);
    }
    for (;;)
    {
      if (isAdded()) {
        dismiss();
      }
      return;
      if ((Launcher.isHelpAppRunning) && (!okButtonSelected) && ((Launcher)getActivity() != null)) {
        ((Launcher)getActivity()).onBackPressed();
      }
    }
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putLong("ITEM_ID", this.mItemId);
    paramBundle.putLong("ITEM_ORIGIN_CONTAINER_ID", this.mOriginContainerId);
    paramBundle.putLong("ITEM_DESTINATION_CONTAINER_ID", this.mDestinationContainerId);
    paramBundle.putBoolean("REMOVE_ITEM", this.mRemoveItem);
    paramBundle.putBoolean("FIND_NEW_POSITION", this.mFindNewPosition);
    paramBundle.putString("FOLDER_TITLE", this.mFolderTitle.getText().toString());
    paramBundle.putInt("ORIGINAL_CONTAINER_SCREEN", this.mOriginalContainerScreen);
    paramBundle.putInt("ORIGINAL_CONTAINER_CELL", this.mOriginalContainerCell);
  }
  
  public void onStart()
  {
    super.onStart();
    if (!getShowsDialog()) {
      dismissAllowingStateLoss();
    }
  }
  
  public void onStop()
  {
    if (Launcher.isHelpAppRunning)
    {
      this.mDismissDialog = true;
      dismissAllowingStateLoss();
    }
    super.onStop();
  }
  
  void setFolderColor(Folder.FolderColor paramFolderColor, boolean paramBoolean)
  {
    Folder.FolderColor[] arrayOfFolderColor = Folder.FolderColor.values();
    int j = arrayOfFolderColor.length;
    int i = 0;
    if (i < j)
    {
      Folder.FolderColor localFolderColor = arrayOfFolderColor[i];
      ImageView localImageView = (ImageView)this.mFolderColorViews.get(localFolderColor);
      if (localImageView != null)
      {
        if (!paramFolderColor.equals(localFolderColor)) {
          break label74;
        }
        localImageView.setImageDrawable(getResources().getDrawable(2130837569));
      }
      for (;;)
      {
        i += 1;
        break;
        label74:
        localImageView.setImageDrawable(null);
      }
    }
    this.mFolderTitle.setTextColor((ColorStateList)this.mFolderTextColors.get(paramFolderColor));
    i = this.mCreateFolderDialog.getPaddingLeft();
    j = this.mCreateFolderDialog.getPaddingRight();
    int k = this.mCreateFolderDialog.getPaddingTop();
    int m = this.mCreateFolderDialog.getPaddingBottom();
    this.mCreateFolderDialog.setBackground((Drawable)this.mFolderColorDrawables.get(paramFolderColor));
    this.mCreateFolderDialog.setPadding(i, k, j, m);
  }
  
  public static abstract interface CreateFolderInterface
  {
    public abstract void getCreateFolderColor(int paramInt);
    
    public abstract void onFolderCreated(BaseItem paramBaseItem, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CreateFolderDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */