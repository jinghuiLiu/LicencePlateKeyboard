package cn.qingsong.car.vehiclenuminputlibrary;

/**
 * @author 陈哈哈 (yoojiachen@gmail.com)
 * 用于显示车牌键盘的提示信息的接口。
 */
public interface MessageHandler {

    /**
     * 显示出错提示时回调此方法
     *
     * @param message 消息
     */
    void onMessageError(int message);

    /**
     * 显示提示消息时回调此方法
     *
     * @param message 消息
     */
    void onMessageTip(int message);
}