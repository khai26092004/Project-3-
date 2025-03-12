package org.hvk.hvk.model;

public enum DangKyHocTrangThai {
    DANG_HOC("Đang học"),
    HOAN_THANH("Hoàn thành"),
    HUY("Hủy");

    private final String displayName;

    DangKyHocTrangThai(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
