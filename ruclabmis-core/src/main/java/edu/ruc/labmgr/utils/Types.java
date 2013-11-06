package edu.ruc.labmgr.utils;

public interface Types {
    enum Role {
        ADMIN("administrators"), LEADER("leader"),
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
        NORMAL(10), USED(11), TOUSE(12), OFF(13), INMAINTAIN(14), BROKEDOWN(15), DONATED(16);
        private int value;

        private EquipState(int v) {
            this.value = v;
        }

        public int getValue() {
            return value;
        }
    }

    enum ApplyState {
        PASS(31), WAITING(32), REJECT(33), CLOSE(34);
        private int value;

        private ApplyState(int v) {
            this.value = v;
        }

        public int getValue() {
            return value;
        }
    }

    enum ApplyType {
        BORROW(21, "borrow"), ALLOT(22, "allot"), DONATE(23, "donate"), REPAIR(24, "repair"), DEFICIT(25, "deficit");
        private int id;
        private String name;

        private ApplyType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getValue() {
            return id;
        }

        public String getName() {
            return name;
        }


        public static ApplyType getApplyTypeFromStr(String name){
            if( ApplyType.BORROW.getName().equals(name))
                return ApplyType.BORROW;

            if( ApplyType.ALLOT.getName().equals(name))
                return ApplyType.ALLOT;

            if( ApplyType.DONATE.getName().equals(name))
                return ApplyType.DONATE;

            if( ApplyType.REPAIR.getName().equals(name))
                return ApplyType.REPAIR;

            if( ApplyType.DEFICIT.getName().equals(name))
                return ApplyType.DEFICIT;
            return null;
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
