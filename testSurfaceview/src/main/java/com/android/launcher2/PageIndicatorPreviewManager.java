package com.android.launcher2;

import android.content.res.Resources;
import android.graphics.Rect;

public class PageIndicatorPreviewManager
  extends PageIndicatorManager
{
  static Rect sRect1 = new Rect();
  static Rect sRect2 = new Rect();
  PagePreviewIndicator mPagePreviewIndicator;
  
  public PageIndicatorPreviewManager(PagedView paramPagedView, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramPagedView, paramInt1, paramInt2, paramInt3);
  }
  
  private void cleanupDrag()
  {
    this.mPagePreviewIndicator.mNewPage.setDraggedOn(false);
    this.mPagePreviewIndicator.mNewPageSelectedAnimator.abort();
    this.mPagePreviewIndicator.mNewPageSelectedAnimator.to(0.0F);
  }
  
  public void endEditMode()
  {
    this.mPagePreviewIndicator.animateDragMode(0.0F);
  }
  
  public void getHitRect(Rect paramRect, int paramInt)
  {
    Rect[] arrayOfRect = this.mPagePreviewIndicator.getPreviewRects();
    super.getHitRect(sRect1, 0);
    float f = this.mPagePreviewIndicator.getDragModeFactor();
    int j = getSelectedPageIndex();
    if (j >= arrayOfRect.length) {
      return;
    }
    int i = arrayOfRect[j].top;
    j = arrayOfRect[j].bottom;
    sRect2.set(arrayOfRect[0].left, i, arrayOfRect[(arrayOfRect.length - 1)].right, j);
    sRect2.offset(paramInt, 0);
    paramInt = (int)PagedView.mix(sRect1.left, sRect2.left, f);
    i = (int)PagedView.mix(sRect1.right, sRect2.right, f);
    paramRect.set(paramInt, (int)PagedView.mix(sRect1.top, sRect2.top, f), i, (int)PagedView.mix(sRect1.bottom, sRect2.bottom, f));
  }
  
  protected PageIndicator getPageIndicator(Resources paramResources)
  {
    this.mPagePreviewIndicator = new PagePreviewIndicator(paramResources, this.mMaxVisiblePages);
    return this.mPagePreviewIndicator;
  }
  
  public Rect[] getPreviewRects()
  {
    return this.mPagePreviewIndicator.getPreviewRects();
  }
  
  public int getSelectedPageIndex()
  {
    if (this.mPagePreviewIndicator.mNewPage.isDraggedOn()) {
      return this.mPagePreviewIndicator.mDisplayPageCount;
    }
    return this.mPagePreviewIndicator.mCurrentPage;
  }
  
  public boolean onDragEnter(int paramInt)
  {
    if (paramInt == this.mPageIndicator.mDisplayPageCount)
    {
      this.mPagePreviewIndicator.mNewPage.setDraggedOn(true);
      this.mPagePreviewIndicator.mNewPageSelectedAnimator.abort();
      this.mPagePreviewIndicator.mNewPageSelectedAnimator.to(1.0F);
    }
    super.onDragEnter(paramInt);
    return true;
  }
  
  public boolean onDragExit(int paramInt)
  {
    cleanupDrag();
    super.onDragExit(paramInt);
    return true;
  }
  
  public boolean onDrop(int paramInt)
  {
    cleanupDrag();
    super.onDrop(paramInt);
    return false;
  }
  
  public void startEditMode()
  {
    this.mPagePreviewIndicator.animateDragMode(1.0F);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/PageIndicatorPreviewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */