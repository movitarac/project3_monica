package com.racic.lib.business.service.contract;

import com.racic.lib.model.Works;

import java.util.List;

public interface WorksService {

   // List<Works> getAllByLibraryId(int libraryid);
    List<Works> getAll();
    Works findWorksById(String worksid);
    Works findWorksByAuthor(String author);
    Works findWorksByTitle(String title);
    String addWorks(Works works);
    String deleteWorks(Works works);
    String updateWorks(Works works);

}
