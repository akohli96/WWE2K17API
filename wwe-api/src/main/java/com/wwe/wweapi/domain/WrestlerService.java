package com.wwe.wweapi.domain;

import com.wwe.wweapi.domain.model.Wrestler;

import java.util.List;

public interface WrestlerService {

    Wrestler getByID(String id);
    List<Wrestler> getAll();
}
