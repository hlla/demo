package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.a.a.a;
import android.support.v4.widget.k;
import android.widget.CompoundButton;

final class ad
{
  public ColorStateList a = null;
  public PorterDuff.Mode b = null;
  private boolean c = false;
  private boolean d = false;
  private boolean e;
  private final CompoundButton f;
  
  ad(CompoundButton paramCompoundButton)
  {
    this.f = paramCompoundButton;
  }
  
  private final void b()
  {
    Drawable localDrawable = k.a(this.f);
    if ((localDrawable != null) && ((this.c) || (this.d)))
    {
      localDrawable = a.f(localDrawable).mutate();
      if (this.c) {
        a.a(localDrawable, this.a);
      }
      if (this.d) {
        a.a(localDrawable, this.b);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.f.getDrawableState());
      }
      this.f.setButtonDrawable(localDrawable);
    }
  }
  
  final int a(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = k.a(this.f);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  final void a()
  {
    if (this.e)
    {
      this.e = false;
      return;
    }
    this.e = true;
    b();
  }
  
  final void a(ColorStateList paramColorStateList)
  {
    this.a = paramColorStateList;
    this.c = true;
    b();
  }
  
  final void a(PorterDuff.Mode paramMode)
  {
    this.b = paramMode;
    this.d = true;
    b();
  }
  
  /* Error */
  final void a(android.util.AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	android/support/v7/widget/ad:f	Landroid/widget/CompoundButton;
    //   4: invokevirtual 92	android/widget/CompoundButton:getContext	()Landroid/content/Context;
    //   7: aload_1
    //   8: getstatic 98	android/support/v7/a/a:aP	[I
    //   11: iload_2
    //   12: iconst_0
    //   13: invokevirtual 104	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   16: astore_1
    //   17: aload_1
    //   18: iconst_0
    //   19: invokevirtual 110	android/content/res/TypedArray:hasValue	(I)Z
    //   22: ifeq +31 -> 53
    //   25: aload_1
    //   26: iconst_0
    //   27: iconst_0
    //   28: invokevirtual 114	android/content/res/TypedArray:getResourceId	(II)I
    //   31: istore_2
    //   32: iload_2
    //   33: ifeq +20 -> 53
    //   36: aload_0
    //   37: getfield 29	android/support/v7/widget/ad:f	Landroid/widget/CompoundButton;
    //   40: astore_3
    //   41: aload_3
    //   42: aload_3
    //   43: invokevirtual 92	android/widget/CompoundButton:getContext	()Landroid/content/Context;
    //   46: iload_2
    //   47: invokestatic 119	android/support/v7/b/a/a:b	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   50: invokevirtual 70	android/widget/CompoundButton:setButtonDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   53: aload_1
    //   54: iconst_1
    //   55: invokevirtual 110	android/content/res/TypedArray:hasValue	(I)Z
    //   58: ifeq +15 -> 73
    //   61: aload_0
    //   62: getfield 29	android/support/v7/widget/ad:f	Landroid/widget/CompoundButton;
    //   65: aload_1
    //   66: iconst_1
    //   67: invokevirtual 123	android/content/res/TypedArray:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   70: invokestatic 126	android/support/v4/widget/k:a	(Landroid/widget/CompoundButton;Landroid/content/res/ColorStateList;)V
    //   73: aload_1
    //   74: iconst_2
    //   75: invokevirtual 110	android/content/res/TypedArray:hasValue	(I)Z
    //   78: ifeq +48 -> 126
    //   81: aload_0
    //   82: getfield 29	android/support/v7/widget/ad:f	Landroid/widget/CompoundButton;
    //   85: astore_3
    //   86: aload_1
    //   87: iconst_2
    //   88: iconst_m1
    //   89: invokevirtual 129	android/content/res/TypedArray:getInt	(II)I
    //   92: aconst_null
    //   93: invokestatic 134	android/support/v7/widget/bw:a	(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;
    //   96: astore 4
    //   98: getstatic 77	android/os/Build$VERSION:SDK_INT	I
    //   101: istore_2
    //   102: iload_2
    //   103: bipush 21
    //   105: if_icmpge +26 -> 131
    //   108: aload_3
    //   109: instanceof 136
    //   112: ifeq +14 -> 126
    //   115: aload_3
    //   116: checkcast 136	android/support/v4/widget/ax
    //   119: aload 4
    //   121: invokeinterface 139 2 0
    //   126: aload_1
    //   127: invokevirtual 142	android/content/res/TypedArray:recycle	()V
    //   130: return
    //   131: aload_3
    //   132: aload 4
    //   134: invokevirtual 145	android/widget/CompoundButton:setButtonTintMode	(Landroid/graphics/PorterDuff$Mode;)V
    //   137: goto -11 -> 126
    //   140: astore_3
    //   141: aload_1
    //   142: invokevirtual 142	android/content/res/TypedArray:recycle	()V
    //   145: aload_3
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	ad
    //   0	147	1	paramAttributeSet	android.util.AttributeSet
    //   0	147	2	paramInt	int
    //   40	92	3	localCompoundButton	CompoundButton
    //   140	6	3	localObject	Object
    //   96	37	4	localMode	PorterDuff.Mode
    // Exception table:
    //   from	to	target	type
    //   17	32	140	finally
    //   36	53	140	finally
    //   53	73	140	finally
    //   73	102	140	finally
    //   115	126	140	finally
    //   131	137	140	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */