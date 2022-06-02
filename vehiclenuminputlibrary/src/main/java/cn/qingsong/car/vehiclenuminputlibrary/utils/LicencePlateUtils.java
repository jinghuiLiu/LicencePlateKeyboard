package cn.qingsong.car.vehiclenuminputlibrary.utils;

/**
 * author:jinghuiLiu
 * createTime:2022/5/28 10:51 上午
 * description: 车牌号正则校验
 */
public class LicencePlateUtils {
    /**
     * 车牌验证
     *
     * @param plate
     * @return
     */
    public static boolean isPlate(String plate) {
        boolean flag = isCommonPlate(plate) || isNewEnergyVehiclePlate(plate) || isCivilSpecialPlate(plate) || isWJPlate(plate) || isMilitaryVehiclePlate(plate);
        return flag;
    }

    /**
     * <pre>
     * 普通车牌（蓝牌、黄牌）
     * 车牌号码长度：7 位
     * 车牌号码格式：
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位
     * 省份简称    发证机关代码 号码 号码 号码 号码 号码
     * 省份简称：
     * 京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新
     * 发证机关代码：
     * ABCDEFGHxJKLMNxPQRSTUVWXYx
     * 说明：无 I, O , Z 三个字母。其中O和Z属于特殊车牌类型，见其它类型说明。
     * 车牌号码：
     * 数字：0123456789
     * 字母：ABCDEFGHxJKLNMxPQRSTUVWXY
     *
     * 说明：无 I, O 字母；
     * </pre>
     * 普通车牌
     *
     * @param plate
     * @return
     */
    public static boolean isCommonPlate(String plate) {
        String commonPlatePattern = "^([京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][ABCDEFGHJKLMNPQRSTUVWXY][\\dABCDEFGHJKLNMPQRSTUVWXYZ]{5})$";
        return plate.matches(commonPlatePattern);
    }

    /**
     * 新能源车牌
     * <pre>
     * 车牌号码长度：8 位
     * 车牌号码格式：
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位    第8位
     * 省份  发证机关   号码 号码 号码 号码 号码 号码
     * 新能源车牌现阶段号码长度为8位，按照现行新能源车牌号码规则：
     * 第3位：1-9DF
     * 第4位：1-9A-Z，无I、O字母；
     * 第5-7位：0-9
     * 第8位：1-9DF
     * 严格校验新能源车牌号码的约束规则：
     * 当第3位为D/F时，第4位可字母和数字，第5-8位必须纯数字；
     * 当第8位为D/F时，第3-7位必须纯数字；
     * </pre>
     *
     * @param plate
     * @return
     */
    public static boolean isNewEnergyVehiclePlate(String plate) {
        String nevPattern = "^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[a-zA-Z](([DF]((?![IO])[a-zA-Z0-9](?![IO]))[0-9]{4})|([0-9]{5}[DF]))|[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1})$";
        return plate.matches(nevPattern);
    }

    /**
     * 民用特殊Civil special车牌
     * <pre>
     *  港澳车牌
     * 车牌号码长度：7 位
     * 车牌号码格式：
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位
     * 粤   Z  号码 号码 号码 号码 [港澳]
     * 第1、2位分别是“粤Z”，第7位为“港澳”。
     *
     *
     * 教练车 - 学
     * 教练车号牌的第7位固定为“学”字，其它号码与普通民用车牌一致；
     *
     * 拖挂车 - 挂
     * 拖挂车的车厢，其号牌的第7位固定为“挂”字，其它号码与普通民用车牌一致；
     *
     * 其它可能出现的字符：领试超练
     * 其号牌的第7位固定为“领试超练”某个字，其它号码与普通民用车牌一致；
     *
     * 民航内部车牌
     * 车牌号码长度：7 位
     *
     * 车牌号码格式：
     *
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位
     * 民   航  号码 号码 号码 号码 号码
     * 使馆车牌
     * 车牌号码长度：7 位
     *
     * 新式使馆车牌号码格式：
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位
     * [1-3]   数字 数字 号码 号码 号码 使
     * 旧式使馆车牌号码格式：
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位
     * 使   [1-3]  数字 数字 号码 号码 号码
     *  </pre>
     *
     * @param plate
     * @return
     */
    public static boolean isCivilSpecialPlate(String plate) {
        String csPattern = "^([粤][Z][0-9ABCDEFGHJKLMNPQRSTUVWXYZ]\\d{4}[港澳]|[京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][ABCDEFGHJKLMNPQRSTUVWXY][\\dABCDEFGHJKLNMxPQRSTUVWXYZ]{4}[学挂领试超练]|[民][航][\\dABCDEFGHJKLNMxPQRSTUVWXYZ]{5}|[1-3]\\d{2}[\\dABCDEFGHJKLNMxPQRSTUVWXYZ]{3}[使]|[使][1-3]\\d{2}[\\dABCDEFGHJKLNMxPQRSTUVWXYZ]{3})$";
        return plate.matches(csPattern);
    }

    /**
     * 武警车牌 2012式车牌规则
     * <pre>
     * 警队车牌规则
     * 警队车牌包括四种车牌：
     *
     * 地方武警车牌；
     * 武警总队车牌；
     * 普通警察车牌；
     * O字警察车牌；
     *
     * 地方武警车牌
     * 车牌号码长度：8 位
     * 车牌号码格式：
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位    第8位
     * W   J  省份简称   号码 号码 号码 号码 号码
     * 其中号码字段，保持与普通车牌号码一致。
     * 例如：
     * - WJ京12345 - WJ粤12345
     *
     *
     * 武警总队车牌
     * 车牌号码长度：7 位
     * 车牌号码格式：
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位
     * W   J  号码 号码 号码 号码 号码
     * 其中号码字段，保持与普通车牌号码一致。
     * 例如：
     * - WJ1234J - WJ95001
     *
     *
     * 普通警察车牌
     * 车牌号码长度：7 位
     * 车牌号码格式：
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位
     * 省份  发证机关   号码 号码 号码 号码 警
     * 其中第7位固定为“警”字，其它位置与普通车牌号码一致；
     *
     *
     * O字车牌
     * 车牌号码长度：7 位
     * 车牌号码格式：
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位
     * 省份  O  号码 号码 号码 号码 号码
     * 其中第1位固定为字母“O”，其它位置与普通车牌号码一致。
     * </pre>
     *
     * @param plate
     * @return
     */
    public static boolean isWJPlate(String plate) {
        String wjPattern = "^(WJ[京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][1-9]{4}|WJ[京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][1-9]{5}|WJ[1-9]{5}|[京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][ABCDEFGHJKLMNPQRSTUVWXY][\\dABCDEFGHJKLNMxPQRSTUVWXYZ]{4}[警]|[京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][O][\\dABCDEFGHJKLNMxPQRSTUVWXYZ]{5})$";
        return plate.matches(wjPattern);
    }

    /**
     * 军用车牌2012式
     * <pre>
     * 车牌号码长度：7 位
     *
     * 车牌号码格式：
     *
     * 第1位 第2位    第3位    第4位    第5位    第6位    第7位
     * 军区军种代码  单位代码   号码 号码 号码 号码 号码
     * 军区代码：
     *
     * QVKHBSLJNGCEZ
     *
     * 代表各大军区、总部、军种：
     *
     * Q 战区首字母（新式）
     * VKHBSLJNGCEZ 旧式军区车牌前缀。后期根据军队车牌情况可能只保存“Q”字母。
     * 单位代码：
     *
     * 与普通民用车牌发证机关代码的字母一致
     * </pre>
     *
     * @param plate
     * @return
     */
    public static boolean isMilitaryVehiclePlate(String plate) {
        //V字头序列(军委、四总部、军直单位)
        //K字头序列(空军)
        //H字头序列(海军)
        //B字头序列(北京军区)
        //N字头序列(南京军区)
        //G字头序列(广州军区)
        //S字头序列(沈阳军区)
        //C字头序列(成都军区)
        //L字头序列(兰州军区)
        //J字头序列(济南军区)
        String mvPattern = "^(V[ABCDEFGRTVKMO][·]{0,1}[0-9]{5}|K[ABCDOREFKUHGJM][·]{0,1}[0-9]{5}|H[ABCDEFGLOR][·]{0,1}[0-9]{5}|B[ABCDKMNORVY][·]{0,1}[0-9]{5}|N[ABCDKMNORVY][·]{0,1}[0-9]{5}|G[ABCDKJMNORVY][·]{0,1}[0-9]{5}|S[ABCDKMNORVY][·]{0,1}[0-9]{5}|C[ABCDKMNORVY][·]{0,1}[0-9]{5}|L[ABCDKMNORVY][·]{0,1}[0-9]{5}|J[ABCDKMNORVY][·]{0,1}[0-9]{5})$";
        return plate.matches(mvPattern);
    }
}
