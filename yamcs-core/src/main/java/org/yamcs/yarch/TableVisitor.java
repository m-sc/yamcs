package org.yamcs.yarch;

public interface TableVisitor {
    public enum ActionType {
        NONE, DELETE, UPDATE
    };

    class Action {
        final boolean stop;
        byte[] updateData;

        ActionType type;

        private Action(ActionType type, boolean stop) {
            this.type = type;
            this.stop = stop;
        }

        public static Action updateAction(byte[] updateValue, boolean stop) {
            Action a = new Action(ActionType.UPDATE, stop);
            a.updateData = updateValue;
            return a;
        }

        public boolean stop() {
            return stop;
        }

        public ActionType action() {
            return type;
        }

        public byte[] getUpdateValue() {
            return updateData;
        }
    }

    public static final Action ACTION_STOP = new Action(ActionType.NONE, true);
    public static final Action ACTION_CONTINUE = new Action(ActionType.NONE, false);
    public static final Action ACTION_DELETE = new Action(ActionType.DELETE, false);
    public static final Action ACTION_DELETE_STOP = new Action(ActionType.DELETE, true);
    public static final Action ACTION_UPDATE = new Action(ActionType.UPDATE, false);
    public static final Action ACTION_UPDATE_STOP = new Action(ActionType.UPDATE, false);

    Action visit(byte[] key, byte[] value);
}
