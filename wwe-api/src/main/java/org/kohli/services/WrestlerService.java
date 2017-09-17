package org.kohli.services;

import java.util.List;

import org.kohli.object.Wrestler;
public interface WrestlerService {

    Wrestler getByID(String id);
    List<Wrestler> getAll();
}
