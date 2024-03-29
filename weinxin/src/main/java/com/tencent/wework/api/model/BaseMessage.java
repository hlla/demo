package com.tencent.wework.api.model;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.wework.api.util.ReflecterHelper;

public abstract class BaseMessage
{
  protected Context mContext = null;
  
  public static Bundle b(BaseMessage paramBaseMessage)
  {
    if (paramBaseMessage == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    paramBaseMessage.toBundle(localBundle);
    localBundle.putString("_wwobject_identifier_", paramBaseMessage.getClass().getName());
    return localBundle;
  }
  
  public static BaseMessage m(Uri paramUri)
  {
    try
    {
      paramUri = paramUri.getQueryParameter("wwoid");
      if (!TextUtils.isEmpty(paramUri))
      {
        paramUri = (BaseMessage)ReflecterHelper.newInstance(paramUri);
        return paramUri;
      }
    }
    catch (Throwable paramUri) {}
    return null;
  }
  
  public abstract boolean checkArgs();
  
  public final void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public abstract void toBundle(Bundle paramBundle);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wework/api/model/BaseMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */