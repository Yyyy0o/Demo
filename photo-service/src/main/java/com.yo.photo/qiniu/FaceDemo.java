package com.yo.photo.qiniu;

import com.alibaba.fastjson.JSONArray;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.util.StringMap;
import com.yo.photo.qiniu.FaceUtil;
import com.yo.photo.qiniu.ImgUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FaceDemo {

    //创建一个ID库
    public void createFaceDB() throws QiniuException {
        String id = "ctmoon001";//人脸的DB库ID
        Map<String, List<Map<String, Object>>> dataMap = new HashMap<String, List<Map<String, Object>>>();

        Map<String, Object> m1 = new HashMap<String, Object>();
        m1.put("uri", "http://file.360kinder.com/ldl1.jpg");
        List<Map<String, Object>> listdata = new ArrayList<Map<String, Object>>();
        listdata.add(m1);

        dataMap.put("data", listdata);
        JSONArray js = new JSONArray();
        String data = js.toJSONString(dataMap);
        System.err.println("data == " + data);

        Response rs = FaceUtil.getInstance().createFaceDB(id, data);
        StringMap sm = rs.jsonToMap();
        System.err.println("errors === " + sm.get("errors").toString());
        System.err.println("faces === " + sm.get("faces").toString());
        System.err.println("attributes === " + sm.get("attributes").toString());
    }


    //往这个ID库里面添加标准照片
    public void addImgToFaceDB() throws QiniuException {
        String id = "ctmoon001";//人脸的DB库ID
        Map<String, List<Map<String, Object>>> dataMap = new HashMap<String, List<Map<String, Object>>>();
        List<Map<String, Object>> listdata = new ArrayList<Map<String, Object>>();
        String folder = "C:/Users/Administrator/Desktop/ID库";
        //然后再删除所有 E:/PDF 下的PDF
        File rootfilee = new File(folder);
        File[] filess = rootfilee.listFiles();
        //遍历删除文件
        for (File file : filess) {
            String uri = ImgUtil.getImageStr(file.getPath());
            Map<String, Object> mapp = new HashMap<String, Object>();
            mapp.put("uri", "data:application/octet-stream;base64," + uri);
            listdata.add(mapp);
        }
        dataMap.put("data", listdata);
        JSONArray js = new JSONArray();
        String data = js.toJSONString(dataMap);

        Response rs = FaceUtil.getInstance().createFace(id, data);
        StringMap sm = rs.jsonToMap();
        System.err.println("errors === " + sm.get("errors").toString());
        System.err.println("faces === " + sm.get("faces").toString());
        System.err.println("attributes === " + sm.get("attributes").toString());
    }


    //删除某个库，以及库内的所有图片
    public void deleteFaceDB() throws QiniuException {
        String id = "ctmoon001";//人脸的DB库ID
        Response rs = FaceUtil.getInstance().deleteFaceDB(id);
        StringMap sm = rs.jsonToMap();
    }


    //显示某个库内的所有图片
    public void showFaceDB() throws QiniuException {
        String id = "ctmoon001";//人脸的DB库ID
        Response rs = FaceUtil.getInstance().getFace(id);
        StringMap sm = rs.jsonToMap();
        System.err.println("code === " + sm.get("code").toString());
        System.err.println("message === " + sm.get("message").toString());
        System.err.println("result === " + sm.get("result").toString());

    }


    //拿一张/多张 图片，去某个库里进行 匹配，返回所有人脸相似度最高的IDs
    public void compareFace() throws Exception {
        List<Map<String, Object>> imgFolderList = new ArrayList<Map<String, Object>>();
        String id = "ctmoon001";//人脸的DB库ID

        String folder = "C:/Users/Administrator/Desktop/混合照片";
        File rootfilee = new File(folder);
        File[] filess = rootfilee.listFiles();

        //遍历删除文件
        List<String> urllist = new ArrayList<String>();
        /*for(int i=1;i<10;i++){
        	String str = "ctmoontest00"+i+".jpg";
        	urllist.add(str);
        }*/
        for (int i = 20; i < 49; i++) {
            String str = "ctmoontest0" + i + ".jpg";
            urllist.add(str);
        }


        for (String key : urllist) {
            //上传给7牛云
            //String key = DigestUtils.md5Hex(Math.random()+"") + ".jpg";
            //fileServiceI.uploadFileToQN(file.getPath(),key);
            String imgurl = "http://file.360kinder.com/" + key;

            String data = "{\"data\": {\"uri\": \"" + imgurl + "\"},\"params\": {\"groups\": [\"ctmoon001\"],\"limit\": 5,\"threshold\": 0.90,\"use_quality\": true,\"mode\": \"ALL\"}}";
            Response rs = FaceUtil.getInstance().compareFace(id, data);
            StringMap sm = rs.jsonToMap();
            String code = sm.get("code").toString();
            if ("0.0".equals(code)) {
                String result = sm.get("result").toString();//里面有个 faces 是人脸列表
                Pattern p = Pattern.compile("id=(.*?)score");
                Matcher m = p.matcher(result);
                while (m.find()) {
                    String reid = m.group(1).replaceAll(",", "");
                    String trueID = reid.replaceAll(" ", "");
                    if (trueID != null && !"".equals(trueID)) {
                        Map<String, Object> idMap = new HashMap<String, Object>();
                        idMap.put("id", trueID);
                        idMap.put("url", imgurl);
                        imgFolderList.add(idMap);
                    }
                }
            }
        }


        //把图片分类存储
        if (imgFolderList != null && imgFolderList.size() != 0) {
            //String folderr = "C:/Users/Administrator/Desktop/123";
            for (Map<String, Object> idMap : imgFolderList) {
                String idstr = idMap.get("id").toString();
                String imgurl = idMap.get("url").toString();
                File file = new File("C:/Users/Administrator/Desktop/123/" + idstr);
                if (!file.exists()) {//如果文件夹不存在
                    file.mkdir();//创建文件夹
                    //创建文件夹的时候，就把ID库对应的那种图片放进去

                }

                //把这个 imgurl 图片 写入到 这个 file 中即可
                URL uri = new URL(imgurl);
                InputStream in = uri.openStream();
                FileOutputStream fo = new FileOutputStream(new File(file.getPath() + "/" + System.currentTimeMillis() + ".jpg"));//文件输出流
                byte[] buf = new byte[1024];
                int length = 0;
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                //关闭流
                in.close();
                fo.close();
            }
        }
    }
}
