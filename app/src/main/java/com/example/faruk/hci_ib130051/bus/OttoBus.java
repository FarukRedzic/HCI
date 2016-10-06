package com.example.faruk.hci_ib130051.bus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class OttoBus {
    private static final Bus BUS = new Bus(ThreadEnforcer.ANY);

    public static Bus getInstance() {
        return BUS;
    }

    private OttoBus() {
    }
}
