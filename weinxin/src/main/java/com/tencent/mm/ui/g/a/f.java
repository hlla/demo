package com.tencent.mm.ui.g.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class f
  extends i
{
  static final float[] wel;
  static final float[] wem;
  static final FrameLayout.LayoutParams wen;
  private String mUrl;
  private MMWebView qhz;
  private c.a weo;
  private ProgressDialog wep;
  private ImageView weq;
  private FrameLayout wer;
  
  static
  {
    GMTrace.i(2911853608960L, 21695);
    wel = new float[] { 20.0F, 60.0F };
    wem = new float[] { 40.0F, 60.0F };
    wen = new FrameLayout.LayoutParams(-1, -1);
    GMTrace.o(2911853608960L, 21695);
  }
  
  public f(Context paramContext, String paramString, c.a parama)
  {
    super(paramContext, 16973840);
    GMTrace.i(2910779867136L, 21687);
    this.mUrl = paramString;
    this.weo = parama;
    GMTrace.o(2910779867136L, 21687);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2910914084864L, 21688);
    super.onCreate(paramBundle);
    this.wep = new ProgressDialog(getContext());
    this.wep.requestWindowFeature(1);
    this.wep.setMessage(getContext().getString(a.g.kCs));
    requestWindowFeature(1);
    this.wer = new FrameLayout(getContext());
    this.weq = new ImageView(getContext());
    this.weq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2908498165760L, 21670);
        f.a(f.this).onCancel();
        f.this.dismiss();
        GMTrace.o(2908498165760L, 21670);
      }
    });
    paramBundle = getContext().getResources().getDrawable(a.c.kBN);
    this.weq.setImageDrawable(paramBundle);
    this.weq.setVisibility(4);
    int i = this.weq.getDrawable().getIntrinsicWidth() / 2;
    paramBundle = new LinearLayout(getContext());
    this.qhz = MMWebView.a.fi(getContext());
    this.qhz.setVerticalScrollBarEnabled(false);
    this.qhz.setHorizontalScrollBarEnabled(false);
    this.qhz.setWebViewClient(new a());
    this.qhz.getSettings().setJavaScriptEnabled(true);
    this.qhz.loadUrl(this.mUrl);
    this.qhz.setLayoutParams(wen);
    this.qhz.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.qhz);
    this.wer.addView(paramBundle);
    this.wer.addView(this.weq, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.wer, new ViewGroup.LayoutParams(-1, -1));
    GMTrace.o(2910914084864L, 21688);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2911048302592L, 21689);
    if (paramInt == 4)
    {
      this.weo.onCancel();
      dismiss();
      GMTrace.o(2911048302592L, 21689);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2911048302592L, 21689);
    return bool;
  }
  
  private final class a
    extends WebViewClient
  {
    public boolean wet;
    
    public a()
    {
      GMTrace.i(2907155988480L, 21660);
      this.wet = true;
      GMTrace.o(2907155988480L, 21660);
    }
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      GMTrace.i(2907692859392L, 21664);
      super.onPageFinished(paramWebView, paramString);
      this.wet = false;
      try
      {
        f.b(f.this).dismiss();
        f.c(f.this).setBackgroundColor(0);
        f.d(f.this).setVisibility(0);
        f.e(f.this).setVisibility(0);
        GMTrace.o(2907692859392L, 21664);
        return;
      }
      catch (Exception paramWebView)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        }
      }
    }
    
    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      GMTrace.i(2907558641664L, 21663);
      v.d("Facebook-WebView", "Webview loading URL: " + paramString);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      try
      {
        f.b(f.this).show();
        f.b(f.this).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(2910377213952L, 21684);
            if ((f.a.this.wet) && (f.this != null))
            {
              f.a(f.this).onCancel();
              f.this.dismiss();
            }
            GMTrace.o(2910377213952L, 21684);
          }
        });
        GMTrace.o(2907558641664L, 21663);
        return;
      }
      catch (Exception paramWebView)
      {
        v.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        GMTrace.o(2907558641664L, 21663);
      }
    }
    
    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      GMTrace.i(2907424423936L, 21662);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      this.wet = false;
      f.a(f.this).a(new b(paramString1, paramInt, paramString2));
      try
      {
        f.this.dismiss();
        f.b(f.this).dismiss();
        GMTrace.o(2907424423936L, 21662);
        return;
      }
      catch (Exception paramWebView)
      {
        v.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        GMTrace.o(2907424423936L, 21662);
      }
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      GMTrace.i(2907290206208L, 21661);
      v.d("Facebook-WebView", "Redirect URL: " + paramString);
      if (paramString.startsWith("fbconnect://success"))
      {
        Bundle localBundle = e.TZ(paramString);
        paramString = localBundle.getString("error");
        paramWebView = paramString;
        if (paramString == null) {
          paramWebView = localBundle.getString("error_type");
        }
        if (paramWebView == null) {
          f.a(f.this).m(localBundle);
        }
        for (;;)
        {
          f.this.dismiss();
          GMTrace.o(2907290206208L, 21661);
          return true;
          if ((paramWebView.equals("access_denied")) || (paramWebView.equals("OAuthAccessDeniedException"))) {
            f.a(f.this).onCancel();
          } else {
            f.a(f.this).a(new d(paramWebView));
          }
        }
      }
      if (paramString.startsWith("fbconnect://cancel"))
      {
        f.a(f.this).onCancel();
        try
        {
          f.this.dismiss();
          GMTrace.o(2907290206208L, 21661);
          return true;
        }
        catch (Exception paramWebView)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
          }
        }
      }
      if (paramString.contains("touch"))
      {
        GMTrace.o(2907290206208L, 21661);
        return false;
      }
      f.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      GMTrace.o(2907290206208L, 21661);
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/g/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */