package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.gmtrace.GMTrace;

public final class a
{
  public int gravity;
  public TextPaint haA;
  public int haS;
  public Typeface haT;
  public int haU;
  public float haV;
  public Layout.Alignment hap;
  public TextUtils.TruncateAt haq;
  public TextDirectionHeuristic has;
  public float hat;
  public float hau;
  public boolean hav;
  public int linkColor;
  public int maxLength;
  public int maxLines;
  public int minLines;
  public int textColor;
  
  public a()
  {
    GMTrace.i(432717955072L, 3224);
    this.maxLines = -1;
    this.minLines = -1;
    this.maxLength = -1;
    this.haA = null;
    this.hap = Layout.Alignment.ALIGN_NORMAL;
    this.haq = null;
    this.gravity = 51;
    this.haS = -1;
    this.has = null;
    this.hat = 0.0F;
    this.hau = 1.0F;
    this.hav = false;
    this.haT = null;
    this.haU = -1;
    this.haV = -1.0F;
    this.textColor = -1;
    this.linkColor = -1;
    GMTrace.o(432717955072L, 3224);
  }
  
  public final int hashCode()
  {
    GMTrace.i(432986390528L, 3226);
    int j = this.maxLines * 31 + 0 + this.maxLength * 31;
    int i = j;
    if (this.haA != null) {
      i = j + this.haA.hashCode() * 31;
    }
    j = i + this.hap.hashCode() * 31;
    i = j;
    if (this.haq != null) {
      i = j + this.haq.hashCode() * 31;
    }
    j = i + this.gravity * 31 + this.haS * 31;
    i = j;
    if (this.has != null) {
      i = j + this.has.hashCode() * 31;
    }
    j = (int)((int)(i + this.hat * 31.0F) + this.hau * 31.0F);
    if (this.hav) {}
    for (i = 1;; i = 0)
    {
      j = i * 31 + j;
      i = j;
      if (this.haT != null) {
        i = j + this.haT.hashCode() * 31;
      }
      i = (int)(i + this.haU * 31 + this.haV * 31.0F);
      j = this.textColor;
      int k = this.linkColor;
      GMTrace.o(432986390528L, 3226);
      return i + j * 31 + k * 31;
    }
  }
  
  public final String toString()
  {
    GMTrace.i(432852172800L, 3225);
    Object localObject = new StringBuilder("");
    ((StringBuilder)localObject).append(String.format("maxLines: %d ", new Object[] { Integer.valueOf(this.maxLines) }));
    ((StringBuilder)localObject).append(String.format("maxLength: %d ", new Object[] { Integer.valueOf(this.maxLength) }));
    ((StringBuilder)localObject).append(String.format("textPaint: %s ", new Object[] { this.haA }));
    ((StringBuilder)localObject).append(String.format("alignment: %s ", new Object[] { this.hap }));
    ((StringBuilder)localObject).append(String.format("ellipsize: %s ", new Object[] { this.haq }));
    ((StringBuilder)localObject).append(String.format("gravity: %s ", new Object[] { Integer.valueOf(this.gravity) }));
    ((StringBuilder)localObject).append(String.format("ellipsizeWidth: %s ", new Object[] { Integer.valueOf(this.haS) }));
    ((StringBuilder)localObject).append(String.format("textDirection: %s ", new Object[] { this.has }));
    ((StringBuilder)localObject).append(String.format("spacingAdd: %s spacingMult: %s ", new Object[] { Float.valueOf(this.hat), Float.valueOf(this.hau) }));
    ((StringBuilder)localObject).append(String.format("includedPad: %b ", new Object[] { Boolean.valueOf(this.hav) }));
    ((StringBuilder)localObject).append(String.format("typeface: %s ", new Object[] { this.haT }));
    ((StringBuilder)localObject).append(String.format("fontStyle: %d ", new Object[] { Integer.valueOf(this.haU) }));
    ((StringBuilder)localObject).append(String.format("textSize: %s ", new Object[] { Float.valueOf(this.haV) }));
    ((StringBuilder)localObject).append(String.format("textColor: %d", new Object[] { Integer.valueOf(this.textColor) }));
    ((StringBuilder)localObject).append(String.format("linkColor: %d", new Object[] { Integer.valueOf(this.linkColor) }));
    localObject = ((StringBuilder)localObject).toString();
    GMTrace.o(432852172800L, 3225);
    return (String)localObject;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kiss/widget/textview/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */