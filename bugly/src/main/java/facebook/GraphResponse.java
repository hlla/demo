/*     */ package com.facebook;
/*     */ 
/*     */ import com.facebook.internal.Logger;
/*     */ import com.facebook.internal.Utility;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ import org.json.JSONTokener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GraphResponse
/*     */ {
/*     */   private final HttpURLConnection connection;
/*     */   private final JSONObject graphObject;
/*     */   private final JSONArray graphObjectArray;
/*     */   private final FacebookRequestError error;
/*     */   private final String rawResponse;
/*     */   private final GraphRequest request;
/*     */   public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
/*     */   public static final String SUCCESS_KEY = "success";
/*     */   private static final String CODE_KEY = "code";
/*     */   private static final String BODY_KEY = "body";
/*     */   private static final String RESPONSE_LOG_TAG = "Response";
/*     */   
/*     */   GraphResponse(GraphRequest request, HttpURLConnection connection, String rawResponse, JSONObject graphObject)
/*     */   {
/*  73 */     this(request, connection, rawResponse, graphObject, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   GraphResponse(GraphRequest request, HttpURLConnection connection, String rawResponse, JSONArray graphObjects)
/*     */   {
/*  81 */     this(request, connection, rawResponse, null, graphObjects, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   GraphResponse(GraphRequest request, HttpURLConnection connection, FacebookRequestError error)
/*     */   {
/*  88 */     this(request, connection, null, null, null, error);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   GraphResponse(GraphRequest request, HttpURLConnection connection, String rawResponse, JSONObject graphObject, JSONArray graphObjects, FacebookRequestError error)
/*     */   {
/*  98 */     this.request = request;
/*  99 */     this.connection = connection;
/* 100 */     this.rawResponse = rawResponse;
/* 101 */     this.graphObject = graphObject;
/* 102 */     this.graphObjectArray = graphObjects;
/* 103 */     this.error = error;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final FacebookRequestError getError()
/*     */   {
/* 112 */     return this.error;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final JSONObject getJSONObject()
/*     */   {
/* 122 */     return this.graphObject;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final JSONArray getJSONArray()
/*     */   {
/* 133 */     return this.graphObjectArray;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final HttpURLConnection getConnection()
/*     */   {
/* 143 */     return this.connection;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GraphRequest getRequest()
/*     */   {
/* 152 */     return this.request;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRawResponse()
/*     */   {
/* 161 */     return this.rawResponse;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum PagingDirection
/*     */   {
/* 171 */     NEXT, 
/*     */     
/*     */ 
/*     */ 
/* 175 */     PREVIOUS;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private PagingDirection() {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GraphRequest getRequestForPagedResults(PagingDirection direction)
/*     */   {
/* 188 */     String link = null;
/* 189 */     if (this.graphObject != null) {
/* 190 */       JSONObject pagingInfo = this.graphObject.optJSONObject("paging");
/* 191 */       if (pagingInfo != null) {
/* 192 */         if (direction == PagingDirection.NEXT) {
/* 193 */           link = pagingInfo.optString("next");
/*     */         } else {
/* 195 */           link = pagingInfo.optString("previous");
/*     */         }
/*     */       }
/*     */     }
/* 199 */     if (Utility.isNullOrEmpty(link)) {
/* 200 */       return null;
/*     */     }
/*     */     
/* 203 */     if ((link != null) && (link.equals(this.request.getUrlForSingleRequest())))
/*     */     {
/*     */ 
/* 206 */       return null;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 211 */       pagingRequest = new GraphRequest(this.request.getAccessToken(), new URL(link));
/*     */     } catch (MalformedURLException e) { GraphRequest pagingRequest;
/* 213 */       return null;
/*     */     }
/*     */     GraphRequest pagingRequest;
/* 216 */     return pagingRequest;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/*     */     String responseCode;
/*     */     
/*     */     try
/*     */     {
/* 226 */       responseCode = String.format(Locale.US, "%d", new Object[] {
/*     */       
/*     */ 
/* 229 */         Integer.valueOf(this.connection != null ? this.connection.getResponseCode() : 200) });
/*     */     } catch (IOException e) { String responseCode;
/* 231 */       responseCode = "unknown";
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 243 */     return "{Response: " + " responseCode: " + responseCode + ", graphObject: " + this.graphObject + ", error: " + this.error + "}";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static List<GraphResponse> fromHttpConnection(HttpURLConnection connection, GraphRequestBatch requests)
/*     */   {
/* 250 */     InputStream stream = null;
/*     */     try
/*     */     {
/* 253 */       if (connection.getResponseCode() >= 400) {
/* 254 */         stream = connection.getErrorStream();
/*     */       } else {
/* 256 */         stream = connection.getInputStream();
/*     */       }
/*     */       
/* 259 */       return createResponsesFromStream(stream, connection, requests);
/*     */     } catch (FacebookException facebookException) {
/* 261 */       Logger.log(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[] { facebookException });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 266 */       return constructErrorResponses(requests, connection, facebookException);
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/*     */       List localList2;
/*     */       
/* 272 */       Logger.log(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[] { exception });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 277 */       return constructErrorResponses(requests, connection, new FacebookException(exception));
/*     */     } finally {
/* 279 */       Utility.closeQuietly(stream);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<GraphResponse> createResponsesFromStream(InputStream stream, HttpURLConnection connection, GraphRequestBatch requests)
/*     */     throws FacebookException, JSONException, IOException
/*     */   {
/* 289 */     String responseString = Utility.readStreamToString(stream);
/* 290 */     Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[] {
/* 291 */       Integer.valueOf(responseString.length()), responseString });
/*     */     
/*     */ 
/* 294 */     return createResponsesFromString(responseString, connection, requests);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static List<GraphResponse> createResponsesFromString(String responseString, HttpURLConnection connection, GraphRequestBatch requests)
/*     */     throws FacebookException, JSONException, IOException
/*     */   {
/* 302 */     JSONTokener tokener = new JSONTokener(responseString);
/* 303 */     Object resultObject = tokener.nextValue();
/*     */     
/* 305 */     List<GraphResponse> responses = createResponsesFromObject(connection, requests, resultObject);
/*     */     
/*     */ 
/*     */ 
/* 309 */     Logger.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[] {requests
/*     */     
/*     */ 
/*     */ 
/* 313 */       .getId(), 
/* 314 */       Integer.valueOf(responseString.length()), responses });
/*     */     
/*     */ 
/* 317 */     return responses;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static List<GraphResponse> createResponsesFromObject(HttpURLConnection connection, List<GraphRequest> requests, Object object)
/*     */     throws FacebookException, JSONException
/*     */   {
/* 325 */     int numRequests = requests.size();
/* 326 */     List<GraphResponse> responses = new ArrayList(numRequests);
/* 327 */     Object originalResult = object;
/*     */     
/* 329 */     if (numRequests == 1) {
/* 330 */       GraphRequest request = (GraphRequest)requests.get(0);
/*     */       
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 336 */         JSONObject jsonObject = new JSONObject();
/* 337 */         jsonObject.put("body", object);
/* 338 */         int responseCode = connection != null ? connection.getResponseCode() : 200;
/* 339 */         jsonObject.put("code", responseCode);
/*     */         
/* 341 */         JSONArray jsonArray = new JSONArray();
/* 342 */         jsonArray.put(jsonObject);
/*     */         
/*     */ 
/* 345 */         object = jsonArray;
/*     */       } catch (JSONException e) {
/* 347 */         responses.add(new GraphResponse(request, connection, new FacebookRequestError(connection, e)));
/*     */ 
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/*     */ 
/* 353 */         responses.add(new GraphResponse(request, connection, new FacebookRequestError(connection, e)));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 361 */     if ((!(object instanceof JSONArray)) || (((JSONArray)object).length() != numRequests)) {
/* 362 */       throw new FacebookException("Unexpected number of results");
/*     */     }
/*     */     
/* 365 */     JSONArray jsonArray = (JSONArray)object;
/*     */     
/* 367 */     for (int i = 0; i < jsonArray.length(); i++) {
/* 368 */       GraphRequest request = (GraphRequest)requests.get(i);
/*     */       try {
/* 370 */         Object obj = jsonArray.get(i);
/* 371 */         responses.add(
/* 372 */           createResponseFromObject(request, connection, obj, originalResult));
/*     */ 
/*     */       }
/*     */       catch (JSONException e)
/*     */       {
/*     */ 
/* 378 */         responses.add(new GraphResponse(request, connection, new FacebookRequestError(connection, e)));
/*     */ 
/*     */       }
/*     */       catch (FacebookException e)
/*     */       {
/*     */ 
/* 384 */         responses.add(new GraphResponse(request, connection, new FacebookRequestError(connection, e)));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 392 */     return responses;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static GraphResponse createResponseFromObject(GraphRequest request, HttpURLConnection connection, Object object, Object originalResult)
/*     */     throws JSONException
/*     */   {
/* 401 */     if ((object instanceof JSONObject)) {
/* 402 */       JSONObject jsonObject = (JSONObject)object;
/*     */       
/*     */ 
/* 405 */       FacebookRequestError error = FacebookRequestError.checkResponseAndCreateError(jsonObject, originalResult, connection);
/*     */       
/*     */ 
/*     */ 
/* 409 */       if (error != null) {
/* 410 */         if ((error.getErrorCode() == 190) && 
/* 411 */           (Utility.isCurrentAccessToken(request.getAccessToken()))) {
/* 412 */           AccessToken.setCurrentAccessToken(null);
/*     */         }
/* 414 */         return new GraphResponse(request, connection, error);
/*     */       }
/*     */       
/* 417 */       Object body = Utility.getStringPropertyAsJSON(jsonObject, "body", "FACEBOOK_NON_JSON_RESULT");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 422 */       if ((body instanceof JSONObject))
/* 423 */         return new GraphResponse(request, connection, body.toString(), (JSONObject)body);
/* 424 */       if ((body instanceof JSONArray)) {
/* 425 */         return new GraphResponse(request, connection, body.toString(), (JSONArray)body);
/*     */       }
/*     */       
/* 428 */       object = JSONObject.NULL;
/*     */     }
/*     */     
/* 431 */     if (object == JSONObject.NULL) {
/* 432 */       return new GraphResponse(request, connection, object.toString(), (JSONObject)null);
/*     */     }
/*     */     
/* 435 */     throw new FacebookException("Got unexpected object type in response, class: " + object.getClass().getSimpleName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<GraphResponse> constructErrorResponses(List<GraphRequest> requests, HttpURLConnection connection, FacebookException error)
/*     */   {
/* 443 */     int count = requests.size();
/* 444 */     List<GraphResponse> responses = new ArrayList(count);
/* 445 */     for (int i = 0; i < count; i++)
/*     */     {
/* 447 */       GraphResponse response = new GraphResponse((GraphRequest)requests.get(i), connection, new FacebookRequestError(connection, error));
/*     */       
/*     */ 
/* 450 */       responses.add(response);
/*     */     }
/* 452 */     return responses;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/GraphResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */