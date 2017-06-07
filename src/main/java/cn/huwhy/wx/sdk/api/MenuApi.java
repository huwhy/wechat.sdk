package cn.huwhy.wx.sdk.api;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;

import cn.huwhy.wx.sdk.model.MenuButton;
import cn.huwhy.wx.sdk.model.Result;

public class MenuApi {

    private static final String CREATE_URI = "https://api.weixin.qq.com/cgi-bin/menu/create";

    private static final String GET_URI = "https://api.weixin.qq.com/cgi-bin/menu/get";

    public static MenuButton get(String accessToken) {
        Result result = HttpClientUtil.get(GET_URI, ImmutableMap.of("access_token", accessToken), MenuButton.class);
        return result.isOk() ? (MenuButton) result.getData() : null;
    }

    public static Result create(String accessToken, MenuButton button) throws IOException {
        return HttpClientUtil.post(CREATE_URI, accessToken, JSON.toJSONString(button));
    }

    public static void main(String[] args) throws IOException {
        String accessToken = "5DsDwC6UIpd75YzvCz20o0fpRX2XzDMwK-d1nX7U4aNKRelnmvQRCQCS-bVbpyb0ysalPvtxRot2vDY2QWOJUY2jpgfhQCfKSWYTw9PgTvgUs6O6GDTK_APC8LgL4n2gMYHjAHARDM";
//        MenuButton mb = get(accessToken);
//        Menu menu = new Menu();
//        menu.setName("第一栏");
//        Menu subMenu = new Menu();
//        subMenu.setName("第一栏1");
//        subMenu.setType("view");
//        subMenu.setUrl("http://angel.huwhy.cn/mp-article/5.html");
//        menu.setSubMenus(asList(subMenu));
//
//        Result r = create(accessToken, new MenuButton(asList(menu)));
//        System.out.println(r);
    }
}
