package com.tencent.mm.ui.widget.celltextview.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static abstract interface a
    extends b<a.b>
  {
    public abstract void Co(int paramInt);
    
    public abstract void Cp(int paramInt);
    
    public abstract void Cq(int paramInt);
    
    public abstract void Cr(int paramInt);
    
    public abstract void Cs(int paramInt);
    
    public abstract void U(String paramString, int paramInt1, int paramInt2);
    
    public abstract void a(com.tencent.mm.ui.widget.celltextview.c.b paramb);
    
    public abstract void a(ArrayList<d> paramArrayList, CharSequence paramCharSequence);
    
    public abstract void aC(LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> paramLinkedList);
    
    public abstract List<com.tencent.mm.ui.widget.celltextview.c.b> caL();
    
    public abstract String caM();
    
    public abstract int getMaxLines();
    
    public abstract int getMeasuredHeight();
    
    public abstract int getMeasuredWidth();
    
    public abstract int getPaddingBottom();
    
    public abstract int getPaddingLeft();
    
    public abstract int getPaddingRight();
    
    public abstract int getPaddingTop();
    
    public abstract Paint getPaint();
    
    public abstract String getText();
    
    public abstract float getTextSize();
    
    public abstract void onDraw(Canvas paramCanvas);
    
    public abstract void requestLayout();
    
    public abstract void setBackgroundDrawable(Drawable paramDrawable);
    
    public abstract void setMaxWidth(int paramInt);
    
    public abstract void setMinHeight(int paramInt);
    
    public abstract void setMinWidth(int paramInt);
    
    public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void setTextColor(int paramInt);
    
    public abstract void setTextSize(float paramFloat);
  }
  
  public static abstract interface b
    extends c<a.a>
  {
    public abstract View getView();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */