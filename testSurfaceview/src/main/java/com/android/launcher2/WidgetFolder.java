package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WidgetFolder
  extends LinearLayout
  implements ViewTreeObserver.OnTouchModeChangeListener
{
  private static final boolean DEBUGGABLE = Utilities.DEBUGGABLE();
  private static final String TAG = WidgetFolder.class.getSimpleName();
  public final View.OnKeyListener MENU_WIDGET_FOLDER_TITLE_LISTENER = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      int i = 1;
      if (paramAnonymousKeyEvent.getAction() != 1) {}
      for (;;)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return false;
          i = 0;
        }
      }
      if ((i != 0) && (WidgetFolder.this.mOpenWidgetGrid != null))
      {
        paramAnonymousView = WidgetFolder.this.mOpenWidgetGrid.getChildAt(0);
        if (paramAnonymousView != null) {
          paramAnonymousView.requestFocus();
        }
      }
      return true;
    }
  };
  int[] folderLocation = new int[2];
  int[] iconLocation = new int[2];
  private boolean isOpened = false;
  private int mCellCountX;
  private int mCellCountY;
  int mExpandDuration;
  private int mFolderViewIndex;
  private LayoutInflater mLayoutInflater;
  private MenuWidgets mMenuWidgets;
  MenuWidgets.MenuWidgetsFolderMgr mMenuWidgetsFolderMgr;
  private GridLayout mOpenWidgetGrid;
  ViewGroup mOtherParent;
  private int mPageRequested;
  private int mPreviewHeight;
  private int mPreviewWidth;
  private List<AppsCustomizeAsyncTask> mRunningTasks;
  private TextView mTitle;
  private Drawable mUninstallOverlay;
  private ArrayList<AvailableWidget> mWidgetFolderAvailableItems;
  private ArrayList<PagedViewWidget> mWidgetFolderItems;
  private WidgetFolderView mWidgetFolderView;
  
  public WidgetFolder(Context paramContext)
  {
    super(paramContext);
  }
  
  public WidgetFolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WidgetFolder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void calculateFolderViewIndex()
  {
    int j = this.mCellCountX;
    int k = this.mCellCountY;
    int i = this.mMenuWidgets.mCellCountX * this.mMenuWidgets.mCellCountY;
    j = this.mMenuWidgets.getCurrentPage() * (j * k) + this.mFolderViewIndex;
    this.mPageRequested = (j / i);
    this.mFolderViewIndex = (j % i);
  }
  
  private void createFolderItems()
  {
    ArrayList localArrayList = this.mWidgetFolderAvailableItems;
    Log.i(TAG, " Creating Widget View");
    int i = 0;
    if (i < localArrayList.size())
    {
      localObject1 = (AvailableWidget)localArrayList.get(i);
      PagedViewWidget localPagedViewWidget = (PagedViewWidget)this.mLayoutInflater.inflate(2130903043, this.mOpenWidgetGrid, false);
      Log.i(TAG, "New PagedViewWidget " + localPagedViewWidget + " for " + localObject1 + "(" + ((AvailableWidget)localObject1).getLabel() + ")");
      localPagedViewWidget.applyLabel(((AvailableWidget)localObject1).getLabel());
      Object localObject2 = new int[2];
      ((AvailableWidget)localObject1).getCellSpan((int[])localObject2);
      localPagedViewWidget.applyCellSpan(localObject2[0], localObject2[1]);
      localPagedViewWidget.setTag(((AvailableWidget)localObject1).createHomePendingItem());
      localPagedViewWidget.setOnClickListener(this.mMenuWidgets);
      localPagedViewWidget.setOnLongClickListener(this.mMenuWidgets);
      localPagedViewWidget.setOnTouchListener(this.mMenuWidgets);
      localPagedViewWidget.setOnKeyListener(FocusHelper.WIDGET_FOLDER_WIDGET_ITEM_LISTENER);
      int k = i % this.mCellCountX;
      int m = i / this.mCellCountX;
      localObject2 = new GridLayout.LayoutParams(GridLayout.spec(m, GridLayout.START), GridLayout.spec(k, GridLayout.TOP));
      ((GridLayout.LayoutParams)localObject2).setGravity(8388659);
      if (getResources().getConfiguration().getLayoutDirection() == 1) {
        if (k > 0)
        {
          j = this.mMenuWidgets.mCellGapX;
          label272:
          ((GridLayout.LayoutParams)localObject2).rightMargin = j;
          if (m <= 0) {
            break label422;
          }
        }
      }
      label422:
      for (int j = this.mMenuWidgets.mCellGapY;; j = 0)
      {
        ((GridLayout.LayoutParams)localObject2).topMargin = j;
        Log.d(TAG, ((AvailableWidget)localObject1).getLabel() + "; row: " + m + ", col: " + k + ", lm: " + ((GridLayout.LayoutParams)localObject2).leftMargin + ", tm: " + ((GridLayout.LayoutParams)localObject2).topMargin);
        this.mOpenWidgetGrid.addView(localPagedViewWidget, (ViewGroup.LayoutParams)localObject2);
        i += 1;
        break;
        j = 0;
        break label272;
        if (k > 0) {}
        for (j = this.mMenuWidgets.mCellGapX;; j = 0)
        {
          ((GridLayout.LayoutParams)localObject2).leftMargin = j;
          break;
        }
      }
    }
    this.mOpenWidgetGrid.setColumnCount(this.mCellCountX);
    Object localObject1 = new BitmapLoaderRunnable(this.mOpenWidgetGrid, 0, localArrayList, true);
    Log.i(TAG, "Running runnable instantly " + localObject1 + " page " + 0 + " items " + localArrayList.size());
    ((BitmapLoaderRunnable)localObject1).run();
    if (this.mMenuWidgets.getWidgetState() == MenuWidgets.WidgetState.UNINSTALL) {
      refreshModel();
    }
  }
  
  private void createPagedViewWidgetList()
  {
    int i = 0;
    while (i < this.mWidgetFolderAvailableItems.size())
    {
      AvailableWidget localAvailableWidget = (AvailableWidget)this.mWidgetFolderAvailableItems.get(i);
      PagedViewWidget localPagedViewWidget = (PagedViewWidget)this.mLayoutInflater.inflate(2130903043, this.mOpenWidgetGrid, false);
      localPagedViewWidget.applyLabel(localAvailableWidget.getLabel());
      int[] arrayOfInt = new int[2];
      localAvailableWidget.getCellSpan(arrayOfInt);
      localPagedViewWidget.applyCellSpan(arrayOfInt[0], arrayOfInt[1]);
      localPagedViewWidget.setTag(localAvailableWidget.createHomePendingItem());
      this.mWidgetFolderItems.add(localPagedViewWidget);
      i += 1;
    }
  }
  
  private int getFolderWidth()
  {
    if (this.mWidgetFolderItems.size() > this.mCellCountX) {}
    for (int i = this.mCellCountX;; i = this.mWidgetFolderItems.size()) {
      return this.mPreviewWidth * i + (i - 1) * this.mMenuWidgets.mCellGapX + getResources().getDimensionPixelSize(2131624047) + getResources().getDimensionPixelSize(2131624048);
    }
  }
  
  private int getNumberOfRows()
  {
    if (this.mWidgetFolderItems.size() > this.mCellCountX) {
      return this.mWidgetFolderItems.size() / this.mCellCountX + this.mWidgetFolderItems.size() % this.mCellCountX;
    }
    return 1;
  }
  
  private int getThreadPriorityForPage(int paramInt)
  {
    int i = 0;
    int j = Math.abs(paramInt + 0);
    if (j <= 0) {
      paramInt = -1;
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (j > 1);
    return 0;
  }
  
  private void layoutChildren()
  {
    ArrayList localArrayList = this.mWidgetFolderAvailableItems;
    int k = this.mOpenWidgetGrid.getChildCount();
    int i = 0;
    if (i < k)
    {
      Object localObject1 = (AvailableWidget)localArrayList.get(i);
      PagedViewWidget localPagedViewWidget = (PagedViewWidget)this.mOpenWidgetGrid.getChildAt(i);
      localPagedViewWidget.applyLabel(((AvailableWidget)localObject1).getLabel());
      Object localObject2 = new int[2];
      ((AvailableWidget)localObject1).getCellSpan((int[])localObject2);
      localPagedViewWidget.applyCellSpan(localObject2[0], localObject2[1]);
      localPagedViewWidget.setTag(((AvailableWidget)localObject1).createHomePendingItem());
      localPagedViewWidget.setOnClickListener(this.mMenuWidgets);
      localPagedViewWidget.setOnLongClickListener(this.mMenuWidgets);
      localPagedViewWidget.setOnTouchListener(this.mMenuWidgets);
      localPagedViewWidget.setOnKeyListener(FocusHelper.WIDGET_FOLDER_WIDGET_ITEM_LISTENER);
      localObject1 = (View)((ImageView)localPagedViewWidget.findViewById(2131689495)).getParent();
      localObject2 = ((View)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = this.mPreviewWidth;
      ((ViewGroup.LayoutParams)localObject2).height = this.mPreviewHeight;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      int j = i % this.mCellCountX;
      int m = i / this.mCellCountX;
      localObject1 = (GridLayout.LayoutParams)localPagedViewWidget.getLayoutParams();
      if (getResources().getConfiguration().getLayoutDirection() == 1) {
        if (j > 0)
        {
          j = this.mMenuWidgets.mCellGapX;
          label233:
          ((GridLayout.LayoutParams)localObject1).rightMargin = j;
          if (m <= 0) {
            break label325;
          }
        }
      }
      label325:
      for (j = this.mMenuWidgets.mCellGapY;; j = 0)
      {
        ((GridLayout.LayoutParams)localObject1).topMargin = j;
        ((GridLayout.LayoutParams)localObject1).columnSpec = GridLayout.spec(Integer.MIN_VALUE);
        ((GridLayout.LayoutParams)localObject1).rowSpec = GridLayout.spec(Integer.MIN_VALUE);
        localPagedViewWidget.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        i += 1;
        break;
        j = 0;
        break label233;
        if (j > 0) {}
        for (j = this.mMenuWidgets.mCellGapX;; j = 0)
        {
          ((GridLayout.LayoutParams)localObject1).leftMargin = j;
          break;
        }
      }
    }
    this.mOpenWidgetGrid.setColumnCount(this.mCellCountX);
    if (this.mMenuWidgets.getWidgetState() == MenuWidgets.WidgetState.UNINSTALL) {
      refreshModel();
    }
  }
  
  private void loadWidgetPreviewsInBackground(String paramString, AppsCustomizeAsyncTask paramAppsCustomizeAsyncTask, AsyncTaskPageData paramAsyncTaskPageData)
  {
    if (paramAsyncTaskPageData == null) {}
    label264:
    for (;;)
    {
      return;
      Log.i(TAG, "loadWidgetPreviewsInBackground who: " + paramString + " page: " + paramAsyncTaskPageData.page + " thread: " + Thread.currentThread().getId() + " data: " + paramAsyncTaskPageData + " items: " + paramAsyncTaskPageData.items.size());
      if (paramAppsCustomizeAsyncTask != null) {
        paramAppsCustomizeAsyncTask.syncThreadPriority();
      }
      paramString = paramAsyncTaskPageData.generatedImages;
      int i = paramAsyncTaskPageData.cellWidth;
      int j = paramAsyncTaskPageData.cellHeight;
      paramAsyncTaskPageData = paramAsyncTaskPageData.items.iterator();
      for (;;)
      {
        if (!paramAsyncTaskPageData.hasNext()) {
          break label264;
        }
        Object localObject = paramAsyncTaskPageData.next();
        if ((localObject instanceof ArrayList)) {
          paramString.add(null);
        }
        if ((localObject instanceof AvailableWidget))
        {
          if (paramAppsCustomizeAsyncTask != null)
          {
            if (paramAppsCustomizeAsyncTask.wasCancelRequested()) {
              break;
            }
            paramAppsCustomizeAsyncTask.syncThreadPriority();
          }
          Bitmap localBitmap = ((AvailableWidget)localObject).getPreview(i, j);
          paramString.add(localBitmap);
          Log.i(TAG, "Got widget preview " + localBitmap + " from widget " + localObject + " (" + ((AvailableWidget)localObject).getLabel() + ")");
        }
      }
    }
  }
  
  private void onSyncWidgetPageItems(String paramString, AsyncTaskPageData paramAsyncTaskPageData)
  {
    if (paramAsyncTaskPageData != null)
    {
      int i = paramAsyncTaskPageData.page;
      Log.i(TAG, "onSyncWidgetPageItems who: " + paramString + " page: " + i + " items: " + paramAsyncTaskPageData.items.size() + " thread: " + Thread.currentThread().getId());
      paramString = paramAsyncTaskPageData.layout;
      if (paramString != null)
      {
        int j = paramAsyncTaskPageData.items.size();
        i = 0;
        if (i < j)
        {
          PagedViewWidget localPagedViewWidget = (PagedViewWidget)paramString.getChildAt(i);
          Object localObject;
          if (localPagedViewWidget != null)
          {
            localObject = (AvailableWidget)paramAsyncTaskPageData.items.get(i);
            if (!this.mMenuWidgets.mSearchString.isEmpty()) {
              break label322;
            }
            localPagedViewWidget.applyLabel(((AvailableWidget)localObject).getLabel());
            label162:
            localObject = (Bitmap)paramAsyncTaskPageData.generatedImages.get(i);
            if (localObject != null) {
              if ((((Bitmap)localObject).getWidth() < paramAsyncTaskPageData.cellWidth) && (((Bitmap)localObject).getHeight() < paramAsyncTaskPageData.cellHeight)) {
                break label344;
              }
            }
          }
          label322:
          label344:
          for (boolean bool = true;; bool = false)
          {
            Log.i(TAG, "About to apply preview " + localObject + " on widget " + localPagedViewWidget + " " + paramAsyncTaskPageData.items.get(i) + " (" + ((AvailableWidget)paramAsyncTaskPageData.items.get(i)).getLabel() + ")");
            localPagedViewWidget.applyPreview(new FastBitmapDrawable((Bitmap)localObject), i, bool, false);
            i += 1;
            break;
            localPagedViewWidget.applyHighLightLabel(((AvailableWidget)localObject).getLabel(), this.mMenuWidgets.mSearchString);
            break label162;
          }
        }
      }
    }
  }
  
  private void prepareForOpenAnimate()
  {
    WidgetFolderView localWidgetFolderView = getFolderView();
    if (localWidgetFolderView != null)
    {
      localWidgetFolderView.getLocationOnScreen(this.iconLocation);
      Object localObject = getCustomLayoutParams();
      ((View)getParent()).getLocationOnScreen(this.folderLocation);
      int[] arrayOfInt = this.folderLocation;
      arrayOfInt[0] += ((HomeView.LayoutParams)localObject).x;
      arrayOfInt = this.folderLocation;
      arrayOfInt[1] += ((HomeView.LayoutParams)localObject).y;
      if ((getParent() instanceof MenuView))
      {
        localObject = new int[2];
        this.mOtherParent.getLocationOnScreen((int[])localObject);
        this.folderLocation[1] = localObject[1];
      }
      setPivotX(this.iconLocation[0] - this.folderLocation[0] + localWidgetFolderView.getWidth() / 2);
      setPivotY(this.iconLocation[1] - this.folderLocation[1] + localWidgetFolderView.getHeight() / 2);
      setScaleX(0.5F);
      setScaleY(0.5F);
      setAlpha(0.5F);
    }
  }
  
  private void prepareLoadWidgetPreviewsTask(GridLayout paramGridLayout, int paramInt1, List<AvailableWidget> paramList, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.mRunningTasks.iterator();
    while (localIterator.hasNext())
    {
      AppsCustomizeAsyncTask localAppsCustomizeAsyncTask = (AppsCustomizeAsyncTask)localIterator.next();
      paramInt4 = localAppsCustomizeAsyncTask.page;
      if (paramInt4 == paramInt1)
      {
        localAppsCustomizeAsyncTask.requestCancel(false);
        localIterator.remove();
      }
      else
      {
        Log.i(TAG, "Task " + localAppsCustomizeAsyncTask + " was not pruned");
        localAppsCustomizeAsyncTask.setThreadPriority(getThreadPriorityForPage(paramInt4));
      }
    }
    paramGridLayout = new AsyncTaskPageData(paramGridLayout, paramInt1, paramList, paramInt2, paramInt3, new WidgetFolder.AsyncTaskPageData.AsyncTaskCallback()new WidgetFolder.AsyncTaskPageData.AsyncTaskCallback
    {
      /* Error */
      public void run(WidgetFolder.AppsCustomizeAsyncTask paramAnonymousAppsCustomizeAsyncTask, WidgetFolder.AsyncTaskPageData paramAnonymousAsyncTaskPageData)
      {
        // Byte code:
        //   0: invokestatic 27	com/android/launcher2/WidgetFolder:access$000	()Ljava/lang/String;
        //   3: astore 4
        //   5: new 29	java/lang/StringBuilder
        //   8: dup
        //   9: invokespecial 30	java/lang/StringBuilder:<init>	()V
        //   12: ldc 32
        //   14: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   17: invokestatic 42	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   20: invokevirtual 46	java/lang/Thread:getId	()J
        //   23: invokevirtual 49	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   26: ldc 51
        //   28: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   31: aload_2
        //   32: getfield 57	com/android/launcher2/WidgetFolder$AsyncTaskPageData:page	I
        //   35: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   38: ldc 62
        //   40: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   43: aload_1
        //   44: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   47: ldc 67
        //   49: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   52: aload_2
        //   53: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   56: ldc 69
        //   58: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   61: aload_2
        //   62: getfield 73	com/android/launcher2/WidgetFolder$AsyncTaskPageData:items	Ljava/util/List;
        //   65: invokeinterface 79 1 0
        //   70: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   73: ldc 81
        //   75: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   78: astore 5
        //   80: aload_1
        //   81: ifnull +76 -> 157
        //   84: aload_1
        //   85: invokevirtual 87	com/android/launcher2/WidgetFolder$AppsCustomizeAsyncTask:wasCancelRequested	()Z
        //   88: invokestatic 93	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   91: astore_3
        //   92: aload 4
        //   94: aload 5
        //   96: aload_3
        //   97: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   100: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   103: invokestatic 102	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
        //   106: pop
        //   107: aload_0
        //   108: getfield 17	com/android/launcher2/WidgetFolder$2:this$0	Lcom/android/launcher2/WidgetFolder;
        //   111: ldc 103
        //   113: aload_1
        //   114: aload_2
        //   115: invokestatic 107	com/android/launcher2/WidgetFolder:access$300	(Lcom/android/launcher2/WidgetFolder;Ljava/lang/String;Lcom/android/launcher2/WidgetFolder$AppsCustomizeAsyncTask;Lcom/android/launcher2/WidgetFolder$AsyncTaskPageData;)V
        //   118: aload_1
        //   119: ifnull +37 -> 156
        //   122: aload_1
        //   123: invokevirtual 87	com/android/launcher2/WidgetFolder$AppsCustomizeAsyncTask:wasCancelRequested	()Z
        //   126: ifeq +30 -> 156
        //   129: aload_2
        //   130: new 29	java/lang/StringBuilder
        //   133: dup
        //   134: invokespecial 30	java/lang/StringBuilder:<init>	()V
        //   137: ldc 109
        //   139: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   142: aload_2
        //   143: getfield 57	com/android/launcher2/WidgetFolder$AsyncTaskPageData:page	I
        //   146: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   149: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   152: iconst_1
        //   153: invokevirtual 113	com/android/launcher2/WidgetFolder$AsyncTaskPageData:cleanup	(Ljava/lang/String;Z)V
        //   156: return
        //   157: ldc 115
        //   159: astore_3
        //   160: goto -68 -> 92
        //   163: astore_3
        //   164: aload_1
        //   165: ifnull +37 -> 202
        //   168: aload_1
        //   169: invokevirtual 87	com/android/launcher2/WidgetFolder$AppsCustomizeAsyncTask:wasCancelRequested	()Z
        //   172: ifeq +30 -> 202
        //   175: aload_2
        //   176: new 29	java/lang/StringBuilder
        //   179: dup
        //   180: invokespecial 30	java/lang/StringBuilder:<init>	()V
        //   183: ldc 109
        //   185: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   188: aload_2
        //   189: getfield 57	com/android/launcher2/WidgetFolder$AsyncTaskPageData:page	I
        //   192: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   195: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   198: iconst_1
        //   199: invokevirtual 113	com/android/launcher2/WidgetFolder$AsyncTaskPageData:cleanup	(Ljava/lang/String;Z)V
        //   202: aload_3
        //   203: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	204	0	this	2
        //   0	204	1	paramAnonymousAppsCustomizeAsyncTask	WidgetFolder.AppsCustomizeAsyncTask
        //   0	204	2	paramAnonymousAsyncTaskPageData	WidgetFolder.AsyncTaskPageData
        //   91	69	3	localObject1	Object
        //   163	40	3	localObject2	Object
        //   3	90	4	str	String
        //   78	17	5	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   107	118	163	finally
      }
    }, new WidgetFolder.AsyncTaskPageData.AsyncTaskCallback()
    {
      public void run(WidgetFolder.AppsCustomizeAsyncTask paramAnonymousAppsCustomizeAsyncTask, WidgetFolder.AsyncTaskPageData paramAnonymousAsyncTaskPageData)
      {
        String str = WidgetFolder.TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("Running B on ").append(Thread.currentThread().getId()).append(" page: ").append(paramAnonymousAsyncTaskPageData.page).append(" task: ").append(paramAnonymousAppsCustomizeAsyncTask).append(" pd: ").append(paramAnonymousAsyncTaskPageData).append(" items: ").append(paramAnonymousAsyncTaskPageData.items.size()).append(" state: ");
        Object localObject1;
        if (paramAnonymousAppsCustomizeAsyncTask != null) {
          localObject1 = Boolean.valueOf(paramAnonymousAppsCustomizeAsyncTask.wasCancelRequested());
        }
        for (;;)
        {
          Log.i(str, localObject1);
          try
          {
            WidgetFolder.this.mRunningTasks.remove(paramAnonymousAppsCustomizeAsyncTask);
            if (paramAnonymousAppsCustomizeAsyncTask != null)
            {
              boolean bool = paramAnonymousAppsCustomizeAsyncTask.wasCancelRequested();
              if (bool)
              {
                return;
                localObject1 = " NULL ";
                continue;
              }
            }
            WidgetFolder.this.onSyncWidgetPageItems("prepareLoadWidgetPreviewsTask", paramAnonymousAsyncTaskPageData);
            return;
          }
          finally
          {
            if (paramAnonymousAppsCustomizeAsyncTask != null) {
              paramAnonymousAsyncTaskPageData.cleanup("B page: " + paramAnonymousAsyncTaskPageData.page, paramAnonymousAppsCustomizeAsyncTask.wasCancelRequested());
            }
          }
        }
      }
    });
    paramList = new AppsCustomizeAsyncTask(paramInt1);
    paramList.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new AsyncTaskPageData[] { paramGridLayout });
    Log.i(TAG, "New AppsCustomizeAsyncTask: " + paramList + " pageData: " + paramGridLayout);
    this.mRunningTasks.add(paramList);
  }
  
  public void animateOpen()
  {
    centerAboutIcon();
    prepareForOpenAnimate();
    this.mMenuWidgetsFolderMgr.onFolderOpen();
    animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        WidgetFolder.this.setLayerType(0, Launcher.sViewLayerPaint);
      }
    }).setDuration(this.mExpandDuration).start();
  }
  
  public void centerAboutIcon()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    View localView = ((PagedViewGridLayout)this.mMenuWidgets.getPageAt(this.mMenuWidgets.getCurrentPage())).getChildAt(this.mFolderViewIndex);
    if (localView == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    Utilities.getLocationWithRespectTo(arrayOfInt, getParent(), localView);
    HomeView.LayoutParams localLayoutParams = getCustomLayoutParams();
    int k = getFolderWidth();
    int i = getNumberOfRows();
    int j = getResources().getInteger(2131492894);
    int n;
    if (j > i)
    {
      j = localView.getHeight();
      int m = this.mMenuWidgets.mCellGapY;
      n = getResources().getDimensionPixelSize(2131624045);
      int i1 = getResources().getDimensionPixelSize(2131624044);
      int i2 = getResources().getDimensionPixelSize(2131624043);
      int i3 = getResources().getDimensionPixelSize(2131624039);
      m = getPaddingTop() + getPaddingBottom() + (j * i + (i - 1) * m + n + i1 + i2 + i3);
      n = (localViewGroup.getWidth() - k) / 2;
      j = arrayOfInt[1] + localView.getHeight() / 2;
      i = j;
      if (j + m > localViewGroup.getBottom() - localViewGroup.getTop()) {
        i = localViewGroup.getBottom() - localViewGroup.getTop() - m;
      }
      localLayoutParams.width = k;
      localLayoutParams.height = m;
      if (getResources().getConfiguration().getLayoutDirection() != 1) {
        break label321;
      }
      localLayoutParams.rightMargin = n;
    }
    for (;;)
    {
      localLayoutParams.topMargin = (getResources().getInteger(2131492892) + i);
      localLayoutParams.x = n;
      localLayoutParams.y = i;
      setLayoutParams(localLayoutParams);
      return;
      i = j;
      break;
      label321:
      localLayoutParams.leftMargin = n;
    }
  }
  
  public boolean close(ViewGroup paramViewGroup)
  {
    setOpened(false);
    paramViewGroup.removeView(this);
    return true;
  }
  
  public void closeFolder()
  {
    this.mMenuWidgetsFolderMgr.onFolderClose();
  }
  
  HomeView.LayoutParams getCustomLayoutParams()
  {
    if ((getLayoutParams() instanceof HomeView.LayoutParams)) {
      return (HomeView.LayoutParams)getLayoutParams();
    }
    HomeView.LayoutParams localLayoutParams = new HomeView.LayoutParams(0, 0);
    localLayoutParams.customPosition = true;
    setLayoutParams(localLayoutParams);
    return localLayoutParams;
  }
  
  public WidgetFolderView getFolderView()
  {
    return this.mWidgetFolderView;
  }
  
  public GridLayout getGridLayout()
  {
    return this.mOpenWidgetGrid;
  }
  
  public boolean isOpened()
  {
    return this.isOpened;
  }
  
  protected void onAttachedToWindow()
  {
    if ((this.mMenuWidgets != null) && (DEBUGGABLE)) {
      Log.i(TAG, "WidgetFolder::onAttachedToWindow" + this.mMenuWidgets.getWidgetState());
    }
    super.onAttachedToWindow();
    getViewTreeObserver().addOnTouchModeChangeListener(this);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    Log.i(TAG, "onConfigurationChanged");
    calculateFolderViewIndex();
    this.mPreviewWidth = getResources().getDimensionPixelSize(2131624237);
    this.mPreviewHeight = getResources().getDimensionPixelSize(2131624238);
    this.mCellCountX = this.mMenuWidgets.mCellCountX;
    this.mCellCountY = this.mMenuWidgets.mCellCountY;
  }
  
  protected void onDetachedFromWindow()
  {
    if ((this.mMenuWidgets != null) && (DEBUGGABLE)) {
      Log.i(TAG, "WidgetFolder::onDetachedFromWindow" + this.mMenuWidgets.getWidgetState());
    }
    super.onDetachedFromWindow();
    getViewTreeObserver().removeOnTouchModeChangeListener(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mWidgetFolderAvailableItems = new ArrayList();
    this.mWidgetFolderItems = new ArrayList();
    this.mLayoutInflater = ((Launcher)getContext()).getLayoutInflater();
    this.mExpandDuration = getResources().getInteger(2131492881);
    if (this.mUninstallOverlay == null) {
      this.mUninstallOverlay = getContext().getResources().getDrawable(2130837738);
    }
    this.mTitle = ((TextView)findViewById(2131689692));
    this.mTitle.setOnKeyListener(this.MENU_WIDGET_FOLDER_TITLE_LISTENER);
    this.mRunningTasks = new ArrayList();
    this.mPreviewWidth = getResources().getDimensionPixelSize(2131624237);
    this.mPreviewHeight = getResources().getDimensionPixelSize(2131624238);
    this.mOpenWidgetGrid = ((GridLayout)findViewById(2131689693));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if (DEBUGGABLE) {
      Log.i(TAG, "WidgetFolder::onTouchModeChanged " + paramBoolean);
    }
    if (!paramBoolean) {
      this.mTitle.requestFocus();
    }
  }
  
  public void open(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, boolean paramBoolean)
  {
    if (this.isOpened) {}
    do
    {
      return;
      setOpened(true);
      if (getParent() != null) {
        ((ViewGroup)getParent()).removeView(this);
      }
      this.mOtherParent = paramViewGroup2;
      paramViewGroup1.addView(this);
      createFolderItems();
      if (this.mOpenWidgetGrid != null)
      {
        paramViewGroup1 = (PagedViewWidget)this.mOpenWidgetGrid.getChildAt(0);
        if (paramViewGroup1 != null) {
          paramViewGroup1.requestFocus();
        }
      }
    } while (!paramBoolean);
    animateOpen();
  }
  
  public void refreshModel()
  {
    GridLayout localGridLayout = (GridLayout)((ViewGroup)((ViewGroup)getChildAt(1)).getChildAt(0)).getChildAt(0);
    int i = localGridLayout.getChildCount() - 1;
    if (i >= 0)
    {
      PagedViewWidget localPagedViewWidget = (PagedViewWidget)localGridLayout.getChildAt(i);
      Object localObject = localPagedViewWidget.getTag();
      if ((localObject instanceof HomePendingItem))
      {
        localObject = (HomePendingItem)localObject;
        if (!this.mMenuWidgets.isUninstallable((HomePendingItem)localObject)) {
          break label122;
        }
        Log.i(TAG, ((HomePendingItem)localObject).mTitle + " is Uninstallable");
        localPagedViewWidget.setOverlay(this.mUninstallOverlay);
      }
      for (;;)
      {
        i -= 1;
        break;
        label122:
        localPagedViewWidget.setOverlay(null);
      }
    }
  }
  
  public void repositionOpenFolder()
  {
    centerAboutIcon();
    postOnAnimation(new Runnable()
    {
      public void run()
      {
        int i;
        if (WidgetFolder.this.getParent() != null)
        {
          i = WidgetFolder.this.mMenuWidgets.getCurrentPage();
          WidgetFolder.this.layoutChildren();
          if (i != WidgetFolder.this.mPageRequested)
          {
            if (WidgetFolder.this.mPageRequested >= i) {
              break label69;
            }
            WidgetFolder.this.mMenuWidgets.snapToPageWithDir(WidgetFolder.this.mPageRequested, 2);
          }
        }
        label69:
        while (WidgetFolder.this.mPageRequested <= i) {
          return;
        }
        WidgetFolder.this.mMenuWidgets.snapToPageWithDir(WidgetFolder.this.mPageRequested, 3);
      }
    });
  }
  
  public void setOpenWidgetFolderTitle(String paramString)
  {
    this.mTitle.setText(paramString);
  }
  
  public void setOpened(boolean paramBoolean)
  {
    this.isOpened = paramBoolean;
  }
  
  public void setWidgetFolderItems(ArrayList<AvailableWidget> paramArrayList, MenuWidgets paramMenuWidgets)
  {
    this.mMenuWidgets = paramMenuWidgets;
    this.mCellCountX = paramMenuWidgets.mCellCountX;
    this.mCellCountY = paramMenuWidgets.mCellCountY;
    this.mWidgetFolderAvailableItems = paramArrayList;
    createPagedViewWidgetList();
  }
  
  public void setWidgetFolderManager(MenuWidgets.MenuWidgetsFolderMgr paramMenuWidgetsFolderMgr)
  {
    this.mMenuWidgetsFolderMgr = paramMenuWidgetsFolderMgr;
  }
  
  public void setWidgetFolderView(WidgetFolderView paramWidgetFolderView)
  {
    this.mWidgetFolderView = paramWidgetFolderView;
  }
  
  public void setWidgetFolderViewIndex(int paramInt)
  {
    this.mFolderViewIndex = paramInt;
  }
  
  private static class AppsCustomizeAsyncTask
    extends AsyncTask<WidgetFolder.AsyncTaskPageData, Void, WidgetFolder.AsyncTaskPageData>
  {
    private boolean mCancelRequested = false;
    final int page;
    private int threadPriority;
    
    AppsCustomizeAsyncTask(int paramInt)
    {
      this.page = paramInt;
      this.threadPriority = 0;
    }
    
    protected WidgetFolder.AsyncTaskPageData doInBackground(WidgetFolder.AsyncTaskPageData... paramVarArgs)
    {
      if (paramVarArgs.length != 1) {
        return null;
      }
      paramVarArgs[0].doInBackgroundCallback.run(this, paramVarArgs[0]);
      return paramVarArgs[0];
    }
    
    protected void onPostExecute(WidgetFolder.AsyncTaskPageData paramAsyncTaskPageData)
    {
      paramAsyncTaskPageData.postExecuteCallback.run(this, paramAsyncTaskPageData);
    }
    
    public boolean requestCancel(boolean paramBoolean)
    {
      Log.i(WidgetFolder.TAG, "requestCancel Task " + this);
      this.mCancelRequested = true;
      return cancel(paramBoolean);
    }
    
    void setThreadPriority(int paramInt)
    {
      this.threadPriority = paramInt;
    }
    
    void syncThreadPriority()
    {
      Process.setThreadPriority(this.threadPriority);
    }
    
    public boolean wasCancelRequested()
    {
      return (this.mCancelRequested) || (isCancelled());
    }
  }
  
  static class AsyncTaskPageData
  {
    final int cellHeight;
    final int cellWidth;
    final AsyncTaskCallback doInBackgroundCallback;
    ArrayList<Bitmap> generatedImages;
    final List<AvailableWidget> items;
    final GridLayout layout;
    final int page;
    final AsyncTaskCallback postExecuteCallback;
    
    AsyncTaskPageData(GridLayout paramGridLayout, int paramInt1, List<AvailableWidget> paramList, int paramInt2, int paramInt3, AsyncTaskCallback paramAsyncTaskCallback1, AsyncTaskCallback paramAsyncTaskCallback2)
    {
      this.page = paramInt1;
      this.layout = paramGridLayout;
      this.items = paramList;
      this.generatedImages = new ArrayList();
      this.cellWidth = paramInt2;
      this.cellHeight = paramInt3;
      this.doInBackgroundCallback = paramAsyncTaskCallback1;
      this.postExecuteCallback = paramAsyncTaskCallback2;
    }
    
    void cleanup(String paramString, boolean paramBoolean)
    {
      Log.i(WidgetFolder.TAG, "Cleanup from " + paramString + " cancelled: " + paramBoolean + " thread: " + Thread.currentThread().getId());
      if (this.generatedImages != null) {
        this.generatedImages.clear();
      }
    }
    
    public static abstract interface AsyncTaskCallback
    {
      public abstract void run(WidgetFolder.AppsCustomizeAsyncTask paramAppsCustomizeAsyncTask, WidgetFolder.AsyncTaskPageData paramAsyncTaskPageData);
    }
  }
  
  private class BitmapLoaderRunnable
    implements Runnable
  {
    final boolean immediate;
    final List<AvailableWidget> items;
    final GridLayout layout;
    final int page;
    
    public BitmapLoaderRunnable(int paramInt, ArrayList<AvailableWidget> paramArrayList, boolean paramBoolean)
    {
      this.page = paramArrayList;
      this.layout = paramInt;
      boolean bool;
      this.immediate = bool;
      this.items = paramBoolean;
    }
    
    public void run()
    {
      Log.i(WidgetFolder.TAG, "Running C " + this + " on " + Thread.currentThread().getId() + " immediate: " + this.immediate + " page: " + this.page);
      if (this.immediate)
      {
        WidgetFolder.AsyncTaskPageData localAsyncTaskPageData = new WidgetFolder.AsyncTaskPageData(this.layout, this.page, this.items, WidgetFolder.this.mPreviewWidth, WidgetFolder.this.mPreviewHeight, null, null);
        WidgetFolder.this.loadWidgetPreviewsInBackground("syncWidgetPageItems", null, localAsyncTaskPageData);
        WidgetFolder.this.onSyncWidgetPageItems("syncWidgetPageItems", localAsyncTaskPageData);
        return;
      }
      WidgetFolder.this.prepareLoadWidgetPreviewsTask(this.layout, this.page, this.items, WidgetFolder.this.mPreviewWidth, WidgetFolder.this.mPreviewHeight, 2);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/WidgetFolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */