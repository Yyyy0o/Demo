package com.yo.photo.qiniu;

import com.qiniu.common.Constants;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * Created by jemy on 2018/6/6.
 */
public class FaceUtil {

    static String ACCESS_KEY = "14_UKXBxXa6-WUZ6SUnD9MnUcHnxj8QAisYzR1ZT";
    static String SECRET_KEY = "BKNYEwpNx4D0g7p0nOffE2tKrGzls1KO12Xk8vUm";

    private final Auth auth;
    private final String host;
    private final Client client;

    private static Auth getAuth() {
        return Auth.create(ACCESS_KEY, SECRET_KEY);
    }

    public static FaceUtil getInstance() {
        return new FaceUtil(getAuth());
    }

    private FaceUtil(Auth auth) {
        this(auth, "http://ai.qiniuapi.com");
    }

    FaceUtil(Auth auth, String host) {
        this.auth = auth;
        this.host = host;
        client = new Client();
    }

    /**
     * @param id   face_id
     * @param data you can open url: https://developer.qiniu.com/dora/manual/4438/face-recognition
     * @return
     * @throws QiniuException
     */
    public Response createFaceDB(String id, String data) throws QiniuException {
        String url = String.format("%s%s%s%s", host, "/v1/face/group/", id, "/new");
        byte[] body = data.getBytes(Constants.UTF_8);
        StringMap headers = auth.authorizationV2(url, "POST", body, Client.JsonMime);
        return client.post(url, body, headers, Client.JsonMime);
    }

    public Response deleteFaceDB(String id) throws QiniuException {
        String url = String.format("%s%s%s%s", host, "/v1/face/group/", id, "/remove");
        StringMap headers = auth.authorizationV2(url, "POST", null, null);
        return client.post(url, null, headers, Client.JsonMime);
    }

    public Response listFaceDB() throws QiniuException {
        String url = String.format("%s%s", host, "/v1/face/group");
        StringMap headers = auth.authorizationV2(url);
        return client.get(url, headers);
    }

    public Response createFace(String id, String data) throws QiniuException {
        String url = String.format("%s%s%s%s", host, "/v1/face/group/", id, "/add");
        byte[] body = data.getBytes(Constants.UTF_8);
        StringMap headers = auth.authorizationV2(url, "POST", body, Client.JsonMime);
        return client.post(url, body, headers, Client.JsonMime);
    }

    public Response getFace(String id) throws QiniuException {
        String url = String.format("%s%s%s", host, "/v1/face/group/", id);
        StringMap headers = auth.authorizationV2(url);
        return client.get(url, headers);
    }

    public Response deleteFace(String id, String data) throws QiniuException {
        String url = String.format("%s%s%s%s", host, "/v1/face/group/", id, "/delete");
        byte[] body = data.getBytes(Constants.UTF_8);
        StringMap headers = auth.authorizationV2(url, "POST", body, Client.JsonMime);
        return client.post(url, body, headers, Client.JsonMime);
    }

    public Response compareFace(String id, String data) throws QiniuException {
        String url = String.format("%s%s%s%s", host, "/v1/face/group/", id, "/search");
        byte[] body = data.getBytes(Constants.UTF_8);
        StringMap headers = auth.authorizationV2(url, "POST", body, Client.JsonMime);
        return client.post(url, body, headers, Client.JsonMime);
    }

    /**
     * 1:1 人脸比对
     *
     * @param data
     * @return
     * @throws QiniuException
     */
    public Response compareFaceByOne(String data) throws QiniuException {
        String url = String.format("%s%s", "http://ai.qiniuapi.com", "/v1/face/sim");
        byte[] body = data.getBytes(Constants.UTF_8);
        StringMap headers = auth.authorizationV2(url, "POST", body, Client.JsonMime);
        return client.post(url, body, headers, Client.JsonMime);
    }

    //人脸识别
    public Response serchFaceByOne(String data) throws QiniuException {
        String url = String.format("%s%s", "http://ai.qiniuapi.com", "/v1/face/detect");
        byte[] body = data.getBytes(Constants.UTF_8);
        StringMap headers = auth.authorizationV2(url, "POST", body, Client.JsonMime);
        return client.post(url, body, headers, Client.JsonMime);
    }
}
