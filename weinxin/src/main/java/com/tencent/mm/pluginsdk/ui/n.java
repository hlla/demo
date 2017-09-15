package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bi.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMEditText;

public final class n
{
  private Context mContext;
  private StringBuilder sJi;
  private SpannableStringBuilder sJj;
  private SpannableString sJk;
  private SpannableStringBuilder sJl;
  private CharacterStyle sJm;
  private int sJn;
  private int sJo;
  public int sJp;
  
  public n(Context paramContext)
  {
    GMTrace.i(1200309141504L, 8943);
    this.sJj = new SpannableStringBuilder();
    this.sJl = new SpannableStringBuilder();
    this.sJm = new ForegroundColorSpan(-5066062);
    this.sJp = 3;
    this.mContext = paramContext;
    GMTrace.o(1200309141504L, 8943);
  }
  
  public final void a(MMEditText paramMMEditText)
  {
    GMTrace.i(1200577576960L, 8945);
    if (paramMMEditText == null)
    {
      GMTrace.o(1200577576960L, 8945);
      return;
    }
    this.sJp = 0;
    this.sJk = g.bKx().d(this.mContext, paramMMEditText.getText().toString(), paramMMEditText.getTextSize());
    v.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[] { this.sJk });
    paramMMEditText.setText(this.sJk);
    paramMMEditText.setSelection(this.sJk.length());
    GMTrace.o(1200577576960L, 8945);
  }
  
  public final void a(MMEditText paramMMEditText, String paramString, boolean paramBoolean)
  {
    GMTrace.i(1200443359232L, 8944);
    if (paramMMEditText == null)
    {
      GMTrace.o(1200443359232L, 8944);
      return;
    }
    if (this.sJi == null) {
      throw new IllegalStateException("You should saveHistory before setText");
    }
    int k = this.sJn + paramString.length();
    this.sJj.clear();
    this.sJl.clear();
    SpannableStringBuilder localSpannableStringBuilder2;
    if (paramBoolean)
    {
      this.sJk = g.bKx().d(this.mContext, this.sJi.subSequence(0, this.sJn), paramMMEditText.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder1 = this.sJj.append(this.sJk);
      localSpannableStringBuilder2 = this.sJl;
      if ((localSpannableStringBuilder2 == null) || (paramString == null) || (paramString.length() == 0)) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2).append(this.sJi.subSequence(this.sJo, this.sJi.length()));
      }
    }
    for (;;)
    {
      v.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[] { Integer.valueOf(this.sJn), Integer.valueOf(this.sJo), Integer.valueOf(k), Integer.valueOf(this.sJj.length()), paramString, this.sJj });
      paramMMEditText.setText(this.sJj);
      if (k > this.sJj.length()) {
        break label373;
      }
      if (k != 0) {
        break label367;
      }
      paramMMEditText.setSelection(this.sJj.length());
      GMTrace.o(1200443359232L, 8944);
      return;
      int j;
      if (paramString.length() < this.sJp) {
        j = paramString.length();
      }
      for (int i = 0;; i = j - this.sJp)
      {
        localSpannableStringBuilder2.append(paramString).setSpan(this.sJm, i, j, 33);
        break;
        j = paramString.length();
      }
      this.sJk = g.bKx().d(this.mContext, paramString, paramMMEditText.getTextSize());
      this.sJj.append(this.sJk);
    }
    label367:
    paramMMEditText.setSelection(k);
    label373:
    GMTrace.o(1200443359232L, 8944);
  }
  
  public final void b(MMEditText paramMMEditText)
  {
    GMTrace.i(1200711794688L, 8946);
    if (paramMMEditText == null)
    {
      GMTrace.o(1200711794688L, 8946);
      return;
    }
    this.sJn = paramMMEditText.getSelectionStart();
    this.sJo = paramMMEditText.getSelectionEnd();
    this.sJi = new StringBuilder(paramMMEditText.getText());
    v.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[] { Integer.valueOf(this.sJn), Integer.valueOf(this.sJo), this.sJi });
    if (paramMMEditText.getText().toString().equalsIgnoreCase("")) {
      this.sJj.clear();
    }
    GMTrace.o(1200711794688L, 8946);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */