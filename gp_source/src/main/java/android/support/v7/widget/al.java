package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.widget.ay;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class al
  extends ImageButton
  implements android.support.v4.view.ab, ay
{
  private final ab a = new ab(this);
  private final am b;
  
  public al(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public al(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969013);
  }
  
  public al(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(hc.a(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new am(this);
    this.b.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.a;
    if (localObject != null) {
      ((ab)localObject).d();
    }
    localObject = this.b;
    if (localObject != null) {
      ((am)localObject).d();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    ab localab = this.a;
    if (localab != null) {
      return localab.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    ab localab = this.a;
    if (localab != null) {
      return localab.c();
    }
    return null;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    am localam = this.b;
    if (localam != null) {
      return localam.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    am localam = this.b;
    if (localam != null) {
      return localam.c();
    }
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    return (this.b.a()) && (super.hasOverlappingRendering());
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    ab localab = this.a;
    if (localab != null) {
      localab.a(paramInt);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    paramBitmap = this.b;
    if (paramBitmap != null) {
      paramBitmap.d();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.b;
    if (paramDrawable != null) {
      paramDrawable.d();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = this.b;
    if (paramUri != null) {
      paramUri.d();
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    ab localab = this.a;
    if (localab != null) {
      localab.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    ab localab = this.a;
    if (localab != null) {
      localab.a(paramMode);
    }
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    am localam = this.b;
    if (localam != null) {
      localam.a(paramColorStateList);
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    am localam = this.b;
    if (localam != null) {
      localam.a(paramMode);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */