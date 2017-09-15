package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.j;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarSearchView
  extends LinearLayout
  implements f
{
  private TextWatcher sOz;
  private View wib;
  private ActionBarEditText wic;
  private ImageButton wid;
  private int wie;
  private boolean wif;
  private t wig;
  public b wih;
  public a wii;
  private View.OnFocusChangeListener wij;
  public View.OnFocusChangeListener wik;
  private View.OnClickListener wil;
  private View.OnClickListener wim;
  
  public ActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(1935285420032L, 14419);
    this.wie = c.wip;
    this.wif = false;
    this.sOz = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(1910723575808L, 14236);
        GMTrace.o(1910723575808L, 14236);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1910455140352L, 14234);
        GMTrace.o(1910455140352L, 14234);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1910589358080L, 14235);
        ActionBarSearchView.a(ActionBarSearchView.this);
        t localt = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localt.wmR)
        {
          localEditText = (EditText)localt.wmP.get();
          if (localEditText != null) {}
        }
        else if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
        {
          localObject = ActionBarSearchView.c(ActionBarSearchView.this);
          if (paramAnonymousCharSequence != null) {
            break label257;
          }
        }
        label257:
        for (paramAnonymousCharSequence = "";; paramAnonymousCharSequence = paramAnonymousCharSequence.toString())
        {
          ((ActionBarSearchView.b)localObject).zC(paramAnonymousCharSequence);
          GMTrace.o(1910589358080L, 14235);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localt.jpC == null) || (localt.jpC.length() == 0) || ((localt.jpC != null) && (localt.jpC.equals(paramAnonymousCharSequence.toString())))))
          {
            v.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localt.jpC });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localt.jpC = ((String)localObject);
            localt.wmO = t.i(localt.jpC, localt.wmQ);
            if (!t.a(localEditText, localt.wmQ)) {
              break;
            }
            v.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.wij = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        GMTrace.i(1914347454464L, 14263);
        v.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        GMTrace.o(1914347454464L, 14263);
      }
    };
    this.wil = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1932064194560L, 14395);
        if (ActionBarSearchView.c.wip == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          v.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.lE(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
          {
            ActionBarSearchView.c(ActionBarSearchView.this).OG();
            GMTrace.o(1932064194560L, 14395);
          }
        }
        else
        {
          v.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).aHh();
          }
        }
        GMTrace.o(1932064194560L, 14395);
      }
    };
    this.wim = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1925219090432L, 14344);
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).aHi();
        }
        GMTrace.o(1925219090432L, 14344);
      }
    };
    init();
    GMTrace.o(1935285420032L, 14419);
  }
  
  public ActionBarSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1935151202304L, 14418);
    this.wie = c.wip;
    this.wif = false;
    this.sOz = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(1910723575808L, 14236);
        GMTrace.o(1910723575808L, 14236);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1910455140352L, 14234);
        GMTrace.o(1910455140352L, 14234);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1910589358080L, 14235);
        ActionBarSearchView.a(ActionBarSearchView.this);
        t localt = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localt.wmR)
        {
          localEditText = (EditText)localt.wmP.get();
          if (localEditText != null) {}
        }
        else if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
        {
          localObject = ActionBarSearchView.c(ActionBarSearchView.this);
          if (paramAnonymousCharSequence != null) {
            break label257;
          }
        }
        label257:
        for (paramAnonymousCharSequence = "";; paramAnonymousCharSequence = paramAnonymousCharSequence.toString())
        {
          ((ActionBarSearchView.b)localObject).zC(paramAnonymousCharSequence);
          GMTrace.o(1910589358080L, 14235);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localt.jpC == null) || (localt.jpC.length() == 0) || ((localt.jpC != null) && (localt.jpC.equals(paramAnonymousCharSequence.toString())))))
          {
            v.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localt.jpC });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localt.jpC = ((String)localObject);
            localt.wmO = t.i(localt.jpC, localt.wmQ);
            if (!t.a(localEditText, localt.wmQ)) {
              break;
            }
            v.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.wij = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        GMTrace.i(1914347454464L, 14263);
        v.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        GMTrace.o(1914347454464L, 14263);
      }
    };
    this.wil = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1932064194560L, 14395);
        if (ActionBarSearchView.c.wip == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          v.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.lE(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
          {
            ActionBarSearchView.c(ActionBarSearchView.this).OG();
            GMTrace.o(1932064194560L, 14395);
          }
        }
        else
        {
          v.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).aHh();
          }
        }
        GMTrace.o(1932064194560L, 14395);
      }
    };
    this.wim = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1925219090432L, 14344);
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).aHi();
        }
        GMTrace.o(1925219090432L, 14344);
      }
    };
    init();
    GMTrace.o(1935151202304L, 14418);
  }
  
  private void bZh()
  {
    GMTrace.i(1936761815040L, 14430);
    if ((this.wic.getEditableText() != null) && (!bf.mA(this.wic.getEditableText().toString())))
    {
      ei(a.f.hbG, getResources().getDimensionPixelSize(a.e.aXE));
      this.wie = c.wip;
      GMTrace.o(1936761815040L, 14430);
      return;
    }
    if (this.wif)
    {
      ei(a.f.hbO, getResources().getDimensionPixelSize(a.e.aXE));
      this.wie = c.wiq;
      GMTrace.o(1936761815040L, 14430);
      return;
    }
    ei(0, 0);
    this.wie = c.wip;
    GMTrace.o(1936761815040L, 14430);
  }
  
  private void ei(int paramInt1, int paramInt2)
  {
    GMTrace.i(1936627597312L, 14429);
    this.wid.setImageResource(paramInt1);
    this.wid.setBackgroundResource(0);
    if (paramInt1 == a.f.hbO) {
      this.wid.setContentDescription(getContext().getString(a.k.hfj));
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.wid.getLayoutParams();
      localLayoutParams.width = paramInt2;
      this.wid.setLayoutParams(localLayoutParams);
      GMTrace.o(1936627597312L, 14429);
      return;
      this.wid.setContentDescription(getContext().getString(a.k.bCn));
    }
  }
  
  private void init()
  {
    GMTrace.i(1935419637760L, 14420);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(a.h.hdw, this, true);
    this.wib = findViewById(a.g.bmt);
    this.wib.setOnClickListener(this.wim);
    this.wic = ((ActionBarEditText)findViewById(a.g.bKI));
    this.wig = new t(this.wic);
    this.wic.wio = this;
    this.wic.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1948304539648L, 14516);
        ActionBarSearchView.g(ActionBarSearchView.this).setText("");
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).aHg();
        }
        GMTrace.o(1948304539648L, 14516);
      }
    });
    this.wid = ((ImageButton)findViewById(a.g.cGh));
    this.wic.addTextChangedListener(this.sOz);
    this.wic.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(1949780934656L, 14527);
        if (paramAnonymousInt == 67)
        {
          v.d("MicroMsg.ActionBarSearchView", "on back key click.");
          Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
          if (((t)localObject).wmR)
          {
            paramAnonymousView = (EditText)((t)localObject).wmP.get();
            if ((paramAnonymousView != null) && (((t)localObject).wmO != null)) {}
          }
          else
          {
            GMTrace.o(1949780934656L, 14527);
            return false;
          }
          paramAnonymousKeyEvent = paramAnonymousView.getText();
          paramAnonymousInt = paramAnonymousView.getSelectionStart();
          if (paramAnonymousInt == paramAnonymousView.getSelectionEnd())
          {
            localObject = ((t)localObject).Ca(paramAnonymousInt);
            if ((localObject != null) && (((t.b)localObject).wmU))
            {
              paramAnonymousKeyEvent.delete(((t.b)localObject).start, ((t.b)localObject).start + ((t.b)localObject).length);
              paramAnonymousView.setTextKeepState(paramAnonymousKeyEvent);
              paramAnonymousView.setSelection(((t.b)localObject).start);
              GMTrace.o(1949780934656L, 14527);
              return true;
            }
          }
          GMTrace.o(1949780934656L, 14527);
          return false;
        }
        GMTrace.o(1949780934656L, 14527);
        return false;
      }
    });
    this.wic.wqg = new AutoMatchKeywordEditText.a()
    {
      public final void a(EditText paramAnonymousEditText, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(1909515616256L, 14227);
        v.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        if (((t)localObject).wmR)
        {
          localEditText = (EditText)((t)localObject).wmP.get();
          if ((localEditText != null) && (paramAnonymousEditText == localEditText)) {}
        }
        else
        {
          GMTrace.o(1909515616256L, 14227);
          return;
        }
        paramAnonymousEditText = localEditText.getText();
        paramAnonymousInt2 = localEditText.getSelectionStart();
        int i = localEditText.getSelectionEnd();
        if ((paramAnonymousInt2 < 0) || (i < paramAnonymousInt2))
        {
          GMTrace.o(1909515616256L, 14227);
          return;
        }
        if (paramAnonymousInt2 == i)
        {
          localObject = ((t)localObject).Ca(paramAnonymousInt2);
          if ((localObject != null) && (((t.b)localObject).wmU))
          {
            localEditText.setTextKeepState(paramAnonymousEditText);
            paramAnonymousInt1 = ((t.b)localObject).start;
            localEditText.setSelection(((t.b)localObject).length + paramAnonymousInt1);
          }
          GMTrace.o(1909515616256L, 14227);
          return;
        }
        t.b localb = ((t)localObject).Ca(paramAnonymousInt2);
        paramAnonymousInt1 = paramAnonymousInt2;
        if (localb != null)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (localb.wmU) {
            paramAnonymousInt1 = localb.start + localb.length;
          }
        }
        if (paramAnonymousInt1 >= i)
        {
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1);
          GMTrace.o(1909515616256L, 14227);
          return;
        }
        localObject = ((t)localObject).Ca(i);
        if ((localObject != null) && (((t.b)localObject).wmU))
        {
          paramAnonymousInt2 = ((t.b)localObject).start;
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1, paramAnonymousInt2);
        }
        GMTrace.o(1909515616256L, 14227);
      }
    };
    this.wic.setOnFocusChangeListener(this.wij);
    c.d(this.wic).Cc(100).a(null);
    this.wid.setOnClickListener(this.wil);
    GMTrace.o(1935419637760L, 14420);
  }
  
  public final void BY(int paramInt)
  {
    GMTrace.i(1937969774592L, 14439);
    if (this.wic != null) {
      this.wic.setCompoundDrawables(aa.getResources().getDrawable(paramInt), null, null, null);
    }
    GMTrace.o(1937969774592L, 14439);
  }
  
  public final void Uf(String paramString)
  {
    GMTrace.i(1935956508672L, 14424);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.wic.setText(str);
    this.wic.setSelection(str.length());
    GMTrace.o(1935956508672L, 14424);
  }
  
  public final void Ug(String paramString)
  {
    GMTrace.i(16746614358016L, 124772);
    if (this.wic != null)
    {
      this.wic.setCompoundDrawables(new d(this.wic, paramString), null, null, null);
      this.wic.setHint("");
    }
    GMTrace.o(16746614358016L, 124772);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(1935822290944L, 14423);
    this.wii = parama;
    GMTrace.o(1935822290944L, 14423);
  }
  
  public final void a(b paramb)
  {
    GMTrace.i(1935688073216L, 14422);
    this.wih = paramb;
    GMTrace.o(1935688073216L, 14422);
  }
  
  public final void a(SearchViewNotRealTimeHelper.a parama)
  {
    GMTrace.i(1937298685952L, 14434);
    GMTrace.o(1937298685952L, 14434);
  }
  
  public final void ak(ArrayList<String> paramArrayList)
  {
    GMTrace.i(1937701339136L, 14437);
    if (this.wig != null)
    {
      t localt = this.wig;
      localt.wmQ = paramArrayList;
      if (localt.wmR)
      {
        paramArrayList = (EditText)localt.wmP.get();
        if (paramArrayList != null) {
          t.a(paramArrayList, localt.wmQ);
        }
      }
    }
    GMTrace.o(1937701339136L, 14437);
  }
  
  public final void bZi()
  {
    GMTrace.i(1937164468224L, 14433);
    this.wic.clearFocus();
    GMTrace.o(1937164468224L, 14433);
  }
  
  public final boolean bZj()
  {
    GMTrace.i(1937432903680L, 14435);
    if (this.wic != null)
    {
      boolean bool = this.wic.hasFocus();
      GMTrace.o(1937432903680L, 14435);
      return bool;
    }
    GMTrace.o(1937432903680L, 14435);
    return false;
  }
  
  public final boolean bZk()
  {
    GMTrace.i(1937567121408L, 14436);
    if (this.wic != null)
    {
      boolean bool = this.wic.requestFocus();
      GMTrace.o(1937567121408L, 14436);
      return bool;
    }
    GMTrace.o(1937567121408L, 14436);
    return false;
  }
  
  public final String bzR()
  {
    GMTrace.i(1935553855488L, 14421);
    if (this.wic.getEditableText() != null)
    {
      String str = this.wic.getEditableText().toString();
      GMTrace.o(1935553855488L, 14421);
      return str;
    }
    GMTrace.o(1935553855488L, 14421);
    return "";
  }
  
  public final void lB(boolean paramBoolean)
  {
    GMTrace.i(1936224944128L, 14426);
    this.wif = paramBoolean;
    bZh();
    GMTrace.o(1936224944128L, 14426);
  }
  
  public final void lC(boolean paramBoolean)
  {
    GMTrace.i(1936359161856L, 14427);
    this.wic.setEnabled(paramBoolean);
    GMTrace.o(1936359161856L, 14427);
  }
  
  public final void lD(boolean paramBoolean)
  {
    GMTrace.i(1936493379584L, 14428);
    this.wid.setEnabled(paramBoolean);
    GMTrace.o(1936493379584L, 14428);
  }
  
  public final void lE(boolean paramBoolean)
  {
    GMTrace.i(1937030250496L, 14432);
    if (!paramBoolean)
    {
      this.wic.removeTextChangedListener(this.sOz);
      this.wic.setText("");
      this.wic.addTextChangedListener(this.sOz);
      GMTrace.o(1937030250496L, 14432);
      return;
    }
    this.wic.setText("");
    GMTrace.o(1937030250496L, 14432);
  }
  
  public final void lF(boolean paramBoolean)
  {
    GMTrace.i(1937835556864L, 14438);
    if (this.wig != null) {
      this.wig.wmR = paramBoolean;
    }
    GMTrace.o(1937835556864L, 14438);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    GMTrace.i(1936090726400L, 14425);
    this.wic.setHint(paramCharSequence);
    GMTrace.o(1936090726400L, 14425);
  }
  
  public final void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    GMTrace.i(1936896032768L, 14431);
    this.wic.setOnEditorActionListener(paramOnEditorActionListener);
    GMTrace.o(1936896032768L, 14431);
  }
  
  public static class ActionBarEditText
    extends AutoMatchKeywordEditText
  {
    ActionBarSearchView wio;
    
    public ActionBarEditText(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      GMTrace.i(2004273332224L, 14933);
      GMTrace.o(2004273332224L, 14933);
    }
    
    public ActionBarEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      GMTrace.i(2004139114496L, 14932);
      GMTrace.o(2004139114496L, 14932);
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      GMTrace.i(2004407549952L, 14934);
      v.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          v.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          GMTrace.o(2004407549952L, 14934);
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          v.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            v.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
            this.wio.clearFocus();
            paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
            if (paramKeyEvent != null) {
              paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
            }
            GMTrace.o(2004407549952L, 14934);
            return true;
          }
        }
      }
      boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
      GMTrace.o(2004407549952L, 14934);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aHi();
  }
  
  public static abstract interface b
  {
    public abstract void OG();
    
    public abstract void aHg();
    
    public abstract void aHh();
    
    public abstract void zC(String paramString);
  }
  
  private static enum c
  {
    static
    {
      GMTrace.i(1957162909696L, 14582);
      wip = 1;
      wiq = 2;
      wir = new int[] { wip, wiq };
      GMTrace.o(1957162909696L, 14582);
    }
  }
  
  final class d
    extends Drawable
  {
    private RectF fw;
    private String jpC;
    private Paint wis;
    private int wit;
    private float wiu;
    private float wiv;
    private Bitmap wiw;
    
    d(EditText paramEditText, String paramString)
    {
      GMTrace.i(16745674833920L, 124765);
      this.wit = BackwardSupportUtil.b.a(aa.getContext(), 2.0F);
      this.wis = new Paint(paramEditText.getPaint());
      this.jpC = paramString;
      this.wis.setColor(aa.getResources().getColor(a.d.aUd));
      this.wiw = d.t(ActionBarSearchView.this.getResources().getDrawable(a.j.dsK));
      this.wiu = this.wis.measureText(this.jpC);
      this$1 = this.wis.getFontMetrics();
      this.wiv = ((float)Math.ceil(ActionBarSearchView.this.bottom - ActionBarSearchView.this.top));
      if (this.wiw.getHeight() > this.wiv) {}
      for (float f = this.wiw.getHeight();; f = this.wiv)
      {
        setBounds(0, 0, (int)(this.wiu + this.wit * 2 + this.wit * 2 + this.wiw.getWidth() + 2.0F), (int)f);
        GMTrace.o(16745674833920L, 124765);
        return;
      }
    }
    
    public final void draw(Canvas paramCanvas)
    {
      GMTrace.i(16745809051648L, 124766);
      Paint.FontMetricsInt localFontMetricsInt = this.wis.getFontMetricsInt();
      Rect localRect = getBounds();
      int i = (int)((localRect.right - localRect.left - (this.fw.right - this.fw.left)) / 2.0F);
      int j = localRect.top;
      int k = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int m = localFontMetricsInt.top;
      paramCanvas.drawBitmap(this.wiw, i, localRect.top, null);
      paramCanvas.drawText(this.jpC, localRect.left + this.wiw.getWidth() + 2, j + k - m, this.wis);
      GMTrace.o(16745809051648L, 124766);
    }
    
    public final int getOpacity()
    {
      GMTrace.i(16746345922560L, 124770);
      GMTrace.o(16746345922560L, 124770);
      return -3;
    }
    
    public final void setAlpha(int paramInt)
    {
      GMTrace.i(16746077487104L, 124768);
      GMTrace.o(16746077487104L, 124768);
    }
    
    public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      GMTrace.i(16745943269376L, 124767);
      super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      Paint.FontMetrics localFontMetrics = this.wis.getFontMetrics();
      float f1 = this.wit + paramInt1;
      float f2 = paramInt2;
      this.fw = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - this.wit, paramInt4);
      invalidateSelf();
      GMTrace.o(16745943269376L, 124767);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      GMTrace.i(16746211704832L, 124769);
      GMTrace.o(16746211704832L, 124769);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/ActionBarSearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */