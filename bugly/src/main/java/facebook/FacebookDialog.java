package com.facebook;

public abstract interface FacebookDialog<CONTENT, RESULT>
{
  public abstract boolean canShow(CONTENT paramCONTENT);
  
  public abstract void show(CONTENT paramCONTENT);
  
  public abstract void registerCallback(CallbackManager paramCallbackManager,
                                        FacebookCallback<RESULT> paramFacebookCallback);
  
  public abstract void registerCallback(CallbackManager paramCallbackManager, FacebookCallback<RESULT> paramFacebookCallback, int paramInt);
}


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */