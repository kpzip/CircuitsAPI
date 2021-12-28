package com.kpzip.circuitsapi.circuitsimulator;

public interface Editable {
    EditInfo getEditInfo(int n);
    public void setEditValue(int n, EditInfo ei);
}
