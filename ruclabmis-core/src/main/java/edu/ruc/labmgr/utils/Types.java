package edu.ruc.labmgr.utils;

public interface Types {
    enum Role {
        ADMIN(1, "administrators"), LEADER(3, "leader"),
        EQUIPMENT_ADMIN(4, "equipment_admin"), TEACHER(2, "teacher"), STUDENT(5, "student");
        private int id;
        private String name;

        private Role(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getValue() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
    /**
     * 设备状态枚举类
     */
    enum EquipState {
        //可用   待分配 已分配 待归还 待转移  待捐赠  已捐赠
        NORMAL(101), TOUSE(102), USED(103), TOREURN(104), TOALLOT(105),  TODONATE(106), DONATED(107),
        //待维修  维修中  已损坏  待报减   已销账
        TOREPAIR(108), REPAIRING(109), BROKEN(110), TODEFICIT(111), DEFICITED(112);

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
        BORROW(21, "borrow", "借用"), ALLOT(22, "allot", "转移"), DONATE(23, "donate", "捐赠"),
        REPAIR(24, "repair", "维修"), DEFICIT(25, "deficit", "报减销账"),
        RETURN(28, "return", "归还"), INFO(29, "info", "设备信息");
        private int id;
        private String name;
        private String title;

        private ApplyType(int id, String name, String title) {
            this.id = id;
            this.name = name;
            this.title = title;
        }

        public int getValue() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getTitle() {
            return title;
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

            if( ApplyType.RETURN.getName().equals(name))
                return ApplyType.RETURN;

            if( ApplyType.INFO.getName().equals(name))
                return ApplyType.INFO;

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
