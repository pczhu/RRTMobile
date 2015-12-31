package cn.mobile.renrentou.controller.widget.textview;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/31 上午10:02
 * 版本：V1.0
 * 修改历史：
 */
/**
 * 增长的数字接口
 *
 */
public interface IRiseNumber {
    /**
     * 开始播放动画的方法
     */
    public void start();

    /**
     * 设置字符串类型
     * @param f
     */
    public void withNumber(String f);
    /**
     * 设置小数
     *
     * @param number
     * @return
     */
    public void withNumber(float number);

    /**
     * 设置整数
     *
     * @param number
     * @return
     */
    public void withNumber(int number);

    /**
     * 设置动画播放时长
     *
     * @param duration
     * @return
     */
    public void setDuration(long duration);

    /**
     * 设置动画结束监听器
     *
     * @param callback
     */
    public void setOnEndListener(RiseNumberTextView.EndListener callback);
}
