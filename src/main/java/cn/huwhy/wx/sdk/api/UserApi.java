package cn.huwhy.wx.sdk.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import cn.huwhy.wx.sdk.model.Result;
import cn.huwhy.wx.sdk.model.UserInfo;
import cn.huwhy.wx.sdk.model.UserInfoList;
import cn.huwhy.wx.sdk.model.UserList;

import static com.alibaba.fastjson.JSON.toJSONString;
import static com.google.common.collect.ImmutableMap.of;

public class UserApi {

    private static String INFO_API = "https://api.weixin.qq.com/cgi-bin/user/info";
    private static String LIST_INFO_API = "https://api.weixin.qq.com/cgi-bin/user/info/batchget";
    private static String LIST_INFO_API2 = "https://api.weixin.qq.com/cgi-bin/user/get";

    public static UserInfo getUserInfo(String accessToken, String openId) {
        Result result = HttpClientUtil.get(INFO_API, of("access_token", accessToken, "openid", openId), UserInfo.class);
        return result.isOk() ? (UserInfo) result.getData() : null;
    }

    public static UserInfoList listUserInfo(String accessToken, List<String> openIds) throws IOException {
        List<OpenIdParam> params = new ArrayList<>(openIds.size());
        for (String openId : openIds) {
            params.add(new OpenIdParam(openId));
        }
        Result result = HttpClientUtil.post(LIST_INFO_API, accessToken, toJSONString(of("user_list", params)), UserInfoList.class);
        return result.isOk() ? (UserInfoList) result.getData() : null;
    }

    public static UserList listUser(String accessToken, String nextOpenId) throws IOException {
        Result result = HttpClientUtil.get(LIST_INFO_API, of("access_token", accessToken, "next_openid", nextOpenId), UserList.class);
        return result.isOk() ? (UserList) result.getData() : null;
    }

    public static void main(String[] args) throws IOException {
        String accessToken = "yLBcTWWlfHuqvfxiFdJkPNrZN8AA0kvmZwD5DhilW7DoKeXIgUW0kH2I7XDufBUW96hTDdXP2i5qUCF2DAK11z0k4M0Zkhh6BH1E0d_zuWUDNNmftDEDnZPyZ69nxtfVUPNeAEAGBZ";

        UserList userInfo = listUser(accessToken, "");
        System.out.println(toJSONString(userInfo));
    }

    static class OpenIdParam {
        @JSONField(name = "openid")
        private String openId;

        public OpenIdParam() {
        }

        public OpenIdParam(String openId) {
            this.openId = openId;
        }

        private String lang = "zh-CN";

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }
    }
}
