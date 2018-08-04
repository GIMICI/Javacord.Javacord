package org.javacord.api.entity.permission;

/**
 * This enum contains all types of permissions.
 */
public enum PermissionType {

    // general
    CREATE_INSTANT_INVITE(0x00000001),
    KICK_MEMBERS(0x00000002),
    BAN_MEMBERS(0x00000004),
    ADMINISTRATOR(0x00000008),
    MANAGE_CHANNELS(0x00000010),
    MANAGE_SERVER(0x00000020),
    ADD_REACTIONS(0x00000040),
    VIEW_AUDIT_LOG(0x00000080),

    // chat
    READ_MESSAGES(0x00000400),
    SEND_MESSAGES(0x00000800),
    SEND_TTS_MESSAGES(0x00001000),
    MANAGE_MESSAGES(0x00002000),
    EMBED_LINKS(0x00004000),
    ATTACH_FILE(0x00008000),
    READ_MESSAGE_HISTORY(0x00010000),
    MENTION_EVERYONE(0x00020000),
    USE_EXTERNAL_EMOJIS(0x00040000),

    // voice
    VOICE_CONNECT(0x00100000),
    VOICE_SPEAK(0x00200000),
    VOICE_MUTE_MEMBERS(0x00400000),
    VOICE_DEAFEN_MEMBERS(0x00800000),
    VOICE_MOVE_MEMBERS(0x01000000),
    VOICE_USE_VAD(0x02000000),
    PRIORITY_SPEAKER(0x00000100),

    // misc
    CHANGE_NICKNAME(0x04000000),
    MANAGE_NICKNAMES(0x08000000),
    MANAGE_ROLES(0x10000000),
    MANAGE_WEBHOOKS(0x20000000),
    MANAGE_EMOJIS(0x40000000);

    /**
     * The value of the permission. An integer where only one bit is set (e.g. <code>0b1000</code>).
     */
    private final int value;

    /**
     * Creates a new permission type.
     *
     * @param value The value of the permission type.
     */
    PermissionType(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the permission type.
     *
     * @return The value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Checks if the permission is "included" in the given integer.
     *
     * @param i The integer to check.
     * @return Whether the permission is "included" or not.
     */
    public boolean isSet(int i) {
        return (i & getValue()) != 0;
    }

    /**
     * Sets or unsets the type for the given integer.
     *
     * @param i The integer to change.
     * @param set Whether the type should be set or not.
     * @return The changed integer.
     */
    public int set(int i, boolean set) {
        if (set && !isSet(i)) {
            return i + getValue();
        }
        if (!set && isSet(i)) {
            return i - getValue();
        }
        return i;
    }

}
