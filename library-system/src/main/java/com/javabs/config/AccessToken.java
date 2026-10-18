package com.javabs.config;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Description
 */
public class AccessToken {

    private static String tokenUrl = "https://aip.baidubce.com/oauth/2.0/token";
    private static String grant_type = "client_credentials";
    private static String client_id = "atsck4POS3FrXcrajxNrOXmp";
    private static String client_secret ="KCkqTj62LPuqQ0PXKqa6UaN6d0s2sjOf";
    public static String getToken(){

        String url = tokenUrl+"?grant_type="+grant_type+"&client_id="+client_id+"&client_secret="+client_secret;
        String s = HttpUtils.sendPost(url, null);
        JSONObject jsonObject = JSONObject.parseObject(s);
        Object access_token = jsonObject.get("access_token");
        return access_token+"";
    }

    public static int idCard(String fileUrl,String file2Url){
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";

        String imgStr = ImgUtil.getImgStr(fileUrl);
        String imgStr2 = ImgUtil.getImgStr(file2Url);
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("image",imgStr);
        map.put("image_type","BASE64");
        Map<String,Object> map1 = new HashMap<>();
        map1.put("image",imgStr2);
        map1.put("image_type","BASE64");
        list.add(map);
        list.add(map1);
        String s = null;
        try {
            s = HttpUtil.post(url,getToken(),"application/json", GsonUtils.toJson(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(s);
        int score = 0;
        String error_code = jsonObject.get("error_code")+"";
        if("0".equals(error_code)){
            String result = jsonObject.get("result")+"";
            JSONObject res = JSONObject.parseObject(result);
            score =(int) Double.parseDouble(res.get("score")+"");
        }
        return score;
    }
    public static void main(String[] args) {

//        String s = "/profile/upload/2022/02/26/f0ca5282-8d0f-4d92-a0eb-088d8149b85c.png";
//        System.out.println(s.substring(8));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//        try {
////            String format = sdf.format("19951102");
//            Date parse = sdf.parse("19951012");
//
//            Date parse1 = sdf2.parse(sdf2.format(parse));
//            System.out.println(parse1);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        getToken();
        idCard("F:\\upload\\110.jpg","F:\\upload\\111.jpg");
    }
}
