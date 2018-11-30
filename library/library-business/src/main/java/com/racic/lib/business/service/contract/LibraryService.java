package com.racic.lib.business.service.contract;

import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Library;
import com.racic.lib.model.Member;
import com.racic.lib.model.Works;

import java.util.List;

public interface LibraryService {

	Library getByWorkList(Works works);

	Library getLibraryByName(String libraryName);

	Library getLibraryById(Integer id);
	
	Library getLibraryByCity(String city);

	List<Works> findByLibraryId(Integer libraryid);
}
