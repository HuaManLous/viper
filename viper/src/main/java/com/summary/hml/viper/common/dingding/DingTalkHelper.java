package com.summary.hml.viper.common.dingding;

import com.aliyun.credentials.utils.StringUtils;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 钉钉机器人消息通知
 * @Author chao.xu
 * @date 6/14/2022 19:54 PM
 */
@Slf4j
public class DingTalkHelper {

    /**
     * 钉钉群设置 webhook,
     */
    private static final String ACCESS_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=a6d350228c027b2a2928d9d249dccee854b343a4441e87f0cf0dcd04a18b3601";
    //private static final String ACCESS_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=a7235b2f2059fed692923dafc797a2bdffc53c463a1ec55e95c1202c3cf1c2f6";

    /**
     * 钉钉群设置 webhook, 加签
     */
    private static final String SECRET = "SEC0c2f6534bccebe2b23d07b77226203d2c0e793430b04b6c0a7f3a1de0468bb3a";
    //private static final String SECRET = "SECb086ce03b41ab43c3384d9e2b17f9bf59cc264a121be1ea7c05f10da292e0110";

    /**
     * 消息类型
     */
    private static final String MSG_TYPE_TEXT = "text";
    private static final String MSG_TYPE_LINK = "link";
    private static final String MSG_TYPE_MARKDOWN = "markdown";
    private static final String MSG_TYPE_ACTION_CARD = "actionCard";
    private static final String MSG_TYPE_FEED_CARD = "feedCard";
 
    /**
     * 客户端实例
     */
    public static DingTalkClient client;

    /**
     * 静态代码块  ==> 类加载时调用一次
     */
    static {
        try {
            client = new DefaultDingTalkClient(ACCESS_TOKEN + sign());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        // 文档演示的例子
        // sdkDemoJava();

        List<String> list = new ArrayList<>();
        list.add("18338354114");
        list.add("18337253581");
        sendMessageByText("测试环境：" + "RedissonConfiguration异常 {\"errCode\": 310000}", list, false);
    }

    /**
     * 因为钉钉中选择了加签，所系需要签名  ==> 如果没有选择加签可以不用这个签名
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     */
    public static String sign() throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Long timestamp = System.currentTimeMillis();
        String stringToSign = timestamp + "\n" + SECRET;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(SECRET.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        return "&timestamp=" + timestamp + "&sign=" + sign;
    }

    /**
     * @description: 官方演示示例
     * title 是消息列表下透出的标题
     * text 是进入群后看到的消息内容
     * @author: chao.xu
     * @date: 2022/06/14
     */
    public static void sdkDemoJava() {

        DingTalkClient client = DingTalkHelper.client;
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("我以修罗成武神.text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("测试");
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Arrays.asList("+86-18338354114","+86-18258477710"));
        request.setAt(at);
 
        request.setMsgtype("link");
        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
        link.setMessageUrl("https://www.dingtalk.com/");
        link.setPicUrl("");
        link.setTitle("我以修罗成武神.link");
        link.setText("修罗武神");
        request.setLink(link);

        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("我以修罗成武神.markdown");
        markdown.setText("修罗武神");
        request.setMarkdown(markdown);
        try {
            client.execute(request);
        } catch (ApiException e) {
            log.error("[ApiException]: 消息发送演示示例, 异常捕获{}", e.getMessage());
        }
    }
 
    /**
     * @param content    文本消息
     * @param mobileList 指定@ 联系人
     * @param isAtAll    是否@ 全部联系人
     * @description: 发送普通文本消息
     * @return: com.dingtalk.api.response.OapiRobotSendResponse
     * @author: niaonao
     * @date: 2019/7/6
     */
    public static OapiRobotSendResponse sendMessageByText(String content, List<String> mobileList, boolean isAtAll) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        //参数	参数类型	必须	说明
        //msgtype	String	是	消息类型，此时固定为：text
        //content	String	是	消息内容
        //atMobiles	Array	否	被@人的手机号(在content里添加@人的手机号)
        //isAtAll	bool	否	@所有人时：true，否则为：false
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(content);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        if (!CollectionUtils.isEmpty(mobileList)) {
            // 发送消息并@ 以下手机号联系人
            OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
            at.setAtMobiles(mobileList);
            at.setIsAtAll(isAtAll);
            request.setAt(at);
        }
        request.setMsgtype(DingTalkHelper.MSG_TYPE_TEXT);
        request.setText(text);
 
        OapiRobotSendResponse response = new OapiRobotSendResponse();
        try {
            response = DingTalkHelper.client.execute(request);
        } catch (ApiException e) {
            log.error("[发送普通文本消息]: 发送消息失败, 异常捕获{}", e.getMessage());
        }
        return response;
    }
 
    /**
     * @param title      消息标题
     * @param text       消息内容
     * @param messageUrl 点击消息后跳转的url
     * @param picUrl     插入图片的url
     * @description: 发送link 类型消息
     * @return: com.dingtalk.api.response.OapiRobotSendResponse
     * @author: niaonao
     * @date: 2019/7/6
     */
    public static OapiRobotSendResponse sendMessageByLink(String title, String text, String messageUrl, String picUrl) {
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(text) || StringUtils.isEmpty(messageUrl)) {
            return null;
        }
        //参数	参数类型	必须	说明
        //msgtype	String	是	消息类型，此时固定为：link
        //title	String	是	消息标题
        //text	String	是	消息内容。如果太长只会部分展示
        //messageUrl	String	是	点击消息跳转的URL
        //picUrl	String	否	图片URL
        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
        link.setTitle(title);
        link.setText(text);
        link.setMessageUrl(messageUrl);
        link.setPicUrl(picUrl);
 
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype(DingTalkHelper.MSG_TYPE_LINK);
        request.setLink(link);
 
        OapiRobotSendResponse response = new OapiRobotSendResponse();
        try {
            response = DingTalkHelper.client.execute(request);
        } catch (ApiException e) {
            log.error("[发送link 类型消息]: 发送消息失败, 异常捕获{}", e.getMessage());
        }
        return response;
    }
 
 
    /**
     * @param title        标题
     * @param markdownText 支持markdown 编辑格式的文本信息
     * @param mobileList   消息@ 联系人
     * @param isAtAll      是否@ 全部
     * @description: 发送Markdown 编辑格式的消息
     * @return: com.dingtalk.api.response.OapiRobotSendResponse
     * @author: niaonao
     * @date: 2019/7/6
     */
    public static OapiRobotSendResponse sendMessageByMarkdown(String title, String markdownText, List<String> mobileList, boolean isAtAll) {
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(markdownText)) {
            return null;
        }
        //参数	类型	必选	说明
        //msgtype	String	是	此消息类型为固定markdown
        //title	String	是	首屏会话透出的展示内容
        //text	String	是	markdown格式的消息
        //atMobiles	Array	否	被@人的手机号(在text内容里要有@手机号)
        //isAtAll	bool	否	@所有人时：true，否则为：false
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle(title);
        markdown.setText(markdownText);
 
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype(DingTalkHelper.MSG_TYPE_MARKDOWN);
        request.setMarkdown(markdown);
        if (!CollectionUtils.isEmpty(mobileList)) {
            OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
            at.setIsAtAll(isAtAll);
            at.setAtMobiles(mobileList);
            request.setAt(at);
        }
 
        OapiRobotSendResponse response = new OapiRobotSendResponse();
        try {
            response = DingTalkHelper.client.execute(request);
        } catch (ApiException e) {
            log.error("[发送link 类型消息]: 发送消息失败, 异常捕获{}", e.getMessage());
        }
        return response;
    }
 
    /**
     * @param title          消息标题, 会话消息会展示标题
     * @param markdownText   markdown格式的消息
     * @param singleTitle    单个按钮的标题
     * @param singleURL      单个按钮的跳转链接
     * @param btnOrientation 是否横向排列(true 横向排列, false 纵向排列)
     * @param hideAvatar     是否隐藏发消息者头像(true 隐藏头像, false 不隐藏)
     * @description: 整体跳转ActionCard类型的消息发送
     * @return: com.dingtalk.api.response.OapiRobotSendResponse
     * @author: niaonao
     * @date: 2019/7/6
     */
    public static OapiRobotSendResponse sendMessageByActionCardSingle(String title, String markdownText, String singleTitle, String singleURL, boolean btnOrientation, boolean hideAvatar) {
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(markdownText)) {
            return null;
        }
        //参数	类型	必选	说明
        //    msgtype	string	true	此消息类型为固定actionCard
        //    title	string	true	首屏会话透出的展示内容
        //    text	string	true	markdown格式的消息
        //    singleTitle	string	true	单个按钮的方案。(设置此项和singleURL后btns无效)
        //    singleURL	string	true	点击singleTitle按钮触发的URL
        //    btnOrientation	string	false	0-按钮竖直排列，1-按钮横向排列
        //    hideAvatar	string	false	0-正常发消息者头像，1-隐藏发消息者头像
        OapiRobotSendRequest.Actioncard actionCard = new OapiRobotSendRequest.Actioncard();
        actionCard.setTitle(title);
        actionCard.setText(markdownText);
        actionCard.setSingleTitle(singleTitle);
        actionCard.setSingleURL(singleURL);
        // 此处默认为0
        actionCard.setBtnOrientation(btnOrientation ? "1" : "0");
        // 此处默认为0
        actionCard.setHideAvatar(hideAvatar ? "1" : "0");
 
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype(DingTalkHelper.MSG_TYPE_ACTION_CARD);
        request.setActionCard(actionCard);
        OapiRobotSendResponse response = new OapiRobotSendResponse();
        try {
            response = DingTalkHelper.client.execute(request);
        } catch (ApiException e) {
            log.error("[发送ActionCard 类型消息]: 整体跳转ActionCard类型的发送消息失败, 异常捕获{}", e.getMessage());
        }
        return response;
    }
 
    /**
     * @param title          标题
     * @param markdownText   文本
     * @param btns           按钮列表
     * @param btnOrientation 是否横向排列(true 横向排列, false 纵向排列)
     * @param hideAvatar     是否隐藏发消息者头像(true 隐藏头像, false 不隐藏)
     * @description: 独立跳转ActionCard类型 消息发送
     * @return: com.dingtalk.api.response.OapiRobotSendResponse
     * @author: niaonao
     * @date: 2019/7/6
     */
    public static OapiRobotSendResponse sendMessageByActionCardMulti(String title, String markdownText, List<OapiRobotSendRequest.Btns> btns, boolean btnOrientation, boolean hideAvatar) {
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(markdownText) || CollectionUtils.isEmpty(btns)) {
            return null;
        }
        //参数	类型	必选	说明
        //msgtype	string	true	此消息类型为固定actionCard
        //title	string	true	首屏会话透出的展示内容
        //text	string	true	markdown格式的消息
        //btns	array	true	按钮的信息：title-按钮方案，actionURL-点击按钮触发的URL
        //btnOrientation	string	false	0-按钮竖直排列，1-按钮横向排列
        //hideAvatar	string	false	0-正常发消息者头像，1-隐藏发消息者头像
        OapiRobotSendRequest.Actioncard actionCard = new OapiRobotSendRequest.Actioncard();
        actionCard.setTitle(title);
        actionCard.setText(markdownText);
        // 此处默认为0
        actionCard.setBtnOrientation(btnOrientation ? "1" : "0");
        // 此处默认为0
        actionCard.setHideAvatar(hideAvatar ? "1" : "0");
 
        actionCard.setBtns(btns);
 
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype(DingTalkHelper.MSG_TYPE_ACTION_CARD);
        request.setActionCard(actionCard);
        OapiRobotSendResponse response = new OapiRobotSendResponse();
        try {
            response = DingTalkHelper.client.execute(request);
        } catch (ApiException e) {
            log.error("[发送ActionCard 类型消息]: 独立跳转ActionCard类型发送消息失败, 异常捕获{}", e.getMessage());
        }
        return response;
    }
 
    /**
     * @param links
     * @description: 发送FeedCard类型消息
     * @return: com.dingtalk.api.response.OapiRobotSendResponse
     * @author: niaonao
     * @date: 2019/7/6
     */
    public static OapiRobotSendResponse sendMessageByFeedCard(List<OapiRobotSendRequest.Links> links) {
        if (CollectionUtils.isEmpty(links)) {
            return null;
        }
 
        //msgtype	string	true	此消息类型为固定feedCard
        //title	string	true	单条信息文本
        //messageURL	string	true	点击单条信息到跳转链接
        //picURL	string	true	单条信息后面图片的URL
        OapiRobotSendRequest.Feedcard feedcard = new OapiRobotSendRequest.Feedcard();
        feedcard.setLinks(links);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype(DingTalkHelper.MSG_TYPE_FEED_CARD);
        request.setFeedCard(feedcard);
        OapiRobotSendResponse response = new OapiRobotSendResponse();
        try {
            response = DingTalkHelper.client.execute(request);
        } catch (ApiException e) {
            log.error("[发送ActionCard 类型消息]: 独立跳转ActionCard类型发送消息失败, 异常捕获{}", e.getMessage());
        }
        return response;
    }
 
}
 