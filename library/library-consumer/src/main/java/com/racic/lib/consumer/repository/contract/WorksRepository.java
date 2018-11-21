package com.racic.lib.consumer.repository.contract;

import com.racic.lib.model.Book;
import com.racic.lib.model.Works;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WorksRepository {
    public Works getWorksByTitle(String workTitle);

    public List<Book> getBooksList();
}
