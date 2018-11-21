package com.racic.lib.business.service.contract;

import com.racic.lib.model.Library;
import com.racic.lib.model.Member;
import com.racic.lib.model.Works;

import java.util.List;

public interface LibraryService {


    Library find(String libraryName);

    Library getLibraryById(int id);

}
