package com.racic.lib.business.service.contract;

import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import java.util.List;

public interface BorrowingService {

    boolean verifyBoksListAvailableSize(Integer worksid);

    boolean borrowBook(Integer worksId, Member member);

    boolean returnBorrowing(Integer borrowingid, Member member);

    List<Borrowing> getNotReturnedBorrowing(String status);

    boolean extendBorrowing (Integer borrowingId, Member member);

    List<Borrowing> findByMember(Member member);

    Borrowing findByBorrowingId(Integer borrowingid);

}
