package com.woniu.test;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import java.util.*;
import com.aliyuncs.facebody.model.v20191230.*;

public class DetectMask {

    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        DetectMaskRequest request = new DetectMaskRequest();
        request.setRegionId("cn-shanghai");
        request.setImageURL("https://viapi-test.oss-cn-shanghai.aliyuncs.com/test-team/tiankong/1%E5%8F%A3%E7%BD%A9%E8%AF%86%E5%88%AB.jpg");

        try {
            DetectMaskResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }
}