package com.tencent.mm.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.PasterEditText;
import com.tencent.mm.ui.f.c.b;

public class MMEditText
  extends PasterEditText
{
  int suz;
  public InputConnection wti;
  public a wtj;
  
  public MMEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1636248322048L, 12191);
    this.suz = 0;
    GMTrace.o(1636248322048L, 12191);
  }
  
  public MMEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1635979886592L, 12189);
    this.suz = 0;
    GMTrace.o(1635979886592L, 12189);
  }
  
  private void MC(String paramString)
  {
    GMTrace.i(1636650975232L, 12194);
    int i = getSelectionStart();
    setText(b.a(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      GMTrace.o(1636650975232L, 12194);
      return;
    }
    setSelection(i);
    GMTrace.o(1636650975232L, 12194);
  }
  
  public final void Uw(String paramString)
  {
    GMTrace.i(1636382539776L, 12192);
    int i = b.m(getContext(), getText().toString(), getSelectionStart());
    int j = b.m(getContext(), getText().toString(), getSelectionEnd());
    Object localObject = new StringBuffer(getText());
    localObject = ((StringBuffer)localObject).substring(0, i) + paramString + ((StringBuffer)localObject).substring(j, ((StringBuffer)localObject).length());
    setText(b.a(getContext(), (CharSequence)localObject, getTextSize()));
    setSelection(i + paramString.length());
    GMTrace.o(1636382539776L, 12192);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    GMTrace.i(1636114104320L, 12190);
    this.wti = super.onCreateInputConnection(paramEditorInfo);
    paramEditorInfo = this.wti;
    GMTrace.o(1636114104320L, 12190);
    return paramEditorInfo;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(1636785192960L, 12195);
    if (this.wtj == null) {}
    KeyEvent.DispatcherState localDispatcherState;
    for (boolean bool = true;; bool = false)
    {
      v.v("MicroMsg.MMEditText", "on onKeyPreIme, listener null ? %B", new Object[] { Boolean.valueOf(bool) });
      if ((this.wtj == null) || (paramInt != 4)) {
        break label203;
      }
      if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
        break;
      }
      v.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.startTracking(paramKeyEvent, this);
      }
      GMTrace.o(1636785192960L, 12195);
      return true;
    }
    if (paramKeyEvent.getAction() == 1)
    {
      v.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.handleUpEvent(paramKeyEvent);
      }
      if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
      {
        v.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
        this.wtj.aIo();
        paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
        if (paramKeyEvent != null) {
          paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        GMTrace.o(1636785192960L, 12195);
        return true;
      }
    }
    label203:
    bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    GMTrace.o(1636785192960L, 12195);
    return bool;
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: ldc2_w 216
    //   3: sipush 12193
    //   6: invokestatic 31	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: iload_1
    //   11: invokespecial 219	com/tencent/mm/ui/base/PasterEditText:onTextContextMenuItem	(I)Z
    //   14: istore_2
    //   15: iload_1
    //   16: ldc -36
    //   18: if_icmpne +21 -> 39
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 33	com/tencent/mm/ui/widget/MMEditText:suz	I
    //   26: aload_0
    //   27: invokevirtual 71	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
    //   30: invokevirtual 92	java/lang/Object:toString	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_0
    //   35: aload_3
    //   36: invokespecial 222	com/tencent/mm/ui/widget/MMEditText:MC	(Ljava/lang/String;)V
    //   39: ldc2_w 216
    //   42: sipush 12193
    //   45: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   48: iload_2
    //   49: ireturn
    //   50: astore_3
    //   51: ldc -122
    //   53: ldc -32
    //   55: iconst_1
    //   56: anewarray 88	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_3
    //   62: aastore
    //   63: invokestatic 227	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc2_w 216
    //   69: sipush 12193
    //   72: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   75: iconst_0
    //   76: ireturn
    //   77: astore 4
    //   79: ldc -122
    //   81: ldc -27
    //   83: iconst_1
    //   84: anewarray 88	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: getfield 33	com/tencent/mm/ui/widget/MMEditText:suz	I
    //   93: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokestatic 227	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload_0
    //   101: getfield 33	com/tencent/mm/ui/widget/MMEditText:suz	I
    //   104: iconst_3
    //   105: if_icmpge +36 -> 141
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 33	com/tencent/mm/ui/widget/MMEditText:suz	I
    //   113: iconst_1
    //   114: iadd
    //   115: putfield 33	com/tencent/mm/ui/widget/MMEditText:suz	I
    //   118: aload_0
    //   119: new 105	java/lang/StringBuilder
    //   122: dup
    //   123: ldc -20
    //   125: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_3
    //   129: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 222	com/tencent/mm/ui/widget/MMEditText:MC	(Ljava/lang/String;)V
    //   138: goto -99 -> 39
    //   141: aload 4
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	MMEditText
    //   0	144	1	paramInt	int
    //   14	35	2	bool	boolean
    //   33	3	3	str	String
    //   50	79	3	localNullPointerException	NullPointerException
    //   77	65	4	localIndexOutOfBoundsException	IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   9	15	50	java/lang/NullPointerException
    //   34	39	77	java/lang/IndexOutOfBoundsException
  }
  
  public static abstract interface a
  {
    public abstract void aIo();
  }
  
  public static abstract interface b
  {
    public abstract void aXJ();
  }
  
  public static final class c
    implements TextWatcher
  {
    private final int aIo;
    private EditText oAr;
    private TextView wtk;
    public MMEditText.b wtl;
    private boolean wtm;
    
    public c(EditText paramEditText, TextView paramTextView, int paramInt)
    {
      GMTrace.i(1628463693824L, 12133);
      this.wtl = null;
      this.wtm = false;
      this.oAr = paramEditText;
      this.wtk = paramTextView;
      this.aIo = paramInt;
      GMTrace.o(1628463693824L, 12133);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int m = 0;
      GMTrace.i(1628597911552L, 12134);
      String str1 = paramEditable.toString();
      paramEditable = "";
      int i = 0;
      int j = 0;
      int k = i;
      if (j < str1.length())
      {
        if (bf.f(str1.charAt(j))) {
          i += 2;
        }
        for (;;)
        {
          k = i;
          if (i > this.aIo) {
            break label102;
          }
          paramEditable = paramEditable + str1.charAt(j);
          j += 1;
          break;
          i += 1;
        }
      }
      label102:
      if (k > this.aIo) {}
      for (;;)
      {
        try
        {
          this.oAr.setText(paramEditable);
          if (this.wtm) {
            continue;
          }
          i = this.oAr.getText().toString().length();
          this.oAr.setSelection(i);
          this.wtm = false;
        }
        catch (Exception localException)
        {
          this.wtm = true;
          String str2 = localException.getMessage();
          v.e("MicroMsg.MMEditText", "error " + str2);
          this.oAr.setText(paramEditable);
          this.oAr.setSelection(0);
          continue;
          continue;
        }
        i = this.aIo - k;
        if (i >= 0) {
          continue;
        }
        i = m;
        if (this.wtk != null) {
          this.wtk.setText(i / 2);
        }
        GMTrace.o(1628597911552L, 12134);
        return;
        this.oAr.setSelection(0);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(1628732129280L, 12135);
      GMTrace.o(1628732129280L, 12135);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(1628866347008L, 12136);
      if (this.wtl != null) {
        this.wtl.aXJ();
      }
      GMTrace.o(1628866347008L, 12136);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/MMEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */