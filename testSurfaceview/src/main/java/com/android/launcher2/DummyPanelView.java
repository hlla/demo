package com.android.launcher2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;

class DummyPanelView
  extends View
{
  CellLayout layout;
  private Matrix mMat = new Matrix();
  PanelDrawer.PanelDrawable panel;
  
  public DummyPanelView(Context paramContext)
  {
    super(paramContext, null, 0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.layout == null) || (this.layout.getParent() == null)) {}
    while ((this.panel.getAlpha() == 0) || (this.layout.getAlpha() == 0.0F) || (this.layout.getChildrenAlpha() == 0.0F)) {
      return;
    }
    ((PagedView)this.layout.getParent()).updatePageTransforms();
    paramCanvas.save();
    paramCanvas.concat(this.layout.getAbsMatrix(this.mMat, getParent()));
    this.panel.blockDraw = false;
    this.panel.draw(paramCanvas);
    this.panel.blockDraw = true;
    paramCanvas.restore();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DummyPanelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */