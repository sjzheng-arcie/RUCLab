package edu.ruc.labmgr.utils;

public interface Types {
    enum Role {
        ADMIN("administrator"), LEADER("leader"),
        EQUIPMENT_ADMIN("equipment_admin"), TEACHER("teacher");
        private String value;

        private Role(String v) {
            this.value = v;
        }

        public String getValue() {
            return value;
        }
    }
    /**
     * 设备状态枚举类
     */
    enum EquipState {
        NORMAL(10), USED(11), TOUSE(12), SCRAPED(13), INMAINTAIN(14), BROKEDOWN(15), TOAPPROVEINSTORE(16);
        private int value;

        private EquipState(int v) {
            this.value = v;
        }

        public int getValue() {
            return value;
        }
    }

    enum ApplyState {
        PASS(31), WAITING(32), REJECT(33);
        private int value;

        private ApplyState(int v) {
            this.value = v;
        }

        public int getValue() {
            return value;
        }
    }

    enum ApplyType {
        ADD(21), REMOVE(22), BORROW(23), RETURN(24);
        private int value;

        private ApplyType(int v) {
            this.value = v;
        }

        public int getValue() {
            return value;
        }
    }

    enum ClassifType {
        BASE(0), EQUIPMENT_STATE(1), APPLY_TYPE(2), APPLY_STATE(3),
        FUNDING_SUBJECT(4), USE_DIRECTION(5);
        private int value;

        private ClassifType(int v) {
            this.value = v;
        }

        public int getValue() {
            return value;
        }
    }

}
