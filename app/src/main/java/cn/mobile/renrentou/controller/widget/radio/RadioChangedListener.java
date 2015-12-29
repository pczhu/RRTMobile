package cn.mobile.renrentou.controller.widget.radio;

/**
 * 名称：RadioChangedListener
 * 作用：CustomLinearlayout与外部响应的回调
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/29 上午11:28
 * 版本：V1.0
 * 修改历史：
 */
public interface RadioChangedListener {
    /**
     * 有控件状态改变了
     * @param count
     * @param flag
     */
    public void getSelectedStatue(int count,boolean flag);
}
