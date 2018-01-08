package com.android.launcher2;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class WidgetFolderView
  extends PagedViewWidget
{
  private ImageView mArrowBtn;
  private Rect mDeleteRegion = new Rect();
  private TextView mDimens;
  private String mDimensionsFormatString;
  private ArrayList<AvailableWidget> mFolderItems;
  private LayoutInflater mLayoutInflater;
  private TextView mTitle;
  private Drawable mUninstallOverlay;
  private WidgetFolder mWidgetFolder;
  private GridLayout mWidgetGridView;
  
  public WidgetFolderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WidgetFolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WidgetFolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setTalkbackDescription(String paramString)
  {
    String str3 = getResources().getString(2131755114);
    String str1;
    if ((paramString == null) || (paramString.isEmpty())) {
      str1 = str3;
    }
    for (;;)
    {
      this.mTitle.setContentDescription(str1);
      return;
      String str2 = "";
      if (paramString.length() >= str3.length()) {
        str2 = paramString.substring(paramString.length() - str3.length());
      }
      str1 = paramString;
      if (!str2.equalsIgnoreCase(str3)) {
        str1 = paramString + " " + str3;
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Utilities.onViewDraw(this, paramCanvas);
    super.draw(paramCanvas);
    Drawable localDrawable = this.mUninstallOverlay;
    if ((localDrawable != null) && (localDrawable.isVisible()))
    {
      localDrawable.mutate();
      int m = this.mUninstallOverlay.getIntrinsicWidth();
      int k = this.mUninstallOverlay.getIntrinsicHeight();
      Rect localRect = new Rect();
      int j = k;
      int i = m;
      if (this.mUninstallOverlay.getPadding(localRect))
      {
        i = m + (localRect.left + localRect.right);
        j = k + (localRect.top + localRect.bottom);
      }
      m = j / 2;
      localRect = new Rect(0, 0, this.mWidgetGridView.getWidth(), this.mWidgetGridView.getHeight());
      offsetDescendantRectToMyCoords(this.mWidgetGridView, localRect);
      int n = localRect.top;
      k = localRect.right - i + getScrollX();
      m = n - m + getScrollY();
      this.mDeleteRegion.set(k, m, k + i, m + j);
      localDrawable.setBounds(this.mDeleteRegion);
      localDrawable.draw(paramCanvas);
    }
  }
  
  public String getWidgetFolderTitle()
  {
    return this.mTitle.getText().toString();
  }
  
  public void hideArrowBtn()
  {
    this.mArrowBtn.setVisibility(8);
  }
  
  public void onFinishInflate()
  {
    this.mTitle = ((TextView)findViewById(2131689688));
    this.mDimens = ((TextView)findViewById(2131689689));
    this.mWidgetGridView = ((GridLayout)findViewById(2131689691));
    this.mArrowBtn = ((ImageView)findViewById(2131689690));
    this.mDimensionsFormatString = getResources().getString(2131755014);
  }
  
  public WidgetFolder openWidgetFolder(MenuWidgets paramMenuWidgets, MenuWidgets.MenuWidgetsFolderMgr paramMenuWidgetsFolderMgr)
  {
    this.mLayoutInflater = LayoutInflater.from(getContext());
    AnimationLayer localAnimationLayer = ((Launcher)getContext()).getAnimationLayer();
    this.mWidgetFolder = ((WidgetFolder)this.mLayoutInflater.inflate(2130903130, null));
    this.mWidgetFolder.setWidgetFolderManager(paramMenuWidgetsFolderMgr);
    this.mWidgetFolder.setWidgetFolderView(this);
    this.mWidgetFolder.setWidgetFolderViewIndex(((PagedViewGridLayout)getParent()).indexOfChild(this));
    Object localObject = ((AvailableWidget)this.mFolderItems.get(0)).createHomePendingItem().getComponentName().getPackageName();
    paramMenuWidgetsFolderMgr = null;
    PackageManager localPackageManager = getContext().getPackageManager();
    try
    {
      localObject = localPackageManager.getApplicationInfo((String)localObject, 0);
      paramMenuWidgetsFolderMgr = (MenuWidgets.MenuWidgetsFolderMgr)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    if (paramMenuWidgetsFolderMgr != null)
    {
      paramMenuWidgetsFolderMgr = (String)localPackageManager.getApplicationLabel(paramMenuWidgetsFolderMgr);
      this.mWidgetFolder.setOpenWidgetFolderTitle(paramMenuWidgetsFolderMgr);
    }
    this.mWidgetFolder.setWidgetFolderItems(this.mFolderItems, paramMenuWidgets);
    this.mWidgetFolder.open(localAnimationLayer, null, true);
    performAccessibilityAction(128, null);
    return this.mWidgetFolder;
  }
  
  public void setOverlay(Drawable paramDrawable)
  {
    if (this.mUninstallOverlay != paramDrawable)
    {
      this.mUninstallOverlay = paramDrawable;
      invalidate();
    }
  }
  
  public void setWidgetFolderImage(ArrayList<Bitmap> paramArrayList)
  {
    int j = 0;
    Resources localResources = getResources();
    this.mWidgetGridView.setColumnCount(2);
    int i = localResources.getDimensionPixelSize(2131624037);
    int k = localResources.getDimensionPixelSize(2131624038);
    int n = localResources.getDimensionPixelSize(2131624034);
    int i1 = localResources.getDimensionPixelSize(2131624035);
    int i2 = localResources.getDimensionPixelSize(2131624237) / 2;
    int i3 = localResources.getDimensionPixelSize(2131624238) / 2;
    if (paramArrayList.size() > 2)
    {
      this.mWidgetGridView.setRowCount(2);
      paramArrayList = paramArrayList.iterator();
    }
    int m;
    do
    {
      if (paramArrayList.hasNext())
      {
        localObject1 = (Bitmap)paramArrayList.next();
        m = j + 1;
        if (m <= 4) {}
      }
      else
      {
        return;
        this.mWidgetGridView.setRowCount(1);
        break;
      }
      localObject2 = new FastBitmapDrawable((Bitmap)localObject1);
      j = m;
    } while (localObject2 == null);
    Object localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
    ((ImageView)localObject1).setBackgroundColor(2131361831);
    ((ImageView)localObject1).setPadding(10, 10, 10, 10);
    j = (m - 1) % 2;
    int i4 = (m - 1) / 2;
    Object localObject2 = new GridLayout.LayoutParams(GridLayout.spec(i4, GridLayout.START), GridLayout.spec(j, GridLayout.TOP));
    ((GridLayout.LayoutParams)localObject2).setGravity(8388659);
    if (localResources.getConfiguration().getLayoutDirection() == 1) {
      if (j > 0)
      {
        j = i;
        label268:
        ((GridLayout.LayoutParams)localObject2).rightMargin = j;
        if (i4 <= 0) {
          break label354;
        }
      }
    }
    label354:
    for (j = k;; j = 0)
    {
      ((GridLayout.LayoutParams)localObject2).topMargin = j;
      ((GridLayout.LayoutParams)localObject2).width = (i2 - i1);
      ((GridLayout.LayoutParams)localObject2).height = (i3 - n);
      this.mWidgetGridView.addView((View)localObject1, m - 1, (ViewGroup.LayoutParams)localObject2);
      j = m;
      break;
      j = 0;
      break label268;
      if (j > 0) {}
      for (j = i;; j = 0)
      {
        ((GridLayout.LayoutParams)localObject2).leftMargin = j;
        break;
      }
    }
  }
  
  public void setWidgetFolderItems(ArrayList<AvailableWidget> paramArrayList)
  {
    this.mFolderItems = paramArrayList;
  }
  
  public void setWidgetFolderSpan(int paramInt1, int paramInt2)
  {
    String.format(this.mDimensionsFormatString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = this.mFolderItems.size() + " Widgets";
    this.mDimens.setText(str);
  }
  
  public void setWidgetFolderTitle(String paramString)
  {
    this.mTitle.setText(paramString);
    setTalkbackDescription(paramString);
  }
  
  public void showArrowBtn()
  {
    this.mArrowBtn.setVisibility(0);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/WidgetFolderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */