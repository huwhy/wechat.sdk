package cn.huwhy.wx.sdk.api;

import java.io.IOException;

import com.alibaba.fastjson.JSON;

import cn.huwhy.wx.sdk.model.TemplateMessage;

public class TemplateMessageApi {
    private static String api = "https://api.weixin.qq.com/cgi-bin/message/template/send";

    public static void send(String accessToken, TemplateMessage message) throws IOException {
        HttpClientUtil.post(api, accessToken, JSON.toJSONString(message));
    }

    public static void main(String[] args) throws IOException {
        String accessToken = "5DsDwC6UIpd75YzvCz20o0fpRX2XzDMwK-d1nX7U4aNKRelnmvQRCQCS-bVbpyb0ysalPvtxRot2vDY2QWOJUY2jpgfhQCfKSWYTw9PgTvgUs6O6GDTK_APC8LgL4n2gMYHjAHARDM";
        TemplateMessage message = new TemplateMessage();
        message.setToUser("o4FxKuCStiQwcUXrPSLxLmBtUc3s");
        message.setTemplateId("e3oiRbdIReasB8C_YmPJe_JcogsmFI7RV9cfgCUtYj8");
        message.setUrl("http://angel.huwhy.cn/mp-article/5.html");
        message.addData("name", "hudaojun", "#fff");
        send(accessToken, message);
    }
}
