package com.facebook;

public abstract interface FacebookCallback<RESULT>
{
  public abstract void onSuccess(RESULT paramRESULT);
  
  public abstract void onCancel();
  
  public abstract void onError(FacebookException paramFacebookException);
}


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookCallback.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */