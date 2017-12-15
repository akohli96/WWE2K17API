package com.wwe.wweapi.services;

import com.wwe.wweapi.object.Wrestler;

import java.util.List;

public interface WrestlerService {

    Wrestler getByID(String id);
    List<Wrestler> getAll();
}
