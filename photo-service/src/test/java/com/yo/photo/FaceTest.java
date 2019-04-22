package com.yo.photo;

import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.util.StringMap;
import com.yo.photo.entity.NewBean;
import com.yo.photo.qiniu.FaceUtil;
import com.yo.photo.qiniu.ImgUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FaceTest {

    @Test
    public void fun1() throws QiniuException {
        NewBean bean = new NewBean();
        List<NewBean.DataBean> list = new ArrayList<>();
        NewBean.DataBean dataBean = new NewBean.DataBean();
        String imageStr = ImgUtil.getImageStr("C:\\Users\\Administrator\\Desktop\\本地测试\\ID库\\1.jpg");
        dataBean.setUri(imageStr);
        list.add(dataBean);
        bean.setData(list);

        Response rs = FaceUtil.getInstance().createFaceDB("student_0000001", JSON.toJSONString(bean));


    }
}
