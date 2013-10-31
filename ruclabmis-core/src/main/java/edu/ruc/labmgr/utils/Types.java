package edu.ruc.labmgr.utils;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
public interface Types {
    /**
     * 设备状态枚举类
     */
    enum EquipStat {

        USED(11), UNUSED(12), SCRAPED(13), INMAINTAIN(14), BROKEDOWN(15), TOAPPROVEINSTORE(16);
        private int value;

        private EquipStat(int v) {
            this.value = v;
        }

        public int getValue() {
            return value;
        }
    }

}
