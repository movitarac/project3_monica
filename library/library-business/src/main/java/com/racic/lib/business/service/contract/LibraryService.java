package com.racic.lib.business.service.contract;

import com.racic.lib.model.Library;
import com.racic.lib.model.Work;

import java.util.List;

public interface LibraryService {

	//Library getByWorkList(Work work);

	Library getLibraryByName(String libraryName);

	Library getLibraryById(Integer id);

	Library getLibraryByCity(String city);

	//List<Work> findByLibraryId(Integer libraryid);

}
